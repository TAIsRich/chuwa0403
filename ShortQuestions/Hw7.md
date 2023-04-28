# Homework 7
## 1. 
See [annotations.md](./annotations.md)

## 2. how do you do the debug?
1. Add break point;
2. Run the debug mode;
3. Run code step by step;
4. Inspect the variable.

## 3. What is DTO, VO, Payload, DO, model?
* Dto represenst the data transfer object, it is used to filter information from the entity. Also, it is used to pass through business logics. It is only a data container
* Payload is the requestbody and responsebody. It is sent between the client and server through http request and response 
* VO reprents value object that holds values. It has business logic and can be used to represent a domain concept.
* DO is data object: A domain object is a developer-defined data type, an immutable Java class encapsulating a scalar value or a structure, with simple validation built into its constructor. The validation check occurs when an object of that domain type is created.
* Model: A model is used to represent the data and behavior of application's domain concepts. A model can have different type of objects, like VO, DTO, DO.

## 4. What is @JsonProperty("description_yyds")
@JsonProperty is used to transfer the name of a modified variable to another name during serilization and deserializatin between JSON and a Java object. In this example, it mark a properties in a class to " description_yyds ";

## 5. do you know what is jackson?
Jackson is a very popular and efficient java based library to serialize or map java objects to JSON and vice versa.

## 6. What is spring-boot-stater?
spring-boot-stater is a set of convenient dependency descriptors that you can include in your application. You get a one-stop–shop for all the Spring and related technologies that you need without having to hunt through sample code and copy-paste loads of dependency descriptors. 

spring-boot-starter-web is used for building the web application, including RESTful applications using Spring MVC. It uses Tomcat as the default embedded container. It includes the necessary dependencies for building web applications with Spring Boot, such as the Spring Web MVC framework, Tomcat embedded server, and Jackson JSON processing libraries.

## 7. do you know  @RequestMapping(value = "/users", method = RequestMethod.POST) ? could you list CRUD by this style?
```
@RequestMapping(value = "/users/{id}", method = RequestMethod.GET)
@RequestMapping(value = "/users/{id}", method = RequestMethod.PUT)
@RequestMapping(value = "/users/{id}", method = RequestMethod.DELETE)
@RequestMapping(value = "/users", method = RequestMethod.POST)
```
