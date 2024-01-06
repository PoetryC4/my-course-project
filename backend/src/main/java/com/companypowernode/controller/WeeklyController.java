package com.companypowernode.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.companypowernode.dao.vo.baseVO.Result;
import com.companypowernode.dao.entity.Weekly;
import com.companypowernode.service.IWeeklyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 暂时不用
 */
@RestController
@RequestMapping("/sys/weekly")
public class WeeklyController {
    @Autowired
    private IWeeklyService iWeeklyService;

    /**根据id查找周行情数据
     *
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    public Result<List<Weekly>> Kweek(@PathVariable String id){
        LambdaQueryWrapper<Weekly> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(Weekly::getTsCode,id);
        List<Weekly> list = iWeeklyService.list(queryWrapper);
        return Result.success(list);
    }
}
