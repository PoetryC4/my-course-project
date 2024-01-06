import sys
from selenium import webdriver
import torch


def policy(state):
    action = [2, 1, 0, 0]
    action[0] += state[0][1]
    return action


def str2int(stateStr):
    '''将完整字符串转换为二维数组'''
    stateList = []
    multiVimState = stateStr.split(';')
    for singleVimState in multiVimState:
        elements = singleVimState.split(' ')
        singleVimList = []
        for e in elements:
            singleVimList.append(int(e))
        stateList.append(singleVimList)
    return stateList

def int2str(actionIntArr):
    '''将形如[0,1,0,0,0]的int动作向量转化为01000字符串，方便Java处理'''
    actionStr = '';
    for e in actionIntArr:
        actionStr += str(e)
    return actionStr

if __name__ == '__main__':
    state = []
    stateStr = sys.argv[1];
    stateIntArr = str2int(stateStr)
    actionIntArr = policy(stateIntArr)
    actionStr = int2str(actionIntArr)
    # [2+5=7, 1, 0, 0] => 7100
    print(actionStr)

