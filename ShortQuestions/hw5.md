
## 1.  What is generic in Java?and type the generic code by yourself.

 Please check Coding/hw5/Generic for the generic code practice

Generic in Java is a feature that allows programmers to define classes, interfaces, and methods that work with various types of objects without specifying the type in advance. 
```java
public class Box<T> {
   private T item;
   public void setItem(T item) {
      this.item = item;
   }
   public T getItem() {
      return item;
   }
}
Box<Integer> box1 = new Box<>();
Box<String> box2 = new Box<>();

box1.setItem(123);
box2.setItem("hello");

Integer item = box.getItem()
String item = box.getItem();
```
## 2. Read those codes and type it one by one by yourself. the push the code to your branch.
Please check Coding/hw5/java8prictise
## 3. practice stream API at least 3 times
Please check Coding/hw5/stream-api-exercises
## 4. Practice Optional methods at least 2 times
Please check Coding/hw5/java8prictise

## 5.  Write the Singleton design pattern include eager load and lazy load.

**Eager loading:** the singleton instance is created eagerly at the time of class loading. 
```java
public class Singleton {
   private static final Singleton INSTANCE = new Singleton();
   // Private constructor to restrict instantiation from outside the class
   private Singleton() {}
   // Public static method to get the singleton instance
   public static Singleton getInstance() {
      return INSTANCE;
   }
}
```
**Lazy loading:** the singleton instance is created lazily, that is, when it is first requested. 
```java
public class Singleton {
   private static Singleton instance;
   // Private constructor to restrict instantiation from outside the class
   private Singleton() {}
   // Public static method to get the singleton instance
   public static synchronized Singleton getInstance() {
      if(instance == null) {
         instance = new Singleton();
      }
      return instance;
   }
}
```
## 6. What is Runtime Exception? could you give me some examples?

A runtime exception is an unchecked exception that occurs at runtime and doesn't require the code to catch or declare it. It indicates that there is a problem that could not be detected by the compiler at compile time. Some examples of runtime exceptions include:

*NullPointerException:* occurs when a program tries to access an object that is null.

*IllegalArgumentException:* occurs when an illegal argument is passed to a method.

*IndexOutOfBoundsException:* occurs when an index is out of bounds for an array or a collection.

*ArithmeticException:* occurs when an arithmetic operation (such as division by zero) results in an undefined or infinite value.

*ClassCastException:* occurs when an object is cast to an incompatible type.

*ConcurrentModificationException:* occurs when a collection is modified while it is being iterated.

## 7. Could you give me one example of NullPointerException?

```java
String name = null;
int length = name.length(); // This line will throw a NullPointerException
```

## 8. What is the Optional class?

The Optional class is a container object that may or may not contain a non-null value. It's a way of avoiding NullPointerExceptions that can occur when working with null values. Instead of returning null, you can return an Optional object which can be checked to see if it contains a value or not.

## 9. What are the advantages of using the Optional class?

The Optional class is a more elegant and safer way to handle values that may be null. By using Optional objects, we can avoid NullPointerExceptions and make the code more concise and readable

1，Avoiding NullPointerExceptions: By using Optional, you can avoid null checks and NullPointerExceptions. Instead of returning a null value, you can return an Optional object that may or may not contain a value.

2，Better code readability: By using Optional, your code becomes more expressive and self-documenting, as it makes it clear that a value may be absent.

3，Improved code safety: When using Optional, you are forced to handle the case where a value may be absent, which leads to more robust and safer code.

4，Better support for stream operations: The Optional class provides useful methods that can be used in stream operations, such as orElse, orElseThrow, and ifPresent.

5，Better integration with other Java 8 features: The Optional class works well with other Java 8 features such as lambda expressions, method references, and stream operations, which makes it easier to write concise and expressive code.

## 10. What is the @FunctionalInterface?
Used to indicates that an interface is intended to be a functional interface,which 
has one single Abstract method and can have a lot of default methods

Lambda is the implementation of the abstract method

## 11. what is lamda?

To Replace anonymous inner class and work with functional interface

Lambda expressions are actually syntax for implementing SAM (Single Abstract Method) interfaces, which have only one abstract method (although they can also contain non-abstract methods, including static and default methods added in JDK 8).

## 12. What is Method Reference?

Method reference is a feature in Java that allows you to refer to an existing method by its name, rather than providing a new implementation for a functional interface. In other words, it is a shorthand notation for creating a lambda expression that calls an existing method.

Method reference is often used with functional interfaces that have a single abstract method. The method reference syntax depends on the type of method being referenced:
```java
Arrays.sort(stringsArray,(s1,s2) -> s1.compareToIgnoreCase(s2));
Arrays.sort(stringsArray, String::compareToIgnoreCase);
```
##  13 What is Java 8 new features?

**Lambda expressions:** A concise way to represent anonymous functions and pass them as arguments to methods.

**Method references:** A shorthand notation for creating a lambda expression that calls an existing method.

**Functional interfaces:** New interfaces that have a single abstract method, which can be used with lambda expressions and method references.

**Stream API:** A set of classes and methods for processing collections of data in a functional style.

**Default methods:** Methods in interfaces that have a default implementation, allowing interfaces to be extended without breaking existing implementations.

**Optional class:** A new class that represents an object that may or may not be present, helping to avoid NullPointerExceptions.

**Date and Time API:** A new API for working with dates and times, which is more comprehensive and flexible than the legacy java.util.Date and java.util.Calendar classes.

## 14. Lambda can use unchanged variable outside of lambda? what is the details?

Final variable
```java
public void testFinal() {
  final String localVariable = "Local";
  Foo foo = parameter -> {
    return parameter + " " + localVariable;
  };
  System.out.println(foo.aMethod("hello"));
 }
 ```
Non-final variable however never changed
```java
public void testEffectivelyFinal() {
  String localVariable = "Local";
  Foo foo = parameter -> {
    return parameter + " " + localVariable;
   };
  System.out.println(foo.aMethod("hello"));
 }
 ```
  ## 15. Describe the newly added features in Java 8?
 
 **Lambda expressions:** A concise way to represent anonymous functions and pass them as arguments to methods.

**Method references:** A shorthand notation for creating a lambda expression that calls an existing method.

**Functional interfaces:** New interfaces that have a single abstract method, which can be used with lambda expressions and method references.

**Stream API:** A set of classes and methods for processing collections of data in a functional style.

**Default methods:** Methods in interfaces that have a default implementation, allowing interfaces to be extended without breaking existing implementations.

**Optional class:** A new class that represents an object that may or may not be present, helping to avoid NullPointerExceptions.

**Date and Time API:** A new API for working with dates and times, which is more comprehensive and flexible than the legacy java.util.Date and java.util.Calendar classes.
 
 ## 16. Can a functional interface extend/inherit another interface?
 
 Yes, a functional interface in Java can extend or inherit another interface. When a functional interface extends another interface, it inherits all of the non-default and non-static methods of the parent interface.

However, there are a few restrictions to keep in mind. First, the parent interface must also be a functional interface, which means it must have exactly one abstract method. Second, the child interface must have only one abstract method as well. If it has more than one abstract method, it will no longer be a functional interface
```java
interface MyFunction {
    int apply(int x, int y);
}

interface MyExtendedFunction extends MyFunction {
    int apply(int x, int y, int z);
}
```


## 17. What is the lambda expression in Java and How does a lambda expression relate to a functional interface?

**A lambda expression** in Java is a concise way to represent an anonymous function that can be passed as an argument to a method. It allows you to write functional code in a more concise and expressive way. Lambda expressions can be used to implement functional interfaces, which are interfaces that have exactly one abstract method.

## 18. In Java 8, what is Method Reference?

**Method reference** is a feature that allows you to reference an existing method by its name instead of providing a lambda expression that implements the method. Method reference simplifies the syntax of lambda expressions and makes your code more concise and readable.

There are four types of method references in Java 8:

Reference to a static method of a class:
```java
ClassName::staticMethodName
```
Reference to an instance method of an object of a particular class:
```java
objectName::instanceMethodName
```
Reference to an instance method of an arbitrary object of a particular type:
```java
ClassName::instanceMethodName
```
Reference to a constructor of a class:
```java
ClassName::new
```

## 19. What does the String::ValueOf expression mean?

*String::valueOf*  is a method reference that refers to the static method valueOf in the String class. This method takes an argument of any primitive data type or an object and returns its string representation.

```java
List<Integer> numbers = Arrays.asList(1, 2, 3);
List<String> strings = numbers.stream()
                              .map(String::valueOf) // convert Integer to String using method reference
                              .collect(Collectors.toList());

```
## 20. What are Intermediate and Terminal operations?

**Intermediate operations:** These operations are applied to a stream and produce a new stream as a result. They are typically used for filtering, mapping, and transforming the elements of a stream. Intermediate operations are not executed until a terminal operation is invoked on the stream.

Some examples of intermediate operations include filter(), map(), flatMap(), distinct(), sorted(), peek(), and limit().

**Terminal operations:** These operations are applied to a stream and produce a non-stream result, such as a value or a collection. They are typically used for reducing, collecting, and iterating over the elements of a stream. Terminal operations trigger the evaluation of all intermediate operations and cannot be followed by additional stream operations.

Some examples of terminal operations include forEach(), toArray(), reduce(), collect(), count(), min(), max(), and anyMatch().
```java
List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
int sum = numbers.stream()
                 .filter(n -> n % 2 == 0) // intermediate operation
                 .mapToInt(Integer::intValue) // intermediate operation
                 .sum(); // terminal operation
```
## 21. What are the most commonly used Intermediate operations?

**filter(Predicate<T> predicate):** Returns a stream that contains only the elements that match the given predicate.

**map(Function<T, R> mapper):** Returns a stream consisting of the results of applying the given function to the elements of the stream.

**flatMap(Function<T, Stream<R>> mapper):** Returns a stream consisting of the results of replacing each element of this stream with the contents of a mapped stream produced by applying the provided mapping function.

**distinct():** Returns a stream that contains only distinct elements.

**sorted():** Returns a stream sorted according to the natural order of its elements.

**peek(Consumer<T> action):** Returns a stream consisting of the elements of this stream, additionally performing the provided action on each element as elements are consumed from the resulting stream.

**limit(long maxSize):** Returns a stream that is truncated to be no longer than maxSize in length.

**skip(long n):** Returns a stream that skips the first n elements.

## 22. What is the difference between findFirst() and findAny()?

**findFirst():** Returns the first element in the stream that matches the given predicate, if any. If the stream is empty, an empty Optional is returned.

**findAny():** Returns any element in the stream that matches the given predicate, if any. If the stream is empty, an empty Optional is returned.

## 23. How are Collections different from Stream?

**Collections:** A collection is an object that represents a group of elements. It is a data structure that stores elements and provides methods for accessing, adding, removing, and manipulating those elements. Collections are usually used to store and manage data in memory, and they provide a wide range of operations for working with data, such as sorting, searching, filtering, and more.

**Streams:** A stream is a sequence of elements that supports data processing operations. It is an abstraction that allows you to process data in a declarative way, without explicitly iterating over elements. Streams are usually used to process data in a functional and efficient way, and they provide a wide range of intermediate and terminal operations for transforming, filtering, aggregating, and more.

**The main differences between Collections and Streams are:**

1, Mutability: Collections are mutable, which means that you can add, remove, or modify elements in a collection. Streams are immutable, which means that you cannot modify the elements in a stream.

2, Laziness: Collections are eager, which means that they evaluate all the elements when they are created. Streams are lazy, which means that they only evaluate the elements when they are consumed by a terminal operation.

3, Ordering: Collections have a defined order, which means that you can access and process the elements in a specific order. Streams may or may not have a defined order, which means that the elements can be processed in any order.

4, Size: Collections have a fixed size, which means that you can get the number of elements in a collection. Streams may or may not have a fixed size, which means that the size of a stream can be infinite or unknown.

