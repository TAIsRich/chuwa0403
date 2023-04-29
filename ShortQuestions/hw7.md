### 1. List all of the new annotations to your annotaitons.md and explain its role.
Please see annotation.md of hw4.

### 2. how do you do the debug?
Set breakpoints; Run the code in debug mode; Step into/over.

### 3. What is DTO, VO, Payload, DO, model?
DTO (Data Transfer Object): A DTO is a java object that is used to transfer data between different layers of an application or between multiple applications.

VO (View Object): A VO is similar to a DTO except it refers specifically to the transfer data to the UI.

Payload: In the context of web development, a payload typically refers to the data sent in an HTTP request or response body. Payload can be represented in different formats like JSON, XML.

DO (Domain Object): A DO is an object that represents a real-world entity or concept within the domain of the application. It contains both data and behavior, and is typically used to encapsulate business logic and represent the state of an entity in the application.

Model: In the Model-View-Controller (MVC) architecture, the model represents the domain objects and business logic of the application. In the context of object-relational mapping (ORM), the model represents the object-oriented representation of the database schema.

### 4. What is @JsonProperty("description_yyds")?
@JsonProperty annotation is used to map the properties of a java object to the recorrding JSON properties.
```
public class Person {
    @JsonProperty("user_id")
    private Long userId;

}
// When we serialize and deserialize a Person object to JSON, the "userId" in class will be mapped to "user_id" in JSON.
```

### 5. do you know what is jackson?
    <dependency>
      <groupId>com.fasterxml.jackson.core</groupId>
      <artifactId>jackson-databind</artifactId>
      <version>2.13.3</version>
      <scope>compile</scope>
    </dependency>
    
Jackson is a widely used open-source Java library to process JSON data. It provides serializing and deserializing tools for JSON data.

Key features:
Streaming API: Jackson provides a streaming API to work with JSON data more efficiently.
Data binding: Jackson can convert JSON data to and from Java objects.
Annotation: Jackson provides annotations to customize serialization and deserialization.
Tree Model: Jackson provides a tree model API to process JSON data as a tree of nodes.

### 6. What is spring-boot-stater?
    a. what dependecies in the below starter? do you know any starters?
        <dependency>
          <groupId>org.springframework.boot</groupId>
          <artifactId>spring-boot-starter-web</artifactId>
        </dependency>

spring-boot-starter is a set of dependencies which provide necessary libraries, configurations, and other resources required to start an application in Spring Boot.

spring-boot-starter-web provides necessary dependencies, such as Tomcat, Spring MVC, and other related libraries for creating web applications. 

Some commonly used starters:
spring-boot-starter-data-jpa
spring-boot-starter-test
spring-boot-starter-security
spring-boot-starter-actuator

### 7. do you know @RequestMapping(value = "/users", method = RequestMethod.POST) ? could you list CRUD by this style?
```
    @RequestMapping(value = "/users", method = RequestMethod.POST)
    public User createUser(@RequestBody User user) {
    }

    @RequestMapping(value = "/users/{id}", method = RequestMethod.GET)
    public User getUser(@PathVariable("id") Long id) {
    }

    @RequestMapping(value = "/users/{id}", method = RequestMethod.PUT)
    public User updateUser(@PathVariable("id") Long id, @RequestBody User user) {
    }

    @RequestMapping(value = "/users/{id}", method = RequestMethod.DELETE)
    public void deleteUser(@PathVariable("id") Long id) {
    }
```
### 8. What is ResponseEntity? why do we need it?
    1. new ResponseEntity<>(postResponse, HttpStatus.OK);
    2. new ResponseEntity<>(postResponse, HttpStatus.CREATED);
    3. ResponseEntity.ok(postService.getPostById(id));

ResponseEntity is a class provided by the Spring MVC framework to represent a HTTP response. It includes headers, response body, and status code. It allows developers to customize the returned response.

### 9. What is ResultSet in jdbc? and describe the flow how to get data using JDBC
ResultSet is an interface provided by JDBC to manipulate the query results of database.
```
Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/my_database","username","password");
        Statement statement=connection.createStatement();
        ResultSet resultSet=statement.executeQuery("SELECT * FROM users")
        while(resultSet.next()){
        int id=resultSet.getInt("id");
        String name=resultSet.getString("name");
        System.out.println("ID: "+id+", Name: "+name);
        }
        resultSet.close();
        statement.close();
        connection.close();
```

### 10. What is the ORM framework?
ORM (Object-Relational Mapping) is a programming technique that allows developers to map objects with the corresponding tables in a relational database.

### 11. Learn how to use ObjectMapper by this example.
    a. https://github.com/TAIsRich/chuwa-eij-tutorial/blob/main/02-java-core/src/main/java/com/chuwa/exercise/oa/api/FoodOutletJackson.java
    1. FoodOutlet foodOutlet = objectMapper.readValue(resBody, FoodOutlet.class);
    2. String s = objectMapper.writeValueAsString(foodOutlet);
    3. objectMapper.readTree() // learn how to use it?

### 12. What is the serialization and desrialization?
    a. https://hazelcast.com/glossary/serialization/
Serialization is the processes of converting data/an object into easily transmitted and stored format. Deserialization is the reverse process of serialization.

### 13. use stream api to get the average of the array [20, 3, 78, 9, 6, 53, 73, 99, 24, 32].
```
    int[] array = {20, 3, 78, 9, 6, 53, 73, 99, 24, 32};
    double ans = Arrays.stream(array).average();
```
### 14. 抄写 https://github.com/TAIsRich/springbootredbook/tree/03_post_pageable 你也可以像我⼀样分branch添加新代码。
### 15. (Optional) 抄写 https://github.com/TAIsRich/springboot-redbook/tree/04_comment 你也可以像我⼀样分branch添加新代码。
### 16. Try to write the CRUD api for a new application Cassandra-Blog
    a. spring 提供了相关 dependency,(https://start.spring.io/)
        i. Spring Data for Apache Cassandra
    b. Cassandra⼗分流⾏，且⾯试问的多。