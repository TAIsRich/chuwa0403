### Homework 3
## 1. Practice collection
## 2. What is the checked exception and unchecked exception in Java, could you give one example?
Checked exception is the one that can be detected during compile time. If some code throws an exception, then the method must either handle the exception or throws the exception. IOException.

Unchecked exception, also called runtime exception, can be thrown during the normal operation of the Java Virtual Machine. ArrayOutOfBoundException.

## 3. Can there be multiple finally blocks?
No. One finally block follows one catch block.

## 4. When both catch and finally return values, what will be the final result?
Finally block.

## 5. What is Runtime/unchecked exception ? what is Compile/Checked Exception ?
* Runtime exception is the superclass that can be thrown during the normal operation of the JVM.
* Checked exceptions are the ones that are checked during compilation time. If a code within a method throws a checked exception, then it should either be handled by a method or specify it using the throws keyword.

## 6. What is the difference between throw and throws ?
Throw is used in methods to throw exceptions explicitly.

Throws is used at the method signature to declare an exception that might be thrown by the function while executing.

## 7. why do we put the Null/Runtime exception before Exception ?
