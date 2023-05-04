package com.chuwa.t08_multithreading.basic;

public class MyThread extends Thread{
    @Override
    public void run() {
        System.out.println("new thread extends Thread");
    }
}
