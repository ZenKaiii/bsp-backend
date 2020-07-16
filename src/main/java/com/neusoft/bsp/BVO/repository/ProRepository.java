package com.neusoft.bsp.BVO.repository;

import com.neusoft.bsp.BVO.entity.Pro;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProRepository extends JpaRepository<Pro,Integer> {
    public Pro getProByProId(Integer proId);
}
