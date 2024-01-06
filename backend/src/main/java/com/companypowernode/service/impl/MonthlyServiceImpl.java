package com.companypowernode.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.companypowernode.dao.entity.Monthly;
import com.companypowernode.dao.mapper.MonthlyMapper;
import com.companypowernode.service.IMonthlyService;
import org.springframework.stereotype.Service;

@Service
public class MonthlyServiceImpl extends ServiceImpl<MonthlyMapper, Monthly> implements IMonthlyService {
}
