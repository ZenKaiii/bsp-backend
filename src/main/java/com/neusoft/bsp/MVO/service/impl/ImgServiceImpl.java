package com.neusoft.bsp.MVO.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.neusoft.bsp.MVO.entity.Img;
import com.neusoft.bsp.MVO.mapper.ImgMapper;
import com.neusoft.bsp.MVO.service.ImgService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service ("imgService")
public class ImgServiceImpl implements ImgService {
    @Autowired
    ImgMapper imgMapper;

    @Override
    public int insert(Img img) {
       return imgMapper.insert(img);
    }

    @Override
    public int update(Img img) {
       return imgMapper.update(img);
    }

    @Override
    public int delete(int imgid) {
        return imgMapper.delete(imgid);
    }

    @Override
    public Img getById(int imgid) {
        return imgMapper.getById(imgid);
    }

    @Override
    public int getByProId(int proId) {
        return imgMapper.getByProId(proId);
    }

    @Override
    public Img getImgByProId(int proId) {
        return imgMapper.getImgByProId(proId);
    }


    @Override
    public List<Img> getAll() {
       return imgMapper.getAll();
    }

    @Override
    public List<Img> getAllByFilter(Map<String, Object> map) {
       return imgMapper.getAllByFilter(map);
    }

    @Override
    public PageInfo<Img> getAllByFilter(Integer pageNum, Integer pageSize) {
       return this.getAllByFilter(pageNum,pageSize,new HashMap());
    }

    @Override
    public PageInfo<Img> getAllByFilter(Integer pageNum, Integer pageSize, Map<String, Object> map) {
       PageHelper.startPage(pageNum,pageSize,true);
       List<Img> Imgs = imgMapper.getAllByFilter(map);
       return new PageInfo<>(Imgs);
    }}
