package com.neusoft.bsp.MVO.service;

import com.github.pagehelper.PageInfo;
import com.neusoft.bsp.MVO.entity.Product;
import com.neusoft.bsp.MVO.entity.SalesOrder;
import com.neusoft.bsp.MVO.entity.SalesOrderLineItem;

import java.util.List;
import java.util.Map;

public interface SalesOrderLineItemService {

    int insert(SalesOrderLineItem salesOrderLineItem);

    int update(SalesOrderLineItem salesOrderLineItem);

    int delete(int salesOrderLineItemid);

    List<SalesOrderLineItem> getByOrder(Map map);

    SalesOrderLineItem getSalBySku(Map map);

    SalesOrderLineItem getById(int salesOrderLineItemid);

    List<SalesOrderLineItem> getBySaoId(int SaoId);

    List<SalesOrderLineItem> getByUserId(int userId);

    List<SalesOrderLineItem> getAll();

    List<SalesOrderLineItem> getAllByFilter(Map<String, Object> map);

    PageInfo<SalesOrderLineItem> getAll(Integer pageNum, Integer pageSize);

}
