package org.example;

public interface Notification {
    void send(String to, String message) throws NotificationException;
}
