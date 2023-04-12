package MyCreaditCardDesign;

public interface UserObserver {
   
   void receivePrivateNotification(String message);
    void receivePublicNotification(String message);
    String getPreference();
    String getName();
}
