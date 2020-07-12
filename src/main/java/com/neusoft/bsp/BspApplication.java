package com.neusoft.bsp;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.CrossOrigin;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@CrossOrigin
@MapperScan("com.neusoft.bsp.*.mapper")
@SpringBootApplication
@EnableSwagger2
public class BspApplication {

    public static void main(String[] args) {
        SpringApplication.run(BspApplication.class, args);
    }

}
