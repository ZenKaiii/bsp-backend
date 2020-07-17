package com.neusoft.bsp.System.dto;

import com.neusoft.bsp.MVO.service.ManufacturerService;
import com.neusoft.bsp.System.entity.User;
import com.neusoft.bsp.common.validationGroup.InsertGroup;
import com.neusoft.bsp.common.validationGroup.UpdateGroup;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.constraints.NotNull;
import java.sql.Time;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class UserMvoDto {
    String username;
    String password;
    String name;
    String email;
    String phone;
    String name_en;
    String name_cn;
    String gmc_report_type;
    String gmc_report_url;
    String description;

    @Autowired
    ManufacturerService manufacturerService;

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
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

    public User toUser(){
        User user = new User();
        user.setUsername(this.username);
        user.setName(this.name);
        user.setPassword(this.password);
        user.setEmail(this.email);
        user.setPhone(this.phone);
        user.setRole_id(2);
        return user;
    }

    public Map<String,Object> toManufacturer(int userId){
        Map<String,Object> map = new HashMap<String,Object>();
        map.put("name_en",this.getName_en());
        map.put("name_cn",this.getName_cn());
        map.put("gmc_report_type",this.getGmc_report_type());
        map.put("gmc_report_url",this.getGmc_report_url());
        map.put("description",this.getDescription());
        map.put("created_by",userId);
        map.put("last_update_by",userId);
        map.put("user_id",userId);
        map.put("creation_date",new Date(System.currentTimeMillis()));
        return map;
    }
}
