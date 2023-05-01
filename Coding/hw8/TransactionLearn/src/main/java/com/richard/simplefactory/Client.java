package com.richard.simplefactory;

/**
 * @Author zhuhaotian
 * @Date 2023/5/1
 */

public class Client {

    public static void main(String[] args) {
        CoffeeStore store = new CoffeeStore();

        Coffee american = store.orderCoffee("american");
        System.out.println(american.getName());

        System.out.println("***************************");

        Coffee latte = store.orderCoffee("latte");
        System.out.println(latte.getName());
    }
}
