package com.companypowernode.sync;

import com.aliyun.dysmsapi20170525.models.SendSmsRequest;
import com.aliyun.teautil.models.RuntimeOptions;
import com.companypowernode.common.utils.Tushare;
import com.companypowernode.service.IDailyService;
import com.companypowernode.service.IUserStockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @author liyue
 * @since 2023-9-17
 */
@Component
public class AlarmSchedule {

    @Autowired
    private RedisTemplate redisTemplate;

    @Autowired
    private IUserStockService iUserStockService;



    @Scheduled(cron = "0/1 * * * * ?")
    public Map<String,String> getStockInfo(){

        //自选股所有当天日线
//        List<String> list = iUserStockService.getTsCodeList();
//        StringBuilder args = new StringBuilder("ts_code=");
//        for (String s: list){
//            args.append(s);
//            args.append(",");
//        }
//
//        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
////        String date = "trade_date=" + simpleDateFormat.format(new Date());
//        String date = "trade_date=20230925";
//
//        date.replaceAll("-","");
//
//        String data = Tushare.tushareApi("daily", args.toString(),date);
//
//        //创建短信请求对象
//        SendSmsRequest sendSmsRequest = new SendSmsRequest();
//        RuntimeOptions runtimeOptions = new RuntimeOptions();
//
//        //发请求
//
//
       return null;
    }

}
