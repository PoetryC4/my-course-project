package com.companypowernode.common.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

@Component
public class EmailUtil {
    @Value("${spring.mail.from}")
    private String from;

    @Autowired
    private JavaMailSender mailSender;

    public void SendMessage(String to,String subject,String text){
        SimpleMailMessage msg = new SimpleMailMessage();
        msg.setFrom(from);//发送方
        msg.setTo(to);//接收方
        msg.setSubject(subject);//主题
        msg.setText(text);//正文

        mailSender.send(msg);
    }

}
