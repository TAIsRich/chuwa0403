# Homework 6
## 1.  Explain volatile variables in java? (we also use it in Singleton)
Volatile variables will never be cached and all writes and reads will be done to and from the memory. It is used to modify the value of a variable by different threads. 

## 2. how to create a new thread(Please also consider Thread Pool case)?
### Create the thread directly
* ```Thread t = new Threads();```
* ``` Thread t = new Threads(new MyRunnable());``` or we can use the lambda expressions here. ```Thread t = new Thread(() -> //do something here);
### Create the thread using the threadpool;
* ``` ExecutorService executor = Executors.newFixedThreadPool(10);```

## 3. Difference between Runnable and Callable
* Runnable has no return values, callable does.
* Runbale cannot throw checked exception but callable does.
* We can run runnable tasks using Thread Class and executor service; while we can only use executor service to run callable;

## 4. what is the diff between t.start() and t.run()?
* t.start() generates a thread and new thread call the run() method;
* t.run() only calls run method on calling thread.

* t.start() defined in thread class;
* t.run() Defined in java.lang.Runnable interface and must be overridden in the implementing class.

## 5. Which way of creating threads is better: Thread class or Runnable interface?
Implementes runnable interface is much better. It use less memory and makes the code less coupled as the code of 

## 6. what is the thread status?
Thread status represents the what a thread is doing right now. Status include ready, running, waiting, sleeping, blocked, terminated.

## 7. difference between wait() and sleep() method
* wait() is called by the lock and release the lock after calling it. It is used for inter-thread communication.
* sleep() doesn't release any lock while keep the current thread wait. It is used for introducing pause on an execution.

## 8. What is deadlock?
Thread1 grabbed lock A while asking for lock B, at the same time thread2 grabbed the lock B while asking for lock A.

## 9. how do threads communicate with each other?
wait(), notify() and notifyAll().

## 10. what is join() method?
Join() is called by a thread. It will the block the caller thread until the thread whose join method is called has completed.

## 11. what is yield() method
It stop the currently executing thread and will give a chance to other waiting threads of the same priority. If there are no waiting threads or the 
priority of the waiting threads are lower or equal to the thread, then the thread will continue its execution.

## 12. Explain thread pool
Thread pool represents a group of worker threads that are waiting for the job and can be reuse many times.
Thread pools offers better performance and resource management compared to create single threads directly. Thread pool controls the number of control the number
of concurrent tasks, reduce the overhead of thread creation and destruction and improve the performance. 
<!-- Thread pools allow tasks queueing for pending executions, -->
<!-- automatically managing thread lifecycles and provide more flexible error handleing mechanisms. -->

## 13. What is Executor Framework in Java, its different types and how to create these executors?
Executor is an interface the provides a way of decoupling task submission from the mechanics of how each tasks will be run, including the details of how the threads are 
created and scheduled and used.

* FixedThreadPool: the number of threads is fixed;
* CachedThreadPool: the number of threads is adjusted dynamically by thread pool;
* SingleThreadExecutor: only one thread in the trhead pool.

An executor can be implemented by calling ```ExecutorSerice es = Executors.newFiexedThreadPool(10);``` 

## 14. Difference between shutdown() and shutdownNow() methods of executor
* shutDown() will allow previously submitted tasks to continue executing before terminating;
* shutDownNow() will prevent the waiting tasks from starting and attempts to stop the currently executing tasks.

## 15. What is Atomic classes? when do we use it?
Atomic classes supports atomic operations on single variables. All classes have get and set methods that work like reads and writes on volatile variables.

We can use it as a counter.

## 16. What is the concurrent collections?
Collections that are thread safe.
List -> CopyOnWriteArrayList

Map -> ConcurrentHashMap

Set -> CopyOnWriteArraySet

Queue -> ArrayBlockingQueue


## 17. what kind of locks you know?
* ReentrantLock: implememts lock interface;
* Read write lock: multiread and only write;
* StampedLock: allow writes while read.

## 18. What is the difference between class lock and object lock?
It has different memory location. 

Object lock is used when non-static method or code block can only accessed by one thread;

Class lock prevents multiple threads to enter in synchronized block in any of all available instances of the class on runtime.   

## 19. What is future and completableFuture?
Future is a class that holds results from threads. It may block caller threads.

CompletableFuture implements the future interface and provide powerful asynchronous capabilities, support chaining operations for easy combination 
and management of multiple asychrnous tasks. It provides non-blocking asychrnous operations.

## 20. what is ThreadLocal?
ThreadLocal variables differ from their normal counterparts in that each thread that accesses one has its own independently initialized copy of the variable.
ThreadLocal instances are typically private static fields in classes that wish to associate state with a thread.
It guarantees keeping the context in the stream work without having to pass parameters.

## 21. 
Please see [multithreading](./../Coding/Hw6/multithreading/src/main/java)

## 22.
What's the difference between thread and process?

Thread: It simply refers to the smallest units of the particular process. It has the ability to execute different parts (referred to as thread) of the program at the same time.  

Process: It simply refers to a program that is in execution i.e., an active program. A process can be handled using PCB (Process Control Block). 

What’s the difference between class lock and object lock?

Class Lock: In java, each and every class has a unique lock usually referred to as a class level lock. These locks are achieved using the keyword ‘static synchronized’ and can be used to make static data thread-safe. It is generally used when one wants to prevent multiple threads from entering a synchronized block. 

Object Lock: In java, each and every object has a unique lock usually referred to as an object-level lock. These locks are achieved using the keyword ‘synchronized’ and can be used to protect non-static data. It is generally used when one wants to synchronize a non-static method or block so that only the thread will be able to execute the code block on a given instance of the class.  

## 23.
* Please see [OddEventPrinter.java](./../Coding/Hw6/multithreadHw/src/main/java/odd_even_printer/OddEventPrinter.java)
* Please see [OddEventPrinter2.java](./../Coding/Hw6/multithreadHw/src/main/java/odd_even_printer/OddEventPrinter2.java)

## 24.
Please see [PrintNumber.java](./../Coding/Hw6/multithreadHw/src/main/java/print_number/PrintNumber.java)

## 25.
* Please see [Hw1.java](./../Coding/Hw6/multithreadHw/src/main/java/completablefuture/Hw1.java)
* Please see [Hw2.java](./../Coding/Hw6/multithreadHw/src/main/java/completablefuture/Hw2.java)
* Please see [Hw3.java](./../Coding/Hw6/multithreadHw/src/main/java/completablefuture/Hw3.java)
