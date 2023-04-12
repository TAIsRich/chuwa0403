# 1. 
## hw2 code files
# 2. 
## For example, int is a data type, Integer is a wrapper class. In Java we use wrapper class to give objects a type like, in other words, wrapper class allow us to use primitive data types like int/String as an object.
### ```
### char c = 'a';
### Character a = c;
### ```
# 3. 
## HashMap and Hashtable are both data structures. The difference is HashMap is non-syncronized and is not thread safe while HashTable is thread safe and is synchronized.
# 4. 
## String Pool is a storage space in Java Heap memory where strings are stored. This includes all strings because Java strings are immutable.
# 5. 
## Our system resources are limited; especially memory space. So in order to free up resources, garbage collection is deployed to delete the unused objects in memory.
# 6. 
## Access modifiers are keyword we can use to define who can access this part. For example, default, private, protected and public.
# 7. 
## When something is declared with final keyword, it means it can not be changed. For example, declare Pi value as 3.1415926.
### ```
### final double pi = 3.1415926;
### ```
# 8. 
## Static Modifier is used for creating a static variable and static method.  A static method or variable exists independently of any class object. It means a static variable or static method can be called using the class name without creating an instance or object of this class.
# 9. 
## Overriding and overloading are use of polymorphism. Overriding is runtime polymorphism, and overloading is compile time polymorphism. Overriding methods must have same name and arguments. Overriding methods have same name but different implementations.
# 10. 
## Super refers to parent class, where this refers to current class.
# 11. 
## Java load sequence is the process of loading java classes into the JVM. 
# 12. 
## Polymorphism simply means ame name and many forms. The way we use polymorphism are through overriding and overloading. With the same method, we will be able to ues it for different purpose.
# 13. 
## Encapsulation in Java is a process of wrapping code and data together into a single unit. Other way to think about encapsulation is, it is a protective shield that prevents the data from being accessed by the code outside this shield. So we can protect our data, and only allow access when needed.
# 14. 
## Abstract class is a class that contain both abstract and non-abstract methods. Interface is a like a blueprint contains a set of methods that a class must implement. Main difference is methods of a Java interface are implicitly abstract and cannot have implementations. A Java abstract class can have instance methods that implements a default behavior.
# 15. 
## parking_lot.java
# 16. 
## A collection designed for holding elements prior to processing. Queues provide additional insertion, extraction, and inspection operations.  