package com.companypowernode.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;

import com.companypowernode.dao.vo.baseVO.Result;
import com.companypowernode.dao.entity.BalanceSheet;
import com.companypowernode.service.IBalanceSheetService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 资产负债表 前端控制器
 * </p>
 *
 * @author ly
 * @since 2023-03-21
 */

@RestController
@RequestMapping("/sys/balanceSheet")
@Api(value = "资产负债表")
public class BalanceSheetController {

    @Autowired
    private IBalanceSheetService iBalanceSheetService;

    /**获得指定季度资产负债表
     *
     * @param id
     * @return
     */
    @PostMapping("/show")
    @ApiOperation(value = "获取资产负债表信息",notes = "资产负债表")
    public Result<List<BalanceSheet>> Balance(String id){
        LambdaQueryWrapper<BalanceSheet> lambdaQueryWrapper = new LambdaQueryWrapper<BalanceSheet>();
        lambdaQueryWrapper.eq(BalanceSheet::getTsCode,id);
        List<BalanceSheet> list = iBalanceSheetService.list(lambdaQueryWrapper);
        return Result.success(list);
    }


}
