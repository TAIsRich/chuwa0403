package com.mycompany.app;

class SMSSubscriber implements Subscriber {
    private String name;

    public SMSSubscriber(String name) {
        this.name = name;
    }

    @Override
    public void update(String message) {
        System.out.println("[" + name + "] Received message: " + message);
    }
}