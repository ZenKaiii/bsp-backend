package com.neusoft.bsp.controller;

import com.neusoft.bsp.System.entity.Code;
import com.neusoft.bsp.System.service.CodeService;
import com.neusoft.bsp.common.base.BaseModel;
import com.neusoft.bsp.common.validationGroup.InsertGroup;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/cdm")
public class CodeController {

    @Autowired
    CodeService codeService;

    @PostMapping("/addCode")
    public BaseModel addCode(@Validated({InsertGroup.class})@RequestBody Code code){
        return null;
    }



}
