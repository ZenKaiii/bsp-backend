package com.neusoft.bsp.BVO.vo;


import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
public class OrderVO {
    private Integer saoId;
    private Integer proId;
    private String title;
    private BigDecimal price;
    private Integer qty;
    private String  sku;
    private String orderNo;
    private BigDecimal total;
    private String trackingNo;
}
