package com.du.springcloudapi.service;

import com.du.springcloudapi.pojo.Dept;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
@Component
@FeignClient(value = "SPRINGCLOUDPROVIDER",fallbackFactory = DeptClientServiceFallbackFactory.class)
public interface DeptService {
    @PostMapping("/dept/add")
    boolean addDept(Dept dept);
    @PostMapping("/dept/get/{id}")
    //根据id查询部门信息
    Dept queryById(@PathVariable("id") int id);
    @GetMapping("/dept/list")
    //查询所有的部门信息
    List<Dept> queryAll();
}
