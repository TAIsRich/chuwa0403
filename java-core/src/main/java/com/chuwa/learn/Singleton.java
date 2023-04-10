package com.chuwa.learn;

import com.sun.xml.internal.bind.v2.runtime.unmarshaller.XsiNilLoader;

//饿汉式：静态成员变量
public class Singleton {
    private Singleton() {}
    private static Singleton instance = new Singleton();
    public static Singleton getInstance() {
        return instance;
    }
}
