# Q2

Set a breakpoint: Place a breakpoint in your code by clicking in the left-hand gutter of the code editor window. You can also right-click on a line of code and select "Toggle Breakpoint" from the context menu.

Run your code in debug mode: Start your application in debug mode by selecting the "Debug" option from the run configuration drop-down menu. This will launch your application and pause execution at the first breakpoint it encounters.

Step through your code: Use the debugger controls to step through your code line by line, examine the values of variables, and evaluate expressions. You can use the "Step Over" button to execute the current line of code, "Step Into" to step into a method call, or "Step Out" to step out of a method and return to the caller.

Inspect variables and expressions: You can view the values of variables and expressions by hovering over them with your mouse or by opening the "Variables" or "Watches" windows.

Use the debugger console: You can use the debugger console to execute code and evaluate expressions during debugging. The console is available at the bottom of the IntelliJ IDEA window.

Fix the problem: Once you have identified the source of the problem, you can modify your code to fix it. You may need to continue debugging to verify that the problem has been resolved.

# Q3

DTO (Data Transfer Object): A DTO is a class that represents a data structure and is used to transfer data between layers of an application. DTOs are typically used to encapsulate data retrieved from a database or another data source and passed between layers of an application. DTOs often have a flat structure and contain only fields and no behavior.

VO (Value Object): A VO is a class that represents a value or object with specific characteristics. VO is similar to DTO but is used in a more domain-driven context. For example, a VO could represent a currency value or a date range, which may have special behavior or validation rules associated with them.

Payload: A payload is the data portion of a message or request that is transmitted over a network or between layers of an application. In RESTful APIs, the payload is typically represented as JSON or XML data and contains the data that is being transferred between the client and the server.

DO (Domain Object): A DO is a class that represents a domain entity or object within an application. DOs typically contain both data and behavior and may represent a business concept or real-world entity such as a customer, product, or order.

Model: A model is a class that represents the data and behavior of an entity or object within an application. A model may be used to represent a domain object, DTO, or VO, and is typically used to separate the concerns of data and behavior within an application.

# Q4

When Jackson serializes a Java object to JSON, it maps Java object fields to JSON properties. The @JsonProperty annotation allows you to specify the name of the JSON property that should be used for a particular Java field. In this case, the JSON property name is "description_yyds".

# Q5

It provides a set of APIs for reading and writing JSON data, as well as a powerful data-binding mechanism for converting JSON data to and from Java objects.

It is a Maven dependency declaration for the Jackson DataBind library, which is a core component of the Jackson library. It includes the necessary classes and methods for mapping JSON data to and from Java objects using data-binding. This library is typically used in web applications to handle RESTful API requests and responses, or to process JSON data in other contexts.

# Q6

a starter is a dependency that includes a set of related dependencies, configurations, and auto-configuration classes to help developers quickly set up a specific feature or functionality in their application.

spring-boot-starter-web is a starter that includes the necessary dependencies to build a web application using Spring Boot. It includes the following dependencies:

spring-boot-starter: core Spring Boot libraries
spring-boot-starter-web: Spring MVC and embedded Tomcat
spring-webmvc: Spring MVC framework
Jackson libraries: for JSON serialization and deserialization
spring-web: core Spring web-related libraries
Tomcat libraries: for embedded Tomcat server
By including spring-boot-starter-web in your project, you get everything you need to start building a web application with Spring Boot, without having to manually configure all the necessary dependencies.

# Q7

@RequestMapping(value = "/users", method = RequestMethod.POST) is a Spring MVC annotation used to map HTTP requests to a specific handler method that can process the request. In this case, it maps a POST request to the "/users" endpoint.

Here are some examples of how the CRUD operations can be mapped using this style:

Create (POST): @RequestMapping(value = "/users", method = RequestMethod.POST)
Read (GET): @RequestMapping(value = "/users/{id}", method = RequestMethod.GET)
Update (PUT): @RequestMapping(value = "/users/{id}", method = RequestMethod.PUT)
Delete (DELETE): @RequestMapping(value = "/users/{id}", method = RequestMethod.DELETE)

# Q8

ResponseEntity is a Spring class that represents an HTTP response, including status code, headers, and body. It is commonly used in Spring MVC controllers to return data in response to client requests.

We need ResponseEntity because it allows us to customize the HTTP response sent back to the client. We can set the response status code, add headers, and include a response body.

In the examples you provided:

new ResponseEntity<>(postResponse, HttpStatus.OK) creates a new ResponseEntity with a body of postResponse and a status code of OK (200). This might be used to indicate that the request was successful and return some data in the response body.

new ResponseEntity<>(postResponse, HttpStatus.CREATED) creates a new ResponseEntity with a body of postResponse and a status code of CREATED (201). This might be used to indicate that a new resource has been created as a result of the request, and return information about that new resource in the response body.

ResponseEntity.ok(postService.getPostById(id)) creates a new ResponseEntity with a body of postService.getPostById(id) and a status code of OK (200). This might be used to indicate that the request was successful and return the requested data in the response body.

# Q9

ResultSet is a Java interface in the JDBC API that represents the result set of a database query. It provides methods to iterate over the rows returned by a query and access the data in each row.

Here is a high-level overview of the flow to get data using JDBC:

Load the JDBC driver for the database you want to connect to, using Class.forName() method.
Create a Connection object to establish a connection to the database using DriverManager.getConnection() method.
Create a Statement object or a PreparedStatement object, depending on the type of query you want to execute.
Execute the query using the appropriate execute() method of the statement object. This will return a ResultSet object.
Iterate over the rows of the result set using the next() method of the ResultSet. Each time you call next(), it moves to the next row in the result set.
Access the data in each row using the getXXX() methods of the ResultSet, where XXX is the data type of the column you want to retrieve.
Close the ResultSet, Statement, and Connection objects when you are done with them, in the reverse order that you opened them.

# Q10

ORM stands for Object-Relational Mapping. It is a programming technique that allows developers to map between object-oriented programming languages and relational databases. ORM frameworks provide a set of tools and libraries to automate the mapping process and simplify database interactions.

ORM frameworks provide a layer of abstraction between the application code and the database, allowing developers to work with objects instead of writing SQL queries directly. The framework automatically generates the necessary SQL queries to interact with the database based on the object-oriented code, and maps the results of those queries back into objects.

Some popular ORM frameworks for Java include Hibernate, JPA (Java Persistence API), MyBatis, and Spring Data JPA. These frameworks provide features like entity mapping, transaction management, caching, and query generation to simplify database access and improve application performance.

# Q11

ObjectMapper objectMapper = new ObjectMapper();

```java
String resBody = "{\"name\": \"My Cafe\", \"location\": \"123 Main St\"}";
FoodOutlet foodOutlet = objectMapper.readValue(resBody, FoodOutlet.class);

// Serialize Java object to JSON using writeValueAsString() method
String s = objectMapper.writeValueAsString(foodOutlet);

// Parse JSON using readTree() method to get a JsonNode object
JsonNode jsonNode = objectMapper.readTree(resBody);
String name = jsonNode.get("name").asText();
String location = jsonNode.get("location").asText();
```

# Q12

Serialization is the process of converting an object from its in-memory representation to a byte stream, which can then be transmitted across a network or stored in a file or database. The byte stream represents the object's state, including its fields and values.

Deserialization is the reverse process, where the byte stream is converted back into an object with the same state as the original object. This allows objects to be transmitted or stored in a way that preserves their state and allows them to be reconstructed later.


# Q13

```java
int[] arr = {20, 3, 78, 9, 6, 53, 73, 99, 24, 32};

double average = Arrays.stream(arr)
                      .average()
                      .orElse(Double.NaN);

System.out.println("The average is " + average);

```

# Q16

```java
@Table("blog_post")
public class BlogPost {
    @PrimaryKey("id")
    private UUID id;

    @Column("title")
    private String title;

    @Column("content")
    private String content;

    // Constructors, getters, and setters
}


public interface BlogPostRepository extends CassandraRepository<BlogPost, UUID> {
}


@RestController
@RequestMapping("/blogposts")
public class BlogPostController {
    @Autowired
    private BlogPostRepository blogPostRepository;

    @GetMapping
    public List<BlogPost> getAllBlogPosts() {
        return blogPostRepository.findAll();
    }

    @GetMapping("/{id}")
    public BlogPost getBlogPostById(@PathVariable UUID id) {
        return blogPostRepository.findById(id).orElse(null);
    }

    @PostMapping
    public BlogPost createBlogPost(@RequestBody BlogPost blogPost) {
        return blogPostRepository.save(blogPost);
    }

    @PutMapping("/{id}")
    public BlogPost updateBlogPost(@PathVariable UUID id, @RequestBody BlogPost blogPost) {
        BlogPost existingBlogPost = blogPostRepository.findById(id).orElse(null);
        if (existingBlogPost != null) {
            existingBlogPost.setTitle(blogPost.getTitle());
            existingBlogPost.setContent(blogPost.getContent());
            return blogPostRepository.save(existingBlogPost);
        }
        return null;
    }

    @DeleteMapping("/{id}")
    public void deleteBlogPost(@PathVariable UUID id) {
        blogPostRepository.deleteById(id);
    }
}
```



















