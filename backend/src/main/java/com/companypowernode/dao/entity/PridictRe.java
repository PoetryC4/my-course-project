package com.companypowernode.dao.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;

@TableName("pridict_re")
public class PridictRe implements Serializable {
    private static final long serialVersionUID = 1L;

    @TableId(value = "re_id",type = IdType.AUTO)
    private Integer reId;

    private String reDate;
    private Float reOpen;
    private Float reClose;
    private Float reHigh;
    private Float reLow;
    private String tsCode;



    public Integer getReId() {
        return reId;
    }

    public void setReId(Integer reId) {
        this.reId = reId;
    }

    public String getReDate() {
        return reDate;
    }

    public void setReDate(String reDate) {
        this.reDate = reDate;
    }

    public Float getReOpen() {
        return reOpen;
    }

    public void setReOpen(Float reOpen) {
        this.reOpen = reOpen;
    }

    public Float getReClose() {
        return reClose;
    }

    public void setReClose(Float reClose) {
        this.reClose = reClose;
    }

    public Float getReHigh() {
        return reHigh;
    }

    public void setReHigh(Float reHigh) {
        this.reHigh = reHigh;
    }

    public Float getReLow() {
        return reLow;
    }

    public void setReLow(Float reLow) {
        this.reLow = reLow;
    }

    public String getTsCode() {
        return tsCode;
    }

    public void setTsCode(String tsCode) {
        this.tsCode = tsCode;
    }

    @Override
    public String toString() {
        return "PridictRe{" +
                "reId=" + reId +
                ", reDate='" + reDate + '\'' +
                ", reOpen=" + reOpen +
                ", reClose=" + reClose +
                ", reHigh=" + reHigh +
                ", reLow=" + reLow +
                ", tsCode='" + tsCode + '\'' +
                '}';
    }
}
