package com.neusoft.bsp.BVO.service;

import com.neusoft.bsp.BVO.entity.Sal;
import com.neusoft.bsp.BVO.entity.Sao;
import com.neusoft.bsp.BVO.vo.OrderVO;

import java.util.List;

public interface OrderService {
    public OrderVO getOrderVOBySalAndSao(Sal sal,Sao sao);

    public List<OrderVO> getAllOrderByDsrId(Integer dsrId);

    public List<OrderVO> getAllOrderByDsrIdAndStatus(Integer dsrId, String orderSts);
}
