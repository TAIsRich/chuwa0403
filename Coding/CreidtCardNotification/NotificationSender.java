package Coding.CreidtCardNotification;

import java.util.*;

public class NotificationSender {
    public static void main(String[] args) {
        List<User> userList = new LinkedList<>();
        NotificationFactory notificationFactory = new NotificationFactory();

        userList.add(new User("Rat", "Cai", "rat@gmail.com", "9096669860", "SMS"));
        userList.add(new User("Dog", "Cai", "rat@gmail.com", "9096669860", "EMAIL"));
        userList.add(new User("Cat", "Cai", "rat@gmail.com", "9096669860", "WHATSAPP"));

        // Create notification based on user preference
        for (User user : userList) {
            Notification notification = notificationFactory.createNotification(user.getPreference());
            // Send notification to user
            String message = "Hey " + user.getFirstName() + ", you have successfully registered to add and here is your confimation, please use this for future references.";
            notification.sendNotification(user, message);
        }
        
        // Broadcast public notification to all users
        String message = "40% off when you buy Popeyes between 06/13 - 06/19";
        for (User user : userList) {
            Notification notification = notificationFactory.createNotification(user.getPreference());
            notification.sendNotification(user, message);
        }
    }
}
