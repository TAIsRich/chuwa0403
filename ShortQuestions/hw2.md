# HW2

## 1. Write up Example code to demonstrate the three fundamental concepts of OOP.
Please see in Coding/OOP

## 2. What is wrapper class in Java and Why we need wrapper class?
In Java we have wrapper classes as `Byte`, `Short`, `Integer`, `Long`, `Float`, `Double`, `Boolean` and `Character`.  

Java is Object-Oriented Programming language, so all should be objects. Primitive data types are not objects, but Wrapper Classes provide a way to use primitive data types as objects. And sometimes we must use Wrapper Classes, for example when we use `Collection` objects, which apply only on Wrapper Classes.

Below copied from internet:
1.	They convert primitive data types into objects. Objects are needed if we wish to modify the arguments passed into a method (because primitive types are passed by value).
2.	The classes in java.util package handles only objects and hence wrapper classes help in this case also.
3.	Data structures in the Collection framework, such as ArrayList and Vector, store only objects (reference types) and not primitive types.
4.	An object is needed to support synchronization in multithreading.

## 3. What is the difference between HashMap and HashTable?
- Thread safe & performance:  
HashMap is not thread safe, hence it has better performance  
HashTable is thread safe, so it has lower performance compared with HashMap
- Allow null:  
HashMap allows one null key. HashTable doesn’t allow null key.  
Because there is some difference when it comes to hashing the key. HashTable calls the `hashcode()` method directly which doesn’t allow null as input. HashMap would check if the key is null in the first place. If the key is null, it would take 0 as the hash, otherwise it would call the `hashcode()` method

## 4. What is String pool in Java and why we need String pool?
String Pool in java is a pool of Strings stored in Java Heap Memory.  
String Pool is possible only because String is immutable in Java and its implementation of String interning concept.  
When we use double quotes to create a String, it first looks for String with the same value in the String pool, if found it just returns the reference else it creates a new String in the pool and then returns the reference. (However using new operator, we force String class to create a new String object in heap space. )  

String pool helps in saving a lot of space. Also it helps to avoid frequently creating and destroying objects which takes computation power. 

摘自总结：直接赋值产生1或0个对象，使用`new String()`赋值时产生2或1对象，赋值时先看字符串常量池，如果字符串常量池中没有，就在常量池中创建一个，如果有，前者直接引用，后者在堆内存中还需创建一个`“xyz”`实例对象（此时引用变量指向的是堆内存中创建的实例对象，而不是常量池中的实例对象）。所以，在日常开发中，能用`String s = "xyz"`;`尽量不用String s = new String("xyz")`;，因为可以少创建一个对象，节省一部分空间。  
调用`StringBuilder`创建的String是不会被注册到String Pool中的。String concatenation中除了直接拼接两个literal：`String str = “aa” + “bb”`，其余情况JVM都会调用`StringBuilder`。但是可以使用`intern( )`方法来强制在Spring Pool中注册


## 5. What is Java garbage collection?
It is a process in java that is to recycle automatically the unused memory.  
The garbage collector will count the number of reference to objects. When the number of references becomes 0, garbage collector will destroy the objects and recycle the memory.  

Call `System.gc()` to force a garbage collection  
Call `.finalize()` to perform a garbage collection
-	`finalize()` is a garbage collection method, that performs cleanup before the object gets destroyed.
-	`finalize()`, rarely used it. Besides it is deprecated from java11.

## 6. What are access modifiers and their scopes in Java?
-	`Public`: can be accessed from anywhere
-	`Private`: can be accessed only within the class
-	`Protected`: can be accessed from anywhere within the same package and any subclass
-	`Default`: can be access from anywhere within the same package  

Scopes are class level, method level and attribute level

## 7. What is final keyword? (Field, Method, Class) 
-	Class: A final class can’t be inherited
-	Method: A final method can’t be overridden
-	Variable: A final variable value can’t be changed once it gets initialized. If it is a primitive varaible, the value means the value. If it is a reference variable, it means the memory address can’t be changed, means that this reference variable cannot point to another object. 


## 8. What is static keyword? (Field, Method, Class). When do we usually use it?
-	Class: A class can be made static only if it is a nested class. Nested static class doesn’t need a reference of Outer class.
-	Method: is a method that can be called without instantiating a class object
Static method can call only static method, it cannot call non static method
  -	Variable: it gets created when class is loaded. Static variables are initialized before any object of that class is created, before any static method of the class executes.  
There’s only one copy of it and all the instances of the class get access to it    
Basically, static is used for a constant variable or a method that are shared by all the instances of the class. Another scenario is that we use static for utility methods which can be called without instantiating the class

## 9. What is the differences between overriding and overloading?
**Override**: This happens when a subclass has the same method as its parent class but implements it in a different way  
**Overload**: This happens when there are multiple methods of the same name in the same class, and work in different ways.

| Override | Overload | 
| :-----| :----- |
| Happens during class inheritance  | Happens in the same class  |
| Same method signature, i.e. same name and method parameters  | Method names are the same but with different method parameters. E.g. constructor overloading.  |
| Method call is determined at runtime  | Method call is determined at compile time  |
Same parameters but different return type is not an overloading, and at compile time error will be generated.

## 10. What is the differences between super and this?
In short words:  
-	**Super**:  in Java is used to refer to methods, static and instance variables, constructors of an immediate parent class instance
-	**This**: in Java is used to refer to methods, static and instance variables, constructors of a current class instance
This: it refers to the current object, not the current class. So, `this.static_variable` is not correct

## 11. What is the Java load sequence?
Not quite sure if I got this question correctly, but from the pdf provided the load sequence should be as below:
1.	Static block is called
2.	Static variables are checked
3.	Class constructor is called

## 12. What is Polymorphism ? And how Java implements it ?
Polymorphism is the ability of an object to take on different forms. In Java, polymorphism refers to the ability of a class to provide different implementations of a method, depending on the type of object that is passed to the method.  

Polymorphism in Java is implemented via two different methods: overriding and overloading

## 13. What is Encapsulation ? How Java implements it? And why we need encapsulation?
Encapsulation means data hiding. This allows class member variables to be invisible and only accessible via the class methods.

Java implements it using member methods with access modifiers.

We need encapsulation because it helps to prevent data from misuse or unwanted changes from other objects

## 14. What is Interface and what is abstract class? What are the differences between them?
**Interface**: it can be seen as a group of abstract methods. But after java 8, it can have default method and static method which do have method implementation.  

**Abstract class**: it’s a class holding keyword abstract which means this class can’t be instantiated. It can have a mixture of abstract or non-abstract methods.  
A class with abstract methods must be an abstract class.  
An abstract class doesn’t have to have abstract methods. Since sometimes we just want to make it abstract to prevent user from instantiating it.

- *Constructor*: Abstract class has a constructor but an interface doesn’t
- *Multiple inheritance*: Abstract class doesn't support multiple inheritance. Interface supports multiple inheritance.
- *Variables*: Abstract class allows final, static and non-static variables. Interface allows only final and static variables.
  -	Abstract class can implement an interface, but an interface cannot extend an abstract class.
  -	An interface extends another interface. The keyword that we use is “extends”. An interface can extend multiple other interfaces 


## 15. (OOD) Design a parking lot (put the code to codingQuestions/coding1 folder, )
Please see coding/ParkingLot

## 16. What are Queue interface implementations and what are the differences and when to use what?
A queue is a data structure or a collection in Java that stores elements in a FIFO order.  

Classes that implement queue interface:  
**ArrayDeque**: This can be seen as a special kind of array that grows and allows users to add or remove an element from both sides of the queue  
**LinkedList**: Underlying implementation uses nodes to store objects, so the memory is not continuous. Typically used when we need to do a lot adding or removing operations  
**PriorityQueue**: It’s a queue that maintains order of the elements. Typically used when we want to maintain order of the elements  

*ArrayDeque vs LinkedList*: ArrayDeque is more efficient than the LinkedList for add and remove operation at both ends. The best operation in a LinkedList implementation is removing the current element during the iteration.
