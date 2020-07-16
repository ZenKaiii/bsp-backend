package com.neusoft.bsp.MVO.mapper;

import com.neusoft.bsp.BVO.entity.Str;
import com.neusoft.bsp.MVO.entity.SalesOrder;
import com.neusoft.bsp.common.base.BaseMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SalesOrderMapper extends BaseMapper<Integer, SalesOrder> {
    List<SalesOrder> getByUserId(int userID);
    SalesOrder getSaoByOrderNo(String orderNo);
}
