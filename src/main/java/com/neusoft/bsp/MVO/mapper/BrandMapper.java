package com.neusoft.bsp.MVO.mapper;

import com.neusoft.bsp.MVO.entity.Brand;
import com.neusoft.bsp.common.base.BaseMapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface BrandMapper extends BaseMapper<Integer, Brand> {
    List<Brand> getAllByUserId(Map<String,Object> map);
    Brand getByBrandNameEn(String name_en);

}
