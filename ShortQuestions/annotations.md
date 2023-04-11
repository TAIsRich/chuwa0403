# Controller

### @RestController

@RestController annotation combines the functionalities of both @Controller and @ResponseBody annotations, making it easier to create RESTful web services in Spring.   

### @RequestMapping

This annotation is used to map HTTP requests to specific methods in the controller.

### @PostMapping

This annotation is used to handle HTTP POST requests.

### @GetMapping

This annotation is used to handle HTTP GET requests.

```java
@RestController
@RequestMapping("/api")
public class MyRestController {

    @PostMapping("/message")
    public String postMessage(@RequestBody String message) {
        // code to process message
        return "Received message: " + message;
    }

    @GetMapping("/user/{id}")
    public User getUserById(@PathVariable Long id) {
        // code to retrieve user from database
        User user = userRepository.findById(id);
        return user;
    }
}
```


# Entity

### @Entity

This annotation is used to indicate that the class is a JPA entity. It maps the class to a database table and its attributes to table columns.

### @Table

This annotation is used to specify the name of the database table that corresponds to a JPA entity.

### @Id  

This annotation is used to specify the primary key of a JPA entity.

### @Column

This annotation is used to specify the name of a database column that corresponds to a JPA entity attribute.

### @GeneratedValue

This annotation is used to specify the strategy for generating primary keys.


```java
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

    // getters and setters
}
```

- - -

### @Service

It is used to mark a class as a service layer component. 

### @Autowired

This annotation is used to inject dependencies into a Spring-managed bean. It tells Spring to look for a bean that matches the type of the annotated field, and inject it automatically. It can also be used in controller.

### @Override

It is used to indicate that a method in the implementing class is intended to override a method from the interface; or a method in a subclass is intended to override a method in its superclass. 

```java
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User getUserById(Long id) {
        return userRepository.findById(id).orElse(null);
    }
}
```

 - - -

### @SpringBootApplication

It is an annotation in the Spring Boot framework that combines three other annotations: @Configuration, @EnableAutoConfiguration, and @ComponentScan. It is commonly used to bootstrap Spring Boot applications.

```java
@SpringBootApplication
public class MyApp {
   public static void main(String[] args) {
      SpringApplication.run(MyApp.class, args);
   }
}
```