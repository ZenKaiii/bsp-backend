package com.neusoft.bsp.MVO.mapper;

import com.neusoft.bsp.MVO.entity.Product;
import com.neusoft.bsp.common.base.BaseMapper;
import org.springframework.stereotype.Repository;

import java.util.Map;

@Repository
public interface ProductMapper extends BaseMapper<Integer, Product>{
    Product getBySku(String sku);

    Product getByTitle(Map<String,Object> map);
}
