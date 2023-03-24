package com.du.springcloudapi.service;

import com.du.springcloudapi.pojo.Dept;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

import java.util.List;

//Hystrix 降级，当服务端关闭后的提示信息
@Component
public class DeptClientServiceFallbackFactory implements FallbackFactory {

    @Override
    public DeptService create(Throwable throwable) {
        return new DeptService() {
            @Override
            public Dept queryById(int id) {
                return new Dept()
                        .setId(id)
                        .setDname("id=>" +id+"没有对应的信息，客户端提供了降级的信息，这个服务现在已经关闭");
            }

            @Override
            public List<Dept> queryAll() {
                return null;
            }

            @Override
            public boolean addDept(Dept dept) {
                return false;
            }

        };
    }
}

