## 1.  What are the types of design patterns in Java?
There are three main types of design patterns in Java:

Creational Patterns: These patterns are used to create objects in a system. The main objective of these patterns is to make object creation more flexible and efficient. Examples include Singleton, Factory, Abstract Factory, Builder, and Prototype.

Structural Patterns: These patterns are used to create relationships between objects and classes. The main objective of these patterns is to make the system more organized and easier to maintain. Examples include Adapter, Bridge, Composite, Decorator, Facade, Flyweight, and Proxy.

Behavioral Patterns: These patterns are used to define how objects and classes interact with each other. The main objective of these patterns is to make the system more efficient and maintainable. Examples include Chain of Responsibility, Command, Interpreter, Iterator, Mediator, Memento, Observer, State, Strategy, Template Method, and Visitor.

## 2.  What are the SOLID Principles?
The SOLID Principles is a set of five design principles for writing maintainable and scalable object-oriented software:

Single Responsibility Principle (SRP): Each class should have only one reason to change. This means that a class should have only one responsibility or job to do. If a class has more than one responsibility, changes to one responsibility may affect the others, making the code hard to maintain.

Open-Closed Principle (OCP): Software entities (classes, modules, functions, etc.) should be open for extension but closed for modification. This means that you should be able to add new functionality without changing the existing code. This can be achieved by using interfaces, abstract classes, and design patterns such as the Strategy pattern.

Liskov Substitution Principle (LSP): Objects of a superclass should be replaceable with objects of a subclass without affecting the correctness of the program. This means that a subclass should be able to replace its parent class without causing any unexpected behavior.

Interface Segregation Principle (ISP): Clients should not be forced to depend on interfaces they do not use. This means that a class should not be forced to implement methods it does not need. Instead, interfaces should be segregated into smaller and more specific interfaces, which can be implemented by classes that need them.

Dependency Inversion Principle (DIP): High-level modules should not depend on low-level modules. Both should depend on abstractions. Abstractions should not depend on details. Details should depend on abstractions. This means that you should depend on abstractions rather than concrete implementations. By doing so, you can easily change the implementation without affecting the rest of the code.

## 3.  How can you achieve thread-safe singleton patterns in Java?
In Java, the thread-safe singleton pattern can be achieved using one of the following approaches:

Eager initialization - In this approach, the singleton instance is created at the time of class loading. This ensures that the instance is created only once and is thread-safe.

Lazy initialization with synchronized keyword - In this approach, the instance is created only when needed, but the method for creating the instance is synchronized to ensure thread safety.

## 4.  What do you understand by the Open-Closed Principle (OCP)?
The Open-Closed Principle (OCP) is a design principle in object-oriented programming that states that software entities (classes, modules, functions, etc.) should be open for extension but closed for modification. This means that you should be able to extend the behavior of a class or module without modifying its source code. Instead of changing the original code, you should create new code that adds or overrides the existing behavior.

## 5.  what do you understand by the iskov Substitution Principle?
The Liskov Substitution Principle (LSP) is a fundamental principle in object-oriented programming (OOP) that defines the behavior of subtyping. It was introduced by Barbara Liskov in a 1987 paper, "Data Abstraction and Hierarchy." The principle states that if S is a subtype of T, then objects of type T may be replaced with objects of type S (i.e., objects of type S may be substituted for objects of type T) without altering any of the desirable properties of the program (correctness, task performed, etc.).

## 6.  Liskov's substitution principle states that if class B is a subtype of class A, then object of type A may be substituted with any object of type B. What does this actually mean? (from OA ) choose your answer.
1.  It mean that if the object of type A can do something, the object of type B could also be able tp
    perform the same thing
2.  It means that all the objects of type A could execute all the methods present in its subtype B
3.  It means if a method is present in class A, it should also be present in class B so that the object of
    type B could substitute object of type A.
4.  It means that for the class B to inherit class A, objects of type B and objects of type A must be same.

I choose 3.

## 7.  Watch the design pattern video, and type the code, submit it to code questions folder
check folder MavenProject/hw3_design_pattern
