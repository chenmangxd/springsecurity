package com.du.redis;

import redis.clients.jedis.Jedis;

public class test {
    public static void main(String[] args) {
        Jedis jedis = new Jedis("192.168.79.128",6379);
// jedis 所有的命令就是我们之前的所有指令
        System.out.println(jedis.ping());
    }
}