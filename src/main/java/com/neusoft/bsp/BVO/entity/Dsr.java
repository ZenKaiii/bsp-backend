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
    private Integer dsr_id;
    private String name;
    private Date register_date;
}
