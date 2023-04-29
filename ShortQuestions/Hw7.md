# Homework 7

## 1.

See [annotations.md](./annotations.md)

## 2. how do you do the debug?

1. Add break point;
2. Run the debug mode;
3. Run code step by step;
4. Inspect the variable.

## 3. What is DTO, VO, Payload, DO, model?

- Dto represenst the data transfer object, it is used to filter information from the entity. Also, it is used to pass through business logics. It is only a data container
- Payload is the requestbody and responsebody. It is sent between the client and server through http request and response
- VO reprents value object that holds values. It has business logic and can be used to represent a domain concept.
- DO is data object: A domain object is a developer-defined data type, an immutable Java class encapsulating a scalar value or a structure, with simple validation built into its constructor. The validation check occurs when an object of that domain type is created.
- Model: A model is used to represent the data and behavior of application's domain concepts. A model can have different type of objects, like VO, DTO, DO.

## 4. What is @JsonProperty("description_yyds")

@JsonProperty is used to transfer the name of a modified variable to another name during serilization and deserializatin between JSON and a Java object. In this example, it mark a properties in a class to " description_yyds ";

## 5. do you know what is jackson?

Jackson is a very popular and efficient java based library to serialize or map java objects to JSON and vice versa.

## 6. What is spring-boot-stater?

spring-boot-stater is a set of convenient dependency descriptors that you can include in your application. You get a one-stop–shop for all the Spring and related technologies that you need without having to hunt through sample code and copy-paste loads of dependency descriptors.

spring-boot-starter-web is used for building the web application, including RESTful applications using Spring MVC. It uses Tomcat as the default embedded container. It includes the necessary dependencies for building web applications with Spring Boot, such as the Spring Web MVC framework, Tomcat embedded server, and Jackson JSON processing libraries.

## 7. do you know @RequestMapping(value = "/users", method = RequestMethod.POST) ? could you list CRUD by this style?

```
@RequestMapping(value = "/users/{id}", method = RequestMethod.GET)
@RequestMapping(value = "/users/{id}", method = RequestMethod.PUT)
@RequestMapping(value = "/users/{id}", method = RequestMethod.DELETE)
@RequestMapping(value = "/users", method = RequestMethod.POST)
```

## 8. What is ResponseEntity? why do we need it?

ResponseEntity is an extension of HttpEntity that represents an HTTP response including status, headers and body. ResponseEntity allows you to modify the response with optional headers and status code. We can use it to fully configure the HTTP response.

## 9. What is ResultSet in jdbc? and describe the flow how to get data using JDBC

Result set is an interface representing the result set of a database query.

The flow works like:

1.  establishing a connection
2.  creating a prepared statement or query
3.  execute the query
4.  looping through the result set to get the objects
5.  close the connection

## 10. What is the ORM framework?

Object-relational mapping (ORM) is a way to align programming code with database structures. ORM uses metadata descriptors to create a layer between the programming language and a relational database.

A simple answer is that you wrap your tables or stored procedures in classes in your programming language, so that instead of writing SQL statements to interact with your database, you use methods and properties of objects.

## 11.

See [objectmapper](./../Coding/hw7/objectmapper);

## 12. What is the serialization and desrialization?

Serialization is the process of converting a data object—a combination of code and data represented within a region of data storage—into a series of bytes that saves the state of the object in an easily transmittable form.

The reverse process—constructing a data structure or object from a series of bytes—is deserialization. The deserialization process recreates the object, thus making the data easier to read and modify as a native structure in a programming language.

## 13.

See [objectmapper](./../Coding/hw7/streamapi);

## 14.

See [redbook](./../Coding/redbook);

## 15.

See [redbook](./../Coding/redbook);

## 16.

See [cassandra blog](./../Coding/Cassandra-Blog);
