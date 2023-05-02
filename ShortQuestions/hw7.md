# HW 7

## 2. How do you do the debug?

Firstly create all the breakpoints needed. Then start the SpringBoot application, use Postman to send requests to server. Program will stop at each breakpoint we created.

## 3. What is DTO, VO, Payload, DO, model

- `DTO` (Data Transfer Object): A DTO is a **plain Java object** that is used to transfer data between different layers of an application, such as between the client and server or between different microservices. DTOs are typically used to encapsulate data that is returned by a web service or retrieved from a database.
- `VO` (Value Object): A VO is a read-only object that represents a simple value, such as an enumeration or a date. VOs are typically used to encapsulate values that are used across different layers of an application.
- `Payload`: A Payload is a term used to refer to the data that is transmitted over a network or stored in a data store. In the context of RESTful web services, a Payload typically refers to the JSON or XML data that is transmitted in the request or response body.
- `DO` (Domain Object): A DO is an object that represents a real-world entity or concept in a software system. DOs are typically used to encapsulate business logic and to represent the state of the application's domain model.
- `Model`: A Model is a term used to refer to the objects or classes that represent the data and behavior of an application. In the context of the Model-View-Controller (MVC) architectural pattern, the Model represents the data and business logic of the application.

## `@JsonProperty("description")` is an annotation in Java that is used to indicate that a Java class field or a Java Bean property should be mapped to a specific JSON property when serializing or deserializing Java objects to and from JSON.

When a Java object is converted to JSON using a serialization library such as Jackson, the properties of the Java object are mapped to the properties of the JSON object. The `@JsonProperty` annotation allows you to specify the name of the JSON property to which a Java class field or Java Bean property should be mapped.

For example, consider the following Java class:

## 4. What is @JsonProperty("description")?

`@JsonProperty("description")` is an annotation in Java that is used to indicate that a Java class field or a Java Bean property should be mapped to a specific JSON property when serializing or deserializing Java objects to and from JSON.

When a Java object is converted to JSON using a serialization library such as Jackson, the properties of the Java object are mapped to the properties of the JSON object. The `@JsonProperty` annotation allows you to specify the name of the JSON property to which a Java class field or Java Bean property should be mapped.

For example, suppose you have the following Java object:

```java
public class Person {
    private String firstName;
    private String lastName;
    private int age;

    // getters and setters go here
}
```

If you want to serialize this object to JSON and specify that the JSON property names should be "first_name", "last_name", and "age", you can use the `@JsonProperty` annotation like this:

```java
public class Person {
    @JsonProperty("first_name")
    private String firstName;
    @JsonProperty("last_name")
    private String lastName;
    @JsonProperty
    private int age;

    // getters and setters go here
}
```

Now when you serialize the `Person` object to JSON using Jackson, the JSON object will have properties with the names specified in the `@JsonProperty` annotations.

## 5. What is Jackson?

```xml
<dependency>
  <groupId>com.fasterxml.jackson.core</groupId>
  <artifactId>jackson-databind</artifactId>
  <version>2.13.3</version>
  <scope>compile</scope>
</dependency>
```

Jackson is a popular open-source Java library for working with JSON data. **It provides a set of high-performance tools for serializing and deserializing JSON data to and from Java objects**. Jackson is widely used in Java-based applications, including web applications, mobile applications, and enterprise systems.

Jackson provides several features, including:

- Streaming API: Jackson allows you to work with JSON data as a stream, which can be more memory-efficient and faster than working with entire JSON documents at once.
- Data Binding: Jackson enables you to map JSON data to and from Java objects. With data binding, you can work with JSON data as if it were native Java objects.
- Tree Model: Jackson provides a tree model API that allows you to manipulate JSON data as a tree of nodes, where each node represents a JSON value or object.
- Annotation support: Jackson supports annotations to customize how Java objects are mapped to JSON and vice versa.

Jackson has several modules that provide additional functionality, such as:

- `jackson-databind`: The core module that provides data binding functionality.
- `jackson-core`: Provides low-level streaming APIs for reading and writing JSON data.
- `jackson-annotations`: Provides annotations that can be used to configure the data binding process.

## 6. What is **spring-boot-stater**?

`spring-boot-starter` is **a set of dependency management libraries provided by the Spring Boot framework**. It's essentially a collection of common libraries and dependencies that are typically used in Spring Boot applications.

When you include the `spring-boot-starter` dependency in your project, it will transitively pull in all the necessary dependencies required to build a basic Spring Boot application, including:

- `spring-boot-starter-web`: For building web applications using Spring MVC, including support for embedded Tomcat or Jetty.
- `spring-boot-starter-data-jpa`: For using Spring Data JPA and Hibernate for ORM operations.
- `spring-boot-starter-test`: For writing unit tests and integration tests.
- `spring-boot-starter-actuator`: For monitoring and managing your application.

The `spring-boot-starter` provides a convenient way to manage dependencies and ensure that all the required dependencies are included in your project. It also helps you to avoid dependency conflicts by providing a consistent set of libraries that work well together.

## 7. Do you know @RequestMapping(value = "/users", method = RequestMethod.POST) ? could you list CRUD by this style?

Using this annotation along with other HTTP methods, you can implement CRUD (Create, Read, Update, Delete) operations in your Spring application.

```java
@Controller
@RequestMapping("/users")
public class UserController {
    
    @Autowired
    private UserService userService;
    
    @RequestMapping(value = "/", method = RequestMethod.POST)
    @ResponseBody
    public User createUser(@RequestBody User user) {
        return userService.createUser(user);
    }
    
    @RequestMapping(value = "/", method = RequestMethod.GET)
    @ResponseBody
    public List<User> getUsers() {
        return userService.getUsers();
    }
    
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseBody
    public User getUser(@PathVariable("id") Long id) {
        return userService.getUserById(id);
    }
    
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    @ResponseBody
    public User updateUser(@PathVariable("id") Long id, @RequestBody User user) {
        user.setId(id);
        return userService.updateUser(user);
    }
    
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public void deleteUser(@PathVariable("id") Long id) {
        userService.deleteUser(id);
    }
}
```

## 8. What is ResponseEntity? why do we need it?

```java
new ResponseEntity<>(postResponse, HttpStatus.OK);
new ResponseEntity<>(postResponse, HttpStatus.CREATED);
ResponseEntity.ok(postService.getPostById(id));
```

`ResponseEntity` is a class in the Spring Framework that represents an HTTP response that can be returned from a controller method in a Spring MVC or Spring WebFlux application.

A `ResponseEntity` object contains both the HTTP status code and the response body, which can be any object that can be serialized to the HTTP response body format (e.g., JSON, XML, or plain text). Using a `ResponseEntity` object, you can customize the HTTP status code, headers, and body of the response that is sent back to the client.

## 9. What is ResultSet in JDBC? And describe the flow how to get data using JDBC?

In JDBC, `ResultSet` is an interface that represents the result set of a SQL query. It provides methods to navigate through the rows and columns of the result set and retrieve the data.

When you execute a SELECT statement using JDBC, the database returns a result set that contains the data that matches the query. You can then use the `ResultSet` interface to retrieve the data from the result set.

```java
Connection connection = null;
PreparedStatement preparedStatement = null;
ResultSet resultSet = null;

try {
    // Get a connection to the database
    connection = DriverManager.getConnection(url, username, password);

    // Create a PreparedStatement object with a SQL query
    String sql = "SELECT * FROM employees WHERE department = ?";
    preparedStatement = connection.prepareStatement(sql);

    // Set the query parameter
    preparedStatement.setString(1, "Sales");

    // Execute the query and get the ResultSet object
    resultSet = preparedStatement.executeQuery();

    // Iterate over the result set and retrieve the data
    while (resultSet.next()) {
        int id = resultSet.getInt("id");
        String name = resultSet.getString("name");
        double salary = resultSet.getDouble("salary");
        System.out.println("Employee: " + id + ", " + name + ", " + salary);
    }
} catch (SQLException e) {
    e.printStackTrace();
} finally {
    // Close the result set, statement, and connection
    try {
        if (resultSet != null) resultSet.close();
        if (preparedStatement != null) preparedStatement.close();
        if (connection != null) connection.close();
    } catch (SQLException e) {
        e.printStackTrace();
    }
}

```

## 10. What is the ORM framework?

ORM stands for Object-Relational Mapping. An ORM framework is a programming tool that provides a mechanism for mapping object-oriented domain models to a relational database management system (RDBMS).

In simpler terms, an ORM framework enables developers to work with a database using a high-level, object-oriented programming interface instead of writing low-level SQL queries. It provides a layer of abstraction between the application code and the database, allowing developers to focus on the domain model and the business logic of their application rather than on the details of the database schema.

An ORM framework typically provides the following features:

1. Entity mapping: Allows developers to map database tables to domain model classes and map database columns to class properties.
2. CRUD operations: Provides methods for creating, reading, updating, and deleting records in the database.
3. Querying: Provides a query language or API for querying the database using domain model classes and properties, rather than writing SQL queries directly.
4. Transaction management: Provides support for transactions, which are units of work that are executed as a single, atomic operation.
5. Caching: Provides a caching mechanism to improve the performance of database operations.

## 11. Learn how to use ObjectMapper by this Example.

Check `~/Coding/hw7`

## 12. What is the serialization and deserialization?

**Serialization** is the process of converting a data object—a combination of code and data represented within a region of data storage—into a series of bytes that saves the state of the object in an easily transmittable form. In this serialized form, the data can be delivered to another data store (such as an [in-memory computing platform](https://hazelcast.com/products/in-memory-computing-platform/)), application, or some other destination.

The reverse process—constructing a data structure or object from a series of bytes—is [deserialization](https://hazelcast.com/glossary/deserialization/). The deserialization process recreates the object, thus making the data easier to read and modify as a native structure in a programming language.

Serialization enables us to save the state of an object and recreate the object in a new location. Serialization encompasses both the storage of the object and exchange of data. Since objects are composed of several components, saving or delivering all the parts typically requires significant coding effort, so serialization is a standard way to capture the object into a sharable format. With serialization, we can transfer objects:

- Over the wire for messaging use cases
- From application to application via web services such as REST APIs
- Through firewalls (as JSON or XML strings)
- Across domains
- To other data stores
- To identify changes in data over time
- While honoring security and user-specific details across applications

## 13-15. Coding Problems

Check `~/Coding/hw7`