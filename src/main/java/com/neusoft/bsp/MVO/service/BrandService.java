package com.neusoft.bsp.MVO.service;

import com.github.pagehelper.PageInfo;
import com.neusoft.bsp.MVO.entity.Brand;
import com.neusoft.bsp.MVO.vo.BrandVo;

import java.util.List;
import java.util.Map;

public interface BrandService {

    int alterBrand(BrandVo brandVo, int userId);

    List<BrandVo> brandList(int userId);

    int deleteBrand(BrandVo brandVo, int userId);

    int insert(Brand brand);

    int update(Brand brand);

    int delete(int brandid);

    Brand getById(int brandid);

    Brand getByNameEn(Map map);

    List<Brand> getAll();

    List<Brand> getAllByUserId(Map<String,Object> map);

    List<Brand> getAllByFilter(Map<String, Object> map);

    PageInfo<Brand> getAll(Integer pageNum, Integer pageSize);

    PageInfo<Brand> getAllByUserID(Integer pageNum, Integer pageSize, Map<String, Object> map);
}
