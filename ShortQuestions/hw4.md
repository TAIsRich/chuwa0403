# HW4

*Claudia Feng     Apr 12, 2023*

1. 

See annotations.md.

2. 

`columnDefinition` attribute is used to provide a database-specific SQL fragment for defining the column.

The column `name` is defined as a VARCHAR with a maximum length of 255 characters, and the default value is set to 'John Snow'.

```java
@Column(columnDefinition = "varchar(255) default 'John Snow'")
private String name;
```

The name of the `studentName` column in the database table will be "STUDENT_NAME", the maximum length of the column is set to 50 characters, and the column cannot have null values, the column does not have a unique constraint.

```java
@Column(name="STUDENT_NAME", length=50, nullable=false, unique=false)
private String studentName;
```

3. 

```java
/*The default column name is "firstName"*/
@Column
private String firstName;
/*The default column name is "operatingSystem"*/
@Column
private String operatingSystem;
```

4. Layers in springboot application and the role of each layer:

**Presentation Layer:** A JSON structure is made up of viewpoints. A front layer is what is seen from the outside and a back layer is where the structure is built from viewpoints. It interprets JSON and handles authentication and HTTP requests. After authentication, it enters the business layer for further processing. This layer is responsible for handling user interface (UI) and user input/output. In a Spring Boot application, this layer usually consists of controllers, which handle incoming HTTP requests and return HTTP responses. Controllers are annotated with `@Controller` or `@RestController` annotations. The presentation layer can also include view templates (like Thymeleaf, JSP, or FreeMarker) to render the UI, although this is less common in modern applications, which often use separate client-side frameworks like Angular, React, or Vue.js.

**Business Layer:** As part of business logic, it manages all of the business decisions and performs the business validation and consent. For example, only admins may modify the customer’s account. This layer contains the business logic of the application, and it is where most of the processing, validation, and transformation take place. The service layer is designed to be reusable and decoupled from the presentation layer, so it can be used by different presentation components or even in other applications. Classes in this layer are usually annotated with `@Service`.

**Persistence Layer:** All of the storage logic in this program, including database questions, is accounted for in this portion of code. It also translates between database rows and company items. This layer is responsible for interacting with the data storage system, such as a relational or NoSQL database. It handles all data-related operations like Create, Read, Update, and Delete (CRUD) and any other custom data access methods. In a Spring Boot application, this layer is typically implemented using Spring Data repositories, which are interfaces extending `JpaRepository`, `CrudRepository`, or other repository types provided by Spring Data. Repository interfaces are annotated with `@Repository`.

**Database Layer:** The structure is constructed in this way: The HTTP request or internet requests are handled by the Controllers from the demonstration layer, the providers control the company logic, as well as also the repositories preserve persistence (storage logic). Each provider, service, and repository may be controlled by a single Controller. There are many repositories, which may be managed by many repositories, and databases may be managed by many databases. This layer contains the domain objects (also known as entities or models) that represent the business concepts and the relationships between them. These objects are usually simple Java classes annotated with `@Entity` when using JPA or Hibernate. The domain layer is used to represent the state and behavior of the application, and it is shared across all other layers.

5. The flow in all of the layers if an API is called by Postman:

- Postman sends an HTTP request to the application's API endpoint
- Presentation layer: The request reaches the presentation layer, where it is handled by a suitable controller
- Service layer: The controller delegates the processing of request to a service class. The class performs processing, validation, transformation, or any other operation needed. The service layer may call other services or helper classes to perform specific tasks.
- Data Access Layer: If the request requires interaction with a data storage system (e.g., a database), the service layer communicates with the data access layer. The data access layer uses repositories, which are interfaces extending Spring Data's `JpaRepository`, `CrudRepository`, or other repository types, to perform data operations like Create, Read, Update, and Delete (CRUD). The repositories provide an abstraction over the underlying data storage system, making it easy to switch between different data sources or storage technologies.
- Database Layer: The data access layer operates on domain objects, which represent the business concepts and their relationships in the application. The domain objects are simple Java classes, often annotated with `@Entity` when using JPA or Hibernate, that are used to represent the state and behavior of the application.
- The response data flows back through the layers, in reverse order, until it reaches the presentation layer.
- In presentation layer, the controller maps the response data to an HTTP response. If the response includes a data payload, the controller may use the `@ResponseBody` annotation, or in the case of a `@RestController`, it's implied, to serialize the data as JSON, XML, or another format. The controller sets the appropriate HTTP status code for the response, such as 200 OK, 201 Created, or 400 Bad Request.

* Postman receives the HTTP response, including the status code and any payload, and displays it in the user interface.

6. 

Both are configuration files.

`application.properties`: This is a Java properties file that uses the key-value pair format to store configuration properties. It is the default configuration file in a Spring Boot application. The properties are stored in a simple format, with each line representing a key-value pair separated by an equal sign (=).

`application.yml`: This is an alternative configuration file format, using the YAML (YAML Ain't Markup Language) format. It is more human-readable and supports complex data structures, making it suitable for hierarchical configuration properties. Instead of using key-value pairs, `application.yml` uses indentation to indicate the structure of the configuration properties.

