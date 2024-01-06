package com.companypowernode.service.impl;

import com.companypowernode.dao.entity.Income;
import com.companypowernode.dao.mapper.IncomeMapper;
import com.companypowernode.service.IIncomeService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 利润表 服务实现类
 * </p>
 *
 * @author ly
 * @since 2023-03-21
 */
@Service
public class IncomeServiceImpl extends ServiceImpl<IncomeMapper, Income> implements IIncomeService {

}
