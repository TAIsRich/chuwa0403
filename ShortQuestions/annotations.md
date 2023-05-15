## Core
- @Autowired

It is used to autowire spring bean on setter methods, instantce variable, and constructor. When we use @Autowired annotation, the spring container auto-wires the bean by matching data-type.

```
public class PostController{
    @Autowired
    private PostService postService;
}
```

## Controller:
- @Contoller

- @RequestMapping
It is used to map web requests onto specific handler classes and handler methods. When it is used on class level it creates a base URI for which the controller will be used. When this annotation is used on methods it will give you the URI on which the handler methods will be executed. 
To define endpoint:
    - @GetMapping
    - @PostMapping
    - @PutMapping
    - @PatchMapping
    - @DeleteMapping
```
@RequestMapping("/api/v1/posts")
public class PostController{

    ...
    @PostMapping
    public ResponseEntity<PostDto> createPost(@RequestBody PostDto postDto){
        ...
    }

    @GetMapping
    public List<PostDto> getAllPosts(){
        ...
    }

    @GetMapping("/{id}")
    public ResponseEntity<PostDto> getPostById(@PathVariable(name = "id") long id){
        ...
    }

    @PutMapping("/{id}")
    public ResponseEntity<PostDto> updatePost(@RequestBody PostDto postDto, @PathVariable(name = "id") long id){
        ...
        }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletePost( @PathVariable(name = "id") long id){
        ...
    }
}
```

## JPA
- @Entity
It identifies a class as an entity class.
- @Table
By default, each entity class maps a database table with the same name in the default schema of your database. You can customize this mapping using the name, schema, and catalog attributes of the @Table annotation.
```
@Entity
@Table(name = "AUTHORS", ...)
public class Author {
    ...
}
```
- @Column
It enables you to customize the mapping between the entity attribute and the database column. 
- @Id
JPA and Hibernate require you to specify at least one primary key attribute for each entity. 
- @GeneratedValue
Use a database sequence by setting the strategy attribute to `GenerationType.SEQUENCE`. Use an auto-incremented database column to generate your primary key values to `GenerationType.IDENTITY`.
```
    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    private Long id;

    @Column(nullable = false)
    private String title;
```

# Component
- @Repository
This annotation indicates that the class deals with CRUD operations, usually it’s used with DAO implementations that deal with database tables.

# Exception
- @ControllerAdvice: Class Level. It is used to handle the exceptions globally.
- @ExceptionHandler: Method Level. It is used to handle the specific exceptions and send the custom responses to the client.

# 
@Value: get value from application.properties. @Value("${propertyName}") with a varibale. The value of the property will pass to the variable.
