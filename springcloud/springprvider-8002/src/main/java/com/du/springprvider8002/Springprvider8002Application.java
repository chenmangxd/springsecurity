package com.du.springprvider8002;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class Springprvider8002Application {

    public static void main(String[] args) {
        SpringApplication.run(Springprvider8002Application.class, args);
    }

}
