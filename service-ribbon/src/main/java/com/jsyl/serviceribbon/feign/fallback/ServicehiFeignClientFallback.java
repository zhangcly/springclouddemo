package com.jsyl.serviceribbon.feign.fallback;

import com.jsyl.serviceribbon.feign.ServicehiFeignClient;
import org.springframework.stereotype.Component;

@Component
public class ServicehiFeignClientFallback implements ServicehiFeignClient {
    @Override
    public String getService(String name) {
        return name + " get error from feign";
    }
}
