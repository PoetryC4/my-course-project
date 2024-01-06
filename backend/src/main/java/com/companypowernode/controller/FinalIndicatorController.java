package com.companypowernode.controller;

import com.companypowernode.dao.vo.baseVO.Result;
import com.companypowernode.dao.entity.FinalIndicator;
import com.companypowernode.service.IFinalIndicatorService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 *  100天预测7天数据
 * </p>
 *
 * @author ly
 * @since 2023-03-21
 */
@Api(tags = "财务指标")
@RestController
@RequestMapping("/sys/finalIndicator")
public class FinalIndicatorController {

    @Autowired
    private IFinalIndicatorService iFinalIndicatorService;

    /**
     * 通过股票code查询主要指标
     * @param id
     * @return
     */
    @PostMapping("")
    public Result<FinalIndicator> indicatorinfo(@RequestParam String id){
        FinalIndicator info = iFinalIndicatorService.getById(id);
        return Result.success(info);
    }


}
