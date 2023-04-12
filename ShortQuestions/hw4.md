# Q2
In a Spring Boot application, the @Column annotation is used to specify the properties of a column in a database table
The annotation @Column(columnDefinition = "varchar(255) default 'John Snow'") is used to specify the details of the column "name". It tells the database to create a column of datatype varchar with a length of 255 characters, and set a default value of 'John Snow' for the column if no value is specified during insertion.

# Q3

In this case, the name attribute is used to specify the column name in the database. So, the firstName field will be mapped to a column named first_name and the operatingSystem field will be mapped to a column named operating_system in the database.

# Q4

Presentation Layer: This layer handles HTTP requests and responses, and is responsible for accepting and validating input data from clients. It communicates with the service layer to perform business logic operations and returns the response back to the clients.

Service Layer: This layer contains the business logic and performs the core operations of the application. It communicates with the data access layer to fetch and persist data.

Data Access Layer: This layer interacts with the database to fetch and persist data. It provides methods to perform CRUD (Create, Read, Update, and Delete) operations on the database.

Domain Layer: This layer contains the domain models or entities that represent the data in the application. It defines the business logic and relationships between entities.

Infrastructure Layer: This layer contains the configurations and utilities required by the application, such as security, caching, logging, and messaging. It provides services to other layers of the application.

# Q5

Presentation Layer: Postman sends an HTTP request to the server, which is handled by a controller in the presentation layer. The controller performs the input validation, authentication, and authorization checks, and delegates the processing to the service layer.

Service Layer: The controller invokes a service method in the service layer to perform the business logic operations. The service layer communicates with the data access layer to fetch and persist data from the database.

Data Access Layer: The service layer invokes a repository or DAO method in the data access layer to fetch or persist data from the database. The data access layer uses the ORM (Object-Relational Mapping) framework to map the entities to database tables and executes SQL queries.

Domain Layer: The data access layer retrieves or persists data from/to the database using the entity models defined in the domain layer. The domain layer defines the business logic and relationships between entities.

Infrastructure Layer: The domain and data access layers use the configuration and utilities provided by the infrastructure layer, such as security, caching, logging, and messaging. The infrastructure layer provides services to other layers of the application.

Data Access Layer: After the service layer has processed the business logic, the result is returned to the controller in the presentation layer, which creates an HTTP response and sends it back to Postman.

Presentation Layer: Postman receives the HTTP response from the server, which contains the data or error message, and displays it to the user.

# Q6

application.properties is a file used in Spring Boot applications to provide configuration properties for the application. It is a key-value pair file, where each line contains a property key and its corresponding value. These properties are used to configure the application's behavior and its various components such as database connections, logging, security, etc. 

application.yml is an alternative file format to application.properties for configuring Spring Boot applications. It uses a YAML syntax to provide the same configuration properties as application.properties. YAML is a more human-readable format that uses indentation to define the structure of the file. 



























