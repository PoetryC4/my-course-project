from torch import nn
import torch
import wandb

class PositionalEncoding(nn.Module):
    """Positional encoding.

    Defined in :numref:`sec_self-attention-and-positional-encoding`"""

    def __init__(self, num_hiddens, dropout, max_len=1000):
        super(PositionalEncoding, self).__init__()
        self.dropout = nn.Dropout(dropout)
        # Create a long enough `P`
        self.P = torch.zeros((1, max_len, num_hiddens))
        X = torch.arange(max_len, dtype=torch.float32).reshape(
            -1, 1) / torch.pow(10000, torch.arange(
            0, num_hiddens, 2, dtype=torch.float32) / num_hiddens)
        self.P[:, :, 0::2] = torch.sin(X)
        self.P[:, :, 1::2] = torch.cos(X)

    def forward(self, X):
        X = X + self.P[:, :X.shape[1], :].to(X.device)
        return self.dropout(X)


class PostionWiseFFN(nn.Module):
    def __init__(self, ffn_input, ffn_hidden, ffn_output, **kwargs):
        super().__init__(**kwargs)
        self.linear1 = nn.Linear(ffn_input, ffn_hidden)
        self.relu = nn.ReLU()
        self.linear2 = nn.Linear(ffn_hidden, ffn_output)

    def forward(self, X):
        X = self.relu(self.linear1(X))
        return self.linear2(X)


class AddNorm(nn.Module):
    def __init__(self, normalize_shape, dropout, **kwargs):
        super().__init__(**kwargs)
        self.ln = nn.LayerNorm(normalize_shape)  # shape of a batch
        self.dropout = nn.Dropout(dropout)

    def forward(self, X, Y):
        """ X and Y should have the same shape"""
        return self.ln(X + self.dropout(Y))


class EncoderBlock(nn.Module):
    def __init__(self, hidden_size, num_heads,
                 normal_shape, ffn_input, ffn_hiddens,
                 dropout, bias=False, **kwargs):
        super(EncoderBlock, self).__init__(**kwargs)
        self.attention = nn.MultiheadAttention(hidden_size, num_heads, dropout, bias)
        self.addnorm1 = AddNorm(normal_shape, dropout)
        self.ffn = PostionWiseFFN(ffn_input, ffn_hiddens, hidden_size)
        self.addnorm2 = AddNorm(normal_shape, dropout)

    def forward(self, X, valid_lens):
        Y = self.addnorm1(X, self.attention(X, X, X, valid_lens)[0])
        return self.addnorm2(Y, self.ffn(Y))


class TransformerEncoder(nn.Module):
    def __init__(self, hidden_size, num_heads, ffn_hiddens, num_layers, dropout, **kwargs):
        super().__init__(**kwargs)
        self.hidden_size = hidden_size
        self.postion_embed = PositionalEncoding(hidden_size, dropout)
        self.blks = nn.Sequential()
        for i in range(num_layers):
            self.blks.add_module('blk' + str(i), nn.TransformerEncoderLayer(hidden_size, num_heads,
                                                                            ffn_hiddens, dropout, batch_first=True))

    def forward(self, X, valid_lens=None):
        X = self.postion_embed(X).float()
        self.attention_weights = [None] * len(self.blks)
        for i, blk in enumerate(self.blks):
            X = blk(X, valid_lens)
        return X

class Transformerdecoder(nn.Module):
    def __init__(self, hidden_size, num_heads, ffn_hiddens, num_layers, dropout, batch_first=True):
        super().__init__()
        self.hidden_size = hidden_size
        self.postion_embed = PositionalEncoding(hidden_size, dropout)
        self.blks = nn.Sequential()
        for i in range(num_layers):
            self.blks.add_module('blk' + str(i), nn.TransformerDecoderLayer(hidden_size, num_heads, ffn_hiddens, dropout=dropout, batch_first=True))

    def forward(self, dec_input, enc_input):
        X = self.postion_embed(dec_input).float()
        for i, blk in enumerate(self.blks):
            X = blk(X, enc_input)
        return X

class MLP(nn.Module):
    def __init__(self, input_size, hidden_size, output_size):
        super().__init__()
        self.l1 = nn.Linear(input_size, hidden_size)
        self.relu = nn.ReLU()
        self.l2 = nn.Linear(hidden_size, output_size)

    def forward(self, X):
        return self.l2(self.relu(self.l1(X)))


class Transformer(nn.Module):
    def __init__(self, input_size, hidden_size, num_heads, ffn_hiddens, num_layers,
                 dropout, mlp_hidden_size, pred_days, **kwargs):
        super().__init__(**kwargs)
        self.trans_enc = TransformerEncoder(hidden_size, num_heads, ffn_hiddens, num_layers, dropout)
        self.decoder = Transformerdecoder(hidden_size, num_heads, ffn_hiddens, num_layers, dropout, batch_first=True)
        self.proj = MLP(hidden_size, mlp_hidden_size, input_size)
        self.pred_days = pred_days

    def forward(self, x):
        """
        :param x: B,E_L,D_I
        :param y: B,D_L,D_I
        :return:
        """
        enc_input = dec_input = x  # E_L,B,D
        enc_output = self.trans_enc(enc_input)
        dec_output = self.decoder(dec_input, enc_output[:, -1].unsqueeze(1))
        output = self.proj(dec_output)      # batch, seq_len, input_size
        return output[:, -self.pred_days:, :]


class CNN_TRANSFORMER(nn.Module):
    def __init__(self, input_size, hidden_size, num_heads, ffn_hiddens, num_layers,
                 dropout, mlp_hidden_size, kernel_size, pred_days, **kwargs):
        super().__init__(**kwargs)
        self.l1 = nn.Linear(input_size, hidden_size)
        # self.l2 = nn.Linear(input_size, hidden_size)
        self.conv = nn.Conv1d(in_channels=hidden_size, out_channels=hidden_size, kernel_size=kernel_size)
        self.transformer = Transformer(input_size, hidden_size, num_heads, ffn_hiddens, num_layers, dropout,
                                       mlp_hidden_size, pred_days)
        self.pred_days = pred_days

    def forward(self, input):
        """

        :param input: 128,100,4
        :return:
        """

        x1 = self.l1(input).transpose(1, 2)  # 128,64,100
        x1 = self.conv(x1).transpose(1, 2)  # 128,100-3+1,64
        output = self.transformer(x1)
        return output