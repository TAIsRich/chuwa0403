# Hw2
## 1.
See [Example.Java](./../Coding/hw2/Example.Java)
## 2. 
A wrapper class is a class wraps a primitve type to an object. e.g. int -> Integer

* Wrapper class converts primitive types to objects which makes it possible to pass by reference;
* All the collections in Java stores objects not primitive types;
* Synchronization in threading needs to handle with objects

## 3.
| HashMap | HashTable| 
|------|-----------|    
| No synchronization    | Support Synchronization |
| Not thread safe | Thread safe |
|  null key and values  | No null key and values   |   
|  Higher performance   |    Less higher performance    | 
| Order of entry changes when adding element | Order remains when adding elements |

## 4. 
String pool is a special storage space in Java heap memory where String literals are stored.

It is inefficient to allocate heap memory to String objects with the same content. A string constant pool escalate the performance and reduce memory usage

## 5. 
Garbage collection is the automated process which looks up in the heap memory and identify which object is still using which is not and deleting the unused objects. 

2 ways of deletion:
* normal deletion: just remove the unreferenced objects to free the space;
* compacting deletion: after delete, compact the remaining referenced objects, which makes new memory allocation easier.

## 6.
Access modifiers are keywords that are used to control the visibility of fiedls, methods, class.

|  | Current class | Same package | Child class | Other package |
|------|-----------|---|---|---|
| public | X | X | X | X |
| protected | X | X | X |  |
| default | X | X | | |
| private | X | | | |

## 7.
* final class: cannot be extended. This is useful for classes that are intended to be used as is and should not be modified or extended.
* final method: cannot be covered or override by child class. This is useful for methods that are part of a class’s public API and should not be modified by subclasses.
* final field: cannot be modified. This is useful for declaring constants or other values that should not be modified.
* final reference: cannot change its reference to other objects, but can modify its inside fields only if the inside fields are not final. 

## 8.
* static inner class: not rely on outer class; it can only use static methods or fields from the outer class; if we want to use the outer class methods, we can only initiate a new objects inside the static field. 
* static field: each objects share the same variable of the class -> the variable modified by static has only on memory location;
* static method: the method belongs to the class can be called by A.method(); it doesn't rely on objects which means it cannot be abstract; And it cannot be overridden, but can be overloaded; it can only directly call other static methods and access static variables (cannot refer to this and super).

Use the static variable for the property that is common to all objects. For example, in class Student, all students share the same college name. Use static methods for changing static variables.

Use a non-static nested class (or inner class) if you require access to an enclosing instance's non-public fields and methods. Use a static nested class if you don't require this access.

## 9.
| Overriding | Overloading | 
|------|-----------|    
| between class and subclass  | same class |
| same parameter (same type, same order) | different parameters (order different stil counts) |
|  same return type or child return type <= father return type | No requirement on return value   |   
|   child has less exception than father  |    No requirement    | 
| access modifier child >= father | No requirement |

## 10. 
this keyword mainly represents the current instance of a class. On other hand super keyword represents the current instance of a parent class. this keyword used to call default constructor of the same class or get access to fields.

## 11. 
Loaders:

+ The BootStrap class loader is on the top of the class loader hierarchy. It loads the standard JDK classes in the JRE’s lib directory.

+ The Extension class loader is in the middle of the class loader hierarchy and is the immediate child of the bootstrap class loader and loads the classes in the JRE’s lib\ext directory.

+ The Application class loader is at the bottom of the class loader hierarchy and is the immediate child of the application class loader. It loads the jars and classes specified by the CLASSPATH ENV variable.

Linking:
+ The linking process consists of the following three steps −

+ Verification − This is done by the Bytecode verifier to ensure that the generated .class files (the Bytecode) are valid. If not, an error is thrown and the linking process comes to a halt.

+ Preparation − Memory is allocated to all static variables of a class and they are initialized with the default values.

+ Resolution − All symbolic memory references are replaced with the original references. To accomplish this, the symbol table in the run-time constant memory of the method area of the class is used.

Initialization:
+ This is the final phase of the class-loading process. Static variables are assigned original values and static blocks are executed.

## 12.
Polymorphism describes a pattern in object oriented programming in which classes have different functionality while sharing a common interface.

Runtime polymorphism -> override

Compiletime polymorphism -> overload

## 13.
Encapsulation is an implementation level process, and it is used to provide privacy and maintain control over the transparency of data at the implementation stage of a project. integrating data (variables) and code (methods) into a single unit.

Use private to hide data from others; Providing public setter and getter methods to modify and view the variables values.

Encapsulation helps us to keep related fields and methods together, which makes our code cleaner and easy to read.

## 14. 
An abstract class is a class that cannot be instantiated and can contain both abstract and non-abstract methods. 

An interface is a contract that specifies a set of methods that a class must implement.

| | interface | Abstract class |
|--|--|--|
|type of methods | abstract method, default method and static method | both abstract and concrete |
| fianl variables | only default final | can contain non-final variables |
| Type of variables | only static and final variables | final, non-final, static and non-static|
| Multiple implementations | extend one or more Java interfaces | extend another Java class and implement multiple Java interfaces |

## 15. 
See [ParkingLot.Java](./../codingQuestions/coding1/ParkingLot.Java)

## 16.
* PriorityQueue: order elements based on priority 
* LinkedList: It is a linear data structure where the elements are not stored in contiguous locations and every element is a separate object with a data part and address part.
* PriorityBlockingQueue: thread safe comparing to PriorityQueue
