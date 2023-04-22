# hw 6 - Multi Thread
1. Explain volatile variables in Java

volatile variable is guaranteed that all threads accessing the variable will see the most up-to-date value. volatile vairables are often used in multi-threaded applicatioins to ensure that all threads can see changes made to a shared variable by another thread, and to prevent race conditions and other sychronization issues. It is acoomplished by ensuring that all reads and writes of the varaible are performed directly to main memory, rather than relying on cached values that may differ across threads,

2. How to create a new thread
    - Extends Thread Class
    ```
    public class MyThread extends Thread{
        @Override 
        public void run(){ ... }
    }
    Thread t = new MyThread();
    t.start();
    ```
    - Implementing the Runnable interface
    ```
    class MyRunnable implements Runnable{
        @Override
        public void run(){}
    }
    Thread t2= new Thread(new MyRunnable());
    ```
    - Use lambda expression
    ```
    Thread t = new Thread(()->{});
    t.start();
    ```
    - Use the Executor Framework
    ```
    ExcutorService es = Executor.newFixedTreadPool(10);
    es.execute(()->{});
    ```

3. Difference between Runnable and Callable

Runnable has no return value while Callabe has the return value of the specified type and throw an exception.

4. what is the diff between t.start() and t.run()

t.start() starts a ne thread to execute the rask, which means the run() is also called.
t.run() execute the task in the current thread without creating a new thread.

5. Most of time, Using Runnable interface is better. It provided more flexibilty and can also implement other interfaces or extend other classes. Extending thread class is easy to access thread-specific variables and method using "this", but it can lead to inefficient use of resources.

6. Thread states: thread can have several states that indicate what the thread is currently doing. These states are defined by the `Thread.State`:
    - New: Just create a new thread and not start it to run.
    - Runnable state: the thread that is ready to run is moved to a runnable state. The thread might be running or it might be ready to run at any instant of time. 
    - Waiting: the thread is waiting for other threads to perform a particular action
    - Blocked: the thread is blocked by the lock and waiting for the lock to be released
    - Time waiting: the thread is waiting for another thread to perform a particular action which is a specified timeout
    - Terminated: the thread has competed its execution and exited.

7. Difference between wait() and sleep(): thread that call wait() will release the monitor and let other threads to acquire the lock. The thread will be the waiting state until other threads call notify() or notifyAll(). sleep() takes a time argument to pause the execution and don't release the monitor. 

8. Deadlock: a programming situation in a multi-threaded system where two or more threads are blcoked forever. Each thread is waiting for the other thread to release a resource that it needs to continue. It results in a circular waiting pattern. It occurs when multiple threads need the same locks but obtain them in different order. 

9. How do threads communicate with each other:
    - Shared Memory: thread can communicate by accessing shared data structures. The data should be synchronized using lock to prevent race conditions.
    - Signal and notifications: by using wait() and notify() methods, threads can communicate. wait() will cause a thread to wait for a signal from anther thread, while notify() sends a signal to a waiting thread.

10. join(): when a thread calss the join() on another thread, the calling thread will wait for the other thread to finish before conituning its own execution.

11. yeild(): it allows the currently executing thread to voluntarily give up. It will pause its execution temporarily.

12. Thread pool: it is a collection of pre-initialized threads that are available to perform a set of tasks. It creates a group of worker threads that can be reused multiple times. The waiting task will be in a queue to enter the thread pool and take one thread to execute. It could be destroied and the threads in there can also be realse together. It will reduce the overhead of creating and terminating new threads.

13. Executor Framework: it is used to manage threads. Especially it provide the ExecutorService to create and manage a thread pool. The main type are:
    - FixedThreadPool: create a thread pool with a fixed number of thread
    - CachedThreadPool: create a thread pool that will adjust the number of threads according to the tasks
    - SingleThreadExecutor: thread pool for a singal thread 
```
ExecutorService es = Executors.newFixedThreadPoll(4);
for(int i = 0;i<count;i++){
    es.submit(new Task());
}

class Task implements Runnable{
    @Override
    public void run(){}
}
```
Create a thread for task: `new Thread(new Task())` or `es.submit(new Task())`

14. shutdown() VS shutdownNow(): shutdown() method allows the already submitted tasks to complete their executtion and then terminates the thread pool. shotdownNow() attempts to forcefully stop the execution of all running tasks by interrupting the threads. It might lead to data loss and inconsistent states.

15. Atomic: Atomic classes provide atomic operations on variables without the need of explicit synchronization. An atomic operations is an operation that performed as a single, invisible unit of execution. It is used when multiple threads access and update a shared variable. By using this, we can ensure that each thread sees the latest value of the variable and that updates the data without need the explicit synchronization.

16. Cocurrent collections: The thread-safe version of collections. For example:  the ArrayList is the non-thread-safe collection, while CopyOnWriteArrayList is thread-safe. HashMap is not thread-safe while ConcurrentHashMap is safe.

17. Locks:
    - synchronized: use this key word to add lock, while it is heavy and the thread must wait when access this lock.
    - ReentrantLock: a thread can access this lock mutiple times. We need to create this lock, run lock() to lock and unlock() after using. It also provide a tryLock() method that allows a thread to attempt to acquire the lock without blocking. It returns a boolean vlaue indicating whether the lock was succefully acquired.
    - ReadWriteLock this lock allows multiple threads to read a shared resource simultaneously, but only one thread can write to the resource. 

18. class lock VS object lock: the class lock is shared for all instances of the class while the object lock is only for this instance. The class lock is for threads to access the static method or block.

19. Future & CompletableFuture: Future is used ot represent the result that may not be avaible yet. It provides methods for checking whether the result is available, waiting for the reuslt and retriving the result. CompletableFuture extend the Future interface. It can represent an asynchronous computation that may complete in the future.It provide additional features of executing operations.

20. ThreadLocal: it is a class that provides a way to create thread-local variables. A thread-local variable is a variable that is local to a specific thread and is not shared with other threads. Thread-local variables are typically used to store data that is specific to a particular thread, such as a user session or a database connection.

20. see [c_08](/Coding//MavenProject/src/main/java/hw6/multi_thread/)

21. Q:
    - When the thread terminated? if there is no infinite loop, it will terminated when task is done.
    - What is the main difference between synchronized and ReentrantLock? ReentrantLock provides more flexibility than synchronized. With ReentrantLock, you can have more than one condition variable and can control which thread gets notified when the condition variable is signaled. synchronized is generally faster than ReentrantLock for simple synchronization needs. However, for more complex scenarios, ReentrantLock can offer better performance due to its greater control over locking and unlocking.

21. see [OddEventPrinter](/Coding//MavenProject/src/main/java/hw6/multi_thread/c05_waitNotify/)

21. see [PrintNumber](/Coding//MavenProject/src/main/java/hw6/multi_thread/exercise/PrintNumber.java)

21. see [completable future](/Coding//MavenProject/src/main/java/hw6/multi_thread/exercise/)