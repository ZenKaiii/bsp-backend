package com.neusoft.bsp.MVO.mapper;

import com.neusoft.bsp.MVO.entity.ProductCategory;
import com.neusoft.bsp.common.base.BaseMapper;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductCategoryMapper extends BaseMapper<Integer, ProductCategory> {
    ProductCategory getByProId(int proId);

}
