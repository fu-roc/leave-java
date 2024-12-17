package com.furoc;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("com.furoc.mapper")
@SpringBootApplication
public class LeaveSysApplication {

    public static void main(String[] args) {
        SpringApplication.run(LeaveSysApplication.class, args);
    }

}
