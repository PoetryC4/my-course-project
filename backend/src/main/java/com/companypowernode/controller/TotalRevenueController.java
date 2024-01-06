package com.companypowernode.controller;

import com.companypowernode.dao.entity.Income;
import com.companypowernode.dao.vo.baseVO.Result;
import com.companypowernode.service.TotalRevenueService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.TreeMap;
@Api(tags = "图表-获得营业收入")
@RestController
@RequestMapping("/revenue")
public class TotalRevenueController {
    @Autowired
    private TotalRevenueService totalRevenueService;
    @ApiOperation(value = "获得该股票营业收入")
    @PostMapping("/total")
    public Result<TreeMap<Integer,Double>> totalRevenue(@RequestBody Income income){
        //拿到一个Treemap数据
        TreeMap<Integer,Double> revenues=totalRevenueService.getRevenues(income.getTsCode(),income.getEndType());
        return Result.success(revenues);
    }
}
