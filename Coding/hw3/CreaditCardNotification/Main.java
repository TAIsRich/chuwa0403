package CreaditCardNotification;

public class Main {
    public static void main(String[] args) {
        NotificationService notificationService = new NotificationService();

        User user1 = new User("Alice", "alice@example.com", "+1234567890", "email");
        User user2 = new User("Bob", "bob@example.com", "+0987654321", "sms");
        User user3 = new User("Charlie", "charlie@example.com", "+9876543210", "whatsapp");

        notificationService.registerObserver(user1);
        notificationService.registerObserver(user2);
        notificationService.registerObserver(user3);

        Notification notification = new Notification("email", "Hey " + user1.getFirstName() + ", you have successfully registered to add and here is your , please use this for future references.");

        notificationService.sendNotification(notification);

        Notification notification2 = new Notification("sms", "Hey " + user2.getFirstName() + ", you have successfully" +
                " registered to add and here is your , please use this for future references.");

        notificationService.sendNotification(notification2);

        Notification notification3 = new Notification("whatsapp", "Hey " + user3.getFirstName() + ", you have " +
                "successfully registered to add and here is your , please use this for future references.");

        notificationService.sendNotification(notification3);

        // broadcasting a public notification to all users
        Notification notification4 = new Notification("public", "40% off when you buy Popeyes between 06/13 - 06/19");

        notificationService.sendNotification(notification4);
    }
}