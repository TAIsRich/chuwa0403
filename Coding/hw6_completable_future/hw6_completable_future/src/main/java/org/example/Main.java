package org.example;
import java.util.concurrent.CompletableFuture;


public class Main {
    public static void main(String[] args) {
        int num1 = 5;
        int num2 = 10;

        CompletableFuture<Integer> sumFuture = CompletableFuture.supplyAsync(() -> num1 + num2);
        CompletableFuture<Integer> productFuture = CompletableFuture.supplyAsync(() -> num1 * num2);

        CompletableFuture<Void> combinedFuture = CompletableFuture.allOf(sumFuture, productFuture);

        combinedFuture.thenRun(() -> {
            int sum = sumFuture.join();
            int product = productFuture.join();

            System.out.println("Sum: " + sum);
            System.out.println("Product: " + product);
        });
    }
}