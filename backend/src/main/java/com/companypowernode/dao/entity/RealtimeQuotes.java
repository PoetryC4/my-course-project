package com.companypowernode.dao.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author ly
 * @since 2023-03-21
 */
@TableName("realtime_quotes")
public class RealtimeQuotes implements Serializable {

    private static final long serialVersionUID = 1L;

    private String name;

    private String open;

    private String preClose;

    private String price;

    private String high;

    private String low;

    private String bid;

    private String ask;

    private String volume;

    private String amount;

    private String b1V;

    private String b1P;

    private String b2V;

    private String b2P;

    private String b3V;

    private String b3P;

    private String b4V;

    private String b4P;

    private String b5V;

    private String b5P;

    private String a1V;

    private String a1P;

    private String a2V;

    private String a2P;

    private String a3V;

    private String a3P;

    private String a4V;

    private String a4P;

    private String a5V;

    private String a5P;

    private String date;

    private String time;

    private String code;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public String getOpen() {
        return open;
    }

    public void setOpen(String open) {
        this.open = open;
    }
    public String getPreClose() {
        return preClose;
    }

    public void setPreClose(String preClose) {
        this.preClose = preClose;
    }
    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
    public String getHigh() {
        return high;
    }

    public void setHigh(String high) {
        this.high = high;
    }
    public String getLow() {
        return low;
    }

    public void setLow(String low) {
        this.low = low;
    }
    public String getBid() {
        return bid;
    }

    public void setBid(String bid) {
        this.bid = bid;
    }
    public String getAsk() {
        return ask;
    }

    public void setAsk(String ask) {
        this.ask = ask;
    }
    public String getVolume() {
        return volume;
    }

    public void setVolume(String volume) {
        this.volume = volume;
    }
    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }
    public String getb1V() {
        return b1V;
    }

    public void setb1V(String b1V) {
        this.b1V = b1V;
    }
    public String getb1P() {
        return b1P;
    }

    public void setb1P(String b1P) {
        this.b1P = b1P;
    }
    public String getb2V() {
        return b2V;
    }

    public void setb2V(String b2V) {
        this.b2V = b2V;
    }
    public String getb2P() {
        return b2P;
    }

    public void setb2P(String b2P) {
        this.b2P = b2P;
    }
    public String getb3V() {
        return b3V;
    }

    public void setb3V(String b3V) {
        this.b3V = b3V;
    }
    public String getb3P() {
        return b3P;
    }

    public void setb3P(String b3P) {
        this.b3P = b3P;
    }
    public String getb4V() {
        return b4V;
    }

    public void setb4V(String b4V) {
        this.b4V = b4V;
    }
    public String getb4P() {
        return b4P;
    }

    public void setb4P(String b4P) {
        this.b4P = b4P;
    }
    public String getb5V() {
        return b5V;
    }

    public void setb5V(String b5V) {
        this.b5V = b5V;
    }
    public String getb5P() {
        return b5P;
    }

    public void setb5P(String b5P) {
        this.b5P = b5P;
    }
    public String geta1V() {
        return a1V;
    }

    public void seta1V(String a1V) {
        this.a1V = a1V;
    }
    public String geta1P() {
        return a1P;
    }

    public void seta1P(String a1P) {
        this.a1P = a1P;
    }
    public String geta2V() {
        return a2V;
    }

    public void seta2V(String a2V) {
        this.a2V = a2V;
    }
    public String geta2P() {
        return a2P;
    }

    public void seta2P(String a2P) {
        this.a2P = a2P;
    }
    public String geta3V() {
        return a3V;
    }

    public void seta3V(String a3V) {
        this.a3V = a3V;
    }
    public String geta3P() {
        return a3P;
    }

    public void seta3P(String a3P) {
        this.a3P = a3P;
    }
    public String geta4V() {
        return a4V;
    }

    public void seta4V(String a4V) {
        this.a4V = a4V;
    }
    public String geta4P() {
        return a4P;
    }

    public void seta4P(String a4P) {
        this.a4P = a4P;
    }
    public String geta5V() {
        return a5V;
    }

    public void seta5V(String a5V) {
        this.a5V = a5V;
    }
    public String geta5P() {
        return a5P;
    }

    public void seta5P(String a5P) {
        this.a5P = a5P;
    }
    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Override
    public String toString() {
        return "RealtimeQuotes{" +
            "name=" + name +
            ", open=" + open +
            ", preClose=" + preClose +
            ", price=" + price +
            ", high=" + high +
            ", low=" + low +
            ", bid=" + bid +
            ", ask=" + ask +
            ", volume=" + volume +
            ", amount=" + amount +
            ", b1V=" + b1V +
            ", b1P=" + b1P +
            ", b2V=" + b2V +
            ", b2P=" + b2P +
            ", b3V=" + b3V +
            ", b3P=" + b3P +
            ", b4V=" + b4V +
            ", b4P=" + b4P +
            ", b5V=" + b5V +
            ", b5P=" + b5P +
            ", a1V=" + a1V +
            ", a1P=" + a1P +
            ", a2V=" + a2V +
            ", a2P=" + a2P +
            ", a3V=" + a3V +
            ", a3P=" + a3P +
            ", a4V=" + a4V +
            ", a4P=" + a4P +
            ", a5V=" + a5V +
            ", a5P=" + a5P +
            ", date=" + date +
            ", time=" + time +
            ", code=" + code +
        "}";
    }
}
