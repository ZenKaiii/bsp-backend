package com.neusoft.bsp.BVO.vo;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
public class WalletVO {
    private String accountName;
    private BigDecimal availableMoney;
}
