package com.neusoft.bsp.controller;

import com.neusoft.bsp.System.entity.Code;
import com.neusoft.bsp.System.service.CodeService;
import com.neusoft.bsp.common.base.BaseModel;
import com.neusoft.bsp.common.base.BaseModelJson;
import com.neusoft.bsp.common.exception.BusinessException;
import com.neusoft.bsp.common.validationGroup.InsertGroup;
import com.neusoft.bsp.common.validationGroup.UpdateGroup;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/cdm")
public class CodeController {

    @Autowired
    CodeService codeService;

    @GetMapping("/codeList")
    public BaseModelJson<List<Code>> getAllCodes(){
        BaseModelJson<List<Code>> result = new BaseModelJson<List<Code>>();
        result.code = 200;
        result.message = "fetch success";
        result.data = codeService.getAll();
        return result;
    }

    @PostMapping("/addCode")
    public BaseModel addCode(@Validated({InsertGroup.class})@RequestBody Code code){
        if(codeService.insert(code)==1){
            BaseModel result = new BaseModel();
            result.code = 200;
            result.message = "insert success";
            return result;
        }else{
            throw BusinessException.INSERT_FAIL;
        }
    }

    @PostMapping("/deleteCode")
    public BaseModel deleteCode(int code_id){
        if(codeService.delete(code_id)==1){
            BaseModel result = new BaseModel();
            result.code = 200;
            result.message = "delete success";
            return result;
        }else{
            throw BusinessException.DELETE_FAIL;
        }
    }

    @PostMapping("/updateCode")
    public BaseModel deleteCode(@Validated({UpdateGroup.class})@RequestBody Code code){
        if(codeService.update(code)==1){
            BaseModel result = new BaseModel();
            result.code = 200;
            result.message = "update success";
            return result;
        }else{
            throw BusinessException.UPDATE_FAIL;
        }
    }




}
