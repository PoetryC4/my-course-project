import torch
import datetime
import mplfinance as mpf
import numpy as np
import matplotlib.pyplot as plt
import wandb
from torch.utils.data import Dataset
import tushare as ts
import torch.utils.data as Data
import pandas as pd
import torch.nn.functional as F
import holidays
from model import CNN_TRANSFORMER


# 取前history天的数据为X, 后面future天数据为Y作为标签
def data_split(dataset, history, pred_days):
    X = []
    Y = []
    for i in range(len(dataset) - history - pred_days):
        X.append(np.array(dataset[i:(i + history), :], dtype=np.float32))  # 每次取history天的数据为一个序列
        Y.append(
            np.array(dataset[i + history:i + history + pred_days], dtype=np.float32))  # 每次取一个序列后紧接着的future天为标签

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


class Mydataset(Dataset):
    def __init__(self, X, Y):
        super().__init__()
        self.X = X
        self.Y = Y

    def __len__(self):
        return len(self.X)

    def __getitem__(self, idx):
        return self.X[idx], self.Y[idx]


if __name__ == '__main__':
    device = torch.device("cuda:0" if torch.cuda.is_available() else "cpu")

    pro = ts.pro_api('77ec9d5512eb7ae419116f536f72ade9a7430905b7015ad1772150d6')

    train_len = 6000  # 通过过去6000天数据训练
    pred_days = 7  # 预测未来7天
    seed = torch.Generator().manual_seed(42)
    # 获取训练结束时间为当天
    current_date = datetime.date.today()
    endDate = current_date.strftime("%Y%m%d")

    # 获取训练结束时间前train_len天的日期字符串
    previous_date = current_date - datetime.timedelta(days=train_len)
    startDate = previous_date.strftime("%Y%m%d")

    df = pro.daily(ts_code='000005.SZ', start_date=startDate, end_date=endDate)
    df = df.iloc[::-1]  # 由于获取的数据是倒序的，需要将其调整为正序
    df.index = pd.to_datetime(df.trade_date)  # 索引转为日期
    dataset = df[["open", "close", "high", "low"]].values

    # 划分训练和测试集
    history = 100   # 建模为100天预测7天
    dataX, dataY = data_split(dataset, history, pred_days)
    dataset = Data.TensorDataset(dataX, dataY)
    train_size = int(0.8 * len(dataset))
    test_size = len(dataset) - train_size
    train_dataset, test_dataset = torch.utils.data.random_split(dataset, [train_size, test_size],
                                                                generator=seed)

    # 分离训练集和验证集
    train_loader = Data.DataLoader(
        dataset=train_dataset,
        batch_size=128,
        shuffle=True
    )
    test_loader = Data.DataLoader(
        dataset=test_dataset,
        batch_size=128,
        shuffle=False
    )

    input_size = output_size = 4
    num_layers, dropout = 2, 0.4
    ffn_num_input, num_heads, kernel_size = 4, 4, 3

    # grid search
    total_loss = 1e5  # 记录所有setting下的最小损失loss，用来保存最好模型
    best_setting = dict(
        hidden_size=32,
        ffn_num_hiddens=32,
        mlp_hidden_size=32
    )

    # wandb.init(project="CNN_TRANSFORMER", config=best_setting)
    # input shape: batch_size, seq_lens, input_size
    model = CNN_TRANSFORMER(input_size, best_setting['hidden_size'], num_heads, best_setting['ffn_num_hiddens'], num_layers,
                            dropout, best_setting['mlp_hidden_size'], kernel_size, pred_days)

    model.load_state_dict(torch.load('ckpt/best_eval_model.pth'))

    hidden_size, ffn_num_hiddens, mlp_hidden_size = best_setting['hidden_size'], best_setting['ffn_num_hiddens'], \
    best_setting['mlp_hidden_size']
    print(f"The best eval setting is hidden_size={hidden_size}, ffn_num_hiddens={ffn_num_hiddens}, mlp_hiddens={mlp_hidden_size}")

    model = CNN_TRANSFORMER(input_size, hidden_size, num_heads, ffn_num_hiddens, num_layers,
                            dropout, mlp_hidden_size, kernel_size, pred_days)
    X = torch.tensor(
        df[['open', 'close', 'high', 'low']][-history:].to_numpy())  # x shape: history, input_size
    model.cpu()
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


    a = 1