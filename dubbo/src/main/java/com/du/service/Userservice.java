package com.du.service;

import com.du.pojo.order;
import org.springframework.core.annotation.Order;

import java.io.Serializable;

public interface Userservice  {
    public order createOrder(Integer userId, String goodName, float price, Integer amount);
}
