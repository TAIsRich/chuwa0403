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
