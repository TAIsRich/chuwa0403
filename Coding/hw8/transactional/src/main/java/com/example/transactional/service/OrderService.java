package com.example.transactional.service;


import com.example.transactional.dto.OrderRequest;
import com.example.transactional.dto.OrderResponse;

public interface OrderService {
    OrderResponse placeOrder(OrderRequest orderRequest);
}
