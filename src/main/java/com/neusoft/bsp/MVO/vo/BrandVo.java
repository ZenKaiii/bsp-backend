package com.neusoft.bsp.MVO.vo;

import com.neusoft.bsp.MVO.entity.Brand;
import com.neusoft.bsp.MVO.entity.Img;

public class BrandVo {
    int brd_id;
    String name_en;
    String url;

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

    public int getBrd_id() {
        return brd_id;
    }

    public void setBrd_id(int brd_id) {
        this.brd_id = brd_id;
    }

    @Override
    public String toString() {
        return "BrandVo{" +
                "brd_id=" + brd_id +
                ", name_en='" + name_en + '\'' +
                ", url='" + url + '\'' +
                '}';
    }

    public BrandVo getBrandVO(Brand brand){
        BrandVo brandVo=new BrandVo();
        brandVo.setName_en(brand.getName_en());
        brandVo.setBrd_id(brand.getBrd_id());
        return brandVo;
    }

    public Brand toBrand(){
        Brand brand=new Brand();
        brand.setName_en(this.getName_en());
        brand.setBrd_id(this.getBrd_id());
        return brand;
    }

    public Brand changeBrand(Brand brand){
        brand.setName_en(this.getName_en());
        brand.setBrd_id(this.getBrd_id());
        return brand;
    }

    public Img toImg(){
        Img img=new Img();
        img.setName("brd");
        img.setUrl(this.getUrl());
        return img;
    }

    public Img changeImg(Img img){
        img.setName("brd");
        img.setUrl(this.getUrl());
        return img;
    }
}
