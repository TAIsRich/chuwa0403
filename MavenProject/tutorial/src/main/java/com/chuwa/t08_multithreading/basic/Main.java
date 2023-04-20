package com.chuwa.t08_multithreading.basic;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class Main {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        Thread t = new MyThread();
        t.start();
        System.out.println("***********");

        Thread t2 = new Thread(new MyRunnable());
        t2.start();

        Thread t3 = new Thread(() -> System.out.println("lambda thread"));
        t3.start();

        Callable<String> callable = new MyCallable();
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        List<Future<String>> list = new ArrayList<>();
        Future<String> future = executorService.submit(callable);
        list.add(future);
        Future<String> stringFuture = list.get(0);
        for (int i = 0; i < 5; i++) {
            Thread.sleep(1000);
            String s = future.get();
            System.out.println(s);
        }

        executorService.shutdown();
    }
}
