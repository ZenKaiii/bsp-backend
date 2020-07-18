package com.neusoft.bsp.MVO.controller;

import com.alibaba.fastjson.JSONArray;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.neusoft.bsp.MVO.entity.*;
import com.neusoft.bsp.MVO.service.*;
import com.neusoft.bsp.MVO.vo.ProductDetailVo;
import com.neusoft.bsp.MVO.vo.ProductVo;
import com.neusoft.bsp.common.base.BaseController;
import com.neusoft.bsp.common.base.BaseModel;
import com.neusoft.bsp.common.base.BaseModelJsonPaging;
import com.neusoft.bsp.common.exception.BusinessException;
import com.neusoft.bsp.common.validationGroup.DeleteGroup;
import com.neusoft.bsp.common.validationGroup.InsertGroup;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@CrossOrigin
@RestController
@RequestMapping("/product")
public class ProductController extends BaseController {

    @Autowired
    ProductService productService;
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

    @PostMapping("/alterProduct")
    public BaseModel alterProduct(@Validated({InsertGroup.class}) @RequestBody ProductVo productVo,BindingResult bindingResult, @RequestParam int userId) {
//        ProductVo productVo=JSONArray.parseObject(productVoJson,ProductVo.class);
        if (bindingResult.hasErrors()) {
            throw BusinessException.INSERT_FAIL.newInstance(this.getErrorResponse(bindingResult),
                    new Object[]{productVo.toString()});
        } else {
           /* Product product=productService.getBySku(productVo.getSku_cd());
            int i=0;
            if(product==null){
                product=productVo.toProduct();
                product.setCreated_by(""+userId);
                product.setLast_update_by(""+userId);
                product.setCreation_date(new Date(System.currentTimeMillis()));
                product.setLast_update_date(new Date(System.currentTimeMillis()));
                int man_id=manufacturerService.getManIdByUserId(userId);
                product.setMan_id(man_id);
                System.out.println("123");
                i=productService.insert(product);
                if(i==1){
                    product=productService.getBySku(productVo.getSku_cd());

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
            else{
                productVo.changeProduct(product);
                product.setLast_update_date(new Date(System.currentTimeMillis()));
                i=productService.update(product);

                PackageInfo packageInfo=packageInfoService.getByProId(product.getPro_id());
                productVo.changePackageInfo(packageInfo);
                packageInfo.setLast_update_date(new Date(System.currentTimeMillis()));
                i=packageInfoService.update(packageInfo);

                ProductDescription productDescription=productDescriptionService.getByProId(product.getPro_id());
                productVo.changeProductDescription(productDescription);
                productDescription.setLast_update_date(new Date(System.currentTimeMillis()));
                i=productDescriptionService.update(productDescription);*/
//            }
            int i= productService.alterProduct(productVo,userId);
            BaseModel result = new BaseModel();
            if(i==1){
                result.code = 200;
                return result;
            }else{
                throw BusinessException.INSERT_FAIL;
            }
        }
    }

    @PostMapping("/alterProductDetail")
    public BaseModel alterProductDetail(@Validated({InsertGroup.class}) @RequestBody ProductDetailVo productDetailVo, @RequestParam int userId, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            throw BusinessException.INSERT_FAIL.newInstance(this.getErrorResponse(bindingResult),
                    new Object[]{productDetailVo.toString()});
        } else {
            /*int man_id=manufacturerService.getManIdByUserId(userId);
            Map<String,Object> map=new HashMap<>();
            map.put("man_id",man_id);
            map.put("title",productDetailVo.getTitle());
            Product product=productService.getByTitle(map);
            product.setSts_cd(productDetailVo.getSts_cd());
            int i = 0;

            productService.update(product);

            if(productCategoryService.getPrcByProId(product.getPro_id())==null) {
                ProductCategory productCategory = productDetailVo.toProductCategory();
                productCategory.setProId(product.getPro_id());
                productCategory.setCreatedBy("" + userId);
                productCategory.setLastUpdateBy("" + userId);
                productCategory.setCreationDate(new Date(System.currentTimeMillis()));
                productCategory.setLastUpdateDate(new Date(System.currentTimeMillis()));
                i = productCategoryService.insert(productCategory);
            }
            else{
                ProductCategory productCategory=productCategoryService.getPrcByProId(product.getPro_id());
                productDetailVo.changeProductCategory(productCategory);
                i=productCategoryService.update(productCategory);
            }
            if(imgService.getImgByProId(product.getPro_id())==null) {
                Img img = productDetailVo.toImg();
                img.setEntityId(product.getPro_id());
                img.setCreatedBy("" + userId);
                img.setLastUpdateBy("" + userId);
                img.setCreationDate(new Date(System.currentTimeMillis()));
                img.setLastUpdateDate(new Date(System.currentTimeMillis()));
                img.setName("pro");
                i = imgService.insert(img);
            }
            else{
                Img img=imgService.getImgByProId(product.getPro_id());
                productDetailVo.changeImg(img);
                i=imgService.update(img);
            }*/
            int i=productService.alterProductDetail(productDetailVo,userId);
            BaseModel result = new BaseModel();
            if(i==1){
                result.code = 200;
                return result;
            }else{
                throw BusinessException.INSERT_FAIL;
            }
        }
    }


    @GetMapping("/productList")
    public BaseModelJsonPaging<PageInfo<ProductVo>> getProductList(Integer pageNum, Integer pageSize,
                                                                   @RequestParam int userId) {
        BaseModelJsonPaging<PageInfo<ProductVo>> result = new BaseModelJsonPaging();
       /* Map<String,Object> map=new HashMap<>();
        map.put("userId",userId);*/
        if(pageNum == null){
            pageNum = 1;
        }
        if(pageSize == null){
            pageSize = 10;
        }
//        List<Product> productList=productService.getAllByFilter(map);
//        List<ProductVo> productVoList=new ArrayList<>();
//        for(Product product:productList){
//            ProductVo productVo=new ProductVo();
//            productVoList.add(productVo.getProductVO(product));
//        }
        List<ProductVo> productVoList=productService.getProductList(userId);
        PageHelper.startPage(pageNum,pageSize,true);
        if(productVoList.size()!=0) {
            PageInfo<ProductVo> productVoPage = new PageInfo(productVoList);
            result.data = productVoPage;
            result.message = JSONArray.toJSONString(productVoPage);
        }
        else{
            result.message="no product info";
        }
        result.code = 200;
        return result;
    }

    @GetMapping("/productDetailList")
    public BaseModelJsonPaging<PageInfo<ProductDetailVo>> getProductDetailList(Integer pageNum, Integer pageSize,
                                                                   @RequestParam int userId) {
        BaseModelJsonPaging<PageInfo<ProductDetailVo>> result = new BaseModelJsonPaging();
        /*Map<String,Object> map=new HashMap<>();
        map.put("userId",userId);*/
        if(pageNum == null){
            pageNum = 1;
        }
        if(pageSize == null){
            pageSize = 10;
        }
       /* List<Product> productList=productService.getAllByFilter(map);
        List<ProductDetailVo> productDetailVoList=new ArrayList<>();
        for(Product product:productList){
            ProductDetailVo productDetailVo=new ProductDetailVo();
            int pro_id=product.getPro_id();
            ProductCategory productCategory=productCategoryService.getPrcByProId(pro_id);
            productDetailVo.setCategory_name(productCategoryService.getPrcByProId(product.getPro_id()).getCategoryName());
            productDetailVo.setSts_cd(product.getSts_cd());
            productDetailVo.setTitle(product.getTitle());
            productDetailVo.setUrl(imgService.getImgByProId(product.getPro_id()).getUrl());
            productDetailVoList.add(productDetailVo);
        }*/
        List<ProductDetailVo> productDetailVoList=productService.getProductDetailList(userId);
        PageHelper.startPage(pageNum,pageSize,true);
        if(productDetailVoList.size()!=0) {
            PageInfo<ProductDetailVo> productDetailVoPage = new PageInfo(productDetailVoList);
            result.data = productDetailVoPage;
            result.message= JSONArray.toJSONString(productDetailVoPage);
        }
        else{
            result.message="no product info";
        }
        result.code = 200;
        return result;
    }

   /* @PostMapping("/deleteProduct")
    public BaseModel deleteProduct(@Validated({DeleteGroup.class}) @RequestBody ProductDetailVo productVo, BindingResult bindingResult) throws Exception {
        if (bindingResult.hasErrors()) {
            throw BusinessException.USERID_NULL_ERROR.newInstance(this.getErrorResponse(bindingResult),
                    new Object[]{productVo.toString()});
        } else {
            BaseModel result = new BaseModel();

            Product product=productService.getByTitle(productVo.getTitle());
            int i = productService.delete(product.getPro_id());
            if (i == 1) {
                result.code = 200;
                return result;
            } else {
                throw BusinessException.DELETE_FAIL;
            }
        }
    }*/
    /*@PostMapping("/updateProduct")
    public BaseModel updateProduct(@Validated({UpdateGroup.class}) @RequestBody Product product, BindingResult bindingResult) {  //bindingResult用于获得validate的反馈信息
        if (bindingResult.hasErrors()) {
            throw BusinessException.PROID_NULL_ERROR.newInstance(this.getErrorResponse(bindingResult),
                    new Object[]{product.toString()});
        } else {
            BaseModel result = new BaseModel();
            int i =productService.update(product);
            if(i==1){
                result.code = 200;
                return result;
            }else{
                throw BusinessException.UPDATE_FAIL;
            }
        }
    }*/



}
