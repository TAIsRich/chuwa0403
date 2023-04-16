Q5  
```java
public class EagerSingleton {
    private static final EagerSingleton instance = new EagerSingleton();

    private EagerSingleton() {
        // 私有构造函数
    }

    public static EagerSingleton getInstance() {
        return instance;
    }
}
```
```java
public class LazySingleton {
    private static volatile LazySingleton instance;

    private LazySingleton() {
        // 私有构造函数
    }

    public static LazySingleton getInstance() {
        if (instance == null) {
            synchronized (LazySingleton.class) {
                if (instance == null) {
                    instance = new LazySingleton();
                }
            }
        }
        return instance;
    }
}
```

Q6  
RuntimeException is a type of unchecked exception that can be thrown during runtime when an exceptional condition occurs in a program.   
Here are some examples of common RuntimeExceptions in Java:

- **NullPointerException**: Thrown when an application attempts to use null in a case where an object is required. For example, accessing a method or variable on a null object reference.

- **ArrayIndexOutOfBoundsException**: Thrown when an application tries to access an array element with an invalid index. For example, accessing an array element with an index greater than or equal to the array length.

- **ArithmeticException**: Thrown when an exceptional arithmetic condition has occurred. For example, dividing by zero.

- **IllegalArgumentException**: Thrown when a method has been passed an illegal or inappropriate argument. For example, passing a negative number to a method that requires a positive argument.

Q7  
```java
String str = null;
int length = str.length(); // This will throw a NullPointerException
```

Q8  
The Optional class is a container object in Java that may or may not contain a non-null value. It is used to represent a value that may or may not be present, and provides a way to avoid NullPointerExceptions that can occur when dealing with null values.

Q9  
Optional class provides a safer and more explicit way to handle optional values, and can help to improve code safety, readability, and maintainability.

Q10  
By marking the interface with @FunctionalInterface, we ensure that it is treated as a functional interface by the compiler. This can be useful in cases where the interface is used in lambda expressions or method references, which rely on the interface being a functional interface.

Q11  
Lambda expressions (also known as lambda functions or closures) are a feature introduced in Java 8 that allow you to define and use small, anonymous functions in your code. A lambda expression can be thought of as a concise way to represent a function, without the need to define a separate class or interface for it.
```
(parameters) -> expression
(parameters) -> { statements; }
```

Q12  
Method references are a shorthand notation introduced in Java 8 that allow you to refer to an existing method by name, without having to define a lambda expression explicitly.
```java
List<String> words = Arrays.asList("hello", "world", "java");

// Using a lambda expression
words.forEach(s -> System.out.println(s));

// Using a method reference
words.forEach(System.out::println);
```

Q13  
Java 8 introduced several new features and improvements, including:

1. Lambda expressions and method references: A concise syntax for defining and using small, anonymous functions (lambda expressions), and a shorthand notation for referring to existing methods (method references).

2. Stream API: A new API for working with collections and processing data in a functional style, including methods for filtering, mapping, reducing, and collecting data.

3. Optional class: A new container class for representing a value that may or may not be present, which can help to eliminate null pointer exceptions and make code more readable.

4. Date and Time API: A new API for working with dates and times, including classes for representing dates, times, and durations, and methods for performing calculations and formatting.

5. Default methods: A new feature that allows interfaces to provide default implementations for methods, which can make it easier to add new methods to existing interfaces without breaking backwards compatibility.

Q14  
Lambda expressions can access variables that are effectively final or are declared outside of the lambda expression, but they cannot modify the value of these variables. This feature is called "capturing variables" and it allows you to reference variables from the enclosing scope within a lambda expression.

Q15  
See Q13

Q16  
Yes, but it must still have exactly one abstract method of its own to be considered a functional interface.

Q17  
Lambda expression in Java is a concise way to represent an anonymous function that can be used as a value. It relates to a functional interface by providing an implementation of the single abstract method of the functional interface. This allows you to use functional interfaces as types, and pass lambda expressions as arguments to methods or assign them to variables.

Q18  
See Q12

Q19  
String::valueOf is a Method Reference that refers to the static method valueOf in the String class. The valueOf method in the String class is used to convert different types of values into a string representation.

Q20  
Intermediate operations are operations that transform a stream into another stream, and they are usually stateless. They are used to transform, filter or sort the elements of the stream. Examples of intermediate operations include filter, map, sorted, distinct, flatMap, peek, etc.  

Terminal operations are operations that produce a result or a side effect, and they usually terminate the stream. They are used to trigger the processing of the stream and produce a final result. Examples of terminal operations include forEach, reduce, collect, count, min, max, anyMatch, allMatch, noneMatch, etc.

Q21  
filter: Used to filter elements based on a condition.

map: Used to transform elements into another type.

flatMap: Used to transform each element into a stream of multiple elements, and then flatten the resulting streams into a single stream.

distinct: Used to remove duplicate elements from the stream.

sorted: Used to sort the elements of the stream in a natural order or a specific order defined by a comparator.

peek: Used to perform a side-effect operation on each element of the stream, without modifying the stream.

limit: Used to limit the number of elements in the stream.

skip: Used to skip a number of elements from the stream.

Q22  
findFirst(): Returns the first element in the stream. If the stream is ordered, it will return the first element in the encounter order. If the stream is unordered, it will return any element in the stream.

findAny(): Returns any element in the stream. If the stream is parallel, it will return any element that is processed first. If the stream is sequential, it will return the first element in the encounter order.  

The difference between findFirst() and findAny() is important in parallel streams, where the order of elements may not be defined. In this case, findAny() can be faster than findFirst() because it does not need to look for the first element in a particular order. However, in sequential streams or ordered parallel streams, findFirst() and findAny() should return the same result.

Q23  
Collections 讲的是数据，Stream讲的是计算（CPU）
* 1. Stream 自己不会存储元素
* 2. Stream 不会改变源对象，相反，他们会返回一个持有结果的新stream
* 3. Stream操作是延迟执行的，这意味着他们会等到需要结果的时候才执行。

