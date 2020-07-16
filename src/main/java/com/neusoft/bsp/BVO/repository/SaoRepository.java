package com.neusoft.bsp.BVO.repository;

import com.neusoft.bsp.BVO.entity.Sao;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SaoRepository extends JpaRepository<Sao,Integer> {
    public Sao getSaoBySaoId(Integer saoId);
    public List<Sao> getSaoByStoId(Integer stoId);
//    public List<>
}
