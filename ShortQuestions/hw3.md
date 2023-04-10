Q2  
Checked exceptions are checked at compile time and must be handled using the try-catch block or by adding a throws clause in the method signature. These exceptions are typically caused by external factors beyond the control of the programmer and are expected to occur occasionally. Examples of checked exceptions include IOException, SQLException, and ClassNotFoundException.

Here's an example of how to handle a checked exception:
```java
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class FileReaderExample {
    public static void main(String[] args) {
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader("input.txt"));
            String line = reader.readLine();
            while (line != null) {
                System.out.println(line);
                line = reader.readLine();
            }
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        } finally {
            try {
                if (reader != null) {
                    reader.close();
                }
            } catch (IOException e) {
                System.err.println("Error closing file: " + e.getMessage());
            }
        }
    }
}
```

On the other hand, unchecked exceptions are not checked at compile time and do not have to be handled explicitly. These exceptions are usually caused by programming errors such as null pointers, array out of bounds, or division by zero. Examples of unchecked exceptions include NullPointerException, ArrayIndexOutOfBoundsException, and ArithmeticException.

Here's an example of an unchecked exception:
```java
public class DivideByZeroExample {
    public static void main(String[] args) {
        int a = 10;
        int b = 0;
        int result = a / b; // This will throw an ArithmeticException
    }
}
```

Q3  
No

Q4  
Finally will be the final result.

Q5  
See Q2

Q6  
throw is used to throw an exception explicitly, while throws is used to declare that a method may throw an exception.

Q7  
Because they are subtypes of Exception

Q7  
Because it is meant to contain code that must be executed regardless of whether an exception is thrown or not.

Q8  
Creational Patterns: These patterns are used to create objects in a systematic and controlled way. Some examples are Singleton, Factory Method, Abstract Factory, Builder, and Prototype patterns.

Structural Patterns: These patterns are used to create relationships between classes and objects to form larger structures. Some examples are Adapter, Bridge, Composite, Decorator, Facade, Flyweight, and Proxy patterns.

Behavioral Patterns: These patterns are used to manage the interactions between objects and the control flow of an application. Some examples are Chain of Responsibility, Command, Interpreter, Iterator, Mediator, Memento, Observer, State, Strategy, Template Method, and Visitor patterns.

Concurrency Patterns: These patterns are used to solve problems related to multi-threading and synchronization. Some examples are Thread-Specific Storage, Double-Checked Locking, and Immutable Object patterns.

J2EE Patterns: These patterns are specifically designed to solve problems related to enterprise application development using J2EE technologies. Some examples are Model-View-Controller, Business Delegate, Service Locator, and Data Access Object patterns.

Q9  
S - Single Responsibility Principle  
O - Open-Closed Principle  
L - Liskov Substitution Principle  
I - Interface Segregation Principle  
D - Dependency Inversion Principle  

Q10  
Eager Initialization: In this approach, the singleton instance is created at the time of class loading. This approach is thread-safe because the JVM guarantees that only one instance of a class will be created at the time of class loading.
```java
public class MySingleton {
   private static final MySingleton instance = new MySingleton();
   private MySingleton() {}

   public static MySingleton getInstance() {
      return instance;
   }
}
```
Lazy Initialization with Double-Checked Locking: In this approach, the singleton instance is created lazily when the getInstance() method is called for the first time. This approach is thread-safe because it uses double-checked locking to ensure that only one instance is created even when multiple threads are accessing the singleton object simultaneously.
```java
public class MySingleton {
   private volatile static MySingleton instance;

   private MySingleton() {}

   public static MySingleton getInstance() {
      if (instance == null) {
         synchronized (MySingleton.class) {
            if (instance == null) {
               instance = new MySingleton();
            }
         }
      }
      return instance;
   }
}
```

Q11  
The Open-Closed Principle (OCP) is one of the SOLID principles of object-oriented programming, which states that software entities (classes, modules, functions, etc.) should be open for extension but closed for modification.

Q12  
1

Q14  
MySQL
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
MongoDB
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
