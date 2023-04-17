## 1.  What is generic in Java?  and type the generic code by yourself.
a. https://github.com/TAIsRich/chuwa-eij-tutorial/tree/main/02-java-core/src/main/java/com/chuwa/tutorial/t01_basic/generic

## 2.  Read those codes and type it one by one by yourself. the push the code to your branch.
https://github.com/TAIsRich/chuwa-eij-tutorial/tree/main/02-java-core/src/main/java/com/chuwa/tutorial/t06_java8

## 3.  practice stream API at least 3 times
a. https://blog.devgenius.io/15-practical-exercises-help-you-master-java-stream-api-3f9c86b1cf82

## 4.  Practice Optional methods at least 2 times
a. https://github.com/TAIsRich/chuwa-eij-tutorial/blob/main/02-java-core/src/main/java/com/chuwa/tutorial/t06_java8/exercise/ShoppingCartUtil.java

## 5.  Write the Singleton design pattern include eager load and lazy load. 

### eager load
```java
public class EagerSingleton{
    private static final EagerSingleton instance = new EagerSingleton();
    private EagerSingleton() {}
    public static EagerSingleton getInstance(){
        return instance;
    }
}
```

### lazy load
```java
public class LazySingleton{
    //The volatile keyword is also used to ensure that all threads have access to the latest value of the instance variable.
    private static volatile LazySingleton instance = null;
    private LazySingleton() {}
    public static LazySingleton getInstance(){
        //To ensure thread safety
        if(instance == null){
            synchronized(LazySingleton.class){
                if(instance == null){
                    instance = new LazeSingleton();
                }
            }   
        }
        return instance;
    }
}
```


## 6.  What is Runtime Exception? could you give me some examples?
A `RuntimeException` is a type of unchecked exception in Java, which means that it is not required to be caught or declared in the method signature. These exceptions are thrown at runtime, usually due to programming errors or unexpected conditions, and indicate a problem that cannot be handled by the program itself.

`NullPointerException`: This occurs when a program attempts to access an object or variable that is null. For example, if you try to call a method on a null object reference, or access a null array element, a `NullPointerException` will be thrown.

`ArrayIndexOutOfBoundsException`: This occurs when a program attempts to access an array element at an index that is outside the bounds of the array. For example, if you try to access the fifth element of an array with only four elements, an `ArrayIndexOutOfBoundsException` will be thrown.

`ClassCastException`: This occurs when a program attempts to cast an object to a type that it is not compatible with. For example, if you try to cast an Integer object to a String object, a `ClassCastException` will be thrown.


## 7. Could you give me one example of NullPointerException?
```
\\ ListNode a->b->c->null
ListNode ptr=a;
while(ptr.val!=0){
    // NPE will be thrown when ptr=c.next;
    ptr=ptr.next;
}
```


## 8.  What is the Optional class?
The `Optional` class is a container object introduced in Java 8 that is used to represent a value that may or may not be present. It is designed to address the problem of null values in Java, which can lead to `NullPointerExceptions` and other errors.

## 9.  What are the advantages of using the Optional class?
The `Optional` class provides a way to explicitly state that a value may be absent, rather than relying on the value being `null`. It can be thought of as a wrapper around an existing value, where the value can either be present or absent.

## 10. What is the @FunctionalInterface?
`@FunctionalInterface` is an annotation introduced in Java 8 that is used to indicate that an interface is intended to be a functional interface. A functional interface is an interface that defines a single abstract method, which is intended to be implemented by a lambda expression or method reference.

## 11. what is lamda?
A `lambda expression` in Java is a way to define a block of code that can be passed around as an object. It allows you to write more concise and readable code, especially when working with functional interfaces, which are interfaces that have a single abstract method.

A lambda expression is essentially a shorthand way of writing an anonymous method or function. It consists of three parts:

1. The parameter list, which defines the input to the lambda expression.
2. The arrow -> symbol, which separates the parameter list from the body of the lambda expression.
3. The body of the lambda expression, which is the code that is executed when the lambda expression is called.

## 12. What is Method Reference?
Method reference is a feature introduced in Java 8 that allows you to reference a method as a value, without actually invoking it. It is used to provide a more concise and readable way of passing a method as an argument to a functional interface, instead of using a lambda expression.

There are four types of method references in Java:

1. Reference to a static method:
```java
MyFunctionalInterface myInterface = MyClass::myStaticMethod;
```
2. Reference to an instance method of an object of a particular type:
```java
MyFunctionalInterface myInterface = myObject::myInstanceMethod;
```
3. Reference to an instance method of an existing object:
```java
MyFunctionalInterface myInterface = myExistingObject::myInstanceMethod;
```
4. Reference to a constructor:
```java
MyFunctionalInterface myInterface = MyClass::new;
```

## 13. What is Java 8 new features?
Java 8 introduced several new features that made it easier to write cleaner and more efficient code, and expanded the capabilities of the Java language. Some of the key features include:

1. `Lambdas` and `Functional Interfaces`: Java 8 introduced the concept of lambda expressions, which allow developers to write more concise and readable code for functional interfaces. This makes it easier to write functional-style code and to work with Java's new Streams API.

2. `Streams API`: Java 8 introduced the Streams API, which provides a more functional way of working with collections of data. Streams allow you to perform complex operations on collections of data, such as filtering, mapping, and reducing, in a more concise and readable way.

3. `Default` and `Static` Methods in Interfaces: Java 8 introduced the ability to include default and static methods in interfaces, which makes it easier to evolve existing interfaces without breaking existing implementations.

4. `Optional`: Java 8 introduced the Optional class, which provides a more explicit way of handling null values. Optional makes it easier to write more concise and safer code when dealing with potentially null values.

5. `Method References`: Java 8 introduced method references, which allow developers to reference a method as a value, without actually invoking it. This provides a more concise and readable way of passing a method as an argument to a functional interface, instead of using a lambda expression.

6. `Date and Time API`: Java 8 introduced a new Date and Time API, which provides a more robust and efficient way of working with dates and times. The new API makes it easier to perform calculations, format dates, and work with time zones.

7. `Nashorn JavaScript Engine`: Java 8 introduced the Nashorn JavaScript engine, which allows developers to run JavaScript code on the Java Virtual Machine (JVM). This makes it easier to integrate JavaScript code with Java applications.

## 14. Lambda can use unchanged variable outside of lambda? what is the details?
Yes, lambdas in Java can access variables that are defined outside the lambda expression, as long as the variables are effectively final or final. An effectively final variable is a variable whose value does not change after it is initialized.

This is because the lambda expression captures the value of the variable at the point where it is created, and stores that value in its own memory space. The lambda can then use that value whenever it is executed, even if the original variable has been modified or is no longer in scope.

Here's an example:

```java
public class LambdaExample {
    public static void main(String[] args) {
        int x = 10; // effectively final variable

        Runnable r = () -> {
            System.out.println("x = " + x); // x is accessed from the lambda expression
        };

        r.run(); // output: x = 10
    }
}
```

In this example, we define a variable x and initialize it to 10. We then create a lambda expression that prints the value of x. Since x is effectively final, we can access it from within the lambda expression. When we execute the lambda expression, it prints the value of x, which is still 10.


## 15. Describe the newly added features in Java 8?

Please check answer to question 13.

## 16. Can a functional interface extend/inherit another interface?

Yes, a `functional interface` in Java can extend or inherit another interface, as long as it satisfies the requirements of a `functional interface`.

In order for an interface to be a `functional interface`, it must have exactly one abstract method. It can also have any number of default or static methods, but only one abstract method.

When a `functional interface` extends another interface, it inherits all of the abstract and default methods from the parent interface. However, it must still satisfy the requirements of a `functional interface`, which means that it must have exactly one abstract method.

## 17.  What is the lambda expression in Java and How does a lambda expression relate to a functional interface?

A `lambda expression` in Java is a way to define a block of code that can be treated as an object. It allows you to pass around behavior as if it were data, making it easier to write code that is both concise and expressive. A `lambda expression` can be seen as a shorthand for an anonymous inner class.

`Lambda expressions` are closely related to `functional interfaces` in Java. A `functional interface` is an interface that has only one abstract method. Since the `lambda expression` is essentially an implementation of this method, it can be used to create an instance of a `functional interface`.

For example, suppose we have a `functional interface` called MyFunction with one abstract method:

```java
@FunctionalInterface
public interface MyFunction {
    int apply(int x, int y);
}

MyFunction f = (x, y) -> x + y;
```

## 18. In Java 8, what is Method Reference?

Method reference is a feature introduced in Java 8 that allows you to reference a method as a value, without actually invoking it. It is used to provide a more concise and readable way of passing a method as an argument to a functional interface, instead of using a lambda expression.

There are four types of method references in Java:

1. Reference to a static method:
```java
MyFunctionalInterface myInterface = MyClass::myStaticMethod;
```
2. Reference to an instance method of an object of a particular type:
```java
MyFunctionalInterface myInterface = myObject::myInstanceMethod;
```
3. Reference to an instance method of an existing object:
```java
MyFunctionalInterface myInterface = myExistingObject::myInstanceMethod;
```
4. Reference to a constructor:
```java
MyFunctionalInterface myInterface = MyClass::new;
```

## 19. What does the String::ValueOf expression mean?

In Java, `String::valueOf` is a method reference that refers to the `valueOf()` method of the String class.

The `valueOf()` method is a static method that converts different data types (such as int, long, float, double, char, boolean, etc.) to their string representation. It returns the string representation of the specified argument. For example, String.valueOf(123) would return the string "123".

The method reference `String::valueOf` can be used instead of a lambda expression that does the same thing, which is to call the `valueOf()` method of the String class. Here's an example:

```java
int num = 123;
String str1 = String.valueOf(num); // using the static method directly
String str2 = Integer.toString(num); // alternative way to convert int to String
String str3 = String::valueOf; // using method reference to call String.valueOf
String str4 = (n) -> String.valueOf(n); // equivalent lambda expression
```

## 20. What are Intermediate and Terminal operations?

In Java 8 and later versions, `streams` provide a functional programming approach to process collections of data. A `stream` is a sequence of elements that can be processed in parallel or sequentially. `Stream` operations can be divided into two categories: `intermediate` and `terminal` operations.

`Intermediate operations` are operations that return a new `stream`. These operations are lazy, meaning that they don't execute immediately when they're called. Instead, they build a new `stream` that will execute when a `terminal operation` is called. Some examples of `intermediate operations` are `filter()`, `map()`, `distinct()`, `sorted()`, `limit()`, and `skip()`. 

`Terminal operations`, on the other hand, are operations that produce a non-stream result, such as a primitive value, an object, or a collection. These operations execute immediately when they are called, and they trigger the processing of the intermediate operations. Some examples of `terminal operations` are `count()`, `reduce()`, `forEach()`, `collect()`, `min()`, and `max()`.

## 21. What are the most commonly used Intermediate operations?

1. `filter(Predicate<T> predicate)`: Filters the stream to include only elements that match the given predicate.

2. `map(Function<T, R> mapper)`: Maps the elements of the stream to a new value using the given mapper function.

3. `flatMap(Function<T, Stream<R>> mapper)`: Maps each element of the stream to a new stream using the given mapper function, and then flattens the resulting streams into a single stream.

4. `distinct()`: Returns a stream that contains only distinct elements.

5. `sorted()`: Sorts the elements of the stream in natural order.

6. `sorted(Comparator<T> comparator)`: Sorts the elements of the stream using the given comparator.

7. `peek(Consumer<T> action)`: Applies the given action to each element of the stream, without changing the stream itself.

8. `limit(long maxSize)`: Returns a stream that contains at most maxSize elements.

9. `skip(long n)`: Returns a stream that discards the first n elements.

## 22. What is the difference between findFirst() and findAny()?

In Java Streams, `findFirst()` and `findAny()` are two terminal operations that can be used to retrieve an element from a stream.

`findFirst()` returns the first element of the stream, or an empty Optional if the stream is empty. It operates in a deterministic manner, meaning that it will always return the same result for a given input. It's often used when you want to retrieve the first element of a stream that meets a certain criteria.

For example:

```java
Optional<Integer> firstEven = numbers.stream().filter(n -> n % 2 == 0).findFirst();
```

`findAny()` returns any element of the stream, or an empty Optional if the stream is empty. It operates in a non-deterministic manner, meaning that it may return different results for different runs of the same program. It's often used when you want to retrieve any element of a stream that meets a certain criteria, but you don't care which one.

For example:

```java
Optional<Integer> anyEven = numbers.stream().filter(n -> n % 2 == 0).findAny();
```

## 23. How are Collections different from Stream?

`Collections` and `Streams` are both used in Java for handling data, but they are different in a few key ways:

1. `Data Structure`: `Collections` are data structures that store elements in memory, while `Streams` are not data structures, but rather a sequence of elements that can be processed on-demand.

2. `Mutability`: `Collections` can be mutable, meaning that their elements can be added, removed, or modified. `Streams`, on the other hand, are immutable, meaning that once created, their elements cannot be changed.

3. `Laziness`: `Streams` are evaluated lazily, meaning that the elements of a `stream `are only computed as they are needed. This can lead to more efficient processing of large datasets, as only the necessary elements are computed at any given time. `Collections`, on the other hand, are always fully loaded into memory, even if only a subset of the elements are needed.

4. `Iteration`: `Collections` can be iterated over multiple times, while a `Stream` can only be iterated over once.

5. `Operations`: `Collections` provide a wide variety of operations for manipulating data, such as adding, removing, and sorting elements. `Streams` provide a more limited set of operations, but they are focused on transforming and processing data in a functional style.