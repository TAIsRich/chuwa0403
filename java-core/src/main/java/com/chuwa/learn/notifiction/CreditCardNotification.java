package com.chuwa.learn.notifiction;

import java.util.ArrayList;
import java.util.List;

public class CreditCardNotification {
    public static void main(String[] args) {
        NotificationFactory notificationFactory = new NotificationFactory();
        NotificationSender notificationSender = new NotificationSender(notificationFactory);

        List<User> users = new ArrayList<>();
        users.add(new User("John", "Doe", "johndoe@gmail.com", "555-123-4567","EMAIL"));
        users.add(new User("Jane", "Smith", "janesmith@yahoo.com", "555-987-6543","SMS"));
        users.add(new User("Bob", "Johnson", "bjohnson@hotmail.com", "555-555-5555","WHATSAPP"));

        // Notify individual users based on preference
        String message = "Hey %s, you have successfully registered to add and here is your %s, please use this for future references.";
        for (User user : users) {
            String notificationMessage = String.format(message, user.getFirstName(), "credit card");
            notificationSender.sendNotification(user, notificationMessage, user.getNotificationPreference());
        }

        // Broadcast public notification to all users
        message = "40% off when you buy Popeyes between 06/13 - 06/19";
        for (User user : users) {
            notificationSender.sendNotification(user, message, user.getNotificationPreference());
        }
    }
}

