package com.neusoft.bsp.MVO.controller;

import com.github.pagehelper.PageInfo;
import com.neusoft.bsp.MVO.entity.PackageInfo;
import com.neusoft.bsp.MVO.service.PackageInfoService;
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
@RequestMapping("/packageInfo")
public class PackageInfoController extends BaseController {

    @Autowired
    PackageInfoService packageInfoService;

    @PostMapping("/addPackageInfo")
    public BaseModel addPackageInfo(@Validated({InsertGroup.class}) @RequestBody PackageInfo packageInfo, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            throw BusinessException.INSERT_FAIL.newInstance(this.getErrorResponse(bindingResult),
                    new Object[]{packageInfo.toString()});
        } else {
            BaseModel result = new BaseModel();
            int i = packageInfoService.insert(packageInfo);
            if(i==1){
                result.code = 200;
                return result;
            }else{
                throw BusinessException.INSERT_FAIL;
            }
        }
    }

    @PostMapping("/packageInfoList")
    public BaseModelJson<PageInfo<PackageInfo>> getPackageInfoList(Integer pageNum, Integer pageSize,
                                                                   @RequestParam Map<String,Object> map) {
        BaseModelJson<PageInfo<PackageInfo>> result = new BaseModelJson();
        if(pageNum == null){
            pageNum = 1;
        }
        if(pageSize == null){
            pageSize = 10;
        }
        result.code = 200;
        result.data = packageInfoService.getAllByFilter(pageNum,pageSize,map);
        return result;
    }

    @PostMapping("/deletePackageInfo")
    public BaseModel deletePackageInfo(@Validated({DeleteGroup.class}) @RequestBody PackageInfo packageInfo, BindingResult bindingResult) throws Exception {
        if (bindingResult.hasErrors()) {
            throw BusinessException.USERID_NULL_ERROR.newInstance(this.getErrorResponse(bindingResult),
                    new Object[]{packageInfo.toString()});
        } else {
            BaseModel result = new BaseModel();
            int i = packageInfoService.delete(packageInfo.getPck_id());
            if (i == 1) {
                result.code = 200;
                return result;
            } else {
                throw BusinessException.DELETE_FAIL;
            }
        }
    }
    @PostMapping("/updatePackageInfo")
    public BaseModel updatePackageInfo(@Validated({UpdateGroup.class}) @RequestBody PackageInfo packageInfo, BindingResult bindingResult) {  //bindingResult用于获得validate的反馈信息
        if (bindingResult.hasErrors()) {
            throw BusinessException.PCKID_NULL_ERROR.newInstance(this.getErrorResponse(bindingResult),
                    new Object[]{packageInfo.toString()});
        } else {
            BaseModel result = new BaseModel();
            int i =packageInfoService.update(packageInfo);
            if(i==1){
                result.code = 200;
                return result;
            }else{
                throw BusinessException.UPDATE_FAIL;
            }
        }
    }



}
