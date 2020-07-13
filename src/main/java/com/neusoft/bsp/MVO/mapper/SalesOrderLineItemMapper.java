package com.neusoft.bsp.MVO.mapper;

import com.neusoft.bsp.MVO.entity.SalesOrder;
import com.neusoft.bsp.MVO.entity.SalesOrderLineItem;
import com.neusoft.bsp.common.base.BaseMapper;
import org.springframework.stereotype.Repository;

@Repository
public interface SalesOrderLineItemMapper extends BaseMapper<Integer, SalesOrderLineItem> {
}
