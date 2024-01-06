package com.companypowernode.component;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.companypowernode.dao.vo.reqVO.NoticeWebsocketResp;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.websocket.*;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @author liyue
 * @since 2023-9-17
 */
@Slf4j
@Component
@ServerEndpoint("/websocket/{userId}")
public class WebSocketService {
    //记录当前连接数
    public static final Map<String, Session> sessionMap = new ConcurrentHashMap<>();

    private Session session;

    private String userId;

    private static CopyOnWriteArrayList<WebSocketService> webSockets = new CopyOnWriteArrayList<WebSocketService>();

    private static ConcurrentHashMap<String, Session> sessionPool = new ConcurrentHashMap<>();

    private String sid;
    public static Map<String, Set<String>> conns = new ConcurrentHashMap<>();//userid关联sid

    /**
     * 开启连接
     * @param session
     * @param userId
     */
    @OnOpen
    public void onOpen(Session session, @PathParam(value = "userId")String userId){

        //记录客户端连接数
        //sessionPool.put(userId,session);
        sessionMap.put(userId,session);
        log.info("用户" + userId + "加入，当前在线总人数：" + sessionMap.size());

        JSONObject result = new JSONObject();
        JSONArray array = new JSONArray();
        result.put("users",array);
        //建立用户列表
        for (Object key: sessionPool.keySet()){
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("userId",key);
            array.add(jsonObject);
        }
    }

    /**
     * 关闭连接
     */
    @OnClose
    public void onClose(){
        try{
            //sessionPool.remove(this.userId);
            sessionMap.remove(this.userId);
            log.info("连接断开，剩余："+ sessionMap.size());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 收到消息
     * @param msg
     */
    @OnMessage
    public String onMessage(String msg,Session session){
        return "提醒！！！";
    }

    @OnError
    public void onError(Throwable error){
        error.printStackTrace();
    }

    public static void sendMessage(String msg){
        NoticeWebsocketResp noticeWebsocketResp = new NoticeWebsocketResp();
        noticeWebsocketResp.setNoticeType(msg);
        sendMessage(noticeWebsocketResp);
    }

    public static void sendMessage(NoticeWebsocketResp noticeWebsocketResp){
        String msg = JSONObject.toJSONString(noticeWebsocketResp);
        for (Session session1:WebSocketService.sessionMap.values()){
            try {
                session1.getBasicRemote().sendText(msg);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    //检查是否连接
    public static boolean isServerClose(){
        if (WebSocketService.sessionMap.values().size()==0){
            log.info("连接已断开");
            return true;
        }
        else {
            log.info("已连接");
            return false;
        }
    }


}
