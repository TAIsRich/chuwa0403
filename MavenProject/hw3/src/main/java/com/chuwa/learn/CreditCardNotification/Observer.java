package com.chuwa.learn.CreditCardNotification;

public interface Observer {
    void update(String message);

    Preference getPreference();

    String getName();
}

class User implements Observer {
    private final String name;
    private final Preference preference;

    public User(String name, Preference preference) {
        this.name = name;
        this.preference = preference;
    }


    @Override
    public void update(String message) {
        System.out.println(message);
    }

    @Override
    public Preference getPreference() {
        return preference;
    }

    @Override
    public String getName() {
        return name;
    }
}