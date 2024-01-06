package com.companypowernode.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.companypowernode.dao.vo.baseVO.Result;
import com.companypowernode.dao.entity.SearchHistory;
import com.companypowernode.service.ISearchHistoryService;
import com.companypowernode.dao.vo.reqVO.SearchHistoryReqVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.List;
@Api(tags = "浏览历史")
@RestController
@RequestMapping("/sys/searchHistory")
public class SearchHistoryController {
    @Autowired
    public ISearchHistoryService iSearchHistoryService;

    /**
     * 分页查询搜索历史
     * @return
     */
    @ApiOperation(value = "分页查询搜索历史")
    @PostMapping("/search")
    public Result<Object> search(@RequestBody SearchHistoryReqVO reqVO){
        LambdaQueryWrapper<SearchHistory> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(SearchHistory::getUserId,reqVO.getUserId());
        queryWrapper.like(SearchHistory::getTsName,reqVO.getInput());
        queryWrapper.orderByDesc(SearchHistory::getsDate);
        Page pageInfo = new Page(reqVO.getPage(),reqVO.getPageSize());
        IPage page1=iSearchHistoryService.page(pageInfo,queryWrapper);
        List<SearchHistory> record = page1.getRecords();
        return Result.success(record);
    }

    /**
     * 获取记录数量
     * @return
     */
    @ApiOperation(value = "获取记录数量")
    @PostMapping("/getnum")
    public Result<Long> searchnum(@RequestBody SearchHistoryReqVO reqVO){
        LambdaQueryWrapper<SearchHistory> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(SearchHistory::getUserId,reqVO.getUserId());
        queryWrapper.like(SearchHistory::getTsName,reqVO.getInput());
        Long num = iSearchHistoryService.count(queryWrapper);
        return Result.success(num);
    }

    /**
     * 新增浏览历史
     * @return
     */
    @ApiOperation(value = "新增浏览历史")
    @PostMapping("/add")
    public Result<String> add(@RequestBody SearchHistoryReqVO reqVO){
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        SearchHistory history = new SearchHistory();
        history.setsDate(reqVO.getSDate());
        history.setsId(reqVO.getSId());
        history.setTsCode(reqVO.getTsCode());
        history.setTsName(reqVO.getTsName());
        history.setUserId(reqVO.getUserId());
        iSearchHistoryService.save(history);
        return Result.success("新增浏览历史成功");
    }

    /**
     * 删除一条记录
     * @return
     */
    @ApiOperation(value = "删除浏览历史")
    @PostMapping("/delete")
    public Result<String> delete(@RequestBody SearchHistoryReqVO reqVO){
        LambdaQueryWrapper<SearchHistory> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(SearchHistory::getUserId,reqVO.getUserId());
        queryWrapper.eq(SearchHistory::getTsCode,reqVO.getTsCode());
        iSearchHistoryService.remove(queryWrapper);
        return Result.success("删除记录成功");
    }

    /**
     * 清除记录
     * @param userId
     * @return
     */
    @ApiOperation(value = "清除浏览历史")
    @PostMapping("/deleteall")
    public Result<String> deleteall(@RequestParam String userId){
        LambdaQueryWrapper<SearchHistory> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(SearchHistory::getUserId,userId);
        iSearchHistoryService.remove(queryWrapper);
        return Result.success("清除记录成功");
    }
}
