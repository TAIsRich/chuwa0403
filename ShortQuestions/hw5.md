# hw 23
1. Generic
Generic allows type to be a parameter to methods, classes and interfaces. Much like the more familiar formal parameters used in method declarations, type parameters provide a way to re-use the same code with different inputs.

see [Generic](/Coding/MavenProject/src/main/java/hw5/generic/)

2. see [features](/Coding/MavenProject/src/main/java/hw5/feature/)

3. see [Stream](/Coding/MavenProject/src/main/java/hw5/stream_exercise/)

4. see [Optional](/Coding/MavenProject/src/main/java/hw5/feature_exercise/)

5. Singleton
    - Eager load
```
class SingletonEager{
    // private static variable
    private static SingletonEager instance = new SingletonEager();

    // private constructor: avoid creating new instance
    private SingletonEager(){}

    // static get Instance method: without create instance of the object
    public static SingletonEager getInstance(){
        return instance;
    }
}
```
    - Lazy load
```
class SingletonLazy{

    // private static variable
    private static SingletonLazy instance;

    // private constructor: avoid creating new instance
    private SingletonLazy(){}

    // double check locking
    public static SingletonLazy getInstance(){
        // if not null, not need to wait
        if(instance == null){
            synchronized(SingletonLazy.class){
                if(instance == null){
                    instance = new SingletonLazy();
                }
            }
        }
        return instance;
    }

}
```

6. Runtime Exception is an error that occurs during the execution of program at runtime. This can cause a program to crash or behave in unexpected way. For example:
- NullPointerException, this occurs when a program tries to access an object or variable that is null or has not been initialized.
- ArrayIndexOutOfBoundsException: this occurs when a program tries to access an array element that is outside the bounds of the array.

7. NullPointerException
```
User user = null;
System.out.println(user.getName());
```
In this example, we are trying to get the name of user. However, the User variable is not been initialized and it is null, which means it does not refer to any object.

8. Optional
Optional class in Java is a container that can hold one value and gracefully deals with null values. The main purpose of Optional class is to prevent `NullPointerExceptions` that might occur when dealing with some values. For the example above, we could turn it to be:
```
Optional<User> optional = Optional.ofNullable(user);
optional.ifPresent(System.out::println);
```
Then if the object is null, the print command will not be executed.

9. Advantages of using the Optional class
    - Avoiding null pointer exception: it forces the developer to handle the possibility of a null value explicity, making the code safer and robust.
    - improved the readability and maintainability, and provide better API design.
    - encourage good programming practices, avoid using null values as a return value

10. @FunctionalInter: It is an annotation in Java mains that this interface is a functional interface. It only contains one abstract method and can be used as the basis of a lambda expression or method reference.

11. Lambda: it is a short way to express a behavior or funcionality that can be passed around as a parameter to a method or sotred as a variable. It consists of three parts: parameter list, the arrow operator and the body.

12. Method Reference: it is a shorthand notation for expressing a lambda expressiong that simply calls a single method. If we only call the method in lambda, we chan replace it by method reference. 

13. Java 8 new features: 
    - **Default and static method of interface**: Interfaces can now have default methods that provide a default implementation of a method.
    - **Optional**: provide a way to represent a value that may or may not be present. This helps to avoid null pointer exceptions and improve code clarity
    - **Stream API**: provides a way to process collections of data in a functional style.
    - **Functional Interface**: an interface that has a single abstract method. These interfaces can be used with lambda expressions and method references.
    - **Lambda expression**: provide a concise way to represent an anonymous function that can be passed around as a parameter to a method or stored as a variable.
    - **Method Reference**:  Method references provide a shorthand notation for expressing a lambda expression that simply calls a single method. 
    - Date and Time API

14. Lambda can use unchanged variable outside of lambda. It can use final variable, non-final variables that aren't changed before and after lambda expression and object variable that are not be reassigned.

15. see 13

16. Functional Interface can extend or inherit another interface just like a regular interface in Java. However the child interface must still have only one abstract method. 

17. Lambda: it is a short way to express a behavior or funcionality that can be passed around as a parameter to a method or sotred as a variable. A lambda expression can be thought of as a concise way to create an instance of a functional interface.

18. see 12

19. `String::valueOf` is a method reference in Java that refers to the `valueOf` method of the String class. It is a static method that return a string representation of the argument. As a method reference, it can be used in place of a lambda expression that take the argument and returns a string.

20. Theses are operations in Stream API and are used to process the data elements. Imtermediate operations are applied to a stream and return a new stream as the result. They are used to perform data processing operations, such as filtering, mapping or sorting. They usually do not acturally produce a final result or side-effect, but instead prepare the data for futher processing. THey are only evaluated when a terminal operation is performed. Terminal operations produce a final result or side-effect. They are used to perform actions on the lements of a stream, such as counting, reducing or collecting. They are evaluated immediately and trigger the evaluation of all the previous intermediate operations.

21. filter, map, flatMap, distinct, sorted, limit, skip, peek

22. findFirst() will return the first element of the stream while findAny() will not guarantee which one would be chose.

23. Collections VS Stream:
    - Purpose: Collections are sued to store and manage a group of objects, while stream are used to perform operations on collections of data. 
    - Data storage: Collections store data in memory, while streams do not store data in memory but instead process it on the fly as it is needed. Collections can be accessed by index, while streams cannot.
    