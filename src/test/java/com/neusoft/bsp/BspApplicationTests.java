package com.neusoft.bsp;

import com.neusoft.bsp.System.entity.User;
import com.neusoft.bsp.System.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class BspApplicationTests {
    @Autowired
    UserService userService;


    @Test
    void contextLoads() {
    }



}
