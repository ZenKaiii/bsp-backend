package com.neusoft.bsp.BVO.entity;


import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.math.BigDecimal;

@Data
@Entity
public class Sal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer salId;
    private Integer saoId;
    private Integer proId;
    private Integer qty;
    private BigDecimal price;
//    private Integer skuNo;
//    private Integer solId;
    private String trackingNo;
    private String wspName;
}
