package com.companypowernode.service.impl;

import com.companypowernode.dao.entity.UserStock;
import com.companypowernode.dao.mapper.UserStockMapper;
import com.companypowernode.service.IUserStockService;
import com.github.jeffreyning.mybatisplus.service.MppServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 自选股 服务实现类
 * </p>
 *
 * @author ly
 * @since 2023-03-21
 */
@Service
public class UserStockServiceImpl extends MppServiceImpl<UserStockMapper, UserStock> implements IUserStockService {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<String> getTsCodeList() {



        String sql = "select distinct ts_code from user_stock where user_id = ";
        List<String> list = jdbcTemplate.queryForList(sql,String.class);
        return list;
    }
    public List<String> getTsCodeListById(String userId) {

        String sql = "select distinct ts_code from user_stock where user_id = "+userId;
        List<String> list = jdbcTemplate.queryForList(sql,String.class);
        return list;
    }
}
