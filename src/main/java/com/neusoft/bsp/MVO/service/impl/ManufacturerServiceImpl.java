package com.neusoft.bsp.MVO.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.neusoft.bsp.MVO.entity.Manufacturer;
import com.neusoft.bsp.MVO.mapper.ManufacturerMapper;
import com.neusoft.bsp.MVO.service.ManufacturerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service ("manufacturerService")
public class ManufacturerServiceImpl implements ManufacturerService {
    @Autowired
    ManufacturerMapper manufacturerMapper;

    @Override
    public int insert(Map<String, Object> map) {
        return manufacturerMapper.insert(map);
    }

    @Override
    public int update(Manufacturer manufacturer) {
       return manufacturerMapper.update(manufacturer);
    }

    @Override
    public int delete(int manufacturerid) {
        return 0;
    }

    @Override
    public Manufacturer selectByUserId(int userId) {
        return manufacturerMapper.selectByUserId(userId);
    }

    @Override
    public int getManIdByUserId(int userId) {
        return manufacturerMapper.getManIdByUserId(userId);
    }

    @Override
    public List<Manufacturer> getAll() {
       return manufacturerMapper.getAll();
    }

    @Override
    public List<Manufacturer> getAllByFilter(Map<String, Object> map) {
       return manufacturerMapper.getAllByFilter(map);
    }

    @Override
    public PageInfo<Manufacturer> getAllByFilter(Integer pageNum, Integer pageSize) {
       return this.getAllByFilter(pageNum,pageSize,new HashMap());
    }

    @Override
    public PageInfo<Manufacturer> getAllByFilter(Integer pageNum, Integer pageSize, Map<String, Object> map) {
       PageHelper.startPage(pageNum,pageSize,true);
       List<Manufacturer> Manufacturers = manufacturerMapper.getAllByFilter(map);
       return new PageInfo<>(Manufacturers);
    }}
