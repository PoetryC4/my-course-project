package com.companypowernode.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.companypowernode.dao.vo.baseVO.Result;
import com.companypowernode.dao.entity.UserHistory;
import com.companypowernode.service.IUserHistoryService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 浏览历史 前端控制器
 * </p>
 *
 * @author ly
 * @since 2023-03-21
 */

@RestController
@RequestMapping("/sys/userHistory")
public class UserHistoryController {
    @Autowired
    private IUserHistoryService iUserHistoryService;

    /**
     * 根据显示浏览历史
     * @param id
     * @return
     */
    @ApiOperation(value = "根据显示浏览历史")
    @PostMapping("/show")
    public Result<List<UserHistory>> show(@RequestBody String id){
        LambdaQueryWrapper<UserHistory> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(UserHistory::getUserId,id);
        List history = iUserHistoryService.list(wrapper);
        return Result.success(history);
    }

    /**
     * 增加浏览历史
     * @param userHistory
     * @return
     */
    @ApiOperation(value = "增加浏览历史")
    @PostMapping("/add")
    public Result<String> add(@RequestBody UserHistory userHistory){
        iUserHistoryService.save(userHistory);
        return Result.success("浏览记录新增成功");
    }

    /**
     * 删除浏览历史
     * @param id
     * @return
     */
    @ApiOperation(value = "删除浏览历史")
    @PostMapping("/delete")
    public Result<String> delete(@RequestParam String id){
        iUserHistoryService.removeById(id);
        return Result.success("浏览历史删除成功");
    }
}
