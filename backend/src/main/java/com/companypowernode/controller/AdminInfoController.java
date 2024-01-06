package com.companypowernode.controller;

import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.companypowernode.dao.vo.baseVO.Result;
import com.companypowernode.dao.entity.AdminInfo;
import com.companypowernode.dao.mapper.AdminInfoMapper;
import com.companypowernode.service.IAdminInfoService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * info of an admin 管理员信息
 * </p>
 *
 * @author ly
 * @since 2023-03-21
 */
@RestController
@RequestMapping("/sys/adminInfo")
public class AdminInfoController {

    public IAdminInfoService iAdminInfoService;
    @Autowired
    public AdminInfoMapper infoMapper;

    /**
     * 新增管理员信息
     * @param adminInfo
     * @return
     */
    @ApiOperation(value = "新增管理员信息")
    @PostMapping("/add")
    public Result<String> addinfo(@RequestBody AdminInfo adminInfo){
        System.out.println(adminInfo);
        infoMapper.insert(adminInfo);
        return Result.success("插入管理数据成功");
    }

    /**
     * 管理员信息更新
     * @param adminInfo
     * @return
     */
    @ApiOperation(value = "管理员信息更新")
    @PostMapping("/update")
    public Result<String> updatew(@RequestBody AdminInfo adminInfo){
        UpdateWrapper<AdminInfo> wrapper = new UpdateWrapper<>();
        Integer id = adminInfo.getUserId2();
        String name = adminInfo.getAdminName();
        String pwd = adminInfo.getAdminPassword();
        wrapper.eq("user_id2",id);
        wrapper.set("admin_password",pwd);
        wrapper.set("admin_name",name);
        infoMapper.update(null,wrapper);
        return Result.success("成功更改");
    }

    /**
     * 管理员信息删除
     * @param userId2
     * @return
     */
    @ApiOperation(value = "管理员信息删除")
    @PostMapping("/delete/{id}")
    public Result<String> delete(@PathVariable("id") Integer userId2){
        System.out.println(userId2);
        infoMapper.deleteById(userId2);
        return Result.success("删除成功");
    }

    /**
     * 管理员信息批量删除
     * @param id
     * @return
     */
    @ApiOperation(value = "管理员信息批量删除")
    @PostMapping("/deletelist")
    public Result<String> delectlist(@RequestBody List<Integer> id){
        infoMapper.deleteBatchIds(id);
        return Result.success("批量删除成功");
    }

}
