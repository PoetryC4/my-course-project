import torch
import torch.nn as nn
import mplfinance as mpf
import numpy as np
import matplotlib.pyplot as plt
from torch.utils.data import Dataset
import tushare as ts
import torch.utils.data as Data
import pandas as pd
import torch.nn.functional as F
import wandb


# 取前history天的数据为X, 后面future天数据为Y作为标签
def data_split(dataset, history, future):
    dataset = dataset[["open", "close", "high", "low"]]
    X = []
    Y = []
    for i in range(dataset.shape[0] - history - future):
        X.append(np.array(dataset.iloc[i:(i + history), :], dtype=np.float32))  # 每次取history天的数据为一个序列
        Y.append(
            np.array(dataset.iloc[i + history:i + history + future], dtype=np.float32))  # 每次取一个序列后紧接着的future天为标签

    X = torch.tensor(np.array(X))
    Y = torch.tensor(np.array(Y))
    return X, Y


class LSTM(nn.Module):
    # input_size:  输入层样本特征向量的长度
    # hidden_size：隐藏层输出特征向量的长度
    # num_layers：隐藏层的层数
    # output_size：整个网络的输出特征的长度
    # last_days:根据过去多少天
    # pred_days:预测未来多少天
    def __init__(self, input_size=5, hidden_size=5, num_layers=2, batch_first=True,
                 seq_length=100, pred_days=7):
        super(LSTM, self).__init__()
        # lstm的输入 #batch,seq_len, input_size
        self.input_size = input_size
        self.hidden_size = hidden_size
        self.output_size = hidden_size * pred_days  # 输出维度为5个特征*预测天数
        self.num_layers = num_layers
        self.seq_length = seq_length
        self.batch_first = batch_first

        self.lstm = nn.LSTM(input_size=self.input_size, hidden_size=self.hidden_size, num_layers=num_layers,
                            batch_first=batch_first)

        # 定义网络的输出层：
        # hidden_size：输出层的输入，隐藏层的特征输出
        # output_size：输出层的输出
        self.linear = nn.Linear(in_features=self.hidden_size * self.seq_length, out_features=self.output_size)

    # 定义前向运算，把各层串联起来
    def forward(self, x):
        # 输入层数据格式：x.shape = [batch_size, seq_len, input_size]
        output, _ = self.lstm(x)  # output size : batch_size, seq_length, hidden_size
        out = self.linear(output.reshape(-1, self.hidden_size * self.seq_length))
        return out  # out shape: batch_size,hidden_size*seq_length


if __name__ == '__main__':
    device = torch.device("cuda:0" if torch.cuda.is_available() else "cpu")
    pro = ts.pro_api('099d503dd05ac189ba998bf3404df708bdb38d73171b9b32ec70db26')

    df = pro.daily(ts_code='601669.SH', start_date='20170101', end_date='20230411')
    df = df.iloc[::-1]  # 由于获取的数据是倒序的，需要将其调整为正序
    df.index = pd.to_datetime(df.trade_date)  # 索引转为日期

    # 通过过去100天预测未来7天
    history = 100
    pred_days = 7
    dataX, dataY = data_split(df, history, pred_days)  # dataX:1331, 100, 5; dataY: 1331, 100, 5
    dataset = Data.TensorDataset(dataX, dataY)  # (dataX, dataY)
    train_size = int(0.8 * len(dataset))
    test_size = len(dataset) - train_size
    training_set, test_set = torch.utils.data.random_split(dataset, [train_size, test_size])  # 以8:2比例划分训练集和测试集

    # 分离训练集和测试集
    train_loader = Data.DataLoader(
        dataset=training_set,
        batch_size=64,
        shuffle=False
    )
    test_loader = Data.DataLoader(
        dataset=test_set,
        batch_size=64,
        shuffle=False
    )

    hidden_size = 4  # 隐藏层大小=特征维度
    input_size = 4
    output_size = 4
    num_layers = 2
    model = LSTM(input_size=input_size, hidden_size=hidden_size, num_layers=num_layers, seq_length=history,
                 pred_days=pred_days)
    optimizer = torch.optim.Adam(model.parameters(), lr=0.001)
    train_loss = []  # 记录每一轮训练loss
    test_loss = []  # 记录每一轮测试loss
    epochs = 100
    for epoch in range(epochs):
        cur_train_loss = []  # 记录当前轮每batch_size个样本训练损失
        model.to(device)
        model.train()
        for step, (x, y) in enumerate(train_loader):
            # x: batch_size, history, input_size,
            # y: batch_size, pred_days, hidden_size
            x, y = x.to(device), y.to(device)
            out = model(x)  # 模型输入
            Loss = F.mse_loss(out, y.view(-1, pred_days * hidden_size))  # loss计算，将y从(64,7,4)变形为(64,28)
            optimizer.zero_grad()  # 当前batch的梯度不会再用到，所以清除梯度
            Loss.backward()  # 反向传播计算梯度
            optimizer.step()  # 更新参数
            cur_train_loss.append(Loss.item())

        train_loss.append(sum(cur_train_loss) / len(cur_train_loss))

        cur_test_loss = []  # 记录当前轮每batch_size个样本预测损失
        model.eval()
        for step, (x, y) in enumerate(test_loader):
            x, y = x.to(device), y.to(device)
            out = model(x)
            Loss = F.mse_loss(out, y.view(-1, pred_days * hidden_size))  # 将batch_y从(64,7,4)变形为(64,28)
            cur_test_loss.append(Loss.item())

        test_loss.append(sum(cur_test_loss) / len(cur_test_loss))

        print(">>> EPOCH{} averTrainLoss:{:.3f} averTestLoss:{:.3f}".format(epoch + 1, train_loss[-1], test_loss[-1]))

    plt.plot(list(range(epochs)), train_loss, label='Train')
    plt.plot(list(range(epochs)), test_loss, label='Test')
    plt.legend()
    plt.xlabel('epoch')
    plt.ylabel('loss')
    plt.show()

    # inference
    model.cpu()
    X = torch.tensor(df[['open', 'close', 'high', 'low']][-history:].to_numpy())  # shape: 100, 4
    Y = model(X.view(1, history, input_size).float()).reshape(pred_days, output_size)  # shape:7, 4

    result = pd.DataFrame(torch.vstack((X, Y)).detach().numpy())  # 将预测的7天未来数据(除去节假日)接在前面100天之后
    result.index = list(df.index[-history:]) + [pd.Timestamp('2023-04-10 00:00:00'),
                                                pd.Timestamp('2023-04-11 00:00:00'),
                                                pd.Timestamp('2023-04-12 00:00:00'),
                                                pd.Timestamp('2023-04-13 00:00:00'),
                                                pd.Timestamp('2023-04-14 00:00:00')]# pd.Timestamp('2023-04-17 00:00:00'),pd.Timestamp('2023-04-18 00:00:00')])
    result.index.name = 'date'
    result.columns = ['open', 'close', 'high', 'low']
    mpf.plot(result[-50:], type='candle')
