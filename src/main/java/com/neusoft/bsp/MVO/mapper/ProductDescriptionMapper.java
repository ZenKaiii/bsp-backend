package com.neusoft.bsp.MVO.mapper;

import com.neusoft.bsp.MVO.entity.ProductCategory;
import com.neusoft.bsp.MVO.entity.ProductDescription;
import com.neusoft.bsp.common.base.BaseMapper;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductDescriptionMapper extends BaseMapper<Integer, ProductDescription> {
    ProductDescription getByProId(int proId);
}
