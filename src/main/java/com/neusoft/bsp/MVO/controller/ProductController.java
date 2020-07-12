package com.neusoft.bsp.MVO.controller;

import com.github.pagehelper.PageInfo;
import com.neusoft.bsp.MVO.entity.Product;
import com.neusoft.bsp.MVO.service.ProductService;
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
@RequestMapping("/product")
public class ProductController extends BaseController {

    @Autowired
    ProductService productService;

    @PostMapping("/addProduct")
    public BaseModel addProduct(@Validated({InsertGroup.class}) @RequestBody Product product, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            throw BusinessException.INSERT_FAIL.newInstance(this.getErrorResponse(bindingResult),
                    new Object[]{product.toString()});
        } else {
            BaseModel result = new BaseModel();
            int i = productService.insert(product);
            if(i==1){
                result.code = 200;
                return result;
            }else{
                throw BusinessException.INSERT_FAIL;
            }
        }
    }

    @PostMapping("/productList")
    public BaseModelJson<PageInfo<Product>> getProductList(Integer pageNum, Integer pageSize,
                                                     @RequestParam Map<String,Object> map) {
        BaseModelJson<PageInfo<Product>> result = new BaseModelJson();
        if(pageNum == null){
            pageNum = 1;
        }
        if(pageSize == null){
            pageSize = 10;
        }
        result.code = 200;
        result.data = productService.getAllByFilter(pageNum,pageSize,map);
        return result;
    }

    @PostMapping("/deleteProduct")
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
    }
    @PostMapping("/updateProduct")
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
    }



}
