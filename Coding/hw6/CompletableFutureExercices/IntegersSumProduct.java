package Coding.hw6.CompletableFutureExercices;

import java.util.concurrent.CompletableFuture;

public class IntegersSumProduct {
    public static void main(String[] args) throws InterruptedException {
        int a = 7;
        int b = 9;

        CompletableFuture<Integer> sumFuture = CompletableFuture.supplyAsync(() -> a + b);
        CompletableFuture<Integer> prodFuture = CompletableFuture.supplyAsync(() -> a * b);

        sumFuture.thenAcceptAsync(sum -> System.out.println("Sum: " + sum));
        prodFuture.thenAcceptAsync(prod -> System.out.println("Product: " + prod));

        // if no following code
        // the program may terminate before the futures have a chance to complete and print their results.
        // This can happen because the main method is the entry point for the program and will continue executing
        // until it reaches the end of the method or encounters a System.exit() statement.
        Thread.sleep(1000);

//        sumFuture.thenAcceptBoth(prodFuture, (sum, product) -> {
//            System.out.println("Sum: " + sum);
//            System.out.println("Product: " + product);
//        });
    }
}

