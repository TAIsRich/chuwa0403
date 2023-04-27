# HW6

*Claudia Feng Apr 21, 2023*

1. Explain volatile variables in java? (we also use it in Singleton)

In Java, a `volatile` variable is a keyword used to indicate that a field's value may be changed by multiple threads simultaneously. 

The `volatile` keyword provides the following guarantees:

1. Visibility: When a thread reads a `volatile` variable, it sees the most recent write to that variable made by any thread. This means that changes to a `volatile` variable by one thread are immediately visible to other threads.
2. Ordering: The Java Memory Model (JMM) ensures a "happens-before" relationship between all reads and writes of a `volatile` variable. It means that any read of a `volatile` variable must come after any previous writes to the same variable, even if those writes were made by another thread.



2. how to create a new thread(Please also consider Thread Pool case)?

Exends Thread class, Implements Runnable, Implements Callable, Executor service



3. Difference between Runnable and Callable

- runnable has no return

- callable has return



4. what is the diff between t.start() and t.run()?

- t.start starts a new thread to excute the task(run()) 

- t.run() excute the task in the current thread.



5. Which way of creating threads is better: Thread class or Runnable interface?

`Runnable` interface is often preferred for the following reasons:

1. Flexibility: Java does not support multiple inheritance. By extending the `Thread` class, your new class is effectively locked from inheriting any other class. Implementing the `Runnable` interface allows your class to extend another class if needed, providing more flexibility.
2. Better object-oriented design: Implementing the `Runnable` interface follows the "composition over inheritance" design principle. You separate the task to be performed in a separate class (the `Runnable`) from the actual threading mechanism (the `Thread` class), promoting a cleaner separation of concerns.
3. Reusability: A `Runnable` object can be passed to different `Thread` instances, allowing the same task to be executed concurrently by multiple threads. This is not possible when extending the `Thread` class directly, as the task and the thread are tightly coupled.
4. Executors and thread pools: The `java.util.concurrent` package, introduced in Java 5, provides a high-level API for managing thread pools and concurrency. The `Executor` framework uses `Runnable` to represent tasks, making it easier to work with these advanced concurrency features when you implement the `Runnable` interface.



6. what is the thread status?

Thread status, also known as thread state, represents the current execution state of a thread in Java. 

1. NEW: A thread that has been created but has not yet started. It is in the NEW state when the `Thread` object is instantiated but before the `start()` method has been called.
2. RUNNABLE: A thread in the RUNNABLE state is either executing its task or waiting for the CPU to be allocated. The thread scheduler may choose any thread in this state to run, based on various factors like priority, available resources, and scheduling algorithm.
3. BLOCKED: A thread in the BLOCKED state is waiting to acquire a monitor lock on an object. This typically happens when a thread tries to enter a synchronized block or method, but another thread is already holding the lock.
4. WAITING: A thread is in the WAITING state when it's waiting for another thread to perform a particular action. This occurs when a thread calls the `wait()` method on an object, the `join()` method on another thread, or the `park()` method of the `LockSupport` class. The thread transitions back to the RUNNABLE state when it's notified, the joined thread terminates, or the specified wait time has elapsed.
5. TIMED_WAITING: A thread is in the TIMED_WAITING state when it's waiting for another thread to perform an action but with a specified timeout. This can occur when a thread calls methods like `sleep(long millis)`, `wait(long timeout)`, `join(long millis)`, or `LockSupport.parkNanos(long nanos)`.
6. TERMINATED: A thread reaches the TERMINATED state when it has completed its execution, either by successfully finishing the `run()` method or by encountering an uncaught exception or an error.

You can check the current status of a thread by calling the `getState()` method on the `Thread` object, which returns a `Thread.State` value representing the current state of the thread.



7. difference between wait() and sleep() method

1. Purpose:
   - `wait()`: This method is used for inter-thread communication, allowing a thread to release the lock on a shared resource and wait for another thread to perform a specific action (such as updating the shared resource). It is typically used in the context of the Producer-Consumer problem or other synchronization scenarios.
   - `sleep()`: This method is used to pause the execution of the current thread for a specified duration, without releasing any lock it might hold. It is commonly used for creating delays or allowing other threads to execute when there is no need to share resources.
2. Class definition:
   - `wait()`: It is a method of the `Object` class, so it can be called on any Java object.
   - `sleep()`: It is a static method of the `Thread` class, and it's invoked on the `Thread` class itself (e.g., `Thread.sleep(millis)`).
3. Lock release:
   - `wait()`: When a thread calls `wait()` on an object, it releases the monitor lock it holds on that object, allowing other threads to acquire the lock and access the synchronized block or method.
   - `sleep()`: When a thread calls `sleep()`, it does not release any monitor locks it holds. If it holds a lock on an object, other threads trying to access synchronized code on that object will be blocked.
4. Wake-up conditions:
   - `wait()`: A waiting thread can be woken up by another thread calling `notify()` or `notifyAll()` on the same object, or when the optional wait timeout elapses.
   - `sleep()`: A sleeping thread will be woken up when the specified sleep duration elapses, or when it's interrupted by another thread calling `interrupt()` on it.
5. Method signature:
   - `wait()`: There are two overloaded versions: `wait()` and `wait(long timeout)`. They both need to be called within a synchronized context (e.g., a synchronized block or method).
   - `sleep()`: There are two overloaded versions: `sleep(long millis)` and `sleep(long millis, int nanos)`. It does not require a synchronized context.



8. What is deadlock?

A deadlock is a situation in a multi-threaded or concurrent environment where two or more threads are blocked forever, waiting for each other to release a shared resource, and neither can make progress. Deadlocks occur when multiple threads hold locks on resources while simultaneously waiting for locks held by other threads, creating a circular dependency between the threads.

A deadlock can be characterized by the following four conditions, which must all hold simultaneously:

1. Mutual exclusion: A resource can only be held by one thread at a time.
2. Hold and wait: A thread holds one or more resources while waiting for additional resources held by other threads.
3. No preemption: Resources cannot be forcibly taken away from a thread once they are acquired; the thread must voluntarily release them.
4. Circular wait: There is a circular chain of two or more threads, where each thread is waiting for a resource held by the next thread in the chain.

To prevent or avoid deadlocks, you can employ various techniques such as:

1. Resource ordering: Establish a fixed order for acquiring resources, and ensure that all threads follow this order when requesting locks. This approach breaks the circular wait condition.
2. Timeout-based approach: Introduce a timeout when requesting locks, and if a lock is not acquired within the specified time, release all acquired locks, wait for a random period, and then retry.
3. Deadlock detection and recovery: Allow deadlocks to occur but detect them when they happen, and then take corrective action like aborting one of the threads or rolling back their operations to a safe state and restarting.
4. Avoiding hold and wait: Require threads to request all resources they need upfront before starting their execution, or release all held resources before requesting new ones.



9. how do threads communicate with each other?

1. Shared variables: Threads can use shared variables to exchange data. To ensure safe access to shared variables, you need to use synchronization mechanisms like the `synchronized` keyword or java.util.concurrent.locks classes. Using `volatile` variables can also help in specific cases where only visibility and ordering guarantees are needed.
2. Wait-notify mechanism: Java provides the `wait()`, `notify()`, and `notifyAll()` methods, which are part of the `Object` class. These methods can be used for signaling between threads, usually in the context of a Producer-Consumer pattern. When a thread calls `wait()` on an object, it releases the lock on that object and waits for another thread to call `notify()` or `notifyAll()` on the same object. The `wait()` and `notify()` methods must be called within a `synchronized` block or method.
3. Blocking queues: The `java.util.concurrent` package provides blocking queue implementations like `ArrayBlockingQueue`, `LinkedBlockingQueue`, and `PriorityBlockingQueue`. Blocking queues can be used to store and exchange data between threads in a thread-safe manner. Producers put items into the queue, and consumers take items from the queue. If the queue is full or empty, the producer or consumer thread will block until the queue has space or contains items, respectively.
4. Executors and thread pools: The `Executor` framework in the `java.util.concurrent` package provides a higher-level abstraction for managing thread pools and executing tasks. You can use `Callable` and `Future` to represent tasks that return a result, allowing you to share data between threads by retrieving the results of their computations.
5. Concurrent collections: The `java.util.concurrent` package also provides thread-safe collection classes like `ConcurrentHashMap`, `CopyOnWriteArrayList`, and `ConcurrentSkipListSet`. These collections can be used to share data between threads without explicit synchronization.
6. CountDownLatch, CyclicBarrier, and Semaphore: These classes, also part of the `java.util.concurrent` package, are synchronization utilities that can be used for coordinating the actions of multiple threads. They help manage common synchronization patterns like waiting for multiple threads to complete their tasks or limiting the number of concurrent threads accessing a resource.



10. what is join() method?

The `join()` method in Java is a method of the `Thread` class that allows one thread to wait for another thread to complete its execution.

1. `join()`: The calling thread waits indefinitely for the specified thread to complete its execution.
2. `join(long millis)`: The calling thread waits for the specified thread to complete its execution or the given timeout (in milliseconds) to elapse, whichever comes first.
3. `join(long millis, int nanos)`: The calling thread waits for the specified thread to complete its execution or the given timeout (in milliseconds and nanoseconds) to elapse, whichever comes first.



11. what is yield() method

The `yield()` method in Java is a static method of the `Thread` class that provides a hint to the thread scheduler that the current thread (the one calling `yield()`) is willing to relinquish its current use of the processor. The scheduler is then free to choose another thread of the same or higher priority to run, if there are any waiting.

When a thread calls `Thread.yield()`, it doesn't release any locks or resources it holds, nor does it change its state from `RUNNABLE` to another state like `WAITING` or `BLOCKED`. It simply moves to the end of the scheduling queue for its current priority level, giving other threads of the same or higher priority an opportunity to run.

It's important to note that the behavior of the `yield()` method is platform-dependent and depends on the underlying thread scheduler implementation. There is no guarantee that calling `yield()` will always result in another thread being scheduled, especially if there are no other threads of the same or higher priority waiting to run.



13. Explain thread pool

A thread pool is a collection of pre-initialized worker threads that are available to perform tasks concurrently. Instead of creating a new thread for each task, which can be resource-intensive and slow, a thread pool reuses existing threads to execute tasks as they become available. This helps to minimize the overhead of thread creation and destruction, improve resource utilization, and control the maximum number of concurrent threads executing tasks in an application.



14. What is Executor Framework in Java, its different types and how to create these executors?

The Executor Framework in Java is a high-level API for managing and controlling thread execution in concurrent applications. It provides an abstraction over low-level thread management by introducing the concept of thread pools and task execution. 

Different types of executors in the Executor Framework:

1. `Executor`: A basic interface that defines the `execute(Runnable command)` method for executing a given `Runnable` task. It does not provide any lifecycle management or advanced features.
2. `ExecutorService`: An extended interface that inherits from `Executor`, adding features like task submission, thread pool lifecycle management, and support for tasks that return results (using the `Callable` interface). The `ExecutorService` interface is commonly used in Java applications for working with thread pools.
3. `ScheduledExecutorService`: An extended interface that inherits from `ExecutorService`, adding the capability to schedule tasks for execution after a delay, or to execute tasks periodically.

The `Executors` class is a utility class that provides factory methods for creating different types of executor instances. Here are some common methods for creating executors:

- newFixedThreadPool(int nThreads)
- newCachedThreadPool()
- newSingleThreadExecutor()
- newScheduledThreadPool(int corePoolSize)



15. Difference between shutdown() and shutdownNow() methods of executor

- `shutdown()` allows in-progress tasks to complete and prevents new tasks from being submitted, while `shutdownNow()` attempts to cancel and interrupt all actively executing tasks and halts the processing of waiting tasks.
- `shutdownNow()` returns a list of tasks that were awaiting execution but were not started yet, while `shutdown()` does not return any task list.



16. What is Atomic classes? when do we use it?

Atomic classes in Java are utility classes provided by the `java.util.concurrent.atomic` package that support lock-free, thread-safe programming on single variables. These classes are designed for performing atomic operations on the underlying variable, which means the operations are indivisible and can't be interrupted in the middle of their execution. As a result, atomic classes provide a way to avoid synchronization overhead while still ensuring thread safety.

The atomic classes are useful in scenarios where you need to guarantee that the operations on a shared variable are atomic, especially in highly concurrent applications. Some common use cases for atomic classes include implementing counters, maintaining state, and performing updates on shared variables.



17. What is the concurrent collections?

Concurrent collections achieve better performance by allowing multiple threads to access and modify the data structure simultaneously, using fine-grained locking or lock-free algorithms. This approach reduces contention and improves scalability when compared to coarse-grained synchronization used by synchronized collections. These concurrent collections can be used as drop-in replacements for their synchronized or non-thread-safe counterparts to improve performance and scalability in multi-threaded applications.



18. what kind of locks you know?

- ReentrantLock
- ReadWriteLock
- StampedLock



19. What is the difference between class lock and object lock?

1. Object Lock: Object lock is used to synchronize access to instance-level resources or shared data that belongs to an instance of a class (non-static members). When a thread acquires an object lock, it obtains exclusive access to the object's non-static synchronized methods or synchronized blocks. Other threads trying to access the same object's synchronized methods or blocks must wait until the lock is released.
2. Class Lock: Class lock is used to synchronize access to static resources or shared data that belongs to a class itself, not a specific instance (static members). When a thread acquires a class lock, it obtains exclusive access to the class's static synchronized methods or synchronized blocks that use the class's `Class` object as a reference. Other threads trying to access the same class's static synchronized methods or blocks must wait until the lock is released.



20. What is future and completableFuture?

1. `Future`: Introduced in Java 5, `Future` is an interface that represents the result of an asynchronous computation. It provides methods to check if the computation is complete, retrieve the result, and cancel the computation. Typically, `Future` objects are returned when you submit a `Callable` task to an `ExecutorService`.

Some of the key methods of the `Future` interface are:

- `isDone()`: Checks if the computation is complete.
- `get()`: Waits for the computation to complete and retrieves the result. This method blocks the calling thread until the result is available.
- `get(long timeout, TimeUnit unit)`: Waits for the computation to complete for a specified duration and retrieves the result. This method throws a `TimeoutException` if the result is not available within the given timeout.
- `cancel(boolean mayInterruptIfRunning)`: Attempts to cancel the computation.

However, the `Future` interface has some limitations:

- It does not provide any convenient methods for chaining or composing multiple tasks.
- It does not support handling exceptions that may occur during task execution.
- It does not support async completion and non-blocking behavior.

1. `CompletableFuture`: Introduced in Java 8, `CompletableFuture` is a class that implements the `Future` interface and provides additional methods for creating, chaining, and composing asynchronous tasks. It is also designed to support non-blocking behavior and allows you to attach callback functions that execute upon the completion of the task. `CompletableFuture` implements both the `Future` and `CompletionStage` interfaces.

`CompletableFuture` includes many useful methods for creating and manipulating asynchronous tasks, such as `supplyAsync()`, `thenApply()`, `thenAccept()`, `thenCompose()`, `thenCombine()`, `exceptionally()`, and many more.



21. what is ThreadLocal?

`ThreadLocal` is a Java class that allows you to create variables with a separate, independent value for each thread that accesses them. In other words, it provides thread-local storage, which is useful in situations where you want to maintain a per-thread state, such as when working with multi-threaded applications and ensuring that each thread has its own isolated value of a variable.

When multiple threads access a `ThreadLocal` instance, each thread will see its own, independently initialized copy of the variable. The value stored in a `ThreadLocal` is not shared between threads, which eliminates the need for synchronization when accessing the variable.

A common use case for `ThreadLocal` is when working with non-thread-safe classes, like `SimpleDateFormat`, in a multi-threaded environment. By creating a separate instance of the non-thread-safe class for each thread, you can avoid potential race conditions.



22 - 25.

 See Coding folder.

