package com.richard.multithreading.m8_future.batch_payments;

/**
 * @Author zhuhaotian
 * @Date 2023/4/21
 */

public class OrderProcessUtil {

    public static Order queryOrder(String orderId) {
        // Query order from the database or other source
        return new Order(orderId, 100.0);
    }

    public static boolean makePayment(Order order) {
        // Process payment for the order.
        return true;
    }

    public static void sendEmail(Order order, boolean paymentResult) {
        // Send email notification based on the payment result
    }
}
