package com.neusoft.bsp.BVO.service;

import com.neusoft.bsp.BVO.vo.WalletVO;

import java.math.BigDecimal;

public interface BvoWalletService {
    public WalletVO getWalletVOByBuyerId(Integer buyerId);
    public void deposit(Integer buyerId, BigDecimal depositAmount);
    public Boolean pay(Integer buyerId, BigDecimal payAmount);
}

