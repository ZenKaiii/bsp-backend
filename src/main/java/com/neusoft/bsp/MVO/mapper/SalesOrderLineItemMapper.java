package com.neusoft.bsp.MVO.mapper;

import com.neusoft.bsp.MVO.entity.Product;
import com.neusoft.bsp.MVO.entity.SalesOrder;
import com.neusoft.bsp.MVO.entity.SalesOrderLineItem;
import com.neusoft.bsp.common.base.BaseMapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface SalesOrderLineItemMapper extends BaseMapper<Integer, SalesOrderLineItem> {
    List<SalesOrderLineItem> getBySaoId(int saoId);

    List<SalesOrderLineItem> getByUserId(int userId);

    SalesOrderLineItem getSalBySku(Map map);
}
