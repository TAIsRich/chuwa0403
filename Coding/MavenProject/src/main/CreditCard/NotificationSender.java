package CreditCard;

public class NotificationSender {
    private NotificationFactory notificationFactory = new NotificationFactory();

    public void sendNotification(User user, String message) {
        NotificationType notificationType = user.getNotificationPreference();
        try {
            Notification notification = notificationFactory.createNotification(notificationType);
            notification.sendNotification(user, message);
        } catch (IllegalArgumentException e) {
            System.out.println("Invalid notification type: " + notificationType);
        }
    }
}
