package com.neusoft.bsp.MVO.vo;

import com.neusoft.bsp.MVO.entity.Product;
import com.neusoft.bsp.MVO.entity.SalesOrder;
import com.neusoft.bsp.MVO.entity.SalesOrderLineItem;
import com.neusoft.bsp.MVO.service.SalesOrderLineItemService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;

public class SalesOrderVo {
    int qty;
    double price;
    String title;
    String sku;
    String orderNo;
    Date createdTime;
    String trackingNo;
    String orderSts;
    String wspName;


    @Override
    public String toString() {
        return "SalesOrderVo{" +
                "qty=" + qty +
                ", price=" + price +
                ", title='" + title + '\'' +
                ", sku='" + sku + '\'' +
                ", orderNo='" + orderNo + '\'' +
                ", createdTime=" + createdTime +
                ", trackingNo='" + trackingNo + '\'' +
                ", orderSts='" + orderSts + '\'' +
                ", wspName='" + wspName + '\'' +
                '}';
    }

    public String getWspName() {
        return wspName;
    }

    public void setWspName(String wspName) {
        this.wspName = wspName;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public Date getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }

    public String getTrackingNo() {
        return trackingNo;
    }

    public void setTrackingNo(String trackingNo) {
        this.trackingNo = trackingNo;
    }

    public String getOrderSts() {
        return orderSts;
    }

    public void setOrderSts(String orderSts) {
        this.orderSts = orderSts;
    }

    public SalesOrderLineItem toSalesOrderLineItem(){
        SalesOrderLineItem salesOrderLineItem=new SalesOrderLineItem();
        salesOrderLineItem.setQty(this.getQty());
        salesOrderLineItem.setTrackingNo(this.getTrackingNo());
        salesOrderLineItem.setPrice(this.getPrice());
        salesOrderLineItem.setWspName(this.getWspName());
        return  salesOrderLineItem;
    }

    public SalesOrderLineItem changeSalesOrderLineItem(SalesOrderLineItem salesOrderLineItem){
        salesOrderLineItem.setQty(this.getQty());
        salesOrderLineItem.setTrackingNo(this.getTrackingNo());
        salesOrderLineItem.setPrice(this.getPrice());
        salesOrderLineItem.setWspName(this.getWspName());
        return  salesOrderLineItem;
    }

    public SalesOrder changeSalesOrder(SalesOrder salesOrder){
        salesOrder.setOrderNo(this.getOrderNo());
        salesOrder.setOrderSts(this.getOrderSts());
        return salesOrder;
    }


}
