# HW3 Part 1 - Exception, Enum, Collection
## 1. Practice Collection
Please see `MavenProject/hw3/src/test/java`

## 2. What is the checked exception and unchecked exception in Java, could you give one example?
### Checked Exception
A checked exception is an exception that is checked at compile-time by the Java compiler.
This means that the compiler will require the developer to handle the exception or declare that it may
be thrown in a method signature using the `throws` keyword.

Example: 
* `FileNotFoundException`
* `SQLException`

### Unchecked Exception
An unchecked exception is an exception that is not checked at compile-time by the Java compiler. So it is not mandatory 
to handle them in a try-catch block or declare them using the `throws` keyword.

Example:
* NullPointerException
* IndexOutOfBoundsException

## 3. Can there be multiple finally blocks?
No.
* `finally` is optional in the try-catch block.
* `finally` can only be used once with a try or try-catch block.
```java

class A {
    void a() {
        try {
            
        } catch (Exception e) {
            
        } finally {
            
        }
    }
}
```

## 4. When both catch and finally return values,what will be the final result?
When both catch and finally blocks return values in Java, the value returned by the `finally` block will override the value returned by the catch block.
```java
public class FinallyReturn {
   int calc() {
      try {
         return 10;
      } catch(Exception e) {
         return 20;
      } finally {
         return 30;
      }
   }
   public static void main(String[] args) {
      FinallyReturn fr = new FinallyReturn();
      System.out.println(fr.calc());
   }
}
```
```shell
30
```

## 5. What is Runtime/unchecked exception? what is Compile/CheckedException?

### Runtime/unchecked exception
An unchecked exception is an exception that is not checked at compile-time by the Java compiler. So it is not mandatory
to handle them in a try-catch block or declare them using the `throws` keyword.

### Compile/CheckedException
A compile/checked exception is an exception that is checked at compile-time by the Java compiler.
This means that the compiler will require the developer to handle the exception or declare that it may
be thrown in a method signature using the `throws` keyword.


## 6. What is the difference between throw and throws?

### `throw`
`throw` is used to throw an exception object in a method or block of code.
```java
class A {
    void a() {
        throw new IllegalArgumentException("wrong argument");
    }
}
```
### `throws`
`throws` is used in a method signature to declare that the method may throw one or more types of exceptions.
it means that the method is not handling the exception itself but is instead leaving it to the caller to handle it.

```java

class A {
    void a() throws IllegalArgumentException, IOException {

    }
}
```

## 7. Run the below three pieces codes,Noticed the printed exceptions. why do we put the Null/Runtime exception before Exception ?

We put the Null/Runtime exception before `Exception`, because `Exception` is the super class of all runtime exceptions.
And we want to throw the specific runtime exception, not just the `Exception`. We always catch the narrow exception first.

## 8. Why finally always be executed?
1. Make sure to execute some important code like closing the file and free the resources.
2. Ensure the entire try-catch-finally block is completed, and cleanup or resource release is executed.

## 9. What are the SOLID Principles?
SOLID:
1. **A Responsibility**: a class should have only one responsibility or reason to change
2. **Open/Closed**: classes should be open for extension but closed for modification.
3. **Liskov Substitution**:  a subclass should be substitutable for its superclass without affecting the correctness of the program.
4. **Interface Segregation** clients should not be forced to depend on interfaces that they do not use.
5. **Dependency Inversion** high-level modules should not depend on low-level modules.

## 10. How can you achieve thread-safe singleton patterns in Java?

### Lazy thread-safe:
```java
public class Singleton {
    private static Singleton instance;

    private Singleton() {
    }

    public static synchronized Singleton getInstance() {
        if (instance == null) {
            instance = new Singleton();
        }
        return instance;
    }

}
```

### Lazy double-checked locking
```java
public class Singleton() {
    private volatile static Singleton instance;
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

### Lazy inner static class
```java
public class Singleton {
    private Singleton() {}

    private static class SingletonHolder {
        private static final Singleton INSTANCE = new Singleton();
    }

    public Singleton getInstance() {
        return SingletonHolder.INSTANCE;
    }
}
```

### Eager thread-safe
```java
public class Singleton {
    private static Singleton instance = new Singleton();
    private Singleton() {}
    public static Singleton getInstance() {
        return instance;
    }
}
```

## 11. What do you understand by the Open-Closed Principle (OCP) ?

Classes should be open for extension but closed for modification. In other words, we should be able to
extend the behavior of a class without modify its existing code.

We can follow this rules to achieve OCP:
1. **Abstraction**: By using interfaces or abstract classes, we can define contracts that specify the behavior of a class, without exposing its implementation details.
2. **Polymorphism**: By using polymorphism, we can define behavior that can be overridden or extended by subclasses, without modifying the existing code. 
3. **Dependency Inversion**: By depending on abstractions rather than concrete implementations, we can create code that is less tightly coupled and more easily extensible.

## 12. (SOLID-L)Liskov’s substitution principle states that if class B is a subtype of class A, then object of type A may be substituted with any object of type B. What does this actually mean? (from OA ) choose your answer.

Liskov’s substitution principle is about subtyping and it states that if a class B is a subtype of class A, then objects of type A can be replaced with objects of type B without affecting the correctness of the program.

1. [x] It mean that if the object of type A can do something,the object of type B could also be able to perform the same thing
2. [ ] It means that all the objects of type A could execute all the methods present in its subtype B
3. [ ] It means if a method is present in class A,it should also be present in class B so that the object of type B could substitute object of type A.
4. [ ] It means that for the class B to inherit class A,objects of type B and. objects of type A must be same.

## 13 Watch the design pattern video, and type the code

Please see:
```
MavenProject/hw3/src/main/java/com/chuwa/learn/singleton
MavenProject/hw3/src/main/java/com/chuwa/learn/builder
MavenProject/hw3/src/main/java/com/chuwa/learn/factory
MavenProject/hw3/src/main/java/com/chuwa/learn/pubsub
```
## 14 CRUD MySQL and MongoDB
## `MySQL`

### 1. Create `oms_company_address` table
```sql
CREATE TABLE IF NOT EXISTS oms_company_address(
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
) ENGINE=INNODB;
```
### 2. Insert some random data to oms_company_address table
```sql
INSERT INTO oms_company_address (address_name, send_status, receive_status, name, phone, province, city, region, detail_address)
VALUES ('home', 0, 0, 'tom', '13311322111', 'BEJ', 'BEJ', 'HD', 'Some Addr');
```

### 3. Write a SQL query to fetch all data from oms_company_address `table
```sql
SELECT * FROM oms_company_address;
```

### 4. Write a SQL query to fetch top 3 records from oms_company_address table
```sql
SELECT * FROM oms_company_address LIMIT 3;
```

### 5. Update oms_company_address table to set all phone to 666-6666-8888
```sql
UPDATE oms_company_address set phone = '666-6666-8888';
```

### 6. Delete one entry from oms_company_address table
```sql
DELETE FROM oms_company_address WHERE id=1;
```

## `MongoDB`
### 1. Create test DB
```mongodb-json-query
test> use chuwa0403
switched to db chuwa0403
```

### 2.  Create oms_company_address collection
```mongodb-json-query
chuwa0403> db.createCollection("oms_company_address")
{ ok: 1 }
```

### 3. Insert few random entries to oms_company_address collection
```mongodb-json-query
db.oms_company_address.insertOne({
  address_name: "home", 
  send_status: 1, 
  receive_status: 0, 
  name: "Tom", 
  phone:  "111-222-333", 
  address: {
    province: "BEJ", 
    city: "BEJ", 
    region: "HD", 
    detail_address: "some_addr"
  }
})

db.oms_company_address.insertOne({
  address_name: "home",
  send_status: 1,
  receive_status: 0,
  name: "Jerry", 
  phone:  "111-444-555",
  address: {
    province: "CA",
    city: "LA",
    region: "HX",
    detail_address: "some_addr"
  }
})

db.oms_company_address.insertOne({
  address_name: "office",
  send_status: 0,
  receive_status: 0,
  name: "Lily", phone:  "111-444-111",
  address: {
    province: "HEB",
    city: "SJZ",
    region: "SK",
    detail_address: "some_addr"
  }
})
```

### 4. Read one entry from oms_company_address collection
```mongodb-json-query
chuwa0403> db.oms_company_address.findOne({name: "Tom"})
{
  _id: ObjectId("64332dad26441b9cb06ca0ca"),
  address_name: 'home',
  send_status: 1,
  receive_status: 0,
  name: 'Tom',
  phone: '111-222-333',
  address: {
    province: 'BEJ',
    city: 'BEJ',
    region: 'HD',
    detail_address: 'some_addr'
  }
}
```

### 5. Read all entries from oms_company_address collection
```mongodb-json-query
chuwa0403> db.oms_company_address.find()
```

### 6. Update one entry from oms_company_address collection (method:update() or save())
```mongodb-json-query
chuwa0403> db.oms_company_address.updateMany({name:  "Tom"}, {$set: {name: "Tim"}})
{
acknowledged: true,
insertedId: null,
matchedCount: 0,
modifiedCount: 0,
upsertedCount: 0
}
```

### 7. Remove one entry from oms_company_address collection
```mongodb-json-query
chuwa0403> db.oms_company_address.deleteOne({name: "Lily"})
{ acknowledged: true, deletedCount: 1 }
```

# HW3 Part 2 -Design Pattern
## 1. What are the types of design patterns in Java?
### Creation Design Pattern
* Factory Pattern
* Abstract Factory Pattern
* Singleton Pattern
* Prototype Pattern
* Builder Pattern

### Structural Design Pattern
* Adapter Pattern
* Bridge Pattern
* Composite Pattern
* Decorator Pattern
* Facade Pattern
* Flyweight Pattern
* Proxy Pattern

### Behavioral Design Pattern
* Chain Of Responsibility Pattern
* Command Pattern
* Interpreter Pattern
* Iterator Pattern
* Mediator Pattern
* Memento Pattern
* Observer Pattern
* State Pattern
* Strategy Pattern
* Template Pattern
* Visitor Pattern

## 2. What are the SOLID Principles?
SOLID:
1. **A Responsibility**: a class should have only one responsibility or reason to change
2. **Open/Closed**: classes should be open for extension but closed for modification.
3. **Liskov Substitution**:  a subclass should be substitutable for its superclass without affecting the correctness of the program.
4. **Interface Segregation** clients should not be forced to depend on interfaces that they do not use.
5. **Dependency Inversion** high-level modules should not depend on low-level modules.

## 3. How can you achieve thread-safe singleton patterns in Java?
Eager:
```java
public class Singleton {
    private static Singleton instance = new Singleton();
    private Singleton() {}
    
    public Singleton getInstance() {
        return instance;
    }
}
```

Lazy:
```java
public class Singleton {
    private Singleton() {}
    private static class SingletonHolder {
        private static final Singleton INSTANCE;
    }

    public static Singleton getInstance() {
        return SingletonHolder.INSTANCE;
    }
}
```
## 4. What do you understand by the Open-Closed Principle (OCP)?
Classes should be open for extension but closed for modification. In other words, we should be able to
extend the behavior of a class without modify its existing code.

We can follow this rules to achieve OCP:
1. **Abstraction**: By using interfaces or abstract classes, we can define contracts that specify the behavior of a class, without exposing its implementation details.
2. **Polymorphism**: By using polymorphism, we can define behavior that can be overridden or extended by subclasses, without modifying the existing code.
3. **Dependency Inversion**: By depending on abstractions rather than concrete implementations, we can create code that is less tightly coupled and more easily extensible.

## 5. What do you understand by the Liskov Substitution Principle?
If a program is using a base class, it should be able to use any of its derived classes without knowing it.
This means that a subclass should not change the behavior or contract of its base class. It should only add new behaviors or override existing ones.

Liskov's substitution principle is violated if :
* Pre-conditions are strengthened, or
* Post-conditions are weakened

## 6. 12. (SOLID-L)Liskov’s substitution principle states that if class B is a subtype of class A, then object of type A may be substituted with any object of type B. What does this actually mean? (from OA ) choose your answer.
First is correct, see part 1 answer.

## 7. Watch the design pattern video,and type the code
See

```shell
MavenProject/hw3/src/main/java/com/chuwa/learn/singleton
MavenProject/hw3/src/main/java/com/chuwa/learn/builder
MavenProject/hw3/src/main/java/com/chuwa/learn/factory
MavenProject/hw3/src/main/java/com/chuwa/learn/pubsub
```

# HW3 Part 3 - Credit Card Notification.
Please check `MavenProject/hw3/src/main/java/com/chuwa/learn/credit_card_notification`

Design pattern I used:
* **Singleton**
* **Abstract factory**
* **Pub-sub**
