# HW 9 - 1

## 1. Check annotation.md in branch Haotian_zhu/hw4

## 2. What is the @Configuration and @Bean?

`@Configuration` is an annotation in the Spring Framework that is used to indicate that a class is a configuration class that provides Spring with instructions on how to configure the application context.

A configuration class typically contains one or more `@Bean` methods that define beans that will be managed by the Spring container. These beans can be injected into other parts of the application as dependencies, making it easy to create loosely coupled, modular code.

```java
@Configuration
@ComponentScan(...)
public class BeanConfig {
    
    // The method name will be the id of this bean
    @Bean
    public MyService myService() {
        return new MyServiceImpl();
    }
}
```

## 3. How do you handle the exception in Spring?

1. Create the specific Exception extends RuntimeException.
2. Create ErrorDetails payload class.
3. Create GlobalException Handler Class.

```java
// 1. Create the specific Exception
@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException {
    
    private String reourceName;
    private String fieldName;
    private long fieldValue;
    
    public ResourceNotFoundException {
        super(String.format("%s not found with %s: %s", resourceName, fieldName, fieldValue));
        this.resourceName = resourceName;
        this.fieldName = fieldName;
        this.fieldValue = fieldValue;
    }
    
    // Getter Setter Constructors...
}

// 2. Create ErrorDetails payload class
public class ErrorDetails {
    
    private Date timestamp;
    private String message;
    private String details;
}

// 3. Create Global Exception Handler class
@ControllerAdvice
public class GlobalExceptionHandler {
    
    @ExceptionHandler(MethodArgumentNotValidException.class)
    protected ResponseEntity<Objec> handleMethodArgumentNotValid(
    			MethodArgumentNotValidException ex,
        		HttpHeaders headers,
    			HttpStatus status,
    			WebRequest request) {
        Map<String, String> errors = new HashMap<>();
        
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String message = error.getDefaultMessage();
            errors.put(fieldName, message);
        });
        return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
    }
    
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ErrorDetails> handleResourceNotFoundException(
    			ResourceNotFoundException ex,
    			WebRequest webRequest) {
        
        ErrorDetails errorDetails = new ErrorDetails (
        			new Dtae(),
        			ex.getMessage().
        			webRequest.getDescription(false));
        
        return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
    }
    
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorDetails> handleException(
    			Exception ex,
    			WebRequest webRequest) {
        
        ErrorDetails errorDetails = new ErrorDetails(
        			new Date(),
        			ex.getMessage(),
        			webRequest.getDescription(false));
        
        return new ResponseEntity<>(errorDetails, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
```

## 4. How do you do the validations in Spring? And list some validation annotations you know.

1. Add validation rules to target payload classes.
2. Add @Valid to the controller, wherever needed add a @Valid.
3. Modify GlobalExceptionHandler(@ControllerAdvie) to handle the errors.

```java
// 1. Add rules to payload
public class User {

    @NotNull
    @Size(min = 2, max = 50)
    private String name;

    @Email
    private String email;

    // getters and setters...
}

// 2. Add @Valid in controller
@PostMapping("/users")
public ResponseEntity<User> createUser(@Valid @RequestBody User user) {
    userService.save(user);
    return ResponseEntity.ok(user);
}

// 3. Handle MethodArgumentNotValid exception in GlobalExceptionHandler
@ControllerAdvice
public class GlobalExceptionHandler {
    
    @ExceptionHandler(MethordArgumentNotValidException.class)
    protected ResponseEntity<Object> handleMethodArgumentNotValid(
    			MethodNotValidException ex,
    			HttpHearders header,
    			HttpStatus status,
    			WebRequest webRequest) {
        
        Map<String, String> errors = new HashMap<>();
        
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String message = error.getDefaultMessage();
            errors.put(fieldName, message);
        });
        return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
    }
}
```

## 5. What's the actuator?

Monitor of the application.

Spring Boot Actuator is a feature of the Spring Boot framework that provides production-ready features and monitoring capabilities to your application. It exposes a set of REST endpoints and metrics that can be used to monitor and manage the application at runtime.

----

# HW 9 - 2

## 1. Check haotian_zhu/hw4/

## 2. What is Spring and Springboot? What is the benfits of using Srpingboot?

Spring and Spring Boot are Java-based frameworks that provide a set of tools and features for building enterprise-level applications. Spring is a mature and widely-used framework that has been around since 2002, while Spring Boot is a newer framework that was introduced in 2014 and is built on top of the Spring framework.


Spring and Spring Boot are Java-based frameworks that provide a set of tools and features for building enterprise-level applications. Spring is a mature and widely-used framework that has been around since 2002, while Spring Boot is a newer framework that was introduced in 2014 and is built on top of the Spring framework.

Spring provides a set of core features for building enterprise-level applications, including dependency injection, data access, transaction management, and web development. Spring Boot builds on top of Spring by providing a simplified and opinionated way of building Spring-based applications, reducing the amount of boilerplate code and configuration required.

Some of the benefits of using Spring Boot include:

- Faster development: Spring Boot provides a set of pre-configured templates and starters that can be used to quickly set up a new project and get started with development.
- Simplified configuration: Spring Boot provides a set of auto-configuration features that automatically configure the application based on the dependencies and environment, reducing the amount of manual configuration required.
- Microservices support: Spring Boot provides a set of tools and features for building microservices-based architectures, including support for RESTful web services, messaging, and service discovery.
- Embedded web server: Spring Boot includes an embedded web server, making it easy to deploy and run the application without the need for a separate web server.
- Production-ready: Spring Boot provides a set of production-ready features, including health checks, metrics, auditing, and management endpoints, making it easy to monitor and manage the application at runtime.

Overall, Spring Boot is a powerful and flexible framework that provides a simplified and opinionated way of building enterprise-level applications, reducing the amount of boilerplate code and configuration required and making it easier to develop, deploy, and manage applications.

## 3. What is IOC and What is DI?

In the context of the Spring Framework, IOC (Inversion of Control) and DI (Dependency Injection) are two closely related concepts that are used to manage the relationships between the various components of an application.

IOC refers to the principle of **inverting the control of a system from the application code to the framework or container. In traditional programming,** the application code controls the flow of execution and manages the creation and lifecycle of objects. In an IOC-based framework like Spring, the control is inverted, and the framework manages the creation and lifecycle of objects.

DI is a specific implementation of IOC that focuses on the way that components are wired together. In a DI-based system, the dependencies between components are defined externally to the components themselves, and are injected into the components at runtime by the framework or container.

## 4. What is @CompnonentScan?

`@ComponentScan` is an annotation in the Spring Framework that is used to automatically detect and register Spring-managed beans in the application context.

When a Spring application is started, Spring will scan the specified package and its sub-packages for classes that are annotated with Spring component annotations, such as `@Component`, `@Service`, `@Repository`, and `@Controller`. Spring will then create instances of these classes and register them as beans in the application context.

## 5. How to define which package spring need to scan in xml and annotaiton?

To define the package(s) that Spring should scan using XML configuration, you can use the `<context:component-scan>` element, like this:

```xml
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:context="http://www.springframework.org/schema/context"
       xsi:schemaLocation="http://www.springframework.org/schema/beans
                           http://www.springframework.org/schema/beans/spring-beans.xsd
                           http://www.springframework.org/schema/context
                           http://www.springframework.org/schema/context/spring-context.xsd">

    <context:component-scan base-package="com.example.myapp"/>

    <!-- other bean definitions -->

</beans>

```

To define the package(s) that Spring should scan using annotations, you can use the `@ComponentScan` annotation, like this:

```java
@Configuration
@ComponentScan(basePackages = "com.example.myapp")
public class AppConfig {

    // ...

}
```

## 6. What is @SpringbootApplication?

`@SpringBootApplication` is a convenience annotation in the Spring Boot framework that is used to configure and bootstrap a Spring Boot application.

The `@SpringBootApplication` annotation is a combination of three other annotations: `@Configuration`, `@EnableAutoConfiguration`, and `@ComponentScan`. By using this annotation, you can configure your Spring Boot application with minimal boilerplate code.

## 7. How many ways we can define a bean?

1. Class level

   ```java
   @Component
   @Controller
   @Service
   @Repository
   ```

2. Method Level

   ```java
   @Configuration
   public class AppConfig {
       
       @Bean
       public MyService myService() {
           return new MyServiceImpl();
       }
   }
   ```

3. XML

   ```xml
   <bean id="dataNucleusChuwaNoComponent"  class="com.chuwa.springbasic.components.impl.DataNucleusChuwaNoComponent"></bean>
   
   ```

## 8. What is default bean name for @Component and @Bean?

In Spring, the default bean name for a component or bean is based on the name of the class or method that is annotated with `@Component` or `@Bean`.

For `@Component`, the default bean name is the simple class name, with the first letter in lowercase. For example, if you have a component class named `MyComponent`, the default bean name would be `myComponent`.

For `@Bean`, the default bean name is the name of the method that creates the bean, with the first letter in lowercase. For example, if you have a `@Bean` method named `createMyBean()`, the default bean name would be `myBean`.

You can override the default bean name by specifying a custom name in the `@Component` or `@Bean` annotation.

## 9. What is the difference between @Component and @Service, @Repository?

@Component: it is a general purpose stereotype annotation which indicates that the class annotated with it, is a spring managed component.

@Controller, @Service and @Repository are special types of @Component, these 3 themselves are annotated with @Component. 

Basically, their functions are the same as @Component, we use different annotations mainly to make the code more readable to developers.

## 10. How many annotations we can use to inject the bean?

1. `@Autowired`: This annotation can be used to inject a bean by type. Spring will automatically search for a bean of the same type and inject it into the component.
2. `@Qualifier`: This annotation can be used in conjunction with `@Autowired` to specify the name or qualifier of the bean to inject.
3. `@Resource`: This annotation can be used to inject a bean by name or qualifier. It is similar to `@Autowired` with `@Qualifier`, but can also be used with non-Spring dependencies.
4. `@Inject`: This annotation can be used to inject a bean by type or name. It is similar to `@Autowired`, but is part of the Java Dependency Injection (JSR-330) standard.
5. `@Value`: This annotation can be used to inject a value from a property file or environment variable into a bean.
6. `@PersistenceContext`: This annotation can be used to inject an EntityManager instance for JPA-based data access.
7. `@Autowired(required = false)`: This annotation can be used to indicate that the injection is optional. If Spring is unable to find a matching bean, it will not throw an exception.

## 11. Tell me the three types to do dependency injection(How can we inject the beans in Spring)? Which way is better and why?

* Constructor Injection

  ```java
  public class UserServiceImpl implements UserService {
      
      private final UserRepository userRepository;
      
      @Autowired
      public UserServiceImpl(UserRepository userRepository) {
          this.userRepository = userRepository;
      }
  }
  ```

* Field Injection

  ```java
  public class UserServiceImpl implements UserService {
      
      @Autowired
      private UserRepository userRepository;
      
  }
  ```

* Setter Injection

  ```java
  public class UserServiceImpl implements UserService {
      
      private UserRepository userRepository;
      
      @Autowired
      public void setUserRepository(UserRepository userRepository) {
          this.userRepository = userRepository;
      }
  }
  ```

In general, constructor injection is considered the best approach for dependency injection in Spring. This is because it provides a clear and unambiguous way to define the dependencies of a component, and ensures that the component is in a valid state when it is created. Additionally, constructor injection makes it easier to reason about the dependencies of a component and can make it easier to test and maintain the application.

## 12. If we have multiple beans for one type, how to set one is primary? and how to let the spring to pick one bean to inject if no primary.

By Class -> @Qualifier -> @Primary -> By Name -> Throw Exceptions

## 13. What is the difference between BeanFactory and ApplicationContext in Spring?

In Spring, `BeanFactory` and `ApplicationContext` are two interfaces that are used to manage the creation and lifecycle of beans. While these interfaces are similar in functionality, there are some key differences between them.

1. Bean Instantiation: `BeanFactory` creates beans lazily (on-demand), while `ApplicationContext` creates beans eagerly (at startup). This means that with `BeanFactory`, beans are only created when they are requested by a client, while with `ApplicationContext`, beans are created upfront when the application starts up.
2. Configuration: `BeanFactory` provides basic support for dependency injection and bean instantiation, while `ApplicationContext` provides advanced features such as internationalization, event handling, and AOP (Aspect-Oriented Programming) support. `ApplicationContext` is a superset of `BeanFactory` and provides more features and functionality.
3. Resource Management: `ApplicationContext` supports resource management, including the ability to load external resources such as property files and message bundles. `BeanFactory` does not support resource management.
4. Bean Post-Processing: `ApplicationContext` supports automatic bean post-processing, which allows you to modify or enhance the behavior of beans after they have been instantiated. `BeanFactory` does not support automatic bean post-processing.
5. Performance: `BeanFactory` is generally considered to be faster and more lightweight than `ApplicationContext`, as it does not eagerly create beans or support advanced features like resource management and automatic bean post-processing.

In general, if you have a simple application with few beans and basic configuration requirements, `BeanFactory` may be sufficient. However, if you have a more complex application with advanced requirements such as resource management, AOP, and automatic bean post-processing, `ApplicationContext` is the better choice.

## 14. What is the Scope of a Bean? and list the examples for each scope.

In Spring, the scope of a bean defines the lifecycle and visibility of the bean instance. There are several bean scopes available in Spring, each with its own characteristics and use cases:

1. Singleton: The singleton scope creates only one instance of the bean, and that instance is shared across the entire application context. This is the default scope in Spring. Examples of singleton-scoped beans include service classes, repositories, and utility classes.
2. Prototype: The prototype scope creates a new instance of the bean every time it is requested by a client. This means that there can be multiple instances of the same bean in the application context. Examples of prototype-scoped beans include stateful components, such as form controllers and wizards.
3. Request: The request scope creates a new instance of the bean for every HTTP request. This means that the bean instance is available only during the processing of that request, and is then discarded. Examples of request-scoped beans include web controllers and view helpers.
4. Session: The session scope creates a new instance of the bean for every HTTP session. This means that the bean instance is available throughout the duration of the session, and is then discarded when the session ends. Examples of session-scoped beans include user-specific data and shopping carts.
5. Application: The application scope creates a single instance of the bean for the entire web application. This means that the bean instance is available to all clients that access the application, and is not specific to a particular request or session. Examples of application-scoped beans include global configuration settings and system-wide caches.
6. WebSocket: The WebSocket scope creates a new instance of the bean for every WebSocket session. This means that the bean instance is available only during the processing of that WebSocket session.

## 15. Configure a bean using xml. If bean has parameters /dependencies, how can we configure the bean? 

```xml
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xsi:schemaLocation="http://www.springframework.org/schema/beans
                           http://www.springframework.org/schema/beans/spring-beans.xsd">

    <!-- Bean -->
    <bean id="myBean" class="com.example.MyBean">
        <constructor-arg ref="dependencyBean" />
        <constructor-arg value="parameterValue" />
    </bean>

    <bean id="dependencyBean" class="com.example.DependencyBean" />
</beans>

```

