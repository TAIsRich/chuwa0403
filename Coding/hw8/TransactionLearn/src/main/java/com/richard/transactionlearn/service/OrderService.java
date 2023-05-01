package com.richard.transactionlearn.service;

import com.richard.transactionlearn.payload.OrderRequest;
import com.richard.transactionlearn.payload.OrderResponse;

public interface OrderService {

    OrderResponse placeOrder(OrderRequest orderRequest);

    OrderResponse placeOrderWithTransactionInMethod(OrderRequest orderRequest);
}
