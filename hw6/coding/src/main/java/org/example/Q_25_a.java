package org.example;

import java.util.concurrent.CompletableFuture;

public class Q_25_a {
    public static void main(String[] args) {
        int i = 2;
        int j = 3;

        CompletableFuture.supplyAsync(() -> i + j)
                .thenCombine(CompletableFuture.supplyAsync(() -> i * j), (sum, product) -> {
                    System.out.println("Sum: " + sum);
                    System.out.println("Product: " + product);
                    return null;
                });
    }
}
