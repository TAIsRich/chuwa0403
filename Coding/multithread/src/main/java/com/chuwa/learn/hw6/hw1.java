package com.chuwa.learn.hw6;

import java.util.concurrent.CompletableFuture;
public class hw1 {

    public static void main(String[] args) {
        int a = 20;
        int b = 30;

        CompletableFuture<Integer> sumFuture = CompletableFuture.supplyAsync(() -> {
            return a + b;
        });

        CompletableFuture<Integer> productFuture = CompletableFuture.supplyAsync(() -> {
            return a * b;
        });

        CompletableFuture<Void> combinedFuture = CompletableFuture.allOf(sumFuture, productFuture);

        combinedFuture.thenRun(() -> {
            try {
                int sum = sumFuture.get();
                int product = productFuture.get();
                System.out.println("Sum: " + sum);
                System.out.println("Product: " + product);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }
}
