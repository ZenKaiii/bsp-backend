package com.neusoft.bsp.BVO.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Data
@Entity
public class Dsr {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer dsrId;
    private String name;
    private Date registerDate;
}
