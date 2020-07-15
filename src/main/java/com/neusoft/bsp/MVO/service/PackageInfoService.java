package com.neusoft.bsp.MVO.service;

import com.github.pagehelper.PageInfo;
import com.neusoft.bsp.MVO.entity.PackageInfo;

import java.util.List;
import java.util.Map;

public interface PackageInfoService {

    int insert(PackageInfo packageInfo);

    int update(PackageInfo packageInfo);

    int delete(int packageInfoid);

    PackageInfo getByProId(int proId);

    PackageInfo getById(int packageInfoid);

    List<PackageInfo> getAll();

    List<PackageInfo> getAllByFilter(Map<String, Object> map);

    PageInfo<PackageInfo> getAllByFilter(Integer pageNum, Integer pageSize);

    PageInfo<PackageInfo> getAllByFilter(Integer pageNum, Integer pageSize, Map<String, Object> map);
}
