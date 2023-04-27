## 1. List all of the new annotations to your annotaitons.md and explain its role.
check annotations.md

## 2. how do you do the debug?
```
1. use system.out.println() to print variable
2. use breakpoint in idea and inspect variables
```

## 3. What is DTO, VO, Payload, DO, model?

DTO: A DTO is an object that carries data between processes in a distributed system. It is a simple container object that typically contains fields for data, along with getter and setter methods for accessing the data.

VO: A VO is an object that contains data that is usually derived from the underlying data model. It is often used to represent a view of data, and typically does not have any behavior.

Payload: A Payload is the data carried by a request or response, typically used in web development. It may contain JSON, XML, or other formats.

DO: A DO is an object that represents a domain entity, such as a user, order, or product. It typically contains data fields, along with business logic methods.

Model: In Java, Model refers to the classes that represent the data in an application. These classes are often used in MVC architecture to represent the data and provide methods for manipulating and accessing the data.

## 4. What is `@JsonProperty("description_yyds")` (不会的话，课上问)?
   
In JSON, the property key is represented as a string. By default, Jackson uses the name of the Java class field as the key when mapping between JSON and Java objects. However, sometimes the JSON property name is different from the Java class field name, so `@JsonProperty` allows us to explicitly specify the JSON property name that should be used when mapping.

In this specific example, the JSON property name is "description_yyds", and the annotation specifies that it should be mapped to a Java class field.


## 5. do you know what is jackson?
   
```
<dependency>
    <groupId>com.fasterxml.jackson.core</groupId>
        <artifactId>jackson-databind</artifactId>
        <version>2.13.3</version>
    <scope>compile</scope>
</dependency>
```

Jackson is a popular open-source JSON parsing and serialization library for Java. It is used to convert Java objects to JSON format and vice versa. Jackson provides a simple and efficient way to handle JSON data and supports various data formats such as XML, YAML, and CSV. It can be used in various types of applications such as web applications, mobile applications, and enterprise software. Jackson is widely used in the Java ecosystem and is supported by many frameworks such as Spring, Hibernate, and JAX-RS.


## 6. What is spring-boot-starter?
    a. what dependecies in the below starter? do you know any starters?

```
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-web</artifactId>
</dependency>
```

spring-boot-starter is a set of convenient dependency descriptors that you can include in your Spring Boot application. It provides a pre-defined set of starter dependencies, which can be added to your project's classpath to enable specific Spring Boot features and technologies. These starter dependencies make it easier to get started with Spring Boot by reducing the amount of configuration required to integrate various Spring technologies into your application.

The `spring-boot-starter-web` dependency in Maven/Gradle provides a set of dependencies for building web applications with Spring. Some of the dependencies included in this starter are:

`spring-boot-starter`: Core Spring Boot starter, which includes auto-configuration support, logging, and YAML support.
`spring-boot-starter-web`: Starter for building web, including Spring MVC, REST, Tomcat, and Jackson.
`spring-webmvc`: Spring Web MVC, which provides an implementation of the Model-View-Controller (MVC) pattern for building web applications.
`spring-web`: Spring Web, which provides basic web-related functionality such as client-side HTTP access and WebSocket communication.
`jackson-databind`: The Jackson data binding library, which is used to convert Java objects to and from JSON.
`tomcat-embed-core`: An embedded version of the Tomcat web server.
`tomcat-embed-jasper`: Tomcat's JSP engine, used for rendering JSP pages.
`tomcat-embed-el`: Tomcat's implementation of the Expression Language (EL) specification, used for evaluating JSP expressions.



## 7. do you know `@RequestMapping(value = "/users", method = RequestMethod.POST)` ? could you list CRUD by this style?
   
`@RequestMapping(value = "/users", method = RequestMethod.POST)` is a Spring annotation used to handle HTTP POST requests for the /users endpoint.

Here are the corresponding CRUD operations that can be implemented using the @RequestMapping annotation:

Create: `@RequestMapping(value = "/users", method = RequestMethod.POST)` - to create a new user
Read: `@RequestMapping(value = "/users/{id}", method = RequestMethod.GET)` - to get the details of a specific user with ID id
Update: `@RequestMapping(value = "/users/{id}", method = RequestMethod.PUT)` - to update the details of a specific user with ID id
Delete: `@RequestMapping(value = "/users/{id}", method = RequestMethod.DELETE)` - to delete a specific user with ID id

## 8. What is `ResponseEntity`? why do we need it?
```java
new ResponseEntity<>(postResponse, HttpStatus.OK);
new ResponseEntity<>(postResponse,
HttpStatus.CREATED);
ResponseEntity.ok(postService.getPostById(id));
```
`ResponseEntity` is a class in Spring Framework that represents the entire HTTP response, including the body, status code, and headers. It is used to build and send HTTP responses to clients from a Spring Controller.

The main advantage of using `ResponseEntity` is that it provides flexibility to customize the HTTP response returned from the server. For example, we can set the HTTP status code, add headers, and return different types of responses, such as JSON or XML data.

Some common scenarios where `ResponseEntity` can be used are:

When we want to return a custom HTTP status code from the server.
When we want to add custom headers to the HTTP response.
When we want to return a response in a different format, such as JSON or XML.

```java
@RequestMapping(value = "/users", method = RequestMethod.POST)
public ResponseEntity<User> createUser(@RequestBody User user) {
    // code to create a new user
    return new ResponseEntity<User>(user, HttpStatus.CREATED);
}

@RequestMapping(value = "/users/{id}", method = RequestMethod.GET)
public ResponseEntity<User> getUser(@PathVariable("id") Long id) {
    // code to get a user by id
    return new ResponseEntity<User>(user, HttpStatus.OK);
}

@RequestMapping(value = "/users/{id}", method = RequestMethod.PUT)
public ResponseEntity<User> updateUser(@PathVariable("id") Long id, @RequestBody User user) {
    // code to update a user by id
    return new ResponseEntity<User>(user, HttpStatus.OK);
}

@RequestMapping(value = "/users/{id}", method = RequestMethod.DELETE)
public ResponseEntity<Void> deleteUser(@PathVariable("id") Long id) {
    // code to delete a user by id
    return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
}
```


## 9.  What is ResultSet in jdbc? and describe the flow how to get data using JDBC
    
`ResultSet` is an interface in JDBC that provides methods to retrieve and process the results of a database query.

Here is a simple flow of how to get data using JDBC:

`Load the JDBC driver`: First, we need to load the JDBC driver for the database we want to connect to. This is typically done using the `Class.forName()` method.

`Create a connection`: Once the driver is loaded, we can create a connection to the database using the `DriverManager.getConnection()` method. We need to pass in the URL of the database, the username, and password to establish the connection.

`Create a statement`: With a connection established, we can create a Statement object using the `connection.createStatement()` method. The Statement object represents the SQL statement that we want to execute on the database.

`Execute the query`: We can execute the SQL statement using the `statement.executeQuery()` method. This method returns a ResultSet object that represents the data retrieved from the database.

`Process the results`: We can use various methods of the ResultSet interface to access and process the data retrieved from the database. For example, we can use the `resultSet.next()` method to move the cursor to the next row of the ResultSet, and use the `resultSet.getString()` method to retrieve a specific column value.

`Close the connection`: Once we have processed the results, we should close the ResultSet, Statement, and Connection objects to free up resources and prevent memory leaks.

## 10. What is the ORM framework?
    
ORM (Object-Relational Mapping) is a programming technique that enables conversion of data between incompatible type systems using object-oriented programming languages. It provides a way to map an object-oriented domain model to a relational database. This means that developers can use high-level object-oriented constructs and concepts, such as classes and inheritance, to manipulate database data, instead of having to use low-level SQL statements.

ORM frameworks provide a higher level of abstraction over database access, allowing developers to focus on business logic rather than database management. They also provide features such as caching, transaction management, and security that can simplify the development process and improve application performance.

Some popular ORM frameworks in Java include Hibernate, EclipseLink, and MyBatis.

## 11. Learn how to use ObjectMapper by this example.
    a. https://github.com/TAIsRich/chuwa-eij-tutorial/blob/main/02-java-core/src/main/java/com/chuwa/exercise/oa/api/FoodOutletJackson.java

```java
FoodOutlet foodOutlet = objectMapper.readValue(resBody, FoodOutlet.class);
String s = objectMapper.writeValueAsString(foodOutlet);
objectMapper.readTree(); // learn how to use it?
```
check folder Coding/hw7_ObjectMapper


## 12. What is the serialization and desrialization?
    a. https://hazelcast.com/glossary/serialization/

Serialization is the process of converting an object into a format that can be stored or transmitted across a network, typically as a sequence of bytes. This is useful for sending objects between different applications or over a network.

Deserialization is the process of converting the serialized data back into an object. This is necessary in order to use the data in the application.

In Java, serialization and deserialization can be done using the ObjectInputStream and ObjectOutputStream classes. Many frameworks, such as Jackson and Gson, also provide built-in serialization and deserialization functionality.

## 13.  use stream api to get the average of the array [20, 3, 78, 9, 6, 53, 73, 99, 24, 32].

```java
        int[] arr = new int[]{20, 3, 78, 9, 6, 53, 73, 99, 24, 32};
        double ans = (Arrays.stream(arr).average().orElse(Double.NaN));
        System.out.println(ans);
```

## 14.  抄写，https://github.com/TAIsRich/springboot-redbook/tree/03_post_pageable，你也可以像我⼀样分branch添加新代码。
    
check folder Coding/hw7_14_spring_pagable


## 15.  (Optional) 抄写 https://github.com/TAIsRich/springboot-redbook/tree/04_comment 你也可以像我⼀样分branch添加新代码。



## 16.  Try to write the CRUD api for a new application Cassandra-Blog
    a. spring 提供了相关dependency,(https://start.spring.io/)
        i. Spring Data for Apache Cassandra
    b. Cassandra⼗分流⾏，且⾯试问的多。

check folder Coding/hw7_Cassandra



