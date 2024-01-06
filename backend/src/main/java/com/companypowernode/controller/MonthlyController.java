package com.companypowernode.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.companypowernode.dao.vo.baseVO.Result;
import com.companypowernode.dao.entity.Monthly;
import com.companypowernode.service.IMonthlyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/sys/month")
public class MonthlyController {
    @Autowired
    private IMonthlyService iMonthlyService;

    /**根据id查找月行情值
     *
     * @param id
     * @return
     */
    @PostMapping("")
    public Result<List<Monthly>> Kmonth(@RequestParam String id){
        LambdaQueryWrapper<Monthly> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(Monthly::getTsCode,id);
        List<Monthly> list = iMonthlyService.list(queryWrapper);
        return Result.success(list);
    }
}
