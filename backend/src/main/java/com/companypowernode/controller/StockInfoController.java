package com.companypowernode.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.companypowernode.dao.vo.baseVO.Result;
import com.companypowernode.dao.entity.StockInfo;
import com.companypowernode.service.IStockInfoService;
import com.companypowernode.dao.vo.reqVO.StockInfoReqVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

/**
 * <p>
 * info of a stock
 前端控制器
 * </p>
 *
 * @author ly
 * @since 2023-03-21
 */
@Api(tags = "股票信息")
@RestController
@RequestMapping("/sys/stockInfo")
public class StockInfoController {
    @Autowired
    private IStockInfoService iStockInfoService;

    /**
     * 分页显示模糊查询
     * @return
     */
    @ApiOperation(value = "分页显示模糊查询")
    @PostMapping("/show")
    public Result<Object> show(@RequestBody StockInfoReqVO reqVO){
        LambdaQueryWrapper<StockInfo> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.like(Objects.nonNull(reqVO.getInput()),StockInfo::getStoName,reqVO.getInput());
        Page pageInfo = new Page(reqVO.getPage(),reqVO.getPageSize());
        IPage page1=iStockInfoService.page(pageInfo,queryWrapper);
        List<StockInfo> record = page1.getRecords();
        return Result.success(record);
    }


    /**
     * 获得记录数量
     * @return
     */
    @PostMapping("/getnum")
    public Result<Long> showNum(@RequestBody StockInfoReqVO reqVO){
        LambdaQueryWrapper<StockInfo> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.like(StockInfo::getStoName,reqVO.getInput());
        Long num = iStockInfoService.count(queryWrapper);
        return Result.success(num);
    }



}
