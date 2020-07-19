package com.neusoft.bsp.BVO.repository;


import com.neusoft.bsp.BVO.entity.Pdn;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PdnRepository extends JpaRepository<Pdn,Integer> {
    public Pdn getPdnByProId(Integer proId);
}
