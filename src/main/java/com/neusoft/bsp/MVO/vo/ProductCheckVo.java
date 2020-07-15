package com.neusoft.bsp.MVO.vo;

import com.neusoft.bsp.MVO.entity.Img;
import com.neusoft.bsp.MVO.entity.ProductCategory;

public class ProductCheckVo {
    String url;
    String category_name;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getCategory_name() {
        return category_name;
    }

    public void setCategory_name(String category_name) {
        this.category_name = category_name;
    }

    public Img toImg(){
        Img img=new Img();
        img.setName("pro");
        img.setUrl(this.getUrl());
        return img;
    }

    public ProductCategory toProductCategory(){
        ProductCategory productCategory=new ProductCategory();
        productCategory.setCategory_name(this.getCategory_name());
        return productCategory;
    }
}
