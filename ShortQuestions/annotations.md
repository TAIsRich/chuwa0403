# Annotations Used by Entity

## @Entity

The `@Entity` annotation is used to indicate that a class represents a table in a database. (*defines that a class can be mapped to a table. And that is it, it is just a marker, like for example Serializable interface*)
```java
@Entity
public class Post{
}
```
## @Table

The `@Table` annotation is used in JPA entities to specify the details of the database table that corresponds to the entity. It provides four attributes to specify the details of the database table that corresponds to the entity:

1, **name**: allows you to override the name of the table. If not specified, the name of the table will be the same as the name of the entity.

2, **catalog**: allows you to specify the catalog of the table.

3, **schema**: allows you to specify the schema of the table.

4, **uniqueConstraints**: allows you to specify one or more unique constraints on columns in the table.
```java
@Entity
@Table(name = "my_table", catalog = "my_catalog", schema = "my_schema", 
       uniqueConstraints = @UniqueConstraint(columnNames = {"column1", "column2"}))
public class MyEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(name = "column1")
    private String column1Value;
    
    @Column(name = "column2")
    private String column2Value;
    
    // getters and setters
}

```
## @Id

The `@Id` annotation is used to specify the primary key of the table. It is typically applied to a field in the class.
```java
@Entity
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
   
}
```
## @GeneratedValue

The `@GeneratedValue` annotation is used to specify how the primary key value is generated for an entity.

1,**GenerationType.AUTO**: This is the default strategy and JPA will choose a strategy that is supported by the underlying database.

2,**GenerationType.IDENTITY**: This strategy uses an auto-incremented column in the database to generate primary key values.

3,**GenerationType.SEQUENCE**: This strategy uses a database sequence to generate primary key values. A sequence is a database object that generates unique numbers.

4,**GenerationType.TABLE**: This strategy uses a database table to generate primary key values. The table has a column that is incremented for each new row, and the generated value is used as the primary key for the entity.
```java
@Entity
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
  }
```
## @Column

The `@Column` annotation is used to specify the mapping of a field to a column in the database. You can use this annotation to specify the column name, length, nullable, and other attributes.
```java
@Entity
@Table(name = "post")
public class Post{
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

   @Column(nullable = false)
    private String title;

   @Column(name = "description",nullable = false)
    private String description;
    }
```
## @CreationTimestamp

The `@CreationTimestamp` is a Hibernate annotation used to automatically set a timestamp as the creation time of an entity. It is typically used in conjunction with @Entity and @Table to represent the mapping between entities and tables.
```java
@Entity
@Table(name = "post")
public class Post{

    @CreationTimestamp
    private LocalDateTime createDateTime;

    @CreationTimestamp
    private LocalDateTime updateDateTime;
```

## @JsonProperty

@JsonProperty is a Java annotation used to specify the name of a JSON property for a field in a Java object. When using a Java object to convert data to JSON format, these annotations on the fields tell the serialization process to map the Java field to the specified JSON property. Using the @JsonProperty annotation, you can control the name and order of properties during the serialization and deserialization process.

```java
public class Person {
  @JsonProperty("first_name")
  private String firstName;
  // other fields and methods
}
When converting a Person object to JSON format, the "firstName" field will map to the "first_name" property:
{
  "first_name": "John",
  // other properties
}
```
## @ManyToOne and @JoinColumn 

@ManyToOne is used to define a many-to-one relationship between two entities, where multiple instances of one entity can be associated with a single instance of another entity. 


For example, suppose there are two entity classes: Order and Customer. An order can only belong to one customer, but a customer can have multiple orders. In the Order entity class, @ManyToOne annotation can be used to establish a many-to-one relationship with the Customer entity class:

```java
@Entity
public class Order {
  @Id
  private Long id;
  
  // other fields
  
  @ManyToOne
  private Customer customer;
  
  // getters and setters
}
```

This tells the JPA framework that there is a many-to-one relationship between the Order entity class and the Customer entity class in the database table, which means that multiple Order records can correspond to one Customer record.

@JoinColumn is used to define the column used for the association between entities. When used in combination with @ManyToOne, it specifies the foreign key column in the owning entity that references the primary key of the related entity.

```java
@Entity
public class Order {
  @Id
  private Long id;
  
  // other fields
  
  @ManyToOne
  @JoinColumn(name = "customer_id")
  private Customer customer;
  
  // getters and setters
}
```

In this example, @JoinColumn annotation is used to specify the name of the foreign key column. This will create a column named "customer_id" in the database to establish the many-to-one relationship between the Order and Customer entity classes.

## @OneToMany

@OneToMany is a Java annotation used in Object-Relational Mapping (ORM) frameworks, such as Hibernate or JPA (Java Persistence API). It is used to define a one-to-many relationship between two entities in a database schema.

In a one-to-many relationship, one instance of an entity (the "one" side) can be associated with multiple instances of another entity (the "many" side"). For example, a customer can have multiple orders, or a university can have multiple students.

Using @OneToMany, we can annotate a field in an entity class that represents the "many" side of the relationship. This field typically holds a collection (e.g. a List or a Set) of instances of the other entity.

```java
@Entity
public class Customer {
 
    @OneToMany(mappedBy = "customer")
    private List<Order> orders;
 
    // other fields and methods
}
```

## @ManyToMany

@ManyToMany is a JPA annotation used to define a many-to-many relationship between two entities. In a many-to-many relationship, an instance of one entity can be related to multiple instances of another entity, and vice versa.

In JPA, a many-to-many relationship is implemented using an intermediary table that holds the foreign keys of both entities. The @ManyToMany annotation is typically used to define this intermediary table and the relationships between the entities.

## @JoinTable

@JoinTable is a JPA annotation used in object-relational mapping to define the association between two entities in a many-to-many relationship. It is used to join the tables of the two entities that have a many-to-many relationship.

```java
/**
* sku和inventory是M:N的关系
* 仓库ID，表示可以下单到哪些仓库
*/
@ManyToMany(fetch = FetchType.LAZY)
@JoinTable(name = "sku_inventory",
joinColumns = @JoinColumn(name = "sku_id"),
inverseJoinColumns = @JoinColumn(name =
"inventory_id"))
private Set<PmsInventory> pmsInventories = new HashSet<>();

```


# Annotations Used by Controller

## @RestController

The `@RestController` annotation is a convenience annotation in Spring that is itself annotated with `@Controller` and `@ResponseBody`. This annotation is applied to a class to mark it as a request handler for creating RESTful web services using Spring MVC.

When the `@RestController` annotation is used on a class, it indicates that all of its methods return **JSON** or **XML** responses directly to the client. The `@ResponseBody` annotation is used to indicate that the return value of a method should be written directly to the HTTP response body, rather than being interpreted as a view name.

```java
@RestController
public class PostController {
}
```
## @RequestMapping

The `@RequestMapping` annotation is used to map HTTP requests to methods in the controller. You can use this annotation to specify the URL path, HTTP method, and other attributes.

```java
@RestController
@RequestMapping("/api/v1/posts")
public class PostController {
}
```
## @PostMapping

The `@PostMapping` is a Spring framework annotation used to map HTTP POST requests to specific handler methods. When a browser sends a POST request to the server, the method annotated with @PostMapping will handle the request.

```java
@RestController
@RequestMapping("/api/v1/posts")
public class PostController {

    @PostMapping
    public ResponseEntity<PostDto> createPost(@RequestBody PostDto postDto){
        return new ResponseEntity<>(postService.createPost(postDto), HttpStatus.CREATED);
    }
}
```
## @RequestBody

The `@RequestBody` annotation is used to map the request body to a Java object. This is useful for accepting JSON or XML payloads in a RESTful service

```java
@RestController
@RequestMapping("/api")
public class UserController {   
    @PostMapping("/users")
    public User createUser(@RequestBody User user) {
        return userService.createUser(user);
    }
    
}
```

## @GetMapping

@GetMapping is a Spring Framework annotation used in Java to map HTTP GET requests to a specified controller method. This annotation can be used to handle incoming HTTP GET requests to a Spring Controller, and return the appropriate response.

```java
@Controller
@RequestMapping("/users")
public class UserController {
 
   @GetMapping("/{id}")
   public ResponseEntity<User> getUser(@PathVariable("id") Long id) {
      User user = userService.getUserById(id);
      return ResponseEntity.ok(user);
   }
}
```

## @PutMapping

@PutMapping is a Spring Framework annotation used in Java to map HTTP PUT requests to a specified controller method. This annotation can be used to handle incoming HTTP PUT requests to a Spring Controller, and update a resource or entity with the provided data.

```java
@Controller
@RequestMapping("/users")
public class UserController {
 
   @PutMapping("/{id}")
   public ResponseEntity<User> updateUser(@PathVariable("id") Long id, @RequestBody User updatedUser) {
      User user = userService.getUserById(id);
      
      // update user with new data
      user.setName(updatedUser.getName());
      user.setEmail(updatedUser.getEmail());
      // etc.
      
      User savedUser = userService.saveUser(user);
      return ResponseEntity.ok(savedUser);
   }
}
```
## DeleteMapping

@DeleteMapping is a Spring Framework annotation used in Java to map HTTP DELETE requests to a specified controller method. This annotation can be used to handle incoming HTTP DELETE requests to a Spring Controller, and delete a resource or entity with the provided data.

```java
@Controller
@RequestMapping("/users")
public class UserController {
 
   @DeleteMapping("/{id}")
   public ResponseEntity<Void> deleteUser(@PathVariable("id") Long id) {
      userService.deleteUser(id);
      return ResponseEntity.noContent().build();
   }
}
```

## @RequestParam 

@RequestParam is a Spring annotation used to bind request parameters (such as query parameters) to a method parameter in a controller handler method.

It allows the values of the request parameters to be retrieved and converted to the appropriate type before being passed into the controller method. By default, @RequestParam expects that the parameter is required, but it can be configured to be optional using the required attribute.

```java
@GetMapping("/users")
public List<User> getUsers(@RequestParam("active") boolean isActive, 
                            @RequestParam(value = "sort", defaultValue = "name") String sortBy) {
    // Do something with isActive and sortBy parameters
    ...
}

```

## @PathVariable

@PathVariable is a Spring annotation used to extract a variable from the URI path and use it as a method parameter in a Spring MVC controller. It allows you to map a URI template variable to a method parameter.

For example, consider the following URL: http://example.com/users/123. In this URL, 123 is the value of the userId path variable. You can use @PathVariable to extract this value from the URL and pass it as a method parameter to your controller method.

```java
@RestController
@RequestMapping("/users")
public class UserController {

    @GetMapping("/{userId}")
    public User getUserById(@PathVariable(name = "userId") Long userId) {
        // code to retrieve user by ID
    }
}

```

## validations

**@NotNull:** Validates that the annotated field is not null.

**@Size:** Validates that the annotated field has a size within the specified range.

**@Email:** Validates that the annotated field is a valid email address.

**@Pattern:** Validates that the annotated field matches the specified regular expression.

**@Min:** Validates that the annotated field is a number greater than or equal to the
specified value.

**@Max:** Validates that the annotated field is a number less than or equal to the specified value.

**@NotBlank:** Validates that the annotated field is not blank (i.e., contains at least one non-whitespace character).

**@NotEmpty:** Validates that the annotated field is not empty (i.e., not null and has a length greater than zero).

# Annotations Used by Service

## @Service
The `@Service` is a Spring framework annotation used to indicate that a particular class is a service.
```java
@Service
public class PostServiceImplement implements PostService {
}
```

## @Autowired

@Autowired is a Spring Framework annotation used in Java to automatically wire a dependency to a Spring bean. This annotation can be used to inject an instance of a Spring bean into another bean, without requiring the developer to explicitly configure the dependency injection.

When a Spring bean is created, the Spring container checks its dependencies and attempts to find a suitable bean from the application context to inject. If a suitable bean is found, it is automatically injected into the field or constructor of the dependent bean.

```java
@Service
public class UserServiceImpl implements UserService {
 
   @Autowired
   private UserRepository userRepository;
 
   // other methods
}
```

In this example, the UserServiceImpl class is annotated with the @Service annotation to indicate that it is a Spring service bean. The UserRepository dependency is injected into the class using the @Autowired annotation on the field declaration. When the Spring container creates an instance of the UserServiceImpl bean, it will automatically inject an instance of the UserRepository bean into the userRepository field.

## @Transactional

@Transactional is an annotation used in Spring Framework to indicate that a method should be executed within a transaction. The annotation can be applied to class or method level, and it provides declarative transaction management, simplifying the code needed to manage transactions.It ensures that the method is executed as an atomic operation, with all changes made to the database either committed if the operation is successful or rolled back if it fails.

```java
  @Transactional
    public OrderResponse placeOrder(OrderRequest orderRequest) {
        Order order = orderRequest.getOrder();
        order.setStatus("INPROGRESS");
        order.setOrderTrackingNumber(UUID.randomUUID().toString());
        orderRepository.save(order);

        Payment payment = orderRequest.getPayment();
        if(!payment.getType().equals("DEBIT")){
            throw new PaymentException("Payment card type do not support");
        }
        payment.setOrderId(order.getId());
        paymentRepository.save(payment);

        OrderResponse orderResponse = new OrderResponse();
        orderResponse.setOrderTrackingNumber(order.getOrderTrackingNumber());
        orderResponse.setStatus(order.getStatus());
        orderResponse.setMessage("SUCCESS");
        return orderResponse;

    }
```

# Annotations Used by Repository

## @Repository 

@Repository is a Spring Framework annotation that marks a class as a repository component, typically used to perform database operations. It serves as a specialization of the @Component annotation, allowing for automatic bean detection through classpath scanning.

By marking a class with @Repository, Spring will perform exception translation from exceptions such as SQLException and DataAccessException to the Spring hierarchy of unchecked exceptions. This helps to decouple the application code from persistence-specific exceptions.

Additionally, @Repository is used to indicate that an exception in the repository layer should be caught and then translated to a meaningful, high-level exception that can be handled by the application layer.

```java
@Repository
public class PostJPQLRepositoryImpl implements PostJPQLRepository{

}
```

## @PersistenceContext

@PersistenceContext is a Spring annotation used to inject a javax.persistence.EntityManager instance into a Spring-managed bean. It allows the container to provide a JPA EntityManager instance to the application context. This annotation helps to simplify the use of the JPA API in a Spring application. By using @PersistenceContext, developers do not need to create and manage the EntityManager instance themselves.

```java
 @PersistenceContext
    EntityManager entityManager;
```

## @NamedQuery and @NamedQueries

In JPA, @NamedQuery and @NamedQueries are used to define pre-defined JPQL queries that can be executed multiple times with different parameter values.

@NamedQuery is used to define a single JPQL query that can be executed by its name.
```java
@NamedQuery(name = "findAllEmployees", query = "SELECT e FROM Employee e")

```

@NamedQueries is used to define multiple named JPQL queries that can be executed by their respective names.
```java
@NamedQueries({
    @NamedQuery(name = "findAllEmployees", query = "SELECT e FROM Employee e"),
    @NamedQuery(name = "findEmployeesByDepartment", query = "SELECT e FROM Employee e WHERE e.department = :department")
})

```

# Other

## @CompnonentScan

@ComponentScan is an annotation in Spring that is used to instruct the Spring container to scan for and register beans (components) within a specified package or set of packages.

When Spring scans the specified package(s), it looks for classes annotated with @Component, @Service, @Repository, @Controller, or any custom annotations that are themselves annotated with @Component. These classes are then registered as beans in the Spring container, which can be subsequently injected into other classes.

```java
@Configuration
@ComponentScan("com.example.app")
public class AppConfig {
    // other configuration
}
```
## @SpringbootApplication

**@SpringBootApplication** is an annotation in Spring Boot that is used to combine the functionality of three annotations: @Configuration, @EnableAutoConfiguration, and @ComponentScan.

```java
@SpringBootApplication
public class MyApp {
    public static void main(String[] args) {
        SpringApplication.run(MyApp.class, args);
    }
}
```

## @Qualifier

**@Qualifier:** @Qualifier is used in conjunction with @Autowired to specify which bean to inject when there are multiple beans of the same type. We can use @Qualifier to specify the name of the bean to inject, as defined by the @Component or @Bean annotation.

```java
@Service
public class MyService {
    
    private final MyRepository myRepository;
    
    @Autowired
    public MyService(@Qualifier("myRepositoryImpl") MyRepository myRepository) {
        this.myRepository = myRepository;
    }
    
    // ...
}
```

## @Value

@Value is an annotation in Spring framework that is used to inject values from external sources into Spring-managed beans. It can be applied to fields, methods, or constructor parameters.

When you use @Value annotation, you can provide a value expression or a placeholder that resolves to a value. The value can be retrieved from various sources such as properties files, environment variables, system properties, or command line arguments.

```java

@Component
public class MyComponent {
    @Value("${my.property}")
    private String myProperty;

    // ...
}
```

## @PreAuthorize

@PreAuthorize is an annotation provided by the Spring Security framework that is used to define method-level security expressions for authorization purposes. It allows you to specify access control rules directly on methods to restrict or allow access based on certain conditions.

When you apply the @PreAuthorize annotation to a method, it indicates that the method can only be executed if the specified authorization expression evaluates to true. If the expression evaluates to false, an exception will be thrown, indicating access denied.

```java
@Service
public class MyService {
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public void performAdminAction() {
        // Perform admin action
    }
}
```

# AOP

## @Aspect 
@Aspect  is an annotation used to define an aspect in aspect-oriented programming (AOP). 

## @Pointcut 

@Pointcut is an annotation used to define a pointcut. A pointcut specifies a set of join points in the application's codebase where advice, defined in an aspect, should be applied.

## @Around

@Around annotation is used to define advice that surrounds a join point, allowing the aspect to control the execution flow before and after the target method invocation.

**Advice: before/after/around/afterThrowing - When to execute aop methods when the application pointcut is found.**

### @Before – Run before the method execution

### @After – Run after the method returned a result

### @AfterReturning – Run after the method returned a result, intercept the 
returned result as well.

### @AfterThrowing – Run after the method throws an exception

### @Around – Run around the method execution, combine all three advices above.

### @Aspect - indicate this is a aop class

### @Component - This annotation mark the beans as Spring’s managed 
components

### @Before annotated methods run exactly before all methods matching with 
pointcut expression

