# Spring Annotations

*Claudia Feng Apr 12, 2023*

#### 1. Autowired

`@Autowired` annotation is applied to the fields, setter methods, and constructors. It injects object dependency implicitly. We use @Autowired to mark the dependency that will be injected by the Spring container.

- Field injection

```java
class Student {
	@Autowired
	Address address;
}
```

* Constructor injection

```java
class Student {
	Address address;

	@Autowired
	Student(Address address) {
		this.address = address;
	}
}
```

- Setter injection

```java
class Student {
	Address address;

	@Autowired
	void setaddress(Address address) {
		this.address = address;
	}
}
```

#### 2. @Bean

The `@Bean` annotations are used at the method level and indicate that a method produces a bean that is to be managed by the Spring container. It is an alternative to the XML<bean> tag. 

```java
@Bean
Public BeanExample beanExample () {
	return new BeanExample ();
}
```

#### 3. @Service

It is used at the class level. It shows that the annotated class is a service class, such as business basic logic, and call external APIs. The `@service` annotation is used where the classes provide some business functionalities. The spring context autodetects these classes as the annotation is used with those classes where the business functionalities are to be used.

```java
@Service
public class TestService {
	public void service1() {
		// business code
	}
}
```

#### 4. @Repository

It is a Data Access Object (DAO) that accesses the database directly. It indicates that the annotated class is a repository. 

The repository annotation indicates the class has the capability of storage, retrieval, updating, deletion, and search (CRUD).

```java
@Repository
public class TestRepository {
	public void delete() {
		// persistence code
	}
}
```

#### 5. @Configuration

It is used as a source of bean definitions. It is a class-level annotation. The configuration annotation represents the class having one or more `@Bean` methods. The spring container could go ahead and generate the Spring Beans to be used.

```java
@Configuration
public class Bus {
  @Bean
  Bus engine() {
  	return new Bus();
  }
}
```

#### 6. @Controller

The annotation is used to indicate that the class is a web request handler. It is often used to present web pages. It is most commonly used with `@RequestMapping` annotation. 

The `@Controller` annotation indicates the class serves the role of a controller. The controller annotation is a specialisation of the component annotation where it is auto-detected through the classpath scanning.

```java
@Controller
@RequestMapping("/api/users")
public class UserController {

    @ResponseBody
    @GetMapping("/{userId}")
    public User getUserById(@PathVariable("userId") String userId) {
        // Get user by ID logic
    }
}

```

#### @RestController

The `@RestController` annotation is a combination of the `@Controller` and `@ResponseBody` annotations. It marks a class as a Spring Web MVC controller but also indicates that the response from each handler method should be directly written to the HTTP response body as JSON, XML, or other formats, without using a view. It is primarily used to create RESTful web services that return data instead of views.

When using `@RestController`, you don't need to add the `@ResponseBody` annotation to individual methods, as it's implicitly applied to all methods.

```java
@RestController
@RequestMapping("/api/users")
public class UserController {

    @GetMapping("/{userId}")
    public User getUserById(@PathVariable("userId") String userId) {
        // Get user by ID logic
    }
}
```



#### 7. @RequestMapping

RequestMapping is used to map the HTTP request. It is used with the class as well as the method. It has many other optional elements like consumes, name, method, request, path, etc.

```java
@Controller
public class FlowersController {
  @RequestMapping (“/red-colour/flowers”)
  public String getAllFlowers(Model model) {
    //application code
    return “flowerlist”;
}
```

#### 8. @Component

It is a class-level annotation that turns the class into Spring bean at the auto-scan time. The component annotation can automatically detect custom beans. It represents that the framework could autodetect these classes for dependency injection.

```java
@Component
Public class Teachers {
	……
}
```

#### 9. @SpringBootApplication

It consists of @Configuration, @ComponentScan, and @EnabeAutoConfiguration. The class annotated with @SpringBootApplication is kept in the base package. This annotation does the component scan. However, only the sub-packages are scanned. 

The SpringBoot Application mark a configuration class that declares Bean methods, either one or more than that. The Spring Boot Application contains-

1. Auto-configuration
2. Spring Boot Configuration
3. Component Scan

#### 10. @EnableAutoConfiguration

It is placed on the main application class. Based on classpath settings, other beans, and various property settings, this annotation instructs SpringBoot to start adding beans.

The Enable Auto Configuration allows the spring boot to auto-figure the application context. The applications are auto figured basis the added jar dependencies.

#### 11. @Required

This annotation is applied to bean setter methods. It indicates that the required property must be filled at the configuration time in the affected bean, or else it throws an exception: BeanInitializationException.

#### 12. @Lazy

It is used in the component class. At startup, all auto-wired dependencies are created and configured. But a @Lazy annotation can be created if a bean is to be initialized lazily. This means that only if it is requested for a bean will be created. It can also be used on @Configuartion classes. It’s an indication that all @Bean methods within that @Configuration should be lazily initialized.

#### 13. @RequestBody

The `@RequestBody` annotation in Spring is used to bind the HTTP request body to a method parameter in a controller. It indicates that a method parameter should be deserialized from the JSON, XML, or other format sent within the request body, and it's commonly used when creating or updating resources in RESTful APIs.

When the `@RequestBody` annotation is used, the Spring Framework automatically converts the request body into a Java object.

```java
@RestController
@RequestMapping("/api/users")
public class UserController {

    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody User newUser) {
        // Create user logic
        // Save newUser to the database and return the created User object
    }
}
```

#### 14. @PathVariable

The `@PathVariable` annotation in Spring is used to bind a path variable (a portion of the request URL) to a method parameter in a controller. It allows you to capture specific parts of a URL and use them as parameters within your handler methods. It's commonly used in RESTful APIs when you want to perform operations on a specific resource, identified by its unique ID or other attributes within the URL.

```java
@RestController
@RequestMapping("/api/users")
public class UserController {

    @GetMapping("/{userId}")
    public ResponseEntity<User> getUserById(@PathVariable("userId") String userId) {
        // Get user by ID logic
        // Fetch the user with the given userId from the database and return the User object
    }
}
```

#### 15. @ResponseStatus

The `@ResponseStatus` annotation in Spring is used to define the HTTP status code that should be returned in the response when a specific exception is thrown, or when a handler method is executed successfully. This annotation can be applied to both exception classes and handler methods in a controller.

1. **When applied to an exception class**: If the `@ResponseStatus` annotation is applied to an exception class, it means that when that exception is thrown during the execution of a handler method, Spring should automatically set the specified status code in the HTTP response. This is particularly useful for defining custom exceptions with their respective HTTP status codes.

```java
@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "User not found")
public class UserNotFoundException extends RuntimeException {
    // Custom exception logic
}
```

In this example, the `UserNotFoundException` is annotated with `@ResponseStatus` and given an HTTP status code of `404 Not Found`. If this exception is thrown during the execution of a handler method, Spring will automatically set the HTTP response status to 404.

2. **When applied to a handler method**: If the `@ResponseStatus` annotation is applied to a handler method in a controller, it means that when the method is executed successfully, Spring should set the specified status code in the HTTP response.

```java
@RestController
@RequestMapping("/api/users")
public class UserController {

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public User createUser(@RequestBody User newUser) {
        // Create user logic
        // Save newUser to the database and return the created User object
    }
}
```

In this example, the `createUser` method is annotated with `@ResponseStatus` and given an HTTP status code of `201 Created`. When this method is executed successfully, Spring will automatically set the HTTP response status to 201, indicating that a new resource has been created.

