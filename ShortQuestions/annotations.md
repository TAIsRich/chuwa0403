# Annotations in Java
## 1. @Override:
This annotation is used to indicate that a method in a subclass is intended to override a method in the superclass. This helps catch errors at compile-time if the method name or signature in the subclass does not match that of the superclass method it is supposed to override.
```java
public class MyBaseClass {
    public void myMethod() {
        // Some code here
    }
}
public class MySubClass extends MyBaseClass {
    @Override
    public void myMethod() {
        // Override the superclass method
    }
}
```

## 2. @Entity

`@Entity` is a JPA annotation that is used to mark a Java class as a persistent entity. It indicates that an 
instance of this class represents a single row in a database table. When we annotate a Java class with `@Entity`, it tells JPA to create a table in the database with the same name as the class and with columns that match the fields of the class.

```java
@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private Double price;

    // Constructors, getters and setters, and other methods
}
```

## 3. @Id
`@Id` is a JPA annotation that is used to mark a field as the primary key of an entity. It is used along with the `@Entity` annotation to define a persistent entity class.
```java
@Entity
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;
    // getters and setters, constructors, and other methods
}
```

## 4. @GeneratedValue
`@GeneratedValue` is a JPA annotation that is used to specify the strategy for generating values for a field marked as a primary key using the @Id annotation. It can be used with the `@Id` annotation to specify the way primary key values should be generated for entities.
```java
@Entity
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;
    // getters and setters, constructors, and other methods
}
```

## 5. @Column
`@Column` is a JPA annotation that is used to map a Java class field to a database table column. It is used to define the properties of the column, such as its name, data type, and constraints.
```java
@Entity
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "full_name", nullable = false, length = 50)
    private String name;

    @Column(nullable = false)
    private String email;

    // Constructors, getters and setters, and other methods
}
```

## 6. @CreationTimestamp
`@CreationTimestamp` is a Hibernate-specific annotation that can be used to automatically set the value of a field to the current timestamp when an entity is persisted to the database for the first time. It can be applied to a field of type `java.util.Date` or `java.sql.Timestamp`.
```java
@Entity
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "created_at", nullable = false)
    private Date createdAt;

    // Constructors, getters and setters, and other methods
}
```

## 7. @UpdateTimestamp
`@UpdateTimestamp` is a Hibernate-specific annotation that can be used to automatically update the value of a field to the current timestamp whenever an entity is updated in the database. It can be applied to a field of type `java.util.Date` or `java.sql.Timestamp`.
```java
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @UpdateTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "last_updated_at")
    private Date lastUpdatedAt;

    // Constructors, getters and setters, and other methods
}
```

## 8. @Table
`@Table` is a JPA annotation that is used to specify the details of a database table that is associated with a particular entity. It can be used to specify the name of the table, its schema, the unique constraints on its columns, and other attributes.
```java
@Entity
@Table(name = "customers", schema = "public", uniqueConstraints = {@UniqueConstraint(columnNames = {"email", "phone"})})
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "email")
    private String email;

    @Column(name = "phone")
    private String phone;

    // Constructors, getters and setters, and other methods
}
```

## 9. @Repository
`@Repository` is a Spring Framework annotation that is used to indicate that a class is a repository, which is a type of component that is responsible for managing the persistence of domain objects to a database or other data source.

When a class is annotated with `@Repository`, Spring will automatically detect and register it as a bean in the application context, which can then be injected into other components using the `@Autowired` annotation or other dependency injection mechanisms.
```java
@Repository
public class CustomerRepository {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<Customer> findAll() {
        String sql = "SELECT id, name, email FROM customers";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Customer.class));
    }

    public Customer findById(Long id) {
        String sql = "SELECT id, name, email FROM customers WHERE id = ?";
        return jdbcTemplate.queryForObject(sql, new Object[]{id}, new BeanPropertyRowMapper<>(Customer.class));
    }

    public void save(Customer customer) {
        String sql = "INSERT INTO customers (name, email) VALUES (?, ?)";
        jdbcTemplate.update(sql, customer.getName(), customer.getEmail());
    }

    public void update(Customer customer) {
        String sql = "UPDATE customers SET name = ?, email = ? WHERE id = ?";
        jdbcTemplate.update(sql, customer.getName(), customer.getEmail(), customer.getId());
    }

    public void deleteById(Long id) {
        String sql = "DELETE FROM customers WHERE id = ?";
        jdbcTemplate.update(sql, id);
    }
}
```
In this example, the `CustomerRepository` class is annotated with `@Repository`, indicating that it is a repository. The class uses the Spring `JdbcTemplate` to interact with the database and provides methods for finding, saving, updating, and deleting customer entities. The `@Autowired` annotation is used to inject the `JdbcTemplate` into the class.

## 10. @Autowired
`@Autowired` is a Spring Framework annotation that is used to automatically inject dependencies into a class.

When a class field or constructor is annotated with `@Autowired`, Spring will automatically detect and inject the corresponding dependency into the field or constructor parameter. The dependency is typically another Spring-managed bean that has been registered with the application context.
```java
@Service
public class CustomerService {
    @Autowired
    private CustomerRepository customerRepository;

    public List<Customer> findAll() {
        return customerRepository.findAll();
    }

    public Customer findById(Long id) {
        return customerRepository.findById(id);
    }

    public void save(Customer customer) {
        customerRepository.save(customer);
    }

    public void update(Customer customer) {
        customerRepository.update(customer);
    }

    public void deleteById(Long id) {
        customerRepository.deleteById(id);
    }
}
```
Using `@Autowired` can help to simplify the wiring of components in your application and can make it easier to manage dependencies between beans. However, it is important to use it judiciously and to be aware of potential issues such as circular dependencies and ambiguous dependencies.

## 11. @Service
`@Service` is a Spring Framework annotation that is used to indicate that a class is a service, which is a type of component that provides some business logic to the application.

When a class is annotated with `@Service`, Spring will automatically detect and register it as a bean in the application context, which can then be injected into other components using the `@Autowired` annotation or other dependency injection mechanisms.
```java
@Service
public class CustomerService {
    @Autowired
    private CustomerRepository customerRepository;

    public List<Customer> findAll() {
        return customerRepository.findAll();
    }

    public Customer findById(Long id) {
        return customerRepository.findById(id);
    }

    public void save(Customer customer) {
        customerRepository.save(customer);
    }

    public void update(Customer customer) {
        customerRepository.update(customer);
    }

    public void deleteById(Long id) {
        customerRepository.deleteById(id);
    }
}
```
## 12. @RestController
`@RestController` is a Spring Framework annotation that is used to create RESTful web services.

When a class is annotated with `@RestController`, Spring will automatically register it as a controller in the application context, and map incoming HTTP requests to the appropriate methods.
```java
@RestController
public class HelloController {
    @GetMapping("/hello")
    public String sayHello() {
        return "Hello, world!";
    }
}
```
## 13. @RequestMapping
`@RequestMapping` is a Spring Framework annotation that is used to map HTTP requests to specific methods in a controller.

When a method is annotated with `@RequestMapping`, Spring will automatically map incoming HTTP requests to that method based on the specified request URL, method type, headers, and other parameters.
```java
@RestController
@RequestMapping("/api")
public class UserController {
    @GetMapping("/users")
    public List<User> getUsers() {
        // retrieve list of users from database
        return userList;
    }

    @PostMapping("/users")
    public void addUser(@RequestBody User user) {
        // save new user to database
    }

    @GetMapping("/users/{id}")
    public User getUserById(@PathVariable Long id) {
        // retrieve user from database by ID
        return user;
    }
}
```
In this example, the `UserController` class is annotated with `@RestController` to indicate that it is a RESTful web service controller. The class is also annotated with `@RequestMapping("/api")`, which specifies that all requests to this controller should be prefixed with `/api`.

The `getUsers()` method is annotated with `@GetMapping("/users")`, which maps the method to the `/api/users` endpoint using a GET request. The `addUser()` method is annotated with `@PostMapping("/users")`, which maps the method to the `/api/users` endpoint using a POST request. Finally, the `getUserById()` method is annotated with `@GetMapping("/users/{id}")`, which maps the method to the `/api/users/{id}` endpoint using a GET request and a path variable for the user ID.
## 14. @PostMapping
`@PostMapping` is a Spring Framework annotation that is used to map HTTP POST requests to a specific method in a controller.

When a method is annotated with `@PostMapping`, Spring will automatically map incoming HTTP POST requests to that method based on the specified request URL.
```java
@RestController
@RequestMapping("/api")
public class UserController {
    @PostMapping("/users")
    public void addUser(@RequestBody User user) {
        // save new user to database
    }
}
```
The `addUser()` method is annotated with `@PostMapping("/users")`, which maps the method to the /api/users endpoint using a POST request. The `@RequestBody` annotation is used to indicate that the `User` object in the request body should be automatically deserialized into a User object in the method parameter.

## 15. @RequestBody
`@RequestBody` is a Spring Framework annotation that is used to indicate that a method parameter should be bound to the body of the HTTP request.

When a method parameter is annotated with `@RequestBody`, Spring will automatically deserialize the body of the HTTP request into an object of the specified type. This can be useful when working with JSON or XML data in a RESTful web service, as it allows you to easily convert the incoming data into a Java object.
```java
@RestController
@RequestMapping("/api")
public class UserController {
    @PostMapping("/users")
    public void addUser(@RequestBody User user) {
        // save new user to database
    }
}
```

## 16. @PutMapping
`@PutMapping` is a Spring Framework annotation that is used to map HTTP PUT requests to a specific method in a controller.

When a method is annotated with `@PutMapping`, Spring will automatically map incoming HTTP PUT requests to that method based on the specified request URL.
```java
@RestController
@RequestMapping("/api")
public class UserController {
    @PutMapping("/users/{id}")
    public void updateUser(@PathVariable Long id, @RequestBody User user) {
        // update the user with the specified ID in the database
    }
}
```

## 16. @PathVariable
`@PathVariable` is a Spring Framework annotation that is used to bind a method parameter to a URI template variable in a request URL.

When a method parameter is annotated with `@PathVariable`, Spring will automatically extract the value of the corresponding URI template variable and pass it as an argument to the method.
```java
@RestController
@RequestMapping("/api")
public class UserController {
    @GetMapping("/users/{id}")
    public User getUserById(@PathVariable Long id) {
        // retrieve the user with the specified ID from the database
    }
}
```

## 17. @ResponseStatus
`@ResponseStatus` is a Spring Framework annotation that is used to declare the HTTP status code to be returned by a controller method when it successfully completes.

When a controller method is annotated with `@ResponseStatus`, Spring will automatically set the HTTP response status code to the specified value if the method completes successfully.
```java
@RestController
@RequestMapping("/api")
public class UserController {
    @PostMapping("/users")
    @ResponseStatus(HttpStatus.CREATED)
    public void createUser(@RequestBody User user) {
        // save the user in the database
    }
}
```
The `@ResponseStatus(HttpStatus.CREATED)` annotation is used to indicate that the HTTP response status code should be set to `201 Created` if the method completes successfully. This status code is typically returned by a successful POST request to indicate that a new resource has been created.


## 18. @JsonProperty
`@JsonProperty` is a Jackson annotation in Java that is used to specify the mapping between a Java object property and a JSON field during serialization and deserialization.
```java
public class Product {
    @JsonProperty("description_yyds")
    private String description;

    // other properties and methods
}
```
In this example, the `description` property of the `Product` class is annotated with `@JsonProperty("description_yyds")`. This means that during serialization, the property `description` will be mapped to the JSON field `description_yyds`, and during deserialization, the JSON field `description_yyds` will be mapped to the property `description`. This allows you to customize the naming of JSON fields in the serialized and deserialized JSON representations of the `Product` class.

## 19. @ManyToOne
`@ManyToOne` is a JPA annotation used to define a many-to-one relationship between two entities in a relational database. It is used to define a foreign key constraint between two tables where one table has multiple instances of another table's primary key value.

The `@ManyToOne` annotation is placed on the field or property in the dependent entity that represents the relationship to the parent entity. It requires a `@JoinColumn` annotation to specify the column in the dependent table that references the primary key column in the parent table.
```java
@Entity
public class Product {
    // ...
    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;
    // ...
}

@Entity
public class Category {
    // ...
    @OneToMany(mappedBy = "category")
    private List<Product> products;
    // ...
}
```
In this example, the `Product` entity has a many-to-one relationship with the `Category` entity. The `category` field in the `Product` entity is annotated with `@ManyToOne` to specify the relationship, and the `category_id` column in the `product` table is used as the foreign key to the `id` column in the `category` table. The `Category` entity has a one-to-many relationship with the `Product` entity, which is mapped by the `products` field.

