### Homework 3
## 1. Practice collection
## 2. What is the checked exception and unchecked exception in Java, could you give one example?
Checked exception is the one that can be detected during compile time. If some code throws an exception, then the method must either handle the exception or throws the exception. IOException.

Unchecked exception, also called runtime exception, can be thrown during the normal operation of the Java Virtual Machine. ArrayOutOfBoundException.

## 3. Can there be multiple finally blocks?
No. One finally block follows one catch block. In one method, there can be multiple try catch finally blocks.

## 4. When both catch and finally return values, what will be the final result?
Finally block.

## 5. What is Runtime/unchecked exception ? what is Compile/Checked Exception ?
* Runtime exception is the superclass that can be thrown during the normal operation of the JVM.
* Checked exceptions are the ones that are checked during compilation time. If a code within a method throws a checked exception, then it should either be handled by a method or specify it using the throws keyword.

## 6. What is the difference between throw and throws ?
Throw is used in methods to throw exceptions explicitly.

Throws is used at the method signature to declare an exception that might be thrown by the function while executing.

## 7. why do we put the Null/Runtime exception before Exception ?
One should always catch the most specific exception first and then the most generic. In this specific question, NullPointerException is the subclass of Runtime Exception which is the subclass of Exception, where NullPointerException is the most specific and the Exception is the most generic.

## 8. Why finally always be executed ?
* Finally block is used to cleanup code, like closing a file or closing an connection;
* It allows to print out some important information.

## 9. What are the types of design patterns in Java ?
* Creational design pattern: provide way to create objects while hiding the creation logic, rather than instantiating objects directly using new operator. This gives program more flexibility in deciding which objects need to be created for a given use case;
* Structural pattern: concern class and object composition. Inheritance is used to compose interfaces and define ways to compose objects to obtain new functionality;
* Behavioral pattern: concern the communication between objects and how to provide loose-coupling and flexibility to extend easily.

## 10. What are the SOLID principles? 
* Single Responsibility Principle: It states that every java class must perform a single functionality. It precise the code and the code can be easily maintained.
* Open closed principle: The module should be open for extension but closed for modification. The extension allows to implement new functionality to the module.
* Liskov Substitution principle: it applies to the inheritance in such a way that the derived class must be completely substitutable for their base classes. If class A is subtype of B, then we should be able to replace B with A without interupting the behavior of the program.
* Interface Segregation Principle: split the large interface into small interfaces. Because the implementation class use only the function. The goal is same to the Single Responsibility Principle.
* Dependency Inversion Principle: high-level modules should depend on abstractions rather than concrete implementations. It helps decouple the high-level and low-level modules, making it easier to change the low-level ones without affecting the high-level ones.

## 11. How can you achieve thread-safe singleton patterns in Java ?
```
public class ThreadSafeExample {
  private static volatile ThreadSafeExample threadSafeExample;
  private ThreadSafeExample() {}
  public static ThreadSafeExample getInstance() {
    if (threadSafeExample == null) {
      synchronized(ThreadSafeExample.class) {
        if (threadSafeExample == null) {
          threadSafeExample = new ThreadSafeExample();
        }
      }
    }
    return threadSafeExample;
  }
}
```

## 12. What do you understand by the Open-Closed Principle (OCP) ?
Creating software entities whose behavior can be changed without the need to edit and recompile the code. For example, if the method try to enter a file and file name is hard code in the method. If the file address is changed, then the only way to modify it is by changing the hardcode part of the file. A better way is to pass the address into the method then we would be able to modify the behavior without changing its source. 

## 13. 
A

## 14. 
## 15. SQL
### 1.
create database test;
use test;
create table oms_company_address(
 id bigint,
 address_name varchar(200), 
 send_status int(1), 
 receive_status int(1),
 `name` varchar(64),
 phone varchar(64),
 province varchar(64),
 city varchar(64),
 region varchar(64),
 detail_address varchar(200),
 primary key (id)
);

### 2.
insert into oms_company_address (id,address_name) values(0, "beach");
insert into oms_company_address (id,address_name) values(1, "ktown");
insert into oms_company_address (id,address_name) values(2, "china town");
insert into oms_company_address (id,address_name) values(3, "george town");

### 3.
select * from oms_company_address;

### 4. 
select * from oms_company_address limit 3;

### 5. 
update oms_company_address set phone = "666-6666-8888";

### 6. 
delete from oms_company_address where id = 0;

## 16. Mongodb
### 1.
show dbs
use test

### 2.
db.createCollection("oms_company_address")

### 3.
db.oms_company_address.insertOne({"address_name":"Beach" "name":"Jakob"})
db.oms_company_address.insertOne({"address_name":"Ktown","name":"Yusurf"})
db.oms_company_address.insertOne({"address_name":"Apex","name":"Fluffy"})
db.oms_company_address.insertOne({"address_name":"Ctown","name":"Jeremy"})

### 4.
db.oms_company_address.find({ name: "Jeremy" })

### 5.
db.oms_company_address.find()
### 6.
db.oms_company_address.updateOne({name:"Apex"}, "$set":{phone:"6789986753"})

### 7. 
db.oms_company_address.deleteMany({name:"Jeremy"})
