package com.neusoft.bsp.MVO.mapper;

import com.neusoft.bsp.MVO.entity.Manufacturer;
import com.neusoft.bsp.common.base.BaseMapper;
import org.springframework.stereotype.Repository;

import java.util.Map;

@Repository
public interface ManufacturerMapper extends BaseMapper<Integer, Manufacturer> {
    int insert(Map map);

    Manufacturer selectByUserId(int userId);

    int getManIdByUserId(int userId);
}
