package com.chuwa.learn.ovserver;

public interface Subject {
    void attach(Observer observer);
    void detach(Observer observer);
    void notify(String message);
}
