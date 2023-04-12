# 1.  Write up Example code to demonstrate the three foundmental concepts of OOP.
- Encapsulation
```
public class Person {
    private String name;
    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
```
- Polymorphism
```
public class Animal {
    public void makeSound() {
        System.out.println("The animal makes a sound.");
    }
}

public class Dog extends Animal {
    @Override
    public void makeSound() {
        System.out.println("The dog barks.");
    }
}

public class Cat extends Animal {
    @Override
    public void makeSound() {
        System.out.println("The cat meows.");
    }
}
```
- Inheritance
```
public class Animal {
    private String name;
    private int age;
    
    public Animal(String name, int age) {
        this.name = name;
        this.age = age;
    }
    
    public void eat() {
        System.out.println(name + " is eating.");
    }
    
    public void sleep() {
        System.out.println(name + " is sleeping.");
    }
}

public class Dog extends Animal {
    public Dog(String name, int age) {
        super(name, age);
    }
    
    public void bark() {
        System.out.println("Woof!");
    }
}

public class Cat extends Animal {
    public Cat(String name, int age) {
        super(name, age);
    }
    
    public void meow() {
        System.out.println("Meow!");
    }
}
```
# 2. What is wrapper class in Java and Why we need wrapper class?
In Java, a wrapper class is a class that encapsulates primitive data types (int, byte, double, float, long, short, char, boolean). It provides a way to work with primitive types as objects, and provide additional functionality for working with these types. Wrapper classes are used to represent primitive types as objects. This is useful because objects can be manipulated and passed around like any other object, while primitive types cannot. In wrapper classe, it can provide some methods such as convering int to string, or parsing string to int. And wrapper classes can also be used in collections such as lists and maps.
# 3. What is the difference between HashMap and HashTable?
- Hashtable is thread-safe, meaning it can be safely accessed by multiple threads at the same time without causing any issues with data consistency or synchronization. HashMap is not thread-safe by default.
- Hashtable does not allow null keys or values, while HashMap allows one null key and any number of null values.
- Hashtable is slower than HashMap because it is thread-safe and each method is synchronized. HashMap is faster because it is not synchronized.
- Iterating over a Hashtable returns the elements in an arbitrary order, while HashMap returns the elements in the order they were inserted.
- Hashtable is a subclass of Dictionary, while HashMap is a subclass of AbstractMap.
# 4. What is String pool in Java and why we need String pool?
In Java, the String pool is a special memory area where Java stores String literals. String literals are strings that are explicitly defined in code. Such as String name = "chen". The String pool is important because it allows Java to optimize memory usage for String literals. For example, if a Java program creates two String objects with the same value, such as "chen" and "chen", Java can reuse the same object in the String pool instead of creating two separate objects. This can lead to significant memory savings in programs that use many String literals.
# 5. What is Java garbage collection?
Garbage Collection is an automatic memory management process that frees up memory occupied by objects that are no longer being used or referenced by the program. Objects are created on heap memory and managed by the JVM. Periodically, the JVM looks for objects that are not referenced by the program and frees up memory accordingly. Garbage Collection can ensure projects do not run out of memory.
# 6. What are access modifiers and their scopes in Java?
There are four access modifiers in Java: Public, Protected, Default, Private. 
Their scopes:
- `Public`: Accessible from anywhere in the program.
- `Protected`: Accessible within the class, subclasses, and other classes in the same package.
- `Default`: Accessible within the same package.
- `Private`: Accessible only within the same class.
# 7. What is final key word? (Filed, Method, Class)
The final key word can be used to declare that a field, method, or class cannot be modified after it has been initialized.
- `Final field`: Final cannot be changed once it has been initialized. Final fields must be initialized either at the time of their declaration or in the constructor of the class. Once a final field has been initialized, it cannot be reassigned.
- `Final method`: final method cannot be overridden by any subclass. Its implementation is fixed and cannot be changed.
- `Final class`: The subclass cannot be defined in a final class. This means that the behavior and implementation of a final class are fixed and cannot be changed or extended by any subclass.
# 8. What is static keyword? (Filed, Method, Class). When do we usually use it?
The static keyword can be used to declare that a field, method, or inner class belongs to the class itself, rather than to any individual instance of the class.
- `static field`: A static field is a field that belongs to the class itself, rather than to any instance of the class. This means that the value of the static field is shared by all instances of the class.
- `static method`:  A static method is a method that belongs to the class itself, rather than to any instance of the class.
- `static class`: static inner class is an inner class that belongs to the class itself, rather than to any instance of the class. This means that the static inner class can be accessed without creating an object of the outer class. Static inner classes are often used to encapsulate utility classes or helper functions that are closely related to the outer class.

We usually use the static keyword to create class-level data or methods that can be shared across all instances of the class, or to encapsulate utility functions or helper classes that are closely related to the class. Static key word can also improve the performance of a Java project.
# 9. What is the differences between overriding and overloading?
- Overloading happens at compile time. Overriding happens at runtime
- Overloading ives better performance because the binding is being done at compile time. And Overriding gives less performance.
- Private and final methods can be overloaded but overriding not.
- Return type of method must be the same in the case of overriding but it doesn't matter in case of method overloaded.
- Arguments must be different in the case of overloading but they must be same in the case of overriding.
- Overloading must be done in the same class. And overriding requires base and derived classes.
- Overloading is mostly used to increase the readability of the code, and overriding provide the implementation of the method that is already provided by its base class.
# 10. What is the differences between super and this?
This accesses the properties, methods and structures in this class, and super accesses the properties, methods and structures in the superclass. This calls the variable of the current object, and super calls the variable of the superclass.
# 11. What is the Java load sequence?
In Java, the order in which classes are loaded is determined by the Java Class Loader. The Java Class Loader is responsible for loading classes and interfaces from the file system, network, or other sources, and ensures that classes are loaded in the correct order to resolve dependencies and avoid circular references. The Java Class Loader loads classes in the following order:
- Bootstrap Class Loader.
- Extension Class Loader.
- System Class Loader.
- Custom Class Loader.

If two classes depend on each other, they must be loaded in the correct order to avoid circular references. If a class is loaded multiple times by different class loaders, it may cause conflicts or unexpected behavior.
# 12. What is Polymorphism ? And how Java implements it ?
In programming, polymorphism refers to the same object exhibiting different forms and behaviors.
To implement Polymorphim, the direct method is to use "extend", such as "class subclass extend superclass".
# 13. What is Encapsulation ? How Java implements it? And why we need encapsulation?
Encapsulation in OOP refers to binding the data and the methods to manipulate that data together in a single unit (class).
Java implements encapsulation through the use of access modifiers (Default, Private, Protected, Public). 
Encapsulation protects the internal state of an object from being modified by outside code. It provides a clean public interface for interacting with the object, which hides the implementation details. And it promotes code reusability by encapsulating common functionality into reusable classes, makes it easier to change the implementation of the object without affecting the code that uses it.
# 14. What is Interface and what is abstract class? What are the differences between them?
- `Interface`: Interface is a contract that specifies a set of methods that a class must implement. It defines a set of abstract methods (methods with no implementation) that must be implemented by any class that implements the interface. In addition to abstract methods, an interface can also include constants and default methods (methods with a default implementation).
- `Abstract class`: An abstract class is a class that cannot be instantiated, but can be subclassed. It can contain both abstract and non-abstract methods, as well as fields and constructors. An abstract method is a method with no implementation that must be implemented by any subclass of the abstract class.
Differences:
- An interface cannot be instantiated, whereas an abstract class can be subclassed and instantiated (though the subclass must still implement any abstract methods).
- A class can implement multiple interfaces, but can only extend one abstract class.
- In an interface, all methods are abstract and have no implementation. In an abstract class, some methods may be abstract and some may have a concrete implementation.
- All methods in an interface are public by default, whereas an abstract class can have methods with any access modifier.
# 15. (OOD) Design a parking lot.
See Coding/coding1.
# 16. What are Queue interface implementations and what are the differences and when to use what?
Quene interface implementations contain:
- LinkedList.
- PriorityQueue.
- ArrayDeque
- ConcurrentLinkedQueue.
- LinkedBlockingQueue.

The choice of which implementation to use depends on the specific requirements of your application. If you need to order elements by priority, use PriorityQueue. If you need to add or remove elements from both ends of the queue, use LinkedList or ArrayDeque. If you need thread-safety, use ConcurrentLinkedQueue. If you need blocking behavior, use LinkedBlockingQueue.

















































