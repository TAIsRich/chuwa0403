package com.chuwa.learn.DesignPattern;

public class SMSNotification implements Notification{
    @Override
    public void send(String message, String receiver) {
        System.out.println("send SMS notification to: " + receiver + ": " + message);
    }
}
