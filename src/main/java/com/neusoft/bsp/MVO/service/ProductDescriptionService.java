package com.neusoft.bsp.MVO.service;

import com.github.pagehelper.PageInfo;
import com.neusoft.bsp.MVO.entity.ProductDescription;

import java.util.List;
import java.util.Map;

public interface ProductDescriptionService {

    int insert(ProductDescription productDescription);

    int update(ProductDescription productDescription);

    int delete(int productDescriptionid);

    ProductDescription getById(int productDescriptionid);

    List<ProductDescription> getAll();

    List<ProductDescription> getAllByFilter(Map<String, Object> map);

    PageInfo<ProductDescription> getAllByFilter(Integer pageNum, Integer pageSize);

    PageInfo<ProductDescription> getAllByFilter(Integer pageNum, Integer pageSize, Map<String, Object> map);
}
