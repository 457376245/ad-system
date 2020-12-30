package com.jh.sponsor;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableCircuitBreaker
@EnableEurekaClient
@EnableFeignClients
@SpringBootApplication
@MapperScan(basePackages = "com.jh.sponsor.*")
public class AdSponsorApplication {

    public static void main(String[] args) {
        SpringApplication.run(AdSponsorApplication.class, args);
    }

}
