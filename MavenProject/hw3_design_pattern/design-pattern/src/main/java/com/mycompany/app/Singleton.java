package com.mycompany.app;

public class Singleton {

    private static Singleton instance = null;

    private Singleton() {
        // Private constructor to prevent instantiation from outside the class
    }

    public static Singleton getInstance() {
        if (instance == null) {
            synchronized(Singleton.class) {
                if (instance == null) {
                    instance = new Singleton();
                }
            }
        }
        return instance;
    }

    // Other methods of the singleton class
}