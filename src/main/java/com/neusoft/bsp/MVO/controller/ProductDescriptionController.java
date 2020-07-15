package com.neusoft.bsp.MVO.controller;

import com.github.pagehelper.PageInfo;
import com.neusoft.bsp.MVO.entity.ProductDescription;
import com.neusoft.bsp.MVO.service.ProductDescriptionService;
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
@RequestMapping("/productDescription")
public class ProductDescriptionController extends BaseController {

    @Autowired
    ProductDescriptionService productDescriptionService;

    @PostMapping("/addProductDescription")
    public BaseModel addProductDescription(@Validated({InsertGroup.class}) @RequestBody ProductDescription productDescription, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            throw BusinessException.INSERT_FAIL.newInstance(this.getErrorResponse(bindingResult),
                    new Object[]{productDescription.toString()});
        } else {
            BaseModel result = new BaseModel();
            int i = productDescriptionService.insert(productDescription);
            if(i==1){
                result.code = 200;
                return result;
            }else{
                throw BusinessException.INSERT_FAIL;
            }
        }
    }

    @PostMapping("/productDescriptionList")
    public BaseModelJson<PageInfo<ProductDescription>> getProductDescriptionList(Integer pageNum, Integer pageSize,
                                                                                 @RequestParam Map<String,Object> map) {
        BaseModelJson<PageInfo<ProductDescription>> result = new BaseModelJson();
        if(pageNum == null){
            pageNum = 1;
        }
        if(pageSize == null){
            pageSize = 10;
        }
        result.code = 200;
        result.data = productDescriptionService.getAllByFilter(pageNum,pageSize,map);
        return result;
    }

    @PostMapping("/deleteProductDescription")
    public BaseModel deleteProductDescription(@Validated({DeleteGroup.class}) @RequestBody ProductDescription productDescription, BindingResult bindingResult) throws Exception {
        if (bindingResult.hasErrors()) {
            throw BusinessException.USERID_NULL_ERROR.newInstance(this.getErrorResponse(bindingResult),
                    new Object[]{productDescription.toString()});
        } else {
            BaseModel result = new BaseModel();
            int i = productDescriptionService.delete(productDescription.getPdn_id());
            if (i == 1) {
                result.code = 200;
                return result;
            } else {
                throw BusinessException.DELETE_FAIL;
            }
        }
    }
    @PostMapping("/updateProductDescription")
    public BaseModel updateProductDescription(@Validated({UpdateGroup.class}) @RequestBody ProductDescription productDescription, BindingResult bindingResult) {  //bindingResult用于获得validate的反馈信息
        if (bindingResult.hasErrors()) {
            throw BusinessException.PDNID_NULL_ERROR.newInstance(this.getErrorResponse(bindingResult),
                    new Object[]{productDescription.toString()});
        } else {
            BaseModel result = new BaseModel();
            int i =productDescriptionService.update(productDescription);
            if(i==1){
                result.code = 200;
                return result;
            }else{
                throw BusinessException.UPDATE_FAIL;
            }
        }
    }



}
