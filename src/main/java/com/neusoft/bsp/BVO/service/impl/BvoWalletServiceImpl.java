package com.neusoft.bsp.BVO.service.impl;

import com.neusoft.bsp.BVO.entity.Waa;
import com.neusoft.bsp.BVO.entity.Waf;
import com.neusoft.bsp.BVO.repository.WaaRepository;
import com.neusoft.bsp.BVO.repository.WafRepository;
import com.neusoft.bsp.BVO.service.BvoWalletService;
import com.neusoft.bsp.BVO.vo.WalletVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
@Slf4j
public class BvoWalletServiceImpl implements BvoWalletService {

    @Autowired
    WaaRepository waaRepository;
    @Autowired
    WafRepository wafRepository;

    @Override
    public WalletVO getWalletVOByBuyerId(Integer buyerId) {
        Waa waa = waaRepository.getWaaByBuyerId(buyerId);
        Waf waf = wafRepository.getWafByBuyerId(buyerId);
        return new WalletVO(waa.getAccountName(),waf.getAvailableMoney());
    }

    @Override
    public void deposit(Integer buyerId, BigDecimal despositAmount) {
        Waf waf = wafRepository.getWafByBuyerId(buyerId);
        waf.setAvailableMoney(waf.getAvailableMoney().add(despositAmount));
        wafRepository.saveAndFlush(waf);
    }

    @Override
    public Boolean pay(Integer buyerId, BigDecimal payAmount) {
        Waf waf = wafRepository.getWafByBuyerId(buyerId);
        if (waf.getAvailableMoney().compareTo(payAmount) < 0){
            log.error("余额不足");
            return false;
        }else{
            waf.setAvailableMoney(waf.getAvailableMoney().subtract(payAmount));
            wafRepository.saveAndFlush(waf);
            return true;
        }
    }
}
