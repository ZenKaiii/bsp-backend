package com.neusoft.bsp.BVO.repository;

import com.neusoft.bsp.BVO.entity.Sal;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SalRepository extends JpaRepository<Sal,Integer> {
    public List<Sal> getSalBySaoId(Integer saoId);
}
