package com.chuwa.learn.Observer;

public class Client {
    public static void main(String[] args) {
        SubscriptionSubject subject = new SubscriptionSubject();
        subject.attach(new WechatUser("Tom"));
        subject.attach(new WechatUser("Jerry"));
        subject.attach(new WechatUser("peach"));

        subject.notify("update");
    }
}
