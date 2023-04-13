# hw 4
## 1
see [annotation](/ShortQuestions/annotations.md)

## 2
```
@Column(columnDefinition = "varchar(255) default 'John Snow'")
private String name;
```
Define a column with the type of varchar(255) to the database and set the default value as 'John Snow'.

```
@Column(name="STUDENT_NAME", length=50, nullable=false, unique=faldefault 'John Snow'")
private String studentName;
```
Define a column named 'STUDENT_NAME' to the database and set it as nullable and unique.

## 3
FIRST_NAME;
OPERATING_SYSTEM;

## 4
Presentation layer: It consists of Views. i.e., the front-end part of the application. It handles the HTTP requests and performs authentication. It is responsible for converting the JSON field’s parameter to Java Objects and vice-versa. 

Business layer: contains all the business logic. It consists of services classes. It is responsible for validation and authorization.

Persistence layer: contains all the database storage logic. It is responsible for converting business objects to the database row and vice-versa.

Database layer: contains all the databases such as MySql, MongoDB, etc. This layer can contain multiple databases. It is responsible for performing the CRUD operations.

## 5
Application layer: The application layer in Spring Boot is responsible for handling the API request and sending it to the appropriate controller for processing. At this layer, the API is typically invoked by an application or user and passes on the necessary data for processing.

Controller layer: The controller layer is responsible for receiving the API request from the application layer, processing it, and returning an appropriate response. Controllers are Java classes that are annotated with Spring annotations, which define the API endpoints and the methods to handle those endpoints.

Service layer: The service layer in Spring Boot is responsible for business logic and data access operations. Service classes are used by controllers to perform operations such as data retrieval and manipulation, which are then returned to the controller for processing.

Repository layer: The repository layer in Spring Boot is responsible for communicating with the database. Repositories provide an interface between the service layer and the database, allowing data to be retrieved, updated, and deleted from the database.

Database layer: The database layer stores the data required for processing the API request. When the repository layer needs to retrieve or store data, it sends queries to the database layer. The database layer processes these queries and returns the data to the repository layer.

Network layer: The network layer in Spring Boot is responsible for transmitting data between the application, controller, service, repository, and database layers. It ensures that data is transferred securely and efficiently by using protocols such as HTTP, HTTPS, TCP, and UDP.

## 6

**application.properties** is a configuration file used in Spring Boot applications to specify various settings and properties for the application. It is a plain text file that contains key-value pairs, where each key represents a configuration setting, and each value specifies the value for that setting. The file is typically located in the _src/main/resources_ folder of the application.

**application.yml** is an alternative to application.properties and is used to configure the Spring Boot application in a YAML (YAML Ain't Markup Language) format. YAML is a human-readable data serialization format that is commonly used for configuration files. It provides a more concise and easier-to-read alternative to the application.properties file, which can become difficult to manage when there are a large number of configuration settings.

## 7
see [mongodb-spring-boot](/Coding/mdb-spring-boot/)
## 8
see [redbook](/Coding/redbook/)