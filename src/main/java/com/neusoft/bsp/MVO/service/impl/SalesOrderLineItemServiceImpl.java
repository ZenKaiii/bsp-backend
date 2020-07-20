package com.neusoft.bsp.MVO.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.neusoft.bsp.MVO.entity.Product;
import com.neusoft.bsp.MVO.entity.SalesOrder;
import com.neusoft.bsp.MVO.entity.SalesOrderLineItem;
import com.neusoft.bsp.MVO.mapper.SalesOrderLineItemMapper;
import com.neusoft.bsp.MVO.service.SalesOrderLineItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service ("salesOrderLineItemService")
public class SalesOrderLineItemServiceImpl implements SalesOrderLineItemService {
    @Autowired
    SalesOrderLineItemMapper salesOrderLineItemMapper;

    @Override
    public int insert(SalesOrderLineItem salesOrderLineItem) {
       return salesOrderLineItemMapper.insert(salesOrderLineItem);
    }

    @Override
    public int update(SalesOrderLineItem salesOrderLineItem) {
       return salesOrderLineItemMapper.update(salesOrderLineItem);
    }

    @Override
    public int delete(int salesOrderLineItemid) {
        return salesOrderLineItemMapper.delete(salesOrderLineItemid);
    }

    @Override
    public List<SalesOrderLineItem> getByOrder(Map map) {
        return salesOrderLineItemMapper.getByOrder(map);
    }


    @Override
    public SalesOrderLineItem getSalBySku(Map map) {
        return salesOrderLineItemMapper.getSalBySku(map);
    }


    @Override
    public SalesOrderLineItem getById(int salesOrderLineItemid) {
        return salesOrderLineItemMapper.getById(salesOrderLineItemid);
    }

    @Override
    public List<SalesOrderLineItem> getBySaoId(int saoId) {
        return salesOrderLineItemMapper.getBySaoId(saoId);
    }

    @Override
    public List<SalesOrderLineItem> getByUserId(int userId) {
        return salesOrderLineItemMapper.getByUserId(userId);
    }


    @Override
    public List<SalesOrderLineItem> getAll() {
       return salesOrderLineItemMapper.getAll();
    }

    @Override
    public List<SalesOrderLineItem> getAllByFilter(Map<String, Object> map) {
       return salesOrderLineItemMapper.getAllByFilter(map);
    }

    @Override
    public PageInfo<SalesOrderLineItem> getAll(Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum,pageSize,true);
        List<SalesOrderLineItem> SalesOrderLineItems = salesOrderLineItemMapper.getAll();
        return new PageInfo<>(SalesOrderLineItems);
    }
}
