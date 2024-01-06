package com.companypowernode.dao.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author anchor
 * @since 2023-06-08
 */
@TableName("balance_sheet")
public class BalanceSheet implements Serializable {

    private static final long serialVersionUID = 1L;

    private String tsCode;

    private String annDate;

    private String fAnnDate;

    private String endDate;

    private Integer reportType;

    private Integer compType;

    private Integer endType;

    private Double totalShare;

    private Double capRese;

    private Double undistrPorfit;

    private Double surplusRese;

    private Double specialRese;

    private Double moneyCap;

    private Double tradAsset;

    private Double notesReceiv;

    private Double accountsReceiv;

    private Double othReceiv;

    private Double prepayment;

    private Double divReceiv;

    private Double intReceiv;

    private Double inventories;

    private Double amorExp;

    @TableField(value = "nca_within_1y")
    private Double ncaWithin1y;

    private Double settRsrv;

    private Double loantoOthBankFi;

    private Double premiumReceiv;

    private Double reinsurReceiv;

    private Double reinsurResReceiv;

    private Double purResaleFa;

    private Double othCurAssets;

    private Double totalCurAssets;

    private Double faAvailForSale;

    private Double htmInvest;

    private Double ltEqtInvest;

    private Double investRealEstate;

    private Double timeDeposits;

    private Double othAssets;

    private Double ltRec;

    private Double fixAssets;

    private Double cip;

    private Double constMaterials;

    private Double fixedAssetsDisp;

    private Double producBioAssets;

    private Double oilAndGasAssets;

    private Double intanAssets;

    private Double rAndD;

    private Double goodwill;

    private Double ltAmorExp;

    private Double deferTaxAssets;

    private Double decrInDisbur;

    private Double othNca;

    private Double totalNca;

    private Double cashReserCb;

    private Double deposInOthBfi;

    private Double precMetals;

    private Double derivAssets;

    private Double rrReinsUnePrem;

    private Double rrReinsOutstdCla;

    private Double rrReinsLinsLiab;

    private Double rrReinsLthinsLiab;

    private Double refundDepos;

    private Double phPledgeLoans;

    private Double refundCapDepos;

    private Double indepAcctAssets;

    private Double clientDepos;

    private Double clientProv;

    private Double transacSeatFee;

    private Double investAsReceiv;

    private Double totalAssets;

    private Double ltBorr;

    private Double stBorr;

    private Double cbBorr;

    private Double deposIbDeposits;

    private Double loanOthBank;

    private Double tradingFl;

    private Double notesPayable;

    private Double acctPayable;

    private Double advReceipts;

    private Double soldForRepurFa;

    private Double commPayable;

    private Double payrollPayable;

    private Double taxesPayable;

    private Double intPayable;

    private Double divPayable;

    private Double othPayable;

    private Double accExp;

    private Double deferredInc;

    private Double stBondsPayable;

    private Double payableToReinsurer;

    private Double rsrvInsurCont;

    private Double actingTradingSec;

    private Double actingUwSec;

    @TableField(value = "non_cur_liab_Due_1y")
    private Double nonCurLiabDue1y;

    private Double othCurLiab;

    private Double totalCurLiab;

    private Double bondPayable;

    private Double ltPayable;

    private Double specificPayables;

    private Double estimatedLiab;

    private Double deferTaxLiab;

    private Double deferIncNonCurLiab;

    private Double othNcl;

    private Double totalNcl;

    private Double deposOthBfi;

    private Double derivLiab;

    private Double depos;

    private Double agencyBusLiab;

    private Double othLiab;

    private Double premReceivAdva;

    private Double deposReceived;

    private Double phInvest;

    private Double reserUnePrem;

    private Double reserOutstdClaims;

    private Double reserLinsLiab;

    private Double reserLthinsLiab;

    private Double indeptAccLiab;

    private Double pledgeBorr;

    private Double indemPayable;

    private Double policyDivPayable;

    private Double totalLiab;

    private Double treasuryShare;

    private Double ordinRiskReser;

    private Double forexDiffer;

    private Double investLossUnconf;

    private Double minorityInt;

    private Double totalHldrEqyExcMinInt;

    private Double totalHldrEqyIncMinInt;

    private Double totalLiabHldrEqy;

    private Double ltPayrollPayable;

    private Double othCompIncome;

    private Double othEqtTools;

    private Double othEqtToolsPShr;

    private Double lendingFunds;

    private Double accReceivable;

    private Double stFinPayable;

    private Double payables;

    private Double hfsAssets;

    private Double hfsSales;

    private Double costFinAssets;

    private Double fairValueFinAssets;

    private Double contractAssets;

    private Double contractLiab;

    private Double accountsReceivBill;

    private Double accountsPay;

    private Double othRcvTotal;

    private Double fixAssetsTotal;

    private Double cipTotal;

    private Double othPayTotal;

    private Double longPayTotal;

    private Double debtInvest;

    private Double othDebtInvest;

    private Integer updateFlag;

    @TableId(value = "balshe_id",type = IdType.AUTO)
    private Integer balsheId;

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

    public Integer getReportType() {
        return reportType;
    }

    public void setReportType(Integer reportType) {
        this.reportType = reportType;
    }
    public Integer getCompType() {
        return compType;
    }

    public void setCompType(Integer compType) {
        this.compType = compType;
    }
    public Integer getEndType() {
        return endType;
    }

    public void setEndType(Integer endType) {
        this.endType = endType;
    }
    public Double getTotalShare() {
        return totalShare;
    }

    public void setTotalShare(Double totalShare) {
        this.totalShare = totalShare;
    }
    public Double getCapRese() {
        return capRese;
    }

    public void setCapRese(Double capRese) {
        this.capRese = capRese;
    }
    public Double getUndistrPorfit() {
        return undistrPorfit;
    }

    public void setUndistrPorfit(Double undistrPorfit) {
        this.undistrPorfit = undistrPorfit;
    }
    public Double getSurplusRese() {
        return surplusRese;
    }

    public void setSurplusRese(Double surplusRese) {
        this.surplusRese = surplusRese;
    }
    public Double getSpecialRese() {
        return specialRese;
    }

    public void setSpecialRese(Double specialRese) {
        this.specialRese = specialRese;
    }
    public Double getMoneyCap() {
        return moneyCap;
    }

    public void setMoneyCap(Double moneyCap) {
        this.moneyCap = moneyCap;
    }
    public Double getTradAsset() {
        return tradAsset;
    }

    public void setTradAsset(Double tradAsset) {
        this.tradAsset = tradAsset;
    }
    public Double getNotesReceiv() {
        return notesReceiv;
    }

    public void setNotesReceiv(Double notesReceiv) {
        this.notesReceiv = notesReceiv;
    }
    public Double getAccountsReceiv() {
        return accountsReceiv;
    }

    public void setAccountsReceiv(Double accountsReceiv) {
        this.accountsReceiv = accountsReceiv;
    }
    public Double getOthReceiv() {
        return othReceiv;
    }

    public void setOthReceiv(Double othReceiv) {
        this.othReceiv = othReceiv;
    }
    public Double getPrepayment() {
        return prepayment;
    }

    public void setPrepayment(Double prepayment) {
        this.prepayment = prepayment;
    }
    public Double getDivReceiv() {
        return divReceiv;
    }

    public void setDivReceiv(Double divReceiv) {
        this.divReceiv = divReceiv;
    }
    public Double getIntReceiv() {
        return intReceiv;
    }

    public void setIntReceiv(Double intReceiv) {
        this.intReceiv = intReceiv;
    }
    public Double getInventories() {
        return inventories;
    }

    public void setInventories(Double inventories) {
        this.inventories = inventories;
    }
    public Double getAmorExp() {
        return amorExp;
    }

    public void setAmorExp(Double amorExp) {
        this.amorExp = amorExp;
    }
    public Double getNcaWithin1y() {
        return ncaWithin1y;
    }

    public void setNcaWithin1y(Double ncaWithin1y) {
        this.ncaWithin1y = ncaWithin1y;
    }
    public Double getSettRsrv() {
        return settRsrv;
    }

    public void setSettRsrv(Double settRsrv) {
        this.settRsrv = settRsrv;
    }
    public Double getLoantoOthBankFi() {
        return loantoOthBankFi;
    }

    public void setLoantoOthBankFi(Double loantoOthBankFi) {
        this.loantoOthBankFi = loantoOthBankFi;
    }
    public Double getPremiumReceiv() {
        return premiumReceiv;
    }

    public void setPremiumReceiv(Double premiumReceiv) {
        this.premiumReceiv = premiumReceiv;
    }
    public Double getReinsurReceiv() {
        return reinsurReceiv;
    }

    public void setReinsurReceiv(Double reinsurReceiv) {
        this.reinsurReceiv = reinsurReceiv;
    }
    public Double getReinsurResReceiv() {
        return reinsurResReceiv;
    }

    public void setReinsurResReceiv(Double reinsurResReceiv) {
        this.reinsurResReceiv = reinsurResReceiv;
    }
    public Double getPurResaleFa() {
        return purResaleFa;
    }

    public void setPurResaleFa(Double purResaleFa) {
        this.purResaleFa = purResaleFa;
    }
    public Double getOthCurAssets() {
        return othCurAssets;
    }

    public void setOthCurAssets(Double othCurAssets) {
        this.othCurAssets = othCurAssets;
    }
    public Double getTotalCurAssets() {
        return totalCurAssets;
    }

    public void setTotalCurAssets(Double totalCurAssets) {
        this.totalCurAssets = totalCurAssets;
    }
    public Double getFaAvailForSale() {
        return faAvailForSale;
    }

    public void setFaAvailForSale(Double faAvailForSale) {
        this.faAvailForSale = faAvailForSale;
    }
    public Double getHtmInvest() {
        return htmInvest;
    }

    public void setHtmInvest(Double htmInvest) {
        this.htmInvest = htmInvest;
    }
    public Double getLtEqtInvest() {
        return ltEqtInvest;
    }

    public void setLtEqtInvest(Double ltEqtInvest) {
        this.ltEqtInvest = ltEqtInvest;
    }
    public Double getInvestRealEstate() {
        return investRealEstate;
    }

    public void setInvestRealEstate(Double investRealEstate) {
        this.investRealEstate = investRealEstate;
    }
    public Double getTimeDeposits() {
        return timeDeposits;
    }

    public void setTimeDeposits(Double timeDeposits) {
        this.timeDeposits = timeDeposits;
    }
    public Double getOthAssets() {
        return othAssets;
    }

    public void setOthAssets(Double othAssets) {
        this.othAssets = othAssets;
    }
    public Double getLtRec() {
        return ltRec;
    }

    public void setLtRec(Double ltRec) {
        this.ltRec = ltRec;
    }
    public Double getFixAssets() {
        return fixAssets;
    }

    public void setFixAssets(Double fixAssets) {
        this.fixAssets = fixAssets;
    }
    public Double getCip() {
        return cip;
    }

    public void setCip(Double cip) {
        this.cip = cip;
    }
    public Double getConstMaterials() {
        return constMaterials;
    }

    public void setConstMaterials(Double constMaterials) {
        this.constMaterials = constMaterials;
    }
    public Double getFixedAssetsDisp() {
        return fixedAssetsDisp;
    }

    public void setFixedAssetsDisp(Double fixedAssetsDisp) {
        this.fixedAssetsDisp = fixedAssetsDisp;
    }
    public Double getProducBioAssets() {
        return producBioAssets;
    }

    public void setProducBioAssets(Double producBioAssets) {
        this.producBioAssets = producBioAssets;
    }
    public Double getOilAndGasAssets() {
        return oilAndGasAssets;
    }

    public void setOilAndGasAssets(Double oilAndGasAssets) {
        this.oilAndGasAssets = oilAndGasAssets;
    }
    public Double getIntanAssets() {
        return intanAssets;
    }

    public void setIntanAssets(Double intanAssets) {
        this.intanAssets = intanAssets;
    }
    public Double getrAndD() {
        return rAndD;
    }

    public void setrAndD(Double rAndD) {
        this.rAndD = rAndD;
    }
    public Double getGoodwill() {
        return goodwill;
    }

    public void setGoodwill(Double goodwill) {
        this.goodwill = goodwill;
    }
    public Double getLtAmorExp() {
        return ltAmorExp;
    }

    public void setLtAmorExp(Double ltAmorExp) {
        this.ltAmorExp = ltAmorExp;
    }
    public Double getDeferTaxAssets() {
        return deferTaxAssets;
    }

    public void setDeferTaxAssets(Double deferTaxAssets) {
        this.deferTaxAssets = deferTaxAssets;
    }
    public Double getDecrInDisbur() {
        return decrInDisbur;
    }

    public void setDecrInDisbur(Double decrInDisbur) {
        this.decrInDisbur = decrInDisbur;
    }
    public Double getOthNca() {
        return othNca;
    }

    public void setOthNca(Double othNca) {
        this.othNca = othNca;
    }
    public Double getTotalNca() {
        return totalNca;
    }

    public void setTotalNca(Double totalNca) {
        this.totalNca = totalNca;
    }
    public Double getCashReserCb() {
        return cashReserCb;
    }

    public void setCashReserCb(Double cashReserCb) {
        this.cashReserCb = cashReserCb;
    }
    public Double getDeposInOthBfi() {
        return deposInOthBfi;
    }

    public void setDeposInOthBfi(Double deposInOthBfi) {
        this.deposInOthBfi = deposInOthBfi;
    }
    public Double getPrecMetals() {
        return precMetals;
    }

    public void setPrecMetals(Double precMetals) {
        this.precMetals = precMetals;
    }
    public Double getDerivAssets() {
        return derivAssets;
    }

    public void setDerivAssets(Double derivAssets) {
        this.derivAssets = derivAssets;
    }
    public Double getRrReinsUnePrem() {
        return rrReinsUnePrem;
    }

    public void setRrReinsUnePrem(Double rrReinsUnePrem) {
        this.rrReinsUnePrem = rrReinsUnePrem;
    }
    public Double getRrReinsOutstdCla() {
        return rrReinsOutstdCla;
    }

    public void setRrReinsOutstdCla(Double rrReinsOutstdCla) {
        this.rrReinsOutstdCla = rrReinsOutstdCla;
    }
    public Double getRrReinsLinsLiab() {
        return rrReinsLinsLiab;
    }

    public void setRrReinsLinsLiab(Double rrReinsLinsLiab) {
        this.rrReinsLinsLiab = rrReinsLinsLiab;
    }
    public Double getRrReinsLthinsLiab() {
        return rrReinsLthinsLiab;
    }

    public void setRrReinsLthinsLiab(Double rrReinsLthinsLiab) {
        this.rrReinsLthinsLiab = rrReinsLthinsLiab;
    }
    public Double getRefundDepos() {
        return refundDepos;
    }

    public void setRefundDepos(Double refundDepos) {
        this.refundDepos = refundDepos;
    }
    public Double getPhPledgeLoans() {
        return phPledgeLoans;
    }

    public void setPhPledgeLoans(Double phPledgeLoans) {
        this.phPledgeLoans = phPledgeLoans;
    }
    public Double getRefundCapDepos() {
        return refundCapDepos;
    }

    public void setRefundCapDepos(Double refundCapDepos) {
        this.refundCapDepos = refundCapDepos;
    }
    public Double getIndepAcctAssets() {
        return indepAcctAssets;
    }

    public void setIndepAcctAssets(Double indepAcctAssets) {
        this.indepAcctAssets = indepAcctAssets;
    }
    public Double getClientDepos() {
        return clientDepos;
    }

    public void setClientDepos(Double clientDepos) {
        this.clientDepos = clientDepos;
    }
    public Double getClientProv() {
        return clientProv;
    }

    public void setClientProv(Double clientProv) {
        this.clientProv = clientProv;
    }
    public Double getTransacSeatFee() {
        return transacSeatFee;
    }

    public void setTransacSeatFee(Double transacSeatFee) {
        this.transacSeatFee = transacSeatFee;
    }
    public Double getInvestAsReceiv() {
        return investAsReceiv;
    }

    public void setInvestAsReceiv(Double investAsReceiv) {
        this.investAsReceiv = investAsReceiv;
    }
    public Double getTotalAssets() {
        return totalAssets;
    }

    public void setTotalAssets(Double totalAssets) {
        this.totalAssets = totalAssets;
    }
    public Double getLtBorr() {
        return ltBorr;
    }

    public void setLtBorr(Double ltBorr) {
        this.ltBorr = ltBorr;
    }
    public Double getStBorr() {
        return stBorr;
    }

    public void setStBorr(Double stBorr) {
        this.stBorr = stBorr;
    }
    public Double getCbBorr() {
        return cbBorr;
    }

    public void setCbBorr(Double cbBorr) {
        this.cbBorr = cbBorr;
    }
    public Double getDeposIbDeposits() {
        return deposIbDeposits;
    }

    public void setDeposIbDeposits(Double deposIbDeposits) {
        this.deposIbDeposits = deposIbDeposits;
    }
    public Double getLoanOthBank() {
        return loanOthBank;
    }

    public void setLoanOthBank(Double loanOthBank) {
        this.loanOthBank = loanOthBank;
    }
    public Double getTradingFl() {
        return tradingFl;
    }

    public void setTradingFl(Double tradingFl) {
        this.tradingFl = tradingFl;
    }
    public Double getNotesPayable() {
        return notesPayable;
    }

    public void setNotesPayable(Double notesPayable) {
        this.notesPayable = notesPayable;
    }
    public Double getAcctPayable() {
        return acctPayable;
    }

    public void setAcctPayable(Double acctPayable) {
        this.acctPayable = acctPayable;
    }
    public Double getAdvReceipts() {
        return advReceipts;
    }

    public void setAdvReceipts(Double advReceipts) {
        this.advReceipts = advReceipts;
    }
    public Double getSoldForRepurFa() {
        return soldForRepurFa;
    }

    public void setSoldForRepurFa(Double soldForRepurFa) {
        this.soldForRepurFa = soldForRepurFa;
    }
    public Double getCommPayable() {
        return commPayable;
    }

    public void setCommPayable(Double commPayable) {
        this.commPayable = commPayable;
    }
    public Double getPayrollPayable() {
        return payrollPayable;
    }

    public void setPayrollPayable(Double payrollPayable) {
        this.payrollPayable = payrollPayable;
    }
    public Double getTaxesPayable() {
        return taxesPayable;
    }

    public void setTaxesPayable(Double taxesPayable) {
        this.taxesPayable = taxesPayable;
    }
    public Double getIntPayable() {
        return intPayable;
    }

    public void setIntPayable(Double intPayable) {
        this.intPayable = intPayable;
    }
    public Double getDivPayable() {
        return divPayable;
    }

    public void setDivPayable(Double divPayable) {
        this.divPayable = divPayable;
    }
    public Double getOthPayable() {
        return othPayable;
    }

    public void setOthPayable(Double othPayable) {
        this.othPayable = othPayable;
    }
    public Double getAccExp() {
        return accExp;
    }

    public void setAccExp(Double accExp) {
        this.accExp = accExp;
    }
    public Double getDeferredInc() {
        return deferredInc;
    }

    public void setDeferredInc(Double deferredInc) {
        this.deferredInc = deferredInc;
    }
    public Double getStBondsPayable() {
        return stBondsPayable;
    }

    public void setStBondsPayable(Double stBondsPayable) {
        this.stBondsPayable = stBondsPayable;
    }
    public Double getPayableToReinsurer() {
        return payableToReinsurer;
    }

    public void setPayableToReinsurer(Double payableToReinsurer) {
        this.payableToReinsurer = payableToReinsurer;
    }
    public Double getRsrvInsurCont() {
        return rsrvInsurCont;
    }

    public void setRsrvInsurCont(Double rsrvInsurCont) {
        this.rsrvInsurCont = rsrvInsurCont;
    }
    public Double getActingTradingSec() {
        return actingTradingSec;
    }

    public void setActingTradingSec(Double actingTradingSec) {
        this.actingTradingSec = actingTradingSec;
    }
    public Double getActingUwSec() {
        return actingUwSec;
    }

    public void setActingUwSec(Double actingUwSec) {
        this.actingUwSec = actingUwSec;
    }
    public Double getNonCurLiabDue1y() {
        return nonCurLiabDue1y;
    }

    public void setNonCurLiabDue1y(Double nonCurLiabDue1y) {
        this.nonCurLiabDue1y = nonCurLiabDue1y;
    }
    public Double getOthCurLiab() {
        return othCurLiab;
    }

    public void setOthCurLiab(Double othCurLiab) {
        this.othCurLiab = othCurLiab;
    }
    public Double getTotalCurLiab() {
        return totalCurLiab;
    }

    public void setTotalCurLiab(Double totalCurLiab) {
        this.totalCurLiab = totalCurLiab;
    }
    public Double getBondPayable() {
        return bondPayable;
    }

    public void setBondPayable(Double bondPayable) {
        this.bondPayable = bondPayable;
    }
    public Double getLtPayable() {
        return ltPayable;
    }

    public void setLtPayable(Double ltPayable) {
        this.ltPayable = ltPayable;
    }
    public Double getSpecificPayables() {
        return specificPayables;
    }

    public void setSpecificPayables(Double specificPayables) {
        this.specificPayables = specificPayables;
    }
    public Double getEstimatedLiab() {
        return estimatedLiab;
    }

    public void setEstimatedLiab(Double estimatedLiab) {
        this.estimatedLiab = estimatedLiab;
    }
    public Double getDeferTaxLiab() {
        return deferTaxLiab;
    }

    public void setDeferTaxLiab(Double deferTaxLiab) {
        this.deferTaxLiab = deferTaxLiab;
    }
    public Double getDeferIncNonCurLiab() {
        return deferIncNonCurLiab;
    }

    public void setDeferIncNonCurLiab(Double deferIncNonCurLiab) {
        this.deferIncNonCurLiab = deferIncNonCurLiab;
    }
    public Double getOthNcl() {
        return othNcl;
    }

    public void setOthNcl(Double othNcl) {
        this.othNcl = othNcl;
    }
    public Double getTotalNcl() {
        return totalNcl;
    }

    public void setTotalNcl(Double totalNcl) {
        this.totalNcl = totalNcl;
    }
    public Double getDeposOthBfi() {
        return deposOthBfi;
    }

    public void setDeposOthBfi(Double deposOthBfi) {
        this.deposOthBfi = deposOthBfi;
    }
    public Double getDerivLiab() {
        return derivLiab;
    }

    public void setDerivLiab(Double derivLiab) {
        this.derivLiab = derivLiab;
    }
    public Double getDepos() {
        return depos;
    }

    public void setDepos(Double depos) {
        this.depos = depos;
    }
    public Double getAgencyBusLiab() {
        return agencyBusLiab;
    }

    public void setAgencyBusLiab(Double agencyBusLiab) {
        this.agencyBusLiab = agencyBusLiab;
    }
    public Double getOthLiab() {
        return othLiab;
    }

    public void setOthLiab(Double othLiab) {
        this.othLiab = othLiab;
    }
    public Double getPremReceivAdva() {
        return premReceivAdva;
    }

    public void setPremReceivAdva(Double premReceivAdva) {
        this.premReceivAdva = premReceivAdva;
    }
    public Double getDeposReceived() {
        return deposReceived;
    }

    public void setDeposReceived(Double deposReceived) {
        this.deposReceived = deposReceived;
    }
    public Double getPhInvest() {
        return phInvest;
    }

    public void setPhInvest(Double phInvest) {
        this.phInvest = phInvest;
    }
    public Double getReserUnePrem() {
        return reserUnePrem;
    }

    public void setReserUnePrem(Double reserUnePrem) {
        this.reserUnePrem = reserUnePrem;
    }
    public Double getReserOutstdClaims() {
        return reserOutstdClaims;
    }

    public void setReserOutstdClaims(Double reserOutstdClaims) {
        this.reserOutstdClaims = reserOutstdClaims;
    }
    public Double getReserLinsLiab() {
        return reserLinsLiab;
    }

    public void setReserLinsLiab(Double reserLinsLiab) {
        this.reserLinsLiab = reserLinsLiab;
    }
    public Double getReserLthinsLiab() {
        return reserLthinsLiab;
    }

    public void setReserLthinsLiab(Double reserLthinsLiab) {
        this.reserLthinsLiab = reserLthinsLiab;
    }
    public Double getIndeptAccLiab() {
        return indeptAccLiab;
    }

    public void setIndeptAccLiab(Double indeptAccLiab) {
        this.indeptAccLiab = indeptAccLiab;
    }
    public Double getPledgeBorr() {
        return pledgeBorr;
    }

    public void setPledgeBorr(Double pledgeBorr) {
        this.pledgeBorr = pledgeBorr;
    }
    public Double getIndemPayable() {
        return indemPayable;
    }

    public void setIndemPayable(Double indemPayable) {
        this.indemPayable = indemPayable;
    }
    public Double getPolicyDivPayable() {
        return policyDivPayable;
    }

    public void setPolicyDivPayable(Double policyDivPayable) {
        this.policyDivPayable = policyDivPayable;
    }
    public Double getTotalLiab() {
        return totalLiab;
    }

    public void setTotalLiab(Double totalLiab) {
        this.totalLiab = totalLiab;
    }
    public Double getTreasuryShare() {
        return treasuryShare;
    }

    public void setTreasuryShare(Double treasuryShare) {
        this.treasuryShare = treasuryShare;
    }
    public Double getOrdinRiskReser() {
        return ordinRiskReser;
    }

    public void setOrdinRiskReser(Double ordinRiskReser) {
        this.ordinRiskReser = ordinRiskReser;
    }
    public Double getForexDiffer() {
        return forexDiffer;
    }

    public void setForexDiffer(Double forexDiffer) {
        this.forexDiffer = forexDiffer;
    }
    public Double getInvestLossUnconf() {
        return investLossUnconf;
    }

    public void setInvestLossUnconf(Double investLossUnconf) {
        this.investLossUnconf = investLossUnconf;
    }
    public Double getMinorityInt() {
        return minorityInt;
    }

    public void setMinorityInt(Double minorityInt) {
        this.minorityInt = minorityInt;
    }
    public Double getTotalHldrEqyExcMinInt() {
        return totalHldrEqyExcMinInt;
    }

    public void setTotalHldrEqyExcMinInt(Double totalHldrEqyExcMinInt) {
        this.totalHldrEqyExcMinInt = totalHldrEqyExcMinInt;
    }
    public Double getTotalHldrEqyIncMinInt() {
        return totalHldrEqyIncMinInt;
    }

    public void setTotalHldrEqyIncMinInt(Double totalHldrEqyIncMinInt) {
        this.totalHldrEqyIncMinInt = totalHldrEqyIncMinInt;
    }
    public Double getTotalLiabHldrEqy() {
        return totalLiabHldrEqy;
    }

    public void setTotalLiabHldrEqy(Double totalLiabHldrEqy) {
        this.totalLiabHldrEqy = totalLiabHldrEqy;
    }
    public Double getLtPayrollPayable() {
        return ltPayrollPayable;
    }

    public void setLtPayrollPayable(Double ltPayrollPayable) {
        this.ltPayrollPayable = ltPayrollPayable;
    }
    public Double getOthCompIncome() {
        return othCompIncome;
    }

    public void setOthCompIncome(Double othCompIncome) {
        this.othCompIncome = othCompIncome;
    }
    public Double getOthEqtTools() {
        return othEqtTools;
    }

    public void setOthEqtTools(Double othEqtTools) {
        this.othEqtTools = othEqtTools;
    }
    public Double getOthEqtToolsPShr() {
        return othEqtToolsPShr;
    }

    public void setOthEqtToolsPShr(Double othEqtToolsPShr) {
        this.othEqtToolsPShr = othEqtToolsPShr;
    }
    public Double getLendingFunds() {
        return lendingFunds;
    }

    public void setLendingFunds(Double lendingFunds) {
        this.lendingFunds = lendingFunds;
    }
    public Double getAccReceivable() {
        return accReceivable;
    }

    public void setAccReceivable(Double accReceivable) {
        this.accReceivable = accReceivable;
    }
    public Double getStFinPayable() {
        return stFinPayable;
    }

    public void setStFinPayable(Double stFinPayable) {
        this.stFinPayable = stFinPayable;
    }
    public Double getPayables() {
        return payables;
    }

    public void setPayables(Double payables) {
        this.payables = payables;
    }
    public Double getHfsAssets() {
        return hfsAssets;
    }

    public void setHfsAssets(Double hfsAssets) {
        this.hfsAssets = hfsAssets;
    }
    public Double getHfsSales() {
        return hfsSales;
    }

    public void setHfsSales(Double hfsSales) {
        this.hfsSales = hfsSales;
    }
    public Double getCostFinAssets() {
        return costFinAssets;
    }

    public void setCostFinAssets(Double costFinAssets) {
        this.costFinAssets = costFinAssets;
    }
    public Double getFairValueFinAssets() {
        return fairValueFinAssets;
    }

    public void setFairValueFinAssets(Double fairValueFinAssets) {
        this.fairValueFinAssets = fairValueFinAssets;
    }
    public Double getContractAssets() {
        return contractAssets;
    }

    public void setContractAssets(Double contractAssets) {
        this.contractAssets = contractAssets;
    }
    public Double getContractLiab() {
        return contractLiab;
    }

    public void setContractLiab(Double contractLiab) {
        this.contractLiab = contractLiab;
    }
    public Double getAccountsReceivBill() {
        return accountsReceivBill;
    }

    public void setAccountsReceivBill(Double accountsReceivBill) {
        this.accountsReceivBill = accountsReceivBill;
    }
    public Double getAccountsPay() {
        return accountsPay;
    }

    public void setAccountsPay(Double accountsPay) {
        this.accountsPay = accountsPay;
    }
    public Double getOthRcvTotal() {
        return othRcvTotal;
    }

    public void setOthRcvTotal(Double othRcvTotal) {
        this.othRcvTotal = othRcvTotal;
    }
    public Double getFixAssetsTotal() {
        return fixAssetsTotal;
    }

    public void setFixAssetsTotal(Double fixAssetsTotal) {
        this.fixAssetsTotal = fixAssetsTotal;
    }
    public Double getCipTotal() {
        return cipTotal;
    }

    public void setCipTotal(Double cipTotal) {
        this.cipTotal = cipTotal;
    }
    public Double getOthPayTotal() {
        return othPayTotal;
    }

    public void setOthPayTotal(Double othPayTotal) {
        this.othPayTotal = othPayTotal;
    }
    public Double getLongPayTotal() {
        return longPayTotal;
    }

    public void setLongPayTotal(Double longPayTotal) {
        this.longPayTotal = longPayTotal;
    }
    public Double getDebtInvest() {
        return debtInvest;
    }

    public void setDebtInvest(Double debtInvest) {
        this.debtInvest = debtInvest;
    }
    public Double getOthDebtInvest() {
        return othDebtInvest;
    }

    public void setOthDebtInvest(Double othDebtInvest) {
        this.othDebtInvest = othDebtInvest;
    }
    public Integer getUpdateFlag() {
        return updateFlag;
    }

    public void setUpdateFlag(Integer updateFlag) {
        this.updateFlag = updateFlag;
    }

    @Override
    public String toString() {
        return "BalanceSheet{" +
            "tsCode=" + tsCode +
            ", annDate=" + annDate +
            ", fAnnDate=" + fAnnDate +
            ", endDate=" + endDate +
            ", reportType=" + reportType +
            ", compType=" + compType +
            ", endType=" + endType +
            ", totalShare=" + totalShare +
            ", capRese=" + capRese +
            ", undistrPorfit=" + undistrPorfit +
            ", surplusRese=" + surplusRese +
            ", specialRese=" + specialRese +
            ", moneyCap=" + moneyCap +
            ", tradAsset=" + tradAsset +
            ", notesReceiv=" + notesReceiv +
            ", accountsReceiv=" + accountsReceiv +
            ", othReceiv=" + othReceiv +
            ", prepayment=" + prepayment +
            ", divReceiv=" + divReceiv +
            ", intReceiv=" + intReceiv +
            ", inventories=" + inventories +
            ", amorExp=" + amorExp +
            ", ncaWithin1y=" + ncaWithin1y +
            ", settRsrv=" + settRsrv +
            ", loantoOthBankFi=" + loantoOthBankFi +
            ", premiumReceiv=" + premiumReceiv +
            ", reinsurReceiv=" + reinsurReceiv +
            ", reinsurResReceiv=" + reinsurResReceiv +
            ", purResaleFa=" + purResaleFa +
            ", othCurAssets=" + othCurAssets +
            ", totalCurAssets=" + totalCurAssets +
            ", faAvailForSale=" + faAvailForSale +
            ", htmInvest=" + htmInvest +
            ", ltEqtInvest=" + ltEqtInvest +
            ", investRealEstate=" + investRealEstate +
            ", timeDeposits=" + timeDeposits +
            ", othAssets=" + othAssets +
            ", ltRec=" + ltRec +
            ", fixAssets=" + fixAssets +
            ", cip=" + cip +
            ", constMaterials=" + constMaterials +
            ", fixedAssetsDisp=" + fixedAssetsDisp +
            ", producBioAssets=" + producBioAssets +
            ", oilAndGasAssets=" + oilAndGasAssets +
            ", intanAssets=" + intanAssets +
            ", rAndD=" + rAndD +
            ", goodwill=" + goodwill +
            ", ltAmorExp=" + ltAmorExp +
            ", deferTaxAssets=" + deferTaxAssets +
            ", decrInDisbur=" + decrInDisbur +
            ", othNca=" + othNca +
            ", totalNca=" + totalNca +
            ", cashReserCb=" + cashReserCb +
            ", deposInOthBfi=" + deposInOthBfi +
            ", precMetals=" + precMetals +
            ", derivAssets=" + derivAssets +
            ", rrReinsUnePrem=" + rrReinsUnePrem +
            ", rrReinsOutstdCla=" + rrReinsOutstdCla +
            ", rrReinsLinsLiab=" + rrReinsLinsLiab +
            ", rrReinsLthinsLiab=" + rrReinsLthinsLiab +
            ", refundDepos=" + refundDepos +
            ", phPledgeLoans=" + phPledgeLoans +
            ", refundCapDepos=" + refundCapDepos +
            ", indepAcctAssets=" + indepAcctAssets +
            ", clientDepos=" + clientDepos +
            ", clientProv=" + clientProv +
            ", transacSeatFee=" + transacSeatFee +
            ", investAsReceiv=" + investAsReceiv +
            ", totalAssets=" + totalAssets +
            ", ltBorr=" + ltBorr +
            ", stBorr=" + stBorr +
            ", cbBorr=" + cbBorr +
            ", deposIbDeposits=" + deposIbDeposits +
            ", loanOthBank=" + loanOthBank +
            ", tradingFl=" + tradingFl +
            ", notesPayable=" + notesPayable +
            ", acctPayable=" + acctPayable +
            ", advReceipts=" + advReceipts +
            ", soldForRepurFa=" + soldForRepurFa +
            ", commPayable=" + commPayable +
            ", payrollPayable=" + payrollPayable +
            ", taxesPayable=" + taxesPayable +
            ", intPayable=" + intPayable +
            ", divPayable=" + divPayable +
            ", othPayable=" + othPayable +
            ", accExp=" + accExp +
            ", deferredInc=" + deferredInc +
            ", stBondsPayable=" + stBondsPayable +
            ", payableToReinsurer=" + payableToReinsurer +
            ", rsrvInsurCont=" + rsrvInsurCont +
            ", actingTradingSec=" + actingTradingSec +
            ", actingUwSec=" + actingUwSec +
            ", nonCurLiabDue1y=" + nonCurLiabDue1y +
            ", othCurLiab=" + othCurLiab +
            ", totalCurLiab=" + totalCurLiab +
            ", bondPayable=" + bondPayable +
            ", ltPayable=" + ltPayable +
            ", specificPayables=" + specificPayables +
            ", estimatedLiab=" + estimatedLiab +
            ", deferTaxLiab=" + deferTaxLiab +
            ", deferIncNonCurLiab=" + deferIncNonCurLiab +
            ", othNcl=" + othNcl +
            ", totalNcl=" + totalNcl +
            ", deposOthBfi=" + deposOthBfi +
            ", derivLiab=" + derivLiab +
            ", depos=" + depos +
            ", agencyBusLiab=" + agencyBusLiab +
            ", othLiab=" + othLiab +
            ", premReceivAdva=" + premReceivAdva +
            ", deposReceived=" + deposReceived +
            ", phInvest=" + phInvest +
            ", reserUnePrem=" + reserUnePrem +
            ", reserOutstdClaims=" + reserOutstdClaims +
            ", reserLinsLiab=" + reserLinsLiab +
            ", reserLthinsLiab=" + reserLthinsLiab +
            ", indeptAccLiab=" + indeptAccLiab +
            ", pledgeBorr=" + pledgeBorr +
            ", indemPayable=" + indemPayable +
            ", policyDivPayable=" + policyDivPayable +
            ", totalLiab=" + totalLiab +
            ", treasuryShare=" + treasuryShare +
            ", ordinRiskReser=" + ordinRiskReser +
            ", forexDiffer=" + forexDiffer +
            ", investLossUnconf=" + investLossUnconf +
            ", minorityInt=" + minorityInt +
            ", totalHldrEqyExcMinInt=" + totalHldrEqyExcMinInt +
            ", totalHldrEqyIncMinInt=" + totalHldrEqyIncMinInt +
            ", totalLiabHldrEqy=" + totalLiabHldrEqy +
            ", ltPayrollPayable=" + ltPayrollPayable +
            ", othCompIncome=" + othCompIncome +
            ", othEqtTools=" + othEqtTools +
            ", othEqtToolsPShr=" + othEqtToolsPShr +
            ", lendingFunds=" + lendingFunds +
            ", accReceivable=" + accReceivable +
            ", stFinPayable=" + stFinPayable +
            ", payables=" + payables +
            ", hfsAssets=" + hfsAssets +
            ", hfsSales=" + hfsSales +
            ", costFinAssets=" + costFinAssets +
            ", fairValueFinAssets=" + fairValueFinAssets +
            ", contractAssets=" + contractAssets +
            ", contractLiab=" + contractLiab +
            ", accountsReceivBill=" + accountsReceivBill +
            ", accountsPay=" + accountsPay +
            ", othRcvTotal=" + othRcvTotal +
            ", fixAssetsTotal=" + fixAssetsTotal +
            ", cipTotal=" + cipTotal +
            ", othPayTotal=" + othPayTotal +
            ", longPayTotal=" + longPayTotal +
            ", debtInvest=" + debtInvest +
            ", othDebtInvest=" + othDebtInvest +
            ", updateFlag=" + updateFlag +
                ",balsheId="+balsheId+
        "}";
    }
}
