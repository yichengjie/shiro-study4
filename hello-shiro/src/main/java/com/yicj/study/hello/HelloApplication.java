package com.yicj.study.hello;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author yicj
 * @date 2023/11/18 18:54
 */

@SpringBootApplication
@MapperScan(basePackages = "com.yicj.study.hello.repository.mapper")
public class HelloApplication {

    public static void main(String[] args) {
        SpringApplication.run(HelloApplication.class, args) ;
    }
}
