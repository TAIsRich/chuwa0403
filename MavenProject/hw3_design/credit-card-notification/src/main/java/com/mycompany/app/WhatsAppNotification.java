package com.mycompany.app;

public class WhatsAppNotification implements NotificationStrategy {
    public void sendNotification(User user) {
        // Code to send WhatsApp notification
        System.out.println("Sending WhatsApp notification to " + user.firstName + " at " + user.email);
    }
}