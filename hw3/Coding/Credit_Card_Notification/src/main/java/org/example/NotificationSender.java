package org.example;

public class NotificationSender {
    public static void sendNotification(User user, String message) {
        try {
            Notification notification = NotificationFactory.createNotification(user.getPreference());
            if ("email".equals(user.getPreference())) {
                notification.send(user.getEmail(), message);
            } else if ("sms".equals(user.getPreference())) {
                notification.send(user.getPhone(), message);
            } else if ("whatsapp".equals(user.getPreference())) {
                notification.send(user.getPhone(), message);
            }
        } catch (NotificationException e) {
            // Handle error appropriately
            e.printStackTrace();
        }
    }
}
