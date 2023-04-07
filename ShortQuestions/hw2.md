Q1:


Q2:  
Java wrapper class is a class used to wrap a primitive data type into an object.  
Wrapper classes are fundamental in Java because they help a Java program be completely object-oriented. The primitive data types in java are not objects, by default. They need to be converted into objects using wrapper classes.

Q3:  
HashMap is non-synchronized and is not thread safe while HashTable is thread safe and is synchronized. HashMap allows one null key and values can be null whereas HashTable doesn't allow null key or value. HashMap is faster than HashTable. HashMap iterator is fail-safe where HashTable iterator is not fail-safe.

Q4:  
String pool is a special memory area where string literals are stored in order to conserve memory and improve performance.  
The reason for having a string pool is to conserve memory. Since string literals are commonly used in Java programs, it would be wasteful to create a new string object every time a string literal is used. By reusing string objects from the pool, Java programs can save memory and improve performance.

Q5:  
Java garbage collection is a mechanism in Java that automatically manages the memory used by Java programs.

Q6:  
Access modifiers are keywords that determine the level of access that a class, method, or variable has to other parts of the program. There are four access modifiers in Java: public, protected, private, and default.  

Q7:  
- Final Fields: When a field is declared as final, its value cannot be changed after initialization. It must be initialized either at the time of declaration or within the constructor of the class. Final fields are often used to create constants or to ensure immutability.
- Final Methods: When a method is declared as final, it cannot be overridden by any subclass. This can be useful when a method implementation should not be changed in any subclass.
- Final Classes: When a class is declared as final, it cannot be subclassed. This can be useful when a class should not be extended or when all necessary functionality has already been implemented in the class.

Q8:  
- Static Fields: When a field is declared as static, it belongs to the class rather than to individual instances of the class. This means that all instances of the class share the same value for the static field. Static fields are often used to represent constants, or to maintain state that is shared across all instances of a class.
- Static Methods: When a method is declared as static, it belongs to the class rather than to individual instances of the class. This means that the method can be called on the class itself, rather than on an instance of the class. Static methods are often used to provide utility methods that do not depend on the state of any particular instance of a class.
- Static Classes: Java does not have a concept of static classes in the same way that it has static fields and methods. However, nested classes can be declared as static, which means that they do not have access to the non-static members of the enclosing class.

We usually use the static keyword when we want to create members that belong to the class itself rather than to individual instances of the class.

Q9:  
Overriding occurs when the method signature is the same in the superclass and the child class. Overloading occurs when two or more methods in the same class have the same name but different parameters.

Q10:  
**this** refers to the current object, while **super** refers to the parent object.

Q11:  
The Java class loading process determines how a Java virtual machine (JVM) loads and initializes classes at runtime. The class loading process follows a well-defined sequence, which can be broken down into the following steps:
- Loading: The class loader reads the class file from the file system or network and converts it into a binary format in memory.
- Linking: The class loader performs three sub-steps in the linking phase: verification, preparation, and resolution.
- Initialization: The JVM initializes the static variables of the class in the order they are declared, and executes any static initialization blocks.

Q12:  
Polymorphism is a programming concept that allows objects of different classes to be treated as if they belong to the same class, and to be manipulated in a consistent and uniform way. In other words, it enables multiple objects to be handled as a single object, as long as they share a common interface or superclass.  
In Java, polymorphism is achieved through two mechanisms: method overloading and method overriding.

Q13:  
Encapsulation is a fundamental principle of object-oriented programming (OOP) that refers to the bundling of data and methods that operate on that data within a single unit, such as a class. The key idea behind encapsulation is to hide the internal details of an object from the outside world, and to provide a well-defined interface that can be used to interact with the object.  
In Java, encapsulation is implemented through the use of access modifiers and getter/setter methods. Access modifiers (such as private, public, and protected) are used to control the visibility of class members (such as fields and methods) to other classes. By default, class members are package-private, meaning that they are visible only within the same package.

Q14:  
An interface is a type that defines a set of methods that a class must implement. It is essentially a contract that defines what a class can do, but does not provide any implementation details. Interfaces are declared using the interface keyword, and all methods declared in an interface are implicitly public and abstract.  
An abstract class, on the other hand, is a class that cannot be instantiated on its own, and may contain both abstract and concrete methods. Abstract classes are declared using the abstract keyword, and can provide partial implementation for the methods they declare. Abstract methods are defined without an implementation, while concrete methods have an implementation.

Q16:  
LinkedList: This is a doubly linked list that implements the Queue interface. It allows for fast element insertion and deletion at both ends of the list. It is an efficient choice when you need to perform frequent insertions and deletions, but it can be slower than other implementations when it comes to random access or search.

ArrayDeque: This is a resizable array that implements the Deque interface, which extends the Queue interface. It allows for fast element insertion and deletion at both ends of the queue. It is a good choice when you need to implement a stack or a queue with a fixed size, or when you need to access elements in constant time.

PriorityQueue: This is an unbounded priority queue that is based on a priority heap. It allows for fast element insertion and removal based on their natural ordering or a custom comparator. It is a good choice when you need to prioritize elements in a specific order.

- Use LinkedList when you need to perform frequent insertions and deletions at both ends of the queue, and you don't need to access elements randomly.
- Use ArrayDeque when you need to implement a stack or a queue with a fixed size, or when you need to access elements in constant time.
- Use PriorityQueue when you need to prioritize elements in a specific order, and you don't need to access elements randomly.

