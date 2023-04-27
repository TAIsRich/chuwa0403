package com.richard.multithreading.m8_future;

import org.junit.Test;

import java.util.concurrent.*;

/**
 * @Author zhuhaotian
 * @Date 2023/4/21
 */

public class FutureVsComletableFuture {

    @Test
    public void testFuture() {
        ExecutorService es = Executors.newFixedThreadPool(2);

        Future<Integer> future = es.submit(() -> {
            TimeUnit.SECONDS.sleep(5); // Simulate a delay
            return 10 + 20;
        });

        try {
            // Perform other tasks while waiting for the result
            System.out.println("Performing other tasks...");

            // Get the result from the Future(Blocked)
            int res = future.get();
            System.out.println("Result from the future: " + res);

            System.out.println("-------------------------------");
            // Prevent the main thread from exiting immediately
            for (int i = 0; i < 7; i++) {
                System.out.println("step " + i);

                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }


        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        } finally {
            es.shutdown();
        }
    }

    @Test
    public void testCompletableFuture() {
        CompletableFuture<Integer> cf = CompletableFuture.supplyAsync(() -> {
            try {
                TimeUnit.SECONDS.sleep(5); // Simulate a delay
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            return 10 + 20;
        });

        // Perform other tasks while waiting for the result
        System.out.println("Performing other tasks...");

        // Handle the result from the CompletableFuture(Non-blocked)
        cf.thenAccept(res -> System.out.println("Result from the CompletableFuture: " + res));

        System.out.println("-------------------------------");
        // Prevent the main thread from exiting immediately
        for (int i = 0; i < 7; i++) {
            System.out.println("step " + i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
