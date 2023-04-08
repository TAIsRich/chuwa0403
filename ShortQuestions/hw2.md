# 1. Write up Example code to demonstrate the three fundamental concepts ofOOP.
All code are in coding1. 

# 2. What is wrapper class in Java and Why we need wrapper class?
A wrapper class is a class can provide an object-oriented representation of the primitive data types (such as int, float, double, etc.).
The wrapper classes provide a way to convert primitive data types into objects.

There are several reasons why we need wrapper classes in Java, including:

+ Boxing and Unboxing: One of the main reasons for using wrapper classes is to convert primitive data types into objects and vice versa.

+ Nullability: Primitive data types cannot be assigned a null value. However, when we use objects, we can assign null values to them.

+ Standardization: By providing a standard representation for primitive data types, wrapper classes enable us to write more generic and reusable code.

+ Utility methods: Wrapper classes provide several utility methods that are not available for primitive data types. For example, the Integer class provides methods for converting strings to integers, and the Double class provides methods for rounding and formatting numbers.

# 3. What is the difference between HashMap and HashTable?
+ Synchronization: HashTable is synchronized, which means that it is thread-safe and can be used in a multi-threaded environment.
  HashMap, on the other hand, is not synchronized by default, but can be made thread-safe by using the Collections.synchronizedMap() method.

+ Null keys/values: HashTable does not allow null keys or values, whereas HashMap allows one null key and any number of null values.

+ Iteration: HashTable's iterator is a legacy class, and its use is discouraged. HashMap's iterator is fail-fast, which means that it throws a ConcurrentModificationException if the map is modified while iterating over it.

+ Performance: HashTable is generally slower than HashMap because of its synchronization overhead.

+ Enumeration vs Iterator: HashTable uses Enumeration to iterate over its elements, while HashMap uses Iterator. Enumeration is a legacy class, and its use is discouraged.

# 4.  What is String pool in Java and why we need String pool?
In Java, the string pool is a special area of the heap where string literals are stored.
When we create a string using a string literal, such as "World", Java checks if that string already exists in the string pool.
If it does, the existing string is returned; if it doesn't, a new string is created and added to the string pool.

We need the string pool for several reasons:
+ Memory efficiency: By reusing existing strings, the string pool can reduce the amount of memory used by a program. Since strings are immutable in Java, we can safely share them without worrying about accidentally modifying them.

+ String interning: When we compare strings using the == operator, Java checks if the two strings are the same object in memory, rather than comparing their values. By using the string pool, we can intern strings and ensure that only one instance of a particular string exists in memory.

+ Constant pool: In addition to storing string literals, the string pool also stores other constants, such as integer and floating-point literals, that are used in the program.

+ Performance: Since string literals are commonly used in Java programs, accessing strings from the string pool can be faster than creating new string objects.

# 5. What is Java garbage collection?
In Java, garbage collection is a process by which the Java Virtual Machine (JVM) automatically manages memory by deallocating objects that are no longer being used by a program. 
Garbage collection frees up memory that can be used by other objects and helps prevent memory leaks and other memory-related issues.

# 6. What are access modifiers and their scopes in Java?
Access modifiers are keywords in Java that are used to set the accessibility of classes, variables, and methods. There are four access modifiers in Java: public, protected, private, and default (also known as package-private). These modifiers determine which parts of a Java program are accessible from other parts of the program.

Here are the scopes of each access modifier:
+ Public: A public class, variable, or method can be accessed from anywhere in the program, including other packages.

+ Protected: A protected variable or method can be accessed from within the same class, subclasses, and other classes in the same package.

+ Private: A private variable or method can only be accessed from within the same class.

+ Default (package-private): A variable or method with no access modifier (i.e., no public, protected, or private keyword) can only be accessed from within the same package.

# 7. What is final keyword?(Filed,Method,Class)
Final fields: When a variable is declared as final, it means that its value cannot be changed once it has been assigned. This is useful for constants, as it ensures that their value remains the same throughout the program.

Final methods: When a method is declared as final, it means that it cannot be overridden by subclasses. This can be useful in situations where a method should not be modified by subclasses, or where the behavior of the method is critical to the class.

Final classes: When a class is declared as final, it means that it cannot be extended by other classes. This can be useful in situations where a class is complete and should not be modified or extended.

# 8. What is static key word?(Filed,Method,Class).When do we usually use it?
+ Static fields: When a field is declared as static, it means that the field belongs to the class and not to any instance of the class. All instances of the class share the same value for the static field. Static fields are useful for storing data that is common to all instances of the class.

+ Static methods: When a method is declared as static, it means that the method belongs to the class and not to any instance of the class. Static methods can be called without creating an instance of the class, which can be useful for utility methods or methods that do not depend on instance variables.

+ Static classes: When a class is declared as static, it means that the class is nested inside another class and does not depend on an instance of the outer class. Static classes are useful for grouping related functionality together.

We usually use the static keyword when we want to create a member that is shared across all instances of a class or that does not depend on an instance of the class. Some common use cases for static members include:

- Constants: Static fields can be used to define constants that are shared across all instances of a class.

- Utility methods: Static methods can be used to define utility methods that do not depend on instance variables.

- Factories: Static methods can be used to define factory methods that create instances of a class.

- Singleton pattern: Static fields and methods can be used to implement the singleton pattern, where a class can have only one instance.

# 9. What is the differences between overriding and overloading?
- Overloading happens at compile time. Overriding happens at runtime
- Overloading  gives better performance because the binding is being done at compile time.overriding gives less performance because the binding is being done at run time.
- Private and final methods can be overloaded. Private and final methods can NOT be overridden.
- Return type of method in Overloading does not matter in case of method overloading. Return type of method in overriding must be the same in the case of overriding.
- Arguments in Overloading must be different in the case of overloading. Arguments in overriding must be the same in the case of overriding.
- Overloading is being done in the same class. Base and derived(child) classes are required in overriding.
- Overloading mostly used to increase the readability of the code. Overriding mostly used to provide the implementation of the method that is already provided by its base class.

# 10. What is the differences between super and this?
"Super" is used to refer to the parent class of the current object. "This" is used to refer to the current object.

# 11. What is the Java load sequence?
In Java, the sequence of loading classes is determined by the Java Classloader. The Java Classloader is responsible for loading Java classes into memory at runtime

# 12. What is Polymorphism ? And how Java implements it ?
Polymorphism is the ability of an object to take on many forms or have multiple behaviors depending on the context in which it is used. 
In Java, polymorphism is implemented through two mechanisms: method overloading and method overriding.

Method overloading allows a class to have multiple methods with the same name but different parameter types or number of parameters. 

Method overriding, on the other hand, allows a subclass to provide a specific implementation of a method that is already defined in its superclass. 

# 13.  What is Encapsulation ? How Java implements it? And why we need encapsulation?
Encapsulation is a mechanism in object-oriented programming that combines data and behavior within a single unit called a class. 
It involves the bundling of data and the methods that operate on that data, to restrict access and protect the data from external interference or misuse.

In Java, encapsulation is implemented using access modifiers such as private, public, and protected. 
These access modifiers control the visibility of the class members (fields and methods), determining which classes are allowed to access them.

Encapsulation is important for several reasons: 
- First, it allows the data of a class to be hidden from external classes, protecting it from unauthorized access or modification. 
- Second, encapsulation helps to reduce complexity by providing a well-defined interface for interacting with the class, making the code more modular and easier to maintain. 
- Finally, encapsulation enables us to enforce business rules and constraints, by controlling the access to the data and providing methods for manipulating it in a controlled manner.

# 14. What is Interface and what is abstract class? What are the differences between them?
An interface is a collection of abstract methods and constants that define a contract or a set of behaviors that a class must implement. It does not contain any implementation code for the methods. A class that implements an interface must provide concrete implementations for all the abstract methods defined in the interface.

An abstract class is a class that cannot be instantiated directly but can be subclassed. It can contain both abstract and non-abstract methods, and can also have fields, constructors, and other types of members. Subclasses of an abstract class must provide concrete implementations for all the abstract methods in the abstract class, but they can also override the non-abstract methods if needed.

Here are some of the key differences:
- Multiple inheritance: Java interfaces support multiple inheritance, which means a class can implement multiple interfaces. On the other hand, Java does not support multiple inheritance for classes, meaning that a class can only extend one class.

- Implementation: Interfaces only define method signatures, while abstract classes can provide some implementation code for non-abstract methods.

- Access modifiers: All interface methods are public, while abstract class methods can have any access modifier.

- Constructor: An interface cannot have a constructor, while an abstract class can.

- Fields: An interface can only have static final fields, while an abstract class can have any type of fields.

# 15. Design a parking lot (put the code to codingQuestions/coding1 folder)? 
All the code files are in coding1/ParkingLot

# 16. What are Queue interface implementations and what are the differences and when to use what?
- LinkedList: The LinkedList class is a doubly linked list implementation of the Queue interface. It provides fast insertion and deletion of elements from both ends of the list, making it a good choice for implementing a FIFO queue.

- ArrayDeque: The ArrayDeque class is a resizable array implementation of the Queue interface. It provides fast insertion and deletion of elements from both ends of the queue, making it a good choice for implementing a FIFO queue or a LIFO stack.

- PriorityQueue: The PriorityQueue class is an implementation of the Queue interface that maintains elements in a sorted order. It is based on a priority heap data structure and provides efficient access to the smallest element in the queue. It is a good choice for implementing a priority queue.

- ConcurrentLinkedQueue: The ConcurrentLinkedQueue class is a thread-safe implementation of the Queue interface. It provides lock-free insertion and removal of elements, making it suitable for concurrent access by multiple threads.

- When choosing a Queue implementation, it is important to consider the specific requirements of your application. Here are some guidelines:

When to use them? 

- If you need a simple FIFO queue, use LinkedList or ArrayDeque.

- If you need a priority queue, use PriorityQueue.

- If you need a thread-safe queue, use ConcurrentLinkedQueue.

- If you need a LIFO stack, use ArrayDeque.





     
 