package com.neusoft.bsp.BVO.repository;

import com.neusoft.bsp.BVO.entity.Waf;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WafRepository extends JpaRepository<Waf,Integer> {
    public Waf getWafByBuyerId(Integer buyerId);
}
