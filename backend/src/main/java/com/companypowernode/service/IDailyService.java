package com.companypowernode.service;

import com.companypowernode.dao.entity.Daily;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author ly
 * @since 2023-03-21
 */
public interface IDailyService extends IService<Daily> {

    List<Daily> getdaily(String tsCode);



}
