package com.idea.springcloud.controller;

import com.idea.springcloud.entities.CommonResult;
import com.idea.springcloud.entities.Payment;
import com.idea.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@Repository
@RestController
@Slf4j
public class PaymentController {
    @Resource
    private PaymentService paymentService;
    @Value("${server.port}")
    private String serverPort;
    @PostMapping(value = "/payment/create")
    public CommonResult create(@RequestBody Payment payment){
        int result=paymentService.create(payment);
        System.out.println(result);
        if(result>0){
            return new CommonResult(200,"success serverport"+serverPort,result);
        }else {
            return new CommonResult(444,"error",null);
        }
    }

    @GetMapping(value = "/payment/get/{id}")
    public CommonResult getPaymentById(@PathVariable("id") Long id){
        Payment payment=paymentService.getPaymentById(id);
        System.out.println(payment);
        if(payment!=null){
            return new CommonResult(200,"success serverport"+serverPort,payment);
        }else {
            return new CommonResult(444,"error",null);
        }
    }


}
