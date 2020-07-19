package com.neusoft.bsp.MVO.vo;

import com.neusoft.bsp.BVO.entity.Pro;
import com.neusoft.bsp.MVO.entity.Img;
import com.neusoft.bsp.MVO.entity.Product;
import com.neusoft.bsp.MVO.entity.ProductCategory;
import com.neusoft.bsp.MVO.mapper.ProductMapper;
import com.neusoft.bsp.MVO.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashMap;
import java.util.Map;

public class ProductDetailVo {

    int proId;
    String title;
    String url;
    String category_name;
    char sts_cd;

    @Override
    public String toString() {
        return "ProductDetailVo{" +
                "proId=" + proId +
                ", title='" + title + '\'' +
                ", url='" + url + '\'' +
                ", category_name='" + category_name + '\'' +
                ", sts_cd=" + sts_cd +
                '}';
    }

    public int getProId() {
        return proId;
    }

    public void setProId(int proId) {
        this.proId = proId;
    }

    public char getSts_cd() {
        return sts_cd;
    }

    public void setSts_cd(char sts_cd) {
        this.sts_cd = sts_cd;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

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

    public Product toProduct(){
        Product product=new Product();
        product.setPro_id(this.getProId());
        product.setTitle(this.getTitle());
        product.setSts_cd(this.getSts_cd());
        return product;
    }

    public Product changeProduct(Product product){
        product.setPro_id(this.getProId());
        product.setTitle(this.getTitle());
        product.setSts_cd(this.getSts_cd());
        return product;
    }

    public ProductCategory toProductCategory(){
        ProductCategory productCategory=new ProductCategory();
        productCategory.setCategoryName(this.getCategory_name());
        return productCategory;
    }

    public ProductCategory changeProductCategory(ProductCategory productCategory){
        productCategory.setCategoryName(this.getCategory_name());
        return productCategory;
    }

    public Img changeImg(Img img){
        img.setName("pro");
        img.setUrl(this.getUrl());
        return img;
    }
}
