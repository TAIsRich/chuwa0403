package com.mycompany.app;

class EmailSubscriber implements Subscriber {
    private String name;

    public EmailSubscriber(String name) {
        this.name = name;
    }

    @Override
    public void update(String message) {
        System.out.println("[" + name + "] Received message: " + message);
    }
}
