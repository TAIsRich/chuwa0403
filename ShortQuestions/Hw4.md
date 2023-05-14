# Homework 4
## 1. 
See [annotations.md](./annotations.md)

## 2. 
```
@Column(columnDefinition = "varchar(255) default 'John Snow'")
private String name;
```
Create a default value "John Snow" for name. The name should fit in char array of length 255.

```
@Column(name="STUDENT_NAME", length=50, nullable=false, unique=false)
private String studentName;
```
The column name is STUDENT_NAME, element length is 50, element cannot be nullable and it is not unique;

## 3. 
```
@Column
private String firstName;
```
The default name is "first_name";

```
@Column
private String operatingSystem;
```
The default name is "operating_system".

## 4. What are the layers in springboot application? what is the role of each layer?
### Presentation layer
The presentation layer is the top layer of the spring boot architecture. It consists of views. It handles the HTTP requests and performs authentication. It is responsible for converting the JSON field's parameter to Java Objects and vice-versa.

### Business Layer
Contains all the business logic. It consists of service classes. It is responsible for validation and authorization.

### Persistence layer
Contains all the database storage logic. It is responsible for converting business objects to the database row and vice-versa.

### Database Layer
Contains all the databases such as MongoDB, MySQL. Can contain multiple databases. It is responsible for performing the CRUD operations.

## 5. Describe the flow in all of the layers if an API is called by Postman
1. Postman client send HTTP request to controller
2. The HTTP request is forwarded to the Controller. The controller maps the request. It processes the handles and calls the server logic.
3. The business logic is performed in the Service layer. The spring boot performs all the logic over the data of the database which is mapped to the spring boot model class through Java Persistence Library(JPA).
4. The JSP page is returned as Response from the controller.

## 6. What is the application.properties? do you know application.yml?
application.properties file is used to write the application-related property into that file. This file contains the different configuration which is required to run the application in a different environment, and each environment will have a different property defined by it. Inside the application properties file, we define every type of property like changing the port, database connectivity.

The application.properties file is not that readable. So most of the time developers choose application.yml file over application.properties file. YAML is a superset of JSON, and as such is a very convenient format for specifying hierarchical configuration data. YAML is more readable and it is good for the developers to read/write configuration files.

An example of YAML files:
```
spring:
  datasource:
    url: jdbc:mysql://${MYSQL_HOST:localhost}:3306/db_example
    username: springuser
    password: ThePassword
    driver-class-name: com.mysql.jdbc.Driver
  jpa:
    hibernate:
      ddl-auto: update
```

## 7.
See [redbook](./../Coding/hw4/redbook)
## 8.
See [mongo-blog](./../Coding/hw4/mongo-blog)
