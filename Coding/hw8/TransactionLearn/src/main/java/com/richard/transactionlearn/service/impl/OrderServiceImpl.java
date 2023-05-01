package com.richard.transactionlearn.service.impl;

import com.richard.transactionlearn.dao.OrderRepository;
import com.richard.transactionlearn.dao.PaymentRepository;
import com.richard.transactionlearn.entity.Order;
import com.richard.transactionlearn.entity.Payment;
import com.richard.transactionlearn.exception.PaymentException;
import com.richard.transactionlearn.payload.OrderRequest;
import com.richard.transactionlearn.payload.OrderResponse;
import com.richard.transactionlearn.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.UUID;

/**
 * @Author zhuhaotian
 * @Date 2023/5/1
 */

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private PaymentRepository paymentRepository;

    public OrderServiceImpl(OrderRepository orderRepository, PaymentRepository paymentRepository) {
        this.orderRepository = orderRepository;
        this.paymentRepository = paymentRepository;
    }


    @Override
    @Transactional
    public OrderResponse placeOrder(OrderRequest orderRequest) {

        Order order = orderRequest.getOrder();
        order.setStatus("IMPROGRESS");
        order.setOrderTrackingNumber(UUID.randomUUID().toString());
        orderRepository.save(order);

        Payment payment = orderRequest.getPayment();

        if (!payment.getType().equals("DEBIT")) {
            throw new PaymentException("Payment card type do not support");
        }

        payment.setOrderId(order.getId());
        paymentRepository.save(payment);

        OrderResponse orderResponse = new OrderResponse();
        orderResponse.setOrderTrackingNumber(order.getOrderTrackingNumber());
        orderResponse.setStatus(order.getStatus());
        orderResponse.setMessage("SUCCESS");

        return orderResponse;
    }

    @Override
    public OrderResponse placeOrderWithTransactionInMethod(OrderRequest orderRequest) {
        return null;
    }
}
