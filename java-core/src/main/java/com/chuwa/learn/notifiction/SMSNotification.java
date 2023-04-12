package com.chuwa.learn.notifiction;

// SMS notification implementation
public class SMSNotification implements NotificationPreference {
    @Override
    public void notifyUser(User user, String message) {
        System.out.println("Sending SMS to " + user.getPhoneNumber());
        System.out.println("Message: " + message);
        System.out.println(" ");
    }
}
