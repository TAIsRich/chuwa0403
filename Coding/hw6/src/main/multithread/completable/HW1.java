package multithread.completable;

import java.util.concurrent.CompletableFuture;

public class HW1 {
    public static void main(String[] args) {
        int a = 10, b = 12;

        CompletableFuture<Integer> sumFuture = CompletableFuture.supplyAsync(() -> {
            return a + b;
        });

        CompletableFuture<Integer> productFuture = CompletableFuture.supplyAsync(() -> {
            return a * b;
        });

        CompletableFuture<Void> resultFuture = CompletableFuture.allOf(sumFuture, productFuture);

        resultFuture.thenRun(() -> {
            int sum = sumFuture.join();
            int product = productFuture.join();
            System.out.println("Sum: " + sum);
            System.out.println("Product: " + product);
        });
    }
}
