package com.companypowernode.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.companypowernode.dao.vo.baseVO.Result;
import com.companypowernode.dao.entity.CashFlow;
import com.companypowernode.service.ICashFlowService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 现金流量表 前端控制器
 * </p>
 *
 * @author ly
 * @since 2023-03-21
 */
@Api(tags = "现金流量表")
@RestController
@RequestMapping("/sys/cashFlow")
public class CashFlowController {

    @Autowired
    private ICashFlowService iCashFlowService;

    /**查询指定季度现金流量表
     *
     * @param id
     * @return
     */
    @ApiOperation(value = "查询指定季度现金流量表")
    @PostMapping("/show")
    public Result<List<CashFlow>> Balance(@RequestParam String id){
        LambdaQueryWrapper<CashFlow> lambdaQueryWrapper = new LambdaQueryWrapper<CashFlow>();
        lambdaQueryWrapper.eq(CashFlow::getTsCode,id);
        List<CashFlow> list = iCashFlowService.list(lambdaQueryWrapper);

        return Result.success(list);

    }


}
