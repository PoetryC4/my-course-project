package com.companypowernode.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.companypowernode.dao.entity.UserInfo;
import com.companypowernode.dao.vo.baseVO.Result;
import com.companypowernode.dao.vo.reqVO.LoginVO;
import com.companypowernode.service.IUserInfoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author liyue
 * @since 2023-12-09
 */

@RestController
@RequestMapping("/sys")
public class LoginController {

    @Autowired
    private IUserInfoService iUserInfoService;

    @ApiOperation(value = "登录")
    @PostMapping("/login")
    public Result<UserInfo> login(@RequestBody LoginVO req){
        LambdaQueryWrapper<UserInfo> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(UserInfo::getUserEmail,req.getUserEmail());
        UserInfo info = iUserInfoService.getOne(wrapper);
        if (info.getPassword().equals(req.getPassword())){
            return Result.success(info);
        }else
            return Result.error("密码错误");

    }
}
