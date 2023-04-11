package design;

// 具体的观察者角色类

public class SMSUser extends User {

    private String name;
    private String account;

    public SMSUser(String name, String phone) {
        this.name = name;
        this.account = phone;
    }

    @Override
    public String getMethod() {
        return "SMS";
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getAccount() {
        return account;
    }

    @Override
    public void update(String message) {
        System.out.println(name + " with phone number " + account + ": " + message);
    }
}
