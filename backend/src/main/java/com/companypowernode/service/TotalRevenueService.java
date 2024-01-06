package com.companypowernode.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.companypowernode.dao.vo.DTO.IncomeDto;

import java.util.List;
import java.util.TreeMap;

public interface TotalRevenueService extends IService<TreeMap<Integer,Double>>{
    TreeMap<Integer, Double> getRevenues(String tsCode, String endType);
}
