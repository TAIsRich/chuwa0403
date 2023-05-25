hw7

### 2.how do you do the debug?

1. Set breakpoint; and run step by step;
2. Use Junit to test and print lot local variables;
3. Check log information

### 3.What is DTO, VO, Payload, DO, model?

DTO, VO, Payload, DO, and model are all terms used in software development to refer to different types of objects or classes used to represent data. Here's a brief overview of each term:

1. DTO (Data Transfer Object): DTO is a design pattern used to transfer data between software application subsystems. A DTO carries data between the tiers, often over a network or other transport mechanism. It is usually a simple object that does not have any business logic or methods.
2. VO (Value Object): VO is another design pattern used to encapsulate data that belongs together into a single object. Unlike a DTO, a VO can have business logic methods associated with it.
3. Payload: Payload is a term used in RESTful web services to refer to the data being transferred between the client and server. It can be represented in different formats such as JSON, XML, or plain text.
4. DO (Domain Object): DO is a term used to describe the objects that represent the business domain model in an application. It encapsulates the business logic and rules that govern the behavior of the system.
5. Model: The model is a term used to refer to the data and logic that represent the business concepts and processes in an application. It is the core of the application's functionality and is often represented as a set of classes that define the objects and their relationships.

### 4.What is @JsonProperty("description_yyds")

A Jackson annotation used in Java to specify the property name of a JSON object during serialization or deserialization. The `@JsonProperty` annotation is used to map a Java field or getter/setter method to a specific key in the JSON data.

```java
public class Person {
    @JsonProperty("name")
    private String firstName;
    @JsonProperty("age")
    private int age;
    
    // getters and setters
}
```

This annotation map the `firstName` field to the key "name" and the `age` field to the key "age" during JSON serialization and deserialization. So, when a `Person` object is serialized to JSON, the resulting JSON object will have properties "name" and "age" instead of "firstName" and "age"

### 5.do you know what is jackson?

```xml
<dependency>
	<groupId>com.fasterxml.jackson.core</groupId>
	<artifactId>jackson-databind</artifactId>
	<version>2.13.3</version>
	<scope>compile</scope>
</dependency>
```

Jackson is a popular open-source library for working with JSON data in Java. It provides a set of API for converting Java objects to JSON and vice versa. Jackson is widely used in web development with frameworks like Spring, and it also supports features like data binding, streaming, and tree model.

ObjectMapper is a part of the Jackson library and is the main class responsible for serialization and deserialization of Java objects to JSON and vice versa

```java
import com.fasterxml.jackson.databind.ObjectMapper;
```



### 6.What is spring-boot-stater? 

What dependecies in the below starter? do you know any starters? 

```xml
<dependency> 
    <groupId>org.springframework.boot</groupId> 
    <artifactId>spring-boot-starter-web</artifactId> 
</dependency>
```

`spring-boot-starter` is a collection of dependencies that are commonly used in Spring Boot applications. It allows developers to easily include a set of related dependencies in their projects without having to specify each one individually.

`spring-boot-starter-web` is a starter that includes dependencies required to build web applications using Spring MVC, including embedded Tomcat server, Spring MVC, and Jackson JSON library.

Others:

- `spring-boot-starter-data-jpa`: includes Hibernate, Spring Data JPA, and related dependencies for working with relational databases.
- `spring-boot-starter-security`: includes Spring Security and related dependencies for securing web applications.
- `spring-boot-starter-test`: includes JUnit, Mockito, and related dependencies for testing Spring Boot applications.

### 7.do you know @RequestMapping(value = "/users", method = RequestMethod.POST) ? could you list CRUD by this style?

@RequestMapping is an annotation in Spring that maps HTTP requests to specific handler methods. The following are the CRUD operations mapped with this annotation:

- CREATE (POST): @RequestMapping(value = "/users", method = RequestMethod.POST)
- READ (GET): @RequestMapping(value = "/users/{id}", method = RequestMethod.GET)
- UPDATE (PUT): @RequestMapping(value = "/users/{id}", method = RequestMethod.PUT)
- DELETE (DELETE): @RequestMapping(value = "/users/{id}", method = RequestMethod.DELETE)

### 8.What is ResponseEntity? why do we need it?

```java
new ResponseEntity<>(postResponse, HttpStatus.OK);
new ResponseEntity<>(postResponse,HttpStatus.CREATED);
ResponseEntity.ok(postService.getPostById(id));
ResponseEntity.notFound().build();
```

`ResponseEntity` is a Spring Framework class that represents an HTTP response, including headers, status code, and body. It allows developers to define the HTTP response in a more detailed and flexible way than just returning a plain object.

In a Spring MVC or Spring WebFlux application, a method annotated with `@RequestMapping` or `@GetMapping` can return a `ResponseEntity` object instead of a plain object. This allows you to customize the HTTP response, for example, by setting the HTTP status code, adding headers, or setting the response body.

### 9.What is ResultSet in jdbc? and describe the flow how to get data using JDB

In JDBC, a ResultSet is a table of data representing a database result set, which is usually generated by executing a query against a database. It is a collection of rows that contain the results of a database query. Each row in the ResultSet represents a record in the result set, and each column in the row represents a field in the record.

To get data using JDBC, you typically follow these steps:

1. Load the JDBC driver for the database you want to connect to, using the `Class.forName()` method.
2. Create a connection to the database using the `DriverManager.getConnection()` method, passing in the URL, username, and password.
3. Create a statement object using the `Connection.createStatement()` method.
4. Execute a SQL query using the statement object's `executeQuery()` method. This will return a ResultSet object containing the results of the query.
5. Iterate over the ResultSet using its `next()` method, which returns `true` if there is another row in the ResultSet, and `false` if there are no more rows. You can then access the columns of the current row using the ResultSet's `getXXX()` methods (e.g. `getInt()`, `getString()`, etc.).
6. Close the ResultSet and statement objects using their `close()` methods.
7. Close the database connection using the `Connection.close()` method.

### 10.What is the ORM framework?

ORM (Object-Relational Mapping) is a technique used in software engineering to map an object-oriented programming language to a relational database. The goal of ORM is to bridge the gap between object-oriented programming and relational database design, by allowing developers to work with objects that represent database entities, rather than writing SQL statements directly.

ORM frameworks provide a set of tools and libraries for developers to interact with databases using objects, and abstract away the complexities of working with raw SQL. They typically provide features like automatic table and column mapping, lazy loading of data, caching, transaction management, and more.

### 12What is the serialization and desrialization?

a. https://hazelcast.com/glossary/serialization/

Serialization is the process of converting an object into a stream of bytes so that it can be stored or transmitted over a network. The reverse process, i.e., converting a stream of bytes back into an object, is called deserialization.

serialization is done using the `java.io.Serializable` interface, which is a marker interface that indicates that the class can be serialized. When an object is serialized, all of its non-transient instance variables are written to a stream. When the object is deserialized, the stream is read and the object is recreated.

Serialization and deserialization are often used in web applications to send and receive data in the form of JSON or XML. 

13.use stream api to get the average of the array [20, 3, 78, 9, 6, 53, 73, 99, 24, 32].

```java
int[] arr = {20, 3, 78, 9, 6, 53, 73, 99, 24, 32};
double average = Arrays.stream(arr)
                       .average()
```

