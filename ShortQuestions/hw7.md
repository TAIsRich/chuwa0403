# HW7

## 1. List all of the new annotations to your annotaitons.md and explain its role

Please check `ShortQuestions/annotations.md`

## 2. How do you do the debug?

1. Set breakpoints:
2. Start debugging
3. Inspect variables
4. Step through the code
5. Evaluate Expression
6. Exit Debugging

## 3. What is DTO, VO, Payload, DO, model?

DTO (Data Transfer Object): A DTO is an object used to transfer data between different layers of an application or
between systems. It is typically a simple Java class with properties, getters, and setters. DTOs can improve the
performance and modularity of an application by encapsulating data and reducing the number of method calls between
layers.

VO: View Object, used to transfer data to the front end

PO: Persistent Object, used to mapping this the database

Payload: In the context of web development, a payload is the data that is sent with an HTTP request or response.

Model: Generic name of all above

## 4. What is @JsonProperty("description_yyds")

`@JsonProperty` is an annotation from the Jackson library, which is a popular Java library for parsing and generating
JSON data. When you use @JsonProperty in your Java code, you can customize the name of a JSON property that maps to a
Java object field during the serialization and deserialization process. When Jackson serializes the Java object into
JSON, it will use the name "description_yyds" for the corresponding JSON property.

```java
public class Product {
    private int id;

    @JsonProperty("description_yyds")
    private String description;

    // Constructors, getters, and setters
}
```

```json
{
  "id": 1,
  "description_yyds": "A sample product description"
}
```

## 5. do you know what is jackson?

Jackson is a widely used Java library for processing JSON data. It provides functionality for reading (deserializing)
JSON content into Java objects, as well as writing (serializing) Java objects as JSON content.

Key features:

* Data binding: Jackson provides simple data binding to convert JSON data to and from Java objects (POJOs).
* Tree Model: Jackson allows you to read and write JSON data as a tree of nodes, similar to how you would work with XML
  data.
* Streaming API: Jackson offers a streaming API for high-performance reading and writing of JSON data.
* Customization: Jackson provides various annotations and configuration options that enable you to customize the
  serialization and deserialization process, such as controlling the JSON property names, handling null values, and
  specifying custom serializers and deserializers.

## 6. What is spring-boot-stater?

spring-boot-starter is a set of pre-defined, opinionated dependencies and configurations provided by the Spring Boot
framework to simplify the process of creating and configuring Spring Boot applications.

* `spring-boot-starter-web`: For creating web applications using Spring MVC. It includes dependencies such as Tomcat,
  Spring MVC, and Jackson.
* `spring-boot-starter-data-jpa`: For using Spring Data JPA with Hibernate for database access and ORM.
* `spring-boot-starter-security`: For adding Spring Security to your application to handle authentication and
  authorization.
* `spring-boot-starter-test`: For testing Spring Boot applications with libraries such as JUnit, Mockito, and AssertJ.
* `spring-boot-starter-actuator`: For adding production-ready monitoring and management features to your application,
  like
  health checks and metrics.

## 7. do you know @RequestMapping(value = "/users", method =RequestMethod.POST) ? could you list CRUD by this style?

Example CRUD

```java
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {

    @RequestMapping(value = "/users", method = RequestMethod.POST)
    public User createUser(@RequestBody User user) {
    }

    @RequestMapping(value = "/users/{id}", method = RequestMethod.GET)
    public User getUser(@PathVariable("id") Long id) {
    }

    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public List<User> getAllUsers() {
    }

    @RequestMapping(value = "/users/{id}", method = RequestMethod.PUT)
    public User updateUser(@PathVariable("id") Long id, @RequestBody User user) {
    }

    @RequestMapping(value = "/users/{id}", method = RequestMethod.DELETE)
    public void deleteUser(@PathVariable("id") Long id) {
    }
}

```

## 8. What is ResponseEntity? why do we need it

```java
new ResponseEntity<>(postResponse,HttpStatus.OK);
        new ResponseEntity<>(postResponse,HttpStatus.CREATED);
        ResponseEntity.ok(postService.getPostById(id));
```

ResponseEntity is a class provided by the Spring MVC framework that represents an HTTP response, including the response
body, status code, and headers. It is a generic class, allowing you to specify the type of the response body as a type
parameter (e.g., ResponseEntity<String> or ResponseEntity<User>).

## 9. What is ResultSet in jdbc? and describe the flow how to get data using JDBC

ResultSet is a Java interface provided by the JDBC, ResultSet allows you to retrieve and manipulate the query results
programmatically.

```java
Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/my_database","username","password");
        Statement statement=connection.createStatement();
        ResultSet resultSet=statement.executeQuery("SELECT * FROM users")
        while(resultSet.next()){
        int id=resultSet.getInt("id");
        String name=resultSet.getString("name");
        System.out.println("ID: "+id+", Name: "+name);
        }
        resultSet.close();
        statement.close();
        connection.close();
```

## 10. What is the ORM framework?

ORM (Object-Relational Mapping) is a programming technique that allows you to interact with relational databases using
object-oriented concepts instead of writing raw SQL queries. An ORM framework is a library that provides an abstraction
layer over a relational database, making it easier for developers to work with data as objects and their relationships,
rather than tables and rows.

## 11. Learn how to use ObjectMapper by this example.

## 12. What is the serialization and desrialization?

Serialization and deserialization are processes related to converting data between different formats. They are commonly
used when transmitting or storing data in a format that can be easily shared, stored, or parsed.
Serialization is the process of converting an object or data structure from its in-memory representation into a format
that can be easily stored or transmitted. Deserialization is the reverse process of serialization. 

## 13. use stream api to get the average of the array [20, 3, 78, 9, 6, 53, 73, 99, 24, 32]
```java
import java.util.Arrays;
import java.util.OptionalDouble;
public class Main {
  public static void main(String[] args) {
    int[] array = {20, 3, 78, 9, 6, 53, 73, 99, 24, 32};
    double average = Arrays.stream(array).average().orElse(0.0);
  }
}
```

## 14. 04_post_pageable
`MavenProject/redbook`

## 15. 04_comment
`MavenProject/redbook`

## 16. Try to write the CRUD api for a new application Cassandra-Blog

