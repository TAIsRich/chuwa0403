package multithreading.Q25;

import java.util.concurrent.CompletableFuture;

public class CompletableFutureSumProduct {
    public static void main(String[] args) {
        int num1 = 20;
        int num2 = 10;

        // CompletableFuture for sum
        CompletableFuture<Integer> sumFuture = CompletableFuture.supplyAsync(() -> num1 + num2);

        // CompletableFuture for product
        CompletableFuture<Integer> productFuture = CompletableFuture.supplyAsync(() -> num1 * num2);

        sumFuture.thenAcceptBoth(productFuture, (sum, product) -> {
            System.out.println("Sum: " + sum);
            System.out.println("Product: " + product);
        }).join();
    }
}
