package com.chuwa.learn.credit_card_notification;

import java.util.ArrayList;
import java.util.List;

public interface Subject {
    void attach(Observer observer);
    void detach(Observer observer);
    void notifyAll(String message);
}

class CreditCardSubject implements Subject {
    List<Observer> observers = new ArrayList<>();

    NotificationFactory emailNotificationFactory = new EmailNotificationFactory();
    NotificationFactory whatsappNotificationFactory = new WhatsappNotificationFactory();
    NotificationFactory smsNotificationFactory = new SMSNotificationFactory();

    @Override
    public void attach(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void detach(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyAll(String message) {
        for (Observer observer : observers) {
            Notification notification = null;

            if (observer.getPreference() == NotificationPreference.EMAIL) {
                notification = emailNotificationFactory.createNotification();
            } else if (observer.getPreference() == NotificationPreference.SMS) {
                notification = smsNotificationFactory.createNotification();
            } else if (observer.getPreference() == NotificationPreference.WHATSAPP) {
                notification = whatsappNotificationFactory.createNotification();
            } else {
                throw new RuntimeException("Cannot match the preference");
            }

            observer.update(message, notification);
        }
    }
}