package com.companypowernode.dao.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.time.LocalDate;

/**
 * <p>
 * 
 * </p>
 *
 * @author ly
 * @since 2023-03-21
 */
@TableName("final_indicator")
public class FinalIndicator implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "ts_code", type = IdType.AUTO)
    private String tsCode;

    private String symbol;

    private LocalDate annData;

    private LocalDate ennData;

    private Float eps;

    private Float bps;

    private Float ocfps;

    private Float grossproMargin;

    private Float revenuePs;

    private Float roe;

    private Float qRoe;

    private Float proDebt;

    private Float opIncome;

    public String getTsCode() {
        return tsCode;
    }

    public void setTsCode(String tsCode) {
        this.tsCode = tsCode;
    }
    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }
    public LocalDate getAnnData() {
        return annData;
    }

    public void setAnnData(LocalDate annData) {
        this.annData = annData;
    }
    public LocalDate getEnnData() {
        return ennData;
    }

    public void setEnnData(LocalDate ennData) {
        this.ennData = ennData;
    }
    public Float getEps() {
        return eps;
    }

    public void setEps(Float eps) {
        this.eps = eps;
    }
    public Float getBps() {
        return bps;
    }

    public void setBps(Float bps) {
        this.bps = bps;
    }
    public Float getOcfps() {
        return ocfps;
    }

    public void setOcfps(Float ocfps) {
        this.ocfps = ocfps;
    }
    public Float getGrossproMargin() {
        return grossproMargin;
    }

    public void setGrossproMargin(Float grossproMargin) {
        this.grossproMargin = grossproMargin;
    }
    public Float getRevenuePs() {
        return revenuePs;
    }

    public void setRevenuePs(Float revenuePs) {
        this.revenuePs = revenuePs;
    }
    public Float getRoe() {
        return roe;
    }

    public void setRoe(Float roe) {
        this.roe = roe;
    }
    public Float getqRoe() {
        return qRoe;
    }

    public void setqRoe(Float qRoe) {
        this.qRoe = qRoe;
    }
    public Float getProDebt() {
        return proDebt;
    }

    public void setProDebt(Float proDebt) {
        this.proDebt = proDebt;
    }
    public Float getOpIncome() {
        return opIncome;
    }

    public void setOpIncome(Float opIncome) {
        this.opIncome = opIncome;
    }

    @Override
    public String toString() {
        return "FinalIndicator{" +
            "tsCode=" + tsCode +
            ", symbol=" + symbol +
            ", annData=" + annData +
            ", ennData=" + ennData +
            ", eps=" + eps +
            ", bps=" + bps +
            ", ocfps=" + ocfps +
            ", grossproMargin=" + grossproMargin +
            ", revenuePs=" + revenuePs +
            ", roe=" + roe +
            ", qRoe=" + qRoe +
            ", proDebt=" + proDebt +
            ", opIncome=" + opIncome +
        "}";
    }
}
