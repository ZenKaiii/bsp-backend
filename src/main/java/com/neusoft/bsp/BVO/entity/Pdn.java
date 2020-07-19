package com.neusoft.bsp.BVO.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@Entity
public class Pdn {
    @Id
    private Integer pdnId;
    private Integer proId;
    private String description;
}
