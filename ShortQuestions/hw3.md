# Part1
# 1. Practice collection
The code are in `mavenProject/hw3/src/test`

# 2. What is the checked exception and unchecked exception in Java,could you give one example?
- Checked exceptions represent errors outside the control of the program. In Checked Exception must use catch or throws.  
For example, 
  - IOException (e.g. FileNotFound) SQLException
  - (e.g. Id/data does not exits)
- If a program throws an unchecked exception, it reflects some error inside the program logic.
For example, 
  - if we divide a number by 0, Java will throw ArithmeticException
  - NullPointerException (NPE)
  - IndexOutOfBoundsException (e.g. List/Array)

# 3. Can there be multiple finally blocks?
No. `finally` can only be used once with a try or try-catch block.

# 4. When both catch and finally return values,what will be the final result?
The value returned by the `finally` block will override the value returned by the  `catch` block.
```
    try {
        orderDao.findOrderById(orderId);
        } catch(OrderNotFoundException e) {
        // busic logic
        return 3;
       } finally {
      return 5;
    }
// 5
```

# 5. What is Runtime/unchecked exception? what is Compile/CheckedException?
- An unchecked exception is an exception that is not checked at compile-time by the Java compiler. It is a type of exception that is not required to be caught or declared by a method.
- A compile-time exception (also known as a checked exception) is a type of exception that is required to be caught or declared by the method. 

# 6. What is the difference between throw and throws?
`throw` is used to throw an exception object in a method or block of code.
`throws` is used in a method signature to declare that the method throw exceptions.
`throws` or `try catch` when call the method who `throws` exception
```
  throw new RuntimeException();  // throw
  public void getOrder(String orderId) throws OrderNotFoundException { //throws
  }
```

# 7. Run the below three pieces codes,Noticed the printed exceptions. why do we put the Null/Runtime exception before Exception ?
In the provided code, catching `NullPointerException` and `RuntimeException` before Exception is recommended.
Because `NullPointerException` and `RuntimeException` are both subclasses of Exception. Narrow exception should be caught firstly.

# 8. Why finally always be executed?
`finally` block is used to specify a block of code that should always be executed after a try-catch block, regardless of whether the program executes normally or an exception is thrown.
Imagine you opened a file, get an exception, then throwed or returned, but never closed. that's the reason why finally always be executed.

# 9. What are the SOLID Principles?
`S` Single Responsibility Principle (SRP): This principle states that a class should have only one reason to change. In other words, a class should have only one responsibility or job, and it should be designed to do that job well.
`O` Open/Closed Principle (OCP): Open/Closed Principle (OCP): This principle states that a class should be open for extension but closed for modification. In other words, a class should be designed in such a way that new functionality can be added by extending the class, without modifying its existing code.
`L` Liskov Substitution Principle (LSP): This principle states that any object of a superclass should be replaceable with an object of its subclass without affecting the correctness of the program. In other words, a subclass should be able to be used in place of its superclass without causing any unexpected behavior.
`I` Interface Segregation Principle (ISP): This principle states that a class should not be forced to depend on interfaces it does not use. In other words, an interface should be designed to contain only the methods that are relevant to its implementing class.
`D` Dependency Inversion Principle (DIP): This principle states that high-level modules should not depend on low-level modules, but both should depend on abstractions. In other words, classes should depend on interfaces or abstract classes rather than concrete implementations, which allows for greater flexibility and easier maintenance.

# 10. How can you achieve thread-safe singleton patterns in Java?
- Eager initialization
```
public class Singleton {
    private static final Singleton INSTANCE = new Singleton();
    
    private Singleton() {
        // private constructor to prevent instantiation from outside the class
    }
    
    public static Singleton getInstance() {
        return INSTANCE;
    }
}

```

- Synchronized getInstance() method
```
public class Singleton {
    private static Singleton instance;
    
    private Singleton() {
        // private constructor to prevent instantiation from outside the class
    }
    
    public static synchronized Singleton getInstance() {
        if (instance == null) {
            instance = new Singleton();
        }
        return instance;
    }
}

```

- Double-checked locking
```
public class Singleton {
    private static volatile Singleton instance;
    
    private Singleton() {
        // private constructor to prevent instantiation from outside the class
    }
    
    public static Singleton getInstance() {
        if (instance == null) {
            synchronized (Singleton.class) {
                if (instance == null) {
                    instance = new Singleton();
                }
            }
        }
        return instance;
    }
}
```

# 11. What do you understand by the Open-Closed Principle (OCP) ?
The Open-Closed Principle (OCP) is a principle of software design that states that software entities (classes, modules, functions, etc.) should be open for extension but closed for modification.
Here is example code, 
```
public interface Shape {
    double area();
}

public class Rectangle implements Shape {
    private double width;
    private double height;
    
    public Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }
    
    public double area() {
        return width * height;
    }
}

public class Circle implements Shape {
    private double radius;
    
    public Circle(double radius) {
        this.radius = radius;
    }
    
    public double area() {
        return Math.PI * radius * radius;
    }
}

```

# 12. (SOLID-L)Liskov’s substitution principle states that if class B is a subtype of class A, then object of type A may be substituted with any object of type B.What does this actually mean? (from OA ) choose your answer.
Any object of a superclass should be replaceable with an object of its subclass without causing any unexpected behavior.
For example, consider a class hierarchy of shapes that includes a superclass Shape and subclasses Rectangle and Square. The Square class is a subtype of the Rectangle class, since a square is a special case of a rectangle where all sides are equal. If the Square class violates the LSP, it may lead to unexpected behavior.
```
public void setDimensions(Rectangle r, int width, int height) {
    r.setWidth(width);
    r.setHeight(height);
}
```
If we create a Square object and pass it to the setDimensions() method, we would expect the width and height to be equal, since a square has equal sides. 
However, if the Square class does not adhere to the LSP, it may have additional constraints that prevent the width and height from being equal. This could result in unexpected behavior, such as incorrect calculations or invalid state.

To adhere to the LSP, the Square class should not impose additional constraints that are not present in the Rectangle class. 
In other words, it should behave like a Rectangle object in all respects, but with the additional constraint that all sides are equal.



# 13. Watch the design pattern video, and type the code
The routes are below:
```
MavenProject/hw3/src/main/java/com/chuwa/learn/singleton
MavenProject/hw3/src/main/java/com/chuwa/learn/builder
MavenProject/hw3/src/main/java/com/chuwa/learn/factory
MavenProject/hw3/src/main/java/com/chuwa/learn/pubsub
```

# 14. CRUD MySQL and MongoDB
see in route:
`ShortQuestions/hw3_db.md`

# Part2
# 1. What are the types of design patterns in Java?
- Creational Patterns: These patterns deal with object creation mechanisms, trying to create objects in a manner suitable for the current situation. 
Examples include Singleton, Factory, Abstract Factory, Builder, and Prototype patterns.

- Structural Patterns: These patterns deal with object composition, trying to form objects into larger structures and systems while keeping these structures flexible and efficient. 
Examples include Adapter, Bridge, Composite, Decorator, Facade, Flyweight, and Proxy patterns.

- Behavioral Patterns: These patterns deal with object interaction and responsibility allocation, trying to define how objects interact with each other to perform tasks. 
Examples include Chain of Responsibility, Command, Interpreter, Iterator, Mediator, Memento, Observer, State, Strategy, Template Method, and Visitor patterns.

# 2. What are the SOLID Principles?
`S` Single Responsibility Principle (SRP): This principle states that a class should have only one reason to change. In other words, a class should have only one responsibility or job, and it should be designed to do that job well.
`O` Open/Closed Principle (OCP): Open/Closed Principle (OCP): This principle states that a class should be open for extension but closed for modification. In other words, a class should be designed in such a way that new functionality can be added by extending the class, without modifying its existing code.
`L` Liskov Substitution Principle (LSP): This principle states that any object of a superclass should be replaceable with an object of its subclass without affecting the correctness of the program. In other words, a subclass should be able to be used in place of its superclass without causing any unexpected behavior.
`I` Interface Segregation Principle (ISP): This principle states that a class should not be forced to depend on interfaces it does not use. In other words, an interface should be designed to contain only the methods that are relevant to its implementing class.
`D` Dependency Inversion Principle (DIP): This principle states that high-level modules should not depend on low-level modules, but both should depend on abstractions. In other words, classes should depend on interfaces or abstract classes rather than concrete implementations, which allows for greater flexibility and easier maintenance.

# 3. How can you achieve thread-safe singleton patterns in Java?
- Eager initialization: In this approach, the Singleton instance is created at the time of class loading. This guarantees that the instance is thread-safe because the JVM guarantees that the class is loaded only once. However, this approach can lead to unnecessary resource consumption if the Singleton instance is not used frequently.

- Lazy initialization with synchronized method: In this approach, the Singleton instance is created only when it is needed, but the getInstance() method is synchronized to ensure that only one thread can create the instance. However, this approach can lead to performance issues because every call to getInstance() will have to wait for the lock, even if the instance has already been created.

- Double-checked locking: In this approach, the getInstance() method is synchronized only when the instance is null. This allows multiple threads to access the instance simultaneously after it has been created, without incurring the overhead of synchronization on subsequent calls. However, this approach requires careful implementation to avoid subtle bugs.

- Initialization-on-demand holder idiom: In this approach, the Singleton instance is created as a static inner class that is loaded only when getInstance() is called for the first time. This guarantees thread safety, lazy initialization, and high performance, without any additional synchronization or locking.

# 4. What do you understand by the Open-Closed Principle (OCP)?
The Open-Closed Principle (OCP) is a principle of software design that states that software entities (classes, modules, functions, etc.) should be open for extension but closed for modification.

# 5. What do you understand by the Liskov Substitution Principle?
Liskov Substitution Principle (LSP) is one of the five SOLID principles of object-oriented design, named after Barbara Liskov. It states that if a program is using a base class, it should be able to use any of its derived classes without knowing it. In other words, a derived class should be substitutable for its base class.



# 6. Liskov’s substitution principle states that if class B is a subtype of class A, then object of type A may be substituted with any object of type B. What does this actually mean? (from OA ) choose your answer.
I choose 1. Please see reasons in Part1 Q12

# Part3
Credit Card Notification
We need to send notification to users by notification preference like email/SMS etc,handle error appropriately when preference given does not match.Write simple java program using design patterns , program to interface & Error handling concepts to come up with solve for above problem.
- Notification type: email/SMS/WhatsAPP
- Call notification module to send notification
- Integrate with notification module to notify depending on preference.
   - if A prefer EMAIL, then we notify A by EMAIL 
- Pass user details and other data points to send email
   - Notificaiton content :
     - Hey firstName, you have successfully registered to add and here is your , please use this for
       future references.
- Broadcast public notification to all users
  - 40% off when you buy Popeyes between 06/13 - 06/19

Please see code in:
`MavenProject/hw3/src/main/java/com/chuwa/learn/designPattern`