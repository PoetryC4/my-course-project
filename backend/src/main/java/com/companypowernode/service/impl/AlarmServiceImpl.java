package com.companypowernode.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.companypowernode.dao.entity.Alarm;
import com.companypowernode.dao.mapper.AlarmMapper;
import com.companypowernode.dao.vo.reqVO.AlarmReqVO;
import com.companypowernode.service.AlarmService;
import org.springframework.stereotype.Service;

/**
 * @author liyue
 * @since 2023-9-17
 */
@Service
public class AlarmServiceImpl extends ServiceImpl<AlarmMapper, Alarm>implements AlarmService {



}
