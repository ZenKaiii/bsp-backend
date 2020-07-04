package com.neusoft.bsp.MVO.service;

import com.github.pagehelper.PageInfo;
import com.neusoft.bsp.MVO.entity.SpecificAttribute;

import java.util.List;
import java.util.Map;

public interface SpecificAttributeService {

    int insert(SpecificAttribute specificAttribute);

    int update(SpecificAttribute specificAttribute);

    int delete(int specificAttributeid);

    SpecificAttribute getById(int specificAttributeid);

    List<SpecificAttribute> getAll();

    List<SpecificAttribute> getAllByFilter(Map<String, Object> map);

    PageInfo<SpecificAttribute> getAllByFilter(Integer pageNum, Integer pageSize);

    PageInfo<SpecificAttribute> getAllByFilter(Integer pageNum, Integer pageSize, Map<String, Object> map);
}
