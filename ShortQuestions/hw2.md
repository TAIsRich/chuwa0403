#  Q1
## 1. Encapsulation:
```
public class BankAccount {
    private String accountNumber;
    private double balance;

    public BankAccount(String accountNumber, double balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        balance += amount;
    }

    public void withdraw(double amount) {
        balance -= amount;
    }
}
```
## 2.Polymorphism
```
public interface Shape {
    double calculateArea();
}

public class Circle implements Shape {
    private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    @Override
    public double calculateArea() {
        return Math.PI * radius * radius;
    }
}

public class Rectangle implements Shape {
    private double width;
    private double height;

    public Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }

    @Override
    public double calculateArea() {
        return width * height;
    }
}

public class ShapeCalculator {
    public double calculateTotalArea(List<Shape> shapes) {
    double totalArea = 0;
    for (Shape shape : shapes) {
    totalArea += shape.calculateArea();
    }
    return totalArea;
    }
}
```

## 3.Inheritance
```
public class Vehicle {
    private String make;
    private String model;
    private int year;

    public Vehicle(String make, String model, int year) {
        this.make = make;
        this.model = model;
        this.year = year;
    }

    public String getMake() {
        return make;
    }

    public String getModel() {
        return model;
    }

    public int getYear() {
        return year;
    }

    public void start() {
        System.out.println("Vehicle started.");
    }

    public void stop() {
        System.out.println("Vehicle stopped.");
    }
}

public class Car extends Vehicle {
    public Car(String make, String model, int year) {
        super(make, model, year);
    }

    @Override
    public void start() {
        System.out.println("Car started.");
    }

    @Override
    public void stop() {
        System.out.println("Car stopped.");
    }
}
```

# Q2
In Java, a wrapper class is a class that provides an object representation of a primitive data type. The wrapper classes allow us to convert primitive data types into objects and perform operations on them, just like any other object.

# Q3

Synchronization: HashTable is synchronized, meaning that it can be safely accessed by multiple threads concurrently. On the other hand, HashMap is not synchronized, meaning that it is not thread-safe by default. However, ConcurrentHashMap is an alternative implementation of Map that provides thread-safety for concurrent access.

Null keys/values: HashTable does not allow null keys or values, whereas HashMap allows one null key and multiple null values.

Iteration: When iterating over a HashTable, the order of the elements is not guaranteed, whereas HashMap guarantees the order of the elements during iteration.

Performance: In general, HashMap is faster than HashTable since it is not synchronized. However, for multi-threaded applications that require thread-safety, HashTable may perform better since it is already synchronized.

# Q4

In Java, the string pool is a location in memory where the JVM stores all the String literals. When we create a String using double quotes (e.g. "Hello"), the JVM first checks if the same string is already present in the string pool. If it is, the JVM returns a reference to the same object in the pool. If not, it creates a new string object and adds it to the pool for future reuse.

The reason for having a string pool in Java is to improve performance and reduce memory usage. Since strings are immutable in Java, the same string can be reused multiple times without any risk of modification. By reusing strings, we can avoid creating multiple instances of the same string, which saves memory and reduces the overhead of creating new objects.

# Q5
Java garbage collection is an automatic process that manages the memory used by Java programs. When a Java program runs, it uses the computer's memory to store objects and data. Garbage collection is the process of identifying and freeing up memory that is no longer needed by the program.

# Q6
Access modifiers in Java are keywords used to control the visibility and accessibility of class members, such as fields, methods, and inner classes. There are four access modifiers in Java: public, protected, private, and the default (also known as package-private).

public: Members declared as public can be accessed from any class or package. They have the widest scope and are visible to all.

protected: Members declared as protected can be accessed within the same package and by subclasses of the class in other packages. They have a more limited scope than public.

private: Members declared as private can only be accessed within the same class. They have the most limited scope.

Default: Members declared with no access modifier (i.e. no keyword is used) can only be accessed within the same package. This is also known as package-private access.

# Q7

In Java, the final keyword can be used to mark classes, methods, and fields, indicating that they cannot be changed or overridden.

final field: A final field is a constant that cannot be modified once it is assigned a value. It must be initialized either at the time of declaration or in the constructor. If an attempt is made to modify a final field, a compile-time error will occur.

final method: A final method is a method that cannot be overridden in a subclass. This is useful when we want to prevent any further changes to the behavior of a method in a subclass.

final class: A final class is a class that cannot be subclassed. This is useful when we want to prevent any further extension of a class, perhaps to ensure that its behavior remains consistent across all instances.

# Q8

In Java, the static keyword can be used to declare a class member (field or method) that belongs to the class itself, rather than to individual instances of the class.

static field: A static field is a class-level variable that is shared among all instances of the class. It can be accessed using the class name and does not require an instance of the class to be created. For example, a static field can be used to keep count of the number of instances of the class that have been created.

static method: A static method is a method that belongs to the class, not to any instance of the class. It can be called using the class name, without the need to create an instance of the class. For example, a static method can be used to perform some common operation that does not depend on the state of any individual instance of the class.

static class: A static class is a nested class that does not require an instance of the enclosing class to be created. It can be used to group related utility methods or constants that do not depend on any instance-specific state.

# Q9

In Java, both method overloading and method overriding are mechanisms used to give different implementations to methods with the same name, but they differ in the following ways:

Definition: Method overloading is the process of defining multiple methods in a class with the same name, but with different parameters. Method overriding is the process of defining a method in a subclass that already exists in the parent class with the same name and signature.

Invocation: Method overloading is invoked at compile-time based on the number, types, and order of the arguments passed. Method overriding is invoked at runtime based on the actual type of the object on which the method is called.

Return type: Method overloading can have the same or different return types. Method overriding must have the same return type, or a covariant return type (a subtype of the original return type).

Access modifier: Method overloading can have different access modifiers (public, protected, private) or even no modifier at all. Method overriding cannot have a more restrictive access modifier than the method being overridden. For example, if a method is public in the parent class, it must also be public in the subclass.

Inheritance: Method overloading is not related to inheritance, and can be used in the same class or in different classes. Method overriding requires inheritance, and can only be used in subclasses that inherit from a parent class.

# Q10

In Java, super and this are both keywords that are used to refer to different things in a class hierarchy. Here are the main differences between the two:

super refers to the parent class, while this refers to the current instance of the class.

super is used to access the parent class's methods, fields, and constructors, while this is used to access the current instance's methods, fields, and constructors.

super is used to resolve name conflicts between the parent class and the subclass, while this is used to differentiate between instance variables and local variables with the same name.

super can be used in both constructors and methods, while this can only be used in methods and constructors.

super must be the first statement in a constructor, while this can be used anywhere in a constructor.

# Q11

In Java, when a class is loaded, initialized, and used for the first time, a sequence of events takes place. Here is the general sequence of events that occur when a Java class is loaded:

Loading: The class loader searches for the bytecode of the class and loads it into memory.

Linking: The class is then verified to ensure that it is valid bytecode and all dependencies are resolved. This includes three sub-stages:

a. Verification: The bytecode is checked to ensure that it adheres to the Java language specifications.

b. Preparation: Static fields are allocated and initialized with their default values.

c. Resolution: Symbolic references to other classes and methods are resolved.

Initialization: Static variables and static blocks of code are executed in the order they appear in the class.

Usage: The class is now available for use and can be instantiated.

# Q12

Polymorphism is a fundamental concept in object-oriented programming (OOP) that allows objects of different classes to be treated as if they are objects of the same class. In other words, polymorphism allows objects to take on multiple forms or shapes.

In Java, there are two types of polymorphism: compile-time polymorphism (or method overloading) and runtime polymorphism (or method overriding).

# Q13

Encapsulation is a fundamental concept in object-oriented programming (OOP) that allows for the hiding of implementation details of a class from external entities, and ensuring that data is accessed and modified through well-defined methods or interfaces.

In Java, encapsulation is implemented through the use of access modifiers, such as private, protected, and public. These access modifiers are used to restrict the access to the members (fields and methods) of a class.

# Q14

Both interfaces and abstract classes are used to provide abstractions in Java, but there are some differences between them.

An interface in Java is a collection of abstract methods, which means that they do not have any implementation. Interfaces can also contain constant fields and default methods with implementation. A class can implement one or multiple interfaces, and it must provide implementation for all the methods declared in the interface(s). The main purpose of an interface is to define a contract or a set of behaviors that a class must implement.
An abstract class in Java is a class that cannot be instantiated, but can contain both abstract and non-abstract methods. Abstract methods are declared without implementation, while non-abstract methods are declared with implementation. A class can extend only one abstract class, but can implement multiple interfaces. The main purpose of an abstract class is to provide a template or a base implementation for its subclasses.

# Q15
In coding package

# Q16

In Java, the Queue interface is used to represent a collection of elements that supports insertion and removal of elements at both ends. Here are some of the implementations of the Queue interface in Java:

LinkedList: LinkedList is a doubly linked list implementation of the List and Deque interfaces in Java. It also implements the Queue interface, which means that it can be used as a queue. It provides operations for adding elements to the end of the list (offer()), removing elements from the beginning of the list (poll()), and inspecting the head element of the list (peek()).

ArrayDeque: ArrayDeque is a resizable array implementation of the Deque interface in Java. It also implements the Queue interface, which means that it can be used as a queue. It provides operations for adding elements to both ends of the deque (offerFirst(), offerLast()), removing elements from both ends of the deque (pollFirst(), pollLast()), and inspecting the head and tail elements of the deque (peekFirst(), peekLast()).

PriorityQueue: PriorityQueue is a priority queue implementation of the Queue interface in Java. It is implemented as a heap data structure, which means that elements are ordered based on their priority. It provides operations for adding elements to the queue (offer()), removing the highest-priority element from the queue (poll()), and inspecting the highest-priority element in the queue (peek()).

When to use which implementation of the Queue interface depends on the specific use case. Here are some guidelines:

If you need to perform a large number of inserts and deletes in the middle of the queue, LinkedList is a good choice because it provides efficient insertions and deletions in the middle of the list.

If you need to perform a large number of inserts and deletes at both ends of the queue, ArrayDeque is a good choice because it provides efficient insertions and deletions at both ends of the deque.

If you need to maintain a priority queue, where elements are ordered based on their priority, PriorityQueue is a good choice.

In general, it is recommended to use the implementation that best fits the specific use case to achieve optimal performance.














