# 6.
A runtime exception is an exception that occurs during the execution of a program due to various reasons like invalid user input, logical errors, or incorrect configurations. Runtime exceptions are a subclass of Exception and are usually not caught by the code, leading to the termination of the program. In Java, some common runtime exceptions are NullPointerException, ArithmeticException, and ArrayIndexOutOfBoundsException.

```java
public class NullPointerExceptionExample {
    public static void main(String[] args) {
        String str = null;
        System.out.println(str.length());
    }
}
```
```java
public class ArithmeticExceptionExample {
    public static void main(String[] args) {
        int a = 10;
        int b = 0;
        System.out.println(a / b);
    }
}
```
```java
public class ArrayIndexOutOfBoundsExceptionExample {
    public static void main(String[] args) {
        int[] arr = new int[3];
        arr[0] = 1;
        arr[1] = 2;
        arr[2] = 3;
        System.out.println(arr[3]);
    }
}
```

# 7.
```java
public class NullPointerExceptionExample {
    public static void main(String[] args) {
        String str = null;
        System.out.println(str.length());
    }
}
```

# 8.
`Optional` is a wrapper class that can contain either a value of a certain type or no value at all. It provides methods to safely access the contained value or specify a default value when the value is not present. The main methods provided by the `Optional` class are:

- `of(T value)`: Creates an `Optional` containing the given non-null value.
- `ofNullable(T value)`: Creates an `Optional` containing the given value if it is not null, or an empty `Optional` if the value is null.
- `empty()`: Creates an empty `Optional`.
- `isPresent()`: Returns `true` if the `Optional` contains a value, `false` otherwise.
- `ifPresent(Consumer<? super T> action)`: Executes the given action if a value is present.
- `orElse(T other)`: Returns the contained value if present, or the specified default value otherwise.
- `orElseGet(Supplier<? extends T> supplier)`: Returns the contained value if present, or the value supplied by the given supplier otherwise.
- `orElseThrow(Supplier<? extends X> exceptionSupplier)`: Returns the contained value if present, or throws the exception supplied by the given supplier otherwise.

Here is a simple example using `Optional`:

```java
import java.util.Optional;

public class OptionalExample {
    public static void main(String[] args) {
        String value = "Hello, World!";
        Optional<String> optionalValue = Optional.ofNullable(value);
        
        optionalValue.ifPresent(System.out::println);
        
        String defaultValue = "Default value";
        String result = optionalValue.orElse(defaultValue);
        System.out.println(result);
    }
}
```

# 9.
1. Avoids NullPointerException: Since Optional can contain either a value or null, it can help to prevent NullPointerExceptions in the code.

2. Encourages better programming practices: By using Optional, developers are forced to handle the case where a value may be absent, leading to more robust and error-free code.

3. Simplifies code: Optional provides a simple and concise way of handling null values without the need for verbose if-else statements.

4. Enhances code readability: Code that uses Optional is easier to read and understand, as it makes it clear when a value may or may not be present.

5. Facilitates testing: Using Optional makes it easier to write unit tests, as it allows developers to test code paths where a value may or may not be present.

# 10.
@FunctionalInterface is an annotation in Java that is used to indicate that an interface is a functional interface. A functional interface is an interface that contains only one abstract method, but it can also contain any number of default methods, static methods, and inherited methods.

The @FunctionalInterface annotation is not required for an interface to be functional, but it is a good practice to use it. This is because the compiler can provide an error message if the interface is not a functional interface and someone tries to use it as one.

Functional interfaces are important in Java because they are used extensively in lambda expressions, method references, and the Stream API. By using functional interfaces, developers can write more concise and readable code that is easier to maintain and understand.

# 11.

Lambda expressions, introduced in Java 8, are a shorthand way of writing anonymous functions. They allow developers to write more concise and expressive code that is easier to read and understand.

A lambda expression consists of three parts: the parameter list, the arrow token ->, and the body. The parameter list specifies the parameters that the lambda takes, the arrow token separates the parameter list from the body, and the body contains the code that is executed when the lambda is called.

Lambda expressions can be used wherever an object of a functional interface is expected. A functional interface is an interface that contains only one abstract method, and it is used as the type for the lambda expression.

Lambda expressions are commonly used in conjunction with the Stream API, which provides a way of processing collections of data in a declarative way. By using lambda expressions, developers can write code that is more concise and easier to read than traditional for loops.

# 12.

1. Reference to a static method: This type of method reference is used to refer to a static method of a class.

2. Reference to an instance method of a particular object: This type of method reference is used to refer to an instance method of a particular object.

3. Reference to an instance method of an arbitrary object of a particular type: This type of method reference is used to refer to an instance method of an arbitrary object of a particular type.

4. Reference to a constructor: This type of method reference is used to refer to a constructor of a class.

Method references can be used wherever a lambda expression is expected, and they provide a more concise and readable alternative to lambda expressions. By using method references, developers can write code that is easier to read and understand, and that is more maintainable and reusable.


# 13.

1. Lambda expressions: A shorthand way of writing anonymous functions that make it easier to write code that is more concise and expressive.

2. Method references: A shorthand way of writing lambda expressions that invoke an existing method.

3. Default methods: Methods that can be defined within an interface, allowing interfaces to evolve without breaking existing code.

4. Stream API: A way of processing collections of data in a declarative way that makes it easier to write code that is more concise and readable.

5. Date and Time API: A new API for handling date and time values that provides a more intuitive and flexible way of working with dates and times.

6. Optional class: A class that can contain either a value or null, which helps to prevent NullPointerExceptions in the code.

7. Nashorn JavaScript engine: A new lightweight, high-performance JavaScript engine that is integrated into the Java runtime.


# 14.

"Lambda expressions can use effectively final variables from the enclosing scope. An effectively final variable is a variable that is not declared final, but whose value is not changed after it is initialized. The variable can be initialized outside the lambda expression, or inside the lambda expression, but once it is initialized, its value cannot be changed.

Lambda expressions can also use static and instance variables from the enclosing class, but the variable must be either final or effectively final.

It's worth noting that if a variable used in a lambda expression is not effectively final (i.e., its value is changed after it is initialized), the code will not compile."

# 15.


1. Lambda expressions: A shorthand way of writing anonymous functions that make it easier to write code that is more concise and expressive.

2. Method references: A shorthand way of writing lambda expressions that invoke an existing method.

3. Default methods: Methods that can be defined within an interface, allowing interfaces to evolve without breaking existing code.

4. Stream API: A way of processing collections of data in a declarative way that makes it easier to write code that is more concise and readable.

5. Date and Time API: A new API for handling date and time values that provides a more intuitive and flexible way of working with dates and times.

6. Optional class: A class that can contain either a value or null, which helps to prevent NullPointerExceptions in the code.

7. Nashorn JavaScript engine: A new lightweight, high-performance JavaScript engine that is integrated into the Java runtime.


# 16.

Yes

# 17.

Lambda expressions are a new feature introduced in Java 8 that allow you to write anonymous functions in a more concise and expressive way. A lambda expression consists of a list of parameters, an arrow token "->", and a body that can be either an expression or a block of code.

Lambda expressions are closely related to functional interfaces. A functional interface is an interface that has only one abstract method, and it is used as the type of a lambda expression. When you write a lambda expression, you are essentially creating an instance of a functional interface that implements the abstract method with the code in the lambda expression.

For example, suppose you have a functional interface called MyInterface that has a single abstract method called doSomething. You can create an instance of this interface using a lambda expression like this:

MyInterface myInterface = () -> System.out.println("Hello, world!");

In this example, the lambda expression "() -> System.out.println("Hello, world!")" implements the "doSomething" method of the MyInterface interface. When you call the "doSomething" method on the "myInterface" object, it will execute the code in the lambda expression.

Overall, lambda expressions and functional interfaces are closely related in Java 8. Lambda expressions provide a shorthand way of creating instances of functional interfaces, which makes it easier to write code that is more concise, expressive, and modular.```


# 18.
1. Reference to a static method: This type of method reference is used to refer to a static method of a class.

2. Reference to an instance method of a particular object: This type of method reference is used to refer to an instance method of a particular object.

3. Reference to an instance method of an arbitrary object of a particular type: This type of method reference is used to refer to an instance method of an arbitrary object of a particular type.

4. Reference to a constructor: This type of method reference is used to refer to a constructor of a class.

Method references can be used wherever a lambda expression is expected, and they provide a more concise and readable alternative to lambda expressions. By using method references, developers can write code that is easier to read and understand, and that is more maintainable and reusable.

# 19.

The expression "String::valueOf" is a method reference to the static method "valueOf" of the "String" class. It provides a shorthand syntax for writing lambda expressions that invoke existing methods. In this case, the method reference is equivalent to the lambda expression "x -> String.valueOf(x)". Method references make it easier to write more concise and readable code that reuses existing methods.```

# 20.

In Java 8's Stream API, there are two types of operations that can be performed on a stream: intermediate operations and terminal operations.

Intermediate operations are operations that are applied to a stream and return a new stream, which allows for chaining multiple operations together. Some examples of intermediate operations include filter(), map(), and sorted().

Terminal operations are operations that are applied to a stream and produce a result or side effect. Terminal operations consume the stream, so a stream can only have one terminal operation. Some examples of terminal operations include forEach(), count(), and reduce().

Intermediate operations are evaluated lazily, which means they are not executed until a terminal operation is called. This allows for more efficient processing of large amounts of data, as only the necessary data is processed.

Overall, the use of intermediate and terminal operations in Java 8's Stream API allows for more concise and expressive code that is easier to read and maintain. It also provides a more efficient way of processing collections of data.```

# 21.

1. filter(): This operation takes a Predicate as a parameter and returns a new stream that contains only the elements that satisfy the Predicate.

2. map(): This operation takes a Function as a parameter and returns a new stream that contains the results of applying the Function to each element in the original stream.

3. flatMap(): This operation is similar to map(), but it takes a Function that returns a stream as a parameter, and then flattens the resulting streams into a single stream.

4. distinct(): This operation returns a new stream that contains only the distinct elements of the original stream, according to their natural ordering or the order imposed by a Comparator.

5. sorted(): This operation returns a new stream that is sorted according to the natural ordering of the elements or a specified Comparator.

# 22.

The main difference between findFirst() and findAny() is in the way they handle parallel streams. The findFirst() method returns the first element of the stream, which is the same in both sequential and parallel streams. However, the findAny() method returns any element of the stream, which may be different in sequential and parallel streams.

In sequential streams, the behavior of findAny() is the same as findFirst(). However, in parallel streams, findAny() can return any element of the stream, which may be different each time the stream is processed.

Because of this difference, findAny() is often used in parallel processing, where it is more important to get any result quickly rather than a specific result.

# 23.
Collections and Streams are both used in Java to work with collections of data, but they have some key differences.

Collections are data structures that hold a collection of elements in memory. Once a collection is created, the elements can be added, removed, or accessed in any order. Collections provide methods to perform operations on the elements of the collection, such as sorting or searching.

Streams, on the other hand, are a sequence of elements that can be processed in a declarative way. Streams do not store elements, but rather generate them on demand. They can be created from a collection, an array, or generated using a stream builder. Once created, streams can be processed using a chain of intermediate and terminal operations, such as filter(), map(), and forEach().

One of the key benefits of using streams is that they can be processed in a lazy manner, which means that only the necessary elements are generated and processed. This can make streams more efficient than collections for certain operations.





