# 1. Explain volatile variables in java? (we also use it in Singleton) 
In Java, the term "volatile" is used as a modifier for variables that are shared between multiple threads. 
A volatile variable is a variable that can be accessed by multiple threads simultaneously, and the value of a volatile variable is always read from and written to main memory.

# 2. how to create a new thread(Please also consider Thread Pool case)? 
- Extending the Thread class:
```
public class MyThread extends Thread {
    public void run() {
        // code to be executed by the new thread
    }
}

// creating a new instance of MyThread and starting the thread
MyThread thread = new MyThread();
thread.start();
```

- Implementing the Runnable interface:
```
public class MyRunnable implements Runnable {
    public void run() {
        // code to be executed by the new thread
    }
}

// creating a new instance of MyRunnable, wrapping it in a Thread object and starting the thread
MyRunnable runnable = new MyRunnable();
Thread thread = new Thread(runnable);
thread.start();
```

- Thread Pool:
```
ExecutorService executor = Executors.newFixedThreadPool(10); // create a thread pool with 10 threads
Runnable task = new MyRunnable(); // create a new task to be executed by the thread pool
executor.execute(task); // submit the task to the thread pool
```
# 3. Difference between Runnable and Callable 
- Return Value:
  The main difference between Runnable and Callable is that the run() method of Runnable doesn't return a value, whereas the call() method of Callable returns a value. 
    The call() method of Callable can return any object of the specified return type, whereas the run() method of Runnable cannot return any value.
- Exception Handling:
  Another difference between Runnable and Callable is how they handle exceptions. 
  The run() method of Runnable cannot throw checked exceptions, whereas the call() method of Callable can throw checked exceptions. In other words, if a checked exception is thrown by a task implemented using Callable, it must be handled or declared in the method signature.
- Usage with Executors:
  Callable is typically used with ExecutorService, which is a framework for managing threads in Java. ExecutorService provides a method called submit(), which takes a Callable object as a parameter and returns a Future object that can be used to retrieve the result of the Callable task. On the other hand, Runnable is used with Executor framework, which provides a similar interface to ExecutorService but cannot return a value.

# 4. what is the diff between t.start() and t.run()? 
The main difference between these two methods is that start() creates a new thread and then calls the run() method in the new thread, whereas run() simply executes the code in the current thread.
    
# 5. Which way of creating threads is better: Thread class or Runnable interface? 
Implementing the Runnable interface is generally considered a better approach for creating threads in Java.
Encapsulation and Reusability, Inheritance, Resource Utilization. 

# 6. what is the thread status? 
In Java, a thread can be in one of several states, which are represented by the Thread Stat. 
- NEW: A thread is in the NEW state when it has been created but has not yet been started using the start() method.
- RUNNABLE: A thread is in the RUNNABLE state when it is ready to run, but it has not been assigned to a processor yet. In other words, it is waiting to be executed by the thread scheduler.
- BLOCKED: A thread is in the BLOCKED state when it is waiting for a monitor lock to be released so that it can enter a synchronized block or method. This occurs when another thread holds the lock and is executing the synchronized code.
- WAITING: A thread is in the WAITING state when it is waiting indefinitely for another thread to perform a particular action, such as notifying it using the notify() method. The thread will remain in the WAITING state until it is either interrupted or notified.
- TIMED_WAITING: A thread is in the TIMED_WAITING state when it is waiting for a specified period of time for another thread to perform a particular action. This occurs when the thread is in a timed wait using methods such as Thread.sleep(), Object.wait(long timeout), or Thread.join(long timeout).
- TERMINATED: A thread is in the TERMINATED state when it has finished executing its run() method and has exited.

# 7. difference between wait() and sleep() method 
- Object dependency: The wait() method is called on an object, while the sleep() method is called on a thread. The wait() method is used to wait for a specific condition to occur on the object, while the sleep() method is used to simply pause the execution of the thread.

- Lock Release: When a thread calls wait() on an object, it releases any lock it holds on that object, allowing other threads to access the object. On the other hand, when a thread calls sleep(), it does not release any locks it holds.

- Notification: The wait() method can only be resumed by another thread calling notify() or notifyAll() on the same object, which releases the waiting thread and allows it to continue executing. The sleep() method, on the other hand, simply pauses the thread for a specified amount of time and then resumes execution when that time has elapsed.

- Exception handling: The wait() method can throw InterruptedException if the thread is interrupted while waiting, while the sleep() method also throws InterruptedException if the thread is interrupted while sleeping.

# 8. What is deadlock? 
In a multi-threaded program, a deadlock is a situation where two or more threads are blocked, waiting for each other to release a resource, resulting in a deadlock state where none of the threads can proceed.

# 9. how do threads communicate with each other? 
- Shared data structures
- Message passing

# 10. what is join() method? 
When a thread calls the join() method on another thread, it will wait until the other thread has completed its execution before continuing.
```
Thread thread = new Thread();
thread.start();
thread.join(); // waits for thread to complete execution
```

# 11. what is yield() method 
The yield() method is a static method of the Thread class that is used to temporarily pause the execution of the current thread and allow other threads of the same priority to execute. When a thread calls the yield() method, it essentially gives up its current turn of execution and allows other threads of the same priority to run.
```
Thread.yield();
```

# 12. Explain thread pool 
A thread pool is a collection of pre-initialized threads that are available for executing tasks. Instead of creating a new thread for every task, a thread pool maintains a pool of reusable threads that can be used to execute tasks.

# 13. What is Executor Framework in Java, its different types and how to create these executors? 
The Executor framework in Java provides a standard way to manage and execute tasks in a multi-threaded environment. It provides a set of interfaces, classes, and utilities that make it easier to develop concurrent applications.
```
// Creating a fixed thread pool with 10 threads
ExecutorService executor = Executors.newFixedThreadPool(10);

// Creating a cached thread pool
ExecutorService executor = Executors.newCachedThreadPool();

// Creating a single thread executor
ExecutorService executor = Executors.newSingleThreadExecutor();

// Creating a scheduled thread pool with 5 threads
ScheduledExecutorService executor = Executors.newScheduledThreadPool(5);
```
# 14. Difference between shutdown() and shutdownNow() methods of executor 
- shutdown() method:The shutdown() method is used to initiate a graceful shutdown of the thread pool. When the shutdown() method is called, the ExecutorService will stop accepting new tasks, and any tasks that have already been submitted will be allowed to complete. Once all tasks have completed, the thread pool will be shut down.

- shutdownNow() method:The shutdownNow() method is used to initiate an abrupt shutdown of the thread pool. When the shutdownNow() method is called, the ExecutorService will attempt to stop all running tasks and prevent any new tasks from being submitted. This method returns a list of tasks that were submitted but have not yet started running.

```
ExecutorService executor = Executors.newFixedThreadPool(10);

// Submitting tasks to the thread pool
for (int i = 0; i < 100; i++) {
    executor.submit(new Runnable() {
        @Override
        public void run() {
            // Task code goes here
        }
    });
}

// Initiating a graceful shutdown
executor.shutdown();

// Initiating an abrupt shutdown
List<Runnable> unexecutedTasks = executor.shutdownNow();
```
# 15. What is Atomic classes? when do we use it? 
In Java, atomic classes are a set of classes that provide thread-safe operations on single variables without requiring external synchronization. Atomic classes are designed to be used in multi-threaded environments where multiple threads may access and modify the same variable simultaneously.

Some common atomic classes in Java include:

- AtomicInteger: A class that provides atomic operations on integers.

- AtomicLong: A class that provides atomic operations on longs.

- AtomicBoolean: A class that provides atomic operations on booleans.

# 16. What is the cocurrent collections? 
In Java, concurrent collections are a set of thread-safe data structures that allow multiple threads to access and modify the collection simultaneously without the need for external synchronization. Concurrent collections provide high concurrency and performance, making them ideal for use in multi-threaded environments.

Some common concurrent collections in Java include:

- ConcurrentHashMap: A class that provides a thread-safe implementation of a hash table.

- ConcurrentLinkedQueue: A class that provides a thread-safe implementation of a linked list.

- ConcurrentSkipListMap: A class that provides a thread-safe implementation of a sorted map.

- ConcurrentSkipListSet: A class that provides a thread-safe implementation of a sorted set.

# 17. what kind of locks you know? 
- ReentrantLock: A lock that can be acquired and released multiple times by the same thread.

- ReadWriteLock: A lock that allows multiple threads to read a shared resource simultaneously, but only one thread can write to the resource at a time.

- ReentrantReadWriteLock: A lock that combines the features of a reentrant lock and a read-write lock.

- StampedLock: A lock that provides optimistic read locks, which do not block write locks, and pessimistic write locks, which block all other locks.

- Synchronized: A built-in lock in Java that is associated with every object and can be used to synchronize access to shared resources.

- Volatile: A keyword in Java that can be used to ensure that changes to a variable are visible to all threads.

# 18. What is the difference between class lock and object lock? 
Class locks are used to synchronize access to static methods or static variables of a class, while object locks are used to synchronize access to non-static methods or non-static variables of a specific instance of a class.

# 19. What is future and completableFuture? 
In Java, the Future and CompletableFuture classes are used to represent the result of an asynchronous computation that may not have completed yet. They provide a way to perform tasks asynchronously and retrieve their results when they become available.

- Future: The Future interface represents a result that may not be available yet. It provides methods for checking whether the result is ready, waiting for the result to become available, and retrieving the result. Futures are typically used with ExecutorService to submit a task for asynchronous execution and retrieve its result later.
```
ExecutorService executor = Executors.newSingleThreadExecutor();

Future<String> future = executor.submit(new Callable<String>() {
    @Override
    public String call() throws Exception {
        // Task code goes here
        return "Result";
    }
});

// Checking if the result is ready
boolean isReady = future.isDone();

// Waiting for the result to become available
String result = future.get();

// Shutting down the executor
executor.shutdown();
```

- CompletableFuture: The CompletableFuture class is an extension of the Future interface that provides additional methods for composing, combining, and chaining asynchronous computations. It provides a way to create asynchronous computations that can be composed together to form more complex computations.
```
CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> {
    // Task code goes here
    return "Result";
});

// Chaining the result of one computation to another
CompletableFuture<Integer> future2 = future.thenApply(result -> result.length());

// Combining the results of two computations
CompletableFuture<Integer> future3 = future.thenCombine(future2, (result1, result2) -> result1.length() + result2);

// Waiting for the result to become available
int result = future3.get();
```

# 20. what is ThreadLocal? 
ThreadLocal class is used to create thread-local variables, which are variables that are local to a specific thread and are not shared with other threads. Thread-local variables can be used to store state that is specific to a thread, such as a user session or a database connection.
```
public class MyThreadLocal {
    private static final ThreadLocal<String> threadLocal = new ThreadLocal<String>() {
        @Override
        protected String initialValue() {
            return "Default value";
        }
    };

    public static String getValue() {
        return threadLocal.get();
    }

    public static void setValue(String value) {
        threadLocal.set(value);
    }
}
```
# 21. Type the code by your self and try to understand it. (package com.chuwa.tutorial.t08_multithreading)

# 22.
* What is the difference between start() and run()?
* How to create a new thread?
* What kind of locks do you know? what the details of them?
* What is thread pool? what is the advantage and how to create a thread pool?
* What is callable? what is the diff between callable and runnable?
* What is future and competableFuture? give me the example in your experience.

# 23. write a code to create 2 threads, one thread print 1,3,5,7,9, another thread print 2,4,6,8,10. (solution is in com.chuwa.tutorial.t08_multithreading.c05_waitNotify.OddEventPrinter)
```
public class OddEventPrinter {
    private static final Object monitor = new Object();
    private static int value = 1;

    public static void main(String[] args) {
        PrintRunnable runnable = new PrintRunnable();
        new Thread(runnable).start();
        new Thread(runnable).start();
    }

    static class PrintRunnable implements Runnable {
        @Override
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
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}

```

```
public class WaitNotify {
    public static void main(String[] args) throws InterruptedException {
        TaskQueue q = new TaskQueue();
        ArrayList<Thread> ts = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            Thread t = new Thread() {
                @Override
                public void run() {
                    // 执行task
                    while (true) {
                        try {
                            String s = q.getTask();
                            System.out.println("execute task: " + s);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                            return;
                        }
                    }
                }
            };
            t.start();
            ts.add(t);
        }

        Thread add = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                // 放入task
                String s = "t-" + Math.random();
                System.out.println("add task: " + s);
                q.addTask(s);
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        add.start();
        add.join();
        Thread.sleep(100);
        for (Thread t : ts) {
            t.interrupt();
        }
    }
}

class TaskQueue {
    Queue<String> queue = new LinkedList<>();

    public synchronized void addTask(String s) {
        this.queue.add(s);
        this.notifyAll();
    }

    public synchronized String getTask() throws InterruptedException {
        while (queue.isEmpty()) {
            // wait()方法必须在当前获取的锁对象上调用，这里获取的是this锁，因此调用this.wait()
            // 调用wait()方法后，线程进入等待状态，wait()方法不会返回，直到将来某个时刻，线程从等待状态被其他线程唤醒后，wait()方法才会返回，然后，继续执行下一条语句。
            this.wait();
        }

        return queue.remove();
    }
}

```

# 24. 
```
public class PrintNumber1 {
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
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        PrintNumber1.class.notifyAll();
    }
}

```

# 25. 
- a. 
```
import java.util.concurrent.CompletableFuture;

public class CompletableFutureExample {
    public static void main(String[] args) {
        int a = 5;
        int b = 10;

        CompletableFuture<Integer> sumFuture = CompletableFuture.supplyAsync(() -> a + b);
        CompletableFuture<Integer> productFuture = CompletableFuture.supplyAsync(() -> a * b);

        sumFuture.thenAcceptAsync(sum -> System.out.println("Sum: " + sum));
        productFuture.thenAcceptAsync(product -> System.out.println("Product: " + product));
    }
}
```

- b.
```
public class CompletableFutureExample {
    public static void main(String[] args) {
        String baseUrl = "https://jsonplaceholder.typicode.com";

        CompletableFuture<String> productsFuture = fetch(baseUrl + "/products");
        CompletableFuture<String> reviewsFuture = fetch(baseUrl + "/reviews");
        CompletableFuture<String> inventoryFuture = fetch(baseUrl + "/inventory");

        CompletableFuture<Void> allFutures = CompletableFuture.allOf(productsFuture, reviewsFuture, inventoryFuture);

        allFutures.thenRun(() -> {
            String products = productsFuture.join();
            String reviews = reviewsFuture.join();
            String inventory = inventoryFuture.join();

            // Merge the fetched data for further processing
            String mergedData = products + reviews + inventory;

            System.out.println("Merged data: " + mergedData);
        });
    }

    private static CompletableFuture<String> fetch(String url) {
        return CompletableFuture.supplyAsync(() -> {
            // Fetch data from the API
            // ...

            return "Fetched data from " + url;
        });
    }
}
```

- c. 
```
public class CompletableFutureExample {
    private static final Logger LOGGER = Logger.getLogger(CompletableFutureExample.class.getName());

    public static void main(String[] args) {
        String baseUrl = "https://jsonplaceholder.typicode.com";

        CompletableFuture<String> productsFuture = fetch(baseUrl + "/products");
        CompletableFuture<String> reviewsFuture = fetch(baseUrl + "/reviews");
        CompletableFuture<String> inventoryFuture = fetch(baseUrl + "/inventory");

        CompletableFuture<Void> allFutures = CompletableFuture.allOf(productsFuture, reviewsFuture, inventoryFuture);

        allFutures.thenRun(() -> {
            String products = handleException(productsFuture);
            String reviews = handleException(reviewsFuture);
            String inventory = handleException(inventoryFuture);

            // Merge the fetched data for further processing
            String mergedData = products + reviews + inventory;

            System.out.println("Merged data: " + mergedData);
        });
    }

    private static CompletableFuture<String> fetch(String url) {
        return CompletableFuture.supplyAsync(() -> {
            try {
                // Fetch data from the API
                // ...

                return "Fetched data from " + url;
            } catch (Exception e) {
                LOGGER.log(Level.SEVERE, "Exception occurred during API call", e);
                return "Default value";
            }
        });
    }
```