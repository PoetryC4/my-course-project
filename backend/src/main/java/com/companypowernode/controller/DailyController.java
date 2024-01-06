package com.companypowernode.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.companypowernode.dao.vo.baseVO.Result;
import com.companypowernode.dao.entity.Daily;
import com.companypowernode.service.IDailyService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author ly
 * @since 2023-03-21
 */
@Api(tags = "日线信息")
@RestController
@RequestMapping("/sys/daily")
public class DailyController {

    @Autowired
    private IDailyService iDailyService;



    /**查询该id下当天数据
     *
     * @param
     * @return
     */
    @ApiOperation(value = "查询该股票下日线数据")
    @PostMapping("/info")
    public Result<Daily> dailyinfo(@RequestParam String tsCode){

        LocalDate today = LocalDate.now();

        LambdaQueryWrapper<Daily> lambdaQueryWrapper = new LambdaQueryWrapper<Daily>();
        lambdaQueryWrapper.eq(Daily::getTradeDate,today);
        lambdaQueryWrapper.eq(Daily::getTsCode,tsCode);
        Daily daily = iDailyService.getOne(lambdaQueryWrapper);
        return Result.success(daily);
    }

    /**查询该ID股票所有日线数据以绘制日K线图
     *
     * @param
     * @return
     */
    @ApiOperation(value = "查询该ID股票所有日线数据以绘制日K线图")
    @PostMapping("/Kday")
    public Result<List<Daily>> Kday(@RequestParam String tsCode){
        LambdaQueryWrapper<Daily> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(Daily::getTsCode,tsCode);
        List<Daily> list = iDailyService.list(queryWrapper);
        return Result.success(list);
    }

    @PostMapping("")
    public Result<List<Daily>> getKday(@RequestParam String tsCode){
        StringBuilder builder = new StringBuilder();
        builder.append("'");
        builder.append(tsCode);
        builder.append("'");
        List<Daily> list = iDailyService.getdaily(builder.toString());
        return Result.success(list);
    }

}
