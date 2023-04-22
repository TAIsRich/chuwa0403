## 1. Explain volatile variables in java? (we also use it in Singleton)
A volatile variable is a type of variable that can be accessed by multiple threads simultaneously. When a variable is declared as volatile, it ensures that its value is always read from the main memory and not from any thread's local cache. This guarantees that the most up-to-date value of the variable is always available to all threads.

In a Singleton pattern, a volatile variable is often used to ensure that the singleton instance is initialized properly in a multithreaded environment. Without using a volatile variable, it is possible for multiple threads to create multiple instances of the singleton, which is not desirable.
```java
public class Singleton {
   private static volatile Singleton instance;

   private Singleton() {}

   public static Singleton getInstance() {
      if (instance == null) {
         synchronized(Singleton.class) {
            if (instance == null) {
               instance = new Singleton();
            }
         }
      }
      return instance;
   }
}
```
## 2. how to create a new thread(Please also consider Thread Pool case)?
### Non-Thread Pool case:

1,**Extending the Thread class:** This involves creating a new class that extends the Thread class and overriding its run() method. 
```java
public class MyThread extends Thread {
    @Override
    public void run() {
        System.out.println("start new thread using extends 
thread");
    }
}
Thread t = new MyThread();  // JVM没有创建thread 
t.start(); // 此时JVM才创建新的thread
```
2,**Implementing the Runnable interface:** This involves creating a class that implements the Runnable interface and overriding its run() method.
```java
public class MyRunnable implements Runnable{
    @Override
    public void run() {
        System.out.println("Start new thread using Runnable");
    }
}
Thread t2 = new Thread(new MyRunnable());
```
3,**Implements Callable interfacce:** is similar to the Runnable interface, but it allows the thread to return a value and throw an exception. 
```java
public class MyCallable implements Callable<String> {
   public String call() throws Exception {
      // Code to be executed in this thread
      return "Hello World";
   }
}

MyCallable myCallable = new MyCallable();
FutureTask<String> futureTask = new FutureTask<>(myCallable);
Thread thread = new Thread(futureTask);
thread.start();

// Wait for the thread to complete and get the result
String result = futureTask.get();

```
### Thread Pool case:
Creating threads on demand can be expensive in terms of memory and time. A thread pool is a way to manage a pool of threads that are available for reuse.To create a thread pool in Java, you can use the ExecutorService interface, which provides a high-level API for managing a thread pool. 
```java
ExecutorService executor = Executors.newFixedThreadPool(10);

for (int i = 0; i < 100; i++) {
   executor.submit(new MyRunnable());
}

executor.shutdown();
```
## 3. Difference between Runnable and Callable

1, Runnable's run() method returns void, while Callable's call() method returns a value of the specified type.

2,Runnable doesn't throw a checked exception, while Callable can throw a checked exception.


## 4. what is the diff between t.start() and t.run()?

t.start() creates a new thread and runs the run() method in the new thread, while t.run() simply calls the run() method in the current thread.

## 5. Which way of creating threads is better: Thread class or Runnable interface?

Both the Thread class and the Runnable interface can be used to create threads in Java. However, using the Runnable interface is generally considered to be a better practice than extending the Thread class. Here are some reasons why:

1, Better object-oriented design: In Java, the Thread class is already a concrete class, which means that if you extend it to create your own thread, you're using inheritance to add functionality to a class that already exists. This violates the principle of composition over inheritance, which recommends that you should prefer composition (i.e., using interfaces) over inheritance whenever possible.

2, Improved flexibility: If you implement the Runnable interface, you can still use the Thread class to create and start the thread. This means that you can separate the code that you want to run in the thread (the Runnable implementation) from the code that creates and manages the thread (the Thread class).

3, Easier to maintain: When you implement the Runnable interface, you're creating a separate class for the code that you want to run in the thread. This makes your code more modular and easier to maintain, as you can change the behavior of the thread by modifying the Runnable implementation without affecting the Thread class or any other classes in your code.

4, Better resource utilization: If you extend the Thread class, each thread that you create will have its own object instance. This can be inefficient in terms of memory usage, especially if you need to create a large number of threads. On the other hand, if you implement the Runnable interface, you can reuse the same object instance to create multiple threads, which can save memory and improve resource utilization.

## 6. what is the thread status?
**New:** A new thread object has been created, but the start() method has not yet been called.

**Runnable:** In Java, the states of "ready" and "running" are generally referred to as "runnable." After a thread object is created, another thread (such as the main thread) calls its start() method. The thread is then in the runnable state, waiting in a pool of runnable threads for the thread scheduler to select it and give it CPU time. Once it has been given a time slice, it enters the running state.

**Blocked:** The thread is blocked on a lock.

**Waiting:** The thread has entered a state where it is waiting for another thread to perform a specific action, such as a notification or an interrupt.

**Timed Waiting:** This state is similar to the waiting state, but with a specified timeout period. The thread will automatically return from this state once the specified time has elapsed.

**Terminated:** The thread has finished executing and has exited.

## 7. difference between wait() and sleep() method

**wait()** method is used to pause the execution of a thread until another thread notifies it. It is used for inter-thread communication, where one thread needs to wait for another thread to complete some work before proceeding. When a thread calls wait(), it releases the lock on the object it is currently holding and goes into a waiting state. The thread remains in the waiting state until another thread calls notify() or notifyAll() on the same object, which wakes up the waiting thread.

**sleep()** method is used to pause the execution of a thread for a specified period of time. It is used to introduce a delay in the execution of a thread, for example, to give other threads a chance to execute or to simulate a slow operation. When a thread calls sleep(), it does not release any locks and remains in the same state until the specified time has elapsed, after which it returns to the runnable state.

## 8. What is deadlock?

Deadlock is a situation that can occur in a multithreaded environment where two or more threads are blocked indefinitely, waiting for each other to release resources or locks that they are holding.

Deadlocks happen when each thread is holding a resource that the other thread needs, and both threads are waiting for the other to release the resource before they can proceed. This results in a situation where neither thread can continue, and the program becomes stuck.

## 9. how do threads communicate with each other?

1, Shared memory: Multiple threads can share the same array or object and use synchronization mechanisms (such as locks) to avoid race conditions. For example, one thread writes data to an array and another thread reads from it.

2, Synchronization primitives: Multiple threads can coordinate their access to shared resources (such as files or databases) using synchronization primitives such as locks or semaphores. For example, one thread acquires a write lock on a file while another thread acquires a read lock on the same file.

3, Message passing: Multiple threads can communicate through a mechanism of sending and receiving messages (such as a queue or a pipe). For example, one thread sends messages to a queue and another thread reads from it.

4, Signals and interrupts: Multiple threads can use signals and interrupts for communication and synchronization. For example, one thread sends a signal to another thread to notify it to complete a certain task, or one thread receives an interrupt to cancel the operation of another thread.

## 10. what is join() method?

The join() method is a method defined in the Thread class, which is used to wait for a thread to complete its execution before proceeding with the execution of the current thread.

When a join() method is called on a Thread object, the current thread waits until the specified thread completes its execution. If the specified thread has already completed its execution, the join() method returns immediately.

## 11. what is yield() method?

The yield() method is a static method defined in the Thread class, which is used to pause the execution of the current thread and give other threads of the same priority a chance to execute.

When a yield() method is called on a Thread object, it temporarily stops the execution of the current thread and allows other threads to run. The scheduler selects another thread of the same priority to run, and the current thread may be selected again for execution after the other threads have had their turn.

## 12. Explain thread pool

A thread pool is a collection of pre-initialized worker threads that are available to perform a set of tasks concurrently. The thread pool is managed by a thread pool executor, which schedules tasks to be executed by the available threads in the pool. This provides a way to manage and reuse a finite number of threads to execute tasks, which can help to improve the performance and scalability of an application.

## 13. What is Executor Framework in Java, its different types and how to create these executors?

The Executor framework in Java provides a way to manage threads and execute tasks asynchronously. It is based on the concept of a thread pool, which contains a group of threads that can be reused to execute multiple tasks. The Executor framework provides several classes and interfaces that can be used to create and manage thread pools, and schedule tasks to be executed by these pools.

Some of the different types of Executors in Java are:

**newSingleThreadExecutor():** Creates a single thread executor that can be used to execute tasks sequentially.

**newFixedThreadPool(int n):** Creates a fixed-size thread pool that can be used to execute a maximum of n tasks concurrently.

**newCachedThreadPool():** Creates a thread pool that can dynamically adjust its size based on the number of tasks and the availability of system resources.

**newScheduledThreadPool(int n):** Creates a thread pool that can be used to schedule tasks to be executed at a specific time or after a certain delay.

## 14. Difference between shutdown() and shutdownNow() methods of executor

shutdown() initiates a graceful shutdown of the executor by preventing it from accepting new tasks and allowing already submitted tasks to complete, while shutdownNow() initiates an abrupt shutdown by attempting to cancel all currently executing tasks and preventing the executor from accepting new tasks. shutdown() waits for tasks to complete, while shutdownNow() interrupts the executing threads and returns a list of unstarted tasks. The choice of method depends on the desired behavior during executor shutdown.

## 15. What is Atomic classes? when do we use it?

Atomic classes are a set of thread-safe classes in Java that provide atomic operations on single variables. They provide a way to perform compound actions on a variable without requiring explicit locking, synchronization or volatile modifiers.
We use Atomic classes in multi-threaded environments where multiple threads access and modify the same variable concurrently. 
Some of the commonly used Atomic classes in Java are:

**AtomicBoolean:** A boolean value that can be atomically updated.

**AtomicInteger:** An integer value that can be atomically updated.

**AtomicLong:** A long value that can be atomically updated.

**AtomicReference:** A reference to an object that can be atomically updated.

For the AtomicInteger class, commonly used methods include:

**addAndGet(int delta):** Atomically adds the given value to the current value and returns the result, which is equivalent to count = count + delta.

**incrementAndGet():** Atomically increments the current value by 1 and returns the result, which is equivalent to ++counter.

**getAndSet(int newValue):** Atomically sets the new value and returns the previous value.

**getAndIncrement():** Atomically increments the current value by 1 and returns the previous value, which is equivalent to counter++.

```java
public class AtomicDemo {
    private static AtomicInteger atomicInteger = new 
AtomicInteger(1);
    public static void main(String[] args) {
        System.out.println(atomicInteger.getAndIncrement()); 
//count++ vs ++count
        System.out.println(atomicInteger.get());//count
    }
}
```

## 16. What is the cocurrent collections?

Concurrent collections are a set of thread-safe collections in Java that are designed to support concurrent access by multiple threads without the need for external synchronization. These collections allow multiple threads to access and modify the collection concurrently while ensuring thread-safety and consistency.

| Interface | Non-thread-safe | Thread-safe |
|-----------|----------------|-------------|
| List | ArrayList | CopyOnWriteArrayList |
| Map | HashMap | ConcurrentHashMap |
| Set | HashSet / TreeSet | CopyOnWriteArraySet |
| Queue | ArrayDeque / LinkedList | ArrayBlockingQueue / LinkedBlockingQueue |
| Deque | ArrayDeque / LinkedList | LinkedBlockingDeque |

## 17. what kind of locks you know?

**Reentrant Locks:** Allows a thread to acquire the same lock multiple times, providing a higher degree of control over lock acquisition and release.

**Read/Write Locks:** Allows multiple threads to read a shared resource simultaneously, but only one thread to write to the resource at a time.

**Stamped Locks:** Provides a more flexible read/write locking mechanism than Read/Write Locks, allowing optimistic reads that don't require obtaining a lock.

**Synchronized Blocks/Methods:** Provides the basic locking mechanism built into the Java language. A synchronized block/method ensures that only one thread at a time can access a block of code.

**Condition Locks:** Provides a more fine-grained locking mechanism where threads can wait for a specific condition to be met before acquiring a lock.

## 18. What is the difference between class lock and object lock?

In Java, every object has a lock associated with it, which is used to synchronize access to the object's fields and methods. This lock is commonly referred to as the "object lock".

On the other hand, a class lock is associated with a class and is used to synchronize access to static fields and methods of the class. A class lock is obtained by acquiring the object lock on the Class object representing the class.

The main difference between object lock and class lock is that object locks are associated with individual objects, while class locks are associated with classes. Object locks are used to synchronize access to instance methods and fields of an object, while class locks are used to synchronize access to static methods and fields of a class.

Another difference is that multiple threads can acquire the object lock on different objects of the same class simultaneously, while only one thread can acquire the class lock at a time.
```java
public class Counter {
    private static int count;
    
    public void increment() {
        synchronized(this) {
            count++;
        }
    }
    
    public static void decrement() {
        synchronized(Counter.class) {
            count--;
        }
    }
}
```
## 19. What is future and completableFuture?

**Future** is an interface in Java that represents a result of an asynchronous computation that may not yet be available. A Future can be used to check if a computation is complete, retrieve its result, or cancel the computation.

**CompletableFuture** is a class in Java that implements the Future interface and provides additional methods to compose multiple CompletableFuture instances together in a chain of computations. It also provides a way to explicitly complete a CompletableFuture with a value or an exception.

```java
blic class Main {
    public static void main(String[] args) throws Exception {
        // 创建异步执行任务:
        CompletableFuture<Double> cf = 
CompletableFuture.supplyAsync(Main::fetchPrice);
        // 如果执行成功:
        cf.thenAccept((result) -> {
            System.out.println("price: " + result);
        });
        // 如果执行异常:
        cf.exceptionally((e) -> {
            e.printStackTrace();
            return null;
        });
```
## 20. what is ThreadLocal?

ThreadLocal is a utility class in Java that provides a simple way to maintain a separate copy of a variable for each thread. Each thread can access its own copy of the variable without interfering with the copies of other threads. This is useful when we need to access shared variables in a thread-safe manner in a multi-threaded environment.

The typical usage of ThreadLocal is to use it as a static variable so that each thread can access a copy of the variable. Threads can use the get method to obtain their own copy of the variable, the set method to set their own copy of the variable, and the remove method to remove their own copy of the variable when it is no longer needed.

## 21. Type the code by your self and try to understand it. (package
com.chuwa.tutorial.t08_multithreading)

Done

## 23 - 25

Check Coding/hw6




