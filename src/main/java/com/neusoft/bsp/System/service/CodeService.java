package com.neusoft.bsp.System.service;

import com.github.pagehelper.PageInfo;
import com.neusoft.bsp.System.entity.Code;

import java.util.List;
import java.util.Map;

public interface CodeService {

    int insert(Code code);

    int update(Code code);

    int delete(String codeid);

    Code getById(String codeid);

    List<Code> getAll();

    List<Code> getAllByFilter(Map<String,Object> map);

    PageInfo<Code> getAllByFilter(Integer pageNum,Integer pageSize);

    PageInfo<Code> getAllByFilter(Integer pageNum,Integer pageSize,Map<String,Object> map);
}
