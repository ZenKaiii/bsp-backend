package com.neusoft.bsp.BVO.vo;


import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
public class OrderVO {
    private String title;
    private BigDecimal price;
    private Integer qty;
    private Integer sku;
    private String orderNo;
    private BigDecimal total;
    private String trackingNo;
}
