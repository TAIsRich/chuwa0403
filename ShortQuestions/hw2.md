1. see Coding/coding1/EncapsulationExample.java
       Coding/coding1/PolymorphismExample.java
       Coding/coding1/InheritanceExample.java

2. What is wrapper class in Java and Why we need wrapper class?
   A wrapper class in Java is a class that wraps (encapsulates) a primitive data type into an object. The primitive data types include byte, short, int, long, float, double, boolean, and char. The wrapper classes for these data types are Byte, Short, Integer, Long, Float, Double, Boolean, and Character, respectively.
   Reasons:
   1. Wrapper classes provide a way to use primitive data types as objects
   2. Wrapper classes provide useful methods for converting primitive data types to and from strings, as well as for performing mathematical operations on them.
   3. Wrapper classes also provide a way to handle null values.

3. What is the difference between HashMap and HashTable?
   1. Thread-safety: HashMap is not synchronized by default. This means that it is not thread-safe and can lead to concurrency issues if multiple threads try to access and modify it simultaneously. However, you can make HashMap thread-safe by using the ConcurrentHashMap class. On the other hand, HashTable is synchronized, which means that it is thread-safe and multiple threads can access it simultaneously without any issue. 
   2. Null values: HashMap allows null values for both keys and values. On the other hand, HashTable does not allow null values for both keys and values. If you try to add a null value to a HashTable, it will throw a NullPointerException.  
   3. Iteration order: The iteration order of the elements in HashMap is not guaranteed and may change over time. On the other hand, the iteration order of the elements in HashTable is guaranteed to be the same as the order in which they were inserted.
   4. Performance: HashMap is generally faster than HashTable as it is not synchronized. This means that HashMap is a better choice for non-threaded applications where performance is a concern.

4. What is String pool in Java and why we need String pool?
   String pool in Java is a pool of String objects that are stored in the heap memory area. When we create a string literal (a string enclosed in double quotes) in our code, the JVM checks if an equivalent string is already present in the String pool. If it is, then the existing String object is returned, otherwise a new String object is created and added to the pool.

   Reasons: 
   1. Memory Optimization: String objects are immutable, which means that once a string object is created, it cannot be modified. Since string objects are frequently used in Java programs, creating a new string object every time a string is needed can lead to unnecessary memory usage. The String pool eliminates this issue by reusing existing String objects, which reduces memory usage and improves performance.
   2. Efficiency: The String pool is created at the time of JVM initialization, and all the string literals that are encountered during the execution of a Java program are added to this pool. This ensures that the strings are always readily available, and there is no need to create a new object every time a string is needed.
   3. String Comparison: String literals are interned (added to the pool) by default. This means that when we create two strings with the same value using string literals, they will refer to the same object in the String pool. This allows us to use the "==" operator to compare the strings, which is faster and more efficient than using the equals method. However, if we create a new string object using the "new" keyword, then using "==" to compare it with another string will compare the object references, rather than the string values, which may lead to unexpected results. To compare the values of two strings that may not be interned, we should use the equals method.

5. What is Java garbage collection?

   Garbage collection in Java is the automated process of deleting code that’s no longer needed or used. This automatically frees up memory space and ideally makes coding Java apps easier for developers. When a Java program creates objects, they are stored in the heap memory area. As the program executes, objects may no longer be needed, but they remain in the heap, occupying memory space. If the program continues to run for a long time without freeing up memory, it may eventually run out of memory and crash.

   Garbage collection is a mechanism in Java that automatically identifies and removes objects that are no longer in use. The Java Virtual Machine (JVM) periodically checks for objects that are no longer referenced by any active part of the program, and marks them as eligible for garbage collection. The JVM then deallocates the memory used by these objects, freeing up space in the heap.

6. What are access modifiers and their scopes in Java?
   In Java, access modifiers are keywords used to control the visibility and accessibility of classes, fields, and methods within a program. There are four access modifiers in Java: public, private, protected, and default (no modifier).
   1. Public: The "public" keyword is used to specify that a class, field, or method can be accessed from anywhere in the program. There is no restriction on its accessibility.
   2. Private: The "private" keyword is used to specify that a field or method can only be accessed within the same class in which it is defined. It cannot be accessed from outside the class, including its subclasses.
   3. Protected: The "protected" keyword is used to specify that a field or method can be accessed within the same class, its subclasses, and classes in the same package. It cannot be accessed from outside the package if it is not a subclass of the class in which it is defined.
   4. Default: If no access modifier is specified, it is considered as the default access modifier. A field or method with default access can be accessed within the same class and package, but not from outside the package.
   In summary, public access has the widest scope, followed by protected, default, and private access with the narrowest scope.

7. What is final keyword? (Field, Method, Class)

   1. Final Field: A final field is a constant value that cannot be modified once it is assigned. It must be initialized either during declaration or in a constructor. Final fields are commonly used for variables that represent configuration settings or other constant values that should not be modified during program execution.
   For example: 
   ```
   public class Test {
     final int MAX_NUM = 10;
   }
   ```
   2. Final Method: A final method is a method that cannot be overridden by subclasses. When a method is declared final, it cannot be modified by any subclasses that inherit from the parent class. Final methods are commonly used to ensure that the functionality of a method remains consistent across all subclasses.
   For example:
   ```
   public class Test {
      public final void addNum() {
        // method implementation
      }
   }
   ```
   3. Final Class: A final class is a class that cannot be subclassed. When a class is declared final, it cannot be extended by any other class. Final classes are commonly used to prevent modification of critical system classes or to provide immutable classes.
   For example:
   ```
   final class myFinalClass 
   {
       void myFinalMethod() 
       {
         //method implementation
       }
   }
   ```

8. What is static keyword? (Field, Method, Class). When do we usually use it?

   In Java, the static keyword is used to declare fields, methods, and inner classes that belong to the class itself, rather than to any instance of the class. 

   1. Static Fields: A static field is a field that belongs to the class, rather than to any instance of the class. This means that there is only one copy of the field, regardless of how many instances of the class are created. Static fields are commonly used to represent shared data or constants that are used across all instances of a class.
   2. Static Methods: A static method is a method that belongs to the class, rather than to any instance of the class. This means that it can be called without creating an instance of the class. Static methods are commonly used to provide utility methods that do not require any state from an object, or to provide factory methods for creating new objects.
   3. Static Classes: A static class is a nested class that has been declared static. This means that it can be accessed without creating an instance of the outer class. Static classes are commonly used for helper classes or utility classes that do not depend on any instance variables of the outer class.

   To create constants: If we want to create a constant value that remains the same for all instances of a class, we can declare it as a static final variable.
   To create utility methods: If we have a method that performs a task that does not depend on any instance variables, we can declare it as a static method.
   To keep track of instances: If we want to keep track of how many instances of a class have been created, we can use a static variable to count them.
   To create factory methods: If we want to provide a way to create objects of a class without using the new operator, we can create a static factory method.
   To create inner classes: If we want to create a nested class that does not depend on any instance variables of the outer class, we can declare it as a static inner class. 

9. What is the differences between overriding and overloading?
   1. Overloading happens at compile time. Overriding happens at runtime.
   2. Overloading gives better performance because the binding is being done at compile time. Overriding gives less performance because the binding is being done at run time.
   3. Private and final methods can be overloaded. Private and final methods can not be overridden.
   4. Return type of method does not matter in case of method overloading. Return type of method must be the same in the case of overriding.
   5. Arguments must be different in the case of overloading. Arguments must be the same in the case of overriding.
   6. Overloading is being done in the same class. Base and derived(child) classes are required in overriding.
   7. Overloading mostly used to increase the readability of the code. Overriding mostly used to provide the implementation of the method that is already provided by its base class.

10. What is the differences between super and this?
   1. Reference: super refers to the immediate parent class of a class, while this refers to the current object or instance of a class.
   2. Usage: super is typically used to call a method or access a field of the parent class, while this is typically used to refer to instance variables or methods of the current class.
   3. Inheritance: super is used to access methods or fields of the parent class in inheritance, while this is used to access instance variables or methods of the current class.
   4. Method Calls: When calling a method using super, the method being called is the one in the parent class, while when calling a method using this, the method being called is the one in the current class.
   5. Constructor Calls: When calling a constructor using super, the constructor being called is the one in the parent class, while when calling a constructor using this, the constructor being called is the one in the current class.

11. What is the Java load sequence?
   Java load sequence refers to the order in which classes are loaded and initialized by the Java Virtual Machine (JVM). 
   1. Loading: The JVM loads the class file from the file system or network into memory.
   2. Linking: The JVM performs three tasks during linking:
      a. Verification: The JVM verifies that the bytecodes in the class file are valid and do not violate any security constraints.
      b. Preparation: The JVM allocates memory for class variables and sets them to their default values.
      c. Resolution: The JVM resolves any symbolic references to other classes or interfaces that the current class depends on.
   3. Initialization: The JVM initializes the class by executing its static initialization block, and by initializing its static fields to their specified values.

12. What is Polymorphism ? And how Java implements it ?
    Polymorphism refers to the same object exhibiting different forms and behaviors. And polymorphism is implemented through two mechanisms:
    1. Method Overloading: Method overloading allows a class to have multiple methods with the same name but different parameters. The JVM determines which method to call at runtime based on the number and types of arguments passed to the method.
    2. Method Overriding: Method overriding occurs when a subclass provides its own implementation of a method that is already defined in its superclass. When a method is called on an object of the subclass, the JVM will call the subclass's implementation of the method, even if the method is called through a reference to the superclass.

13. What is Encapsulation ? How Java implements it? And why we need encapsulation? 
    Encapsulation allows you to protect the internal state of an object and ensure that it can only be modified through a well-defined interface. This interface usually consists of a set of methods or functions that allow users of the object to interact with it in a safe and controlled way.
    In Java, encapsulation is implemented through the use of access modifiers such as private, public, and protected. These modifiers control the visibility of class members, such as fields and methods, and allow you to restrict access to them from other parts of the program
    The private modifier, for example, is used to declare fields or methods that can only be accessed within the class in which they are defined. This means that the internal state of the object can only be modified through the methods provided by the class, rather than directly accessing the fields themselves.
    Reasons:
    1. Encapsulation helps to prevent accidental modification of an object's internal state by external code, which can lead to bugs and other unexpected behavior.
    2. Encapsulation allows you to change the implementation of a class without affecting other parts of the program that use it, as long as the external interface remains the same.
    3. Encapsulation makes it easier to reason about and maintain the code, as you can treat objects as black boxes with well-defined inputs and outputs.

14. What is Interface and what is abstract class? What are the differences between them?
    An interface is a type that defines a set of abstract methods and constants that a class can implement. An interface is like a contract between the class and the rest of the program that specifies what methods the class must implement and what properties it must have.
    An abstract class is a class that cannot be instantiated and serves as a base class for other classes to inherit from. Abstract classes can contain abstract and non-abstract methods, and they can also have fields and constructors. However, they cannot be instantiated directly because they may contain abstract methods that need to be implemented by the inheriting classes.
    Differences: 
    1. Interfaces can only contain abstract methods, whereas abstract classes can contain both abstract and non-abstract methods.
    2. A class can implement multiple interfaces, but it can only inherit from one abstract class.
    3. Interfaces can only contain constants, whereas abstract classes can contain fields that can be inherited by subclasses.
    4. Methods in an interface are implicitly public and abstract, whereas methods in an abstract class can have any access modifier and can be either abstract or non-abstract.
    5. Interfaces are often used to define a set of behaviors that a class must implement, whereas abstract classes are often used to provide a common implementation for a group of related classes.

15. Design a parking lot
    See Coding/coding1/ParkingLot.java

16. What are Queue interface implementations and what are the differences and when to use what?
    The Queue interface in Java represents a collection of elements that can be accessed in a specific order.    
    1. LinkedList: This implementation uses a linked list data structure to store elements and allows for efficient insertion and deletion operations at both the front and back of the queue. This makes it a good choice for applications where frequent insertion and deletion operations are expected.
    2. PriorityQueue: This implementation uses a priority heap data structure to store elements, with elements ordered according to their natural order or a specified comparator. This makes it a good choice for applications where elements need to be processed in a specific order based on their priority.
    3. ArrayDeque: This implementation uses a resizable array to store elements and allows for efficient insertion and deletion operations at both the front and back of the queue. This makes it a good choice for applications where random access to elements is also required.
    4. ConcurrentLinkedQueue: This implementation is similar to LinkedList, but is designed for use in multithreaded applications where multiple threads may access the queue concurrently. It provides thread-safe operations and high concurrency performance.

    If you need to process elements in a specific order based on their priority, then PriorityQueue may be the best choice. On the other hand, if you need to perform frequent insertion and deletion operations, LinkedList or ArrayDeque may be more appropriate. Finally, if your application needs to handle concurrent access to the queue, then ConcurrentLinkedQueue may be the best choice.