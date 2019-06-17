package com;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan({"com.common.dao"}) //手动添加扫描包地址
@SpringBootApplication
public class HelloScrapyApplication {

    public static void main(String[] args) {
        SpringApplication.run(HelloScrapyApplication.class, args);
        System.out.print("hello world");
    }

}
