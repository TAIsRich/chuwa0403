### 1. create a file to list all of the annotaitons you learned and known, and explain the usage and how do you understand it. you need to update it when you learn a new annotation. Please organize those annotations well, like annotations used by entity, annotations used by controller.     
    1. File name: annotations.md 
    2. you'd better also list a code example under the annotations.
Please see annotations.md

### 2. explain how the below annotaitons specify the table in database?
```
@Column(columnDefinition = "varchar(255) default 'John Snow'")
private String name;
@Column(name="STUDENT_NAME", length=50, nullable=false, unique=false)
private String studentName;
```
1. @Column is used to define column of a database table.
columnDefinition is a parameter used to specify the SQL data type and other additional constraints for the column. In this example, it defines the name column as a VARCHAR type with a length limit of 255 characters, and a default value of 'John Snow'


2. name parameter is used to define the actual name of the column in the database table, which is STUDENT_NAME in the example. length parameter defines the maximum length of the column data is 50 characters. nullable defines the column can not be null. unique defines the column must have a unique value and can not have duplicate values.

### 3. What is the default column names of the table in database for @Column ?
```
// The default column name is firstName
@Column
private String firstName;
// The default column name is operatingSystem
@Column
private String operatingSystem;
```

### 4. What are the layers in springboot application? what is the role of each layer?
1. Controller layer: handle the HTTP requests and responses, serializes and deserializes input/output, validates input. 
2. Service layer: the business logic layer. The service layer is responsible for retrieving data from the data access layer, processing the data, and returning the results to the API.
3. Repository layer: data persistence and retrieval. contains DAO classes responsible for interacting with database.

### 5. Describe the flow in all of the layers if an API is called by Postman.
1. Controller Layer: When a request is sent to the API endpoint using Postman, the controller will receive the request and process it and retrieve relevant data from the request. It will then call the corresponding service method to handle this request.
2. Service Layer: The service layer is responsible for business logic and call the DAO layer to perform data processing.
3. DAO Layer: The DAO layer interacts with database to retrieve data and to map it to objects that can be used by the service layer.

### 6. What is the application.properties? do you know application.yml?
application.properties is a configuration file in Spring Boot to configure various aspects of the application, such as database connection details, the server ports, logging settings, etc. It typically locates in the src/main/resources directory and is of the format key = value.

application.yml is in another file format to configure the properties in Spring Boot applications. It is an alternative to the application.properties file and is often used when the configuration is complex or requires a hierarchical structure. The application.yml file uses YAML syntax, which is more human-readable and allows for nested properties and arrays.

### 7. Create a Project, name it with mongo-blog, write a POST API for mongo-blog, change database to MongoDB;
    1. https://www.mongodb.com/compatibility/spring-boot

### 8. In your redbook application, write the code for RUD APIs.
    1. https://github.com/TAIsRich/springboot-redbook.git
        1. Branch: 02_post_RUD
    2. you need to call the new APIs in your postman.
    3. You need to type it line by line and try your best to understand it. DO NOT COPY PASTE