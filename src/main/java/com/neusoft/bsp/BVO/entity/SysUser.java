package com.neusoft.bsp.BVO.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@Entity
public class SysUser {
    @Id
    private Integer userId;
    private String name;
    private String email;
    private String phone;
    private Integer manBuyerId;
}
