package com.chuwa.learn.credit_card_notification;

public interface Observer {
    void update(String message, Notification notification);

    NotificationPreference getPreference();
}

class User implements Observer {
    private final String name;
    private final NotificationPreference preference;

    public User(String name, NotificationPreference preference) {
        this.name = name;
        this.preference = preference;
    }

    @Override
    public void update(String message, Notification notification) {
        notification.sendMessage(message, name);
    }

    @Override
    public NotificationPreference getPreference() {
        return preference;
    }
}