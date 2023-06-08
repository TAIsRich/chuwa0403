package com.mycompany.app;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        User JohnUser = new User.UserBuilder("John","John")
                .email("john@example.com")
                .preference("email")
                .build();
        User BobUser = new User.UserBuilder("Bob","Bob")
                .email("bob@example.com")
                .preference("whatsapp")
                .build();
        User AliceUser = new User.UserBuilder("Bob","Bob")
                .email("bob@example.com")
                .preference("push") /*Invalid preference*/
                .build();
        NotificationSender sender = new NotificationSender();
        String notification = "40% off when you buy Popeyes between 06/13 - 06";
        sender.sendNotification(JohnUser,notification);
        sender.sendNotification(BobUser,notification);
        sender.sendNotification(AliceUser,notification); // Invalid preference

    }
}
