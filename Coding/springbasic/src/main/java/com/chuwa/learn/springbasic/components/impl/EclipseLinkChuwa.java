package com.chuwa.learn.springbasic.components.impl;

//Bean名默认是class名,首字母小写

import com.chuwa.learn.springbasic.components.JpaChuwa;
import org.springframework.stereotype.Component;

@Component
public class EclipseLinkChuwa implements JpaChuwa {

    @Override
    public void printMessage() {
        System.out.println("Message from " + getClass().getName());
    }
}
