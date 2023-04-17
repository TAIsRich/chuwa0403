package com.chuwa.learn.default_interface_method;

public class DIMLImpl implements DIML{
    /**
     * 只需要override add method, default method 不需要override, 不override也不会报错
     */
    @Override
    public int add(int a, int b) {
        return a+b;
    }
}
