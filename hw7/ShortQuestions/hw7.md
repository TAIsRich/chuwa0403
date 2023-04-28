# 1.
@JsonProperty: This annotation is used to specify the name of a property during serialization and deserialization of JSON objects. It allows developers to map a JSON property to a specific Java class property.

@JsonDeserialize: This annotation is used to specify a custom deserializer for a particular class or field. Developers can use this annotation to define their own deserialization logic for JSON data.

@JsonSerialize: This annotation is used to specify a custom serializer for a particular class or field. Developers can use this annotation to define their own serialization logic for JSON data.

@JsonFormat: This annotation is used to specify the date and time format of a property during serialization and deserialization of JSON objects. It allows developers to control the format of date and time values in JSON.

@JsonIgnore: This annotation is used to exclude a particular property or field from being serialized or deserialized. Developers can use this annotation to prevent certain fields from being included in JSON data.

# 2.
Set breakpoints: A breakpoint is a marker that tells the debugger to pause the program's execution at a specific line of code. To set a breakpoint, click on the left-hand side of the code editor's line where you want the program to pause. A red dot will appear to indicate the breakpoint has been set.

Run the program in debug mode: To start the program in debug mode, click on the "Debug" button in the top toolbar or use the shortcut key Shift + F9. The program will start running, and the debugger will pause execution at the first breakpoint.

Step through the code: Use the debugging tools to navigate through the code, line by line. The most common debug tools are:

# 3.
DTO (Data Transfer Object): DTO is a design pattern used to transfer data between different layers or tiers of an application. It is typically a simple object that contains data and may have some validation logic, but it does not have any business logic. Its primary purpose is to carry data between the layers of an application.

VO (Value Object): VO is a design pattern used to encapsulate data that belongs together and has a value semantics. It represents a single value or a collection of values that are treated as a single value. Unlike DTO, it has business logic and can be used to represent a domain concept.

Payload: Payload is a term used to describe the data that is sent in a request or response between a client and server. In the context of web development, it typically refers to the data sent in an HTTP request or response. Payload can be represented in different formats like JSON, XML, or binary.

DO (Domain Object): DO is a design pattern used to represent a domain concept in object-oriented programming. It typically represents an entity in a domain model and contains both data and behavior that is relevant to that entity. DO can be used to encapsulate business logic and state related to a specific domain concept.

Model: A Model is a term used to describe the representation of data within an application. It is a design pattern used to represent the data and behavior of an application's domain concepts. The model can contain different types of objects, such as DTO, VO, DO, or any other objects that represent data within the application.

# 4.
The @JsonProperty("description_yyds") annotation is used in Java to indicate that a JSON property should be mapped to a specific class property during serialization or deserialization using the Jackson library.

# 5.
Jackson is a popular Java-based library that provides a suite of data-processing tools for handling JSON data. It is an open-source project that is widely used in the Java community to serialize and deserialize Java objects to and from JSON format.

# 6.
spring-boot-starter is a common naming convention for the Spring Boot starter dependencies that help developers quickly set up a new project with the necessary dependencies and configurations.

spring-boot-starter-web includes the necessary dependencies for building web applications with Spring Boot, such as the Spring Web MVC framework, Tomcat embedded server, and Jackson JSON processing libraries.

# 7.
```java
Create (Insert) - HTTP POST: @RequestMapping(value = "/users", method = RequestMethod.POST) or @PostMapping("/users")

Read (Retrieve) - HTTP GET: @RequestMapping(value = "/users/{id}", method = RequestMethod.GET) or @GetMapping("/users/{id}")

Update - HTTP PUT: @RequestMapping(value = "/users/{id}", method = RequestMethod.PUT) or @PutMapping("/users/{id}")

Delete - HTTP DELETE: @RequestMapping(value = "/users/{id}", method = RequestMethod.DELETE) or @DeleteMapping("/users/{id}")
```

# 8.
ResponseEntity is a class in the Spring Framework that represents an HTTP response from a web server. It is typically used to return a response with a specific HTTP status code, headers, and body from a Spring controller method.

The ResponseEntity class allows developers to have fine-grained control over the HTTP response that is sent back to the client. It provides methods for setting the response status code, headers, and body. This can be useful in cases where the default behavior of Spring's message converters is not sufficient or when you need to set a custom response header or status code.

# 9.

ResultSet is a Java class in the JDBC (Java Database Connectivity) API that represents the result set of a database query. It is a tabular data structure that contains the data returned by a SELECT query or stored procedure.

# 10.
An ORM framework is a tool or library that automates the mapping between the object-oriented programming language and the relational database, thereby allowing developers to work with objects instead of raw SQL statements. It provides an abstraction layer over the database that allows developers to interact with the database using objects and their properties and methods

# 12.
Serialization and deserialization are the processes of converting an object or data structure into a stream of bytes for transmission or storage, and then converting it back into an object or data structure again when it is needed.

# 13.
```java
int[] numbers = {20, 3, 78, 9, 6, 53, 73, 99, 24, 32};

double average = Arrays.stream(numbers)
                      .average()
                      .orElse(Double.NaN);

System.out.println("Average: " + average);
```

# 14.

