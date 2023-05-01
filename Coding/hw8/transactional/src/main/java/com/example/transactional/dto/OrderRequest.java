package com.example.transactional.dto;

import com.example.transactional.entity.Order;
import com.example.transactional.entity.Payment;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrderRequest {
    private Order order;
    private Payment payment;
}
