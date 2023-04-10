package org.example;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
    }
}

// Java code to create singleton class by
// Eager Initialization
// 饿汉式-静态常量（可用）
class Eager1 {
    // public instance initialized when loading the class
    private static final Eager1 instance = new Eager1();

    private Eager1() {
        // private constructor
    }
    public static Eager1 getInstance() {
        return instance;
    }
}

// Java code to create singleton class
// Using Static block
// 饿汉式-静态代码块（可用）
class Eager2 {
    // public instance
    public static Eager2 instance;

    private Eager2() {
        // private constructor
    }
    static {
        // static block to initialize instance
        instance = new Eager2();
    }
}

//Java Code to create singleton class
// With Lazy initialization
// 懒汉式-线程不安全（不可用）
class Lazy1 {
    // private instance, so that it can be
    // accessed by only by getInstance() method
    private static Lazy1 instance;

    private Lazy1() {
        // private constructor
    }

    //method to return instance of class
    public static Lazy1 getInstance() {
        if (instance == null) {
            // if instance is null, initialize
            instance = new Lazy1();
        }
        return instance;
    }
}

// Java program to create Thread Safe
// Singleton class
// 懒汉式——线程安全，同步方法（不推荐用）
class Lazy2 {
    // private instance, so that it can be
    // accessed by only by getInstance() method
    private static Lazy2 instance;

    private Lazy2() {
        // private constructor
    }

    //synchronized method to control simultaneous access
    synchronized public static Lazy2 getInstance() {
        if (instance == null) {
            // if instance is null, initialize
            instance = new Lazy2();
        }
        return instance;
    }
}

// Java code to explain double check locking
// 懒汉式——双重检查, 线程安全（可用）
class Lazy3 {
    // private instance, so that it can be
    // accessed by only by getInstance() method
    private static Lazy3 instance;

    private Lazy3() {
        // private constructor
    }

    public static Lazy3 getInstance() {
        if (instance == null) {
            //synchronized block to remove overhead
            synchronized (Lazy3.class) {
                if(instance==null) {
                    // if instance is null, initialize
                    instance = new Lazy3();
                }

            }
        }
        return instance;
    }
}