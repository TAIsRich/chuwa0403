# homework 1
## 1 Example code
see MavenProject/src/main/java/hw2
- [Encapsulation](/MavenProject/src/main/java/hw2/encapsulation/)
- [polymorphism](/MavenProject/src/main/java/hw2/polymorphism/)
- [Inheritance](/MavenProject/src/main/java/hw2/inheritance/)
## 2
Wrapper class: A wrapper class is the class that encapsulates types, so those types can create object instances and methods in another class that needs those types. Primitive wrapper class is the class that encapsulates, hides or wrps data typer from the primitive data types. (int -> Integer, double -> Double)

Why we need:

- Primitive types are passed by value. It is a restriction, if we wish to modify the arguments passed into a method.
- Some classes and data structures only accept objects, like ArrayList. 
- An object is needed to support synchronization in multithreading.

## 3
Difference between HashMap and HashTable:
- HashMap is non-synchronized. It is not thread-safe and can’t be shared between many threads without proper synchronization code whereas Hashtable is synchronized. It is thread-safe and can be shared with many threads.
- HashMap allows one null key and multiple null values whereas Hashtable doesn’t allow any null key or value.
- HashMap is generally preferred over HashTable if thread synchronization is not needed.

## 4
String pool: 
A pool of Strings stored in Java Heap Memory. String pool helps in saving a lot of space for Java Runtime although it takes more time to create the String. 

When we use double quotes to create a String, it first looks for String with the same value in the String pool, if found it just returns the reference else it creates a new String in the pool and then returns the reference. However using new operator, we force String class to create a new String object in heap space (outside the pool). We can use intern() method to put it into the pool or refer to another String object from the string pool having the same value.

Why we need:

It is created to decrease the number of String objects created in the memory. Whenever a new string is created, JVM first checks the string pool. 

Extendes:
Stack Memory Allocation and Heap Memory Allocation.
In stack memory, only the primitive data types like- int, char, byte, short, boolean, long, float and double are stored.

Whereas, in the heap memory, non-primitive data types like strings are stored. A reference to this location is held by the stack memory.

## 5
Java garbage collection:
Garbage collection in Java is the automated process of deleting code that's no longer needed or used. This automatically frees up memory space and ideally makes coding Java apps easier for developers. 

An in use object, or a referenced object, means that some part of your program still maintains a pointer to that object. An unused object, or unreferenced object, is no longer referenced by any part of your program. So the memory used by an unreferenced object can be reclaimed.

## 6
Access modifier:
Access modifiers are keywords that can be used to control the visibility of fields, methods, and constructors in a class. The four access modifiers in Java are public, protected, default, and private:

|       | same class | same package | sub class | other package|
|-------|-------------|-----------|------------|--------------|
|public| √|√|√|√|
|protected| √|√|√|x|
|default| √|√|x|x|
|private| √|x|x|x|

- Public:
If a class member like variable, method, or data members are prefixed with a public access modifier, then they can be accessed from anywhere inside the program. 
- Protected:
 This access modifier is used to access the methods or data members of a class within the same package as well as outside the package but only through inheritance. 
- Default:
It is not a keyword. Any Java members such as class or methods or data members when not specified with any access modifier they are by default considered as default access modifiers. These methods or data members are only accessible within the same package and they cannot be accessed from outside the package. 
- Private:
When the methods or data members are prefixed with a private access modifier, the visibility of these methods and data members are restricted so, they can be accessed only within the same class where they have been declared, they will not be visible to the outside world. 

## 7
Final:
Final keyword is used to indicate that a variable, method, or class cannot be modified or extended.

- Final variables: its value cannot be changed once it has been initialized. This is useful for declaring constants or other values that should not be modified.
- Final methods: it cannot be overridden by a subclass. This is useful for methods that are part of a class’s public API and should not be modified by subclasses.
- Final classes: it cannot be extended by a subclass.
- Initialization: Final variables must be initialized either at the time of declaration or in the constructor of the class. 

## 8
Static: The particular member belongs to a type itself, rather than to an instance of that type.
- Static Fields (Or Class Variables): There will always be only one copy of static field belonging to it. The value of this static field is shared across all objects of either the same class. From the memory perspective, static variables are stored in the heap memory. Only static method can be used inside static method. 
- Static Methods: use static methods to perform an operation that's not dependent upon instance creation. We also commonly use static methods to create utility or helper classes so that we can get them without creating a new object of these classes.
- Static Block: We use a static block to initialize static variables. This part is always the first to excute.
- Static Class: the static nested classes only have access to static members of the outer class and are enclosed in the only class that will access it. It provides better packaging convenience.

## 9
override: 
- "runtime polymorphism": The method call is determined at runtime based on the object type. 
-  occurs between superclass and subclass
- have the same signature (name & parameters)
- erro will be visible at runtime

overload:
- "compile time polymorphism": The method call is determined at compile time
- Occurs between the methods in the same class
- have same name, but the parameters are different
- erro will be visible at compile time

## 10
super:
used to refer super-class's instance as well as static members. It can also use to invoke super-class's method or constructor. It eliminates the confusion between the superclasses and subclasses that have methods with same name.
this:
used to refer current class's instance as well as static memebers. 

## 11
Java load sequence:
JVM determines the entry point into the program and starts running the `main` method. JVM will not load all imported classes until the JVM encounters the bytecode instructions for other class.

## 12
Polymorphism:
A class could provide different implementations of a method, depending on the type of object that is passed to the method. Java achieves this in two ways: method overloading and overriding. 

## 13
Encapsulation:
It is a mechanism of wrpping the data and code together as a single unit. A class's variables are hidden from other classes and can obly accesed by the methods of the class in which they are found.

Implementation:
Use the private access modifier to declare variables of class as private. And define public getter and setter methods to read and modify the values of these variable.

Why we need:
It can prevent unwanted access to sensitive data and hide information through access modifiers. It can reduce erroneous human changes.

## 14
Interface:
A group of related methods with empty bodyies. It is used to add more specific method to the class. Use implements keyword to add interface.

Abstract class:
A class declared `abstract`. It cannot used to create objects. It is a restricted class. It may contains abstract method. A class contains abstract method must be abstract class.

Difference:
-  In an abstract class, some methods can be implemented, while others are left abstract, meaning that they have no implementation and must be overridden by concrete subclasses. In contrast, all methods in an interface are by default abstract and must be implemented by any class that implements the interface.
- A class can inherit from only one abstract class, but it can implement multiple interfaces. 
- An abstract class can have member variables, while an interface cannot.

## 15
see coding
## 16
Queue interface:
The Queue interface is present in java.util package and extends the Collection interface is used to hold the elements about to be processed in FIFO(First In First Out) order.

Differences:
- LinkedList: A linked list implementation of the Queue interface. Elements can be added or removed from the beginning or end of the queue. 
- PriorityQueue: Elements are ordered based on their natural ordering or a specified Comparator.
- LinkedList:  Elements can be added or removed from the beginning or end of the queue.

