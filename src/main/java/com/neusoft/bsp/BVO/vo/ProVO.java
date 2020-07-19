package com.neusoft.bsp.BVO.vo;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
public class ProVO {
    private Integer proId;
    private String name;
    private BigDecimal price;
    private String sku;
    private String brand;
    private Integer stock;
    private String description;
    private String imgPath;
}
