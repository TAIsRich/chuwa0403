# 2. 
1. `@Column`: This annotation specifies the properties of a database column that will be mapped to the studentName field in a Java entity class.
2. `name = "STUDENT_NAME"`: This attribute defines the name of the column in the database as STUDENT_NAME.
3. `length = 50`: This attribute sets the maximum length of the column to 50 characters.
4. `nullable = false`: This attribute indicates that the column cannot have null values.
5. `unique = false`: This attribute specifies that the column does not have a uniqueness constraint, meaning it can have duplicate values.
---
# 3.
`firstName` and `operatingSystem`

---
# 4.

1. Controller layer: This layer is responsible for handling incoming web requests and returning appropriate responses. It leverages Spring MVC's @Controller and @RestController annotations to define classes that map HTTP methods (GET, POST, PUT, DELETE, etc.) to specific methods. The controller layer focuses on processing requests, validating input, and passing data to the service layer. It also converts the service layer's responses into the desired format, such as JSON or XML.

2. Service layer: This layer contains the business logic of the application. It is responsible for processing data, enforcing business rules, and coordinating interactions between different components (e.g., calling multiple repositories or external services). Classes in this layer are typically annotated with @Service. The service layer separates the business logic from the other layers, making the code more maintainable and easier to test.

3. DAO layer: This layer is responsible for interacting with the data storage system, such as a relational or NoSQL database. It provides an abstraction over the underlying storage mechanism, allowing the service layer to work with data without being aware of the specific storage implementation. Classes in this layer are typically annotated with @Repository and use Spring Data JPA or another persistence framework to perform CRUD operations on the database. This layer promotes the separation of concerns and makes it easier to swap out or modify the data storage system without affecting other layers.

4. Model layer: This layer consists of the domain objects (or entities) that represent the data structure of the application. These objects often map to tables in a relational database and are used to transfer data between different layers of the application. Domain objects are usually simple classes with properties, getters, and setters. They might also contain some basic validation or business logic related to the specific domain object. In Spring Boot applications, model classes are often used with JPA annotations (e.g., @Entity, @Table, @Column) to define how they map to the database schema.
   
---

# 5 .
1. Controller layer: The Spring Boot application receives the incoming request and routes it to the appropriate controller method, based on the URL and HTTP method. The controller is responsible for processing the request, extracting any relevant data (e.g., path variables, query parameters, request body) and validating the input if necessary. After processing the request, the controller calls the relevant service method and passes the extracted data.

2. Service layer: The service layer processes the data received from the controller, enforces any necessary business rules, and coordinates interactions with other components (e.g., repository layer or external services). The service layer might call one or multiple repository methods to retrieve, store, or update data in the database. After the business logic is executed, the service layer returns the result (e.g., a domain object, a list of objects, or a status message) to the controller.

3. DAO layer: When the service layer calls a repository method, the repository layer interacts with the data storage system (e.g., a relational or NoSQL database) to perform the requested CRUD operation. The repository layer is responsible for translating between the domain objects (Java classes) and the database schema (tables and columns). Once the repository method completes its operation, it returns the result (e.g., a domain object, a list of objects, or an update count) to the service layer.

4. Model layer: As the data flows between the layers, it is represented using domain objects. These objects are Java classes that map to the database schema and carry the data between the controller, service, and repository layers. The domain objects might also contain validation or basic business logic specific to the domain.
   
---

# 6.
`application.properties` and `application.yml` are configuration files in Spring Boot applications that store configuration properties for your application. Both files serve the same purpose but use different formats for organizing the configuration properties.

Spring Boot automatically reads and applies the configuration properties defined in these files during the application startup. You can set various properties related to the application, such as server port, logging level, data source configuration, and other custom properties.


---
# 7.


