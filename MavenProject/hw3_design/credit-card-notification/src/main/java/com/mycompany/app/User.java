// Builder design pattern
package com.mycompany.app;

public class User {
    private final String firstName;
    private final String lastName;
    private final int age;
    private final String email;
    private final String phoneNumber;
    private final String preference;
    private final List<String> notifications;

    private User(UserBuilder builder) {
        this.firstName = builder.firstName;
        this.lastName = builder.lastName;
        this.age = builder.age;
        this.email = builder.email;
        this.phoneNumber = builder.phoneNumber;
        this.preference = builder.preference;
        this.notifications = new ArrayList<>();
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getAge() {
        return age;
    }

    public String getEmail() {
        return email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getPreference() {
        return preference;
    }

    public void getNotification(String string) {
        notifications.add(string);
    }

    public static class UserBuilder {
        private final String firstName;
        private final String lastName;
        private int age;
        private String email;
        private String phoneNumber;
        private String preference;

        public UserBuilder(String firstName, String lastName) {
            this.firstName = firstName;
            this.lastName = lastName;
        }

        public UserBuilder age(int age) {
            this.age = age;
            return this;
        }

        public UserBuilder email(String email) {
            this.email = email;
            return this;
        }

        public UserBuilder phoneNumber(String phoneNumber) {
            this.phoneNumber = phoneNumber;
            return this;
        }

        public UserBuilder preference(String preference) {
            this.preference = preference;
            return this;
        }

        public User build() {
            return new User(this);
        }
    }
}
