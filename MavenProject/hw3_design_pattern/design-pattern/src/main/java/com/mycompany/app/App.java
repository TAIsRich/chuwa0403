package com.mycompany.app;
import java.util.ArrayList;
import java.util.List;
/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );


        Publisher publisher = new Publisher();

        Subscriber emailSubscriber1 = new EmailSubscriber("Email Subscriber 1");
        Subscriber emailSubscriber2 = new EmailSubscriber("Email Subscriber 2");
        Subscriber smsSubscriber1 = new SMSSubscriber("SMS Subscriber 1");

        publisher.subscribe(emailSubscriber1);
        publisher.subscribe(emailSubscriber2);
        publisher.subscribe(smsSubscriber1);

        publisher.notifySubscribers("New Product Launch");

        publisher.unsubscribe(emailSubscriber1);

        publisher.notifySubscribers("Discount Sale");
    }
}
