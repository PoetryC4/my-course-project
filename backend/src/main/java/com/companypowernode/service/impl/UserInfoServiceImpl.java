package com.companypowernode.service.impl;

import com.companypowernode.dao.entity.UserInfo;
import com.companypowernode.dao.mapper.UserInfoMapper;
import com.companypowernode.service.IUserInfoService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * info of a user 服务实现类
 * </p>
 *
 * @author ly
 * @since 2023-03-21
 */
@Service
public class UserInfoServiceImpl extends ServiceImpl<UserInfoMapper, UserInfo> implements IUserInfoService {

}
