package com.neusoft.bsp.MVO.service;

import com.github.pagehelper.PageInfo;
import com.neusoft.bsp.BVO.entity.Str;
import com.neusoft.bsp.MVO.entity.Brand;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface BrandService {

    int insert(Brand brand);

    int update(Brand brand);

    int delete(int brandid);

    Brand getById(int brandid);

    Brand getByNameEn(String name_en);

    List<Brand> getAll();

    List<Brand> getAllByUserId(Map<String,Object> map);

    List<Brand> getAllByFilter(Map<String, Object> map);

    PageInfo<Brand> getAll(Integer pageNum, Integer pageSize);

    PageInfo<Brand> getAllByUserID(Integer pageNum, Integer pageSize, Map<String, Object> map);
}
