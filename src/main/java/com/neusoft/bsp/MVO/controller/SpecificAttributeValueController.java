package com.neusoft.bsp.MVO.controller;

import com.github.pagehelper.PageInfo;
import com.neusoft.bsp.MVO.entity.SpecificAttributeValue;
import com.neusoft.bsp.MVO.service.SpecificAttributeValueService;
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
@RequestMapping("/specificAttributeValue")
public class SpecificAttributeValueController extends BaseController {

    @Autowired
    SpecificAttributeValueService specificAttributeValueService;

    @PostMapping("/addSpecificAttributeValue")
    public BaseModel addSpecificAttributeValue(@Validated({InsertGroup.class}) @RequestBody SpecificAttributeValue specificAttributeValue, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            throw BusinessException.INSERT_FAIL.newInstance(this.getErrorResponse(bindingResult),
                    new Object[]{specificAttributeValue.toString()});
        } else {
            BaseModel result = new BaseModel();
            int i = specificAttributeValueService.insert(specificAttributeValue);
            if(i==1){
                result.code = 200;
                return result;
            }else{
                throw BusinessException.INSERT_FAIL;
            }
        }
    }

    @PostMapping("/specificAttributeValueList")
    public BaseModelJson<PageInfo<SpecificAttributeValue>> getSpecificAttributeValueList(Integer pageNum, Integer pageSize,
                                                     @RequestParam Map<String,Object> map) {
        BaseModelJson<PageInfo<SpecificAttributeValue>> result = new BaseModelJson();
        if(pageNum == null){
            pageNum = 1;
        }
        if(pageSize == null){
            pageSize = 10;
        }
        result.code = 200;
        result.data = specificAttributeValueService.getAllByFilter(pageNum,pageSize,map);
        return result;
    }

    @PostMapping("/deleteSpecificAttributeValue")
    public BaseModel deleteSpecificAttributeValue(@Validated({DeleteGroup.class}) @RequestBody SpecificAttributeValue specificAttributeValue, BindingResult bindingResult) throws Exception {
        if (bindingResult.hasErrors()) {
            throw BusinessException.USERID_NULL_ERROR.newInstance(this.getErrorResponse(bindingResult),
                    new Object[]{specificAttributeValue.toString()});
        } else {
            BaseModel result = new BaseModel();
            int i = specificAttributeValueService.delete(specificAttributeValue.getSpv_id());
            if (i == 1) {
                result.code = 200;
                return result;
            } else {
                throw BusinessException.DELETE_FAIL;
            }
        }
    }
    @PostMapping("/updateSpecificAttributeValue")
    public BaseModel updateSpecificAttributeValue(@Validated({UpdateGroup.class}) @RequestBody SpecificAttributeValue specificAttributeValue, BindingResult bindingResult) {  //bindingResult用于获得validate的反馈信息
        if (bindingResult.hasErrors()) {
            throw BusinessException.SPVID_NULL_ERROR.newInstance(this.getErrorResponse(bindingResult),
                    new Object[]{specificAttributeValue.toString()});
        } else {
            BaseModel result = new BaseModel();
            int i =specificAttributeValueService.update(specificAttributeValue);
            if(i==1){
                result.code = 200;
                return result;
            }else{
                throw BusinessException.UPDATE_FAIL;
            }
        }
    }



}
