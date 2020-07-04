package com.neusoft.bsp.MVO.entity;

import java.util.Date;

public class PackageInfo {
    int pck_id;
    int war_id;
    int pro_id;
    char type_cd;
    double width;
    double height;
    double length;
    double weight;
    String created_by;
    Date creation_date;
    String last_update_by;
    Date last_update_date;
    int call_cnt;
    String remark;
    char sts_cd;
    String heavy_cargo;
    String logistics_company;

    @Override
    public String toString() {
        return "PackageInfo{" +
                "pck_id=" + pck_id +
                ", war_id=" + war_id +
                ", pro_id=" + pro_id +
                ", type_cd=" + type_cd +
                ", width=" + width +
                ", height=" + height +
                ", length=" + length +
                ", weight=" + weight +
                ", created_by='" + created_by + '\'' +
                ", creation_date=" + creation_date +
                ", last_update_by='" + last_update_by + '\'' +
                ", last_update_date=" + last_update_date +
                ", call_cnt=" + call_cnt +
                ", remark='" + remark + '\'' +
                ", sts_cd=" + sts_cd +
                ", heavy_cargo='" + heavy_cargo + '\'' +
                ", logistics_company='" + logistics_company + '\'' +
                '}';
    }

    public int getPck_id() {
        return pck_id;
    }

    public void setPck_id(int pck_id) {
        this.pck_id = pck_id;
    }

    public int getWar_id() {
        return war_id;
    }

    public void setWar_id(int war_id) {
        this.war_id = war_id;
    }

    public int getPro_id() {
        return pro_id;
    }

    public void setPro_id(int pro_id) {
        this.pro_id = pro_id;
    }

    public char getType_cd() {
        return type_cd;
    }

    public void setType_cd(char type_cd) {
        this.type_cd = type_cd;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
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

    public String getHeavy_cargo() {
        return heavy_cargo;
    }

    public void setHeavy_cargo(String heavy_cargo) {
        this.heavy_cargo = heavy_cargo;
    }

    public String getLogistics_company() {
        return logistics_company;
    }

    public void setLogistics_company(String logistics_company) {
        this.logistics_company = logistics_company;
    }
}
