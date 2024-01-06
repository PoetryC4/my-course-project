package com.companypowernode.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.companypowernode.dao.vo.baseVO.Result;
import com.companypowernode.dao.entity.Brosehistory;
import com.companypowernode.service.IBrosehistoryService;
import com.companypowernode.dao.vo.reqVO.AddBroseHistoryReqVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Api(tags = "搜索历史")
@RestController
@RequestMapping("/sys/brosehistory")
public class BrosehistoryController {

    @Autowired
    private IBrosehistoryService iBrosehistoryService;

    /**
     * 返回id用户搜索历史
     * @param id
     * @return
     */
    @ApiOperation(value = "返回用户搜索历史")
    @PostMapping("/gethistory")
    public Result<List<Brosehistory>> gethistory(@RequestParam Integer id){

        LambdaQueryWrapper<Brosehistory> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(Brosehistory::getUserid,id);
        List<Brosehistory> list = iBrosehistoryService.list(wrapper);
        return Result.success(list);
    }



    /**
     * 清空浏览记录
     * @param id
     * @return
     */
    @ApiOperation(value = "清空浏览记录")
    @PostMapping("/clean")
    public Result<String> clean(@RequestParam Integer id){
        LambdaQueryWrapper<Brosehistory> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(Brosehistory::getUserid,id);
        iBrosehistoryService.remove(wrapper);
        return Result.success("成功删除搜索记录");
    }

    /**
     * 分页查询搜索浏览历史
     * @param userid
     * @return
     */
    @ApiOperation(value = "分页查询搜索浏览历史")
    @ResponseBody
    @PostMapping("/search")
    public Result<Object> search(@RequestParam String userid){
        LambdaQueryWrapper<Brosehistory> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(Brosehistory::getUserid,userid);

        queryWrapper.orderByDesc(Brosehistory::getDate);
        List<Brosehistory> record =iBrosehistoryService.list(queryWrapper);
        return Result.success(record);
    }

    /**
     *新增搜索历史
     * @return
     */
    @ApiOperation(value = "新增搜索历史")
    @PostMapping("/add")
    public Result<String> add(@RequestBody AddBroseHistoryReqVO reqVO){
        LambdaQueryWrapper<Brosehistory> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(Brosehistory::getHistory,reqVO.getHistory());
        Brosehistory b = iBrosehistoryService.getOne(queryWrapper);
        if (b == null){
            Brosehistory brosehistory = new Brosehistory();
            brosehistory.setDate(reqVO.getDate());
            brosehistory.setHistory(reqVO.getHistory());
            brosehistory.setUserid(reqVO.getUserid());
            iBrosehistoryService.save(brosehistory);
            return Result.success("新增浏览历史成功");
        }
        else {
            return Result.error("记录已存在");
        }

    }

}
