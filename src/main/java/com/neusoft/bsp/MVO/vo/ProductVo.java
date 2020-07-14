package com.neusoft.bsp.MVO.vo;

import com.neusoft.bsp.MVO.entity.*;

public class ProductVo {
    String sku_cd;
    String title;
    String upc;
    String ean;
    String model;
    String warranty_day;
    Double retail_price;
    String description;
    String url;
    String category_name;
    double width;
    double height;
    double length;
    double weight;
    char sts_cd;

    @Override
    public String toString() {
        return "ProductVo{" +
                "sku_cd='" + sku_cd + '\'' +
                ", title='" + title + '\'' +
                ", upc='" + upc + '\'' +
                ", ean='" + ean + '\'' +
                ", model='" + model + '\'' +
                ", warranty_day='" + warranty_day + '\'' +
                ", retail_price=" + retail_price +
                ", description='" + description + '\'' +
                ", url='" + url + '\'' +
                ", category_name='" + category_name + '\'' +
                ", width=" + width +
                ", height=" + height +
                ", length=" + length +
                ", weight=" + weight +
                ", sts_cd=" + sts_cd +
                '}';
    }

    public char getSts_cd() {
        return sts_cd;
    }

    public void setSts_cd(char sts_cd) {
        this.sts_cd = sts_cd;
    }

    public String getCategory_name() {
        return category_name;
    }

    public void setCategory_name(String category_name) {
        this.category_name = category_name;
    }

    public String getSku_cd() {
        return sku_cd;
    }

    public void setSku_cd(String sku_cd) {
        this.sku_cd = sku_cd;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUpc() {
        return upc;
    }

    public void setUpc(String upc) {
        this.upc = upc;
    }

    public String getEan() {
        return ean;
    }

    public void setEan(String ean) {
        this.ean = ean;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getWarranty_day() {
        return warranty_day;
    }

    public void setWarranty_day(String warranty_day) {
        this.warranty_day = warranty_day;
    }

    public Double getRetail_price() {
        return retail_price;
    }

    public void setRetail_price(Double retail_price) {
        this.retail_price = retail_price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
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

    public ProductVo getProductVO(Product product){
        ProductVo productVo=new ProductVo();
        productVo.setSts_cd(product.getSts_cd());
        productVo.setEan(product.getEan());
        productVo.setModel(product.getModel());
        productVo.setSku_cd(product.getSku_cd());
        productVo.setTitle(product.getTitle());
        productVo.setUpc(product.getUpc());
        productVo.setWarranty_day(product.getWarranty_day());
        productVo.setRetail_price(product.getRetail_price());
        return productVo;
    }

    public Product toProduct(){
        Product product=new Product();
        product.setSts_cd(this.getSts_cd());
        product.setEan(this.getEan());
        product.setModel(this.getModel());
        product.setSku_cd(this.getSku_cd());
        product.setTitle(this.getTitle());
        product.setUpc(this.getUpc());
        product.setWarranty_day(this.getWarranty_day());
        product.setRetail_price(this.getRetail_price());
        return product;
    }

    public Product changeProduct(Product product){
        product.setSts_cd(this.getSts_cd());
        product.setEan(this.getEan());
        product.setModel(this.getModel());
        product.setSku_cd(this.getSku_cd());
        product.setTitle(this.getTitle());
        product.setUpc(this.getUpc());
        product.setWarranty_day(this.getWarranty_day());
        product.setRetail_price(this.getRetail_price());
        return product;
    }

    public ProductCategory toProductCategory(){
        ProductCategory productCategory=new ProductCategory();
        productCategory.setCategory_name(this.getCategory_name());
        return productCategory;
    }

    public ProductDescription toProductDescription(){
        ProductDescription productDescription=new ProductDescription();
        productDescription.setDescrition(this.getDescription());
        return productDescription;
    }

    public ProductDescription changeProductDescription(ProductDescription productDescription){
        productDescription.setDescrition(this.getDescription());
        return productDescription;
    }


    public PackageInfo toPackageInfo(){
        PackageInfo packageInfo=new PackageInfo();
        packageInfo.setHeight(this.getHeight());
        packageInfo.setLength(this.getLength());
        packageInfo.setWeight(this.getWeight());
        packageInfo.setWidth(this.getWidth());
        return packageInfo;
    }

    public PackageInfo changePackageInfo(PackageInfo packageInfo){
        packageInfo.setHeight(this.getHeight());
        packageInfo.setLength(this.getLength());
        packageInfo.setWeight(this.getWeight());
        packageInfo.setWidth(this.getWidth());
        return packageInfo;
    }

    public Img toImg(){
        Img img=new Img();
        img.setName("pro");
        img.setUrl(this.getUrl());
        return img;
    }

}
