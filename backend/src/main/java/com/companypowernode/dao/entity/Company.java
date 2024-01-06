package com.companypowernode.dao.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;

import java.io.Serializable;
import java.time.LocalDate;

/**
 * <p>
 * info of a company
 * </p>
 *
 * @author ly
 * @since 2023-03-21
 */
public class Company implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "ts_code", type = IdType.AUTO)
    private String tsCode;

    private String balTsCode;

    private String incTsCode;

    private String exchangeCode;

    private String chairman;

    private String manager;

    private String secretary;

    private Float regCapital;

    private LocalDate setupDate;

    private String province;

    private String city;

    private String introduction;

    private String website;

    private String email;

    private String ofiice;

    public String getTsCode() {
        return tsCode;
    }

    public void setTsCode(String tsCode) {
        this.tsCode = tsCode;
    }
    public String getBalTsCode() {
        return balTsCode;
    }

    public void setBalTsCode(String balTsCode) {
        this.balTsCode = balTsCode;
    }
    public String getIncTsCode() {
        return incTsCode;
    }

    public void setIncTsCode(String incTsCode) {
        this.incTsCode = incTsCode;
    }
    public String getExchangeCode() {
        return exchangeCode;
    }

    public void setExchangeCode(String exchangeCode) {
        this.exchangeCode = exchangeCode;
    }
    public String getChairman() {
        return chairman;
    }

    public void setChairman(String chairman) {
        this.chairman = chairman;
    }
    public String getManager() {
        return manager;
    }

    public void setManager(String manager) {
        this.manager = manager;
    }
    public String getSecretary() {
        return secretary;
    }

    public void setSecretary(String secretary) {
        this.secretary = secretary;
    }
    public Float getRegCapital() {
        return regCapital;
    }

    public void setRegCapital(Float regCapital) {
        this.regCapital = regCapital;
    }
    public LocalDate getSetupDate() {
        return setupDate;
    }

    public void setSetupDate(LocalDate setupDate) {
        this.setupDate = setupDate;
    }
    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }
    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }
    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    public String getOfiice() {
        return ofiice;
    }

    public void setOfiice(String ofiice) {
        this.ofiice = ofiice;
    }

    @Override
    public String toString() {
        return "Company{" +
            "tsCode=" + tsCode +
            ", balTsCode=" + balTsCode +
            ", incTsCode=" + incTsCode +
            ", exchangeCode=" + exchangeCode +
            ", chairman=" + chairman +
            ", manager=" + manager +
            ", secretary=" + secretary +
            ", regCapital=" + regCapital +
            ", setupDate=" + setupDate +
            ", province=" + province +
            ", city=" + city +
            ", introduction=" + introduction +
            ", website=" + website +
            ", email=" + email +
            ", ofiice=" + ofiice +
        "}";
    }
}
