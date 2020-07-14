package com.neusoft.bsp.System.service;

import com.github.pagehelper.PageInfo;
import com.neusoft.bsp.System.entity.Code;

import java.util.List;
import java.util.Map;

public interface CodeService {

    int insert(Code code);

    int update(Code code);

    int delete(int cdm_id);

    Code getById(int cdm_id);

    Code getByCode(String type_cd);

    List<Code> getAll();

    List<Code> getAllByFilter(Map<String, Object> map);
}


