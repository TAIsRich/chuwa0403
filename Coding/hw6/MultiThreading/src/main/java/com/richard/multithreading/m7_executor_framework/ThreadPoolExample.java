package com.richard.multithreading.m7_executor_framework;

import org.junit.Test;

import java.util.concurrent.*;

/**
 * @Author zhuhaotian
 * @Date 2023/4/20
 */

public class ThreadPoolExample {

    @Test
    public void fixedThreadPool() {
        ExecutorService es = Executors.newFixedThreadPool(5);

        for (int i = 0; i < 10; i++) {
            int taskId = i + 1;
            es.submit(() ->
                    System.out.println("Task " + taskId + " is running on thread " + Thread.currentThread().getName()));
        }

        es.shutdown();
    }

    @Test
    public void singleThreadExecutorExample() {
        ExecutorService es = Executors.newSingleThreadExecutor();

        for (int i = 0; i < 10; i++) {
            int taskId = i + 1;
            es.submit(() ->
                    System.out.println("Task " + taskId + " is running on thread " + Thread.currentThread().getName()));
        }

        es.shutdown();
    }

    /**
     * 使用ThreadPoolExecutor手动创建线程池可以让您更好地控制线程池的配置
     * 设置了线程池的核心和最大线程数，保持活动时间和时间单位，以及任务队列的容量。
     * 然后，我们将Lambda表达式作为任务提交给线程池来执行。
     * 最后，我们关闭线程池以确保所有任务在应用程序退出之前完成。
     *
     * 通过手动创建线程池，可以更好地控制线程池的参数，
     * 例如核心线程数、最大线程数、保持活动时间、任务队列等。
     * 这使您能够根据应用程序的需求和性能要求进行精细的调整。
     */
    @Test
    public void customThreadPoolExample() {
        int corePoolSize = 5;
        int maximumPoolSize = 5;
        long keepAliveTime = 0L;
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        int queueCapacity = 100;

        ThreadPoolExecutor es = new ThreadPoolExecutor(
                corePoolSize,
                maximumPoolSize,
                keepAliveTime,
                timeUnit,
                new ArrayBlockingQueue<>(queueCapacity)
        );

        for (int i = 0; i < 10; i++) {
            int taskId = i + 1;
            es.submit(() ->
                    System.out.println("Task " + taskId + " is running on thread " + Thread.currentThread().getName()));
        }

        es.shutdown();
    }
}
