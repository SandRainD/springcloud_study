package com.idea.springcloud.service;

import cn.hutool.core.util.IdUtil;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.concurrent.TimeUnit;

@Service
public class PaymentService {
    public String paymentInfo_ok(Integer id){
        return "线程池：   "+Thread.currentThread().getName()+"    paymentInfo_ok   "+id;
    }
    @HystrixCommand(fallbackMethod = "paymentInfo_TimeoutHandler",commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "3000")
    })
    public String paymentInfo_Timeout(Integer id){
        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "线程池：   "+Thread.currentThread().getName()+"   paymentInfo_Timeout   "+id+"耗时timeout";
    }
    public String paymentInfo_TimeoutHandler(Integer id){
        return "线程池：   "+Thread.currentThread().getName()+"   paymentInfo_TimeoutHandler   "+id+"┭┮﹏┭┮";
    }


    //服务熔断
    @HystrixCommand(fallbackMethod = "paymentCircuitBreaker_fallback",commandProperties = {
            @HystrixProperty(name = "circuitBreaker.enabled",value = "true"),//是否开启断路器
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold",value = "10"),//请求次数
            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds",value = "10000"),//时间窗口期
            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage",value = "60"),//失败率达到value时开启熔断
    })
    public String paymentCircuitBreaker(@PathVariable(value = "id") Integer id){
        if(id<0){
            throw new RuntimeException("*****id不能为负数");
        }
        String serialNumber= IdUtil.simpleUUID();
        return Thread.currentThread().getName()+"\t"+"调用成功流水号"+serialNumber;
    }
    public String paymentCircuitBreaker_fallback(@PathVariable(value = "id") Integer id){
        return "请稍后再试(*^▽^*)";
    }
}
