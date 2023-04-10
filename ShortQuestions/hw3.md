## 1. Practice Collection
   
   See Coding/Collection

## 2. What is the checked exception and unchecked exception in Java,could you give one example?
   
   1. Checked exceptions are exceptions that are checked at compile-time, meaning the compiler will require the programmer to handle or declare them in the method signature. These exceptions are typically caused by external factors beyond the control of the program, such as I/O errors, database errors, network errors, etc.
```
import java.sql.*;

public class Example {
    public static void main(String[] args) {
        try {
            
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydatabase", "username","password");
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM mytable");
            while (rs.next()) {
                System.out.println(rs.getString("column1") + " " + rs.getString("column2"));
            }
            rs.close();
            stmt.close();
            conn.close();
        } catch (ClassNotFoundException e) {
            System.out.println("Could not load the JDBC driver.");
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println("An error occurred while executing the query.");
            e.printStackTrace();
        }
    }
}
```
   2. Unchecked exceptions are exceptions that are not checked at compile-time, meaning the compiler does not require the programmer to handle or declare them in the method signature. These exceptions are typically caused by programming errors, such as null pointer exceptions, array index out of bounds, etc.
```
public class Example {
    public static void main(String[] args) {
        int x = 4;
        int y = 0;
        int res = x / y;
        System.out.println(res);
    }
}

```

## 3. Can there be multiple finally blocks?

   No.

## 4. When both catch and finally return values, what will be the final result?

   In Java, if both catch and finally blocks return values, the value returned by the finally block will overwrite the value returned by the catch block.

## 5. What is Runtime/unchecked exception? what is Compile/Checked Exception?
   
   1. A checked exception, also known as a compile-time exception, is an exception that the compiler checks at compile-time. These exceptions occur when the code is trying to do something that might cause an error. The compiler forces the programmer to handle these exceptions by either using a try-catch block or by throwing them.

   2. An unchecked exception, also known as a runtime exception, is an exception that occurs at runtime, i.e., during the execution of the program. These exceptions occur due to logical errors in the program, such as dividing by zero or trying to access an array index that does not exist. Unchecked exceptions do not need to be handled explicitly, and if not handled, they will result in a runtime erro

## 6. What is the difference between throw and throws?
   
   throw is used to explicitly throw an exception from a block of code. When you encounter an error or an exceptional condition, you can use the throw keyword to throw an exception object. throws is used to declare that a method may throw an exception. It is used in the method signature to specify that a method might throw one or more exceptions.

## 7. Why do we put the Null/Runtime exception before Exception ?

   NullPointerException and RuntimeException are unchecked exceptions, which means they do not need to be declared in the method signature, and they are commonly encountered in Java programs. Therefore, it is a good practice to handle them first before handling other exceptions. If you catch Exception first, then any NullPointerException or RuntimeException that occurs will also be caught, and this program may not behave as expected.

## 8. Why finally always be executed?

   1. Exception handling: When an exception is thrown in a try block, the corresponding catch block is executed (if it exists), followed by the finally block. This ensures that any cleanup code in the finally block is executed, even if an exception is thrown.
   2. Resource management: The finally block is often used for resource management, such as closing a file or releasing a network connection. By putting the cleanup code in the finally block, you can ensure that the resources are released even if an exception occurs.
   3. Control flow: The finally block is executed regardless of how the try block exits. This ensures that any cleanup code in the finally block is executed, even if the method exits early.
   4. Program integrity: The finally block is an important part of ensuring the integrity of a program. By executing the cleanup code in the finally block, you can prevent resource leaks, ensure that data is saved correctly, and prevent other issues that may arise if the program is terminated unexpectedly.

## 9. What are the types of design patterns in Java?

   There are three types of design patterns in Java.
   1. Creational Patterns: Singleton Pattern, Factory Pattern, Abstract Factory Pattern, Builder Pattern, Prototype Pattern
   2. Structural Patterns: Adapter Pattern, Bridge Pattern, Composite Pattern, Decorator Pattern, Proxy Pattern, Facade Pattern, Flyweight Pattern
   3. Behavioral Patterns: Chain of Responsibility Pattern, Command Pattern, Interpreter Pattern, Iterator Pattern,Mediator Pattern, Memento Pattern, Observer Pattern, State Pattern, Strategy Pattern, Template Method Pattern, Visitor Pattern

## 10. What are the SOLID Principles?
   
   SOLID is an acronym that represents a set of five design principles for object-oriented programming.
   1. Single Responsibility Principle (SRP):
   This principle states that a class should have only one reason to change, meaning that it should have only one responsibility. If a class has multiple responsibilities, it becomes harder to maintain and modify.
   2. Open/Closed Principle (OCP):
   This principle states that a class should be open for extension but closed for modification. This means that we should be able to add new functionality to a class without changing its existing code.
   3. Liskov Substitution Principle (LSP):
   This principle states that derived classes should be substitutable for their base classes without affecting the correctness of the program. In other words, any instance of a base class should be replaceable with an instance of a derived class without causing any unexpected behavior.
   4. Interface Segregation Principle (ISP):
   This principle states that a client should not be forced to depend on methods it does not use. In other words, it's better to have many small interfaces that are focused on specific tasks rather than one large interface that does everything.
   5. Dependency Inversion Principle (DIP):
   This principle states that high-level modules should not depend on low-level modules, but both should depend on abstractions. In other words, we should depend on abstractions, not on concrete implementations. This makes our code more flexible and easier to maintain.

## 11. How can you achieve thread-safe singleton patterns in Java?

   1. Eager initialization with static final variable: 
```
public class Singleton {
    private static final Singleton INSTANCE = new Singleton();
    
    private Singleton() {}
    
    public static Singleton getInstance() {
        return INSTANCE;
    }
}
```
   2. Lazy initialization with synchronized method:
```
public class Singleton {
    private static Singleton INSTANCE;
    
    private Singleton() {}
    
    public static synchronized Singleton getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new Singleton();
        }
        return INSTANCE;
    }
}
```
   3. Lazy initialization with double-checked locking:
```
public class Singleton {
    private static volatile Singleton INSTANCE;
    
    private Singleton() {}
    
    public static Singleton getInstance() {
        if (INSTANCE == null) {
            synchronized (Singleton.class) {
                if (INSTANCE == null) {
                    INSTANCE = new Singleton();
                }
            }
        }
        return INSTANCE;
    }
}
```

## 12. What do you understand by the Open-Closed Principle (OCP)?
   The Open-Closed Principle (OCP) is a design principle that states that software entities (classes, modules, functions, etc.) should be open for extension but closed for modification. The OCP encourages the use of abstraction and polymorphism to achieve this. OCP can reduce risk of introducing bugs and errors, improve scalability and maintainability and improve code reuse.

## 13. what do you understand by the Liskov Substitution Principle?
   The Liskov Substitution Principle (LSP) is a fundamental principle in object-oriented design that states that if a program is using a base class (or interface), then the program should be able to use any of its derived classes (or implementations of the interface) without knowing it, and without the program's correctness being affected. The LSP is closely related to the concept of inheritance, and helps ensure that classes that inherit from a base class or interface do not violate the expected behavior of the base class or interface.

## 14. (SOLID-L)Liskov’s substitution principle states that if class B is a subtype of class A, then object of type A may be substituted with any object of type B. What does this actually mean? 
   Option 1 & 3

## 15. Watch the design pattern video, and type the code, submit it to MavenProject folder
   See Coding/MavenProject

## 16. CRUD MySQL and MongoDB (separated PDF)
   See hw3_db.md

## Design Pattern Credit Card Notification
   See Coding/MavenProject/src/main/java/com/chuwa/learn/DesignPattern