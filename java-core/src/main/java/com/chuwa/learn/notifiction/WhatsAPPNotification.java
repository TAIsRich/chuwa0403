package com.chuwa.learn.notifiction;

// WhatsAPP notification implementation
public class WhatsAPPNotification implements NotificationPreference{
    @Override
    public void notifyUser(User user, String message) {
        System.out.println("Sending WhatsAPP message to " + user.getPhoneNumber());
        System.out.println("Message: " + message);
        System.out.println(" ");
    }
}
