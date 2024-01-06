package com.companypowernode.dao.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * <p>
 * 利润表
 * </p>
 *
 * @author anchor
 * @since 2023-06-08
 */
public class Income implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "股票代码")
    private String tsCode;

    private String annDate;

    private String fAnnDate;

    private String endDate;

    private String reportType;

    private String compType;

    @ApiModelProperty(value = "1代表一季度，2代表中报，3代表三季度，4代表年报")
    private String endType;

    private Double basicEps;

    private Double dilutedEps;

    private Double totalRevenue;

    private Double revenue;

    private Double intIncome;

    private Double premEarned;

    private Double commIncome;

    private Double nCommisIncome;

    private Double nOthIncome;

    private Double nOthBIncome;

    private Double premIncome;

    private Double outPrem;

    private Double unePremReser;

    private Double reinsIncome;

    private Double nSecTbIncome;

    private Double nSecUwIncome;

    private Double nAssetMgIncome;

    private Double othBIncome;

    private Double fvValueChgGain;

    private Double investIncome;

    private Double assInvestIncome;

    private Double forexGain;

    private Double totalCogs;

    private Double operCost;

    private Double intExp;

    private Double commExp;

    private Double bizTaxSurchg;

    private Double sellExp;

    private Double adminExp;

    private Double finExp;

    private Double assetsImpairLoss;

    private Double premRefund;

    private Double compensPayout;

    private Double reserInsurLiab;

    private Double divPayt;

    private Double reinsExp;

    private Double operExp;

    private Double compensPayoutRefu;

    private Double insurReserRefu;

    private Double reinsCostRefund;

    private Double otherBusCost;

    private Double operateProfit;

    private Double nonOperIncome;

    private Double nonOperExp;

    private Double ncaDisploss;

    private Double totalProfit;

    private Double incomeTax;

    private Double nIncome;

    private Double nIncomeAttrP;

    private Double minorityGain;

    private Double othComprIncome;

    private Double tComprIncome;

    private Double comprIncAttrP;

    private Double comprIncAttrMS;

    private Double ebit;

    private Double ebitda;

    private Double insuranceExp;

    private Double undistProfit;

    private Double distableProfit;

    private Double rdExp;

    private Double finExpIntExp;

    private Double finExpIntInc;

    private Double transferSurplusRese;

    private Double transferHousingImprest;

    private Double transferOth;

    private Double adjLossgain;

    private Double withdraLegalSurplus;

    private Double withdraLegalPubfund;

    private Double withdraBizDevfund;

    private Double withdraReseFund;

    private Double withdraOthErsu;

    private Double workersWelfare;

    private Double distrProfitShrhder;

    private Double prfsharePayableDvd;

    private Double comsharePayableDvd;

    private Double capitComstockDiv;

    private Double continuedNetProfit;

    private String updateFlag;

    @TableId(value = "income_id", type = IdType.AUTO)
    private Integer incomeId;

    public String getTsCode() {
        return tsCode;
    }

    public void setTsCode(String tsCode) {
        this.tsCode = tsCode;
    }
    public String getAnnDate() {
        return annDate;
    }

    public void setAnnDate(String annDate) {
        this.annDate = annDate;
    }
    public String getfAnnDate() {
        return fAnnDate;
    }

    public void setfAnnDate(String fAnnDate) {
        this.fAnnDate = fAnnDate;
    }
    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }
    public String getReportType() {
        return reportType;
    }

    public void setReportType(String reportType) {
        this.reportType = reportType;
    }
    public String getCompType() {
        return compType;
    }

    public void setCompType(String compType) {
        this.compType = compType;
    }
    public String getEndType() {
        return endType;
    }

    public void setEndType(String endType) {
        this.endType = endType;
    }
    public Double getBasicEps() {
        return basicEps;
    }

    public void setBasicEps(Double basicEps) {
        this.basicEps = basicEps;
    }
    public Double getDilutedEps() {
        return dilutedEps;
    }

    public void setDilutedEps(Double dilutedEps) {
        this.dilutedEps = dilutedEps;
    }
    public Double getTotalRevenue() {
        return totalRevenue;
    }

    public void setTotalRevenue(Double totalRevenue) {
        this.totalRevenue = totalRevenue;
    }
    public Double getRevenue() {
        return revenue;
    }

    public void setRevenue(Double revenue) {
        this.revenue = revenue;
    }
    public Double getIntIncome() {
        return intIncome;
    }

    public void setIntIncome(Double intIncome) {
        this.intIncome = intIncome;
    }
    public Double getPremEarned() {
        return premEarned;
    }

    public void setPremEarned(Double premEarned) {
        this.premEarned = premEarned;
    }
    public Double getCommIncome() {
        return commIncome;
    }

    public void setCommIncome(Double commIncome) {
        this.commIncome = commIncome;
    }
    public Double getnCommisIncome() {
        return nCommisIncome;
    }

    public void setnCommisIncome(Double nCommisIncome) {
        this.nCommisIncome = nCommisIncome;
    }
    public Double getnOthIncome() {
        return nOthIncome;
    }

    public void setnOthIncome(Double nOthIncome) {
        this.nOthIncome = nOthIncome;
    }
    public Double getnOthBIncome() {
        return nOthBIncome;
    }

    public void setnOthBIncome(Double nOthBIncome) {
        this.nOthBIncome = nOthBIncome;
    }
    public Double getPremIncome() {
        return premIncome;
    }

    public void setPremIncome(Double premIncome) {
        this.premIncome = premIncome;
    }
    public Double getOutPrem() {
        return outPrem;
    }

    public void setOutPrem(Double outPrem) {
        this.outPrem = outPrem;
    }
    public Double getUnePremReser() {
        return unePremReser;
    }

    public void setUnePremReser(Double unePremReser) {
        this.unePremReser = unePremReser;
    }
    public Double getReinsIncome() {
        return reinsIncome;
    }

    public void setReinsIncome(Double reinsIncome) {
        this.reinsIncome = reinsIncome;
    }
    public Double getnSecTbIncome() {
        return nSecTbIncome;
    }

    public void setnSecTbIncome(Double nSecTbIncome) {
        this.nSecTbIncome = nSecTbIncome;
    }
    public Double getnSecUwIncome() {
        return nSecUwIncome;
    }

    public void setnSecUwIncome(Double nSecUwIncome) {
        this.nSecUwIncome = nSecUwIncome;
    }
    public Double getnAssetMgIncome() {
        return nAssetMgIncome;
    }

    public void setnAssetMgIncome(Double nAssetMgIncome) {
        this.nAssetMgIncome = nAssetMgIncome;
    }
    public Double getOthBIncome() {
        return othBIncome;
    }

    public void setOthBIncome(Double othBIncome) {
        this.othBIncome = othBIncome;
    }
    public Double getFvValueChgGain() {
        return fvValueChgGain;
    }

    public void setFvValueChgGain(Double fvValueChgGain) {
        this.fvValueChgGain = fvValueChgGain;
    }
    public Double getInvestIncome() {
        return investIncome;
    }

    public void setInvestIncome(Double investIncome) {
        this.investIncome = investIncome;
    }
    public Double getAssInvestIncome() {
        return assInvestIncome;
    }

    public void setAssInvestIncome(Double assInvestIncome) {
        this.assInvestIncome = assInvestIncome;
    }
    public Double getForexGain() {
        return forexGain;
    }

    public void setForexGain(Double forexGain) {
        this.forexGain = forexGain;
    }
    public Double getTotalCogs() {
        return totalCogs;
    }

    public void setTotalCogs(Double totalCogs) {
        this.totalCogs = totalCogs;
    }
    public Double getOperCost() {
        return operCost;
    }

    public void setOperCost(Double operCost) {
        this.operCost = operCost;
    }
    public Double getIntExp() {
        return intExp;
    }

    public void setIntExp(Double intExp) {
        this.intExp = intExp;
    }
    public Double getCommExp() {
        return commExp;
    }

    public void setCommExp(Double commExp) {
        this.commExp = commExp;
    }
    public Double getBizTaxSurchg() {
        return bizTaxSurchg;
    }

    public void setBizTaxSurchg(Double bizTaxSurchg) {
        this.bizTaxSurchg = bizTaxSurchg;
    }
    public Double getSellExp() {
        return sellExp;
    }

    public void setSellExp(Double sellExp) {
        this.sellExp = sellExp;
    }
    public Double getAdminExp() {
        return adminExp;
    }

    public void setAdminExp(Double adminExp) {
        this.adminExp = adminExp;
    }
    public Double getFinExp() {
        return finExp;
    }

    public void setFinExp(Double finExp) {
        this.finExp = finExp;
    }
    public Double getAssetsImpairLoss() {
        return assetsImpairLoss;
    }

    public void setAssetsImpairLoss(Double assetsImpairLoss) {
        this.assetsImpairLoss = assetsImpairLoss;
    }
    public Double getPremRefund() {
        return premRefund;
    }

    public void setPremRefund(Double premRefund) {
        this.premRefund = premRefund;
    }
    public Double getCompensPayout() {
        return compensPayout;
    }

    public void setCompensPayout(Double compensPayout) {
        this.compensPayout = compensPayout;
    }
    public Double getReserInsurLiab() {
        return reserInsurLiab;
    }

    public void setReserInsurLiab(Double reserInsurLiab) {
        this.reserInsurLiab = reserInsurLiab;
    }
    public Double getDivPayt() {
        return divPayt;
    }

    public void setDivPayt(Double divPayt) {
        this.divPayt = divPayt;
    }
    public Double getReinsExp() {
        return reinsExp;
    }

    public void setReinsExp(Double reinsExp) {
        this.reinsExp = reinsExp;
    }
    public Double getOperExp() {
        return operExp;
    }

    public void setOperExp(Double operExp) {
        this.operExp = operExp;
    }
    public Double getCompensPayoutRefu() {
        return compensPayoutRefu;
    }

    public void setCompensPayoutRefu(Double compensPayoutRefu) {
        this.compensPayoutRefu = compensPayoutRefu;
    }
    public Double getInsurReserRefu() {
        return insurReserRefu;
    }

    public void setInsurReserRefu(Double insurReserRefu) {
        this.insurReserRefu = insurReserRefu;
    }
    public Double getReinsCostRefund() {
        return reinsCostRefund;
    }

    public void setReinsCostRefund(Double reinsCostRefund) {
        this.reinsCostRefund = reinsCostRefund;
    }
    public Double getOtherBusCost() {
        return otherBusCost;
    }

    public void setOtherBusCost(Double otherBusCost) {
        this.otherBusCost = otherBusCost;
    }
    public Double getOperateProfit() {
        return operateProfit;
    }

    public void setOperateProfit(Double operateProfit) {
        this.operateProfit = operateProfit;
    }
    public Double getNonOperIncome() {
        return nonOperIncome;
    }

    public void setNonOperIncome(Double nonOperIncome) {
        this.nonOperIncome = nonOperIncome;
    }
    public Double getNonOperExp() {
        return nonOperExp;
    }

    public void setNonOperExp(Double nonOperExp) {
        this.nonOperExp = nonOperExp;
    }
    public Double getNcaDisploss() {
        return ncaDisploss;
    }

    public void setNcaDisploss(Double ncaDisploss) {
        this.ncaDisploss = ncaDisploss;
    }
    public Double getTotalProfit() {
        return totalProfit;
    }

    public void setTotalProfit(Double totalProfit) {
        this.totalProfit = totalProfit;
    }
    public Double getIncomeTax() {
        return incomeTax;
    }

    public void setIncomeTax(Double incomeTax) {
        this.incomeTax = incomeTax;
    }
    public Double getnIncome() {
        return nIncome;
    }

    public void setnIncome(Double nIncome) {
        this.nIncome = nIncome;
    }
    public Double getnIncomeAttrP() {
        return nIncomeAttrP;
    }

    public void setnIncomeAttrP(Double nIncomeAttrP) {
        this.nIncomeAttrP = nIncomeAttrP;
    }
    public Double getMinorityGain() {
        return minorityGain;
    }

    public void setMinorityGain(Double minorityGain) {
        this.minorityGain = minorityGain;
    }
    public Double getOthComprIncome() {
        return othComprIncome;
    }

    public void setOthComprIncome(Double othComprIncome) {
        this.othComprIncome = othComprIncome;
    }
    public Double gettComprIncome() {
        return tComprIncome;
    }

    public void settComprIncome(Double tComprIncome) {
        this.tComprIncome = tComprIncome;
    }
    public Double getComprIncAttrP() {
        return comprIncAttrP;
    }

    public void setComprIncAttrP(Double comprIncAttrP) {
        this.comprIncAttrP = comprIncAttrP;
    }
    public Double getComprIncAttrMS() {
        return comprIncAttrMS;
    }

    public void setComprIncAttrMS(Double comprIncAttrMS) {
        this.comprIncAttrMS = comprIncAttrMS;
    }
    public Double getEbit() {
        return ebit;
    }

    public void setEbit(Double ebit) {
        this.ebit = ebit;
    }
    public Double getEbitda() {
        return ebitda;
    }

    public void setEbitda(Double ebitda) {
        this.ebitda = ebitda;
    }
    public Double getInsuranceExp() {
        return insuranceExp;
    }

    public void setInsuranceExp(Double insuranceExp) {
        this.insuranceExp = insuranceExp;
    }
    public Double getUndistProfit() {
        return undistProfit;
    }

    public void setUndistProfit(Double undistProfit) {
        this.undistProfit = undistProfit;
    }
    public Double getDistableProfit() {
        return distableProfit;
    }

    public void setDistableProfit(Double distableProfit) {
        this.distableProfit = distableProfit;
    }
    public Double getRdExp() {
        return rdExp;
    }

    public void setRdExp(Double rdExp) {
        this.rdExp = rdExp;
    }
    public Double getFinExpIntExp() {
        return finExpIntExp;
    }

    public void setFinExpIntExp(Double finExpIntExp) {
        this.finExpIntExp = finExpIntExp;
    }
    public Double getFinExpIntInc() {
        return finExpIntInc;
    }

    public void setFinExpIntInc(Double finExpIntInc) {
        this.finExpIntInc = finExpIntInc;
    }
    public Double getTransferSurplusRese() {
        return transferSurplusRese;
    }

    public void setTransferSurplusRese(Double transferSurplusRese) {
        this.transferSurplusRese = transferSurplusRese;
    }
    public Double getTransferHousingImprest() {
        return transferHousingImprest;
    }

    public void setTransferHousingImprest(Double transferHousingImprest) {
        this.transferHousingImprest = transferHousingImprest;
    }
    public Double getTransferOth() {
        return transferOth;
    }

    public void setTransferOth(Double transferOth) {
        this.transferOth = transferOth;
    }
    public Double getAdjLossgain() {
        return adjLossgain;
    }

    public void setAdjLossgain(Double adjLossgain) {
        this.adjLossgain = adjLossgain;
    }
    public Double getWithdraLegalSurplus() {
        return withdraLegalSurplus;
    }

    public void setWithdraLegalSurplus(Double withdraLegalSurplus) {
        this.withdraLegalSurplus = withdraLegalSurplus;
    }
    public Double getWithdraLegalPubfund() {
        return withdraLegalPubfund;
    }

    public void setWithdraLegalPubfund(Double withdraLegalPubfund) {
        this.withdraLegalPubfund = withdraLegalPubfund;
    }
    public Double getWithdraBizDevfund() {
        return withdraBizDevfund;
    }

    public void setWithdraBizDevfund(Double withdraBizDevfund) {
        this.withdraBizDevfund = withdraBizDevfund;
    }
    public Double getWithdraReseFund() {
        return withdraReseFund;
    }

    public void setWithdraReseFund(Double withdraReseFund) {
        this.withdraReseFund = withdraReseFund;
    }
    public Double getWithdraOthErsu() {
        return withdraOthErsu;
    }

    public void setWithdraOthErsu(Double withdraOthErsu) {
        this.withdraOthErsu = withdraOthErsu;
    }
    public Double getWorkersWelfare() {
        return workersWelfare;
    }

    public void setWorkersWelfare(Double workersWelfare) {
        this.workersWelfare = workersWelfare;
    }
    public Double getDistrProfitShrhder() {
        return distrProfitShrhder;
    }

    public void setDistrProfitShrhder(Double distrProfitShrhder) {
        this.distrProfitShrhder = distrProfitShrhder;
    }
    public Double getPrfsharePayableDvd() {
        return prfsharePayableDvd;
    }

    public void setPrfsharePayableDvd(Double prfsharePayableDvd) {
        this.prfsharePayableDvd = prfsharePayableDvd;
    }
    public Double getComsharePayableDvd() {
        return comsharePayableDvd;
    }

    public void setComsharePayableDvd(Double comsharePayableDvd) {
        this.comsharePayableDvd = comsharePayableDvd;
    }
    public Double getCapitComstockDiv() {
        return capitComstockDiv;
    }

    public void setCapitComstockDiv(Double capitComstockDiv) {
        this.capitComstockDiv = capitComstockDiv;
    }
    public Double getContinuedNetProfit() {
        return continuedNetProfit;
    }

    public void setContinuedNetProfit(Double continuedNetProfit) {
        this.continuedNetProfit = continuedNetProfit;
    }
    public String getUpdateFlag() {
        return updateFlag;
    }

    public void setUpdateFlag(String updateFlag) {
        this.updateFlag = updateFlag;
    }
    public Integer getIncomeId() {
        return incomeId;
    }

    public void setIncomeId(Integer incomeId) {
        this.incomeId = incomeId;
    }

    @Override
    public String toString() {
        return "Income{" +
            "tsCode=" + tsCode +
            ", annDate=" + annDate +
            ", fAnnDate=" + fAnnDate +
            ", endDate=" + endDate +
            ", reportType=" + reportType +
            ", compType=" + compType +
            ", endType=" + endType +
            ", basicEps=" + basicEps +
            ", dilutedEps=" + dilutedEps +
            ", totalRevenue=" + totalRevenue +
            ", revenue=" + revenue +
            ", intIncome=" + intIncome +
            ", premEarned=" + premEarned +
            ", commIncome=" + commIncome +
            ", nCommisIncome=" + nCommisIncome +
            ", nOthIncome=" + nOthIncome +
            ", nOthBIncome=" + nOthBIncome +
            ", premIncome=" + premIncome +
            ", outPrem=" + outPrem +
            ", unePremReser=" + unePremReser +
            ", reinsIncome=" + reinsIncome +
            ", nSecTbIncome=" + nSecTbIncome +
            ", nSecUwIncome=" + nSecUwIncome +
            ", nAssetMgIncome=" + nAssetMgIncome +
            ", othBIncome=" + othBIncome +
            ", fvValueChgGain=" + fvValueChgGain +
            ", investIncome=" + investIncome +
            ", assInvestIncome=" + assInvestIncome +
            ", forexGain=" + forexGain +
            ", totalCogs=" + totalCogs +
            ", operCost=" + operCost +
            ", intExp=" + intExp +
            ", commExp=" + commExp +
            ", bizTaxSurchg=" + bizTaxSurchg +
            ", sellExp=" + sellExp +
            ", adminExp=" + adminExp +
            ", finExp=" + finExp +
            ", assetsImpairLoss=" + assetsImpairLoss +
            ", premRefund=" + premRefund +
            ", compensPayout=" + compensPayout +
            ", reserInsurLiab=" + reserInsurLiab +
            ", divPayt=" + divPayt +
            ", reinsExp=" + reinsExp +
            ", operExp=" + operExp +
            ", compensPayoutRefu=" + compensPayoutRefu +
            ", insurReserRefu=" + insurReserRefu +
            ", reinsCostRefund=" + reinsCostRefund +
            ", otherBusCost=" + otherBusCost +
            ", operateProfit=" + operateProfit +
            ", nonOperIncome=" + nonOperIncome +
            ", nonOperExp=" + nonOperExp +
            ", ncaDisploss=" + ncaDisploss +
            ", totalProfit=" + totalProfit +
            ", incomeTax=" + incomeTax +
            ", nIncome=" + nIncome +
            ", nIncomeAttrP=" + nIncomeAttrP +
            ", minorityGain=" + minorityGain +
            ", othComprIncome=" + othComprIncome +
            ", tComprIncome=" + tComprIncome +
            ", comprIncAttrP=" + comprIncAttrP +
            ", comprIncAttrMS=" + comprIncAttrMS +
            ", ebit=" + ebit +
            ", ebitda=" + ebitda +
            ", insuranceExp=" + insuranceExp +
            ", undistProfit=" + undistProfit +
            ", distableProfit=" + distableProfit +
            ", rdExp=" + rdExp +
            ", finExpIntExp=" + finExpIntExp +
            ", finExpIntInc=" + finExpIntInc +
            ", transferSurplusRese=" + transferSurplusRese +
            ", transferHousingImprest=" + transferHousingImprest +
            ", transferOth=" + transferOth +
            ", adjLossgain=" + adjLossgain +
            ", withdraLegalSurplus=" + withdraLegalSurplus +
            ", withdraLegalPubfund=" + withdraLegalPubfund +
            ", withdraBizDevfund=" + withdraBizDevfund +
            ", withdraReseFund=" + withdraReseFund +
            ", withdraOthErsu=" + withdraOthErsu +
            ", workersWelfare=" + workersWelfare +
            ", distrProfitShrhder=" + distrProfitShrhder +
            ", prfsharePayableDvd=" + prfsharePayableDvd +
            ", comsharePayableDvd=" + comsharePayableDvd +
            ", capitComstockDiv=" + capitComstockDiv +
            ", continuedNetProfit=" + continuedNetProfit +
            ", updateFlag=" + updateFlag +
            ", incomeId=" + incomeId +
        "}";
    }
}
