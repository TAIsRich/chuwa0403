### 1.Explain volatile variables in java? (we also use it in Singleton)

 The `volatile` keyword is used to indicate that a variable's value may be modified by multiple threads at the same time. The keyword ensures that the value of the variable is always read from and written to the main memory, and not from a thread's local cache. This makes the variable's value visible to all threads, ensuring thread-safety.

By using the `volatile` keyword, we can guarantee that changes to the variable are immediately visible to all threads.

In a Singleton pattern, the `volatile` keyword is used to ensure that only one instance of the Singleton class is created.

### 2.how to create a new thread(Please also consider Thread Pool case)?

4 ways:

- Extending the Thread class:

  ```java
  public class MyThread extends Thread {
      @Override
      public void run() {
          // code to be executed in the new thread
      }
  }
  
  // To create a new thread:
  MyThread thread = new MyThread();
  thread.start();
  ```

- Implementing the Runnable interface:

  ```java
  public class MyRunnable implements Runnable {
      @Override
      public void run() {
          // code to be executed in the new thread
      }
  }
  
  // To create a new thread:
  Thread thread = new Thread(new MyRunnable());
  thread.start();
  ```

- Implementing the Callable interface:

  ```java
  public class MyCallable implements Callable<Integer> {
      @Override
      public Integer call() throws Exception {
          // code to be executed in the new thread
          return 42;
      }
  }
  FutureTask<Integer> task = new FutureTask<>(callable);
  Thread t = new Thread(task);
  t.start();
  ```

- use a thread pool:

  ```java
  // Create a thread pool with 10 threads
  ExecutorService threadPool = Executors.newFixedThreadPool(10);
  // Submit a task to the thread pool
  threadPool.submit(new MyRunnable());
  
  threadPool.shutdown();
  ```

### 3.Difference between Runnable and Callable

1. Return Value: Runnable's run() method does not return any value, while Callable's call() method returns a value.
2. Exceptions: Runnable's run() method cannot throw a checked exception, while Callable's call() method can throw a checked exception.
3. Generics: Callable is a generic interface that can be parameterized with the type of the result that it returns, while Runnable is not generic.

### 4.what is the diff between t.start() and t.run()?

The `start()` method is used to start a new thread of execution, while the `run()` method is called by the `start()` method to perform the actual work of the thread. Calling `t.start()` creates a new thread of execution and starts it, while calling `t.run()` simply executes the `run()` method in the same thread that called it.

When you call the `run()` method directly, it is executed in the same thread that called it, so it does not create a new thread of execution. This means that if the `run()` method is long-running, it will block the calling thread and prevent other activities from executing until it is finished.

### 5.Which way of creating threads is better: Thread class or Runnable interface?

Both ways of creating threads have their advantages and disadvantages:

Using the Thread class:

- More concise syntax, as the code can be written in a single class
- Allows for overriding of methods like `run()` and `toString()`
- Can be less flexible if the class already extends another class

Using the Runnable interface:

- More flexible, as the class can implement multiple interfaces
- Promotes separation of concerns, as the code for the thread behavior can be separated from the main class
- Can require more boilerplate code, as a separate class must be created to implement the interface

### 6.what is the thread status?

These states are defined by the `Thread.State` enumeration and include:

1. NEW: A thread that has not yet started running.
2. RUNNABLE: A thread that is executing in the JVM.
3. BLOCKED: A thread that is blocked waiting for a monitor lock to be released.
4. WAITING: A thread that is waiting indefinitely for another thread to perform a particular action.
5. TIMED_WAITING: A thread that is waiting for a specific amount of time for another thread to perform a particular action.
6. TERMINATED: A thread that has completed execution and has exited.

### 7.difference between wait() and sleep() method

The `wait()` method is used for  ==inter-thread communication and synchronization==.

It causes the current thread to release the monitor and wait until another thread either notifies or interrupts it. The `wait()` method must be called on a synchronized object, and it releases the monitor of the object until it is notified. It is used for thread synchronization in multithreaded environments, where threads need to wait for a specific condition before proceeding.

The `sleep()` method, is used to ==pause the execution of a thread== for a specified amount of time.

 It does not release the lock or monitor of any object, so other threads cannot acquire the lock while a thread is sleeping. The `sleep()` method is used to introduce a delay or pause in a thread's execution, for example, to simulate a slow operation or to avoid busy-waiting.

### 8.What is deadlock?

Deadlock is a situation that occurs when two or more threads are blocked, each waiting for the other to release a resource that it needs to continue executing. In other words, each thread is holding a resource that the other threads need, while waiting for a resource that it needs, but cannot acquire because another thread is holding it. This creates a circular dependency between the threads, and neither of them can make progress. Deadlocks can cause the entire application to hang or become unresponsive.

### 9.how do threads communicate with each other?

1. **Wait/Notify mechanism**: This mechanism allows a thread to wait for a certain condition to be met and then proceed. The waiting thread releases the lock on the object it is waiting on, allowing other threads to access the object. When the condition is met, another thread can notify the waiting thread, which wakes up and tries to reacquire the lock on the object. This usually happens with a shared object with synchronized methods or blocks to ensure thread-safe access to shared data
2. **Inter-thread messaging**: This mechanism involves sending messages between threads to communicate. The messages are sent through a shared data structure such as a queue. One thread adds messages to the queue, and the other thread reads them and acts accordingly. Or using volatile variables to share data between threads.
3. Using a concurrent collection such as `ConcurrentHashMap` or `BlockingQueue` for thread-safe data sharing

### 10.what is join() method?

 join() is a method that allows a thread to wait for the completion of another thread before continuing its own execution. When a thread calls join() on another thread, it will wait for that thread to finish executing before it continues with its own execution.

The join() method can be useful when one thread is dependent on the output of another thread. For example, consider a scenario where a main thread is waiting for the completion of multiple worker threads before it can proceed with its own processing. In such cases, the main thread can call join() on each worker thread, which will ensure that it waits for each worker thread to complete before continuing with its own execution.

The join() method can also be used to ensure that the main thread does not terminate before all other threads have finished executing. This can be achieved by calling join() on all worker threads from the main thread before it exits.

### 11.what is yield() method

The yield() method is a static method of the Thread class in Java, and it's used to pause the current thread and give the opportunity for other threads to execute. When a thread invokes yield(), it temporarily leaves the running state and moves to the ready state, allowing other threads to run in the meantime.

The yield() method doesn't release any locks or monitors held by the thread that calls it, so it's not a tool for synchronization. It's mainly used in situations where we have multiple threads running on a shared resource, and we want to give them a chance to execute in a fair way.

```java
class CalculationTask implements Runnable {
    private final int start;
    private final int end;

    public CalculationTask(int start, int end) {
        this.start = start;
        this.end = end;
    }

    @Override
    public void run() {
        for (int i = start; i <= end; i++) {
            // Perform complex calculation
        }
    }
}

class UserInterfaceTask implements Runnable {
    private final JTextField inputField;
    private final JTextArea outputArea;

    public UserInterfaceTask(JTextField inputField, JTextArea outputArea) {
        this.inputField = inputField;
        this.outputArea = outputArea;
    }

    @Override
    public void run() {
        // Update user interface
        String input = inputField.getText();
        outputArea.append("Calculating for input: " + input + "\n");
        outputArea.setCaretPosition(outputArea.getDocument().getLength());
    }
}

// In the main method or some other class
Thread calculationThread = new Thread(new CalculationTask(1, 100000));
Thread userInterfaceThread = new Thread(new UserInterfaceTask(inputField, outputArea));

calculationThread.start();
while (calculationThread.isAlive()) {
    userInterfaceThread.run();
    Thread.yield(); // Give user interface thread a chance to execute
}
```

In this example, the `CalculationTask` performs a long-running calculation in the background thread, while the `UserInterfaceTask` updates the user interface with some status information. The `Thread.yield() `method is called in the main thread to give the user interface thread a chance to execute some of its pending tasks and handle user input before the background thread resumes its processing.

### 12.Explain thread pool

A thread pool is a collection of threads that can be reused to execute tasks in a concurrent program. It maintains a pool of threads, which are created and managed by the thread pool manager, and each thread is used to execute a task that is submitted to the thread pool.

The thread pool provides the following benefits over creating a new thread for each task:

1. Reuse of threads: Creating a new thread for each task can be expensive, as the process of creating and destroying threads has some overhead. Thread pool can reuse threads for multiple tasks, which reduces the overhead of thread creation and destruction.
2. Resource management: A thread pool limits the number of threads that can be created, which helps to manage the system resources efficiently. This prevents the system from running out of memory due to a large number of threads.
3. Improved performance: A thread pool can improve the performance of a concurrent program by reducing the overhead of thread creation and destruction. By reusing threads, the program can execute tasks more efficiently.
4. Better control: A thread pool provides better control over the number of threads used in the program. The thread pool manager can control the number of threads created, the maximum number of threads that can be active at any given time, and other properties of the thread pool.

### 13.What is Executor Framework in Java, its different types and how to create these executors?

The Executor Framework in Java is a collection of classes and interfaces that provide a flexible thread pool implementation. It is used to create and manage threads in Java applications efficiently. The framework allows the developer to separate the task submission and execution logic from the thread creation and management logic.

The different types of executors available in Java 8 are:

1. `ThreadPoolExecutor`: It is the most commonly used executor that allows the creation of a thread pool with a fixed number of threads.
2. `ScheduledThreadPoolExecutor`: It is an extension of the `ThreadPoolExecutor` that allows the scheduling of tasks to be executed periodically.
3. `ForkJoinPool`: It is a special type of executor that is designed for parallel computing tasks that can be divided into smaller sub-tasks.
4. `SingleThreadExecutor`: It is an executor that creates a single thread for executing tasks. It is useful for tasks that need to be executed sequentially.

In which, ThreadPoolExecutor has several different types of thread pools that can be created using its constructor. Here are some of the commonly used ones:

1. `FixedThreadPool`: This type of thread pool has a fixed number of threads that are created when the pool is initialized. Each task submitted to the pool is executed by one of the threads in the pool.
2. `CachedThreadPool`: This type of thread pool creates new threads as needed, and reuses threads that have become available after completing previous tasks. This can be useful for applications that have many short-lived tasks.
3. `ScheduledThreadPool`: This type of thread pool is used for scheduling tasks to be executed in the future, either once or periodically. It allows you to schedule tasks to be executed after a certain delay or at fixed intervals.
4. `SingleThreadExecutor`: This type of thread pool creates a single thread for executing tasks. It can be useful when you want to ensure that all tasks are executed in a specific order, or when you want to limit the concurrency of your application.

14.Difference between shutdown() and shutdownNow() methods of executor

`shutdown()` waits for previously submitted tasks to complete while `shutdownNow()` does not wait for executing tasks to complete and instead interrupts the execution of running tasks.

### 15.What is Atomic classes? when do we use it?

The `java.util.concurrent.atomic` package provides a set of classes that support atomic operations on single variables, without needing to use `synchronized` blocks. These classes are commonly known as Atomic classes.

Atomic classes provide thread-safe and atomic operations on variables that are shared between threads. This means that the operations performed on these variables are executed as a single, atomic unit, without being interrupted by other threads.

Some of the commonly used Atomic classes are:

- `AtomicBoolean`: provides atomic operations on a boolean variable.
- `AtomicInteger`: provides atomic operations on an integer variable.
- `AtomicLong`: provides atomic operations on a long variable.
- `AtomicReference`: provides atomic operations on a reference variable.
- `AtomicReferenceArray`: provides atomic operations on an array of reference variables.

We use Atomic classes when we need to ensure thread safety while performing operations on shared variables. By using these classes, we can avoid the need for explicit synchronization and make our code more efficient.

### 16.What is the cocurrent collections?

Concurrent collections in Java are a set of thread-safe collections that were introduced in Java 5 to provide better support for concurrent programming. These collections are designed to be used in a multi-threaded environment and offer thread-safety without the need for explicit synchronization.

1. ConcurrentHashMap - a highly concurrent key-value map implementation that allows multiple concurrent readers and a high degree of concurrency for updates.
2. ConcurrentLinkedQueue - an unbounded thread-safe queue based on linked nodes.
3. ConcurrentSkipListMap - a scalable and concurrent NavigableMap implementation based on a concurrent skip list.
4. ConcurrentSkipListSet - a concurrent set based on a concurrent skip list.
5. CopyOnWriteArrayList - a thread-safe variant of ArrayList in which all mutative operations (add, set, and so on) are implemented by making a fresh copy of the underlying array.
6. CopyOnWriteArraySet - a thread-safe variant of Set in which all mutative operations (add, set, and so on) are implemented by making a fresh copy of the underlying array.
7. LinkedBlockingQueue - an optionally bounded blocking queue based on linked nodes.
8. ArrayBlockingQueue - a bounded blocking queue backed by an array.
9. PriorityBlockingQueue - an unbounded blocking queue that uses the same ordering rules as the java.util.PriorityQueue class.
10. SynchronousQueue - a blocking queue in which each insert operation must wait for a corresponding remove operation by another thread.

### 17.what kind of locks you know?

1. ReentrantLock: A reentrant mutual exclusion lock, which can be used to coordinate access to a shared resource by multiple threads.
2. ReentrantReadWriteLock: A lock that allows multiple readers or a single writer to access a shared resource at the same time.
3. StampedLock: A lock that provides an optimistic read lock, a pessimistic read lock, and a write lock.
4. ReadWriteLock: An interface that defines a read lock and a write lock, which can be used to coordinate access to a shared resource by multiple threads.
5. synchronized: A keyword that can be used to synchronize access to a shared resource by multiple threads.
6. Lock: An interface that defines a locking mechanism, which can be used to coordinate access to a shared resource by multiple threads.
7. Condition: An interface that provides a mechanism for threads to wait for a certain condition to be met before continuing execution.

### 18.What is the difference between class lock and object lock?

Class Lock:

1. It is obtained on the class object.
2. Only one class lock can be obtained by a thread.
3. All instances of the class share the same class lock.
4. It can be used to achieve synchronized class methods.
5. It can be used to achieve synchronized static blocks.

Object Lock:

1. It is obtained on a particular object of the class.
2. Multiple object locks can be obtained by a thread.
3. Each object has its own object lock.
4. It can be used to achieve synchronized instance methods.
5. It can be used to achieve synchronized blocks within instance methods.

### 19.What is future and completableFuture?

They both represent a result that may not yet be available. `Future` represents a single result that will be available at some point in the future, while `CompletableFuture` represents a stage of a potentially asynchronous computation that can be composed with other stages to form a pipeline of operations. We can then use methods like `thenApply()`, `thenAccept()`, and `thenRun()` to chain together operations that depend on each other.

20 what is ThreadLocal?

`ThreadLocal` is a class in Java that allows you to create variables that can only be accessed and modified by a single thread. Each thread that accesses the `ThreadLocal` object has its own copy of the variable.

The `ThreadLocal` class is useful in situations where you need to store data that is specific to a thread, such as request or session information in a web application. It is also commonly used in multi-threaded programming to avoid race conditions and synchronization issues.

```java
public class Session {
    private static ThreadLocal<User> userThreadLocal = new ThreadLocal<>();

    public static void setUser(User user) {
        userThreadLocal.set(user);
    }

    public static User getUser() {
        return userThreadLocal.get();
    }

    public static void clearUser() {
        userThreadLocal.remove();
    }
}
```

Each thread that accesses the `ThreadLocal` will have its own copy of the variable, and changes made by one thread will not affect the value seen by other threads.