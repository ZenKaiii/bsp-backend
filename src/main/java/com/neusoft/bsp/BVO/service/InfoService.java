package com.neusoft.bsp.BVO.service;

import com.neusoft.bsp.BVO.vo.BvoUserVO;

public interface InfoService {
    public BvoUserVO findUserVo(String userId);
    public void updateUserInfo(String id, BvoUserVO bvoUserVO);
}
