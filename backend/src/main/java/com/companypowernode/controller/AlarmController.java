package com.companypowernode.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.companypowernode.dao.entity.Alarm;
import com.companypowernode.dao.entity.UserInfo;
import com.companypowernode.dao.mapper.AlarmMapper;
import com.companypowernode.service.AlarmService;
import com.companypowernode.dao.vo.baseVO.Result;
import com.companypowernode.dao.vo.reqVO.AlarmReqVO;
import com.companypowernode.service.IUserInfoService;
import com.mchange.v2.beans.BeansUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;
import java.util.Objects;

/**
 * @author liyue
 * @since 2023-9-17
 */
@Api(tags = "预警")
@Slf4j
@RequestMapping("/sys/alarm")
@RestController
public class AlarmController {

    @Autowired
    private AlarmService alarmService;

    @Autowired
    private IUserInfoService iUserInfoService;

    @Autowired
    private AlarmMapper alarmMapper;

    /**
     * 录入预警数据
     * @param reqVO
     * @return
     */
    @ApiOperation(value = "设置预警值")
    @PostMapping("/InsertOrUpdate")
    public Result<String> InsertOrUpdate(@RequestBody AlarmReqVO reqVO){
        Alarm alarm = new Alarm();
        BeanUtils.copyProperties(reqVO,alarm);
//        LambdaQueryWrapper<Alarm> wrapper = new LambdaQueryWrapper<>();
//        wrapper.eq(Alarm::getId,reqVO.getId());
//        alarmService.saveOrUpdate(alarm,wrapper);
        if (Objects.nonNull(reqVO.getId()))
            alarmMapper.Update(reqVO);
        else
            alarmMapper.Insert(reqVO);
        return Result.success("更新成功");
    }

    @ApiOperation(value = "获得预警值")
    @PostMapping("/info")
    public Result<List<Alarm>> getAlarm(@RequestParam String userId){
        LambdaQueryWrapper<Alarm> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(Alarm::getUserId,userId);
        List<Alarm> alarms = alarmMapper.info(userId);
        //List<Alarm> alarms1 = alarmService.list(wrapper);
        return Result.success(alarms);
    }

    @ApiOperation(value = "删除预警值")
    @PostMapping("/delete")
    public Result<String> deleteAlarm(@RequestBody AlarmReqVO reqVO){
        LambdaQueryWrapper<Alarm> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(Alarm::getId,reqVO.getId());
        wrapper.eq(Alarm::getUserId,reqVO.getUserId());
        alarmService.remove(wrapper);
        return Result.success("删除成功");
    }

    @ApiOperation(value = "开启预警")
    @PostMapping("/open")
    public Result<String> openAlarm(@RequestParam String userId){
        UpdateWrapper<UserInfo> wrapper = new UpdateWrapper<>();
        wrapper.set("is_open_alarm",1);
        wrapper.eq("user_id",userId);
        iUserInfoService.update(wrapper);
        return Result.success("开启预警");
    }

    @ApiOperation(value = "关闭预警")
    @PostMapping("/close")
    public Result<String> closeAlarm(@RequestParam String userId){
        UpdateWrapper<UserInfo> wrapper = new UpdateWrapper<>();
        wrapper.set("is_open_alarm",0);
        wrapper.eq("user_id",userId);
        iUserInfoService.update(wrapper);
        return Result.success("关闭预警");
    }

}
