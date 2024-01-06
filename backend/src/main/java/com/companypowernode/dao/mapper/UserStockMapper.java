package com.companypowernode.dao.mapper;

import com.companypowernode.dao.entity.UserStock;

import com.github.jeffreyning.mybatisplus.base.MppBaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 * 自选股 Mapper 接口
 * </p>
 *
 * @author ly
 * @since 2023-03-21
 */
@Mapper
public interface UserStockMapper extends MppBaseMapper<UserStock> {

}
