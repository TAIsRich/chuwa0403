package hw3.design_credit_card;

import java.util.ArrayList;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        ArrayList<User> list = new ArrayList<>();
        User u1 = new User("Joe");
        User u2 = new User("Ann", new EmailNotificationFactory());
        User u3 = new User("Tony");

        list.add(u1);
        list.add(u2);
        list.add(u3);

        // change register notification
        u3.setPrefer(new EmailNotificationFactory());

        try {
            //send register message
            ContentStorage storage = new ContentStorage();
            storage.setFactory(new RegisterContentFactory());
            HashMap<String, String> map3 = new HashMap<>();
            map3.put("$name$", u3.getName());
            Content c = storage.pickContent(map3);

            Sender sender3 = new Sender();
            sender3.SetFactory(u3.getPrefer());
            sender3.sendNotification(c.getContent());

            // send public message
            storage.setFactory(new PublicContentFactory());
            Content c2 = storage.pickContent(new HashMap<>());

            Sender senderP = new Sender();
            for (User u : list) {
                senderP.SetFactory(u.getPrefer());
                senderP.sendNotification(c2.getContent());
            }
        }catch (NullPointerException e){
            System.out.println("User didn't choose prefer notification");
        }
    }
}
