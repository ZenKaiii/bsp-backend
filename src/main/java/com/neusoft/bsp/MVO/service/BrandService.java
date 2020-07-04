package com.neusoft.bsp.MVO.service;

import com.github.pagehelper.PageInfo;
import com.neusoft.bsp.MVO.entity.Brand;

import java.util.List;
import java.util.Map;

public interface BrandService {

    int insert(Brand brand);

    int update(Brand brand);

    int delete(int brandid);

    Brand getById(int brandid);

    List<Brand> getAll();

    List<Brand> getAllByFilter(Map<String, Object> map);

    PageInfo<Brand> getAllByFilter(Integer pageNum, Integer pageSize);

    PageInfo<Brand> getAllByFilter(Integer pageNum, Integer pageSize, Map<String, Object> map);
}
