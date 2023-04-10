package org.example;

public class Main {
    public static void main(String[] args) {
        User user1 = new User.Builder()
                .firstName("first")
                .lastName("last")
                .email("xxx@xxx.com")
                .phone("xxx-xxx-xxxx")
                .preference("email")
                .build();
    }
}