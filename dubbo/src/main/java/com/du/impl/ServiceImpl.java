package com.du.impl;

import com.du.pojo.order;
import com.du.service.Userservice;
import java.util.UUID;
public class ServiceImpl implements Userservice {
    @Override
        public order createOrder(Integer userId, String goodName, float price, Integer amount) {
        order order = new order();
        String orderId = UUID.randomUUID().toString().replaceAll("-","");
        order.setId(orderId);
        order.setAmount(amount);
        order.setGoodName(goodName);
        order.setPrice(price);
        return order;
    }

}