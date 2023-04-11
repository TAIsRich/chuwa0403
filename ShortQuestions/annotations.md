## Spring Annotations

1. @SpringBootApplication

@SpringBootApplication is a Java annotation used in Spring Framework to indicate that a class is a Spring Boot application. The @SpringBootApplication annotation is actually a combination of three other annotations: @Configuration, @EnableAutoConfiguration, and @ComponentScan. The @Configuration annotation indicates that the class contains Spring configuration, @EnableAutoConfiguration enables Spring Boot's auto-configuration capabilities, and @ComponentScan tells Spring where to scan for components.

```
@SpringBootApplication
public class SpringSecurityJwtGuideApplication {
      public static void main(java.lang.String[] args) {
        SpringApplication.run(SpringSecurityJwtGuideApplication.class, args);
    }
}

```

2. @Autowired

@Autowired is a Java annotation used in Spring Framework to inject dependencies automatically into a class. It can be used to inject dependencies for any Spring-managed bean, such as controllers, services, repositories, or configuration classes. @Autowired can be used in Field injection, Constructor injection, and Setter injection

```
@Component
public class MyService {
   private final MyRepository repository;

   @Autowired
   public MyService(MyRepository repository) {
      this.repository = repository;
   }
}
```

3. @Component

@Component can be used to mark any class as a Spring component. When a class is annotated with @Component, Spring will automatically create a bean for the class and manage its lifecycle.

```
@Component
public class MyService {
   
}
```

4. @Repository

@Repository is used to indicate that a particular class is a repository, which typically involves accessing a database or other persistent data store. @Repository is part of the Spring Data Access / DAO (Data Access Object) support, which provides a set of abstractions for working with data sources in a consistent and efficient way. When a class is marked with @Repository, Spring will automatically handle exceptions and translate them into more specific data access exceptions.

```
@Repository
public class CustomerRepository {
  
  private final JdbcTemplate jdbcTemplate;
  
  public CustomerRepository(JdbcTemplate jdbcTemplate) {
    this.jdbcTemplate = jdbcTemplate;
  }
  
}
```

5. @Service

@Service is used to indicate that a particular class is a service, which typically contains business logic that is used to implement the behavior of an application. Services are often used to implement the use cases of an application, such as creating a new user account, processing a payment, or updating a product catalog. They are typically responsible for coordinating the work of multiple components, such as repositories, validators, and external services.

```
@Service
public class OrderService {
  
  private final OrderRepository orderRepository;
  
  public OrderService(OrderRepository orderRepository) {
    this.orderRepository = orderRepository;
  }
  
  public void createOrder(Order order) {
    orderRepository.save(order);
  }  
}
```

6. @Controller

@Controller is used to indicate that a particular class is a controller, which is responsible for handling user requests and returning the appropriate response. Controllers typically receive requests from the client, retrieve data from one or more services, and then generate a response that is returned to the client. They are often used to implement the presentation layer of an application, which is responsible for rendering the user interface and handling user input.

```
@Controller
public class HomeController {
  
  private final ProductService productService;
  
  public HomeController(ProductService productService) {
    this.productService = productService;
  }
  
  @GetMapping("/")
  public String home(Model model) {
    List<Product> products = productService.getFeaturedProducts();
    model.addAttribute("products", products);
    return "home";
  }
  
}
```

7. @RestController

When a class is annotated with @RestController, Spring will automatically create a bean for the class and manage its lifecycle. The bean can then be used to handle incoming HTTP requests and return a response. @RestController is a convenient way to create and manage Spring RESTful web service controllers.

```
@RestController
public class MyRestController {
   
   @GetMapping("/hello")
   public String sayHello() {
      return "Hello, World!";
   }
}
```

8. @Scope

@Scope is used to specify the scope of a bean, which determines the lifecycle and visibility of the bean instance within the Spring container.

```
@Bean
@Scope("singleton")
public Person personSingleton() {
    return new Person();
}
```

Other common scopes include:
singleton (default): A single instance of the bean is created for the entire lifetime of the application context.
request: A new instance of the bean is created for each HTTP request that is handled by a Spring MVC controller.
session: A new instance of the bean is created for each HTTP session that is started by a user.
application: A single instance of the bean is created for the entire lifetime of the ServletContext.
websocket: A new instance of the bean is created for each WebSocket session that is established between a client and server.

9. @Bean

@Bean is an annotation in Spring framework used to indicate that a method produces a bean which should be managed by Spring container. This method creates and initializes an instance of a bean and also specifies its dependencies. The @Bean annotation can be used in conjunction with a @Configuration class, which is a class that contains methods annotated with @Bean and is processed by the Spring container to generate bean definitions and service requests for those beans at runtime.

```
@Configuration
public class AppConfig {
 
    @Bean
    public MyService myService() {
        return new MyServiceImpl();
    }
 
    @Bean
    public MyRepository myRepository() {
        return new MyRepositoryImpl();
    }

}
```

10. @Value

@Value is an annotation in the Spring framework that is used to inject values into fields of beans from external sources such as property files or system environment variables. It can be used to inject simple values like strings and numbers as well as more complex values like lists and maps.

```
myapp.datasource.url=jdbc:mysql://localhost:3306/myapp
myapp.datasource.username=root
myapp.datasource.password=secret
```

```
@Component
public class DataSourceConfig {
 
    @Value("${myapp.datasource.url}")
    private String url;
 
    @Value("${myapp.datasource.username}")
    private String username;
 
    @Value("${myapp.datasource.password}")
    private String password;
}

```

11. @ConfigurationProperties

@ConfigurationProperties is an annotation in the Spring framework used to map configuration properties to fields of a Java class. It is often used to bind configuration properties from an external source such as a properties file or environment variables to a bean.

```
myapp.datasource.url=jdbc:mysql://localhost:3306/myapp
myapp.datasource.username=root
myapp.datasource.password=secret
```

```
@Configuration
@ConfigurationProperties(prefix = "myapp.datasource")
public class DataSourceProperties {
    
    private String url;
    
    private String username;
    
    private String password;
    
    // getters and setters
}
```

12. @RequestMapping

@RequestMapping is an annotation in the Spring framework used to map HTTP requests to methods of a Java class. It is often used to define the endpoint URLs and HTTP methods for a RESTful web service.

```
@RestController
@RequestMapping("/api")
public class ApiController {
    
    @GetMapping("/hello")
    public String hello() {
        return "Hello, world!";
    }
    
    @PostMapping("/users")
    public User createUser(@RequestBody User user) {
        // save the user to the database
        return user;
    }
    
}
```

13. @GetMapping 

@GetMapping is an annotation in the Spring framework used to map HTTP GET requests to methods of a Java class. It is often used to define the endpoint URLs for retrieving resources in a RESTful web service.

```
@RestController
@RequestMapping("/api")
public class ApiController {
    
    @GetMapping("/hello")
    public String hello() {
        return "Hello, world!";
    }
    
    @GetMapping("/users/{id}")
    public User getUserById(@PathVariable Long id) {
        // retrieve the user from the database by id
        return user;
    }
    
}
```

14. @PostMapping

@PostMapping is an annotation in the Spring framework used to map HTTP POST requests to methods of a Java class. It is often used to define the endpoint URLs for creating or updating resources in a RESTful web service.

```
@RestController
@RequestMapping("/api")
public class ApiController {
    
    @PostMapping("/users")
    public User createUser(@RequestBody User user) {
        // save the user to the database
        return user;
    }

}
```

15. @PathVariable

@PathVariable is an annotation in the Spring framework used to bind a path variable from a URL to a method parameter in a Java class. It is often used in conjunction with the @RequestMapping annotation to define the endpoint URL of a RESTful web service.

```
@RestController
@RequestMapping("/api")
public class ApiController {
    
    @GetMapping("/users/{id}")
    public User getUserById(@PathVariable Long id) {
        // retrieve the user from the database by id
        return user;
    }
    
    // other methods
}
```

16. @RequestParam

@RequestParam is an annotation in the Spring framework used to bind a request parameter from a URL to a method parameter in a Java class. It is often used in conjunction with the @RequestMapping annotation to define the endpoint URL of a RESTful web service.

```
@RestController
@RequestMapping("/api")
public class ApiController {
    
    @GetMapping("/users")
    public List<User> getUsersByPage(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "10") int size) {
        // retrieve a list of users from the database by page and size
        return users;
    }    
}
```

17. @RequestBody

@RequestBody is an annotation in the Spring framework used to bind the body of an HTTP request to a method parameter in a Java class. It is often used in conjunction with the @RequestMapping annotation to define the endpoint URL of a RESTful web service.

```
@RestController
@RequestMapping("/api")
public class ApiController {
    
    @PostMapping("/users")
    public User createUser(@RequestBody User user) {
        // create the user in the database using the data from the request body
        return user;
    }
}
```

18. @ResponseBody

@ResponseBody is an annotation in the Spring framework used to indicate that the return value of a method should be serialized into the body of the HTTP response. It is often used in conjunction with the @RequestMapping annotation to define the endpoint URL of a RESTful web service.

```
@RestController
@RequestMapping("/api")
public class ApiController {
    
    @GetMapping("/users/{id}")
    @ResponseBody
    public User getUserById(@PathVariable Long id) {
        // retrieve the user from the database by id
        return user;
    }
}
```

19. @ExceptionHandler

@ExceptionHandler is an annotation in the Spring framework used to handle exceptions thrown by a controller method. It is often used in conjunction with the @ControllerAdvice annotation to define a global exception handler for a Spring application.

```
@ControllerAdvice
public class ExceptionHandlerAdvice {

    @ExceptionHandler(UserNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ResponseBody
    public ErrorResponse handleUserNotFoundException(UserNotFoundException ex) {
        return new ErrorResponse("USER_NOT_FOUND", ex.getMessage());
    }

    // other exception handler methods
}
```

20. @Entity

@Entity is an annotation in the Java Persistence API (JPA) used to indicate that a Java class is a JPA entity. JPA entities are Java objects that are mapped to database tables, and are used to represent and manipulate data stored in a relational database.

```
@Entity
@Table(name = "users")
public class User {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(name = "name")
    private String name;
    
    @Column(name = "email")
    private String email;
    
    // getters and setters
}
```

21. @Table

@Table is an annotation in the Java Persistence API (JPA) used to specify the table that an entity is mapped to. JPA entities are Java objects that are mapped to database tables, and @Table is used to specify the name of the database table that the entity is mapped to.

22. @Id

@Id is an annotation in the Java Persistence API (JPA) used to indicate the primary key of an entity. JPA entities are Java objects that are mapped to database tables, and @Id is used to specify which field or property of the entity represents the primary key.

23. @GeneratedValue

@GeneratedValue is an annotation in the Java Persistence API (JPA) used to specify the strategy for generating primary key values for an entity. JPA entities are Java objects that are mapped to database tables, and @GeneratedValue is used to specify how the primary key values for the entity should be generated.

24. @Column

@Column is an annotation in the Java Persistence API (JPA) used to specify the mapping between a field or property of an entity and a column in a database table. JPA entities are Java objects that are mapped to database tables, and @Column is used to specify the details of the database column that a field or property should be mapped to.

25. @Transactional 

@Transactional is an annotation in Spring Framework used to provide declarative transaction management for applications. When this annotation is used on a class or method, Spring will automatically handle the transaction management, including beginning and committing the transaction, rolling back the transaction if an exception occurs, and managing the transactional boundaries.

```
@Service
public class UserService {
    
    @Autowired
    private UserRepository userRepository;
    
    @Transactional
    public void saveUser(User user) {
        userRepository.save(user);
    }
    
    @Transactional(readOnly = true)
    public User getUser(Long id) {
        return userRepository.findById(id).orElse(null);
    }
}
```