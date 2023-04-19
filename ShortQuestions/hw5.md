# HW5

*Claudia Feng Apr 14, 2023*



  1 - 4. See Coding folder.



5. Write the Singleton design pattern include eager load and lazy load.

- Eager load

```java
public class Singleton {
  // private static variable
  private static Singleton instance = new Singleton();
  // make constructor private, cannot new
  private Singleton() {
  }
  // static method to get the instance
  public static Singleton getInstance() {
    return instance;
  }
}
```

* Lazy load

```java
public class Singleton {
  private static volatile Singleton instance;
  private Singleton() {
  }
  public static Singleton getInstance() {
    if (instance == null) {
      synchronized(Singleton.class) {
        if (instance == null) {
          instance = new Singleton();
        }
      }
    }
    return instance;
  }
}
```

 

6. What is Runtime Exception? could you give me some examples?

`RuntimeException `  are unchecked exceptions and do not require a method to declare them in `throws`  clause. Runtime exceptions usually represent programming bugs, and the correct way to address them is to fix the underlying code rather than handle them through exception handling mechanisms.

Examples:

- NullPointerException
- ArrayIndexOutOfBoundsException
- ArithmeticException



7. Could you give me one example of NullPointerException?

```java
public class Example {
	public static void main(String[] args) {
    List<Integer> list = null;
    list.add(1);
  }
}
```



8. What is the Optional class?

The `Optional` class, introduced in Java 8, is a container object that can hold either a single value of a given type or no value at all (i.e., it represents a nullable value without using `null`).



9. What are the advantages of using the Optional class?

The purpose of the `Optional` class is to help developers avoid common programming errors related to `null` values, such as `NullPointerException`, and to promote a more expressive and safe way of handling nullable values in Java. It improves the code readability, reduces the risk of `NullPointerException` and allows more functional programming style. `Optional` provides several functional-style methods, such as `map()`, `flatMap()`, `filter()`, and `orElse()`, which allow developers to manipulate and transform values in a more functional and concise way.



10. What is the @FunctionalInterface?

`@FunctionalInterface` is an annotation in Java that can be used to indicate that a particular interface is intended to be a functional interface. A functional interface is an interface with exactly one abstract method, which can be used as a target for lambda expressions and method references.



11. what is lamda?

Lambda expressions in Java are a feature introduced in Java 8, which allows for a more concise way to represent instances of functional interfaces. Lambdas provide a shorter and more readable syntax for creating anonymous classes or methods, enabling functional programming and simplifying code in many situations.

A lambda expression consists of a parameter list, an arrow symbol (`->`), and a body.



12. What is Method Reference?

Method reference in Java is a feature introduced in Java 8 that provides a more concise way to refer to a method, as an alternative to using lambda expressions. Method references can be used as a target for functional interfaces, enabling a cleaner and more readable code in certain situations.

A method reference is created using the double colon (::) operator. There are four types of method references in Java:

1. Reference to a static method:

```java
ClassName::staticMethodName
```

2. Reference to an instance method of a particular object:

```java
objectInstance::instanceMethodName
```

3. Reference to an instance method of an arbitrary object of a particular type:

```java
ClassName::instanceMethodName
```

4. Reference to a constructor:

```java
ClassName::new
```



13. What is Java 8 new features?

Lambda expressions, method references, default methods, static methods in interfaces, Streams API, Optional class.



14. Lambda can use unchanged variable outside of lambda? what is the details?

Lambda can use unchanged variable outside of lambda as long as the variable is final or effectively final.



15. Describe the newly added features in Java 8?

    1. Lambda expressions: These allow for more concise and readable code when implementing instances of functional interfaces. Lambda expressions help bring functional programming capabilities to Java.

    2. Method references: A more compact syntax for referring to methods, often used as an alternative to lambda expressions when creating instances of functional interfaces.

    3. Default methods: These allow interfaces to have concrete method implementations without affecting existing classes that implement the interface. This feature enables interfaces to evolve without breaking backward compatibility.

    4. Static methods in interfaces: Java 8 allows interfaces to have static methods, which can help group utility methods specific to an interface without requiring a separate utility class.

    5. Java Streams API: A new abstraction that provides a functional approach to processing sequences of data. The Streams API supports various operations like filter, map, reduce, and more, allowing for more expressive and parallelizable code.

    6. Optional class: The `java.util.Optional<T>` class provides a better way to handle nullable values, aiming to reduce the number of null pointer exceptions by encouraging developers to explicitly handle optional values.

    

16. Can a functional interface extend/inherit another interface?

Yes, a functional interface can extend or inherit another interface. However, there are certain rules that must be followed for the extended interface to still be considered a functional interface:

1. The extended interface must have only one abstract method, including those inherited from the parent interface(s).
2. The parent interface(s) must not have any abstract methods with the same signature as those already present in the extended interface.



17. What is the lambda expression in Java and How does a lambda expression relate to a functional interface?

* A functional interface is the target type for a lambda expression. When a lambda expression is assigned to a variable, the variable's type must be a functional interface.
* The abstract method of a functional interface is implicitly implemented by the lambda expression.
* When the functional interface's abstract method is called, it executes the body of the lambda expression associated with the interface instance.



18. In Java 8, what is Method Reference?

See question 12.



19. What does the String::ValueOf expression mean?

In Java, `String::valueOf` is a method reference that points to the `valueOf` static method in the `java.lang.String` class. This method is used to convert different data types, such as primitives or objects, into their corresponding string representation.



20. What are Intermediate and Terminal operations?

Intermediate operations:

1. Intermediate operations are lazy, meaning they are not executed immediately but are only invoked when a terminal operation is called on the stream. This allows for efficient chaining of multiple intermediate operations without actually processing any elements until required.
2. Intermediate operations transform a stream into another stream by applying a specific operation on the stream elements. This means that they return a new stream as their output, allowing for further intermediate operations to be chained.
3. Intermediate operations do not modify the original data source; instead, they create a new stream with the transformed elements.

Terminal operations:

1. Terminal operations are eager, meaning they initiate the actual processing of the data in the stream and force the evaluation of any intermediate operations in the pipeline. Terminal operations usually produce a final result or a side effect.
2. Terminal operations consume the stream and return a non-stream value, such as a collection, an optional value, a primitive value, or `void`.
3. Once a terminal operation is called on a stream, the stream is considered "consumed" and can no longer be used for further operations. If you need to perform additional operations on the stream, you must create a new stream from the data source.



21. What are the most commonly used Intermediate operations?

Examples of intermediate operations include `filter()`, `map()`, `flatMap()`, `distinct()`, `limit()`, `sorted()`, `distinct()` and `skip()`.



22. What is the difference between findFirst() and findAny()?

`findFirst()`: This operation returns the first element encountered in the stream that satisfies the conditions specified in the pipeline (if any). In a sequential stream, the first element is deterministic and is based on the stream's encounter order. 

`findAny()`: This operation returns any element from the stream that satisfies the conditions specified in the pipeline (if any). The returned element is not necessarily the first one. In a sequential stream, `findAny()` often returns the first element, but it's not guaranteed.



23. How are Collections different from Stream?

Data Storage:

Collections are primarily used for storing and managing data in memory. They are data structures, such as lists, sets, and maps, which allow you to add, remove, update, and retrieve elements.

Streams are not data structures. They are a functional programming concept for processing sequences of data in a declarative manner. Streams don't store elements but provide a pipeline for processing data on-the-fly.

Mutability:

Collections are often mutable, streams are immutable.

Reusability:

Collections can be used multiple times and iterated over as needed.

Streams can be consumed only once. Once a terminal operation is called on a stream, the stream is considered "consumed" and cannot be reused for further operations. To perform additional operations, you must create a new stream from the data source.

Parallelism:

Collections do not provide built-in support for parallel processing.

Streams have built-in support for parallel processing through the `parallelStream()` method or by converting a sequential stream to a parallel one using the `parallel()` method.