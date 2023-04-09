package com.mycompany.app;

public class EmailNotification implements NotificationStrategy {
    public void sendNotification(User user) {
        // Code to send email notification
        System.out.println("Sending email notification to " + user.firstName + " at " + user.email);
    }
}