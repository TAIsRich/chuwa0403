## 1. List all of the new annotations to your annotaitons.md and explain its role.
 
 Check ShortQuetions/annotations.md
 
 ## 2. how do you do the debug?
 
1，Open the Java file containing the code you want to debug in your IDE.

2，Locate the line of code where I want to set the breakpoint.

3，Click on the left-hand margin of the editor window, next to the line of code. This will create a red dot, indicating a breakpoint has been set.

4，Start the debugger by clicking the Debug button or selecting Debug from the Run menu.

5，Once the debugger is running, execute the application normally. When the code execution reaches the line of code where the breakpoint is set, it will pause and switch to the debug perspective.

6，In the debug perspective, I can examine the current state of variables, step through the code line-by-line, and even change the value of variables to test different scenarios.

7，To continue execution, click the Resume button or select Resume from the Run menu.

8，When I am finished debugging, stop the debugger by clicking the Terminate button or selecting Terminate from the Run menu.
 
 
 ## 3. What is DTO, VO, Payload, DO, model?
 
**DTO (Data Transfer Object):** A DTO is a simple container for data that is used to transfer data between different layers of an application or between different applications. A DTO typically contains only data and no business logic. It is used to reduce the number of calls between client and server, reduce network traffic, and simplify the code.

**VO (Value Object):** A VO is a type of object that represents a value or a set of values. It is similar to a DTO in that it is a simple container for data, but it is typically used within a single application or module rather than between different applications.

**Payload:** A payload is the data that is carried by a message or transmitted over a network. In web development, a payload typically refers to the data that is sent in a request or response body in JSON or XML format.

**DO (Domain Object):** A DO is an object that represents a real-world entity or concept within the domain of the application. It contains both data and behavior, and is typically used to encapsulate business logic and represent the state of an entity in the application.

**Model:** The term "model" can refer to different things depending on the context. In the Model-View-Controller (MVC) architecture, the model represents the domain objects and business logic of the application. In the context of object-relational mapping (ORM), the model represents the object-oriented representation of the database schema. In general, a model can be any object or set of objects that represents some aspect of the application domain.
 ## 4. What is @JsonProperty("description_yyds") (不会的话，课上问)?
 
@JsonProperty is a Java annotation used to specify the name of a JSON property for a field in a Java object. When using a Java object to convert data to JSON format, these annotations on the fields tell the serialization process to map the Java field to the specified JSON property. Using the @JsonProperty annotation, you can control the name and order of properties during the serialization and deserialization process.

```java
public class Person {
  @JsonProperty("first_name")
  private String firstName;
  // other fields and methods
}
When converting a Person object to JSON format, the "firstName" field will map to the "first_name" property:
{
  "first_name": "John",
  // other properties
}
```

## 5. do you know what is jackson?

Jackson is a popular Java library used for serializing and deserializing Java objects to and from JSON format. It provides a set of simple and easy-to-use APIs for reading and writing JSON data. The core component of the Jackson library is jackson-databind, which provides functionality for object-to-JSON conversion and JSON-to-object conversion. With Jackson, you can easily map JSON data to Java objects and vice versa. Jackson is widely used in web development and is supported by many popular frameworks such as Spring and JAX-RS.

Java class
```java
public class Person {
    private String name;
    private int age;
    private String email;
    
    public Person(String name, int age, String email) {
        this.name = name;
        this.age = age;
        this.email = email;
    }
    
    // getters and setters
}
```
To serialize an instance of the Person class to JSON format, we can use the ObjectMapper class provided by Jackson:
```java
import com.fasterxml.jackson.databind.ObjectMapper;

public class Main {
    public static void main(String[] args) throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        Person person = new Person("John Doe", 25, "john.doe@example.com");
        String json = mapper.writeValueAsString(person);
        System.out.println(json);
    }
}
```
This code creates an instance of the ObjectMapper class and uses it to serialize the person object to a JSON string. The resulting JSON string would look something like this:
```java
{
    "name": "John Doe",
    "age": 25,
    "email": "john.doe@example.com"
}
```
## 6. What is spring-boot-stater?

spring-boot-starter is a set of dependencies that are bundled together in a convenient way to provide a specific functionality in a Spring Boot application. These dependencies include all the necessary libraries, configurations, and other resources required to get started with a specific feature in Spring Boot, such as web applications, data access, security, and more.

For example, if you want to build a Spring Boot web application, you can use the spring-boot-starter-web dependency, which includes the necessary dependencies for building a web application, such as Tomcat, Spring MVC, and other related libraries. Similarly, if you want to build a Spring Boot application that interacts with a relational database, you can use the spring-boot-starter-data-jpa dependency, which includes the necessary dependencies for using the Java Persistence API (JPA) and Hibernate for data access.

*The spring-boot-starter-web dependency includes the following dependencies:*

1，**spring-boot-starter**

2，**spring-boot-starter-json**

3，**spring-boot-starter-tomcat**

4，**spring-web**

5，**spring-webmvc**

*Some other starters provided by Spring Boot are:*

**spring-boot-starter-data-jpa:** Includes the Spring Data JPA, Hibernate, and a JDBC driver.

**spring-boot-starter-security:** Includes Spring Security, OAuth2, and other security-related dependencies.

**spring-boot-starter-test:** Includes JUnit, Mockito, and other testing-related dependencies.

**spring-boot-starter-amqp:** Includes RabbitMQ client and other messaging-related dependencies.

**spring-boot-starter-actuator:** Includes production-ready features to help you monitor and manage your application

## 7. do you know @RequestMapping(value = "/users", method = RequestMethod.POST) ? could you list CRUD by this style?

@RequestMapping annotation with RequestMethod.POST is typically used to handle HTTP POST requests for creating resources. 

```java
@RequestMapping(value = "/users", method = RequestMethod.POST)
public ResponseEntity<User> createUser(@RequestBody User user) {
    // Save the user to the database
    User savedUser = userRepository.save(user);
    // Return the saved user with HTTP status 201 CREATED
    return ResponseEntity.status(HttpStatus.CREATED).body(savedUser);
}

@RequestMapping(value = "/users/{id}", method = RequestMethod.GET)
public ResponseEntity<User> getUserById(@PathVariable Long id) {
    // Find the user in the database by id
    User user = userRepository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("User not found with id " + id));
    // Return the user with HTTP status 200 OK
    return ResponseEntity.ok(user);
}

@RequestMapping(value = "/users/{id}", method = RequestMethod.PUT)
public ResponseEntity<User> updateUser(@PathVariable Long id, @RequestBody User user) {
    // Find the user in the database by id
    User existingUser = userRepository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("User not found with id " + id));
    // Update the user with the new values
    existingUser.setName(user.getName());
    existingUser.setEmail(user.getEmail());
    // Save the updated user to the database
    User updatedUser = userRepository.save(existingUser);
    // Return the updated user with HTTP status 200 OK
    return ResponseEntity.ok(updatedUser);
}

@RequestMapping(value = "/users/{id}", method = RequestMethod.DELETE)
public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
    // Find the user in the database by id
    User user = userRepository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("User not found with id " + id));
    // Delete the user from the database
    userRepository.delete(user);
    // Return HTTP status 204 NO CONTENT
    return ResponseEntity.noContent().build();
}
```

## 8. What is ResponseEntity? why do we need it?

ResponseEntity is a class in Spring Framework that represents the entire HTTP response, including status code, headers, and body. It allows developers to customize the response that is returned from the server.

We need ResponseEntity in Spring Framework for several reasons:

1, Customization of the response: ResponseEntity provides a way to customize the HTTP response with a specific status code, headers, and body.

2, Returning responses with different data types: ResponseEntity can be used to return different types of responses, such as JSON, XML, or plain text.

3, Handling errors: ResponseEntity can be used to handle errors in a more detailed way, such as returning a specific HTTP status code for an error condition.

4, Testing: ResponseEntity can be useful for testing, allowing developers to assert the status code, headers, and body of the HTTP response.

## 9. What is ResultSet in jdbc? and describe the flow how to get data using JDBC

ResultSet is an interface in Java that represents the result of a database query. It contains methods to iterate over the results, retrieve data from individual columns, and navigate through the data.

Here is a general flow of how to get data using JDBC:

1, Load the JDBC driver: Use Class.forName() to load the appropriate JDBC driver for your database.

2, Establish a connection: Use DriverManager.getConnection() to establish a connection to the database.

3, Create a statement: Use the Connection.createStatement() method to create a Statement object.

4, Execute a query: Use the Statement.executeQuery() method to execute a SQL query and obtain a ResultSet object.

5, Process the results: Use methods provided by the ResultSet interface to process the results of the query. You can iterate over the rows using ResultSet.next(), retrieve column values using ResultSet.getXXX(), and so on.

6, Close the connection: Use the Connection.close() method to close the connection to the database.

```java
try {
    Class.forName("com.mysql.jdbc.Driver");
    Connection conn = DriverManager.getConnection(url, username, password);
    Statement stmt = conn.createStatement();
    ResultSet rs = stmt.executeQuery("SELECT * FROM my_table");

    while (rs.next()) {
        int id = rs.getInt("id");
        String name = rs.getString("name");
        int age = rs.getInt("age");
        System.out.println("id: " + id + ", name: " + name + ", age: " + age);
    }

    rs.close();
    stmt.close();
    conn.close();
} catch (SQLException e) {
    e.printStackTrace();
} catch (ClassNotFoundException e) {
    e.printStackTrace();
}
```

## 10.What is the ORM framework?

ORM stands for Object-Relational Mapping. It is a programming technique that allows developers to map between objects in their code and the corresponding tables in a relational database. In other words, it enables developers to work with a database using an object-oriented programming language.

ORM frameworks provide a set of tools and libraries that help developers to perform CRUD (Create, Read, Update, Delete) operations on database tables without writing raw SQL queries. Instead, developers work with objects and classes, and the ORM framework takes care of translating those objects into SQL queries and vice versa.

Some popular ORM frameworks for Java include Hibernate, MyBatis, and EclipseLink. In addition to Java, ORM frameworks are available for other programming languages like Python, Ruby, and PHP.

## 11. Learn how to use ObjectMapper by this example.
 
 Done
 
## 12. What is the serialization and desrialization?

Serialization and Deserialization refer to the process of converting an object into a format that can be stored or transmitted, and converting that format back into an object. Typically, serialization and deserialization are used to transfer object data between different applications or to store objects on disk for later retrieval. For example, in Java, Java serialization can be used to write objects to disk and read objects. In web applications, it is common to serialize objects to JSON or XML format for transmission over the network.

## 13. use stream api to get the average of the array [20, 3, 78, 9, 6, 53, 73, 99, 24, 32].

```java
int[] array = {20, 3, 78, 9, 6, 53, 73, 99, 24, 32};
double res = Arrays.stream(array).average();
```

## 14-16

Check MavenProject/hw7

