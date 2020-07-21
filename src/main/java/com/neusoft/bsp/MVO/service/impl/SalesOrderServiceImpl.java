package com.neusoft.bsp.MVO.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.neusoft.bsp.MVO.entity.Product;
import com.neusoft.bsp.MVO.entity.SalesOrder;
import com.neusoft.bsp.MVO.entity.SalesOrderLineItem;
import com.neusoft.bsp.MVO.mapper.SalesOrderMapper;
import com.neusoft.bsp.MVO.service.ProductService;
import com.neusoft.bsp.MVO.service.SalesOrderLineItemService;
import com.neusoft.bsp.MVO.service.SalesOrderService;
import com.neusoft.bsp.MVO.vo.SalesOrderVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service ("salesOrderService")
public class SalesOrderServiceImpl implements SalesOrderService {
    @Autowired
    SalesOrderMapper salesOrderMapper;

    @Autowired
    SalesOrderLineItemService salesOrderLineItemService;
    @Autowired
    ProductService productService;


    @Override
    public int alterSalesOrder(SalesOrderVo salesOrderVo, int userId) {
        int i=0;
        if(salesOrderVo.getOrderSts()=="3"){
            i=this.deliver(salesOrderVo.getSku(),salesOrderVo.getQty());
            if(i==0){
                return 0;
            }
        }
        Map<String, Object> map = new HashMap<>();
        map.put("sku", salesOrderVo.getSku());
        map.put("orderNo", salesOrderVo.getOrderNo());
        SalesOrderLineItem salesOrderLineItem = salesOrderLineItemService.getSalBySku(map);


        SalesOrder salesOrder = this.getSaoByOrderNo(salesOrderVo.getOrderNo());
        salesOrderVo.changeSalesOrder(salesOrder);
        i = this.update(salesOrder);
        if(i==0){
            return 0;
        }

        salesOrderVo.changeSalesOrderLineItem(salesOrderLineItem);
        i = salesOrderLineItemService.update(salesOrderLineItem);
        if(i==0){
            return 0;
        }

        return i;
    }

    public int deliver(String sku,int qty){
        Product product=productService.getBySku(sku);
        int i=0;
        if(product!=null){
            if(product.getStockseting()>qty) {
                product.setStockseting(product.getStockseting()-qty);
                i=productService.update(product);
            }
        }
        return i;
    }

    @Override
    public List<SalesOrderVo> getSalesOrderList(int userId,String orderSts) {
        Map<String,Object> map=new HashMap<>();
        map.put("userId",userId);
        map.put("orderSts",orderSts);
        List<SalesOrderLineItem> salesOrderLineItems = salesOrderLineItemService.getByOrder(map);
        List<SalesOrderVo> salesOrderVoList = new ArrayList<>();
        if(salesOrderLineItems.size()!=0) {
            for (SalesOrderLineItem salesOrderLineItem : salesOrderLineItems) {
//            SalesOrderVo salesOrderVo=new SalesOrderVo();
                salesOrderVoList.add(this.getSalesOrderVo(salesOrderLineItem));
            }
        }
        return salesOrderVoList;
    }

    public SalesOrderVo getSalesOrderVo(SalesOrderLineItem salesOrderLineItem){
        SalesOrderVo salesOrderVo = new SalesOrderVo();
        if(salesOrderLineItem!=null) {
            SalesOrder salesOrder = this.getById(salesOrderLineItem.getSaoId());
            Product product = productService.getById(salesOrderLineItem.getProId());
            if (product != null) {
                salesOrderVo.setTitle(product.getTitle());
                salesOrderVo.setSku(product.getSku_cd());
                salesOrderVo.setPrice(product.getRetail_price());
            }
            if (salesOrder != null) {
                salesOrderVo.setCreatedTime(salesOrder.getCreationDate());
                salesOrderVo.setOrderSts(salesOrder.getOrderSts());
                salesOrderVo.setOrderNo(salesOrder.getOrderNo());
            }
            salesOrderVo.setQty(salesOrderLineItem.getQty());
            salesOrderVo.setTrackingNo(salesOrderLineItem.getTrackingNo());
            salesOrderVo.setWspName(salesOrderLineItem.getWspName());
            salesOrderVo.setProId(salesOrderLineItem.getProId());
        }
//        this.getExpressInfo(salesOrderVo);
        return salesOrderVo;
    }

//    public SalesOrderVo getExpressInfo(SalesOrderVo salesOrderVo){
//        ExpressQuery expressQuery=new ExpressQuery();
//        String expressInfo=expressQuery.queryLogistics(salesOrderVo.getWspName(),salesOrderVo.getOrderNo());
//        JSONObject jsonData = JSONObject.parseObject(expressInfo);
//        salesOrderVo.setOrderSts(""+jsonData.getString("state"));
//        return salesOrderVo;
//    }


    @Override
    public int insert(SalesOrder salesOrder) {
       return salesOrderMapper.insert(salesOrder);
    }

    @Override
    public int update(SalesOrder salesOrder) {
       return salesOrderMapper.update(salesOrder);
    }

    @Override
    public int delete(int salesOrderid) {
        return salesOrderMapper.delete(salesOrderid);
    }

    @Override
    public SalesOrder getById(int salesOrderid) {
        return salesOrderMapper.getById(salesOrderid);
    }

    @Override
    public SalesOrder getSaoByOrderNo(String orderNo) {
        return salesOrderMapper.getSaoByOrderNo(orderNo);
    }

    @Override
    public List<SalesOrder> getByUserId(int userId) {
        return salesOrderMapper.getByUserId(userId);
    }


    @Override
    public List<SalesOrder> getAll() {
       return salesOrderMapper.getAll();
    }

    @Override
    public List<SalesOrder> getAllByFilter(Map<String, Object> map) {
       return salesOrderMapper.getAllByFilter(map);
    }

    @Override
    public PageInfo<SalesOrder> getAll(Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum,pageSize,true);
        List<SalesOrder> SalesOrders = salesOrderMapper.getAll();
        return new PageInfo<>(SalesOrders);
    }
}
