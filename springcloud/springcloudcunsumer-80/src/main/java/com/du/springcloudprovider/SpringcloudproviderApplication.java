package com.du.springcloudprovider;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

//(exclude ={DataSourceTransactionManagerAutoConfiguration.class} )
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
@EnableEurekaClient
public class SpringcloudproviderApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringcloudproviderApplication.class, args);
    }

}
