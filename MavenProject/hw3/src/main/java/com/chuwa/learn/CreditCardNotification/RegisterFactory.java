package com.chuwa.learn.CreditCardNotification;

public interface RegisterFactory {
    Register noticeRegister();
}

class EmailRegisterFactory implements RegisterFactory {

    @Override
    public Register noticeRegister(){
        return EmailRegister.getInstance();
    }
}

class WhatsAppRegisterFactory implements RegisterFactory {

    @Override
    public Register noticeRegister(){
        return WhatsAppRegister.getInstance();
    }
}

class SMSRegisterFactory implements RegisterFactory {

    @Override
    public Register noticeRegister(){
        return SMSRegister.getInstance();
    }
}

