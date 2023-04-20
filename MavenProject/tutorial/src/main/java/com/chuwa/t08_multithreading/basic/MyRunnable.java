package com.chuwa.t08_multithreading.basic;

public class MyRunnable implements Runnable{
    @Override
    public void run() {
        System.out.println("new runnable thread");
    }
}
