package com.neusoft.bsp.BVO.form;


import lombok.Data;

@Data
public class StoreForm {
    private String plataeformType; //1:Amazon 2:ebay
    private Integer dsrId;
    private String storeName;
}
