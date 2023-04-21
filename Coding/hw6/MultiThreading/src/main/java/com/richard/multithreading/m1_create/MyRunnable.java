package com.richard.multithreading.m1_create;

/**
 * @Author zhuhaotian
 * @Date 2023/4/18
 */

public class MyRunnable implements Runnable {
    @Override
    public void run() {
        System.out.println("Start new thread using Runnable");
    }
}
