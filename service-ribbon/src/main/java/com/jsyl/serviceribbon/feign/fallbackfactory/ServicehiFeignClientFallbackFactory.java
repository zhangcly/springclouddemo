package com.jsyl.serviceribbon.feign.fallbackfactory;

import com.jsyl.serviceribbon.feign.ServicehiFeignClient;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

@Component
public class ServicehiFeignClientFallbackFactory implements FallbackFactory<ServicehiFeignClient> {
    @Override
    public ServicehiFeignClient create(Throwable throwable) {
        return new ServicehiFeignClient() {
            @Override
            public String getService(String name) {
                return name +" get from fallback factory";
            }
        };
    }
}
