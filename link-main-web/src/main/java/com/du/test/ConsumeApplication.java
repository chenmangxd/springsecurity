package com.du.test;

import com.du.pojo.order;
import com.du.service.ShopService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.annotation.Order;

public class ConsumeApplication {
    public static void main(String[] args) {
        String configLocation = "shop-consume.xml";
        ApplicationContext context = new ClassPathXmlApplicationContext(configLocation);
        ((ClassPathXmlApplicationContext) context).start();
        ShopService shopService = (ShopService) context.getBean("shopService");
        order order = shopService.buyGoods(1,"手机",1000,2);
        System.out.println("order" + order);
    }
}