package com.companypowernode.sys.controller;
import com.companypowernode.common.Result;
import com.companypowernode.common.Tushare;
import com.companypowernode.sys.entity.TopListItem;
import com.companypowernode.sys.service.TopListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Date;

@RestController
@RequestMapping("/top")
public class TopListController {
    @Autowired
    private TopListService topListService;

    @GetMapping("/list")
    public String list(String tradeDate) {
        String topList = Tushare.tushareApi("top_list","trade_date="+tradeDate);
        return topList;
    }
}
