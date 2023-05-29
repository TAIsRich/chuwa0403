package hw3.design_pattern;

import java.util.ArrayList;
import java.util.List;
public class PS {
    /*
     * Observable (Subject) - interface or abstract class defining the operations for attaching and de-attaching observers to the client. In the GOF book this class/interface is known as Subject.
     * ConcreteObservable (Concrete Subject) - concrete Observable class. It maintain the state of the object and when a change in the state occurs it notifies the attached Observers.
     * Observer - interface or abstract class defining the operations to be used to notify this object.
     * ConcreteObserverA, ConcreteObserver2 - concrete Observer implementations.      
     */

    public static void main(String[] args) {
        // create one Observable
        SubscriptionSubject subject = new SubscriptionSubject();

        // add one oberserver to this Observable
        subject.attach(new User("a"));
        subject.attach(new User("b"));

        // update this observable -> auto notisfy every observer
        subject.notify("new stuff!");
    }
 
}

// Observable
interface Subject {

    void attach(Observer observer);

    void detach(Observer observer);

    void notify(String message);
}

// Concrete Observable
class SubscriptionSubject implements Subject {

    private List<Observer> userList = new ArrayList<Observer>();

    @Override
    public void attach(Observer observer) {
        userList.add(observer);
    }

    @Override
    public void detach(Observer observer) {
        userList.remove(observer);
    }

    @Override
    public void notify(String message) {
        // notify every concrete observer -> users
        for (Observer observer : userList) {
            // everyone updates
            observer.update(message);
        }
    }
}

// Observer
interface Observer {
    void update(String message);
}

// concreate observer
class User implements Observer {

    private String name;

    public User(String name) {
        this.name = name;
    }

    @Override
    public void update(String message) {
        // concrete observer to update the info
        System.out.println(name + "-" + message);
    }
}
