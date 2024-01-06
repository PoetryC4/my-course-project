package com.companypowernode.controller;

import com.companypowernode.dao.vo.baseVO.Result;
import com.companypowernode.dao.entity.RealtimeQuotes;
import com.companypowernode.service.IRealtimeQuotesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 *  实时股票信息
 * </p>
 *
 * @author ly
 * @since 2023-03-21
 */
@RestController
@RequestMapping("/sys/realtimeQuotes")
public class RealtimeQuotesController {
    @Autowired
    private IRealtimeQuotesService iRealtimeQuotesService;


    @PostMapping("/show")
    public Result<RealtimeQuotes> show(@RequestParam String tsCode){
        RealtimeQuotes realtimeQuotes = new RealtimeQuotes();
        realtimeQuotes=iRealtimeQuotesService.getById(tsCode);
        return Result.success(realtimeQuotes);
    }

}
