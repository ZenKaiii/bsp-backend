package com.neusoft.bsp.BVO.entity;


import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.math.BigDecimal;

@Data
@Entity
public class Waf {
    @Id
    private Integer buyerId;
    private BigDecimal availableMoney;
}
