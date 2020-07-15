package com.neusoft.bsp.System.mapper;

import com.neusoft.bsp.System.entity.Code;
import com.neusoft.bsp.common.base.BaseMapper;
import org.springframework.stereotype.Repository;

@Repository
public interface CodeMapper extends BaseMapper<Integer, Code> {

    Code getById(int id);
    Code getByCode(String type_cd);
}
