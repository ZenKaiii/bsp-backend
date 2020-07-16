package com.neusoft.bsp.MVO.vo;

import com.neusoft.bsp.MVO.entity.Brand;
import com.neusoft.bsp.MVO.entity.Img;

public class BrandVo {
    String name_en;
    String name_cn;
    String url;

    @Override
    public String toString() {
        return "BrandVo{" +
                "name_en='" + name_en + '\'' +
                ", name_cn='" + name_cn + '\'' +
                ", url='" + url + '\'' +
                '}';
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
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

    public BrandVo getBrandVO(Brand brand){
        BrandVo brandVo=new BrandVo();
        brandVo.setName_cn(brand.getName_cn());
        brandVo.setName_en(brand.getName_en());
        return brandVo;
    }

    public Brand toBrand(){
        Brand brand=new Brand();
        brand.setName_cn(this.getName_cn());
        brand.setName_en(this.getName_en());
        return brand;
    }

    public Brand changeBrand(Brand brand){
        brand.setName_cn(this.getName_cn());
        brand.setName_en(this.getName_en());
        return brand;
    }

    public Img toImg(){
        Img img=new Img();
        img.setName("brd");
        img.setUrl(this.getUrl());
        return img;
    }
}
