package com.neusoft.bsp.MVO.service;

import com.github.pagehelper.PageInfo;
import com.neusoft.bsp.MVO.entity.Product;

import java.util.List;
import java.util.Map;

public interface ProductService {

    int insert(Product product);

    int update(Product product);

    int delete(int productid);

    Product getById(int productid);

    List<Product> getAll();

    List<Product> getAllByFilter(Map<String, Object> map);

    PageInfo<Product> getAllByFilter(Integer pageNum, Integer pageSize);

    PageInfo<Product> getAllByFilter(Integer pageNum, Integer pageSize, Map<String, Object> map);
}
