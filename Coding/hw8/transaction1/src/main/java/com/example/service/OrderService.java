package com.example.service;

import com.example.dto.OrderRequest;
import com.example.dto.OrderResponse;

public interface OrderService {
    OrderResponse placeOrder(OrderRequest orderRequest);
}
