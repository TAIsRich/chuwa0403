public class CompletableFutureExample1
{
    public static void main(String[] args) throws InterruptedException {
        CompletableFuture<Integer> sumFuture = CompletableFuture.supplyAsync(() -> 5 + 9);
        CompletableFuture<Integer> addFuture = CompletableFuture.supplyAsync(() -> 5 * 9);
        sumFuture.thenAcceptAsync(sum -> System.out.println( sum));
        prodFuture.thenAcceptAsync(add -> System.out.println(add));
        Thread.sleep(1000);
    }
}