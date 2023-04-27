package com.richard.multithreading.m1_create;

import java.util.concurrent.Callable;

/**
 * @Author zhuhaotian
 * @Date 2023/4/18
 */

public class MyCallable implements Callable<String> {
    @Override
    public String call() throws Exception {
        Thread.sleep(5000);
        return "Start new thread using Callable";
    }
}
