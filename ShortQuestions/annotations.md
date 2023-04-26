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