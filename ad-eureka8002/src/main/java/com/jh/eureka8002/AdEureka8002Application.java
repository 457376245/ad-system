package com.jh.eureka8002;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class AdEureka8002Application {

    public static void main(String[] args) {
        SpringApplication.run(AdEureka8002Application.class, args);
    }

}
