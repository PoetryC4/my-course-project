package com.companypowernode.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.companypowernode.dao.vo.baseVO.Result;
import com.companypowernode.common.utils.EmailUtil;
import com.companypowernode.dao.entity.UserInfo;

import com.companypowernode.service.IUserInfoService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Map;

/**
 * <p>
 * info of a UserInfo 前端控制器
 * </p>
 *
 * @author ly
 * @since 2023-03-21
 */
@Api(tags = "用户信息")
@RestController
@RequestMapping("/sys/UserInfo")
public class UserInfoController {
    @Autowired
    private IUserInfoService UserInfoService;

    @Autowired
    private EmailUtil emailUtil;

    @ApiOperation(value = "登录")
    @PostMapping("/login")
    public Result<UserInfo> login(HttpServletRequest request, @RequestBody UserInfo userInfo){
        LambdaQueryWrapper<UserInfo> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(UserInfo::getUserId,userInfo.getUserId());
        UserInfo u = UserInfoService.getOne(queryWrapper);

        String password = userInfo.getPassword();


        if (u == null){
            return Result.error("用户名不存在，请先注册");
        }

        if (!u.getPassword().equals(password)){
            return Result.error("密码不正确，请重新登陆");
        }


        //将id保存到session
        request.getSession().setAttribute("UserInfo",u.getUserId());

        return Result.success(u);

    }
    //退出,清理session
    @ApiOperation(value = "登出")
    @PostMapping("/logout")
    public Result<String> logout(HttpServletRequest request){
        request.getSession().removeAttribute("UserInfo");
        return Result.success("退出成功");
    }

    /**
     * 注册
     * @param
     * @return
     */
    @ApiOperation(value = "注册")
    @PostMapping("/register")
    public Result<String> save(@RequestBody Map map, HttpSession session){

        String code = map.get("code").toString();
        String email = map.get("email").toString();
        Object codeinSession = session.getAttribute(email);

        if (codeinSession.equals(code)){
            UserInfo userInfo = new UserInfo();
            userInfo.setUserId(map.get("userId").toString());
            userInfo.setTsCode(map.get("tsCode").toString());
            userInfo.setUserEmail(email);
            userInfo.setAvatar(map.get("avatar").toString());
            userInfo.setGender(map.get("gender").toString());
            userInfo.setPassword(map.get("password").toString());
            userInfo.setIsEnabled((Boolean)map.get("isEnabled"));
            userInfo.setPhone(map.get("phone").toString());
            UserInfoService.save(userInfo);
        }
        else {
            return Result.error("验证码不正确");
        }

        return Result.success("注册成功");
    }
    @ApiOperation(value = "邮箱验证")
    @PostMapping("/emailcode")
    public Result<String> email(@RequestBody UserInfo userInfo,HttpSession session){
        String email = userInfo.getUserEmail();
        int code = (int) ((Math.random()*9+1)*100000);
        String context = "您的验证码是"+code;
        String subject = "上市公司系统发给您的验证码";
        emailUtil.SendMessage(email,subject,context);
        session.setAttribute(email,code);
        return Result.success("成功发送验证码");
    }



}
