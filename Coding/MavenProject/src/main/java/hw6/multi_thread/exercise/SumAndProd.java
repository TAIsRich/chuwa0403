package hw6.multi_thread.exercise;

import java.util.concurrent.CompletableFuture;

public class SumAndProd {
    public static void main(String[] args) {
        int x = 2;
        int y = 4;

        CompletableFuture<Integer> sumFuture = CompletableFuture.supplyAsync(()-> x+y);
        CompletableFuture<Integer> proFuture = CompletableFuture.supplyAsync(()-> x*y);

        sumFuture.thenAccept(sum -> System.out.println("Sum "+sum));
        proFuture.thenAccept(pro -> System.out.println("Product "+pro));
    }
}
