### Q1: List all of the new annotations to your annotaitons.md and explain its role.

@Entity: This annotation is used in Java to mark a class as a database table. It allows the class to be mapped to a database table and provides various functionalities such as persistence, queries, and relationships.

@Id: This annotation is used in Java to mark a field as the primary key of a database table.

@Column: This annotation is used in Java to map a class attribute to a database column.

@GeneratedValue: This annotation is used in Java to generate an automatic value for a field marked with @Id.

Annotations used by controller:

@Controller: This annotation is used in Spring MVC to mark a class as a controller. It allows the class to handle incoming HTTP requests and generate HTTP responses.

@RequestMapping: This annotation is used in Spring MVC to map a URL pattern to a method in a controller. It allows the method to handle HTTP requests that match the specified URL pattern.

@RequestBody: This annotation is used in Spring MVC to map the HTTP request body to a method parameter. It allows the method to receive data from the client-side.

@ResponseBody: This annotation is used in Spring MVC to map the method return value to the HTTP response body. It allows the method to send data to the client-side.

@PathVariable: This annotation is used in Spring MVC to map a variable part of a URL to a method parameter. It allows the method to receive dynamic values from the client-side.

Annotations used by dependency injection:

@Autowired: This annotation is used in Spring to inject a bean into a class field, constructor or method.

@Component: This annotation is used in Spring to mark a class as a Spring component. It allows the class to be automatically discovered by Spring's component scanning.

@Qualifier: This annotation is used in Spring to specify which bean to inject when multiple beans of the same type are available.

@Configuration: This annotation is used in Spring to mark a class as a configuration class. It allows the class to define beans and configurations for the Spring application context.


### Q2: how do you do the debug?

Using IDE create break point.


### Q3: What is DTO, VO, Payload, DO, model?

DTO stands for Data Transfer Object, which is a design pattern used in software engineering to transfer data between different layers or tiers of an application. It is essentially an object that contains data, but does not have any behavior associated with it.

VO stands for Value Object, which is a design pattern used to encapsulate a value or a group of related values. It is similar to DTO, but it typically has behavior associated with it, such as validation rules.

Payload is a term used to refer to the data that is sent over a network or between different layers of an application. It can be in various formats, such as JSON, XML, or binary data, and can contain any type of data, including DTOs, VOs, or other types of objects.

DO stands for Domain Object, which is an object that represents a concept or entity in the domain of the application. It typically has behavior associated with it, and is used to encapsulate business logic and state.

Model is a general term used to refer to any object or representation of data used in software engineering. It can be used to represent anything from database records to complex data structures, and can be implemented using various design patterns and programming paradigms.

### Q4: What is @JsonProperty("description_yyds")?

`@JsonProperty("description_yyds")` is a Java annotation that is used to define the mapping between a JSON property and a Java class field or getter/setter method.

In this case, the annotation specifies that the JSON property with the name "description_yyds" should be mapped to the annotated field or method in the Java class.

### Q5: do you know what is jackson?

Jackson is a popular open-source Java library for processing JSON data. It provides a set of tools for converting Java objects to JSON and vice versa, as well as for manipulating JSON data directly.

Jackson supports a wide range of JSON-related features, including:

-   Reading and writing JSON data to and from Java objects
-   Streaming API for efficient processing of large JSON data
-   Tree Model API for in-memory representation of JSON data
-   Support for data binding annotations, such as `@JsonProperty`, to map JSON properties to Java fields or methods
-   Custom serialization and deserialization of JSON data using JSON serializers and deserializers
-   Support for JSON Schema validation

Jackson is widely used in Java-based web applications and microservices, as well as in other types of Java applications that need to work with JSON data. Its popularity is due to its ease of use, performance, and extensive feature set.

### Q6: What is spring-boot-stater? what dependecies in the below starter? do you know any starters?

`spring-boot-starter` is a collection of dependencies that are commonly used together to provide a specific feature or set of features in a Spring Boot application. It is essentially a convenient way to include multiple dependencies in a project with a single dependency declaration.

In the example you provided, the `spring-boot-starter-web` dependency includes all the necessary dependencies to build a web application using Spring Boot, such as:

- Spring Web (spring-web) - for building web applications using Spring MVC
- Spring Web MVC (spring-webmvc) - for building traditional Spring MVC web applications
- Jackson (jackson-databind) - for JSON data processing
- Spring Boot Starter (spring-boot-starter) - for common Spring Boot functionality
- Tomcat (tomcat-embed-core) - for an embedded Tomcat server

Some other examples of Spring Boot starters include:

- `spring-boot-starter-data-jpa`: Includes dependencies for using Spring Data JPA for database access
- `spring-boot-starter-security`: Includes dependencies for securing web applications using Spring Security
- `spring-boot-starter-test`: Includes dependencies for writing unit and integration tests with Spring Boot

There are many other starters available, each providing a specific set of dependencies for a particular feature or use case.

### Q7: do you know @RequestMapping(value = "/users", method = RequestMethod.POST) ? could you list CRUD by this style?

`@RequestMapping(value = "/users", method = RequestMethod.POST)` is a Spring annotation that maps an HTTP POST request with the URL path "/users" to a method in a Spring controller.

C:
````
@RequestMapping(value = "/users", method = RequestMethod.POST)
public ResponseEntity<User> createUser(@RequestBody User user) {
    User savedUser = userRepository.save(user);
    return new ResponseEntity<>(savedUser, HttpStatus.CREATED);
}

````

R:
````
@RequestMapping(value = "/users/{id}", method = RequestMethod.GET)
public ResponseEntity<User> getUser(@PathVariable Long id) {
    Optional<User> user = userRepository.findById(id);
    if (user.isPresent()) {
        return new ResponseEntity<>(user.get(), HttpStatus.OK);
    } else {
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
````

U:
````
@RequestMapping(value = "/users/{id}", method = RequestMethod.PUT)
public ResponseEntity<User> updateUser(@PathVariable Long id, @RequestBody User user) {
    Optional<User> existingUser = userRepository.findById(id);
    if (existingUser.isPresent()) {
        User savedUser = userRepository.save(user);
        return new ResponseEntity<>(savedUser, HttpStatus.OK);
    } else {
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
````

D:
````
@RequestMapping(value = "/users/{id}", method = RequestMethod.DELETE)
public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
    Optional<User> user = userRepository.findById(id);
    if (user.isPresent()) {
        userRepository.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    } else {
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
````

### Q8: What is ResponseEntity? why do we need it?

`ResponseEntity` is a class in the Spring Framework that represents an HTTP response with a status code, headers, and body. It is commonly used in Spring web applications to provide a consistent way of returning responses from controller methods.

The main advantage of using `ResponseEntity` is that it allows you to customize the HTTP response sent back to the client. This includes setting the HTTP status code, adding custom headers, and returning a custom body. By default, Spring uses the `@ResponseBody` annotation to convert the return value of a controller method to an HTTP response with a status code of 200 and no additional headers. However, with `ResponseEntity`, you have more control over the response.

### Q9: What is ResultSet in jdbc? and describe the flow how to get data using JDBC

`ResultSet` is an interface in JDBC that represents the result of executing a SQL query. It provides methods for retrieving data from the result set, such as iterating over the rows, getting the values of specific columns, and navigating the result set.

Here is a general flow of how to get data using JDBC:

1.  Load the JDBC driver: Before using JDBC, you need to load the JDBC driver for your database. This can be done by calling the `Class.forName` method and passing in the name of the JDBC driver class.

2.  Establish a database connection: Once the JDBC driver is loaded, you need to establish a connection to your database. This can be done by calling the `DriverManager.getConnection` method and passing in the URL, username, and password for your database.

3.  Create a statement: After establishing a connection, you can create a statement object by calling the `Connection.createStatement` method. The statement object is used to execute SQL queries.

4.  Execute a query: You can execute a query by calling the `Statement.executeQuery` method and passing in the SQL query string. This method returns a `ResultSet` object that represents the result of the query.

5.  Process the result set: You can process the result set by iterating over its rows using the `ResultSet.next` method. Each row in the result set is represented by a set of column values, which you can retrieve using the various `ResultSet.get` methods.

6.  Close the result set and statement: After processing the result set, you should close it and the statement object using the `ResultSet.close` and `Statement.close` methods, respectively.

7.  Close the database connection: Finally, you should close the database connection using the `Connection.close` method.


### Q10: What is the ORM framework?

ORM stands for Object-Relational Mapping. It is a programming technique used to map object-oriented programming concepts to relational database concepts. In other words, it is a way to interact with a database using object-oriented programming concepts and syntax.

An ORM framework is a software library that provides a programming interface for accessing a relational database using object-oriented programming concepts. It automates the process of mapping between the database tables and the corresponding classes in an object-oriented programming language, such as Java or Python. The ORM framework provides an abstraction layer that allows developers to work with a database in a more natural way, using objects and methods instead of SQL queries.

There are several popular ORM frameworks available for different programming languages, including Hibernate for Java, Django ORM for Python, and Entity Framework for .NET.

Some of the benefits of using an ORM framework include:

- Increased productivity: With an ORM framework, developers can work with a database using familiar object-oriented programming concepts, which can help them be more productive and efficient.

- Improved maintainability: By using an ORM framework, developers can write code that is easier to maintain and update over time, since the code is more modular and less dependent on specific database implementations.

- Reduced risk of SQL injection: ORM frameworks can help prevent SQL injection attacks by automatically escaping user input and parameterizing SQL queries.

- Platform independence: ORM frameworks can be used with multiple databases and platforms, making it easier to write code that is portable and works across different environments.

Overall, ORM frameworks can help simplify the process of working with databases and allow developers to focus more on the application logic and less on the database implementation details.

### Q11: Learn how to use ObjectMapper.

`ObjectMapper` is a class in the Jackson library for Java that provides methods for converting JSON data to and from Java objects. It is commonly used in RESTful web services to serialize and deserialize data between the client and server.

### Q12: What is the serialization and desrialization?

Serialization and deserialization are the processes of converting data between a binary or text format and an object-oriented programming language format, such as Java or Python.

Serialization is the process of converting an object into a format that can be stored or transmitted, such as a binary stream, a text file, or a network packet. During serialization, the object's state is converted into a series of bytes that can be transmitted or stored, and later used to recreate the original object.

Deserialization is the opposite process of serialization. It is the process of reconstructing an object from its serialized state. During deserialization, the serialized data is converted back into an object that can be used by the program.

Serialization and deserialization are commonly used in communication protocols between software components or distributed systems, where data needs to be transmitted between different machines or processes. They are also used in data storage, such as saving an object to a file or a database.

One popular format for serialization and deserialization is JSON (JavaScript Object Notation), which is a lightweight data interchange format that is easy to read and write for humans, and easy to parse and generate for machines. Other formats include XML, YAML, and binary formats such as Protocol Buffers and Apache Avro.

### Q13: use stream api to get the average of the array [20, 3, 78, 9, 6, 53, 73, 99, 24, 32]

````
int[] arr = {20, 3, 78, 9, 6, 53, 73, 99, 24, 32};

double avg = Arrays.stream(arr)
                   .average()
                   .orElse(Double.NaN);

System.out.println("Average: " + avg);

````

### Q14:
see folder `springboot-redbook-03_post_pageable`


### Q16:

see folder `cassandra`