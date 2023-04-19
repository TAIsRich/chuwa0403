package com.richard.java8.default_interface_method;

/**
 * @Author zhuhaotian
 * @Date 2023/4/15
 */

public interface DIM {

    static final String BLOG = "Java8 New Features Exercise";

    int add(int a, int b);

    default int sub(int a, int b) {
        return a - b;
    }

    static String getBlog() {
        return BLOG;
    }

}
