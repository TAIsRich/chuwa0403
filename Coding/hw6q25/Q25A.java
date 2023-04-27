import java.util.concurrent.CompletableFuture;

public class Q25A {
    public static void main(String[] args) {
        int a = 5, b = 10;

        CompletableFuture<Integer> sumFuture = CompletableFuture.supplyAsync(() -> a + b);
        CompletableFuture<Integer> productFuture = CompletableFuture.supplyAsync(() -> a * b);

        CompletableFuture<Void> combinedFuture = CompletableFuture.allOf(sumFuture, productFuture);

        combinedFuture.thenRun(() -> {
            Integer sum = sumFuture.join();
            Integer product = productFuture.join();
            System.out.println("Sum: " + sum);
            System.out.println("Product: " + product);
        });
    }
}
