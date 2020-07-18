package com.neusoft.bsp.MVO.service;

import com.github.pagehelper.PageInfo;
import com.neusoft.bsp.MVO.entity.SalesOrder;
import com.neusoft.bsp.MVO.entity.SalesOrderLineItem;
import com.neusoft.bsp.MVO.vo.SalesOrderVo;

import java.util.List;
import java.util.Map;

public interface SalesOrderService {

    int alterSalesOrder(SalesOrderVo salesOrderVo, int userId);

    List<SalesOrderVo> getSalesOrderList(int userId);

    int insert(SalesOrder salesOrder);

    int update(SalesOrder salesOrder);

    int delete(int salesOrderid);

    SalesOrder getById(int salesOrderid);

    SalesOrder getSaoByOrderNo(String orderNo);

    List<SalesOrder> getByUserId(int userId);

    List<SalesOrder> getAll();

    List<SalesOrder> getAllByFilter(Map<String, Object> map);

    PageInfo<SalesOrder> getAll(Integer pageNum, Integer pageSize);

}
