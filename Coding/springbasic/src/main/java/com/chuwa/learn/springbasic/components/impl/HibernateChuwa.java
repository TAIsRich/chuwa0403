package com.chuwa.learn.springbasic.components.impl;

import com.chuwa.learn.springbasic.components.JpaChuwa;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
//@Primary
public class HibernateChuwa implements JpaChuwa {

    @Override
    public void printMessage() {
        System.out.println("Message from " + getClass().getName());
    }
}
