package com.companypowernode;

import com.aliyun.dysmsapi20170525.models.SendSmsRequest;
import com.aliyun.dysmsapi20170525.models.SendSmsResponse;
import com.aliyuncs.CommonRequest;
import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.profile.DefaultProfile;
import com.companypowernode.common.utils.HttpUtil;
import com.companypowernode.common.utils.MessageUtil;
import com.companypowernode.common.utils.Tushare;
import com.google.gson.Gson;
import org.apache.http.HttpEntity;
import org.apache.http.StatusLine;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import java.io.*;
import java.rmi.ServerException;

import static java.lang.Thread.sleep;

public class test1 {
    @Value("${aliyun.ALIBABA_CLOUD_ACCESS_KEY_ID}")
    String ALIBABA_CLOUD_ACCESS_KEY_ID;
    @Value("${aliyun.ALIBABA_CLOUD_ACCESS_KEY_SECRET}")
    String ALIBABA_CLOUD_ACCESS_KEY_SECRET;


    public static void main(String[] args) throws IOException {


        String path = "https://quote.eastmoney.com/sz300750.html";
        Document doc = Jsoup.connect(path).get();
        Element body = doc.body();

        System.out.println(body);



    }


    @Test
    public void testGet() throws Exception {
        while(true){
            String ts_code = "300750";
            //1.相当于打开浏览器
            CloseableHttpClient httpClient = HttpUtil.getHttpClient();
            //创建get对象
            HttpGet httpGet = new HttpGet("https://xueqiu.com/S/SZ"+ts_code);
            httpGet.setHeader("User-Agent","Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/75.0.3770.100 Safari/537.36");
            //执行请求
            CloseableHttpResponse response = httpClient.execute(httpGet);
            //接收结果
            HttpEntity entity = response.getEntity();
            String html = EntityUtils.toString(entity,"utf-8");
            Document doc = Jsoup.parseBodyFragment(html);
            Element body = doc.body();
            Elements result = body.getElementsByClass("stock-current");

            String stock_current = result.select("strong").text();
            stock_current = stock_current.replaceAll("¥","");
            System.out.println(stock_current);

            //打印结果
            //System.out.println(html);
            //关闭连接
            response.close();
            //System.out.println(1);
            Thread.sleep(5000);
        }


    }




    public static String toHtmlString(File file){
        StringBuffer htmlbuf = new StringBuffer();
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(
                    new FileInputStream(file),"unicode"
            ));
            while (reader.ready()){
                htmlbuf.append(reader.readLine());
            }
            reader.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        String htmlStr = htmlbuf.toString();
        return htmlStr;
    }
}
