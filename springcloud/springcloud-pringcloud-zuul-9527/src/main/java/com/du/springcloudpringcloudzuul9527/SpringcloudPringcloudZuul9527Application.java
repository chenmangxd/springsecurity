package com.du.springcloudpringcloudzuul9527;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
@EnableZuulProxy // 开启Zuul
public class SpringcloudPringcloudZuul9527Application {

    public static void main(String[] args) {
        SpringApplication.run(SpringcloudPringcloudZuul9527Application.class, args);
    }

}
