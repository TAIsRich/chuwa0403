# HW3 - hw21 exception&enum&collection
## 1. Practice collection
see coding/collection

## 2. What is the checked exception and unchecked exception in Java, could you give one example?
Checked exception:
- classes that extend `Throwable` class except `RuntimeException` and `Error` are called checked exception
- they are checked during compile time. The method must either handle the exception or it must specify the exception using the `throws` keyword
- `FileNotFoundException`, `IOException`, `SQLException`   

Unchecked exception:
- Classes that extend `RuntimeException` and `Error` are unchecked exception
- They happen during runtime and don’t have to be handled
- `ArithmeticException`, `NullPointerException`, `ArrayIndexOutOfBoundsException`


## 3. Can there be multiple finally blocks?
- We can have only 0 or 1 `finally` block per `try/catch/finally` statement, but we are allowed to have multiple such statements  
- We can have 0 or more `catch` block, but if we have 0 `catch` block then we must have a `finally` block  
- No matter the exception is caught/handled or not, the code in the `finally` block will always be executed
- When there is a `return` clause in the catch block, the code in the `finally` block will be executed first before executing the `return` clause in the `catch` block  
[Useful link](https://blog.csdn.net/fitaotao/article/details/115866269)

## 4. When both catch and finally return values, what will be the final result ?
The `finally` block will always execute, even if the `catch` block has a `return` statement.  
If both `catch` and `finally` return, the receiving method will get the returned value from the `finally` block.


## 5. What is Runtime/unchecked exception ? what is Compile/Checked Exception ?
Checked exception:
- classes that extend `Throwable` class except `RuntimeException` and `Error` are called checked exception
- they are checked during compile time. The method must either handle the exception or it must specify the exception using the `throws` keyword
- `FileNotFoundException`, `IOException`, `SQLException`

Unchecked exception:
- Classes that extend `RuntimeException` and `Error` are unchecked exception
- They happen during runtime and don’t have to be handled
- `ArithmeticException`, `NullPointerException`, `ArrayIndexOutOfBoundsException`

## 6. What is the difference between throw and throws ?
-	The `throw` is used inside the function to explicitly throw an exception. The `throws` is used in the function signature to declare an exception which might be thrown while the execution of the function
-	The `throw` keyword can throw only one exception at a time. The `throws` keyword can be used to declare multiple exceptions, separated by a comma.
- The `throw` keyword, can be used to declare both checked and unchecked exceptions. The `throws` keyword can be used to propagate checked exceptions only.
-	The `throw` keyword is followed by an instance of the Exception to be thrown. The `throws` keyword is followed by class names of Exceptions to be thrown.

## 7. Run the below three pieces codes, Noticed the printed exceptions. why do we put the Null/Runtime exception before Exception ?
First piece gives:
```
java.lang.ArithmeticException: / by zero
	at org.example.Main.main(Main.java:9)
End ...
```
Second piece gives:
```
java.lang.NullPointerException: Cannot invoke "String.equals(Object)" because "s" is null
	at org.example.Main.main(Main.java:10)
End ...
```
Third piece gives:
```
java.lang.RuntimeException
	at org.example.Main.main(Main.java:11)
End ...
```
We put the `ArithmeticException` / `NullPointerException` / `RuntimeException` before `Exception` because we should always start from the smaller blocks to bigger ones.  
Though the size of a try block makes no difference in performance, keeping try blocks small can lead to better programs. When an exception is caught so that it can be wrapped by another exception and re-thrown, or displayed to the user, **small try blocks mean that you know more precisely which operation failed**, and the higher-level context in which that call was made.

## 7. Why finally always be executed ?
In `try` block, when an exception is found, the code after this exception will not be executed, but these code may be necessary. So sometimes we need the `finally` block to make it up.  
Imagine that you opened a file, get an exception, then thrown or returned. The code after this exception will never be executed, so the file will never be closed. Here come the necessity of having a `finally` block being always executed.

## 8.  What are the types of design patterns in Java ? (#1 in hw22)
There are mainly three types of design patterns:
- Creational Design Pattern
  - Factory Pattern
  - Abstract Factory Pattern
  - Singleton Pattern
  - Prototype Pattern
  - Builder Pattern.
- Structural Design Pattern
  - Facade Pattern
  - Proxy Pattern
- Behavioral Design Pattern
  - Iterator Pattern

## 9.  What are the SOLID Principles ? (#2 in hw22)
SOLID is an acronym for five other class-design principles: 
- **Single Responsibility Principle**: Each class should be responsible for a single part or functionality of the system.
- **Open-Closed Principle**: Software components should be open for extension, but not for modification.
- **Liskov Substitution Principle**: Objects of a superclass should be replaceable with objects of its subclasses without breaking the system.
- **Interface Segregation Principle**: 	No client should be forced to depend on methods that it does not use.
- **Dependency Inversion Principle**: High-level modules should not depend on low-level modules, both should depend on abstractions.

## 10.  How can you achieve thread-safe singleton patterns in Java ? (#3 in hw22)
- Eager instantiation is thread safe, but a waste of memo, since we may never use this object
```
public class Singleton {
    private static Singleton instance = new Singleton();

    public static Singleton getInstance() {
        return instance;
    }
}
```
- Lazy instantiation with double null check (synchronize the second null check): thread safe and higher performance. It synchronized the creation code block only for the first few threads that may create separate instances. Then once an instance is created, the following threads will directly return the singleton, they won’t even pass the first if.
```
public class Singleton {
    private static Singleton instance;

    public static Singleton getInstance() {
        if (instance ==  null) {
            synchronized (Singleton.class) {
                if (instance == null)
                    instance = new Singleton();
            }
        }
        
        return instance;
    }
}　
```
## 11.  What do you understand by the Open-Closed Principle (OCP) ? (#4 in hw22)
OCP means "software entities (classes, modules, functions, etc.) should be open for extension, but closed for modification".   
It tells you to write your code so that you will be able to add new functionality without changing the existing code. That prevents situations in which a change to one of your classes also requires you to adapt all depending classes.

## 12.  (SOLID-L)Liskov’s substitution principle states that if class B is a subtype of class A, then object of type A may be substituted with any object of type B. What does this actually mean? choose your answer. (#6 in hw22)
1.  It means that if the object of type A can do something, the object of type B could also be able to
 perform the same thing
2.  It means that all the objects of type A could execute all the methods present in its subtype B
3.  It means if a method is present in class A, it should also be present in class B so that the object of
    type B could substitute object of type A.
4.  It means that for the class B to inherit class A, objects of type B and objects of type A must be same.  

1
## 13.  Watch the design pattern video, and type the code, submit it to MavenProject folder (#7 in hw22)
see MavenProject/pattern

## 14.  CRUD MySQL and MongoDB (separated PDF)
### MySQL-1.  Create  oms_company_address  table
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
### MySQL-2.  Insert some random data to  oms_company_address  table
```
INSERT INTO oms_company_address (id, address_name, send_status, receive_status, name, phone, province, city, region, detail_address) VALUES 
(1, 'Home', 0, 1, 'Alice', '00000000', 'MA', 'BOS', 'BOS', 'xxxxxx'),
(1, 'School', 1, 1, 'Bob', '11111111', 'MA', 'BOS', 'BOS', 'yyyyyy'),

```
### MySQL-3.  Write a SQL query to fetch all data from  oms_company_address  `table
```SELECT * FROM oms_company_address;```
### MySQL-4.  Write a SQL query to fetch top 3 records from  oms_company_address  table
```SELECT * FROM oms_company_address LIMIT 3;```
### MySQL-5.  Update  oms_company_address  table to set all  phone to 666-6666-8888
```UPDATE oms_company_address SET phone = '666-6666-8888';```
### MySQL-6.  Delete one entry from  oms_company_address  table
```DELETE FROM oms_company_address WHERE id = 1;```

### MongoDB-1. Create  test DB
```use test```
### MongoDB-2.  Create  oms_company_address  collection  (method: createCollection() )
```db.createCollection("oms_company_address")```
### MongoDB-3.  Insert few random entries to  oms_company_address  collection (method: insert() )
```
db.oms_company_address.insertMany([
{ address_name: "Home", send_status: 1, receive_status: 0, name: "Alice", phone: "00000000", province: "MA", city: "BOS", region: "BOS", detail_address: "xxxxxx" },
{ address_name: "School", send_status: 1, receive_status: 1, name: "Bob", phone: "11111111", province: "MA", city: "BOS", region: "BOS", detail_address: "yyyyyy" }
])
```
### MongoDB-4.  Read one entry from  oms_company_address  collection (method: find() )
```db.oms_company_address.findOne({ name: "Alice" })```
### MongoDB-5.  Read all entries from  oms_company_address  collection (method: find() )
```db.oms_company_address.find()```
### MongoDB-6.  Update one entry from  oms_company_address collection (method: update() or save() )
```db.oms_company_address.update({ name: "Alice" }, { $set: { name: "Anna" }})```
### MongoDB-7.  Remove one entry from  oms_company_address collection (method: remove() )
```db.oms_company_address.remove({ name: "Anna" })```

 
 
 