package com.richard.java8.default_interface_method;

/**
 * @Author zhuhaotian
 * @Date 2023/4/15
 */

public class Client {

    public static void main(String[] args) {

        DIMImpl dim = new DIMImpl();
        System.out.println("Override Method: " + dim.add(1, 2));
        System.out.println("Default Method: " + dim.sub(2, 1));
        System.out.println("Static Method: " + DIM.getBlog());

    }

}
