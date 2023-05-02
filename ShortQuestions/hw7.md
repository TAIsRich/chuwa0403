# HW7
## 1.  List all the new annotations to your annotations.md and explain its role.
See annotations.md
## 2.  how do you do the debug?
General steps to debug:
1. Reproduce the problem:   
Reproduce the bug by running the code and testing it in the same way that caused it
2. Identify the problem:   
Identify the root cause of the problem. This may involve examining error messages, reviewing the code, or using a debugger to step through the code.
3. Fix the problem:   
This may involve modifying the code, changing a configuration setting, or updating a library or framework.
4. Test the fix:   
Then it's important to test the program again to make sure that the problem has been resolved and that no new problems have been introduced.
5. Repeat:   
Debugging is often an iterative process, and it may be necessary to repeat these steps several times before the problem is completely resolved.

Techniques that can be used to debug:
1. Print statements:   
Adding print statements to the code can help to identify where the code is executing and what values are being used at each step.
2. Logging:  
It's used to record information about the program's execution, including error messages and variable values.
3. Debugger:  
This is a tool that allows developers to step through the code and examine variable values and other program state at each step.
4. Unit testing:   
It can help to identify problems before they are introduced into the codebase.
5. Code review:   
It can help to identify potential issues and suggest improvements.

## 3.  What is DTO, VO, Payload, DO, model?
- DTO: Data Transfer Object  
It is used to transfer data between layers or modules of an application.   
A DTO typically includes only the data that needs to be transferred and does not include any behavior or logic.

- VO: Value Object
A VO is an object that encapsulates a single value or a set of related values that are treated as a single unit.   
VOs are often used to represent immutable data, such as dates, currency amounts, or other domain-specific concepts.   
Unlike DTOs, VOs may contain behavior, and they are typically designed to be used within the business logic layer of an application.

- Payload is used to describe the data that is sent or received in a message or API request.   
It can be in any format, such as JSON, XML, or binary.

- DO: Domain Object  
It is a data structure that represents an entity or concept in the domain of the application. A DO can include behavior or logic related to the entity it represents.

- Model is a generic term used to describe any data structure used to represent data in an application. It can refer to any of the above patterns, or other patterns such as Active Record or Entity-Relationship models.  

[userful link](https://zhuanlan.zhihu.com/p/102389552)


## 4.  What is @JsonProperty("description_yyds")
`@JsonProperty("description_yyds")` is a Jackson annotation used in Java to map a JSON property to a Java class field during serialization or deserialization.
```aidl
public class ExampleClass {
    @JsonProperty("description_yyds")
    private String description;
}
```
## 5.  What is jackson?
Jackson is a Java library for working with JSON data. It provides a set of tools for converting JSON data to and from Java objects, manipulating JSON data, and validating JSON data against schemas.   

Jackson provides annotations that can be used to customize the serialization and deserialization of Java objects to JSON and vice versa.  
Besides, Jackson provides utilities for working with JSON data, such as filtering, transforming, and manipulating JSON data.

## 6.  What is spring-boot-starter?
`spring-boot-starter` is a set of dependencies in the Spring Boot framework that provides a convenient way to include commonly used libraries and frameworks together in a Spring Boot application without causing any compatability issue.
 
a. what dependencies in the below starter? do you know any starters?
```aidl
<dependency>
   <groupId>org.springframework.boot</groupId>
   <artifactId>spring-boot-starter-web</artifactId>
</dependency>
```
It uses `spring-boot-starter-web` which includes the necessary dependencies for creating a web application, such as Spring MVC, Tomcat, and other required libraries.
There are also starters like `spring-boot-starter-security`, `spring-boot-starter-data-jpa`

## 7. Do you know  @RequestMapping(value = "/users", method = RequestMethod.POST) ? could you list CRUD by this style?
This annotation maps requests with the URL path `/users` and HTTP method POST to the method in the controller class that has this annotation
- `@RequestMapping(value = "/{id}", method = RequestMethod.GET)`
- `@RequestMapping(value = "/{id}", method = RequestMethod.POST)`
- `@RequestMapping(value = "/{id}", method = RequestMethod.PUT)`
- `@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)`

## 8.  What is ResponseEntity? why do we need it?
It is a utility class provided by Spring. With it, we can customize the response including the status code, header and body.  

The ResponseEntity class provides a convenient way to set the HTTP status code, headers, and body of the response in a single object, rather than having to set each of these properties separately. It also allows you to specify the exact type of the response body, using generics.
Reasons:  
- To return a custom HTTP status code: By default, Spring returns a 200 (OK) status code for successful requests, but you can use ResponseEntity to set a different status code, such as 201 (Created) or 204 (No Content). 
- To include custom headers in the response: With it we can customize header, such as Content-Type or Cache-Control. 
- To return a specific type of response body: ResponseEntity allows you to specify the exact type of the response body, using generics. This is particularly useful when you need to return complex objects that are not automatically serialized to JSON by Spring.

## 9.  What is ResultSet in jdbc? and describe the flow how to get data using JDBC
`ResultSet` is an interface in the JDBC to represent a set of results from a database query.   
When executing a query using JDBC, the database returns a `ResultSet` object that contains the results of the query. You can then use the methods provided by the `ResultSet` interface to iterate over the results and retrieve the data.


Flow of getting from a database using JDBC:
- Load the JDBC driver:   
Load the JDBC driver for the database you want to connect to using the `Class.forName()` method, which loads the driver class into memory.
- Establish a connection to the database:   
Establish a connection to the database using the `DriverManager.getConnection()` method.   
This method takes a URL string that identifies the database, as well as a username and password if required.

- Create a statement: 
Using the `Connection.createStatement()` method to create a statement. This object represents a SQL statement that you can execute against the database.

- Execute the query: 
Call the `Statement.executeQuery()` method with a SQL SELECT statement to execute a query. This returns a `ResultSet` object that contains the results of the query.

- Process the results:   
Use the methods provided by the `ResultSet` interface to iterate over the results and retrieve the data.   
The `ResultSet.next()` method moves the cursor to the next row in the result set, and you can use methods such as `getInt()`, `getString()`, or `getTimestamp()` to retrieve the data from each column in the row.

- Close the resources: Close the ResultSet, Statement, and Connection objects to release any resources they hold and avoid potential memory leaks.

## 10. What is the ORM framework?
Object relational mapping  
It is a technique that maps relational databases to java classes  
It makes the database operations more object-oriented.

## 11. Learn how to use ObjectMapper by this example.
```aidl
FoodOutlet foodOutlet = objectMapper.readValue(resBody, FoodOutlet.class);
String s = objectMapper.writeValueAsString(foodOutlet);
objectMapper.readTree()
```
Jackson library's ObjectMapper class provides methods for reading, writing and manipulating JSON data.    
- `objectMapper.readValue(resBody, FoodOutlet.class)`: It reads JSON data from the `resBody` string and maps it to a `FoodOutlet` object.   
The `readValue()` method is to **deserialize** JSON data into Java objects.

- `objectMapper.writeValueAsString(foodOutlet)`: It serializes the `foodOutlet` object to a JSON string.   
The `writeValueAsString()` method is used to **serialize** Java objects into JSON data.

- `objectMapper.readTree(jsonString)`: It reads JSON data from the `jsonString` string and returns a JsonNode object representing the root node of the JSON tree.   
The `readTree()` method is used when you want to **parse JSON data without mapping it to a specific Java class**.   
This is useful when you need to manipulate the JSON data programmatically or when the JSON structure is not known at compile time.

## 12. What is the serialization and deserialization?
- Serialization is the process of converting an object from its in-memory representation to a stream of bytes, so that it can be stored in a file, sent over a network, or otherwise transferred between different systems.   
In the context of Java, serialization typically involves converting an object to a stream of bytes using the `java.io.Serializable` interface and the `ObjectOutputStream` class.

- Deserialization is the reverse process of serialization, it involves taking a stream of bytes that represents an object and reconstructing the object in memory.   
In Java, deserialization is typically done using the `java.io.Serializable` interface and the `ObjectInputStream` class.


## 13. Use stream api to get the average of the array [20, 3, 78, 9, 6, 53, 73, 99, 24, 32]
```aidl
int[] array = {20, 3, 78, 9, 6, 53, 73, 99, 24, 32};
double average = Arrays.stream(array)
                       .average()
                       .orElse(Double.NaN);
// IntStream.average() returns an OptionalDouble which may not contain a value and which needs a special handling.
```
## 14. 抄写，https://github.com/TAIsRich/springboot-
    redbook/tree/03_post_pageable，你也可以像我一样分branch添加新代码。
## 15. (Optional) 抄写 https://github.com/TAIsRich/springboot-redbook/tree/04_comm
    ent你也可以像我一样分branch添加新代码。
## 16. Try to write the CRUD api for a new application Cassandra-Blog
    a. spring 提供了相关dependency,(https://start.spring.io/)
    i.  Spring Data for Apache Cassandra
    b. Cassandra十分流行，且面试问的多。






