package com.chuwa.learn.Singleton.EagerLoad2;

public class Singleton {

    private Singleton(){

    }
    private static Singleton instance;

    //静态代码块赋值
    static {
        instance = new Singleton();
    }

    public static Singleton getInstance(){
        return instance;
    }
}
