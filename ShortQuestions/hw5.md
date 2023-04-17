#  Q5
### EagerSingleton
```java
public class EagerSingleton {
    private static EagerSingleton instance = new EagerSingleton();

    private EagerSingleton() {
    }

    public static EagerSingleton getInstance() {
        return instance;
    }
}
```
### LazySingleton

```java
public class LazySingleton {
    private static LazySingleton instance;

    private LazySingleton() {
        // private constructor to prevent instantiation outside the class
    }

    public static synchronized LazySingleton getInstance() {
        if (instance == null) {
            instance = new LazySingleton();
        }
        return instance;
    }
}
```
#  Q6
A RuntimeException is a type of exception in Java that is not checked at compile-time, but rather at runtime. 

ArrayIndexOutOfBoundsException: This occurs when an attempt is made to access an array element with an index that is either negative or greater than or equal to the length of the array.

```java
int[] arr = {1, 2, 3};
int val = arr[3];
```
#  Q7
```java
String str = null;
int length = str.length();
```

#  Q8
The Optional class is a container object introduced in Java 8 that may or may not contain a non-null value. It is intended to help avoid null pointer exceptions in code by providing a way to express "optional" values that may or may not be present.

An Optional instance can be either empty or contain a value. If it contains a value, we can retrieve it using the get() method. If it is empty, calling get() will throw a NoSuchElementException. Therefore, it is recommended to check if an Optional instance is present before calling get() using the isPresent() method.

The Optional class also provides methods such as orElse(), orElseGet(), and orElseThrow() to retrieve a default value if the Optional is empty. It also provides methods such as map(), flatMap(), and filter() to perform transformations and filtering on the contained value.

#  Q9

The Optional class provides several advantages over using null values in Java. Here are some of the main advantages of using the Optional class:

Avoiding null pointer exceptions: One of the main advantages of using Optional is that it helps to avoid null pointer exceptions. With Optional, you can clearly indicate when a value may be absent and handle it accordingly, rather than relying on null checks throughout your code.

Increased code readability: By using Optional, you can make your code more readable and expressive. For example, using Optional to represent an absent value is clearer than using null, which can be ambiguous.

Improved API design: Using Optional can lead to improved API design by making it more clear when a method may return a null value. It also allows developers to provide better error messages and more informative stack traces.

Better compatibility with functional programming: The Optional class is compatible with functional programming concepts, such as map, filter, and reduce. This makes it easier to write functional-style code in Java and can lead to more concise and expressive code.

Easier refactoring: When using Optional, refactoring your code is easier since you can clearly see which values may be absent and handle them accordingly. This can make your code more robust and less error-prone.

# Q10
@FunctionalInterface is an annotation introduced in Java 8 that indicates that an interface is intended to be a functional interface. A functional interface is an interface that has only one abstract method and can be used as the target for a lambda expression or method reference.

# Q11

Lambda expressions can be used to simplify code by allowing us to pass behavior as a method argument, create new functional interfaces on the fly, and reduce boilerplate code.

# Q12

Method references are a shorthand syntax in Java 8 that allow us to pass a method as a parameter to another method or constructor. Method references can be used to simplify code by avoiding the need to write a lambda expression that only calls a single method.

A method reference is denoted by the :: operator, and the syntax depends on the type of method being referenced. There are four types of method references:

Reference to a static method: ClassName::methodName
Reference to an instance method of an object of a particular type: object::methodName
Reference to an instance method of an arbitrary object of a particular type: ClassName::methodName
Reference to a constructor: ClassName::new

# Q13

ava 8 introduced several new features and improvements, including:

Lambda expressions: A concise syntax for implementing functional interfaces.
Streams: A new API for processing collections of data in a functional style.
Default methods: Methods that can be added to interfaces without breaking existing implementations.
Method references: A shorthand syntax for passing a method as a parameter to another method or constructor.
Optional: A container object that may or may not contain a non-null value.
Date and Time API: A new API for working with dates and times, replacing the old java.util.Date and java.util.Calendar classes.
Nashorn JavaScript engine: A lightweight JavaScript engine that allows Java applications to execute JavaScript code.
Type annotations: Annotations that can be applied to types, such as classes, interfaces, and generics.
Functional interfaces: A new category of interfaces that declare a single abstract method, used for lambda expressions and method references.
Parallel arrays: A new set of classes that provide efficient parallel processing of arrays.

# Q14

In Java, lambdas can access final or effectively final variables from their enclosing scope. An effectively final variable is a variable that is not declared final, but its value is never changed after it is initialized.

The lambda can read the value of the final or effectively final variable, but it cannot modify it. If the variable's value is changed after the lambda is created, a compile-time error will occur. This is because the lambda holds a reference to the variable, and the variable needs to remain effectively final to ensure the lambda behaves correctly.

# Q15

Java 8 introduced several new features and improvements to the language, including:

Lambda expressions: A new way of writing anonymous functions in Java, which makes it easier to write functional-style code.

Stream API: A new API for processing collections of data in a functional style. Streams allow you to write concise and expressive code for data manipulation and parallel processing.

Default methods: A new feature that allows you to add methods to interfaces without breaking existing implementations. Default methods provide a way to add new functionality to interfaces without requiring all implementing classes to provide their own implementations.

Method references: A shorthand syntax for passing a method as a parameter to another method or constructor. Method references provide a way to write concise and readable code that is easier to understand than traditional anonymous classes.

Optional: A container object that may or may not contain a non-null value. Optional provides a way to avoid null pointer exceptions and write more robust code.

Date and Time API: A new API for working with dates and times, which is more powerful and flexible than the old java.util.Date and java.util.Calendar classes.

Nashorn JavaScript engine: A lightweight JavaScript engine that allows Java applications to execute JavaScript code. Nashorn provides a way to write more modular and flexible applications that can use both Java and JavaScript code.

Parallel arrays: A new set of classes that provide efficient parallel processing of arrays. Parallel arrays allow you to write high-performance code for processing large amounts of data.

Type annotations: Annotations that can be applied to types, such as classes, interfaces, and generics. Type annotations provide a way to write more expressive and precise code that is easier to understand and maintain.

# Q16

Yes, a functional interface can extend another interface, as long as the other interface doesn't have more than one abstract method.

In other words, if the extended interface has only one abstract method, and the functional interface defines only one abstract method, the resulting interface will still be considered a functional interface.

# Q17

A lambda expression is a concise way to represent an anonymous function in Java. It allows you to define a block of code that can be passed around as a parameter or stored as a variable.

A lambda expression is related to a functional interface in Java because a lambda expression can only be used where a functional interface is expected. A functional interface is an interface that has only one abstract method, called the functional method.

# Q18

In Java 8, method reference is a shorthand syntax for defining lambda expressions that simply call an existing method.

A method reference allows you to use an existing method as the implementation of a functional interface, instead of writing a lambda expression to define the behavior. It's a way to make your code more concise and readable.


# Q19

The String::valueOf expression is a method reference that refers to the static method valueOf() in the String class.


# Q20

In Java 8 Stream API, operations can be divided into two categories: intermediate and terminal operations.

Intermediate operations are operations that are applied on a stream and return a new stream. These operations are used to transform, filter, or manipulate the data in the stream. Intermediate operations do not produce any side effects or modify the original stream.

Terminal operations are operations that are applied on a stream and return a non-stream result, such as a value or a collection. These operations are used to perform a final action on the data in the stream. Terminal operations cause the stream to be consumed and cannot be followed by another operation.

# Q21

There are several commonly used intermediate operations in Java 8 Stream API that are used to transform, filter, or manipulate the data in a stream. Some of the most commonly used intermediate operations are:

map(): This operation is used to transform the elements in a stream by applying a function to each element. The function takes an element as input and returns a transformed element.

filter(): This operation is used to remove elements from a stream that do not satisfy a given predicate. The predicate takes an element as input and returns a boolean value.

sorted(): This operation is used to sort the elements in a stream in natural order or in a specified order.

distinct(): This operation is used to remove duplicate elements from a stream.

limit(): This operation is used to limit the number of elements in a stream.

skip(): This operation is used to skip a specified number of elements in a stream.

flatMap(): This operation is used to transform each element in a stream into a stream of zero or more elements, and then flatten the resulting streams into a single stream.

peek(): This operation is used to perform a specified action on each element in a stream without modifying the elements or the stream itself.

# Q22

The findFirst() method is useful when you want to find a specific element in the stream, while findAny() is useful when you just want to find any element that matches the predicate. The findAny() method can be faster than findFirst() when used in parallel streams, as it does not need to search for the first element in the stream, and can return any matching element that it finds first.

# Q23

Iteration: Collections require you to iterate over all the elements in the collection to perform operations, while Streams use internal iteration and allow you to perform operations on elements without having to write explicit loops.

Intermediate and Terminal Operations: Collections offer methods to perform operations on elements, while Streams offer both intermediate and terminal operations. Intermediate operations return a new Stream that can be used to chain additional operations, while terminal operations return a result or a side effect.

Laziness: Collections always store all the elements in memory, while Streams can be lazily evaluated. This means that operations are only performed on elements when they are needed, potentially saving memory and improving performance.



















