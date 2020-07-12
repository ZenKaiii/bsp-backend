package com.neusoft.bsp.BVO.service;

import com.neusoft.bsp.BVO.entity.Str;
import com.neusoft.bsp.BVO.vo.BvoUserVO;

import java.util.List;

public interface InfoService {
    public BvoUserVO findUserVo(String userId);
    public void updateUserInfo(String id, BvoUserVO bvoUserVO);
    public List<Str> getStoresByDsrId(Integer id);
    public void addStore();
}
