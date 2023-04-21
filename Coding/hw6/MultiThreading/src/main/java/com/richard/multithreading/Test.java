package com.richard.multithreading;

/**
 * @Author zhuhaotian
 * @Date 2023/4/19
 */

public class Test {
    public static void main(String[] args) {
        Thread thread1 = new Thread(new MyThread());
        Thread thread2 = new Thread(new MyThread());
        thread1.start();
        thread2.start();
    }
}

class MyThread implements Runnable {
    @Override
    public void run() {
        for (int i = 1; i <= 10; i++) {
            System.out.println("Thread " + Thread.currentThread().getId() + ": " + i);
            Thread.yield();
        }
    }
}

