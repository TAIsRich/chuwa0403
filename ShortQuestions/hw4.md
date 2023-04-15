## 1. Create a file to list all of the annotaitons you learned and known, and explain the usage and how do you understand it. you need to update it when you learn a new annotation. Please organize those annotations well, like annotations used by entity, annotations used by controller.   
Please see annotations file.

## 2. Explain how the below annotaitons specify the table in database?
The first annotation specifies that the corresponding column in the table will have a datatype of VARCHAR(255) and a default value of 'John Snow' if no value is provided when inserting a row.

The second annotation specifies that the corresponding column in the table will have a name of STUDENT_NAME, a maximum length of 50, and that it cannot be null. The unique property is set to false, meaning that multiple rows in the table can have the same value for this column.

## 3. What is the default column names of the table in database for @Column ?
The default column names in the database will be the same as the names of the corresponding fields in the Java class. The column names in the database for the firstName and operatingSystem fields will be firstName and operatingSystem, respectively.

## 4. What are the layers in springboot application? what is the role of each layer?
- The Presentation layer is responsible for handling user requests and returning responses to the client. It provides an interface for the user to interact with the application.

- The Service layer contains the business logic of the application. It is responsible for processing the data received from the presentation layer and performing the necessary operations on it.

- The Persistence layer is responsible for interacting with the database or any other external data source. It provides the necessary methods to retrieve and store data in the database.

- The Domain layer contains the POJOs that represent the entities or objects in the application. It provides a clear and concise representation of the data in the application.

- The Configuration layer contains the configuration classes that are used to configure various aspects of the application, such as database configuration, security configuration, etc. It provides a central location to manage the configuration of the application.

## 5. Describe the flow in all of the layers if an API is called by Postman.
1. Presentation Layer: When an API is called by Postman, it sends an HTTP request to the Spring Boot application. The presentation layer is responsible for handling the incoming request and sending a response back to the client. The presentation layer typically includes the @Controller or @RestController annotated classes and methods that handle the HTTP requests. The HTTP request is mapped to a specific method in the controller based on the URL and HTTP method used in the request.

2. Service Layer: Once the HTTP request is received by the presentation layer, it delegates the processing to the service layer. The service layer typically includes the @Service annotated classes that contain the business logic of the application. In this layer, the service methods can perform any necessary processing on the data before sending it to the persistence layer. The service layer can also include any third-party API or service integrations.

3. Persistence Layer: The persistence layer is responsible for interacting with the database or any other external data source. It typically includes the @Repository annotated classes that contain the database operations. In this layer, the data can be retrieved, updated, or deleted based on the requirements of the API.

4. Domain Layer: The domain layer contains the POJOs (Plain Old Java Objects) that represent the entities or objects in the application. These entities typically include the @Entity annotated classes that map to the database tables. In this layer, the data is represented as objects with attributes and methods that can be used by the service and persistence layers.

5. Configuration Layer: The configuration layer contains the configuration classes that are used to configure various aspects of the application. It typically includes the @Configuration annotated classes that define the configuration of the application, such as database configuration, security configuration, etc. The configuration layer also includes any necessary external library integrations or settings.

Once the data processing is complete, the response is sent back to the presentation layer, which converts the data to a format that can be sent as an HTTP response to the client (in this case, Postman).

## 6. What is the application.properties? do you know application.yml?
- Application.properties is a file in the .properties format that contains key-value pairs of configuration properties. These properties can be used to configure various aspects of the application such as database settings, server port, logging, security, and many more. 

- Application.yml is a file in the YAML format that also contains configuration properties. YAML is a human-readable format that allows for more complex structures and nested configurations. 

## 7. Create a Project, name it with mongo-blog, write a POST API for mongo-blog, change database to MongoDB.
Please see coding folder

## 8. In your redbook application, write the code for RUD APIs.
Please see coding foler