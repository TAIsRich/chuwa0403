### 1.What is generic in Java? 

Generics are a way to enable type parameters (generics) to be used in classes, interfaces, and methods. This means that classes and methods can be parameterized by type, allowing them to be used with different data types. The use of generics in Java allows for type safety, code reusability, and cleaner code.

A generic class is a class that has one or more type parameters, which are placeholders for the actual types that will be used when the class is instantiated

A generic method is a method that has its own type parameters, which can be different from the type parameters of the class it belongs to.

5. ### Write the Singleton design pattern include eager load and lazy load

Lazy

```java
public class Singleton {
    private static volatile Singleton INSTANCE = null;

    // private constructor to prevent others from instantiating this class
    private Singleton() {}

    public static Singleton getInstance() {
        if (INSTANCE == null) {
            synchronized (Singleton.class) {
                if (INSTANCE == null) {
                    INSTANCE = new Singleton();
                }
            }
        }
        return INSTANCE;
    }
}
```

Eager

```java
public class Singleton {
    private Singleton() {
    }
    private static Singleton instance = new Singleton();
    private Singleton getInstance() {
        return instance;
    }
}
```

### 6.What is Runtime Exception? could you give me some examples?

Runtime Exception is a type of exception that occurs at runtime during the execution of a program. Unlike Checked Exceptions, Runtime Exceptions do not need to be declared in the method signature or caught explicitly by the calling code. They are often caused by logic errors in the code, such as accessing an array out of bounds or attempting to divide by zero.

1. NullPointerException - This exception is thrown when a null reference is used in a method that does not accept null values.
2. ArithmeticException - This exception is thrown when an arithmetic operation fails, such as division by zero.
3. ArrayIndexOutOfBoundsException - This exception is thrown when an attempt is made to access an array element that is outside the bounds of the array.
4. ClassCastException - This exception is thrown when an attempt is made to cast an object to a type that it is not compatible with.
5. IllegalArgumentException - This exception is thrown when an illegal argument is passed to a method.

### 7.Could you give me one example of NullPointerException?

```
String str = null;
System.out.println(str.length());
```

### 8.What is the Optional class?

`Optional` class was introduced in Java 8 and is used to represent a value that may or may not be present. It's a container object that can hold a null reference or a non-null value. The main advantage of using `Optional` is to avoid NullPointerExceptions.

### 9.What are the advantages of using the Optional class?

1. Avoiding null pointer exceptions: Using Optional can help prevent null pointer exceptions, as it forces developers to check whether a value is present before attempting to use it.
2. Increased readability: Code that uses Optional can be more readable, as it makes it clear that a value may be absent and forces developers to handle that case explicitly.
3. Encouraging better programming practices: Optional encourages better programming practices, such as reducing the use of null and favoring more explicit error handling.
4. Improving code safety: By using Optional, developers can ensure that their code is safer, as it forces them to handle potentially missing values explicitly.

### 10.What is the @FunctionalInterface?

`@FunctionalInterface` is a Java annotation that marks an interface as a functional interface, meaning that it has exactly one abstract method. The purpose of this annotation is to prevent developers from accidentally adding additional abstract methods to the interface, which would invalidate the lambda expressions or method references that depend on the interface.

### 11.what is lambda?

A concise way of representing an anonymous function in Java. They were introduced in Java 8 and are commonly used in functional programming.

Lambda expressions are essentially functions that can be created without belonging to any class. They can be passed as arguments to other methods or functions, and they can be stored in variables and passed around like any other value.

```java
List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
numbers.forEach((Integer value) -> System.out.println(value));
```

### 12.What is Method Reference?

Method Reference is a feature introduced in Java 8 that allows you to reuse existing method definitions and pass them around like values, just like lambda expressions. It allows you to simplify the code by using an existing method to represent a lambda expression.

In Method Reference, you use a double colon (::) to separate the method name from the object or class name. There are four types of Method References:

1. Reference to a static method: `ClassName::staticMethodName`
2. Reference to an instance method of an object: `object::instanceMethodName`
3. Reference to an instance method of a class: `ClassName::instanceMethodName`
4. Reference to a constructor: `ClassName::new`

### 13.What is Java 8 new features?

1. Lambda expressions: A way to write more concise code for anonymous classes.
2. Method references: A way to reference an existing method as a lambda expression.
3. Default methods: A way to add new methods to an interface without breaking existing implementations.
4. Streams API: A new API for processing collections of data using functional programming techniques.
5. Date/Time API: A new API for working with dates and times that is easier to use and more powerful than the old Date and Calendar classes.
6. Optional class: A new class that allows for more expressive and safe handling of null values.

### 14.Lambda can use unchanged variable outside of lambda? what is the details?

Yes, Lambda can access and use the final or effectively final variables outside of the lambda expression.

An effectively final variable is a variable whose value is not changed after its initialization. If you try to change its value, you will get a compilation error. Lambda expressions can access effectively final variables from the enclosing scope.

```java
public static void main(String[] args) {
        int x = 10;
        Runnable r = () -> System.out.println("x = " + x);
        r.run();
    }
```

### 15.Describe the newly added features in Java 8?

same as 13

### 16.Can a functional interface extend/inherit another interface?

Yes, a functional interface can extend/inherit another interface. If the extended interface is also a functional interface (meaning it has only one abstract method), then the child interface will also be a functional interface.

### 17.What is the lambda expression in Java and How does a lambda expression relate to a functional interface?

Lambda expression is a new feature introduced in Java 8 that allows the creation of anonymous functions with a compact syntax. It provides a way to pass behavior to methods, making it easier to write code that is concise, expressive, and flexible.

In Java, a lambda expression can be considered as an implementation of a functional interface. A functional interface is an interface that has only one abstract method, known as a functional method. Since there is only one method in the interface, it can be implemented by a lambda expression.

### 18.In Java 8, what is Method Reference?

same as 12

### 19.What does the String::ValueOf expression mean?

A method reference that refers to the static method `valueOf` of the `String` class. This method converts different types of data to their string representation.

### 20.What are Intermediate and Terminal operations?

Intermediate:

operations that are applied to a stream and produce another stream as a result. They do not cause any computation to take place on the elements of the stream until a terminal operation is applied. 
* filter
* limit
* skip
* distinct
* map
* flatMap
* sorted

 Terminal:

operations that produce a result or a side-effect. They trigger the computation of the stream and produce a result or a side-effect.
* allMatch
* anyMatch
* noneMatch
* findFirst
* count
* max
* min
* forEach
* reduce
* collect

21.What are the most commonly used Intermediate operations?

`filter(Predicate<T> predicate)`

`map(Function<T, R> mapper)`

`flatMap(Function<T, Stream<R>> mapper)`

`distinct()`

`sorted()`

`peek(Consumer<T> action)`

22.What is the difference between findFirst() and findAny()?

They are terminal operations that can be used to find an element in a stream.

`findFirst()` returns the first element of the stream that satisfies the given condition, whereas `findAny()` returns any element of the stream. In a sequential stream, both methods return the same result, which is the first element of the stream. However, in a parallel stream, `findFirst()` may not return the first element of the stream, as the order of processing is not guaranteed in a parallel stream, whereas `findAny()` is more efficient in a parallel stream, as it can return any element that matches the given condition.

23.How are Collections different from Stream?

Collections:

1. Represent a group of objects as a data structure.
2. Can be modified by adding or removing elements.
3. Provide methods for accessing and manipulating elements.
4. Execute eagerly, i.e., all elements are evaluated before any operation is performed.

Streams:

1. Represent a sequence of elements that can be processed in a pipelined manner.
2. Cannot be modified directly.
3. Provide methods for filtering, mapping, reducing, and aggregating elements.
4. Execute lazily, i.e., elements are evaluated on demand as they are needed.
5. Can be parallelized for better performance on large datasets.
6. Are useful for processing large datasets and performing complex operations in a concise and readable way.