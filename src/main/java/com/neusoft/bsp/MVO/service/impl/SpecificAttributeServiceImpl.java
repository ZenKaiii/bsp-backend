package com.neusoft.bsp.MVO.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.neusoft.bsp.MVO.entity.SpecificAttribute;
import com.neusoft.bsp.MVO.mapper.SpecificAttributeMapper;
import com.neusoft.bsp.MVO.service.SpecificAttributeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service ("specificAttributeService")
public class SpecificAttributeServiceImpl implements SpecificAttributeService {
    @Autowired
    SpecificAttributeMapper specificAttributeMapper;

    @Override
    public int insert(SpecificAttribute specificAttribute) {
       return specificAttributeMapper.insert(specificAttribute);
    }

    @Override
    public int update(SpecificAttribute specificAttribute) {
       return specificAttributeMapper.update(specificAttribute);
    }

    @Override
    public int delete(int specificAttributeid) {
        return 0;
    }

    @Override
    public SpecificAttribute getById(int specificAttributeid) {
        return null;
    }

    @Override
    public List<SpecificAttribute> getAll() {
       return specificAttributeMapper.getAll();
    }

    @Override
    public List<SpecificAttribute> getAllByFilter(Map<String, Object> map) {
       return specificAttributeMapper.getAllByFilter(map);
    }

    @Override
    public PageInfo<SpecificAttribute> getAllByFilter(Integer pageNum, Integer pageSize) {
       return this.getAllByFilter(pageNum,pageSize,new HashMap());
    }

    @Override
    public PageInfo<SpecificAttribute> getAllByFilter(Integer pageNum, Integer pageSize, Map<String, Object> map) {
       PageHelper.startPage(pageNum,pageSize,true);
       List<SpecificAttribute> SpecificAttributes = specificAttributeMapper.getAllByFilter(map);
       return new PageInfo<>(SpecificAttributes);
    }}
