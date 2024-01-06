package com.example.finance.api;

import com.alibaba.fastjson.JSON;
import com.example.finance.common.Conn;
import com.example.finance.common.R;
import com.example.finance.utils.GetURLContent;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class AlarmApi {

    public static String BASE_URL="http://"+ Conn.ipAddrHost+":"+Conn.ipAddrPort +"/sys/alarm/";

    static class ThreadAlarm_2 extends Thread{
        Integer a;
        String resStr;
        String[] parameters;
        String[] values;
        String mapping;
        String method;

        public ThreadAlarm_2(String[] parameters, String[] values, String mapping, String method){
            this.parameters = parameters;
            this.values = values;
            this.mapping = mapping;
            this.method = method;
        }

        @Override

        public void run(){
            StringBuilder url = new StringBuilder(BASE_URL + mapping + "?");
            for (int i = 0; i < parameters.length; i++) {
                url.append(parameters[i]);
                url.append("=");
                url.append(values[i]);
                if(i != parameters.length - 1) url.append("&");
            }
            System.out.println("url:"+url);
            resStr = GetURLContent.getContent(url.toString(),this.method);
            //System.out.println("resStr:"+resStr);
            a = 1;
        }
    }
    static class ThreadAlarm extends Thread{
        Integer a;
        String resStr;
        List<String> parameters;
        List<Object> values;
        String mapping;
        String method;

        public ThreadAlarm(List<String> parameters, List<Object> values, String mapping, String method){
            this.parameters = parameters;
            this.values = values;
            this.mapping = mapping;
            this.method = method;
        }

        @Override

        public void run(){
            resStr = GetURLContent.RequestWithBody("http","10.0.2.2","9999","/sys/alarm/"+mapping,parameters,values);
            //System.out.println("resStr:"+resStr);
            a = 1;
        }
    }

    public static R<Object> AddAlarm(String tsCode, Double low,Double change,String userId) throws IOException, InterruptedException {
        List<String> parameters = new ArrayList<>();
        List<Object> values = new ArrayList<>();
        parameters.add("userId");
        parameters.add("low");
        parameters.add("change");
        parameters.add("tsCode");
        values.add(userId);
        values.add(low);
        values.add(change);
        values.add(tsCode);
        System.out.println(parameters);
        System.out.println(values);
        ThreadAlarm tt=new ThreadAlarm(parameters,values,"InsertOrUpdate","POST");
        tt.start();
        while(tt.a==null){
            Thread.sleep(100);
        }
        if (Objects.equals("E", tt.resStr)) return R.error("获取错误!");
        Map map = JSON.parseObject(tt.resStr,Map.class);
        if(!map.containsKey("code") || (Integer) map.get("code")==0) {
            return R.error("获取错误!");
        }
        return R.success(map.get("data"));
    }

    /*public static R<Object> GetTopicById(String topicId) throws IOException, InterruptedException {
        List<String> parameters = new ArrayList<>();
        List<Object> values = new ArrayList<>();
        parameters.add("id");
        values.add(topicId);
        ThreadTopic tt=new ThreadTopic(parameters,values,"getone","GET");
        tt.start();
        while(tt.a==null){
            Thread.sleep(100);
        }
        if (Objects.equals("E", tt.resStr)) return R.error("获取错误!");
        Map map = JSON.parseObject(tt.resStr,Map.class);
        if(!map.containsKey("code") || (Integer) map.get("code")==0) {
            return R.error("获取错误!");
        }
        return R.success(map.get("data"));
    }*/

    public static R<Object> GetAlarm(String userId) throws IOException, InterruptedException {
        List<String> parameters = new ArrayList<>();
        List<String> values = new ArrayList<>();
        parameters.add("userId");
        values.add(userId);
        ThreadAlarm_2 tt=new ThreadAlarm_2(parameters.toArray(new String[0]),values.toArray(new String[0]),"info","POST");
        tt.start();
        while(tt.a==null){
            Thread.sleep(100);
        }
        if (Objects.equals("E", tt.resStr)) return R.error("获取错误!");
        Map map = JSON.parseObject(tt.resStr,Map.class);
        if(!map.containsKey("code") || (Integer) map.get("code")==0) {
            return R.error("获取错误!");
        }
        return R.success(map.get("data"));
    }
}
