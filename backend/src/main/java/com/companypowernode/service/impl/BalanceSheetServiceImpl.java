package com.companypowernode.service.impl;

import com.companypowernode.dao.entity.BalanceSheet;
import com.companypowernode.dao.mapper.BalanceSheetMapper;
import com.companypowernode.service.IBalanceSheetService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 资产负债表 服务实现类
 * </p>
 *
 * @author ly
 * @since 2023-03-21
 */
@Service
public class BalanceSheetServiceImpl extends ServiceImpl<BalanceSheetMapper, BalanceSheet> implements IBalanceSheetService {

}
