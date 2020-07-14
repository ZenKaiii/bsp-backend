package com.neusoft.bsp.MVO.mapper;

import com.neusoft.bsp.MVO.entity.PackageInfo;
import com.neusoft.bsp.common.base.BaseMapper;
import org.springframework.stereotype.Repository;

@Repository
public interface PackageInfoMapper extends BaseMapper<Integer, PackageInfo> {
    PackageInfo getByProId(int proId);
}
