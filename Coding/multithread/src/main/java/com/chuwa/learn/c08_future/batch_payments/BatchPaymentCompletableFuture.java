package com.chuwa.learn.c08_future.batch_payments;

import java.util.concurrent.CompletableFuture;
import java.util.List;
import java.util.*;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static com.chuwa.learn.c08_future.batch_payments.OrderProcessUtil.*;
public class BatchPaymentCompletableFuture {

    /**
     * 使用 CompletableFuture 版本:
     * 优势：
     * 性能更好，因为可以利用多线程并行执行查询订单、支付和发送邮件等操作，同时使用非阻塞的回调函数处理结果。
     * 使用线程池有效地管理线程资源。
     * 代码更加清晰和简洁，因为可以使用链式方法调用来组合和组装异步操作。
     * 提供了丰富的API来处理多个CompletableFuture的组合和异常处理。
     * 弊端：
     * 代码复杂度相对较高，需要理解CompletableFuture的API和工作原理。
     * 在某些情况下，可能需要额外的同步或线程管理机制以确保正确的程序行为。
     */

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        List<String> orderIds = Arrays.asList("order1", "order2", "order3");
        ExecutorService executorService = Executors.newFixedThreadPool(3);

        List<CompletableFuture<Order>> orderFutures = new ArrayList<>();
        for (String orderId : orderIds) {
            CompletableFuture<Order> future = CompletableFuture.supplyAsync(() -> queryOrder(orderId), executorService);
            orderFutures.add(future);
        }

        List<CompletableFuture<Void>> emailFutures = new ArrayList<>();
        for (CompletableFuture<Order> orderFuture : orderFutures) {
            /**
             * 对于每个订单，makePayment操作和sendEmail操作会顺序执行，即先处理支付，然后发送邮件。
             * 但在处理多个订单时，这些操作会并发执行。这意味着，在处理一个订单的makePayment操作时，可能同时处理另一个订单的sendEmail操作。
             */
            CompletableFuture<Void> future = orderFuture
                    .thenApplyAsync(OrderProcessUtil::makePayment, executorService)
                    .thenAcceptAsync(paymentResult -> sendEmail(orderFuture.join(), paymentResult), executorService);
            emailFutures.add(future);
        }

        CompletableFuture.allOf(emailFutures.toArray(new CompletableFuture[0])).join();
        executorService.shutdown();
    }
}
