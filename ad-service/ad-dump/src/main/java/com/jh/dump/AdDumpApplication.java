package com.jh.dump;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = "com.jh.sponsor.*")
public class AdDumpApplication {

    public static void main(String[] args) {
        SpringApplication.run(AdDumpApplication.class, args);
    }

}
