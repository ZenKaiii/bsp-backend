package com.neusoft.bsp.MVO.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.neusoft.bsp.MVO.entity.ProductCategory;
import com.neusoft.bsp.MVO.mapper.ProductCategoryMapper;
import com.neusoft.bsp.MVO.service.ProductCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service ("productCategoryService")
public class ProductCategoryServiceImpl implements ProductCategoryService {

    @Autowired
    ProductCategoryMapper productCategoryMapper;

    @Override
    public int insert(ProductCategory productCategory) {
       return productCategoryMapper.insert(productCategory);
    }

    @Override
    public int update(ProductCategory productCategory) {
       return productCategoryMapper.update(productCategory);
    }

    @Override
    public int delete(int productCategoryid) {
        return 0;
    }

    @Override
    public int getByProId(int proId) {
        return productCategoryMapper.getByProId(proId);
    }

    @Override
    public ProductCategory getPrcByProId(int proId) {
        return productCategoryMapper.getPrcByProId(proId);
    }

    @Override
    public ProductCategory getById(int productCategoryid) {
        return null;
    }

    @Override
    public List<ProductCategory> getAll() {
       return productCategoryMapper.getAll();
    }

    @Override
    public List<ProductCategory> getAllByFilter(Map<String, Object> map) {
       return productCategoryMapper.getAllByFilter(map);
    }

    @Override
    public PageInfo<ProductCategory> getAllByFilter(Integer pageNum, Integer pageSize) {
       return this.getAllByFilter(pageNum,pageSize,new HashMap());
    }

    @Override
    public PageInfo<ProductCategory> getAllByFilter(Integer pageNum, Integer pageSize, Map<String, Object> map) {
       PageHelper.startPage(pageNum,pageSize,true);
       List<ProductCategory> ProductCategorys = productCategoryMapper.getAllByFilter(map);
       return new PageInfo<>(ProductCategorys);
    }}
