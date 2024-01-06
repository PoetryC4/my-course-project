package com.companypowernode.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.companypowernode.dao.vo.baseVO.Result;
import com.companypowernode.dao.entity.MyNotes;
import com.companypowernode.service.IMyNotesService;
import com.companypowernode.dao.vo.reqVO.MyNoteReqVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

/**
 * <p>
 * 我的笔记 前端控制器
 * </p>
 *
 * @author ly
 * @since 2023-03-21
 */
@Api(tags = "笔记")
@RestController
@RequestMapping("/sys/myNotes")
public class MyNotesController {

    @Autowired
    private IMyNotesService iMyNotesService;

    /**
     * 新增笔记
     * @return
     */
    @ApiOperation(value = "新增笔记")
    @PostMapping("/add")
    public Result<String> add(@RequestBody MyNoteReqVO reqVO){

//        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
//        Date date = null;
//        try {
//            date = format.parse(noteDate);
//        } catch (ParseException e) {
//            e.printStackTrace();
//        }

        MyNotes myNotes = new MyNotes();
        myNotes.setContent(reqVO.getContent());
        myNotes.setNoteDate(reqVO.getNoteDate());
        myNotes.setTitle(reqVO.getTitle());
        myNotes.setUserId(reqVO.getUserId());
        iMyNotesService.save(myNotes);
        return Result.success("笔记新增成功");
    }

    /**
     * 修改指定笔记
     * @return
     */
    @ApiOperation(value = "修改笔记")
    @PostMapping("/update")
    public Result<String> save(@RequestBody MyNoteReqVO reqVO){

        LambdaUpdateWrapper<MyNotes> queryWrapper = new LambdaUpdateWrapper<>();
        queryWrapper.eq(MyNotes::getNoteId,reqVO.getUserId())
                .set(MyNotes::getTitle,reqVO.getTitle())
                .set(MyNotes::getContent,reqVO.getContent())
                .set(MyNotes::getNoteDate,reqVO.getNoteDate());
        iMyNotesService.update(queryWrapper);

        return Result.success("笔记修改成功");
    }

    /**
     * 显示笔记
     * @return
     */
    @ApiOperation(value = "查询笔记")
    @PostMapping("/show")
    public Result<MyNotes> shows(@RequestBody MyNoteReqVO reqVO){
        LambdaQueryWrapper<MyNotes> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(MyNotes::getUserId,reqVO.getUserId());
        queryWrapper.eq(MyNotes::getNoteId,reqVO.getNoteId());
        MyNotes info = iMyNotesService.getOne(queryWrapper);
        if (info == null){
            return Result.error("笔记为空");
        }
        return Result.success(info);
    }

    /**
     * 根据ID删除笔记
     * @return
     */
    @ApiOperation(value = "删除笔记")
    @PostMapping("/delete")
    public Result<String> delnote(@RequestBody MyNoteReqVO reqVO){
        LambdaQueryWrapper<MyNotes> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(MyNotes::getNoteId,reqVO.getNoteId());
        wrapper.eq(MyNotes::getUserId,reqVO.getUserId());
        iMyNotesService.remove(wrapper);
        return Result.success("删除成功");
    }

    /**
     * 分页查询笔记
     * @return
     */
    @ApiOperation(value = "笔记列表")
    @PostMapping("/getpage")
    public Result<Object> page(@RequestBody MyNoteReqVO reqVO){
        //构造分页构造器
        Page pageInfo = new Page(reqVO.getPage(),reqVO.getPageSize());
        //构造条件构造器
        LambdaQueryWrapper<MyNotes> queryWrapper = new LambdaQueryWrapper<>();
        //添加过滤条件
        queryWrapper.like(StringUtils.isNotEmpty(reqVO.getInput()), MyNotes::getTitle,reqVO.getInput());
        queryWrapper.eq(MyNotes::getUserId,reqVO.getUserId());
        //添加排序条件
        queryWrapper.orderByDesc(MyNotes::getNoteDate);
        //执行查询
        IPage pageRes = iMyNotesService.page(pageInfo,queryWrapper);
        List<MyNotes> notesRes = pageRes.getRecords();
        return Result.success(notesRes);
    }

    @ApiOperation(value = "查询笔记数量")
    @PostMapping("/getnum")
    public Result<Long> getnum(@RequestBody MyNoteReqVO reqVO){
        LambdaQueryWrapper<MyNotes> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.like(Objects.nonNull(reqVO.getInput()), MyNotes::getTitle,reqVO.getInput());
        queryWrapper.eq(MyNotes::getUserId,reqVO.getUserId());
        Long num = iMyNotesService.count(queryWrapper);
     return Result.success(num);
    }
}
