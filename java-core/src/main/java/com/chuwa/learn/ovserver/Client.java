package com.chuwa.learn.ovserver;

public class Client {
    public static void main(String[] args) {
        SubscriptionSubject subject = new SubscriptionSubject();

        subject.attach(new WeiXinUser("Jerry"));
        subject.attach(new WeiXinUser("Tom"));
        subject.attach(new WeiXinUser("Mark"));

        subject.notify("hello");
    }
}
