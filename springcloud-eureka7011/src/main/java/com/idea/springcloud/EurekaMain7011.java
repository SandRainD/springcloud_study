package com.idea.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class EurekaMain7011 {
    public static void main(String[] args) {
        SpringApplication.run(EurekaMain7011.class,args);
    }
}
