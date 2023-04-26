# 1. List all of the new annotations to your annotations.md and explain its role. 
I have upload in `qiuchen_lei/notes/annotations`

# 2. how do you do the debug? 
- Logging: One of the most common ways to debug in Spring is by logging. 
- Debugging with an IDE
- Debugging with Spring Boot Actuator: Spring Boot Actuator is a tool that provides endpoints for monitoring and managing your Spring application at runtime. 
- Using the Spring Boot devtools: Spring Boot devtools is a set of tools that provide fast application restarts, live reload of static resources, and other features to improve the development experience. 

# 3.What is DTO, VO, Payload, DO, model? 
- DTO (Data Transfer Object): A DTO is an object that is used to transfer data between layers or tiers of an application, such as between the front-end and back-end or between microservices. It typically contains only the data that is needed for a particular operation or request, and it is often used to reduce network traffic and improve performance.

- VO (Value Object): A VO is a type of DTO that represents a single, immutable value or a set of related values. It is often used to encapsulate data that has some business meaning or rules attached to it, such as a currency or a date range. Unlike DTOs, VOs are typically used within the same layer of an application, rather than being passed between layers.

- Payload: A payload is the data that is sent over a network or messaging system as part of a request or response. It can include DTOs, VOs, and other types of data, and it is often serialized into a specific format, such as JSON or XML.

- DO (Domain Object): A DO is an object that represents a domain entity or business object within an application. It contains both data and behavior, and it is often used to model complex business logic and rules. DOs typically have a one-to-one mapping with database tables or other persistence mechanisms.

- Model: The term "model" can refer to several different concepts, depending on the context. In general, it refers to the representation of data or information in a structured format. In the context of a Spring MVC application, the Model is the data that is passed to the view for rendering. In the context of an MVC framework like Ruby on Rails or Django, the Model is the layer that represents the business logic and interacts with the database.

# 4. What is @JsonProperty? 
In Java, @JsonProperty is an annotation that is used to map JSON property names to Java object fields or getters/setters. 
It is commonly used in serialization and deserialization of JSON data.
When a Java object is serialized to JSON format, the @JsonProperty annotation can be used to customize the name of the JSON property that corresponds to a particular Java field or getter/setter method. 
For example, consider the following Java class:
```
public class Person {
    private String firstName;
    private String lastName;

    @JsonProperty("first_name")
    public String getFirstName() {
        return firstName;
    }

    @JsonProperty("last_name")
    public String getLastName() {
        return lastName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}

```

# 5. do you know what is jackson? 
Yes, Jackson is a popular open-source library for working with JSON data in Java. 
It provides a set of APIs for serializing and deserializing JSON data to and from Java objects, as well as for manipulating JSON data directly.
For example, Streaming API

# 6. what is spring-boot-stater?
In Java Spring Boot, a "starter" is a dependency or set of dependencies that provides a specific set of functionality to your Spring Boot application. 
A starter typically includes a set of pre-configured dependencies that work together to provide a specific feature, such as data access or web services.

# 7. do you know `@RequestMapping(value = "/users", method = RequestMethod.POST)` ? could you list CRUD by this style?
This annotation is used to map an HTTP POST request to the "/users" endpoint in a Spring controller.

Here are examples of how to use @RequestMapping to implement CRUD (Create, Read, Update, Delete) operations in a RESTful API style:
- Create (POST)
```
@RequestMapping(value = "/users", method = RequestMethod.POST)
public ResponseEntity<User> createUser(@RequestBody User user) {
    // Save the user to the database
    userRepository.save(user);

    // Return a response with HTTP status code 201 (Created)
    return new ResponseEntity<>(user, HttpStatus.CREATED);
}
```

- Read (GET)
```
@RequestMapping(value = "/users/{id}", method = RequestMethod.GET)
public ResponseEntity<User> getUser(@PathVariable("id") Long id) {
    // Find the user with the specified ID
    Optional<User> optionalUser = userRepository.findById(id);

    // If the user is not found, return HTTP status code 404 (Not Found)
    if (!optionalUser.isPresent()) {
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    // Otherwise, return the user with HTTP status code 200 (OK)
    User user = optionalUser.get();
    return new ResponseEntity<>(user, HttpStatus.OK);
}
```

- Update (PUT)
```
@RequestMapping(value = "/users/{id}", method = RequestMethod.PUT)
public ResponseEntity<User> updateUser(@PathVariable("id") Long id, @RequestBody User user) {
    // Find the user with the specified ID
    Optional<User> optionalUser = userRepository.findById(id);

    // If the user is not found, return HTTP status code 404 (Not Found)
    if (!optionalUser.isPresent()) {
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    // Otherwise, update the user and return with HTTP status code 200 (OK)
    User updatedUser = optionalUser.get();
    updatedUser.setName(user.getName());
    updatedUser.setEmail(user.getEmail());
    userRepository.save(updatedUser);

    return new ResponseEntity<>(updatedUser, HttpStatus.OK);
}
```

- Delete (DELETE)
```
@RequestMapping(value = "/users/{id}", method = RequestMethod.DELETE)
public ResponseEntity<Void> deleteUser(@PathVariable("id") Long id) {
    // Find the user with the specified ID
    Optional<User> optionalUser = userRepository.findById(id);

    // If the user is not found, return HTTP status code 404 (Not Found)
    if (!optionalUser.isPresent()) {
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    // Otherwise, delete the user and return with HTTP status code 204
```

# 8. What is ResponseEntity? why do we need it?
In Java Spring, ResponseEntity is a class that represents an HTTP response, including the status code, headers, and body. It is commonly used to return responses from Spring controller methods in a RESTful API style.

# 9. What is ResultSet in jdbc? and describe the flow how to get data using JDBC
In Java, JDBC (Java Database Connectivity) is an API that provides a standard way to interact with relational databases.
- Load the JDBC driver
- Create a Connection object
- Create a Statement object
- Execute the SQL statement
- Iterate over the ResultSet
- Close the ResultSet, Statement, and Connection

# 10. What is the ORM framework?
ORM (Object-Relational Mapping) is a programming technique used to map data from a relational database to an object-oriented programming language. 
An ORM framework is a software tool that automates this process by mapping database tables and their relationships to object classes and their associations.

# 11. Learn how to use ObjectMapper by this example.
`Coding/FoodOutletJackson.java`

# 12. What is the serialization and desrialization?
Serialization is the process of converting an object into a format that can be stored or transmitted over a network. Deserialization is the process of converting the serialized data back into an object.

# 13. use stream api to get the average of the array [20, 3, 78, 9, 6, 53, 73, 99, 24, 32].
`Coding/StreamAverageExample.java`

# 14. 
`MavenProject/springboot-redbook-03_post_pageable`

# 15. 抄写 https://github.com/TAIsRich/springboot-redbook/tree/04_comm 

# 16. Try to write the CRUD api for a new application Cassandra-Blog
Try to write the CRUD api for a new application Cassandra-Blog
Spring 提供了相关dependency,(https://start.spring.io/) , Spring Data for Apache Cassandra
- Create a BlogPost entity class:
```
@Table("blog_posts")
public class BlogPost {

    @PrimaryKeyColumn(name = "id", ordinal = 0, type = PrimaryKeyType.PARTITIONED)
    private UUID id;

    @Column("title")
    private String title;

    @Column("content")
    private String content;

    // constructors, getters and setters
}

```

- Create a BlogPostRepository interface that extends CassandraRepository:
```
@Repository
public interface BlogPostRepository extends CassandraRepository<BlogPost, UUID> {
}

```

- Create a BlogPostService class that uses the repository to perform CRUD operations:
```
@Service
public class BlogPostService {

    @Autowired
    private BlogPostRepository blogPostRepository;

    public BlogPost createBlogPost(BlogPost blogPost) {
        return blogPostRepository.save(blogPost);
    }

    public BlogPost getBlogPost(UUID id) {
        Optional<BlogPost> result = blogPostRepository.findById(id);
        return result.orElse(null);
    }

    public List<BlogPost> getAllBlogPosts() {
        return (List<BlogPost>) blogPostRepository.findAll();
    }

    public BlogPost updateBlogPost(UUID id, BlogPost blogPost) {
        BlogPost existingBlogPost = getBlogPost(id);
        if (existingBlogPost == null) {
            return null;
        }
        blogPost.setId(id);
        return blogPostRepository.save(blogPost);
    }

    public void deleteBlogPost(UUID id) {
        blogPostRepository.deleteById(id);
    }
}

```

- Create a BlogPostController class that exposes the API endpoints:
```
@RestController
@RequestMapping("/api/blogposts")
public class BlogPostController {

    @Autowired
    private BlogPostService blogPostService;

    @PostMapping("")
    public BlogPost createBlogPost(@RequestBody BlogPost blogPost) {
        return blogPostService.createBlogPost(blogPost);
    }

    @GetMapping("/{id}")
    public BlogPost getBlogPost(@PathVariable("id") UUID id) {
        return blogPostService.getBlogPost(id);
    }

    @GetMapping("")
    public List<BlogPost> getAllBlogPosts() {
        return blogPostService.getAllBlogPosts();
    }

    @PutMapping("/{id}")
    public BlogPost updateBlogPost(@PathVariable("id") UUID id, @RequestBody BlogPost blogPost) {
        return blogPostService.updateBlogPost(id, blogPost);
    }

    @DeleteMapping("/{id}")
    public void deleteBlogPost(@PathVariable("id") UUID id) {
        blogPostService.deleteBlogPost(id);
    }
}

```



