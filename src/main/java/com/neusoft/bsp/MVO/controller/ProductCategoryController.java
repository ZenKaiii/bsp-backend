package com.neusoft.bsp.MVO.controller;

import com.github.pagehelper.PageInfo;
import com.neusoft.bsp.MVO.entity.ProductCategory;
import com.neusoft.bsp.MVO.service.ProductCategoryService;
import com.neusoft.bsp.common.base.BaseController;
import com.neusoft.bsp.common.base.BaseModel;
import com.neusoft.bsp.common.base.BaseModelJson;
import com.neusoft.bsp.common.exception.BusinessException;
import com.neusoft.bsp.common.validationGroup.DeleteGroup;
import com.neusoft.bsp.common.validationGroup.InsertGroup;
import com.neusoft.bsp.common.validationGroup.UpdateGroup;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@CrossOrigin
@RestController
@RequestMapping("/productCategory")
public class ProductCategoryController extends BaseController {

    @Autowired
    ProductCategoryService productCategoryService;

    @PostMapping("/addProductCategory")
    public BaseModel addProductCategory(@Validated({InsertGroup.class}) @RequestBody ProductCategory productCategory, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            throw BusinessException.INSERT_FAIL.newInstance(this.getErrorResponse(bindingResult),
                    new Object[]{productCategory.toString()});
        } else {
            BaseModel result = new BaseModel();
            int i = productCategoryService.insert(productCategory);
            if(i==1){
                result.code = 200;
                return result;
            }else{
                throw BusinessException.INSERT_FAIL;
            }
        }
    }

    @PostMapping("/productCategoryList")
    public BaseModelJson<PageInfo<ProductCategory>> getProductCategoryList(Integer pageNum, Integer pageSize,
                                                                           @RequestParam Map<String,Object> map) {
        BaseModelJson<PageInfo<ProductCategory>> result = new BaseModelJson();
        if(pageNum == null){
            pageNum = 1;
        }
        if(pageSize == null){
            pageSize = 10;
        }
        result.code = 200;
        result.data = productCategoryService.getAllByFilter(pageNum,pageSize,map);
        return result;
    }

    @PostMapping("/deleteProductCategory")
    public BaseModel deleteProductCategory(@Validated({DeleteGroup.class}) @RequestBody ProductCategory productCategory, BindingResult bindingResult) throws Exception {
        if (bindingResult.hasErrors()) {
            throw BusinessException.USERID_NULL_ERROR.newInstance(this.getErrorResponse(bindingResult),
                    new Object[]{productCategory.toString()});
        } else {
            BaseModel result = new BaseModel();
            int i = productCategoryService.delete(productCategory.getPrc_id());
            if (i == 1) {
                result.code = 200;
                return result;
            } else {
                throw BusinessException.DELETE_FAIL;
            }
        }
    }
    @PostMapping("/updateProductCategory")
    public BaseModel updateProductCategory(@Validated({UpdateGroup.class}) @RequestBody ProductCategory productCategory, BindingResult bindingResult) {  //bindingResult用于获得validate的反馈信息
        if (bindingResult.hasErrors()) {
            throw BusinessException.PRCID_NULL_ERROR.newInstance(this.getErrorResponse(bindingResult),
                    new Object[]{productCategory.toString()});
        } else {
            BaseModel result = new BaseModel();
            int i =productCategoryService.update(productCategory);
            if(i==1){
                result.code = 200;
                return result;
            }else{
                throw BusinessException.UPDATE_FAIL;
            }
        }
    }



}
