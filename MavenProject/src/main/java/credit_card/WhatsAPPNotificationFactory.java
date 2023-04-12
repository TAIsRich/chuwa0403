package credit_card;

import static credit_card.NotificationType.*;

public class WhatsAPPNotificationFactory implements NotificationFactory {

    @Override
    public Notification generateAndSendNotification() {
        return new EmailNotification(WHATSAPP);
    }
}
