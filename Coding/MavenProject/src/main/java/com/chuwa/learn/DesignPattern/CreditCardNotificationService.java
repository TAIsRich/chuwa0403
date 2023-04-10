package com.chuwa.learn.DesignPattern;

import java.util.List;

public class CreditCardNotificationService {

    private List<CreditCardUser> users;
    public CreditCardNotificationService(List<CreditCardUser> users) {
        this.users = users;
    }

    public void sendNotification(String type, String message) {
        Notification notification = NotificationFactory.createNotification(type);

        for (CreditCardUser user : users) {
            String receiver = null;

            if (type.equals("email")) {
                receiver = user.getEmail();
            } else if (type.equals("SMS")) {
                receiver = user.getPhoneNumber();
            } else if (type.equals("WhatsAPP")) {
                receiver = user.getWhatsappNumber();
            }

            if (receiver != null) {
                notification.send(message, receiver);
            } else {
                System.out.println("Error: Unable to send notification to user " + user.getFirstName() + " " + user.getLastName() + " as preference does not match");
            }
        }
    }

    public void sendBroadcastNotification(String message) {
        System.out.println("Sending broadcast notification: " + message);
    }
}
