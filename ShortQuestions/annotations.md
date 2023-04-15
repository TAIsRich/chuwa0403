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
# Annotations Used by Service

## @Service
The `@Service` is a Spring framework annotation used to indicate that a particular class is a service.
```java
@Service
public class PostServiceImplement implements PostService {
}
```
