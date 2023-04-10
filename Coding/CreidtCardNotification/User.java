package Coding.CreidtCardNotification;

// User class with preference and details
class User {
    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    private String preference;

    public User(String firstName, String lastName, String email, String phone, String preference) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phone = phone;
        this.preference = preference;
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
}