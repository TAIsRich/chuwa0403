package com.chuwa.learn.CreditCardNotification;

/**
 * Hey firstName, you have successfully registered to add and here is your , please use this for
 * future references.
 */
public interface Register {
    void registerMessage(String message, String firstName);
}

class EmailRegister implements Register {
    private EmailRegister () {}

    private static class instanceHolder {
        private static final EmailRegister  INSTANCE = new  EmailRegister();
    }

    public static EmailRegister  getInstance() {
        return instanceHolder.INSTANCE;
    }

    @Override
    public void registerMessage(String message, String firstName) {
        System.out.println( "Hey" + firstName + "you have successfully registered to add and here is your register notification, please use this for email notification");
    }
}

class WhatsAppRegister implements Register {
    private WhatsAppRegister() {}

    private static class instanceHolder {
        private static final WhatsAppRegister   INSTANCE = new  WhatsAppRegister();
    }

    public static WhatsAppRegister   getInstance() {
        return instanceHolder.INSTANCE;
    }

    @Override
    public void registerMessage(String message, String firstName) {
        System.out.println( "Hey" + firstName + "you have successfully registered to add and here is your register notification, please use this for whatsApp notification");
    }
}

class SMSRegister implements Register {
    private SMSRegister() {}

    private static class instanceHolder {
        private static final SMSRegister   INSTANCE = new  SMSRegister();
    }

    public static SMSRegister getInstance() {
        return instanceHolder.INSTANCE;
    }

    @Override
    public void registerMessage(String message, String firstName) {
        System.out.println( "Hey" + firstName + "you have successfully registered to add and here is your register notification, please use this for SMS notification");
    }
}

