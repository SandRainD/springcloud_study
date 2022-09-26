package com.idea.springcloud.controller;

import com.idea.springcloud.service.OrderHystrixService;
import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

@RestController
@Slf4j
@DefaultProperties(defaultFallback = "payment_Global_fallbackMethod")
public class OrderHystrixController {
    @Resource
    private OrderHystrixService orderHystrixService;
    @GetMapping("/consumer/payment/hystrix/ok/{id}")
    public String PaymentInfo_ok(@PathVariable(value = "id") Integer id){
        String result=orderHystrixService.PaymentInfo_ok(id);
        return result;
    }
    @GetMapping(value = "/consumer/payment/hystrix/timeout/{id}")
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
    public String payment_Global_fallbackMethod(){
        return "Global异常处理触发，请检查服务器内部故障";
    }
}
