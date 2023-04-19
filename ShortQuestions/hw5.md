# 1. What is generic in Java?  and type the generic code by yourself
## Generics allow type to be a parameter. Using Generics, it is possible to create methods, classes, and interfaces that work with different data types.
## java files
# 2. Read those codes and type it one by one by yourself. the push the code to your branch.
## java files
# 3. practice stream API at least 3 times
## java files
# 4. Practice Optional methods at least 2 times
## java files
# 5. Write the Singleton design pattern include eager load and lazy load.
## java files
# 6. What is Runtime Exception? could you give me some examples?
## RuntimeException is the superclass of those exceptions that can be thrown during the normal operation of the Java Virtual Machine. RuntimeException and its subclasses are unchecked exceptions.
```
int[] a = new int[] { 1, 2, 3, 4, 5 };
for (int i = 0; i < 6; i++) System.out.println(a[i]);
//OutOfBoundsException, array only have 5 elements
//to fix this:
int[] a = new int[] { 1, 2, 3, 4, 5 };
try {
     for (int i = 0; i < 6; i++) System.out.println(a[i]);
    }
catch (Exception x) {
     system.out.println("runtime exception");
    }
```
# 7. Could you give me one example of NullPointerException?
## When you passing something that is null.
```
User user = null;
getName(user);
```
# 8. What is the Optional class?
## Optional is a container object used to contain not-null objects. Optional object is used to represent null with absent value. This class has various utility methods to facilitate code to handle values as ‘available’ or ‘not available’ instead of checking null values.
# 9. What are the advantages of using the Optional class?
## The Optional class provides useful methods.
# 10. What is the @FunctionalInterface?
## an annotation to ensure our interface is functional only. An informative annotation type used to indicate that an interface type declaration is intended to be a functional interface as defined by the Java Language Specification.
# 11. what is lambda?
## Lambda Expressions were added in Java 8. A lambda expression is a short block of code which takes in parameters and returns a value. Lambda expressions are similar to methods, but they do not need a name and they can be implemented right in the body of a method.
# 12. What is Method Reference?
## We use lambda expressions to create anonymous methods. Sometimes, however, a lambda expression does nothing but call an existing method. In those cases, it's often clearer to refer to the existing method by name. Method references enable you to do this; they are compact, easy-to-read lambda expressions for methods that already have a name.
# 13. What is Java 8 new features?
## forEach() method in Iterable interface
## default and static methods in Interfaces
## Functional Interfaces and Lambda Expressions
## Java Stream API for Bulk Data Operations on Collections
## Java Time API
## Collection API improvements
## Concurrency API improvements
## Java IO improvements
# 14. Lambda can use unchanged variable outside of lambda? what is the details?
## lambda expression can only access local variables from an enclosing scope that are effectively final.
# 15. Describe the newly added features in Java 8?
## A new java.util.stream has been added in Java 8 to perform filter/map/reduce like operations with the collection. Stream API will allow sequential as well as parallel execution. This is one of the best features for me because I work a lot with Collections and usually with Big Data, we need to filter out them based on some conditions.
## Java 8 Optional<T> class can help to handle situations where there is a possibility of getting the NPE. It works as a container for the object of type T. It can return a value of this object if this value is not a null. When the value inside this container is null, it allows doing some predefined actions instead of throwing NPE.
# 16. Can a functional interface extend/inherit another interface?
## A functional interface cannot extend another functional interface. A functional interface can contain any number of Object class methods.
# 17. What is the lambda expression in Java and How does a lambda expression relate to a functional interface?
## A lambda expression is a short block of code which takes in parameters and returns a value. Lambda expressions are similar to methods, but they do not need a name and they can be implemented right in the body of a method.
## Lambda expressions are the couriers via which Java moves around a set of behavior. A functional interface is an interface that has exactly one abstract method.
# 18. In Java 8, what is Method Reference?
## Method reference can be used as a shorter and more readable alternative for a lambda expression that only calls an existing method. There are four variants of method references.
# 19. What does the String::ValueOf expression mean?
## (ClassName::methodName)
## use of method reference, String is a class and ValueOf is a method.
# 20. What are Intermediate and Terminal operations?
## Intermediate operations process the current stream of data (if any) and then return a new stream. Terminal operations as the name suggests are the last in the pipeline of operations performed on a stream.
# 21. What are the most commonly used Intermediate operations?
## filter()
## map()
## flatMap()
## distinct()
## sorted()
## limit()
# 22. What is the difference between findFirst() and findAny()?
## The findAny() method returns any element from a Stream, while the findFirst() method returns the first element in a Stream.
# 23. How are Collections different from Stream?
## Collection is a data structure. A stream is not a data structure. Streams are iterated internally by just mentioning the operations. Collections are iterated externally using loops.