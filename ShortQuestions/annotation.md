# Annotations used by Entity
### @Entity
Indicates that a class is a JPA entity and will be managed by a persistence provider.
### @Table
Specifies the table name and schema for an entity.
### @Id
Specifies the primary key of an entity.
### @GeneratedValue
Specifies how the primary key value is generated for an entity.
### @Colunm
Specifies the mapping between a Java class property and a database column.

example codes:
```
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;

}
```
# Annotations used by Controller
### @Controller
Indicates that a class is a Spring MVC controller.
### @RestController
Indicates that a class is a Spring MVC controller that handles RESTful web requests.
### @RequestMapping
Maps HTTP requests to handler methods in a Spring MVC controller.
### @PathVariable
Extracts a variable from the URL path in a Spring MVC controller handler method.
### @RequestBody
Binds the HTTP request body to a Java object in a Spring MVC controller handler method.
### @GetMapping
To map HTTP GET requests onto specific methods within a controller. It is used to handle the HTTP GET requests and can be used to retrieve a resource, like a web page or data, from the server.
### @PostMapping
To map HTTP POST requests onto specific methods within a controller. It is used to handle the HTTP POST requests and can be used to create a new resource on the server.
### @Autowired
Used to automatically wire and inject beans into a class or object.

Example codes:
```
@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/{id}")
    public User getUser(@PathVariable Long id) {
        return userService.getUserById(id);
    }

    @PostMapping
    public User createUser(@RequestBody User user) {
        return userService.createUser(user);
    }
}
```
# Error Handling Annotations
### @ExceptionHandler
Handles exceptions thrown from controller handler methods in a Spring MVC application. 
### @ControllerAdvice
Specifies a global exception handler for a Spring MVC application.

Example codes:
```
@ControllerAdvice
public class MyExceptionHandler {
    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleException(Exception e) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
            .body("An error occurred: " + e.getMessage());
    }
}
```

- `@PostMapping` This annotation is used to map HTTP POST requests to specific controller methods in Spring and handle form data or JSON requests.
- `@RequestBody` This annotation is used to indicate that the incoming request should be bound to the method parameter. It is used to handle the body of the incoming HTTP request.
- `@RestController` This annotation is used to define a controller in Spring that is responsible for handling RESTful requests.
- `@RequestMapping` This annotation is used to map HTTP requests to specific methods in Spring. It can be used to map URLs to controller methods, set HTTP headers or request parameters.
- `@GetMapping` This annotation is used to map HTTP GET requests to specific methods in Spring. It is used to handle form data or JSON requests.
- `@PathVaribale` This annotation is used to bind a URI template variable to a method parameter in Spring. It is used to extract values from the URL path.
- `@DeleteMapping` This annotation is used to map HTTP DELETE requests to specific controller methods in Spring. It is used to delete resources.
- `@PutMapping` This annotation is used to map HTTP PUT requests to specific controller methods in Spring. It is used to update resources.
- `@ResponseStatus` This annotation is used to define the HTTP status code to be returned by the controller method. It is used to customize the HTTP response status of the API.
- `@Query` This annotation is used in Spring Data JPA to declare a custom query to be executed by the JPA provider. It allows developers to write custom SQL or JPQL queries and map the results to Java objects.
- `@EnableTransactionManagement` This annotation is used to enable transaction management in Spring. It is typically used in the main configuration class of a Spring application and allows for declarative transaction management using annotations such as `@Transactional`.
- `@Transactional` This annotation provides a declarative way to manage transactions in Spring, allowing developers to focus on the business logic of their application rather than worrying about transaction management.
- `@Repository` This annotation is used to perform database operations. It allows Spring to automatically create an instance of the repository and manage its lifecycle, including transaction management.
- `@ManyToOne`  This annotation is used to define a many-to-one relationship between two entities.
- `@OneToOne` This annotation is typically used to define a relationship between two entities where each entity has a unique reference to the other.
- `@ManyToMany` This annotation is typically used to define a relationship where multiple instances of one entity can be associated with multiple instances of another entity.
- `@JoinColumn` This annotation is used to define a column used for joining two entities in a database table.
- `@JoinTable` This annotation is used to define a join table used for many-to-many relationships. It allows developers to define the table used for the relationship, as well as any additional columns required.
- `@PersistenceContext` This annotation is typically used to manage the persistence context in JPA.
- `@UniqueConstraint` This annotation is typically used to enforce uniqueness constraints on one or more columns in a table.
- `@NamedQueries` This annotation allows developers to define a named query using JPQL, which can be used to retrieve data from the database.
- `@Bean`  This annotation is used to mark a method in a configuration class that returns an object which should be registered as a bean in the Spring application context. The method should return an instance of a class that can be managed by Spring's dependency injection container.
- `@Primary` This annotation is used to indicate the primary bean when there are multiple beans of the same type.
- `@ComponentScan` This annotation is used to specify the packages that should be scanned by Spring for detecting components, such as controllers, services, repositories, and so on. It is typically used in a configuration class that is annotated with @Configuration.
- `@Controller` This annotation is used to mark a class as a Spring MVC controller. It is typically used to handle HTTP requests and return a response.
- `@ControllerAdvice` This annotation is used to define global exception handling for a Spring MVC application. It is typically used to handle exceptions that occur across multiple controllers.
- `@Service` This annotation is used to mark a class as a service in a Spring application. It is typically used to define business logic and transaction management.
- `@Component` his annotation is used to mark a class as a component in a Spring application. It is a generic stereotype annotation that can be used for any Spring-managed component. Components are auto-detected by Spring's @ComponentScan.




