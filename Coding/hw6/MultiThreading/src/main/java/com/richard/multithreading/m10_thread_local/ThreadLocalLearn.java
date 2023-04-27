package com.richard.multithreading.m10_thread_local;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Author zhuhaotian
 * @Date 2023/4/21
 */

public class ThreadLocalLearn {

    public static void main(String[] args) {
        MyData myData = new MyData();
        ExecutorService es = Executors.newFixedThreadPool(3);

        try {
            for (int i = 0; i < 3; i++) {
                es.submit(() -> {
                    try {
                        Integer beforeInt = myData.threadLocalField.get();
                        myData.add();
                        Integer afterInt = myData.threadLocalField.get();

                        System.out.println(Thread.currentThread().getName() + "\t" + "beforeInt:" + beforeInt + "\t afterInt: " + afterInt);
                    } finally {
                        /**
                         * The current thread's value for this thread-local variable must be removed,
                         * or it may cause memory leaks.
                         */
                        myData.threadLocalField.remove();
                    }
                });
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            es.shutdown();
        }
    }
}

class MyData {
    ThreadLocal<Integer> threadLocalField = ThreadLocal.withInitial(() -> 0);

    public void add() {
        threadLocalField.set(threadLocalField.get() + 1);
    }
}
