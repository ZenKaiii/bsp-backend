package com.neusoft.bsp.MVO.controller;

import com.alibaba.fastjson.JSONArray;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.neusoft.bsp.MVO.entity.Brand;
import com.neusoft.bsp.MVO.service.BrandService;
import com.neusoft.bsp.MVO.service.ManufacturerService;
import com.neusoft.bsp.MVO.vo.BrandVo;
import com.neusoft.bsp.common.base.BaseController;
import com.neusoft.bsp.common.base.BaseModel;
import com.neusoft.bsp.common.base.BaseModelJsonPaging;
import com.neusoft.bsp.common.exception.BusinessException;
import com.neusoft.bsp.common.validationGroup.DeleteGroup;
import com.neusoft.bsp.common.validationGroup.InsertGroup;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@CrossOrigin
@RestController
@RequestMapping("/brand")
public class BrandController extends BaseController {

    @Autowired
    BrandService brandService;
    ManufacturerService manufacturerService;

    @PostMapping("/alterBrand")
    public BaseModel alterBrand(@Validated({InsertGroup.class}) @RequestParam String brandVoJson,
                                @RequestParam int userId, BindingResult bindingResult) {
        BrandVo brandVo= JSONArray.parseObject(brandVoJson,BrandVo.class);
        if (bindingResult.hasErrors()) {
            throw BusinessException.INSERT_FAIL.newInstance(this.getErrorResponse(bindingResult),
                    new Object[]{brandVo.toString()});
        } else {
            Brand brand=brandService.getByNameEn(brandVo.getName_en());
            int i=0;
            if(brand==null){
                brand=brandVo.toBrand();
                brand.setCreated_by(""+userId);
                brand.setLast_update_by(""+userId);
                brand.setCreation_date(new Date(System.currentTimeMillis()));
                brand.setLast_update_date(new Date(System.currentTimeMillis()));
                brand.setMan_id(manufacturerService.getManIdByUserId(userId));
                i=brandService.insert(brand);
            }
            else{
                brandVo.changeBrand(brand);
                brand.setLast_update_date(new Date(System.currentTimeMillis()));
                i=brandService.update(brand);
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

    @PostMapping("/brandList")
    public BaseModelJsonPaging<PageInfo<BrandVo>> getBrandList(Integer pageNum, Integer pageSize,
                                                               @RequestParam int userId) {
        Map<String,Object> map = new HashMap<>();
        map.put("user_id",userId);
        BaseModelJsonPaging<PageInfo<BrandVo>> result = new BaseModelJsonPaging<>();
        if(pageNum == null){
            pageNum = 1;
        }
        if(pageSize == null){
            pageSize = 10;
        }
        List<Brand> brandList= brandService.getAllByUserId(map);
        List<BrandVo> brandVoList=new ArrayList<>();
        for(Brand brand:brandList){
            BrandVo brandVo=new BrandVo();
            brandVoList.add(brandVo.getBrandVO(brand));
        }
        PageHelper.startPage(pageNum,pageSize,true);
        PageInfo<BrandVo> brandVoPage=new PageInfo(brandVoList);
        result.code = 200;
        result.data = brandVoPage;
        result.message=JSONArray.toJSONString(brandVoPage);
        return result;
    }

    @PostMapping("/deleteBrand")
    public BaseModel deleteBrand(@Validated({DeleteGroup.class}) @RequestParam String brandVoJson, BindingResult bindingResult) throws Exception {
        Brand brandVo=JSONArray.parseObject(brandVoJson,Brand.class);
        if (bindingResult.hasErrors()) {
            throw BusinessException.USERID_NULL_ERROR.newInstance(this.getErrorResponse(bindingResult),
                    new Object[]{brandVo.toString()});
        } else {
            BaseModel result = new BaseModel();
            Brand brand=brandService.getByNameEn(brandVo.getName_en());
            int i = brandService.delete(brand.getBrd_id());
            if (i == 1) {
                result.code = 200;
                return result;
            } else {
                throw BusinessException.DELETE_FAIL;
            }
        }
    }




}
