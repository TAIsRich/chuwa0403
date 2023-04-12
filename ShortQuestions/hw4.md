## 1. Create a file to list all of the annotaitons you learned and known,and explain the usage and how do you understand

it.
Please see `ShortQuestions/hw4.md`

## 2. Explain how the below annotations specify the table in database?

```java
@Column(columnDefinition = "varchar(255) default 'John Snow'")
private String name;
```

* The name of the database column is default to "name"
* SQL data type is varchar(255)
* the default value is "John Snow"

```java
@Column(name = "STUDENT_NAME", length = 50, nullable = false, unique = false)
private String studentName;
```

* The name of the database column is "STUDENT_NAME"
* The "length" attribute specifies the maximum length is 50 in this case
* This column cannot be null
* This column do not need to be unique

`unique=false` is same to

```java
@Table(name = "STUDENT", uniqueConstraints = {@UniqueConstraint(columnNames = {"STUDENT_NAME"})})
```

## 3. What is the default column names of the table in database for @Column?

```java
@Column
private String firstName;
@Column
private String operatingSystem;
```

Without the "name" attribute, column names will be the same as the variable names in the Java class. This is not a good
practice

## 4. What are the layers in springboot application? What is the role of each layer?

1. **Presentation Layer**: The presentation layer handles the HTTP requests, translates the JSON parameter to object,
   and authenticates the request and transfer it to the business layer. In short, it consists of views i.e., frontend
   part.

2. **Business Layer**: The business layer handles all the business logic. It consists of service classes and uses
   services provided by data access layers. It also performs authorization and validation.

3. **Persistence Layer**: The persistence layer contains all the storage logic and translates business objects from and
   to database rows.

4. **Database Layer**: In the database layer, CRUD (create, retrieve, update, delete) operations are performed.

## 5. Describe the flow in all of the layers if an API is called by Postman
1. Postman client send HTTP requests GET/POST/PUT/DELETE to controller
2. The request goes to the controller, and the controller maps that request and handles it. After that, it calls the service logic if required.
3. In the service layer, all the business logic performs. It performs the logic on the data that is mapped to JPA with model classes.\
4. A JSP page is returned to the user if no error occurred.

## 6. What is the application.properties? do you know application.yml?
`application.properties` is a file used in Spring Boot applications to externalize application configuration properties. It allows developers to configure the application at runtime without having to recompile or rebuild the application.
```properties
server.port=8080
```

On the other hand, `application.yml` is another file format that can be used to externalize configuration properties in a Spring Boot application. It uses YAML syntax to define configuration properties in a more human-readable and structured format. YAML allows the use of lists, maps, and nested objects to define configuration properties.
```yaml
server:
  port: 8080
```

## 7. Create a Project,name it with mongo-blog,write a POST API for mongo-blog, change database to MongoDB;


## 8. In your redbook application, write the code for RUD APIs.
Please see `MavenProject/redbook`