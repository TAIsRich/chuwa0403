# Big Homework
## Maven
### 1.  What is the lifecycle of maven? could you tell me the details ?
validate, compile, test, package, verify, install, deploy.
validate check the project structure and configuration.
compile compiles the source code to class file
test run unit test
package packages the code to jar file
verfiy use integration test for verifing the code.
install installs the jar file to local maven repository;
deploy deploys the jar file to remote maven repository;

### 2. what is the difference between package and install in maven lifecycle ?
package turns the code to jar files; install will put the jar file to local repository.

## Linux

## Java
### 1. Write up Example code to demonstrate the three foundmental concepts of OOP. 
```
class A extends Object{ // inheritance 
    private int i; // encapsulation

    public int geti() {return i;}
    public void seti(int i_) {this.i = i_;}

    public int geti(int a) {return i + a;} // overload 

    @Override
    public String toString() {return "";} // override
}
```

### 2. What is Java garbage collection?
Java garbage collection is JVM will automatically remove the unused reference (not refered objects).

### 3. What is Runtime/unchecked exception? what is Compile/Checked Exception?
Runtime exception can't be found by compilers but may occur during code running. NullPointerException.

Compile exception can be found by compiler during the compile time. These exceptions related to external factors that may occur at runtime and must be handled by programmers using try catch blocks or throws. ClassNotFound Exception.

### 4. What is the difference between throw and throws?
Throw is to throw an exception by programmer in code on purpose.

Throws is declared in the method signature, representing this function may or may not throw an exception and it should be catch by caller function. 

### 5. Could you give me one example of NullPointerException?
There is no "key" key in hashmap A and you try to get value of "key" from A.

### 6. how does Java hashmap internally work?
HashMap is composed of Array and LinkedList. The index of the array is hashcode and the array stores the LinkedList. Each item in the linkedlist is a node. A node is composed of a key value pair. The node with the same hashvalue will be added to the same index of the array. If the number of the linkedlist reached over 8. It will automatically changed itself to a reb-black tree. The final hashcode is -> (hashcode) & (length - 1) (length - 1) is the mask.

The hashmap has an initial size and load factor. If the number of nodes in hashmap reach size * factor. It will automatically renew its size. Usually the size will be chosen as the factor of 2. Size renew will occur the hashcode changing problem. In jdk1.8, no need to recalculate. Instead, everytime the renew process will add a new bit 1 to the mask. Use the new mask to & with the previous hashcode. if the new added bit of the previous code is 0, the hashcode remains the same, else new hashcode is previous hashcode add old size.

## Java 8
1. Optional: used to simply if else code block, handle potential nullable value in a new manner. Provide functions like map, orElse, oreELseThrow to handle different situations;

2. Stream API: can be used to handle chaining operations on a collection or an array. Provide efficient and parallel  of processing data. Provide middle process and termination process.

3. CompleteableFuture: it is used to provide asynchronous. It will generate a new thread from main thread and will not block the main thread for waiting for result. A completable future is a subclass of Future. Compare to Future, it provide call back function and can perform futire actions on it, handle exceptions, can combine multiple futures.

4. Functional interface: Funtional interface is an interface with only one abstarct function to be implemented. It can be created using lambda expression. 

## Multiple Threading
### 1. What is deadlock?
Each thread hold one resource while waiting for another resource but can never get.

### 2. how to create a new thread(Please also consider Thread Pool case)?
Extends Thread. Override run method.

Implements Runnable and implenent run;

Implements Callable and implement call;

```
// 创建固定大小的线程池:
ExecutorService executor = Executors.newFixedThreadPool(4);
// 提交任务:
executor.submit(task1);
executor.submit(task2);
executor.submit(task3);
executor.submit(task4);
executor.submit(task5);
```

### 3. What is the difference between t.start() and t.run()?
t.run() execute the task in current thread; t.start() starts a new thread and execute run();

### 4. What is the differecence between Callable and Runnbale?
runnable doesn't have return values, callable do.

### 5. 
