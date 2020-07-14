package com.neusoft.bsp.MVO.mapper;

import com.neusoft.bsp.MVO.entity.Brand;
import com.neusoft.bsp.MVO.entity.SalesOrder;
import com.neusoft.bsp.common.base.BaseMapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface SalesOrderMapper extends BaseMapper<Integer, SalesOrder> {
    List<SalesOrder> getByUserId(int userID);
}
