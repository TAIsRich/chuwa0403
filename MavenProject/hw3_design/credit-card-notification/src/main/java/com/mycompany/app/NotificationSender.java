package com.mycompany.app;

public class NotificationSender {
    private NotificationFactory factory;

    public NotificationSender() {
        factory = new NotificationFactory();
    }

    public void sendNotification(User user, String notification) {
        try {
            NotificationStrategy strategy = factory.createNotification(user.preference);
            user.getNotification(notification);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public void broadcastNotification(String message) {
        // Code to broadcast notification to all users
        System.out.println("Broadcasting notification: " + message);
    }
}



