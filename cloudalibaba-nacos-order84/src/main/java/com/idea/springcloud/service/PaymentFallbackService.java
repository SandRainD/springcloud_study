package com.idea.springcloud.service;

import com.idea.springcloud.entities.CommonResult;
import com.idea.springcloud.entities.Payment;
import org.springframework.stereotype.Component;

@Component
public class PaymentFallbackService implements PaymentService {
    @Override
    public CommonResult<Payment> paymentSQL(Long id) {
        return new CommonResult<Payment>(444,"服务降级返回PaymentFallbackService");
    }
}