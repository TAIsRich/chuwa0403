## 1. List all of the new annotations to your annotaitons.md and explain its role.
- @ResponseStatus： In Spring Framework, @ResponseStatus is an annotation that can be used to indicate the HTTP status code returned by a controller method. By default, when a controller method returns a response, Spring will set the HTTP status code to 200 OK. However, there may be cases where you want to return a different HTTP status code, such as 404 Not Found or 500 Internal Server Error.
- @EnableAutoConfiguration： @EnableAutoConfiguration is an annotation in Spring Framework that enables the auto-configuration of the Spring application context. It is typically used in the main class of a Spring Boot application to automatically configure the required beans and dependencies based on the classpath.
- @Deprecated： In Spring Framework, @Deprecated is an annotation used to indicate that a method or class should no longer be used in new code. This is typically used when a method or class is being replaced by a newer, better alternative or when it is being removed from the framework altogether.
- @SuppressWarnings: In Spring Framework, @SuppressWarnings is an annotation used to suppress compiler warnings. This is typically used when you are using a method or class that generates a warning, but you know that the code is correct and you want to suppress the warning.
- @Retention： 
In Spring Framework, @Retention is an annotation used to indicate the retention policy for an annotation. It specifies how long an annotation should be retained, or stored, by the Java Virtual Machine (JVM) and whether it should be available at runtime.

## 2. how do you do the debug?
1. Install the Java Extension Pack: Open VS Code, go to the Extensions tab, and search for "Java Extension Pack". Install the extension pack, which includes the Java Language Support, Debugger for Java, and other useful tools.

2. Set up the launch configuration: In the Explorer tab of VS Code, navigate to the project you want to debug and click the "Add Configuration" button in the Run and Debug pane. Select "Java" as the environment and specify the main class or JAR file to run.

3. Set breakpoints: In your code, add breakpoints by clicking on the line number where you want to pause execution. Alternatively, you can use the Debug Console to set breakpoints programmatically.

4. Start debugging: Click the "Start Debugging" button in the Run and Debug pane, or press the F5 key. The application will start running and pause at the first breakpoint encountered.

5. Debug the application: Use the Debug Console to step through the code, examine variables, and evaluate expressions. You can also view the call stack, set watch variables, and modify code on the fly.

6. Stop debugging: When you are done debugging, click the "Stop" button in the Run and Debug pane or press the Shift+F5 key combination.

## 3. What is DTO, VO, Payload, DO, model?
- DTO (Data Transfer Object): A DTO is an object used to transfer data between different layers or modules of an application. It typically contains only the data necessary for the transfer and does not include any behavior.

- VO (Value Object): A VO is similar to a DTO, but it typically contains more behavior or logic. It is often used to represent a value or concept in the business domain, such as a date range or a geographic location.

- Payload: A payload is the data that is transmitted over a network or between different parts of an application. It can be in various formats, such as JSON, XML, or binary.

- DO (Domain Object): A DO is an object that represents an entity in the business domain, such as a customer or an order. It typically includes both data and behavior, and it can be used to perform operations or enforce business rules.

- Model: A model is a term used to refer to any object or set of objects used to represent data in an application. It can include DTOs, VOs, DOs, or any other type of object used to represent data.

## 4. What is @JsonProperty("description_yyds")
In Java and other programming languages, @JsonProperty is an annotation used to indicate the name of a JSON property that should be used when serializing or deserializing JSON data.

## 5. do you know what is jackson?
Yes, Jackson is a Java library used for processing JSON data. In Spring, Jackson is commonly used as the default JSON (de)serializer for converting Java objects to and from JSON format.

## 6. What is spring-boot-stater?
In Spring Boot, a starter is a dependency that includes a set of pre-configured dependencies and a default set of configurations for a specific purpose. A starter is essentially a dependency that simplifies the process of setting up a particular feature or technology in a Spring Boot application.

## 7. do you know @RequestMapping(value = "/users", method = RequestMethod.POST) ? could you list CRUD by this style?
@RequestMapping(value = "/users", method = RequestMethod.POST) is a Spring annotation used to map HTTP requests to controller methods in a Spring MVC application. Specifically, this annotation maps HTTP POST requests to the "/users" URL path to the controller method that it annotates.
- Create (HTTP POST): @RequestMapping(value = "/users", method = RequestMethod.POST). This maps HTTP POST requests to the "/users" URL path to the corresponding controller method, which can create a new user based on the data provided in the request body.

- Read (HTTP GET): @RequestMapping(value = "/users/{id}", method = RequestMethod.GET). This maps HTTP GET requests to the "/users/{id}" URL path to the corresponding controller method, which can retrieve the user with the specified ID.

- Update (HTTP PUT or PATCH): @RequestMapping(value = "/users/{id}", method = RequestMethod.PUT) or @RequestMapping(value = "/users/{id}", method = RequestMethod.PATCH). These map HTTP PUT or PATCH requests to the "/users/{id}" URL path to the corresponding controller method, which can update the user with the specified ID based on the data provided in the request body.

- Delete (HTTP DELETE): @RequestMapping(value = "/users/{id}", method = RequestMethod.DELETE). This maps HTTP DELETE requests to the "/users/{id}" URL path to the corresponding controller method, which can delete the user with the specified ID.

## 8. What is ResponseEntity? why do we need it?
ResponseEntity is a Spring class that represents an HTTP response, including status code, headers, and body. It allows you to create a more flexible and customized response than simply returning a plain object from your controller method.

- Custom HTTP status codes: By default, Spring will set the HTTP status code of the response based on the return type of your controller method. However, sometimes you may need to return a custom status code to indicate a specific error or success condition. With ResponseEntity, you can set the status code explicitly using the status() method.

- Custom headers: Similarly, you may need to return custom HTTP headers with your response. With ResponseEntity, you can set the headers explicitly using the header() or headers() method.

- More control over the response body: If you simply return an object from your controller - method, Spring will automatically serialize it to JSON (or XML, etc.) based on the configured message converters. With ResponseEntity, you can customize the serialization process by explicitly setting the media type using the contentType() method, or by returning a HttpEntity with a custom body and media type.

- Returning binary data: If you need to return binary data (such as a file download), you can use ResponseEntity to set the content type, content disposition, and other HTTP headers as needed.

## 9. What is ResultSet in jdbc? and describe the flow how to get data using JDBC
ResultSet is a Java interface that provides methods for iterating over the results of a database query in JDBC. It represents a set of rows returned by a database query, and allows you to access the data in those rows using various methods.

- Load the JDBC driver: Before you can connect to a database using JDBC, you need to load the appropriate driver for your database. You can do this using the Class.forName() method, which loads the driver class into the JVM's classpath.

- Establish a connection: Once you have loaded the driver, you can establish a connection to the database using the DriverManager.getConnection() method. This method takes a JDBC URL, which specifies the location and other parameters of the database you want to connect to.

- Create a statement: After you have established a connection, you can create a Statement or PreparedStatement object to execute a SQL query. Statement is used for static SQL queries that do not have any parameters, while PreparedStatement is used for dynamic queries that take parameters.

- Execute the query: Once you have created a statement object, you can execute the SQL query using the executeQuery() method. This method returns a ResultSet object that contains the rows returned by the query.

- Iterate over the results: Once you have a ResultSet object, you can use its various methods to iterate over the rows and access the data in each row. For example, you can use the next() method to move the cursor to the next row, and the getInt(), getString(), and other methods to retrieve the values of individual columns.

- Close the resources: After you have finished iterating over the results, you should close the ResultSet, Statement, PreparedStatement, and Connection objects in reverse order of their creation. This frees up any resources used by these objects and ensures that the connection to the database is closed properly.

## 10. What is the ORM framework?
ORM stands for Object-Relational Mapping. An ORM framework is a software tool or library that helps developers to interact with a database by mapping database tables and their columns to objects in their programming language.

## 11. Learn how to use ObjectMapper by this example.
See coding foler

## 12. What is the serialization and desrialization?
Serialization is the process of converting an object into a format that can be easily transmitted or stored. Deserialization is the reverse process of converting a serialized format back into an object.

## 13 use stream api to get the average of the array [20, 3, 78, 9, 6, 53, 73, 99, 24, 32].
```
double average = Arrays.stream(arr)
                       .average()
                       .orElse(Double.NaN);
```
## 14 & 15
See coding foler
