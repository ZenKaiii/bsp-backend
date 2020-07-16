package com.neusoft.bsp.BVO.repository;

import com.neusoft.bsp.BVO.entity.Sto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StoRepository extends JpaRepository<Sto,Integer> {
    public List<Sto> getStoByStrId(Integer strId);
}
