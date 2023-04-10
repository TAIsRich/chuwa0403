package com.chuwa.learn.pubsub;

import java.util.Observable;
import java.util.Observer;

public class WechatUser implements Observer {
    private Subject name;

    public WechatUser(Subject name) {
        this.name = name;
    }

    @Override
    public void update(Observable o, Object arg) {

    }

//    @Override
//    public void update(String message) {
//        System.out.println(name + " " + message);
//    }
}
