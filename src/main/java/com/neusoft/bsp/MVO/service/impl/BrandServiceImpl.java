package com.neusoft.bsp.MVO.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.neusoft.bsp.MVO.entity.Brand;
import com.neusoft.bsp.MVO.mapper.BrandMapper;
import com.neusoft.bsp.MVO.service.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service ("brandService")
public class BrandServiceImpl implements BrandService {
    @Autowired
    BrandMapper brandMapper;

    @Override
    public int insert(Brand brand) {
       return brandMapper.insert(brand);
    }

    @Override
    public int update(Brand brand) {
       return brandMapper.update(brand);
    }

    @Override
    public int delete(int brandid) {
        return brandMapper.delete(brandid);
    }

    @Override
    public Brand getById(int brandid) {
        return brandMapper.getById(brandid);
    }



    @Override
    public List<Brand> getAll() {
       return brandMapper.getAll();
    }

    @Override
    public List<Brand> getAllByUserId(Map<String, Object> map) {
        return brandMapper.getAllByUserId(map);
    }

    @Override
    public List<Brand> getAllByFilter(Map<String, Object> map) {
       return brandMapper.getAllByFilter(map);
    }

    @Override
    public PageInfo<Brand> getAll(Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum,pageSize,true);
        List<Brand> Brands = brandMapper.getAll();
        return new PageInfo<>(Brands);
    }

    @Override
    public PageInfo<Brand> getAllByUserID(Integer pageNum, Integer pageSize, Map<String, Object> map) {
       PageHelper.startPage(pageNum,pageSize,true);
       List<Brand> Brands = brandMapper.getAllByUserId(map);
       return new PageInfo<>(Brands);
    }}
