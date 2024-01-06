package com.companypowernode.service.impl;

import com.companypowernode.dao.entity.StockInfo;
import com.companypowernode.dao.mapper.StockInfoMapper;
import com.companypowernode.service.IStockInfoService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * info of a stock
 服务实现类
 * </p>
 *
 * @author ly
 * @since 2023-03-21
 */
@Service
public class StockInfoServiceImpl extends ServiceImpl<StockInfoMapper, StockInfo> implements IStockInfoService {

}
