# 1. What is t01_bacis_generic in Java? and type the t01_bacis_generic code by yourself. 
Please check in `Coding/t01_bacis_generic`

# 2. Read those codes and type it one by one by yourself. the push the code to your branch.
Please check in `Coding/t06_java8/src/main/java/features`

# 3. practice stream API at least 3 times.
Please check in `MavenProject/stream-api-exercises/src/test/java/space/gavinklfong/demo/streamapi/StreamApiTest_self.java`

# 4. Practice Optional methods at least 2 times. 
Please check in `Coding/t06_java8/src/main/java/exercise/ShoppingCartUtil.java`

# 5. Write the Singleton design pattern include eager load and lazy load. 
Eager Loading:
```
public class EagerSingleton {

    private static final EagerSingleton instance = new EagerSingleton();

    private EagerSingleton() {
        // Private constructor to prevent instantiation
    }

    public static EagerSingleton getInstance() {
        return instance;
    }
}
```

```
public class LazySingleton {

    private static LazySingleton instance = null;

    private LazySingleton() {
        // Private constructor to prevent instantiation
    }

    public static LazySingleton getInstance() {
        if (instance == null) {
            instance = new LazySingleton();
        }
        return instance;
    }
}
```

# 6. What is Runtime Exception? could you give me some examples? 
A RuntimeException is a type of exception that is not checked at compile-time, but instead is thrown at runtime when the code is executed.
- NullPointerException
- ArrayIndexOutOfBoundsException

# 7. Could you give me one example of NullPointerException? 
```
String str = null;
int length = str.length();
```

# 8. What is the Optional class? 
The Optional class is a container object that may or may not contain a non-null value.
```
Optional<String> optionalString = Optional.of("Hello World");
System.out.println(optionalString.isPresent()); // Output: true
System.out.println(optionalString.get()); // Output: "Hello World"
```
# 9. What are the advantages of using the Optional class? 
- Reduces the risk of `NullPointerExceptions`
- Improves code clarity and readability
- Provides a type-safe alternative to null

# 10. What is the @Functional Interface?
`@Functional Interface` is a Java annotation that is used to indicate that an interface is intended to be a functional interface.
- Has one single Abstract method @FunctionalInterface - for sanity check
- Can have a lot of default methods
- Lambda is the implementation of the abstract method

```
@FunctionalInterface
public interface Bar {

    method String method(String string);    //唯一一个abstract 
    default String defaultBar() {
        String s = "default Bar method";
        System.out.println(s);
        return s;
    }
    default String defaultCommon() {
        String s = "defaultCommon from Bar";
        System.out.println(s);
        return s;
    }
}
```

# 11. what is lamda?
A lambda expression, also known as a lambda function, is a concise way to represent a method or function as an object. 
In Java, lambda expressions were introduced in Java 8 as part of the language's support for functional programming.
```
public void lambdaFoo() {
        Foo foo = parameter -> parameter + " from Foo";
        String hello = foo.aMethod("hello");
        System.out.println(hello);
}
```

# 12. What is Method Reference? 
Method reference is a shorthand syntax in Java that allows you to refer to a method or constructor by its name without invoking it, as if it were a lambda expression.
```
Arrays.sort(stringsArray, String::compareToIgnoreCase);
```

# 13. What is Java 8 new features? 
- Default method and static method in interface
- Lambda & Functional Interface
- Method Reference
- Optional class
- Stream API

# 14. Lambda can use unchanged variable outside of lambda? what is the details? 
As long as the memory address of the variable remains unchanged, the variable can be used by a lambda expression.
- Final variable
- Non-final variable however never changed
- Object variable (if we use new to reassign a new memory, then this variable is changed, can not be used in lambda)

# 15. Describe the newly added features in Java 8? 
- Default method and static method in interface： 
- Lambda & Functional Interface
- Method Reference
- Optional class
- Stream API

# 16. Can a functional interface extend/inherit another interface? 
Yes, a functional interface can extend or inherit another interface. 
This allows the functional interface to inherit any default methods or constants defined by the superinterface, while still maintaining its functional nature.

# 17. What is the lambda expression in Java and How does a lambda expression relate to a functional interface? 
- A lambda expression in Java is a concise way to represent a function or method as an object. It allows us to write code that is more functional and expressive, by separating the behavior of a program from the control flow.

- Because Functional Interface needs the following elements:  
  - Functional Interface 
  - Has one single Abstract method @FunctionalInterface - for sanity check 
  - Can have a lot of default methods 
  - Lambda is the implementation of the abstract method

# 18. In Java 8, what is Method Reference? 
Method reference is a shorthand syntax in Java that allows you to refer to a method or constructor by its name without invoking it, as if it were a lambda expression.
```
Arrays.sort(stringsArray, String::compareToIgnoreCase);
```

# 19. What does the String::ValueOf expression mean? 
`String::valueOf` is a method reference in Java that refers to the `valueOf` method of the String class.

# 20. What are Intermediate and Terminal operations?
In Java 8 Streams, intermediate and terminal operations are the two types of operations that can be performed on a stream.
```
List<String> names = Arrays.asList("John", "Jane", "Bob", "Alice", "Mary");

// Intermediate operations
Stream<String> stream1 = names.stream().filter(s -> s.startsWith("J")).sorted();

// Terminal operation
long count = stream1.count();

System.out.println(count); // Output: 2

// Intermediate and terminal operations combined
List<String> newList = names.stream().filter(s -> s.length() > 3).map(String::toUpperCase).collect(Collectors.toList());

System.out.println(newList); // Output: [JOHN, JANE, ALICE]

```

# 21. What are the most commonly used Intermediate operations? 
- map(): This operation applies a function to each element of the stream, and returns a new stream of the transformed elements.

- filter(): This operation selects elements from the stream that match a given predicate, and returns a new stream of the matching elements.

- flatMap(): This operation applies a function to each element of the stream that returns a stream of elements, and then flattens the resulting streams into a single stream.

- distinct(): This operation removes duplicate elements from the stream, and returns a new stream of the unique elements.

- sorted(): This operation sorts the elements of the stream, either using the natural ordering of the elements or a custom comparator.

- peek(): This operation applies a consumer to each element of the stream, and returns a new stream of the same elements.

- limit(): This operation returns a stream containing a maximum number of elements.

- skip(): This operation returns a stream that skips the first n elements of the original stream.

# 22. What is the difference between findFirst() and findAny()?
- `findFirst()` returns the first element in the stream that matches the given predicate, if any
- `findAny()` returns any element in the stream that matches the given predicate, if any.

# 23. How are Collections different from Stream?
- Collections are data structures that hold a fixed number of elements, and allow you to add, remove, and access those elements using specific methods.
- Streams are a way of processing a potentially large or infinite set of data, and are used for transforming, filtering, and aggregating data in a functional and declarative way. 
Streams are not data structures themselves, but rather represent a sequence of elements that can be processed one by one.