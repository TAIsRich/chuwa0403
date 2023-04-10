package com.chuwa.learn.CreditCardNotification;

import java.util.ArrayList;
import java.util.List;

public interface Subject {
    void notifyAll(String message);

    void attach(Observer observer);

    //void notifyRegister(String message);
}

class CreditCardSubject implements Subject {
    List<Observer> observers = new ArrayList<>();

    NotificationFactory emailNotificationFactory = new EmailNotificationFactory();
    NotificationFactory whatsappNotificationFactory = new WhatsAppNotificationFactory();
    NotificationFactory smsNotificationFactory = new SMSNotificationFactory();

    @Override
    public void attach(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void notifyAll(String message) {
        Notification notification = null;
        for (Observer observer : observers) {
            if (observer.getPreference() == Preference.EMAIL) {
                notification = emailNotificationFactory.makeNotification();
            } else if (observer.getPreference() == Preference.SMS) {
                notification = smsNotificationFactory.makeNotification();
            } else if (observer.getPreference() == Preference.WHATSAPP) {
                notification = whatsappNotificationFactory.makeNotification();
            } else {
                throw new RuntimeException("Cannot match the preference");
            }
            notification.sendMessage(message, observer.getName());
        }
    }

//    @Override
//    public void notifyAll(String message) {
//        Notification notification = null;
//        for (Observer observer : observers) {
//            if (observer.getPreference() == Preference.EMAIL) {
//                notification = emailNotificationFactory.makeNotification();
//            } else if (observer.getPreference() == Preference.SMS) {
//                notification = smsNotificationFactory.makeNotification();
//            } else if (observer.getPreference() == Preference.WHATSAPP) {
//                notification = whatsappNotificationFactory.makeNotification();
//            } else {
//                throw new RuntimeException("Cannot match the preference");
//            }
//            notification.sendMessage(message, observer.getName());
//        }
//    }


}
