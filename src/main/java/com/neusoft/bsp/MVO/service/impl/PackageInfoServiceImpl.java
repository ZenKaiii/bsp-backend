package com.neusoft.bsp.MVO.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.neusoft.bsp.MVO.entity.PackageInfo;
import com.neusoft.bsp.MVO.mapper.PackageInfoMapper;
import com.neusoft.bsp.MVO.service.PackageInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service ("packageInfoService")
public class PackageInfoServiceImpl implements PackageInfoService {
    @Autowired
    PackageInfoMapper packageInfoMapper;

    @Override
    public int insert(PackageInfo packageInfo) {
       return packageInfoMapper.insert(packageInfo);
    }

    @Override
    public int update(PackageInfo packageInfo) {
       return packageInfoMapper.update(packageInfo);
    }

    @Override
    public int delete(int packageInfoid) {
        return 0;
    }

    @Override
    public PackageInfo getById(int packageInfoid) {
        return null;
    }


    @Override
    public List<PackageInfo> getAll() {
       return packageInfoMapper.getAll();
    }

    @Override
    public List<PackageInfo> getAllByFilter(Map<String, Object> map) {
       return packageInfoMapper.getAllByFilter(map);
    }

    @Override
    public PageInfo<PackageInfo> getAllByFilter(Integer pageNum, Integer pageSize) {
       return this.getAllByFilter(pageNum,pageSize,new HashMap());
    }

    @Override
    public PageInfo<PackageInfo> getAllByFilter(Integer pageNum, Integer pageSize, Map<String, Object> map) {
       PageHelper.startPage(pageNum,pageSize,true);
       List<PackageInfo> PackageInfos = packageInfoMapper.getAllByFilter(map);
       return new PageInfo<>(PackageInfos);
    }}
