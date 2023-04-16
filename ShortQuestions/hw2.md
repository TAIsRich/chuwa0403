# HW2
## 1. Write up Example code to demonstrate the three fundamental concepts of OOP.
Please see:
* `/coding1/EncapsulationExample.java`
* `/coding1/InheritanceExample.java`
* `/coding1/PolymorphismExample.java`

## 2. What is wrapper class in Java and Why we need wrapper class?
Wrapper class is a class that encapsulates a primitive data type into an object. Since Java
is an OOP language, so wrapper class provide a way to deal with them as objects. And we can
use them as generics, such as `List<Integer>`.

Some wrapper classes:
* `Byte`
* `Short`
* `Integer`
* `Long`
* `Float`
* `Double`
* `Character`
* `Boolean`

## 3. What is the difference between HashMap and HashTable?
Differences:
1. Hashtable is synchronized, so it is thread-safe, but HashMap is not synchronized. We can use `ConcurrentHashMap` instead.
2. Hashtable does not allow null key or null values, but HashTable could.
3. Hashtable inherits from Dictionary, but HashMap inherits from AbstractMap and implements the Map interface
4. Hashtable is slower because of synchronization.


## 4. What is String pool in Java and why we need String pool?
String pool is a piece of Java heap memory to store String objects. It is used to optimize memory usage by reusing the String objects.
If user instantiates multiple String objects with same content, like `String s1 = "abc"`, the String pool will record `abc` in the memory and reuse it in the next time.

```
String s1 = "abc"
String s2 = "abc" //same instance as s1
String s3 = new String("abc) // different instance as s1, s2
```

## 5. What is Java garbage collection?
Java GC is an automatic mechanism provided by JVM to manage the object lifecycle. So we don't need to 
manually allocate or free the memory. The GC collector will find the object that is no longer reachable, and remove these objects
from the heap. There are some GC strategies such as generational garbage collection, mark-and-sweep, and concurrent mark-and-sweep
## 6. What are access modifiers and their scopes in Java?
Access modifiers are Java keywords to restrict the access scope to class, methods and variables.
* `default` declarations are visible only within the package (package private)
* `private` declarations are visible within the class only
* `protected` declarations are visible within the package or all subclasses
* `public` declarations are visible everywhere
* 
## 7. What is final keyword?(Filed,Method,Class)
### Variable
Value cannot be changed once it is initialized. `public static final String APP_NAME=“testApp”`


### Method
Method cannot be overridden by a subclass.
`public final int add(int a, int b){ return a + b; }`

### Class
Class cannot be extended. And it is immutable
`final class MyClass() {}`

## 8. What is static keyword?(Filed,Method,Class).When do we usually use it?
### static variable
The static variable belongs to the class, it is initialized before calling the constructor 
```java
public class A {
    static int a = 1;
}
```

### static block
The static block is used to perform one-time setup, it executed before the object initialization
```java
public class A {
    static {
        System.out.println("before constructor");
    }
}
```

### static method
The static method belongs to the class, it can be called without instantiate the class. It can only access static content.
```java
public class A {
    static int i;
    public static void main() {
        i++;
    }
}
```

### static inner class
A static inner class is a nested class which is a static member of the outer class. A static nested class does not have
access to the instance variables and methods of the outer class. It can be accessed without instantiating the outer class.
we use a non-static nested class (or inner class) if you require access to an enclosing instance's non-public fields and methods. Use a static nested class if you don't require this access.

```java
public class Outer{
    static class Inner{
        public void a() {
            
        }
    }

    public static void main(String args[]) {
        Outer.Inner nested = new Outer.Inner();
        nested.a();
    }
}
```
## 9. What is the differences between overriding and overloading?
### Override
When subclass create a same-signature method as its supper class. Must have same name, return type and parameters.
And the access modifier can only extend the scope.
```java
class Parent {
    protected void a(int i) {
        
    }
}

class Child extends Parent {
    @Override
    public void a(int i) {
        
    }
}
```

### Overload
When a class has multiple methods with same name but different parameters. Return type can be same or different.
```java
class A {
    public void a() {
        
    }
    
    public void a(int i) {
        
    }
    
    public int a(int i, int j) {
        return i + j;
    }
}
```

## 10. What is the differences between super and this?
`Super`: refer to super class, or calling the parent constructor  `super(i, j, k)`

`this`: refer to current class `this.i = 10`
## 11. What is the Java load sequence?
It is the order of element initialized by the JVM. 
1. **Loading**: The JVM loads the class files into memory
2. **Verification**: Makes sure that the class is not corrupted and is structurally correct
3. **Preparation**: Initializing its static contents to default values;
4. **Resolution**: Checking that the symbolic references in the runtime constant pool actually point to valid classes of the required types
5. **Initialization**: It runs the class’s initializer. During initialization, the static fields are initialized to whatever values are specified in the code
6. **Execution**: Run the java application

## 12. What is Polymorphism ? And how Java implements it ?
Polymorphism is a fundamental concept in object-oriented programming that refers to the ability of an object to take on many forms. 
In Java, polymorphism is implemented through method overriding and method overloading. Allowing an object to take on many forms and providing multiple implementations for a single concept.

## 13. What is Encapsulation ? How Java implements it? And why we need encapsulation?
Encapsulation refers to the idea of wrapping data and methods within a single unit, or object. 
Encapsulation is implemented through the use of classes and objects, and by using access modifiers

```java
class A {
    private int a;
    
    public int getA() {
        return a;
    }
    
    public void setA(int a) {
        this.a = a;
    }
}
```
## 14. What is Interface and what is abstract class? What are the differences between them?
An interface in Java is a blueprint for a class that defines a set of methods that a class must implement

An abstract class in Java is a class that cannot be instantiated on its own, but it can be used as a base class for other classes.
Difference:
1. An interface does not mainly responsible for providing concrete methods, but abstract class could.
2. An interface cannot have constructor, but abstract class could.
3. A class can only extends one class, but it can implement multiple interfaces.
4. An interface can only contain `public` methods, but abstract class could contain all level modifiers
5. An abstract class can have all four; static, non-static and final, non-final variables. But interface only has final and static variables are used.

## 15. (OOD) Design a parking lot (put the code to codingQuestions/coding1 folder)
Pleases see `/Coding/coding1/ParkingLot.java`

## 16. What are Queue interface implementations and what are the differences and when to use what?

The Queue interface defines a set of FIFO collections. Here are the implementaions:
1. `LinkedList`: uses a linked list to store elements, null elements are allowed in the LinkedList implementation but not in the ArrayDeque implementation. The best operation in a LinkedList implementation is removing the current element during the iteration. LinkedList implementations are not ideal structures to iterate.
2. `ArrayDeque`: uses a resizeable array to store elements, it is faster than LinkedList. If you need add/remove of the both ends, ArrayDeque is significantly better than a linked list. Random access each element is also O(1) for a cyclic queue. It is a generally better choice. 
3. `BlockingQueue` is a child interface which provides additional methods for handling thread synchronization