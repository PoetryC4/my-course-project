package com.companypowernode.dao.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
@TableName(value = "search_history")
public class SearchHistory implements Serializable {

    @TableId(value = "s_id",type = IdType.AUTO)
    private Integer sId;
    private Integer userId;
    private String tsCode;
    private String tsName;
    private String sDate;

    public Integer getsId() {
        return sId;
    }

    public void setsId(Integer sId) {
        this.sId = sId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getTsCode() {
        return tsCode;
    }

    public void setTsCode(String tsCode) {
        this.tsCode = tsCode;
    }

    public String getTsName() {
        return tsName;
    }

    public void setTsName(String tsName) {
        this.tsName = tsName;
    }

    public String getsDate() {
        return sDate;
    }

    public void setsDate(String sDate) {
        this.sDate = sDate;
    }

    @Override
    public String toString() {
        return "SearchHistory{" +
                "sId=" + sId +
                ", userId=" + userId +
                ", tsCode='" + tsCode + '\'' +
                ", tsName='" + tsName + '\'' +
                ", sDate='" + sDate + '\'' +
                '}';
    }
}
