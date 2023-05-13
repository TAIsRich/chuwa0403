# Annotations

## Spring

1. `@SpringBootApplication`

   This annotation is a combination of `@Configuration`, `@EnableAutoConfiguration`, and `@ComponentScan`. It is used to indicate that a class is a Spring Boot application and enables Spring Boot auto-configuration and component scanning features.

```java
@SpringBootApplication
public class MyApp {
   public static void main(String[] args) {
      SpringApplication.run(MyApp.class, args);
   }
}
```

2. `@Configuration`

   This annotation indicates that a class is a Spring configuration class and defines the beans that will be managed by the Spring container.

```java
@Configuration
public class AppConfig {
   @Bean
   public MyService myService() {
      return new MyServiceImpl();
   }
}
```

3. `@ComponentScan`

   This annotation is used to specify the packages that should be scanned for Spring components, such as controllers, services, and repositories.

```java
@ComponentScan(basePackages = "com.example.myapp")
public class AppConfig {
}
```

4. `@EnableAutoConfiguration`

   This annotation enables Spring Boot's auto-configuration feature, which automatically configures the Spring application based on the dependencies and the environment.

```java
@SpringBootApplication
@EnableAutoConfiguration
public class MyApp {
   // ...
}
```

## Bean

1. `@Bean`

   This annotation is used to declare a method in a Spring configuration class as a bean that will be managed by the Spring container. It allows the developer to define dependencies and configurations for the bean in the method. Example:

```java
@Configuration
public class AppConfig {
   @Bean
   public MyService myService() {
      return new MyServiceImpl();
   }
}
```

2. `@Scope`

   This annotation is used to specify the scope of a bean. It determines the lifecycle and visibility of the bean within the Spring container. The default scope is "singleton". Example:

```java
@Bean
@Scope("prototype")
public MyService myService() {
   return new MyServiceImpl();
}
```

3. `@Lazy`

   This annotation is used to delay the initialization of a bean until it is first used. It can improve the performance of an application by reducing the number of beans that are created and initialized at startup. Example:

```java
@Bean
@Lazy
public MyService myService() {
   return new MyServiceImpl();
}
```

4. `@Primary`

   This annotation is used to indicate that a bean should be given preference when multiple beans of the same type are present. It is commonly used with the `@Autowired` annotation to resolve dependencies when there are multiple beans of the same type. Example:

```java
@Bean
@Primary
public MyService myService1() {
   return new MyServiceImpl1();
}

@Bean
public MyService myService2() {
   return new MyServiceImpl2();
}
```

5. `@Qualifier`

   This annotation is used to specify which bean should be injected when there are multiple beans of the same type. It is commonly used with the `@Autowired` annotation to resolve dependencies. Example:

```java
@Bean
@Qualifier("myServiceImpl1")
public MyService myService1() {
   return new MyServiceImpl1();
}

@Bean
@Qualifier("myServiceImpl2")
public MyService myService2() {
   return new MyServiceImpl2();
}

@Autowired
@Qualifier("myServiceImpl1")
private MyService myService;
```

## Autowiring

1. `@Autowired`

   This annotation allows automatic wiring of dependencies in Spring. It can be used to inject a bean into another bean or to inject a value into a bean. Example code:

```java
@Component
public class MyClass {
   @Autowired
   private MyDependency dependency;
}
```

`@Autowired` and `@Component` are two different Spring annotations with different purposes.

`@Component` is used to mark a class as a Spring component. Spring scans the classpath for classes annotated with `@Component` and creates a Spring bean for each class it finds. These Spring components can be injected into other Spring beans using `@Autowired`.

On the other hand, `@Autowired` is used to inject a Spring bean into another Spring bean. It allows Spring to automatically wire the beans together based on the type of the bean.

In summary, `@Component` is used to mark a class as a Spring component while `@Autowired` is used to inject Spring beans into other Spring beans.

2. `@Resource`

   This annotation is used to autowire a bean by its name. It can be used to inject a bean into another bean or to inject a value into a bean. Example code:

```java
@Component
public class MyClass {
   @Resource(name="myDependency")
   private MyDependency dependency;
}
```

3. `@Inject`

   This annotation is used to autowire dependencies in Spring. It can be used to inject a bean into another bean or to inject a value into a bean. Example code:

```java
@Component
public class MyClass {
   @Inject
   private MyDependency dependency;
}
```

4. `@Value`

   This annotation is used to inject a value into a bean in Spring. It can be used to inject a property value or an environment variable. Example code:

```java
@Component
public class MyClass {
   @Value("${my.property}")
   private String myProperty;
}
```

## Controller

1. `@RestController`

   An annotation used to mark a controller class, indicating that all methods in the controllerrespond to RESTful requests, equivalent to the combination of `@Controller` and `@ResponseBody`.

```java
@RestController
@RequestMapping("/api")
public class ApiController {
    @GetMapping("/hello")
    public String hello() {
        return "Hello World!";
    }
}
```

2. `@RequestBody`

   An annotation used to mark a method parameter, indicating that the content of the request body should be converted to the specified type of object.

```java
@PostMapping("/user")
public void addUser(@RequestBody User user) {
    userService.addUser(user);
}
```

3. `@PathVariable`

   An annotation used to mark a method parameter, indicating that the value from a placeholder in the request URL should be used as the method parameter.

```java
@GetMapping("/user/{id}")
public User getUserById(@PathVariable Long id) {
    return userService.getUserById(id);
}
```

4. `@RequestParam`

   An annotation used to mark a method parameter, indicating that the value of a specific parameter in the request should be used as the method parameter.

```java
@GetMapping("/user")
public User getUserById(@RequestParam Long id) {
    return userService.getUserById(id);
}
```

5. `@GetMapping`, `@PostMapping`, `@PutMapping`, `@DeleteMapping`, `@PatchMapping`

   HTTP request mapping annotations in Spring.

   ```java
   @GetMapping("/users")
   public List<User> getAllUsers() {
       return userService.getAllUsers();
   }
   @PostMapping("/users")
   public ResponseEntity<User> createUser(@RequestBody User user) {
       User createdUser = userService.createUser(user);
       return new ResponseEntity<>(createdUser, HttpStatus.CREATED);
   }
   @PutMapping("/users/{id}")
   public ResponseEntity<User> updateUser(@PathVariable Long id, @RequestBody User user) {
       User updatedUser = userService.updateUser(id, user);
       return new ResponseEntity<>(updatedUser, HttpStatus.OK);
   }
   @DeleteMapping("/users/{id}")
   public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
       userService.deleteUser(id);
       return new ResponseEntity<>(HttpStatus.NO_CONTENT);
   }
   @PatchMapping("/users/{id}")
   public ResponseEntity<User> updateUserPartial(@PathVariable Long id, @RequestBody User user) {
       User updatedUser = userService.updateUserPartial(id, user);
       return new ResponseEntity<>(updatedUser, HttpStatus.OK);
   }
   ```

## Service

1. `@Service`

   An annotation used to mark a service class, indicating that the class is a Spring Bean that can be injected into other classes.

```java
@Service
public class UserServiceImpl implements UserService {
    //...
}
```



## DAO

1. `@Repository`

   An annotation used to mark a data access class, indicating that the class is a Spring Bean that can be injected into other classes.

```java
@Repository
public class UserRepositoryImpl implements UserRepository {
    //...
}
```

2. `@Transactional`

   An annotation used to mark a method or class, indicating that the method or all methods in the class should be executed within a transaction, commonly used to manage database transactions.

```java
@Service
@Transactional
public class UserServiceImpl implements UserService {
    //...
}
```

3. `@Column`

   An annotation used to specify the properties of the corresponding columns in the database table.

```java
@Column(columnDefinition = "varchar(255) default 'John Snow'")
private String name;

@Column(name="STUDENT_NAME", length=50, nullable=false, unique=false)
private String studentName; 
```

4. @Entity

   JPA (Java Persistence API) annotation that marks a Java class as an entity, which means it is a mapped object that can be persisted to a database.

   When we add the `@Entity` annotation to a Java class, it indicates that the class will be mapped to a database table. Each instance of the class will be a row in the table and each field will be a column.

   @Id is another commonly used Spring annotation in the context of entity classes. It is used to specify the primary key field of an entity.

   ```java
   @Entity
   public class Customer {
       @Id
       private Long id;
   
       private String name;
   
       private String email;
   
       // Getters and setters
   }
   ```

   

5. @Table

   To map an entity to a database table. It allows developers to specify the details of the table, such as the name, schema, and indexes

   ```java
   @Entity
   @Table(name = "users")
   public class User {
       @Id
       @GeneratedValue(strategy = GenerationType.IDENTITY)
       private Long id;
   
       @Column(name = "first_name")
       private String firstName;
   
       @Column(name = "last_name")
       private String lastName;
   
       // getters and setters
   }
   ```

## Json

1. @JsonProperty("")

A Jackson annotation used in Java to specify the property name of a JSON object during serialization or deserialization. The `@JsonProperty` annotation is used to map a Java field or getter/setter method to a specific key in the JSON data.

```java
public class Person {
    @JsonProperty("name")
    private String firstName;
    @JsonProperty("age")
    private int age;
    
    // getters and setters
}
```

This annotation map the `firstName` field to the key "name" and the `age` field to the key "age" during JSON serialization and deserialization. So, when a `Person` object is serialized to JSON, the resulting JSON object will have properties "name" and "age" instead of "firstName" and "age"





