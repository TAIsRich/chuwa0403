package com.chuwa.learn.springbasic.components.impl;

import com.chuwa.learn.springbasic.components.JpaChuwa;

//no @Component, so Spring don't add it to IOC container

public class DataNucleusChuwaNoComponent implements JpaChuwa {

    @Override
    public void printMessage() {
        System.out.println("Message from " + getClass().getName() + " - No @Component. By @Bean!");
    }
}
