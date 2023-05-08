## Springboot
### @SpringBootApplication
This annotation is used to bootstrap and configure a Spring Boot application. It includes: 
@EnableAutoConfiguration: enable auto-configuration mechanism
@Configuration: allow to register extra beans in the context or import additional configuration classes
@ComponentScan: enables component scanning in a Spring application. Component scanning allows Spring to automatically discover and instantiate Spring-managed components, such as Spring beans, within the application context.

### @Component
Declare a class as a Spring-managed component. When a class is annotated with @Component, Spring will automatically detect and instantiate the class as a bean within the application context.

## Controller
### @Controller
This annotation marks a class as a controller class to handle HTTP requests and return responses to the client.

### @RestController
It is a convenience annotation in Spring that combines @Controller and @ResponseBody. This annotation is applied to a class to mark it as a request handler for creating RESTful web services using Spring MVC.

### @ResponseBody 
is used to indicate that the return value of a controller method should be serialized into a response body like Json or XML.

### @RequestBody
This annotation is used to indicate that a controller method parameter should be bound to the body of the HTTP request.

### @RequestMapping 
This annotation maps HTTP requests to Spring controller methods. It is used to specify the URL path, HTTP method, and other attributes.

### @PostMapping
The @PostMapping is a Spring framework annotation used to map HTTP POST requests to specific handler methods. When a browser sends a POST request to the server, the method annotated with @PostMapping will handle the request.

### @PutMapping
This annotation is used to map HTTP PUT requests to a specified controller method. This annotation can be used to handle incoming HTTP PUT requests to a Spring Controller, and update a resource or entity with the provided data.

### @GetMapping
This annotation is used to map HTTP GET requests to a specified controller method. This annotation can be used to handle incoming HTTP GET requests to a Spring Controller, and return the appropriate response.

### @DeleteMapping
This annotation is used to map HTTP DELETE requests to a specified controller method. This annotation can be used to handle incoming HTTP DELETE requests to a Spring Controller, and delete a resource or entity with the provided data.

### @RequestParam
This annotation is used to bind request parameters to a method parameter in a controller handler method.

### @PathVariable
This annotation is used to extract a variable from the URI path and pass it as a method parameter 
in a controller

### @RequestHeader 
This annotation is used to extract the header from the request.

### @ResponseStatus
This annotation marks a method or exception class with the status code and message that should be returned. The status code is applied to the HTTP response when the handler method is invoked, or whenever the specified exception is thrown.

## Service
### @Service
The @Service is a Spring framework annotation used to indicate that a particular class is a service.

### @Autowired
This annotation is used to automatically wire a dependency to a Spring bean. It is typically used to inject an instance of a Spring bean into another bean, without requiring the developer to explicitly configure the dependency injection.

### @Transactional
This annotation is used to indicate that a method should be executed within a transaction. The annotation can be applied to class or method level, and it provides declarative transaction management, simplifying the code needed to manage transactions. It ensures that the method is executed as an atomic operation, with all changes made to the database either committed if the operation is successful or rolled back if it fails.

## Repository
### @Repository
This annotation marks a class as a repository component, typically annotate classes that are responsible for managing the persistence of data(database). 

### @NamedQuery and @NamedQueries
@NamedQuery is used to define a single JPQL query that can be executed by its name.
@NamedQueries is used to define multiple named JPQL queries that can be executed by their respective names.

## JPA
### @Entity
This annotation indicates that a class mapping to a table in a database. 

### @Table
This annotation is used in JPA entities to specify the additional details of the database table that is related to the entity. It includes these attributes uniqueConstraints, name, catalog, schema.

### @Id
This annotation is used to specify the primary key of the table. 

### @Column
This annotation is used to map a field in the entity to a column in the database. This annotation specifies the column name, length, nullable, and other attributes.

### @GeneratedValue
This annotation is used to specify how the primary key value is generated for an entity. GenerationType.AUTO
GenerationType.IDENTITY
GenerationType.SEQUENCE
GenerationType.TABLE

### @OneToMany
@OneToMany is an annotation used in Object-Relational Mapping(ORM) frameworks, such as Hibernate or JPA (Java Persistence API). It is used to define a one-to-many relationship between two entities.

### @ManyToOne and @JoinColumn
@ManyToOne is an annotation used to define a many-to-one relationship between two entities. It is usually used with @JoinColumn to specifiy the foreign key with the primary key in owning Entity.

### @ManyToMany and @JoinTable
@ManyToMany is a JPA annotation used to define a many-to-many relationship between two entities. 
@JoinTable is a JPA annotation used in object-relational mapping(ORM) to define the association between two entities in a many-to-many relationship. It is used to join the tables of the two entities that have a many-to-many relationship.

### @Query 
is an annotation in Spring Boot that allows you to declare a query using a SQL statement, JPQL, or native query for your data access method.