package com.webAdmin.admin.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.webAdmin.admin.common.R;
import com.webAdmin.admin.entity.UserInfo;
import com.webAdmin.admin.service.UserInfoService;
import com.webAdmin.admin.utils.RandomCharacters;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

@Slf4j
@Controller
@RestController
@RequestMapping("/user")
public class UserInfoController {

    @Autowired
    private UserInfoService userInfoService;

    @GetMapping("/page")
    public R<IPage> page(int page,int pageSize,String name){
        log.info("page = {},pageSize = {},name = {}" ,page,pageSize,name);

        //构造分页构造器
        Page pageInfo = new Page(page,pageSize);

        //构造条件构造器
        LambdaQueryWrapper<UserInfo> queryWrapper = new LambdaQueryWrapper();
        //添加过滤条件
        queryWrapper.like(StringUtils.isNotEmpty(name), UserInfo::getUserName,name);
        //添加排序条件
        queryWrapper.orderByAsc(UserInfo::getUserId);

        //执行查询
        IPage pageRes = userInfoService.page(pageInfo,queryWrapper);

        List<UserInfo> userRes = pageRes.getRecords();

        return R.success(pageRes);
    }

    @PutMapping("/edit")
    public R<String> update(HttpServletRequest request, @RequestBody UserInfo userInfo){
        log.info(userInfo.toString());

        long id = Thread.currentThread().getId();
        log.info("线程id为：{}",id);
        //Long empId = (Long)request.getSession().getAttribute("employee");
        //employee.setUpdateTime(LocalDateTime.now());
        //employee.setUpdateUser(empId);
        userInfoService.updateById(userInfo);

        return R.success("用户信息修改成功");
    }

    @PostMapping("/add")
    public R<String> save(HttpServletRequest request,@RequestBody UserInfo userInfo){
        log.info("新增用户，用户信息：{}",userInfo.toString());

        String salt = RandomCharacters.getRandomString(6);
        //设置初始密码123456，需要进行md5加密处理
        userInfo.setSalt(salt);
        userInfo.setPassword(DigestUtils.md5DigestAsHex(("123456"+salt).getBytes()));

        //employee.setCreateTime(LocalDateTime.now());
        //employee.setUpdateTime(LocalDateTime.now());

        //获得当前登录用户的id
        //Long empId = (Long) request.getSession().getAttribute("employee");

        //employee.setCreateUser(empId);
        //employee.setUpdateUser(empId);

        if(userInfo.getUserName() != null && userInfo.getUserEmail() != null) {
            userInfoService.save(userInfo);
        }

        return R.success("新增用户成功");
    }
    @GetMapping("/{id}")
    public R<UserInfo> getById(@PathVariable Long id){
        log.info("根据id查询用户信息...");
        UserInfo userInfo = userInfoService.getById(id);
        if(userInfo != null){
            return R.success(userInfo);
        }
        return R.error("没有查询到对应用户信息");
    }
}
