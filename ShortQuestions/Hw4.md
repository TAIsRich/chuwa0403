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
Presentation handles the HTTP requests and transfer it into objects and pass it to Business Layer.

