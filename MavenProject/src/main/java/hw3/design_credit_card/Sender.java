package hw3.design_credit_card;

public class Sender {
    private NotificationFactory facotry;

    public void SetFactory(NotificationFactory facotry){
        this.facotry = facotry;
    }

    public Notification sendNotification(String content){
        Notification notification =  facotry.createNotification();
        notification.addContent(content);

        return notification;
    }
}
