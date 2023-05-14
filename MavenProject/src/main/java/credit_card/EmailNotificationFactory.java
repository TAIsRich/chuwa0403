package credit_card;

import static credit_card.NotificationType.*;

public class EmailNotificationFactory implements NotificationFactory{

    @Override
    public Notification generateAndSendNotification() {
        return new EmailNotification(EMAIL);
    }
}
