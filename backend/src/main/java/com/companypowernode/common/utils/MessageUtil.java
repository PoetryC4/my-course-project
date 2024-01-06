package com.companypowernode.common.utils;

import com.aliyun.dysmsapi20170525.Client;
import com.aliyun.dysmsapi20170525.models.SendSmsRequest;
import com.aliyun.dysmsapi20170525.models.SendSmsResponse;
import com.aliyun.teaopenapi.models.Config;
import com.aliyuncs.CommonRequest;
import com.aliyuncs.CommonResponse;
import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.http.MethodType;
import com.aliyuncs.http.ProtocolType;
import com.aliyuncs.profile.DefaultProfile;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.rmi.ServerException;

/**
 * @author liyue
 * @since 2023-12-09
 */
@Component
public class MessageUtil {
    @Value("${aliyun.ALIBABA_CLOUD_ACCESS_KEY_ID}")
    public String AccessId;
    @Value("${aliyun.ALIBABA_CLOUD_ACCESS_KEY_SECRET}")
    public String AccessKey;
    public String SendMessage(String phone,String code) {
        DefaultProfile profile = DefaultProfile.getProfile("cn-hangzhou", AccessId, AccessKey);

        IAcsClient client = new DefaultAcsClient(profile);

        String param = "{\"code\":\"" + code + "\"}";
        CommonRequest request = new CommonRequest();
        request.setSysProtocol(ProtocolType.HTTP);
        request.setSysMethod(MethodType.POST);
        request.setSysDomain("dysmsapi.aliyuncs.com");
        request.setSysVersion("2017-05-25");
        request.setSysAction("SendSms");
        request.putQueryParameter("RegionId", "cn-hangzhou");
        request.putQueryParameter("PhoneNumbers", phone);
        request.putQueryParameter("SignName", "eco系统通知");
        request.putQueryParameter("TemplateCode", "SMS_464180328");
        request.putQueryParameter("TemplateParam", param);

        try {
            CommonResponse response = client.getCommonResponse(request);
            System.out.println(new Gson().toJson(response));
            return "短信发送成功";
        } catch (ClientException e) {
            System.out.println("ErrCode:" + e.getErrCode());
            System.out.println("ErrMsg:" + e.getErrMsg());
            System.out.println("RequestId:" + e.getRequestId());
        }
        return "短信发送失败";
    }

}
