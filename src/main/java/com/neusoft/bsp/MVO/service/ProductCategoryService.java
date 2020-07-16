package com.neusoft.bsp.MVO.service;

import com.github.pagehelper.PageInfo;
import com.neusoft.bsp.MVO.entity.ProductCategory;

import java.util.List;
import java.util.Map;

public interface ProductCategoryService {

    int insert(ProductCategory productCategory);

    int update(ProductCategory productCategory);

    int delete(int productCategoryid);

    int getByProId(int proId);

    ProductCategory getPrcByProId(int proId);

    ProductCategory getById(int productCategoryid);

    List<ProductCategory> getAll();

    List<ProductCategory> getAllByFilter(Map<String, Object> map);

    PageInfo<ProductCategory> getAllByFilter(Integer pageNum, Integer pageSize);

    PageInfo<ProductCategory> getAllByFilter(Integer pageNum, Integer pageSize, Map<String, Object> map);
}
