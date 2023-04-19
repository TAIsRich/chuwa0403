# 1. What is generic in Java? and type the generic code by yourself.
# 2. Read those codes and type it one by one by yourself. the push the code to your branch.
# 3. practice stream API at least 3 times.
# 4. Practice Optional methods at least 2 times.
# 5. Write the Singleton design pattern include eager load and lazy load.
Here is an example of `eager load`
```
public class Singleton {

    private Singleton() {}

    private static Singleton instance = new Singleton();

    public static Singleton getInstance() {
        return instance;
    }
}
```
Here is an example of `lazy load`
```
public class Singleton {

    private Singleton() {}

    private static Singleton instance;

    public static synchronized Singleton getInstance() {
        if(instance == null) {
            instance = new Singleton();
        }
        return instance;
    }
}
```
# 6. What is RuntimeException? could you give me some examples?
RuntimeException is an unchecked exception, meaning that it doesn't have to be declared in a method or a constructor's throws clause. The occurrence of RuntimeExceptions usually indicates a problem with the logic of the program, such as a division by zero, a null pointer reference, or an array index out of bounds.

Here are some examples pf RuntimeException:
- NullPointerException 
- ArithmeticException 
- ArrayIndexOutOfBoundsException 
- ClassCastException 
- IllegalArgumentException 
- NumberFormatException 
- ConcurrentModificationException 
- OutOfMemoryError 
# 7. Could you give me one example of NullPointerException?
Here is an example:
```
String str = null;
System.out.println(str.length());
```
# 8. What is the Optional class?
The Optional class in Java is a container object that may or may not contain a non-null value. It is used to avoid null pointer exceptions when working with objects that may or may not be null.
# 9. What are the advantages of using the Optional class?
-`Avoiding null pointer exceptions`: The Optional class allows us to handle null values without explicitly checking for null pointers, which can make code cleaner and more concise.

-`Improved readability`: By using the Optional class, we can make our code more expressive and easier to read by explicitly stating whether a value is expected to be present or absent.

-`Safer handling of null values`: Optional provides a way to safely handle null values by providing methods to check if a value is present and to perform actions conditionally based on its presence or absence.

-`Encourages better design`: Using Optional can help developers design their code to be more modular and encapsulated by forcing them to think about the nullability of objects and their dependencies.

-`Compatible with streams`: Optional can be used in conjunction with streams to enable safe and concise transformations of values, making it easier to write functional-style code.
# 10. What is the @FunctionalInterface?
A functional interface is an interface that contains exactly one abstract method, and can be used as the basis for a lambda expression or method reference. @FunctionalInterface is mainly used for compilation-level error checking. With this annotation, when the interface you write does not conform to the definition of a functional interface, the compiler will report an error.
# 11. what is lamda?
Lambda expression is the syntax for implementing SAM interfaces. SAM (Single Abstract Method), there is only one abstract method in this interface, and the interface can also contain non-abstract methods. Static methods and default methods have been added in JDK 8.
# 12. What is Method Reference?
A method reference is used to directly access an existing method or constructor of a class or instance. Method references provide a way to reference, without executing methods, that require a target type context composed of a compatible functional interface. When evaluated, a method reference creates an instance of the functional interface.
# 13. What is Java 8 new features?
Here are Java 8 new features:
-`Lambda expressions`
-`Method references`
-`Optional class`
-`Stream API`
-`Default methods`
-`Date and Time API`
-`Nashorn JavaScript engine`
-`Parallel array processing`
# 14. Lambda can use unchanged variable outside of lambda? what is the details?
Lambda expressions in Java can access variables from the enclosing scope, provided that those variables are effectively final. An effectively final variable is one that is not assigned a new value after it is initialized.
# 15. Describe the newly added features in Java 8?
Here are Java 8 new features:
-`Lambda expressions`
-`Method references`
-`Optional class`
-`Stream API`
-`Default methods`
-`Date and Time API`
-`Nashorn JavaScript engine`
-`Parallel array processing`
# 16. Can a functional interface extend/inherit another interface?
Yes, a functional interface in Java can extend another interface, as long as the other interface has only one abstract method. When a functional interface extends another interface, it inherits its abstract method, and any class that implements the functional interface must implement both the inherited method and the method defined in the functional interface itself.
# 17. What is the lambda expression in Java and How does a lambda expression related to a functional interface?
Lambda expression is the syntax for implementing SAM interfaces. SAM (Single Abstract Method), there is only one abstract method in this interface, and the interface can also contain non-abstract methods. Static methods and default methods have been added in JDK 8.

Lambda is the implementation of the single abstract method (functional interface).
# 18. In Java 8, what is Method Reference?
A method reference is used to directly access an existing method or constructor of a class or instance. Method references provide a way to reference, without executing methods, that require a target type context composed of a compatible functional interface. When evaluated, a method reference creates an instance of the functional interface.
# 19. What does the String::ValueOf expression mean?
It's a method reference. It refers to the static valueOf method in the String class. This method is used to convert different types of values, including primitive types and objects, into a string representation.
# 20. What are Intermediate and Terminal operations?
`Intermediate Operations` Transform a stream into another stream, and can be chained together to form a pipeline of operations.
`Terminal operations` It doesn't produce any final result or side effect, but instead create a new stream that can be further operated upon. 
# 21. What are the most commonly used Intermediate operations?
Some examples of intermediate operations are `filter`, `map`, `flatMap`, `distinct`, and `sorted`.
# 22. What is the difference between findFirst() and findAny()?
`findFirst()` method returns the first element of the stream. If the stream is empty, it returns an empty optional. If the stream has a defined encounter order, such as a list or an array, it returns the first element in that order. 

`findAny()` method returns any element of the stream. If the stream is empty, it returns an empty optional. If the stream has no defined encounter order, such as a set or a parallel stream, it returns any element from the stream. 
# 23. How are Collections different from Stream?
`Collections` is an operation on a collection of elements, which itself is a collection. 

`Stream` is a function model of collection elements. It is neither a collection nor a data structure. It does not store any elements. It can perform step operations on elements, which is a processing scheme for collection elements.