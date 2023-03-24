package com.du.impl;

import com.du.pojo.order;
import com.du.service.ShopService;
import com.du.service.Userservice;
import org.springframework.core.annotation.Order;

public class ShopServiceImpl implements ShopService {
    //使用远程服务端口
    private Userservice orderService;

    @Override
    public order buyGoods(Integer userId, String goodName, float price, Integer amount) {
        order order = orderService.createOrder(userId, goodName, price, amount);
        return order;
    }

    public void setOrderService(Userservice orderService) {
        this.orderService = orderService;
    }
}