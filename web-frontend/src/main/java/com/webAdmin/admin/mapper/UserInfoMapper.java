package com.webAdmin.admin.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.webAdmin.admin.entity.UserInfo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.Map;

@Mapper
@Repository
public interface UserInfoMapper extends BaseMapper<UserInfo> {

}
