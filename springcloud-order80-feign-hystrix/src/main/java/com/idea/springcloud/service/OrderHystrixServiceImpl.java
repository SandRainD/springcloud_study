package com.idea.springcloud.service;

import org.springframework.stereotype.Component;

@Component
public class OrderHystrixServiceImpl implements OrderHystrixService{
    @Override
    public String PaymentInfo_ok(Integer id) {
        return "OrderHystrixServiceImpl fallback";
    }
    @Override
    public String PaymentInfo_Timeout(Integer id) {
        return "OrderHystrixServiceImpl fallback";
    }
}
