package com.neusoft.bsp.System.entity;

import com.neusoft.bsp.common.base.BaseEntity;

import java.io.Serializable;

public class Menu implements BaseEntity {

    int menu_id;
    String menu_name;
    String menu_index;



    @Override
    public Serializable getId() {
        return null;
    }
}
