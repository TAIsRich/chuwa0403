# 1. 
## annotations.md
# 2. explain how the below annotaitons specify the table in database?
## @column is used to specify a mapped column for a persistent property or field. If no Column annotation is specified, the default values are applied.
## Generated a default column, type varchar, max size 255, default value is John Snow.
## Generated a column name is STUDENT_NAME, size is 50, not nullable, and is not a unique key.
# 3. What is the default column names of the table in database for  @Column ?
## two columns with name firstName and operatingSystem.
# 4. What are the layers in springboot application? what is the role of each layer?
## -Presentation Layer
### The presentation layer handles the HTTP requests, translates the JSON parameter to object, and authenticates the request and transfer it to the business layer.
## -Business Layer
### The business layer handles all the business logic. It consists of service classes and uses services provided by data access layers. It also performs authorization and validation.
## -Persistence Layer
### The persistence layer contains all the storage logic and translates business objects from and to database rows.
## -Database Layer
### In the database layer, CRUD (create, retrieve, update, delete) operations are performed.
# 5. Describe the flow in all of the layers if an API is called by Postman.
## Presentation Layer: When API is called, the request is sent to the presentation layer. The request is then passed to the controller method. The controller method checks and calls the service method.
## Business Layer: Business layer receives the request from the controller. Then validating the input data, making decisions based on the data, and invoking operations in the data access layer.
## Persistence Layer: The persistence layer gets the request from the business layer and talk with the database.
## Database Layer: Perform any operations if needed.
# 6. What is the application.properties? do you know application.yml?
## Properties files are used to keep 'N' number of properties in a single file to run the application in a different environment. In Spring Boot, properties are kept in the application. properties file under the classpath.
## YAML is a convenient format for specifying hierarchical configuration data. we can also use YAML-based configuration files in our Spring Boot application.
# 7. 
## mongoblog
# 8. 
## redbook