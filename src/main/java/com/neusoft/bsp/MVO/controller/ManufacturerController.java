package com.neusoft.bsp.MVO.controller;

import com.github.pagehelper.PageInfo;
import com.neusoft.bsp.MVO.entity.Manufacturer;
import com.neusoft.bsp.MVO.service.ManufacturerService;
import com.neusoft.bsp.System.entity.User;
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

import java.util.HashMap;
import java.util.Map;

@CrossOrigin
@RestController
@RequestMapping("/manufacturer")
public class ManufacturerController extends BaseController {

    @Autowired
    ManufacturerService manufacturerService;

    @PostMapping("/addManufacturer")
    public BaseModel addManufacturer(@Validated({InsertGroup.class}) @RequestBody Manufacturer manufacturer,
                                     @RequestParam String userId, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            throw BusinessException.INSERT_FAIL.newInstance(this.getErrorResponse(bindingResult),
                    new Object[]{manufacturer.toString()});
        } else {
            Map<String,Object> map = new HashMap<>();
            map.put("man_id",manufacturer.getMan_id());
            map.put("name_en",manufacturer.getName_en());
            map.put("name_cn",manufacturer.getName_cn());
            map.put("gmc_report_type",manufacturer.getGmc_report_type());
            map.put("gmc_report_url",manufacturer.getGmc_report_url());
            map.put("description",manufacturer.getDescription());
            map.put("created_by",manufacturer.getCreated_by());
            map.put("creation_date",manufacturer.getCreation_date());
            map.put("last_update_by",manufacturer.getLast_update_by());
            map.put("last_update_date",manufacturer.getLast_update_date());
            map.put("call_cnt",manufacturer.getCall_cnt());
            map.put("remark",manufacturer.getRemark());
            map.put("sts_cd",manufacturer.getSts_cd());
            map.put("user_id",userId);

            BaseModel result = new BaseModel();
            int i = manufacturerService.insert(map);

            if(i==1){
                result.code = 200;
                return result;
            }else{
                throw BusinessException.INSERT_FAIL;
            }
        }
    }

    @PostMapping("/getmanufacturerinfo")
    public BaseModelJson<Manufacturer> getManufacturerInfo(@RequestBody Manufacturer manufacturer, @RequestParam User user, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            throw BusinessException.MANID_NULL_ERROR.newInstance(this.getErrorResponse(bindingResult),
                    new Object[]{});
        }
        else {
            BaseModelJson<Manufacturer> result = new BaseModelJson();
            manufacturer = manufacturerService.getById(user.getMan_buyer_id());
            if (manufacturer != null) {
                result.code = 200;
                result.data = manufacturerService.getById(user.getMan_buyer_id());
                return result;
            } else {
                throw BusinessException.MANID_NOT_EXISTS;
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
