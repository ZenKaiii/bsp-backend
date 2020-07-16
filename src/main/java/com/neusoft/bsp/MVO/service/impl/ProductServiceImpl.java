package com.neusoft.bsp.MVO.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.neusoft.bsp.MVO.entity.Product;
import com.neusoft.bsp.MVO.mapper.ProductMapper;
import com.neusoft.bsp.MVO.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service ("productService")
public class ProductServiceImpl implements ProductService {

    @Autowired
    ProductMapper productMapper;

    @Override
    public int insert(Product product) {
        return productMapper.insert(product);
    }

    @Override
    public int update(Product product) {
       return productMapper.update(product);
    }

    @Override
    public int delete(int productid) {
        return 0;
    }

    @Override
    public Product getById(int productid) {
        return null;
    }

    @Override
    public Product getBySku(String sku) {
        return productMapper.getBySku(sku);
    }

    @Override
    public List<Product> getAll() {
       return productMapper.getAll();
    }

    @Override
    public List<Product> getAllByFilter(Map<String, Object> map) {
       return productMapper.getAllByFilter(map);
    }

    @Override
    public PageInfo<Product> getAllByFilter(Integer pageNum, Integer pageSize) {
       return this.getAllByFilter(pageNum,pageSize,new HashMap());
    }

    @Override
    public PageInfo<Product> getAllByFilter(Integer pageNum, Integer pageSize, Map<String, Object> map) {
       PageHelper.startPage(pageNum,pageSize,true);
       List<Product> Products = productMapper.getAllByFilter(map);
       return new PageInfo<>(Products);
    }}
