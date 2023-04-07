## 1.  Write up Example code to demonstrate the three foundmental concepts of OOP.

### Encapsulation
```
public class BankAccount {
    private double balance;

    public BankAccount(double initialBalance) {
        this.balance = initialBalance;
    }

    public void deposit(double amount) {
        balance += amount;
    }

    public void withdraw(double amount) {
        balance -= amount;
    }

    public double getBalance() {
        return balance;
    }
}
```
In this example, the balance instance variable is encapsulated by making it private. This means that it can only be accessed within the BankAccount class itself, and not by any other classes or objects.

### Polymorphism
```
public class Animal {
    public void makeSound() {
        System.out.println("The animal makes a sound");
    }
}

public class Dog extends Animal {
    @Override
    public void makeSound() {
        System.out.println("The dog barks");
    }
}

public class Cat extends Animal {
    @Override
    public void makeSound() {
        System.out.println("The cat meows");
    }
}
```
In this example, we have a base class Animal with a method makeSound(). This method is overridden in the Dog and Cat subclasses, which provide their own implementation of the makeSound() method.

### Inheritance
```
public class Animal {
    public void eat() {
        System.out.println("The animal eats");
    }

    public void sleep() {
        System.out.println("The animal sleeps");
    }
}

public class Dog extends Animal {
    public void bark() {
        System.out.println("The dog barks");
    }
}
```
In this example, we have a base class Animal with two methods eat() and sleep(). The Dog class extends the Animal class and inherits these methods. Additionally, the Dog class provides its own method bark().

## 2.  What is wrapper class in Java and Why we need wrapper class?

In Java, a wrapper class is a class that "wraps" or encapsulates a primitive data type into an object. Each primitive data type has a corresponding wrapper class in Java.

For example:

`boolean` -> `Boolean`

`int` -> `Integer`

`double` -> `Double`

`char` -> `Character`


## 3.  What is the difference between HashMap and HashTable?

1. `HashTable` is synchronized while `HashMap` isn't, which means `HashTable` is thread-safe. 
2. `HashMap` has higher performance because it's not synchronized.
3. `Hashtable` does not allow null keys or values, whereas `HashMap` allows one null key and any number of null values.
4. `HashMap` does not guarantee any specific iteration order, whereas `Hashtable` iterates in the order in which the elements were added.

## 4.  What is String pool in Java and why we need String pool?

In Java, the string pool is a special area of memory that is used to store literal string values. When a string literal is encountered in Java code, the JVM checks whether the same string already exists in the string pool. If it does, a reference to the existing string is returned. If not, a new string is created and added to the string pool.

Reasons:

1. Memory optimization: The string pool allows Java to reuse string literals, which can reduce the amount of memory used by a Java program.
2. Performance optimization: Since the string pool allows Java to reuse string literals, it can improve the performance of Java programs by reducing the amount of garbage collection required and by allowing for faster string comparisons.
3. The string pool can also be used to perform string interning, which is the process of creating a single instance of a string literal in memory and sharing it across multiple references.

## 5.  What is Java garbage collection?

Java garbage collection is a mechanism used by the Java Virtual Machine (JVM) to automatically manage memory allocation and deallocation for Java objects. When a Java program creates an object, the JVM allocates memory for that object on the heap. When the object is no longer needed, the memory allocated to it is deallocated and made available for other objects to use.

## 6.  What are access modifiers and their scopes in Java?

In Java, access modifiers are keywords used to control the visibility and accessibility of class members (fields, methods, and nested classes). There are four types of access modifiers in Java:

1. `public`: A public class member can be accessed from anywhere in the Java program.

2. `protected`: A protected class member can be accessed within the same package or by a subclass in a different package. It cannot be accessed by other classes outside the package or by non-subclasses outside the package.

3. `default` (also known as package-private): A default class member can only be accessed within the same package. It is not accessible by classes outside the package.

4. `private`: A private class member can only be accessed within the same class. It is not accessible by any other class, including subclasses.

## 7.  What is final key word? (Filed, Method, Class)

In Java, the `final` keyword is used to declare a constant or an entity that cannot be modified. Once a variable, method, or class is marked as final, its value or implementation cannot be changed.

There are several uses for the `final` keyword in Java:

1. `Constants`: The `final` keyword can be used to declare constants, which are values that never change. For example, final int MAX_VALUE = 100; declares a constant integer variable named MAX_VALUE with a value of 100.

2. `Method`: The `final` keyword can be used to declare a method that cannot be overridden in a subclass. This is useful when a method's implementation should never change, or when a class wants to prevent subclasses from modifying a particular method.

3. `Class`: The `final` keyword can be used to declare a class that cannot be subclassed. This is useful when a class's behavior should never be modified or when a class wants to prevent other classes from extending it.

## 8.  What is static keyword? (Filed, Method, Class). When do we usually use it?

In Java, the `static` keyword can be applied to fields, methods, and inner classes, and it is used to denote that they belong to the class rather than to an instance of the class.


1. Static fields are shared by all instances of the class, and they can be accessed using the class name. For example, a static field count can be accessed as MyClass.count, rather than creating an instance of the class and accessing it as myObject.count. Static fields are initialized only once when the class is loaded into memory, and they remain in memory until the program ends.

2. Static methods are associated with the class rather than with an instance of the class. They can be called using the class name, for example, MyClass.staticMethod(), without the need to create an instance of the class. Static methods are useful for performing operations that do not require access to instance variables, or when a method should be shared by all instances of the class.

3. Static classes are nested classes that do not require an instance of the outer class to be created. They are useful for grouping related utility methods or constants, and they can be accessed using the outer class name, for example, MyClass.StaticNestedClass.

## 9.  What is the differences between overriding and overloading?

Overriding refers to the ability of a subclass to provide a different implementation of a method that is already defined in its superclass.

Overloading, on the other hand, refers to the ability of a class to define multiple methods with the same name but with different parameters.

## 10.  What is the differences between super and this?

`super` is used to refer to the superclass of the current class. It can be used to call the superclass constructor or a method that is overridden by the subclass. super can also be used to access superclass fields and methods that are hidden by fields and methods in the subclass.

`this`, on the other hand, is used to refer to the current instance of the class. It is typically used to refer to instance variables, methods, and constructors within the same class. this can also be used to call another constructor in the same class, or to pass the current instance of the class as a parameter to a method or constructor.

## 11.  What is the Java load sequence?

In Java, the load sequence refers to the order in which classes are loaded by the Java Virtual Machine (JVM) at runtime. The Java load sequence includes three phases: loading, linking, and initialization.

1. Loading: During the loading phase, the JVM reads class files and creates a binary representation of the class in the method area of the JVM. This includes loading the class and its superclass, interfaces, and other dependent classes.

2. Linking: During the linking phase, the JVM performs three sub-phases: verification, preparation, and resolution.

3. Initialization: During the initialization phase, the static initializer blocks and static variable initializers of the class are executed in the order they appear in the source code. This phase is triggered when the class is first used by the program, such as when an instance of the class is created or a static method or field is accessed.

## 12.  What is Polymorphism ? And how Java implements it ?

The word polymorphism means having many forms. In simple words, we can define polymorphism as the ability of a message to be displayed in more than one form.

In Java polymorphism is mainly divided into Compile-time Polymorphism and Runtime Polymorphism

1. Compile-time polymorphism is also known as static polymorphism. This type of polymorphism is achieved by function overloading or operator overloading. 

Method Overloading: This refers to creating multiple methods in a class with the same name, but with different parameters. Java determines which method to call at runtime based on the number, order, and types of the arguments passed to the method.

2. Runtime polymorphism is also known as Dynamic Method Dispatch. It is a process in which a function call to the overridden method is resolved at Runtime. This type of polymorphism is achieved by Method Overriding.

Method Overriding: This refers to defining a method in a subclass with the same name and signature as a method in its superclass. When the method is called on an object of the subclass, Java will call the overridden method in the subclass instead of the method in the superclass.

## 13.  What is Encapsulation ? How Java implements it? And why we need encapsulation?

1. Encapsulation is a concept in object-oriented programming that involves combining data and methods that operate on that data into a single unit, and then restricting access to the data from outside that unit.
2. In Java, encapsulation is implemented through the use of access modifiers such as `private`, `public`, and `protected`. These modifiers control the visibility of class members (i.e., fields and methods) from outside the class.
3. Encapsulation helps to ensure that the data is accessed and manipulated only in a controlled manner, which can help improve the reliability and security of the code.

## 14.  What is Interface and what is abstract class? What are the differences between them?

An interface is a collection of abstract methods and constant fields that define a contract for a class to implement. Interfaces can also contain default and static methods, as well as nested types.

An abstract class is a class that cannot be instantiated, but can contain both abstract and non-abstract methods and fields. Abstract classes are used to define a base class or template for a set of related classes that share some common behavior or attributes.

The main differences between interfaces and abstract classes in Java are:

1. Implementation: An interface only defines the contract that must be implemented by a class, while an abstract class can provide partial implementation of its methods.

2. Inheritance: A class can implement multiple interfaces, but can only extend a single abstract class.

3. Fields: An interface can only contain constant fields, while an abstract class can contain both constant and non-constant fields.

4. Access modifiers: All methods in an interface are implicitly public, while an abstract class can have methods with different access modifiers.

## 15.  (OOD) Design a parking lot (put the code to codingQuestions/coding1 folder, )

check folder Coding/coding1

## 16.  What are Queue interface implementations and what are the differences and when to use what?

The Queue interface represents a collection that orders its elements in a specific way for processing. There are several implementations of the Queue interface in Java, each with its own characteristics and suitable use cases:

1. `LinkedList`: This implementation provides a doubly-linked list implementation of the Queue interface. It is efficient for add and remove operations at both ends of the list, but accessing elements in the middle of the list can be slower. Use LinkedList if you need a basic implementation of the Queue interface that can efficiently add and remove elements from both ends of the list.

2. `ArrayDeque`: This implementation provides a resizable-array implementation of the Queue interface. It is efficient for add and remove operations at both ends of the queue and provides constant-time performance for these operations. Use ArrayDeque if you need a Queue implementation that can handle a large number of elements and can efficiently add and remove elements from both ends of the queue.

3. `PriorityQueue`: This implementation provides a priority queue implementation of the Queue interface. Elements are ordered based on their natural order or a custom comparator. Use PriorityQueue if you need a Queue implementation that orders its elements based on priority.

4. `ConcurrentLinkedQueue`: This implementation provides a thread-safe implementation of the Queue interface. It is optimized for multi-threaded access and provides high throughput and low latency. Use ConcurrentLinkedQueue if you need a Queue implementation that can be safely accessed from multiple threads.

5. `LinkedBlockingQueue`: This implementation provides a bounded implementation of the Queue interface, meaning that it has a fixed capacity. It is thread-safe and optimized for multi-threaded access. Use LinkedBlockingQueue if you need a Queue implementation that has a fixed capacity and can be safely accessed from multiple threads.