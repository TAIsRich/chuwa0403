package MyCreaditCardDesign;

public class Test {
    public static void main(String[] args) throws Exception {
        Notification subject = new Notification();
        CreditCardUser user1 = new CreditCardUser("Min He","SMS");
        CreditCardUser user2 = new CreditCardUser("Hao Liu","EMAIL");
        subject.attach(user1);
        subject.attach(user2);
        String Broadcast = " 40% off when you buy Popeyes between 06/13 - 06/19";
        String privateNotify = ", you have successfully registered to add and here is your account number, please use this for\n" +
                "future references.";
        subject.notifyPublic(Broadcast);
        subject.notifyPrivate("Hao Liu","EMAIL",privateNotify);
        subject.notifyPrivate("Min He","WHATSAPP",privateNotify);
    }
}
/*OUTPUT
 Min He received SMS message :  40% off when you buy Popeyes between 06/13 - 06/19
 Hao Liu received EMAIL message :  40% off when you buy Popeyes between 06/13 - 06/19

 Hey Hao Liu, you have successfully registered to add and here is your account number, please use this for
 future references.

 Exception in thread "main" java.lang.Exception: Preference type is not match !
 at ZMyCreaditCardDesign.Notification.notifyPrivate(Notification.java:24)
 at ZMyCreaditCardDesign.Test.main(Test.java:15)
 * */
