package MavenProject.src.creditCard;

import java.util.ArrayList;
import java.util.List;

public class SubjectSubscription implements Subject{
    List<MavenProject.src.creditCard.Observer> observers = new ArrayList<>();
    NotificationFactory notificationFactory = new NotificationFactory();

    @Override
    public void attach(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void detach(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notify(String message) {
        for (Observer o : observers) {
            Notification notification;
            if (o.getPreference().equals("email"))
                notification = new EmailNotification();
            else if (o.getPreference().equals("sms"))
                notification = new SmsNotification();
            else if (o.getPreference().equals("whatsapp"))
                notification = new WhatsappNotification();
            else
                throw new RuntimeException("No such method");

            o.update(message, notification);
        }
    }
}
