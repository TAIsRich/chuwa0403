package com.chuwa.learn.DesignPattern;

public class EmailNotification implements Notification{
    @Override
    public void send(String message, String receiver) {
        System.out.println("send email notification to: " + receiver + ": " + message);
    }
}
