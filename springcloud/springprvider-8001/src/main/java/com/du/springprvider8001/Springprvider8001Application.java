package com.du.springprvider8001;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class Springprvider8001Application {

    public static void main(String[] args) {
        SpringApplication.run(Springprvider8001Application.class, args);
    }

}
