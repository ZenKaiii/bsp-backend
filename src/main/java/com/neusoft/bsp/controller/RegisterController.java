package com.neusoft.bsp.controller;

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

@CrossOrigin
@RestController
@RequestMapping("/register")
public class RegisterController extends BaseController {

    @Autowired
    UserService userService;

    @PostMapping("/addUser")
    public BaseModel addUser(@Validated({InsertGroup.class}) @RequestBody User user, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            throw BusinessException.INSERT_FAIL.newInstance(this.getErrorResponse(bindingResult),
                    new Object[]{user.toString()});
        } else {
            BaseModel result = new BaseModel();
            if(userService.getUserByName(user.getUsername())!=null){
                throw BusinessException.USERNAME_EXISTS;
            }
            int i = userService.insert(user);
            if (i == 1) {
                result.code = 200;
                return result;
            } else {
                throw BusinessException.INSERT_FAIL;
            }
        }
    }

}
