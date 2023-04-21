package mutithreads.twoSumCompFuture;

import java.util.concurrent.CompletableFuture;

public class twoSumAndProductCompFuture {
    public static void main(String[] args) {
        int a = 1;
        int b = 3;

        CompletableFuture<Integer> sumFuture = CompletableFuture.supplyAsync(() -> a + b);
        CompletableFuture<Integer> productFuture = CompletableFuture.supplyAsync(() -> a * b);
        sumFuture.thenAccept(sum -> System.out.println("Sum is :" + sum));
        productFuture.thenAccept(product -> System.out.println("Product is :" + product));
    }
}
