# HW5

## 1. What is generic in Java? and type the generic code by yourself.
Generics means parameterized types. Using Generics, it is possible to create classes that work with different data types

* Generic Method: Generic Java method takes a parameter and returns some value after performing a task.
* Generic Classes: A generic class is implemented exactly like a non-generic class. The only difference is that it contains a type parameter section.

Please see: `MavenProject/tutorial/src/main/java/com/chuwa/t01_generics`

## 2. Read those codes and type it one by one by yourself. the push the code to your branch.
Please see `MavenProject/tutorial/src/main/java/com/chuwa/t06_java8`

## 3. practice stream API at least 3 times
Please see  `MavenProject/stream-api-exercises-main/src/test/java/space/gavinklfong/demo/streamapi`

## 4. Practice Optional methods at least 2 times
Please see `MavenProject/tutorial/src/main/java/com/chuwa/optional_exercise`

## 5. Write the Singleton design pattern include eager load and lazy load
### Lazy

```java
public class Singleton {
    private Singleton() {
    }

    private static class InstanceHolder {
        private static final Singleton INSTANCE = new Singleton();
    }

    public Singleton getInstance() {
        return InstanceHolder.INSTANCE;
    }
}
```

### Eager

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

## 6. What is Runtime Exception? could you give me some examples?

Runtime Exception is a type of exception that can occur at runtime and doesn't need to be explicitly handled by the
program.
For example:

* ArithmeticException
* NullPointerException
* IndexOutOfBoundsException
* IllegalArgumentException

## 7. Could you give me one example of NullPointerException?

This code will occur NullPointerException, and the program will throw it and exit

```java
public class Example {
    public static void main(String[] args) {
        String str = null;
        int length = str.length(); // NullPointerException occurs here
        System.out.println(length);
    }
}
```

## 8. What is the Optional class?

The Optional class is a container object that may or may not contain a non-null value. It was introduced in Java 8 as a
way to reduce the amount of null checks in code and to make it more explicit when a method can return a null value.

```java
import java.util.Optional;

public class Example {
    public static void main(String[] args) {
        Optional<String> optionalName = Optional.of("John");
        String name = optionalName.orElse("Unknown");
    }
}
```

## 9. What are the advantages of using the Optional class?

1. Reduced null checks: When we use the Optional class, we can reduce the number of null checks in our code.
2. Explicit handling of null values: The Optional class makes it clear when a method can return a null value, and forces
   us to explicitly handle the possibility of null values.
3. Avoidance of NullPointerExceptions: we can use the methods provided by the Optional class to handle null values.
4. Improved code readability: make our code more expressive and easier to understand.

## 10. What is the @FunctionalInterface?

The `@FunctionalInterface` annotation is used in Java to indicate that an interface is a functional interface. A
functional interface is an interface that has exactly one abstract method, and is used as the basis for lambda
expressions and method references.

```java

@FunctionalInterface
public interface MyFunction {
    int apply(int x, int y);
}
```

## 11. What is lamda?

Lambda is a feature introduced in Java 8 that allows us to write compact and functional-style code. It's essentially a
way to create anonymous functions – functions without a name that can be passed around as values.

```java
public interface MyFunction {
    int apply(int x, int y);
}

public class Example {
    public static void main(String[] args) {
        MyFunction add = (x, y) -> x + y;
        int result = add.apply(2, 3);
        System.out.println(result);
    }
}
```

## 12. What is Method Reference?

Method reference is another feature introduced in Java 8 that allows us to refer to a method of a class or object
without invoking it. It's essentially a shorthand notation for lambda expressions that can make our code more concise
and readable.

## 13. What is Java 8 new features?

1. Lambda expressions
2. Stream API
3. Default methods
4. Optional
5. Method references

## 14. Lambda can use unchanged variable outside of lambda? what is the details?

Lambda can use:

* Final variable
* Non-final variable however never changed
* Object variable (if we use new to reassign a new memory, then this variable is
  changed, can not be used in lambda)

## 15. Describe the newly added features in Java 8?

1. Lambda expressions: A concise way to represent anonymous functions that can be passed as arguments or stored in
   variables.
2. Stream API: A functional-style API for processing collections of data, allowing operations like filtering, mapping,
   and reducing.
3. Default methods: Methods that can have an implementation in an interface
4. Optional: A container object that may or may not contain a non-null value, providing a safer way to handle null
   values.
5. Method references: A shorthand notation for lambda expressions that allows us to refer to a method of a class or
   object without invoking it.

## 16. Can a functional interface extend/inherit another interface?

No.

```java
public interface Adder {
    int add(int a, int b);
}

public interface SmartAdder extends Adder {
    int add(double a, double b);
}
```

SmartAdder isn’t a functional interface because it specifies two abstract methods

## 17. What is the lambda expression in Java and How does a lambda expression relate to a functional interface?

A lambda expression is a concise way to represent anonymous functions in Java. It allows us to create a function without
having to write a separate class or method, and can be passed around as a value or stored in a variable.
Lambda expressions are closely related to functional interfaces in Java. A functional interface is an interface that has
only one abstract method, and is used as the basis for lambda expressions and method references. When we create a lambda
expression, we are essentially creating an implementation of the single abstract method of a functional interface.

## 18. In Java 8, what is Method Reference?

Method reference is another feature introduced in Java 8 that allows us to refer to a method of a class or object
without invoking it. It's essentially a shorthand notation for lambda expressions that can make our code more concise
and readable.

## 19. What does the String::ValueOf expression mean?

The String::valueOf expression is a method reference in Java that refers to the static method valueOf of the String
class. The valueOf method takes an argument of any primitive or object type, and returns a string representation of that
argument.

## 20. What are Intermediate and Terminal operations?
They are part of stream life cycle
### Intermediate:
operations that transform the stream into another stream or perform some kind of intermediate processing on the elements in the stream.
* filter
* limit
* skip
* distinct
* map
* flatMap
* sorted

### Terminal:
Terminal operations are operations that produce a final result or side-effect, and may cause the stream to be closed.
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

## 21. What are the most commonly used Intermediate operations?
`filter` and `map`

Others:

* filter
* limit
* skip
* distinct
* map
* flatMap
* sorted

## 22. What is the difference between findFirst() and findAny()?
The `findFirst()` method returns the first element in the stream that satisfies the given condition. If the stream is ordered, this will be the first element in the encounter order. If the stream is empty, `Optional.empty()` is returned.

On the other hand, the `findAny()` method returns any element in the stream that satisfies the given condition. There is no guarantee on which element will be returned, and the result may differ between sequential and parallel executions. If the stream is empty, `Optional.empty()` is returned.

## 23. How are Collections different from Stream?
`Collections`: store data

`Stream`: compute but not store data