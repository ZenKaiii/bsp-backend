package com.neusoft.bsp.MVO.controller;

import com.alibaba.fastjson.JSONArray;
import com.neusoft.bsp.MVO.entity.Manufacturer;
import com.neusoft.bsp.MVO.service.ManufacturerService;
import com.neusoft.bsp.MVO.vo.ManufacturerVo;
import com.neusoft.bsp.common.base.BaseController;
import com.neusoft.bsp.common.base.BaseModel;
import com.neusoft.bsp.common.base.BaseModelJson;
import com.neusoft.bsp.common.exception.BusinessException;
import com.neusoft.bsp.common.validationGroup.DeleteGroup;
import com.neusoft.bsp.common.validationGroup.InsertGroup;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@CrossOrigin
@RestController
@RequestMapping("/manufacturer")
public class ManufacturerController extends BaseController {

    @Autowired
    ManufacturerService manufacturerService;

    @PostMapping("/alterManufacturer")
    public BaseModel alterManufacturer(@Validated({InsertGroup.class}) @RequestBody ManufacturerVo manufacturerVo,
                                       @RequestParam int userId, BindingResult bindingResult) {
        //ManufacturerVo manufacturerVo = JSONArray.parseObject(manufacturerVoJson, ManufacturerVo.class);
        if (bindingResult.hasErrors()) {
            throw BusinessException.INSERT_FAIL.newInstance(this.getErrorResponse(bindingResult),
                    new Object[]{manufacturerVo.toString()});
        } else {
            Map<String,Object> map = new HashMap<>();
            Manufacturer manufacturer=manufacturerService.selectByUserId(userId);
//            Manufacturer manufacturer=new Manufacturer();
            manufacturer=manufacturerVo.changeManufacturer(manufacturer);
            map.put("man_id",manufacturer.getMan_id());
            map.put("name_en",manufacturer.getName_en());
            map.put("name_cn",manufacturer.getName_cn());
            map.put("gmc_report_type",manufacturer.getGmc_report_type());
            map.put("gmc_report_url",manufacturer.getGmc_report_url());
            map.put("description",manufacturer.getDescription());
            map.put("created_by",userId);
            map.put("last_update_by",userId);
            map.put("call_cnt",manufacturer.getCall_cnt());
            map.put("remark",manufacturer.getRemark());
            map.put("sts_cd",manufacturer.getSts_cd());
            map.put("user_id",userId);
            int i=0;
            if(manufacturerService.getManIdByUserId(userId)!=0){
                manufacturer.setLast_update_date(new Date(System.currentTimeMillis()));
                i=manufacturerService.update(manufacturer);
            }
            else {
                map.put("created_date",new Date(System.currentTimeMillis()).toString());
                i=manufacturerService.insert(map);
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

    @GetMapping("/getmanufacturerinfo")
    public BaseModelJson<ManufacturerVo> getManufacturerInfo(@RequestParam int userId) {
        BaseModelJson<ManufacturerVo> result = new BaseModelJson();
        Manufacturer manufacturer = manufacturerService.selectByUserId(userId);
        if (manufacturer != null) {
            result.code = 200;
            ManufacturerVo manufacturerVo=new ManufacturerVo();
            manufacturerVo=manufacturerVo.getManufacturerVo(manufacturer);
            result.data = manufacturerVo;
            result.message= JSONArray.toJSONString(manufacturerVo);
            return result;
        } else {
            result.code=200;
            result.message="Manufacturer doesn't exist";
            return  result;
        }

    }


    /*@PostMapping("/deleteManufacturer")
    public BaseModel deleteManufacturer(@Validated({DeleteGroup.class}) @RequestParam int userId, BindingResult bindingResult) throws Exception {
        if (bindingResult.hasErrors()) {
            throw BusinessException.USERID_NULL_ERROR.newInstance(this.getErrorResponse(bindingResult),
                    new Object[]{userId});
        } else {
            Manufacturer manufacturer=manufacturerService.selectByUserId(userId);
            BaseModel result = new BaseModel();
            int i = manufacturerService.delete(manufacturer.getMan_id());
            if (i == 1) {
                result.code = 200;
                return result;
            } else {
                throw BusinessException.DELETE_FAIL;
            }
        }
    }*/
}
