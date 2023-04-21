# 1. Explain volatile variables in java? (we also use it in Singleton)
A `volatile` variable means that its value can be modified by multiple threads, and that changes in its value should be immediately visible to other threads.
When a variable is declared as volatile, Java guarantees that any read or write operation on the variable will be atomic. This means that the variable's value will always be read or written in its entirety, even if the operation is interrupted by another thread.
Declaring a `Singleton` instance as `volatile` ensures that changes to the instance made by one thread are immediately visible to other threads.
Without the `volatile` keyword, changes made by one thread may not be visible to another thread.
# 2. how to create a new thread(Please also consider Thread Pool case)?
- Extends Thread Class
```
public class MyThread extends Thread {
@Override
public void run() {
System.out.println("start new thread using extends
thread");
 }
}
Thread t = new MyThread(); // JVM没有创建thread
t.start(); // 此时JVM才创建新的thread
```
- Implements Runnable
```
public class MyRunnable implements Runnable{
@Override
public void run() {
System.out.println("Start new thread using Runnable");
}
}
Thread t2 = new Thread(new MyRunnable());
```
- Implements Callable
```
public class MyCallable implements Callable<String> {
@Override
public String call() throws Exception {
Thread.sleep(5000);
return "Start new thread using Callable";
 }
}
```
- Thread pool.
# 3. Difference between Runnable and Callable
- `Runnable` has no return;

- `Callable` has return;

- `Callable` can throw a checked exception, `Runnable` cannot.
# 4. what is the diff between t.start() and t.run()?
`t.start` starts a new thread to excute the task（run()）

`t.run()` excute the task in the current thread.
# 5. Which way of creating threads is better: Thread class or Runnable interface?
Implementing the Runnable interface is preferred over extending the Thread class. This is because implementing the Runnable interface separates the task to be executed from the thread that executes it, and it allows the task to be executed by any thread. Another advantage of using Runnable is that it allows you to use the same task object with multiple threads, which can improve performance by reducing the overhead of creating and destroying threads.
# 6. what is the thread status?
- `New` A thread object is newly created, but the start() method has not been called yet.
- `Runnable` In Java threads, the two states of ready (ready) and running (running) are generally called "running". After the thread object is created, other threads (such as the main thread) call the object's start() method. The thread in this state is located in the runnable thread pool, waiting to be selected by thread scheduling, and obtains the right to use the CPU. At this time, it is in the ready state (ready). A thread in the ready state becomes the running state (running) after obtaining the CPU time slice.
- `Blocked` Indicates that the thread is blocked on the lock.
- `Waiting` The thread entering this state needs to wait for other threads to take some specific actions (notification or interruption).
- `TIMED_WAITING` This state is different from WAITING, it can return by itself after the specified time.
- `TERMINATED` ndicates that the thread has finished executing.
# 7. difference between wait() and sleep() method
- `wait()` is a method defined in the Object class, and it can only be called from within a synchronized block or method.
- `sleep()` is a static method defined in the Thread class, and it can be called from any context.
- `wait()` causes the thread to release the lock on the object and enter the waiting state, and `sleep()` does not release any locks or resources.
- `wait()` can be notified by another thread calling notify() or notifyAll() on the same object, and `sleep()` wakes up automatically after the specified time has elapsed.
# 8. What is deadlock?
A deadlock in Java threads occurs when two or more threads are blocked and waiting for each other to release the resources that they are holding, causing a circular dependency that cannot be resolved.
# 9. how do threads communicate with each other?
Java provides several classes and interfaces that can be used to facilitate communication between threads, including `wait()`, `notify()`, and `notifyAll()` methods of the Object class, which allow threads to synchronize on a shared object and communicate through signals.
# 10. what is join() method?
`join()` is a thread synchronization mechanism that allows one thread to wait for another thread to complete its execution before proceeding. When a thread calls the `join()` method on another thread, it waits for that thread to finish its execution before continuing its own execution.
# 11. what is yield() method
`yield()` is a thread control mechanism that allows a thread to voluntarily give up its current execution to give other threads a chance to run. When a thread calls the `yield()` method, it signals to the scheduler that it is willing to yield its current use of the CPU.
# 12. Explain thread pool
A thread pool is a collection of pre-initialized threads that are ready to perform tasks. A thread pool is used to improve the performance of a program by minimizing the overhead associated with creating and destroying threads.
# 13. What is Executor Framework in Java, its different types and how to create these executors?
- `ThreadPoolExecutor`
- `ScheduledThreadPoolExecutor`
- `ForkJoinPool`
Here is an example to create a `ThreadPoolExecutor` with 10 threads.
```
ExecutorService executor = Executors.newFixedThreadPool(10);
```
# 14. Difference between shutdown() and shutdownNow() methods of executor
`shutdown()` method initiates a graceful shutdown of the executor service, allowing existing tasks to complete before shutting down the executor service. And the `shutdownNow()` method initiates an immediate shutdown, interrupting any running tasks and preventing any new tasks from being submitted.
# 15. What is Atomic classes? when do we use it?
- `AtomicInteger`: provides atomic operations on an int variable.
-`AtomicLong`: provides atomic operations on a long variable
-`AtomicBoolean`: provides atomic operations on a boolean variable.
-`AtomicReference`: provides atomic operations on a reference variable.
We use Atomic classes when we need to perform atomic operations on a single variable in a multi-threaded environment.
# 16. What is the cocurrent collections?
Cocurrent collections are thread-safe collections. Here are some examples:
`CopyOnWriteArrayList`
`ConcurrentHashMap`
`CopyOnWriteArraySet`
`ArrayBlockingQueue`
`LinkedBlockingDeque`
# 17. what kind of locks you know?
- `ReentrantLock` It allows a thread to acquire and release a lock multiple times, and also provides support for interruptible lock acquisition, fairness, and timeouts.
- `ReadWriteLock` This lock provides separate read and write locks for a shared resource. Multiple threads can acquire the read lock at the same time, but only one thread can acquire the write lock at a time.
- `StampedLock` This is an advanced locking mechanism introduced in Java 8 that provides an optimistic locking mode in addition to the usual read and write locks. The optimistic locking mode allows multiple threads to access the shared resource concurrently without acquiring a lock, but if there is a conflict, the lock is acquired and the operation is retried.
- `Semaphore` This is a synchronization tool that allows a fixed number of threads to access a shared resource concurrently. It maintains a count of the number of permits available and allows threads to acquire or release permits.
# 18. What is the difference between class lock and object lock?
Object locks are used to synchronize access to instance methods and instance variables, while class locks are used to synchronize access to static methods and static variables. Object locks are associated with an instance of a class, while class locks are associated with the class itself.
# 19. What is future and completableFuture?
- `future` is a simple interface that represents the result of an asynchronous computation. It has methods to check if the computation is complete, to cancel the computation, and to retrieve the result of the computation.
- `completableFuture` is an extension of `future` that provides more advanced features for handling asynchronous computations. It provides a wide range of methods for composing, combining, and manipulating asynchronous computations. It also provides a way to explicitly complete a computation with a result or an exception, and to combine the results of multiple computations.
# 20. what is ThreadLocal?
ThreadLocal is a class in Java that provides thread-local variables. A thread-local variable is a variable that is local to a specific thread and is not shared between threads. Each thread that accesses the variable sees its own, independently initialized copy of the variable.
21. Type the code by your self and try to understand it. (package
com.chuwa.tutorial.t08_multithreading)
22. Read those interview questions and pick some important questions to this homework.