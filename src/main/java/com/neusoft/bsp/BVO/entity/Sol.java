package com.neusoft.bsp.BVO.entity;

import lombok.Data;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.math.BigDecimal;

//原始订单明细 gun

@Data
@Entity
public class Sol {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer solId;
    private Integer stoId;
    private BigDecimal salesPrice;
    private Integer qty;
    private String skuNo;

}
