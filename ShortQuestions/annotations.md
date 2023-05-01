`@SpringBootApplication`  
This annotation is used to bootstrap and configure a Spring Boot application. It includes @Configuration, @EnableAutoConfiguration and @ComponentScan annotations.
```aidl
@SpringBootApplication
public class MyApp {
   public static void main(String[] args) {
      SpringApplication.run(MyApp.class, args);
   }
}
```

`@Controller`  
This is an annotation that marks a class as a controller class, so this class will receive http requests, deserializes input,  validates input, calls the business logic and serializes the output

`@ResponseBody `  
tells the controller that the object returned is automatically written into HttpResponse as Json or XML. Using Spring MVC, a method should return a page, if we want the method to return only data, we need to tell the Spring MVC to take the return type as a body of the response by adding the `@ResponseBody` annotation  

`@RestController` 
is the same as `@Controller` + `@ResponseBody`

`@RequestMapping` 
is used to map HTTP requests to Spring controller methods. For example, we can use it with class to create the base URI

`@GetMapping` 
annotated method is to handle HTTP Get requests matched the given URI. It is a shortcut for `@RequestMapping(method = RequestMethod.GET)`
```aidl
@RestController
@RequestMapping("/api")
public class MyController {
   @GetMapping("/hello")
   public String sayHello() {
      return "Hello World";
   }
}
```

`@Repository` 
is to indicate that an interface or class provides data access and CRUD operations to DB
```aidl
@Repository
public interface MyRepository extends JpaRepository<MyEntity, Long> {
   // ...
}
```

`@Component`
is to declare a class as a bean that should be managed by the Spring Container
```aidl
@Component
public class MyComponent {
   // ...
}
```

`@EnableAutoConfiguration`
is to enable Spring Boot's auto-configuration mechanism.
```aidl
@EnableAutoConfiguration
public class MyConfig {
   // ...
}
```

`@Autowired`
is to inject dependency
```aidl
@Service
public class MyService {
   @Autowired
   private MyRepository myRepository;
   // ...
}
```

`@RequestBody` 
deserializes an HttpRequest body into a java object
```aidl
@RestController
@RequestMapping("/api")
public class MyController {

   @PostMapping("/user")
   public ResponseEntity<?> createUser(@RequestBody User user) {
      // Do something with the user object
      return ResponseEntity.ok("User created successfully");
   }
   
}
```

`@RequestParam` 
is to extract query parameters from the request

`@PathVariable` 
is to extract values from the URI path. We need to make sure that the number and order of path variables in the url match the ones in the method

`@RequestHeader`
this annotation is to extract the header from the request

`@ResponseStatus`
used to specify the response status of a controller method

`@ExceptionHandler`
This annotation is used to handle exception. If it is used on a method in a controller class, means that it will handle the exceptions thrown within this controller only. If we specify some exception inside the annotation, means that this method will only handle this kind of exception thrown within this controller.
```aidl
@RestController
@RequestMapping("/api")
public class MyController {

   @GetMapping("/user/{id}")
   public ResponseEntity<User> getUserById(@PathVariable Long id) {
      // Code to fetch user by id
      if (user == null) {
         throw new UserNotFoundException("User not found with id " + id);
      }
      return ResponseEntity.ok(user);
   }
   
   @ExceptionHandler(UserNotFoundException.class)
   public ResponseEntity<String> handleUserNotFoundException(UserNotFoundException ex) {
      return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
   }
}
```

## hw8
`@Query`
is an annotation in Spring Boot that allows you to declare a query using a SQL statement, JPQL, or native query for your data access method.
```aidl
@Query("Select p from Post where p.id = ?1 or p.title = ?2) 
@Query("Select p from Post where p.id = :key or p.title = :title)
```
The first query uses positional parameters "?1" and "?2" to represent the ID and title values, respectively. This means that the parameter values are passed to the query in the order they appear, and their position is used to identify which parameter corresponds to which condition in the query.

The second query uses named parameters ":key" and ":title" to represent the ID and title values, respectively. This means that the parameter values are passed to the query using their assigned names, rather than their positions in the query.

---

`@Column` specifies the information of this column, like name in database, can be null or not in database
```aidl
@Column(name = "description", nullable = false)
```
---
`@OneToOne` is a JPA annotation used in Spring Boot to establish a one-to-one relationship between two entities. 
This annotation can be used to define the relationship between the two entities at the object level, which is then mapped to a database table relationship.

`@JoinColumn` annotation is used to specify the join column between the two entities. 
```@Entity
public class Employee {

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "address_id", referencedColumnName = "id")
    private Address address;

    // getters and setters
}

@Entity
public class Address {

    @Id
    @GeneratedValue
    private Long id;

    private String street;

    private String city;

    private String state;

    private String zipCode;

    // getters and setters
}
```
In this example, the `Employee` entity has a `@OneToOne` relationship with the `Address` entity. The `@OneToOne` annotation is used to define the relationship and the `cascade` attribute is set to `CascadeType.ALL` to propagate all changes to the `Address` entity.

The `@JoinColumn` annotation is used to specify the join column between the two entities. In this case, the join column is named `address_id` and references the `id` column in the `Address` entity.

With this setup, you can use the `Employee` entity to retrieve or persist data from the database, including the `Address` entity that is associated with it.

---
`@ManyToOne` is a JPA annotation used in Spring Boot to establish a many-to-one relationship between two entities. This annotation can be used to define the relationship between the two entities at the object level, which is then mapped to a database table relationship.

---
`@JoinTable` is a JPA annotation used in Spring Boot to define a many-to-many relationship between two entities. This annotation is used to specify the join table that maps the relationship between the two entities.
```aidl
@ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "sku_inventory",
            joinColumns = @JoinColumn(name = "sku_id"),
            inverseJoinColumns = @JoinColumn(name = "inventory_id"))
    private Set<Inventory> inventories = new HashSet<>();
```
The `@JoinTable` annotation is used to specify the join table that maps the relationship between the two entities. In this case, the join table is named `sku_inventory` and has two columns, `sku_id` and `inventory_id`, which are mapped to the id columns in the `SKU` and `Inventory` entities, respectively.

---
`@NamedQuery` annotation is used to define a named query in JPQL for an entity. JPQL (Java Persistence Query Language) is a query language used to retrieve data from databases in Java applications using JPA (Java Persistence API).  
JPQL (Java Persistence Query Language) is a query language used to retrieve data from databases in Java applications using JPA (Java Persistence API).
```aidl
@Entity
@NamedQuery(name="get_all_posts", query="SELECT p FROM Post p")
public class Post {
    // Entity fields and methods
}
```
In this example, the `@NamedQuery` annotation is used to define a named query with the name `get_all_posts` and the JPQL query `SELECT p FROM Post p`. This named query can be later referred to in your code using the name `get_all_posts`.

---
`@EnableTransactionManagement` is a Spring annotation that is used to enable transaction management in a Spring application. When this annotation is applied to a configuration class, Spring will automatically detect and apply transactional behavior to any bean that is marked with the `@Transactional` annotation.

`@Transactional` annotation is used to mark a method or class as transactional. When this annotation is applied to a method or class, Spring will ensure that the annotated method is executed within a transactional context. If the annotated method executes successfully, the transaction will be committed, and any changes made to the database will be persisted. If an exception is thrown during the execution of the annotated method, the transaction will be rolled back, and any changes made to the database will be undone.
