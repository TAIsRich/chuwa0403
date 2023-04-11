package credit_card;

public class NotificationSender {
    private NotificationFactory notificationFactory;

    public void setContentFactory(ContentFactory contentFactory) {
        this.contentFactory = contentFactory;
    }

    private ContentFactory contentFactory;

    public void setFactory(NotificationFactory factory) {notificationFactory = factory;}


    public void sendNotificationToUser(User user) {
        Notification notification = notificationFactory.generateAndSendNotification();
        Content content = contentFactory.generateContent(user);
        sendNotification(user, content, notification);
    }

    private void sendNotification(User user, Content content, Notification notification) {
        System.out.println("Send notification to " + user.getName());
    }
}
