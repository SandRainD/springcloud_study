package com.idea.springcloud.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Component
@FeignClient(value = "SPRINGCLOUD-PAYMENT-HYSTRIX",fallback = OrderHystrixServiceImpl.class)
public interface OrderHystrixService {
    @GetMapping("/payment/hystrix/ok/{id}")
    public String PaymentInfo_ok(@PathVariable(value = "id") Integer id);
    @GetMapping("/payment/hystrix/timeout/{id}")
    public String PaymentInfo_Timeout(@PathVariable(value = "id") Integer id);
}
