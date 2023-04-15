### 1. Write up Example code to demonstrate the three foundmental concepts of OOP. (reference Code Demo repo as example)
>Encapsulation:
```
public class Example {
    private int age;
    public int getAge() {
        return age;
    }
    public int setAge(int age) {
        this.age = age;
    }
}
```
>Inheritance:
```
public class Car {
    int price = 1000;
}

public class discountCar extends Car {
    public int discount = 500;
}

class Example {
    discountCar car = new discountCar();
    System.out.println(car.price - car.discount);
}
```
>Polymorphism:
```
class Animal {
    public void Sound() {};
}

class Pig extends Animal {
    @override
    public void Sound(){};
}

class Dog extends Animal {
    @override
    public void Soound(){};
}
```

### 2. What is wrapper class in Java and Why we need wrapper class?
> Wrapper class helps in conversion from primitive to object as well as from object to primitive data type. 
> It is beneficial for situations where the program demands working with an object instead of a primitive data type.

### 3. What is the difference between HashMap and HashTable?
> One of the major differences between HashMap and Hashtable is that HashMap is non-synchronized whereas Hashtable is 
> synchronized, which means Hashtable is thread-safe and can be shared between multiple threads but HashMap can not be 
> shared between multiple threads without proper synchronization.

### 4. What is String pool in Java and why we need String pool?
> String Pool in Java is a special storage space in Java Heap memory where string literals are stored. 
> It can decrease the number of string objects created in the memory.

### 5. What is Java garbage collection?
> Garbage collection in Java is the automated process of deleting code that's no longer needed or used. This 
> automatically frees up memory space and ideally makes coding Java apps easier for developers.

### 6. What are access modifiers and their scopes in Java?
> Access modifiers are keywords that can be used to control the visibility of fields, methods, and constructors in a 
> class. The four access modifiers in Java are public, protected, default, and private.

### 7. What is final key word? (Filed, Method, Class)
> It is a non-access modifier used for classes, attributes and methods, which makes them non-changeable (impossible to 
> inherit or override).

### 8. What is static keyword? (Filed, Method, Class). When do we usually use it?
> static keyword is mainly used for memory management. It can be used with variables, methods, blocks and nested 
> classes. It is a keyword which is used to share the same variable or method of a given class. Basically, static is 
> used for a constant variable or a method that is same for every instance of a class.

### 9. What is the differences between overriding and overloading?
> Overriding occurs when the method signature is the same in the superclass and the child class. Overloading occurs when
> two or more methods in the same class have the same name but different parameters.

### 10. What is the differences between super and this?
> Super is referring to its parent class where this is referring to the current class

### 11. What is the Java load sequence?
> The JVM first loads the class file from the file system into memory, then it will perform three tasks, verification, 
> preparation and resolution. Then it will initialize the class.

### 12. What is Polymorphism ? And how Java implements it?
> In Java, polymorphism refers to the ability of a class to provide different implementations of a method, 
> depending on the type of object that is passed to the method. Polymorphism in Java can be achieved into 
> method overloading and method overriding. Polymorphism in Java is mainly divided into two types. Compile-time
> polymorphism and runtime polymorphism. Compile-time polymorphism can be achieved by method overloading, 
> and Runtime polymorphism can be achieved by method overriding.

### 13. What is Encapsulation ? How Java implements it? And why we need encapsulation?
> Encapsulation in Java is the process by which data (variables) and the code that acts upon them (methods) are 
> integrated as a single unit. Encapsulation wraps data and codes for necessary information. it helps developers to 
> easily organize the whole code.

### 14. What is Interface and what is abstract class? What are the differences between them?
> Interfaces are a kind of code contract, which must be implemented by a concrete class. Abstract classes are similar 
> to normal classes, with the difference that they can include abstract methods, which are methods without a body. 
> Abstract classes cannot be instantiated.

### 15. (OOD) Design a parking lot (put the code to codingQuestions/coding1 folder, )
> Please see coding folder

### 16. What are Queue interface implementations and what are the differences and when to use what?
> LinkedList: The LinkedList class in Java implements the Queue interface and can be used as a queue. 
> LinkedList provides constant time for adding and removing elements from the beginning and end of the list, making it 
> a good choice for small queues.   
> 
> ArrayDeque: The ArrayDeque class in Java is a resizable array that can be used as a queue. It provides constant time 
> for adding and removing elements from both ends of the array, making it a good choice for a queue with a dynamic size.
> 
> PriorityQueue: The PriorityQueue class in Java is an implementation of a priority queue. Elements are stored based on 
> their priority, and the queue retrieves the element with the highest priority first. Priority queues are useful when
> you want to process elements based on their priority, such as in event processing.
