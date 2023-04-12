# 2. explain how the below annotaitons specify the table in database?
```
@Column(columnDefinition = "varchar(255) default 'John Snow'")
private String name;
```
This code defines a column. The columnDefinition attribute is used to define the column type and other constraints. And the `name` field of the entity will be mapped to a column of type `VARCHAR(255)` in the database, and the default value is `John Snow`.
```
@Column(name="STUDENT_NAME", length=50, nullable=false, unique=false)
private String studentName;
```
In this code, the `name` attribute is used to specify the name of the column in the database table. The `nullable` attribute is used to specify whether the column can have a null value. The `unique` attribute is used to specify whether the column value should be unique in the table. The field `studentName` should be mapped to a column named `STUDENT_NAME`. And the maximum length should be 50 characters, and cannot be null and unique.
# 3. What is the default column names of the table in database for @Column ?
```
@Column
private String firstName;
```
The name of this column should equal to `firstName`.
```
private String operatingSystem;
```
The name of this column should equal to operatingSystem.
4. What are the layers in springboot application? what is the role of each layer?
`Presentation Layer` It handles the HTTP requests and performs authentication. It is responsible for converting the JSON field's parameter to Java Objects and vice-versa. Once it performs the authentication of the request it passes it to the next layer. i.e., the business layer.

`Business Layer` The business layer contains all the business logic. It consists of services classes. It is responsible for validation and authorization.

`Persistence Layer` The persistence layer contains all the database storage logic. It is responsible for converting business objects to the database row and vice-versa.

`Database Layer` The database layer contains all the databases such as MySql, MongoDB, etc. This layer can contain multiple databases. It is responsible for performing the CRUD operations.
# 5. Describe the flow in all of the layers if an API is called by Postman.
`Presentation Layer` Postman sends a request to the API, which is received by the presentation layer. The presentation layer is responsible for handling the HTTP request, validating the request parameters, and passing the request to the service layer.

`Business Layer` The business layer receives the request from the presentation layer and performs business logic operations. It interacts with the persistence layer to retrieve or modify data.

`Persistence Layer` The persistence layer interacts with the database and performs data access operations such as reading or writing data.

`Database layer` The database layer stores and manages data.

`Presentation Layer` After performing the business logic and data access operations, the response is returned to the presentation layer, which creates an HTTP response with the appropriate status code, headers, and body.

`Postman` Finally, Postman receives the HTTP response from the API and displays the response to the user.
# 6. What is the application.properties? do you know application.yml?
`application.properties` is a text file that contains key-value pairs of configuration properties. These properties can be used to configure various aspects of the Spring Boot application such as the server port, database connection details, logging configuration, and many more. 

`application.yml` is also a configuration file, but it uses a YAML format instead of a key-value pair format. YAML is a human-readable data serialization format that is often used for configuration files. It allows you to define nested properties, making it easier to organize and read your configurations.