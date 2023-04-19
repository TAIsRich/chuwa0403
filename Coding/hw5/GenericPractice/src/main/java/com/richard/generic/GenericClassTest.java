package com.richard.generic;

import java.security.spec.RSAOtherPrimeInfo;

public class GenericClassTest {

    public static void main(String[] args) {

        // Integer Type
        GenericClass<Integer> obj1 = new GenericClass<>(1);
        System.out.println(obj1.getObj());

        // Double Type
        GenericClass<Double> obj2 = new GenericClass<>(2.33);
        System.out.println(obj2.getObj());

        // String Type
        GenericClass<String> obj3 = new GenericClass<>("3");
        System.out.println(obj3.getObj());

    }
}
