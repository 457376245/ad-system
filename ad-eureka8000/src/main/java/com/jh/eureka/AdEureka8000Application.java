package com.jh.eureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
@EnableEurekaServer
@SpringBootApplication
public class AdEureka8000Application {
    public static void main(String[] args) {
        SpringApplication.run(AdEureka8000Application.class, args);
    }

}
