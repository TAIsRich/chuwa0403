package CreditCard;

public interface Subject {
    void attach(Observer observer);
    void detach(Observer observer);
    void notifyAll(String message);
}
