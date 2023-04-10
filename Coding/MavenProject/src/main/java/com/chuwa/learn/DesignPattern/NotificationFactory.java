package com.chuwa.learn.DesignPattern;

public class NotificationFactory {
    public static Notification createNotification(String type) {
        if (type == null) {
            throw new IllegalArgumentException("type cannot be null");
        }

        switch (type) {
            case "email":
                return new EmailNotification();
            case "SMS":
                return new SMSNotification();
            case "WhatsAPP":
                return new WhatsappNotification();
            default:
                throw new IllegalArgumentException("Invalid notification type: " + type);
        }
    }
}
