package com.richard.simplefactory;

/**
 * @Author zhuhaotian
 * @Date 2023/5/1
 */

public abstract class Coffee {

    public abstract String getName();

    public void addSugar() {
        System.out.println("Add Sugar");
    }

    public void addMilk() {
        System.out.println("Add Milk");
    }
}
