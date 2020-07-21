package com.neusoft.bsp.BVO.repository;

import com.neusoft.bsp.BVO.entity.Wit;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface WitRepository extends JpaRepository<Wit,Integer> {
    public Wit findWitByWitId(Integer witId);
    public List<Wit> findAllWitByDsrId(Integer dsrId);
    public List<Wit> findWitByProId(Integer proId);
    public void removeByWitId(Integer witId);
}
