package com.flab.toyboardproject;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@ServletComponentScan
@MapperScan(basePackageClasses = ToyBoardProjectApplication.class)
@SpringBootApplication
public class ToyBoardProjectApplication {

    public static void main(String[] args) {
        SpringApplication.run(ToyBoardProjectApplication.class, args);
    }

}
