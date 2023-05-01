package com.richard.transactionlearn.controller;

import com.richard.transactionlearn.payload.OrderRequest;
import com.richard.transactionlearn.payload.OrderResponse;
import com.richard.transactionlearn.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author zhuhaotian
 * @Date 2023/5/1
 */

@RestController
@RequestMapping("/api/v1/orders")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping
    public ResponseEntity<OrderResponse> placeOrder(@RequestBody OrderRequest OrderRequest) {
        return new ResponseEntity<>(orderService.placeOrder(OrderRequest), HttpStatus.OK);
    }
}
