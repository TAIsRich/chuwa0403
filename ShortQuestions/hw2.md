# HW2

## 1. Write up an example of OOP.

See ~/Coding/hw2

## 2. What is a wrapper class and why we need wrapper class?

A wrapper class is a class that provides an object-oriented representation of a primitive data type.

Reasons:

1. **To convert primitive data types into objects**: primitive data types do not have any methods or properties associated with them. To perform any operation on them or use them in collections, we need to wrap them into an object using their corresponding wrapper classes.
2. **To use primitive data types in collections**: Collections in Java can only store objects. Therefore, we need to wrap primitive data types into objects using their corresponding wrapper classes to store them in collections.
3. **To pass primitive data types as objects**: Some methods in Java only accept objects as arguments. To pass primitive data types as arguments to these methods, we need to wrap them into objects using their corresponding wrapper classes.
4. **To perform operations on primitive data types**: Wrapper classes provide methods that allow us to perform various operations on the primitive data types. For example, the Integer class provides methods to convert a string to an integer and vice versa, find the maximum and minimum value of two integers, and more.

## 3. What is the difference between HashMap and HashTable?

1. Synchronization:

   - HashTable is synchronized, which means **that it is thread-safe** and can be accessed by multiple threads simultaneously without causing any concurrency issues.

   - HashMap is not synchronized by default, which means that **it is not thread-safe**. However, we can make it synchronized by using the `Collections.synchronizedMap()` method.

2. Null keys and values:

   - HashTable **does not allow null keys or null values**. If we try to add a null key or value, it will throw a `NullPointerException`.

   - HashMap **allows one null key and multiple null values**.

3. Iteration:
   - HashTable is enumerated through an Enumerator, which is a legacy class, while HashMap uses the **Iterator interface**, which is **more efficient and recommended in modern Java**.

4. Performance:

   - HashTable is **slower** than HashMap because of its synchronization and the use of the Enumerator interface.

   - HashMap is **faster** than HashTable because it is not synchronized by default and uses the more efficient Iterator interface.

In summary, both HashMap and HashTable are used to store data in key-value pairs, but HashTable is synchronized and does not allow null keys or values, while HashMap is not synchronized by default and allows one null key and multiple null values. Additionally, HashMap is faster than HashTable in terms of performance.

## 4. What is String pool in Java and why we need String pool? 

In Java, the string pool is a storage area in the **heap memory** where all string literals are stored. Whenever we create a string literal in Java, t**he JVM checks if an identical string is already present in the string pool**. If it is, then the new string literal is not created, and the existing one is returned instead. This helps in saving memory by reusing the same string objects instead of creating new ones.

We need the string pool in Java for the following reasons:

1. **Memory optimization**: By reusing the same string objects instead of creating new ones, the string pool helps in reducing the memory usage in Java programs.
2. **Performance improvement**: Since string objects are immutable in Java, reusing the same objects can improve the performance of string-related operations.
3. **Easy string comparison**: Since the string pool guarantees that identical string literals refer to the same object, we can use the `==` operator for string comparison instead of the `equals()` method, which can be faster and more convenient.

## 5. What is Java garbage collection?

Java garbage collection is a process in which the JVM (Java Virtual Machine) automatically frees up memory occupied by objects that are no longer in use by the application. In other words, it is the automatic management of memory in Java, where the JVM automatically detects and removes objects that are no longer needed by the application.

The garbage collection process in Java works as follows:

1. The JVM keeps track of all the objects created by the application.
2. It identifies the objects that are no longer in use or have no references pointing to them.
3. It frees up the memory occupied by these objects and makes it available for future use.

## 6.  What are access modifiers and their scopes in Java? 

Access modifiers in Java are keywords that are used to restrict access to classes, methods, and variables in Java. There are four access modifiers in Java, which are:

1. Public: The public access modifier allows unrestricted access to the class, method, or variable. It can be accessed from anywhere, including other packages.
2. Protected: The protected access modifier allows access to the class, method, or variable **within the same package and any subclass of the class, regardless of the package.**
3. Default (No modifier): If no access modifier is specified, the default access modifier is used. It allows **access to the class, method, or variable within the same package.**
4. Private: The private access modifier allows access only within the same class. **It cannot be accessed from outside the class**, including subclasses.

The scope of access modifiers in Java varies based on their usage. The following are the scopes of access modifiers in Java:

1. Class level: Access modifiers can be applied to a class to restrict its access from other classes.
2. Method level: Access modifiers can be applied to a method to restrict its access from other classes.
3. Variable level: Access modifiers can be applied to a variable to restrict its access from other classes.

## 7. What is final key word? (Filed, Method, Class)

1. Final Field: A final field is a constant, which means its value cannot be changed once it is initialized. It must be initialized at the time of declaration or in the constructor of the class. Once initialized, its value cannot be modified. For example:

   ```java
   public class Example {
      final int MAX_VALUE = 100;
      // other code
   }
   ```

2. Final Method: A final method is a method that cannot be overridden by a subclass. Once a method is declared as final, its implementation cannot be changed by any subclass. For example:

   ```java
   public class Example {
      public final void display() {
         // method implementation
      }
   }
   
   public class SubExample extends Example {
      // This will generate a compile-time error
      public void display() {
         // overridden method implementation
      }
   }
   ```

3. Final Class: A final class is a class that cannot be subclassed. Once a class is declared as final, it cannot be extended by any other class. For example:

   ```java
   public final class Example {
      // class implementation
   }
   
   // This will generate a compile-time error
   public class SubExample extends Example {
      // subclass implementation
   }
   ```

## 8. What is static keyword? (Filed, Method, Class). When do we usually use it?

1. Static Field: A static field is a **class-level variable** that is shared among all instances of the class. It is **initialized only once, at the time the class is loaded into memory, and its value remains the same for all instances of the class.** To access a static field, we use the syntax `ClassName.fieldName`. For example:

   ```java
   public class Example {
      static int count = 0;
      // other code
   }
   
   // Access the static field using the class name
   Example.count = 10;
   ```

2. Static Method: A static method is a class-level method that **can be called without creating an instance of the class**. It can access only static fields and other static methods of the class. To call a static method, we use the syntax `ClassName.methodName()`. For example:

   ```java
   public class Example {
      static int count = 0;
      
      public static void incrementCount() {
         count++;
      }
   }
   
   // Call the static method using the class name
   Example.incrementCount();
   ```

3. Static Inner Class: A static inner class is a **nested class that is associated with the outer class rather than with any instance of the outer class**. **It can access only static fields and other static members of the outer clas**s. To instantiate a static inner class, we use the syntax `OuterClass.InnerClass innerObject = new OuterClass.InnerClass()`. For example:

   ```java
   public class OuterClass {
      static int count = 0;
      
      public static class InnerClass {
         public void display() {
            System.out.println("Count: " + count);
         }
      }
   }
   
   // Instantiate the static inner class using the outer class name
   OuterClass.InnerClass innerObject = new OuterClass.InnerClass();
   innerObject.display();
   ```

We typically use the `static` keyword in Java when we want to define members of a class that are shared among all instances of the class, or when we want to define utility methods that can be called without creating an instance of the class. Some common use cases of the `static` keyword include defining constants, counters, factory methods, and utility classes.

## 9. What is the differences between overriding and overloading?

1. Overloading: Overloading occurs when **a class has multiple methods with the same name but different parameters**. These methods are **distinguished by their parameter lists, which can differ in the number, order, and type of their parameters.** Overloading allows us to provide multiple methods with the same name, but with different behaviors, based on the arguments that are passed. For example:

   ```java
   public class Example {
      public void print(String message) {
         System.out.println(message);
      }
      
      public void print(int number) {
         System.out.println(number);
      }
      
      public void print(String message, int number) {
         System.out.println(message + " " + number);
      }
   }
   
   Example ex = new Example();
   ex.print("Hello"); // calls print(String message)
   ex.print(42); // calls print(int number)
   ex.print("Hello", 42); // calls print(String message, int number)
   ```

2. Overriding: Overriding occurs **when a subclass provides its own implementation of a method that is already defined in its superclass.** The method in the subclass **must have the same name, return type, and parameters as the method in the superclass**. Overriding allows us to provide a specialized implementation of a method in a subclass that overrides the behavior of the method in the superclass. For example:

   ```java
   public class Vehicle {
      public void drive() {
         System.out.println("Driving...");
      }
   }
   
   public class Car extends Vehicle {
      @Override
      public void drive() {
         System.out.println("Driving a car...");
      }
   }
   
   Vehicle v = new Car();
   v.drive(); // calls drive() method of Car class
   ```

In summary, the main difference between overriding and overloading is that overriding is about providing a specialized implementation of a method in a subclass that overrides the behavior of the method in the superclass, whereas overloading is about providing multiple methods with the same name, but with different behaviors, based on the arguments that are passed.

## 10. What is the differences between super and this?

1. `super`: `super` is used to refer to the superclass of the current class. We can use `super` to call a method or access a field that is defined in the superclass, or to explicitly call a constructor of the superclass.
2. `this`: `this` is used to refer to the current instance of the class. We can use `this` to access a field or call a method that is defined in the current class, or to explicitly call a constructor of the current class.

## 11. What is the Java load sequence?

1. Loading: The class loader loads the **.class file** of the class into the memory.
2. Verification: The **bytecode of the class is verified to ensure it is valid** and does not violate any security constraints.
3. Preparation: The memory is allocated for the **static fields of the class**, and they are initialized to their default values.
4. Resolution: The **symbolic references to other classes, methods, and fields are resolved to their runtime references.**
5. Initialization: The **static blocks of the class are executed in the order they appear in the source code**, and the static fields are initialized to their explicit values.
6. Execution: The **main method of the class is executed**, and the program starts running.

## 12. What is Polymorphism ? And how Java implements it ? 

Polymorphism is the ability of an object to take on multiple forms. In Java, polymorphism is implemented through two mechanisms: method overloading and method overriding.

Polymorphism allows us to write code that can work with objects of different classes in a generic way, without knowing the specific type of the object at compile time. Java implements polymorphism through method overloading and method overriding.

## 13. What is Encapsulation ? How Java implements it? And why we need encapsulation?

Encapsulation is a fundamental concept in object-oriented programming that **refers to the practice of hiding the internal details of an object from the outside world, and providing a well-defined interface for interacting with the object.** In Java, encapsulation is **implemented using access modifiers and getter/setter methods.**

Encapsulation is important in object-oriented programming because it helps **to prevent unauthorized access to an object's internal state, and allows the object to enforce its own rules for accessing and modifying its state.** It also promotes code reusability, because objects can be reused in different parts of a program without affecting the internal details of the object.

## 14. What is Interface and what is abstract class? What are the differences between them?

An interface **is a collection of abstract methods** (methods without a body) and constants that represent a contract for what a class implementing the interface must provide. 

An abstract class is a class **that cannot be instantiated and may contain both concrete and abstract methods.**

Here are some key differences between interfaces and abstract classes:

1. Implementation: An interface defines a contract that a class must implement, while an abstract class provides a partial implementation of a class.
2. Multiple inheritance: A class can implement multiple interfaces, but can only inherit from one abstract class.
3. Access modifiers: Interface methods are by default public and abstract, while abstract class methods can have any access modifier.
4. Default method implementation: Interfaces can provide default method implementations, while abstract classes cannot.
5. Constructor: An interface cannot have a constructor, while an abstract class can.
6. Variables: Interface can only have constants (public static final fields), while abstract classes can have instance variables.

## 15. Design a parking lot

See ~/Coding/ParkingLot

## 16. What are Queue interface implementations and what are the differences and when to use what?

The `Queue` interface represents a collection of elements that can be accessed in a first-in, first-out (FIFO) order. There are several implementations of the `Queue` interface in Java, each with its own strengths and weaknesses. Here are some of the most commonly used implementations:

1. `LinkedList`: This implementation uses a linked list to store elements and is a good choice when you need to frequently add or remove elements from the beginning or end of the queue.
2. `ArrayDeque`: This implementation uses a resizable array to store elements and is a good choice when you need to frequently add or remove elements from both the beginning and end of the queue.
3. `PriorityQueue`: This implementation stores elements in a priority queue, which orders the elements based on their natural ordering (as determined by the `Comparable` interface) or a custom comparator. It is a good choice when you need to maintain a queue of elements in sorted order.
4. `BlockingQueue`: This is an interface that extends the `Queue` interface and provides additional methods for handling thread synchronization. The most commonly used implementation of `BlockingQueue` is `ArrayBlockingQueue`, which is a bounded blocking queue that uses a fixed-size array to store elements.

When to use:

- If you need to frequently add or remove elements from the beginning or end of the queue, use `LinkedList`.
- If you need to frequently add or remove elements from both the beginning and end of the queue, use `ArrayDeque`.
- If you need to maintain a queue of elements in sorted order, use `PriorityQueue`.
- If you need to handle thread synchronization, use `BlockingQueue`.