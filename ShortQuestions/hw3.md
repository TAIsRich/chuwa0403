> 1. Please see coding folder   

> 2. A checked exception is a type of exception that is checked at compile-time. This means that the programmer is required to handle the exception, either by catching it or by declaring it in a throws clause. eg. IOException:   
```
try {
    FileReader fileReader = new FileReader("file.txt");
} catch (IOException e) {
    //handle catch
}
```
> an unchecked exception is a type of exception that is not checked at compile-time. This means that the programmer is not required to handle the exception, and it can be thrown anywhere in the code. eg. ArithmeticException:
```
public int function() {
    return 1 / 0;
}
```
> 3. Yes, it is possible to have multiple finally blocks in java, it will be excuted follow the order of how they are defined.

> 4. The final result will be whatever the finally block returns, because the finally block will always be excuted and will override any other return values.

> 5. A checked exception is a type of exception that is checked at compile-time. This means that the programmer is required to handle the exception, either by catching it or by declaring it in a throws clause. And an unchecked exception is a type of exception that is not checked at compile-time. This means that the programmer is not required to handle the exception, and it can be thrown anywhere in the code.

> 6. The keyword throw is used to throw an exception from a block or method of code. When using the throw keyword, it must be accompanied by an object of the corresponding exception class. Differently, the keyword throws is used in method signature, it declares that the method might throw those exception without handling it, the code who calls it should have the ablity to handle it.

> 7. Because if we put exception before Null/Runtime exception, the exception block will always be excuted and Null/Runtime exception will become unreachable, it will destory the meaning to handle Null/Runtime exception.

> 7. To my understanding, the finally block is very important for the exception handling of Java, it provides a way to ensure that any system resources acquired within the try block are properly cleaned up in the case of exceptions.

> 8. 
> Creational Patterns:
>- Singleton pattern: This pattern ensures that a class has only one instance, and provides a global point of access to that instance.
> - Factory pattern: This pattern provides an interface for creating objects, but allows subclasses to decide which class to instantiate.
> - Builder pattern: This pattern separates the construction of a complex object from its representation, allowing the same construction process to create different representations.   

> Structural Patterns:
> - Adapter pattern: This pattern allows objects with incompatible interfaces to work together by creating a wrapper object that translates one interface to another.
> - Bridge pattern: This pattern decouples an abstraction from its implementation, allowing them to vary independently.
> - Composite pattern: This pattern composes objects into tree structures to represent part-whole hierarchies.

> Behavioral Patterns:
> - Observer pattern: This pattern defines a one-to-many dependency between objects so that when one object changes state, all its dependents are notified and updated automatically.
> - Strategy pattern: This pattern defines a family of algorithms, encapsulates each one, and makes them interchangeable. Strategy lets the algorithm vary independently from clients that use it.
> - Command pattern: This pattern encapsulates a request as an object, thereby letting you parameterize clients with different requests, queue or log requests, and support undoable operations.

### 9. 
1. Single Responsibility Principle (SRP):    
A class should have only one reason to change.   
Each class should have a single responsibility or job to do, and it should not be responsible for doing anything else. This principle helps to make classes more modular and easier to test and maintain.

2. Open-Closed Principle (OCP):   
A class should be open for extension but closed for modification.   
A class should be designed in a way that allows new functionality to be added without modifying its existing code. This principle helps to make the software more flexible and easier to maintain over time.

3. Liskov Substitution Principle (LSP):
Subtypes should be substitutable for their base types.   
This principle ensures that a derived class can be used in place of its parent class without causing any errors or unexpected behavior. This principle helps to ensure that the software is easy to extend and maintain.

4. Interface Segregation Principle (ISP):
Clients should not be forced to depend on interfaces they do not use.
This principle states that an interface should only contain methods that are relevant to its users. This principle helps to keep the codebase clean and easy to understand.

5. Dependency Inversion Principle (DIP)：   
High-level modules should not depend on low-level modules. Both should depend on abstractions.
This principle ensures that the code is easy to maintain and extend by decoupling the higher-level modules from the lower-level modules. It promotes the use of abstractions and interfaces to allow for more flexibility in the software design.

### 10.
It can be achieved by using eager load:   
```
public class Singleton {
    private static Singleton instance = new Singleton();

    private Singleton() {
    }

    public static Singleton getInstance() {
        return instance;
    }
}
```
Or using thread-safe lazy load:
```
public class Singleton {
    private static volatile Singleton instance;
    private Singleton() {
    }
    public static Singleton getInstance() {

    if (instance == null) {
        synchronized (Singleton.class) {
            if (instance == null) {
                instance = new Singleton();
                }
            }
        }
    return instance;
}
}
```

### 11.
The Open-Closed Principle (OCP) is a design principle in software engineering that was introduced by Bertrand Meyer. The principle states that a software entity (such as a class, module, or function) should be open for extension but closed for modification. In other words, once a software entity has been created and tested, it should not be modified, but should be easily extended to accommodate new requirements or functionality.

The OCP principle is based on the idea that modifying existing code can be risky, as it may introduce new bugs or cause existing functionality to break. Instead, the principle encourages developers to design their software entities in a way that allows for future extension without requiring modification of existing code.

### 12.
1 & 3

### 13.
Please see coding folder

### 14. 
Please see DB file in ShortQuestions folder