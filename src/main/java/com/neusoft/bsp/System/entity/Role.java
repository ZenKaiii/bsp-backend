package com.neusoft.bsp.System.entity;

import com.neusoft.bsp.common.base.BaseEntity;

public class Role implements BaseEntity<Integer> {

    int role_id;
    String role_name;
    String role_description;

    @Override
    public Integer getId() {
        return this.role_id;
    }

    public int getRole_id() {
        return role_id;
    }

    public void setRole_id(int role_id) {
        this.role_id = role_id;
    }

    public String getRole_name() {
        return role_name;
    }

    public void setRole_name(String role_name) {
        this.role_name = role_name;
    }

    public String getRole_description() {
        return role_description;
    }

    public void setRole_description(String role_description) {
        this.role_description = role_description;
    }

    @Override
    public String toString() {
        return "Role{" +
                "role_id=" + role_id +
                ", role_name='" + role_name + '\'' +
                ", role_description='" + role_description + '\'' +
                '}';
    }
}
