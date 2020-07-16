package com.neusoft.bsp.BVO.service.impl;

import com.neusoft.bsp.BVO.entity.Sal;
import com.neusoft.bsp.BVO.entity.Sao;
import com.neusoft.bsp.BVO.entity.Sto;
import com.neusoft.bsp.BVO.entity.Str;
import com.neusoft.bsp.BVO.exception.BvoException;
import com.neusoft.bsp.BVO.repository.*;
import com.neusoft.bsp.BVO.service.BvoWalletService;
import com.neusoft.bsp.BVO.service.OrderService;
import com.neusoft.bsp.BVO.vo.OrderVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class OrderServiceImpl implements OrderService {

    @Autowired
    StrRepository strRepository;
    @Autowired
    StoRepository stoRepository;
    @Autowired
    SaoRepository saoRepository;
    @Autowired
    SalRepository salRepository;
    @Autowired
    ProRepository proRepository;

    @Override
    public OrderVO getOrderVOBySalAndSao(Sal sal, Sao sao) {
        return new OrderVO(sao.getSaoId(),proRepository.getProByProId(sal.getProId()).getTitle(),sal.getPrice(),sal.getQty(),proRepository.getProByProId(sal.getProId()).getSkuCd(),sao.getOrderNo(),sal.getPrice().multiply(new BigDecimal(sal.getQty())),sal.getTrackingNo());
    }

    @Override
    public List<OrderVO> getAllOrderByDsrId(Integer dsrId) {
        List<Str> strs = strRepository.getStrByDsrId(dsrId);
        List<Sto> stos = new ArrayList<>();
        List<Sao> saos = new ArrayList<>();
        List<Sal> sals = new ArrayList<>();
        List<OrderVO> orderVOS = new ArrayList<>();

        for (Str str : strs) {
            stos.addAll(stoRepository.getStoByStrId(str.getStrId()));
        }
        for (Sto sto : stos) {
            saos.addAll(saoRepository.getSaoByStoId(sto.getStoId()));
        }
        for (Sao sao : saos) {
            sals.addAll(salRepository.getSalBySaoId(sao.getSaoId()));
        }

        for (Sal sal : sals) {
            orderVOS.add(getOrderVOBySalAndSao(sal,saoRepository.getSaoBySaoId(sal.getSaoId())));
        }

        return orderVOS;
    }

    @Override
    public List<OrderVO> getAllOrderByDsrIdAndStatus(Integer dsrId, String orderSts) {
        List<Str> strs = strRepository.getStrByDsrId(dsrId);
        List<Sto> stos = new ArrayList<>();
        List<Sao> saos = new ArrayList<>();
        List<Sal> sals = new ArrayList<>();
        List<OrderVO> orderVOS = new ArrayList<>();

        for (Str str : strs) {
            stos.addAll(stoRepository.getStoByStrId(str.getStrId()));
        }
        for (Sto sto : stos) {
            saos.addAll(saoRepository.getSaoByStoId(sto.getStoId()));
        }
        for (Sao sao : saos) {
            if (sao.getOrderSts().equals(orderSts)){
                sals.addAll(salRepository.getSalBySaoId(sao.getSaoId()));
            }
        }

        for (Sal sal : sals) {
            orderVOS.add(getOrderVOBySalAndSao(sal,saoRepository.getSaoBySaoId(sal.getSaoId())));
        }

        return orderVOS;
    }

    @Override
    public void payOrder(Integer saoId) {
        Sao sao = saoRepository.getSaoBySaoId(saoId);
        if (sao == null){
            throw new BvoException("订单不存在");
        }
        if (sao.getOrderSts().equals("1")){
            sao.setOrderSts("2");
            saoRepository.saveAndFlush(sao);
        }
        else {
            log.error("订单已支付");
        }
    }


}
