package com.neusoft.bsp.MVO.vo;

import com.neusoft.bsp.MVO.entity.Manufacturer;

public class ManufacturerVo {
    int man_id;
    String name_en;
    String name_cn;
    String gmc_report_type;
    String gmc_report_url;
    String description;

    @Override
    public String toString() {
        return "ManufacturerVo{" +
                "man_id=" + man_id +
                ", name_en='" + name_en + '\'' +
                ", name_cn='" + name_cn + '\'' +
                ", gmc_report_type='" + gmc_report_type + '\'' +
                ", gmc_report_url='" + gmc_report_url + '\'' +
                ", description='" + description + '\'' +
                '}';
    }

    public int getMan_id() {
        return man_id;
    }

    public void setMan_id(int man_id) {
        this.man_id = man_id;
    }

    public String getName_en() {
        return name_en;
    }

    public void setName_en(String name_en) {
        this.name_en = name_en;
    }

    public String getName_cn() {
        return name_cn;
    }

    public void setName_cn(String name_cn) {
        this.name_cn = name_cn;
    }

    public String getGmc_report_type() {
        return gmc_report_type;
    }

    public void setGmc_report_type(String gmc_report_type) {
        this.gmc_report_type = gmc_report_type;
    }

    public String getGmc_report_url() {
        return gmc_report_url;
    }

    public void setGmc_report_url(String gmc_report_url) {
        this.gmc_report_url = gmc_report_url;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public ManufacturerVo getManufacturerVo(Manufacturer manufacturer){
        ManufacturerVo manufacturerVo=new ManufacturerVo();
        manufacturerVo.setDescription(manufacturer.getDescription());
        manufacturerVo.setGmc_report_type(manufacturer.getGmc_report_type());
        manufacturerVo.setGmc_report_url(manufacturer.getGmc_report_url());
        manufacturerVo.setName_cn(manufacturer.getName_cn());
        manufacturerVo.setName_en(manufacturer.getName_en());
        return manufacturerVo;
    }

    public Manufacturer toManufacturer() {
        Manufacturer manufacturer = new Manufacturer();
        manufacturer.setGmc_report_url(this.getGmc_report_url());
        manufacturer.setGmc_report_type(this.getGmc_report_type());
        manufacturer.setName_cn(this.getName_cn());
        manufacturer.setName_en(this.getName_en());
        manufacturer.setDescription(this.getDescription());
        return manufacturer;
    }

    public Manufacturer changeManufacturer(Manufacturer manufacturer) {
        manufacturer.setGmc_report_url(this.getGmc_report_url());
        manufacturer.setGmc_report_type(this.getGmc_report_type());
        manufacturer.setName_cn(this.getName_cn());
        manufacturer.setName_en(this.getName_en());
        manufacturer.setDescription(this.getDescription());
        return manufacturer;
    }


}
