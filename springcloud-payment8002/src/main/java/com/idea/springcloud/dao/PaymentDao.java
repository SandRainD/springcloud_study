package com.idea.springcloud.dao;

import com.idea.springcloud.entities.Payment;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface PaymentDao {
    public int create(Payment payment);
    public Payment getPaymentById(@Param("id") long id);
}
