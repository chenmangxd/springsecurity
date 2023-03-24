package com.du.springcloudproviderdepthystrix8001.controller;

import com.du.springcloudapi.pojo.Dept;

import com.du.springcloudproviderdepthystrix8001.service.DeptService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DeptController{
    @Autowired
    private DeptService deptService;

    @PostMapping("/dept/add")
    public boolean addDept(Dept dept) {
        return deptService.addDept(dept);
    }

    @RequestMapping("/dept/get/{id}")
    @HystrixCommand(fallbackMethod = "hystrixGet")  //如果失败 去调用Hystrix的备选方案
    public Dept get(@PathVariable("id") int id){
        Dept dept = deptService.queryById(id);
        if (dept==null){//如果当前id值为空 抛出异常
            throw new RuntimeException("id=> "+ id+"不存在该用户,或者该信息无法找到");
        }
        return dept;
    }

    //如果出现异常 采取Hystrix的备选方案
    public Dept hystrixGet(@PathVariable("id") int id){
        return new Dept()
                .setId(id)
                .setDname("id=> "+id+"没有找到相关信息,null by Hystrix");
    }

    @RequestMapping("/dept/list")
    public List<Dept> queryAll() {
        return deptService.queryAll();
    }
    @Autowired
    private DiscoveryClient client;

    /**
     * 获取一些注册进来的微服务的信息~，
     *
     * @return
     */
    @HystrixCommand
    @GetMapping("/dept/discovery")
    public Object discovery() {
        // 获取微服务列表的清单
        List<String> services = client.getServices();
        System.out.println("discovery=>services:" + services);
        // 得到一个具体的微服务信息,通过具体的微服务id，applicaioinName；
        List< ServiceInstance > instances = client.getInstances("SPRINGCLOUD-PROVIDER-DEPT");
        for (ServiceInstance instance : instances) {
            System.out.println(
                    instance.getHost() + "\t" + // 主机名称
                            instance.getPort() + "\t" + // 端口号
                            instance.getUri() + "\t" + // uri
                            instance.getServiceId() // 服务id
            );
        }
        return this.client;
    }

}

