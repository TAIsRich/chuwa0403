package org.example;

public class User {
    private final String firstName;
    private final String lastName;
    private final String email;
    private final String phone;
    private final String preference;


    User(Builder builder) {
        this.firstName = builder.firstName;
        this.lastName = builder.lastName;
        this.email = builder.email;
        this.phone = builder.phone;
        this.preference = builder.preference;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public String getPreference() {
        return preference;
    }


    public static class Builder {
        private String firstName;
        private String lastName;
        private String email;
        private String phone;
        private String preference;

//        public Builder(String firstName, String lastName, String email, String phone) {
//            this.firstName = firstName;
//            this.lastName = lastName;
//            this.email = email;
//            this.phone = phone;
//        }


        public Builder firstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public Builder lastName(String lastName) {
            this.lastName = lastName;
            return this;
        }
        public Builder email(String email) {
            this.email = email;
            return this;
        }

        public Builder phone(String phone) {
            this.phone = phone;
            return this;
        }

        public Builder preference(String preference) {
            this.preference = preference;
            return this;
        }

        public User build() {
            return new User(this);
        }
    }
}

