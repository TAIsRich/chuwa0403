## 1. Practice collection
Please see Coding/hw3/collection

## 2. What is the checked exception and unchecked exception in Java, could you give one example?
- **Checked exceptions** are exceptions that the Java compiler requires to be either handled or declared in the method signature. These are usually exceptions that can be anticipated and handled by the program, such as file I/O 
  Exception or network connectivity issues. Examples of checked exceptions include `IOException` and `SQLException`.

- **Unchecked exceptions** are exceptions that do not need to be explicitly handled or declared in the method 
  signature. These are usually **runtime** exceptions that are not always easy to anticipate, such as 
  `NullPointerException` or `ArrayIndexOutOfBoundsException`.
## 3. Can there be multiple finally blocks?
No, there can only be one finally block.

## 4. When both catch and finally return values, what will be the final result ?
In Java, when both catch and finally blocks return values, the value returned by the finally block will be the final result. The finally block is always executed, regardless of whether an exception is thrown or caught, and its return value takes precedence over the return value of any catch block. If a finally block returns a value, it will overwrite any return value from the try or catch block.

## 5. What is Runtime/unchecked exception ? what is Compile/Checked Exception?
- **Runtime/Unchecked Exceptions**: These exceptions occur at runtime and are not checked by the compiler during 
compilation. As a result, they can go unnoticed until the code is actually executed. Examples of runtime exceptions 
  include `NullPointerException`, `ArrayIndexOutOfBoundsException`, `ArithmeticException`, and
  `IllegalArgumentException`.

- **Compile/Checked Exceptions**: These exceptions are checked by the compiler during compilation and are required to be either handled using try-catch blocks or declared in the method signature using the throws keyword. Examples of checked exceptions include `IOException`, `SQLException`, `ClassNotFoundException`, and `InterruptedException`.

## 6. What is the difference between throw and throws?
`throw` is used to explicitly throw an exception in the code, while `throws` is used in the method signature to declare the exceptions that can be thrown by the method.
## 7. Run the below three pieces codes, Noticed the printed exceptions. why do we put the Null/Runtime exception before Exception ?
If we put the `Exception` catch block before the `RuntimeException` catch block, then the `Exception` block will catch all exceptions, including the `RuntimeException` exceptions, before they are caught by the `RuntimeException` block. This means that any `RuntimeException` exceptions will never be caught by the `RuntimeException` block, which defeats the purpose of having a separate catch block for it.

## 8. Why finally always be executed?
Because the `finally` block is used to perform cleanup operations, such as closing files or releasing resources, that should always be executed regardless of any exceptions that may have occurred in the try block.

## 9. What are the types of design patterns in Java ?
1. Creational Patterns: These patterns are used to create objects in a way that is suitable for a particular 
   situation. Examples of creational patterns include Singleton, Factory Method, Abstract Factory, Builder, and Prototype.

2. Structural Patterns: These patterns are used to deal with the composition of classes and objects to form larger 
structures. Examples of structural patterns include Adapter, Bridge, Composite, Decorator, Facade, Flyweight, and Proxy.

3. Behavioral Patterns: These patterns are used to manage the behavior of objects and their interactions. Examples of 
behavioral patterns include Chain of Responsibility, Command, Interpreter, Iterator, Mediator, Memento, Observer, State, Strategy, Template Method, and Visitor.
## 10. What are the SOLID Principles ?
1. Single Responsibility Principle (SRP): A class should have only one reason to change. This means that a class should have only one responsibility or job to perform.

2. Open-Closed Principle (OCP): Software entities (classes, modules, functions, etc.) should be open for extension, but closed for modification. This means that you should be able to extend the behavior of a class without modifying its code.

3. Liskov Substitution Principle (LSP): Subtypes must be substitutable for their base types. This means that you should be able to use an object of a subclass wherever an object of its superclass is expected.

4. Interface Segregation Principle (ISP): Clients should not be forced to depend on methods they do not use. This means that interfaces should be fine-grained and specific to the needs of the clients that use them.

5. Dependency Inversion Principle (DIP): High-level modules should not depend on low-level modules. Both should depend on abstractions. Abstractions should not depend on details. Details should depend on abstractions. This means that classes should depend on interfaces, not on concrete implementations.

## 11. How can you achieve thread-safe singleton patterns in Java ?
1. Eager Initialization: In this approach, the instance of the Singleton class is created at the time of class loading. It guarantees thread safety, but it can result in unnecessary instance creation if the Singleton class is not used in the application.
```
    public class Singleton {
        private static Singleton instance = new Singleton();
    
        private Singleton() {}
    
        public static Singleton getInstance() {
            return instance;
        }
    }
```

2. Lazy Initialization with Synchronized Method: In this approach, the instance of the Singleton class is created when it is requested for the first time. It uses a synchronized method to ensure thread safety, but it can result in performance issues due to the synchronization overhead.
```
public class Singleton {
    private static Singleton instance;

    private Singleton() {}

    public static synchronized Singleton getInstance() {
        if (instance == null) {
            instance = new Singleton();
        }
        return instance;
    }
}

```
3. Lazy Initialization with Double-Checked Locking: In this approach, the instance of the Singleton class is created when it is requested for the first time, but it uses a double-checked locking mechanism to minimize the synchronization overhead. It is more efficient than the previous approach, but it requires careful implementation to ensure correctness.
```
public class Singleton {
    private static volatile Singleton instance;

    private Singleton() {}

    public static Singleton getInstance() {
        if (instance == null) {
            synchronized (Singleton.class) {
                if (instance == null) {
                    instance = new Singleton();
                }
            }
        }
        return instance;
    }
}

```
4. Initialization-on-demand with Holder class: In this approach, the instance of the Singleton class is created when it is requested for the first time, but it uses a static inner class to ensure thread safety and lazy initialization. It is the most efficient and recommended approach.
```
public class Singleton {
    private Singleton() {}

    private static class SingletonHolder {
        private static final Singleton INSTANCE = new Singleton();
    }

    public static Singleton getInstance() {
        return SingletonHolder.INSTANCE;
    }
}

```
## 12. What do you understand by the Open-Closed Principle (OCP) ?
This means that the behavior of a software entity should be easily extended without modifying its source code. In other words, the software entity should be designed in such a way that new behavior can be added by writing new code that interacts with the existing code, rather than modifying the existing code directly.

## 13. (SOLID-L)Liskov’s substitution principle states that if class B is a subtype of class A, then object of type A may be substituted with any object of type B. What does this actually mean? (from OA ) choose your answer.
1. It means that if the object of type A can do something, the object of type B could also be able to perform the 
   same thing

## 14. Watch the design pattern video, and type the code, submit it to MavenProject folder
Please check MavenProject/DesignPattern.

## 15. CRUD MySQL
```
    -- Create oms_company_address table
    CREATE SCHEMA `oms` DEFAULT CHARACTER SET utf8;
    
    USE `oms`;
    
    -- Create oms_company_address table:
    CREATE TABLE oms_company_address (
        id BIGINT PRIMARY KEY AUTO_INCREMENT,
        address_name VARCHAR(200),
        send_status INT(1),
        receive_status INT(1),
        name VARCHAR(64),
        phone VARCHAR(64),
        province VARCHAR(64),
        city VARCHAR(64),
        region VARCHAR(64),
        detail_address VARCHAR(200)
    );
    
    -- Insert some random data to oms_company_address table:
    INSERT INTO oms_company_address (address_name, send_status, receive_status, name, phone, province, city, region, detail_address) 
    VALUES 
    ('Home', 1, 0, 'John', '555-5555-5555', 'CA', 'Los Angeles', 'US', '1234 Wwood Ave'),
    ('Office', 0, 1, 'Jane', '444-4444-4444', 'NY', 'Manhattan', 'US', '5678 5th Ave'),
    ('Warehouse', 1, 1, 'Bob', '333-3333-3333', 'TX', 'Houston', 'US', '9101 Main St'),
    ('School', 1, 1, 'Tim', '333-3333-3333', 'WA', 'Seattle', 'US', '3333 Main St');
    
    -- Write a SQL query to fetch all data from oms_company_address table:
    SELECT * FROM oms_company_address;
    
    -- Write a SQL query to fetch top 3 records from oms_company_address table:
    SELECT * FROM oms_company_address LIMIT 3;
    
    -- Update oms_company_address table to set all phone to 666-6666-8888:
    UPDATE oms_company_address SET phone = '666-6666-8888';
    
    -- Delete one entry from oms_company_address table:
    DELETE FROM oms_company_address WHERE id = 2;
```

## 16. CRUD MongoDB
```
# Create test DB
use test

# Create oms_company_address collection (method: createCollection() )
db.createCollection("oms_company_address")

# Insert few random entries to oms_company_address collection (method: insert() )
db.oms_company_address.insertOne({
   address_name: "Home",
   send_status: 1,
   receive_status: 1,
   name: "John Doe",
   phone: "123-456-7890",
   province: "Ontario",
   city: "Toronto",
   region: "North York",
   detail_address: "123 Main Street"
})

# Read one entry from oms_company_address collection (method: find() )
db.oms_company_address.findOne({ address_name: "Home" })

# Read all entries from oms_company_address collection (method: find() )
db.oms_company_address.find()

# Update one entry from oms_company_address collection (method: update() or save() )
db.oms_company_address.updateOne(
   { { address_name: "Home" } },
   { $set: { phone: "666-6666-8888" } }
)

# Remove one entry from oms_company_address collection (method: remove() )
db.oms_company_address.deleteOne({ { address_name: "Home" } })
```