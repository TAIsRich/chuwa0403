# HW3 - Part I

## 1. Collection Exercise

See `coding/hw3/CollectionExercise`.

## 2. What is the checked exception and unchecked exception in Java, could you give one example?

Checked exceptions are exceptions that must be either handled or declared in the method signature. These are usually exceptions that are beyond the control of the programmer and can occur due to external factors like file IO, network connectivity, etc.

Examples of checked exceptions in Java are `IOException`, `SQLException`, and `ClassNotFoundException`.

Unchecked exceptions, on the other hand, are exceptions that need not be explicitly handled or declared in the method signature. These exceptions are usually caused by logical errors in the code or illegal arguments passed to a method.

Examples of unchecked exceptions in Java are `NullPointerException`, `ArrayIndexOutOfBoundsException`, and `ArithmeticException`.

## 3. Can there be multiple finally blocks?

In one try-catch block, **there can only be one finally block**, and it must follow the catch blocks. If the try block exits normally (no exceptions occurred), then control goes directly to the finally block. After the finally block is executed, the statements following it get control.

## 4. When both catch and finally return values, what will be the final result ?

If both the `catch` block and the `finally` block return a value, the value returned by the `finally` block takes precedence and overrides the value returned by the `catch` block. For example:

```java
public static int d() {
    int result = 0;
    try {
        result = divide(10, 0);
    } catch (ArithmeticException e) {
        System.out.println("Caught an ArithmeticException");
        return 1;
    } finally {
        System.out.println("This is the finally block");
        return 2;
    }
}
```

The Output will be:

```text
Caught an ArithmeticException
This is the finally block
2
```

## 5. What is Runtime/Unchecked exception ? what is Compile/Checked Exception ?

A checked exception is an exception that must be either caught or declared in the method signature using the `throws` keyword. Checked exceptions are checked by the Java compiler at compile time and must be handled to ensure that the program can continue executing properly.

Examples of checked exceptions in Java include `IOException`, `SQLException`, and `ClassNotFoundException`.

On the other hand, an unchecked exception is an exception that does not need to be caught or declared in the method signature. Unchecked exceptions are checked by the Java runtime system during the execution of the program, and occur when the program is in an abnormal state due to factors such as incorrect logic or incorrect use of APIs.

Examples of unchecked exceptions in Java include `NullPointerException`, `IndexOutOfBoundsException`, and `ArithmeticException`.

## 6. What is the difference between throw and throws ?

`throw` is used to explicitly throw an exception from within a method. When `throw` is executed, it creates an instance of the specified exception class and throws it.

On the other hand, `throws` is used in the method signature to declare that a method may throw a checked exception. When a method declares that it `throws` a checked exception, it is informing the caller that the method may not be able to handle the exception and that the caller should handle it instead.

## 7. Why do we put the Null/Runtime exception before Exception?

In Java, when multiple catch blocks are used, they are executed in the order in which they appear in the code. If an exception is caught by one of the catch blocks, the subsequent catch blocks are skipped.

1. The first statement in the catch block is a division `System.out.prinln(b / a)` , so we need to check the ArithmeticException first. Because if a is zero, there will be a ArithmeticException.
2. This time the first statement is the catch block is `System.out.println(s.equals("aa"))`, if s is null there will be a NullPointerException.
3. At last, the `throw new RuntimeException()` is the first sentence, there will be a RuntimeException. So we catch RuntimeException before the most general exception.

## 8. Why finally always be executed?

It is programmed to be executed no matter there is an exception or not. In Java, the `finally` block is used in exception handling to specify a block of code that should be executed regardless of whether an exception is thrown or not. The `finally` block is always executed, regardless of whether an exception is caught and handled by a catch block or not.

## 9. What are the types of design patterns in Java?

1. Creational patterns: These patterns are used to create objects in a way that is flexible and easy to maintain. Examples include the Singleton pattern, Factory pattern, Abstract Factory pattern, Builder pattern, and Prototype pattern.
2. Structural patterns: These patterns are used to define relationships between objects, and how they can work together to form larger structures. Examples include the Adapter pattern, Bridge pattern, Composite pattern, Decorator pattern, Facade pattern, Flyweight pattern, and Proxy pattern.
3. Behavioral patterns: These patterns are used to define how objects communicate with each other, and how they can work together to accomplish a specific task. Examples include the Chain of Responsibility pattern, Command pattern, Interpreter pattern, Iterator pattern, Mediator pattern, Memento pattern, Observer pattern, State pattern, Strategy pattern, Template Method pattern, and Visitor pattern.

## 10. What are the **SOLID** Principles?

1. Single Responsibility Principle (SRP): A class should have only one reason to change. In other words, a class should be responsible for doing one thing, and doing it well.
2. Open-Closed Principle (OCP): A class should be open for extension but closed for modification. This means that you should be able to add new functionality to a class without changing its existing code.
3. Liskov Substitution Principle (LSP): Subtypes must be substitutable for their base types. This means that you should be able to use a subclass wherever a parent class is expected, without any unexpected behavior.
4. Interface Segregation Principle (ISP): A client should not be forced to depend on methods it does not use. This means that you should design small, cohesive interfaces that are tailored to specific clients.
5. Dependency Inversion Principle (DIP): High-level modules should not depend on low-level modules. Both should depend on abstractions. This means that you should design your code so that high-level modules depend on abstract interfaces, rather than on concrete implementations.

## 11. How can you achieve **thread-safe singleton patterns** in Java ?

1. Eager Initialization: This method initializes the singleton instance at the time of class loading itself. It's thread-safe but not suitable for large or expensive objects.

   ```java
   public class Singleton {
      private static final Singleton INSTANCE = new Singleton();
      private Singleton() {}
      public static Singleton getInstance() {
         return INSTANCE;
      }
   }
   ```

2. Lazy Initialization with Synchronized Method: This method initializes the singleton instance when it is needed and ensures thread safety using a synchronized method. But it causes performance issues as it acquires the lock every time the method is called.

   ```java
   public class Singleton {
      private static Singleton instance;
      private Singleton() {}
      public static synchronized Singleton getInstance() {
         if(instance == null) {
            instance = new Singleton();
         }
         return instance;
      }
   }
   ```

3. Lazy Initialization with Double-checked Locking: This method also initializes the singleton instance when it is needed but uses double-checked locking to ensure thread safety. It is more efficient than the previous method.

   ```java
   public class Singleton {
      private static volatile Singleton instance;
      private Singleton() {}
      public static Singleton getInstance() {
         if(instance == null) {
            synchronized(Singleton.class) {
               if(instance == null) {
                  instance = new Singleton();
               }
            }
         }
         return instance;
      }
   }
   ```

4. Initialization on Demand Holder (IODH): This method uses a static inner class to hold the singleton instance, and it is created only when the getInstance() method is called. It is thread-safe, efficient, and compatible with lazy initialization.

   ```java
   public class Singleton {
      private Singleton() {}
      private static class SingletonHolder {
         private static final Singleton INSTANCE = new Singleton();
      }
      public static Singleton getInstance() {
         return SingletonHolder.INSTANCE;
      }
   }
   ```

## 12. What do you understand by the **Open-Closed Principle (OCP)** ?

The Open-Closed Principle (OCP) is a design principle in object-oriented programming that states that software entities (classes, modules, functions, etc.) should be open for extension but closed for modification. This means that the behavior of a module or component should be easily extendable without modifying the existing code.

In other words, the OCP states that you should be able to add new functionality to a system without changing existing code. Instead of modifying the existing code, you should be able to extend it by adding new code that interacts with the existing code.

The OCP is important because it helps to make code more modular and easier to maintain over time. By following the OCP, you can create code that is more flexible, scalable, and able to adapt to changing requirements.

One common way to achieve the OCP is to use inheritance or composition. By creating a base class or interface that defines the behavior of a system, you can create subclasses or implementations that extend or modify that behavior without changing the original code. This allows you to add new functionality while keeping the existing code unchanged, making the system more open for extension and closed for modification.

## 13. (SOLID-L)**Liskov’s substitution principle **

Liskov’s substitution principle states that if class B is a subtype of class A, then object of type A may be substituted with any object of type B. What does this actually mean? (from OA ) choose your answer.

1. It mean that if the object of type A can do something, the object of type B could also be able to perform the same thing.

## 14. Design Pattern

Check the MavenProject.

# HW3 - Part II

## 1. What are the types of design patterns in Java?

1. Creational patterns: These patterns are used to create objects in a way that is flexible and easy to maintain. Examples include the Singleton pattern, Factory pattern, Abstract Factory pattern, Builder pattern, and Prototype pattern.
2. Structural patterns: These patterns are used to define relationships between objects, and how they can work together to form larger structures. Examples include the Adapter pattern, Bridge pattern, Composite pattern, Decorator pattern, Facade pattern, Flyweight pattern, and Proxy pattern.
3. Behavioral patterns: These patterns are used to define how objects communicate with each other, and how they can work together to accomplish a specific task. Examples include the Chain of Responsibility pattern, Command pattern, Interpreter pattern, Iterator pattern, Mediator pattern, Memento pattern, Observer pattern, State pattern, Strategy pattern, Template Method pattern, and Visitor pattern.

## 2. What are the SOLID Principles?

1. Single Responsibility Principle (SRP): A class should have only one reason to change. In other words, a class should be responsible for doing one thing, and doing it well.
2. Open-Closed Principle (OCP): A class should be open for extension but closed for modification. This means that you should be able to add new functionality to a class without changing its existing code.
3. Liskov Substitution Principle (LSP): Subtypes must be substitutable for their base types. This means that you should be able to use a subclass wherever a parent class is expected, without any unexpected behavior.
4. Interface Segregation Principle (ISP): A client should not be forced to depend on methods it does not use. This means that you should design small, cohesive interfaces that are tailored to specific clients.
5. Dependency Inversion Principle (DIP): High-level modules should not depend on low-level modules. Both should depend on abstractions. This means that you should design your code so that high-level modules depend on abstract interfaces, rather than on concrete implementations.

