package com.chuwa.learn.singleton;

public class Client {
    public static void main(String[] args) {
        SingletonEager1 singleton = SingletonEager1.getInstance();
        SingletonEager2 singleton2 = SingletonEager2.getInstance();
    }
}
