package com.jsyl.serviceribbon.feign;

import com.jsyl.serviceribbon.feign.fallbackfactory.ServicehiFeignClientFallbackFactory;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

@FeignClient(name = "service-offer", fallbackFactory = ServicehiFeignClientFallbackFactory.class)
public interface ServicehiFeignClient {

    @GetMapping(value = "/hi")//？xxx=xxx形式 Method为GET
    String getService(@RequestParam(name = "name") String name);
}
