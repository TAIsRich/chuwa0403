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
#Annotations used by Controller
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


