package com.neusoft.bsp.BVO.service;

import com.neusoft.bsp.BVO.entity.Dsr;
import com.neusoft.bsp.BVO.entity.Str;
import com.neusoft.bsp.BVO.form.StoreForm;
import com.neusoft.bsp.BVO.vo.BvoUserVO;

import java.util.List;

public interface InfoService {
    public BvoUserVO findUserVo(int userId);
    public void updateUserInfo(int id, BvoUserVO bvoUserVO);
    public List<Str> getStoresByDsrId(Integer id);
    public void addStore(StoreForm storeForm);
    public Dsr getDsr();
}
