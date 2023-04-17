# hw5

## 1. What is generic in Java? and type the generic code by yourself.
Generics means parameterized types. The idea is to allow type (`Integer`, `String`, … etc., and user-defined types) to be a parameter to methods, classes, and interfaces. Using Generics, it is possible to create classes that work with different data types. An entity such as class, interface, or method that operates on a parameterized type is a generic entity.  
Code is typed in `Coding/generic`

## 2. Read those codes and type it one by one by yourself. the push the code to your branch.
Code is typed in `chuwa-eij-tutorial`

## 3. practice stream API at least 3 times
Code in `streamApiPractice/src/test/java/space/gavinklfong/demo/streamapi/StreamApiTest.java`

## 4. Practice Optional methods at least 2 times
Code in `chuwa-eij-tutorial/02-java-core/src/main/java/com/chuwa/tutorial/t06_java8/exercise/ShoppingCartUtil.java`

## 5. Write the Singleton design pattern include eager load and lazy load.
Code is in `Coding/singleton`

## 6. What is Runtime Exception? could you give me some examples?
Runtime exceptions happen during the execution of the program. Unlike checked exceptions, runtime exceptions are not known to the compiler during compiling time.  
Examples: `NullPointerException`; `ArithmeticException`; `ArrayIndexOutOfBoundsException`

## 7. Could you give me one example of NullPointerException?
NullPointerException occurs when trying to use a null reference object, meaning that the object has not been initialized.
```
String str = null;
System.out.println(str.length()); 
```

## 8. What is the Optional class?
It is a new feature of Java 8. It helps to git rid of `NullPointerException`. It can deal with null value gracefully instead of just throwing an exception

## 9. What are the advantages of using the Optional class?
1. Avoiding NullPointerExceptions: The `Optional` class offers to handle null values without throwing `NullPointerExceptions`
2. More readable code: Using `Optional` can make the code easier to read by avoiding repeatedly using `if-else` statements to perform null checks.

## 10. What is the @FunctionalInterface?
`@FunctionalInterface` is an annotation used to indicate that an interface is a functional interface. When using it, `@FunctionalInterface` annotation, the Java compiler will force that it has only one abstract method.

## 11. What is Lambda?
It's a new feature of Java8. It's a short block of code that takes input and returns a value.  
It can be used to replace anonymous inner class  
We use it to implement functional interface in a clean, one-line style, make code easier to read and write.

## 12. What is Method Reference?
Method references are a special type of lambda expressions. They're often used to create simple lambda expressions by referencing existing methods, like static methods, constructor, instance methods for example.

## 13. What is Java 8 new features?
- Lambda expression
- Functional interface
- Stream API
- Method reference
- Optional class
- Metaspace

## 14. Lambda can use unchanged variable outside of lambda? what are the details?
A variable used in Lambda expression should be final or effectively final.
- Final means that the value of the variable would never be changed. If it is a reference variable, it means that it would never be referenced. 
```
final int x = 10;
Runnable r = () -> System.out.println(x);
```
- Effectively final mean that a variable is not final but its value is never changed after it is assigned. This allows the compiler to treat it as if it were final, even if it is not explicitly declared as such.
```aidl
int x = 10;
Runnable r = () -> System.out.println(x);
```
- For reference variable, Lambda will not be valid if we re-reference it, but if we change its internal state using some methods like setter, no error will be caused
```
List<Integer> myList = new ArrayList<>();
IntConsumer addToList = myList::add;

// Using the lambda expression to add elements to the list
IntStream.range(0, 10).forEach(addToList);

// Changing the state of the captured variable inside the lambda expression
addToList.accept(10);

// The changes are reflected outside the lambda expression as well
System.out.println(myList); // prints [0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10]
```

## 15. Describe the newly added features in Java 8?
- Lambda expression : Used to replace the anonymous inner class; Implemented with functional interface
- Functional interface : Interface that has only one abstract method, but it can have default or static methods which do have method body
- Stream API : Used to process a collection of objects. It's a sequence of objects that supports various methods which can be pipelined to produce the desired result 
- Method reference : Method references are a special type of lambda expressions. They're often used to create simple lambda expressions by referencing existing methods, like static methods, constructor, instance methods for example.
- Optional class : A way to get rid of `NullPointerException`
- Metaspace : A way to replace PermGen. Metaspace is designed to auto-increase, so that JVM doesn't have to frequently perform GC on it as what it had to do when using PermGen

## 16. Can a functional interface extend/inherit another interface?
A functional interface can extends another interface only when it does not have any abstract method

## 17. What is the lambda expression in Java and How does a lambda expression relate to a functional interface?
It's a new feature of Java8. It's a short block of code that takes input and returns a value.  
It can be used to replace anonymous inner class  
We use it to implement functional interface in a clean, one-line style, make code easier to read and write.
```aidl
@FunctionalInterface
interface MyInterface {
    void doSomething();
}

```
```aidl
MyInterface myLambda = () -> {
    System.out.println("Hello, world!");
};
```

## 18. In Java 8, what is Method Reference?
Method references are a special type of lambda expressions. They're often used to create simple lambda expressions by referencing existing methods, like static methods, constructor, instance methods for example.

## 19. What does the String::ValueOf expression mean?
`String::valueOf` is a method reference that is used to create a lambda expression converting an object to its string representation  
```aidl
Object obj = // some object
Function<Object, String> func = String::valueOf;
String str = func.apply(obj);
```

## 20. What are Intermediate and Terminal operations?
- Intermediate Operations: are the operations like map(), filter(), sorted() that can be used in a pipeline style to transform a stream into another stream
- Terminal Operations:are the operations which produce a result or side-effect, such as count() or forEach(Consumer).   
Those operations will terminate the stream, no more operations after this.  
  If there is no termination operation, the stream will be silently declared, it won’t be run at all.
## 21. What are the most commonly used Intermediate operations?
1. map(): applies a function to each element in a stream and returns a new stream with the transformed values.  
In short, it converts a stream into another stream

2. filter():returns a new stream containing only the elements that satisfy a given condition.

3. sorted(): sorts the elements based on a given sorting.

4. distinct(): returns a new stream with only the distinct elements.

5. flatMap(): applies a function to each element in a stream and returns a new stream by flattening the resulting streams.

6. limit(): returns a new stream containing only the first n elements of the original stream.

7. skip(): returns a new stream that skips the first n elements of the original stream.
8. 
## 22. What is the difference between findFirst() and findAny()?
- `findFirst()`: returns the first element in the stream that matches the given condition. For parallel stream, `findFirst()` will return the first element found in the encounter order, which is the order in which the elements were added to the stream
- `findAny()`:  returns any element in the stream that matches the given condition. If the stream is parallel, `findAny()` will return any element found, without guaranteeing any specific order.  

In a sequential stream, both methods will behave similarly and return the same result. However, in a parallel stream, findFirst() may need to traverse the entire stream in order to find the first element that matches the condition, while findAny() can return any element that matches the condition, regardless of its position in the stream.

## 23. How are Collections different from Stream?
- Data Structure: Collection is a data structure that groups objects of some type, Stream is a sequence of elements that can be processed on demand.
- Immutability: Collections are generally mutable, meaning that elements can be added or removed from them. Streams are immutable, meaning that once a stream is created, it cannot be modified. Instead, transformations and operations can be performed on a stream to create a new stream.
- Lazy Evaluation: Streams use lazy evaluation, which means that they only process elements when they are required by a terminal operation. Collections, on the other hand, do not use lazy evaluation and process all the elements in the collection when they are accessed.
