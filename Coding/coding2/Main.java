package designhw3;

public class Main {
    public static void main(String[] args) {
        User userA = new User();
        User userB = new User();
        NotiFunction service = new NotiFunction();
        service.sendToUser(userA, "Hey " + userA.getFirstName() + ", you have successfully registered to add and here is your <registration_number>, please use this for future references.");
        service.sendToUser(userB, "Hey " + userB.getFirstName() + ", you have successfully registered to add and here is your <registration_number>, please use this for future references.");
        service.broadcast("40% off when you buy Popeyes between 06/13 - 06/19");
    }
}
