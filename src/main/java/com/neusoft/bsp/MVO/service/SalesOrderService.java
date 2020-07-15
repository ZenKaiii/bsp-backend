package com.neusoft.bsp.MVO.service;

import com.github.pagehelper.PageInfo;
import com.neusoft.bsp.MVO.entity.SalesOrder;

import java.util.List;
import java.util.Map;

public interface SalesOrderService {

    int insert(SalesOrder salesOrder);

    int update(SalesOrder salesOrder);

    int delete(int salesOrderid);

    SalesOrder getById(int salesOrderid);

    List<SalesOrder> getByUserId(int userId);

    List<SalesOrder> getAll();

    List<SalesOrder> getAllByFilter(Map<String, Object> map);

    PageInfo<SalesOrder> getAll(Integer pageNum, Integer pageSize);

}
