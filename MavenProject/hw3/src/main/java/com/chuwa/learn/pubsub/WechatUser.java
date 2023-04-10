package com.chuwa.learn.pubsub;

public class WechatUser implements Observer{
    private Subject name;

    public WechatUser(Subject name) {
        this.name = name;
    }

    @Override
    public void update(String message) {
        System.out.println(name + " " + message);
    }
}
