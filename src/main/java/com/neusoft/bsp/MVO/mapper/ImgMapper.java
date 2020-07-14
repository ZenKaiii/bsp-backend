package com.neusoft.bsp.MVO.mapper;

import com.neusoft.bsp.MVO.entity.Img;
import com.neusoft.bsp.common.base.BaseMapper;
import org.springframework.stereotype.Repository;

@Repository
public interface ImgMapper extends BaseMapper<Integer, Img> {
    Img getByProId(int proId);
}
