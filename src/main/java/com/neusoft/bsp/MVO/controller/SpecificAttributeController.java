package com.neusoft.bsp.MVO.controller;

import com.github.pagehelper.PageInfo;
import com.neusoft.bsp.MVO.entity.SpecificAttribute;
import com.neusoft.bsp.MVO.service.SpecificAttributeService;
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
@RequestMapping("/specificAttribute")
public class SpecificAttributeController extends BaseController {

    @Autowired
    SpecificAttributeService specificAttributeService;

    @PostMapping("/addSpecificAttribute")
    public BaseModel addSpecificAttribute(@Validated({InsertGroup.class}) @RequestBody SpecificAttribute specificAttribute, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            throw BusinessException.INSERT_FAIL.newInstance(this.getErrorResponse(bindingResult),
                    new Object[]{specificAttribute.toString()});
        } else {
            BaseModel result = new BaseModel();
            int i = specificAttributeService.insert(specificAttribute);
            if(i==1){
                result.code = 200;
                return result;
            }else{
                throw BusinessException.INSERT_FAIL;
            }
        }
    }

    @PostMapping("/specificAttributeList")
    public BaseModelJson<PageInfo<SpecificAttribute>> getSpecificAttributeList(Integer pageNum, Integer pageSize,
                                                     @RequestParam Map<String,Object> map) {
        BaseModelJson<PageInfo<SpecificAttribute>> result = new BaseModelJson();
        if(pageNum == null){
            pageNum = 1;
        }
        if(pageSize == null){
            pageSize = 10;
        }
        result.code = 200;
        result.data = specificAttributeService.getAllByFilter(pageNum,pageSize,map);
        return result;
    }

    @PostMapping("/deleteSpecificAttribute")
    public BaseModel deleteSpecificAttribute(@Validated({DeleteGroup.class}) @RequestBody SpecificAttribute specificAttribute, BindingResult bindingResult) throws Exception {
        if (bindingResult.hasErrors()) {
            throw BusinessException.USERID_NULL_ERROR.newInstance(this.getErrorResponse(bindingResult),
                    new Object[]{specificAttribute.toString()});
        } else {
            BaseModel result = new BaseModel();
            int i = specificAttributeService.delete(specificAttribute.getSpa_id());
            if (i == 1) {
                result.code = 200;
                return result;
            } else {
                throw BusinessException.DELETE_FAIL;
            }
        }
    }
    @PostMapping("/updateSpecificAttribute")
    public BaseModel updateSpecificAttribute(@Validated({UpdateGroup.class}) @RequestBody SpecificAttribute specificAttribute, BindingResult bindingResult) {  //bindingResult用于获得validate的反馈信息
        if (bindingResult.hasErrors()) {
            throw BusinessException.SPAID_NULL_ERROR.newInstance(this.getErrorResponse(bindingResult),
                    new Object[]{specificAttribute.toString()});
        } else {
            BaseModel result = new BaseModel();
            int i =specificAttributeService.update(specificAttribute);
            if(i==1){
                result.code = 200;
                return result;
            }else{
                throw BusinessException.UPDATE_FAIL;
            }
        }
    }



}
