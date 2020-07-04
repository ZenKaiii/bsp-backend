package com.neusoft.bsp.MVO.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.neusoft.bsp.MVO.entity.SpecificAttributeValue;
import com.neusoft.bsp.MVO.mapper.SpecificAttributeValueMapper;
import com.neusoft.bsp.MVO.service.SpecificAttributeValueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service ("specificAttributeValueService")
public class SpecificAttributeValueServiceImpl implements SpecificAttributeValueService {
    @Autowired
    SpecificAttributeValueMapper specificAttributeValueMapper;

    @Override
    public int insert(SpecificAttributeValue specificAttributeValue) {
       return specificAttributeValueMapper.insert(specificAttributeValue);
    }

    @Override
    public int update(SpecificAttributeValue specificAttributeValue) {
       return specificAttributeValueMapper.update(specificAttributeValue);
    }

    @Override
    public int delete(int specificAttributeValueid) {
        return 0;
    }

    @Override
    public SpecificAttributeValue getById(int specificAttributeValueid) {
        return null;
    }

    @Override
    public List<SpecificAttributeValue> getAll() {
       return specificAttributeValueMapper.getAll();
    }

    @Override
    public List<SpecificAttributeValue> getAllByFilter(Map<String, Object> map) {
       return specificAttributeValueMapper.getAllByFilter(map);
    }

    @Override
    public PageInfo<SpecificAttributeValue> getAllByFilter(Integer pageNum, Integer pageSize) {
       return this.getAllByFilter(pageNum,pageSize,new HashMap());
    }

    @Override
    public PageInfo<SpecificAttributeValue> getAllByFilter(Integer pageNum, Integer pageSize, Map<String, Object> map) {
       PageHelper.startPage(pageNum,pageSize,true);
       List<SpecificAttributeValue> SpecificAttributeValues = specificAttributeValueMapper.getAllByFilter(map);
       return new PageInfo<>(SpecificAttributeValues);
    }}
