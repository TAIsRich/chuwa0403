## 1. create a file to list all of the annotaitons you learned and known, and explain the usage and how do you understand it. you need to update it when you learn a new annotation. Please organize those annotations well, like annotations used by entity, annotations used by controller.

Please check shortAnswer/annotations.md

## 2. explain how the below annotaitons specify the table in database?
```java
@Column(columnDefinition = "varchar(255) default 'John Snow'")
private String name;
@Column(name="STUDENT_NAME", length=50, nullable=false, unique=false)
private String studentName;
```
The first `@Column` specify the table means the column name is default name and  `columnDefinition = "varchar(255) default 'John Snow'" ` indicating that the data type of this column is varchar(255) with a default value of 'John Snow'.

The second means the column name in the table is *STUDENT_NAME* with a maximum length of 50 characters. The column is configured to not allow null values and is not marked as unique.

## 3. What is the default column names of the table in database for @Column ?

```java
@Column
private String firstName;
@Column
private String operatingSystem;
```

The default column names in the database table for firstName and operatingSystem fields would be first_name and operating_system.

## 4. What are the layers in springboot application? what is the role of each layer?

**Presentation Layer**: This layer is responsible for handling incoming requests from the client and returning responses. In a Spring Boot application, this layer is typically implemented using controllers, which use annotations like @RestController or @Controller to map requests to specific methods and return responses in different formats (e.g., JSON, HTML, XML).

**Buisness Layer**: This layer also known as the Service Layer, is responsible for implementing business logic and processing data. The service layer is typically called by the presentation layer and may use one or more repositories or data access objects (DAOs) to interact with the database or other external systems. In a Spring Boot application, this layer is typically implemented using services, which use annotations like @Service to indicate that they contain business logic.

**Persistence Layer**:This layeralso known as the Data Access Layer, is responsible for storing and retrieving data from a database. It interacts with the database using an ORM (Object-Relational Mapping) framework such as Hibernate or JPA. The persistence layer abstracts away the details of the database and provides a simple interface to the business layer.

**Database**: This layer is where the application data is stored. It can be any relational or non-relational database, depending on the requirements of the application. The database is typically accessed using SQL queries or an ORM framework.

## 5. Describe the flow in all of the layers if an API is called by Postman.

### Flow:

1,**PostMan**: Postman sends an HTTP request to the specified URL(the REST API endpoint exposed by the Spring Boot application.), including the HTTP method (GET, POST, etc.), headers, and the request body.

2,**Presentation Layer**: The REST controller receives the request and delegates the processing to the corresponding service method.

3,**Business Layer**: The service layer can perform business logic and use any required DAO objects to interact with the persistence layer.

4,**Persistence Layer**: The DAO objects interact with the database to perform CRUD operations on the required tables.

5,**Database**: The data is stored or retrieved from the database as per the request.

6,**Persistence Layer**: The response data is fetched from the database and passed back to the service layer.

7,**Business Layer**: The service layer processes the response data (if required) and prepares a response to be sent back to the client.

8,**Presentation Layer**: The REST controller receives the response and packages the response data into an HTTP response and sends it back to Postman via the HTTP protocol.

9,**Postman**: Postman receives the HTTP response and displays it to the user.

## 6. What is the application.properties? do you know application.yml?

**application.properties** is a configuration file used in Spring Boot applications to configure various properties such as server port, database connection details, logging levels, etc. It uses key-value pairs to specify the configuration settings.

**application.yml** is an alternative to application.properties which uses YAML format instead of properties format. YAML is a human-readable format that uses whitespace indentation to delimit different levels of nesting. It can be easier to read and write than the properties format, especially for complex configurations.

## 6. What is the application.properties? do you know application.yml

*application.properties* is a text file that contains key-value pairs of configuration properties that Spring uses to configure the application. The file is usually located in the src/main/resources directory of the application. Some of the common configuration properties that can be set in the application.properties file include server port number, database connection settings, logging configuration, and security settings.

```java
server.port=8080
```

*application.yml* is another type of configuration file used in Spring applications. It is a YAML file that contains configuration properties in a structured format. YAML is a human-readable data serialization language that is often preferred over other formats such as XML or JSON because it is more concise and easier to read. application.yml can be used to define the same configuration properties as application.properties, but in a more readable and concise format.

```java
server:
  port: 8080
```

## 7. Create a Project, name it with mongo-blog, write a POST API for mongo-blog, change database to
MongoDB;

Please check MavenProject/hw4/mango-blog

## 8. In your redbook application, write the code for RUD APIs.

please check MavenProject/hw4/redbook



