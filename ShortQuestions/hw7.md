## 1. List all of the new annotations to your annotaitons.md and explain its role.

1. @ResponseStatus: Used to define the HTTP status code to be returned by a controller method. This annotation is typically used to define custom error responses for RESTful web services.
2. @ComponentScan: Used to automatically scan for Spring components, such as controllers, services, and repositories. This annotation is typically placed on a configuration class, and can be used to specify which packages should be scanned.
3. @EnableAutoConfiguration: Used to enable Spring Boot's auto-configuration mechanism. This annotation allows Spring Boot to automatically configure various aspects of the application based on the classpath and other configuration properties.
4. @Override: Indicates that a method is intended to override a method in a superclass or interface.
5. @Deprecated: Marks a class, method, or field as deprecated, indicating that it should no longer be used and may be removed in a future release.
6. @SuppressWarnings: Instructs the compiler to suppress specific warnings, such as unchecked cast warnings or deprecation warnings.
7. @FunctionalInterface: Indicates that an interface is a functional interface, which means it has a single abstract method and can be used as a lambda expression.
8. @SafeVarargs: Indicates that a method is safe to call with a variable number of arguments of a generic type.
9. @Nullable: Indicates that a parameter, method return value, or field may be null.
10. @NonNull: Indicates that a parameter, method return value, or field cannot be null.
11. @Retention: Used to specify the retention policy for an annotation. Annotations can have different retention policies, such as SOURCE, CLASS, or RUNTIME, which determine when the annotation is discarded.
12. @Documented: Used to indicate that an annotation should be included in the Javadoc documentation for the annotated element. This annotation is useful for providing additional information to developers who may be using the annotated element.

## 2. How do you do the debug?

In IntelliJ IDEA, there are several steps to do the debug.

1. Set breakpoints: Identify the lines of code that you want to debug and set breakpoints by clicking on the left margin of the line numbers in the code editor. You can also set conditional breakpoints that only stop the program when specific conditions are met.
2. Run the program in debug mode: To run the program in debug mode, click on the "Debug" button. This will start the program and pause at the first breakpoint encountered.
3. Step through the code: You can use the debugging toolbar or keyboard shortcuts to step through the code, one line at a time. 
4. Inspect variables and expressions: While debugging, you can inspect the values of variables and expressions by hovering over them or by adding them to the Watches panel. You can also modify variable values on the fly.
5. Analyze stack trace: If an exception is thrown, IntelliJ IDEA will pause the program and display the stack trace. You can analyze the stack trace to identify the source of the error.
6. Stop debugging: Once you have finished debugging, click on the "Stop" button to terminate the program.

## 3. What is DTO, VO, Payload, DO, model?

1. DTO (Data Transfer Object): A DTO is a plain Java object that is used to transfer data between different layers of an application or between an application and external systems. DTOs typically contain only fields with getters and setters, and do not contain any business logic or methods.
2. VO (Value Object): A VO is a read-only object that represents a value or a set of values. VOs are typically used to encapsulate domain-specific data and are immutable, meaning that their values cannot be changed once they are created.
3. Payload: A payload is the data that is being carried by a message or request. In RESTful API development, the payload is typically a JSON or XML object that contains data that is being sent or received by the API.
4. Data Object (DO): DO is a type of object that represents a real-world entity or data structure in an application's domain. DOs are used to encapsulate and manipulate data within the application. DOs typically contain fields that correspond to the attributes of the real-world entity they represent, as well as methods to manipulate the data. 
5. Model: A model is a representation of data that is used by the application to perform various operations. In the Model-View-Controller (MVC) architecture, the model represents the application's data and business logic, and is responsible for managing the state of the application.

## 4. What is @JsonProperty("description_yyds")?

@JsonProperty("description_yyds") is a Jackson annotation in Java that is used to specify the JSON property name for a field or method when serializing or deserializing an object. When Jackson serializes an object to JSON, it maps the field or method name to a corresponding JSON property name. By default, Jackson uses the field or method name as the JSON property name. 

```
public class Product {
    private String name;
    @JsonProperty("description_yyds")
    private String description;
}
```
For example, in this code that when Jackson serializes an instance of the Product class to JSON, the description field will be mapped to a JSON property named description_yyds. Similarly, when Jackson deserializes JSON to an instance of the Product class, it will expect to find a JSON property named description_yyds and map its value to the description field.

## 5. Do you know what is jackson?

Jackson is a popular Java library for working with JSON data. It provides a set of APIs for reading and writing JSON data, as well as annotations for customizing the serialization and deserialization of Java objects to and from JSON.Jackson is widely used in Java applications for a variety of tasks, including communicating with RESTful APIs, exchanging data between client and server in web applications, and serializing Java objects for storage or transmission. One of the key features of Jackson is its support for data binding, which allows Java objects to be automatically serialized to and deserialized from JSON data. Jackson can also be used to work with other data formats, such as YAML and CSV.
`jackson-databind` is a module of the Jackson library that provides a high-level data binding API for working with JSON data in Java. With `jackson-databind`, you can easily convert Java objects to JSON and back again using the ObjectMapper class, which provides a range of methods for reading and writing JSON data. The module supports a range of data formats, including JSON, YAML, and XML, and it provides a flexible and customizable set of APIs for working with these formats.

## 6. What is spring-boot-starter?

spring-boot-starter is a module of the Spring Boot framework that provides a convenient way to include a set of dependencies in your project with a single, easy-to-use dependency. It is essentially a collection of related dependencies that are commonly used together to build a Spring Boot application. The spring-boot-starter module contains a set of "starter" dependencies that provide everything you need to get started with a specific feature or functionality of Spring Boot. The spring-boot-starter module includes a wide range of starter dependencies for common use cases, such as web applications (spring-boot-starter-web), security (spring-boot-starter-security), testing (spring-boot-starter-test), and many others.

### what dependecies in the below starter? do you know any starters?

The spring-boot-starter-web starter includes the following dependencies:
1. Spring MVC: provides a robust framework for building web applications using the Model-View-Controller (MVC) architecture.
2. Spring Web: provides additional features for building web applications, such as support for RESTful web services and WebSocket communication.
3. Jackson Databind: provides support for JSON serialization and deserialization.
4. Validation: provides support for data validation and binding.
5. Tomcat: provides an embedded Tomcat server for deploying and running web applications.

Starters:

1. spring-boot-starter-data-jpa: includes dependencies for using Spring Data JPA, Hibernate, and a JDBC driver for connecting to a database.
2. spring-boot-starter-actuator: includes dependencies for adding monitoring and management features to a Spring Boot application.
3. spring-boot-starter-security: includes dependencies for adding security features to a Spring Boot application, such as authentication and authorization.
4. spring-boot-starter-test: includes dependencies for testing a Spring Boot application, such as JUnit, Mockito, and Spring Test.

## 7. do you know @RequestMapping(value = "/users", method = RequestMethod.POST) ? could you list CRUD by this style?

The @RequestMapping annotation in Spring is used to map HTTP requests to handler methods in your application. In the example @RequestMapping(value = "/users", method = RequestMethod.POST), this annotation is used with the POST method to map HTTP POST requests to the /users endpoint of the application.

1. Create(POST)

```
@RequestMapping(value = "/users", method = RequestMethod.POST)
public ResponseEntity<User> createUser(@RequestBody User user) {
    User savedUser = userRepository.save(user);
    return ResponseEntity.created(URI.create("/users/" + savedUser.getId())).body(savedUser);
}
```

2. Update(PUT)

```
@RequestMapping(value = "/users/{id}", method = RequestMethod.PUT)
public ResponseEntity<User> updateUser(@PathVariable("id") Long id, @RequestBody User updatedUser) {
    Optional<User> user = userRepository.findById(id);
    if (user.isPresent()) {
        updatedUser.setId(id);
        User savedUser = userRepository.save(updatedUser);
        return ResponseEntity.ok(savedUser);
    } else {
        return ResponseEntity.notFound().build();
    }
}
```

3. Read(GET)

```
@RequestMapping(value = "/users/{id}", method = RequestMethod.GET)
public ResponseEntity<User> getUserById(@PathVariable("id") Long id) {
    Optional<User> user = userRepository.findById(id);
    if (user.isPresent()) {
        return ResponseEntity.ok(user.get());
    } else {
        return ResponseEntity.notFound().build();
    }
}
```

4. Delete(DELETE)

```
@RequestMapping(value = "/users/{id}", method = RequestMethod.DELETE)
public ResponseEntity<Void> deleteUser(@PathVariable("id") Long id) {
    Optional<User> user = userRepository.findById(id);
    if (user.isPresent()) {
        userRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    } else {
        return ResponseEntity.notFound().build();
    }
}
```

## 8. What is ResponseEntity? why do we need it?

ResponseEntity is a class in Spring Framework that represents an HTTP response with a status code and a body. It can be used as the return type for methods in Spring controllers that handle HTTP requests. ResponseEntity is useful because it allows you to have more fine-grained control over the response that is sent back to the client. With ResponseEntity, you can set the HTTP status code, headers, and body of the response.

## 9. What is ResultSet in jdbc? and describe the flow how to get data using JDBC

ResultSet is an interface in the Java Database Connectivity (JDBC) API that provides methods for retrieving data from a database in the form of a table-like data structure. It represents the result of a database query executed using a JDBC Statement object.

Here is a general flow for how to get data using JDBC:
1. Load the JDBC driver class: First, you need to load the JDBC driver class that corresponds to the database you are using. This is typically done using the Class.forName() method.
2. Establish a connection: Use the DriverManager.getConnection() method to establish a connection to the database. You will need to provide the database URL, username, and password as arguments to this method.
3. Create a statement: Use the Connection.createStatement() method to create a Statement object that can be used to execute SQL queries against the database.
4. Execute a query: Use the Statement.executeQuery() method to execute an SQL query against the database. This will return a ResultSet object that contains the results of the query.
5. Retrieve data: Use the various ResultSet methods to retrieve data from the result set. The next() method is used to iterate through the rows of the result set, while other methods such as getInt(), getString(), etc. are used to retrieve data from specific columns.
6. Process data: Once you have retrieved the data from the ResultSet, you can process it as needed. This may involve displaying it to the user, performing calculations, or storing it in a data structure for later use.
7. Close resources: Finally, you should close the ResultSet, Statement, and Connection objects to release any database resources they may be holding.

## 10. What is the ORM framework?

An Object-Relational Mapping (ORM) framework is a software tool or library that provides a mechanism to map between an object-oriented programming language and a relational database. The goal of an ORM framework is to simplify the development of database-driven applications by eliminating the need for low-level SQL database code. ORM frameworks work by mapping classes and objects in an application to tables and records in a database. This mapping is typically defined using metadata, such as annotations or XML configuration files. Once the mapping is established, the ORM framework handles the translation between objects in the application and rows in the database.

ORM framework features including:

1. Support for common database operations such as creating tables, inserting records, updating records, and deleting records
2. Support for querying the database using object-oriented syntax, rather than writing low-level SQL code
3. Caching and optimization features to improve performance
4. Transaction management to ensure data consistency and integrity
5. Integration with other tools and libraries, such as object-relational mappers and data access objects

## 11. Learn how to use ObjectMapper by this example.

```
FoodOutlet foodOutlet = objectMapper.readValue(resBody, FoodOutlet.class);
String s = objectMapper.writeValueAsString(foodOutlet);
objectMapper.readTree() // learn how to use it?
```

1. FoodOutlet foodOutlet = objectMapper.readValue(resBody, FoodOutlet.class):
This line is using the objectMapper instance to deserialize the JSON data contained in the resBody variable into a FoodOutlet object. The readValue() method of the ObjectMapper class is used for deserializing JSON data into Java objects.
2. String s = objectMapper.writeValueAsString(foodOutlet):
This line is using the objectMapper instance to serialize the FoodOutlet object back into a JSON string. The writeValueAsString() method of the ObjectMapper class is used for serializing Java objects into JSON data.
3. objectMapper.readTree():
objectMapper.readTree() is a method in the Jackson library for reading a JSON string or JSON data from an input source (such as an InputStream or Reader) and creating a JsonNode object that represents the data.

## 12. What is the serialization and desrialization?

Serialization is the process of converting an object or data structure into a format that can be stored or transmitted. The serialized data can then be saved to a file, sent over a network, or stored in a database. During serialization, the object or data structure is converted into a stream of bytes that can be reconstructed later. Deserialization is the process of converting the serialized data back into an object or data structure. This process involves reading the stream of bytes and reconstructing the object or data structure as it was before serialization. Serialization and deserialization are commonly used in software development, particularly in distributed systems, where data needs to be transmitted between different processes or machines. By serializing an object, it can be easily transmitted across a network or stored in a file. When the data is needed, it can be deserialized to reconstruct the original object or data structure.

## 13. use stream api to get the average of the array [20, 3, 78, 9, 6, 53, 73, 99, 24, 32] 

```
int[] arr = {20, 3, 78, 9, 6, 53, 73, 99, 24, 32};

double average = Arrays.stream(arr)
                       .average()
                       .orElse(Double.NaN);
                       
System.out.println("Average: " + average);
```

## 14. 抄写，https://github.com/TAIsRich/springboot-redbook/tree/03_post_pageable

See Coding/redbook_post_pageable

## 15. (Optional) 抄写 https://github.com/TAIsRich/springboot-redbook/tree/04_comment

See Coding/redbook_comment

## 16. Try to write the CRUD api for a new application Cassandra-Blog

See Coding/cassandra-blog