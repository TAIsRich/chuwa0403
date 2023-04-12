package designhw3;

import java.util.ArrayList;
import java.util.List;

public class User {
    public String firstName;
    public String lastName;
    public String email;
    public String phoneNumber;
    public String whatsAppId;
    public String preference;

    public User(String firstName, String lastName, String email, String phoneNumber, String whatsAppId, String preference) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.whatsAppId = whatsAppId;
        this.preference = preference;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getWhatsAppId() {
        return whatsAppId;
    }

    public void setWhatsAppId(String whatsAppId) {
        this.whatsAppId = whatsAppId;
    }

    public String getPreference() {
        return preference;
    }

    public void setPreference(String preference) {
        this.preference = preference;
    }
}

