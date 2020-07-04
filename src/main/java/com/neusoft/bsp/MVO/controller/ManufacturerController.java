package com.neusoft.bsp.MVO.controller;

import com.github.pagehelper.PageInfo;
import com.neusoft.bsp.MVO.entity.Manufacturer;
import com.neusoft.bsp.MVO.service.ManufacturerService;
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
@RequestMapping("/manufacturer")
public class ManufacturerController extends BaseController {

    @Autowired
    ManufacturerService manufacturerService;

    @PostMapping("/addManufacturer")
    public BaseModel addManufacturer(@Validated({InsertGroup.class}) @RequestBody Manufacturer manufacturer, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            throw BusinessException.INSERT_FAIL.newInstance(this.getErrorResponse(bindingResult),
                    new Object[]{manufacturer.toString()});
        } else {
            BaseModel result = new BaseModel();
            int i = manufacturerService.insert(manufacturer);
            if(i==1){
                result.code = 200;
                return result;
            }else{
                throw BusinessException.INSERT_FAIL;
            }
        }
    }

    @PostMapping("/manufacturerList")
    public BaseModelJson<PageInfo<Manufacturer>> getManufacturerList(Integer pageNum, Integer pageSize,
                                                     @RequestParam Map<String,Object> map) {
        BaseModelJson<PageInfo<Manufacturer>> result = new BaseModelJson();
        if(pageNum == null){
            pageNum = 1;
        }
        if(pageSize == null){
            pageSize = 10;
        }
        result.code = 200;
        result.data = manufacturerService.getAllByFilter(pageNum,pageSize,map);
        return result;
    }

    @PostMapping("/deleteManufacturer")
    public BaseModel deleteManufacturer(@Validated({DeleteGroup.class}) @RequestBody Manufacturer manufacturer, BindingResult bindingResult) throws Exception {
        if (bindingResult.hasErrors()) {
            throw BusinessException.USERID_NULL_ERROR.newInstance(this.getErrorResponse(bindingResult),
                    new Object[]{manufacturer.toString()});
        } else {
            BaseModel result = new BaseModel();
            int i = manufacturerService.delete(manufacturer.getMan_id());
            if (i == 1) {
                result.code = 200;
                return result;
            } else {
                throw BusinessException.DELETE_FAIL;
            }
        }
    }
    @PostMapping("/updateManufacturer")
    public BaseModel updateManufacturer(@Validated({UpdateGroup.class}) @RequestBody Manufacturer manufacturer, BindingResult bindingResult) {  //bindingResult用于获得validate的反馈信息
        if (bindingResult.hasErrors()) {
            throw BusinessException.MANID_NULL_ERROR.newInstance(this.getErrorResponse(bindingResult),
                    new Object[]{manufacturer.toString()});
        } else {
            BaseModel result = new BaseModel();
            int i =manufacturerService.update(manufacturer);
            if(i==1){
                result.code = 200;
                return result;
            }else{
                throw BusinessException.UPDATE_FAIL;
            }
        }
    }



}
