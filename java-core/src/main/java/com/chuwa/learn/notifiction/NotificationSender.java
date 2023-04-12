package com.chuwa.learn.notifiction;

public class NotificationSender {
    private NotificationFactory factory;

    public NotificationSender(NotificationFactory factory) {
        this.factory = factory;
    }

    public void sendNotification(User user, String message, String preference) {
        try {
            NotificationPreference notificationPreference = factory.createNotification(preference);
            notificationPreference.notifyUser(user, message);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            // handle the error appropriately when the preference given does not match
        }
    }

    public void broadcastNotification(String notificationContent) {
        // send the public notification to all the users
        // pass notificationContent to send broadcast notification
    }
}
