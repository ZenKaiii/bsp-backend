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
   public int delete(String brandid) {
       return brandMapper.delete(brandid);
   }

   @Override
   public Brand getById(String brandid) {
       return brandMapper.getById(brandid);
   }

   @Override
   public List<Brand> getAll() {
       return brandMapper.getAll();
   }

   @Override
   public List<Brand> getAllByFilter(Map<String, Object> map) {
       return brandMapper.getAllByFilter(map);
   }

   @Override
   public PageInfo<Brand> getAllByFilter(Integer pageNum, Integer pageSize) {
       return this.getAllByFilter(pageNum,pageSize,new HashMap());
   }

   @Override
   public PageInfo<Brand> getAllByFilter(Integer pageNum, Integer pageSize, Map<String, Object> map) {
       PageHelper.startPage(pageNum,pageSize,true);
       List<Brand> Brands = brandMapper.getAllByFilter(map);
       return new PageInfo<>(Brands);
   }}
