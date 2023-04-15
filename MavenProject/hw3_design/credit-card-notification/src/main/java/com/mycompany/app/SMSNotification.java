package com.mycompany.app;

public class SMSNotification implements NotificationStrategy {
    public void sendNotification(User user) {
        // Code to send SMS notification
        System.out.println("Sending SMS notification to " + user.firstName + " at " + user.email);
    }
}