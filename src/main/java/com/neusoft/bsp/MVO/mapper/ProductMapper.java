package com.neusoft.bsp.MVO.mapper;

import com.neusoft.bsp.MVO.entity.Product;
import com.neusoft.bsp.common.base.BaseMapper;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductMapper extends BaseMapper<String, Product> {
    Product getBySku(String sku);
}
