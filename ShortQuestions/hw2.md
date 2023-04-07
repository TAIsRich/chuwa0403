## 1. Write up Example code to demonstrate the three foundmental concepts of OOP. (reference Code Demo repo as example)

Please check Coding/src

## 2. What is wrapper class in Java and Why we need wrapper class?

**A Wrapper class** in Java is a class whose object wraps or contains primitive data types.They convert primitive data types into objects

We need wrapper class because primitive data types are not classes, they do not have corresponding methods and variables, and therefore lack various functionalities. More importantly, in some scenarios, we can only use objects and not primitive data types. For example, some containers like ArrayList and HashMap can only accept objects as elements, and there are also cases where we provide a method that may receive null as a parameter from the caller. If we use primitive data types, passing in null will cause an error.

| Primitive Data Type | Wrapper Class |
|---------------------|----------------|
| byte                | Byte           |
| short               | Short          |
| int                 | Integer        |
| long                | Long           |
| float               | Float          |
| double              | Double         |
| boolean             | Boolean        |
| char                | Character      |

## 3. What is the difference between HashMap and HashTable?

**Synchronization**: HashMap is not synchronized and therefore not thread-safe, while HashTable is synchronized and thread-safe. This means that multiple threads can safely access a HashTable instance without causing data corruption, whereas in the case of HashMap, access from multiple threads can lead to data inconsistency.

**Null keys and values**: HashMap allows one null key and any number of null values, whereas HashTable does not allow null keys or values. In HashTable, attempting to insert a null key or value will result in a NullPointerException.

**Performance**: HashMap is generally faster than HashTable since it is not synchronized. However, in situations where thread safety is required, HashTable may perform better than HashMap due to its synchronized nature.

|  HashMap  |  HashTable  |
|-----------|-------------|
| Not synchronized/Not thread-safe| Synchronized/thread-safe |
| Allows one null key and any number of null values | Does not allow null keys or values |
| Generally faster | May perform better in situations requiring thread safety |

## 4. What is String pool in Java and why we need String pool?

**What is String pool?**

The string pool is a special storage area where the JVM keeps a copy of all the string literals in the program(a string literals is like: String s = "dog");

**Why we need String pool?**

1. *More efficient and saves memory* : When a string is needed, the JVM first checks the string pool to see if an identical string already exists there. If it does, the JVM simply returns a reference to the existing string object. If it doesn't exist yet, the JVM creates a new string object and adds it to the pool.
2. *Ensure consistency and prevent errors* : Strings in the string pool are immutable, meaning that once created, they cannot be changed. This helps ensure consistency and prevent errors in the program.

## 5. What is Java garbage collection? 

+ Garbage collection is a process in Java where unused memory is recycled. 
+ Garbage collector counts the references to objects. When the number of references to an object becomes 0 in the JVM, the collector will destroy and recycle the memory. 

## 6. What are access modifiers and their scopes in Java?

**Access modifiers** in Java are keywords that determine the visibility or accessibility of a class, method, or field. There are four types of access modifiers in Java

| Modifier | Description                                                       |
|----------|-------------------------------------------------------------------|
| Default  | Declarations are visible only within the package (package private)|
| Private  | Declarations are visible within the class only                    |
| Protected| Declarations are visible within the package or all subclasses     |
| Public   | Declarations are visible everywhere                              |


## 7. What is final key word? (Filed, Method, Class)

+ Final field: When a field is marked as final, its value cannot be changed once it is assigned.
+ Final method: When a method is marked as final, it cannot be overridden in the subclass. 
+ Final class: When a class is marked as final, it cannot be extended by any subclass. 

## 8. What is static keyword? (Filed, Method, Class). When do we usually use it?

**Static field**: When a field is declared as static, it belongs to the class instead of an instance of the class.Static fields can be accessed directly using the class name and do not require an instance of the class to be created.

**Static method**: When a method is declared as static, it belongs to the class instead of an instance of the class. This means that the method can be called directly using the class name without the need for an instance of the class.

**Static class**: A static class is a class that can be accessed without creating an instance of it. This means that you can use its methods and access its fields without having to create an object of that class. Static classes cannot be instantiated or subclassed.

We usually use the `static` keyword when we want to create class-level variables or methods that are shared by all instances of the class.

## 9. What is the differences between overriding and overloading?

| Method Overloading | Method Overriding                                             |
| ------------------ | -------------------------------------------------------------- |
| Overloading happens at compile time.      | Overriding happens at runtime                                 |
| Gives better performance because the binding is being done at compile time. | Gives less performance because the binding is being done at run time. |
| Private and final methods can be overloaded. | Private and final methods can NOT be overridden.               |
| Return type of method does not matter in case of method overloading. | Return type of method must be the same in the case of overriding. |
| Arguments must be different in the case of overloading. | Arguments must be the same in the case of overriding.         |
| It is being done in the same class.       | Base and derived(child) classes are required here.              |
| Mostly used to increase the readability of the code. | Mostly used to provide the implementation of the method that is already provided by its base class. |


## 10. What is the differences between super and this?

|    | Usage                                               | Context                                            | Parameters                                               | Inheritance                                            |
|----|-----------------------------------------------------|----------------------------------------------------|----------------------------------------------------------|--------------------------------------------------------|
| this   | Refers to the current instance of a class           | Used within the same class where it is defined     | Does not take any parameters                             | Not related to inheritance                             |
| super  | Refers to the parent class or superclass            | Used in a subclass to access methods or constructors of the parent class | Can take arguments that are passed to the parent constructor or method | Used for inheritance to access methods or constructors |

**Example**:

``` java
public class Person {
  private String name;
  public Person(String name, int age) {
    this.name = name;
  }
  public String getName() {
    return this.name;
  }
}
```
*this* is used to refer to the current instance of the Person class within its own methods.
```java
public class Student extends Person {
  private String major;
  public Student(String name, int age, String major) {
    super(name, age);
    this.major = major;
  }
  public String getMajor() {
    return this.major;
  }
}
```
*super* is used to call the constructor of the Person class, which is the parent class of Student. By calling the constructor of the parent class, the name and age fields of the Person class can be initialized in the Student constructor.

## 11. What is the Java load sequence?

In Java, the load sequence refers to the order in which classes are loaded by the Java Virtual Machine (JVM). The Java class loading mechanism is a **three-step process**:

*Loading*: The JVM searches for the bytecode of the class and reads it into memory.

*Linking*: The JVM performs verification, preparation, and resolution of the class.

*Initialization*: The static variables and static initializers of the class are executed in the order they are declared in the source code.

**The sequence of loading is as follows**:

*Bootstrap Classloader*: Loads core Java classes, such as java.lang.Object and java.lang.Class.

*Extension Classloader*: Loads classes from the Java extension directories, which are specified by the java.ext.dirs system property.

*System Classloader*: Loads classes from the system classpath, which is specified by the java.class.path system property.

## 12. What is Polymorphism ? And how Java implements it ?

**Polymorphism**

In programming, polymorphism refers to the same object exhibiting different forms and behaviors.

For example, take the Shape Class. The exact shape you choose can be anything. It can be a rectangle, a circle, a polygon or a diamond. So, these are all shapes but their properties are different. This is called Polymorphism.

**Implements polymorphism**: method overloading and method overriding.

**Static Polymorphism - Overload (same class) - compile time**
```java
public class MyClass {
   public int add(int x, int y) {
      return x + y;
   }
   public double add(double x, double y) {
      return x + y;
   }
}
```
**Dynamic Polymorphism - Override (child class) - run time**
```java
public class Animal {
   public void makeSound() {
      System.out.println("The animal makes a sound");
   }
}
public class Dog extends Animal {
  @override
   public void makeSound() {
      System.out.println("The dog barks");
   }
}
```
## 13. What is Encapsulation ? How Java implements it? And why we need encapsulation?

**Encapsulation** in OOP refers to binding the data and the methods to manipulate that data together in a single unit (class).

**Implements**:access modifiers and getter(),setter()

Java implements encapsulation by using access modifiers such as private, public, and protected to control access to class members (fields and methods). Private members are only accessible within the class in which they are defined. Other classes can only access them through getter and setter methods provided by the class.

```java
public class User {
    private String userName;
    public String getUserName() {
        return userName;
    }
    public void setUserName(String userName) {
        this.userName = userName;
    }
}
public static void main(String[] args) {
        User user = new User();
        user.setUserName("Min He");
        user.getUserNme();
}
 ```
 **Why?**
 
+ Data security: Encapsulation helps to protect the data of a class from unwanted access and manipulation by external code.

+ Code maintenance: Encapsulation makes it easier to modify and maintain code by limiting the impact of changes to the internal implementation of a class.

+ Code reusability: Encapsulation allows classes to be used as building blocks for other classes, making code more reusable.

+ Abstraction: Encapsulation allows the implementation details of a class to be hidden, allowing the class to be treated as a black box with a well-defined interface.

## 14. What is Interface and what is abstract class? What are the differences between them?

**interface**: A collection of abstract methods and constant variables. It provides a contract for the implementation classes that implement it, defining what methods they should implement and what constants they should define. An interface can be seen as a pure template for a set of methods that an implementing class must provide.

**abstract class** : A class that cannot be instantiated directly and may contain abstract methods or concrete methods with implementation. An abstract class can also contain instance variables, constructors, and static methods. Abstract classes are designed to be extended by subclasses that provide specific implementation details for the abstract methods.

|      | Interface | Abstract class |
|------|-----------|----------------|
| Usage | Implements | Extends |
| Multiple Inheritances | Implement several interfaces | Only one abstract class |
| Access Modifiers | The interface does not have access modifiers. Everything defined inside the interface is assumed public modifier. | Abstract class can have an access modifier. |
| When to use | It is better to use interface when various implementations share only method signature. Polymorphic hierarchy of value types. | It should be used when various implementations of the same kind share a common behavior. |
| Implementation | Interface can have only abstract methods. An abstract class can have abstract and non-abstract methods. From Java 8, it can have default and static methods also. From Java 9, it can have private concrete methods as well. | An abstract class can give complete, default code which should be overridden |
| Defined fields only | Static and final variables | Abstract class can have final, non-final, static and non-static variables. |
| Constructor or destructors | An interface cannot declare constructors or destructors. | An abstract class can declare constructors and destructors. |
| Abstract keyword | In an abstract interface, the keyword is optional for declaring a method as an abstract. | In an abstract class, the abstract keyword is compulsory for declaring a method as an abstract. |

## 15. (OOD) Design a parking lot (put the code to codingQuestions/coding1 folder)

Please check codingQuestions/coding1 folder

## 16. What are Queue interface implementations and what are the differences and when to use what?

Java Queue is a part of the Collection Framework and implements Collection interface. So it supports all methods of Collection interface such as insertion, deletion and so on. The most frequently used implementations of Queue are LinkedList, ArrayDeque and PriorityQueue

**LinkedList**: LinkedList is a doubly linked list implementation of the Queue interface in Java. It provides efficient insertion and removal of elements at both ends of the queue, which makes it suitable for use cases where elements are frequently added and removed from both ends of the queue. LinkedList also allows null elements and maintains the insertion order of elements.

When to use LinkedList: LinkedList is a good choice for implementing a queue when the number of elements in the queue is not known in advance, and frequent insertion and removal of elements is required at both ends of the queue.

**ArrayDeque**: ArrayDeque is a resizable array implementation of the Queue interface in Java. It provides efficient insertion and removal of elements at both ends of the queue, and it is suitable for use cases where elements are frequently added and removed from both ends of the queue and the size of the queue is known in advance. ArrayDeque does not allow null elements and maintains the insertion order of elements.

When to use ArrayDeque: ArrayDeque is a good choice for implementing a queue when the number of elements in the queue is known in advance, and frequent insertion and removal of elements is required at both ends of the queue.

**PriorityQueue**: PriorityQueue is an ordered implementation of the Queue interface in Java. It maintains the elements in a priority order based on their natural ordering or a custom comparator. It provides efficient insertion and removal of elements based on their priority. PriorityQueue does not allow null elements, and it does not maintain the insertion order of elements.

When to use PriorityQueue: PriorityQueue is a good choice for implementing a queue when elements need to be processed in a specific order based on their priority. 