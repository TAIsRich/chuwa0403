package com.chuwa.t06_java8.optional;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class OptionalDemo {
    public static void main(String[] args) {
        Map<Integer, User> userMap = new HashMap<>();
        userMap.put(1, new User("Alice", new Address("Main Street")));
        userMap.put(2, new User("Bob", null));

        //no optional
        String streetName = "Unkown";
        User user = userMap.get(1);

        if (user != null) {
            Address address = user.getAddress();
            if (address != null) {
                streetName = address.getStreet();
            }
        }
        System.out.println("Street name without Optional: " + streetName);

        //with optional
        streetName = Optional.ofNullable(userMap.get(1))
                .map(User::getAddress)
                .map(Address::getStreet)
                .orElse("Unkown");

        System.out.println("Street name with Optional: " + streetName);
    }
}

class Address {
    private String street;

    public Address(String street) {
        this.street = street;
    }

    public String getStreet() {
        return street;
    }
}

class User {
    private String name;
    private Address address;

    public User(String name, Address address) {
        this.name = name;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public Address getAddress() {
        return address;
    }
}