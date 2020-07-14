package com.neusoft.bsp.System.entity;

import com.neusoft.bsp.common.base.BaseEntity;
import com.neusoft.bsp.common.validationGroup.InsertGroup;
import com.neusoft.bsp.common.validationGroup.SelectGroup;
import com.neusoft.bsp.common.validationGroup.UpdateGroup;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
// import java.sql.Time;

public class Code implements BaseEntity {
    int cdm_id;
    String code_type;
    String description;
    @NotNull(message = "The type code shouldn't be null",groups = {InsertGroup.class, UpdateGroup.class, SelectGroup.class})
    String type_cd;
    String code_val;
//    String seq_no;
//    String created_by;
//    Time creation_date;
//    String last_update_by;
//    Time last_update_date= new Time(System.currentTimeMillis());
//    int call_cnt;
//    String remark;
//    char sts_cd;

    public int getCdm_id() {
        return cdm_id;
    }

    public void setCdm_id(int cdm_id) {
        this.cdm_id = cdm_id;
    }

    public String getCode_type() {
        return code_type;
    }

    public void setCode_type(String code_type) {
        this.code_type = code_type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getType_cd() {
        return type_cd;
    }

    public void setType_cd(String type_cd) {
        this.type_cd = type_cd;
    }

    public String getCode_val() {
        return code_val;
    }

    public void setCode_val(String code_val) {
        this.code_val = code_val;
    }

    @Override
    public Serializable getId() {
        return this.cdm_id;
    }


    @Override
    public String toString() {
        return "Code{" +
                "cdm_id='" + cdm_id + '\'' +
                ", code_type='" + code_type + '\'' +
                ", description='" + description + '\'' +
                ", type_cd='" + type_cd + '\'' +
                ", code_val='" + code_val + '\'' +
                '}';
    }
}
