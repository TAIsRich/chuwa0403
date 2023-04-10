package com.chuwa.learn.DesignPattern;

public class WhatsappNotification implements Notification{
    @Override
    public void send(String message, String receiver) {
        System.out.println("send Whatsapp notification to: " + receiver + ": " + message);
    }
}
