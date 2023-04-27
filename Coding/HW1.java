package Coding;
import java.util.concurrent.CompletableFuture;

public class HW1 {
    public static void main(String[] args) {
        int a = 5;
        int b = 10;
        
        CompletableFuture<Integer> sumFuture = CompletableFuture.supplyAsync(() -> a + b);
        CompletableFuture<Integer> productFuture = CompletableFuture.supplyAsync(() -> a * b);
        
        CompletableFuture<Void> combinedFuture = CompletableFuture.allOf(sumFuture, productFuture);
        
        combinedFuture.thenRun(() -> {
            int sum = sumFuture.join();
            int product = productFuture.join();
            System.out.println("Sum: " + sum);
            System.out.println("Product: " + product);
        });
    }
}
