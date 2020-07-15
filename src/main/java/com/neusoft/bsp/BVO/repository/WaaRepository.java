package com.neusoft.bsp.BVO.repository;

import com.neusoft.bsp.BVO.entity.Waa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WaaRepository extends JpaRepository<Waa,Integer> {
    public Waa getWaaByBuyerId(Integer buyerId);
}
