package com.neusoft.bsp.BVO.service;

import com.neusoft.bsp.BVO.entity.Pro;
import com.neusoft.bsp.BVO.entity.Wit;
import com.neusoft.bsp.BVO.vo.ProVO;
import com.neusoft.bsp.MVO.entity.Product;

import java.util.List;

public interface ProService {
    public List<ProVO> findAllProduct();
    public List<Wit> findAllWitByDsrId(Integer dsrId);
    public List<Pro> findProductByWit(Integer dsrId);
    public void deleteWitById(Integer witId);
}
