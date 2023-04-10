package com.chuwa.learn.CreditCardNotification;

public interface Notification {
    void sendMessage(String message, String userName);
}

class EmailMessage implements Notification {
    private EmailMessage () {}

    private static class instanceHolder {
        private static final EmailMessage INSTANCE = new  EmailMessage();
    }

    public static EmailMessage getInstance() {
        return instanceHolder.INSTANCE;
    }

    @Override
    public void sendMessage(String message, String userName) {
        System.out.println( "Hi" + userName);
        System.out.println( '\n' + message + "using email.");
    }
}

class WhatsAppMessage implements Notification {
    private WhatsAppMessage () {}

    private static class instanceHolder {
        private static final WhatsAppMessage INSTANCE = new  WhatsAppMessage();
    }

    public static WhatsAppMessage getInstance() {
        return instanceHolder.INSTANCE;
    }

    @Override
    public void sendMessage(String message, String userName) {
        System.out.println( "Hi" + userName);
        System.out.println( '\n' + message + "using WhatsApp.");
    }
}

class SMSMessage implements Notification {
    private SMSMessage () {}

    private static class instanceHolder {
        private static final SMSMessage INSTANCE = new  SMSMessage();
    }

    public static SMSMessage getInstance() {
        return instanceHolder.INSTANCE;
    }

    @Override
    public void sendMessage(String message, String userName) {
        System.out.println( "Hi" + userName);
        System.out.println( '\n' + message + "using SMS.");
    }
}



