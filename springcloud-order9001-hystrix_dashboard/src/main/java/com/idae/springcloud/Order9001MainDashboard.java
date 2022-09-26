package com.idae.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

@SpringBootApplication
@EnableHystrixDashboard
public class Order9001MainDashboard {
    public static void main(String[] args) {
        SpringApplication.run(Order9001MainDashboard.class,args);
    }
}
