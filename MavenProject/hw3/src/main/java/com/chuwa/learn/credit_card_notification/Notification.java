package com.chuwa.learn.credit_card_notification;

public interface Notification {
    void sendMessage(String message, String userName);
}

class EmailNotification implements Notification {
    private EmailNotification() {}

    private static class instanceHolder {
        private static final EmailNotification INSTANCE = new EmailNotification();
    }

    public static EmailNotification getInstance() {
        return instanceHolder.INSTANCE;
    }

    @Override
    public void sendMessage(String message, String userName) {
        System.out.println("Sending to " + userName + " via email: " + message);
    }
}

class WhatsappNotification implements Notification {

    private WhatsappNotification() {}

    private static class instanceHolder {
        private static final WhatsappNotification INSTANCE = new WhatsappNotification();
    }

    public static WhatsappNotification getInstance() {
        return instanceHolder.INSTANCE;
    }

    @Override
    public void sendMessage(String message, String userName) {
        System.out.println("Sending to " + userName + " via Whatsapp: " + message);
    }
}

class SMSNotification implements Notification {

    private SMSNotification() {}

    private static class instanceHolder {
        private static final SMSNotification INSTANCE = new SMSNotification();
    }

    public static SMSNotification getInstance() {
        return instanceHolder.INSTANCE;
    }

    @Override
    public void sendMessage(String message, String userName) {
        System.out.println("Sending to " + userName + " via SMS: " + message);
    }
}