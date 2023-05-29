package com.mycompany.app;

public class NotificationFactory {
    public NotificationStrategy createNotification(String preference) throws Exception {
        if (preference.equals("email")) {
            return new EmailNotification();
        } else if (preference.equals("sms")) {
            return new SMSNotification();
        } else if (preference.equals("whatsapp")) {
            return new WhatsAppNotification();
        } else {
            throw new Exception("Invalid notification preference");
        }
    }
}