# HW6

## 1. Explain volatile variables in java? (we also use it in Singleton)

A volatile variable is a special type of variable that **ensures that changes to its value by one thread are immediately visible to other threads**. The Java volatile keyword guarantees that all threads see a **consistent view of the variable's value**.

In the Singleton implementation, the `instance` variable is declared as `volatile`, which ensures that any changes made to it by one thread are immediately visible to all other threads. The `getInstance()` method checks if the `instance` variable is null, and if it is, it creates a new Singleton instance inside a synchronized block. This double-checked locking approach ensures that only one instance of the Singleton class is created, even in a multi-threaded environment.

## 2. How to create a new thread (Please also consider Thread Pool case)?

1. Not using ThreadPool case

   * Extend the Thread class:

     ```java
     public static void main(String[] agrs) {
         Mythread myThread = new MyThread();
         myThread.start();
         ...
     }
     
     class MyThread extends Thread {
         @Override
         public void run() {
             ...
         }
     }
     ```

   * Implement the Runnable Interface:

     * Not use inner class

       ```java
       public static void main(String[] args) {
           Thread myRunnable = new Thread(new MyRunnable());
           myRunnable.start();
       }
       
       class MyRunnable implements Runnable {
           @Override
           public void run() {
               ...
           }
       }
       ```

     * Use inner class

       * Not use lambda

         ```java
         public static void main(String[] args) {
             Thread myRunnable = new Thread(new Runnable() {
                 @Override
                 public void run() {
                     ...
                 }
             });
         }
         ```

       * Use lambda

         ```java
         public static void main(String[] args) {
             Thread myRunnable = new Thread(() -> {
                 ...
             });
             // If there is only one line in runnable, we don't need {}
         }
         ```

2. Using ThreadPool case:

   * Standard ThreadPool:

     ```java
     public static void main(String[] args) {
         // Create a thread poll with 4 threads.
         ExecutorService es = Executors.newFixedThreadPoll(4);
         // 4 threads are currently created.
         
         // Give runnable task to threads to execute
         es.submit(new MyRunnable());
         es.submit(task1);
         es.submit(task2);
         
         // Shutdown the threadpoll.
         es.shutdown();
     }
     ```

   * Implement Callable interfase:

     ```java
     public static void main(String[] args) {
         // A callable task must be executed by a thread pool
         ExecutorService es = Executors.newFixedThreadPool(10);
         
         Future<String> future = executor.submit(new MyCallable());
         String res = future.get();
         es.shutdown();
     }
     
     class MyCallable implements Callable<String> {
         @Override
         public String call() throws Excetion {
             ...
             return "A String";
         }
     }
     ```

## 3. Difference between Runnable and Callable.

1. Return value:

   The `run()` method of the Runnable interface does not return any value, whereas the `call()` method of the Callable interface returns a result of a specific type.

2. Exception handling:

   The `run()` method of the Runnable interface cannot throw any checked exceptions, whereas the `call()` method of the Callable interface can throw a checked exception. If a Callable throws an exception, it must be handled explicitly by the calling code.

3. Usage with ExecutorService:

   The `submit()` method of the ExecutorService interface can be used to submit a task that implements either the Runnable or Callable interface. However, when using Callable, the `submit()` method returns a `Future` object that can be used to obtain the result of the task when it completes.

## 4. What is the diff between t.start() and t.run()?

The key difference between `start()` and `run()` is tha**t `start()` starts a new thread and runs the code in that thread, while `run()` simply executes the code in the current thread**. When you call the `start()` method, the new thread runs independently of the current thread, allowing concurrent execution. On the other hand, when you call the `run()` method directly, the code executes in the same thread that called the method, potentially blocking the current thread and preventing concurrent execution.

```java
public class MyThread extends Thread {
    public void run() {
        System.out.println("Hello from thread " + 			Thread.currentThread().getName());
    }
}

public class Main {
    public static void main(String[] args) {
        MyThread myThread = new MyThread();

        // Start the thread using start() method
        myThread.start(); // Output: Hello from thread Thread-0

        // Run the thread using run() method
        myThread.run(); // Output: Hello from thread main
    }
}
```

## 5. Which way of creating threads is better: Thread class or Runnable interface?

Using the `Runnable` interface also has some additional benefits, such as allowing your class to implement other interfaces or extend other classes, which can be useful for code reuse.

In general, it's recommended to use the `Runnable` interface instead of extending the `Thread` class because **it provides more flexibility and allows for better code organization**. However, if you have a simple use case where you don't need to define any additional methods or interfaces, extending the `Thread` class may be simpler and more straightforward.

## 6. What is the thread status?

- `NEW`: The thread is created, but it hasn't started yet.
- `RUNNABLE`: The thread is running or ready to run. This includes both the running state and the ready-to-run state.
- `BLOCKED`: The thread is waiting for a monitor lock to be released by another thread.
- `WAITING`: The thread is waiting for another thread to perform a particular action, such as releasing a lock or sending a signal.
- `TIMED_WAITING`: The thread is waiting for a specified amount of time for another thread to perform a particular action.
- `TERMINATED`: The thread has completed its execution.

## 7. Difference between wait() and sleep() method.

1. Usage:

   The `wait()` method is used for synchronization between threads, while the `sleep()` method is used for pausing a thread for a specified amount of time.

2. Monitor:

   The `wait()` method releases the monitor on the object it's called on, allowing other threads to synchronize on that object. On the other hand, the `sleep()` method doesn't release any monitor, allowing other threads to execute concurrently.

3. Time:

   The `wait()` method can be called with a timeout, which means that the thread will wait for a specified amount of time or until it's notified by another thread. On the other hand, the `sleep()` method is always called with a specified duration.

4. `wait()` will only be called by the LOCK and `sleep()` will be called by a thread.

## 8. What is deadlock?

Deadlock is a situation that can occur in a multi-threaded program when two or more threads are blocked, each waiting for the other to release a resource that it needs to proceed. As a result, none of the threads can make progress, and the program becomes stuck.

## 9. How do threads communicate with each other?

1. Shared Objects:

   Threads can communicate with each other by sharing objects in memory. For example, one thread can modify an object's state, and another thread can read the updated state.

2. Communication Primitives:

   Threads can communicate with each other through shared objects or through the use of communication primitives such as `wait()`, `notify()`, and `notifyAll()` methods.

## 10. What is join() method?

 `join()` method is a synchronization mechanism that allows one thread to wait for another thread to complete its execution before continuing. When a thread calls the `join()` method on another thread, the calling thread is blocked until the other thread completes its execution or until a specified timeout occurs.

```java
public class MyThread implements Runnable {
    public void run() {
        System.out.println("Thread started");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Thread completed");
    }
}

public class Main {
    public static void main(String[] args) {
        MyThread myThread = new MyThread();
        Thread thread = new Thread(myThread);
        thread.start();
        try {
            // main thread will pause to wait for thread
            // when thread is completed main will continue
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Main thread completed");
    }
}

```

## 11. What is yield() method

 `yield()` method is a hint to the scheduler that the current thread **is willing to yield its current use of the CPU** and let other threads run. The scheduler can choose to ignore this hint, but it may choose to give other threads a chance to run.

The `yield()` method is a method of the `Thread` class and has no parameters. When a thread calls the `yield()` method, it returns immediately, allowing other threads to run. The thread that called the `yield()` method remains in the "runnable" state and can be scheduled to run again by the scheduler.

## 12. Explain the ThreadPool

A thread pool **is a collection of threads that can be used to execute tasks concurrently**. A thread pool consists of a fixed number of threads that are created when the thread pool is initialized. Instead of creating a new thread every time a task needs to be executed, the task is submitted to the thread pool, and one of the threads in the pool executes the task.

Using thread pools generally offers **better performance and resource management** compared to creating single threads directly. Thread pools control the number of concurrent tasks, reduce the overhead of thread creation and destruction, and improve performance. Moreover, thread pools allow task queuing for pending execution, automatically manage thread lifecycles, and provide more flexible error handling mechanisms. However, in some simple scenarios, using a single thread might be more straightforward.

## 13. What is Executor Framework in Java, its different types and how to create these executors?

There are three main types of executors in the Executor framework:

1. `ThreadPoolExecutor`: This is the most common type of executor and provides a fixed-size thread pool that can be used to execute tasks concurrently. You can configure the size of the thread pool and the queue used to hold the submitted tasks.
2. `ScheduledThreadPoolExecutor`: This executor provides a fixed-size thread pool that can be used to execute tasks at a specific time or after a specific delay. You can configure the size of the thread pool, the queue used to hold the submitted tasks, and the maximum delay time for executing the tasks.
3. `ForkJoinPool`: This executor provides a work-stealing algorithm for executing tasks that can be divided into smaller sub-tasks. It's designed for parallelizing recursive algorithms and is useful for processing large amounts of data.

```java
// ThreadPoolExecutor example
ExecutorService executor = Executors.newFixedThreadPool(3);
for (int i = 0; i < 10; i++) {
    executor.execute(() -> {
        // Execute the task here
    });
}
executor.shutdown();

// ScheduledThreadPoolExecutor example
ScheduledExecutorService scheduledExecutor = Executors.newScheduledThreadPool(2);
scheduledExecutor.schedule(() -> {
    // Execute the task after a delay
}, 5, TimeUnit.SECONDS);
scheduledExecutor.shutdown();

// ForkJoinPool example
ForkJoinPool forkJoinPool = new ForkJoinPool();
forkJoinPool.invoke(new RecursiveAction() {
    protected void compute() {
        // Execute the task here
    }
});
forkJoinPool.shutdown();

```

## 14. Difference between shutdown() and shutdownNow() methods of executor.

The `shutdown()` method initiates **a graceful shutdown of the executor, allowing any submitted tasks to complete their execution before shutting down the executor**. The method does not accept any new tasks after it's called, but any tasks that have already been submitted will be executed. Once all tasks have completed their execution, the executor is shut down, and the method returns.

The `shutdownNow()` method, on the other hand, **initiates an abrupt shutdown of the executor by interrupting any running tasks and discarding any tasks that haven't started execution yet**. The method returns a list of tasks that were submitted but haven't started execution yet, allowing you to handle them appropriately.

## 15. What is Atomic classes? When do we use it?

Atomic classes provide several benefits over traditional synchronization mechanisms such as `synchronized` blocks or methods. One of the main benefits is that atomic classes provide better performance in highly-contended scenarios. Another benefit is that they are less error-prone than traditional synchronization mechanisms since they eliminate the need for locks and can prevent race conditions and deadlocks.

Atomic classes are useful in situations **where multiple threads need to access the same variable concurrently.** For example, in a web application, multiple threads may need to access a counter variable that keeps track of the number of requests processed. In this case, using an atomic class such as `AtomicInteger` can ensure that the counter is updated atomically and without the need for locks or synchronization.

## 16. What is the concurrent collections?

Concurrent collections are data structures that are designed to be used in multi-threaded programs. They are similar to the standard Java collections, but with added features to ensure thread-safety and avoid race conditions and deadlocks.

| Traditional Collection | Concurrent Collection   |
| ---------------------- | ----------------------- |
| `ArrayList`            | `CopyOnWriteArrayList`  |
| `LinkedList`           | `ConcurrentLinkedDeque` |
| `HashSet`              | `ConcurrentHashSet`     |
| `TreeSet`              | `ConcurrentSkipListSet` |
| `HashMap`              | `ConcurrentHashMap`     |
| `TreeMap`              | `ConcurrentSkipListMap` |
| `ArrayDeque`           | `ArrayBlockingQueue`    |

## 17. What kinds of locks do you know?

1. `synchronized` keyword: This is the most basic form of locking in Java and is used to ensure that only one thread can access a shared resource at a time. The `synchronized` keyword is used to mark a method or block of code as synchronized, and only one thread can execute the synchronized code at a time.
2. `ReentrantLock`: This is a more flexible form of locking in Java and provides additional features such as fairness, interruptible locks, and tryLock(). A `ReentrantLock` can be acquired and released multiple times by the same thread, which can be useful in certain situations.
3. `ReadWriteLock`: This type of lock provides separate locks for reading and writing to a shared resource. Multiple threads can hold the read lock simultaneously, but only one thread can hold the write lock at a time.
4. `StampedLock`: This type of lock is similar to `ReadWriteLock`, but provides a more flexible way of controlling access to shared resources. A `StampedLock` allows multiple readers and a single writer, and also provides support for optimistic locking.
5. `Semaphore`: This is a type of lock that allows a fixed number of threads to access a shared resource at a time. A semaphore can be used to limit the number of threads that can access a shared resource concurrently.

## 18. What is the difference between class lock and object lock?

Class locks are associated with a class, while object locks are associated with an instance of a class. When a thread acquires **a class lock, it blocks access to all synchronized static methods of the class**. When a thread acquires **an object lock, it blocks access to all synchronized instance methods of the object**.

**What is the difference between synchronized(this) and synchronized(Singleton.class)?**

```java
public class Singleton {
    private static Singleton instance;

    public synchronized static Singleton getInstance() {
        if (instance == null) {
            instance = new Singleton();
        }
        return instance;
    }

    public void myMethod() {
        synchronized (this) {
            // synchronized block of code using object lock
        }

        synchronized (Singleton.class) {
            // synchronized block of code using class lock
        }
    }
}

```

Note that using `synchronized(this)` can be less efficient than using `synchronized(Singleton.class)` since it can lead to contention between threads that are trying to acquire the lock on different instances of the same class. In contrast, using `synchronized(Singleton.class)` acquires a lock on the entire class, which can prevent contention and improve performance. However, it's important to use class locks judiciously since they can affect the performance of your application, especially in highly-concurrent scenarios.

More details:

* Object Lock

  * Lock non-static variable

  * Lock this

  * Lock non-static method

    ```java
    private Object lock = new Object();
    
    // 1. Lock non-static variable
    public void lockObjectField() throws InterruptedException {
        synchronized(lock) {
            //...
        }
    }
    
    // 2. Lock this
    public void lockThis() throws InterruptedException {
        synchronized(this) {
            //...
        }
    }
    
    // 3. Lock non-static method
    public synchronized void methodLock() throws InterruptedException {
        // ...
    }
    ```

    **使用对象锁的情况，只有使用同一实例的线程才会受锁的影响，多个实例调用同一方法也不会受影响。**

* Class Lock:

  * Lock static variable

  * Lock xxx.class

  * Lock static method

    ```java
    private static Object lock = new Object();
    
    // 1. Lock static variable
    public void lockStaticObjectField() throws InterruptedException {
        synchronized(lock) {
            //..
        }
    }
    
    // 2. Lock xxx.class
    public void lockClass() throws InterruptedException {
        synchronized(ClassLock.class) {
            //...
        }
    }
    
    // 3. Lock static method
    public static synchronized void lockMethod() throws InterruptedException {
        //...
    }
    ```

    **类锁是所有线程共享的锁，所以同一时刻，只能有一个线程使用加了锁的方法或方法体，不管是不是同一个实例。**

## 19. What is future and completableFuture?

`Future` and `CompletableFuture` are Java classes that provide a way to perform asynchronous and non-blocking computations.

A `Future` represents a computation that may not have completed yet. It provides a way to check whether the computation is done, retrieve the result of the computation, or cancel the computation. The `get()` method of the `Future` class blocks the calling thread until the computation is complete, which can be inefficient if the computation takes a long time to complete.

`CompletableFuture`, on the other hand, is an extension of the `Future` class that provides a more flexible and powerful way to work with asynchronous computations. A `CompletableFuture` represents a computation that may or may not have completed yet, and allows you to chain together multiple computations in a declarative and concise way. It also provides a number of methods for composing, combining, and transforming asynchronous computations, such as `thenApply()`, `thenCompose()`, `thenAccept()`, and `allOf()`, among others.

`Future` may cause blocking because `.get()` will wait for the future object to get the answer.

## 20. What's ThreadLocal

`ThreadLocal` is a class that provides a way to create variables that are local to a thread. Each thread that accesses a `ThreadLocal` variable has its own, independently initialized copy of the variable.

To use a `ThreadLocal` variable, you create an instance of the `ThreadLocal` class and then use its `get()` and `set()` methods to access the variable. The `get()` method returns the value of the variable for the current thread, while the `set()` method sets the value of the variable for the current thread.

```java
public class MyThreadLocal {
    private static final ThreadLocal<Integer> threadLocal = new ThreadLocal<Integer>() {
        @Override
        protected Integer initialValue() {
            return 0;
        }
    };

    public static void main(String[] args) {
        Thread thread1 = new Thread(() -> {
            threadLocal.set(1);
            System.out.println("Thread 1: " + threadLocal.get());
            threadLocal.remove();
        });

        Thread thread2 = new Thread(() -> {
            threadLocal.set(2);
            System.out.println("Thread 2: " + threadLocal.get());
            threadLocal.remove();
        });

        thread1.start();
        thread2.start();
    }
}
```

## 22. Important interview questions.

1. What is the difference between t.start() and t.run() ?
   * t.start() creates a new thread to execute the task in t.run().
   * t.run() executes the task in the current thread.
2. What is the difference between Callable and Runnable?
   * Runnable has no return. Callable has return.
   * Callable must be executed by using thread pool.
3. Can we use new Thread(lambda)? Is it equal to implement Runnable? Why?
   * Yes, the runnable interface is @FunctionalInterface, and has only one abstract method.
   * The only one abstract method is run().
4. When will the thread terminate?
   * If there is no infinite loop, it will terminate when the task is done.
5. Which one is popular between Runnable and Callable? Why?
   * The popularity of Runnable and Callable depends on the specific use case. Runnable is more popular for simple tasks, while Callable is more popular for complex tasks that require a result.

6. If we need two locks, what can we do?

   * Use two objects to be as locks.

     ```java
     class Counter {
     	public static final Object LOCK_1 = new Object();
         public static final Object LOCK_2 = new Object();
     }
     ```

7. What is the difference between synchronized(this) and synchronized(Singleton.class)?

   * One is an Object Lock and the other is a Class Lock.
   * When using object locks, only threads using the same instance will be affected by the lock, and multiple instances calling the same method will not be affected. The class lock is a lock shared by all the threads, so at the same time, only one thread can use the locked method or method body, regardless of whether it is the same instance or not.
   * Object lock may cause contention, while class lock won't.

8. How many ways can we create a thread for task?

   * See 2

9. What is the main difference between synchronized and ReentrantLock?

   * ```java
     if (lock.tryLock(1, TimeUnit.SECONDS)) {
         try {
             ...
         } finally {
             lock.unlock();
         }
     }
     ```

