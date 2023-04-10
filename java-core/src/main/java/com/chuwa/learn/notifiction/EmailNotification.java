package com.chuwa.learn.notifiction;

// Email notification implementation
public class EmailNotification implements NotificationPreference {
    @Override
    public void notifyUser(User user, String message) {
        System.out.println("Sending email to " + user.getEmail());
        System.out.println("Message: " + message);
        System.out.println(" ");
    }
}
