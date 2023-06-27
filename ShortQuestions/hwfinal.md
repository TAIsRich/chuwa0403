# Maven
## 1. What is the lifecycle of maven? could you tell me the details ?
## 2. what is the difference between package and install in maven lifecycle ?

# Linux
## 1. Reading: https://www.yuque.com/fairy-era/yg511q/oeybmv

# Java Core & OOP
## 1. Write up Example code to demonstrate the three foundmental concepts of OOP.(reference Code Demo repo as example)
a. Encapsulation;
b. Polymorphism;
i. Override, Overloading.
c. Inheritance;

check folder Coding/hwfinal/javaoop

## 2. What is Java garbage collection?
Java garbage collection is a mechanism used by the Java Virtual Machine (JVM) to automatically manage memory allocation and deallocation for Java objects. When a Java program creates an object, the JVM allocates memory for that object on the heap. When the object is no longer needed, the memory allocated to it is deallocated and made available for other objects to use.

## 3. What is Runtime/unchecked exception? what is Compile/Checked Exception?
a. also reading： https://www.yuque.com/fairy-era/yg511q/gldkel#b861aad7

Checked exceptions are exceptions that are checked at compile-time. This means that the code must handle them, either by catching them or by declaring that the method throws them. If a checked exception is not handled, the code will not compile.

Here's an example of checked exception.

```java
try {
      BufferedReader br = new BufferedReader(new FileReader("file.txt"));
      String line;
      while ((line = br.readLine()) != null) {
        System.out.println(line);
      }
      br.close();
    } catch (IOException e) {
      System.out.println("An error occurred: " + e.getMessage());
    }
```

Unchecked exceptions, on the other hand, are exceptions that are not checked at compile-time. These exceptions are typically caused by programming errors such as null pointer exceptions, array index out of bounds exceptions, and class cast exceptions.

example:
```java
String str = null;
System.out.println(str.length());
```
## 4. What is the difference between throw and throws?
throw is used to explicitly throw an exception in a program. It is followed by an instance of the Throwable class (or one of its subclasses) that represents the exception being thrown.

throws, on the other hand, is used to declare the exceptions that a method may throw. It is followed by the name of the exception class or classes separated by commas.

## 5. Could you give me one example of NullPointerException?
```java
public class NullPointerExceptionExample {
    public static void main(String[] args) {
        String str = null;
        int length = str.length(); // NullPointerException occurs here
        System.out.println("Length: " + length);
    }
}
```

## 6. how does Java hashmap internally work?
Java's HashMap internally uses an array of linked lists to store key-value pairs. When a key-value pair is added to the HashMap, the hash code of the key is computed, which determines the index of the array where the entry should be stored.

If multiple key-value pairs have the same hash code, they are stored as nodes in a linked list at the corresponding array index. This is known as a bucket. Each node in the linked list contains the key, value, and a reference to the next node in the list.

When we want to retrieve a value associated with a specific key, the hash code of the key is computed again, and the corresponding bucket is located. Then, the linked list in that bucket is traversed to find the node with a matching key. Once the node is found, the associated value can be retrieved.

## 7. Collections：
a. reading: https://www.yuque.com/fairy-era/yg511q/ksp07m#daf18702
i. Not necessary to read how to implement the data structure


## 8. Reading: https://www.yuque.com/fairy-era/yg511q/qzv31t#347111bb
a. ⼀些OA要⽤到IO


# External Libs
## 1. What is Guava? (https://www.tutorialspoint.com/guava/index.htm). No need to learn it. it is good enough to hear about it and know its role.
Guava, also known as Google Guava, is an open-source Java library developed by Google. It provides a set of utility classes and helper functions that complement the Java Standard Library and make Java programming more convenient and efficient.

Guava offers a wide range of features and functionalities, including:

Collections: Guava provides enhanced collections such as immutable collections, multiset, multimap, and biMap, which offer additional capabilities and performance improvements compared to the standard Java collections.

Utilities: Guava includes various utility classes for working with strings, primitives, dates, and other common operations. It provides convenient methods for handling null values, working with files and input/output operations, and manipulating data structures.

Functional programming: Guava incorporates functional programming concepts and provides functional interfaces, predicates, and functions that can be used for expressive and concise code. It also supports functional idioms like function composition and memoization.

Caching: Guava offers a powerful caching framework with features like time-based expiration, size-based eviction, and automatic loading of cache entries. It simplifies the implementation of caching mechanisms and helps improve application performance.

Concurrency: Guava includes utilities for concurrent programming, such as atomic variables, thread-safe collections, and utilities for working with concurrent tasks and synchronization. It provides abstractions for managing concurrent operations and ensures thread safety.

Input validation: Guava provides a comprehensive set of preconditions and validation utilities for validating method arguments and ensuring the correctness of inputs. It helps improve code reliability and makes it easier to write defensive code.

## 2. List and expain some methods from Apache Commons/Collections
a. https://www.baeldung.com/apache-commons-collection-utils)
b. https://developer.aliyun.com/article/896751

Apache Commons Collections is a library that provides additional collection classes, utilities, and extensions to the Java Collections Framework. It offers a wide range of methods to work with collections more effectively. Here are some commonly used methods from Apache Commons Collections:

`CollectionUtils.isEmpty(Collection<?> collection)`: Checks if a collection is null or empty. It returns true if the collection is null or has zero elements.

`CollectionUtils.isNotEmpty(Collection<?> collection)`: Checks if a collection is not null and not empty. It returns true if the collection is not null and has at least one element.

`CollectionUtils.filter(Collection<T> collection, Predicate<? super T> predicate)`: Filters a collection by applying a predicate to each element. It modifies the original collection and retains only the elements that satisfy the predicate.

`CollectionUtils.transform(Collection<T> collection, Transformer<? super T, ? extends R> transformer)`: Transforms a collection by applying a transformer function to each element. It returns a new collection with transformed elements, leaving the original collection unchanged.

`ListUtils.partition(List<T> list, int size)`: Partitions a list into sublists of the specified size. It returns a list of sublists, each containing elements from the original list.

`ArrayUtils.isEmpty(Object[] array)`: Checks if an array is null or empty. It returns true if the array is null or has zero elements.

`MapUtils.isEmpty(Map<?, ?> map)`: Checks if a map is null or empty. It returns true if the map is null or has zero key-value pairs.

`MapUtils.isNotEmpty(Map<?, ?> map)`: Checks if a map is not null and not empty. It returns true if the map is not null and has at least one key-value pair.

`MapUtils.invertMap(Map<?, ?> map)`: Inverts the keys and values of a map. It creates a new map where the keys of the original map become the values and the values become the keys.

`SetUtils.union(Set<?> set1, Set<?> set2)`: Computes the union of two sets. It returns a new set that contains all unique elements from both sets.

## 3. How to convert json format string to java object? and how to convert java object to json string? write some demo codes.
a. ObjectMapper from Jackson which is default in Spring framework.
b. Gson grom google.

```java
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonToObjectDemo {
    public static void main(String[] args) {
        String json = "{\"name\":\"John\",\"age\":30,\"email\":\"john@example.com\"}";

        try {
            ObjectMapper objectMapper = new ObjectMapper();
            Person person = objectMapper.readValue(json, Person.class);
            System.out.println(person);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

class Person {
    private String name;
    private int age;
    private String email;

    // Getters and setters

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", email='" + email + '\'' +
                '}';
    }
}
```
# Java 8
## 1. List Several Java 8 new features and briefly explain them.
Java 8 introduced several new features that made it easier to write cleaner and more efficient code, and expanded the capabilities of the Java language. Some of the key features include:

1. `Lambdas` and `Functional Interfaces`: Java 8 introduced the concept of lambda expressions, which allow developers to write more concise and readable code for functional interfaces. This makes it easier to write functional-style code and to work with Java's new Streams API.

2. `Streams API`: Java 8 introduced the Streams API, which provides a more functional way of working with collections of data. Streams allow you to perform complex operations on collections of data, such as filtering, mapping, and reducing, in a more concise and readable way.

3. `Default` and `Static` Methods in Interfaces: Java 8 introduced the ability to include default and static methods in interfaces, which makes it easier to evolve existing interfaces without breaking existing implementations.

4. `Optional`: Java 8 introduced the Optional class, which provides a more explicit way of handling null values. Optional makes it easier to write more concise and safer code when dealing with potentially null values.

5. `Method References`: Java 8 introduced method references, which allow developers to reference a method as a value, without actually invoking it. This provides a more concise and readable way of passing a method as an argument to a functional interface, instead of using a lambda expression.

6. `Date and Time API`: Java 8 introduced a new Date and Time API, which provides a more robust and efficient way of working with dates and times. The new API makes it easier to perform calculations, format dates, and work with time zones.

7. `Nashorn JavaScript Engine`: Java 8 introduced the Nashorn JavaScript engine, which allows developers to run JavaScript code on the Java Virtual Machine (JVM). This makes it easier to integrate JavaScript code with Java applications.
## 2. practice stream API at least 3 times (vendor ⾯试会给个情景让写stream，⼯作上也会⼤量⽤到。)
a. https://blog.devgenius.io/15-practical-exercises-help-you-master-javastream-api-3f9c86b1cf82


# Multiple Threading
## 1. What is deadlock?
Deadlock is a situation that can occur in a multi-threaded application where two or more threads are blocked and waiting for each other to release the resources they need to proceed. In a deadlock situation, none of the threads can make progress, and the entire application comes to a standstill.

## 2. how to create a new thread(Please also consider Thread Pool case)?
1 extend thread class
2 implement runnable
3 implement callable
4 lambda expression
5 use Executor

## 3. Difference between Runnable and Callable？
Runnable doesn't have return value;

## 4. what is the diff between t.start() and t.run()?
If you want to create a new thread and execute the code in the run() method concurrently with the main thread, you should call the start() method. If you simply want to execute the code in the run() method in the current thread of execution, you can call the run() method directly. However, calling the run() method directly does not provide any concurrency or parallelism, and is typically not what you want to do when working with threads.

## 5. how do threads communicate with each other?
Shared memory: Threads can share data by accessing shared variables or data structures. However, it is important to ensure that the access to shared data is synchronized to prevent race conditions and data inconsistencies.

Message passing: Threads can communicate with each other by sending messages through a communication channel such as a queue or a pipe. The receiving thread can then process the message and respond accordingly.

Signals: Threads can signal each other to indicate the occurrence of an event or the availability of a resource. For example, a thread can signal another thread when a particular task is completed or when a lock is released.

Synchronization constructs: Threads can use synchronization constructs such as semaphores, mutexes, and condition variables to coordinate their activities and prevent conflicts. These constructs can be used to implement various synchronization patterns such as producer-consumer, reader-writer, and barrier synchronization.

## 6. What is Atomic classes? when do we use it?
Atomic classes in Java are a set of thread-safe classes that provide atomic operations on single variables. These classes are useful in multi-threaded programming scenarios where multiple threads access and modify the same variable concurrently.

The atomic classes provide several methods that perform atomic operations such as read-modify-write operations on the variables, and ensure that these operations are executed atomically and thread-safe. The atomic classes also ensure that any changes made to the variables are visible to all threads immediately, without the need for explicit synchronization.

Some examples of atomic classes in Java are AtomicInteger, AtomicLong, and AtomicReference. These classes are typically used in high-concurrency applications, such as web servers, where multiple threads access and modify shared variables frequently.

## 7. What is the cocurrent collections?
The thread-safe version of custom collections

## 8. What is keyword synchronized, how do you understand it?
The synchronized keyword in Java is used to create synchronized blocks and methods to control concurrent access to shared resources or critical sections of code. It ensures that only one thread can access the synchronized block or method at a time, while other threads wait for their turn.

When a method or block is marked as synchronized, it acquires a lock on the object it is synchronized on. This lock allows only one thread to enter the synchronized section at a time, while other threads are blocked until the lock is released.

## 9. what kind of locks you know?
Synchronized blocks/methods: Synchronized blocks and methods use intrinsic locks to ensure that only one thread at a time can execute a synchronized block or method on a given object.

ReentrantLock: ReentrantLock is a more flexible alternative to synchronized blocks, allowing more fine-grained control over locking and unlocking operations. It also supports features such as fairness, which ensures that the lock is granted in a first-come, first-served order.

ReadWriteLock: ReadWriteLock provides a mechanism for controlling access to shared resources that can be read by multiple threads but only written by one thread at a time. It allows multiple threads to read the resource concurrently, but only one thread can hold the write lock at a time.

StampedLock: StampedLock is a new lock introduced in Java 8 that supports optimistic locking, which can be more efficient than traditional locks in certain scenarios. It also supports read and write locks, and provides several modes for controlling access to shared resources.

Semaphore: Semaphore is a concurrency primitive that allows a fixed number of threads to access a shared resource concurrently. It can be used to limit the number of concurrent accesses to a resource, or to ensure that a certain number of resources are available at any given time.

CountDownLatch: CountDownLatch is a synchronization aid that allows one or more threads to wait until a set of operations being performed in other threads completes. It can be used to coordinate the execution of multiple threads or to ensure that certain conditions are met before continuing with the execution of a program.

## 10. What is future and completableFuture?
In Java, a `Future` represents the result of an asynchronous computation. It is a placeholder object that will eventually contain the result of a computation that has been submitted to an ExecutorService.

A `CompletableFuture` is an implementation of the Future interface that provides additional features for working with asynchronous computations. It allows for chaining of multiple asynchronous operations and provides a way to explicitly complete a computation.

One of the key differences between Future and CompletableFuture is that Future is a passive placeholder that can only be queried for the status of the computation and the result, while CompletableFuture is an active object that can be used to control the computation and combine multiple asynchronous operations.

## 11. leetcode for multiple threading (paste your solution code to here)
a. 1114- Print in Order
```java
class Foo {
    static volatile int seq;
    public Foo() {
        seq=0;
    }

    public synchronized void first(Runnable printFirst) throws InterruptedException {
        
        // printFirst.run() outputs "first". Do not change or remove this line.
        printFirst.run();
        notifyAll();
        seq++;
    }

    public synchronized void second(Runnable printSecond) throws InterruptedException {
        while(seq!=1){
            wait();
        }
        // printSecond.run() outputs "second". Do not change or remove this line.
        printSecond.run();
        notifyAll();
        seq++;
    }

    public synchronized void third(Runnable printThird) throws InterruptedException {
        while(seq!=2){
            wait();
        }
        // printThird.run() outputs "third". Do not change or remove this line.
        printThird.run();
        notifyAll();
        seq++;
    }
}
```

b. 1115-Print FooBar Alternately
```java
class FooBar {
    private int n;
    boolean isfoo;
    public FooBar(int n) {
        this.n = n;
        isfoo = true;
    }

    public synchronized void foo(Runnable printFoo) throws InterruptedException {
        
        for (int i = 0; i < n; i++) {
            
        	// printFoo.run() outputs "foo". Do not change or remove this line.
            while(!isfoo){
                wait();
            }
        	printFoo.run();
            isfoo = !isfoo;
            notifyAll();
        }
    }

    public synchronized void bar(Runnable printBar) throws InterruptedException {
        
        for (int i = 0; i < n; i++) {
            while(isfoo){
                wait();
            }
            // printBar.run() outputs "bar". Do not change or remove this line.
        	printBar.run();
            isfoo = !isfoo;
            notifyAll();
        }
    }
}
```

c. 1116-Print Zero Even Odd
```java
class ZeroEvenOdd {
    private int n;
    private volatile int cur;
    private volatile int next;
    
    public ZeroEvenOdd(int n) {
        this.n = n;
        this.cur=1;
        this.next=0;
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void zero(IntConsumer printNumber) throws InterruptedException {
        while(cur<=n){
            synchronized(this){
                while(next!=0){
                    wait();
                }
                if(cur<=n)
                printNumber.accept(0);
                next = cur;
                notifyAll();
            }
        }
        
    }

    public void even(IntConsumer printNumber) throws InterruptedException {
        while(cur<=n){
            synchronized(this){
            while(next==0 || next%2 !=0){
                wait();
            }
            if(next!=0 && next%2==0 && next<=n)
            printNumber.accept(next);
            this.cur+=1;
            next = 0;
            notifyAll();
            }
        }
    }

    public void odd(IntConsumer printNumber) throws InterruptedException {
        while(cur<=n){
            synchronized(this){
            while(next==0 || next%2==0){
                wait();
            }
            if(next%2!=0 && next<=n)
            printNumber.accept(next);
            this.cur+=1;
            next = 0;
            notifyAll();
            }
        }        
    }
}
```


# Database
## 1. what is the difference between RDBMS and NoSQL?
RDBMS (Relational Database Management System) and NoSQL (Not Only SQL) are two different types of database management systems, each with its own characteristics and use cases. Here are the key differences between RDBMS and NoSQL:

`Data Model`:

RDBMS: RDBMS follows a structured data model based on tables, rows, and columns. It enforces a predefined schema where relationships between tables are defined through keys (primary and foreign keys).

NoSQL: NoSQL databases offer a flexible data model that can vary between different database systems. They can be document-based, key-value pairs, columnar, or graph-based. NoSQL databases allow schema-less or schema-flexible data storage, where each record/document can have different structures.

`Scalability`:

RDBMS: RDBMS systems are typically designed for vertical scalability, meaning they can handle a large amount of data on a single server by increasing the server's resources (CPU, RAM, storage). Scaling horizontally (across multiple servers) can be complex and requires advanced techniques such as sharding or replication.

NoSQL: NoSQL databases are built for horizontal scalability. They are designed to scale easily across multiple servers by distributing the data across the cluster. This makes NoSQL databases well-suited for handling large-scale applications with high data volumes and traffic.

`Data Consistency`:

RDBMS: RDBMS systems emphasize strong data consistency, ensuring that data remains in a consistent state at all times. ACID (Atomicity, Consistency, Isolation, Durability) properties are enforced to maintain data integrity.

NoSQL: NoSQL databases often relax data consistency to achieve high scalability and performance. They prioritize availability and partition tolerance (CAP theorem) over strict consistency. NoSQL databases offer eventual consistency or relaxed consistency models, where data may be inconsistent for a short period.

`Query Language`:

RDBMS: RDBMS systems typically use SQL (Structured Query Language) for data manipulation and querying. SQL provides a standardized language for accessing and manipulating relational data.

NoSQL: NoSQL databases may have their own query languages or provide APIs specific to their data models. Some NoSQL databases offer SQL-like query languages, while others use key-value or document-oriented APIs.

`Use Cases`:

RDBMS: RDBMS systems are widely used in traditional business applications, where structured and relational data modeling is essential. They are suitable for applications that require complex joins, transactions, and ACID compliance.

NoSQL: NoSQL databases are popular for handling large volumes of unstructured or semi-structured data. They excel in use cases such as real-time analytics, content management systems, social media platforms, and applications requiring high scalability and flexible data models.

## 2. In which cases you choose Nosql or RDBMS?
RDBMS: RDBMS systems are widely used in traditional business applications, where structured and relational data modeling is essential. They are suitable for applications that require complex joins, transactions, and ACID compliance.

NoSQL: NoSQL databases are popular for handling large volumes of unstructured or semi-structured data. They excel in use cases such as real-time analytics, content management systems, social media platforms, and applications requiring high scalability and flexible data models.
## 3. Do you know Cassandra and MongoDB?
`Cassandra:`

Cassandra is a distributed and highly scalable NoSQL database designed to handle large amounts of data across multiple commodity servers.

It provides a decentralized architecture with no single point of failure and offers high availability and fault tolerance.
Cassandra is optimized for write-heavy workloads and can handle massive write throughput with low latency.

It uses a distributed hash table (DHT) for data partitioning and replication across the cluster, providing linear scalability.

Cassandra supports a flexible data model with a column-oriented structure. It allows querying and indexing data based on column families and columns.

It provides tunable consistency levels, allowing trade-offs between consistency and availability.

`MongoDB:`

MongoDB is a document-oriented NoSQL database that stores data in flexible, JSON-like documents.

It offers high performance, scalability, and flexibility for a variety of use cases.

MongoDB supports rich queries, indexing, and secondary indexes, making it suitable for applications with complex data retrieval needs.

It provides horizontal scalability through sharding, allowing distribution of data across multiple servers.

MongoDB's flexible schema allows easy handling of evolving data structures and frequent schema changes.

It has built-in support for replication, providing high availability and fault tolerance.

MongoDB offers advanced features like text search, geospatial indexing, and aggregation framework for data analysis.

## 4. LEFT JOIN & RIGHT JOIN
`LEFT JOIN`:

A LEFT JOIN returns all the records from the left (or first) table and the matched records from the right (or second) table. If there are no matches, NULL values are included for the columns of the right table.
The syntax for a LEFT JOIN is: SELECT * FROM table1 LEFT JOIN table2 ON table1.column = table2.column

`RIGHT JOIN`:

A RIGHT JOIN returns all the records from the right (or second) table and the matched records from the left (or first) table. If there are no matches, NULL values are included for the columns of the left table.
The syntax for a RIGHT JOIN is: SELECT * FROM table1 RIGHT JOIN table2 ON table1.column = table2.column

## 5. SQL design: given two tables, product and order, how will you design?
Table 1: Products
+----+--------------+
| ID | Name | Price |
+----+--------------+

Table 2: Orders
+---------+------------+----------+
| OrderID | ProductsID | Quantity |
+---------+------------+----------+

## 6. How to improve the database performance?
`Indexing`: Properly indexing the database tables can significantly improve query performance. Identify the frequently queried columns and create appropriate indexes on them.

`Query Optimization`: Analyze and optimize database queries to ensure they are efficiently retrieving the required data. Use query analyzers, explain plans, and tools to identify bottlenecks and optimize the queries accordingly.

`Database Schema Design`: Design the database schema in a way that minimizes data redundancy, optimizes data retrieval, and avoids unnecessary joins. Normalize the tables to eliminate data duplication and improve query performance.

`Caching`: Implement caching mechanisms to store frequently accessed data in memory. This reduces the need to fetch data from the database repeatedly, resulting in faster response times. Use technologies like Memcached or Redis for caching.

`Connection Pooling`: Use connection pooling to reuse database connections instead of establishing a new connection for each request. This helps reduce the overhead of connection establishment and teardown, improving performance.

`Database Partitioning`: Partition large database tables into smaller, more manageable chunks based on a certain criterion (e.g., range, list, or hash). This distributes the data across multiple physical storage locations, enabling parallel processing and faster data retrieval.

`Hardware Scaling`: Upgrade your hardware resources, such as CPU, memory, and storage, to handle increased database workload. Consider options like solid-state drives (SSDs) for faster data access.

`Regular Maintenance`: Perform routine database maintenance tasks such as regular backups, index rebuilds, and statistics updates. These tasks optimize database performance and ensure data consistency.

`Denormalization`: In certain scenarios, selectively denormalizing the database schema can improve performance. This involves duplicating and storing data redundantly to minimize joins and improve query performance.

`Load Balancing`: Distribute database workload across multiple database servers using load balancing techniques. This helps distribute queries evenly and prevents any single server from becoming a performance bottleneck.

`Database Monitoring and Tuning`: Continuously monitor the database performance using monitoring tools and analyze the collected metrics. Fine-tune database configurations, memory allocation, and other settings based on performance insights.

## 7. LeetCode (paste your solution code to here)
    1.   BIG COUNTRIES
select name,population,area from world where (area>=3000000 or population>=25000000)

    2.    Recyclable and Low Fat Products
select product_id from Products where (low_fats='Y' and recyclable='Y');

    3.   Find Customer Referee
select name from Customer where (referee_id is null or referee_id != 2)

    4.   Customers Who Never Order
SELECT name as Customers
from Customers
where id not in (
    select customerId
    from Orders
);

    5.   Combine Two Tables
SELECT P.firstName, P.lastName, A.city, A.state
FROM Person P
LEFT JOIN Address A USING (personId)

    6.   Second Highest Salary
SELECT  MAX(SALARY) AS SecondHighestSalary FROM EMPLOYEE WHERE SALARY <>(SELECT MAX(SALARY) FROM EMPLOYEE);

    7.   Nth Highest Salary
CREATE FUNCTION getNthHighestSalary(N INT) RETURNS INT
BEGIN
SET N = N-1;
  RETURN (
      SELECT DISTINCT(salary) from Employee order by salary DESC
      LIMIT 1 OFFSET N
      
  );
END

    8.   Employees Earning More Than Their M
SELECT e2.name as Employee
FROM employee e1
INNER JOIN employee e2 ON e1.id = e2.managerID
WHERE
e1.salary < e2.salary

    9.   Delete Duplicate Emails
delete p1 from person p1,person p2 
where p1.email=p2.email and p1.id>p2.id;

    10.  Consecutive Numbers
SELECT distinct(t1.num) as ConsecutiveNums 
FROM logs t1, logs t2 , logs t3
WHERE t1.id=t2.id+1 AND t2.id=t3.id+1 AND t1.num=t2.num AND t2.num=t3.num

    11.  Department Highest Salary
SELECT d.name AS Department, e.name AS Employee, e.salary AS Salary
FROM Employee e
JOIN Department d ON e.departmentId = d.id
WHERE (e.departmentId, e.salary) IN
    (SELECT departmentId, MAX(salary)
     FROM Employee
     GROUP BY departmentId)

    12.  Classes More Than 5 Students
select class from Courses group by class having count(class) >= 5;


# Design Pattern
## 1. List several design pattern names. and write the code for Singleton and simple factory design pattern.
`Singleton Pattern`: Ensures that a class has only one instance and provides a global point of access to it.

`Factory Pattern`: Provides an interface for creating objects but lets subclasses decide which class to instantiate.

`Observer Pattern`: Defines a one-to-many dependency between objects so that when one object changes state, all its dependents are notified and updated automatically.

`Decorator Pattern`: Allows behavior to be added to an object dynamically by wrapping it with an additional class.

`Strategy Pattern`: Enables a client to choose from a family of algorithms or behaviors at runtime.

`Adapter Pattern`: Converts the interface of a class into another interface that clients expect, enabling classes to work together that otherwise wouldn't be compatible.

`Builder Pattern`: Separates the construction of a complex object from its representation, allowing the same construction process to create different representations.

`Prototype Pattern`: Creates new objects by cloning existing ones, avoiding the need to create objects from scratch.

`Composite Pattern`: Composes objects into tree structures to represent part-whole hierarchies. Clients can treat individual objects and compositions uniformly.

`Iterator Pattern`: Provides a way to access elements of an aggregate object sequentially without exposing its underlying representation.

`Template Method Pattern`: Defines the skeleton of an algorithm in a method, allowing subclasses to provide specific implementations of certain steps.

`Proxy Pattern`: Provides a surrogate or placeholder for another object to control access to it.

`Command Pattern`: Encapsulates a request as an object, allowing parameterization of clients with different requests and supporting operations like undo and redo.

`State Pattern`: Allows an object to alter its behavior when its internal state changes, encapsulating the state-dependent logic into separate classes.

`Observer Pattern`: Defines a one-to-many dependency between objects, where a change in one object triggers updates to all its dependents.

`Singleton`

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

`factory`

```java
public interface Animal {
    void makeSound();
}

public class Dog implements Animal {
    public void makeSound() {
        System.out.println("Woof!");
    }
}

public class Cat implements Animal {
    public void makeSound() {
        System.out.println("Meow!");
    }
}

public class AnimalFactory {
    public Animal createAnimal(String animalType) {
        if (animalType == null) {
            return null;
        }
        if (animalType.equalsIgnoreCase("dog")) {
            return new Dog();
        } else if (animalType.equalsIgnoreCase("cat")) {
            return new Cat();
        }
        return null;
    }
}

public class Main {
    public static void main(String[] args) {
        AnimalFactory animalFactory = new AnimalFactory();

        Animal dog = animalFactory.createAnimal("dog");
        dog.makeSound(); // Output: "Woof!"

        Animal cat = animalFactory.createAnimal("cat");
        cat.makeSound(); // Output: "Meow!"
    }
}
```


# Rest
## 1. What are HTTP request methods?
GET: Retrieves the representation of a resource identified by the URI. It should not have any side effects and should be idempotent (multiple identical requests produce the same result).

POST: Submits data to be processed to a specified resource. It may result in the creation of a new resource or the update of an existing resource. It is not idempotent.

PUT: Updates or replaces the entire representation of a resource at the specified URI. It creates the resource if it doesn't exist or completely replaces it if it does.

PATCH: Partially updates the representation of a resource at the specified URI. It is used to apply partial modifications to an existing resource.

DELETE: Deletes the specified resource identified by the URI.

HEAD: Retrieves the response headers of a resource without retrieving the actual content. It is used to check the status or headers of a resource.

OPTIONS: Retrieves the allowed methods, headers, and other information about a resource.

## 2. What is the difference between Put and Post?
PUT: The PUT method is used to update or replace the entire representation of a resource at a specific URI (Uniform Resource Identifier). When making a PUT request, the client sends the complete representation of the resource in the request payload to the server. The server then replaces the existing resource with the new representation provided. If the resource does not exist, the server may create a new resource at the specified URI.

POST: The POST method is used to submit data to be processed to a specified resource. It is commonly used to create a new resource or submit data for further processing. When making a POST request, the client sends data in the request payload, which may or may not include a representation of the resource being created or modified. The server determines how to handle the data based on the specific application logic or API implementation.

## 3. What are HTTP Status codes? and explain them.( 200, 201, 302, 400, 404, 500)
200 OK: This status code indicates that the request was successful. It is commonly used for successful GET requests, indicating that the server has returned the requested resource.

201 Created: This status code is used to indicate successful creation of a new resource. It is typically returned in response to a POST request, indicating that the request resulted in the creation of a new resource on the server.

302 Found: This status code is a redirect status code. It indicates that the requested resource has been temporarily moved to a different URI. The client should make a new request to the new URI provided in the response.

400 Bad Request: This status code indicates that the server cannot process the client's request due to malformed syntax or invalid parameters. It is often used to indicate client-side errors, such as invalid input or missing required fields.

404 Not Found: This status code indicates that the requested resource could not be found on the server. It is commonly returned when a client requests a resource that does not exist or has been removed.

500 Internal Server Error: This status code indicates that an unexpected error occurred on the server while processing the request. It is a generic error message that does not provide specific information about the nature of the problem.

## 4. Could you tell any endpoints you developed?


## 5. Design one set of APIs for managing the customers history orders
Retrieve Customer's Order History:

GET /customers/{customerId}/orders
Description: Retrieves the order history for a specific customer.
Response: Returns a list of orders associated with the customer.


Retrieve Specific Order Details:

GET /customers/{customerId}/orders/{orderId}
Description: Retrieves the details of a specific order for a customer.
Response: Returns the details of the specified order.


Create a New Order:

POST /customers/{customerId}/orders
Description: Creates a new order for a customer.
Request Body: Contains the necessary information to create the order.
Response: Returns the newly created order with a unique order ID.


Update Order Details:

PUT /customers/{customerId}/orders/{orderId}
Description: Updates the details of a specific order for a customer.
Request Body: Contains the updated information for the order.
Response: Returns the updated order.


Delete an Order:

DELETE /customers/{customerId}/orders/{orderId}
Description: Deletes a specific order for a customer.
Response: Returns a success message indicating the deletion was successful.


# Spring
## 1. What is the IOC?
IOC refers to the design principle where the control of object creation and dependency management is inverted or delegated to a container or framework. In traditional programming, objects are responsible for creating and managing their dependencies, leading to tight coupling between classes. With IOC, the responsibility of creating and managing objects is transferred to an external container, which is responsible for wiring dependencies and providing objects to other classes.

## 2. What is Dependency Injection?
DI, on the other hand, is a specific implementation of IOC. It is a technique used to achieve loose coupling between classes by injecting dependencies into a class from an external source rather than creating them within the class itself. With DI, the class declares its dependencies as constructor parameters, method arguments, or properties, and the container resolves and provides these dependencies at runtime.

## 3. Different ways of DI
Constructor Injection:

In this approach, dependencies are injected through the constructor of a class.
The dependencies are declared as parameters in the constructor, and Spring resolves and injects them when creating an instance of the class.
It ensures that the dependencies are available when the object is created, promoting better immutability and testability.
Setter Injection:

In this approach, dependencies are injected using setter methods.
The dependencies are declared as private instance variables in the class, and Spring uses the setter methods to inject the dependencies.
Setter injection allows flexibility in terms of optional dependencies and changing dependencies at runtime.
Field Injection:

In this approach, dependencies are directly injected into the class's fields.
The dependencies are declared as private instance variables, and Spring uses reflection to set the values of these fields.
Field injection is considered less preferable than constructor or setter injection because it hides the class's dependencies and makes it harder to test.
Interface Injection:

In this approach, dependencies are injected through an interface that the class implements.
The interface defines methods to set the dependencies, and the class implementing the interface provides the implementation for those methods.
Interface injection is less commonly used in Spring and is considered less preferable compared to constructor or setter injection.

## 4. Types of dependency injection
same as above

## 5. What is the Scope of a Bean?
In Spring Framework, the scope of a bean defines the lifecycle and visibility of an object managed by the container. The scope determines how long the bean instance will live and how it will be shared or scoped within the application.

Here are the common bean scopes in Spring:

Singleton: The default scope. A single bean instance is created and shared across the entire application context. All requests for the bean will return the same instance.

Prototype: A new bean instance is created each time it is requested. Each request for the bean will result in a new independent instance. Prototypes are not shared among different parts of the application.

Request: A new bean instance is created for each HTTP request. The bean instance is available only within the current request and is not shared with other requests.

Session: A new bean instance is created for each HTTP session. The bean instance is available throughout the duration of the session and is not shared with other sessions.

Global Session: Similar to the session scope, but specific to the Portlet applications. It creates a bean instance per global session.

Application: The bean instance is scoped to the entire web application. It is shared across all sessions and requests.

WebSocket: Introduced in Spring 4.2, it creates a bean instance per WebSocket connection. The bean instance is available only within the specific WebSocket session.

## 6. could you give me the exmaple for singelton bean scope
```java
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("singleton")
public class MySingletonBean {
    // Bean implementation goes here
}
```

In this example, the `MySingletonBean` class is annotated with `@Component` to indicate that it is a Spring-managed bean. The `@Scope("singleton")` annotation specifies that the bean should have a singleton scope.

When the Spring container initializes, it creates a single instance of the `MySingletonBean` class. This instance is then shared across all parts of the application that request this bean. Subsequent requests for the `MySingletonBean` will receive the same instance.

## 7. What are the differences between @RequestParam and @PathVariable?
`@RequestParam`: This annotation is used to extract query parameters from the request URL. Query parameters are appended to the URL after a question mark (?) and are in the form of key=value pairs. Here's an example:
```java
@GetMapping("/example")
public String exampleMethod(@RequestParam("id") int id) {
    // Method implementation
}
```
In this example, the id parameter is extracted from the query parameter with the key "id". For example, if the URL is /example?id=123, the value 123 will be assigned to the id parameter.


`@PathVariable`: This annotation is used to extract path variables from the request URL. Path variables are dynamic parts of the URL that are denoted by curly braces ({}). Here's an example:
```java
@GetMapping("/example/{id}")
public String exampleMethod(@PathVariable("id") int id) {
    // Method implementation
}
```
In this example, the id parameter is extracted from the path variable with the name "id". For example, if the URL is /example/123, the value 123 will be assigned to the id parameter.

## 8. What is AOP? could you list any annotations and briefly explain it? could give me one example how do you use it?
`Aspect-Oriented Programming` (AOP) is a programming paradigm that aims to modularize cross-cutting concerns in software systems. A cross-cutting concern is a functionality or feature that affects multiple parts of an application, cutting across different modules or components. Examples of cross-cutting concerns include logging, security, transaction management, and error handling.

AOP provides a way to separate cross-cutting concerns from the core business logic of an application. It allows developers to define aspects, which encapsulate the behavior associated with a cross-cutting concern. Aspects can be applied to specific points in the code, known as join points, using a set of rules or patterns called pointcuts.

AOP introduces several key concepts:

`Aspect`: An aspect is a modular unit of cross-cutting functionality. It encapsulates the advice (code that implements the cross-cutting behavior) and the pointcut (specifies where the advice should be applied).

`Advice`: Advice represents the actions or behavior associated with a cross-cutting concern. It defines what should be done at a particular join point, such as before, after, or around the execution of a method.

`Join Point`: A join point is a specific point in the execution of a program, such as the execution of a method, the handling of an exception, or the modification of a field. A pointcut defines which join points should be matched for applying the advice.

`Pointcut`: A pointcut is a predicate that matches join points. It defines a set of join points where the advice should be applied.

`Weaving`: Weaving is the process of applying aspects to the target objects or classes at the specified join points. It can be done at compile-time, load-time, or runtime.

## 9. What is spring batch?
Spring Batch is a lightweight, open-source framework provided by the Spring ecosystem for building batch processing applications. It simplifies the development of robust and scalable batch applications by providing reusable components and abstractions for common batch processing tasks.

Spring Batch is designed to handle high-volume, repetitive tasks such as processing large datasets, performing data transformations, and generating reports. It follows the batch processing principles of reading data, processing it, and writing the result.

## 10. What is cron/spring task?

A cron expression is a string that represents a schedule or a recurring pattern of time-based events. It is commonly used in scheduling systems to define when and how often a task or job should be executed. In the context of Spring Batch or any other scheduling framework, a cron expression is used to specify the schedule for executing a job or task.

In Spring, the Spring Task is a module that provides support for scheduling tasks or jobs in a Spring application. It simplifies the process of scheduling and executing tasks at specified intervals or times. The Spring Task module is built on top of the Java java.util.concurrent package and provides a higher-level abstraction for task scheduling.

## 11. how to monitor you application? (spring actuator)
Spring Actuator offers several endpoints that provide valuable insights into your application's health, metrics, logging, and more. 

Add Spring Actuator dependency: Include the Spring Actuator dependency in your project's pom.xml or build.gradle file:
```xml
<!-- Maven -->
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-actuator</artifactId>
</dependency>
```


Enable Actuator endpoints: By default, most Actuator endpoints are enabled, but you can customize the configuration. In your application.properties or application.yml file, add the following configuration to enable all endpoints:

```yml
management.endpoints.web.exposure.include=*
```

Access Actuator endpoints: Once your application is running, you can access various Actuator endpoints via HTTP. Here are a few common endpoints:

/actuator/health: Provides the health status of your application, including database connectivity, disk space, and custom health indicators.
/actuator/info: Displays custom application information.
/actuator/metrics: Shows application metrics such as memory usage, CPU usage, request counts, etc.
/actuator/loggers: Allows you to view and configure logging levelsat for different components.
You can access these endpoints using a web browser or tools like cURL or Postman.

## 12. Spring validation?
Spring Validation is a feature provided by the Spring Framework that allows you to perform data validation and binding in a structured and declarative way. It helps ensure that the data input meets the specified requirements and constraints before processing it further.

Spring Validation works based on the Java Bean Validation standard (JSR 380) and integrates seamlessly with other Spring features like data binding and error handling. It provides a set of annotations and validation constraints that you can apply to your domain model objects to enforce data validation rules.

```java
public class User {
    @NotNull
    @Size(min = 3, max = 20)
    private String username;

    @NotBlank
    private String password;

    // Getters and setters
}
```

## 13. how to handler exception in spring?
Using `@ExceptionHandler`: You can use the `@ExceptionHandler` annotation to define methods in your controller classes that handle specific exceptions. When an exception of the specified type is thrown during the execution of a request, Spring will invoke the corresponding exception handler method.
```java
@Controller
public class MyController {
    @ExceptionHandler(MyException.class)
    public ResponseEntity<String> handleMyException(MyException ex) {
        // Handle the exception and return a response
    }
}
```

Using `@ControllerAdvice`: `@ControllerAdvice` is an annotation that allows you to define global exception handling across multiple controllers. You can use it to define exception handler methods that will be applied to all controllers or specific controller packages.
```java
@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleException(Exception ex) {
        // Handle the exception and return a response
    }
}
```

Using `HandlerExceptionResolver`: `HandlerExceptionResolver` is an interface that allows you to implement custom exception resolution logic. You can create a class that implements this interface and define your exception handling logic. Spring will automatically detect and use your custom `HandlerExceptionResolver`.

Using `@ResponseStatus`: You can use the `@ResponseStatus` annotation to set the HTTP response status code for a specific exception. By annotating your exception class with `@ResponseStatus`, you can specify the desired status code to be returned when that exception occurs.
```java
@ResponseStatus(HttpStatus.BAD_REQUEST)
public class MyException extends RuntimeException {
    // Exception implementation
}
```

## 14. What is Dispatcher Servelet/Front Controller? please describe the flow.
`Configuration`: In the Spring configuration file (usually web.xml or using Java-based configuration), the DispatcherServlet is defined and mapped to a specific URL pattern. This mapping ensures that all requests that match the specified pattern are intercepted by the DispatcherServlet.

`Request handling`: When a request is received, the DispatcherServlet analyzes the request URL and consults the configured mappings to determine the appropriate controller to handle the request. The controller is responsible for processing the request, executing business logic, and preparing the response data.

`Model-View-Controller`: Spring MVC follows the MVC pattern, where the model represents the data, the view represents the presentation logic, and the controller handles the request and coordinates the flow. The DispatcherServlet interacts with the controllers, views, and other components to fulfill the request and generate the response.

`Handler mappings`: The DispatcherServlet uses handler mappings to determine which controller should handle a specific request. Handler mappings can be configured using various strategies, such as annotations (@RequestMapping), XML-based configuration, or implementing custom HandlerMapping interfaces.

`View resolution`: Once the request has been processed by the controller, the DispatcherServlet is responsible for resolving the appropriate view based on the view name returned by the controller. The view determines how the response data is rendered and presented to the client.

## 15. Difference between @Component and @Bean
@Component: @Component is a stereotype annotation used to mark a class as a Spring-managed component. It is a generic annotation that can be applied to any class to indicate that it should be managed by the Spring container. The @Component annotation is usually used for auto-discovery of beans, where Spring scans the classpath and automatically registers the annotated classes as beans.

@Bean: @Bean is a method-level annotation used to explicitly declare a bean in a Spring configuration class. It is used when you want to have fine-grained control over the bean creation process, such as specifying dependencies or configuring the bean properties. The @Bean annotation is typically used in combination with @Configuration or @Component classes.

## 16. Difference between @Component, @Service, @Repository and @RestController?
@Component: @Component is a generic stereotype annotation used to mark a class as a Spring-managed component. It serves as a general-purpose stereotype and can be used to annotate any class. It indicates that the annotated class is a candidate for auto-discovery and instantiation as a bean by the Spring container.

@Service: @Service is a specialization of the @Component annotation. It is used to annotate classes that represent a service layer in your application. It typically encapsulates business logic or performs operations related to the processing of data. @Service is used to provide a clear separation of concerns and to convey the intent that the annotated class is a service component.

@Repository: @Repository is another specialization of the @Component annotation. It is used to annotate classes that serve as repositories or data access components in your application. @Repository classes typically interact with databases or other external data sources to perform CRUD operations or data access tasks. The annotation provides additional functionality, such as exception translation, when working with data access technologies in Spring.

@RestController: @RestController is a specialized version of the @Controller annotation and is used to annotate classes that handle HTTP requests and produce RESTful responses. It combines @Controller and @ResponseBody, meaning that methods annotated with @RestController are automatically considered to return response bodies and are not required to annotate each individual method with @ResponseBody. It is commonly used in building RESTful APIs.

In summary, @Component is a generic stereotype annotation, @Service is used for service layer components, @Repository is used for data access components, and @RestController is used for RESTful API controllers. These annotations provide additional semantic meaning and may have specific behavior associated with them in the Spring framework.

## 17. What is @ComponentScan?
@ComponentScan is an annotation provided by the Spring Framework that is used to configure component scanning in your application. Component scanning is a mechanism provided by Spring to automatically discover and register Spring-managed beans (components) in your application context.

When you annotate a class with @ComponentScan, Spring will scan the specified base packages and its sub-packages to find classes annotated with stereotype annotations such as @Component, @Service, @Repository, etc., and automatically register them as beans in the Spring application context.

```java
@Configuration
@ComponentScan("com.example.myapp")
public class AppConfig {
    // Configuration code
}
```

In this example, the @ComponentScan annotation is used to specify the base package com.example.myapp for component scanning. Spring will scan this package and its sub-packages to find classes annotated with stereotype annotations and register them as beans in the application context.

## 18. Authentication vs. Authorization
Authentication verifies the identity of a user or entity, while authorization determines the access rights and permissions granted to that identity within a software system. These two concepts work together to ensure proper access control and security.

## 19. What is JWT? (header.payload.signature) and what kind of tool/dependency in java can generate and parse JWT?
JWT stands for JSON Web Token. It is a compact and self-contained way of transmitting information between parties as a JSON object. JWTs are commonly used for authentication and authorization purposes in web applications.

A JWT consists of three parts: header, payload, and signature. The header contains information about the type of token and the algorithm used for signing. The payload contains the claims, which are statements about the user and additional metadata. The signature is generated by combining the header, payload, and a secret key using the specified algorithm. The signature ensures the integrity and authenticity of the token.

## 20. What will happen after click the URL?
In Java, there are several libraries and dependencies that can be used to generate and parse JSON Web Tokens (JWTs). Some popular ones include:

jjwt (Java JWT): jjwt is a widely used Java library for working with JWTs. It provides simple and straightforward APIs for generating, parsing, and validating JWTs. It supports all the standard JWT features and algorithms.

Nimbus-JOSE-JWT: Nimbus-JOSE-JWT is a comprehensive library for working with JSON Web Tokens (JWTs) and JSON Object Signing and Encryption (JOSE). It provides a wide range of functionalities for generating, parsing, validating, signing, and encrypting JWTs.

Apache Shiro: Apache Shiro is a powerful and flexible security framework for Java applications. It includes support for JWTs through its JwtRealm and JwtToken classes. It provides features for generating, parsing, and validating JWTs along with other security-related functionalities.

Spring Security: Spring Security is a widely used security framework for Java applications. It provides support for JWTs through its Jwt classes and integration with other Spring components. It offers features for generating, parsing, and validating JWTs as part of its authentication and authorization mechanisms.

## 21. how to call api in java code?
In Java, you can call APIs using the java.net package or popular HTTP client libraries such as Apache HttpClient or OkHttp. 

## 22. I want to get the customer's history orders between 01/02/2023 and 02/07/2023, and also want to get the suctomer's payments in this account. Please design the API url.
GET /customers/{customerId}/orders?startdate=01022023&enddate=02072023
Description: Retrieves the order history for a specific customer.
Response: Returns a list of orders associated with the customer.

## 23. Develop the API to CRUD the customer's histroy orders.
a. Need to write the full codes including Controller, Service & ServiceImpl, Repository, Entity
b. You need to design the payloads(request, and response body).
c. Use the correct status code for each API
d. Use ResponseEntity
e. Use Validation for request body
f. Write unit tests.
g. Exception handling.
h. use log



# Test
## 1. Functional test & Integrtion test & Unit test & Regression Test & Performance/Load test
Functional Test:
Functional tests verify that the system functions correctly from the end-user's perspective. These tests ensure that the software meets the specified requirements and performs the intended tasks. They focus on testing the external behavior and functionality of the application. Functional tests are typically black-box tests, meaning that they do not require knowledge of the internal implementation.

Integration Test:
Integration tests verify that individual components/modules of an application work together correctly when integrated. These tests focus on testing the interactions and data flow between different components to ensure that they function as expected when combined. Integration tests help identify any issues or defects that may arise due to the integration of multiple components.

Unit Test:
Unit tests are small, focused tests that verify the correctness of individual units or components of an application. These tests isolate specific units, such as classes or methods, and test them in isolation from the rest of the system. Unit tests help ensure that each unit performs as expected and can be used to catch and fix issues early in the development process. They are typically automated and run frequently as part of the development workflow.

Regression Test:
Regression tests are executed to ensure that changes or updates in the software do not introduce new bugs or cause previously working functionality to break. These tests are performed after making modifications to the codebase to ensure that existing features continue to function correctly. Regression testing helps maintain the stability and reliability of the software by detecting and fixing any unintended side effects of changes.

Performance/Load Test:
Performance/load tests assess the performance and scalability of an application under various conditions. These tests simulate a high volume of concurrent users or a heavy load on the system to measure its response time, throughput, resource usage, and stability. Performance testing helps identify bottlenecks, scalability issues, and areas for optimization in the application.

Each type of testing serves a specific purpose in the software development lifecycle and contributes to ensuring the overall quality and reliability of the software. It's important to have a combination of these tests in your testing strategy to achieve comprehensive test coverage.

## 2. What's the test framework in your team?
Junit

## 3. Talk about Mockito, PowerMockito and give an example
Mockito and PowerMockito are popular Java mocking frameworks used for unit testing. They help in creating mock objects and stubbing behaviors to isolate and test specific units of code.

Mockito is a lightweight and easy-to-use mocking framework that simplifies the process of creating and working with mock objects. It provides a simple and fluent API for creating mocks, stubbing method calls, verifying interactions, and handling return values. Mockito focuses on creating mock objects for interfaces and classes by leveraging dynamic proxy or bytecode manipulation.

```java
import static org.mockito.Mockito.*;

// Create a mock object
UserService userServiceMock = mock(UserService.class);

// Stub a method call
when(userServiceMock.getUserById(1)).thenReturn(new User("John"));

// Perform the test
User result = userServiceMock.getUserById(1);

// Verify the interactions
verify(userServiceMock).getUserById(1);
```

PowerMockito, on the other hand, is an extension of Mockito that adds additional capabilities to mock static methods, final classes, constructors, and private methods. It is useful when dealing with legacy code or external dependencies that cannot be easily modified.

```java
import static org.powermock.api.mockito.PowerMockito.*;

// Mock a static method
mockStatic(DatabaseUtil.class);
when(DatabaseUtil.getConnection()).thenReturn(mockConnection);

// Perform the test
Connection connection = DatabaseUtil.getConnection();

// Verify the interactions
verifyStatic(DatabaseUtil.class);
DatabaseUtil.getConnection();
```

## 4. What is SonarQube?

SonarQube is an open-source platform for continuous code quality inspection. It provides a comprehensive set of tools and features to analyze code, detect bugs, security vulnerabilities, code smells, and maintain code quality across projects. SonarQube integrates with various programming languages and tools to perform static code analysis and generate detailed reports.

The main features of SonarQube include:

Code Quality Analysis: SonarQube performs static code analysis to identify issues such as bugs, vulnerabilities, code smells, and code duplications. It provides detailed metrics and visualizations to assess code quality.

Rule Engine: SonarQube comes with a built-in rule engine that defines a set of coding rules and standards. These rules are used to detect code issues and enforce best practices.

Integration with CI/CD: SonarQube seamlessly integrates with popular continuous integration and continuous delivery (CI/CD) tools such as Jenkins, GitLab, and Azure DevOps. It can be configured to automatically analyze code during the build process and generate reports.

Security Vulnerability Detection: SonarQube includes security-specific rules to identify common vulnerabilities in code, such as injection attacks, cross-site scripting, and insecure authentication.

Customizable Quality Profiles: SonarQube allows the customization of quality profiles to define project-specific rules and configurations. This enables teams to tailor code analysis to their specific needs and requirements.

Code Coverage and Test Analysis: SonarQube integrates with code coverage tools to analyze test coverage and identify areas of the code that lack proper testing.

Historical Analysis and Trends: SonarQube maintains a history of code analysis results, allowing teams to track code quality over time, identify trends, and monitor improvements.

# Microservice
## 1. Microservice architecture in your recent project?
Eureka: microservice registration
Hystrix & Kafka: message queue
Ribbon: Load-balancer
Docker: container
API Gateway: API integration
Spring Cloud: Config server

## 2. Microservice components
Service: The core building block of a microservice architecture is a service, which represents a specific business capability or functionality. Each service is independently deployable and responsible for a specific task.

API Gateway: The API gateway acts as the entry point for external client requests. It handles routing and load balancing across multiple services, as well as providing authentication, authorization, and security mechanisms.

Service Registry: The service registry is a centralized repository that stores information about available services, their network locations, and metadata. It allows services to discover and communicate with each other dynamically.

Service Discovery: Service discovery is the mechanism by which services locate and connect with other services. It involves querying the service registry to obtain the network location and other details of the required services.

Event Bus/Message Broker: An event bus or message broker facilitates asynchronous communication between services. It allows services to publish and subscribe to events or messages, enabling loose coupling and scalability.

Database per Service: Each service typically has its own dedicated database or data storage for its specific needs. This promotes data isolation and autonomy for services, ensuring that changes in one service's data model do not impact others.

Configuration Server: The configuration server stores and manages the configuration settings for all services in the architecture. It allows for centralized configuration management and enables dynamic configuration updates.

Monitoring and Logging: Monitoring and logging components are essential for collecting and analyzing metrics, logs, and traces from services. They provide visibility into the health, performance, and behavior of the system.

Load Balancer: Load balancers distribute incoming client requests across multiple instances of a service to ensure scalability, high availability, and optimal resource utilization.

Circuit Breaker: The circuit breaker pattern is used to handle failures and prevent cascading failures in distributed systems. It monitors the health of services and, if necessary, breaks the circuit to stop further requests and provide fallback responses.

Authentication and Authorization: These components are responsible for verifying the identity of clients and granting access to protected resources. They enforce security policies and ensure that only authorized requests are processed.

Caching: Caching mechanisms, such as in-memory caches or distributed caches, can be employed to improve performance and reduce the load on services by storing frequently accessed data.


## 3. How to do server discovery?
Client-side Service Discovery:

Each service instance registers itself with a service registry upon startup, providing its metadata and network location (host and port).
Client services (service consumers) query the service registry to obtain the network locations of the desired services.
The client-side load balancer then uses the obtained service instances to distribute client requests across the available instances.
Popular client-side service discovery frameworks include Netflix Eureka and Consul.
Server-side Service Discovery:

A separate component, known as the service registry or discovery server, maintains a centralized registry of all available services and their network locations.
Service instances do not directly register themselves with the registry. Instead, they are typically registered by infrastructure or orchestration tools.
Client services communicate with the service registry to obtain the network locations of the desired services.
Once the client has the network location, it can make direct calls to the service instances without the need for an additional load balancer.
Examples of server-side service discovery tools include Apache ZooKeeper and etcd.

## 4. What is API gateway and what we can do in API Gateway?
An API gateway is a key component in a microservice architecture that acts as a single entry point for all client requests. It serves as a traffic cop, routing incoming requests to the appropriate microservices and handling various cross-cutting concerns related to API management. 

## 5. how to communicate each other between services?
Synchronous HTTP/REST: Services can communicate with each other using synchronous HTTP requests over the REST (Representational State Transfer) protocol. One service makes an HTTP request to another service's API endpoint, and the response is returned synchronously. This approach is simple and widely supported by various programming languages and frameworks.

Asynchronous Messaging: Services can communicate asynchronously using message queues or event-driven systems. In this approach, one service publishes a message or event to a messaging system (such as Apache Kafka or RabbitMQ), and other services subscribe to these messages and react accordingly. This decouples services and allows for asynchronous and scalable communication.

Remote Procedure Call (RPC): RPC allows services to invoke methods or functions on other services as if they were local method calls. Services expose their functionalities via APIs, and remote services can invoke these APIs using RPC frameworks such as gRPC or Apache Thrift. RPC provides a more direct and efficient communication mechanism compared to RESTful HTTP.

Service Mesh: A service mesh is a dedicated infrastructure layer that handles communication between services. It typically uses a sidecar proxy deployed alongside each service, which intercepts and manages all network traffic. The proxy handles service discovery, load balancing, encryption, and other cross-cutting concerns, providing a transparent communication layer for services.

Database Integration: Services can communicate indirectly through a shared database. Each service has its own database and interacts with it independently. Services can read from and write to the shared database, allowing data to be exchanged between services. However, care must be taken to ensure data consistency and avoid tight coupling between services.

## 6. How do you use RestTemplate? write the code example to call an API
```java
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class RestTemplateExample {
    public static void main(String[] args) {
        // Create an instance of RestTemplate
        RestTemplate restTemplate = new RestTemplate();
        
        // Define the API endpoint URL
        String apiUrl = "https://api.example.com/data";
        
        // Make a GET request to the API and retrieve the response
        ResponseEntity<String> response = restTemplate.getForEntity(apiUrl, String.class);
        
        // Check the response status code
        if (response.getStatusCode().is2xxSuccessful()) {
            // Request was successful, retrieve the response body
            String responseBody = response.getBody();
            
            // Process the response data
            System.out.println("Response: " + responseBody);
        } else {
            // Request failed, handle the error
            System.out.println("Error: " + response.getStatusCode());
        }
    }
}
```

## 7. How to scale up your microservice?
Vertical Scaling: This involves increasing the resources (CPU, memory, storage) of the individual server or instance running the microservice. Vertical scaling is typically done by upgrading the hardware or allocating more resources to the server.

Horizontal Scaling: This involves adding more instances of the microservice to distribute the load across multiple servers. Each instance handles a portion of the incoming requests, increasing the overall capacity. Horizontal scaling requires a load balancer to distribute requests evenly among the instances.

Containerization: Using containerization platforms like Docker and orchestration tools like Kubernetes can simplify the process of scaling up microservices. Containers provide lightweight and isolated runtime environments, making it easier to deploy and manage multiple instances of the microservice across different servers.

Auto-scaling: This is a dynamic scaling approach where the number of instances of the microservice is automatically adjusted based on the current load. Auto-scaling can be based on metrics such as CPU utilization, request latency, or the number of requests in the queue. Cloud platforms like AWS, Azure, and Google Cloud provide auto-scaling capabilities.

Caching: Implementing caching mechanisms can help improve the performance and scalability of microservices. Caching frequently accessed data or the results of expensive computations can reduce the load on the microservice and improve response times.

Database Optimization: Optimize database queries and indexes to ensure efficient data retrieval and minimize the load on the database. Consider using caching layers, database sharding, or replica sets to distribute the database load and improve scalability.

Asynchronous Processing: Offloading time-consuming or non-blocking tasks to asynchronous processing frameworks or message queues can help improve the responsiveness and scalability of the microservice. This allows the microservice to quickly return a response to the client while processing the task in the background.

Monitoring and Performance Testing: Regularly monitor the performance and resource utilization of the microservice to identify bottlenecks and areas for improvement. Perform load testing to determine the maximum capacity and identify any performance issues under heavy load.

## 8. Kafka
    a. What is broker?
    
    
In Apache Kafka, a broker is a core component of the Kafka messaging system. It refers to an individual server instance that stores and manages streams of records, which are organized into topics. Multiple brokers work together to form a Kafka cluster, enabling distributed and scalable data processing.

Key features of brokers in Kafka include:

Data Storage: Brokers are responsible for storing the published records in a distributed and fault-tolerant manner. Each broker maintains a portion of the overall topic data, known as partitions. Partitions are replicated across multiple brokers for durability and high availability.

Topic Partition Management: Brokers handle the management of topic partitions, including creating, assigning, and reassigning partitions to ensure load balancing and fault tolerance. The partitions are distributed across the available brokers in the cluster.

Message Replication: Kafka brokers replicate topic partitions across multiple brokers to ensure data redundancy and fault tolerance. This replication enables the system to continue functioning even if a broker fails. Replicas are synchronized to maintain consistency across the cluster.

Message Storage and Retrieval: Brokers store messages in their partitions in an append-only manner. They handle the reading and writing of messages, as well as the retrieval of messages based on offsets.

Metadata Management: Brokers maintain metadata information about the topics, partitions, replicas, and consumer offsets. This metadata is crucial for the coordination of producers and consumers in the Kafka cluster.

Communication: Brokers facilitate communication between producers, which publish messages to Kafka topics, and consumers, which consume messages from those topics. They handle the network protocols and data transfer between the clients and the Kafka cluster.

    b. are you a producer or consumer in your recent project?
consumer

    c. What is topic? could you give me one example of the topics in your recent project?

In Apache Kafka, a topic is a category or feed name to which messages are published. It represents a logical stream of data, similar to a table or a queue in other messaging systems. Topics in Kafka are multi-subscriber, meaning that multiple consumers can subscribe to and read from the same topic concurrently.

In my project, the topics are the order details

    d. What is partition?
In Apache Kafka, a partition is a unit of data organization and distribution within a topic. Each topic can be divided into one or more partitions, and each partition is a linearly ordered, immutable sequence of records.

    e. What is group consumer?
In Apache Kafka, a consumer group is a group of consumers that work together to consume messages from one or more partitions of a topic. Each partition within a topic can be consumed by only one consumer within a consumer group at a time. However, multiple consumer groups can consume from the same topic, allowing for parallel processing and scalability.

    f. What is offset?
In Apache Kafka, an offset is a unique identifier that represents the position of a consumer within a partition of a topic. Each message in a partition is assigned a unique offset starting from zero. The offset provides a way to track the progress of a consumer in consuming messages from a topic.

    g. Explain the concept of Leader and Follower in Kafka.
In Apache Kafka, the concept of Leader and Follower is associated with the replication of partitions across multiple brokers. Each partition of a topic in Kafka is replicated for fault tolerance and high availability. The Leader and Follower roles determine how data is distributed and maintained across these replicas.

Here's an explanation of the Leader and Follower roles in Kafka:

Leader:

The Leader is the active replica for a partition and handles all read and write requests for that partition.
Producers send messages to the Leader, and consumers read messages from the Leader.
The Leader is responsible for maintaining the in-sync replicas (ISRs) and handling all data replication to the Follower replicas.
The Leader maintains an in-memory replica of the partition's log, which is used for serving read and write requests efficiently.
Follower:

The Followers are passive replicas that replicate the data from the Leader and stay in sync with the Leader's log.
Follower replicas consume and replicate the log entries received from the Leader in the same order.
Follower replicas do not handle client requests directly. They only serve as backups and can take over as the new Leader in case of Leader failure.
Follower replicas periodically pull data from the Leader to update their replicas and stay in sync.

    h. If consumer has a big lagging, how to solve it?
When a consumer in Apache Kafka has a significant lag, meaning it is falling behind in processing messages, there are several steps you can take to address the issue and reduce the lag:

Increase Consumer Parallelism: If you have multiple partitions in the topic, ensure that you have enough consumer instances to handle the workload. Each consumer instance can process messages from different partitions concurrently, which can help distribute the load and reduce lag.

Adjust Consumer Configuration: Review and optimize the consumer configuration parameters. Some relevant properties include the fetch.min.bytes and fetch.max.wait.ms, which control the amount of data fetched in each request and the maximum wait time for data availability. Tweaking these values can help balance the trade-off between latency and throughput.

Increase Consumer Capacity: If the lag is consistently high, consider increasing the resources allocated to the consumer application, such as CPU, memory, or network bandwidth. This can improve the consumer's processing capability and reduce the time taken to handle messages.

Optimize Consumer Processing Logic: Analyze the consumer's message processing logic to identify any potential bottlenecks or areas for optimization. Ensure that the processing code is efficient and does not introduce unnecessary delays or resource-intensive operations. Consider asynchronous processing, batching, or other optimization techniques to improve performance.

Monitor and Tune Kafka Cluster: Monitor the Kafka cluster for any potential issues or bottlenecks that might impact consumer performance. Keep an eye on metrics like broker CPU and disk utilization, network latency, and partition reassignments. If necessary, scale up the cluster by adding more brokers or increasing the resources allocated to existing brokers.

Adjust Consumer Group Assignment Strategy: If you have control over the consumer group assignment strategy, consider using a different strategy that better balances the workload across consumers. The default assignment strategy in Kafka is the range assignment, but you can also implement a custom assignment strategy tailored to your application's needs.

Review Message Throughput and Retention Policies: Evaluate the message throughput and retention policies in your Kafka deployment. If the message rate is consistently high, and the retention period is long, it can contribute to consumer lag. Consider adjusting the retention period or implementing data archiving strategies to manage the message backlog.

Monitor and Tune Consumer Lag: Continuously monitor the lag of your consumers using Kafka monitoring tools or built-in consumer lag monitoring features. Set up alerts to notify you when the lag exceeds certain thresholds, allowing you to take proactive actions.

    i. do you have any even name in your recent project?


    j. Differentiate between Rabbitmq and Kafka.

Messaging Model:

RabbitMQ: RabbitMQ follows the traditional message broker model based on the Advanced Message Queuing Protocol (AMQP). It focuses on reliable message delivery, supporting features like message queues, exchanges, and bindings.
Kafka: Kafka follows the publish-subscribe model. It is designed as a distributed streaming platform, where messages are organized into topics, and consumers can subscribe to topics and consume messages in real-time.
Messaging Pattern:

RabbitMQ: RabbitMQ is well-suited for traditional messaging patterns, such as request-response, work queues, and routing.
Kafka: Kafka is designed for high-throughput, fault-tolerant, and scalable stream processing. It excels in scenarios where data needs to be processed and analyzed in real-time, such as event streaming, log aggregation, and data pipelines.
Persistence:

RabbitMQ: RabbitMQ persists messages to disk by default, ensuring reliable message delivery even in the event of failures.
Kafka: Kafka is built for high-performance and relies on a distributed commit log architecture. It persists messages for a configurable period of time or based on storage limits, allowing for efficient replay and real-time processing.
Scalability and Performance:

RabbitMQ: RabbitMQ uses a traditional queuing model, where messages are distributed to consumers. It is generally suited for scenarios with moderate message volumes and a smaller number of consumers.
Kafka: Kafka is designed for high scalability and performance. It can handle high message throughput and supports horizontal scaling by distributing partitions across multiple brokers. It can handle large-scale streaming workloads with low latency.
Consumer Flexibility:

RabbitMQ: RabbitMQ provides flexibility in acknowledging and managing message consumption. Consumers can explicitly acknowledge messages, control message prefetching, and implement various acknowledgement modes.
Kafka: Kafka provides a pull-based consumer model, where consumers pull messages from brokers at their own pace. Consumers can control the offset they want to consume from and have more control over message consumption.
Ecosystem and Use Cases:

RabbitMQ: RabbitMQ has a mature ecosystem and is widely used in enterprise applications for reliable messaging, task distribution, and integration between systems.
Kafka: Kafka has gained popularity in big data and real-time streaming scenarios. It is used for event sourcing, real-time analytics, log processing, and building data pipelines.


# Docker
Reference: https://www.interviewbit.com/docker-interview-questions/#docker-basic-questions
## 1. Can you tell something about docker container?
Docker is an open-source platform that allows you to automate the deployment, scaling, and management of applications using containerization. Docker containers are lightweight, standalone, and portable environments that package an application along with its dependencies and configurations. Here are some key points about Docker containers:

Containerization: Containers provide a consistent and isolated environment for applications to run, ensuring that they work the same way across different environments, such as development, testing, and production. Containers are based on container images, which are read-only templates that contain the application code, libraries, and runtime dependencies.

Isolation: Docker containers use operating system-level virtualization to ensure isolation between applications. Each container has its own file system, networking, and process space, making it independent and secure. Containers share the host operating system kernel, which allows for efficient resource utilization and faster startup times compared to traditional virtual machines.

Portability: Docker containers are highly portable and can run on any system that has Docker installed, regardless of the underlying operating system. This enables easy migration of applications across different environments and avoids issues related to environment inconsistencies.

Scalability: Docker containers are designed to be scalable. You can easily scale the number of containers up or down based on the demand for your application. Container orchestration tools like Docker Swarm or Kubernetes help manage container clusters and handle automatic scaling, load balancing, and service discovery.

Efficiency: Docker containers are lightweight and have minimal overhead compared to traditional virtual machines. They share the host system's resources, allowing for higher density of application instances on a single server. This efficient resource utilization reduces hardware costs and improves overall performance.

Continuous Integration and Deployment (CI/CD): Docker containers are often used in CI/CD pipelines to automate the build, test, and deployment processes. Containers provide consistent environments across different stages of the pipeline, ensuring that applications work as expected from development to production.

## 2. What are docker images?
Docker images are the building blocks of Docker containers. They are read-only templates or snapshots that contain everything needed to run a specific application, including the application's code, runtime environment, libraries, and dependencies. Docker images are created from a base image or can be built from a Dockerfile, which is a text file that specifies the instructions to build the image.

Here are some key points about Docker images:

Layered Structure: Docker images are composed of multiple layers, where each layer represents a specific change or addition to the image. Layers are stacked on top of each other, and the final image is the combination of all the layers. This layered structure allows for efficient storage and sharing of images. If multiple images share the same layers, they can reuse those layers, saving disk space and download time.

Immutable and Versioned: Docker images are immutable, meaning they cannot be modified once they are created. If any changes need to be made, a new image needs to be built with the desired modifications. This immutability ensures consistency and reproducibility in container deployments. Images can also be versioned, allowing you to manage different versions of an application or configuration.

Registry and Repository: Docker images can be stored in a registry, which is a centralized repository for managing and distributing Docker images. The most commonly used registry is Docker Hub, but you can also set up private registries for more control over image distribution and security. Images in a registry can be tagged with different versions or labels for easy identification and retrieval.

Reusability: Docker images are designed to be reusable across different environments and systems. Once an image is built, it can be easily shared and deployed on any system that has Docker installed. This reusability simplifies the process of setting up and running applications, as all the necessary dependencies and configurations are encapsulated within the image.

Incremental Updates: Docker images support incremental updates. When you make changes to the application or its dependencies, only the affected layers need to be rebuilt and updated, while the unchanged layers can be reused from the existing image. This feature speeds up the image build process and reduces network transfer when pushing and pulling images.

Layer Caching: Docker employs layer caching to optimize the image build process. Each instruction in the Dockerfile is executed as a separate layer, and if a layer already exists in the cache, it is reused instead of being rebuilt. This caching mechanism improves build times, especially during iterative development and continuous integration workflows.

## 3. What is a DockerFile?
A Dockerfile is a text file that contains a set of instructions and commands used to build a Docker image. It provides a declarative way to define the steps required to create an image with the desired configuration and dependencies.

Here are some key points about Dockerfiles:

Image Configuration: Dockerfiles are used to specify the base image, which serves as the starting point for building the new image. The base image can be a minimal operating system or a pre-configured image that already includes certain software or libraries.

Layered Approach: Dockerfiles use a layered approach, where each instruction in the Dockerfile creates a new layer on top of the existing image. Layers are cached and can be reused during subsequent builds, speeding up the build process.

Instructions and Commands: Dockerfiles consist of a series of instructions and commands that are executed sequentially during the image build process. Some common instructions include FROM (specifying the base image), RUN (running commands inside the container), COPY (copying files from the host machine to the container), EXPOSE (specifying ports to be exposed), and CMD (defining the default command to run when a container is started).

Build Context: When building an image using a Dockerfile, a build context is required. The build context is the set of files and directories located on the host machine that are needed during the build process. It includes the Dockerfile itself and any files referenced in the Dockerfile's instructions, such as application code or configuration files.

Repeatability and Versioning: Dockerfiles provide repeatability and versioning for image builds. By using a Dockerfile, the image build process becomes reproducible, as the same set of instructions is used every time. Dockerfiles can also be version-controlled, allowing you to track changes and easily roll back to previous versions if needed.

Customization and Extensibility: Dockerfiles can be customized to fit specific application requirements. Additional software, dependencies, or configurations can be added by including the necessary instructions in the Dockerfile. This allows for flexibility and customization of the resulting image.

## 4. What can you tell about Docker Compose?
Docker Compose is a tool that allows you to define and manage multi-container Docker applications. It simplifies the process of running and orchestrating multiple containers that work together to form a complete application stack. Docker Compose uses a declarative YAML file to define the services, networks, and volumes required for your application.

Here are some key features and benefits of Docker Compose:

Service Definitions: With Docker Compose, you can define the different services or containers that make up your application stack. Each service can have its own configuration, such as the base image, environment variables, ports to expose, volumes to mount, and dependencies on other services.

Easy Configuration: Docker Compose uses a simple YAML file to define the desired state of your application. This file can be version-controlled and shared with other developers, making it easy to collaborate and reproduce the application stack across different environments.

Service Discovery and Networking: Docker Compose automatically creates a network for your application and assigns each service a unique hostname. This allows the services to communicate with each other using their service names instead of IP addresses. By default, containers within the same network can discover and communicate with each other using these service names.

Container Orchestration: Docker Compose provides a way to manage the lifecycle of your containers. You can start, stop, and restart your application stack with a single command. Docker Compose also handles container dependencies, ensuring that dependent services are started before the services that rely on them.

Volume Mounting: Docker Compose allows you to define volumes and mount them into your containers. This enables persistent storage and data sharing between containers or between containers and the host machine. Volumes can be used to store application data, configuration files, or any other files required by your application.

Environment Variables and Secrets: Docker Compose supports environment variables, allowing you to pass configuration values to your containers at runtime. This makes it easy to configure different environments (e.g., development, testing, production) without modifying the container images. Docker Compose also provides support for managing secrets, which allows you to securely store and use sensitive information in your application.

Scalability and Replication: Docker Compose can help you scale your application by allowing you to define multiple instances of a service. This is useful for distributed applications or when you need to handle increased load. Docker Compose supports scaling up or down by specifying the desired number of replicas for a service.

## 5. What is the purpose of the volume parameter in a docker run command?
The volume parameter in a docker run command is used to create and manage persistent storage for containers. It allows you to define a mapping between a directory or file on the host machine and a directory inside the container. This mapping ensures that any data written to the specified directory or file inside the container is persisted even after the container is stopped or deleted.

The volume parameter is specified using the -v or --volume flag in the docker run command. It follows the format <host-path>:<container-path>, where <host-path> is the path to the directory or file on the host machine, and <container-path> is the path to the corresponding directory or file inside the container.

## 6. How to get logs of a container?
To get the logs of a container, you can use the docker logs command. 

## 7. list all of the docker commands you know, and briefly explain it.
docker run: This command is used to create and start a new container from a Docker image.

docker build: It builds a new Docker image from a Dockerfile.

docker pull: It fetches a Docker image from a registry (like Docker Hub) to your local machine.

docker push: It pushes a Docker image from your local machine to a registry.

docker images: It lists all the Docker images available on your local machine.

docker ps: It shows the currently running containers.

docker stop: It stops a running container.

docker start: It starts a stopped container.

docker restart: It stops and then starts a container.

docker rm: It removes one or more stopped containers.

docker rmi: It removes one or more Docker images.

docker logs: It fetches the logs of a container.

docker exec: It executes a command in a running container.

docker inspect: It provides detailed information about a Docker object (container, image, network, etc.).

docker network: It manages Docker networks, allowing containers to communicate with each other.

docker volume: It manages Docker volumes, which are used to persist data between containers.

docker-compose: It manages multi-container Docker applications using a YAML file (docker-compose.yml).

docker attach: It attaches to a running container and allows you to interact with its terminal.

docker cp: It copies files between a container and the local filesystem.

docker-compose up: It starts the services defined in a Docker Compose file.

docker-compose down: It stops and removes the containers defined in a Docker Compose file.


# Kubernetes
## 1. What is Kubernetes?
Kubernetes is an open-source container orchestration platform that automates the deployment, scaling, and management of containerized applications. It was originally developed by Google and is now maintained by the Cloud Native Computing Foundation (CNCF).

Kubernetes provides a scalable and highly available platform for running containerized applications. It abstracts the underlying infrastructure and provides a set of powerful features for deploying and managing containers, including:

Container Orchestration: Kubernetes manages the scheduling and placement of containers across a cluster of nodes, ensuring that applications are running efficiently and reliably.

Service Discovery and Load Balancing: Kubernetes provides built-in mechanisms for discovering and routing traffic to containers within a cluster, making it easy to expose and access services.

Scaling and Self-Healing: Kubernetes can automatically scale applications based on resource usage or custom metrics. It also monitors the health of containers and restarts or replaces them if they fail.

Storage Orchestration: Kubernetes supports various storage options, allowing applications to use persistent storage volumes for data persistence.

Configuration and Secret Management: Kubernetes provides mechanisms for managing application configuration and secrets, allowing you to store sensitive information securely.

Rolling Updates and Rollbacks: Kubernetes supports rolling updates, allowing you to update applications without downtime. It also enables easy rollbacks to previous versions if issues are encountered.

Logging and Monitoring: Kubernetes integrates with logging and monitoring solutions, making it easier to collect and analyze application logs and metrics.

Multi-Environment Deployment: Kubernetes is cloud-agnostic and can be deployed on a variety of infrastructure providers, including public clouds, private clouds, and on-premises environments.

## 2. What is pod, what is service, and what is deployment?
a. reading: https://www.educative.io/module/665EM3i03GVvJNjwJ/10370001/6231939383558144
i. only need to know theories.
b. reading: https://www.yuque.com/fairy-era/yg511q/eu30ue

Pod: A Pod is the smallest and most basic unit of deployment in Kubernetes. It represents a single instance of a running process within a cluster. A Pod can encapsulate one or more containers, which are tightly coupled and share the same network namespace and storage volumes. Pods are used to deploy and scale applications and are scheduled and managed by the Kubernetes cluster.

Service: A Service is an abstraction that defines a logical set of Pods and a policy to access them. It provides a consistent and stable network endpoint (IP address and port) that other components within and outside the cluster can use to communicate with the Pods. Services enable load balancing and service discovery within the cluster, allowing Pods to be easily accessed by other applications or services.

Deployment: A Deployment is a higher-level abstraction that manages the lifecycle of Pods and provides declarative updates to the application. It defines the desired state of the application, including the number of replicas (Pod instances) to be created and maintained. Deployments enable rolling updates and rollbacks, making it easy to update and manage the application without downtime. They also provide scaling capabilities to handle increased traffic or demand.


## 3. Remember the below Kubectl commands
a. 查看所有命名空间：
kubectl get namespaces
b. 查看所有Pod：
kubectl get pods
c. 查看指定命名空间的所有Pod：
kubectl get pods -n <namespace>
d. 查看所有运⾏中的Pod：
kubectl get pods --field-selector=status.phase=Running
e. 查看指定Pod的详细信息：
kubectl describe pod <pod-name>
f. 查看Pod的⽇志：
kubectl logs <pod-name>
g. 进⼊⼀个正在运⾏的容器：
kubectl exec -it <pod-name> -- /bin/bash
h. 删除⼀个Pod：
kubectl delete pod <pod-name>
i. 扩展⼀个部署：
kubectl scale deployment <deployment-name> --replicas=<numreplicas>
j. 滚动更新⼀个部署：
kubectl rollout restart deployment <deployment-name>

# Tools
## 1. What is splunk?
Splunk is a software platform used for monitoring, searching, analyzing, and visualizing machine-generated data. It is designed to help organizations gain insights from the massive amounts of data generated by various systems, applications, devices, and infrastructure components. Splunk collects and indexes data from diverse sources, such as logs, metrics, events, and sensors, and provides powerful search and analytics capabilities to extract valuable information and patterns.

## 2. What is Jira? what is sprint? what is scrum?
Jira is a popular project management tool developed by Atlassian. It is widely used for issue tracking, project planning, and agile software development. Jira provides a collaborative platform for teams to manage tasks, track progress, and facilitate communication within a project.

Sprint, in the context of agile development, is a time-boxed iteration during which a set of planned work is completed. It is a fundamental concept in Scrum, which is an agile framework for managing and delivering software projects. A sprint typically lasts for a fixed duration, commonly 1-4 weeks, and focuses on delivering a specific set of user stories or features.

Scrum is an agile framework for managing complex projects, primarily used in software development. It emphasizes iterative and incremental development, cross-functional teams, and close collaboration between team members. Scrum promotes transparency, adaptability, and continuous improvement. It consists of several key elements, including sprints, product backlog, scrum master, product owner, and daily stand-up meetings.

## 3. how long is one Sprint? tell me your daily routine.
2 weeks

## 4. what is agile?
Agile is an iterative and incremental approach to project management and software development. It emphasizes flexibility, collaboration, and customer satisfaction. Agile methodologies are designed to respond to changing requirements and deliver value to customers in a faster and more efficient manner.

The Agile Manifesto, created in 2001, outlines the core principles of agile development. These principles prioritize individuals and interactions, working software, customer collaboration, and responding to change over following rigid plans and processes.

Some key characteristics of agile methodologies include:

Iterative and incremental development: Work is divided into small iterations or sprints, allowing for frequent feedback and continuous improvement.

Cross-functional teams: Collaboration among individuals with different skill sets promotes communication, efficiency, and shared responsibility.

Adaptive planning: Plans are flexible and evolve as the project progresses. Requirements are refined and reprioritized based on feedback and changing circumstances.

Customer involvement: Customers and stakeholders are actively involved throughout the development process, providing feedback and influencing the direction of the project.

Continuous delivery and feedback: Frequent releases allow for early and continuous delivery of valuable features. Feedback loops ensure that the product meets customer needs and expectations.

## 5. Can you talk about CI/CD?
CI/CD stands for Continuous Integration and Continuous Deployment/Delivery. It is a software development approach that emphasizes automating the processes of building, testing, and deploying software applications. The goal of CI/CD is to enable frequent and reliable releases of software, ensuring high-quality and efficient delivery.

Here's a breakdown of the key concepts and benefits of CI/CD:

Continuous Integration (CI):

CI involves integrating code changes from multiple developers into a shared repository frequently, typically several times a day.
Automated build and test processes are triggered upon code commits to detect integration issues early.
CI encourages collaboration, reduces conflicts, and provides fast feedback on code quality.
Continuous Deployment (CD) or Continuous Delivery (CD):

Continuous Deployment involves automatically deploying code changes to production environments after passing all necessary tests.
Continuous Delivery focuses on having a release-ready product at any point, allowing for manual deployment decisions.
CD streamlines the deployment process, reduces the risk of errors, and enables faster time-to-market.

## 6. How can you monitor your application? Like QPS, network, CPU usage, Memory Usage, APIs error rates (https://grafana.com/)
Monitoring an application involves collecting and analyzing various metrics and logs to gain insights into its performance, availability, and overall health. Here are some commonly used methods and tools for monitoring:

Application Performance Monitoring (APM) tools:

APM tools like New Relic, AppDynamics, and Dynatrace provide deep visibility into application performance metrics, including response times, throughput, error rates, and resource consumption.
These tools often offer real-time monitoring, alerting, and detailed transaction tracing to identify bottlenecks and optimize application performance.
Infrastructure Monitoring:

Tools like Prometheus, Nagios, and Datadog help monitor server infrastructure metrics such as CPU usage, memory usage, disk space, network traffic, and system load.
They provide insights into the health and resource utilization of servers, containers, virtual machines, and other infrastructure components.
Log Management:

Log management tools like ELK Stack (Elasticsearch, Logstash, Kibana), Splunk, and Graylog centralize and analyze logs from various sources.
Logs can provide valuable information about application behavior, errors, and exceptions, aiding in troubleshooting and root cause analysis.
Distributed Tracing:

Distributed tracing tools like Jaeger and Zipkin help trace requests across various microservices and provide visibility into the flow and performance of requests.
They assist in identifying latency issues, pinpointing bottlenecks, and optimizing service communication.
Synthetic Monitoring:

Synthetic monitoring tools like Pingdom and Uptime Robot simulate user interactions with the application to monitor its availability and performance from different geographical locations.
These tools often perform scheduled tests to check endpoint responsiveness, API availability, and response times.
Custom Metrics and Dashboards:

Applications can emit custom metrics and expose them through monitoring endpoints.
Developers can define and track specific metrics like API error rates, request rates (QPS), latency, and other application-specific metrics.
Dashboards, using tools like Grafana, can display real-time and historical data, providing a consolidated view of key metrics.

## 7. What kind of tools do you use to ensure your code quality? (Sonarqube) Soft Skills (discuss it with team, no need to gather all members, at least 3 ppl)



# Soft Skills
## 1. write one set of soft skills you will use for interview. The goal is to have a good communication and make the interview be happly.


## 2. If you didn't get the questions,


## 3. If you misunderstand the question,


## 4. If you cannot catch up the hints from the interviewee,


## 5. If you totally don't know the answer for the question,


## 6. If you don't know the good answer for that question, however you have basic knowledge.


## 7. If you will know the answer when you have more info/details,


## 8. When doing the coding, if the interviewer like communication,


## 9. When doing the coding, if the interviewer doesn't like communication,


## 10. When doing the coding, if the interviewer communicate a lot then suddenly don't want talk since he is busy.


## 11. If the interviewer try to drive you do the system design or algorithm coding,


## 12. If the interviewer has diffrent solution with the solution you are writting.


## 13. How to make the communication be happy, and flow is smoothie.


## 14. How to make the interviewer like you.


# Coding (discuss it with team, no need to gather all members, at least 3 ppl)
## 1. What is your steps to do the coding interview


## 2. how to do clarification?


## 3. how to design test cases for solution?


## 4. Coding style


## 5. write code on different platform
a. google doc (notice coding style)
b. online compiler (https://www.jdoodle.com/online-java-compiler/)
i. 注意常⽤的导包
ii. 注意怎么debug
iii. 注意stream的包怎么导进去
c. Local IDE


## 6. Practice the below coding in different platforms. in main method, design the test cases for your solution and make sure it can pass.
a. 347. Top K Frequent Elements
b. 206. Reverse Linked List
i. you need to design the ListNode
c. 3. Longest Substring Without Repeating
d. 43. Multiply Strings


## 7. FYI
a. If input array is sorted, then
i. Binary Search
ii. Two Pointers
b. If asked for all permutations/subsets, then
i. Backtracking
c. If given a tree, then
i. DFS
ii. BFS
d. If given a linkedList, then
i. Two Pointers
e. If recursion is banned, then
i. Stack,
ii. Queue
f. If must solve in-place, then
i. Swap corresponding values
ii. store one or more different values in the same postion
g. If asked for maximum/minimum subarray/subset/options, then
i. DP
h. If asked for top/least K items, then
i. Heap - PriorityQueue + lambda
i. If asked for common strings then
i. Map
ii. Trie
j. Else
i. Map/Set for O(1) time & O(n) space
ii. Sort input for O(nlogn) time and O(1) space

# OOD and SD
## 1. Parking lot


## 2. tiny url


## 3. shopping cart


