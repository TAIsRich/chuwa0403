package CreditCard;

import java.util.ArrayList;
import java.util.List;

public class CreditCardNotification implements Subject{
    List<Observer> observers = new ArrayList<>();

    NotificationModuleFactory fac = new NotificationModuleFactory();

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
            NotificationModule notification = null;

            if ("email".equals(observer.getPreference())) {
                notification = NotificationModuleFactory.createNotificationModule(observer.getPreference());
            } else if ("sms".equals(observer.getPreference())) {
                notification = NotificationModuleFactory.createNotificationModule(observer.getPreference());
            } else if ("whatsapp".equals(observer.getPreference())) {
                notification = NotificationModuleFactory.createNotificationModule(observer.getPreference());
            } else {
                throw new RuntimeException("Cannot match the preference");
            }

            observer.update(message, notification);
        }
    }
}
