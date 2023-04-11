package MyCreaditCardDesign;

public interface CreditCardSubject {

    void attach(UserObserver observer);

    void notifyPrivate(String name,String preferenceType,String message) throws Exception;

    void notifyPublic(String message);
}
