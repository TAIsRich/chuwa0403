package com.chuwa.learn.completablefuture;

import java.util.concurrent.CompletableFuture;

public class CompletableFutureExample {
    public static void main(String[] args) {
        CompletableFuture<Integer> sumFuture = CompletableFuture.supplyAsync(() -> 2 + 3);
        CompletableFuture<Integer> productFuture = CompletableFuture.supplyAsync(() -> 2 * 3);

        sumFuture.thenAcceptBoth(productFuture, (sum, product) -> {
            System.out.println("Sum: " + sum);
            System.out.println("Product: " + product);
        });
    }
}
