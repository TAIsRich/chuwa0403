## 1. Explain volatile variables in java? (we also use it in Singleton)

In Java, the keyword "volatile" is used to indicate that a variable's value may be modified by multiple threads and that any changes made to the variable should be immediately visible to all threads. When a variable is marked as volatile, Java guarantees that all reads and writes of that variable are atomic, meaning that they are indivisible and cannot be interrupted. Additionally, Java guarantees that any write to a volatile variable will be visible to all threads immediately, without any caching or optimization that might delay the update.

In Singleton pattern, marking the instance variable as volatile is one way to ensure that the Singleton is thread-safe. When multiple threads access the Singleton at the same time, marking the instance variable as volatile ensures that all threads see the same instance of the Singleton, rather than potentially creating multiple instances. Additionally, marking the instance variable as volatile ensures that any changes made to the Singleton by one thread are immediately visible to all other threads.

## 2. how to create a new thread(Please also consider Thread Pool case)?

1. Extending the Thread class:

```
class MyThread extends Thread {
    public void run() {
        System.out.println("start new thread using extends thread");
    }
}

Thread t = new MyThread();
t.start();

```

2. Implements Runnable:

```
class MyRunnable implements Runnable {
    @Override
    public void run() {
       System.out.println("start new thread using Runnable"); 
    }
}

Thread t2 = new Thread(new MyRunnable());
t2.start();
```

3. Implements Callable:

```
class MyCallable implements Callable<String> {
    @Override
    public String call() throws Exception {
       Thread.sleep(5000);
       return "Start new thread using Callable";
    }
}
```

4. Thread Pool

Thread Pool is a way to manage a group of threads, so that the threads can be reused and the overhead of creating new threads can be avoided. To create a thread pool in Java, you can use the Executor framework, which provides a set of classes and interfaces for thread management.

```
ExecutorService executor = Executors.newFixedThreadPool(10);
executor.execute(new MyRunnable());
executor.shutdown();
```

## 3. Difference between Runnable and Callable

1. Return value: Runnable's run() method does not return a value, while Callable's call() method returns a value of the specified type.
2. Exceptions: Runnable's run() method does not throw any checked exceptions, while Callable's call() method can throw a checked exception of the specified type.
3. Future object: When a task is submitted to an ExecutorService using a Callable, it returns a Future object, which can be used to retrieve the result of the computation when it becomes available. This is not possible with Runnable.

## 4. what is the diff between t.start() and t.run()?

1. t.start() starts a new thread to execute the task(run()). When the start() method is called, the JVM creates a new thread and calls the run() method of the Thread object in that new thread. The code in the run() method runs in the new thread, while the current thread continues to execute concurrently.

2. t.run() execute the task in the current thread. The run() method runs the code of the Thread object in the current thread, without starting a new thread. When the run() method is called, the code in the run() method runs synchronously in the current thread, just like any other method call.

## 5. Which way of creating threads is better: Thread class or Runnable interface?

Runnable interface is better. 
1. Improved flexibility: When you create a new thread by implementing the Runnable interface, your class can still extend other classes and implement other interfaces. This provides greater flexibility in your application design and allows you to separate the task logic from the thread management logic.
2. Better resource utilization: When you create a new thread by subclassing the Thread class, a new object is created every time a new thread is created. This can lead to unnecessary resource utilization, especially if you are creating a large number of threads. By using the Runnable interface, you can reuse a single object across multiple threads, which can improve the performance and scalability of your application.
3. Thread pooling: When you use the Runnable interface, it becomes easier to implement thread pooling, which can help to further improve the performance of your application. By reusing threads from a pool, you can avoid the overhead of creating and destroying threads for every task.

## 6. what is the thread status?

1. NEW: When a thread is created but not yet started, it is in the NEW state.
2. RUNNABLE: When a thread is started and is running, it is in the RUNNABLE state. This means that the thread is executing its task, or waiting to be assigned a processor by the operating system.
3. BLOCKED: When a thread is blocked, it is unable to run because it is waiting for a monitor lock. This can happen when a thread attempts to enter a synchronized block that is already held by another thread. When a thread is blocked, it is in the BLOCKED state.
4. WAITING: When a thread is waiting, it is in a state of suspended animation. This can happen when a thread calls the wait() method on an object, or when it waits for another thread to finish using the join() method. When a thread is waiting, it is in the WAITING state.
5. TIMED_WAITING: When a thread is in a state of timed waiting, it is waiting for a certain amount of time before it can resume execution. This can happen when a thread calls the sleep() method, or when it waits for I/O operations to complete. When a thread is in a state of timed waiting, it is in the TIMED_WAITING state.
6. TERMINATED: When a thread has finished executing its task, or has been terminated by an external event, it is in the TERMINATED state. Once a thread is terminated, it cannot be restarted.

## 7. difference between wait() and sleep() method

1. wait() is used for inter-thread communication, while sleep() is used for general-purpose delay.
2. wait() releases the lock on the object, while sleep() does not release any locks.
3. wait() is called on an object, while sleep() is called on a thread.
4. wait() can only be called inside a synchronized block or method, while sleep() can be called anywhere in the program.

## 8. What is deadlock?

Deadlock is a situation in multithreaded programming where two or more threads are blocked forever, waiting for each other to release a resource that they need in order to proceed. In a deadlock situation, none of the threads can continue execution, and the program becomes unresponsive. Deadlock occurs when two or more threads acquire locks on resources in different orders. For example, consider two threads, A and B, that both need to acquire locks on resources X and Y. If thread A acquires a lock on resource X and thread B acquires a lock on resource Y, but then thread A also needs to acquire a lock on resource Y while thread B needs to acquire a lock on resource X, a deadlock occurs.

## 9. how do threads communicate with each other?

1. Shared memory: Threads can communicate by sharing memory, where they read and write data to the same memory location. However, synchronization is crucial to prevent race conditions or other synchronization issues.
2. Message passing: Threads can communicate by sending messages to each other through a shared data structure, such as a queue or a buffer. The sender thread places messages in the shared data structure, while the receiver thread reads messages from it.
3. Synchronization: Threads can communicate by synchronizing access to shared resources using locks, semaphores, or other synchronization primitives. These mechanisms ensure that only one thread can access the shared resource at a time.
4. Signals: Threads can communicate using signals, where one thread sends a signal to another thread to indicate that a certain event has occurred. Signals can be used to coordinate actions between threads.
5. Event listeners: Threads can communicate using event listeners, where one thread listens for events triggered by another thread. This can be useful in GUI applications, where one thread handles user input and another thread updates the display.

## 10. what is join() method?

In Java, the join() method is a method of the Thread class that allows one thread to wait for the completion of another thread before continuing its execution. When a thread calls the join() method on another thread, the calling thread is blocked and waits for the target thread to complete its execution. Once the target thread completes, the calling thread is unblocked and continues its execution. The join() method can be useful in situations where one thread depends on the results of another thread before it can proceed.


## 11. what is yield() method?

The yield() method is used in Java to hint the task scheduler to move the currently executing task to the Ready state and move another task or thread to the running state. The task scheduler is free to ignore the hint. Through the yield() method, a thread is willing to yield or relinquish its current use of the processor. The yield() method is typically used in situations where a thread is performing a long-running operation, and the programmer wants to ensure that other threads have a chance to run as well. However, it is important to note that yield() should not be used as a substitute for proper thread synchronization, as it does not guarantee any specific order or timing of execution between threads.

## 12. Explain thread pool

A thread pool is a collection of pre-created threads that are available for performing a set of tasks. A thread pool maintains a pool of threads that can be reused to perform multiple tasks. The thread pool is typically created with a fixed number of threads, and when a new task is submitted, a free thread from the pool is assigned to handle the task. Once the task is completed, the thread is returned to the pool and made available for the next task. Java provides a built-in thread pool implementation called the Executor framework. The Executor framework provides a set of interfaces and classes for managing thread pools and executing tasks. It allows you to create different types of thread pools, such as fixed-size, cached, and scheduled thread pools, and provides a simple API for submitting tasks to the thread pool.

## 13. What is Executor Framework in Java, its different types and how to create these executors?

The Executor framework is a built-in Java framework that provides a standardized way of executing tasks in a background thread. The framework provides a set of interfaces and classes for managing thread pools and executing tasks asynchronously, which can help to improve the performance of multi-threaded applications.

1. ThreadPoolExecutor: This is the most common type of executor and provides a fixed-size pool of worker threads that can execute tasks concurrently. You can create a ThreadPoolExecutor using the Executors.newFixedThreadPool() method.
2. ScheduledThreadPoolExecutor: This executor is used for executing tasks at a scheduled time or repeatedly at a fixed interval. You can create a ScheduledThreadPoolExecutor using the Executors.newScheduledThreadPool() method.
3. CachedThreadPoolExecutor: This executor creates new threads as needed and reuses idle threads if available. You can create a CachedThreadPoolExecutor using the Executors.newCachedThreadPool() method.
4. SingleThreadExecutor: This executor creates a single thread that executes tasks sequentially. You can create a SingleThreadExecutor using the Executors.newSingleThreadExecutor() method.

## 14. Difference between shutdown() and shutdownNow() methods of executor

1. shutdown(): shutdown() initiates an orderly shutdown of the executor service. It allows previously submitted tasks to execute before shutting down the executor. The shutdown() method does not forcibly terminate the executor or the tasks that are currently executing. Instead, it sets a flag that prevents new tasks from being submitted and waits for the existing tasks to complete before shutting down the executor.
2. shutdownNow(): shutdownNow() attempts to stop the executor immediately. It interrupts any running tasks and prevents pending tasks from starting. It returns a list of tasks that were waiting to be executed but were never started. The shutdownNow() method may not immediately terminate the executor service, as some tasks may not respond to interruption and continue to execute.

## 15. What is Atomic classes? when do we use it?

Atomic classes are a programming concept that relates to the synchronization of data between threads in a multi-threaded environment. An atomic class is a class that guarantees that read and write operations on its instances are atomic, which means that these operations will appear to occur instantaneously from the perspective of other threads. Atomic classes are typically used when multiple threads access the same data and changes made by one thread can affect the behavior of other threads. In such cases, using atomic classes ensures that each thread sees the latest value of the shared data, without interference from other threads. In Java, the java.util.concurrent.atomic package provides a set of atomic classes, such as AtomicInteger, AtomicLong, and AtomicReference, that can be used to create instances of atomic variables. These classes provide methods such as getAndIncrement(), getAndSet(), and compareAndSet(), which perform atomic operations on the variable.


## 16. What is the concurrent collections?

Concurrent collections are a set of thread-safe collections that can be accessed concurrently by multiple threads without the need for external synchronization. They provide efficient and safe access to shared data structures, allowing multiple threads to read, write, and modify the collection simultaneously. The concurrent collections are particularly useful in multi-threaded applications where multiple threads may need to access and modify the same collection simultaneously. By using a concurrent collection, developers can ensure that the data is safely shared between threads, without the need for explicit locking or synchronization.

For example:

Interface         NON-THREAD-SAFE                THREAD-SAFE
List              ArrayList                      CopyOnWriteArrayList
Map               HashMap                        ConcurrentHashMap
Set               HashSet/TreeSet                CopyOnWriteArraySet
Queue             ArrayDeque/LinkedList          ArrayBlockingQueue/LinkedBlockingQueue
Deque             ArrayDeque/LinkedList          LinkedBlockingDeque

## 17. what kind of locks you know?

1. Mutex Lock: A mutex (short for "mutual exclusion") lock is a basic type of lock used to ensure that only one thread can access a shared resource at a time. Mutex locks are typically used to protect critical sections of code, where multiple threads might otherwise try to modify the same data simultaneously.
2. Read/Write Lock: A read/write lock is a type of lock that allows multiple threads to read a shared resource simultaneously, but only one thread to write to the resource at a time. This is useful when there are multiple readers but infrequent writers, as it can improve performance by reducing contention between threads.
3. Reentrant Lock: A reentrant lock is a type of lock that allows a thread to acquire the same lock multiple times without deadlocking. This is useful in situations where a thread needs to call a method that uses the same lock, as it prevents other threads from acquiring the lock while the first thread is still holding it.
4. Spin Lock: A spin lock is a type of lock that repeatedly polls a shared resource until it becomes available. This is useful in situations where the time spent waiting for a lock to become available is expected to be short, as it avoids the overhead of blocking and unblocking threads.
5. Semaphore: A semaphore is a type of lock that allows a fixed number of threads to access a shared resource simultaneously. This is useful in situations where the resource can support a limited number of concurrent users, such as a database connection pool.

## 18. What is the difference between class lock and object lock?

The main difference between object locks and class locks is that object locks are used to synchronize access to instance variables and methods of an object, while class locks are used to synchronize access to static variables and methods of a class.

1. Scope: Object locks are associated with individual instances of a class, while class locks are associated with the class itself.
2. Availability: Object locks are available only for instances of a class, while class locks are available for the class itself.
3. Usage: Object locks are typically used to protect critical sections of code that involve instance variables, while class locks are used to protect critical sections of code that involve static variables.
4. Lock granularity: Object locks provide finer granularity than class locks, as each object can have its own lock, while class locks are shared by all instances of a class.

## 19. What is future and completableFuture?

Future is a basic interface that was introduced in Java 5. It represents the result of an asynchronous operation that has not yet been completed. A Future object can be used to check whether the operation has completed, and to retrieve the result of the operation when it is complete. However, the Future interface does not provide a way to explicitly set the result of the operation.

CompletableFuture is a more advanced class that was introduced in Java 8. It extends the Future interface and provides additional methods for creating, combining, and manipulating asynchronous operations. CompletableFuture objects can be used to specify a chain of operations that should be executed when the original operation completes, allowing for more complex workflows. One of the main advantages of CompletableFuture is that it supports asynchronous chaining of operations. This means that one operation can be executed as soon as the previous operation completes, without blocking the thread. Additionally, CompletableFuture provides a way to explicitly set the result of an operation, using methods such as complete(), completeExceptionally(), and obtrudeValue(). CompletableFuture also provides a way to specify a custom executor for executing the asynchronous operations. This allows for greater control over the thread pool used for executing the operations, which can improve performance in some cases.

## 20. what is ThreadLocal?

ThreadLocal is a class that allows you to create variables that are local to a thread. In other words, each thread that accesses a ThreadLocal variable has its own, independently initialized copy of the variable. The ThreadLocal class is often used in multithreaded programs where each thread needs its own instance of a variable, but the variable is not thread-safe. By using a ThreadLocal variable, each thread can have its own instance of the variable, without the need for synchronization.

## 21. Type the code by your self and try to understand it. (package com.chuwa.tutorial.t08_multithreading)

See Coding/multithread

## 22. Read those interview questions and pick some important questions to this home work.

1. What is the diff between t.start() and t.run()?
2. How to create a new thread(Please also consider Thread Pool case)?
3. Explain volatile variables in java? (we also use it in Singleton)
4. What is deadlock?
5. Explain thread pool
6. What kind of locks you know?

## 23. write a code to create 2 threads, one thread print 1,3,5,7,9, another thread print 2,4,6,8,10. 

1. See Coding/multithread/hw6/OddEventPrinter.java
2. See Coding/multithread/hw6/OddEventPrinter2.java 

## 24. Create 3 threads, one thread ouput 1-10, one thread output 11-20, one thread output 21-22. threads run sequence is random.

See Coding/multithread/hw6/PrintNumber1.java 

## 25. completable future

1. Homework 1: Write a simple program that uses CompletableFuture to asynchronously get the sum and product of two integers, and print the results.

See Coding/multithread/hw6/hw1.java

2. Homework 2: Assume there is an online store that needs to fetch data from three APIs: products, reviews, and inventory. Use CompletableFuture to implement this scenario and merge the fetched data for further processing.
(https://jsonplaceholder.typicode.com/)

See Coding/multithread/hw6/hw2.java

3. Homework 3: For Homework 2, implement exception handling. If an exception occurs during any API call, return a default value and log the exception information.

See Coding/multithread/hw6/hw3.java


