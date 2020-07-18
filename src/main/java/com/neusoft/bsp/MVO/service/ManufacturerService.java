package com.neusoft.bsp.MVO.service;

import com.github.pagehelper.PageInfo;
import com.neusoft.bsp.MVO.entity.Manufacturer;
import com.neusoft.bsp.MVO.vo.ManufacturerVo;

import java.util.List;
import java.util.Map;

public interface ManufacturerService {

    int alterManufacturer(ManufacturerVo manufacturerVo,int userId);

    int insert(Map<String, Object> map);

    int update(Manufacturer manufacturer);

    int delete(int manufacturerid);

    Manufacturer selectByUserId(int userId);

    int getManIdByUserId(int userId);

    List<Manufacturer> getAll();

    List<Manufacturer> getAllByFilter(Map<String, Object> map);

    PageInfo<Manufacturer> getAllByFilter(Integer pageNum, Integer pageSize);

    PageInfo<Manufacturer> getAllByFilter(Integer pageNum, Integer pageSize, Map<String, Object> map);
}
