package com.richard.multithreading.m8_future.batch_payments;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Author zhuhaotian
 * @Date 2023/4/21
 * @Description CompletableFuture 实现
 *
 * 优势：
 * 性能更好，因为可以利用多线程并行执行查询订单、支付和发送邮件等操作，同时使用非阻塞的回调函数处理结果。
 * 使用线程池有效地管理线程资源。
 * 代码更加清晰和简介，因为可以使用链式函数编程的方法来调用组合或组装异步操作。
 *
 * 弊端：
 * 代码复杂度较高，需要理解CompletableFuture的API和工作远离
 * 在某些情况下，可能需要额外的同步线程管理机制以确保正确的程序行为。
 */

public class BatchPaymentCompletableFuture {

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        List<String> orderIds = Arrays.asList("order1", "order2", "order3");
        ExecutorService executorService = Executors.newFixedThreadPool(3);

        /**
         * 并发查询订单：      ｜｜｜
         * 订单并发查询完成    -------
         * 并发支付订单：      ｜｜｜
         * 并发发送邮件：      ｜｜｜
         */

        List<CompletableFuture<Order>> orderFutures = new ArrayList<>();
        for (String orderId : orderIds) {
            orderFutures.add(
                    CompletableFuture.supplyAsync(() -> OrderProcessUtil.queryOrder(orderId))
            );
        }

        /**
         * 对于每个订单，makePayment操作和sendEmail操作会顺序执行，即先处理支付，然后发送邮件。
         * 但在处理多个订单时，这些操作会并发执行。这意味着，在处理一个订单的makePayment操作时，可能同时处理另一个订单的sendEmail操作。
         */
        List<CompletableFuture<Void>> emailFutures = new ArrayList<>();
        for (CompletableFuture<Order> orderFuture : orderFutures) {
            emailFutures.add(
                    orderFuture.thenApplyAsync(OrderProcessUtil::makePayment, executorService)
                            .thenAcceptAsync(paymentResult -> {
//                                try {
//                                    OrderProcessUtil.sendEmail(orderFuture.get(), paymentResult);
//                                } catch (InterruptedException | ExecutionException e) {
//                                    throw new RuntimeException(e);
//                                }
                                /**
                                 * join() will wait until orderFuture has its result,
                                 * so unlike get(), we don't need an exception handler
                                 */
                                OrderProcessUtil.sendEmail(orderFuture.join(), paymentResult);
                            }, executorService)
            );
        }

        CompletableFuture.allOf(emailFutures.toArray(new CompletableFuture[0])).join();
        executorService.shutdown();

        // Chain all three operations into one chain
        List<CompletableFuture<Void>> emails = new ArrayList<>();
        for (String orderId : orderIds) {
            emails.add(
                    CompletableFuture
                            .supplyAsync(() -> OrderProcessUtil.queryOrder(orderId))
                            .thenApplyAsync(OrderProcessUtil::makePayment, executorService)
                            .thenAcceptAsync(paymentResult -> {
                                OrderProcessUtil.sendEmail(
                                        // The line below is the first operation we did, because we still need the order object.
                                        CompletableFuture.supplyAsync(() -> OrderProcessUtil.queryOrder(orderId)).join(),
                                        paymentResult);
                            }, executorService)
            );
        }

    }
}
