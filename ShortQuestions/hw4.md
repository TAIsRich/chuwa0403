# HW4

## 1. Explain Common Annotations

See annotation.md

## 2. Explain how the below annotations specify the table in database?

1. `@Column(columnDefinition = "varchar(255) default 'John Snow'")` - this annotation is used to specify the definition of a database column. In this case, the `name` field will be mapped to a `varchar` column in the database with a maximum length of 255 characters and a default value of 'John Snow'.
2. `@Column(name="STUDENT_NAME", length=50, nullable=false, unique=false)` - this annotation is used to specify the name, length, nullability, and uniqueness of a database column. In this case, the `studentName` field will be mapped to a column in the database with the name `STUDENT_NAME`, a maximum length of 50 characters, and which cannot be null or have duplicate values.

## 3. What is the default column names of the table in database for @Column?

```java
// The default column name is firstName
@Column
private String firstName;

// The default column name is operatingSystem
@Column
private String operatingSystem;
```

## 4. What are the layers in springboot application? what is the role of each layer?

1. Presentation Layer: This layer is responsible for handling HTTP requests and responses. It is typically implemented using controllers or RESTful endpoints. The presentation layer is responsible for handling user interactions and passing data to and from the service layer.
2. Service Layer: This layer is responsible for business logic and data processing. It contains the application's business logic, which is typically implemented using services. The service layer is responsible for retrieving data from the data access layer, processing the data, and returning the results to the presentation layer.
3. Data Access Layer: This layer is responsible for data persistence and retrieval. It typically contains data access objects (DAOs) that are responsible for interacting with the database. The data access layer is responsible for retrieving data from the database, transforming it into objects that can be used by the service layer, and persisting changes to the database.
4. Infrastructure Layer: This layer contains infrastructure components that provide support for other layers, such as security, logging, and configuration. It typically contains libraries, utilities, and frameworks that are used by the other layers.

## 5. Describe the flow in all of the layers if an API is called by Postman.

1. Presentation Layer: When a request is made to the API endpoint using Postman, the request is received by the controller in the presentation layer. The controller processes the request and extracts any relevant data from the request parameters or body.
2. Service Layer: The controller then calls the appropriate service method to handle the request. The service layer contains the business logic and data processing for the application. The service method retrieves any necessary data from the data access layer and processes the data according to the business logic of the application.
3. Data Access Layer: The service layer then interacts with the data access layer to retrieve or persist data. The data access layer contains the necessary data access objects (DAOs) to interact with the database. The DAO retrieves data from the database and maps it to objects that can be used by the service layer.
4. Infrastructure Layer: The service layer may also interact with the infrastructure layer to provide additional functionality. For example, it may use a logging framework to log information about the request or use a security framework to authenticate the user.
5. Service Layer: Once the data has been processed, the service layer returns the response to the controller in the presentation layer.
6. Presentation Layer: The controller then formats the response and sends it back to the client using Postman.

## 6. What is the application.properties? Do you know application.yml?

`application.properties` is a configuration file used by Spring Boot to configure various aspects of the application, such as the database connection settings, logging settings, and other properties. It is typically located in the `src/main/resources` directory of the project and contains key-value pairs in the format `key=value`.

`application.yml` is another type of configuration file used by Spring Boot, which is based on YAML (YAML Ain't Markup Language). It is an alternative to `application.properties` and allows for a more human-readable and organized way of defining configuration properties, using indentation and a hierarchy structure. The format is similar to JSON but without the curly braces and commas.

Both `application.properties` and `application.yml` can be used to set configuration properties for the Spring Boot application, but the choice between them is mostly a matter of personal preference and the complexity of the application. Some developers prefer `application.yml` for its readability and structure, while others prefer `application.properties` for its simplicity and familiarity.

## 7. mongo-blog

See Coding/mongo-blog

## 8. redbook

See Coding/redbook