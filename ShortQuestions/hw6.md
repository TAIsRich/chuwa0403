## 1.  Explain volatile variables in java? (we also use it in Singleton)
In Java, a volatile variable is a type of variable that is used to indicate that its value may be modified by multiple threads. When a variable is declared as volatile, the compiler and the runtime system are informed that the variable's value may be modified asynchronously, and that access to the variable should always be synchronized.

The use of the volatile keyword ensures that the value of the variable is read directly from memory, rather than being cached in a thread's local memory. This means that any changes made to the variable by one thread will be immediately visible to other threads that access the same variable.


## 2.  how to create a new thread(Please also consider Thread Pool case)?
1 extend thread class
2 implement runnable
3 implement callable
4 lambda expression
5 use Executor


## 3.  Difference between Runnable and Callable
Runnable doesn't have return value;


## 4.  what is the diff between t.start() and t.run()?
If you want to create a new thread and execute the code in the run() method concurrently with the main thread, you should call the start() method. If you simply want to execute the code in the run() method in the current thread of execution, you can call the run() method directly. However, calling the run() method directly does not provide any concurrency or parallelism, and is typically not what you want to do when working with threads.


## 5.  Which way of creating threads is better: Thread class or Runnable interface?
It depends on the situations.  If you only need to perform a single task in the thread and don't need to extend any other classes, using the Thread class is simpler and more convenient. If you need more flexibility and reusability, or if you need to extend other classes, using the Runnable interface is a better approach.


## 6.  what is the thread status?
`New`: When a thread is created, it is in the new state. The thread has not yet started executing, and the start() method has not yet been called.

`Runnable`: When the start() method is called on a thread, it becomes runnable. The thread is now eligible to run, but it has not yet been selected by the scheduler to run.

`Running`: When the thread scheduler selects the thread to run, it enters the running state. The thread is now executing its run() method.

`Blocked`: A thread can be blocked when it is waiting for a monitor lock or for input/output operations to complete. When a thread is blocked, it is temporarily inactive and cannot run until the lock or operation is completed.

`Waiting`: A thread can be in the waiting state when it is waiting for another thread to perform a specific action. The wait() method can be called on an object to make the current thread wait for another thread to call the notify() or notifyAll() method.

`Timed Waiting`: Similar to the waiting state, a thread can be in the timed waiting state when it is waiting for another thread to perform a specific action, but with a timeout period. The sleep() and join() methods can put the current thread in the timed waiting state.

`Terminated`: When a thread has completed its run() method or an exception is thrown in the run() method, it enters the terminated state. Once a thread is terminated, it cannot be restarted.


## 7. difference between wait() and sleep() method
 The wait() method is used for inter-thread communication, while the sleep() method is used for timing purposes. The wait() method is used when a thread needs to wait for some specific condition to occur, while the sleep() method is used to pause the thread for a specified period of time.


## 8.  What is deadlock?
Deadlock is a situation that can occur in a multi-threaded application where two or more threads are blocked and waiting for each other to release the resources they need to proceed. In a deadlock situation, none of the threads can make progress, and the entire application comes to a standstill.


## 9.  how do threads communicate with each other?
Shared memory: Threads can share data by accessing shared variables or data structures. However, it is important to ensure that the access to shared data is synchronized to prevent race conditions and data inconsistencies.

Message passing: Threads can communicate with each other by sending messages through a communication channel such as a queue or a pipe. The receiving thread can then process the message and respond accordingly.

Signals: Threads can signal each other to indicate the occurrence of an event or the availability of a resource. For example, a thread can signal another thread when a particular task is completed or when a lock is released.

Synchronization constructs: Threads can use synchronization constructs such as semaphores, mutexes, and condition variables to coordinate their activities and prevent conflicts. These constructs can be used to implement various synchronization patterns such as producer-consumer, reader-writer, and barrier synchronization.


## 10. what is join() method?
This method is to wait for the thread to end. If you call t.join() in main, the main will wait for thread t to end.


## 11. what is yield() method
The yield() method is a static method of the Thread class in Java, which is used to pause the current thread and allow other threads of equal priority to run. When a thread calls yield(), it gives up the CPU and goes back to the ready state, allowing other threads to run.


## 12. Explain thread pool
A thread pool is a mechanism in Java that manages a group of worker threads and reuses them to execute a large number of tasks, thereby reducing the overhead of thread creation and destruction. In a thread pool, a fixed number of threads are created upfront, and a queue is maintained to hold the tasks that need to be executed. When a new task arrives, it is added to the queue, and a worker thread from the pool picks up the task and executes it.

The main advantages of using a thread pool are:

`Improved performance`: Thread pools improve the performance of the application by reducing the overhead of thread creation and destruction. Creating and destroying threads are expensive operations, and using a thread pool can reduce this overhead by reusing existing threads.

`Better resource management`: Thread pools provide better resource management by limiting the number of threads that can be created and ensuring that the threads are reused efficiently. This helps to prevent resource exhaustion and improves the stability of the application.

`Easy to use`: Thread pools are easy to use and require minimal coding effort. The developer only needs to create a thread pool, submit tasks to it, and let the thread pool manage the execution of the tasks.


## 13. What is Executor Framework in Java, its different types and how to create these executors?
Executor Framework is a powerful and flexible framework introduced in Java 5 that simplifies the management of threads in applications. It provides a set of interfaces and classes that allow developers to execute tasks in a thread-safe manner, while also providing advanced features such as thread pooling, task scheduling, and load balancing.

There are several types of Executor Frameworks in Java, including:

`Executor`: This is the basic interface of the framework and defines a single method, execute(Runnable command), which accepts a Runnable task for execution.

`ExecutorService`: This extends the Executor interface and provides additional methods for managing and controlling the execution of tasks. It provides methods for submitting tasks, shutting down the executor, and querying the status of the executor.

`ScheduledExecutorService`: This extends the ExecutorService interface and provides additional methods for scheduling tasks to be executed at a specific time or after a specified delay.

To create these executors, you can use the Executors class, which provides factory methods for creating instances of the various executor types. 

```java
ExecutorService executor = Executors.newFixedThreadPool(10);
```


## 14. Difference between shutdown() and shutdownNow() methods of executor
shutdown(): This method initiates an orderly shutdown of the ExecutorService. It stops accepting new tasks, and waits for all previously submitted tasks to complete. It does not interrupt the running threads, but allows them to finish their current tasks.

shutdownNow(): This method attempts to stop all running tasks immediately and prevent new tasks from being submitted. It returns a list of tasks that were submitted but not started, as well as a list of tasks that were running at the time of the shutdown. It does this by interrupting the running threads, which may cause some tasks to terminate prematurely.


## 15. What is Atomic classes? when do we use it?
Atomic classes in Java are a set of thread-safe classes that provide atomic operations on single variables. These classes are useful in multi-threaded programming scenarios where multiple threads access and modify the same variable concurrently.

The atomic classes provide several methods that perform atomic operations such as read-modify-write operations on the variables, and ensure that these operations are executed atomically and thread-safe. The atomic classes also ensure that any changes made to the variables are visible to all threads immediately, without the need for explicit synchronization.

Some examples of atomic classes in Java are AtomicInteger, AtomicLong, and AtomicReference. These classes are typically used in high-concurrency applications, such as web servers, where multiple threads access and modify shared variables frequently.


## 16. What is the concurrent collections?
The thread-safe version of custom collections


## 17.  what kind of locks you know? 
Synchronized blocks/methods: Synchronized blocks and methods use intrinsic locks to ensure that only one thread at a time can execute a synchronized block or method on a given object.

ReentrantLock: ReentrantLock is a more flexible alternative to synchronized blocks, allowing more fine-grained control over locking and unlocking operations. It also supports features such as fairness, which ensures that the lock is granted in a first-come, first-served order.

ReadWriteLock: ReadWriteLock provides a mechanism for controlling access to shared resources that can be read by multiple threads but only written by one thread at a time. It allows multiple threads to read the resource concurrently, but only one thread can hold the write lock at a time.

StampedLock: StampedLock is a new lock introduced in Java 8 that supports optimistic locking, which can be more efficient than traditional locks in certain scenarios. It also supports read and write locks, and provides several modes for controlling access to shared resources.

Semaphore: Semaphore is a concurrency primitive that allows a fixed number of threads to access a shared resource concurrently. It can be used to limit the number of concurrent accesses to a resource, or to ensure that a certain number of resources are available at any given time.

CountDownLatch: CountDownLatch is a synchronization aid that allows one or more threads to wait until a set of operations being performed in other threads completes. It can be used to coordinate the execution of multiple threads or to ensure that certain conditions are met before continuing with the execution of a program.


## 18. What is the difference between class lock and object lock?
Object locks synchronize access to the instance (non-static) methods or blocks of code in the object by allowing only one thread to execute the code at a time. This means that multiple threads can execute the code in different objects simultaneously.

Class locks synchronize access to the static methods or blocks of code in the class by allowing only one thread to execute the code at a time. This means that multiple threads can execute the code in different objects simultaneously but not in the same static method or block of code at the same time.

In other words, object locks provide a way to control access to instance-specific code, while class locks provide a way to control access to class-level code.


## 19. What is future and completableFuture?
In Java, a `Future` represents the result of an asynchronous computation. It is a placeholder object that will eventually contain the result of a computation that has been submitted to an ExecutorService.

A `CompletableFuture` is an implementation of the Future interface that provides additional features for working with asynchronous computations. It allows for chaining of multiple asynchronous operations and provides a way to explicitly complete a computation.

One of the key differences between Future and CompletableFuture is that Future is a passive placeholder that can only be queried for the status of the computation and the result, while CompletableFuture is an active object that can be used to control the computation and combine multiple asynchronous operations.


## 20. what is ThreadLocal?
`ThreadLocal` is a class in Java that provides thread-local variables. A thread-local variable is a variable whose value is local to the thread on which it is called. This means that each thread that accesses the variable will have its own independent copy of the variable. The ThreadLocal class provides a simple way to create thread-local variables.

In other words, a ThreadLocal variable is a variable that is stored in a special data structure that is local to a thread. Each thread that accesses the variable will have its own copy of the variable that is independent of the copies of the variable in other threads.

ThreadLocal variables are typically used to store state that is local to a thread, such as configuration settings, user preferences, or database connections. This allows each thread to maintain its own state without interfering with the state of other threads.

## 21. Type the code by your self and try to understand it. (package com.chuwa.tutorial.t08_multithreading)
Check folder Coding/hw6_multithreading_practice


## 22. Read those interview questions and pick some important questions to this home work.
What is the difference between deep copy and shallow copy in Java, and how would you implement them?
How does Java handle multiple inheritance, and what are the limitations of this approach?
Explain the difference between overloading and overriding methods in Java, and give an example of each.
What is reflection in Java, and how would you use it to access private methods and fields?
What is the difference between a checked and unchecked exception in Java, and why is this distinction important?
How does Java implement garbage collection, and what are the advantages and disadvantages of this approach?
What is the Java Virtual Machine (JVM), and how does it work?


## 23. write a code to create 2 threads, one thread print 1,3,5,7,9, another thread print 2,4,6,8,10. (solution is in com.chuwa.tutorial.t08_multithreading.c05_waitNotify.OddEventPrinter)
a. One solution use synchronized and wait notify 
b. One solution use ReentrantLock and await, signal

Check folder Coding/hw6_23


## 24. create 3 threads, one thread ouput 1-10, one thread output 11-20, one thread output 21-22. threads run sequence is random. (solution is in com.chuwa.exercise.t08_multithreading.PrintNumber1)
Check folder Coding/hw6_24



## 25. completable future:
a. Homework 1: Write a simple program that uses CompletableFuture to asynchronously get the sum and product of two integers, and print the results.
b. Homework 2: Assume there is an online store that needs to fetch data from three APIs: products, reviews, and inventory. Use CompletableFuture to implement this scenario and merge the fetched data for further processing. (需要找public api去模拟，)
    i.  Sign In to Developer.BestBuy.com
    ii. Best Buy Developer API Documentation (bestbuyapis.github.io)
    iii.  可以用fake api https://jsonplaceholder.typicode.com/
c.  Homework 3: For Homework 2, implement exception handling. If an exception occurs during any API call, return a default value and log the exception information

Check folder Coding/hw6_completable_future



