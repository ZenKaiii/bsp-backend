package com.neusoft.bsp;

import com.neusoft.bsp.System.entity.User;
import com.neusoft.bsp.System.service.UserService;
import com.neusoft.bsp.common.base.BaseModelJson;
import com.neusoft.bsp.controller.LoginController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class LoginTest {

    @Autowired
    UserService userService;

    @Test
    void service_getUserByName(){
        User user = userService.getUserByName("zhx");
        System.out.println(user);
    }



}
