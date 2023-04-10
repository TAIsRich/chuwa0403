package com.chuwa.learn.CreditCardNotification;

public interface NotificationFactory {
    Notification makeNotification();
}

class EmailNotificationFactory implements NotificationFactory {

    @Override
    public Notification makeNotification() {
        return EmailMessage.getInstance();
    }
}

class WhatsAppNotificationFactory implements NotificationFactory {

    @Override
    public Notification makeNotification() {
        return WhatsAppMessage.getInstance();
    }
}

class SMSNotificationFactory implements NotificationFactory {

    @Override
    public Notification makeNotification() {
        return SMSMessage.getInstance();
    }
}
