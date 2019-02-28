package com.jsyl.servicehystrix;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

@SpringBootApplication
@EnableHystrixDashboard
public class ServicehystrixApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServicehystrixApplication.class, args);
    }

}
