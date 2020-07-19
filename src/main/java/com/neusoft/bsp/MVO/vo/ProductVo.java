package com.neusoft.bsp.MVO.vo;

import com.neusoft.bsp.MVO.entity.*;

public class ProductVo {
    String sku_cd;
    String title;
    String upc;
    String Ean;
    String model;
    String warranty_day;
    Double retail_price;
    String description;
    double width;
    double height;
    double length;
    double weight;
    int stock;
    char sts_cd;

    @Override
    public String toString() {
        return "ProductVo{" +
                "sku_cd='" + sku_cd + '\'' +
                ", title='" + title + '\'' +
                ", upc='" + upc + '\'' +
                ", Ean='" + Ean + '\'' +
                ", model='" + model + '\'' +
                ", warranty_day='" + warranty_day + '\'' +
                ", retail_price=" + retail_price +
                ", description='" + description + '\'' +
                ", width=" + width +
                ", height=" + height +
                ", length=" + length +
                ", weight=" + weight +
                ", stock=" + stock +
                ", sts_cd=" + sts_cd +
                '}';
    }

    public char getSts_cd() {
        return sts_cd;
    }

    public void setSts_cd(char sts_cd) {
        this.sts_cd = sts_cd;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public String getEan() {
        return Ean;
    }

    public void setEan(String Ean) {
        this.Ean = Ean;
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
        productVo.setEan(product.getEan());
        productVo.setModel(product.getModel());
        productVo.setSku_cd(product.getSku_cd());
        productVo.setTitle(product.getTitle());
        productVo.setUpc(product.getUpc());
        productVo.setWarranty_day(product.getWarranty_day());
        productVo.setRetail_price(product.getRetail_price());
        productVo.setStock(product.getStockseting());
        productVo.setSts_cd(product.getSts_cd());
        return productVo;
    }

    public Product toProduct(){
        Product product=new Product();
        product.setEan(this.getEan());
        product.setModel(this.getModel());
        product.setSku_cd(this.getSku_cd());
        product.setTitle(this.getTitle());
        product.setUpc(this.getUpc());
        product.setWarranty_day(this.getWarranty_day());
        product.setRetail_price(this.getRetail_price());
        product.setStockseting(this.getStock());
        product.setSts_cd(this.getSts_cd());
        return product;
    }

    public Product changeProduct(Product product){
        product.setEan(this.getEan());
        product.setModel(this.getModel());
        product.setSku_cd(this.getSku_cd());
        product.setTitle(this.getTitle());
        product.setUpc(this.getUpc());
        product.setWarranty_day(this.getWarranty_day());
        product.setRetail_price(this.getRetail_price());
        product.setStockseting(this.getStock());
        product.setSts_cd(this.getSts_cd());
        return product;
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
}
