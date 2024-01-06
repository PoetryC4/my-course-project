package com.companypowernode.dao.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;

import java.io.Serializable;
import java.time.LocalDate;

public class Monthly implements Serializable {
    private static final long serialVersionUID = 1L;

    @TableId(value = "ts_code", type = IdType.AUTO)
    private String tsCode;

    private LocalDate tradeDate;

    private Float open;

    private Float high;

    private Float low;

    private Float close;

    private Float preClose;

    private Float change;

    private Float pctChg;

    private Float vol;

    private Float amount;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getTsCode() {
        return tsCode;
    }

    public void setTsCode(String tsCode) {
        this.tsCode = tsCode;
    }

    public LocalDate getTradeDate() {
        return tradeDate;
    }

    public void setTradeDate(LocalDate tradeDate) {
        this.tradeDate = tradeDate;
    }

    public Float getOpen() {
        return open;
    }

    public void setOpen(Float open) {
        this.open = open;
    }

    public Float getHigh() {
        return high;
    }

    public void setHigh(Float high) {
        this.high = high;
    }

    public Float getLow() {
        return low;
    }

    public void setLow(Float low) {
        this.low = low;
    }

    public Float getClose() {
        return close;
    }

    public void setClose(Float close) {
        this.close = close;
    }

    public Float getPreClose() {
        return preClose;
    }

    public void setPreClose(Float preClose) {
        this.preClose = preClose;
    }

    public Float getChange() {
        return change;
    }

    public void setChange(Float change) {
        this.change = change;
    }

    public Float getPctChg() {
        return pctChg;
    }

    public void setPctChg(Float pctChg) {
        this.pctChg = pctChg;
    }

    public Float getVol() {
        return vol;
    }

    public void setVol(Float vol) {
        this.vol = vol;
    }

    public Float getAmount() {
        return amount;
    }

    public void setAmount(Float amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "Monthly{" +
                "tsCode='" + tsCode + '\'' +
                ", tradeDate=" + tradeDate +
                ", open=" + open +
                ", high=" + high +
                ", low=" + low +
                ", close=" + close +
                ", preClose=" + preClose +
                ", change=" + change +
                ", pctChg=" + pctChg +
                ", vol=" + vol +
                ", amount=" + amount +
                '}';
    }
}
