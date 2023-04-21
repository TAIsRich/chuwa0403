# 1.  Explain volatile variables in java? (we also use it in Singleton)
## The volatile modifier is used to let the JVM know that a thread accessing the variable must always merge its own private copy of the variable with the master copy in the memory. Accessing a volatile variable synchronizes all the cached copied of the variables in the main memory.
# 2.  how to create a new thread(Please also consider Thread Pool case)?
## Extends Thread Class
```
public class MyThread extends Thread {
    @Override
    public void run() {
        System.out.println("start new thread using extends thread");
    }
}
Thread t = new MyThread();  // JVM没有创建thread 
t.start(); // 此时JVM才创建新的thread
```
## Implements Runnable
```
public class MyRunnable implements Runnable{
    @Override
    public void run() {
        System.out.println("Start new thread using Runnable");
    }
}
Thread t2 = new Thread(new MyRunnable());
```
## Implements Callable
```
public class MyCallable implements Callable<String> {
    @Override
    public String call() throws Exception {
        Thread.sleep(5000);
        return "Start new thread using Callable";
    }
}
```
# 3.  Difference between Runnable and Callable
## A callable interface throws the checked exception and returns the result. A runnable interface, on the other hand, does not return a result and cannot throw a checked exception.
# 4.  what is the diff between t.start() and t.run()?
## t.start starts a new thread to excute the task（run()）
## t.run() excute the task in the current thread.
# 5.  Which way of creating threads is better: Thread class or Runnable interface?
## implement a Runnable interface instead of extending Thread class.
# 6.  what is the thread status?
## new, runnable, blocked, waiting, timed_waiting, and terminated.
## NEW
### A thread that has not yet started is in this state.
## RUNNABLE
### A thread executing in the Java virtual machine is in this state.
## BLOCKED
### A thread that is blocked waiting for a monitor lock is in this state.
## WAITING
### A thread that is waiting indefinitely for another thread to perform a particular action is in this state.
## TIMED_WAITING
### A thread that is waiting for another thread to perform an action for up to a specified waiting time is in this state.
## TERMINATED
### A thread that has exited is in this state.
# 7.  difference between wait() and sleep() method
## The major difference is that wait() releases the lock while sleep() doesn't release any lock while waiting. wait() is used for inter-thread communication while sleep() is used to introduce a pause on execution.
# 8.  What is deadlock?
## Deadlock describes a situation where two or more threads are blocked forever, waiting for each other.
# 9.  how do threads communicate with each other?
## using wait() and notify()
# 10. what is join() method?
## The join() method in Java is provided by the java.lang.Thread class that permits one thread to wait until the other thread to finish its execution.
# 11. what is yield() method
## The yield() method of thread class causes the currently executing thread object to temporarily pause and allow other threads to execute.
# 12. Explain thread pool
## A thread pool reuses previously created threads to execute current tasks and offers a solution to the problem of thread cycle overhead and resource thrashing. Since the thread is already existing when the request arrives, the delay introduced by thread creation is eliminated, making the application more responsive.
# 13. What is Executor Framework in Java, its different types and how to create these executors?
## The Executor Framework contains a bunch of components that are used to efficiently manage multiple threads. 
## SingleThreadExecutor
### single thread pool
## FixedThreadPool
### fixed size
## CachedThreadPool
### size is dynamic
# 14. Difference between shutdown() and shutdownNow() methods of executor
## shutdown() will just tell the executor service that it can't accept new tasks, but the already submitted tasks continue to run. shutdownNow() will do the same AND will try to cancel the already submitted tasks by interrupting the relevant threads. Note that if your tasks ignore the interruption, shutdownNow will behave exactly the same way as shutdown.
# 15. What is Atomic classes? when do we use it?
## The atomic classes provide a lock-free and thread-safe environment or programming on a single variable. It also supports atomic operations. All the atomic classes have the get() and set() methods that work on the volatile variable. The method works the same as read and writes on volatile variables.
# 16. What is the concurrent collections?
## Concurrent Collections are thread-safe collection classes that we should use in a scenario where our code involves simultaneous access to a collection. Unlike collections, concurrent collections have a reliable behavior in a multi-threaded environment.
# 17.  what kind of locks you know?
## ReadWriteLock, A ReadWriteLock maintains a pair of associated locks, one for read-only operations and one for writing. The read lock may be held simultaneously by multiple reader threads, so long as there are no writers
# 18. What is the difference between class lock and object lock?
## Object Level Locks − It can be used when you want non-static method or non-static block of the code should be accessed by only one thread. Class Level locks − It can be used when we want to prevent multiple threads to enter the synchronized block in any of all available instances on runtime.
# 19. What is future and completableFuture?
## An asynchronous programming tool introduced in Java 8. Implements the Future interface, providing powerful asynchronous capabilities. Supports chaining operations for easy combination and management of. multiple asynchronous tasks. Non-blocking asynchronous operations
# 20. what is ThreadLocal?
## The Java ThreadLocal class enables you to create variables that can only be read and written by the same thread. ThreadLocal instances are typically private static fields in classes that wish to associate state with a thread.
# 21. Type the code by your self and try to understand it. (package com.chuwa.tutorial.t08_multithreading)
## java files
# 22. Read those interview questions and pick some important questions to this homework.
## What will happen if we don’t override the thread class run() method?
### Nothing will happen as such if we don’t override the run() method. The compiler will not show any error. It will execute the run() method of thread class and we will just don’t get any output because the run() method is with an empty implementation.
## What's the difference between thread and process?
### Thread: It simply refers to the smallest units of the particular process. It has the ability to execute different parts (referred to as thread) of the program at the same time.
### Process: It simply refers to a program that is in execution i.e., an active program. A process can be handled using PCB (Process Control Block).
## What's the difference between User thread and Daemon thread?
### User Thread (Non-Daemon Thread): In Java, user threads have a specific life cycle and its life is independent of any other thread. JVM (Java Virtual Machine) waits for any of the user threads to complete its tasks before terminating it. When user threads are finished, JVM terminates the whole program along with associated daemon threads.
### Daemon Thread: In Java, daemon threads are basically referred to as a service provider that provides services and support to user threads. There are basically two methods available in thread class for daemon thread: setDaemon() and isDaemon(). 
# 23. write a code to create 2 threads, one thread print 1,3,5,7,9, another thread print 2,4,6,8,10.
## a. One solution use synchronized and wait notify
### 
## b. One solution use ReentrantLock and await, signa
### 
# 24. create 3 threads, one thread ouput 1-10, one thread output 11-20, one thread output 21-22. threads run sequence is random.
## 
# 25. completable future:
## a. Homework 1: Write a simple program that uses CompletableFuture to asynchronously get the sum and product of two integers, and print the results.
### 
## b. Homework 2: Assume there is an online store that needs to fetch data from three APIs: products, reviews, and inventory. 
### 
## c.  Homework 3: For Homework 2, implement exception handling. If an exception occurs during any API call, return a default value and log the exception information.
### 