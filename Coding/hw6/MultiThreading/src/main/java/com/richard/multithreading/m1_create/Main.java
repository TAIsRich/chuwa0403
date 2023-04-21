package com.richard.multithreading.m1_create;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/**
 * @Author zhuhaotian
 * @Date 2023/4/18
 */

public class Main {

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        // NULL -> NEW
        Thread t = new MyThread(); // use extends thread
        // NEW -> RUNNABLE
        t.start(); // create a new thread then run the task in the new thread
        // t.run(); // run task in current process / thread
        System.out.println("***********");

        // Use implements Runnable
        Thread t2 = new Thread(new MyRunnable());
        t2.start();

        // Use lambda
        Thread t3 = new Thread(() -> System.out.println("Start new thread by implementing Runnable with lambda"));
        t3.start();

        // Use implements Callable
        // 1. new Callable Implementation class
        Callable<String> callable = new MyCallable();
        // Get ExecutorService from Executors utility class, thread pool size i s 10
        ExecutorService executor = Executors.newFixedThreadPool(10);
        // Create a list to hold the Future object associated with Callable
        List<Future<String>> list = new ArrayList<>();
        Future<String> future = executor.submit(callable);
        list.add(future);
        Future<String> stringFuture = list.get(0);

        for (int i = 0; i < 5; i++) {
            Thread.sleep(1000);
            String s = future.get();
            System.out.println(s);
        }

        executor.shutdown();
    }
}
