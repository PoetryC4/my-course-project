package com.companypowernode.component;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.companypowernode.common.utils.HttpUtil;
import com.companypowernode.common.utils.MessageUtil;
import com.companypowernode.common.utils.SpringUtil;
import com.companypowernode.common.utils.Tushare;
import com.companypowernode.dao.entity.Alarm;
import com.companypowernode.dao.entity.UserInfo;
import com.companypowernode.dao.entity.UserStock;
import com.companypowernode.service.AlarmService;
import com.companypowernode.service.IUserInfoService;
import com.companypowernode.service.IUserStockService;
import com.sun.xml.bind.v2.TODO;
import io.swagger.models.auth.In;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.util.EntityUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Date;
import java.util.List;

/**
 * @author liyue
 * @since 2023-12-09
 */
@Service
public class QJob implements Job {


    private AlarmService alarmService;


    private MessageUtil messageUtil;

    private IUserInfoService userInfoService;
    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        System.out.println("send message");
        alarmService = SpringUtil.getBean(AlarmService.class);
        userInfoService = SpringUtil.getBean(IUserInfoService.class);
        messageUtil = SpringUtil.getBean(MessageUtil.class);

        List<Alarm> list = alarmService.list();
        for (Alarm a:list) {

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

            //用户
            LambdaQueryWrapper<UserInfo> wrapper = new LambdaQueryWrapper<>();
            wrapper.eq(UserInfo::getUserId,a.getUserId());
            UserInfo info = userInfoService.getOne(wrapper);
            Float stock_c = Float.valueOf(stock_current);
            //比较
            if (a.getHigh()<stock_c|| a.getLow()>stock_c){
                messageUtil.SendMessage(info.getPhone(),ts_code);
            }
        }

    }
}
