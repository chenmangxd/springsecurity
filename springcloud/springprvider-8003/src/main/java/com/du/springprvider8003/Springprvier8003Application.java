package com.du.springprvider8003;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class Springprvier8003Application {

    public static void main(String[] args) {
        SpringApplication.run(Springprvier8003Application.class, args);
    }

}
