1.  create a file to list all of the annotaitons you learned and known, and explain the usage and how do you
    understand it. you need to update it when you learn a new annotation. Please organize those annotations
    well, like annotations used by entity, annotations used by controller.
    

    Check file annotations.md


2. explain how the below annotaitons specify the table in database?

```java
@Column(columnDefinition = "varchar(255) default 'John Snow'")
private String name;
  
@Column(name="STUDENT_NAME", length=50, nullable=false, unique=false)
private String studentName;
```

The `@Column` annotation in Spring is used to map a field in a Java class to a column in a database table. It is used in combination with the `@Entity` annotation which is used to specify that a class is a table in the database.

3. What is the default column names of the table in database for  @Column ?

```java
@Column
private String firstName;
@Column
private String operatingSystem;
```

The default column name in the database for the `@Column` annotation is the same as the name of the field or property to which it is applied. If the name of the field or property contains multiple words, the column name will be formed by concatenating the words together and separating them with underscores. For example, if the field name is `firstName`, the default column name will be `first_name`.

4. What are the layers in springboot application? what is the role of each layer?

`Presentation Layer`: A JSON structure is made up of viewpoints. A front layer is what is seen from the outside and a back layer is where the structure is built from viewpoints. It interprets JSON and handles authentication and HTTP requests. After authentication, it enters the business layer for further processing.

`Business Layer`: As part of business logic, it manages all of the business decisions and performs the business validation and consent. For example, only admins may modify the customer’s account.

`Persistence Layer`: All of the storage logic in this program, including database questions, is accounted for in this portion of code. It also translates between database rows and company items.

`Database Layer`: The structure is constructed in this way: The HTTP request or internet requests are handled by the Controllers from the demonstration layer, the providers control the company logic, as well as also the repositories preserve persistence (storage logic). Each provider, service, and repository may be controlled by a single Controller. There are many repositories, which may be managed by many repositories, and databases may be managed by many databases.

5.  Describe the flow in all of the layers if an API is called by Postman.

`Presentation Layer`: When an API is called by Postman, the request is first received by the Presentation Layer. This layer is responsible for handling the user interface and receiving the user's input. In a Spring Boot application, the Presentation Layer is typically handled by the Controller classes, which receive and respond to HTTP requests.

`Business Layer`: Once the request is received by the Controller, it is passed on to the Business Layer. This layer contains the business logic of the application and is responsible for processing the request and returning a response. In a Spring Boot application, the Business Layer is typically implemented by the Service classes, which contain the business logic and handle the interactions between the Presentation Layer and Persistence Layer.

`Persistence Layer`: After the request has been processed by the Business Layer, the data is stored in the database through the Persistence Layer. This layer is responsible for interacting with the database and handling the data storage and retrieval operations. In a Spring Boot application, the Persistence Layer is typically implemented using the Repository classes, which contain the database-specific operations and handle the interactions between the Business Layer and the database.

`Database Layer`: Finally, the data is stored in the database, which is handled by the Database Layer. This layer is responsible for managing the database and ensuring that the data is stored and retrieved efficiently and accurately.

6.  What is the application.properties? do you know application.yml?

`application.properties` and `application.yml` are configuration files in a Spring Boot application that allow you to configure various aspects of the application.

`application.properties` is a file format that uses key-value pairs to set configuration properties. For example, you can set the server port, database URL, logging levels, and other settings.

`application.yml` is a YAML file format that can be used instead of application.properties. It uses a hierarchical structure to set properties, which can be more readable and easier to maintain in some cases.

7.  Create a Project, name it with mongo-blog, write a POST API for mongo-blog, change database to
    MongoDB;

https://www.mongodb.com/compatibility/spring-boot

check folder Coding/hw4/mongo-blog

8.  In your redbook application, write the code for RUD APIs.

https://github.com/TAIsRich/springboot-redbook.git

Branch: 02_post_RUD

you need to call the new APIs in your postman.

You need to type it line by line and try your best to understand it. DO NOT COPY PASTE
    @Column(columnDefinition = "varchar(255) default 'John Snow'")
    private String name;


check folder Coding/hw4/springboot-redbook-02_post_RUD