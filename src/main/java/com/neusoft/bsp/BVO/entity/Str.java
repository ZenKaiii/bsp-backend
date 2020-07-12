package com.neusoft.bsp.BVO.entity;


import lombok.Data;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@Entity
@DynamicInsert
@DynamicUpdate
public class Str {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer strId;
    private Integer dsrId;
    private String plataeformType; //1:Amazon 2:ebay
    private String storeName;

}
