package com.companypowernode.dao.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;

/**
 * <p>
 * 现金流量表
 * </p>
 *
 * @author anchor
 * @since 2023-06-08
 */
@TableName("cash_flow")
public class CashFlow implements Serializable {

    private static final long serialVersionUID = 1L;

    private String tsCode;

    private String annDate;

    private String fAnnDate;

    private String endDate;

    private Integer compType;

    private Integer reportType;

    private Integer endType;

    private Double netProfit;

    private Double finanExp;

    private Double cFrSaleSg;

    private Double recpTaxRends;

    private Double nDeposIncrFi;

    private Double nIncrLoansCb;

    private Double nIncBorrOthFi;

    private Double premFrOrigContr;

    private Double nIncrInsuredDep;

    private Double nReinsurPrem;

    private Double nIncrDispTfa;

    private Double ifcCashIncr;

    private Double nIncrDispFaas;

    private Double nIncrLoansOthBank;

    private Double nCapIncrRepur;

    private Double cFrOthOperateA;

    private Double cInfFrOperateA;

    private Double cPaidGoodsS;

    private Double cPaidToForEmpl;

    private Double cPaidForTaxes;

    private Double nIncrCltLoanAdv;

    private Double nIncrDepCbob;

    private Double cPayClaimsOrigInco;

    private Double payHandlingChrg;

    private Double payCommInsurPlcy;

    private Double othCashPayOperAct;

    private Double stCashOutAct;

    private Double nCashflowAct;

    private Double othRecpRalInvAct;

    private Double cDispWithdrwlInvest;

    private Double cRecpReturnInvest;

    private Double nRecpDispFiolta;

    private Double nRecpDispSobu;

    private Double stotInflowsInvAct;

    private Double cPayAcqConstFiolta;

    private Double cPaidInvest;

    private Double nDispSubsOthBiz;

    private Double othPayRalInvAct;

    private Double nIncrPledgeLoan;

    private Double stotOutInvAct;

    private Double nCashflowInvAct;

    private Double cRecpBorrow;

    private Double procIssueBonds;

    private Double othCashRecpRalFncAct;

    private Double stotCashInFncAct;

    private Double freeCashflow;

    private Double cPrepayAmtBorr;

    private Double cPayDistDpcpIntExp;

    private Double inclDvdProfitPaidScMs;

    private Double othCashpayRalFncAct;

    private Double stotCashoutFncAct;

    private Double nCashFlowsFncAct;

    private Double effFxFluCash;

    private Double nIncrCashCashEqu;

    private Double cCashEquBegPeriod;

    private Double cCashEquEndPeriod;

    private Double cRecpCapContrib;

    private Double inclCashRecSaims;

    private Double unconInvestLoss;

    private Double provDeprAssets;

    private Double deprFaCogaDpba;

    private Double amortIntangAssets;

    private Double ltAmortDeferredExp;

    private Double decrDeferredExp;

    private Double incrAccExp;

    private Double lossDispFiolta;

    private Double lossScrFa;

    private Double lossFvChg;

    private Double investLoss;

    private Double decrDefIncTaxAssets;

    private Double incrDefIncTaxLiab;

    private Double decrInventories;

    private Double decrOperPayable;

    private Double incrOperPayable;

    private Double others;

    private Double imNetCashflowOperAct;

    private Double convDebtIntoCap;

    @TableField(value = "conv_copbonds_due_within_1y")
    private Double convCopbondsDueWithin1y;

    private Double faFncLeases;

    private Double imNIncrCashEqu;

    private Double netDismCapitalAdd;

    private Double netCashReceSec;

    private Double creditImpaLoss;

    private Double useRightAssetDep;

    private Double othLossAsset;

    private Double endBalCash;

    private Double begBalCash;

    private Double endBalCashEqu;

    private Double begBalCashEqu;

    private Integer updateFlag;

    @TableId(value = "cash_id",type = IdType.AUTO)
    private Integer cashId;

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

    public Integer getCompType() {
        return compType;
    }

    public void setCompType(Integer compType) {
        this.compType = compType;
    }
    public Integer getReportType() {
        return reportType;
    }

    public void setReportType(Integer reportType) {
        this.reportType = reportType;
    }
    public Integer getEndType() {
        return endType;
    }

    public void setEndType(Integer endType) {
        this.endType = endType;
    }
    public Double getNetProfit() {
        return netProfit;
    }

    public void setNetProfit(Double netProfit) {
        this.netProfit = netProfit;
    }
    public Double getFinanExp() {
        return finanExp;
    }

    public void setFinanExp(Double finanExp) {
        this.finanExp = finanExp;
    }
    public Double getcFrSaleSg() {
        return cFrSaleSg;
    }

    public void setcFrSaleSg(Double cFrSaleSg) {
        this.cFrSaleSg = cFrSaleSg;
    }
    public Double getRecpTaxRends() {
        return recpTaxRends;
    }

    public void setRecpTaxRends(Double recpTaxRends) {
        this.recpTaxRends = recpTaxRends;
    }
    public Double getnDeposIncrFi() {
        return nDeposIncrFi;
    }

    public void setnDeposIncrFi(Double nDeposIncrFi) {
        this.nDeposIncrFi = nDeposIncrFi;
    }
    public Double getnIncrLoansCb() {
        return nIncrLoansCb;
    }

    public void setnIncrLoansCb(Double nIncrLoansCb) {
        this.nIncrLoansCb = nIncrLoansCb;
    }
    public Double getnIncBorrOthFi() {
        return nIncBorrOthFi;
    }

    public void setnIncBorrOthFi(Double nIncBorrOthFi) {
        this.nIncBorrOthFi = nIncBorrOthFi;
    }
    public Double getPremFrOrigContr() {
        return premFrOrigContr;
    }

    public void setPremFrOrigContr(Double premFrOrigContr) {
        this.premFrOrigContr = premFrOrigContr;
    }
    public Double getnIncrInsuredDep() {
        return nIncrInsuredDep;
    }

    public void setnIncrInsuredDep(Double nIncrInsuredDep) {
        this.nIncrInsuredDep = nIncrInsuredDep;
    }
    public Double getnReinsurPrem() {
        return nReinsurPrem;
    }

    public void setnReinsurPrem(Double nReinsurPrem) {
        this.nReinsurPrem = nReinsurPrem;
    }
    public Double getnIncrDispTfa() {
        return nIncrDispTfa;
    }

    public void setnIncrDispTfa(Double nIncrDispTfa) {
        this.nIncrDispTfa = nIncrDispTfa;
    }
    public Double getIfcCashIncr() {
        return ifcCashIncr;
    }

    public void setIfcCashIncr(Double ifcCashIncr) {
        this.ifcCashIncr = ifcCashIncr;
    }
    public Double getnIncrDispFaas() {
        return nIncrDispFaas;
    }

    public void setnIncrDispFaas(Double nIncrDispFaas) {
        this.nIncrDispFaas = nIncrDispFaas;
    }
    public Double getnIncrLoansOthBank() {
        return nIncrLoansOthBank;
    }

    public void setnIncrLoansOthBank(Double nIncrLoansOthBank) {
        this.nIncrLoansOthBank = nIncrLoansOthBank;
    }
    public Double getnCapIncrRepur() {
        return nCapIncrRepur;
    }

    public void setnCapIncrRepur(Double nCapIncrRepur) {
        this.nCapIncrRepur = nCapIncrRepur;
    }
    public Double getcFrOthOperateA() {
        return cFrOthOperateA;
    }

    public void setcFrOthOperateA(Double cFrOthOperateA) {
        this.cFrOthOperateA = cFrOthOperateA;
    }
    public Double getcInfFrOperateA() {
        return cInfFrOperateA;
    }

    public void setcInfFrOperateA(Double cInfFrOperateA) {
        this.cInfFrOperateA = cInfFrOperateA;
    }
    public Double getcPaidGoodsS() {
        return cPaidGoodsS;
    }

    public void setcPaidGoodsS(Double cPaidGoodsS) {
        this.cPaidGoodsS = cPaidGoodsS;
    }
    public Double getcPaidToForEmpl() {
        return cPaidToForEmpl;
    }

    public void setcPaidToForEmpl(Double cPaidToForEmpl) {
        this.cPaidToForEmpl = cPaidToForEmpl;
    }
    public Double getcPaidForTaxes() {
        return cPaidForTaxes;
    }

    public void setcPaidForTaxes(Double cPaidForTaxes) {
        this.cPaidForTaxes = cPaidForTaxes;
    }
    public Double getnIncrCltLoanAdv() {
        return nIncrCltLoanAdv;
    }

    public void setnIncrCltLoanAdv(Double nIncrCltLoanAdv) {
        this.nIncrCltLoanAdv = nIncrCltLoanAdv;
    }
    public Double getnIncrDepCbob() {
        return nIncrDepCbob;
    }

    public void setnIncrDepCbob(Double nIncrDepCbob) {
        this.nIncrDepCbob = nIncrDepCbob;
    }
    public Double getcPayClaimsOrigInco() {
        return cPayClaimsOrigInco;
    }

    public void setcPayClaimsOrigInco(Double cPayClaimsOrigInco) {
        this.cPayClaimsOrigInco = cPayClaimsOrigInco;
    }
    public Double getPayHandlingChrg() {
        return payHandlingChrg;
    }

    public void setPayHandlingChrg(Double payHandlingChrg) {
        this.payHandlingChrg = payHandlingChrg;
    }
    public Double getPayCommInsurPlcy() {
        return payCommInsurPlcy;
    }

    public void setPayCommInsurPlcy(Double payCommInsurPlcy) {
        this.payCommInsurPlcy = payCommInsurPlcy;
    }
    public Double getOthCashPayOperAct() {
        return othCashPayOperAct;
    }

    public void setOthCashPayOperAct(Double othCashPayOperAct) {
        this.othCashPayOperAct = othCashPayOperAct;
    }
    public Double getStCashOutAct() {
        return stCashOutAct;
    }

    public void setStCashOutAct(Double stCashOutAct) {
        this.stCashOutAct = stCashOutAct;
    }
    public Double getnCashflowAct() {
        return nCashflowAct;
    }

    public void setnCashflowAct(Double nCashflowAct) {
        this.nCashflowAct = nCashflowAct;
    }
    public Double getOthRecpRalInvAct() {
        return othRecpRalInvAct;
    }

    public void setOthRecpRalInvAct(Double othRecpRalInvAct) {
        this.othRecpRalInvAct = othRecpRalInvAct;
    }
    public Double getcDispWithdrwlInvest() {
        return cDispWithdrwlInvest;
    }

    public void setcDispWithdrwlInvest(Double cDispWithdrwlInvest) {
        this.cDispWithdrwlInvest = cDispWithdrwlInvest;
    }
    public Double getcRecpReturnInvest() {
        return cRecpReturnInvest;
    }

    public void setcRecpReturnInvest(Double cRecpReturnInvest) {
        this.cRecpReturnInvest = cRecpReturnInvest;
    }
    public Double getnRecpDispFiolta() {
        return nRecpDispFiolta;
    }

    public void setnRecpDispFiolta(Double nRecpDispFiolta) {
        this.nRecpDispFiolta = nRecpDispFiolta;
    }
    public Double getnRecpDispSobu() {
        return nRecpDispSobu;
    }

    public void setnRecpDispSobu(Double nRecpDispSobu) {
        this.nRecpDispSobu = nRecpDispSobu;
    }
    public Double getStotInflowsInvAct() {
        return stotInflowsInvAct;
    }

    public void setStotInflowsInvAct(Double stotInflowsInvAct) {
        this.stotInflowsInvAct = stotInflowsInvAct;
    }
    public Double getcPayAcqConstFiolta() {
        return cPayAcqConstFiolta;
    }

    public void setcPayAcqConstFiolta(Double cPayAcqConstFiolta) {
        this.cPayAcqConstFiolta = cPayAcqConstFiolta;
    }
    public Double getcPaidInvest() {
        return cPaidInvest;
    }

    public void setcPaidInvest(Double cPaidInvest) {
        this.cPaidInvest = cPaidInvest;
    }
    public Double getnDispSubsOthBiz() {
        return nDispSubsOthBiz;
    }

    public void setnDispSubsOthBiz(Double nDispSubsOthBiz) {
        this.nDispSubsOthBiz = nDispSubsOthBiz;
    }
    public Double getOthPayRalInvAct() {
        return othPayRalInvAct;
    }

    public void setOthPayRalInvAct(Double othPayRalInvAct) {
        this.othPayRalInvAct = othPayRalInvAct;
    }
    public Double getnIncrPledgeLoan() {
        return nIncrPledgeLoan;
    }

    public void setnIncrPledgeLoan(Double nIncrPledgeLoan) {
        this.nIncrPledgeLoan = nIncrPledgeLoan;
    }
    public Double getStotOutInvAct() {
        return stotOutInvAct;
    }

    public void setStotOutInvAct(Double stotOutInvAct) {
        this.stotOutInvAct = stotOutInvAct;
    }
    public Double getnCashflowInvAct() {
        return nCashflowInvAct;
    }

    public void setnCashflowInvAct(Double nCashflowInvAct) {
        this.nCashflowInvAct = nCashflowInvAct;
    }
    public Double getcRecpBorrow() {
        return cRecpBorrow;
    }

    public void setcRecpBorrow(Double cRecpBorrow) {
        this.cRecpBorrow = cRecpBorrow;
    }
    public Double getProcIssueBonds() {
        return procIssueBonds;
    }

    public void setProcIssueBonds(Double procIssueBonds) {
        this.procIssueBonds = procIssueBonds;
    }
    public Double getOthCashRecpRalFncAct() {
        return othCashRecpRalFncAct;
    }

    public void setOthCashRecpRalFncAct(Double othCashRecpRalFncAct) {
        this.othCashRecpRalFncAct = othCashRecpRalFncAct;
    }
    public Double getStotCashInFncAct() {
        return stotCashInFncAct;
    }

    public void setStotCashInFncAct(Double stotCashInFncAct) {
        this.stotCashInFncAct = stotCashInFncAct;
    }
    public Double getFreeCashflow() {
        return freeCashflow;
    }

    public void setFreeCashflow(Double freeCashflow) {
        this.freeCashflow = freeCashflow;
    }
    public Double getcPrepayAmtBorr() {
        return cPrepayAmtBorr;
    }

    public void setcPrepayAmtBorr(Double cPrepayAmtBorr) {
        this.cPrepayAmtBorr = cPrepayAmtBorr;
    }
    public Double getcPayDistDpcpIntExp() {
        return cPayDistDpcpIntExp;
    }

    public void setcPayDistDpcpIntExp(Double cPayDistDpcpIntExp) {
        this.cPayDistDpcpIntExp = cPayDistDpcpIntExp;
    }
    public Double getInclDvdProfitPaidScMs() {
        return inclDvdProfitPaidScMs;
    }

    public void setInclDvdProfitPaidScMs(Double inclDvdProfitPaidScMs) {
        this.inclDvdProfitPaidScMs = inclDvdProfitPaidScMs;
    }
    public Double getOthCashpayRalFncAct() {
        return othCashpayRalFncAct;
    }

    public void setOthCashpayRalFncAct(Double othCashpayRalFncAct) {
        this.othCashpayRalFncAct = othCashpayRalFncAct;
    }
    public Double getStotCashoutFncAct() {
        return stotCashoutFncAct;
    }

    public void setStotCashoutFncAct(Double stotCashoutFncAct) {
        this.stotCashoutFncAct = stotCashoutFncAct;
    }
    public Double getnCashFlowsFncAct() {
        return nCashFlowsFncAct;
    }

    public void setnCashFlowsFncAct(Double nCashFlowsFncAct) {
        this.nCashFlowsFncAct = nCashFlowsFncAct;
    }
    public Double getEffFxFluCash() {
        return effFxFluCash;
    }

    public void setEffFxFluCash(Double effFxFluCash) {
        this.effFxFluCash = effFxFluCash;
    }
    public Double getnIncrCashCashEqu() {
        return nIncrCashCashEqu;
    }

    public void setnIncrCashCashEqu(Double nIncrCashCashEqu) {
        this.nIncrCashCashEqu = nIncrCashCashEqu;
    }
    public Double getcCashEquBegPeriod() {
        return cCashEquBegPeriod;
    }

    public void setcCashEquBegPeriod(Double cCashEquBegPeriod) {
        this.cCashEquBegPeriod = cCashEquBegPeriod;
    }
    public Double getcCashEquEndPeriod() {
        return cCashEquEndPeriod;
    }

    public void setcCashEquEndPeriod(Double cCashEquEndPeriod) {
        this.cCashEquEndPeriod = cCashEquEndPeriod;
    }
    public Double getcRecpCapContrib() {
        return cRecpCapContrib;
    }

    public void setcRecpCapContrib(Double cRecpCapContrib) {
        this.cRecpCapContrib = cRecpCapContrib;
    }
    public Double getInclCashRecSaims() {
        return inclCashRecSaims;
    }

    public void setInclCashRecSaims(Double inclCashRecSaims) {
        this.inclCashRecSaims = inclCashRecSaims;
    }
    public Double getUnconInvestLoss() {
        return unconInvestLoss;
    }

    public void setUnconInvestLoss(Double unconInvestLoss) {
        this.unconInvestLoss = unconInvestLoss;
    }
    public Double getProvDeprAssets() {
        return provDeprAssets;
    }

    public void setProvDeprAssets(Double provDeprAssets) {
        this.provDeprAssets = provDeprAssets;
    }
    public Double getDeprFaCogaDpba() {
        return deprFaCogaDpba;
    }

    public void setDeprFaCogaDpba(Double deprFaCogaDpba) {
        this.deprFaCogaDpba = deprFaCogaDpba;
    }
    public Double getAmortIntangAssets() {
        return amortIntangAssets;
    }

    public void setAmortIntangAssets(Double amortIntangAssets) {
        this.amortIntangAssets = amortIntangAssets;
    }
    public Double getLtAmortDeferredExp() {
        return ltAmortDeferredExp;
    }

    public void setLtAmortDeferredExp(Double ltAmortDeferredExp) {
        this.ltAmortDeferredExp = ltAmortDeferredExp;
    }
    public Double getDecrDeferredExp() {
        return decrDeferredExp;
    }

    public void setDecrDeferredExp(Double decrDeferredExp) {
        this.decrDeferredExp = decrDeferredExp;
    }
    public Double getIncrAccExp() {
        return incrAccExp;
    }

    public void setIncrAccExp(Double incrAccExp) {
        this.incrAccExp = incrAccExp;
    }
    public Double getLossDispFiolta() {
        return lossDispFiolta;
    }

    public void setLossDispFiolta(Double lossDispFiolta) {
        this.lossDispFiolta = lossDispFiolta;
    }
    public Double getLossScrFa() {
        return lossScrFa;
    }

    public void setLossScrFa(Double lossScrFa) {
        this.lossScrFa = lossScrFa;
    }
    public Double getLossFvChg() {
        return lossFvChg;
    }

    public void setLossFvChg(Double lossFvChg) {
        this.lossFvChg = lossFvChg;
    }
    public Double getInvestLoss() {
        return investLoss;
    }

    public void setInvestLoss(Double investLoss) {
        this.investLoss = investLoss;
    }
    public Double getDecrDefIncTaxAssets() {
        return decrDefIncTaxAssets;
    }

    public void setDecrDefIncTaxAssets(Double decrDefIncTaxAssets) {
        this.decrDefIncTaxAssets = decrDefIncTaxAssets;
    }
    public Double getIncrDefIncTaxLiab() {
        return incrDefIncTaxLiab;
    }

    public void setIncrDefIncTaxLiab(Double incrDefIncTaxLiab) {
        this.incrDefIncTaxLiab = incrDefIncTaxLiab;
    }
    public Double getDecrInventories() {
        return decrInventories;
    }

    public void setDecrInventories(Double decrInventories) {
        this.decrInventories = decrInventories;
    }
    public Double getDecrOperPayable() {
        return decrOperPayable;
    }

    public void setDecrOperPayable(Double decrOperPayable) {
        this.decrOperPayable = decrOperPayable;
    }
    public Double getIncrOperPayable() {
        return incrOperPayable;
    }

    public void setIncrOperPayable(Double incrOperPayable) {
        this.incrOperPayable = incrOperPayable;
    }
    public Double getOthers() {
        return others;
    }

    public void setOthers(Double others) {
        this.others = others;
    }
    public Double getImNetCashflowOperAct() {
        return imNetCashflowOperAct;
    }

    public void setImNetCashflowOperAct(Double imNetCashflowOperAct) {
        this.imNetCashflowOperAct = imNetCashflowOperAct;
    }
    public Double getConvDebtIntoCap() {
        return convDebtIntoCap;
    }

    public void setConvDebtIntoCap(Double convDebtIntoCap) {
        this.convDebtIntoCap = convDebtIntoCap;
    }
    public Double getConvCopbondsDueWithin1y() {
        return convCopbondsDueWithin1y;
    }

    public void setConvCopbondsDueWithin1y(Double convCopbondsDueWithin1y) {
        this.convCopbondsDueWithin1y = convCopbondsDueWithin1y;
    }
    public Double getFaFncLeases() {
        return faFncLeases;
    }

    public void setFaFncLeases(Double faFncLeases) {
        this.faFncLeases = faFncLeases;
    }
    public Double getImNIncrCashEqu() {
        return imNIncrCashEqu;
    }

    public void setImNIncrCashEqu(Double imNIncrCashEqu) {
        this.imNIncrCashEqu = imNIncrCashEqu;
    }
    public Double getNetDismCapitalAdd() {
        return netDismCapitalAdd;
    }

    public void setNetDismCapitalAdd(Double netDismCapitalAdd) {
        this.netDismCapitalAdd = netDismCapitalAdd;
    }
    public Double getNetCashReceSec() {
        return netCashReceSec;
    }

    public void setNetCashReceSec(Double netCashReceSec) {
        this.netCashReceSec = netCashReceSec;
    }
    public Double getCreditImpaLoss() {
        return creditImpaLoss;
    }

    public void setCreditImpaLoss(Double creditImpaLoss) {
        this.creditImpaLoss = creditImpaLoss;
    }
    public Double getUseRightAssetDep() {
        return useRightAssetDep;
    }

    public void setUseRightAssetDep(Double useRightAssetDep) {
        this.useRightAssetDep = useRightAssetDep;
    }
    public Double getOthLossAsset() {
        return othLossAsset;
    }

    public void setOthLossAsset(Double othLossAsset) {
        this.othLossAsset = othLossAsset;
    }
    public Double getEndBalCash() {
        return endBalCash;
    }

    public void setEndBalCash(Double endBalCash) {
        this.endBalCash = endBalCash;
    }
    public Double getBegBalCash() {
        return begBalCash;
    }

    public void setBegBalCash(Double begBalCash) {
        this.begBalCash = begBalCash;
    }
    public Double getEndBalCashEqu() {
        return endBalCashEqu;
    }

    public void setEndBalCashEqu(Double endBalCashEqu) {
        this.endBalCashEqu = endBalCashEqu;
    }
    public Double getBegBalCashEqu() {
        return begBalCashEqu;
    }

    public void setBegBalCashEqu(Double begBalCashEqu) {
        this.begBalCashEqu = begBalCashEqu;
    }
    public Integer getUpdateFlag() {
        return updateFlag;
    }

    public void setUpdateFlag(Integer updateFlag) {
        this.updateFlag = updateFlag;
    }

    @Override
    public String toString() {
        return "CashFlow{" +
            "tsCode=" + tsCode +
            ", annDate=" + annDate +
            ", fAnnDate=" + fAnnDate +
            ", endDate=" + endDate +
            ", compType=" + compType +
            ", reportType=" + reportType +
            ", endType=" + endType +
            ", netProfit=" + netProfit +
            ", finanExp=" + finanExp +
            ", cFrSaleSg=" + cFrSaleSg +
            ", recpTaxRends=" + recpTaxRends +
            ", nDeposIncrFi=" + nDeposIncrFi +
            ", nIncrLoansCb=" + nIncrLoansCb +
            ", nIncBorrOthFi=" + nIncBorrOthFi +
            ", premFrOrigContr=" + premFrOrigContr +
            ", nIncrInsuredDep=" + nIncrInsuredDep +
            ", nReinsurPrem=" + nReinsurPrem +
            ", nIncrDispTfa=" + nIncrDispTfa +
            ", ifcCashIncr=" + ifcCashIncr +
            ", nIncrDispFaas=" + nIncrDispFaas +
            ", nIncrLoansOthBank=" + nIncrLoansOthBank +
            ", nCapIncrRepur=" + nCapIncrRepur +
            ", cFrOthOperateA=" + cFrOthOperateA +
            ", cInfFrOperateA=" + cInfFrOperateA +
            ", cPaidGoodsS=" + cPaidGoodsS +
            ", cPaidToForEmpl=" + cPaidToForEmpl +
            ", cPaidForTaxes=" + cPaidForTaxes +
            ", nIncrCltLoanAdv=" + nIncrCltLoanAdv +
            ", nIncrDepCbob=" + nIncrDepCbob +
            ", cPayClaimsOrigInco=" + cPayClaimsOrigInco +
            ", payHandlingChrg=" + payHandlingChrg +
            ", payCommInsurPlcy=" + payCommInsurPlcy +
            ", othCashPayOperAct=" + othCashPayOperAct +
            ", stCashOutAct=" + stCashOutAct +
            ", nCashflowAct=" + nCashflowAct +
            ", othRecpRalInvAct=" + othRecpRalInvAct +
            ", cDispWithdrwlInvest=" + cDispWithdrwlInvest +
            ", cRecpReturnInvest=" + cRecpReturnInvest +
            ", nRecpDispFiolta=" + nRecpDispFiolta +
            ", nRecpDispSobu=" + nRecpDispSobu +
            ", stotInflowsInvAct=" + stotInflowsInvAct +
            ", cPayAcqConstFiolta=" + cPayAcqConstFiolta +
            ", cPaidInvest=" + cPaidInvest +
            ", nDispSubsOthBiz=" + nDispSubsOthBiz +
            ", othPayRalInvAct=" + othPayRalInvAct +
            ", nIncrPledgeLoan=" + nIncrPledgeLoan +
            ", stotOutInvAct=" + stotOutInvAct +
            ", nCashflowInvAct=" + nCashflowInvAct +
            ", cRecpBorrow=" + cRecpBorrow +
            ", procIssueBonds=" + procIssueBonds +
            ", othCashRecpRalFncAct=" + othCashRecpRalFncAct +
            ", stotCashInFncAct=" + stotCashInFncAct +
            ", freeCashflow=" + freeCashflow +
            ", cPrepayAmtBorr=" + cPrepayAmtBorr +
            ", cPayDistDpcpIntExp=" + cPayDistDpcpIntExp +
            ", inclDvdProfitPaidScMs=" + inclDvdProfitPaidScMs +
            ", othCashpayRalFncAct=" + othCashpayRalFncAct +
            ", stotCashoutFncAct=" + stotCashoutFncAct +
            ", nCashFlowsFncAct=" + nCashFlowsFncAct +
            ", effFxFluCash=" + effFxFluCash +
            ", nIncrCashCashEqu=" + nIncrCashCashEqu +
            ", cCashEquBegPeriod=" + cCashEquBegPeriod +
            ", cCashEquEndPeriod=" + cCashEquEndPeriod +
            ", cRecpCapContrib=" + cRecpCapContrib +
            ", inclCashRecSaims=" + inclCashRecSaims +
            ", unconInvestLoss=" + unconInvestLoss +
            ", provDeprAssets=" + provDeprAssets +
            ", deprFaCogaDpba=" + deprFaCogaDpba +
            ", amortIntangAssets=" + amortIntangAssets +
            ", ltAmortDeferredExp=" + ltAmortDeferredExp +
            ", decrDeferredExp=" + decrDeferredExp +
            ", incrAccExp=" + incrAccExp +
            ", lossDispFiolta=" + lossDispFiolta +
            ", lossScrFa=" + lossScrFa +
            ", lossFvChg=" + lossFvChg +
            ", investLoss=" + investLoss +
            ", decrDefIncTaxAssets=" + decrDefIncTaxAssets +
            ", incrDefIncTaxLiab=" + incrDefIncTaxLiab +
            ", decrInventories=" + decrInventories +
            ", decrOperPayable=" + decrOperPayable +
            ", incrOperPayable=" + incrOperPayable +
            ", others=" + others +
            ", imNetCashflowOperAct=" + imNetCashflowOperAct +
            ", convDebtIntoCap=" + convDebtIntoCap +
            ", convCopbondsDueWithin1y=" + convCopbondsDueWithin1y +
            ", faFncLeases=" + faFncLeases +
            ", imNIncrCashEqu=" + imNIncrCashEqu +
            ", netDismCapitalAdd=" + netDismCapitalAdd +
            ", netCashReceSec=" + netCashReceSec +
            ", creditImpaLoss=" + creditImpaLoss +
            ", useRightAssetDep=" + useRightAssetDep +
            ", othLossAsset=" + othLossAsset +
            ", endBalCash=" + endBalCash +
            ", begBalCash=" + begBalCash +
            ", endBalCashEqu=" + endBalCashEqu +
            ", begBalCashEqu=" + begBalCashEqu +
            ", updateFlag=" + updateFlag +
                ",cashId="+cashId+
        "}";
    }
}
