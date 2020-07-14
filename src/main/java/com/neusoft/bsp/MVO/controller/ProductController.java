package com.neusoft.bsp.MVO.controller;

import com.alibaba.fastjson.JSONArray;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.neusoft.bsp.MVO.entity.*;
import com.neusoft.bsp.MVO.mapper.ManufacturerMapper;
import com.neusoft.bsp.MVO.service.*;
import com.neusoft.bsp.MVO.vo.BrandVo;
import com.neusoft.bsp.MVO.vo.ProductVo;
import com.neusoft.bsp.common.base.BaseController;
import com.neusoft.bsp.common.base.BaseModel;
import com.neusoft.bsp.common.base.BaseModelJson;
import com.neusoft.bsp.common.base.BaseModelJsonPaging;
import com.neusoft.bsp.common.exception.BusinessException;
import com.neusoft.bsp.common.validationGroup.DeleteGroup;
import com.neusoft.bsp.common.validationGroup.InsertGroup;
import com.neusoft.bsp.common.validationGroup.UpdateGroup;
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
    ManufacturerService manufacturerService;
    ProductDescriptionService productDescriptionService;
    PackageInfoService packageInfoService;
    ProductCategoryService productCategoryService;
    ImgService imgService;

    @PostMapping("/alterProduct")
    public BaseModel alterProduct(@Validated({InsertGroup.class}) @RequestParam String productVoJson, @RequestParam int userId, BindingResult bindingResult) {
        ProductVo productVo=JSONArray.parseObject(productVoJson,ProductVo.class);
        if (bindingResult.hasErrors()) {
            throw BusinessException.INSERT_FAIL.newInstance(this.getErrorResponse(bindingResult),
                    new Object[]{productVo.toString()});
        } else {
            Product product=productService.getBySku(productVo.getSku_cd());
            int i=0;
            if(product==null){
                product=productVo.toProduct();
                product.setCreated_by(""+userId);
                product.setLast_update_by(""+userId);
                product.setCreation_date(new Date(System.currentTimeMillis()));
                product.setLast_update_date(new Date(System.currentTimeMillis()));
                product.setMan_id(manufacturerService.getManIdByUserId(userId));
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
                i=productDescriptionService.update(productDescription);
            }
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
    public BaseModel alterProductDetail(@Validated({InsertGroup.class}) @RequestParam String productVoJson, @RequestParam int userId, BindingResult bindingResult) {
        ProductVo productVo=JSONArray.parseObject(productVoJson,ProductVo.class);
        if (bindingResult.hasErrors()) {
            throw BusinessException.INSERT_FAIL.newInstance(this.getErrorResponse(bindingResult),
                    new Object[]{productVo.toString()});
        } else {
            Product product = productService.getBySku(productVo.getSku_cd());
            product.setTitle(productVo.getTitle());
            int i = 0;

            ProductCategory productCategory = productVo.toProductCategory();
            productCategory.setPro_id(product.getPro_id());
            productCategory.setCreated_by("" + userId);
            productCategory.setLast_update_by("" + userId);
            productCategory.setCreation_date(new Date(System.currentTimeMillis()));
            productCategory.setLast_update_date(new Date(System.currentTimeMillis()));
            i = productCategoryService.insert(productCategory);

            Img img = productVo.toImg();
            img.setEntityId(product.getPro_id());
            img.setCreatedBy("" + userId);
            img.setLastUpdateBy("" + userId);
            img.setCreationDate(new Date(System.currentTimeMillis()));
            img.setLastUpdateDate(new Date(System.currentTimeMillis()));
            i = imgService.insert(img);

            BaseModel result = new BaseModel();
            if(i==1){
                result.code = 200;
                return result;
            }else{
                throw BusinessException.INSERT_FAIL;
            }
        }
    }


    @PostMapping("/productList")
    public BaseModelJsonPaging<PageInfo<ProductVo>> getProductList(Integer pageNum, Integer pageSize,
                                                                 @RequestParam int userId) {
        BaseModelJsonPaging<PageInfo<ProductVo>> result = new BaseModelJsonPaging();
        Map<String,Object> map=new HashMap<>();
        map.put("userId",userId);
        if(pageNum == null){
            pageNum = 1;
        }
        if(pageSize == null){
            pageSize = 10;
        }
        List<Product> productList=productService.getAllByFilter(map);
        List<ProductVo> productVoList=new ArrayList<>();
        for(Product product:productList){
            ProductVo productVo=new ProductVo();
            productVoList.add(productVo.getProductVO(product));
        }

        PageHelper.startPage(pageNum,pageSize,true);
        PageInfo<ProductVo> productVoPage=new PageInfo(productVoList);
        result.code = 200;
        result.data = productVoPage;
        result.message= JSONArray.toJSONString(productVoPage);
        return result;
    }

    /*@PostMapping("/deleteProduct")
    public BaseModel deleteProduct(@Validated({DeleteGroup.class}) @RequestBody Product product, BindingResult bindingResult) throws Exception {
        if (bindingResult.hasErrors()) {
            throw BusinessException.USERID_NULL_ERROR.newInstance(this.getErrorResponse(bindingResult),
                    new Object[]{product.toString()});
        } else {
            BaseModel result = new BaseModel();
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
