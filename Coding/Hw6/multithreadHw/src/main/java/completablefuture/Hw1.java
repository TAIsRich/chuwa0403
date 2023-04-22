package completablefuture;

import java.util.concurrent.CompletableFuture;

public class Hw1 {
    public static void main (String [] args) {
        int a = 10, b = 9;
        CompletableFuture<Void> cf = CompletableFuture.allOf(
                CompletableFuture.supplyAsync(() -> a + b).thenAccept(result -> System.out.println(result)),
                CompletableFuture.supplyAsync(() -> a * b).thenAccept(result -> System.out.println(result))
        );
        cf.join();
    }
}
