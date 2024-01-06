import torch
import torch.nn as nn
import datetime
import mplfinance as mpf
import numpy as np
import matplotlib.pyplot as plt
from torch.utils.data import Dataset
import tushare as ts
import torch.utils.data as Data
import pandas as pd
import torch.nn.functional as F
import holidays


# 取前history天的数据为X, 后面future天数据为Y作为标签
def data_split(dataset, history, pred_days):
    dataset = dataset[["open", "close", "high", "low"]]
    X = []
    Y = []
    for i in range(dataset.shape[0] - history - pred_days):
        X.append(np.array(dataset.iloc[i:(i + history), :], dtype=np.float32))  # 每次取history天的数据为一个序列
        Y.append(
            np.array(dataset.iloc[i + history:i + history + pred_days], dtype=np.float32))  # 每次取一个序列后紧接着的future天为标签

    X = torch.tensor(np.array(X))
    Y = torch.tensor(np.array(Y))
    return X, Y


def is_holiday(date):
    # 创建一个节假日对象，指定你想要的国家或地区
    # 这里以中国为例
    china_holidays = holidays.China()

    # 判断给定日期是否为节假日
    if date in china_holidays:
        return True
    else:
        return False


def is_weekend(date):
    # 将日期字符串转换为日期对象
    date_obj = datetime.datetime.strptime(date, "%Y-%m-%d")

    # 判断日期是周几（0代表周一，1代表周二，以此类推）
    weekday = date_obj.weekday()

    # 判断日期是周末（周六或周日）
    if weekday >= 5:
        return True
    else:
        return False


class MLP(nn.Module):
    def __init__(self, input_size, output_size, hidden_size=64):
        super().__init__()
        self.l1 = nn.Linear(input_size, hidden_size)
        self.l2 = nn.Linear(hidden_size, output_size)
        self.relu = nn.ReLU()

    def forward(self, X):
        return self.l2(self.relu(self.l1(X)))


class LSTM(nn.Module):
    # input_size:  输入层样本特征向量的长度
    # hidden_size：隐藏层输出特征向量的长度
    # num_layers：隐藏层的层数
    # output_size：整个网络的输出特征的长度
    # last_days:根据过去多少天
    # pred_days:预测未来多少天
    def __init__(self, input_size=4, hidden_size=16, num_layers=4, batch_first=True,
                 history=200, pred_days=7):
        super().__init__()

        # lstm的输入
        self.hidden_size = hidden_size
        self.input_length = history
        self.output_lenth = pred_days

        # mlp的输入
        self.mlp_input_size = hidden_size * self.input_length
        self.mlp_output_size = input_size * self.output_lenth  # 输出维度为4个特征*预测天数

        self.lstm = nn.LSTM(input_size=input_size, hidden_size=hidden_size, num_layers=num_layers,
                            batch_first=batch_first)

        # 定义网络的输出层：
        # hidden_size：输出层的输入，隐藏层的特征输出
        # output_size：输出层的输出
        self.linear = MLP(self.mlp_input_size, self.mlp_output_size)

    # 定义前向运算，把各层串联起来
    def forward(self, x):
        # 输入层数据格式：x.shape = [batch_size, seq_len, input_size]
        output, _ = self.lstm(x)  # output size : batch_size, seq_length, hidden_size
        out = self.linear(output.reshape(-1, self.hidden_size * self.input_length))  # out shape: batch_size, output_size
        return out


if __name__ == '__main__':
    device = torch.device("cuda:0" if torch.cuda.is_available() else "cpu")
    pro = ts.pro_api('77ec9d5512eb7ae419116f536f72ade9a7430905b7015ad1772150d6')

    train_len = 5000  # 通过过去5000天数据训练
    # 通过过去100天预测未来5天
    history = 100
    pred_days = 3

    # 获取训练结束时间为当天
    current_date = datetime.date.today()
    endDate = current_date.strftime("%Y%m%d")

    # 获取训练结束时间前train_len天的日期字符串
    previous_date = current_date - datetime.timedelta(days=train_len)
    startDate = previous_date.strftime("%Y%m%d")

    # 获取当天前200天的日期为开始预测日期
    # pred_date = current_date - datetime.timedelta(days=history)
    # predDate = pred_date.strftime("%Y%m%d")

    df = pro.daily(ts_code='000001.SZ', start_date=startDate, end_date=endDate)
    df = df.iloc[::-1]  # 由于获取的数据是倒序的，需要将其调整为正序
    df.index = pd.to_datetime(df.trade_date)  # 索引转为日期

    # 划分训练和测试集
    dataX, dataY = data_split(df, history, pred_days)  # 按200:7划分特征和目标
    dataset = Data.TensorDataset(dataX, dataY)  # (dataX, dataY)
    train_size = int(0.7 * len(dataset))
    test_size = len(dataset) - train_size
    generator1 = torch.Generator().manual_seed(42)
    training_set, test_set = torch.utils.data.random_split(dataset, [train_size, test_size],
                                                           generator=generator1)  # 以 7:3 比例划分训练集和验证集

    # 分离训练集和验证集
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

    hidden_size = 128  # 隐藏层大小=特征维度
    input_size = 4
    num_layers = 4
    model = LSTM(input_size=input_size, hidden_size=hidden_size, num_layers=num_layers, history=history,
                 pred_days=pred_days, batch_first=True)
    optimizer = torch.optim.Adam(model.parameters(), lr=0.001)
    train_loss = []  # 记录每一轮训练loss
    test_loss = []  # 记录每一轮测试loss
    epochs = 50
    for epoch in range(epochs):
        cur_train_loss = []  # 记录当前轮每batch_size个样本训练损失
        model.to(device)
        model.train()
        for step, (x, y) in enumerate(train_loader):
            # x: batch_size, history, input_size
            # y: batch_size, pred_days, input_size
            x, y = x.to(device), y.to(device)
            out = model(x)  # (batch_size, pred_days * input_size)
            Loss = F.mse_loss(out, y.view(-1, pred_days * input_size))  # loss计算，将y从(-1,7,4)变形为(-1,28)
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
            Loss = F.mse_loss(out, y.view(y.shape[0], -1))  # 将batch_y从(-1,7,4)变形为(-1,28)
            cur_test_loss.append(Loss.item())

        test_loss.append(sum(cur_test_loss) / len(cur_test_loss))

        print(">>> EPOCH{} averTrainLoss:{:.3f} averTestLoss:{:.3f}".format(epoch + 1, train_loss[-1], test_loss[-1]))

    plt.plot(list(range(epochs)), train_loss, label='Train')
    plt.plot(list(range(epochs)), test_loss, label='Test')
    plt.legend()
    plt.xlabel('epoch')
    plt.ylabel('loss')
    plt.show()

    model.cpu()
    X = torch.tensor(df[['open', 'close', 'high', 'low']][-history:].to_numpy())  # x shape: history, input_size
    Y = model(X.view(1, history, input_size).float()).reshape(pred_days, input_size)  # y shape:7, 4

    result = pd.DataFrame(torch.vstack((X, Y)).detach().numpy())  # 将预测的7天未来数据(除去节假日)接在前面200天之后
    pred_date_list = []
    current_date = datetime.datetime.now()
    i = 0
    for j in range(pred_days):
        while is_holiday((current_date - datetime.timedelta(days=-1 - i)).strftime('%Y-%m-%d')) or \
                is_weekend((current_date - datetime.timedelta(days=-1 - i)).strftime('%Y-%m-%d')):
            i += 1
        day = (current_date - datetime.timedelta(days=-1 - i)).strftime('%Y-%m-%d')
        day_str = day + ' 00:00:00'
        pred_date_list.append(pd.Timestamp(day))
        i += 1

    history_date_list = [x.strftime('%Y-%m-%d') for x in list(df.index[-history:])]
    result.index = list(df.index[-history:]) + pred_date_list
    result.index.name = 'date'
    result.columns = ['open', 'close', 'high', 'low']
    mpf.plot(result[-20:], type='candle')