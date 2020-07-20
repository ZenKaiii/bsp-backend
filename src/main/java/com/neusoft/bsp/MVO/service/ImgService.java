package com.neusoft.bsp.MVO.service;

import com.github.pagehelper.PageInfo;
import com.neusoft.bsp.MVO.entity.Img;

import java.util.List;
import java.util.Map;

public interface ImgService {

    int insert(Img img);

    int update(Img img);

    int delete(int imgid);

    Img getById(int imgid);

    int getByProId(int proId);

    String getUrlByProId(int proId);

    String getUrlByBrdId(int brdId);

    Img getImgByBrdId(int brdId);

    int deleteByBrdId(int brdId);

    Img getImgByProId(int proId);

    List<Img> getAll();

    List<Img> getAllByFilter(Map<String, Object> map);

    PageInfo<Img> getAllByFilter(Integer pageNum, Integer pageSize);

    PageInfo<Img> getAllByFilter(Integer pageNum, Integer pageSize, Map<String, Object> map);

}
