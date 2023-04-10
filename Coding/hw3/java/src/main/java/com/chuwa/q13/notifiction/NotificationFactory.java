package com.chuwa.q13.notifiction;

public class NotificationFactory {
    public NotificationPreference createNotification(String preference) {
        switch (preference) {
            case "EMAIL":
                return new EmailNotification();
            case "SMS":
                return new SMSNotification();
            case "WHATSAPP":
                return new WhatsAPPNotification();
            default:
                throw new IllegalArgumentException("Invalid notification preference");
        }
    }
}
