## 5. Write the Singleton design pattern include eager load and lazy load.

1. Eager load

```
public class Singleton {

    private static Singleton instance = new Singleton();
    private Singleton(){

    }
    
    public static Singleton getInstance(){
        return instance;
    }
}
```

2. Lazy load

```
public class Singleton{

    private static volatile Singleton instance;

    private Singleton(){

    }

    public static Singleton getInstance(){
        if(instance == null){
            synchronized (Singleton.class){
                if(instance == null){
                    instance = new Singleton();
                }
            }
        }
    }
}
```

## 6. What is Runtime Exception? could you give me some examples?

Runtime Exception is also known as Unchecked Exception. A runtime exception is an exception that occurs during the execution of a program, typically due to logical or programming errors, and can cause the program to terminate abruptly. Runtime Exception is thrown by the JVM (Java Virtual Machine) when it occur.

Examples:
1. NullPointerException - occurs when a program tries to access a null object reference.
2. ArithmeticException - occurs when a program tries to divide an integer by zero.
3. ArrayIndexOutOfBoundsException - occurs when a program tries to access an array index that is outside the bounds of the array.
4. IllegalArgumentException - occurs when a program passes an illegal argument to a method.
5. ClassCastException - occurs when a program tries to cast an object to a subclass of which it is not an instance.

## 7. Could you give me one example of NullPointerException?

```
public class Example {
    public static void main(String[] args) {
        String str = null;  
        int length = str.length();  
    }
}
```
In this example, I first declare a String variable str and assign it the value null. Later, I try to call the length() method on the str variable to get the length of the string, but since str is null, a NullPointerException is thrown at runtime.

## 8. What is Optional class?

Optional class is a container object that may or may not contain a non-null value. It is designed to provide a more expressive way of handling null values than traditional null checks, and it can help to reduce NullPointerExceptions in Java programs. Optional class provides a convenient and safe way to handle null values in Java programs.

## 9. What are the advantages of using the Optional class?

1. Avoiding NullPointerExceptions: Using the Optional class helps to avoid NullPointerExceptions. When you use Optional, you can write code that handles both the presence and absence of a value, without having to check for null values explicitly. This can make your code more robust and less prone to errors.
2. Clearer code: Using Optional can make your code clearer and more expressive. By using methods like orElse() and orElseGet(), you can make your code more concise and easier to read.
3. Better documentation: When you use Optional, it makes it clearer in your code documentation whether a method or field can return a null value or not. This can help other developers who are using your code to understand what to expect when they call your methods or access your fields.
4. Safer APIs: Using Optional can make your APIs safer, since it forces clients to handle the possibility of null values. If you use Optional in your API, clients will have to use the methods and APIs provided by Optional to access the value, which will help to prevent null-related errors.
5. Better performance: While using Optional may involve some additional overhead, the performance impact is usually minimal. In fact, in some cases, using Optional can actually improve performance by allowing the compiler to optimize code that would otherwise require null checks.

## 10. What is the @FunctionalInterface?

@FunctionalInterface is an annotation introduced in Java 8 that indicates that an interface is intended to be a functional interface. A functional interface is an interface that has only one abstract method, known as the functional method. The purpose of the @FunctionalInterface annotation is to provide additional compile-time checks to ensure that the interface is indeed a functional interface. Functional Interface is for sanity check, and can have a lot of default methods. Lambda is the implementation of the abstract method.

## 11. What is Lambda?

A lambda expression, also known as a lambda function or an anonymous function, is a way to define a function in Java without declaring a method. It is a concise way to represent a single-method interface using an expression. Lambda expressions were introduced in Java 8 as part of the Java Functional Programming paradigm. Lambda works with functional interface, and lambda can replace anonymous inner class. 

## 12. What is Method Reference?

Method reference is a shorthand syntax for defining a lambda expression that calls a method. It allows you to pass a method as an argument to another method, without actually invoking the method.

Types:
1. Reference to a static method: This references a static method of a class. It can be expressed using the syntax ClassName::methodName.
2. Reference to an instance method of an object of a particular type: This references an instance method of a specific object. It can be expressed using the syntax object::methodName.
3. Reference to an instance method of an arbitrary object of a particular type: This references an instance method of any object of a specific type. It can be expressed using the syntax ClassName::methodName.
4. Reference to a constructor: This references a constructor of a class. It can be expressed using the syntax ClassName::new.

## 13. What is Java 8 new features?

1. Lambda expressions: This allows you to write more concise and functional code using lambda expressions, which are anonymous functions that can be passed as arguments to methods.
2. Stream API: This provides a new way to work with collections and arrays using functional programming concepts. It allows you to perform operations on a collection of elements in a declarative manner.
3. Optional class: This provides a way to handle null values without causing null pointer exceptions. It allows you to wrap a potentially null value in an Optional object, which you can then check for null before accessing the value.
4. Default methods: This allows you to add methods to interfaces without breaking existing code that implements the interface.
5. Method reference: This provides a way to refer to a method without invoking it. It can be used to pass a method as an argument to another method, making your code more concise and readable.
6. Date and Time API: Java 8 introduced a new Date and Time API, which provides better support for working with dates and times.
7. Nashorn JavaScript engine: Nashorn is a new JavaScript engine that is included in Java 8. It provides better performance and allows you to use JavaScript in your Java applications.

## 14. Lambda can use unchanged variable outside of lambda? what is the details?

Lambda expressions can use variables from their enclosing scope, including local variables, instance variables, and static variables. The captured variables are treated as final or effectively final, meaning that their values cannot be modified after they are captured. If a lambda expression captures a local variable, the variable must be either final or effectively final. A variable is effectively final if its value is not modified after it is initialized. If a lambda expression captures a local variable, it essentially creates a new instance of that variable inside the lambda expression. Any changes made to the variable inside the lambda expression do not affect the original variable outside of the lambda expression. However, the lambda expression can read the value of the captured variable and use it as needed.

## 15. Describe the newly added features in Java 8?

1. Lambda expressions: This allows you to write more concise and functional code using lambda expressions, which are anonymous functions that can be passed as arguments to methods.
2. Stream API: This provides a new way to work with collections and arrays using functional programming concepts. It allows you to perform operations on a collection of elements in a declarative manner.
3. Optional class: This provides a way to handle null values without causing null pointer exceptions. It allows you to wrap a potentially null value in an Optional object, which you can then check for null before accessing the value.
4. Default methods: This allows you to add methods to interfaces without breaking existing code that implements the interface.
5. Method reference: This provides a way to refer to a method without invoking it. It can be used to pass a method as an argument to another method, making your code more concise and readable.
6. Date and Time API: Java 8 introduced a new Date and Time API, which provides better support for working with dates and times.
7. Nashorn JavaScript engine: Nashorn is a new JavaScript engine that is included in Java 8. It provides better performance and allows you to use JavaScript in your Java applications.

## 16. Can a functional interface extend/inherit another interface?

Yes, a functional interface can extend another interface in Java. However, the extended interface must also be a functional interface. In Java, a functional interface is an interface that has exactly one abstract method. This means that any interface that has more than one abstract method is not a functional interface. If a functional interface extends another interface, then the new interface must also have exactly one abstract method. This is because if it had more than one abstract method, it would not be a functional interface anymore. But the new interface can have default methods, static methods, and abstract methods from the extended interface as long as it still has only one abstract method.

## 17. What is the lambda expression in Java and How does a lambda expression relate to a functional interface?

In Java, a lambda expression is a shorthand notation for defining and implementing a functional interface. A functional interface is an interface that has exactly one abstract method, also known as the functional method. Lambda expressions provide a concise way to write anonymous functions that can be passed around as data. The relationship between lambda expressions and functional interfaces is that a lambda expression is a way of implementing the single abstract method of a functional interface. When you use a lambda expression to implement a functional interface, you're essentially defining the behavior of the functional interface's single method.

## 18. In Java 8, what is Method Reference?

Method reference is a shorthand syntax for defining a lambda expression that calls a method. It allows you to pass a method as an argument to another method, without actually invoking the method.

Types:
1. Reference to a static method: This references a static method of a class. It can be expressed using the syntax ClassName::methodName.
2. Reference to an instance method of an object of a particular type: This references an instance method of a specific object. It can be expressed using the syntax object::methodName.
3. Reference to an instance method of an arbitrary object of a particular type: This references an instance method of any object of a specific type. It can be expressed using the syntax ClassName::methodName.
4. Reference to a constructor: This references a constructor of a class. It can be expressed using the syntax ClassName::new.

## 19. What does the String::ValueOf expression mean?

The String::valueOf expression is a method reference that refers to the valueOf() method of the String class in Java. This method takes a value of any primitive data type or an object and returns a String representation of that value.

## 20. What are Intermediate and Terminal operations?

Intermediate operations are operations that transform a stream into another stream. These operations are usually lazy and do not produce a final result until a terminal operation is called. Examples of intermediate operations include filter(), map(), flatMap(), distinct(), skip(n), limit(n). Terminal operations are operations that produce a result or a side-effect. They trigger the evaluation of the intermediate operations and produce a final result. Examples of terminal operations include forEach(), reduce(), collect(), and count(). Intermediate operations can be chained together to form a pipeline of transformations, and the pipeline can be terminated by a terminal operation. 

## 21. What are the most commonly used Intermediate operations?

1. filter(Predicate p): filters the elements of the stream based on a given predicate and returns a new stream that contains only the elements that satisfy the predicate.
2. map(function f): transforms the elements of the stream by applying a given function to each element and returns a new stream that contains the transformed elements.
3. flatMap(function f): transforms the elements of the stream by applying a given function to each element and returns a new stream that contains the flattened elements.
4. distinct(): removes duplicate elements from the stream and returns a new stream that contains only unique elements.
5. limit(n): returns a new stream that contains only the first maxSize elements of the original stream.
6. skip(n): returns a new stream that skips the first n elements of the original stream and contains the rest of the elements.

## 22. What is the difference between findFirst() and findAny()?

The findFirst() operation returns the first element of the stream, while the findAny() operation returns any element of the stream. The element returned by findAny() is non-deterministic, meaning that it may vary between multiple invocations of the operation. The difference between findFirst() and findAny() is more significant in parallel streams. In a parallel stream, findFirst() must wait for all the elements to be processed before it can return the first element, while findAny() can return any element that has been processed so far, making it faster in some cases.

## 23. How are Collections different from Stream?

1. Data Storage: Collections are data structures that store a collection of elements in memory, while Streams represent a sequence of elements that may come from a variety of sources, such as collections, arrays, or I/O channels.
2. Data Mutation: Collections are typically mutable, meaning that elements can be added, removed, or modified. Streams are generally immutable, meaning that once created, they cannot be modified.
3. Lazy Evaluation: Streams support lazy evaluation, meaning that they only evaluate the elements that are necessary for the current operation. Collections, on the other hand, are typically eager, meaning that all the elements are evaluated before any operation is performed.
4. Pipeline: Streams provide a way to create a pipeline of operations that can be performed on the data source in a declarative way, without needing to iterate over the collection manually. Collections require iteration over the collection and applying operations manually.






