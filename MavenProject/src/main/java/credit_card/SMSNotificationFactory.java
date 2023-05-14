package credit_card;

import static credit_card.NotificationType.SMS;

public class SMSNotificationFactory implements NotificationFactory{
    @Override
    public Notification generateAndSendNotification() {
        return new SMSNotification(SMS);
    }
}
