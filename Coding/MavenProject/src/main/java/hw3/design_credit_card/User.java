package hw3.design_credit_card;

public class User {
    private String name;
    private NotificationFactory prefer;

    public User(String name){
        this.name = name;
    }
    public User(String name, NotificationFactory prefer) {
        this.name = name;
        this.prefer = prefer;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public NotificationFactory getPrefer() {
        return prefer;
    }

    public void setPrefer(NotificationFactory prefer) {
        this.prefer = prefer;
    }
}
