package org.example;

public class SMSNotification implements Notification {
    @Override
    public void send(String to, String message) throws NotificationException {
        // Code to send SMS
        System.out.println("Sent SMS to " + to + " with message: " + message);
    }
}
