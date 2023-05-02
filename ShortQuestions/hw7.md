# hw 7
1. annotations:
    - @RestController:  tells Spring that this class is responsible for handling HTTP requests and producing HTTP responses.
    - @Autowired: inject a service into the controller, the service will handle the business logic for creating new object;
    - @PostMapping: map the method to HTTP POST requests to the usrl path. 
    - @RequestBody: tells Spring to deserialize the HTTP request body into a entity object. It often with a class/entity name, like @RequestBody User user.

2. how to debug:
    - Try to replicate the problem.  Understand the issue and try to isolate the problem.
    - print the statements to log or use the debugging tools. For example, for IntelliJ IDEA, we could use debug mode. Set breakpoints that program will be suspended at there. We could see the variables and frames at the breakpoints to find out where the issue is occuring.
    - Once we have identified the problem and fixed it, test the fix thoroughly to ensure that it has resolved the issue.
3. What is DTO, VO, payload, DO, model?
    - DTO: Data Transfer Object. It is an object that carries data between different layers or tiers of an application. It's used to transfer data between a web client and server. It is used to hide the information of part of entity with no business logic.
    - VO: Value Object. It represents a value or single piece of data that can be used in the business logic of an application. It is often used  to represent a single record a value from database and is immutable.
    - Payload: A payload is the data that is transmitted over a network or stored in a message queue. It can be JSON. In the context of REST API, the payload is the body of an HTTP request or response.
    - DO: Domain Objecct. An object that represents a domain entity in an application. It's used to model the business logic of an application and encapsulate the behavior and data of a specific domain entity.
    - Model: A model is an object that represents the data and behavior of a specific part of an application. It can be a DTO, VO, DO, or any other type. The model is often used in the MVC (Model-View-Controller) architecture to represent the data and behavior of the application's domain entities.
4. What is `@JsonProperty("description_yyds")`: This is a Jackson annotation.  This is used to specify the JSON property name for a Java class or method. When you seiralize a java object to JSON with this JsonProperty, it will use the differenet name rather than the Java object's fields or method name.
```
public class Book {
    private String title;
    @JsonProperty("description_yyds")
    private String description;
}
// become JSON
{
    "title": "book,
    "description_yyds": "A comedy "
}
```

5. Jackson: Jackson is a java based library to seriralize or map java objects to JSON and vice versa.
```
<dependency>
    <groupId>com.fasterxml.jackson.core</groupId>
    <artifactId>jackson-databind</artifactId>
    <version>2.13.3</version>
    <scope>compile</scope>
</dependency>
```

6. spring-boot-starter: starter allow to add jars in the classpath. The spring-boot-starter dependencies contain a pre-configured set of Spring and third-party libraries that are commonly used in Spring Boot applications. These dependencies help get started quickly by providing a set of commonly used features. For example: spring-boot-starter-web includes all the libraries to develop a web-based Spring Boot application, including the Spring Web MVC framework, Tomcat embedded server, Spring Boot auto-configuration and other related dependencies. 

7. `@RequestMapping(value = "/users", method = RequestMethod.POST)` : a Spring Framework annotation that maps a POST HTTP request to the specified URL patter "/users" with a method POST. When a client sends a POST request to the url, this annotation telss Spring to route the request to the method that has this annotation defined in the controller class. 

8. ResponseEntity: ResponseEntity represents the whole HTTP response: status code, headers and body. Without ResponseEntity we could simplyreturn the object from controller method. And Spring will serialize the object to JSON and set HTTP status code to `200 OK`. While this may be sufficient for some use cases. Using ResponseEntity gives us more control over the HTTP response.
9. ResultSet: it is an interface that is used to store the data from the database and use it in Java program. It provides methods for retrieving and manipulating the results of executed queries. When execute a SQL query against a database using a `Statemenet` or `PreparedStatement` object, the result is returned as a `ResultSet`.
Data flow: cuse `DriverManager` class to establish a connection to the database. 
10. ORM framework: Object-Relational Mapping. An ORM framework is a tool that provides a mapping between an application's object-oriented domain model and a relational database management system 
11. see [ObjectMapper](/Coding/MavenProject/src/main/java/hw7/object_mapper/)
12. What is the serialization and deserialization: Serialization is the process of converting an object into a stream of bytes so that it can be easily stored in a file, sent over a network, or otherwise transmitted as a sequence of bytes. The opposite process, which converts a stream of bytes back into an object, is called deserialization.
13. see [Average](/Coding/MavenProject/src/main/java/hw7/stream_api/Average.java)
14. see [redbook](/Coding/redbook/)
16. see [Cassandra-blog](/Coding/hw7/cassandra-blog/)