package com.neusoft.bsp.MVO.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * (Sao)实体类
 *
 * @author makejava
 * @since 2020-07-13 14:48:10
 */
public class SalesOrder implements Serializable {
    private static final long serialVersionUID = -78918870667842795L;

    private Integer saoId;

    private String createdBy;

    private Date creationDate;

    private String lastUpdateBy;

    private Date lastUpdateDate;

    private Integer callCnt;

    private String remark;

    private String stsCd;

    private Integer manId;

    private Integer warId;

    private Date syncDate;

    private Date paymentDate;

    private Date pushDate;

    private Date trackNoDate;

    private Date fulfillmentDate;

    private Date settlementDate;

    private Double productAmount;

    private Double freightCost;

    private Double handlingFee;

    private String customerRemark;

    private String orderNo;

    private String orderSts;

    private String refundSts;

    private String deliverySts;

    private Integer stoId;

    private Double lastFreightCost;

    private Date cancleTime;

    private String autoPayStatus;

    private String buyerCheckoutMessage;

    private String autoPayTime;


    public Integer getSaoId() {
        return saoId;
    }

    public void setSaoId(Integer saoId) {
        this.saoId = saoId;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public String getLastUpdateBy() {
        return lastUpdateBy;
    }

    public void setLastUpdateBy(String lastUpdateBy) {
        this.lastUpdateBy = lastUpdateBy;
    }

    public Date getLastUpdateDate() {
        return lastUpdateDate;
    }

    public void setLastUpdateDate(Date lastUpdateDate) {
        this.lastUpdateDate = lastUpdateDate;
    }

    public Integer getCallCnt() {
        return callCnt;
    }

    public void setCallCnt(Integer callCnt) {
        this.callCnt = callCnt;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getStsCd() {
        return stsCd;
    }

    public void setStsCd(String stsCd) {
        this.stsCd = stsCd;
    }

    public Integer getManId() {
        return manId;
    }

    public void setManId(Integer manId) {
        this.manId = manId;
    }

    public Integer getWarId() {
        return warId;
    }

    public void setWarId(Integer warId) {
        this.warId = warId;
    }

    public Date getSyncDate() {
        return syncDate;
    }

    public void setSyncDate(Date syncDate) {
        this.syncDate = syncDate;
    }

    public Date getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(Date paymentDate) {
        this.paymentDate = paymentDate;
    }

    public Date getPushDate() {
        return pushDate;
    }

    public void setPushDate(Date pushDate) {
        this.pushDate = pushDate;
    }

    public Date getTrackNoDate() {
        return trackNoDate;
    }

    public void setTrackNoDate(Date trackNoDate) {
        this.trackNoDate = trackNoDate;
    }

    public Date getFulfillmentDate() {
        return fulfillmentDate;
    }

    public void setFulfillmentDate(Date fulfillmentDate) {
        this.fulfillmentDate = fulfillmentDate;
    }

    public Date getSettlementDate() {
        return settlementDate;
    }

    public void setSettlementDate(Date settlementDate) {
        this.settlementDate = settlementDate;
    }

    public Double getProductAmount() {
        return productAmount;
    }

    public void setProductAmount(Double productAmount) {
        this.productAmount = productAmount;
    }

    public Double getFreightCost() {
        return freightCost;
    }

    public void setFreightCost(Double freightCost) {
        this.freightCost = freightCost;
    }

    public Double getHandlingFee() {
        return handlingFee;
    }

    public void setHandlingFee(Double handlingFee) {
        this.handlingFee = handlingFee;
    }

    public String getCustomerRemark() {
        return customerRemark;
    }

    public void setCustomerRemark(String customerRemark) {
        this.customerRemark = customerRemark;
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public String getOrderSts() {
        return orderSts;
    }

    public void setOrderSts(String orderSts) {
        this.orderSts = orderSts;
    }

    public String getRefundSts() {
        return refundSts;
    }

    public void setRefundSts(String refundSts) {
        this.refundSts = refundSts;
    }

    public String getDeliverySts() {
        return deliverySts;
    }

    public void setDeliverySts(String deliverySts) {
        this.deliverySts = deliverySts;
    }

    public Integer getStoId() {
        return stoId;
    }

    public void setStoId(Integer stoId) {
        this.stoId = stoId;
    }

    public Double getLastFreightCost() {
        return lastFreightCost;
    }

    public void setLastFreightCost(Double lastFreightCost) {
        this.lastFreightCost = lastFreightCost;
    }

    public Date getCancleTime() {
        return cancleTime;
    }

    public void setCancleTime(Date cancleTime) {
        this.cancleTime = cancleTime;
    }

    public String getAutoPayStatus() {
        return autoPayStatus;
    }

    public void setAutoPayStatus(String autoPayStatus) {
        this.autoPayStatus = autoPayStatus;
    }

    public String getBuyerCheckoutMessage() {
        return buyerCheckoutMessage;
    }

    public void setBuyerCheckoutMessage(String buyerCheckoutMessage) {
        this.buyerCheckoutMessage = buyerCheckoutMessage;
    }

    public String getAutoPayTime() {
        return autoPayTime;
    }

    public void setAutoPayTime(String autoPayTime) {
        this.autoPayTime = autoPayTime;
    }

    @Override
    public String toString() {
        return "SalesOrder{" +
                "saoId=" + saoId +
                ", createdBy='" + createdBy + '\'' +
                ", creationDate=" + creationDate +
                ", lastUpdateBy='" + lastUpdateBy + '\'' +
                ", lastUpdateDate=" + lastUpdateDate +
                ", callCnt=" + callCnt +
                ", remark='" + remark + '\'' +
                ", stsCd='" + stsCd + '\'' +
                ", manId=" + manId +
                ", warId=" + warId +
                ", syncDate=" + syncDate +
                ", paymentDate=" + paymentDate +
                ", pushDate=" + pushDate +
                ", trackNoDate=" + trackNoDate +
                ", fulfillmentDate=" + fulfillmentDate +
                ", settlementDate=" + settlementDate +
                ", productAmount=" + productAmount +
                ", freightCost=" + freightCost +
                ", handlingFee=" + handlingFee +
                ", customerRemark='" + customerRemark + '\'' +
                ", orderNo='" + orderNo + '\'' +
                ", orderSts='" + orderSts + '\'' +
                ", refundSts='" + refundSts + '\'' +
                ", deliverySts='" + deliverySts + '\'' +
                ", stoId=" + stoId +
                ", lastFreightCost=" + lastFreightCost +
                ", cancleTime=" + cancleTime +
                ", autoPayStatus='" + autoPayStatus + '\'' +
                ", buyerCheckoutMessage='" + buyerCheckoutMessage + '\'' +
                ", autoPayTime='" + autoPayTime + '\'' +
                '}';
    }
}