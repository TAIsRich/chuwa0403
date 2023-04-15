package org.example;

public class EmailNotification implements Notification {
    @Override
    public void send(String to, String message) throws NotificationException {
        // Code to send email
        System.out.println("Sent email to " + to + " with message: " + message);
    }
}
