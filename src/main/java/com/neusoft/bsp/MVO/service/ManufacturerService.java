package com.neusoft.bsp.MVO.service;

import com.github.pagehelper.PageInfo;
import com.neusoft.bsp.MVO.entity.Manufacturer;

import java.util.List;
import java.util.Map;

public interface ManufacturerService {

    int insert(Manufacturer manufacturer);

    int update(Manufacturer manufacturer);

    int delete(int manufacturerid);

    Manufacturer getById(int manufacturerid);

    List<Manufacturer> getAll();

    List<Manufacturer> getAllByFilter(Map<String, Object> map);

    PageInfo<Manufacturer> getAllByFilter(Integer pageNum, Integer pageSize);

    PageInfo<Manufacturer> getAllByFilter(Integer pageNum, Integer pageSize, Map<String, Object> map);
}
