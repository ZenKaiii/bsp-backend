package com.neusoft.bsp.MVO.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.neusoft.bsp.MVO.entity.SalesOrder;
import com.neusoft.bsp.MVO.mapper.SalesOrderMapper;
import com.neusoft.bsp.MVO.service.SalesOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service ("salesOrderService")
public class SalesOrderServiceImpl implements SalesOrderService {
    @Autowired
    SalesOrderMapper salesOrderMapper;

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
