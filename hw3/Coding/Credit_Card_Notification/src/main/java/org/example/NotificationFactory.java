package org.example;

public class NotificationFactory {
    public static Notification createNotification(String preference) throws NotificationException {
        switch (preference) {
            case "email":
                return new EmailNotification();
            case "sms":
                return new SMSNotification();
            case "whatsapp":
                return new WhatsAppNotification();
            default:
                throw new NotificationException("Invalid notification preference: " + preference);
        }
    }
}
