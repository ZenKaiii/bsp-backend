package com.neusoft.bsp.BVO.repository;

import com.neusoft.bsp.BVO.entity.Brd;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BrdRepository extends JpaRepository<Brd,Integer> {
    public Brd getBrdByBrdId(Integer brdId);
}
