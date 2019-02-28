package com.jsyl.serviceribbon.controller;

import com.jsyl.serviceribbon.feign.ServicehiFeignClient;
import com.jsyl.serviceribbon.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class HelloController {

    @Autowired
    private HelloService helloService;

    @Autowired
    private DiscoveryClient discoveryClient;

    @Autowired
    private ServicehiFeignClient servicehiFeignClient;

    @RequestMapping(value = "/hi")
    public String hi(@RequestParam String name) {
//        return helloService.hiService(name);
        return servicehiFeignClient.getService(name);
    }

    @RequestMapping(value = "/instanceInfo")
    public List<ServiceInstance> showInfo() {
        return discoveryClient.getInstances("SERVICE-HI");
    }


}
