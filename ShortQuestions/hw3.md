# hw21 Exception & Enum & Collection
## 1 
see [collections](/MavenProject/src/main/java/hw3/collections/)
## 2
checked exception: exceptions that are checked at compile time, such as IOException, FileNotFoundedException.
unchecked exception: exceptions that are not checked at compile time. Only at run time, we can figure out if it exists exceptions. For example, ArrayIndexOutOfBoundsException, NullPointerException.
## 3
No. There can only be one finally block, and it must follow the catch blocks. 

## 4
If both catch and finally return, the receiving method will get the returned value from the finally block.

## 5
same as question 2

## 6 
The `throws` keyword is used to declare which exceptions can be thrown from a method.
The `throw` keyword is used to explicitly throw an exception within a method or block of code.
```
public static void test(int value) throws IllegalArgumentException{
    if(integers.contains(value)) {
        throw new IllegalArgumentException("Integer already added.");
    }
    integers.add(value);
}
```

## 7
The order of excuation is whatever matches first, get excuted. So if the first catch matches the exception, it executes, if it doesn't, the next one is tried and on and on until one is matched or none are. So if we want to chatch the most specific exceptions first, we should put it first then catch the less specific one and put most general exception last.

## 7
The `finally` block always executes when the try block exits. This ensures that the finally block is executed even if an unexpected exception occurs.

## 8-13
see **hw22 Design Pattern** part

## 14
MySQL: see [hw3-db](/Coding/hw3/hw3-db.sql)

MongoDB: 
```
show dbs
use test
db.createCollection("oms_company_address")
db.oms_company_address.insertOne({"address_name":"Home" "name":"Jone"})
db.oms_company_address.insertOne({"address_name":"Work","name":"Jone"})
db.oms_company_address.insertOne({"address_name":"Home","name":"Ann", "phone":"111"})

db.oms_company_address.find({ name: "Jone" })
db.oms_company_address.find()
db.oms_company_address.updateOne({name:"Ann"}, "$set":{phone:"222"})
db.oms_company_address.deleteMany({name:"Jone"})
```

# hw22 Design Pattern
## 1 Design patterns
Creational Design Patterns: provide solutions to instantiate an Object in the best possible way for specific situations

Structural Design Patterns:
provide different ways to create a Class structure (for example, using inheritance and composition to create a large Object from small Objects).

Behavioral Design Patterns:
provide a solution for better interaction between objects and how to provide loose-coupling and flexibility to extend easily.

## 2 SOLID Principles
five principles of Object-Oriented class design:
- The Single Responsibility Principle: a class should do one thing and therefore it should have only a single reason to change.
- The Open-Closed Principle: classes should be open for extension and closed to modification. Modification means changing the code of an existing class, and extension means adding new functionality.  We should be able to add new functionality without touching the existing code for the class.
- The Liskov Substitution Principle: subclasses should be substitutable for their base classes. This means that, given that class B is a subclass of class A, we should be able to pass an object of class B to any method that expects an object of class A and the method should not give any weird output in that case.
- The Interface Segregation Principle: many client-specific interfaces are better than one general-purpose interface. Clients should not be forced to implement a function they do no need.
- The Dependency Inversion Principle: our classes should depend upon interfaces or abstract classes instead of concrete classes and functions.

## 3 Achieve thread-safe singleton patterns
1. Eager load:
Object of class is created when it is loaded to the memory by JVM. It is done by assgining the reference of an instance directly. Then the program will always use instance of this class, and multithread will not create multiple objects: 
```
public class Singleton{
    private static Singleton instance = new Singleton();

    private Singleton(){}

    public static Singleton getInstance(){
        return instance;
    }
}
```
2. Lazy load:
object is created only if it is needed. There is a null check that if object is not created then create, otherwise return previously created. To make sure that class cannot be instantiated in any other way. The block which creates instance is synchronized so that multiple threads can’t create it simultaneously.
```
public class Singleton{
    private static volatile Singleton instantce;;

    private Singleton(){}

    public static Singleton getInstance(){
        if(instance == null){
            synchronized(Singleton.class){
                if (instance == null){
                    instance = new Singleton();
                }
            }
        }
        return instance;
    }

}
```

## 4 Open-Closed Principle(OCP)
We should be able to add new functionality without touching the existing code for the class. This is because whenever we modify the existing code, we are taking the risk of creating potential bugs. It is usually done with the help of interfaces and abstract classes.

## 5 Liskov Substitution Principle
Class B is a subclass of class A, we should be able to pass an object of class B to any method that expects an object of class A and the method should not give any weird output in that case. We could use inheritance that the child class inherits everything that the superclass has. The child class extends the behavior but never narrows it down.

## 6 Liskov's substitution principle
select 1: It mean that if the object of type A can do something, the object of type B could also be able to perform the same thing.

## 7 
see [design_patter](../Coding/hw3/design_pattern/)
each java file contains multiple classes, just for convenience. For specific implementation, it is recommended that each class be a file

# hw-2 Design Credit Card Notification
See [design](../MavenProject/src/main/java/hw3/design_credit_card)

Use Factory Design Pattern:

- (Notification -> EmailNotification) --> (NotificationFactory -> EmailNotificationFactory)
- (Content -> RegisterContent) --> (ContentFactory -> RegisterContentFactory)

* Sender use NotificationFactory to create Notification
* ContentStorage use ContentFactory to pick a Content

- User choose prefer notification.


Try to send register content by email notification.
Try to send public content by prefer notification.