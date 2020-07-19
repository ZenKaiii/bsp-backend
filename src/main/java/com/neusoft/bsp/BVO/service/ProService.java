package com.neusoft.bsp.BVO.service;

import com.neusoft.bsp.BVO.entity.Pro;
import com.neusoft.bsp.BVO.entity.Wit;
import com.neusoft.bsp.BVO.vo.ProVO;
import com.neusoft.bsp.MVO.entity.Product;

import java.util.List;

public interface ProService {
    public ProVO findProVOById(Integer proId);
    public List<ProVO> findAllProduct();
    public List<Wit> findAllWitByUserId(Integer userId);
    public List<ProVO> findProductByWit(Integer userId);
    public void addWitbyDsrIdAndProId(Integer dsrId,Integer proId);
    public void deleteWitById(Integer witId);
}
