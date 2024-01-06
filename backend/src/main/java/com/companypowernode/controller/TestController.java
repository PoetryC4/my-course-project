package com.companypowernode.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.companypowernode.common.utils.HttpUtil;
import com.companypowernode.common.utils.MessageUtil;
import com.companypowernode.common.utils.Tushare;
import com.companypowernode.component.WebSocketService;
import com.companypowernode.dao.entity.Alarm;
import com.companypowernode.dao.entity.FinalIndicator;
import com.companypowernode.dao.entity.UserInfo;
import com.companypowernode.dao.vo.reqVO.RevenueReqVO;
import com.companypowernode.dao.vo.respVO.RevenueRespVO;
import com.companypowernode.service.AlarmService;
import com.companypowernode.service.IFinalIndicatorService;
import com.companypowernode.service.IUserInfoService;
import com.companypowernode.service.IUserStockService;
import com.companypowernode.dao.vo.baseVO.Result;
import io.swagger.annotations.ApiOperation;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.util.EntityUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author liyue
 * @since 2025-9-25
 */
@RestController
@RequestMapping("/test")
public class TestController {

    @Autowired
    private IUserStockService iUserStockService;

    @Autowired
    private IFinalIndicatorService iFinalIndicatorService;

    @Autowired
    private MessageUtil messageUtil;
    @Autowired
    private AlarmService alarmService;



    @Autowired
    private IUserInfoService userInfoService;
    //@PostMapping("/get")
    //public Result<Map<String,String>> getStockInfo(){

        //自选股所有当天日线
//        List<String> list = iUserStockService.getTsCodeList();
//        StringBuilder args = new StringBuilder("ts_code=");
//        for (String s: list){
//            args.append(s);
//            args.append(",");
//        }
//
//        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
//        String date = "trade_date=" + simpleDateFormat.format(new Date());
//
//        date = date.replaceAll("-","");
//
//        String jsondata = Tushare.tushareApi("daily", args.toString(),date);
//
//        JSONObject jsonObject = JSON.parseObject(jsondata);
//
//
//
//
//        Map<String,String> req = new HashMap<>();
//        req.put("sucess",jsondata);
//
//
//        return Result.success(req);
   // }

    @GetMapping("/testweb")
    public String webtest(){
        WebSocketService.sendMessage("hello");
        return "OK";
    }

    @PostMapping("/getRevenue")
    @ApiOperation(value = "获得每股营业收入")
    public Result<RevenueRespVO> getRevenue(@RequestBody RevenueReqVO reqVO){
        LambdaQueryWrapper<FinalIndicator> wrapper = new LambdaQueryWrapper<>();
        wrapper.ge(FinalIndicator::getAnnData,reqVO.getStartTime());
        wrapper.le(FinalIndicator::getAnnData,reqVO.getEndTime());
        List<FinalIndicator> list = iFinalIndicatorService.list(wrapper);
        RevenueRespVO respVO = new RevenueRespVO();
        respVO.setList(list);
        return Result.success(respVO);
    }

    @GetMapping
    public Result<String> sendMsg(){
        List<Alarm> list = alarmService.list();
        for (Alarm a:list) {
            //TODO 获取实时信息
            String ts_code = a.getTsCode().replaceAll(".SZ","");
            //String ts_code = "300750";
            //1.相当于打开浏览器
            CloseableHttpClient httpClient = null;
            try {
                httpClient = HttpUtil.getHttpClient();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
            //创建get对象
            HttpGet httpGet = new HttpGet("https://xueqiu.com/S/SZ"+ts_code);
            httpGet.setHeader("User-Agent","Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/75.0.3770.100 Safari/537.36");
            //执行请求
            CloseableHttpResponse response = null;
            try {
                response = httpClient.execute(httpGet);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            //接收结果
            HttpEntity entity = response.getEntity();
            String html = null;
            try {
                html = EntityUtils.toString(entity,"utf-8");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            Document doc = Jsoup.parseBodyFragment(html);
            Element body = doc.body();
            Elements result = body.getElementsByClass("stock-current");

            String stock_current = result.select("strong").text();
            stock_current = stock_current.replaceAll("¥","");
            //打印结果
            System.out.println(stock_current);
            //关闭连接
            try {
                response.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            Float stock_c = Float.valueOf(stock_current);
            //用户
            LambdaQueryWrapper<UserInfo> wrapper = new LambdaQueryWrapper<>();
            wrapper.eq(UserInfo::getUserId,a.getUserId());
            UserInfo info = userInfoService.getOne(wrapper);
            //比较
            if (a.getHigh()<stock_c|| a.getLow()>stock_c){
                messageUtil.SendMessage(info.getPhone(),ts_code);
            }
        }

        return Result.success("ok");
    }

}
