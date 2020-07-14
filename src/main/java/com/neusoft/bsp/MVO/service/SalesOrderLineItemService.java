package com.neusoft.bsp.MVO.service;

import com.github.pagehelper.PageInfo;
import com.neusoft.bsp.MVO.entity.SalesOrderLineItem;

import java.util.List;
import java.util.Map;

public interface SalesOrderLineItemService {

    int insert(SalesOrderLineItem salesOrderLineItem);

    int update(SalesOrderLineItem salesOrderLineItem);

    int delete(int salesOrderLineItemid);

    SalesOrderLineItem getById(int salesOrderLineItemid);

    List<SalesOrderLineItem> getAll();

    List<SalesOrderLineItem> getAllByFilter(Map<String, Object> map);

    PageInfo<SalesOrderLineItem> getAll(Integer pageNum, Integer pageSize);

}
