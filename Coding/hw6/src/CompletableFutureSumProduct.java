import java.util.concurrent.*;

public class CompletableFutureSumProduct {
    private static final ExecutorService executor = Executors.newFixedThreadPool(2);

    public static void main(String[] args) {

        int num1 = 5;
        int num2 = 10;

        CompletableFuture<Integer> sumFuture = asyncSum(num1, num2);
        CompletableFuture<Integer> productFuture = asyncProduct(num1, num2);

        CompletableFuture<Void> allFutures = CompletableFuture.allOf(sumFuture, productFuture);

        allFutures.thenAccept(result -> {
            try {
                System.out.println("Sum: " + sumFuture.get());
                System.out.println("Product: " + productFuture.get());
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
        });

        // Wait for the computations to complete before exiting the main thread.
        allFutures.join();

        // Shutdown the executor to release resources.
        executor.shutdown();
    }

    public static CompletableFuture<Integer> asyncSum(int a, int b) {
        return CompletableFuture.supplyAsync(() -> a + b, executor);
    }

    public static CompletableFuture<Integer> asyncProduct(int a, int b) {
        return CompletableFuture.supplyAsync(() -> a * b, executor);
    }

}
