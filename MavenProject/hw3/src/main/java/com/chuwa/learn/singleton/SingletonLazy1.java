package com.chuwa.learn.singleton;

public class SingletonLazy1 {
    private SingletonLazy1() {};
    private static SingletonLazy1 instance;
    private static synchronized SingletonLazy1 getInstance() {
        if (instance == null) {
            instance = new SingletonLazy1();
        }

        return instance;
    }
}
