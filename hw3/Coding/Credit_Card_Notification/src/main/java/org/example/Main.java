package org.example;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<User> users = getUsersFromDatabase();
        User user_1 = users.get(0);

        String message = "Hey " + user_1.getFirstName() + ", you have successfully registered to add and here is your , please use this for future references.";
        NotificationSender.sendNotification(user_1, message);

        // Broadcast public notification to all users
        String publicMessage = "40% off when you buy Popeyes between 06/13 - 06/19";
        for (User user : users) {
            NotificationSender.sendNotification(user, publicMessage);
        }
    }

    private static List<User> getUsersFromDatabase() {
        List<User> users = new ArrayList<>();
        User user_1 = new User.Builder()
                .firstName("user1_first")
                .lastName("user1_last")
                .email("user1@abc.com")
                .preference("email")
                .build();
        User user_2 = new User.Builder()
                .firstName("user2_first")
                .lastName("user2_last")
                .phone("xxx-xxx-xxxx")
                .preference("sms")
                .build();
        User user_3 = new User.Builder()
                .firstName("user3_first")
                .lastName("user3_last")
                .phone("xxx-xxx-xxxx")
                .preference("whatsapp")
                .build();
        users.add(user_1);
        users.add(user_2);
        users.add(user_3);

        return users;
    }
}