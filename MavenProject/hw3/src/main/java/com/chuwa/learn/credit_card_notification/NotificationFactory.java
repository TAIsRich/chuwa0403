package com.chuwa.learn.credit_card_notification;

public interface NotificationFactory {
    Notification createNotification();
}

class EmailNotificationFactory implements NotificationFactory {

    @Override
    public Notification createNotification() {
        return EmailNotification.getInstance();
    }
}

class WhatsappNotificationFactory implements NotificationFactory {

    @Override
    public Notification createNotification() {
        return WhatsappNotification.getInstance();
    }
}

class SMSNotificationFactory implements NotificationFactory {

    @Override
    public Notification createNotification() {
        return SMSNotification.getInstance();
    }
}