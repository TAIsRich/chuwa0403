package com.richard.multithreading.m8_future.batch_payments;

/**
 * @Author zhuhaotian
 * @Date 2023/4/21
 */

public class Order {

    String id;
    double amount;

    Order(String id, double amount) {
        this.id = id;
        this.amount = amount;
    }
}
