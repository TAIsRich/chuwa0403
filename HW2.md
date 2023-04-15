### Q1
see `Coding/Example.java`

### Q2: What is wrapper class in Java and Why we need wrapper class?
* In Java, a wrapper class is a class that provides an object-oriented representation of a primitive data type.
* Wrapper classes are needed in Java because some Java APIs only work with objects and not with primitive types.
* Wrapper classes also provide a range of utility methods that allow you to perform operations on primitive data types as if they were objects.

### Q3: What is the difference between HashMap and HashTable?
HashMap and HashTable are both implementations of the Map interface in Java, but they have some key differences:

1.  Synchronization: HashTable is synchronized, while HashMap is not. This means that HashTable is thread-safe, while HashMap is not. If multiple threads are accessing a HashTable object concurrently, synchronization is handled internally to ensure that the object remains in a consistent state. In contrast, if multiple threads are accessing a HashMap object concurrently, external synchronization is required to ensure that the object remains in a consistent state.

2.  Null keys and values: HashTable does not allow null keys or values, while HashMap allows one null key and multiple null values. If you try to insert a null key or value into a HashTable, a NullPointerException will be thrown at runtime.

3.  Performance: HashMap is generally faster than HashTable because it is not synchronized. In single-threaded environments, this performance difference may not be noticeable, but in multi-threaded environments, the overhead of synchronization can significantly impact performance.

4.  Enumeration: HashTable provides an Enumeration interface to iterate over its elements, while HashMap does not. Instead, HashMap provides an Iterator interface to iterate over its elements.

### Q4: What is String pool in Java and why we need String pool?
The String pool is a pool of unique strings stored in the heap memory of the JVM. When a string is created in Java, it is stored in the String pool if the pool already contains a string with the same value. If not, a new string object is created and added to the pool.

The primary reason for having a String pool in Java is to conserve memory. Because strings are immutable in Java, many operations on strings create new string objects. Without a String pool, these operations would result in the creation of many identical strings, wasting memory. By using a String pool, the JVM can reuse existing strings instead of creating new ones, which can result in significant memory savings.

Another benefit of the String pool is that it allows for more efficient string comparison. When comparing two strings in Java, the JVM can first check if they are stored in the String pool. If they are, it can quickly determine if they are equal by comparing their references. This can be much faster than comparing the actual contents of the strings.

### Q5: What is Java garbage collection?
Java garbage collection is the automatic process of reclaiming unused memory in a Java program. When an object is created in Java, it is allocated memory in the heap, which is a region of the program's memory dedicated to storing objects. However, when an object is no longer referenced by any part of the program, it becomes eligible for garbage collection.

The garbage collector is responsible for identifying and reclaiming unused memory in the heap. It does this by periodically scanning the heap for objects that are no longer referenced by any part of the program. When it finds such an object, it marks it as garbage and frees its memory.

The process of garbage collection in Java is automatic, meaning that the programmer does not need to manually deallocate memory as in other programming languages. This can make programming in Java more convenient and less error-prone, as the programmer does not need to worry about memory leaks or other memory-related bugs.

Java's garbage collector is highly configurable and can be tuned to meet the needs of different applications. For example, it is possible to adjust the frequency of garbage collection, the size of the heap, and the algorithm used to reclaim memory.

One potential downside of garbage collection is that it can sometimes lead to performance issues. The garbage collector can use significant amounts of CPU time and memory, which can cause slowdowns or other performance problems. However, in most cases, the benefits of automatic memory management outweigh these concerns.

Overall, Java's garbage collection system is a key feature of the language that makes programming more convenient and less error-prone. It allows developers to focus on writing code rather than managing memory, which can lead to more efficient and productive development.

### Q6: What are access modifiers and their scopes in Java?
Access modifiers in Java are keywords used to control the visibility and accessibility of class members such as fields, methods, and inner classes. There are four types of access modifiers in Java:

1.  Public: Public members can be accessed from anywhere in the program, even from outside the class or package.

2.  Protected: Protected members can be accessed from within the same class, any subclasses, and any other classes in the same package.

3.  Default (package-private): Members with no access modifier (also called package-private) can be accessed only from within the same package.

4.  Private: Private members can be accessed only from within the same class.


### Q7: What is final key word? (Filed, Method, Class)
In Java, the `final` keyword is used to denote that a field, method, or class cannot be changed after it is initialized.

1.  Final Field: A final field is a field that cannot be modified once it has been initialized. If you declare a field as final, you must initialize it at the time of declaration or in the constructor of the class. Once a final field has been initialized, its value cannot be changed.
2.  Final Method: A final method is a method that cannot be overridden by a subclass. If you declare a method as final, the subclass cannot provide its own implementation of the method. This is useful when you want to ensure that a method's behavior remains consistent across all subclasses.
3.  Final Class: A final class is a class that cannot be subclassed. If you declare a class as final, no other class can extend it. This is useful when you want to ensure that the behavior of the class remains consistent and cannot be altered by other classes.

### Q8: What is static keyword? (Filed, Method, Class). When do we usually use it?
In Java, the `static` keyword is used to denote a class-level entity that belongs to the class itself rather than to any particular instance of the class. The `static` keyword can be applied to fields, methods, and inner classes.

1.  Static Field: A static field is a field that belongs to the class, rather than to any particular instance of the class. This means that there is only one copy of the field, shared by all instances of the class. Static fields are often used to represent constants or to keep track of information that is shared across all instances of the class.
2. Static Method: A static method is a method that belongs to the class, rather than to any particular instance of the class. This means that you can call the method without creating an instance of the class. Static methods are often used for utility methods that do not depend on the state of any particular instance.
3. Static Class: A static class is a nested class that is declared `static`. This means that you can access the class without creating an instance of the enclosing class. Static classes are often used to group related utility methods together.

### Q9: What is the differences between overriding and overloading?
Method Overloading: Method overloading is the practice of defining two or more methods in a class with the same name but different parameters. When a method is overloaded, it can accept different types or numbers of arguments. Java chooses which method to call based on the number and types of arguments passed in. Method overloading is a compile-time polymorphism, meaning that the decision of which method to call is made by the compiler.

Method Overriding: Method overriding is the practice of defining a method in a subclass that has the same name and signature as a method in the superclass. When a method is overridden, the implementation in the subclass replaces the implementation in the superclass. Method overriding is a runtime polymorphism, meaning that the decision of which method to call is made by the JVM at runtime.

In summary, method overloading allows you to define multiple methods with the same name but different parameters, while method overriding allows you to provide a new implementation for a method that is already defined in a superclass. Method overloading is resolved at compile time based on the number and types of arguments passed in, while method overriding is resolved at runtime based on the actual type of the object on which the method is called.



### Q10: What is the differences between super and this?
`super`: The `super` keyword is used to refer to the immediate parent class of a class. It is used to access members of the superclass that are hidden by a subclass or to call the superclass's constructor. When a method or field is called with `super`, it is resolved in the superclass.
2.  `this`: The `this` keyword is used to refer to the current instance of a class. It is used to access the current object's members or to pass the current object as a parameter to another method. When a method or field is called with `this`, it is resolved in the current object.

### Q11: What is the Java load sequence?

In Java, the load sequence refers to the order in which classes are loaded and initialized when a program is run. The load sequence is important because it can affect the behavior of the program.

### Q12: What is Polymorphism ? And how Java implements it ?

Polymorphism is the ability of an object to take on many forms. In Java, polymorphism is implemented through two mechanisms: method overloading and method overriding.


### Q13: What is Encapsulation ? How Java implements it? And why we need encapsulation?

Encapsulation is a fundamental concept in object-oriented programming that refers to the practice of hiding the internal details of an object from the outside world, and restricting access to its properties and methods. The goal of encapsulation is to ensure that an object's state is accessed and modified in a controlled way, and to protect it from unauthorized access or modification.

In Java, encapsulation is implemented through the use of access modifiers such as `public`, `private`, `protected`, and `default`. These modifiers control the visibility of a class's properties and methods, and determine whether they can be accessed by other classes or methods.

Encapsulation is important for several reasons:

1.  Security: Encapsulation helps protect an object's state from unauthorized access or modification, which can improve security and prevent errors.

2.  Modularity: Encapsulation allows objects to be treated as black boxes, which can simplify the design and implementation of complex systems.

3.  Maintainability: Encapsulation can make it easier to maintain and update code, because changes can be made to the internal details of an object without affecting other parts of the system.

### Q14: What is Interface and what is abstract class? What are the differences between them?

Both interfaces and abstract classes are used in Java to achieve abstraction, which is a key principle of object-oriented programming. Abstraction allows us to separate the behavior of an object from its implementation, and to define a common set of methods that can be implemented in different ways by different classes.

An interface is a collection of abstract methods and constants that define a contract for a class to implement. In other words, an interface defines what a class must do, but not how it does it. A class that implements an interface must provide implementations for all of its methods.

An abstract class is a class that cannot be instantiated, and that may contain abstract methods, concrete methods, and instance variables. An abstract method is a method that is declared but not defined, and that must be implemented by any concrete subclass of the abstract class. Abstract classes are often used to provide a common set of methods and properties that can be shared by a group of related classes.

The main differences between interfaces and abstract classes are:

1.  Implementation: An interface only defines a contract for a class to implement, whereas an abstract class can provide partial implementations for its methods.

2.  Instantiation: An interface cannot be instantiated, whereas an abstract class can be extended and instantiated.

3.  Multiple Inheritance: A class can implement multiple interfaces, but can only extend one abstract class.

4.  Access Modifiers: All methods in an interface are public by default, whereas abstract classes can have methods with various access modifiers.

5.  Variables: An interface can only have constants, whereas an abstract class can have instance variables.

### Q15
See  `Coding/ParkingLot.java`

### Q16: What are Queue interface implementations and what are the differences and when to use what?
1.  LinkedList: LinkedList is a doubly linked list implementation of the Queue interface. It offers constant-time performance for the enqueue and dequeue operations, but linear-time performance for accessing elements by index.

2.  ArrayDeque: ArrayDeque is an array-based implementation of the Queue interface. It offers constant-time performance for the enqueue and dequeue operations, and also supports accessing elements by index. It can be used as a stack or a queue, depending on the order of insertions and removals.

3.  PriorityQueue: PriorityQueue is a priority queue implementation of the Queue interface. It orders elements according to their natural ordering, or according to a Comparator that is provided at the time of creation. It offers logarithmic-time performance for adding and removing elements, and constant-time performance for accessing the head of the queue.

The choice of which Queue implementation to use depends on the specific requirements of the application. If fast insertion and removal of elements is a priority, then LinkedList or ArrayDeque may be a good choice. If elements need to be ordered by priority, then PriorityQueue may be a better choice. If the queue needs to support both fast insertion and removal, as well as access by index, then ArrayDeque may be the most appropriate choice.