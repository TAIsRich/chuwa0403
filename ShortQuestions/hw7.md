# 1. List all of the new annotations to your annotaitons.md and explain its role.
See chuwa0403/ShortQuestions.
# 2. how do you do the debug?
If we roughly know that the bug appears in a certain location of the code, we can set a breakpoint at the relevant location, and then click debug in the IDE to view the results of running before each breakpoint and determine the type of bug. If the cause of the bug is too vague, we can use line-by-line debug.
# 3. What is DTO, VO, Payload, DO, model?
- `DTO (Data Transfer Object)`  It is used to transfer data between different layers of an application, such as between the presentation layer and the service layer. It usually contains only simple data types such as primitive types or Strings and does not contain any business logic.
- `VO (Value Object)` VO is a design pattern used to represent an immutable object that contains values that describe a particular state.
- `Payload` payload is the actual data that is being transferred between different layers of an application. It can be a DTO, VO, or any other type of object that contains the necessary data.
- `DO (Domain Object)` DO is an object that represents a real-world entity in the domain model of an application. It typically contains both data and business logic and is used to encapsulate the behavior and data of a domain entity.
- `Model` A model is an object that represents the data and the business logic of an application. 
# 4. What is @JsonProperty("description_yyds")?
`@JsonProperty("description_yyds")` means to map a Java property named `"description_yyds"` to a Json property also called `description_yyds`. 
# 5. do you know what is jackson?
```
<dependency>
<groupId>com.fasterxml.jackson.core</groupId>
<artifactId>jackson-databind</artifactId>
<version>2.13.3</version>
<scope>compile</scope>
</dependency>
```
Jackson is a class library that handles JSON and XML formatting. It is more efficient. Jackson is mainly used for JSON and Java object conversion in projects.

In this Maven dependency, it uses Jackson Databind. It provides a powerful and flexible way to read and write JSON data in Java.
# 6. What is spring-boot-stater?
- a. what dependecies in the below starter? do you know any starters?
```
<dependency>
<groupId>org.springframework.boot</groupId>
<artifactId>spring-boot-starter-web</artifactId>
</dependency>
```
spring-boot-starter is a collection of dependency management libraries provided by the Spring Boot framework. It is designed to make it easy to create production-ready, stand-alone Spring-based applications that can be run with minimal configuration.

This example uses `spring-boot-starter-web` dependency. It is a collection of pre-configured libraries that are required to develop web applications using Spring Boot.

Some other starters:
- `spring-boot-starter-data-jpa`
- `spring-boot-starter-security`
- `spring-boot-starter-actuator`
# 7. do you know `@RequestMapping(value = "/users", method = RequestMethod.POST)`? could you list CRUD by this style?
This is a Spring annotation used to map HTTP requests with the /users endpoint to a handler method that handles HTTP POST requests.
- `C` `@RequestMapping(value = "/users", method = RequestMethod.POST)`
- `R` `@RequestMapping(value = "/users", method = RequestMethod.GET)`
- `U` `@RequestMapping(value = "/users", method = RequestMethod.PUT)`
- `D` `@RequestMapping(value = "/users", method = RequestMethod.DELETE)`
# 8. What is ResponseEntity? why do we need it?
```
new ResponseEntity<>(postResponse, HttpStatus.OK);
new ResponseEntity<>(postResponse, HttpStatus.CREATED);
ResponseEntity.ok(postService.getPostById(id));
```
ResponseEntity is a class in the Spring Framework that represents an HTTP response to a client. It allows to specify the HTTP status code, headers, and body of the response, and is typically used to return responses from RESTful web services built using Spring.

Using ResponseEntity is useful when we need to customize the response sent back to the client beyond just returning the response body. 
# 9. What is ResultSet in jdbc? and describe the flow how to get data using JDBC
ResultSet is an interface in the JDBC API that represents a set of results from a database query. It provides methods to navigate through the results and access the data in each row.

There are 7 steps to use JDBC.
- Load the driver (select the database)
- Get a connection (establish a connection with the database)
- Prepare SQL
- Build a processing block (encapsulate and send SQL)
- Send SQL and get the result
- Processing results
- Connection closed
# 10. What is the ORM framework?
An ORM framework converts database types into object-oriented programming language types. It matches the Java entity class with the database field, and can quickly realize the encapsulation of the Java entity class field into the sql statement, and encapsulate the result set of the database query into the Java entity class, so as to complete the data usage.
# 12. What is the serialization and desrialization?
`Serialization` is the process of converting a data object—a combination of code and data represented within a region of data storage—into a series of bytes that saves the state of the object in an easily transmittable form.
The reverse process—constructing a data structure or object from a series of bytes—is deserialization. The `deserialization` process recreates the object, thus making the data easier to read and modify as a native structure in a programming language.
# 13. use stream api to get the average of the array [20, 3, 78, 9, 6, 53, 73, 99, 24, 32].