package com.neusoft.bsp.BVO.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@Entity
public class Brd {
    @Id
    private Integer brdId;
    private String nameCn;
}
