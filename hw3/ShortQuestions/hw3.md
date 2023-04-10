# 2.
---
Checked exceptions are exceptions that are checked at compile-time. The programmer is required to either catch these exceptions or declare them in the throws clause of the method. Example: IOException.

Unchecked exceptions are exceptions that are not checked at compile-time. The programmer is not required to catch or declare them. Example: NullPointerException.

```
// Checked exception example
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class FileReadExample {
    public static void main(String[] args) {
        File file = new File("example.txt");
        try {
            FileReader fr = new FileReader(file);
            // Do something with the file
        } catch (IOException e) {
            System.out.println("An error occurred while reading the file.");
            e.printStackTrace();
        }
    }
}

// Unchecked exception example
public class NullPointerExceptionExample {
    public static void main(String[] args) {
        String str = null;
        System.out.println(str.length());
    }
}


```

# 3.
---
You cannot make multiple finally block in one try-catch statement.

# 4.
---
The value returned by finally will overwrite the return value of catch.

# 5.
---
Runtime or unchecked exceptions are not checked at compile time, which means the compiler doesn't force the programmer to handle them explicitly. They occur during the execution of a program and can be handled using a try-catch block, but it is not mandatory to do so. Examples include NullPointerException and ArithmeticException.

Compile-time or checked exceptions are checked by the compiler at compile time and force the programmer to handle them explicitly. This means that if a method throws a checked exception, the calling method must either handle it using a try-catch block or declare it in its throws clause. Examples include IOException and ClassNotFoundException.

# 6.
---
`throw` is used to explicitly throw an exception in the code. It is followed by an instance of an exception class, which can be either a built-in or custom exception.

`throws` is used in a method declaration to indicate that the method may throw one or more types of exceptions. It is followed by a list of exceptions that the method may throw, separated by commas.


# 7.
---
NullPointerException and RuntimeException are unchecked exceptions, so they don't require declaration in the method signature and are frequently encountered in Java programs. Therefore, it's recommended to handle them before other exceptions. Catching Exception first can lead to catching any occurring NullPointerException or RuntimeException as well, which may cause unexpected program behavior.

# 8.
---
When an exception is thrown, the control is transferred to the nearest catch block that matches the type of the thrown exception. However, before the control is transferred to the catch block, the finally block is executed. Similarly, when no exception is thrown, the finally block is executed after the try block. Therefore, finally block is always executed to guarantee that a certain block of code is executed regardless of whether an exception was thrown or not, and to perform any necessary cleanup or resource release.

# 9.
---
1. Creational Patterns - These patterns are used to create objects in a way that is suitable for a particular situation. Examples of creational patterns include Singleton, Factory Method, Abstract Factory, and Builder.

2. Structural Patterns - These patterns are used to organize objects in a way that makes it easier to understand and work with them. Examples of structural patterns include Adapter, Facade, Bridge, and Decorator.

3. Behavioral Patterns - These patterns are used to manage the interaction between objects and how they communicate with each other. Examples of behavioral patterns include Observer, Strategy, Command, and Template Method.

# 10.
---
SOLID consists of 5 coding practices:

1. SRP - Single responsibility principle
   - says that each method / class should be responsible for one specific activity. Inserting everything into one method does not meet the basic assumptions of objectivity, but also makes it difficult to read, repair or expand programs.
2. OCP - Open/close principle
   - says that the classes that we create are open to extensions and closed to modifications.
3. LSP - Liskov substitution principle
   - says that functions that use pointers or references to base classes must also be able to use class objects that inherit from the base classes without having a thorough knowledge of these objects.
4. ISP - Interface segregation principle
   - says that "Many dedicated interfaces are better than one overall".
5. DIP - Dependency inversion principle
   - say that High-level modules should not depend on low-level modules.Both should depend on abstractions.

# 11.
---
```
public class Singl
{
  // private instance, so that it can be
  // accessed by only by getInstance() method
  private static Singl instance;
 
  private Singl()
  {
    // private constructor
  }
 
 //synchronized method to control simultaneous access
  synchronized public static Singl getInstance()
  {
    if (instance == null)
    {
      // if instance is null, initialize
      instance = new Singl();
    }
    return instance;
  }
}
```

```
public class Singl
{
  // private instance, so that it can be
  // accessed by only by getInstance() method
  private static Singl instance;
 
  private Singl()
  {
    // private constructor
  }
 
  public static Singl getInstance()
  {
    if (instance == null)
    {
      //synchronized block to remove overhead
      synchronized (Singl.class)
      {
        if(instance==null)
        {
          // if instance is null, initialize
          instance = new Singl();
        }
       
      }
    }
    return instance;
  }
}
```
# 12.
---
The OCP principle says that the classes that we create are **open to extensions and closed to modifications.**

The application that we create must be ready for extensions, because the systems are changing very quickly these days. Thanks to the OCP principle, we are able to repeatedly use our classes for various tasks, which promotes reusability of the code, but also makes it easy to understand.

# 13. what do you understand by the iskov Substitution Principle?
---

Functions that use pointers or references to base classes must also be able to use class objects that inherit from the base classes without having a thorough knowledge of these objects.

# 14. Liskov's substitution principle states that if class B is a subtype of class A, then object of type A may be substituted with any object of type B. What does this actually mean? (from OA ) choose your answer
---
answer: Option 1

