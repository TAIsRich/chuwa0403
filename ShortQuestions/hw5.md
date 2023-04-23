### 1. What is generic in Java? and type the generic code by yourself. a. https://github.com/TAIsRich/chuwa-eij-tutorial/tree/main/02-java-core/src/main/java/com/chuwa/tutorial/t01_basic/generic
Generic in Java is a feature that allows programs to define different types of objects in classes and methods without specifying the type in advance.
Please check Coding/hw5.

### 2. Read those codes and type it one by one by yourself. the push the code to your branch. https://github.com/TAIsRich/chuwa-eij-tutorial/tree/main/02-java-core/src/main/java/com/chuwa/tutorial/t06_java8
Please check Coding/hw5.

### 3. practice stream API at least 3 times a. https://blog.devgenius.io/15-practical-exercises-help-you-master-javastream-api-3f9c86b1cf82
Please check Coding/hw5.

### 4. Practice Optional methods at least 2 times a. https://github.com/TAIsRich/chuwa-eij-tutorial/blob/main/02-java-core/src/main/java/com/chuwa/tutorial/t06_java8/exercise/ShoppingCartUtil.java
Please check Coding/hw5.

### 5. Write the Singleton design pattern include eager load and lazy load.
Eager Load:
```
public class Singleton {
   private static final Singleton instance = new Singleton();  
   private Singleton() {}  
   public static Singleton getInstance() {
      return instance;
   }
}
```
Lazy load:
```
public class Singleton {
   private static Singleton instance;
   private Singleton() {}
   public static synchronized Singleton getInstance() {
      if(instance == null) {
         instance = new Singleton();
      }
      return instance;
   }
}
```

### 6. What is Runtime Exception? could you give me some examples?
A runtime exception is an exception that occurs at runtime and doesn't require explicit handle of it. Examples:
IndexOutOfBoundsException: occurs when an index is out of bounds of an array or a collection.
NullPointerException: occurs when the program tries to access an object whose value is null.
IllegalArgumentException: occurs when an illegal argument is passed to a method.
ArithmeticException: occurs when an arithmetic operation results in an undefined or infinite value.

### 7. Could you give me one example of NullPointerException?
```
public class NullPointerExceptionDemo {
    public static void main(String[] args) {
        String str = null;
        int length = str.length(); // NullPointerException occurs here
        System.out.println(length);
    }
}
```

### 8. What is the Optional class?
The Optional is a container object that may or may not contain a non-null value. It provides methods to safely access the contained value while avoiding frequently NullPointerExceptions checks when working with null values. These are the methods of Optional Class we should know:
of: Create an Optional object containing the given non-null value.
ofNullable: Create an Optional object containing the specified value if it is not null, an empty Optional if the value is null.
empty(): Creates an empty Optional.
isPresent(): Return true if the Optional contains a value, false otherwise.
ifPresent(Consumer<? super T> action): Executes ... if a value is present.
orElse: Returns the contained value if present, or the default value otherwise.

### 9. What are the advantages of using the Optional class?
1.Avoid NullPointerExceptions: Since Optional can contain null, we can avoid frequent null checks and NullPointerExceptions.
2.Improve readability: Make our code more expressive and easier to read.

### 10. What is the @FunctionalInterface?
The @FunctionalInterface annotation is a new feature introduced in Java 8, using to indicate that an interface has only one single abstract method and any numbers of default methods. And lambda expressions and method references can be used here.

### 11. what is lamda?
Lambda expressions, a feature introduced in Java 8, allows us to write compact and functional-style code. It's a easy way to implement functions instead of anonymous inner classes. Lambda expressions can be used within functional interface.

### 12. What is Method Reference?
Method reference, a feature in Java 8, is a shorthand way of writing a lambda expression.
Example:
```
Arrays.sort(stringsArray, (s1, s2) -> s1.compareToIgnoreCase(s2));
Arrays.sort(stringsArray, String::compareToIgnoreCase);
```

### 13. What is Java 8 new features?
1.Lambda expressions
2.Stream API
3.Method references
4.Functional interfaces
5.Default methods
6.Optional class

### 14. Lambda can use unchanged variable outside of lambda? what is the details?
Lambda expressions can use final variables or effectively final (variables is not declared final but whose value can not be changed once it is intialized.

### 15. Describe the newly added features in Java 8?
Lambda expressions: replace anonymous functions and inner class
Method reference: A shorthand notation for lambda expressions
Default methods: Methods that can be defined within an interface
Optional: A container object that may or may not contain a non-null value
Stream API: A way of processing collections of data, allowing operations such as filtering and mapping.

### 16. Can a functional interface extend/inherit another interface?
Yes. This can be useful when we want to build a hierarchy of functional interfaces that share some common behavior. 

### 17. What is the lambda expression in Java and How does a lambda expression relate to a functional interface?
A lambda expression in Java is a new feature to easily writing an anonymous function. It allows you to write functional code in a more concise and expressive way. Lambda expressions are usually used with functional interfaces, because functional interfaces only have one single abstract method.

### 18. In Java 8, what is Method Reference?
Method reference, a feature in Java 8, is a shorthand way of writing a lambda expression.

### 19. What does the String::ValueOf expression mean?
This expression is a method reference which is equivalent to the lambda expression "x -> String.valueOf(x)". The valueOf method takes the x argument, and returns a string representation of x.

### 20. What are Intermediate and Terminal operations?
In Stream API, there are two types of operations that can be performed on a stream: intermediate operations and terminal operations.
Intermediate operations: operations that are applied to a stream and return a new stream, like filter(), limit(), skip(), map(), flatMap(), distinct(), sorted(), etc.
Terminal operations: operations are applied to a stream and produce a non-stream result, like anyMatch(), allMatch(), forEach(), min(), max(), toArray(), reduce(), collect(), count(), etc.

### 21. What are the most commonly used Intermediate operations?
filter: returns elements that satisfy the given Predicate.
limit: returns the first n elements.
skip: skips the first n elements.
map: returns the elements after some operations of the given functions.
distinct: returns distinct elements.
sorted: returns sorted elements.

### 22. What is the difference between findFirst() and findAny()?
findFirst(): Returns the first element in the stream that matches the given conditions, if any. If the stream is empty, an empty Optional is returned.
findAny(): Returns any element in the stream that matches the given conditions, if any. If the stream is empty, an empty Optional is returned.

### 23. How are Collections different from Stream?
Collections: data structures that holds elements and methods to manipulate these elements. 
Streams: A stream is a sequence of elements that supports data processing operations without storing the data themselves. 
