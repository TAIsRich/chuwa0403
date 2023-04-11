## 1. Practice collection
Please see the Coding/hw3

## 2. What is the checked exception and unchecked exception in Java, could you give one example?

**checked exceptions**:checked at compile-time,need to be handed by catch or throws
                       include: IOEeception(eg.File not found), StackOverFlowError(e.g. CPU)	
                       
*example :*

```java 
List<Integer> list = new ArrayList<>(Arrays.asList(1,2,3));
   try {
       int value = numbers.get(3);
        System.out.println(value);
    } catch (IndexOutOfBoundsException e) {
        System.out.println("Index out of bounds: " + e.getMessage());
    }
```
**unchecked exceptions**:checked at run-time,include: NullPointerException (NPE),IndexOutOfBoundsException (e.g. List/Array)

*example :*

```java

NullPointerException:

public class Main {
    public static void main(String[] args) {
        String name = null;
        System.out.println(name.length());
    }
}
```
## 3. Can there be multiple finally blocks?

No,finally can only be used once with a try or try-catch block.

## 4. When both catch and finally return values, what will be the final result ?

The final result should be the finally return values.

## 5. What is Runtime/unchecked exception ? what is Compile/Checked Exception ?

**Checked Exception (also known as compile-time exception) :** is a type of exception that must be either caught or declared in the method in which it is thrown.
```java
public void ioOperation(boolean isResourceAvailable) {
  try {
    if (!isResourceAvailable) {
      throw new IOException();
    }
  } catch(IOException e) {
    // Handle caught exceptions.
  }
}
```
```java
public void ioOperation(boolean isResourceAvailable) throws IOException {
  if (!isResourceAvailable) {
    throw new IOException();
  }
}
```

**Unchecked Exception (also known as runtime exception):** is a type of exception that occurs during the execution of a Java program, rather than at compile time.Unlike Checked Exceptions, runtime Exceptions do not need to be declared in the method signature or caught explicitly.

## 6. What is the difference between throw and throws ?

`throw` and `throws` are two keywords in Java that are used in exception handling

**throw** is used to manually throw an exception in a method or block of code. When you throw an exception, you are indicating that something unexpected or exceptional has occurred in your program, and that the normal flow of execution cannot continue.

**throws**  is used to declare that a method may throw a particular exception. When you declare that a method throws an exception, you are indicating to the compiler and other developers that they should handle the exception appropriately when calling your method.

```java
throw new RuntimeException(); // throw
public void getOrder(String orderId) throws OrderNotFoundException { //throws
}
```
## 7. Run the below three pieces codes, Noticed the printed exceptions. why do we put the Null/Runtime exception before Exception ?

**print exceptions:**

*First codes*: java.lang.ArithmeticException: / by zero at MyClass.main(MyClass.java:7)

*Second codes*: java.lang.NullPointerException: Cannot invoke "String.equals(Object)" because "<local3>" is null at MyClass.main(MyClass.java:8)

*Third codes*: java.lang.RuntimeException at MyClass.main(MyClass.java:9)

**why do we put the Null/Runtime exception before Exception ?**

Because Null/Runtime exception is the subclass of Exception.It is easy to know the exactly exception and debug, if we put exception before Null/Runtime exception,we catch the general type first, it will catch all exceptions, including the specific ones. This can make it harder to debug the specific exceptions and handle them properly.

## 8. Why finally always be executed ?

**finally block** is a code block that is executed after a try block, regardless of whether an exception is thrown or caught. The purpose of the finally block is to execute code that must be run for resource cleanup or release, to ensure program stability and
correctness.

## 9. What are the types of design patterns in Java ?

Java design patterns are divided into three categories - creational, structural, and behavioral design patterns

**Creational patterns**: These patterns provide a way to create objects in a manner that is flexible, efficient, and maintainable. Examples include Singleton, Factory Method, Abstract Factory, Builder, and Prototype.

**Structural patterns**: These patterns deal with the composition of classes and objects to form larger structures. They make it easier to design systems by identifying relationships between different classes and objects. Examples include Adapter, Bridge, Composite, Decorator, Facade, Flyweight, and Proxy.

**Behavioral patterns**: These patterns focus on communication and interaction between objects. They provide solutions for how objects can interact with each other in a flexible and understandable way. Examples include Chain of Responsibility, Command, Interpreter, Iterator, Mediator, Memento, Observer, State, Strategy, Template Method, Visitor.

## 10. What are the SOLID Principles ?

SOLID stands for:

**S - Single-responsiblity Principle(SRP)**

A class should have only one reason to change, meaning that it should have only one responsibility.

**O - Open-closed Principle(OCP)**

Objects or entities should be open for extension but closed for modification.

**L - Liskov Substitution Principle(LSP)**

Let q(x) be a property provable about objects of x of type T. Then q(y) should be provable for objects y of type S where S is a subtype of T.

**I - Interface Segregation Principle(ISP)**

A client should never be forced to implement an interface that it doesn’t use, or clients shouldn’t be forced to depend on methods they do not use.

**D - Dependency Inversion Principle(DIP)**

Entities must depend on abstractions, not on concretions. It states that the high-level module must not depend on the low-level module, but they should depend on abstractions.

## 11. How can you achieve thread-safe singleton patterns in Java?

*In general, we follow the below steps to create a singleton class:*

1,Create the private constructor to avoid any new object creation with new operator.

2,Declare a private static instance of the same class.

3,Provide a public static method that will return the singleton class instance variable. If the variable is not initialized then initialize it or else simply return the instance variable.

```java
public class Singleton {
    private static Singleton instance;

    private Singleton() {
        // Private constructor to prevent instantiation outside the class
    }

    public static Singleton getInstance() {
        if (instance == null) {
            instance = new Singleton();
        }
        return instance;
    }
}
```

*How to achieve thread-safety in Singleton Class?*(this answer from chatGPT)

**Using synchronized keyword**: use the synchronized keyword to make the getInstance() method thread-safe by synchronizing access to the shared resource. 

```java
public class Singleton {
    private static Singleton instance;
    
    private Singleton() {}

    public static synchronized Singleton getInstance() {
        if (instance == null) {
            instance = new Singleton();
        }
        return instance;
    }
}
```
**Using double-checked locking**: check whether an instance of the class has already been created before acquiring a lock. If an instance does not exist, it then creates one while holding the lock.

```java
public class Singleton {
    private volatile static Singleton instance;

    private Singleton() {}

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
**Using an enum**: An enum can be used to create a Singleton pattern in Java. The instance of the Singleton class is created as a constant in the enum, and it is automatically thread-safe.

```java
public enum Singleton {
    INSTANCE;
    // Add methods and fields here
}
```

## 12. What do you understand by the Open-Closed Principle (OCP) ?

In object-oriented programming, the open–closed principle (OCP) states "software entities (classes, modules, functions, etc.) should be open for extension, but closed for modification"; that is, such an entity can allow its behaviour to be extended without modifying its source code.

```java
public abstract class Shape {
    public abstract void draw();
}

public class Circle extends Shape {
    public void draw() {
        // Draw a circle on the screen
    }
}
```
Without OCP,if you want to draw a circle you may add a new conditional statement to handle the Circle shape. With OCP, you would create a new class Circle that extends the Shape class and implements its own draw() method.

## 13. Liskov’s substitution principle states that if class B is a subtype of class A, then object of type A may be substituted with any object of type B. What does this actually mean? (from OA ) choose your answer.
1. It mean that if the object of type A can do something, the object of type B could also be able tp
perform the same thing
2. It means that all the objects of type A could execute all the methods present in its subtype B
3. It means if a method is present in class A, it should also be present in class B so that the object of
type B could substitute object of type A.
4. It means that for the class B to inherit class A, objects of type B and objects of type A must be same.

My Answer is 1. It means that if the object of type A can do something, the object of type B could also be able to perform the same thing.

## 14.Watch the design pattern video, and type the code, submit it to MavenProject folder

Please check MavenProject folder

## 15. CRUD MySQL and MongoDB (separated PDF)

Done

## 16. Creadit Card Notification Design

Please check MavenProject folder/hw3/MyCreditCardDsign






































