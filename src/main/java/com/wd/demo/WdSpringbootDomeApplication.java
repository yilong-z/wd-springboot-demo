package com.wd.demo;

import org.mybatis.spring.annotation.MapperScan;
import org.mybatis.spring.annotation.MapperScans;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.wd.demo.dao")
public class WdSpringbootDomeApplication {

    public static void main(String[] args) {
        SpringApplication.run(WdSpringbootDomeApplication.class, args);
    }

}
