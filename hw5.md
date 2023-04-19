### Q1

In Java, "Generic" refers to a feature that allows the creation of classes, interfaces, and methods that can work with different types of objects. It enables type safety and reusability by providing a way to parameterize types.

````
public class Box<T> {
   private T t;

   public void set(T t) {
      this.t = t;
   }

   public T get() {
      return t;
   }

   public static void main(String[] args) {
      Box<Integer> integerBox = new Box<Integer>();
      integerBox.set(10);
      System.out.println(integerBox.get());

      Box<String> stringBox = new Box<String>();
      stringBox.set("Hello World");
      System.out.println(stringBox.get());
   }
}


````

### Q2&3&4:

see `chuwa-eji-tutorial`

### Q5:
Eager
````
public class EagerSingleton {
    private static final EagerSingleton instance = new EagerSingleton();

    private EagerSingleton() {
        // Private constructor to prevent instantiation from outside the class
    }

    public static EagerSingleton getInstance() {
        return instance;
    }
}

````
Lazy
````
public class LazySingleton {
    private static LazySingleton instance;

    private LazySingleton() {
        // Private constructor to prevent instantiation from outside the class
    }

    public static synchronized LazySingleton getInstance() {
        if (instance == null) {
            instance = new LazySingleton();
        }
        return instance;
    }
}

````
### Q6: What is Runtime Exception? could you give me some examples?


In Java, `RuntimeException` is a type of exception that occurs at runtime, as opposed to being a checked exception that must be handled or declared in a method's throws clause. `RuntimeException` is a subclass of `Exception` class, but it is not checked at compile time. Instead, it occurs during the execution of the program, usually due to unexpected or unpredictable conditions.

Here are some examples of `RuntimeExceptions`:

1.  `NullPointerException`: This exception is thrown when an application attempts to use a null reference, for example, calling a method or accessing a field of a null object.

2.  `ArrayIndexOutOfBoundsException`: This exception is thrown when an application attempts to access an array index that is outside the bounds of the array.

3.  `ArithmeticException`: This exception is thrown when an arithmetic operation, such as division by zero, results in an undefined or infinite value.

4.  `IllegalArgumentException`: This exception is thrown when an argument passed to a method is illegal or inappropriate.

5.  `IllegalStateException`: This exception is thrown when a method is called in an inappropriate state, for example, calling a method on a closed object.

6.  `ClassCastException`: This exception is thrown when an attempt is made to cast an object to a subclass of which it is not an instance.


These are just a few examples of `RuntimeExceptions`. They can occur for a variety of reasons and can be caused by both coding errors and unexpected input or environmental conditions. It is important to handle or prevent `RuntimeExceptions` appropriately in Java programs to ensure that they do not result in unexpected or incorrect behavior.


### Q7: Could you give me one example of NullPointerException?

````
public class Example {
    public static void main(String[] args) {
        String str = null;
        int length = str.length();
        System.out.println("Length of the string: " + length);
    }
}

````
In this example, a `NullPointerException` will occur because the variable `str` is assigned a `null` value, and the `length()` method is invoked on it. Since `str` is `null`, there is no object on which to call the `length()` method, resulting in a `NullPointerException` at runtime.
### Q8: What is the Optional class?

In Java, the `Optional` class is a container object that may or may not contain a non-null value. It is used to represent a value that may be absent, instead of using null references.

Using the `Optional` class can make code more readable and less prone to null pointer exceptions. It is a good practice to use `Optional` instead of null references whenever possible, especially when returning values from methods or when accessing values that may be absent.

### Q9: What are the advantages of using the Optional class?
There are several advantages of using the `Optional` class in Java:

1.  Avoiding null pointer exceptions: One of the main advantages of using `Optional` is that it can help avoid null pointer exceptions. Instead of returning a null reference, a method can return an `Optional` object that may or may not contain a non-null value. This can help improve code robustness and reduce the likelihood of unexpected errors.

2.  Improving code readability: Using `Optional` can also make code more readable by making it clear when a value may be absent. When an `Optional` object is used, it is clear that the value may be missing and that special handling may be required.

3.  Encouraging best practices: The use of `Optional` can also encourage developers to follow best practices, such as avoiding null references and using defensive programming techniques.

4.  Providing a standard API: The `Optional` class provides a standard API for working with nullable values, which can help improve consistency and reduce the likelihood of errors.


Overall, the use of `Optional` can help improve code quality and make it more robust and maintainable. It is a good practice to use `Optional` instead of null references whenever possible, especially when returning values from methods or when accessing values that may be absent.

### Q10: What is the @FunctionalInterface?

In Java, the `@FunctionalInterface` annotation is used to indicate that an interface is intended to be a functional interface, which means that it has a single abstract method that is used as the functional signature of the interface. The purpose of the `@FunctionalInterface` annotation is to provide a way to enforce this constraint and make it clear that the interface is intended to be used as a functional interface.

### Q11: what is lamda?
In Java, a lambda expression is a short block of code that represents a function, which can be passed around as an object and executed on demand. It is a key feature of Java 8's support for functional programming, and it provides a concise way to express behavior without the need for verbose anonymous inner classes.

Lambda expressions are used to implement functional interfaces, which are interfaces that have a single abstract method. The lambda expression provides an implementation for the abstract method of the functional interface, which can be used as a function in its own right.

### Q12: What is Method Reference?

In Java, method reference is a shorthand syntax for defining a lambda expression that calls a specific method. It provides a way to pass behavior around as an object without the need to define an explicit lambda expression.

Method reference is used to simplify code by removing unnecessary boilerplate code, making it easier to read and maintain. It is especially useful when the lambda expression simply calls an existing method with the same signature.### Q13: What is Java 8 new features?

### Q14: Lambda can use unchanged variable outside of lambda? what is the details?

In Java, a lambda expression can access and use variables from the enclosing scope, including variables that are defined outside of the lambda expression. However, the variable must be effectively final or final, which means that its value cannot be changed after it is initialized.

Effectively final means that the variable is not explicitly marked as final, but its value is not changed after it is initialized. If a variable is marked as final, it cannot be reassigned a new value after it is initialized.

### Q15: Describe the newly added features in Java 8?

Java 8 introduced several new features and enhancements to the language, including:

1.  Lambda expressions: This feature allows for concise and expressive functional programming by providing a way to define and pass behavior as objects.

2.  Stream API: This feature provides a way to process collections of data in a declarative and functional manner, making it easy to write parallel and pipelined code.

3.  Date and Time API: This feature provides a modern date and time API that is easy to use and understand, and provides better support for internationalization and time zone handling.

4.  Default methods: This feature allows interfaces to provide method implementations, which simplifies the evolution of interfaces and makes it easier to write functional interfaces.

5.  Method references: This feature provides a shorthand syntax for defining lambda expressions that call existing methods.

6.  Optional class: This feature provides a way to handle null values in a safe and concise manner, which reduces the likelihood of null pointer exceptions.

7.  Nashorn JavaScript engine: This feature provides a high-performance JavaScript engine that can be used to execute JavaScript code from Java applications.

8.  Parallel arrays: This feature provides a way to perform bulk operations on arrays in parallel, which can improve performance for certain types of operations.


Overall, Java 8 introduced several significant improvements to the language and libraries, which have made it easier and more efficient to write modern, functional, and concurrent code in Java.

### Q16: Can a functional interface extend/inherit another interface?

Yes, a functional interface in Java can extend or inherit from another interface. When a functional interface extends another interface, it inherits all the abstract methods from the parent interface.

### Q17: What is the lambda expression in Java and How does a lambda expression relate to a functional interface?

In Java, a lambda expression is a concise way to represent a block of code that can be treated as a function. It is similar to an anonymous function in other programming languages. Lambda expressions were introduced in Java 8 to support functional programming features.

A lambda expression consists of a list of parameters, an arrow operator (`->`), and a body that can be either an expression or a block of statements. The parameters represent the input to the lambda expression, and the body represents the output.

Lambda expressions relate to functional interfaces because they can be used to create instances of functional interfaces. A functional interface is an interface that has only one abstract method, and it is used to define the signature of a lambda expression. When a lambda expression is used to implement the abstract method of a functional interface, it becomes an instance of that interface.

### Q18: In Java 8, what is Method Reference?

In Java 8, method reference is a feature that allows you to reference a method of a class or an instance without invoking it. It is a shorthand notation for creating lambda expressions that call a specific method.

Method reference is a way to simplify the creation of lambda expressions that call a single method. Instead of writing a lambda expression that calls a specific method, you can use the `::` operator to reference the method directly. Method reference is particularly useful when the lambda expression is simply calling an existing method.

### Q19: What does the String::ValueOf expression mean?

In Java, `String::valueOf` is a method reference to the static method `valueOf` of the `String` class. This method returns the string representation of the specified value.

### Q20: What are Intermediate and Terminal operations?

In Java streams, operations can be classified into two categories: intermediate and terminal operations.

Intermediate operations are operations that transform a stream into another stream, but do not produce any final result. Intermediate operations are always lazy, which means that they do not perform any computation until a terminal operation is called. Examples of intermediate operations include `map()`, `filter()`, `sorted()`, and `distinct()`.

Terminal operations are operations that produce a final result or a side-effect, and consume the elements of the stream. When a terminal operation is called, all intermediate operations are evaluated, and the computation of the stream is performed. Examples of terminal operations include `forEach()`, `reduce()`, `collect()`, and `count()`.

### Q21: What are the most commonly used Intermediate operations?

Some of the most commonly used intermediate operations in Java streams are:

1.  `map(Function<T, R> mapper)`: Transforms each element in the stream into another object of a different type, according to the provided function.
2.  `filter(Predicate<T> predicate)`: Selects only the elements in the stream that satisfy the given predicate.
3.  `sorted()`: Sorts the elements in the stream in natural order.
4.  `distinct()`: Removes duplicate elements from the stream.
5.  `limit(long maxSize)`: Truncates the stream to the specified maximum size.
6.  `skip(long n)`: Skips the first `n` elements in the stream and returns a new stream containing the remaining elements.
7.  `flatMap(Function<T, Stream<R>> mapper)`: Maps each element in the stream to zero or more elements of a different type, and flattens the resulting streams into a single stream.
8.  `peek(Consumer<T> action)`: Applies the specified action to each element in the stream and returns a new stream containing the same elements.

These intermediate operations can be combined together in various ways to perform more complex transformations on the stream.

### Q22: What is the difference between findFirst() and findAny()?

The `findFirst()` and `findAny()` methods in Java streams are used to find an element in the stream that satisfies a given condition. However, there is a subtle difference between them.

`findFirst()` returns the first element in the stream that satisfies the given condition, while `findAny()` returns any element in the stream that satisfies the given condition. The choice of which element to return in the case of `findAny()` is non-deterministic and can vary between different runs of the program, or between different execution environments.

The `findFirst()` method is usually used when you need to find a specific element in the stream, for example, the first person in a stream of people who meets a certain criteria. On the other hand, `findAny()` can be used when you just need to find any element that meets a certain criteria, and the specific element is not important.

It's worth noting that when using parallel streams, `findFirst()` may not return the first element in the stream, since the stream is split into multiple threads and the elements are processed in parallel. In this case, `findAny()` may be faster, since it can return any element that satisfies the condition, regardless of its position in the stream. However, the downside of using `findAny()` in a parallel stream is that the result can be non-deterministic.

### Q23: How are Collections different from Stream?

Collections and Streams are two different concepts in Java that serve different purposes.

Collections are Java objects that store a collection of elements, such as ArrayList, LinkedList, HashSet, TreeMap, etc. They are used to store and manipulate a group of related objects. Collections can be modified by adding, removing or updating elements, and they support random access to their elements.

Streams, on the other hand, are used to process a sequence of data elements in a functional-style manner, without modifying the original data source. They are created from a source, such as a Collection, and then a series of operations are performed on the data, such as filtering, mapping, and reducing, to produce a result. Streams are designed to be processed in a single pass and they support lazy evaluation, which means that intermediate operations are not evaluated until a terminal operation is invoked.

Here are some of the key differences between Collections and Streams:

1.  Collections store data, while Streams process data.
2.  Collections are mutable, while Streams are immutable.
3.  Collections support random access to elements, while Streams do not.
4.  Collections can be modified by adding, removing or updating elements, while Streams cannot.
5.  Collections are eager, which means that they eagerly evaluate all elements in the collection, while Streams are lazy, which means that they only evaluate the elements that are required for the requested operation.
6.  Collections are typically used to store and manipulate data, while Streams are used to process data in a functional-style manner.

In summary, Collections are used to store and manipulate data, while Streams are used to process data in a functional-style manner, without modifying the original data source.