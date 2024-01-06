package com.companypowernode.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.companypowernode.dao.vo.baseVO.Result;
import com.companypowernode.dao.entity.UserStock;
import com.companypowernode.service.IUserStockService;
import com.companypowernode.dao.vo.reqVO.UserStockReqVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * <p>
 * 自选股 前端控制器
 * </p>
 *
 * @author ly
 * @since 2023-03-21
 */
@Api(tags = "自选股")
@RestController
@RequestMapping("/sys/userStock")
public class UserStockController {
    @Autowired
    private IUserStockService iUserStockService;


    /**
     * 加入自选股
     * @return
     */
    @ApiOperation(value = "新增自选股")
    @PostMapping("/add")
    public Result<String> addmystock(@RequestBody UserStockReqVO reqVO){
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date date = null;
        try {
            date = format.parse(reqVO.getFavorDate());
        } catch (ParseException e) {
            e.printStackTrace();
        }

        UserStock stock= new UserStock();
        stock.setFavorDate(reqVO.getFavorDate());
        stock.setTsCode(reqVO.getTsCode());
        stock.setUserId(reqVO.getUserId());
        System.out.println(stock);
        iUserStockService.save(stock);
        return Result.success("新增自选股成功");
    }

    /**
     * 删除自选股
     * @param
     * @return
     */
    @ApiOperation(value = "删除自选股")
    @PostMapping("/delete")
    public Result<String> delmystock(@RequestBody UserStockReqVO reqVO){
        LambdaQueryWrapper<UserStock> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(UserStock::getTsCode,reqVO.getTsCode());
        queryWrapper.eq(UserStock::getUserId,reqVO.getUserId());
        iUserStockService.remove(queryWrapper);
        return Result.success("删除自选股成功");
    }

    /**
     * 获取自选股信息
     * @return
//     */
    @ApiOperation(value = "获取自选股信息")
    @PostMapping("/info")
    public Result<List<UserStock>> info(@RequestBody UserStockReqVO reqVO){
        LambdaQueryWrapper<UserStock> queryWrapper = new LambdaQueryWrapper<UserStock>();
        queryWrapper.eq(UserStock::getUserId,reqVO.getUserId());
        Page pageInfo = new Page(reqVO.getPage(),reqVO.getPageSize());
        IPage pageRes = iUserStockService.page(pageInfo,queryWrapper);

        List<UserStock> notesRes = pageRes.getRecords();

        return Result.success(notesRes);
   }

    /**
     * 获得记录数量
     * @param id
     * @return
     */
    @PostMapping("/getnum")
    public Result<Long> info(@RequestParam String id){
        LambdaQueryWrapper<UserStock> queryWrapper = new LambdaQueryWrapper<UserStock>();
        queryWrapper.eq(UserStock::getUserId,id);
        Long num = iUserStockService.count(queryWrapper);
        return Result.success(num);
    }

    /**
     * 根据id查找
     * @return
     */
    @PostMapping("/getById")
    public Result<String> search(@RequestBody UserStockReqVO reqVO){
        LambdaQueryWrapper<UserStock> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(UserStock::getTsCode,reqVO.getTsCode());
        if (iUserStockService.count(queryWrapper)==0)
        {
            return Result.error("可添加自选股");
        }
        else {
            return Result.success("自选股已添加");
        }
    }

}
