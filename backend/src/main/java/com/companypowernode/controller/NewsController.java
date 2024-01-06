package com.companypowernode.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.companypowernode.dao.vo.baseVO.Result;
import com.companypowernode.dao.entity.News;
import com.companypowernode.dao.mapper.NewsMapper;
import com.companypowernode.service.INewsService;
import com.companypowernode.dao.vo.reqVO.NewsReqVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;

import java.util.List;
@Api(tags = "新闻")
@RestController
@RequestMapping("/sys/news")
public class NewsController {

    @Autowired
    private INewsService iNewsService;
    @Autowired
    private NewsMapper newsMapper;

    /**
     * 分页获取新闻数据，一页10条
     * @return
     */
    @ApiOperation(value = "分页获取新闻数据，一页10条")
    @PostMapping("/new")
    public Result<Object> news(@RequestBody NewsReqVO reqVO){
        Page<News> newsPage = new Page<>(reqVO.getPage(),reqVO.getPageSize());
        LambdaQueryWrapper<News> queryWrapper = new LambdaQueryWrapper();
        queryWrapper.like(News::getTitle,reqVO.getInput());
        IPage page1 = iNewsService.page(newsPage,queryWrapper);
        List<News> record = page1.getRecords();
        return Result.success(record);
    }

    /**
     * 获取记录条数
     * @return
     */
    @ApiOperation(value = "获取记录条数")
    @PostMapping("/newnum")
    public Result<Long> newsnum(@RequestBody NewsReqVO reqVO){
        LambdaQueryWrapper<News> queryWrapper = new LambdaQueryWrapper();
        queryWrapper.like(News::getTitle,reqVO.getInput());
        Long num = iNewsService.count(queryWrapper);
        return Result.success(num);
    }

    /**
     * 返回标题与时间
     * @param
     * @return
     */
    @ApiOperation(value = "返回标题与时间")
    @PostMapping("/getone")
    public Result<News> newone(@RequestBody NewsReqVO reqVO){
        LambdaQueryWrapper<News> queryWrapper = new LambdaQueryWrapper();
        queryWrapper.eq(News::getNewsId,reqVO.getNewsId());
        News record = iNewsService.getOne(queryWrapper);
        return Result.success(record);
    }

}
