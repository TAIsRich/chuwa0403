# HW7

*Claudia Feng Apr 28, 2023*



1. **List all of the new annotations to your annotations.md and explain its role.**

   See annotations.md.

   

2. **how do you do the debug?**

   Use IDE debug functionality.



3. **What is DTO, VO, Payload, DO, model?**

1. DTO (Data Transfer Object): A DTO is an object used to transfer data between different layers or subsystems within an application, such as between the service and presentation layers. DTOs are typically simple, lightweight, and serializable, containing only the necessary data attributes without any business logic or behavior. They are used to reduce the number of method calls or remote invocations by aggregating multiple pieces of data into a single object.

2. VO (Value Object): A Value Object is an immutable object that represents a specific value or a set of related values. It does not have an identity, meaning that two instances of a Value Object are considered equal if their values are the same. Value Objects are often used to represent domain concepts that have no identity, such as colors, dates, or coordinates. They help improve code readability and maintainability by encapsulating the logic related to specific values.

3. Payload: In the context of web services and APIs, the payload refers to the data transmitted between the client and the server. It can be part of an HTTP request or response, a message in a message queue, or a packet in a network protocol. Payloads typically include the actual data being sent (e.g., a JSON object or an XML document), as well as metadata, such as headers or tokens.

4. DO (Domain Object): A Domain Object represents a key concept in a business domain and encapsulates the data, behavior, and relationships associated with that concept. Domain Objects are part of the domain model, which is used to describe the problem domain in a software application. They help ensure that the business rules and logic are captured accurately and consistently across the application. Examples of Domain Objects include entities like User, Product, or Order.

5. Model: In software development, a model often refers to the representation of data and business logic in an application. Models can include various types of objects, such as Domain Objects, Value Objects, or Data Transfer Objects, depending on the specific design and architecture of the application.

   

4. **What is @JsonProperty("description_yyds") ?**

This annotation is used to define custom mappings between JSON property names and the fields of Java objects during serialization (converting a Java object into JSON) and deserialization (converting JSON into a Java object). By default, Jackson uses the field names of the Java objects, but sometimes, the JSON property names might differ from the field names or follow different naming conventions.



5. **do you know what is jackson?**

```java
<dependency>
  <groupId>com.fasterxml.jackson.core</groupId>
  <artifactId>jackson-databind</artifactId>
  <version>2.13.3</version>
  <scope>compile</scope>
</dependency>
```

​	Jackson is a library for converting java objects to JSON and vice versa.



6. **What is spring-boot-starter?**

​	a. what dependecies in the below starter? do you know any starters?

```java
<dependency>
   <groupId>org.springframework.boot</groupId>
   <artifactId>spring-boot-starter-web</artifactId>
</dependency>
```

Spring Boot starters allow developers to quickly set up a Spring Boot project by providing a set of predefined configurations and dependencies. 

The `spring-boot-starter-web` dependency is a starter for building web applications using Spring Boot. It includes several dependencies that are commonly used for web development with Spring:

1. `spring-web`: Provides core web functionalities like web request and response handling, and contains Servlet and WebFlux (Reactive web) support.

2. `spring-webmvc`: Provides the Spring MVC framework, which is built on top of `spring-web` and offers a way to develop web applications using the Model-View-Controller architecture.

3. `spring-boot-starter-json`: A starter for JSON support, including Jackson for JSON parsing and serialization.

4. `spring-boot-starter-tomcat`: The embedded Tomcat server for running your web application. By default, Spring Boot uses Tomcat as the embedded server, but you can switch to other servers like Jetty or Undertow if needed.

   

7. **do you know @RequestMapping(value = "/users", method = RequestMethod.POST) ? could you list CRUD by this style?**

```java
@RequestMapping(value = "/users", method = RequestMethod.POST)
public ResponseEntity<User> createUser(@RequestBody User user) {
    // Create a new user and return the created user with a 201 Created status
}
```

```java
@RequestMapping(value = "/users/{id}", method = RequestMethod.GET)
public ResponseEntity<User> getUser(@PathVariable("id") Long id) {
    // Retrieve and return the user with the specified ID, or a 404 Not Found status if not found
}
```

```java
@RequestMapping(value = "/users/{id}", method = RequestMethod.PUT)
public ResponseEntity<User> updateUser(@PathVariable("id") Long id, @RequestBody User updatedUser) {
    // Update the user with the specified ID and return the updated user, or a 404 Not Found status if not found
}
```

```java
@RequestMapping(value = "/users/{id}", method = RequestMethod.DELETE)
public ResponseEntity<Void> deleteUser(@PathVariable("id") Long id) {
    // Delete the user with the specified ID and return a 204 No Content status
}
```



8. **What is ResponseEntity? why do we need it?**

```java
new ResponseEntity<>(postResponse, HttpStatus.OK); 2 new ResponseEntity<>(postResponse,
HttpStatus.CREATED);
3 ResponseEntity.ok(postService.getPostById(id));
```

`ResponseEntity` represents the whole HTTP response, including the status code, headers, and body. 

We need `ResponseEntity` for several reasons:

1. Flexibility: It allows developers to have fine-grained control over the HTTP response sent back to the client. You can set custom status codes, headers, and a response body as needed.
2. Readability: By using `ResponseEntity`, you can create more expressive and self-explanatory code. The class encapsulates the different parts of an HTTP response, making it easier to understand the intent of the code at a glance.
3. Type safety: `ResponseEntity` is a generic class, allowing you to specify the type of the response body. This helps ensure type safety and can prevent potential issues related to incorrect data types.
4. Interoperability: Since it adheres to the HTTP standard, using `ResponseEntity` makes your application more interoperable with other systems and clients that also follow the standard.
5. Error handling: `ResponseEntity` can be used to handle different types of errors and exceptions in a consistent and centralized way. It makes it easier to manage error responses and ensure that clients receive meaningful information about the error.



9. **What is `ResultSet` in jdbc? and describe the flow how to get data using JDBC**

`ResultSet` is a Java interface in the `java.sql` package used in JDBC (Java Database Connectivity) to represent the result set of a query. It provides a way to retrieve and manipulate data obtained from a database after executing an SQL statement, such as a SELECT query.

The flow to get data using JDBC:

1. establishing a connection

2. creating a prepared statement or query

3. execute the query

4. looping through the result set to get the objects

5. close the connection

   

10. **What is the ORM framework?**

An ORM framework is a software library that facilitates the conversion of data between incompatible systems, specifically between object-oriented programming languages and relational databases. It aims to simplify the process of persisting application data in a relational database by abstracting the underlying database complexities.



11. **Learn how to use ObjectMapper by this example.**

​	a. https://github.com/TAIsRich/chuwa-eij-tutorial/blob/main/02-java-core/src/main/java/com/chuwa/exercise/oa/api/FoodOutletJackson.java

```java
1 FoodOutlet foodOutlet = objectMapper.readValue(resBody, FoodOutlet.class);
2 String s = objectMapper.writeValueAsString(foodOutlet);
3 objectMapper.readTree() // learn how to use it?
```



12. **What is the serialization and desrialization?**
     a. https://hazelcast.com/glossary/serialization/

**Serialization** is the process of converting a data object—a combination of code and data represented within a region of data storage—into a series of bytes that saves the state of the object in an easily transmittable form.

The reverse process—constructing a data structure or object from a series of bytes—is **deserialization**. The deserialization process recreates the object, thus making the data easier to read and modify as a native structure in a programming language.



13. **use stream api to get the average of the array [20, 3, 78, 9, 6, 53, 73, 99, 24, 32].**

```java
int[] array = {20, 3, 78, 9, 6, 53, 73, 99, 24, 32};

Arrays.stream(array).average().ifPresent(System.out::println);
```



14. **抄写，https://github.com/TAIsRich/springboot-redbook/tree/03_post_pageable，你也可以像我一样分branch添加新代码。**



15. **(Optional) 抄写 https://github.com/TAIsRich/springboot-redbook/tree/04_comment你也可以像我一样分branch添加新代码。**



16. **Try to write the CRUD api for a new application Cassandra-Blog**

​	**a. spring 提供了相关dependency,(https://start.spring.io/) i. Spring Data for Apache Cassandra**

​	**b. Cassandra十分流行，且面试问的多。**