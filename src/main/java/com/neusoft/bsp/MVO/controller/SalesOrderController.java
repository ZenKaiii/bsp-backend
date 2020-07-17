package com.neusoft.bsp.MVO.controller;

import com.alibaba.fastjson.JSONArray;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.neusoft.bsp.MVO.entity.Product;
import com.neusoft.bsp.MVO.entity.SalesOrder;
import com.neusoft.bsp.MVO.entity.SalesOrderLineItem;
import com.neusoft.bsp.MVO.service.ProductService;
import com.neusoft.bsp.MVO.service.SalesOrderLineItemService;
import com.neusoft.bsp.MVO.service.SalesOrderService;
import com.neusoft.bsp.MVO.vo.SalesOrderVo;
import com.neusoft.bsp.common.base.BaseController;
import com.neusoft.bsp.common.base.BaseModel;
import com.neusoft.bsp.common.base.BaseModelJsonPaging;
import com.neusoft.bsp.common.exception.BusinessException;
import com.neusoft.bsp.common.validationGroup.InsertGroup;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin
@RestController
@RequestMapping("/salesOrder")
public class SalesOrderController extends BaseController {

    @Autowired
    SalesOrderService salesOrderService;
    @Autowired
    SalesOrderLineItemService salesOrderLineItemService;
    @Autowired
    ProductService productService;

    @PostMapping("/alterSalesOrder")
    public BaseModel alterSalesOrder(@Validated({InsertGroup.class}) @RequestBody SalesOrderVo salesOrderVo, @RequestParam int userId, BindingResult bindingResult) {
//        SalesOrderVo salesOrderVo=JSONArray.parseObject(salesOrderVoJson, SalesOrderVo.class);
        if (bindingResult.hasErrors()) {
            throw BusinessException.INSERT_FAIL.newInstance(this.getErrorResponse(bindingResult),
                    new Object[]{salesOrderVo.toString()});
        } else {
            int i=0;
            Map<String,Object> map=new HashMap<>();
            map.put("sku",salesOrderVo.getSku());
            map.put("orderNo",salesOrderVo.getOrderNo());

            SalesOrder salesOrder=salesOrderService.getSaoByOrderNo(salesOrderVo.getOrderNo());
            SalesOrderLineItem salesOrderLineItem=salesOrderLineItemService.getSalBySku(map);

            salesOrderVo.changeSalesOrder(salesOrder);
            i=salesOrderService.update(salesOrder);

            salesOrderVo.changeSalesOrderLineItem(salesOrderLineItem);
            i=salesOrderLineItemService.update(salesOrderLineItem);

            BaseModel result = new BaseModel();
            if(i==1){
                result.code = 200;
                return result;
            }else{
                throw BusinessException.INSERT_FAIL;
            }
        }
    }

   /* @PostMapping("/alterSalesOrderDetail")
    public BaseModel alterSalesOrderDetail(@Validated({InsertGroup.class}) @RequestParam int userId, BindingResult bindingResult) {
        SalesOrderVo salesOrderVo=JSONArray.parseObject(salesOrderVoJson,SalesOrderVo.class);
        if (bindingResult.hasErrors()) {
            throw BusinessException.INSERT_FAIL.newInstance(this.getErrorResponse(bindingResult),
                    new Object[]{salesOrderVo.toString()});
        } else {
            List<SalesOrderLineItem> salesOrderLineItems = salesOrderLineItemService.getByUserId(userId);
            salesOrder.setTitle(salesOrderVo.getTitle());
            int i = 0;

            SalesOrderCategory salesOrderCategory = salesOrderVo.toSalesOrderCategory();
            salesOrderCategory.setPro_id(salesOrder.getPro_id());
            salesOrderCategory.setCreated_by("" + userId);
            salesOrderCategory.setLast_update_by("" + userId);
            salesOrderCategory.setCreation_date(new Date(System.currentTimeMillis()));
            salesOrderCategory.setLast_update_date(new Date(System.currentTimeMillis()));
            i = salesOrderCategoryService.insert(salesOrderCategory);

            Img img = salesOrderVo.toImg();
            img.setEntityId(salesOrder.getPro_id());
            img.setCreatedBy("" + userId);
            img.setLastUpdateBy("" + userId);
            img.setCreationDate(new Date(System.currentTimeMillis()));
            img.setLastUpdateDate(new Date(System.currentTimeMillis()));
            i = imgService.insert(img);

            BaseModel result = new BaseModel();
            if(i==1){
                result.code = 200;
                return result;
            }else{
                throw BusinessException.INSERT_FAIL;
            }
        }
    }*/


    @GetMapping("/salesOrderList")
    public BaseModelJsonPaging<PageInfo<SalesOrderVo>> getSalesOrderList(Integer pageNum, Integer pageSize,
                                                                         @RequestParam int userId) {
        List<SalesOrderLineItem> salesOrderLineItems = salesOrderLineItemService.getByUserId(userId);
        BaseModelJsonPaging<PageInfo<SalesOrderVo>> result = new BaseModelJsonPaging();
//        Map<String,Object> map=new HashMap<>();
//        map.put("userId",userId);
        if(pageNum == null){
            pageNum = 1;
        }
        if(pageSize == null){
            pageSize = 10;
        }
        List<SalesOrderVo> salesOrderVoList=new ArrayList<>();
        for(SalesOrderLineItem salesOrderLineItem:salesOrderLineItems){
//            SalesOrderVo salesOrderVo=new SalesOrderVo();
            salesOrderVoList.add(this.getSalesOrderVo(salesOrderLineItem));
        }

        PageHelper.startPage(pageNum,pageSize,true);
        PageInfo<SalesOrderVo> salesOrderVoPage=new PageInfo(salesOrderVoList);
        result.code = 200;
        result.data = salesOrderVoPage;
        result.message= JSONArray.toJSONString(salesOrderVoPage);
        return result;
    }

    public SalesOrderVo getSalesOrderVo(SalesOrderLineItem salesOrderLineItem){
        SalesOrder salesOrder=salesOrderService.getById(salesOrderLineItem.getSaoId());
        Product product=productService.getById(salesOrderLineItem.getProId());
        SalesOrderVo salesOrderVo=new SalesOrderVo();
        salesOrderVo.setTitle(product.getTitle());
        salesOrderVo.setCreatedTime(salesOrder.getCreationDate());
        salesOrderVo.setOrderSts(salesOrder.getOrderSts());
        salesOrderVo.setOrderNo(salesOrder.getOrderNo());
        salesOrderVo.setQty(salesOrderLineItem.getQty());
        salesOrderVo.setSku(product.getSku_cd());
        salesOrderVo.setTrackingNo(salesOrderLineItem.getTrackingNo());
        salesOrderVo.setPrice(product.getRetail_price());
        return salesOrderVo;
    }

    /*@PostMapping("/deleteSalesOrder")
    public BaseModel deleteSalesOrder(@Validated({DeleteGroup.class}) @RequestBody SalesOrder salesOrder, BindingResult bindingResult) throws Exception {
        if (bindingResult.hasErrors()) {
            throw BusinessException.USERID_NULL_ERROR.newInstance(this.getErrorResponse(bindingResult),
                    new Object[]{salesOrder.toString()});
        } else {
            BaseModel result = new BaseModel();
            int i = salesOrderService.delete(salesOrder.getPro_id());
            if (i == 1) {
                result.code = 200;
                return result;
            } else {
                throw BusinessException.DELETE_FAIL;
            }
        }
    }*/
    /*@PostMapping("/updateSalesOrder")
    public BaseModel updateSalesOrder(@Validated({UpdateGroup.class}) @RequestBody SalesOrder salesOrder, BindingResult bindingResult) {  //bindingResult用于获得validate的反馈信息
        if (bindingResult.hasErrors()) {
            throw BusinessException.PROID_NULL_ERROR.newInstance(this.getErrorResponse(bindingResult),
                    new Object[]{salesOrder.toString()});
        } else {
            BaseModel result = new BaseModel();
            int i =salesOrderService.update(salesOrder);
            if(i==1){
                result.code = 200;
                return result;
            }else{
                throw BusinessException.UPDATE_FAIL;
            }
        }
    }*/



}
