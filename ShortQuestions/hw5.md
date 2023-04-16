# HW 5

## 1. What is generic in Java? 

In Java, "generic" refers to a feature that allows you to **write reusable code that can work with different types of data**. Specifically, Java generics provide a way to create classes, interfaces, and methods that can take in or return values of a parameterized type.

By using generics, you can write more flexible and type-safe code, which can help you catch errors at compile time instead of runtime. For example, instead of writing a separate class or method for every data type, you can write a single generic class or method that can work with any data type.

The code is at `Coding/hw5/genericPractice`

## 2. Java8 Practice

The code is at `Coding/hw5/Java8Practice`

## 3. Stream API Practice

The code is at `Coding/hw5/StreamApiPractice`

## 4. Optional Practice

The code is at `Coding/hw5/OptionalPractice`

## 5.  Write the Singleton design pattern include eager load and lazy load.

The code is at `Coding/hw5/Singleton`

## 6. What is Runtime Exception? could you give me some examples?

In Java, a `RuntimeException` is a type of exception that **is not checked by the compiler at compile time**. Unlike checked exceptions, which must be declared or handled by the calling method, runtime exceptions can be thrown by a method without being declared or caught, and will propagate up the call stack until they are caught by a catch block or cause the program to terminate.

1. `NullPointerException`
2. `ArrayIndexOutOfBoundsException`
3. `ArithmeticException`
4. `ClassCastException`
5. `IllegalArgumentException`
6. `IllegalStateException`
7. `UnsupportedOperationException`

## 7. Could you give me one example of NullPointerException?

```java
String s = null;
System.out.println(s.length());
```

## 8. What is the Optional class?

The `Optional` class is a container object that may or may not contain a non-null value. It is a part of the Java 8 API and is used to help avoid null pointer exceptions by providing a way to express the absence of a value.

An `Optional` object can either contain a non-null value, or it can be empty. If an `Optional` object contains a value, we can retrieve the value using the `get()` method. If the `Optional` object is empty, calling the `get()` method will throw a `NoSuchElementException`.

## 9. What are the advantages of using the Optional class?

1. **Avoiding null pointer exceptions**: The `Optional` class provides a way to avoid null pointer exceptions, which can be a common source of bugs and runtime errors in Java code. By using `Optional` instead of allowing null values, you can make your code more robust and reliable.
2. **Encouraging explicit handling of absent values**: Using `Optional` makes it explicit that a value may be absent and requires special handling. This can help prevent bugs that arise from assuming a value is present when it is actually null.
3. **Improving code readability**: By using `Optional`, you can make your code more readable and expressive. Instead of checking for null values and handling them explicitly, you can use `Optional` methods to express the intent of your code more clearly.
4. **Supporting method chaining**: The `Optional` class supports method chaining, which can make your code more concise and readable. For example, you can chain together `map()` and `filter()` methods to perform transformations and filtering on `Optional` values.
5. **Reducing the need for null checks**: Using `Optional` can help reduce the amount of null checks in your code, which can make your code easier to read and maintain. Instead of checking for null values at every step, you can use `Optional` methods to handle the absence of a value more gracefully.

## 10. What is the @FunctionalInterface?

`@FunctionalInterface` is a **marker annotation in Java that is used to indicate that an interface is a functional interface**. A functional interface is **an interface that has exactly one abstract method**, and is used to represent a single unit of behavior.

The `@FunctionalInterface` annotation is not required for an interface to be a functional interface, but it is good practice to include it to make it clear to other developers that the interface is intended to be used as a functional interface. If an interface marked with the `@FunctionalInterface` annotation has more than one abstract method, the compiler will generate an error.

## 11. what is lamda?

Lambda is a feature introduced in Java 8 that allows you to **define and use a small, anonymous code block as if it were a value.** A lambda expression is a concise way to express a single unit of behavior, such as a method or function, without having to define a whole class or interface.

## 12. What is Method Reference?

Method reference is a shorthand notation introduced in Java 8 that **allows you to refer to a method or constructor without actually invoking it**. Method reference is similar to lambda expressions in that it allows you to define and use a block of code as a value, but it is more concise and easier to read in some cases.

## 13. What is Java 8 new features?

**Important**:

1. Lambda expressions: A shorthand notation for defining and using a block of code as a value.
2. Stream API: A new set of API classes and interfaces for working with streams of data in a functional programming style.
3. Method reference: A shorthand notation for referring to a method or constructor without actually invoking it.
4. Default methods: A new feature that allows interfaces to have non-abstract methods, providing a way to extend existing interfaces without breaking existing code.
5. Optional class: A container object that may or may not contain a non-null value, providing a way to avoid null pointer exceptions.

Not Important:

1. Date and time API: A new set of classes and interfaces for working with dates and times in a more flexible and intuitive way.
2. Nashorn JavaScript engine: A lightweight JavaScript engine that allows Java applications to interoperate with JavaScript code.
3. PermGen space removed: The PermGen space was removed and replaced with the Metaspace, which allows for more flexible memory allocation.

## 14. Lambda can use unchanged variable outside of lambda? what is the details?

Yes, lambda expressions can use variables that are defined outside of the lambda expression, **as long as those variables are effectively final**. An effectively final variable is a variable that is not declared final, but whose value is never changed after initialization.

**Lambda expressions capture the value of effectively final variables at the time the lambda is created**, and can use those values within the body of the lambda expression. This allows lambda expressions to access variables in the enclosing scope without requiring the variables to be explicitly passed as arguments.

## 15. Describe the newly added features in Java 8?

The same as question 13.

## 16. Can a functional interface extend/inherit another interface?

Yes, **a functional interface can extend or inherit from another interface, as long as the extended interface has only one abstract method.** When a functional interface extends another interface, it inherits all of the methods of the parent interface, **but still has only one abstract method.**

## 17. What is the lambda expression in Java and How does a lambda expression relate to a functional interface?
What: the same as question 11.

How:

A lambda expression relates to a functional interface in that it provides an implementation of the single abstract method defined by the functional interface.

A functional interface is an interface that has exactly one abstract method, and is used to represent a single unit of behavior. When you define a lambda expression that implements a functional interface, you provide a concise and readable way of defining that behavior. The syntax for a lambda expression is similar to that of a method or function, and allows you to express the behavior of the functional interface in a natural and intuitive way.

## 18. In Java 8, what is Method Reference?

The same as question 12.

## 19. What does the `String::ValueOf` expression mean?

The `String::valueOf` expression is a method reference that refers to the `valueOf()` method of the `String` class. The `valueOf()` method is a static method that converts a value of a primitive type or another object type to its string representation.

Using the `String::valueOf` method reference, you can create a reference to the `valueOf()` method of the `String` class without actually invoking it. This can be useful in situations where you want to pass a method reference as an argument to a method or assign it to a functional interface variable.

```java
int number = 42;

// Using String::valueOf
Function<Integer, String> func1 = String::valueOf;
String str1 = func1.apply(number);

// Using String.valueOf()
String str2 = String.valueOf(number);

System.out.println(str1); // Output: 42
System.out.println(str2); // Output: 42

```

## 20. What are Intermediate and Terminal operations?

Intermediate operations are operations that **transform the data in the stream,** **but do not produce a final result.** Intermediate operations are typically chained together to form a pipeline of operations that are applied to the stream in a sequence. Examples of intermediate operations include `map()`, `filter()`, `sorted()`, `distinct()`, and `flatMap()`. Intermediate operations are lazy, which means that they do not actually process the stream data until a terminal operation is invoked.

Terminal operations are operations that **produce a final result from the stream, and typically mark the end of the stream processing pipeline.** Examples of terminal operations include `forEach()`, `reduce()`, `collect()`, and `count()`. Terminal operations trigger the evaluation of the intermediate operations and produce a final result, which may be a single value, a collection, or a side effect.

## 21. What are the most commonly used Intermediate operations?

1. `map()`: Transforms the elements of a stream by applying a function to each element.
2. `filter()`: Selects only the elements of a stream that match a given predicate.
3. `sorted()`: Sorts the elements of a stream according to a given comparator.
4. `distinct()`: Removes duplicates from a stream based on the elements' natural order or a provided comparator.
5. `flatMap()`: Flattens a stream of streams into a single stream.
6. `peek()`: Performs an action on each element of a stream without modifying the stream.
7. `limit()`: Limits the size of a stream to a given number of elements.
8. `skip()`: Skips a given number of elements in a stream.

## 22. What is the difference between findFirst() and findAny()?

The `findFirst()` method returns the first element of the stream, if any, while `findAny()` returns any element of the stream, if any.

## 23. How are Collections different from Stream?

1. **Data source**: Collections are **in-memory data structures** that store a fixed set of elements, while Streams are not data structures themselves, but represent a sequence of elements that can be processed on-the-fly.
2. **Mutability**: **Collections are typically mutable**, meaning that elements can be added, removed, or modified after the collection is created, while **Streams are typically immutable**, meaning that the sequence of elements cannot be modified once the Stream is created.
3. **Eager vs Lazy**: **Collections are typically eager**, meaning that they immediately create and store all elements in memory when the collection is created, while **Streams are typically lazy**, meaning that elements are only processed on-the-fly when needed by intermediate and terminal operations.
4. **Size**: **Collections have a fixed size** that is determined when the collection is created, while **Streams can be infinite or dynamically generated**, allowing for more flexibility in data processing.
5. **Parallel processing**: **Streams can be processed in paralle**l, allowing for more efficient processing of large data sets, while **Collections typically do not support parallel processing directly.**

