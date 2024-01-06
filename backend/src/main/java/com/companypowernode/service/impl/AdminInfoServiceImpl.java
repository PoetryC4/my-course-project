package com.companypowernode.service.impl;

import com.companypowernode.dao.entity.AdminInfo;
import com.companypowernode.dao.mapper.AdminInfoMapper;
import com.companypowernode.service.IAdminInfoService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * info of an admin 服务实现类
 * </p>
 *
 * @author ly
 * @since 2023-03-21
 */
@Service
public class AdminInfoServiceImpl extends ServiceImpl<AdminInfoMapper, AdminInfo> implements IAdminInfoService {

}
