package com.companypowernode.service.impl;

import com.companypowernode.dao.entity.UserHistory;
import com.companypowernode.dao.mapper.UserHistoryMapper;
import com.companypowernode.service.IUserHistoryService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 浏览历史 服务实现类
 * </p>
 *
 * @author ly
 * @since 2023-03-21
 */
@Service
public class UserHistoryServiceImpl extends ServiceImpl<UserHistoryMapper, UserHistory> implements IUserHistoryService {

}
