# HW6

## 1.  Explain volatile variables in java? (we also use it in Singleton)
In short, `volatile` keyword ensures all the reads and writes directly on main memory instead of cpu cache  
When applied to a variable, it indicates to JVM that the value of the variable may be modified by multiple threads.  
The `volatile` keyword guarantees the `Visibility`: When a thread reads the value of a volatile variable, it always gets the latest one  
However, the `volatile` keyword does not ensure atomicity, meaning that operations on volatile variables are not thread-safe if they involve multiple reads and writes

## 2.  how to create a new thread(Please also consider Thread Pool case)?
- extends Thread class
```aidl
public class MyThread extends Thread {
    @Override
    public void run() {
        System.out.println("start new thread using extends thread");
    }
}
```
- implements Runnable interface
```aidl
public class MyRunnable implements Runnable{
    @Override
    public void run() {
        System.out.println("Start new thread using Runnable");
    }
}
```
- implements Callable interface
```aidl
public class MyCallable implements Callable<String> {
    @Override
    public String call() throws Exception {
        Thread.sleep(5000);
        return "Start new thread using Callable";
    }
}
```
```aidl
public class Main {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        // use extends thread
        Thread t = new MyThread();
        t.start();
        System.out.println("***********");

        // use implements Runnable
        Thread t2 = new Thread(new MyRunnable());
        t2.start();
        // use implements Runnable using lambda expression
        Thread t3 = new Thread(() -> System.out.println("Start new thread by implementing Runnable with lambda"));
        t3.start();

        // user implements Callable
        // new our callable implementation class
        Callable<String> callable = new MyCallable();
        
        // Submit the callable to the executor
        ExecutorService executor = Executors.newSingleThreadExecutor();
        
        // Submit the callable to the executor
        Future<String> future = executor.submit(callable);
        
        // Get the result of the callable when it finishes
        String result = future.get();
        
        // Shut down the executor
        executor.shutdown();
    }
}
```

## 3.  Difference between Runnable and Callable
1. return value
`Runnable` doesn't have a return value, whereas a `Callable` does. The `call()` method of the `Callable` interface has a return value
2. exception handling
`Runnable` can't throw exceptions whereas `Callable` can throw
```aidl
Runnable runnable = new Runnable() {
    @Override
    public void run() {
        System.out.println("Runnable");
    }
};
```
```aidl
Callable callable = new Callable<Integer>() {
    @Override
    public Integer call() throws Exception {
        return 77;
    }
};
```

## 4.  what is the diff between t.start() and t.run()?
- `t.start()` starts a new thread and automatically calls the `t.run()` method
- `t.run()` won’t create a new thread, it is just executed on the calling thread itself

## 5.  Which way of creating threads is better: Thread class or Runnable interface?
1. Avoid the inconvenience cause by the single inheritance of a class  
In java, multiple inheritance is not allowed when inheriting classes, to make up to it, we use interfaces.  
If the class that contains asynchronous logic has already inherited a base class, it is not possible to inherit the Thread class again.     
Therefore, when there is an existing inheritance relationship, the only way to create a thread is to implement the Runnable interface.  


2. Separate business logic and data resources, making it easier to share data
Using Runnable interface is more suitable for scenarios where the same resource needs to be concurrently processed by multiple threads.  
In scenarios where multiple threads asynchronously and concurrently process the same resource, creating multiple target execution classes by implementing the Runnable interface can more conveniently and clearly separate the execution logic and data storage, better reflecting the object-oriented design
   1. 通过继承Thread类的方式实现多线程，数据资源和业务执行逻辑是耦合在一起的， 多个线程并发地完成各自的任务，访问各自的数据资源，而不是共享一份数据资源：
    ```aidl
    class MyThread extends Thread{
        private int ticket=3;
        public void run(){
            for(int i=0;i<3;i++){
                if(ticket>0){
                    System.out.println(Thread.currentThread().getName()+"卖票：ticket"+ticket--);
                }
            }
        }
    }
    
    public class ThreadDemo{
        public static void main(String args[]){
            MyThread mt1=new MyThread();
            MyThread mt2=new MyThread();
            mt1.start();
            mt2.start();
        }
    }
    ```
   多个线程并发地完成各自的任务，访问各自的数据资源：
    ```aidl
    1 Thread-0 卖票--->3
    2 Thread-1 卖票--->3
    4 Thread-0 卖票--->2
    5 Thread-1 卖票--->2
    6 Thread-1 卖票--->1
    7 Thread-0 卖票--->1
    ```
   2. 通过继承Thread类可以实现资源共享：
    ```aidl
    public class ThreadTask {
         private int ticket = 3;
         public synchronized void saleTicket(){
             for(int i=0;i<3;i++){
                 if(ticket>0){
                     System.out.println(Thread.currentThread().getName()+" 卖票--->"+ticket--);
                 }
             }
         }
    }
    ```
    ```aidl
    public class ThreadA extends Thread {
        ThreadTask threadTask ;
        public ThreadA(ThreadTask threadTask){
            super();
            this.threadTask = threadTask;
        }
        
        @Override
        public void run() {
            threadTask.saleTicket();
        }
    }
    ```
    ```aidl
    public class ThreadB extends Thread {
        ThreadTask threadTask ;
        public ThreadB(ThreadTask threadTask){
            super();
            this.threadTask = threadTask;
        }
        
        @Override
        public void run() {
            threadTask.saleTicket();
        }
    }
    ```
    ```aidl
    public class Main {
        public static void main(String[] args) throws InterruptedException {
            ThreadTask threadTask = new ThreadTask();
            ThreadA t1 = new ThreadA(threadTask);
            ThreadB t2 = new ThreadB(threadTask);
            t1.start();
            t2.start();
        }
    }
    ```
    ```
    1 Thread-0 卖票--->3
    2 Thread-1 卖票--->2
    3 Thread-1 卖票--->1
    ```
   3. 通过实现Runnable接口实现多线程，能更好地做到多个线程并发地完成同一个任务，访问同一份数据资源。多个线程的代码逻辑可以方便地访问和处理同一个共享数据资源 ，这样可以将线程逻辑和业务数据进行有效的分离，更好地体现了面向对象的设计思想。
    ```aidl
    public class RunnableDemo{
        public static class RunnableTask  implements Runnable{
            // 数据资源
            private int ticket = 3;
     
             // 线程执行体
            @Override
            public synchronized void run() {
                for(int i=0;i<3;i++){
                    if(ticket>0){
                        System.out.println(Thread.currentThread().getName()+" 卖票--->"+ticket--);
                         
                    }
                    System.out.println(Thread.currentThread().getName()+" 线程运行结束");
                }
            }
            
            public static void main(String[] args) {
                // 将这一个target作为参数传给两个线程，那么这两个线程执行的都是这个target的run()方法
                Runnable target = new RunnableTask();
       
                // 创建两个线程执行target的线程体
                Thread thread1 = new Thread(target,"thread1");
                thread1.start();
                Thread thread2 = new Thread(target,"thread2");
                thread2.start();
                System.out.println("main线程运行结束");
            }
    }
    ```
    ```aidl
    1 thread1 卖票--->3
    2 thread1 卖票--->2
    3 thread1 卖票--->1
    ```

[Useful link](https://www.cnblogs.com/r1-12king/p/16114755.html)


## 6.  what is the thread status?
1. **NEW** - When a thread is created but has not yet started. 
2. **RUNNABLE** - When a thread is ready to run, it enters the RUNNABLE state.   
In this state, the thread may actually be running, or it may be waiting for the CPU to become available to run. 
3. **BLOCKED** - A thread that is blocked is one that is waiting for a monitor lock to be released so that it can enter the RUNNABLE state again.  
When a thread is blocked, it is not using any CPU time. 
4. **WAITING** - When a thread is waiting, it is waiting for another thread to perform a particular action.   
A thread can be in the WAITING state indefinitely. 
5. **TIMED_WAITING** - This is similar to the WAITING state, but the thread is waiting for a certain amount of time before it can continue running. 
6. **TERMINATED** - When a thread has finished running, it enters the TERMINATED state


## 7. difference between wait() and sleep() method
1. Object level vs Thread level:  
The `wait()` method is an Object class method, which is used to pause the current thread until another thread calls the `notify()` or `notifyAll()` method on the same object.   
The `sleep()` method is a static method of the Thread class, which is used to pause the current thread for a certain amount of time. 
2. Locks:   
When a thread calls the `wait()` method, it releases any lock it holds and goes into a waiting state.  
When a thread calls the `sleep()` method, it does not release any locks it holds. 
3. Exception:   
The `wait()` method can throw an `InterruptedException` if the thread is interrupted while waiting.   
The `sleep()` method can also throw an `InterruptedException`, but it is not required to handle it. 
4. Usage:   
The `wait()` method is typically used for synchronization between threads.  
The `sleep()` method is typically used to pause a thread for a specified amount of time, such as to implement a delay or to perform periodic actions.

## 8.  What is deadlock?
Deadlock is a situation where more than one threads are blocked and unable to proceed because each thread is waiting for the other to release a resource or lock.   
This results in a deadlock, where neither thread can make progress and the entire system comes to a halt.  

Deadlock often occurs when multiple threads are competing for resources, such as shared objects, files, or network connections.   
For example, thread A is holding a lock on resource X and waiting to get a lock on resource Y, while thread B is holding a lock on resource Y and waiting to get a lock on resource X. As a result, both threads are blocked and unable to proceed, leading to a deadlock.
```aidl
class Counter {
    public static final Object LOCK_A = new Object();
    public static final Object LOCK_B = new Object();
    private static int value = 0;
    private static int another = 0;

    public static void add (int m) {
        synchronized (LOCK_A) {
            value += m;
            synchronized (LOCK_B) {
                another += m;
            }
        }

        System.out.println("value is: " + value + ", another is: " + another);
    }

    public static void dec(int m) {
        synchronized (LOCK_B) {
            another -= m;
            synchronized (LOCK_A) {
                value -= m;
            }
        }

        System.out.println("value is: " + value + ", another is: " + another);
    }
}
```
In the above example, to prevent deadblock, synchronized the shared objects in same order

## 9.  how do threads communicate with each other?
1. **Shared memory**:   
Threads can communicate through shared memory by accessing shared variables.   
For example, one thread can write to a shared variable and another thread can read from the same variable. However, we need to make sure that access to shared variables is synchronized properly to guarantee thread safety.
2. **Message passing**:   
Threads can communicate through messages. This can be done using a messaging system or by using Java's wait(), notify(), and notifyAll() methods.
3. **Pipes**:   
Threads can communicate through pipes by using Java's PipedInputStream and PipedOutputStream classes. This approach involves setting up a pipeline between threads where one thread writes to a pipe and the other thread reads from the same pipe. 
4. **Blocking queue**:   
Threads can communicate through a blocking queue, which is a thread-safe data structure that allows one thread to add items to the queue and another thread to remove items from the queue.   
This approach can be useful for implementing producer-consumer scenarios where one thread produces data and another thread consumes the data.

## 10. what is join() method?
The `join()` method is to make a calling thread wait for a target thread to finish its execution.   
When a thread calls `join()` on another thread, the calling thread will be blocked and will not continue until the target thread finishes
```aidl
public static void main(String[] args) throws InterruptedException {
     Thread t1 = new Thread(() -> {
         for (int i = 0; i < 5; i++) {
             System.out.println("Thread 1: " + i);
         }
     });

     Thread t2 = new Thread(() -> {
         for (int i = 0; i < 5; i++) {
             System.out.println("Thread 2: " + i);
         }
     });

     t1.start();
     t1.join(); // wait for t1 to complete before starting t2
     t2.start();
     t2.join(); // wait for t2 to complete before proceeding

     System.out.println("All threads completed.");
 }
```
## 11. what is yield() method
The `yield()` method is to pause the currently running thread and give the other threads a chance to execute.   
When a thread calls `yield()`, it means that gives up its current use of the CPU and let other threads run.
```aidl
public class YieldExample {
    public static void main(String[] args) {
        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                System.out.println("Thread 1: " + i);
                Thread.yield(); // yield to other threads
            }
        });

        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                System.out.println("Thread 2: " + i);
                Thread.yield(); // yield to other threads
            }
        });

        t1.start();
        t2.start();
    }
}
```
Both threads have a loop that prints their name and a number from 0 to 4. Between iterations, they call `Thread.yield()` to give other threads a chance to run.
```aidl
Thread 1: 0
Thread 2: 0
Thread 1: 1
Thread 2: 1
Thread 1: 2
Thread 2: 2
Thread 1: 3
Thread 2: 3
Thread 1: 4
Thread 2: 4
```

## 12. Explain thread pool
A thread pool is a group of pre-popularized threads that can be used to perform tasks  

Threads are objects, it takes computation power to create or destroy a thread. To reduce the cost, we use thread pool to pre-populate certain number of threads to be reused by different tasks

## 13. What is Executor Framework in Java, its different types and how to create these executors?
The Executor Framework is to manage and execute asynchronous tasks using a pool of threads. 
It provides a standard way to decouple task submission from task execution, simplifying the process of creating and managing threads in a Java application. 
It provides a set of interfaces and classes that enable the creation of thread pools and the scheduling and execution of tasks.

- FixedThreadPool: the number of threads is fixed; 
- CachedThreadPool: the number of threads changes according to the number of tasks; 
- SingleThreadExecutor: the number of threads is one
```aidl
public static void main(String[] args) {
    // create a fixed size thread poll:
    ExecutorService es = Executors.newFixedThreadPool(4); for (int i = 0; i < 6; i++) {
       // submit a task to the executor
       es.submit(new Task("" + i));
    }
    // close the thread pool:
    es.shutdown();
}
```

## 14. Difference between shutdown() and shutdownNow() methods of executor
These two are used to stop the execution of submitted tasks and shut down the executor
- `shutdown()`: It waits for the tasks that have been submitted but not yet executed to complete.   
It will not accept any new tasks after this method is called

- `shutdownNow()`: It stops all running tasks and refuse any new tasks to be submitted.   
It returns a list of tasks that were scheduled to be executed but were not started, as well as a list of tasks that were cancelled while running.

## 15. What is Atomic classes? when do we use it?
Atomic classes are a group of classes that provide thread-safe operations on single variables without the need for synchronization. 
They guarantee that a variable is updated atomically, meaning that the entire operation is executed as a single, indivisible unit of work. 
This ensures that the variable is always in a consistent state, even when multiple threads are accessing it concurrently.

The frequently used ones include:
- AtomicBoolean: A boolean value that can be atomically updated.
- AtomicInteger: An integer value that can be atomically updated.
- AtomicLong: A long value that can be atomically updated.

Atomic classes are useful in multithreaded applications where multiple threads need to access and modify a shared variable. 
They can be used to implement lock-free algorithms and improve performance by eliminating the need for synchronization.   
In general, atomic classes should be used when the value of a variable needs to be modified atomically, and the cost of synchronization is too high.

## 16. What are the concurrent collections?
Concurrent collections are a group of thread-safe collections that allow multiple threads to access and modify them concurrently without the need for explicit synchronization.   
They provide high-performance alternatives to the traditional collections in Java, which are not thread-safe and require explicit synchronization in a multithreaded environment.

| Non-thread-safe | Thread-safe |
| --------------- | ----------- |
| List: `ArrayList` | List: `CopyOnWriteArrayList` |
| Map: `HashMap` | Map: `ConcurrentHashMap` |
| Set: `HashSet` / `TreeSet` | Set: `CopyOnWriteArraySet` |
| Queue: `ArrayDeque` / `LinkedList` | Queue: `ArrayBlockingQueue` / `LinkedBlockingQueue` |
| Deque: `ArrayDeque` / `LinkedList` | Deque: `LinkedBlockingDeque` |

## 17. What kind of locks you know?
A lock is a synchronization mechanism that provides exclusive access to a shared resource to a single thread at a time  

- **synchronized vs lock**  
The `synchronized` keyword is a built-in mechanism of Java for implementing locks.   
It provides a simple way to ensure that only one thread can execute a block of code at a time. 
When a thread enters a synchronized block or method, it acquires the lock associated with the object or class that the block or method is synchronized on. 
Other threads that try to execute the same block or method must wait until the lock is released before they can execute.   <br>   
The Lock interface, provides a more flexible and powerful mechanism for implementing locks in Java.   
It allows finer-grained control over lock acquisition and release, and it supports additional features such as interruptible and reentrant locks.

- **Frequently-used locks**
  - **ReentrantLock**:  
  It allows threads to acquire the lock multiple times, that means that a thread that already holds the lock can acquire it again, which is known as reentrant.   
  It is a more flexible alternative to the synchronized keyword in Java, as it allows for more advanced lock acquisition mechanisms like fairness, interruptible lock acquisition, and non-blocking lock acquisition.  
  It uses `.lock()` and `.unlock()` methods to define the scope of a block of code that needs to be synchronized
  - **ReadWriteLock**:  
  It allows multiple readers to access a shared data at the same time, but only one writer can access the data at a time.   
  This can improve performance when there are many more reads than writes, as multiple threads can access the resource concurrently without blocking each other.   
  However, when a write is required, all readers must release their locks to allow the writer to acquire the lock.
  - **StampedLock**:  
  It is lock that allows for optimistic read operations, meaning that a thread can attempt to read a shared resource without acquiring a lock, 
  as long as it is known that no other threads are modifying the resource. If the thread's read operation succeeds, it returns a stamp that can be used to check if the resource has been modified before attempting to modify it. 
  This can improve performance in situations where there are many more reads than writes and allows for a more fine-grained control over locking.
```aidl
import java.util.concurrent.locks.*;

class Example {
    private ReentrantLock reentrantLock = new ReentrantLock();
    private ReadWriteLock readWriteLock = new ReentrantReadWriteLock();
    private StampedLock stampedLock = new StampedLock();
    private int sharedResource = 0;

    public void incrementWithReentrantLock() {
        reentrantLock.lock();
        try {
            sharedResource++;
        } finally {
            reentrantLock.unlock();
        }
    }

    public int readWithReadWriteLock() {
        readWriteLock.readLock().lock();
        try {
            return sharedResource;
        } finally {
            readWriteLock.readLock().unlock();
        }
    }

    public void incrementWithStampedLock() {
        long stamp = stampedLock.writeLock();
        try {
            sharedResource++;
        } finally {
            stampedLock.unlockWrite(stamp);
        }
    }

    public int readWithStampedLock() {
        long stamp = stampedLock.tryOptimisticRead();
        int value = sharedResource;
        if (!stampedLock.validate(stamp)) {
            stamp = stampedLock.readLock();
            try {
                value = sharedResource;
            } finally {
                stampedLock.unlockRead(stamp);
            }
        }
        return value;
    }
}

```

## 18. What is the difference between class lock and object lock?
The difference between class lock and object lock in Java is that class lock is associated with the class itself and used to synchronize access to static resources, 
while object lock is associated with a specific instance of the class and used to synchronize access to instance resources.

## 19. What is future and completableFuture?
- Future:  
  It is an interface used to represent the result of an asynchronous computation, where the computation is started in one thread and the result is obtained in another thread
- CompletableFuture:  
  A CompletableFuture is a subclass of Future introduced in Java 8 that provides more advanced features for asynchronous programming.   
It allows to chain multiple asynchronous operations together and provides a way to handle errors and exceptions in a more flexible manner.

## 20. What is ThreadLocal?
ThreadLocal is a class that provides a way to store data that is specific to a particular thread. 
Each thread that accesses a ThreadLocal variable has its own, independently initialized copy of the variable.
This means that ThreadLocal variables can be used to store thread-local state, such as user preferences, security credentials, or database connections, without requiring synchronization or worrying about race conditions. 
Each thread can access its own copy of the variable without interfering with other threads.

## 21. Type the code by your self and try to understand it. (package com.chuwa.tutorial.t08_multithreading)
See in `Coding/hw6/multithreading`

## 22. Read those interview questions and pick some important questions to this homework.
https://www.interviewbit.com/multithreading-interview-questions/#what-is-semaphore
- What's the difference between thread and process?  
  - Thread: It simply refers to the smallest units of the particular process. It has the ability to execute different parts (referred to as thread) of the program at the same time. 
  - Process: It simply refers to a program that is in execution i.e., an active program. A process can be handled using PCB (Process Control Block). 

- What is the lock interface? Why is it better to use a lock interface rather than a synchronized block.?  
Advantages of using Lock interface over Synchronization block:
  - Methods of Lock interface i.e., Lock() and Unlock() can be called in different methods. It is the main advantage of a lock interface over a synchronized block because the synchronized block is fully contained in a single method.  
  - Lock interface is more flexible and makes sure that the longest waiting thread gets a fair chance for execution, unlike the synchronization block.


## 23. write a code to create 2 threads, one thread print 1,3,5,7,9, another thread print 2,4,6,8,10. 
(solution is in com.chuwa.tutorial.t08_multithreading.c05_waitNotify.OddEventPrinter)
a. One solution use synchronized and wait notify
```aidl
public class OddEvenPrinter {
    private static final Object monitor = new Object();
    private static int value = 1;

    public static void main(String[] args) {
        OddEvenPrinter.PrintRunnable runnable = new OddEvenPrinter.PrintRunnable();
        new Thread(runnable).start();
        new Thread(runnable).start();
    }

    static class PrintRunnable implements Runnable {
        public void run() {
            synchronized (monitor) {
                while (value <= 10) {
                    System.out.println(Thread.currentThread().getName() + ": " + value++);

                    monitor.notify();
                    try {
                        if (value < 11) {
                            monitor.wait();
                        }
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        }
    }
}
```
b. One solution use ReentrantLock and await, signal  
```aidl
public class PrintNumbers {
    private static final ReentrantLock lock = new ReentrantLock();
    private static final Condition oddCondition = lock.newCondition();
    private static final Condition evenCondition = lock.newCondition();
    private static volatile int count = 1;

    public static void main(String[] args) {
        Thread oddThread = new Thread(() -> {
            try {
                lock.lock();
                while (count <= 10) {
                    if (count % 2 == 0) {
                        oddCondition.await();
                    } else {
                        System.out.println(Thread.currentThread().getName() + count++);
                        evenCondition.signal();
                    }
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            } finally {
                lock.unlock();
            }
        });

        Thread evenThread = new Thread(() -> {
            try {
                lock.lock();
                while (count <= 10) {
                    if (count % 2 == 1) {
                        evenCondition.await();
                    } else {
                        System.out.println(Thread.currentThread().getName() + count++);
                        oddCondition.signal();
                    }
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            } finally {
                lock.unlock();
            }
        });

        oddThread.start();
        evenThread.start();
    }
}
```

## 24. create 3 threads, one thread ouput 1-10, one thread output 11-20, one thread output 21-22. threads run sequence is random. 
(solution is in
com.chuwa.exercise.t08_multithreading.PrintNumber1)
```aidl
public class PrintNumberCopy {
    private static int n = 1;
    public static void main(String[] args) {
        Thread t1 = new Thread(() -> printNumber());
        Thread t2 = new Thread(() -> printNumber());
        Thread t3 = new Thread(() -> printNumber());

        t1.start();
        t2.start();
        t3.start();
    }

    private static synchronized void printNumber() {
        int count = 10;
        while (count-- > 0) {
            System.out.println(Thread.currentThread().getName() + ": " + n++);
        }

//        PrintNumberCopy.class.notifyAll();
    }
}
```

## 25. completable future:
1 . Homework 1: Write a simple program that uses CompletableFuture to
    asynchronously get the sum and product of two integers, and print the
    results. 
2. Homework 2: Assume there is an online store that needs to fetch data
    from three APIs: products, reviews, and inventory. Use
    CompletableFuture to implement this scenario and merge the fetched
    data for further processing. (需要找public api去模拟，)
    1. Sign In to Developer.BestBuy.com
    2. Best Buy Developer API Documentation
    (bestbuyapis.github.io)
    3.  可以用fake api https://jsonplaceholder.typicode.com/
3.  Homework 3: For Homework 2, implement exception handling. If an
    exception occurs during any API call, return a default value and log the
    exception information.
