# 1.
---
```
Encapsulation:

public class Main {
    public static void main(String[] args) {
        Cat cat1 = new Cat("cat1", 2);
        // print cat name
        System.out.println(cat1.getName());
    }
}

class Cat {
    private String name;
    private int age;

    public Cat(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return this.name;
    }
}
```

```
Polymorphism:

public class Main {
    public static void main(String[] args) {
        Animal cat1 = new Cat("cat1", 2);
        // print cat name
        System.out.println(cat1.getName());
    }
}

class Animal{
    public String getName() {
        return "Animal";
    }
}

class Cat extends Animal {
    private String name;
    private int age;

    public Cat(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String getName() {
        return this.name;
    }
}
```

```
inheritance:

public class Main {
    public static void main(String[] args) {
        Cat cat1 = new Cat("cat1", 2);
        // print cat name
        cat1.meow();
        cat1.run();
    }
}

class Animal{
    private String name;
    private int age;
    public Animal(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String run() {
        return "Running...";
    }
}

class Cat extends Animal {
    public Cat(String name, int age) {
        super(name, age);
    }

    public void meow() {
        System.out.println("Meow!");
    }

}

```

# 2.
---
Wrapper classes provide a way to use primitive data types as objects.

Why we need?
- Data structures in the Collection framework, such as ArrayList, store only objects (reference types) and not primitive types.
- The objects are necessary if we wish to modify the arguments passed into the method
- An object is needed to support synchronization in multithreading.

# 3.
---
|            HashTable            |         HashMap          |
| :-----------------------------: | :----------------------: |
|           Thread-safe           |     Not Thread-safe      |
| Do not accept null key or value | Accept null key or value |
|      Slower(Synchronzied)       |  Faster (Asynchronized)  |

# 4.
---
String poll in java is the memory space where allocate to store the constant string values such as String str = "str".
String poll helps memory management of jvm which saved memory space during the implementation.

# 5.
---
Garbage Collection is the automatic memory allocation system in java which reclaims memory used by objects/reference that can never again be accessed.

# 6.
---
| Modifier  |                              Scopres                               |
| :-------: | :----------------------------------------------------------------: |
|  Default  | declarations are visible only within the package (package private) |
|  Private  |           declarations are visible within the class only           |
| Protected |   declarations are visible within the package or all subclasses    |
|  Public   |                declarations are visible everywhere                 |

# 7.
---
|      Field       |      Method      |                    Class                     |
| :--------------: | :--------------: | :------------------------------------------: |
| define constants | prevent override | prevent inheritance and make class immutable |

# 8.
---
| Keyword usage   |                                                                                                                                               Description                                                                                                                                                |
| --------------- | :------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------: |
| `static` field  |              A field that belongs to the class itself rather than to any instance of the class. There is only one copy of a static field shared by all instances of the class. Typically used for values that are shared across all instances of the class, such as constants or counters.               |
| `static` method | A method that belongs to the class itself rather than to any instance of the class. Static methods can be called without creating an instance of the class. Typically used for utility functions that don't depend on the state of any object, such as mathematical calculations or string manipulation. |
| `static` class  |                           An inner class that is defined as static. A static class can only access static members of the enclosing class and does not have access to any instance members. Typically used for helper classes that are closely related to the enclosing class.                            |

# 9.
---
|                             Method Overloading                              |                                          Method Overriding                                          |
| :-------------------------------------------------------------------------: | :-------------------------------------------------------------------------------------------------: |
|                    Overloading happens at compile time.                     |                                   Overriding happens at runtime.                                    |
| Gives better performance because the binding is being done at compile time. |                Gives less performance because the binding is being done at run time.                |
|                Private and final methods can be overloaded.                 |                          Private and final methods can NOT be overridden.                           |
|    Return type of method does not matter in case of method overloading.     |                  Return type of method must be the same in the case of overriding.                  |
|           Arguments must be different in the case of overloading.           |                        Arguments must be the same in the case of overriding.                        |
|                     It is being done in the same class.                     |                         Base and derived(child) classes are required here.                          |
|            Mostly used to increase the readability of the code.             | Mostly used to provide the implementation of the method that is already provided by its base class. |

# 10. 
---
| Keyword |                                                                                                                                                                                              Description                                                                                                                                                                                               |
| :-----: | :----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------: |
| `super` |                                                Refers to the superclass of the current class. It is used to access members of the superclass, including fields, methods, and constructors. `super` can be used to call a constructor of the superclass, or to access a field or method of the superclass that has been overridden in the current class.                                                |
| `this`  | Refers to the current object or instance of the class. It is used to access members of the current object, including fields, methods, and constructors. `this` can be used to call a constructor of the current class, or to access a field or method of the current object. `this` is also used to pass the current object as a parameter to a method, or to return the current object from a method. |

# 11.
---
static variable/block -> constructor(used in Obj)

# 12.
---
In Java, polymorphism refers to the same object exhibiting different forms and behaviors.

We use `Overload` and `Override` to implement the polymorphism in java.

# 13.
---
Encapsulation refers to binding the data and the methods to manipulate that data together in a single unit (class).

Java implements Encapsulation by using the modifiers such as public, private, protected.

Referring to encapsulation - a wrapping class which prevent the states inside the warpped class to be modified by outside code.

# 14. 
| Feature              | Interface                                                                                                                                                     | Abstract Class                                                                                                                                                                                                                                                           |
| -------------------- | ------------------------------------------------------------------------------------------------------------------------------------------------------------- | ------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------ |
| Inheritance          | An interface can extend multiple other interfaces.                                                                                                            | An abstract class can only extend one other class or abstract class.                                                                                                                                                                                                     |
| Implementation       | A class that implements an interface must implement all of its methods.                                                                                       | A subclass of an abstract class can choose to implement or override any of its methods, but is not required to implement all of them.                                                                                                                                    |
| Access Modifiers     | All methods in an interface are implicitly public.                                                                                                            | Methods in an abstract class can have any access modifier.                                                                                                                                                                                                               |
| Default Methods      | An interface can provide default implementations for its methods using the `default` keyword.                                                                 | An abstract class can provide implementations for some or all of its methods using the `default` keyword.                                                                                                                                                                |
| Static Methods       | An interface can provide static methods using the `static` keyword.                                                                                           | An abstract class can provide static methods using the `static` keyword.                                                                                                                                                                                                 |
| Constructors         | An interface cannot have constructors.                                                                                                                        | An abstract class can have constructors.                                                                                                                                                                                                                                 |
| Fields               | An interface can have only constants (static final fields) and default methods.                                                                               | An abstract class can have any type of fields, including instance variables.                                                                                                                                                                                             |
| Multiple Inheritance | An interface can provide multiple inheritance-like behavior through default methods.                                                                          | An abstract class provides limited multiple inheritance-like behavior through inheritance from interfaces and composition.                                                                                                                                               |
| Polymorphism         | Interfaces allow for polymorphic behavior. An object can be assigned to a variable of any interface or class type that it implements.                         | Abstract classes allow for polymorphic behavior. An object can be assigned to a variable of any class type in its inheritance hierarchy.                                                                                                                                 |
| Usage                | Use an interface when you want to define a contract for a group of related classes that share common behavior, but may not have any implementation in common. | Use an abstract class when you want to provide a base implementation for a group of related classes that share common behavior, but may have different implementations. Use an abstract class when you want to define a common interface for a group of related classes. |

# 16.
---
In Java, the `Queue` interface represents a collection that orders its elements in a specific way for processing. The `Queue` interface is implemented by several classes, each of which has its own characteristics and use cases. Here are some of the most commonly used `Queue` implementations in Java:

1. `ArrayDeque`: A double-ended queue that stores its elements in an array. Elements can be added or removed from both ends of the queue. Use this implementation when you need a fast, efficient implementation that supports both stack-like and queue-like behavior.

2. `LinkedList`: A linked list implementation of the `Queue` interface. Elements can be added or removed from the beginning or end of the queue. Use this implementation when you need a `Queue` implementation that allows efficient insertion and deletion of elements from both ends of the queue.

3. `PriorityQueue`: A priority queue implementation of the `Queue` interface. Elements are ordered based on their natural ordering or a specified `Comparator`. Use this implementation when you need a `Queue` that prioritizes elements based on their value.

4. `ConcurrentLinkedQueue`: A thread-safe implementation of the `Queue` interface. This implementation is suitable for use in a concurrent environment where multiple threads may access the queue simultaneously. Use this implementation when you need a thread-safe `Queue`.

When deciding which `Queue` implementation to use, consider the specific requirements of your application. For example, if you need a fast, efficient queue that supports both stack-like and queue-like behavior, `ArrayDeque` may be the best choice. If you need a `Queue` that prioritizes elements based on their value, `PriorityQueue` may be the best choice. If you need a thread-safe `Queue`, `ConcurrentLinkedQueue` may be the best choice.







    