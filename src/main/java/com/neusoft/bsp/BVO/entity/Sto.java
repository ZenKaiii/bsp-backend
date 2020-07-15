package com.neusoft.bsp.BVO.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

// 原始订单

@Data
@Entity
public class Sto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer stoId;
    private Integer strId;
    private String orderId;
    private String plateformType;
}
