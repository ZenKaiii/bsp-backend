package com.neusoft.bsp.MVO.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * (Sal)实体类
 *
 * @author makejava
 * @since 2020-07-13 14:49:52
 */
public class SalesOrderLineItem
        implements Serializable {
    private static final long serialVersionUID = -31742530324040090L;

    private Integer salId;

    private String createdBy;

    private Date creationDate;

    private String lastUpdateBy;

    private Date lastUpdateDate;

    private Integer callCnt;

    private String remark;

    private String stsCd;

    private Integer saoId;

    private Integer proId;

    private Integer qty;

    private Double price;

    private Integer solId;

    private String trackingNo;

    private String wspName;


    public Integer getSalId() {
        return salId;
    }

    public void setSalId(Integer salId) {
        this.salId = salId;
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

    public Integer getSaoId() {
        return saoId;
    }

    public void setSaoId(Integer saoId) {
        this.saoId = saoId;
    }

    public Integer getProId() {
        return proId;
    }

    public void setProId(Integer proId) {
        this.proId = proId;
    }

    public Integer getQty() {
        return qty;
    }

    public void setQty(Integer qty) {
        this.qty = qty;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getSolId() {
        return solId;
    }

    public void setSolId(Integer solId) {
        this.solId = solId;
    }

    public String getTrackingNo() {
        return trackingNo;
    }

    public void setTrackingNo(String trackingNo) {
        this.trackingNo = trackingNo;
    }

    public String getWspName() {
        return wspName;
    }

    public void setWspName(String wspName) {
        this.wspName = wspName;
    }

    @Override
    public String toString() {
        return "SalesOrderLineItem{" +
                "salId=" + salId +
                ", createdBy='" + createdBy + '\'' +
                ", creationDate=" + creationDate +
                ", lastUpdateBy='" + lastUpdateBy + '\'' +
                ", lastUpdateDate=" + lastUpdateDate +
                ", callCnt=" + callCnt +
                ", remark='" + remark + '\'' +
                ", stsCd='" + stsCd + '\'' +
                ", saoId=" + saoId +
                ", proId=" + proId +
                ", qty=" + qty +
                ", price=" + price +
                ", solId=" + solId +
                ", trackingNo='" + trackingNo + '\'' +
                ", wspName='" + wspName + '\'' +
                '}';
    }
}