package com.neusoft.bsp.controller;

import com.neusoft.bsp.MVO.entity.Manufacturer;
import com.neusoft.bsp.MVO.service.ManufacturerService;
import com.neusoft.bsp.System.entity.User;
import com.neusoft.bsp.System.service.UserService;
import com.neusoft.bsp.common.base.BaseController;
import com.neusoft.bsp.common.base.BaseModel;
import com.neusoft.bsp.common.exception.BusinessException;
import com.neusoft.bsp.common.validationGroup.InsertGroup;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@CrossOrigin
@RestController
@RequestMapping("/register")
public class RegisterController extends BaseController {

    @Autowired
    UserService userService;
    @Autowired
    ManufacturerService manufacturerService;
//    @Autowired
//    DropshipperService dropshipperService;

    @PostMapping("/adduser")
    public BaseModel addUser(@Validated({InsertGroup.class}) @RequestBody User user) {
        if (userService.getUserByName(user.getUsername()) == null) {
            BaseModel result = new BaseModel();
            int i = userService.insert(user);
            if (i == 1) {
                result.code = 200;
                result.message = "Register success";
                return result;
            } else {
                throw BusinessException.INSERT_FAIL;
            }
        }else{
            throw BusinessException.USERNAME_EXISTS;
        }
    }

    @PostMapping("/mvoregister")
    public BaseModel mvoRegister(@RequestBody User user, @RequestBody Manufacturer manufacturer) {
        if (userService.getUserByName(user.getUsername()) == null) {
            BaseModel result = new BaseModel();
            int i1 = userService.insert(user);
            Map manmap = new HashMap<String,Object>();
            int i2 = manufacturerService.insert(manmap);
            if (i1 == 1&&i2 == 1) {
                result.code = 200;
                result.message = "Register success";
                return result;
            } else {
                throw BusinessException.INSERT_FAIL;
            }
        }else{
            throw BusinessException.USERNAME_EXISTS;
        }
    }


}
