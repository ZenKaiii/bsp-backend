package com.neusoft.bsp.MVO.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.neusoft.bsp.MVO.entity.*;
import com.neusoft.bsp.MVO.mapper.ProductMapper;
import com.neusoft.bsp.MVO.service.*;
import com.neusoft.bsp.MVO.vo.ProductDetailVo;
import com.neusoft.bsp.MVO.vo.ProductVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service ("productService")
public class ProductServiceImpl implements ProductService {

    @Autowired
    ProductMapper productMapper;

    @Autowired
    ManufacturerService manufacturerService;
    @Autowired
    ProductDescriptionService productDescriptionService;
    @Autowired
    PackageInfoService packageInfoService;
    @Autowired
    ProductCategoryService productCategoryService;
    @Autowired
    ImgService imgService;


    @Override
    public int alterProduct(ProductVo productVo, int userId) {
        Product product=this.getBySku(productVo.getSku_cd());
        int i=0;
        if(product==null){
            product=productVo.toProduct();
            product.setCreated_by(""+userId);
            product.setLast_update_by(""+userId);
            product.setCreation_date(new Date(System.currentTimeMillis()));
            product.setLast_update_date(new Date(System.currentTimeMillis()));
            int man_id=manufacturerService.getManIdByUserId(userId);
            product.setMan_id(man_id);
            i=this.insert(product);
            if(i==1){
                product=this.getBySku(productVo.getSku_cd());

                ProductDescription productDescription=productVo.toProductDescription();
                productDescription.setPro_id(product.getPro_id());
                productDescription.setCreated_by(""+userId);
                productDescription.setLast_update_by(""+userId);
                productDescription.setCreation_date(new Date(System.currentTimeMillis()));
                productDescription.setLast_update_date(new Date(System.currentTimeMillis()));
                i=productDescriptionService.insert(productDescription);


                PackageInfo packageInfo=productVo.toPackageInfo();
                packageInfo.setPro_id(product.getPro_id());
                packageInfo.setCreated_by(""+userId);
                packageInfo.setLast_update_by(""+userId);
                packageInfo.setCreation_date(new Date(System.currentTimeMillis()));
                packageInfo.setLast_update_date(new Date(System.currentTimeMillis()));
                i=packageInfoService.insert(packageInfo);
            }
        }
        else {
            productVo.changeProduct(product);
            product.setLast_update_date(new Date(System.currentTimeMillis()));
            i = this.update(product);

            PackageInfo packageInfo = packageInfoService.getByProId(product.getPro_id());
            productVo.changePackageInfo(packageInfo);
            packageInfo.setLast_update_date(new Date(System.currentTimeMillis()));
            i = packageInfoService.update(packageInfo);

            ProductDescription productDescription = productDescriptionService.getByProId(product.getPro_id());
            productVo.changeProductDescription(productDescription);
            productDescription.setLast_update_date(new Date(System.currentTimeMillis()));
            i = productDescriptionService.update(productDescription);
        }
        return i;
    }

    @Override
    public int alterProductDetail(ProductDetailVo productDetailVo, int userId) {
        int man_id=manufacturerService.getManIdByUserId(userId);
        if(man_id==0){
            return 0;
        }
        Map<String,Object> map=new HashMap<>();
        map.put("man_id",man_id);
        map.put("title",productDetailVo.getTitle());
        Product product=this.getByTitle(map);
        if(product==null){
            return 0;
        }
        int i = 0;
        product.setSts_cd(productDetailVo.getSts_cd());

        this.update(product);

        if (productCategoryService.getPrcByProId(product.getPro_id()) == null) {
            ProductCategory productCategory = productDetailVo.toProductCategory();
            productCategory.setProId(product.getPro_id());
            productCategory.setCreatedBy("" + userId);
            productCategory.setLastUpdateBy("" + userId);
            productCategory.setCreationDate(new Date(System.currentTimeMillis()));
            productCategory.setLastUpdateDate(new Date(System.currentTimeMillis()));
            i = productCategoryService.insert(productCategory);
        } else {
            ProductCategory productCategory = productCategoryService.getPrcByProId(product.getPro_id());
            productDetailVo.changeProductCategory(productCategory);
            i = productCategoryService.update(productCategory);
        }
        if (imgService.getImgByProId(product.getPro_id()) == null) {
            Img img = productDetailVo.toImg();
            img.setEntityId(product.getPro_id());
            img.setCreatedBy("" + userId);
            img.setLastUpdateBy("" + userId);
            img.setCreationDate(new Date(System.currentTimeMillis()));
            img.setLastUpdateDate(new Date(System.currentTimeMillis()));
            img.setName("pro");
            i = imgService.insert(img);
        } else {
            Img img = imgService.getImgByProId(product.getPro_id());
            productDetailVo.changeImg(img);
            i = imgService.update(img);
        }

        return i;
    }

    @Override
    public List<ProductVo> getProductList(int userId) {
        Map<String,Object> map=new HashMap<>();
        map.put("userId",userId);
        List<Product> productList=this.getAllByFilter(map);
        List<ProductVo> productVoList=new ArrayList<>();
        if(productList.size()!=0){
            for (Product product : productList) {
                ProductVo productVo = new ProductVo();
                productVoList.add(productVo.getProductVO(product));
            }
        }
        return  productVoList;

    }

    @Override
    public List<ProductDetailVo> getProductDetailList(int userId) {
        Map<String,Object> map=new HashMap<>();
        map.put("userId",userId);
        List<Product> productList=this.getAllByFilter(map);
        List<ProductDetailVo> productDetailVoList=new ArrayList<>();
        if(productList.size()!=0) {
            for (Product product : productList) {
                ProductDetailVo productDetailVo = new ProductDetailVo();
                int pro_id = product.getPro_id();
                ProductCategory productCategory = productCategoryService.getPrcByProId(pro_id);
                productDetailVo.setCategory_name(productCategoryService.getPrcByProId(product.getPro_id()).getCategoryName());
                productDetailVo.setSts_cd(product.getSts_cd());
                productDetailVo.setTitle(product.getTitle());
                productDetailVo.setUrl(imgService.getImgByProId(product.getPro_id()).getUrl());
                productDetailVoList.add(productDetailVo);
            }
        }
        return productDetailVoList;
    }


    @Override
    public int insert(Product product) {
        return productMapper.insert(product);
    }

    @Override
    public int update(Product product) {
       return productMapper.update(product);
    }

    @Override
    public int delete(int pro_id) {
        return delete(pro_id);
    }

    @Override
    public Product getById(int pro_id) {
        return productMapper.getById(pro_id);
    }

    @Override
    public Product getBySku(String sku) {
        return productMapper.getBySku(sku);
    }

    @Override
    public Product getByTitle(Map<String, Object> map) {
        return productMapper.getByTitle(map);
    }

    @Override
    public List<Product> getAll() {
       return productMapper.getAll();
    }

    @Override
    public List<Product> getAllByFilter(Map<String, Object> map) {
       return productMapper.getAllByFilter(map);
    }

    @Override
    public PageInfo<Product> getAllByFilter(Integer pageNum, Integer pageSize) {
       return this.getAllByFilter(pageNum,pageSize,new HashMap());
    }

    @Override
    public PageInfo<Product> getAllByFilter(Integer pageNum, Integer pageSize, Map<String, Object> map) {
       PageHelper.startPage(pageNum,pageSize,true);
       List<Product> Products = productMapper.getAllByFilter(map);
       return new PageInfo<>(Products);
    }}
