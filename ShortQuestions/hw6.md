# HW6

## 1. Explain volatile variables in java? (we also use it in Singleton)

`volatile` keyword is used to indicate that a variable's value may be modified by multiple threads, and therefore its
value should always be read from main memory and not from a thread's local cache.

When a variable is declared as volatile, the compiler and the JVM are instructed to ensure that every read and write
operation performed on that variable is synchronized with main memory. This ensures that the value of the variable is
visible to all threads immediately after it has been modified by one thread.

However, it should be noted that using volatile does not guarantee thread safety on its own. It simply ensures that the
value of the variable is always up-to-date across all threads.

```java
public class Counter {
    private volatile int count = 0;

    public synchronized void increment() {
        count++;
    }

    public int getCount() {
        return count;
    }
}

```

## 2. How to create a new thread(Please also consider Thread Pool case)?

1. Extending the Thread class: This involves creating a new class that extends the Thread class and overriding its run()
   method.
2. Implementing the Runnable interface: This involves creating a new class that implements the Runnable interface and
   overriding its run() method.
3. Implementing the Callable interface and overrides call method
4. Using an Executor framework: Java provides several Executor frameworks like ThreadPoolExecutor

## 3. Difference between Runnable and Callable

1. Return value: The main difference between Runnable and Callable is that the Callable interface allows the thread to
   return a value after its execution, whereas the run() method of the Runnable interface does not return any value.
2. Checked exception: The Callable interface can throw a checked exception, whereas the run() method of the Runnable
   interface cannot throw a checked exception.
3. Usage with Executor framework: The Executor framework can execute both Runnable and Callable tasks, but Callable
   tasks provide a Future object that can be used to get the result of the task when it completes.
4. Usage with Thread class: The Thread class can be used to execute Runnable tasks using its start() method. However,
   the Thread class does not have any direct support for executing Callable tasks.

## 4. what is the diff between t.start() and t.run()?

* `t.start()`: the JVM creates a new thread and invokes the run() method of the thread in that new thread.
* `t.run()`: the run() method of the thread is executed on the same thread as the caller, and there is no new thread
  created.

## 5. Which way of creating threads is better: Thread class or Runnable interface?

The Thread class is suitable when you need to create a thread with custom behavior and state. You can extend the Thread
class and override its methods, such as run(), to define the thread's behavior. This approach can be useful if you need
to define a thread that has its own state, such as member variables, and you want to encapsulate the thread's behavior
within a class.

On the other hand, the Runnable interface is suitable when you need to create a thread to perform a simple task without
any custom behavior or state. You can implement the Runnable interface and provide the task's code in the run() method.
This approach can be useful when you need to perform a simple task, such as printing a message or performing a
calculation, without the need for any additional state.

## 6. What is the thread status?

1. NEW: When a thread is first created using the Thread constructor, it is in the NEW state. In this state, the thread
   has not yet started running.
2. RUNNABLE: When a thread has been started using the start() method, it enters the RUNNABLE state. In this state, the
   thread is executing or is ready to execute, but may not actually be running at this moment due to other threads also
   competing for CPU time.
3. BLOCKED: A thread enters the BLOCKED state when it is waiting to acquire a monitor lock to enter a synchronized block
   or method, and the lock is currently held by another thread. In this state, the thread is blocked and cannot continue
   until it acquires the lock.
4. WAITING: A thread enters the WAITING state when it is waiting for another thread to perform a particular action. For
   example, a thread may wait for a certain amount of time or for a specific signal from another thread. In this state,
   the thread is not actively executing and does not consume CPU time.
5. TIMED_WAITING: This state is similar to the WAITING state, except that the thread is waiting for a specific period of
   time, after which it will automatically resume execution.
6. TERMINATED: When a thread has completed its execution, it enters the TERMINATED state. In this state, the thread is
   no longer running and cannot be restarted.

## 7. Difference between wait() and sleep() method

1. Purpose: The wait() method is used for thread synchronization and communication, whereas the sleep() method is used
   for thread delay or pausing.
2. Object used: The wait() method is invoked on an object, while the sleep() method is invoked on a thread.

3. Monitor lock: The wait() method releases the monitor lock on the object it is invoked on, allowing other threads to
   acquire it and continue executing. The sleep() method does not release any monitor lock.

4. Interrupt: The wait() method can be interrupted by another thread using the interrupt() method, whereas the sleep()
   method cannot be interrupted in this way.

5. Usage with synchronized blocks: The wait() method is used inside synchronized blocks to release the monitor lock and
   wait for a notification from another thread. The sleep() method is not typically used inside synchronized blocks.

## 8. What is deadlock?

A deadlock occurs when two or more threads are blocked waiting for each other to release resources or locks that they
need to continue execution.
In other words, a deadlock is a situation in which two or more threads are blocked indefinitely, and none of them can
continue executing.

## 9. How do threads communicate with each other?

1. **Shared variables**: Threads can communicate by sharing data through variables that are accessible to multiple
   threads. However, when using shared variables, you need to ensure that the access to these variables is synchronized
   properly to prevent data races and ensure thread safety.

2. **Synchronization**: Threads can communicate and coordinate their actions by using synchronization constructs such as
   synchronized blocks or methods, locks, or semaphores. Synchronization ensures that only one thread can access a
   shared resource at a time, preventing race conditions and conflicts.

3. **Wait and notify**: Threads can communicate and coordinate their actions by using wait() and notify() methods
   provided by the Object class. wait() allows a thread to wait until it receives a notification from another thread,
   while notify() sends a signal to a waiting thread to wake it up and resume execution.

4. **Blocking queues**: Threads can communicate by using blocking queues, which are data structures that allow one
   thread to put data into the queue and another thread to take data from the queue. Blocking queues are thread-safe and
   can be used to implement producer-consumer patterns or to pass data between threads.

5. **Callbacks**: Threads can communicate by using callbacks, which are methods that a thread can invoke on another
   object to signal the completion of a task or to receive data from another thread.

## 10. What is join() method?

The join() method is used to wait for a thread to complete its execution before continuing with the execution of the
calling thread. When a thread calls the join() method on another thread, it waits until the other thread completes its
execution or until a specified timeout period elapses.

## 11. what is yield() method

The yield() method is used to give a hint to the scheduler that the current thread is willing to yield its current use
of the CPU, allowing other threads with the same priority to run instead. When a thread calls the yield() method, it may
give up its current time slice and allow another thread to execute, but this behavior is not guaranteed and depends on
the operating system's scheduling algorithm.

## 12. Explain thread pool

A thread pool is a collection of pre-initialized threads that are available to execute tasks submitted by a program.
Thread pools are a common technique for managing the creation and destruction of threads, as they can reduce the
overhead associated with creating new threads for every task.

* FixedThreadPool
* CachedThreadPool
* SingleThreadExecutor

## 13. What is Executor Framework in Java, its different types and how to create these executors?

### interfaces:

* Executor: The Executor interface defines a single method execute() that accepts a Runnable task and executes it
  asynchronously.
* ExecutorService: The ExecutorService interface extends the Executor interface and adds additional methods for managing
  and controlling the execution of tasks.
* ScheduledExecutorService: The ScheduledExecutorService interface extends the ExecutorService interface and adds
  support for scheduling tasks to run at a specified time or with a specified delay.

### implementations:

* ThreadPoolExecutor: This is the most common executor type, which provides a fixed or dynamic pool of worker threads
  that can execute tasks submitted to it.
* ScheduledThreadPoolExecutor: This executor type extends the ThreadPoolExecutor and provides support for scheduling
  tasks to run at a specified time or with a specified delay.
* SingleThreadExecutor: This executor type provides a single worker thread that can execute tasks sequentially, one
  after the other.
* CachedThreadPoolExecutor: This executor type provides a dynamic pool of worker threads that can grow or shrink in size
  depending on the number of tasks submitted to it.

## 14. Difference between shutdown() and shutdownNow() methods of executor

**shutdown() method**: The shutdown() method initiates a graceful shutdown of the executor by allowing any submitted
tasks
to complete their execution before shutting down the executor. This means that any tasks that have been submitted to the
executor but have not yet started executing will be allowed to run to completion, while any tasks that are currently
executing will be allowed to finish before the executor is terminated. However, the shutdown() method does not wait for
all the tasks to complete and returns immediately after initiating the shutdown process.

**shutdownNow() method**: The shutdownNow() method initiates an immediate shutdown of the executor by attempting to stop
all
executing tasks and discarding any pending tasks that have not yet been started. This means that any tasks that have
been submitted to the executor but have not yet started executing will be discarded, and any tasks that are currently
executing will be interrupted and stopped forcefully by calling their interrupt() method. The shutdownNow() method
returns a list of tasks that were submitted to the executor but were not started.

## 15. What is Atomic classes? when do we use it?

Atomic classes are a set of thread-safe classes that provide atomic operations on shared variables without requiring
explicit synchronization. The atomic classes provide a way to perform operations on shared variables that are guaranteed
to be atomic, meaning that they are performed as a single, indivisible unit of operation. The atomic classes in Java
include AtomicInteger, AtomicLong, and AtomicBoolean, among others.

Atomic classes are typically used in multi-threaded programs where multiple threads need to access and modify shared
variables concurrently. By using atomic classes, you can avoid the need for explicit synchronization constructs such as
locks, semaphores, or synchronized blocks, which can be error-prone and can cause performance overhead.

## 16. What is the concurrent collections?

Concurrent collections are a set of thread-safe collections that can be safely accessed and modified by multiple threads
concurrently.

1. `ConcurrentHashMap`: This is a thread-safe implementation of a hash table, which provides fast lookup and insertion
   of key-value pairs.

2. `ConcurrentLinkedQueue` and ConcurrentLinkedDeque: These are thread-safe implementations of a queue and deque,
   respectively, which provide fast insertion and removal of elements.

3. `ConcurrentSkipListMap` and ConcurrentSkipListSet: These are thread-safe implementations of a sorted map and set,
   respectively, which provide fast access to elements in sorted order.

4. `CopyOnWriteArrayList` and CopyOnWriteArraySet: These are thread-safe implementations of a list and set,
   respectively, which provide fast iteration and retrieval of elements.

## 17. What kind of locks you know?

1. ReentrantLock: This is a mutual exclusion lock that allows a thread to acquire and release the lock multiple times.
   ReentrantLock provides a range of advanced features, such as fairness, interruptible lock acquisition, and timed lock
   waits.

2. ReadWriteLock: This is a lock that allows multiple threads to acquire a read lock simultaneously or a single thread
   to acquire a write lock exclusively. ReadWriteLock is useful for optimizing performance in situations where the
   shared resource is frequently read but infrequently modified.

3. StampedLock: This is a lock that provides optimistic locking, which allows multiple threads to read the shared
   resource concurrently and one thread to modify the resource exclusively. StampedLock provides better performance than
   ReadWriteLock in situations where the shared resource is frequently read and infrequently modified.

4. Synchronized: This is a built-in mechanism in Java that allows a block of code or a method to be synchronized,
   meaning that only one thread can execute the synchronized block or method at a time. Synchronized is the most basic
   and commonly used mechanism for synchronization in Java.

5. Semaphore: This is a synchronization construct that allows a fixed number of threads to access a shared resource
   simultaneously. Semaphore is useful in situations where the shared resource has a limited capacity or where the
   number of threads accessing the resource needs to be controlled.

## 18. What is the difference between class lock and object lock?

* Scope: Class lock is associated with the class itself, while object lock is associated with an instance of the class.
  This means that class lock is global to all instances of the class, while object lock is specific to each individual
  instance.

* Usage: Class lock is used to synchronize access to static methods or static data members of the class, while object
  lock is used to synchronize access to instance methods or instance data members of the class.

* Acquisition: Class lock is acquired using the synchronized keyword on the class name, while object lock is acquired
  using the synchronized keyword on the object reference.

* Impact: Class lock affects all threads that access the class, while object lock affects only the threads that access
  the specific object.

```java
public class MyClass {
    public static synchronized void staticMethod() {
        // synchronized on class lock
    }

    public synchronized void instanceMethod() {
        // synchronized on object lock
    }
}
```

## 19. What is future and completableFuture?

### Future:

The Future interface represents the result of an asynchronous computation, which may not yet be available. It provides
methods to check whether the computation is complete, retrieve the result of the computation, or cancel the computation
if necessary. Futures are commonly used in multi-threaded programs to execute tasks asynchronously and retrieve their
results.

```java
ExecutorService executor = Executors.newSingleThreadExecutor();

Future<Integer> future = executor.submit(() -> {
    // Perform a long-running computation
    return 42;
});

// Check whether the computation is complete
if (future.isDone()) {
    // Retrieve the result of the computation
    Integer result = future.get();
    System.out.println("Result: " + result);
}

// Shut down the executor
executor.shutdown();
```

### CompletableFuture:
The CompletableFuture class is a more powerful extension of the Future interface that provides additional methods for
chaining and combining multiple asynchronous computations. It provides a way to perform operations on the result of a
computation as soon as it becomes available, without blocking the calling thread.

```java
CompletableFuture<Integer> future = CompletableFuture.supplyAsync(() -> {
    // Perform a long-running computation
    return 42;
});

future.thenAccept(result -> {
    System.out.println("Result: " + result);
});
```

## 21. Type the code by your self and try to understand it. (package com.chuwa.tutorial.t08_multithreading)

## 22. Read those interview questions and pick some important questions to this home work.
* What is the difference between start() and run()?
* How to create a new thread?
* What kind of locks do you know? what the details of them?
* What is thread pool? what is the advantage and how to create a thread pool?
* What is callable? what is the diff between callable and runnable?
* What is future and competableFuture? give me the example in your experience.

## 23. write a code to create 2 threads, one thread print 1,3,5,7,9, another thread print 2,4,6,8,10.
please see `MavenProject/tutorial/src/main/java/com/chuwa/hw6/OddEvenPrinter.java` and `MavenProject/tutorial/src/main/java/com/chuwa/hw6/OddEvenPrinter2.java`

## 24. create 3 threads, one thread ouput 1-10, one thread output 11-20, one thread output 21-22. threads run sequence is random.
please see `MavenProject/tutorial/src/main/java/com/chuwa/hw6/PrintNumber.java`

## 25. Completable Future
### Homework 1: 
`MavenProject/tutorial/src/main/java/com/chuwa/hw6/HW1.java`

### Homework 2:
`MavenProject/tutorial/src/main/java/com/chuwa/hw6/HW2.java`

### Homework 3:
`MavenProject/tutorial/src/main/java/com/chuwa/hw6/HW3.java`