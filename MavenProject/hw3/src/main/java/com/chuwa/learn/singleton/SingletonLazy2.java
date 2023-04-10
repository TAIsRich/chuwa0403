package com.chuwa.learn.singleton;

public class SingletonLazy2 {
    private SingletonLazy2() {}

    //volatile防止指令重排序。
    private volatile static SingletonLazy2 instance;

    public static SingletonLazy2 getInstance() {
        if (instance == null) {
            synchronized (SingletonLazy2.class) {
                if (instance == null) {
                    instance = new SingletonLazy2();
                }
            }
        }

        return instance;
    }
}
