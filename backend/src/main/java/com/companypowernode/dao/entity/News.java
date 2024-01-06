package com.companypowernode.dao.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.time.LocalDate;

@TableName(value = "news")
public class News implements Serializable {

    private static final long serialVersionUID = 1L;



    private LocalDate datetime;
    private String content;
    private String title;

    @TableId(value = "news_id", type = IdType.AUTO)
    private Integer newsId;

    public Integer getNewsId() {
        return newsId;
    }

    public void setNewsId(Integer newsId) {
        this.newsId = newsId;
    }

    public LocalDate getDatetime() {
        return datetime;
    }

    public void setDatetime(LocalDate datetime) {
        this.datetime = datetime;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

//    public String getChannals() {
//        return channals;
//    }
//
//    public void setChannals(String channals) {
//        this.channals = channals;
//    }

    @Override
    public String toString() {
        return "News{" +
                "newsId=" + newsId +
                ", datetime=" + datetime +
                ", contents='" + content + '\'' +
                ", title='" + title + '\'' +
                '}';
    }
}

