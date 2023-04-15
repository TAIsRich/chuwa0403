### Q1
see `annotation.md`

### Q2:
First annotation is used to create a database table column with a default value of `'John Snow'` and a data type of `varchar(255)`.

The second annotation is used to create a database table column named `STUDENT_NAME`, with a maximum length of 50 characters, not allowing null values, and not requiring unique values

### Q3:
if you have a class with a field called `firstName` and annotate it with `@Column`, and you do not specify the `name` attribute, then the default column name in the database will be `firstName`. so as `operatingSystem` field will also be the same.

### Q4: What are the layers in springboot application? what is the role of each layer?

In a typical Spring Boot application, the following layers are commonly used:

1.  Presentation Layer / Web Layer
2.  Service Layer / Business Layer
3.  Data Access Layer / Persistence Layer

Here's a brief description of each layer:

1.  Presentation Layer / Web Layer: The presentation layer, also known as the web layer, is responsible for handling incoming HTTP requests and generating HTTP responses. This layer typically consists of controllers, which are annotated with `@Controller` and `@RequestMapping`, and are responsible for mapping the incoming requests to specific methods and returning a response to the client.

2.  Service Layer / Business Layer: The service layer, also known as the business layer, contains the business logic of the application. This layer is responsible for implementing use cases and business processes. The service layer typically contains classes annotated with `@Service` and methods that are used to implement the application's business logic.

3.  Data Access Layer / Persistence Layer: The data access layer, also known as the persistence layer, is responsible for interacting with the database or any other data source. This layer typically consists of classes annotated with `@Repository` or `@Component`, which are used to manage the interaction with the database or data source. It also contains classes that implement data access and data manipulation operations such as create, read, update, and delete (CRUD) operations.


Overall, these layers in Spring Boot application helps in separating concerns and make the code more modular and easier to maintain.


### Q5: Describe the flow in all of the layers if an API is called by Postman.

1.  Presentation Layer / Web Layer: When an API is called by Postman, the request is first received by the presentation layer or web layer of the Spring Boot application. The request is then passed to the appropriate controller method based on the `@RequestMapping` annotation. The controller method performs any necessary validation on the input data and calls the appropriate service method.

2.  Service Layer / Business Layer: The service layer or business layer receives the request from the controller and performs the necessary business logic. This may include validating the input data, making decisions based on the data, and invoking operations in the data access layer. The service layer is responsible for implementing the business logic of the application.

3.  Data Access Layer / Persistence Layer: The data access layer or persistence layer receives the request from the service layer and interacts with the database or other data source. This may involve reading or writing data to the database, or invoking stored procedures. The data access layer is responsible for managing the persistence of the application data.

4.  Presentation Layer / Web Layer: Once the data access layer has performed its operations, the result is returned to the service layer. The service layer processes the result and passes it back to the controller method. The controller method then generates an HTTP response and returns it to Postman.

5.  Postman: Finally, Postman receives the HTTP response from the controller method and displays the result to the user.

### Q6: What is the application.properties? do you know application.yml?

Both `application.properties` and `application.yml` are configuration files in Spring Boot that allow developers to configure various properties of the application.

`application.properties` is a file in Spring Boot that contains key-value pairs of configuration properties. These properties can be used to configure various aspects of the application, such as the database connection, server port, logging settings, and more. These properties can be easily accessed and used in the application code by using the `@Value` annotation.

`application.yml` is another configuration file in Spring Boot that can be used to configure the application. It is an alternative to `application.properties` and is based on the YAML syntax. YAML is a human-readable format for data serialization, and it provides a more concise and readable way to represent configuration data.

Both `application.properties` and `application.yml` files are used to configure Spring Boot applications, but the choice between them depends on personal preference and the specific use case. Some developers prefer `application.yml` for its readability and conciseness, while others prefer `application.properties` for its simplicity and familiarity.


### Q7:
see `redbook-mongo`


### Q8:
see `redbook`