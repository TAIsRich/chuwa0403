package Coding.hw6.multithreadingPractice.c01_create;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class Main {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        // use Thread
        Thread t1 = new MyThread();
        t1.start();
        System.out.println("~~~~~~~~~~~~~~~~");

        // use Runnable
        Thread t2 = new Thread(new MyRunnable());
        t2.start();
        System.out.println("~~~~~~~~~~~~~~~~");

        // use Runnable with lambda
        Thread t3 = new Thread(() -> System.out.println("start a thread with runnable using lambda"));
        t3.start();
        System.out.println("~~~~~~~~~~~~~~~~");

        // use Callable
        Callable<String> callable = new MyCallable();
        ExecutorService executor  = Executors.newFixedThreadPool(10);
        List<Future<String>> list = new ArrayList<>();
        Future<String> future = executor.submit(callable);
        list.add(future);

        executor.shutdown();
    }
}
