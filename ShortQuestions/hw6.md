### 1. volatile variables in java
The Java volatile keyword is used to handle the multithread safty issues. It indicates the modified variables will be synchronized with main memory immediately and all reads operations will be read directly from main memory.

### 2. how to create a new thread(Please also consider Thread Pool case)?
1.Extend the Thread class, then .start()
2.Implement Runnable
3.Implement Callable
4.ThreadPoolExecutor(Executors.newFixedThreadPoll())

### 3. Difference between Runnable and Callable
1.Return value. Runnable has no return value while Callable dose.
2.Exception. Runnable has no exception while Callable dose.
3.ExecutorService can implement either Runnable or Callable while only Callable can return a Future object which obtains the result.

### 4. what is the diff between t.start() and t.run()?
.start() creates a new thread and prepares the thread to be runnable.
.run() is used to actually run the thread.

### 5. Which way of creating threads is better: Thread class or Runnable interface?
Generally Runnable is better because it is simplier when you do not care about return value and exceptions.

### 6. what is the thread status?
RUNNABLE: The thread is ready to run.
BLOCKED: The thread is holding a lock and waiting for the resources to be released.
WAITING: The thread is waiting for another thread to perform a particular action.
TERMINATED: The thread has finished its tasks.

### 7. difference between wait() and sleep() method
wait() is used for thread synchronization while sleep() is used to pause threads.

### 8. What is deadlock?
Deadlock is a situation occurs when two or more threads are waiting for the resources occupied by each other. Therefore, none of the threads can be completed.

### 9. how do threads communicate with each other?
wait() and notify
synchronized blocks or locks 

### 10. what is join() method?
If Thread A calls B.join() within its code block means A waits for B to finish and join.

### 11. what is yield() method？
yield() means the current thread is willing to yield its resourses and let other threads run.

### 12. Explain thread pool
A thread pool is a collection of threads that can be used to execute tasks concurrently. The number of the threads can be fixed or dynamically changed.

### 13. What is Executor Framework in Java, its different types and how to create these executors?
Executor is a framework simplify the process of executing asynchronous tasks in a multithreaded environment. It is used to manage threads, thread pools, and task execution. We have Executor and ExecutorService interfaces. These are most common implementations: ThreadPoolExecutor, SingleThreadExecutor, CachedThreadPoolExecutor.

### 14. Difference between shutdown() and shutdownNow() methods of executor
shutdown() will allow the running tasks to complete their execution before truly shut down the executor. shutdownNow() will shut down the executor immediatly.

### 15. What is Atomic classes? when do we use it?
Atomic classes are a set of classes used in multi-threads environments that provide thread-safe operations on single variables, for example, AtomicInteger.

### 16. What is the cocurrent collections?
Concurrent collections are the thread-safe version of collections. such as ConcurrentHashMap,CopyOnWriteArrayList, ConcurrentLinkedDeque.

### 17. what kind of locks you know?
1.synchronized: The most common lock in Java. When we mark a method or code block synchronized, it means only one thread can get access to the resources at a time.
2.ReentrantLock: A thread holds ReentrantLock can check the resource status multiple times. If it is occupied the thread will not wait. 
3.ReadWriteLock: Two or more threads can hold the read lock simultaneously while only one thread can hold the write lock, which, assure thread-safe and efficiency.
4.StampedLock: Just like ReadWriteLock except that StampedLock allows read and write at the same time. So it need to check if there are writing operations while reading to assure the data persistency.

### 18. What is the difference between class lock and object lock?
Class lock is used to synchronize static methods, while object lock is used to synchronize instance methods. synchronized(this) locks on the current object instance while synchronized(Singleton.class) all instances of the Singleton class.

### 19. What is future and completableFuture?
Future is an object used to receive the excecution result of the multi-thread computation.
CompletableFuture is more powerful than Future because it provides methods to manipulate results by chaining.

### 20. what is ThreadLocal?
We use ThreadLocal class to create variables that is only accessible to the thread that creates it, and the changes and operations of these variables are not visible to other threads. Thus,ThreadLocal can be used in multithreaded environment to avoid synchronization issues.

### 21. Type the code by your self and try to understand it.

### 22. Read those interview questions and pick some important questions to this homework.
1.What is the difference between t.start() and t.run() ?
2.What is the difference between Callable and Runnable?
3.What is the difference between synchronized(this) and synchronized(Singleton.class)?
4.What is thread pool? what is the advantage and how to create a thread pool?
5.What is future and competableFuture? give me the example in your experience.