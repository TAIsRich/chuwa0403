# HW6

## 1. Explain `volatile` variables in java? (we also use it in Singleton)
`volatile` keyword is used to declare a variable whose value may be modified by multiple threads, and ensures that changes to the variable are immediately visible to all threads without the need for explicit synchronization.

One common use case for `volatile` variables is in the implementation of the double-checked locking pattern for Singleton objects. In this pattern, a class's constructor is made private to prevent direct instantiation, and a static method is provided to obtain a single instance of the object. To improve performance, the Singleton instance is lazily initialized only when needed, and double-checked locking is used to ensure that only one instance of the object is created even when multiple threads try to create the instance concurrently.
```java
public class Singleton {
    private static volatile Singleton instance;

    private Singleton() {
        // private constructor to prevent direct instantiation
    }

    public static Singleton getInstance() {
        if (instance == null) {
            synchronized (Singleton.class) {
                if (instance == null) {
                    instance = new Singleton();
                }
            }
        }
        return instance;
    }
}
```
In this example, the `instance` variable is declared as `volatile` to ensure that changes to its value (i.e., the creation of the Singleton object) are immediately visible to all threads. Without the use of `volatile`, there may be scenarios where one thread creates the instance but other threads still see the old, uninitialized value of the variable, leading to multiple instances being created. By using `volatile`, we ensure that the `instance` variable is accessed and modified atomically, without the need for explicit synchronization, thus preventing race conditions in the Singleton creation process.

## 2. How to create a new thread(Please also consider Thread Pool case)?
1. Extending the `Thread` class:
```java
public class MyThread extends Thread {
    @Override
    public void run() {
        // code to be executed in the new thread
    }
}

// Creating and starting a new thread
MyThread myThread = new MyThread();
myThread.start();
```
2. Implementing the `Runnable` interface:
```java
public class MyRunnable implements Runnable {
    @Override
    public void run() {
        // code to be executed in the new thread
    }
}

// Creating and starting a new thread using Runnable
MyRunnable myRunnable = new MyRunnable();
Thread thread = new Thread(myRunnable);
thread.start();
```
3. Implements `Callable`:
```java
public class MyCallable implements Callable<String> {
    @Override
    public String call() throws Exception {
        // code to be executed in the new thread
        return "Hello from Callable!";
    }
}
```
4. Using an Executor and a Thread Pool:
```java
public class MyCallable implements Callable<String> {
    @Override
    public String call() throws Exception {
        // code to be executed in the new thread
        return "Hello from Callable!";
    }
}
public class Main {
    public static void main(String[] args) throws Exception {
        // Creating and starting a new thread using Callable
        MyCallable myCallable = new MyCallable();
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        Future<String> future = executorService.submit(myCallable);
        executorService.shutdown();

        // Retrieving the result from the Callable
        String result = future.get();
        System.out.println(result);
    }
}
```
## 3. Difference between `Runnable` and `Callable`
| Feature                | Runnable                                         | Callable                                                                                    |
|------------------------|--------------------------------------------------|---------------------------------------------------------------------------------------------|
| Return value           | **Does not** return value                        | Can return a value of type `V`                                                              |
| Exception handling     | Cannot throw checked exceptions                  | Can throw checked exceptions                                                                |
| Usage with Executors   | Can be used with `Executor` or `ExecutorService` | Can be used with `ExecutorService`                                                          |
| Interface methods      | `void run()`                                     | `V call()`                                                                                  |
| Handling of exceptions | Need to be handled within `run()` method         | Need to be handled by caller using try-catch blocks or propagated further up the call stack |
| Flexibility            | Simpler interface                                | More powerful, provides `Future` for result retrieval and exception handling                |

## 4. What is the diff between t.start() and t.run()?
1. `t.start()`: This method starts a new thread of execution for the thread represented by the `t` object. It creates a new thread and invokes the `run()` method on that thread in a separate thread of execution. The `start()` method returns immediately, allowing the calling thread to continue executing independently of the new thread. The `run()` method of the thread will be executed concurrently with the calling thread.

2. `t.run()`: This method invokes the `run()` method of the thread represented by the `t` object in the same thread of execution as the calling thread. It does not create a new thread. The `run()` method will be executed sequentially in the calling thread, and the calling thread will block until the `run()` method completes. This means that the `run()` method will run to completion before the calling thread continues executing.

`t.start` starts a new thread to execute the task `run()`

`t.run()` execute the task in the current thread.

## 5. Which way of creating threads is better: Thread class or Runnable interface?
It is recommended to use the Runnable interface over extending the Thread class for creating threads in Java, as it promotes better separation of concerns, improved flexibility, and reusability.

## 6. What is the thread status?
The thread statuses represent the current state of a thread during its lifecycle.

1. NEW: The thread is in a newly created state and has not yet started.
2. RUNNABLE: The thread is in a runnable state and may be executing, or waiting to be assigned a CPU by the scheduler.
3. BLOCKED: The thread is blocked and waiting for a monitor lock to be released by another thread.
4. WAITING: The thread is waiting indefinitely for another thread to perform a particular action before it can continue.
5. TIMED_WAITING: The thread is waiting for a specified period of time for another thread to perform a particular action before it can continue.
6. TERMINATED: The thread has completed its execution and has terminated.

## 7. Difference between wait() and sleep() method
| Feature | `wait()` | `sleep()` |
|---------|----------|-----------|
| Usage | Used for inter-thread communication | Used for suspending thread execution |
| Class | Defined in `Object` | Defined in `Thread` |
| Monitor Release | Releases lock on object, allowing other threads to acquire it | Does not release any locks |
| Notification | Involves notifications with `notify()` and `notifyAll()` | Does not involve any notifications |
| Exception Handling | Must be called within synchronized block, can throw `InterruptedException` | Does not require synchronized block, can throw `InterruptedException` |
| Time Precision | Does not take time parameter | Takes time parameter in milliseconds, can take nanoseconds |
| Behavior | Waits until notified or interrupted | Sleeps for specified time duration |
| Usage Context | Inter-thread communication, coordination among threads | Temporary thread suspension for timing purposes |

## 8. What is deadlock?
Deadlock is a state in which two or more threads are mutually blocking each other, resulting in a situation where none of them can make progress.

Deadlock occurs when multiple threads are competing for shared resources, and each thread holds a resource while waiting for another resource that is currently held by another thread. As a result, all threads are blocked, and the program comes to a halt, unable to proceed further.

## 9. How do threads communicate with each other?
1. Thread synchronization constructs: Java provides built-in synchronization constructs, such as **locks**, semaphores, and conditions, which threads can use to coordinate their actions and enforce synchronization among themselves. These constructs allow threads to wait for specific conditions to be met, signal other threads, and coordinate their execution.

2. Inter-thread communication (ITC) mechanisms: Java provides ITC mechanisms, such as `wait()`, `notify()`, and `notifyAll()`, which can be used by threads to communicate with each other by signaling and waiting for notifications. These mechanisms are typically used in combination with synchronized blocks or methods to ensure proper coordination among threads.

## 10. What is join() method?
The `join()` method is a method provided by the `Thread` class in Java, and it is used to wait for a thread to complete its execution before the calling thread continues its own execution. When a thread calls the `join()` method on another thread, the calling thread will block and wait for the target thread to complete its execution before proceeding further.

## 11. What is yield() method
The `yield()` method is a method provided by the `Thread` class in Java, and it is used to give a hint to the scheduler that the current thread is willing to yield its execution time to other threads. When a thread calls the `yield()` method, it indicates that it is willing to pause its execution and allow other threads to run, although there is no guarantee that the scheduler will actually yield the CPU time to other threads.
```java
Thread t1 = new Thread(() -> {
    // Task to be performed by thread t1
    for (int i = 0; i < 10; i++) {
        System.out.println("Thread t1: " + i);
        Thread.yield(); // Yield execution to other threads
    }
});

Thread t2 = new Thread(() -> {
    // Task to be performed by thread t2
    for (int i = 0; i < 10; i++) {
        System.out.println("Thread t2: " + i);
        Thread.yield(); // Yield execution to other threads
    }
});

t1.start(); // Start thread t1
t2.start(); // Start thread t2
```
In this example, threads `t1` and `t2` will alternate their execution due to the `yield()` method calls, allowing each other to run, although the exact interleaving of their output is not guaranteed.

## 12. Explain thread pool
A thread pool is a managed pool of threads that are created and maintained for the purpose of executing tasks concurrently. Thread pools are used to optimize the creation and management of threads in multi-threaded applications, providing a way to reuse threads instead of creating new threads for every task, which can be expensive in terms of time and resources.

Thread pools typically consist of a fixed number of threads that are pre-created and kept alive in the pool until the application terminates. When a task needs to be executed, it is submitted to the thread pool, and one of the idle threads from the pool is assigned to execute the task. Once the task is completed, the thread is returned to the pool, ready to be assigned to another task.

## 13. What is Executor Framework in Java, its different types and how to create these executors?
The Executor Framework provides a high-level API for managing threads and executing tasks concurrently in a controlled and efficient manner. It provides a way to create and manage thread pools, which are a group of pre-created threads that are available for executing tasks concurrently, without the overhead of creating and terminating threads for every task.

There are several types of thread pools that can be created using the Executor Framework, including:

1. Fixed Thread Pool: This type of thread pool has a fixed number of threads that are created and maintained in the pool. Once all the threads are busy, any additional tasks are queued until a thread becomes available. You can create a fixed thread pool using the `Executors.newFixedThreadPool(int nThreads)` method, where `nThreads` is the number of threads in the pool.

2. Cached Thread Pool: This type of thread pool dynamically creates and terminates threads based on the workload. If a thread is idle for a certain period of time, it may be terminated to reduce resource usage. If a new task arrives and no idle thread is available, a new thread may be created. You can create a cached thread pool using the **Executors.newCachedThreadPool()** method.

3. Scheduled Thread Pool: This type of thread pool is used for scheduling tasks to run at specified intervals or after a delay. It maintains a fixed number of threads that are used to execute tasks at scheduled times. You can create a scheduled thread pool using the **Executors.newScheduledThreadPool(int corePoolSize)** method, where **corePoolSize** is the number of threads in the pool.

4. Single-Thread Executor: This type of thread pool maintains only one thread that sequentially executes tasks in the order they are submitted. If a task is currently being executed, any additional tasks are queued until the current task completes. You can create a single-thread executor using the **Executors.newSingleThreadExecutor()** method.

```java
// Creating a fixed thread pool with 5 threads
ExecutorService executor = Executors.newFixedThreadPool(5);

// Creating a cached thread pool
ExecutorService executor = Executors.newCachedThreadPool();

// Creating a scheduled thread pool with 10 threads
ScheduledExecutorService executor = Executors.newScheduledThreadPool(10);

// Creating a single-thread executor
ExecutorService executor = Executors.newSingleThreadExecutor();
```

## 14. Difference between shutdown() and shutdownNow() methods of executor
`shutdown()`: This method initiates a graceful shutdown of the executor, allowing the threads in the executor's thread pool to complete their current tasks before terminating. It does not accept new tasks for execution, but it allows the already submitted tasks to complete. The `shutdown()` method returns immediately without blocking and does not throw an exception. It returns `void`.

`shutdownNow()`: This method attempts to forcefully stop the threads in the executor's thread pool and terminate their execution immediately, regardless of whether they have completed their tasks or not. It also interrupts the threads that are currently waiting for tasks to be executed. The `shutdownNow()` method returns a list of `Runnable` tasks that were submitted but not started or completed. It may throw `InterruptedException` if the thread executing the method is interrupted while waiting for threads to terminate.

| Feature             | `shutdown()`     | `shutdownNow()`  |
|---------------------|------------------|------------------|
| Graceful Shutdown   | Yes              | No               |
| Completion of Current Tasks | Allowed | Not Guaranteed |
| Accept New Tasks    | No               | No               |
| Return Type         | `void`           | `List<Runnable>` |
| Exception           | None             | `InterruptedException` |

## 15. What is Atomic classes? When do we use it?
Atomic classes are used to perform operations on shared variables in a concurrent multi-threaded environment, ensuring consistency and avoiding race conditions.

Atomic classes are typically used when multiple threads need to perform operations on a shared variable simultaneously, and we want to ensure that the operations are executed in an atomic, thread-safe manner without the need for explicit synchronization using synchronized blocks or locks.

1. Counters: When multiple threads need to increment or decrement a counter, Atomic classes such as `AtomicInteger`, `AtomicLong`, etc. can be used to ensure that the increments or decrements are performed atomically and without race conditions.

2. Flags and status indicators: When multiple threads need to read or update a boolean flag or status indicator, Atomic classes such as `AtomicBoolean` can be used to ensure that the updates are atomic and visible to all threads.

## 16. What is the concurrent collections?
Concurrent collections in Java are specialized collections designed for concurrent, multi-threaded environments where multiple threads can access and modify the collection concurrently without explicit synchronization.

Concurrent collections are designed to offer high performance in concurrent multi-threaded environments, while ensuring thread-safety and correctness. They are optimized for concurrent access and typically use lock-free or fine-grained locking techniques to minimize contention and provide scalable performance.

| INTERFACE | NON-THREAD-SAFE           | THREAD-SAFE                            |
|-----------|---------------------------|----------------------------------------|
| List      | ArrayList                 | CopyOnWriteArrayList                   |
| Map       | HashMap                   | ConcurrentHashMap                      |
| Set       | HashSet/TreeSet           | CopyOnWriteArraySet                    |
| Queue     | ArrayDeque/LinkedList     | ArrayBlockingQueue/LinkedBlockingQueue |
| Deque     | ArrayDeque/LinkedList     | LinkedBlockingDeque                    |

## 17. What kind of locks you know?
1. `synchronized`: The `synchronized` keyword in Java is used to provide mutual exclusion and synchronization between threads. It can be applied to methods or blocks of code to ensure that only one thread can execute the synchronized portion at a time, preventing concurrent access and modification to shared resources.

2. `ReentrantLock`: The `ReentrantLock` class is part of the `java.util.concurrent.locks` package and provides a more flexible and powerful alternative to the `synchronized` keyword. It allows for greater control over locking and unlocking, supports features such as fairness, multiple condition variables, and non-blocking attempts to acquire a lock.

3. `ReadWriteLock`: The `ReadWriteLock` interface, also part of the java.util.concurrent.locks package, provides separate locks for read and write operations. It allows multiple threads to read simultaneously without contention, but only one thread can acquire the write lock at a time, preventing concurrent writes.

4. `StampedLock`: The `StampedLock` class, introduced in Java 8, provides an advanced read-write lock with support for optimistic reading. It allows for multiple readers, but only one writer at a time. It also supports optimistic reads which can be useful in scenarios where reads are more frequent than writes.

5. `Lock` and `Condition` interfaces: The `Lock` and `Condition` interfaces in the `java.util.concurrent.locks` package provide a more fine-grained and flexible way of managing locks and synchronization in concurrent environments. They allow for greater control over locking and unlocking, and support advanced features such as multiple conditions and explicit signaling between threads.

## 18. What is the difference between class lock and object lock?
|                 | Class Lock | Object Lock |
|-----------------|------------|-------------|
| Associated with | Class       | Object      |
| Used for        | Synchronizing access to static methods or static fields | Synchronizing access to instance methods or instance fields |
| Acquired at     | Class level  | Object level |
| Shared among    | All instances of the class | Individual objects |
| Usage example   | `synchronized static void staticMethod()` | `synchronized void instanceMethod()` |

## 19. What is Future and CompletableFuture?
`Future`: `Future` represents the result of an asynchronous computation that may not have completed yet. It provides methods for checking if the computation is done, retrieving the result when it is available, and canceling the computation if desired. However, Future has limited functionality and can only represent a single result of a computation.

`CompletableFuture`:
- An asynchronous programming tool introduced in Java 8.
- Implements the Future interface, providing powerful asynchronous capabilities.
- Supports chaining operations for easy combination and management of multiple asynchronous tasks.
- Non-blocking asynchronous operations.

## 20. What is ThreadLocal?
`ThreadLocal` is a class in Java that provides thread-local variables. It allows you to create variables that are specific to each thread, and their values are not shared among different threads. In other words, each thread that accesses a `ThreadLocal` variable gets its own copy of that variable, and changes made to the variable by one thread do not affect the values of the variable in other threads.

`ThreadLocal` is often used in multithreaded applications where multiple threads share the same instance of an object, but each thread needs to maintain its own state or configuration. It can be used to store thread-specific information, such as user context, transactional state, or request context, without the need for explicit synchronization or passing of thread-specific data between methods or classes.

## 21. Type the code by your self and try to understand it. (package com.chuwa.tutorial.t08_multithreading)
Please check `Coding/java_tutorial/t08_multithreading`


## 23. Write a code to create 2 threads, one thread print 1,3,5,7,9, another thread print 2,4,6,8,10.
Please check `Coding/java_tutorial/c05_waitNotify/OddEventPrinter.java` and `OddEvenReentrantLock.java`.

## 24. Create 3 threads, one thread ouput 1-10, one thread output 11-20, one thread output 21-30. threads run sequence is random.
Please check `Coding/java_tutorial/exercise/multithreading/Q24`.

## 25. completable future:
1. Homework 1: Write a simple program that uses CompletableFuture to asynchronously get the sum and product of two integers, and print the results.  
Please check `Coding/java_tutorial/exercise/multithreading/Q25/CompletableFutureSumProduct`.

2. Homework 2: Assume there is an online store that needs to fetch data from three APIs: products, reviews, and inventory. Use CompletableFuture to implement this scenario and merge the fetched data for further processing. 
   (需要找public api去模拟，)  
Please check `Coding/java_tutorial/exercise/multithreading/Q25/OnlineStoreExample`.

3. Homework 3: For Homework 2, implement exception handling. If an exception occurs during any API call, return a default value and log the exception information.  
Please check `Coding/java_tutorial/exercise/multithreading/Q25/OnlineStoreExampleUpdated`.