package com.neusoft.bsp.controller;

import com.github.pagehelper.PageInfo;
import com.neusoft.bsp.System.entity.Code;
import com.neusoft.bsp.System.entity.User;
import com.neusoft.bsp.System.service.CodeService;
import com.neusoft.bsp.common.base.BaseModel;
import com.neusoft.bsp.common.base.BaseModelJson;
import com.neusoft.bsp.common.base.BaseModelJsonPaging;
import com.neusoft.bsp.common.exception.BusinessException;
import com.neusoft.bsp.common.validationGroup.InsertGroup;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@CrossOrigin
@RestController
@RequestMapping("/cdm")
public class CodeController {

    @Autowired
    CodeService codeService;

    @PostMapping("/addCode")
    public BaseModel addCode(@Validated({InsertGroup.class})@RequestBody Code code){
        BaseModel baseModel = new BaseModel();
        int result = codeService.insert(code);
        if(result == 1){
            baseModel.code = 200;
            return baseModel;
        }else{
            throw BusinessException.INSERT_FAIL;
        }
    }

    @RequiresPermissions("code:codelist")
    @GetMapping("/codelist")
    public BaseModelJsonPaging<PageInfo<Code>> getCodeList(Integer page, Integer limit,
                                                           String username, String name, String email) {
        Map<String, Object> map = new HashMap<>();
        map.put("username", username);
        map.put("name", name);
        map.put("email", email);
        BaseModelJsonPaging<PageInfo<Code>> result = new BaseModelJsonPaging<PageInfo<Code>>();
        if (page == null) {
            page = 1;
        }
        if (limit == null) {
            limit = 10;
        }
        result.code = 200;
        result.data = codeService.getAllByFilter(page, limit, map);
        result.total = codeService.getAllByFilter(page, limit, map).getSize();

        return result;
    }



}
