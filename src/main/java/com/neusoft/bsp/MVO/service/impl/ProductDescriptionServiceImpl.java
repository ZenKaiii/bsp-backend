package com.neusoft.bsp.MVO.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.neusoft.bsp.MVO.entity.ProductDescription;
import com.neusoft.bsp.MVO.mapper.ProductDescriptionMapper;
import com.neusoft.bsp.MVO.service.ProductDescriptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service ("productDescriptionService")
public class ProductDescriptionServiceImpl implements ProductDescriptionService {

    @Autowired
    ProductDescriptionMapper productDescriptionMapper;

    @Override
    public int insert(ProductDescription productDescription) {
       return productDescriptionMapper.insert(productDescription);
    }

    @Override
    public int update(ProductDescription productDescription) {
       return productDescriptionMapper.update(productDescription);
    }

    @Override
    public int delete(int productDescriptionid) {
        return 0;
    }

    @Override
    public ProductDescription getById(int productDescriptionid) {
        return null;
    }

    @Override
    public ProductDescription getByProId(int proId) {
        return productDescriptionMapper.getByProId(proId);
    }

    @Override
    public List<ProductDescription> getAll() {
       return productDescriptionMapper.getAll();
    }

    @Override
    public List<ProductDescription> getAllByFilter(Map<String, Object> map) {
       return productDescriptionMapper.getAllByFilter(map);
    }

    @Override
    public PageInfo<ProductDescription> getAllByFilter(Integer pageNum, Integer pageSize) {
       return this.getAllByFilter(pageNum,pageSize,new HashMap());
    }

    @Override
    public PageInfo<ProductDescription> getAllByFilter(Integer pageNum, Integer pageSize, Map<String, Object> map) {
       PageHelper.startPage(pageNum,pageSize,true);
       List<ProductDescription> ProductDescriptions = productDescriptionMapper.getAllByFilter(map);
       return new PageInfo<>(ProductDescriptions);
    }}
