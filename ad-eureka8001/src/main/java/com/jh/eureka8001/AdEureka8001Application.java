package com.jh.eureka8001;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class AdEureka8001Application {

    public static void main(String[] args) {
        SpringApplication.run(AdEureka8001Application.class, args);
    }

}
