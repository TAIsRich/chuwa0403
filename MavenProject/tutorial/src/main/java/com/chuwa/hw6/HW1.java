package com.chuwa.hw6;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;


public class HW1 {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        int a = 10;
        int b = 5;
        CompletableFuture<Integer> future1 = CompletableFuture.supplyAsync(() -> a + b);
        CompletableFuture<Integer> future2 = CompletableFuture.supplyAsync(() -> a * b);

        CompletableFuture<Void> combinedFuture = CompletableFuture.allOf(future1, future2)
                .thenRun(() -> {
                    try {
                        int sum = future1.get();
                        int product = future2.get();
                        System.out.println("Sum: " + sum);
                        System.out.println("Product: " + product);

                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                });
        combinedFuture.join();
    }

}
