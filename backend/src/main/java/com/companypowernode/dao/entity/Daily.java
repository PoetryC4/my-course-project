package com.companypowernode.dao.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;

import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author ly
 * @since 2023-03-21
 */
public class Daily implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "dailyid", type = IdType.AUTO)
    private Integer dailyid;

    private String tsCode;

    private String tradeDate;

    private Float open;

    private Float high;

    private Float low;

    private Float close;

    private Float preClose;

    private Float changes;

    private Float pctChg;

    private Float vol;

    private Float amount;

    public Integer getDailyid() {
        return dailyid;
    }

    public void setDailyid(Integer dailyid) {
        this.dailyid = dailyid;
    }

    public Float getChanges() {
        return changes;
    }

    public void setChanges(Float changes) {
        this.changes = changes;
    }

    public String getTsCode() {
        return tsCode;
    }

    public String getTradeDate() {
        return tradeDate;
    }

    public void setTradeDate(String tradeDate) {
        this.tradeDate = tradeDate;
    }

    public void setTsCode(String tsCode) {
        this.tsCode = tsCode;
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
        return changes;
    }

    public void setChange(Float change) {
        this.changes = change;
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
        return "Daily{" +
                "dailyid=" + dailyid +
                ", tsCode='" + tsCode + '\'' +
                ", tradeDate=" + tradeDate +
                ", open=" + open +
                ", high=" + high +
                ", low=" + low +
                ", close=" + close +
                ", preClose=" + preClose +
                ", changes=" + changes +
                ", pctChg=" + pctChg +
                ", vol=" + vol +
                ", amount=" + amount +
                '}';
    }
}
