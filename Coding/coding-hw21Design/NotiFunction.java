package designhw3;

import java.util.List;

public class NotiFunction {

    public void sendToUser(User user, String message) {
        NotiType strategy = Factory.getPlan(user.getPreference());
        if (strategy == null) {
            throw new IllegalArgumentException("Invalid preference: " + user.getPreference());
        }
        strategy.sendNoti(user, message);
    }

    public void broadcast(String message) {
        System.out.println(message);
    }
}
