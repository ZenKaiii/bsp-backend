package com.neusoft.bsp.MVO.service;

import com.github.pagehelper.PageInfo;
import com.neusoft.bsp.MVO.entity.SpecificAttributeValue;

import java.util.List;
import java.util.Map;

public interface SpecificAttributeValueService {

    int insert(SpecificAttributeValue specificAttributeValue);

    int update(SpecificAttributeValue specificAttributeValue);

    int delete(int specificAttributeValueid);

    SpecificAttributeValue getById(int specificAttributeValueid);

    List<SpecificAttributeValue> getAll();

    List<SpecificAttributeValue> getAllByFilter(Map<String, Object> map);

    PageInfo<SpecificAttributeValue> getAllByFilter(Integer pageNum, Integer pageSize);

    PageInfo<SpecificAttributeValue> getAllByFilter(Integer pageNum, Integer pageSize, Map<String, Object> map);
}
