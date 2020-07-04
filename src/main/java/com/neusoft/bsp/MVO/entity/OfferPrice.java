package com.neusoft.bsp.MVO.entity;

import java.util.Date;

public class OfferPrice {
    int ofp_id;
    int man_id;
    Date effetive_start_date;
    Date effective_end_date;
    int pro_id;
    double price;
    String type_cd;
    int dsr_id;
    String created_by;
    Date creation_date;
    String last_update_by;
    Date last_update_date;
    int call_cnt;
    String remark;
    char sts_cd;
    String period;

    @Override
    public String toString() {
        return "OfferPrice{" +
                "ofp_id=" + ofp_id +
                ", man_id=" + man_id +
                ", effetive_start_date=" + effetive_start_date +
                ", effective_end_date=" + effective_end_date +
                ", pro_id=" + pro_id +
                ", price=" + price +
                ", type_cd='" + type_cd + '\'' +
                ", dsr_id=" + dsr_id +
                ", created_by='" + created_by + '\'' +
                ", creation_date=" + creation_date +
                ", last_update_by='" + last_update_by + '\'' +
                ", last_update_date=" + last_update_date +
                ", call_cnt=" + call_cnt +
                ", remark='" + remark + '\'' +
                ", sts_cd=" + sts_cd +
                ", period='" + period + '\'' +
                '}';
    }

    public int getOfp_id() {
        return ofp_id;
    }

    public void setOfp_id(int ofp_id) {
        this.ofp_id = ofp_id;
    }

    public int getMan_id() {
        return man_id;
    }

    public void setMan_id(int man_id) {
        this.man_id = man_id;
    }

    public Date getEffetive_start_date() {
        return effetive_start_date;
    }

    public void setEffetive_start_date(Date effetive_start_date) {
        this.effetive_start_date = effetive_start_date;
    }

    public Date getEffective_end_date() {
        return effective_end_date;
    }

    public void setEffective_end_date(Date effective_end_date) {
        this.effective_end_date = effective_end_date;
    }

    public int getPro_id() {
        return pro_id;
    }

    public void setPro_id(int pro_id) {
        this.pro_id = pro_id;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getType_cd() {
        return type_cd;
    }

    public void setType_cd(String type_cd) {
        this.type_cd = type_cd;
    }

    public int getDsr_id() {
        return dsr_id;
    }

    public void setDsr_id(int dsr_id) {
        this.dsr_id = dsr_id;
    }

    public String getCreated_by() {
        return created_by;
    }

    public void setCreated_by(String created_by) {
        this.created_by = created_by;
    }

    public Date getCreation_date() {
        return creation_date;
    }

    public void setCreation_date(Date creation_date) {
        this.creation_date = creation_date;
    }

    public String getLast_update_by() {
        return last_update_by;
    }

    public void setLast_update_by(String last_update_by) {
        this.last_update_by = last_update_by;
    }

    public Date getLast_update_date() {
        return last_update_date;
    }

    public void setLast_update_date(Date last_update_date) {
        this.last_update_date = last_update_date;
    }

    public int getCall_cnt() {
        return call_cnt;
    }

    public void setCall_cnt(int call_cnt) {
        this.call_cnt = call_cnt;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public char getSts_cd() {
        return sts_cd;
    }

    public void setSts_cd(char sts_cd) {
        this.sts_cd = sts_cd;
    }

    public String getPeriod() {
        return period;
    }

    public void setPeriod(String period) {
        this.period = period;
    }
}
