## Part 1 exception&enum&collection
### 1. Practice collection
### 2. What is the checked exception and unchecked exception in Java, could you give one example?
    1. Checked exceptions are exceptions that are checked at compile-time, meaning the compiler will require the programmer to handle or declare them in the method signature. These exceptions are typically caused by external factors beyond the control of the program, such as I/O errors, database errors, network errors, etc. Example:
    import java.sql.*;

    public class Example {
        public static void main(String[] args) {
            try {
                
                Class.forName("com.mysql.jdbc.Driver");
                Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydatabase", "username","password");
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery("SELECT * FROM mytable");
                while (rs.next()) {
                    System.out.println(rs.getString("column1") + " " + rs.getString("column2"));
                }
                rs.close();
                stmt.close();
                conn.close();
            } catch (ClassNotFoundException e) {
                System.out.println("Could not load the JDBC driver.");
                e.printStackTrace();
            } catch (SQLException e) {
                System.out.println("An error occurred while executing the query.");
                e.printStackTrace();
            }
        }
    }
    2. Unchecked exceptions are exceptions that are not checked at compile-time, meaning the compiler does not require the programmer to handle or declare them in the method signature. These exceptions are typically caused by programming errors, such as null pointer exceptions, array index out of bounds, etc. Example:
    public class Example {
        public static void main(String[] args) {
            int x = 4;
            int y = 0;
            int res = x / y;
            System.out.println(res);
        }
    }
    
### 3. Can there be multiple finally blocks?
No. finally is optional in the try-catch block. finally can only be used once with a try or try-catch block.

### 4. When both catch and finally return values, what will be the final result ?
In Java, if both catch and finally blocks return values, the value returned by the finally block will overwrite the value returned by the catch block.

### 5. What is Runtime/unchecked exception ? what is Compile/Checked Exception ?
**A checked exception**, also known as a compile-time exception, is an exception that the compiler checks at compile-time. These exceptions occur when the code is trying to do something that might cause an error. The compiler forces the programmer to handle these exceptions by either using a try-catch block or by throwing them.
* classes that extend Throwable class except RuntimeException and Error are called checked exception
* they are checked during compile time. The method must either handle the exception or it must specify the exception using the throws keyword
* FileNotFoundException, IOException, SQLException

**An unchecked exception**, also known as a runtime exception, is an exception that occurs at runtime, i.e., during the execution of the program. These exceptions occur due to logical errors in the program, such as dividing by zero or trying to access an array index that does not exist. Unchecked exceptions do not need to be handled explicitly, and if not handled, they will result in a runtime error.
* Classes that extend RuntimeException and Error are unchecked exception
* They happen during runtime and don’t have to be handled
* ArithmeticException, NullPointerException, ArrayIndexOutOfBoundsException

### 6. What is the difference between throw and throws ?
throw is used to explicitly throw an exception from a block of code. When you encounter an error or an exceptional condition, you can use the throw keyword to throw an exception object. throws is used to declare that a method may throw an exception. It is used in the method signature to specify that a method might throw one or more exceptions.

### 7. Run the below three pieces codes, Noticed the printed exceptions. why do we put the Null/Runtime exception before Exception ?
```
//code
```
NullPointerException and RuntimeException are unchecked exceptions, which means they do not need to be declared in the method signature, and they are commonly encountered in Java programs. Therefore, it is a good practice to handle them first before handling other exceptions. If you catch Exception first, then any NullPointerException or RuntimeException that occurs will also be caught, and this program may not behave as expected. We put the Null/Runtime exception before Exception, because Exception is the super class of all runtime exceptions. And we want to throw the specific runtime exception, not just the Exception. We always catch the narrow exception first.

### 8. Why finally always be executed ?
Make sure to execute some important code like closing the file and free the resources. Ensure the entire try-catch-finally block is completed, and cleanup or resource release is executed.
1. Exception handling: When an exception is thrown in a try block, the corresponding catch block is executed (if it exists), followed by the finally block. This ensures that any cleanup code in the finally block is executed, even if an exception is thrown.
2. Resource management: The finally block is often used for resource management, such as closing a file or releasing a network connection. By putting the cleanup code in the finally block, you can ensure that the resources are released even if an exception occurs.
3. Control flow: The finally block is executed regardless of how the try block exits. This ensures that any cleanup code in the finally block is executed, even if the method exits early.
4. Program integrity: The finally block is an important part of ensuring the integrity of a program. By executing the cleanup code in the finally block, you can prevent resource leaks, ensure that data is saved correctly, and prevent other issues that may arise if the program is terminated unexpectedly.

### 9. What are the types of design patterns in Java ?
1. Creational Patterns: Singleton Pattern, Factory Pattern, Abstract Factory Pattern, Builder Pattern, Prototype Pattern
2. Structural Patterns: Adapter Pattern, Bridge Pattern, Composite Pattern, Decorator Pattern, Proxy Pattern, Facade Pattern, Flyweight Pattern
3. Behavioral Patterns: Chain of Responsibility Pattern, Command Pattern, Interpreter Pattern, Iterator Pattern,Mediator Pattern, Memento Pattern, Observer Pattern, State Pattern, Strategy Pattern, Template Method Pattern, Visitor Pattern

### 10. What are the SOLID Principles ?
SOLID is an acronym that represents a set of five design principles for object-oriented programming.

1. Single Responsibility Principle (SRP): This principle states that a class should have only one reason to change, meaning that it should have only one responsibility. If a class has multiple responsibilities, it becomes harder to maintain and modify.
2. Open/Closed Principle (OCP): This principle states that a class should be open for extension but closed for modification. This means that we should be able to add new functionality to a class without changing its existing code.
3. Liskov Substitution Principle (LSP): This principle states that derived classes should be substitutable for their base classes without affecting the correctness of the program. In other words, any instance of a base class should be replaceable with an instance of a derived class without causing any unexpected behavior.
4. Interface Segregation Principle (ISP): This principle states that a client should not be forced to depend on methods it does not use. In other words, it's better to have many small interfaces that are focused on specific tasks rather than one large interface that does everything.
5. Dependency Inversion Principle (DIP): This principle states that high-level modules should not depend on low-level modules, but both should depend on abstractions. In other words, we should depend on abstractions, not on concrete implementations. This makes our code more flexible and easier to maintain.

### 11. How can you achieve thread-safe singleton patterns in Java ?
1. Eager initialization with static final variable:
```
public class Singleton {
    private static final Singleton INSTANCE = new Singleton();
    
    private Singleton() {}
    
    public static Singleton getInstance() {
        return INSTANCE;
    }
}
```
2. Lazy initialization with synchronized method:
```
public class Singleton {
    private static Singleton INSTANCE;
    
    private Singleton() {}
    
    public static synchronized Singleton getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new Singleton();
        }
        return INSTANCE;
    }
}
```
3. Lazy initialization with double-checked locking:
```
public class Singleton {
    private static volatile Singleton INSTANCE;
    
    private Singleton() {}
    
    public static Singleton getInstance() {
        if (INSTANCE == null) {
            synchronized (Singleton.class) {
                if (INSTANCE == null) {
                    INSTANCE = new Singleton();
                }
            }
        }
        return INSTANCE;
    }
}
```

### 12. What do you understand by the Open-Closed Principle (OCP) ?
The Open-Closed Principle (OCP) is a design principle that states that software entities (classes, modules, functions, etc.) should be open for extension but closed for modification. The OCP encourages the use of abstraction and polymorphism to achieve this. OCP can reduce risk of introducing bugs and errors, improve scalability and maintainability and improve code reuse.

### 13. what do you understand by the iskov Substitution Principle?
The Liskov Substitution Principle (LSP) is a fundamental principle in object-oriented design that states that if a program is using a base class (or interface), then the program should be able to use any of its derived classes (or implementations of the interface) without knowing it, and without the program's correctness being affected. The LSP is closely related to the concept of inheritance, and helps ensure that classes that inherit from a base class or interface do not violate the expected behavior of the base class or interface.If a program is using a base class, it should be able to use any of its derived classes without knowing it. This means that a subclass should not change the behavior or contract of its base class. It should only add new behaviors or override existing ones. Liskov's substitution principle is violated if : Pre-conditions are strengthened, or Post-conditions are weakened.

### 14. (SOLID-L)Liskov’s substitution principle states that if class B is a subtype of class A, then object of type A may be substituted with any object of type B. What does this actually mean? (from OA ) choose your answer.
    1. It mean that if the object of type A can do something, the object of type B could also be able to perform the same thing
    2. It means that all the objects of type A could execute all the methods present in its subtype B
    3. It means if a method is present in class A, it should also be present in class B so that the object of type B could substitute object of type A.
    4. It means that for the class B to inherit class A, objects of type B and objects of type A must be same.

1

### 15. Watch the design pattern video, and type the code, submit it to MavenProject folder
    singleton: https://www.bilibili.com/video/BV1Np4y1z7BU?p=22
    Factory: https://www.bilibili.com/video/BV1Np4y1z7BU?p=35&vd_source=310561eab1216a27f7accf859bf7f6d9
    Builder: https://www.bilibili.com/video/BV1Np4y1z7BU?p=50&vd_source=310561eab1216a27f7accf859bf7f6d9
    Publisher_Subscriber: https://www.bilibili.com/video/BV1Np4y1z7BU?p=114&vd_source=310561eab1216a27f7accf859bf7f6d9

### 16. CRUD MySQL and MongoDB (separated PDF)
MySQL:
1. Create oms_company_address table
```
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
)
```
2. Insert some random data to oms_company_address table
```
INSERT INTO oms_company_address (id, address_name, send_status, receive_status, name, phone, province, city, region, detail_address) VALUES 
(1, 'Home', 0, 1, 'Alice', '00000000', 'MA', 'BOS', 'BOS', 'xxxxxx'),
(1, 'School', 1, 1, 'Bob', '11111111', 'MA', 'BOS', 'BOS', 'yyyyyy'),
```

3. Write a SQL query to fetch all data from oms_company_address table
```
SELECT * FROM oms_company_address;
```

4. Write a SQL query to fetch top 3 records from oms_company_address table
```
SELECT * FROM oms_company_address LIMIT 3;
```

5. Update oms_company_address table to set all phone to 666-6666-8888
```
UPDATE oms_company_address SET phone = '666-6666-8888';
```

6. Delete one entry from oms_company_address table
```
DELETE FROM oms_company_address WHERE id = 1;
```

MongoDB:
1. Create test DB
```
use test
```

2. Create oms_company_address collection (method: createCollection())
```
db.createCollection("oms_company_address")
```

3. Insert few random entries to oms_company_address collection (method: insert())
```
db.oms_company_address.insertMany([
{ address_name: "Home", send_status: 1, receive_status: 0, name: "Alice", phone: "00000000", province: "MA", city: "BOS", region: "BOS", detail_address: "xxxxxx"},
{ address_name: "School", send_status: 1, receive_status: 1, name: "Bob", phone: "11111111", province: "MA", city: "BOS", region: "BOS", detail_address: "yyyyyy"}
])
```

4. Read one entry from oms_company_address collection (method: find())
```
db.oms_company_address.findOne({ name: "Alice" })
```

5. Read all entries from oms_company_address collection (method: find())
```
db.oms_company_address.find()
```

6. Update one entry from oms_company_address collection (method: update() or save())
```
db.oms_company_address.update({ name: "Alice" }, { $set: { name: "Anna" }})
```

7. Remove one entry from oms_company_address collection (method: remove() )
```
db.oms_company_address.remove({ name: "Anna" })
```


## Part 2 design-pattern
### 7. Watch the design pattern video, and type the code, submit it to code questions folder
    1. singleton: https://www.bilibili.com/video/BV1Np4y1z7BU?p=22
    2. Factory: https://www.bilibili.com/video/BV1Np4y1z7BU?p=35&vd_source=310561eab1216a27f7accf8
59bf7f6d9
    3. Builder: https://www.bilibili.com/video/BV1Np4y1z7BU?p=50&vd_source=310561eab1216a27f7accf8
59bf7f6d9
    4. Publisher_Subscriber: https://www.bilibili.com/video/BV1Np4y1z7BU?p=114&vd_source=310561eab1
216a27f7accf859bf7f6d9


## Part 3 design
Problem :
Creadit Card Notification.
We need to send notification to users by notification preference like email/SMS etc,handle error appropriately when preference given does not match.Write simple java program using design patterns , program to interface & Error handling concepts to come up with solve for above problem.
* Notification type: email/SMS/WhatsAPP
* Call notification module to send notification
* Integrate with notification module to notify depending on preference.
    * if A prefer EMAIL, then we notify A by EMAIL
* Pass user details and other data points to send email
    * Notificaiton content :
        * Hey firstName, you have successfully registered to add and here is your , please use this for future references.
* Broadcast public notification to all users
    * 40% off when you buy Popeyes between 06/13 - 06/19