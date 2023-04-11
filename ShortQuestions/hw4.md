## 1. Whatistheapplication.properties?doyouknowapplication.yml? create a file to list all of the annotaitons you learned and known,and explain the usage and how do you understand it. you need to update it when you learn a new annotation. Please organize those annotations well, like annotations used by entity, annotations used by controller

See annotations.md

## 2. explain how the below annotaitons specify the table in database?

1. Using the @Column annotation with the "columnDefinition" attribute to map the "name" field of a class to a database column. The "columnDefinition" attribute specifies the SQL data type and default value of the column. In this case, the "name" column will be created as a "varchar(255)" column with a default value of 'John Snow'.

2. Using the @Column annotation to map the "studentName" field of a class to a database column.
The column will be named "STUDENT_NAME", the maximum length of the "STUDENT_NAME" column will be 50 characters. The "STUDENT_NAME" column cannot be assigned a null value, and the "STUDENT_NAME" column values do not have to be unique.
The String type of the "studentName" field indicates that it will be mapped to a text column in the database.

## 3. What is the default column names of the table in database for @Column?

1. The default column name would be "firstName". But it's recommended to always specify explicit column names using the name attribute of the @Column annotation.

```
@Column(name = "FIRST_NAME")
private String firstName;
```

2. The default column name would be "operatingSystem".

```
@Column(name = "OPERATING_SYSTEM")
private String operatingSystem;
```

## 4. What are the layers in springboot application? what is the role of each layer?

[springboot architecture](https://www.interviewbit.com/blog/spring-boot-architecture/)

1. Presentation Layer:
A JSON structure is made up of viewpoints. A front layer is what is seen from the outside and a back layer is where the structure is built from viewpoints. It interprets JSON and handles authentication and HTTP requests. After authentication, it enters the business layer for further processing.
2. Business Layer:
As part of business logic, it manages all of the business decisions and performs the business validation and consent. For example, only admins may modify the customer’s account.
3. Persistence Layer:
All of the storage logic in this program, including database questions, is accounted for in this portion of code. It also translates between database rows and company items.
4. Database Layer:
The structure is constructed in this way: The HTTP request or internet requests are handled by the Controllers from the demonstration layer, the providers control the company logic, as well as also the repositories preserve persistence (storage logic). Each provider, service, and repository may be controlled by a single Controller. There are many repositories, which may be managed by many repositories, and databases may be managed by many databases.

## 5. Describe the flow in all of the layers if an API is called by Postman.

1. Presentation Layer:
Postman sends an HTTP request to the API endpoint. The request is received by the controller in the Presentation Layer.The controller validates the request and extracts any necessary parameters or data from it. The controller calls a method in the Business Layer to perform the required business logic on the data. The method in the Business Layer returns a response object back to the Presentation Layer. The Presentation Layer constructs an HTTP response using the response object and returns it to Postman.

2. Business Layer:
The method in the Business Layer processes the data according to the business rules of the application. The Business Layer may call a method in the Persistence Layer to retrieve or save data from the database. The method in the Persistence Layer returns the retrieved data or any other response back to the Business Layer. The Business Layer constructs a response object using the retrieved data or any other response from the Persistence Layer and returns it back to the Presentation Layer.

3. Persistence Layer:
The method in the Persistence Layer communicates with the database to perform database operations such as retrieving or saving data. The Persistence Layer constructs a response object using the retrieved data or any other response and returns it back to the Business Layer.

4. Database Layer:
This layer consists of the actual database where the data is stored. The Persistence Layer communicates with the database to perform database operations such as retrieving or saving data.

## 6. What is the application.properties? do you know application.yml? 

application.properties and application.yml are configuration files used in Spring Boot applications. application.properties is a file that contains key-value pairs of configuration properties that Spring Boot uses to configure the application. The properties can be used to configure various aspects of the application, such as database connections, logging, server port, etc. The properties are typically defined in a file named application.properties in the root of the classpath. application.yml is an alternative to application.properties. It is a YAML file that is structured differently than the application.properties file. It uses a hierarchical structure that allows for more complex configurations. It is often preferred over application.properties for its readability and maintainability. Both application.properties and application.yml are used to externalize configuration, which means that the configuration properties can be easily modified without changing the application code. This makes it easier to configure the application for different environments and reduces the risk of hard-coding configuration values in the application code.

## 7. Create a Project, name it with mongo-blog, write a POST API for mongo-blog, change database to MongoDB

