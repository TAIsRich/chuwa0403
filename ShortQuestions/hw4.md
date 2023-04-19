# HW4

## 1. Create a file to list all the annotations
See `ShortQuestions/annotations.md`

## 2. explain how the below annotations specify the table in database?
```
@Column(columnDefinition = "varchar(255) default 'John Snow'")
private String name;
```
-  `@Column` is used to define the metadata for the `name` column of a database table
- `columnDefinition` parameter is to specify the SQL data type and any additional constraints for the column
- So here, it's defining the `name` column as a `VARCHAR` type with a length of 255 characters, and a default value of 'John Snow'
```  
@Column(name="STUDENT_NAME", length=50, nullable=false, unique=false)
private String studentName;
```
-  `@Column` is used to define the metadata for the `studentName` column of a database table
- `name` parameter allows us to specify the actual name of the column in the database table, which may be different from the name of the Java field.
- `length` parameter defines the maximum length of the column data
- `nullable` defines whether the column can be null
- `unique` defines whether the column must have a unique value

## 3. What is the default column names of the table in database for @Column ?
```aidl
@Column
private String firstName;
@Column
private String operatingSystem;
```
The default column names would be `firstName` and `operatingSystem`, respectively.   
These names will be used as the column names when the entity class is mapped to a database table using JPA.

If the `@Column` annotation **is used without specifying the `name` attribute**, then **the default column name will be the same as the name of the Java field**

## 4.  What are the layers in springboot application? what is the role of each layer?
- Controller layer: that is to listen to http requests, deserializes input,  validates input, calls the business logic and serializes the output
- Service layer which is for the business logic, for transaction management
- Repository layer contains dao classes, for data access, for CRUD operation to DB
- Entity layer holds the entities classes, which are the classes that correspond to tables in DB

## 5.  Describe the flow in all the layers if an API is called by Postman
1. Controller Layer: When a request is sent to the API endpoint using Postman, the controller will receive the request and process it and retrieve relevant data from the request. It will then call the corresponding service method and pass the relevant data to the service layer to handle this request
2. Service Layer: The service layer is for business logic and call the DAO layer to perform data processing to retrieve or save data
3. DAO Layer: The DAO layer is to interact with database to retrieve data and to map it to objects that can be used by the service layer. 
4. Database layer: The corresponding data is store or updated in this layer or retrieved from this layer

## 6.  What is the application.properties? do you know application.yml?
`application.properties` is a file in Spring Boot projects to configure various aspects of the application such as the server port, database connection details, logging levels, and many other settings.  
he file is typically located in the `src/main/resources` directory and is of format `key=value`

`application.yml` is another file format to define configuration properties in Spring Boot applications. It is an alternative to the `application.properties` file and is often used when the configuration is complex or requires a hierarchical structure. The `application.yml` file uses `YAML` syntax, which is more human-readable and allows for nested properties and arrays.

## 7.  Create a Project, name it with mongo-blog, write a POST API for mongo-blog, change database to MongoDB
See Coding/hw4/mongo-blog