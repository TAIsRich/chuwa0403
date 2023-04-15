package org.example;

public class WhatsAppNotification implements Notification {
    @Override
    public void send(String to, String message) throws NotificationException {
        // Code to send WhatsApp message
        System.out.println("Sent WhatsApp message to " + to + " with message: " + message);
    }
}
