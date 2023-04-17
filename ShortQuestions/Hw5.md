# Homework 5
## 1. What is generic in Java? 
Generic means an parameteried types which can be any class. Using generic, it is possible to create classes that can work on differet classes.

### Generic class
generic class that contains declares a generic type. `public class<T> {}`

### Generic method
Can pass a generic type to a method `<T extends ?> void func()`
See []().

## 2.
See []().

## 3.
See []().

## 4. 
See []().

## 5. Write the Singleton design pattern include eager load and lazy load. 
### Eager load
```
public class EagerSingleton {
  private staic EagerSingleton eagerSingleton = new EagerSingleton();
  private EagerSingleton(){}
  
  public EagerSingleton getInstance() { return eagerSingleton; }
}
```
### Lazy load
```
public class LazySingleton {
  private staic LazySingleton lazySingleton = null;
  private EagerSingleton(){}
  
  public EagerSingleton getInstance() { 
    if (lazySingleton == null) {
      syhcronized(LazySingleton.class) {
        if (lazySingleton == null) {
          lazySingleton = new LazySingleton();
        }
      }
    }
    return lazySingleton
  }
}
```

## 6. What is Runtime Exception? could you give me some examples?
Runtime exceptions is the super class of exceptions that can be thrown during the normal operation of JVM. E.g. nullpointer exception, IndexOutOfBoundsException

## 7. Could you give me one example of NullPointerException?
Accessing a null pointer properties.

## 8. What is the Optional class?
A container object that may or may not contain a non-null value.

## 9. What are the advantages of using the Optional class?
1. Significantly reduce the if else clause and make code more elegant.
2. Reduce null checks. 
3. Avoidance of nullpointerexception and makes the handling null values explicitly.

## 10. What is the @FunctionalInterface?
Indicates the modified interface has only one abstract method. If an interface declares an abstract method that overriding one of the public methods of java.lang.object, that also does't count to the interface's abstract method count.

Instance of functional interfaces can be created with lambda expressions, method reference.

## 11. what is lamda?
It is a new feature introduced in Java8. The Lambda expression is used to provide the implementation of an interface which is functional interface. 

## 12. What is Method Reference?
Method reference allows us to refer to a method without invoking. It is a cleaner way to write lambda expression. Or, method reference is a compact easy-to-read lambda
expressions for methods that already have a name.

## 13. What are Java 8 new features?
1. default method and abstract method in interface;
2. Stream API;
3. Optional class;
4. Lambda expression;
5. Method reference.


## 14. Lambda can use unchanged variable outside of lambda? what is the details?
Yes. But it requires the variable outside of lambda to be final or address unchanged.

## 15. Describe the newly added features in Java 8?
1. default method and abstract method in interface:Methods modified by default or static can be implemented in interface, allowing default method to be declared in interface makes extending interface easy and without having to changed
a lot; static method helps avoiding undesired results in case of poor implementation.
2. Stream API: An api for processing collections of data, without changeing the source.
3. Optional class: A container object that may or may not contain a non-null value that helps on handle null values.
4. Lambda expression: provide the implementation of an interface which is functional interface. 
5. Method reference: a cleaner way of lambda expression, by calling `ClassName::Method`.

## 16. Can a functional interface extend/inherit another interface?
Yes. But can only implement another interface when it doesn't have abstract methods.

## 17. What is the lambda expression in Java and How does a lambda expression relate to a functional interface?
Lambda expression is, essentially, an anonymous or unnamed method. The lambda expression does not execute on its own. It always passes in as a parameter.
Lambda expression is a way to implement a functional interface.

## 18. In Java 8, what is Method Reference?
Method reference allows us to refer to a method without invoking. It is a cleaner way to write lambda expression. Or, method reference is a compact easy-to-read lambda
expressions for methods that already have a name.

## 19. What does the String::ValueOf expression mean?
It is a method reference call. ValueOf is a static method of String. It means that it will return string format of the primitive object.

## 20. What are Intermediate and Terminal operations?
Intermediate operations are used in Stream process which takes in a stream, then process on the element and return a stream. 
Functions include filter, map, flatmap, sorted, limit.

Terminal functions are also used in Stream process which takes in a stream but return in a wanted class.
Functions include forEach, allMatch, anyMatch, count, findFirst, max, min, collect.

## 21. What are the most commonly used Intermediate operations?
filter, map, flatmap, sorted, limit, skip, distinct.

## 22. What is the difference between findFirst() and findAny()?
findFirst will return the first element that match.

findAnt() will returns any element that match. No guarantee on which element will be returned.

## 23. How are Collections different from Stream?
Collections: data structure to store data

Stream: doesn't store data but process on data. It doesn't change the source and return a new stream each time; it delays operation and only execute when it comes to the result.
