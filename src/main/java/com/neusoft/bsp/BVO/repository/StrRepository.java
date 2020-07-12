package com.neusoft.bsp.BVO.repository;

import com.neusoft.bsp.BVO.entity.Str;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StrRepository extends JpaRepository<Str,Integer> {
    public List<Str> getStrByDsrId(Integer dsrId);
}
