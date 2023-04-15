package observer;

public interface Subject {

    void attach(Observer observer);

    void dttach(Observer observer);

    void notify(String message);
}
