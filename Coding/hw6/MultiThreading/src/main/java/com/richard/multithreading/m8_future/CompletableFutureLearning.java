package com.richard.multithreading.m8_future;

import org.junit.Test;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.Assert.assertTrue;

/**
 * @Author zhuhaotian
 * @Date 2023/4/21
 */

public class CompletableFutureLearning {

    /**
     * Using CompletableFuture as a Simple Future.
     */
    @Test
    public void demo01() {
        CompletableFuture<String> cf = new CompletableFuture<>();

        ExecutorService es = Executors.newCachedThreadPool();

        es.submit(() -> {
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            cf.complete("Hello");
        });

        try {
            System.out.println(cf.get());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Using static methods runAsync and supplyAsync to create a CompletableFuture
     * instance out of Runnable and Supplier Functional types correspondingly.
     *
     * CompletableFuture.supplyAsync() 有返回值 - CompletableFuture<U>
     * CompletableFuture.runAsync() 没有返回值 - CompletableFuture<Void> 参数是 runnable 对象
     */
    @Test
    public void demo02() {

        /**
         * CompletableFuture.supplyAsync() 返回一个 CompletableFuture<U> 对象， U 的类型是 Supplier 对象的返回类型；
         * CompletableFuture.runAsync() 返回一个 CompletableFuture<Void> 对象，表示异步任务没有返回值。
         */
        CompletableFuture<String> cf1 = CompletableFuture.supplyAsync(() -> {
            System.out.println(Thread.currentThread().getName() + ": Hello1");
            return "Hello1";
        });
        CompletableFuture<Void> cf2 = CompletableFuture.runAsync(() -> {
            System.out.println(Thread.currentThread().getName() + ": Hello2");
        });

        try {
            System.out.println(cf2.isDone());
            Thread.sleep(1000);
            System.out.println(cf2.isDone());

            System.out.println(cf1.get());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Using thenApply method process the result,
     * and returns a Future that holds a value returned by a function.
     */
    @Test
    public void demo03() {
        CompletableFuture<String> cf = CompletableFuture.supplyAsync(() -> "Hello");
        CompletableFuture<String> future = cf.thenApply(s -> s + "World");

        try {
            System.out.println(future.get());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * thenAccept method receives a Consumer(no return) and passes
     * the result of the computation
     */
    @Test
    public void demo04() {
        CompletableFuture<String> cf = CompletableFuture.supplyAsync(() -> "Hello");
        CompletableFuture<Void> future = cf
                .thenAccept(s -> System.out.println("Computation returned: " + s));

        try {
            future.get();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * If we neither need the value of the computation
     * nor want to return some value at the end of the chain
     * then we can pass a Runnable lambda to the thenRun method
     */
    @Test
    public void demo05() {
        CompletableFuture<String> cf = CompletableFuture.supplyAsync(() -> "Hello");
        CompletableFuture<Void> future = cf
                .thenRun(() -> System.out.println("Computation finished."));

        try {
            future.get();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Using thenCompose method to chain two Futures sequentially.
     * The thenApply and the thenCompose methods are closely related to the map and flatMap methods of Stream
     * Cause supplyAsync will return a CompletableFuture object,
     * If we use a.thenCompose(b), we will get the content out from b to add to a.
     * If we use a.thenSupply(b), we will replace the content in a with b.
     */
    @Test
    public void demo06() {
        CompletableFuture<String> f1 = CompletableFuture
                .supplyAsync(() -> "Hello")
                .thenCompose(s -> CompletableFuture.supplyAsync(() -> s + "World"));
        CompletableFuture<CompletableFuture<String>> f2 = CompletableFuture
                .supplyAsync(() -> "Hello")
                .thenApply(s -> CompletableFuture.supplyAsync(() -> s + "World"));

        try {
            System.out.println(f1.get());

            System.out.println(f2.get());
            System.out.println(f2.get().get());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Using the thenCombine method to execute two independent Futures and do something
     * with their results and return the final result
     */
    @Test
    public void demo07() {
        CompletableFuture<String> cf = CompletableFuture
                .supplyAsync(() -> {
                    System.out.println("1");
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    System.out.println("2");
                    return "Hello";
                })
                .thenCombine(
                        CompletableFuture.supplyAsync(() -> {
                            System.out.println("3");
                            return "World";}),
                        (s1, s2) -> s1 + s2
                );

        try {
            System.out.println(cf.get());
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
    }

    /**
     * Using thenAcceptBoth to execute two independent Futures and do something
     * with their results but don't pass any result
     */
    @Test
    public void demo08() {
        CompletableFuture<Void> future = CompletableFuture.supplyAsync(() -> "Hello")
                .thenAcceptBoth(CompletableFuture.supplyAsync(() -> "World"),
                        (s1, s2) -> System.out.println(s1 + s2));
    }

    /**
     * CompletableFuture.allOf() static method allows waiting for completion of all Futures
     */
    @Test
    public void demo09() {
        CompletableFuture<String> f1 = CompletableFuture.supplyAsync(() -> "Hello"),
                f2 = CompletableFuture.supplyAsync(() -> "Beautiful"),
                f3 = CompletableFuture.supplyAsync(() -> "World");

        // If we need to use a List as the argument of allOf(), we need to convert it to an array.
        CompletableFuture<Void> cf = CompletableFuture.allOf(f1, f2, f3);

        try {
            cf.get();

            assertTrue(f1.isDone());
            assertTrue(f2.isDone());
            assertTrue(f3.isDone());
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
    }

    /**
     * CompletableFuture.join() method is similar to the get method, but it throws an unchecked exception.
     * This makes it possible to use it as a method reference in the Stream.map().
     * This is a method that blocks the current thread and waits for the completion of the CompletableFuture instance it is called on.
     */
    @Test
    public void demo10() {
        CompletableFuture<String> f1 = CompletableFuture.supplyAsync(() -> "Hello"),
                f2 = CompletableFuture.supplyAsync(() -> "Beautiful"),
                f3 = CompletableFuture.supplyAsync(() -> "World");

        CompletableFuture<Void> cf = CompletableFuture.allOf(f1, f2, f3);

        try {
            String combined = Stream.of(f1, f2, f3)
                    .map(CompletableFuture::join)
                    .collect(Collectors.joining(" "));

            System.out.println(combined);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Handling Errors
     */
    @Test
    public void demo11() {
        CompletableFuture<Integer> cf = CompletableFuture.supplyAsync(() -> {
            System.out.println("111");
            return 1;
        }).handle((f, e) -> {
            int i = 10 / 0;
            System.out.println("222");
            return f + 2;
        }).handle((f, e) -> {
            System.out.println("333");
            return f + 3;
        }).whenComplete((v, e) -> {
            System.out.println("complete");
            if (e == null) {
                System.out.println("calculate result: " + v);
            }
        }).exceptionally(e -> {
            e.printStackTrace();
            System.out.println("exceptionally: " + e.getMessage());
            return null;
        });

        try {
            System.out.println(cf.get());
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
    }
}
