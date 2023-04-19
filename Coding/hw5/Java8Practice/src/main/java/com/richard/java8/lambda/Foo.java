package com.richard.java8.lambda;

@FunctionalInterface
public interface Foo {

    String aMethod(String s);

    default String defaultBar() {

        String s = "Default Bar Method From Foo.";
        System.out.println(s);

        return s;

    }

    default String defaultCommon() {

        String s = "Default Common from Bar From Foo.";
        System.out.println(s);

        return s;

    }

    static void staticMethod() {
        System.out.println("Static Method from Foo.");
    }

}
