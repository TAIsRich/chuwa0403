## 1. Practice Collection
Ans: Please check folder Coding/hw3-collection-exercise/collection

## 2. What is the checked exception and unchecked exception in Java, could you give one example?
Checked exceptions are exceptions that are checked at compile-time. This means that the code must handle them, either by catching them or by declaring that the method throws them. If a checked exception is not handled, the code will not compile.

Here's an example of checked exception.

```java
try {
      BufferedReader br = new BufferedReader(new FileReader("file.txt"));
      String line;
      while ((line = br.readLine()) != null) {
        System.out.println(line);
      }
      br.close();
    } catch (IOException e) {
      System.out.println("An error occurred: " + e.getMessage());
    }
```

Unchecked exceptions, on the other hand, are exceptions that are not checked at compile-time. These exceptions are typically caused by programming errors such as null pointer exceptions, array index out of bounds exceptions, and class cast exceptions.

example:
```java
String str = null;
System.out.println(str.length());
```

## 3.  Can there be multiple finally blocks?

Yes. You can only have one finally clause per try/catch/finally statement, but you can have multiple such statements, either in the same method or in multiple methods.

## 4.  When both catch and finally return values, what will be the final result ?

The value returned by the finally block will be the final result. The reason for this is that the finally block is always executed, regardless of whether an exception is thrown or not.

## 5.  What is Runtime/unchecked exception ? what is Compile/Checked Exception ?

See question 2.

## 6.  What is the difference between throw and throws ?
throw is used to explicitly throw an exception in a program. It is followed by an instance of the Throwable class (or one of its subclasses) that represents the exception being thrown.

throws, on the other hand, is used to declare the exceptions that a method may throw. It is followed by the name of the exception class or classes separated by commas.
## 7.  Run the below three pieces codes, Noticed the printed exceptions. why do we put the Null/Runtime exception before Exception 
NullPointerException and RuntimeException are more specific and often more likely to occur than the general Exception class, so listing them first can make it easier to identify and handle specific errors.

The order of the exceptions in the method signature does not affect the order in which they are caught and handled in a try-catch block. The exceptions are caught in the order they are listed in the catch blocks, regardless of the order in the method signature.
## 8. Why finally always be executed ?
There are a few reasons why finally is guaranteed to be executed:

Exception propagation: When an exception is thrown, the JVM begins unwinding the call stack to find an appropriate exception handler. During this process, it executes all the finally blocks encountered along the way.

Resource management: The finally block is often used to release resources (such as file handles or network connections) that were acquired in a try block. By placing the resource cleanup code in the finally block, we can be sure that the resources are released even if an exception occurs.

Control flow: The finally block can be used to change the control flow of a program. For example, if we want to ensure that a certain piece of code is executed regardless of whether an exception is thrown or not, we can place that code in a finally block.
## 9. What are the types of design patterns in Java ?
There are three main types of design patterns in Java:

Creational Patterns: These patterns are used to create objects in a system. The main objective of these patterns is to make object creation more flexible and efficient. Examples include Singleton, Factory, Abstract Factory, Builder, and Prototype.

Structural Patterns: These patterns are used to create relationships between objects and classes. The main objective of these patterns is to make the system more organized and easier to maintain. Examples include Adapter, Bridge, Composite, Decorator, Facade, Flyweight, and Proxy.

Behavioral Patterns: These patterns are used to define how objects and classes interact with each other. The main objective of these patterns is to make the system more efficient and maintainable. Examples include Chain of Responsibility, Command, Interpreter, Iterator, Mediator, Memento, Observer, State, Strategy, Template Method, and Visitor.
## 10. What are the SOLID Principles ?
The SOLID Principles is a set of five design principles for writing maintainable and scalable object-oriented software:

Single Responsibility Principle (SRP): Each class should have only one reason to change. This means that a class should have only one responsibility or job to do. If a class has more than one responsibility, changes to one responsibility may affect the others, making the code hard to maintain.

Open-Closed Principle (OCP): Software entities (classes, modules, functions, etc.) should be open for extension but closed for modification. This means that you should be able to add new functionality without changing the existing code. This can be achieved by using interfaces, abstract classes, and design patterns such as the Strategy pattern.

Liskov Substitution Principle (LSP): Objects of a superclass should be replaceable with objects of a subclass without affecting the correctness of the program. This means that a subclass should be able to replace its parent class without causing any unexpected behavior.

Interface Segregation Principle (ISP): Clients should not be forced to depend on interfaces they do not use. This means that a class should not be forced to implement methods it does not need. Instead, interfaces should be segregated into smaller and more specific interfaces, which can be implemented by classes that need them.

Dependency Inversion Principle (DIP): High-level modules should not depend on low-level modules. Both should depend on abstractions. Abstractions should not depend on details. Details should depend on abstractions. This means that you should depend on abstractions rather than concrete implementations. By doing so, you can easily change the implementation without affecting the rest of the code.
## 11. How can you achieve thread-safe singleton patterns in Java ?
In Java, the thread-safe singleton pattern can be achieved using one of the following approaches:

Eager initialization - In this approach, the singleton instance is created at the time of class loading. This ensures that the instance is created only once and is thread-safe.

Lazy initialization with synchronized keyword - In this approach, the instance is created only when needed, but the method for creating the instance is synchronized to ensure thread safety.
## 12. What do you understand by the Open-Closed Principle (OCP)
The Open-Closed Principle (OCP) is a design principle in object-oriented programming that states that software entities (classes, modules, functions, etc.) should be open for extension but closed for modification. This means that you should be able to extend the behavior of a class or module without modifying its source code. Instead of changing the original code, you should create new code that adds or overrides the existing behavior.

## 13.  Watch the design pattern video, and type the code, submit it to MavenProject folder
Check folder MavenProject/hw3_design_pattern/design-pattern

## 14.  CRUD MySQL and MongoDB (separated PDF)
 