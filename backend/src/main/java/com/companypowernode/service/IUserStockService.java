package com.companypowernode.service;

import com.companypowernode.dao.entity.UserStock;
import com.github.jeffreyning.mybatisplus.service.IMppService;

import java.util.List;

/**
 * <p>
 * 自选股 服务类
 * </p>
 *
 * @author ly
 * @since 2023-03-21
 */
public interface IUserStockService extends IMppService<UserStock> {

    /**
     * 获得所有自选股代码
     * @return
     */
    List<String> getTsCodeList();
    List<String> getTsCodeListById(String userId);

}
