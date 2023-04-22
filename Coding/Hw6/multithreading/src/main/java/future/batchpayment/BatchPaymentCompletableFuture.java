package future.batchpayment;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static future.batchpayment.OrderProcessUtil.queryOrder;
import static future.batchpayment.OrderProcessUtil.sendEmail;

public class BatchPaymentCompletableFuture {
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

            CompletableFuture<Void> future = orderFuture
                    .thenApplyAsync(OrderProcessUtil::makePayment, executorService)
                    .thenAcceptAsync(paymentResult -> sendEmail(orderFuture.join(), paymentResult), executorService);
            emailFutures.add(future);
        }

//        List<CompletableFuture<Void>> emailFutures2 = new ArrayList<>();
//        for (String orderId : orderIds) {
//            CompletableFuture<Void> future = CompletableFuture
//                    .supplyAsync(() -> queryOrder(orderId), executorService)
//                    .thenApplyAsync(OrderProcessUtil::makePayment, executorService)
//                    .thenAcceptAsync(paymentResult -> sendEmail(orderFuture.join(), paymentResult), executorService); // can't be
//            //implemented here
//            emailFutures2.add(future);
//        }

        CompletableFuture.allOf(emailFutures.toArray(new CompletableFuture[0])).join();
        executorService.shutdown();
    }
}
