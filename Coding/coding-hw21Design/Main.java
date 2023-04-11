package designhw3;

public class Main {
    public static void main(String[] args) {
        User userA = new User("chen", "yuan", "yc47084613@gmail.com", "9704022499", "menmen", "EMAIL");
        User userB = new User("xiaochuan", "sun", "menmen@colostate.edu", "13114061525", "buzhidao", "SMS");
        NotiFunction service = new NotiFunction();
        service.sendToUser(userA, "Hey " + userA.getFirstName() + ", you have successfully registered to add and here is your , please use this for future references.");
        service.sendToUser(userB, "Hey " + userB.getFirstName() + ", you have successfully registered to add and here is your , please use this for future references.");
        service.broadcast("40% off when you buy Popeyes between 06/13 - 06/19");
    }
}
