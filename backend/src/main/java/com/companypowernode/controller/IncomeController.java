package com.companypowernode.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.companypowernode.dao.vo.baseVO.Result;
import com.companypowernode.dao.entity.Income;
import com.companypowernode.service.IIncomeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 利润表 前端控制器
 * </p>
 *
 * @author ly
 * @since 2023-03-21
 */
@Api(tags = "利润表")
@RestController
@RequestMapping("/sys/income")
public class IncomeController {

    @Autowired
    private IIncomeService iIncomeService;

    /**查询指定季度利润表
     *
     * @param id
     * @return
     */
    @ApiOperation(value = "查询指定季度利润表")
    @PostMapping("/show")
    public Result<List<Income>> Balance(@RequestParam String id){
        LambdaQueryWrapper<Income> lambdaQueryWrapper = new LambdaQueryWrapper<Income>();
        lambdaQueryWrapper.eq(Income::getTsCode,id);
        List<Income> list = iIncomeService.list(lambdaQueryWrapper);
        return Result.success(list);

    }

}
