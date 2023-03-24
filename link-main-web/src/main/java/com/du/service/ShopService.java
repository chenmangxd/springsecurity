package com.du.service;

import com.du.pojo.order;

public interface ShopService {
    public order buyGoods(Integer userId, String goodName, float price, Integer amount);
}
