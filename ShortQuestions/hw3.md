# Q2
An exception is a runtime error that occurs during the execution of a program. Java has two types of exceptions: checked exceptions and unchecked exceptions.

A checked exception is a type of exception that the Java compiler requires the programmer to handle explicitly using try-catch blocks or by declaring the exception in the method signature using the "throws" keyword. Examples of checked exceptions include IOException, SQLException, and ClassNotFoundException.

An unchecked exception, on the other hand, is a type of exception that doesn't require the programmer to handle explicitly. Unchecked exceptions are usually caused by programming errors such as accessing a null reference or dividing by zero. Examples of unchecked exceptions include NullPointerException, ArrayIndexOutOfBoundsException, and ArithmeticException.

# Q3

No, in Java, a try block can have at most one finally block associated with it. The finally block is used to execute code that needs to be run regardless of whether an exception was thrown or not.

# Q4

If both the catch block and finally block contain return statements, the finally block's return statement will override the catch block's return statement, and the value returned will be the one specified in the finally block


# Q5

Exceptions are categorized into two types based on when they are detected by the Java compiler: runtime/unchecked exceptions and compile/checked exceptions.

A runtime/unchecked exception is an exception that occurs at runtime, during the execution of a Java program. These exceptions are not checked by the Java compiler at compile-time, which means the compiler doesn't force the programmer to handle them using try-catch blocks or by declaring them in the method signature using the "throws" keyword. Examples of unchecked exceptions include NullPointerException, ArrayIndexOutOfBoundsException, and ArithmeticException.

A compile/checked exception is an exception that occurs at compile-time. These exceptions are checked by the Java compiler at compile-time, which means the compiler forces the programmer to handle them using try-catch blocks or by declaring them in the method signature using the "throws" keyword. Examples of checked exceptions include IOException, SQLException, and ClassNotFoundException.

The main difference between checked and unchecked exceptions is that checked exceptions must be handled or declared in the method signature, while unchecked exceptions don't need to be handled or declared. This means that if a method throws a checked exception, any code that calls that method must handle the exception or declare it in its own method signature, or else the program will not compile. On the other hand, if a method throws an unchecked exception, it's up to the programmer whether or not to handle it.

# Q6

throw is used to manually throw an exception. It is used within a method to indicate that something unexpected has occurred and to terminate the normal flow of the program. When throw is used, the program stops executing the current method and jumps to the nearest catch block to handle the exception.

throws is used to declare that a method may throw one or more exceptions. When a method declares that it throws an exception using the throws keyword, it means that it's possible for the method to throw an exception of that type, and that the calling method or the JVM must handle the exception.

# Q7
If a NullPointerException or a RuntimeException is thrown, it will be caught by their respective catch blocks, even if there is a more generic Exception catch block defined later in the code. If the Exception catch block was defined before the NullPointerException or RuntimeException catch blocks, the Exception catch block would catch the exceptions instead of the more specific catch blocks, which may not handle the exception properly.


# Q8
The finally block in Java is used to contain code that should be executed regardless of whether an exception is thrown or not. This means that the code inside a finally block will always be executed, even if an exception is thrown and caught by a preceding catch block.

# Q9
Design patterns are reusable solutions to common software design problems. In Java, there are several types of design patterns.
ex: Creational Patterns, Structural Patterns, Behavioral Patterns, Concurrency Patterns

# Q10
The SOLID principles are a set of five principles for software design that were introduced by Robert C. Martin (also known as Uncle Bob). The acronym SOLID stands for:

Single Responsibility Principle (SRP): A class should have only one reason to change, meaning that it should have only one responsibility.

Open-Closed Principle (OCP): Software entities (classes, modules, functions, etc.) should be open for extension, but closed for modification. This means that you should be able to add new features to a system without changing its existing code.

Liskov Substitution Principle (LSP): Subtypes should be substitutable for their base types, meaning that objects of a superclass should be able to be replaced with objects of a subclass without affecting the correctness of the program.

Interface Segregation Principle (ISP): Clients should not be forced to depend on interfaces that they do not use. This means that interfaces should be specific to the needs of their clients.

Dependency Inversion Principle (DIP): High-level modules should not depend on low-level modules. Both should depend on abstractions. Abstractions should not depend on details. Details should depend on abstractions.

# Q11
there are several ways to achieve a thread-safe Singleton pattern:

Eager initialization: This approach involves creating the Singleton instance at the time of class loading. The instance is created once and used every time the Singleton is requested. This approach is thread-safe by default.

Lazy initialization with synchronized method: This approach involves creating the Singleton instance when it is first requested. The instance is created inside a synchronized block to ensure that only one thread can create the instance. This approach can cause performance issues if the getInstance() method is called frequently.

# Q12
The Open-Closed Principle (OCP) is one of the SOLID principles of object-oriented design. It states that software entities (classes, modules, functions, etc.) should be open for extension but closed for modification. This means that new functionality should be added to the system by adding new code rather than changing the existing code.

In other words, the behavior of a module or class should be able to be extended without modifying its source code. This can be achieved through the use of interfaces, abstract classes, and polymorphism. By designing software with the OCP in mind, it becomes easier to maintain and evolve over time since changes to existing code are minimized. Additionally, OCP helps to promote better code organization and modularity, making it easier to test and reuse code.

# Q13
The correct answer is:

1. It means that if the object of type A can do something, the object of type B could also be able to perform the same thing.

Liskov’s Substitution Principle (LSP) is a fundamental principle of object-oriented design that helps ensure that inheritance hierarchies are well-formed and that subclasses can be used in place of their superclasses without introducing bugs or unexpected behavior. This principle ensures that subtypes (i.e. subclasses) do not violate the behavioral contracts of the supertypes (i.e. superclasses) they inherit from.

In simpler terms, LSP states that a subclass should be able to replace its superclass without changing the correctness of the program. This means that if an object of type A can do something, then an object of type B (which is a subtype of A) should be able to do that same thing without causing any issues or breaking the program.


# Q14
### 1 MySQL
```genericsql
CREATE TABLE oms_company_address (
id bigint, 
address_name varchar(200),
send_status int,
receive_status int,
name varchar(64),
phone varchar(64),
province varchar(64),
city varchar(64),
region varchar(64),
detail_address varchar(200), 
primary key(id)
);

INSERT INTO oms_company_address
(id, address_name, send_status, receive_status, name, phone, province, city, region, detail_address)
VALUES
('1','Home', 1, 0, 'John Doe', '123456789', 'Ontario', 'Toronto', 'North York', '123 Main St.'),
('2','Office', 0, 1, 'Jane Doe', '987654321', 'British Columbia', 'Vancouver', 'Richmond', '456 Market St.'),
('3','Factory', 1, 1, 'Bob Smith', '55555555', 'Quebec', 'Montreal', 'Laval', '789 Industrial Rd.');

SELECT * FROM oms_company_address;

SELECT * FROM oms_company_address LIMIT 3;

UPDATE oms_company_address SET phone = '666-6666-8888';

DELETE FROM oms_company_address WHERE id = 1;
```
# 2 MongoDB - Non-SQL
```genericsql
use testDB

db.createCollection("oms_company_address")

db.oms_company_address.insertMany([
   { address_name: "address1", send_status: 1, receive_status: 0, name: "John Doe", phone: "555-1234", province: "Ontario", city: "Toronto", region: "Downtown", detail_address: "123 Main St" },
   { address_name: "address2", send_status: 0, receive_status: 1, name: "Jane Smith", phone: "555-5678", province: "Ontario", city: "Ottawa", region: "Downtown", detail_address: "456 Queen St" },
   { address_name: "address3", send_status: 1, receive_status: 1, name: "Bob Johnson", phone: "555-9876", province: "Quebec", city: "Montreal", region: "West Island", detail_address: "789 Lakeshore Blvd" }
])

db.oms_company_address.findOne({ address_name: "address1" })

db.oms_company_address.find()
    
db.oms_company_address.update({ address_name: "address2" }, { $set: { phone: "555-4321" }})

db.oms_company_address.deleteOne({ address_name: "address3" })
```


















































