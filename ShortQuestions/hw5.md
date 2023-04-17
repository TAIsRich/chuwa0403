# HW5
## 1. What is generic in Java? and type the generic code by yourself.
Generics in Java is a feature that allows types to be passed as parameters to classes, interfaces, and methods. This feature helps in writing type-safe code and eliminates the need for explicit casting. Generics can be used to create classes, interfaces, and methods that work with different types of objects, allowing developers to write reusable code. The use of generics can help prevent runtime errors and improve code maintainability. Examples of generic classes in Java include List, Set, and Map.

Please check Coding/hw5/generic.

## 2. Read those codes and type it one by one by yourself. the push the code to your branch.
https://github.com/TAIsRich/chuwa-eij-tutorial/tree/main/02-java-core/src/main/java/com/chuwa/tutorial/t06_java8

Please check Coding/hw5/features.

## 3. practice stream API at least 3 times
https://blog.devgenius.io/15-practical-exercises-help-you-master-javastream-api-3f9c86b1cf82

Please check Coding/hw5/stream-api-exercises-main.

## 4. Practice Optional methods at least 2 times
https://github.com/TAIsRich/chuwa-eij-tutorial/blob/main/02-java-core/src/main/java/com/chuwa/tutorial/t06_java8/exercise/ShoppingCartUtil.java

Please check Coding/hw5/optional_exercise.

## 5. Write the Singleton design pattern include eager load and lazy load.
Steps:
1. static volatile variable (optional)
2. make constructor be private
3. static synchronized getInstance method
4. make sure thread safe
- Eager Load
```java
public class Singleton {
    private static Singleton instance = new Singleton();
    
    private Singleton() {}
    
    public static Singleton getInstance() {
        return instance;
    }
}
```
- Lazy Load
```java
public class Singleton {
    private static Singleton instance = new Singleton();
    
    private Singleton() {}
    
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

## 6. What is Runtime Exception? Could you give me some examples?
A `RuntimeException` is a type of exception in Java that is not checked by the compiler, meaning that you are not required to declare or handle it explicitly in your code. Runtime exceptions are typically caused by programming errors such as invalid input or division by zero, and can be thrown at any point during program execution.

1. `NullPointerException` - thrown when you try to access an object or invoke a method on a null reference.
```java
String str = null;
int length = str.length(); // throws NullPointerException
```
2. `ArrayIndexOutOfBoundsException` - thrown when you try to access an array index that is out of bounds.
```java
int[] numbers = {1, 2, 3};
int value = numbers[3]; // throws ArrayIndexOutOfBoundsException
```
3. `ArithmeticException` - thrown when an arithmetic operation (such as division) is performed with invalid arguments.
```java
int result = 5 / 0; // throws ArithmeticException
```
4. 1ClassCastException1 - thrown when you try to cast an object to a type that it is not compatible with.
```java
Object obj = new Integer(10);
String str = (String) obj; // throws ClassCastException
```

## 7. Could you give me one example of NullPointerException?
```java
String str = null;
int length = str.length(); // throws NullPointerException
```

## 8. What is the Optional class?
The Optional class is a class introduced in Java 8 that provides A container object which may or may not contain a non-null value. It is often used as a replacement for returning null values from methods and functions, as it forces the caller to explicitly handle the case where the value is not present.

## 9. What are the advantages of using the Optional class?
1. Avoiding NullPointerExceptions: One of the main advantages of using Optional is that it can help to avoid NullPointerExceptions, which are a common source of bugs in Java code. By forcing the caller to explicitly handle the case where a value may not be present, Optional can help to make your code more robust and less error-prone.

2. Encouraging better design: By using Optional, you are forced to think more carefully about the design of your code, and to explicitly consider whether a value may or may not be present. This can help to encourage better design practices and make your code more modular and maintainable.

3. Improved readability: By using Optional, you can make your code more readable and expressive, as the use of 
Optional signals to the reader that a value may or may not be present. This can help to make your code more self-documenting and easier to understand.

4. More concise code: By using the methods provided by Optional, you can often write more concise code that is easier to read and understand. For example, instead of writing complex null-checking code, you can use methods like orElse() to provide a default value if a value is not present.

5. Better API design: By using Optional in your API design, you can make it clearer to callers which values may or may not be present, and provide a more consistent and predictable interface. This can help to make your API more user-friendly and reduce the likelihood of errors and bugs.

## 10. What is the @FunctionalInterface?
The @FunctionalInterface annotation is used to mark interfaces as functional interfaces. A functional interface is an interface that contains only one abstract method, and is therefore suitable for use as a lambda expression or method reference.

By marking an interface with the @FunctionalInterface annotation, you are explicitly declaring that the interface is intended to be used as a functional interface, and that it should contain **only one abstract method**. If the interface contains more than one abstract method, the compiler will generate an error.

## 11. What is lambda?
Lambda is the implementation of the abstract method. Lambda can replace anonymous inner class and work with 
functional interface.

A lambda expression is a short block of code which takes in parameters and returns a value. Lambda expressions are similar to methods, but they do not need a name, and they can be implemented right in the body of a method.
```
(parameter1, parameter2) -> { code block }
```

## 12. What is Method Reference?
Method reference allows you to refer to a method by its name instead of writing a lambda expression to call that method. It is essentially a shorthand syntax for creating lambda expressions that call a specific method.

There are four types of method references in Java:

1. Reference to a static method: This type of method reference refers to a static method of a class. It can be 
written as `ClassName::methodName`.

2. Reference to an instance method of an object: This type of method reference refers to an instance method of an object. It can be written as `object::methodName`.

3. Reference to an instance method of a class: This type of method reference refers to an instance method of a class, where the instance is passed as the first argument to the method. It can be written as `ClassName::methodName`.

4. Reference to a constructor: This type of method reference refers to a constructor of a class. It can be written as `ClassName::new`.

## 13. What is Java 8 new features?
1. Lambda expressions: A new syntax for defining and passing around blocks of code that can be executed later.
2. Method references: A shorthand syntax for creating lambda expressions that call a specific method.
3. Default methods: A new feature that allows interfaces to define methods with default implementations.
4. Static method: A static method in an interface is a method that is declared with the `static` keyword, and can be called directly on the interface itself, rather than on an instance of the interface.
5. Streams API: A new API for working with collections that allows you to easily perform bulk operations on data.
6. Optional class: A new class that provides a way to express the absence of a value in a type-safe manner.

## 14. Lambda can use unchanged variable outside of lambda? What are the details?
Yes, lambdas can capture and use variables from their enclosing scope, provided that the variables are effectively final or final.
1. Final variable
2. Non-final variable however never changed
3. Object variable (if we use new to reassign a new memory, then this variable is changed, can not be used in lambda)

## 15. Describe the newly added features in Java 8?
1. Lambda expressions: A new syntax for defining and passing around blocks of code that can be executed later.
2. Method references: A shorthand syntax for creating lambda expressions that call a specific method.
3. Default methods: A new feature that allows interfaces to define methods with default implementations.
4. Static method: A static method in an interface is a method that is declared with the `static` keyword, and can be called directly on the interface itself, rather than on an instance of the interface.
5. Streams API: A new API for working with collections that allows you to easily perform bulk operations on data.
6. Optional class: A new class that provides a way to express the absence of a value in a type-safe manner.
## 16. Can a functional interface extend/inherit another interface?
A functional interface can extend another interface only when it does not have any abstract method.

## 17. What is the lambda expression in Java and How does a lambda expression relate to a functional interface?
A lambda expression in Java is a shorthand syntax for defining and passing around a block of code that can be executed later. It allows you to write concise and expressive code that can be easily used in functional programming constructs.

Lambda expressions are related to functional interfaces in Java because they are used to implement the abstract method of a functional interface. A functional interface is an interface that contains exactly one abstract method and is used to represent a single behavior or action.

Lambda expressions provide a way to implement the abstract method of a functional interface without having to define a separate class or method. They allow you to create a block of code that can be passed as an argument to a method or stored in a variable, and which can be executed later when needed.
```java
// Define a functional interface with one abstract method
interface MyFunctionalInterface {
    void myMethod();
}

// Use a lambda expression to implement the abstract method of the interface
MyFunctionalInterface obj = () -> System.out.println("Hello, World!");

// Call the method using the functional interface object
obj.myMethod();
```
## 18. In Java 8, what is Method Reference?
Method reference allows you to refer to a method by its name instead of writing a lambda expression to call that method. It is essentially a shorthand syntax for creating lambda expressions that call a specific method.

There are four types of method references in Java:

1. Reference to a static method: This type of method reference refers to a static method of a class. It can be
   written as `ClassName::methodName`.

2. Reference to an instance method of an object: This type of method reference refers to an instance method of an object. It can be written as `object::methodName`.

3. Reference to an instance method of a class: This type of method reference refers to an instance method of a class, where the instance is passed as the first argument to the method. It can be written as `ClassName::methodName`.

4. Reference to a constructor: This type of method reference refers to a constructor of a class. It can be written as `ClassName::new`.
5. 
## 19. What does the String::ValueOf expression mean?
`String::valueOf` is a method reference that refers to the `valueOf()` method in the `String` class. This method converts different types of values (int, float, double, etc.) to their string representation.

The syntax `String::valueOf` can be used in situations where a functional interface with a single argument of type `T` is expected, and `T` is expected to be a `String`. In this case, the method reference `String::valueOf` can be used to provide the implementation for the functional interface.

```java
List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
List<String> strings = numbers.stream()
                               .map(String::valueOf)
                               .collect(Collectors.toList());
```

## 20. What are Intermediate and Terminal operations?
Intermediate operations are operations that are applied to a stream and create a new stream as output. These operations do not modify the original stream but return a new stream with the desired modification. Some examples of intermediate operations are `filter()`, `map()`, `flatMap()`, `distinct()`, `sorted()`, `limit()`, and `skip()`.

Terminal operations are operations that produce a non-stream result, which means that they consume the stream and return a result that is not a stream. Once a terminal operation is applied to a stream, it triggers the processing of the entire stream. Some examples of terminal operations are `collect()`, `count()`, `forEach()`, `reduce()`, `anyMatch()`, `allMatch()`, and `noneMatch()`.

## 21. What are the most commonly used Intermediate operations?
1. `filter(Predicate<T> predicate)` - returns a new stream that contains only the elements that match the given predicate.
2. `map(Function<T, R> mapper)` - returns a new stream that contains the result of applying the given function to each element in the original stream.
3. `flatMap(Function<T, Stream<R>> mapper)` - returns a new stream that contains the result of applying the given function to each element in the original stream, and then flattening the results into a single stream.
4. `distinct()` - returns a new stream that contains only the distinct elements of the original stream.
5. `sorted()` - returns a new stream that contains the elements of the original stream, sorted according to their natural ordering.
6. `peek(Consumer<T> action)` - returns a new stream that applies the given action to each element of the original stream, and then passes the elements on unchanged.
7. `limit(long maxSize)` - returns a new stream that contains at most maxSize elements of the original stream.
8. `skip(long n)` - returns a new stream that skips the first n elements of the original stream.

## 22. What is the difference between findFirst() and findAny()?
`findFirst()` returns the **first element** of the stream, which is the first element in the encounter order. The encounter order is the order in which the elements are produced by the stream source (e.g., the order in which they appear in a list). If the stream has no encounter order (e.g., a parallel stream), `findFirst()` will return the first element in the stream's internal order.

`findAny()` returns an **arbitrary element** of the stream. It is useful when we don't care about the order of elements in the stream, or when we want to take advantage of parallel processing. In a parallel stream, findAny() may return a different result each time it is called.

It is important to note that for **sequential streams**, `findFirst()` and `findAny()` will **return the same result**. In parallel streams, `findFirst()` may be slower than `findAny()` because it has to wait for all the elements to be processed before it can return a result.

## 23. How are Collections different from Stream?

A collection is an in-memory data structure that holds a group of elements of the same type. It provides a set of operations such as adding, removing, and retrieving elements.

On the other hand, a stream is a sequence of elements that can be processed in a declarative way. It does not store elements, but it generates them on the fly from a data source (such as a collection or an I/O channel) and processes them in a functional manner. Streams can be used to filter, map, sort, and aggregate data.

The main difference between collections and streams is that collections are designed for in-memory data storage and direct access to elements, whereas streams are designed for processing large or infinite data sets in a declarative way. Collections can be modified, while streams are immutable and cannot be modified.

In summary, Collections are used to **store and manage data**, while Streams are used to **process data** in a functional manner.