package com.neusoft.bsp.BVO.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@Entity
public class Wit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer witId;
    private Integer dsrId;
    private Integer proId;
}
