## 1. create a file to list all of the annotations you learned and known, and explain the usage and how do you 
understand it. you need to update it when you learn a new annotation. Please organize those annotations well, like annotations used by entity, annotations used by controller.
Please check annotations.md.

## 2. Explain how the below annotations specify the table in database?
```java
@Column(columnDefinition = "varchar(255) default 'John Snow'")
private String name;
@Column(name="STUDENT_NAME", length=50, nullable=false, unique=false)
private String studentName;
```
The `@Column` annotation is used to specify the mapping between a Java class field and a database column. The 
`@Column` annotation provides various attributes that can be used to specify the characteristics of the database column that the Java field should be mapped to.

1. `columnDefinition`: This attribute is used to specify the SQL column definition for the database column. In the first example, `columnDefinition = "varchar(255) default 'John Snow'"` specifies that the column should be a `varchar` type with a length of 255 characters and a default value of 'John Snow'.

2. `name`: This attribute is used to specify the name of the database column. In the second example, `name="STUDENT_NAME"` specifies that the Java field should be mapped to a column named `STUDENT_NAME` in the database table.

3. `length`: This attribute is used to specify the maximum length of the database column. In the second example, `length=50` specifies that the maximum length of the column should be 50 characters.

4. `nullable`: This attribute is used to specify whether the database column can be null or not. In the second example, `nullable=false` specifies that the `STUDENT_NAME` column cannot be null.

5. `unique`: This attribute is used to specify whether the database column should be unique or not. In the second example, `unique=false` specifies that the `STUDENT_NAME` column can contain duplicate values.

## 3. What is the default column names of the table in database for @Column ?
```java
@Column
private String firstName;
@Column
private String operatingSystem;
```
The default column name for a JPA entity property that is annotated with `@Column` is the name of the property itself. In other words, if you don't specify a value for the `name` attribute of the `@Column` annotation, the column name in the database will be the same as the name of the Java field.

In the first example, the `firstName` property is annotated with `@Column` but no value is specified for the name attribute, so the default column name will be `firstName`.

In the second example, the `operatingSystem` property is also annotated with `@Column` without a `name` attribute value, so the default column name in the database will be `operatingSystem`.

## 4. What are the layers in springboot application? what is the role of each layer?
1. **Presentation Layer**  
The presentation layer is the top layer of the spring boot architecture. It consists of Views. i.e., the front-end part of the application. It handles the HTTP requests and performs authentication. It is responsible for converting the JSON field’s parameter to Java Objects and vice-versa. Once it performs the authentication of the request it passes it to the next layer. i.e., the business layer.

2. **Business Layer**  
The business layer contains all the business logic. It consists of services classes. It is responsible for validation and authorization.

3. **Persistence Layer**  
The persistence layer contains all the database storage logic. It is responsible for converting business objects to the database row and vice-versa.

4. **Database Layer**
The database layer contains all the databases such as MySql, MongoDB, etc. This layer can contain multiple databases. It is responsible for performing the CRUD operations.

## 5. Describe the flow in all of the layers if an API is called by Postman.
1. The request is sent from Postman to the Presentation Layer of the Spring Boot application. This layer typically uses Spring MVC or Spring WebFlux to handle HTTP requests and responses.

2. The Presentation Layer receives the request and performs any necessary validation or sanitization of the input.

3. The Presentation Layer then passes the request to the Business Layer, which is responsible for implementing the business logic of the application. The Business Layer typically uses Spring services or Spring beans to implement the use cases of the application.

4. The Business Layer retrieves or modifies data from the Persistence Layer, which is responsible for interacting with the database or any other data storage technology used by the application. The Persistence Layer typically uses Spring Data or JPA to implement the data access logic.

5. The Database Layer then stores or retrieves data from the actual database or data storage technology used by the application.

6. The Persistence Layer returns the requested data to the Business Layer, which processes it further as necessary.

7. The Business Layer returns the processed data to the Presentation Layer, which generates an HTTP response and sends it back to Postman.

8. Finally, Postman receives the HTTP response and displays the result.

## 6. What is the application.properties? do you know application.yml?
`application.properties` and `application.yml` are configuration files that are commonly used in Spring Boot applications to configure various settings.

`application`.properties` is a plain text file that contains key-value pairs of configuration properties. It is typically located in the `src/main/resources` directory of the application. Here's an example of what an `application.properties` file might look like:
```properties
# Database configuration
spring.datasource.url=jdbc:mysql://localhost:3306/mydb
spring.datasource.username=root
spring.datasource.password=mypassword

# Server configuration
server.port=8080
server.servlet.context-path=/myapp

```

On the other hand, `application.yml` is a YAML file that contains the same configuration information as `application.properties`. The main difference is that `application.yml` uses a hierarchical structure to organize the configuration properties. Here's an example of what an `application.yml` file might look like:

```yaml
# Database configuration
spring:
  datasource:
    url: jdbc:mysql://localhost:3306/mydb
    username: root
    password: mypassword

# Server configuration
server:
  port: 8080
  servlet:
    context-path: /myapp
```

## 7. Create a Project, name it with mongo-blog, write a POST API for mongo-blog, change database to MongoDB;
Please check MavenProject/mongo-blog.

## 8. In your redbook application, write the code for RUD APIs.
Please check MavenProject/redbook.