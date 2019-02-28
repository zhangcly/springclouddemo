package com.jsyl.serviceribbon.service.impl;

import com.jsyl.serviceribbon.service.HelloService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class HelloServiceImpl implements HelloService {
    @Autowired
    RestTemplate restTemplate;

    @HystrixCommand(fallbackMethod = "hiError",
            //配置具体见https://github.com/Netflix/Hystrix/wiki/Configuration
            commandProperties = {@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "5000"),//调用者等待命令执行的超时限制，超过此时间，HystrixCommand被标记为TIMEOUT，并执行回退逻辑。
                    @HystrixProperty(name = "metrics.rollingStats.timeInMilliseconds", value = "10000"), //统计的滚动窗口的时间段大小。该属性是线程池保持指标时间长短。
                    @HystrixProperty(name = "execution.isolation.strategy", value = "THREAD")},//Hystrix隔离策略有THREAD和SENSPHORE两种，THREAD(线程隔离)HystrixCommand会在单独线程执行 SENSPHORE(信号量隔离)在调用线程上执行，收到信号量限制
            threadPoolProperties = {@HystrixProperty(name = "coreSize", value = "1"),//线程池中核心线程数量
                    @HystrixProperty(name = "maxQueueSize",value = "10")})//队列大小
    @Override
    public String hiService(String name) {
        return restTemplate.getForObject("http://service-hi/hi?name="+name,String.class);
    }

    public String hiError(String name){
        return name + "get error";
    }
}
