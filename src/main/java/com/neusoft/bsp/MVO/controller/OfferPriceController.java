package com.neusoft.bsp.MVO.controller;

import com.github.pagehelper.PageInfo;
import com.neusoft.bsp.MVO.entity.OfferPrice;
import com.neusoft.bsp.MVO.service.OfferPriceService;
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
@RequestMapping("/offerPrice")
public class OfferPriceController extends BaseController {

    @Autowired
    OfferPriceService offerPriceService;

    @PostMapping("/addOfferPrice")
    public BaseModel addOfferPrice(@Validated({InsertGroup.class}) @RequestBody OfferPrice offerPrice, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            throw BusinessException.INSERT_FAIL.newInstance(this.getErrorResponse(bindingResult),
                    new Object[]{offerPrice.toString()});
        } else {
            BaseModel result = new BaseModel();
            int i = offerPriceService.insert(offerPrice);
            if(i==1){
                result.code = 200;
                return result;
            }else{
                throw BusinessException.INSERT_FAIL;
            }
        }
    }

    @PostMapping("/offerPriceList")
    public BaseModelJson<PageInfo<OfferPrice>> getOfferPriceList(Integer pageNum, Integer pageSize,
                                                                 @RequestParam Map<String,Object> map) {
        BaseModelJson<PageInfo<OfferPrice>> result = new BaseModelJson();
        if(pageNum == null){
            pageNum = 1;
        }
        if(pageSize == null){
            pageSize = 10;
        }
        result.code = 200;
        result.data = offerPriceService.getAllByFilter(pageNum,pageSize,map);
        return result;
    }

    @PostMapping("/deleteOfferPrice")
    public BaseModel deleteOfferPrice(@Validated({DeleteGroup.class}) @RequestBody OfferPrice offerPrice, BindingResult bindingResult) throws Exception {
        if (bindingResult.hasErrors()) {
            throw BusinessException.USERID_NULL_ERROR.newInstance(this.getErrorResponse(bindingResult),
                    new Object[]{offerPrice.toString()});
        } else {
            BaseModel result = new BaseModel();
            int i = offerPriceService.delete(offerPrice.getOfp_id());
            if (i == 1) {
                result.code = 200;
                return result;
            } else {
                throw BusinessException.DELETE_FAIL;
            }
        }
    }
    @PostMapping("/updateOfferPrice")
    public BaseModel updateOfferPrice(@Validated({UpdateGroup.class}) @RequestBody OfferPrice offerPrice, BindingResult bindingResult) {  //bindingResult用于获得validate的反馈信息
        if (bindingResult.hasErrors()) {
            throw BusinessException.OFPID_NULL_ERROR.newInstance(this.getErrorResponse(bindingResult),
                    new Object[]{offerPrice.toString()});
        } else {
            BaseModel result = new BaseModel();
            int i =offerPriceService.update(offerPrice);
            if(i==1){
                result.code = 200;
                return result;
            }else{
                throw BusinessException.UPDATE_FAIL;
            }
        }
    }



}
