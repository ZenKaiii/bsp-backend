package com.neusoft.bsp.controller;

import com.neusoft.bsp.BVO.entity.Dsr;
import com.neusoft.bsp.BVO.repository.DsrRepository;
import com.neusoft.bsp.MVO.controller.ManufacturerController;
import com.neusoft.bsp.MVO.entity.Manufacturer;
import com.neusoft.bsp.MVO.service.ManufacturerService;
import com.neusoft.bsp.MVO.vo.ManufacturerVo;
import com.neusoft.bsp.System.dto.UserMvoDto;
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

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin
@RestController
@RequestMapping("/register")
public class RegisterController extends BaseController {

    @Autowired
    UserService userService;
    @Autowired
    ManufacturerService manufacturerService;
    @Autowired
    DsrRepository dsrRepository;


    @PostMapping("/bvo")
    public BaseModel addUser(@Validated({InsertGroup.class}) @RequestBody User user) {
        if (userService.getUserByName(user.getUsername()) == null) {
            Dsr dsr = new Dsr();
            dsr.setName(user.getName());
            dsrRepository.saveAndFlush(dsr);
            List<Dsr> dsrs = dsrRepository.findAll();
            user.setRole_id(3);
            user.setMan_buyer_id(dsrs.get(dsrs.size()-1).getDsrId());
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

    @PostMapping("/mvo")
    public BaseModel mvoRegister(@RequestBody UserMvoDto umd) {
       if (userService.getUserByName(umd.getUsername()) == null) {
           User user = umd.toUser();
           int i1 = userService.insert(user);
           if(i1 != 1){
               throw BusinessException.INSERT_FAIL;
           }else{
               Map<String,Object> manmap = umd.toManufacturer(user.getId());
               int i2 = manufacturerService.insert(manmap);
               List<Manufacturer> mans = manufacturerService.getAll();
               user.setMan_buyer_id(mans.get(mans.size()-1).getMan_id());
               userService.update(user);
               BaseModel result = new BaseModel();
               result.code = 200;
               result.message = "register success";
               return result;
           }

       }else{
            throw BusinessException.USERNAME_EXISTS;
       }
    }



}
