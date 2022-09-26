package com.idea.springcloud.service.Impl;


import com.idea.springcloud.dao.PaymentDao;
import com.idea.springcloud.entities.Payment;
import com.idea.springcloud.service.PaymentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class PaymentServiceImpl implements PaymentService {
    @Resource
    private PaymentDao paymentDao;
    @Override
    public int create(Payment payment){
        return paymentDao.create(payment);
    }
    @Override
    public Payment getPaymentById(long id){
        return paymentDao.getPaymentById(id);
    }
}
