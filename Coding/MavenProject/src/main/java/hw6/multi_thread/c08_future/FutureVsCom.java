package hw6.multi_thread.c08_future;

import org.junit.Test;

import java.util.concurrent.*;

public class FutureVsCom {
    @Test
    public void testFuture(){
        ExecutorService executorService = Executors.newFixedThreadPool(2);

        Future<Integer> future = executorService.submit(()->{
            TimeUnit.SECONDS.sleep(5); // simulate a delay
            return 10+20;
        });

        try{
            System.out.println("Perform other ...");

            int result = future.get();
            System.out.println("result from the future "+result);

            // Prevent the main thread from exiting immediately
            for (int i = 0; i < 7; i++) {
                System.out.println("step "+i);
                try {
                    Thread.sleep(1000);
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
            }
        }catch (InterruptedException | ExecutionException e){
            e.printStackTrace();
        } finally {
            executorService.shutdown();
        }
    }

    @Test
    public void testCompletableFuture(){
        CompletableFuture<Integer> completableFuture = CompletableFuture.supplyAsync(()->{
            try{
                TimeUnit.SECONDS.sleep(5);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
            return 10+20;
        });

        System.out.println("other ...");

        completableFuture.thenAccept(integer -> System.out.println("result: "+integer));

        for (int i = 0; i < 7; i++) {
            System.out.println("step"+ i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
