package com.du.pojo;

import java.io.Serializable;

public class order implements Serializable {
    private static final long serialVersionUID  = 1L;

    //订单id
    private String id;
    //商品名称
    private String goodName;
    //商品单价
    private float price;
    //购买数量
    private Integer amount;
    //get and set

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getGoodName() {
        return goodName;
    }

    public void setGoodName(String goodName) {
        this.goodName = goodName;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public order() {
    }

    public order(String id, String goodName, float price, Integer amount) {
        this.id = id;
        this.goodName = goodName;
        this.price = price;
        this.amount = amount;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }
}
