### Q1
see `Coding` folder

### Q2:  What is the checked exception and unchecked exception in Java, could you give one example?
* Checked exceptions are those that must be handled explicitly by the programmer. If a method throws a checked exception, then the calling method must either handle that exception or declare it in its own throws clause.
*  Examples of checked exceptions include IOException, SQLException, and ClassNotFoundException.
* Unchecked exceptions are those that do not need to be explicitly handled by the programmer. These exceptions are generally caused by programming errors such as null pointer dereferences or array index out of bounds errors.
* Examples of unchecked exceptions include NullPointerException, ArrayIndexOutOfBoundsException, and ClassCastException.

### Q3: Can there be multiple finally blocks?
No


### Q4: When both catch and finally return values, what will be the final result ?

If both `catch` and `finally` blocks contain return statements in a Java program, then the value returned from the method will depend on which block executes last.

If the `finally` block executes after the `catch` block, then the value returned from the method will be the one returned by the `finally` block. This is because the `finally` block always executes, regardless of whether an exception is thrown or not. Therefore, if a `finally` block contains a return statement, it will override any previous return statement in the `catch` block.

### Q5: What is Runtime/unchecked exception ? what is Compile/Checked Exception?

A checked exception is an exception that must be declared in a method's signature using the `throws` keyword, or handled with a try-catch block. The compiler checks whether the method handles or declares the checked exception, and generates an error if neither is done.

An unchecked exception is an exception that can occur at runtime without being explicitly declared in the code.

### Q6: What is the difference between throw and throws ?

`throw` is used to explicitly throw an exception from a method or block of code. When `throw` is used, the specified exception is thrown and the execution of the program is immediately transferred to the nearest catch block that can handle that exception.

`throws` is used to declare that a method may throw one or more types of exceptions. This is done by adding the `throws` keyword followed by the name of the exception(s) to the method signature.

`throw` is used to throw an exception explicitly from a block of code, while `throws` is used to declare that a method may throw an exception.

### Q7:  Run the below three pieces codes, Noticed the printed exceptions. why do we put the Null/Runtime exception before Exception ?

It is recommended to handle more specific exceptions before more general exceptions because the catch blocks are evaluated in the order in which they appear in the code. If a more general exception is caught before a more specific exception, the more specific exception will never be caught and the program may not behave as expected.

### Q7: Why finally always be executed ?

The reason why `finally` always gets executed is because it is designed to provide a way to perform cleanup actions, such as closing a file or releasing a resource, regardless of whether an exception occurred or not. By placing the cleanup code in a `finally` block, you can be sure that it will always be executed, even if an exception is thrown.


### Q8: What are the types of design patterns in Java ?

In Java, design patterns can be categorized into three main categories:

1.  Creational Design Patterns: Creational design patterns deal with object creation mechanisms, trying to create objects in a manner suitable to the situation. The basic approach to object creation could otherwise result in added complexity to a project.

Some examples of Creational Design Patterns are:

-   Singleton Pattern
-   Factory Method Pattern
-   Abstract Factory Pattern
-   Builder Pattern
-   Prototype Pattern

2.  Structural Design Patterns: Structural design patterns are concerned with object composition and make up of classes. These patterns use inheritance to compose interfaces and define ways to compose objects to obtain new functionality.

Some examples of Structural Design Patterns are:

-   Adapter Pattern
-   Bridge Pattern
-   Composite Pattern
-   Decorator Pattern
-   Facade Pattern
-   Flyweight Pattern
-   Proxy Pattern

3.  Behavioral Design Patterns: Behavioral design patterns deal with the communication between objects, responsibilities, and algorithms that are encapsulated. It is concerned with communication between objects and defining the flow of control in a program.

Some examples of Behavioral Design Patterns are:

-   Chain of Responsibility Pattern
-   Command Pattern
-   Interpreter Pattern
-   Iterator Pattern
-   Mediator Pattern
-   Memento Pattern
-   Observer Pattern
-   State Pattern
-   Strategy Pattern
-   Template Method Pattern
-   Visitor Pattern

These design patterns are not specific to Java, but rather are general solutions to common programming problems that can be implemented in many programming languages.


### Q9: What are the SOLID Principles ?

SOLID is an acronym that stands for five important design principles in object-oriented programming that are used to develop software that is easy to maintain, extend, and understand. These principles are:

1.  Single Responsibility Principle (SRP): This principle states that a class should have only one reason to change. In other words, a class should have only one responsibility or job. This makes the class more maintainable, testable, and easier to understand.

2.  Open-Closed Principle (OCP): This principle states that software entities (classes, modules, functions) should be open for extension but closed for modification. This means that you should be able to add new features or behaviors to a system without modifying its existing code.

3.  Liskov Substitution Principle (LSP): This principle states that subtypes must be substitutable for their base types. In other words, if a program is written to use a base type, it should be able to use any of its subtypes without any problems. This principle ensures that the program is resilient to change and can be easily extended.

4.  Interface Segregation Principle (ISP): This principle states that a class should not be forced to implement interfaces it doesn't use. Instead, it should be segregated into smaller and more specific interfaces. This makes the code more modular and easier to understand.

5.  Dependency Inversion Principle (DIP): This principle states that high-level modules should not depend on low-level modules. Instead, both should depend on abstractions. Furthermore, abstractions should not depend on details. This makes the code more flexible and easier to maintain.

### Q10: How can you achieve thread-safe singleton patterns in Java ?

1.  Eager initialization: In this approach, the singleton instance is created at the time of class loading. This approach is thread-safe because the instance is created before any threads are spawned.
2.  Lazy initialization with synchronized method: In this approach, the singleton instance is created lazily only when required. The `getInstance()` method is marked as synchronized to prevent multiple threads from creating multiple instances of the singleton class.
3.  Lazy initialization with double-checked locking: In this approach, the singleton instance is created lazily and the `getInstance()` method checks if the instance is null before acquiring the lock. This avoids the overhead of synchronization every time the method is called.

### Q11: What do you understand by the Open-Closed Principle (OCP) ?

The Open-Closed Principle (OCP) is one of the SOLID principles of object-oriented design. It states that software entities (classes, modules, functions, etc.) should be open for extension but closed for modification. In other words, the behavior of a class or module can be extended without modifying its source code.


### Q12

Option 1.


### Q13

See `MavenProject`

### Q14

Done
