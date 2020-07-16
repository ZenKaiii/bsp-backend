package com.neusoft.bsp.BVO.entity;


import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@Entity
public class Sao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer saoId;
    private String orderNo;
    private String orderSts;
//    private String refund
    private Integer stoId;
}
