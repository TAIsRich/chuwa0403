# HW2

*Claudia Feng*



1. Writeup Example code to demonstrate the three found mental concepts of OOP.(reference **CodeDemo repo** as example)

   1. **Encapsulation;** 2. **Polymorphism;** 3. **Inheritance;**

   

2. What is **wrapper class** in Java and Why we need wrapper class?

   A **wrapper class** in Java is a class that encapsulates, or "wraps," a primitive data type (such as int, char, float, etc.) within an object. They allow primitive values to be used as objects, which can be useful in various programming scenarios.

   

3. What is the difference between **HashMap** and **HashTable**?

   **Synchronization**: Hashtable is synchronized, which means it is thread-safe and can be shared between multiple threads without any risk of data corruption. HashMap is not synchronized and not thread-safe.

   **Inheritance**: HashMap extends the AbstractMap class and implements the Map interface, while Hashtable extends the Dictionary class and implements the Map interface. 

   **Null keys and values**: HashMap allows one null key and multiple null values, while Hashtable does not allow any null keys or values. 

   **Performance**: Because Hashtable is synchronized, it has a performance cost associated with the synchronization process. HashMap, being unsynchronized, is generally faster than Hashtable when used in a single-threaded environment. 

   **Iteration**: HashMap uses an iterator for traversing the elements, while Hashtable uses an enumerator. 

   

4. What is **String pool** in Java and why we need String pool?

   The **String pool** (also known as the intern pool) is a memory area in the Java heap that stores unique String literals or interned String objects. When the Java compiler encounters a String literal, it checks if the same String already exists in the String pool. If it does, the existing reference is used; otherwise, a new String object is created and placed in the pool. The String pool helps in optimizing memory usage and reducing the number of duplicate String objects in memory.

   

5. What is Java **garbage collection**?

   Java **garbage collection** (GC) is an automatic memory management process that identifies and deallocates objects that are no longer in use or referenced by the application. It helps in preventing memory leaks, optimizing memory usage, and maintaining system stability.

   

6. What are **access modifiers** and their scopes in Java?

   In Java, **access modifiers** are keywords that determine the visibility and accessibility of class members (i.e., variables, methods, and inner classes). They define the scope in which a member can be accessed or used by other parts of the code. There are four access modifiers in Java:

   1. **private**: The member is accessible only within the same class it is declared. It is the most restrictive access level. Members marked as private are not visible to subclasses or other classes in the same package.

   2. **default** (no keyword): When no access modifier is specified, the member has package-private or default access. It means the member is accessible within the same package but not from other packages. This access level provides more accessibility than private but is still restricted to the same package.

   3. **protected**: The member is accessible within the same package and also by subclasses in any package. This access level provides more accessibility than default/package-private, allowing subclasses in different packages to access the member.

   4. **public**: The member is accessible from any class in any package. It is the least restrictive access level and provides the widest scope of accessibility.

      

7. What is **final** keyword? (Filed, Method, Class)

   1. Field: When the `final` keyword is used with a field (variable), it means the value of the field cannot be changed once it is assigned. Essentially, the field becomes a constant. It is common practice to use uppercase letters for naming final variables.

   2. Method: When the `final` keyword is used with a method, it indicates that the method cannot be overridden by a subclass. This is useful for ensuring the behavior of a method remains consistent across all subclasses.

   3. Class: When the `final` keyword is used with a class, it prevents the class from being subclassed (extended). This is useful when you want to create a class that should not be inherited by other classes.

      

8. What is **static** keyword? (Filed, Method, Class). When do we usually use it?

   1. Field: When the `static` keyword is used with a field, it indicates that the field belongs to the class itself, rather than to any individual instance (object) of the class. As a result, there is only one copy of the static field for the entire class, and it can be accessed directly using the class name without creating an instance of the class.

   2. Method: When the `static` keyword is used with a method, it indicates that the method belongs to the class itself, rather than to any individual instance of the class. Static methods can be accessed directly using the class name without creating an instance of the class. They can only work with static fields and cannot access non-static fields or methods of the class directly.

   3. Nested Class: When the `static` keyword is used with a nested class, it makes the nested class a static nested class. A static nested class does not have access to the instance variables and non-static methods of the enclosing class. However, it can be instantiated without an instance of the enclosing class.

      

      We usually use the `static` keyword in the following cases:

      - When we want to have a variable that is common to all instances of a class, such as a global counter or a constant value.

      - When we want to create utility methods that don't depend on the state of an instance, like mathematical calculations or string manipulations.

      - When we want to create a nested class that does not need access to the instance variables and non-static methods of the enclosing class.

        

9. What is the differences between **overriding** and **overloading**?

   1. Overriding:

   Overriding occurs when a subclass provides a new implementation for a method that already exists in its parent class. The new implementation in the subclass must have the same method signature (i.e., method name, return type, and parameter list) as the one in the parent class. The purpose of overriding is to allow the subclass to inherit the methods and fields of the parent class while still being able to modify or extend the behavior of specific methods.

   2. Overloading:

   Overloading occurs when a class has multiple methods with the same name but different parameter lists. The methods can have different numbers of parameters, different types of parameters, or a different order of parameter types. The return type of the methods does not play a role in overloading. The purpose of overloading is to provide multiple implementations of a method with the same name, allowing the method to handle different types or numbers of arguments in a more intuitive way.

   

10. What is the differences between **super** and **this**?

    The `super` keyword is used to refer to the immediate parent class of an object.

    - To call the parent class's constructor from a subclass constructor

      When a subclass constructor wants to call the constructor of its parent class, it can use the `super` keyword followed by the constructor's arguments. This is typically done in the first line of the subclass constructor.

    - To call a method in the parent class that has been overridden in the subclass

      If a method has been overridden in a subclass, but the subclass still wants to call the original method from the parent class, the `super` keyword can be used.

    The `this` keyword is used to refer to the current instance of an object. 

    - To differentiate between instance variables and local variables or method parameters with the same name

    - To call another constructor within the same class (constructor chaining)

    - To pass the current instance as an argument to a method or a constructor of another class

      

11. What is the Java **load sequence**?

    The Java load sequence refers to the order in which classes are loaded, initialized, and instantiated in a Java program. 

    1. Loading: The first step is loading the class. When a Java program is run, the JVM loads the required class files (bytecode) into memory.

    2. Linking: Once a class is loaded, the JVM performs the linking process, which includes three sub-steps: Verification, Preparation, Resolution

    3. Initialization: After linking, the JVM initializes the class, which involves executing the class's static initializer blocks and initializing its static fields with their assigned values. 

    4. Instantiation: Once a class is loaded, linked, and initialized, it is ready to be instantiated. Instantiation involves creating instances (objects) of the class using the `new` keyword or reflection. 

       

12. What is **Polymorphism** ? And how Java implements it ?

    Polymorphism is a fundamental concept in object-oriented programming (OOP) that allows objects of different classes to be treated as objects of a common superclass. It enables a single function or method to work with different data types or objects, simplifying the code and making it more maintainable and extensible.

    1. Compile-time polymorphism (also called method overloading): This type of polymorphism occurs when multiple methods in the same class have the same name but different parameters (different number or different types). The Java compiler determines which method to call based on the method arguments provided at compile time.

    2. Runtime polymorphism (also called method overriding or dynamic method dispatch): This type of polymorphism occurs when a subclass provides its own implementation of a method already defined in its parent class. At runtime, the Java Virtual Machine (JVM) decides which method implementation to call based on the actual object type, not the reference type. This allows you to use a superclass reference to refer to a subclass object and call the appropriate method implementation.

       

13. What is **Encapsulation** ? How Java implements it? And why we need encapsulation?

    Encapsulation is a fundamental concept in object-oriented programming that refers to the bundling of data (attributes) and the methods (functions) that operate on that data within a single unit, usually a class. The primary goal of encapsulation is to promote separation of concerns, increase modularity, and hide the internal implementation details of a class from the outside world.

    Java implements encapsulation through access modifiers and getters & setters.

    

14. What is **Interface** and what is **abstract** class? What are the differences between them?

    **Interface:**

    An interface in Java is a collection of abstract methods (methods without a body) and constants. It defines a contract that specifies what a class implementing the interface should do, without specifying how to do it. A class can implement multiple interfaces, which enables a form of multiple inheritance. In Java 8 and later, interfaces can also have default methods (methods with a default implementation) and static methods.

    **Abstract Class:**

    An abstract class is a class that cannot be instantiated and is meant to be subclassed by other classes. It can have both abstract methods (methods without a body) and concrete methods (methods with an implementation). Abstract classes can have fields, constructors, and even fully implemented methods. A class can extend only one abstract class, which means that abstract classes do not support multiple inheritance.

    

15. (**OOD**) Design a parking lot (put the code to **codingQuestions**/coding1 folder, )

    1. If you have no ability to design it, please find the solution in internet, then understand it, and re-type it.(**Do NOT just copy and paste**)

    

16. What are **Queue interface** implementations and what are the differences and when to use what?

    The Queue interface in Java is a part of the Java Collections Framework and provides a data structure to hold elements prior to processing. It follows the First-In-First-Out (FIFO) principle, meaning that the element added first will be removed first.

    1. LinkedList: A LinkedList is a doubly-linked list implementation of the List and Queue interfaces. It provides good performance for adding and removing elements at both the beginning and end of the list. It is suitable for use cases where you need a Queue with fast insertion and removal operations but don't require constant-time access to elements.
    2. ArrayDeque: ArrayDeque is a resizable-array implementation of the Deque interface, which is a double-ended queue that allows elements to be added and removed at both ends. ArrayDeque can be used as a Queue or a Stack. It provides better performance than LinkedList for most queue operations due to its cache-friendliness and lower memory overhead. It is not thread-safe and doesn't support null elements.
    3. PriorityQueue: PriorityQueue is a priority queue implementation based on a binary heap data structure. Elements are ordered according to their natural order or a provided comparator. PriorityQueue doesn't guarantee constant-time performance for the enqueue and dequeue operations but provides an efficient way to access the smallest (or largest) element in the queue. It is suitable for use cases where you need a priority queue with efficient access to the highest-priority element.