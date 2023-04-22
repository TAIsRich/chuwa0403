package hw6.completableFuture.homework1;

import java.util.concurrent.CompletableFuture;
import static hw6.completableFuture.homework1.SumProduct.*;


public class CompletableFutureO {
    public static void main(String[] args) {
        int a = 5;
        int b = 10;
        CompletableFuture<Integer> sumFuture = CompletableFuture.supplyAsync(()->sum(a,b));
        CompletableFuture<Integer> productFuture = CompletableFuture.supplyAsync(()->product(a,b));
        sumFuture.thenAccept(result->printResult(result));
        productFuture.thenAccept(result->printResult(result));
    }
}
