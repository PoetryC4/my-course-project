package com.companypowernode.service.impl;

import com.companypowernode.dao.entity.Daily;
import com.companypowernode.dao.mapper.DailyMapper;
import com.companypowernode.service.IDailyService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author ly
 * @since 2023-03-21
 */
@Service
public class DailyServiceImpl extends ServiceImpl<DailyMapper, Daily> implements IDailyService {

    @Autowired DailyMapper dailyMapper;

    @Override
    public List<Daily> getdaily(String tsCode) {
        return dailyMapper.getdaily(tsCode);
    }


}
