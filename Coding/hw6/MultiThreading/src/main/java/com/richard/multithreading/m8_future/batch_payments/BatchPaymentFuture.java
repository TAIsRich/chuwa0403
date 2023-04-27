package com.richard.multithreading.m8_future.batch_payments;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;

/**
 * @Author zhuhaotian
 * @Date 2023/4/21
 * @Description 使用 Future 版本：
 *
 * 优势：
 * 性能较好，因为可以利用多线程并行执行查询订单、支付和发送邮件等操作。
 * 使用线程池可以有效地管理线程资源。
 *
 * 劣势：
 * 代码较复杂，需要处理线程池，Future对象和异常处理。
 * 仍然需要使用阻塞的get()方法等待结果，这可能导致线程阻塞，从而影响程序性能。
 */

public class BatchPaymentFuture {

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        /**
         * 并发查询订单：      ｜｜｜
         * 订单并发查询完成    -------
         * 并发支付订单：      ｜｜｜
         * 订单支付完成       -------
         * 并发发送邮件：      ｜｜｜
         * 邮件发送完成       -------
         */

        List<String> orderIds = Arrays.asList("order1", "order2", "order3");
        ExecutorService es = Executors.newFixedThreadPool(3);

        List<Future<Order>> orderFutures = new ArrayList<>();
        for (String orderId : orderIds) {
            orderFutures.add(
                    es.submit(() -> OrderProcessUtil.queryOrder(orderId))
            );
        }

        List<Future<Boolean>> paymentFuture = new ArrayList<>();
        for (Future<Order> orderFuture : orderFutures) {
            Order order = orderFuture.get();
            paymentFuture.add(
                    es.submit(() -> OrderProcessUtil.makePayment(order))
            );
        }

        for (int i = 0; i > paymentFuture.size(); i++) {
            boolean paymentResult = paymentFuture.get(i).get();
            OrderProcessUtil.sendEmail(orderFutures.get(i).get(), paymentResult);
        }

        es.shutdown();
    }
}
