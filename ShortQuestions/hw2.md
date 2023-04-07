## 1. Write up Example code to demonstrate the three fundamental concepts of OOP. (reference Code Demo
   repo as example)
1. Encapsulation;
```
    public class src.encapsulation.Encapsulation.Student {
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
    
    public class Encapsulation {
        public static void main(String[] args) {
            src.encapsulation.Encapsulation.Student student = new src.encapsulation.Encapsulation.Student();
            student.setName("Jianqiao");
            student.setAge(25);
    
            // Retrieve the name and age
            String name = person.getName();
            int age = person.getAge();
    
            // Print the name and age
            System.out.println("Name: " + name); // Name: Jianqiao
            System.out.println("Age: " + age); // Age: 25
        }
    }
```
2. Polymorphism;
```
   public class Animal {
       public void makeSound() {
           System.out.println("The animal makes a sound");
       }
   }
   
   public class Dog extends Animal {
       @Override
       public void makeSound() {
           System.out.println("The dog barks");
       }
   }
   
   public class Cat extends Animal {
       @Override
       public void makeSound() {
           System.out.println("The cat meows");
       }
   }
   
   public class Main {
       public static void main(String[] args) {
           Animal animal1 = new Dog();
           Animal animal2 = new Cat();
   
           animal1.makeSound(); // The dog barks
           animal2.makeSound(); // The cat meows
       }
   }
```

3. Inheritance;
```
   public class Animal {
       protected String name;
   
       public Animal(String name) {
           this.name = name;
       }
   
       public void eat() {
           System.out.println(name + " is eating");
       }
   
       public void sleep() {
           System.out.println(name + " is sleeping");
       }
   }
   
   public class Dog extends Animal {
       public Dog(String name) {
           super(name);
       }
   
       public void bark() {
           System.out.println(name + " is barking");
       }
   }
   
   public class Main {
       public static void main(String[] args) {
           Dog myDog = new Dog("Joe");
           myDog.eat();
           myDog.sleep();
           myDog.bark();
       }
   }
```

## 2. What is wrapper class in Java and Why we need wrapper class?
A wrapper class is a class that provides an object representation of a primitive type. There are eight primitive 
types in Java: `byte`, `short`, `int`, `long`, `float`, `double`, `char`, and `boolean`. For each of these primitive 
types, there is a corresponding wrapper class: `Byte`, `Short`, `Integer`, `Long`, `Float`, `Double`, `Character`, 
and `Boolean`. Wrapper classes allow us to treat primitive values as objects. This is important because many of the classes and methods in the Java API require objects, not primitives.

## 3. What is the difference between HashMap and HashTable?
| HashMap                                                                                    | HashTable                                                                                        |
|--------------------------------------------------------------------------------------------|--------------------------------------------------------------------------------------------------|
| Not synchronized                                                                           | Synchronized                                                                                     |
| Null is allowed for both key and value.                                                    | Null is not allowed for both key and value. Otherwise, we will get a null pointer exception.     |  
| Multiple threads can operate simultaneously and hence hashmap’s object is not thread-safe. | At a time only one thread is allowed to operate the Hashtable’s object. Hence it is thread-safe. |
| Threads are not required to wait and hence relatively performance is high.                 | It increases the waiting time of the thread and hence performance is low.                        |

## 4. What is String pool in Java and why we need String pool?
- String pool in Java is a special memory area in the heap where String objects are stored. When a string literal is 
declared in a Java program, the JVM checks if it already exists in the string pool. If it does, a reference to the 
existing String object is returned. Otherwise, a new String object is created in the pool and the reference to it is 
  returned. 
- String pool is used to optimize memory usage and performance. Since string literals are used frequently in Java programs, it would be inefficient to create a new String object every time a string literal is declared. By storing string literals in the string pool, Java ensures that only one copy of each distinct string literal is created and shared among all instances of the same string value.
## 5. What is Java garbage collection?
Java garbage collection is a process of automatically freeing up the memory used by Java objects that are no longer referenced or needed by the Java program. Java's garbage collector periodically scans the Java heap for objects that are no longer referenced by the program and then releases their memory.

## 6. What are access modifiers and their scopes in Java?
Access modifiers in Java are keywords that determine the accessibility of classes, variables, methods, and 
constructors in Java.
1. Public: Accessible from anywhere in the program.
2. Protected: Accessible within the same package or in a subclass, even if the subclass is in a different package.
3. Default: Accessible within the same package.
4. Private: Accessible only within the same class.

## 7. What is final key word? (Field, Method, Class)
`final` keyword can be applied to fields, methods, and classes to indicate that they cannot be modified or overridden, depending on the context in which it is used.
1. Final fields: When a field is declared as `final`, its value cannot be changed after it has been assigned once. This is often used to create constants in Java.
2. Final methods: When a method is declared as `final`, it cannot be overridden by any subclass. This is often used to prevent a subclass from modifying the behavior of a method defined in the superclass.
3. Final classes: When a class is declared as `final`, it cannot be subclassed. This is often used to prevent a class from being extended or modified by other classes.

## 8. What is static keyword? (Field, Method, Class). When do we usually use it?
In Java, the static keyword can be used to declare static fields, methods, and classes.

1. Static Block: A static block is a static initializer that is executed when a class is loaded into memory. It is declared using the `static` keyword and the block is enclosed in braces `{}`. This block is executed only once, when the class is loaded into the memory.
2. Static Variable: A static variable is a class-level variable that is shared among all instances of the class. It can be accessed without creating an instance of the class.
3. Static methods: A static method is a method that belongs to a class rather than an instance of the class. It can be called without creating an instance of the class. This is useful when you have a method that does not depend on the state of any particular instance of the class.
4. Static class: A static class is a nested class that is associated with the outer class rather than an instance of the outer class. It can be instantiated without creating an instance of the outer class. This is useful when you want to group related functionality together in a single class.

## 9. What is the differences between overriding and overloading?
| **Overloading**                                                                 | **Overriding**                                                                                            |
|---------------------------------------------------------------------------------|-----------------------------------------------------------------------------------------------------------|
| Overloading happens at **compile time**.                                        | Overriding happens at **runtime**.                                                                        |
| Gives **better performance** because the binding is being done at compile time. | Gives **less performance** because the binding is being done at run time.                                 |
| **Private** and **final** methods can be **overloaded**.                        | **Private** and **final** methods can **NOT** be overridden.                                              |
| Return type of method does not matter in case of method overloading.            | Return type of method must be the same in the case of overriding.                                         |
| **Arguments must be different** in the case of overloading.                     | Arguments must be the same in the case of overriding.                                                     |
| It is being done in the **same class**.                                         | Base and **derived(child) classes** are required here.                                                    |
| Mostly used to increase the **readability** of the code.                        | Mostly used to provide the **implementation** of the method that is already provided by its base class.   |

## 10. What is the differences between `super` and `this`?
- `this` is a reference to the current object, which is the object that is executing the current method or constructor.
- `super` is used to refer to the parent class of a subclass. It is used to access the members of the parent class, 
  such as instance variables, methods, or constructors.

## 11. What is the Java load sequence?
static variable/block -> constructor(used in Obj)

## 12. What is Polymorphism? And how Java implements it?
Polymorphism refers to the same object exhibiting different forms and behaviors. In Java, polymorphism is implemented through method overloading and method overriding.

## 13. What is Encapsulation ? How Java implements it? And why we need encapsulation?
Encapsulation in OOP refers to binding the data and the methods to manipulate that data together in a single unit
(class). In Java, encapsulation is implemented through the use of access modifiers such as `private`, `protected`, 
`public`, and `default`.

Encapsulation is important because it helps to maintain the integrity of the data in an object, and prevents unintended modification or manipulation of the object's state. It also allows for greater flexibility in modifying the implementation of a class, as changes made to the internal workings of a class do not affect the code that uses the class, as long as the public interface remains the same.

## 14. What is Interface and what is abstract class? What are the differences between them?
- An interface is a collection of abstract methods (methods without a body) that define a set of behaviors or 
capabilities that a class can implement.
- An abstract class is a class that cannot be instantiated, and is typically used as a base class for other classes to inherit from.

|                            | Interface                                                                                                                                                                                                                    | Abstract class                                                                                  |
|----------------------------|------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|-------------------------------------------------------------------------------------------------|
| Usage                      | Implements                                                                                                                                                                                                                   | Extends                                                                                         |
| Multiple Inheritances      | Implement several Interfaces                                                                                                                                                                                                 | Only one abstract class                                                                         |
| When to use                | Future enhancement                                                                                                                                                                                                           | To avoid independence                                                                           |
| Access Modifiers           | The interface does not have access modifiers. Everything defined inside the interface is assumed public modifier.                                                                                                            | Abstract Class can have an access modifier.                                                     |
| When to use                | It is better to use interface when various implementations share only method signature. Polymorphic hierarchy of value types.                                                                                                | It should be used when various implementations of the same kind share a common behavior.        |
| Implementation             | Interface can have only abstract methods. An abstract class can have abstract and non-abstract methods. From Java 8, it can have default and static methods also. From Java 9, it can have private concrete methods as well. | An abstract class can give complete, default code which should be overridden                    |
| Usage                      | Interfaces help to define the peripheral abilities of a class.                                                                                                                                                               | An abstract class defines the identity of a class.                                              |
| Defined fields             | Only static and final variables.                                                                                                                                                                                             | Abstract class can have final, non-final, static and non-static variables.                      |
| Constructor or destructors | An interface cannot declare constructors or destructors.                                                                                                                                                                     | An abstract class can declare constructors and destructors.                                     |
| Abstract keyword           | In an abstract interface keyword, is optional for declaring a method as an abstract.                                                                                                                                         | In an abstract class, the abstract keyword is compulsory for declaring a method as an abstract. |


## 15. (OOD) Design a parking lot (put the code to codingQuestions/coding1 folder, )
Please check Coding/coding1/ParkingLot

## 16. What are Queue interface implementations and what are the differences and when to use what?
1. **LinkedList**: It is a doubly linked list implementation of the Queue interface. It provides constant-time performance for adding and removing elements from both the beginning and end of the queue.

2. **PriorityQueue**: It is a priority-based implementation of the Queue interface. The elements in the priority queue are ordered based on their natural ordering or using a custom Comparator. It provides O(log n) time complexity for adding and removing elements.

3. **ArrayDeque**: It is a resizable-array implementation of the Queue interface. It provides constant time performance for adding and removing elements from both the beginning and end of the queue.