2.What is the **checked exception** and **unchecked exception** in Java, could you give one example?

Exceptions are categorized into two types: checked exceptions and unchecked exceptions.

Checked exceptions are those that are checked at compile-time and must be handled using try-catch or declared using the throws keyword. If a method throws a checked exception, then the calling method must either catch that exception or declare that it throws that exception. Some common examples of checked exceptions include IOException, SQLException, and ClassNotFoundException.

Unchecked exceptions do not need to be declared or handled explicitly. Unchecked exceptions are intended to represent serious or irrecoverable errors that should be caught and fixed during development. Examples of unchecked exceptions include NullPointerException, ArrayIndexOutOfBoundsException, and IllegalArgumentException.

```java
try {
  // some code that may throw an IOException
} catch (IOException e) {
  // handle the IOException here
}
```

3.Can there be multiple finally blocks?

No

The finally block is used to execute code that should be run whether or not an exception is thrown, and it is typically used to clean up resources or release locks that were acquired in the try block. If a try block has a finally block associated with it, the finally block will always be executed regardless of whether or not an exception is thrown.

4.When both catch and finally return values, what will be the final result ?

Return value of `Finally` block. The finally block will override the catch block and the value returned from the finally block will be the final result.

5.What is **Runtime/unchecked exception** ? what is Compile/Checked Exception ?

In Java, there are two main types of exceptions: checked exceptions and unchecked exceptions (also known as runtime exceptions).

Checked exceptions are exceptions that must be declared in the method signature using the `throws` keyword, or caught and handled in a try-catch block. These exceptions are checked by the compiler at compile-time to ensure that they are properly handled. Some examples of checked exceptions include `IOException`, `SQLException`, and `ClassNotFoundException`.

Unchecked exceptions, on the other hand, do not need to be declared or caught at compile-time. They occur at runtime, and are typically caused by programming errors such as null pointer dereferences or invalid array indices. Some examples of unchecked exceptions include `NullPointerException`, `ArrayIndexOutOfBoundsException`, and `ArithmeticException`.

6.What is the difference between **throw** and **throws** ?

`throw` and `throws` are two different keywords used in Java for handling exceptions.

`throw` is used to explicitly throw an exception in the code. It is followed by an instance of an exception class or a subclass, and is used to indicate that a specific error condition has occurred. ]

`throws` is used to declare that a method may throw one or more exceptions. It is followed by a list of exception classes, and is used to indicate that a method may raise a specific type of exception. For example:

7. why do we put the Null/Runtime exception before Exception

Null/Runtime exception is placed before `Exception`, because `Exception` is the super class of all runtime exceptions. Also we should throw the specific runtime exception, not just the `Exception`. System catch the more concrete exception first.

8.Why **finally** always be executed ?

he `finally` block in Java is used to execute a block of code whether or not an exception is thrown in the `try` block. It is executed after the `try` or `catch` block is finished and it is designed to handle resource cleanup, such as closing a file or releasing a database connection, that needs to be done regardless of whether an exception occurs or not.

9.What are the types of design patterns in Java ?

There are three main types of design patterns: creational, structural, and behavioral.

Creational patterns deal with object creation mechanisms, trying to create objects in a manner suitable to the situation. Some examples of creational patterns include:

- Singleton Pattern
- Factory Pattern and Abstract Factory Pattern
- Builder Pattern
- Prototype Pattern

Structural patterns deal with object composition, i.e., how objects are composed to form larger structures. Some examples of structural patterns include:

- Adapter Pattern
- Bridge Pattern
- Composite Pattern
- Decorator Pattern

Behavioral patterns deal with communication between objects, with the focus on how objects collaborate and fulfill their respective responsibilities. Some examples of behavioral patterns include:

- Chain of Responsibility Pattern
- Command Pattern
- Interpreter Pattern
- Iterator Pattern
- Mediator Pattern
- Memento Pattern
- Observer Pattern

11.What are the **SOLID** Principles ?

1. Single Responsibility Principle (SRP): A class should have only one reason to change, i.e., it should have only one responsibility.
2. Open-Closed Principle (OCP): A class should be open for extension but closed for modification, i.e., it should be possible to add new features without modifying the existing code.
3. Liskov Substitution Principle (LSP): Objects of a superclass should be able to be replaced by objects of its subclasses without affecting the correctness of the program.
4. Interface Segregation Principle (ISP): A client should not be forced to depend on methods it does not use, i.e., interfaces should be tailored to their clients' needs.
5. Dependency Inversion Principle (DIP): High-level modules should not depend on low-level modules. Both should depend on abstractions, i.e., abstractions should not depend on details, but details should depend on abstractions.

12.How can you achieve **thread-safe singleton patterns** in Java ?

1. Eager Initialization: In this approach, the singleton instance is created at the time of class loading. Since the instance is created during class loading, it is thread-safe. However, this approach has a drawback, as the instance is created regardless of whether it is used or not.
2. Lazy Initialization with Synchronized Method: In this approach, the singleton instance is created only when the getInstance() method is called for the first time. Since the method is synchronized, it is thread-safe. However, this approach has a performance drawback, as synchronization can slow down the application.
3. Double-Checked Locking: In this approach, the singleton instance is checked twice, once without synchronization and once with synchronization. This approach allows us to avoid synchronization for subsequent calls, improving performance. However, this approach is more complex than the previous approaches and requires careful implementation.
4. Initialization-on-demand Holder (IoDH): In this approach, the singleton instance is created inside a private static nested class, which is not loaded until the getInstance() method is called. This approach ensures thread safety, while also avoiding unnecessary synchronization or complex logic.

12.What do you understand by the **Open-Closed Principle (OCP)** ?

The Open-Closed Principle (OCP) is one of the five SOLID principles of object-oriented design, which states that software entities (classes, modules, functions, etc.) should be open for extension but closed for modification. We should design our software in such a way that new functionality can be added without changing existing code. Instead of modifying existing code to accommodate new functionality, we should be able to extend the existing codebase by adding new modules or classes.

13.Sold_L

The correct answer is:

1. It means that if the object of type A can do something, the object of type B could also be able to perform the same thing.

Liskov's Substitution Principle (LSP) emphasizes that a subclass should be able to replace its parent class without causing any errors or issues. This means that any object of type A should be able to be replaced with an object of type B, without affecting the behavior of the program. In other words, if a program can work correctly with an object of type A, it should also be able to work correctly with an object of type B, since B is a subtype of A.







MYSQL And MongoDB

`MYSQL`

Create `oms_company_address` table

```sql
CREATE TABLE oms_company_address(
    id bigint AUTO_INCREMENT PRIMARY KEY,
    address_name varchar(200),
    send_status int(1),
    receive_status int(1),
    name varchar(64),
    phone varchar(64),
    province varchar(64),
    city varchar(64),
    region varchar(64),
    detail_address varchar(200)
);
```
Insert some random data to oms_company_address table

```sql
INSERT INTO oms_company_address (address_name, send_status, receive_status, name, phone, province, city, region, detail_address) VALUES ('Homepalce', 1,10, 'Chuwa', '231231241', 'dewd', 'dsf', 'nvidia3090', '1234 Water St ');
```

3.fetch all data from oms_company_address table

```sql
SELECT * FROM oms_company_address;
```

Write a SQL query to fetch top 3 records from oms_company_address table

```sql
SELECT * FROM oms_company_address LIMIT 3;
```

Update oms_company_address table to set all phone to 666-6666-8888

```sql
UPDATE oms_company_address set phone = '666-6666-8888';
```

Delete one entry from oms_company_address table

```sql
DELETE FROM oms_company_address WHERE id = <id>;
```

 `MongoDB`

Create test DB

```json
use chuwa0403
```

Create oms_company_address collection

```json
db.createCollection("oms_company_address")
```

Insert few random entries to oms_company_address collection

```json
db.oms_company_address.insertOne({
  address_name: "Homeland", 
  send_status: 1, 
  receive_status: 1, 
  name: "chuwa", 
  phone:  "12333445", 
  province: "CA", 
  city: "LA", 
  region: "Nvidia", 
  detail_address: "1234 water St"
})
```

Read one entry from oms_company_address collection

```json
db.oms_company_address.findOne({name: "chuwa"})
```

Read all entries from oms_company_address collection

```json
db.oms_company_address.find()
```

Update one entry from oms_company_address collection (method:update() or save())

```json
db.oms_company_address.update({region: "Nvidia"}, {$set: {region: "I don't know"}})
```

Remove one entry from oms_company_address collection

```json
db.oms_company_address.deleteOne({name: "chuwa"})
```