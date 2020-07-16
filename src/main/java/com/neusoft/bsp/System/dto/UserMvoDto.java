package com.neusoft.bsp.System.dto;

import com.neusoft.bsp.common.validationGroup.InsertGroup;
import com.neusoft.bsp.common.validationGroup.UpdateGroup;

import javax.validation.constraints.NotNull;

public class UserMvoDto {
    String username;
    String password;
    String name;
    String rights;
    String bz;
    String skin;
    String email;
    String number;
    String phone;
    String name_en;
    String name_cn;
    String gmc_report_type;
    String gmc_report_url;
    String description;

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getName() {
        return name;
    }

    public String getRights() {
        return rights;
    }

    public String getBz() {
        return bz;
    }

    public String getSkin() {
        return skin;
    }

    public String getEmail() {
        return email;
    }

    public String getNumber() {
        return number;
    }

    public String getPhone() {
        return phone;
    }

    public String getName_en() {
        return name_en;
    }

    public String getName_cn() {
        return name_cn;
    }

    public String getGmc_report_type() {
        return gmc_report_type;
    }

    public String getGmc_report_url() {
        return gmc_report_url;
    }

    public String getDescription() {
        return description;
    }
}
