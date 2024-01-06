package com.companypowernode.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.companypowernode.dao.entity.Weekly;
import com.companypowernode.dao.mapper.WeeklyMapper;
import com.companypowernode.service.IWeeklyService;
import org.springframework.stereotype.Service;

@Service
public class WeeklyServiceImpl extends ServiceImpl<WeeklyMapper, Weekly> implements IWeeklyService {
}
