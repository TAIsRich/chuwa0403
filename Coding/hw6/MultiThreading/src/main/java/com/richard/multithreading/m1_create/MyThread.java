package com.richard.multithreading.m1_create;

/**
 * @Author zhuhaotian
 * @Date 2023/4/18
 */

public class MyThread extends Thread {
    @Override
    public void run() {
        System.out.println("start new thread using extends thread");
    }
}
