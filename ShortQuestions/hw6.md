## 1. Explain volatile variables in java? (we also use it in Singleton)
In Java, a volatile variable is a variable whose value is always read from the main memory and not from a thread's local cache. When a variable is declared as volatile, it means that any thread accessing the variable will see the most up-to-date value.

The use of volatile variables is particularly useful in multithreaded environments where multiple threads may access and modify the same variable simultaneously. Without the use of volatile variables, it is possible for one thread to see a stale value of a variable that has been modified by another thread.

## 2. how to create a new thread(Please also consider Thread Pool case)?
- Extending the Thread class
- Implementing the Runnable interface.
```
ExecutorService executor = Executors.newFixedThreadPool(5);
executor.submit(task1);
```

## 3. Difference between Runnable and Callable
Runnable has no return value, callable has return value

# 4. what is the diff between t.start() and t.run()?
- t.start starts a new thread to excute the task（run()）
- t.run() excute the task in the current thread.

# 5. Which way of creating threads is better: Thread class or Runnable interface?
Extending the Thread class:

- This approach allows you to override the Thread class methods, such as start(), interrupt(), and isAlive().
- It may be simpler for small tasks that do not require any additional methods or states.

Implementing the Runnable interface:

- This approach allows you to implement the Runnable interface on any class, not just the Thread class. This makes your code more flexible and allows for better separation of concerns.
- You can pass the Runnable object to multiple threads or to an ExecutorService for efficient thread management.
- This approach is preferred when you need to implement multiple inheritance, as Java does not support multiple inheritance of classes.

## 6. what is the thread status?
- New: When a thread is first created, it is in the New state. The thread has not yet started executing and is not yet eligible to run.

- Runnable: A thread that is ready to run is in the Runnable state. It may be waiting for the CPU to be allocated to it, but it is eligible to run.

- Blocked: A thread that is waiting for a monitor lock to be released is in the Blocked state. This can happen when the thread is trying to access a synchronized block that is already held by another thread.

- Waiting: A thread that is waiting for a specific condition to occur is in the Waiting state. This can happen when the thread is waiting for another thread to complete or for a specific amount of time to pass.

- Timed Waiting: A thread that is waiting for a specific amount of time to pass is in the Timed Waiting state. This can happen when the thread is waiting for a specific amount of time to pass or for a specific condition to occur.

- Terminated: A thread that has completed its execution is in the Terminated state. Once a thread is terminated, it cannot be restarted.

## 7. difference between wait() and sleep() method
- Object.wait() method is a non-static method that can only be called on an object that is synchronized on. In contrast, Thread.sleep() is a static method that can be called from any context.

- The wait() method is used to make a thread pause and wait for a signal from another thread that a particular condition has been met. The sleep() method, on the other hand, simply makes a thread pause for a specific amount of time, regardless of any condition.

- The wait() method releases the lock on the object it is called on, allowing other threads to synchronize on that object. The sleep() method does not release any locks.

- The wait() method can only be woken up by another thread calling the notify() or notifyAll() methods on the object that the waiting thread is synchronized on. The sleep() method will automatically wake up the thread after the specified amount of time has elapsed.

## 8. What is deadlock?
Deadlock is a situation that can occur in a multithreaded environment when two or more threads are blocked, waiting for each other to release a resource that they need to continue executing.

## 9. how do threads communicate with each other?
- Shared memory: Threads can communicate by accessing shared data structures in memory. One thread can modify the shared data, and other threads can read or modify it as well.

- Synchronization: Threads can use synchronization mechanisms such as locks, semaphores, and monitors to coordinate access to shared resources. This ensures that only one thread can access a shared resource at a time, avoiding conflicts and race conditions.

- Wait and notify: Threads can use the wait and notify methods of the Object class to signal each other when a condition has been met. One thread can wait for another thread to notify it that a condition has been met before proceeding.

- Pipes and streams: Threads can communicate with each other using input and output streams or pipes. One thread can write data to an output stream, which another thread can read from an input stream.

- Message passing: Threads can communicate by passing messages to each other. One thread can send a message to another thread, which can receive the message and act on it.

## 10. what is join() method?
The calling thread wait for the called thread to finish.

## 11. what is yield() method
The yield() method is a static method defined in the Thread class in Java. When a thread calls the yield() method, it signals to the scheduler that it is willing to yield its current use of the CPU, giving other threads a chance to execute.

The yield() method does not cause the thread to go into a blocked or waiting state, but instead simply gives the scheduler a hint that it can switch to another thread that is ready to run. However, the scheduler is free to ignore this hint, and may continue to run the same thread.

The yield() method can be useful in situations where a thread is performing a long-running task that is not time-critical, and other threads are waiting for a chance to execute. By calling yield(), the thread can give other threads a chance to run and prevent them from being blocked indefinitely.

It is important to note that the yield() method should be used with caution, as excessive use of yield() can actually decrease performance by causing unnecessary context switching between threads.

## 12. Explain thread pool
A thread pool is a collection of threads that are created at startup and managed by a thread pool manager. Thread pools are used to manage and reuse threads to reduce the overhead associated with creating new threads for each task.

In a thread pool, a fixed number of threads are created at the start of the application, and are held in a pool of available threads. When a new task is submitted to the thread pool, one of the available threads is assigned to the task, and begins executing it. Once the task is completed, the thread is returned to the pool of available threads, where it can be used for another task.

## 13. What is Executor Framework in Java, its different types and how to create these executors?
The Executor Framework in Java is a powerful framework that simplifies the process of creating and managing threads in Java applications. It provides a higher level of abstraction over low-level thread management and helps in managing thread execution, scheduling, and synchronization.

The different types of Executor Framework in Java are:

- ThreadPoolExecutor: This is the most commonly used executor that manages a pool of threads and executes submitted tasks asynchronously. It has several parameters that allow fine-tuning of the thread pool, such as the core pool size, maximum pool size, and thread idle time.

- ScheduledThreadPoolExecutor: This executor extends the ThreadPoolExecutor and provides a way to schedule tasks to run at a specific time or repeatedly after a fixed delay.

- SingleThreadExecutor: This executor creates a single thread to execute all submitted tasks sequentially. It is useful when we want to ensure that all tasks are executed in a specific order.

- CachedThreadPoolExecutor: This executor creates a thread pool that can grow dynamically based on the number of submitted tasks. It is useful when we have a large number of short-lived tasks that need to be executed quickly.

## 14. Difference between shutdown() and shutdownNow() methods of executor
shutdown() allows the threads to complete their tasks normally, while shutdownNow() interrupts the threads and stops them immediately. The choice of which method to use depends on the desired behavior of the application. If we want to stop the executor gracefully and allow the running tasks to complete, we should use shutdown(). If we want to stop the executor immediately and don't care about the running tasks, we should use shutdownNow().

## 15. What is Atomic classes? when do we use it?
The Atomic classes are a set of utility classes that provide thread-safe access to a single variable. These classes use atomic operations to ensure that the variable is updated atomically, that is, in a single, indivisible operation, without any interference from other threads.

These classes are useful when we need to update a shared variable concurrently from multiple threads, without having to use synchronization locks, which can be expensive and can cause performance issues. Atomic classes provide a lightweight and efficient way to handle concurrent updates to shared variables.
## 16. What is the cocurrent collections?
Concurrent collections are thread-safe data structures that provide high concurrency and scalability, allowing multiple threads to access and modify them concurrently without the need for explicit synchronization or locking. They provide a powerful tool for building high-performance, concurrent applications in Java.
## 17. what kind of locks you know?
- synchronized keyword: This is a built-in language feature in Java that provides a mutual exclusion lock. It allows only one thread at a time to execute a block of code that is synchronized on the same object. The lock is released when the synchronized block completes, or when an exception is thrown.

- ReentrantLock: This is a class in the java.util.concurrent.locks package that provides a reentrant lock. It allows a thread to acquire the lock multiple times, as long as it releases the lock the same number of times. It also provides more advanced features, such as interruptible lock acquisition and fairness policy.

- ReadWriteLock: This is a class in the java.util.concurrent.locks package that provides a lock that allows multiple readers or a single writer to access a shared resource. Readers can acquire the lock concurrently, while writers have exclusive access to the lock. This can improve concurrency and scalability in situations where there are many more readers than writers.

- StampedLock: This is a class in the java.util.concurrent.locks package that provides a lock that allows optimistic reading and exclusive writing. Optimistic reading allows a thread to read the shared resource without acquiring a lock, assuming that no other thread is modifying the resource. If the resource has been modified, the thread can acquire an exclusive lock and retry.

- Phaser: This is a class in the java.util.concurrent package that provides a synchronization barrier that can be used to coordinate the execution of multiple threads. It allows threads to wait for each other to reach a particular phase of execution before proceeding, and it can be dynamically reconfigured as needed.
## 18. What is the difference between class lock and object lock?
The main difference between class locks and object locks is the scope of the lock. Object locks are associated with specific object instances, and they are used to synchronize access to instance-level resources. Class locks are associated with classes, and they are used to synchronize access to static resources.
## 19. What is future and completableFuture?
 A Future is a basic construct for working with asynchronous computations, while a CompletableFuture is a more advanced construct that provides additional functionality for composing and chaining asynchronous operations.
## 20. what is ThreadLocal?
ThreadLocal provides a way to create thread-local variables, which are only accessible by the thread that created them. This can be useful for storing per-thread state and avoiding concurrency issues.
## 21. Type the code by your self and try to understand it. (package com.chuwa.tutorial.t08_multithreading)
See coding
## 22. Read those interview questions and pick some important questions to this home work.
- What is the difference between t.start() and t.run()?
- What is the differecence between Callable and Runnbale?
- What is future and completableFuture?
- What is Atomic classes? when do we use it?
## 23. write a code to create 2 threads, one thread print 1,3,5,7,9, another thread print 2,4,6,8,10. (solution is in com.chuwa.tutorial.t08_multithreading.c05_waitNotify.OddEventPrinter)
See coding
## 24. create 3 threads, one thread ouput 1-10, one thread output 11-20, one thread output 21-22. threads run sequence is random. (solution is in com.chuwa.exercise.t08_multithreading.PrintNumber1)
See coding
## 25 See coding