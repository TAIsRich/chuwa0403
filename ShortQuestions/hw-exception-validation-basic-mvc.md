# 1. List all of the annotations you learned from class and homework to annotaitons.md

See `ShortQuestions/annotations.md`

# 2. What is the @configuration and @bean?

* `@Configuration`: This annotation is used to mark a class as a source of bean definitions. A class annotated with
  @Configuration is a configuration class that contains methods with the @Bean annotation. Spring will process this
  class to generate the necessary beans and wire them together

* `@Bean`: This annotation is used to indicate that a method returns a Spring bean to be managed by the Spring
  container.
  The method annotated with @Bean is responsible for creating an instance of the bean, and Spring will call this method
  when it needs to create a new instance of the bean. The bean's lifecycle is then managed by the Spring container,
  which includes handling dependency injection, singleton scope, and other bean-related features.

# 3. How do you handle the exception in Spring?

* `@ExceptionHandler`: You can handle exceptions in a Spring controller by annotating a method with the
  @ExceptionHandler annotation. This method will be invoked when a specified exception is thrown within the same
  controller class. You can specify the type of exception(s) the method should handle as a parameter to the annotation.
* `@ControllerAdvice`: To handle exceptions globally across multiple controllers, you can use the @ControllerAdvice
  annotation to create a central exception handling class. This class will contain methods annotated with
  @ExceptionHandler to handle different types of exceptions.

# 4. How do you do the validations in Spring? And list some validation annotaitons you know.

In Spring, you can perform validations using the Bean Validation API (JSR 380), which is integrated with Spring through
the spring-boot-starter-validation dependency. The Bean Validation API uses annotations to define constraints on fields,
and Hibernate Validator is the reference implementation of this API.

```java
import javax.validation.constraints.*;

public class User {

    @NotBlank(message = "Name must not be blank")
    private String name;

    @Email(message = "Invalid email format")
    private String email;

    @Min(value = 18, message = "Age must be at least 18")
    @Max(value = 100, message = "Age must be at most 100")
    private int age;

    // Getters and setters
}
```

```java
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class UserController {

    @PostMapping("/user")
    public ResponseEntity<String> createUser(@Valid @RequestBody User user) {
        // Process the user object
        return ResponseEntity.status(HttpStatus.CREATED).body("User created successfully");
    }
}

```

```java
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Object> handleValidationExceptions(MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errors);
    }
}

```

# 5. What is the actuator?

The Actuator is a module in the Spring Boot framework that provides production-ready features to help monitor and manage
your application. It exposes various HTTP endpoints or JMX beans, which allow you to gather information about the
application's health, metrics, environment, and configuration, as well as to perform specific management tasks. Actuator
endpoints can be extremely useful in diagnosing issues, understanding the application's performance, and ensuring the
smooth operation of the application in a production environment.

* `/actuator/health`: Shows the health status of the application. This can be used by monitoring tools to check if the
  application is running as expected.
* `/actuator/info`: Displays arbitrary application information, such as version number, build details, or custom data.
* `/actuator/metrics`: Provides various metrics about the application, such as memory usage, garbage collection, and web
  request statistics.
* `/actuator/env`: Shows the application's environment properties, including profiles, system properties, and
  environment variables.
* `/actuator/loggers`: Allows you to view and change the log levels of your application's loggers.

# 6. Watch those videos

Done

# 7. What is Spring and Springboot? What is the benefits of using Springboot?

* Spring Framework: Spring is an open-source framework that provides a comprehensive programming and configuration model
  for Java-based applications. It offers a wide range of features, such as dependency injection, data access,
  validation, security, and web application development through various modules. Spring's core principle is Inversion of
  Control (IoC), which is implemented using dependency injection, allowing for better modularity, testability, and
  maintainability of code.

* Spring Boot: Spring Boot is an extension of the Spring Framework designed to simplify the process of creating
  stand-alone, production-grade Spring applications. Spring Boot takes an opinionated approach to configuration,
  providing sensible defaults and automatically configuring many aspects of the application based on the included
  dependencies. This allows developers to focus on writing code rather than dealing with complex configurations.

Benefits of using Spring Boot:

* Simplified dependency management: Spring Boot offers a set of pre-defined starters, which are dependency descriptors
  that bundle commonly used libraries and modules. This simplifies the process of managing dependencies and helps avoid
  version conflicts.

* Auto-configuration: Spring Boot automatically configures your application based on the included dependencies. This
  means you don't need to write extensive configuration code or XML files, making it easier to create and maintain your
  application.

* Embedded web server: Spring Boot includes embedded web servers (such as Tomcat, Jetty, or Undertow), allowing you to
  create stand-alone, runnable applications without needing a separate web server. This makes it easier to deploy and
  run your application in different environments.

* Production-ready features: Spring Boot provides several production-ready features out-of-the-box, such as health
  checks, metrics, and externalized configuration. These features make it easier to monitor and manage your application
  in a production environment.

* Faster development: Spring Boot's opinionated approach to configuration and its use of sensible defaults allow
  developers to create applications quickly and with minimal boilerplate code.

* Easy integration with Spring ecosystem: Spring Boot seamlessly integrates with other Spring projects like Spring Data,
  Spring Security, and Spring Cloud, making it easier to build full-featured applications using various components of
  the Spring ecosystem.

# 8. What is IOC and What is DI?

**Inversion of Control (IoC)**: IoC is a design principle that inverts the traditional flow of control in a software
application. In a conventional application, the flow of control is dictated by the application itself, which is
responsible for creating and managing its dependencies. With IoC, the flow of control is inverted, and an external
framework or container takes responsibility for creating and managing the dependencies. This inversion enables greater
modularity, as components become more decoupled and can be easily swapped or modified without affecting other parts of
the application.

**Dependency Injection (DI)**: DI is a specific form of IoC that deals with the way dependencies are provided to a
component
or class. In DI, the dependencies are "injected" into a component, instead of the component creating and managing its
dependencies directly. This injection can happen through various methods, such as constructor injection, setter
injection, or interface injection. By using DI, components become more testable and maintainable, as their dependencies
can be easily replaced with mock implementations during testing or substituted with different concrete implementations
in different scenarios.

# 9. What is @ComponentScan?

`@ComponentScan` is an annotation in the Spring Framework that is used to specify the packages to be scanned for
components, which are automatically detected and registered as beans in the Spring IoC (Inversion of Control) container.
This annotation is often used with the @Configuration annotation in a Java-based Spring configuration class.

When the Spring container starts, it scans the specified packages and their sub-packages for classes annotated with
@Component, @Service, @Repository, @Controller, or any other custom stereotype annotations. These classes are then
instantiated and managed by the Spring container as beans, making them available for dependency injection.

# 10. How to define which package spring need to scan in xml and annotation?

```xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xmlns:context="http://www.springframework.org/schema/context"
       xsi:schemaLocation="http://www.springframework.org/schema/beans
           http://www.springframework.org/schema/beans/spring-beans.xsd
           http://www.springframework.org/schema/context
           http://www.springframework.org/schema/context/spring-context.xsd">

    <context:component-scan base-package="com.example.package1, com.example.package2"/>

    <!-- Other bean definitions and configurations -->

</beans>
```

```java
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = {"com.example.package1", "com.example.package2"})
public class AppConfig {
    // Other configurations and bean definitions
}
```

# 11. What is @SpringbootApplication?

`@SpringBootApplication` is a convenience annotation in Spring Boot that combines several other annotations commonly
used
when creating a Spring Boot application. It is typically placed on the main class of the application and serves as an
entry point for configuring, launching, and running the application.

* `@Configuration`: Indicates that the class can be used as a source of bean definitions for the Spring IoC (Inversion
  of Control) container. This allows you to define beans and other configurations in the same class.
* `@EnableAutoConfiguration`: Enables Spring Boot's auto-configuration feature, which automatically configures your
  application based on the included dependencies in the classpath. This simplifies the configuration process and allows
  you to focus on writing code rather than dealing with complex configurations.
* `@ComponentScan`: Instructs Spring to scan the package containing the annotated class and its sub-packages for
  components, such as beans annotated with @Component, @Service, @Repository, or @Controller. This allows Spring to
  discover and register these components in the IoC container.

# 12. How many ways wo can define a bean?

```xml

<bean id="myBean" class="com.example.MyBeanClass">
    <!-- Bean properties can be set using the <property> element -->
    <property name="propertyName" value="propertyValue"/>
</bean>
```

```java
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.example.MyBeanClass;

@Configuration
public class AppConfig {

    @Bean
    public MyBeanClass myBean() {
        MyBeanClass myBean = new MyBeanClass();
        myBean.setPropertyName("propertyValue");
        return myBean;
    }
}

```

```java
import org.springframework.stereotype.Component;

@Component
public class MyBeanClass {
    // ...
}
```

# 13. What is default bean name for @Component and @Bean?

1. @Component: When you annotate a class with @Component (or other stereotype annotations such as @Service, @Repository,
   and @Controller), the default bean name is the uncapitalized class name. For example, if your class name is
   MyBeanClass, the default bean name would be myBeanClass.
2. When you define a bean using the @Bean annotation in a @Configuration class, the default bean name is the name of the
   method that creates and returns the bean.

# 14. What is the difference between @component and @service, @repository?

* `@Component`: This is a general-purpose annotation used to indicate that a class is a Spring-managed component. When
  you
  annotate a class with @Component, Spring automatically detects and registers the class as a bean during component
  scanning. It serves as a base annotation for other stereotype annotations like @Service, @Repository, and @Controller.
  You can use @Component for any class that should be managed by the Spring container.

* `@Service`: This annotation is a specialization of @Component and is used for classes that belong to the service layer
  of
  your application. The @Service annotation provides additional semantics to express the intention of the class clearly,
  making it easier to understand the role of the class in the application. Although @Service doesn't add any extra
  functionality compared to @Component, using this annotation for service classes helps to indicate their purpose and
  improve the readability of the code.

* `@Repository`: This annotation is another specialization of @Component and is used for classes that belong to the data
  access layer, such as Data Access Objects (DAOs). The @Repository annotation not only registers the class as a bean
  but
  also provides additional features specific to data access, such as translating persistence technology-specific
  exceptions (e.g., JDBC, JPA, Hibernate) into Spring's DataAccessException hierarchy. This simplifies the exception
  handling in your application by providing a consistent and technology-agnostic exception hierarchy.

# 15. How many annotations we can use to inject the bean?

* `@Autowired`: This annotation is the most commonly used annotation for injecting beans in Spring. By default, it
  performs
  dependency injection by type, which means it looks for a bean that matches the type of the field, constructor
  parameter,
  or setter method parameter. If there are multiple beans of the same type, you can use the @Qualifier annotation
  alongside @Autowired to specify the bean by name.

  ```java
  private MyService myService;
  
  @Autowired
  public MyClass(MyService myService) {
      this.myService = myService;
  }
  ```

* `@Resource`: This annotation is part of the Java EE standard (javax.annotation package) and can be used to inject a
  bean by name. It works similarly to @Autowired, but instead of matching by type, it matches by the bean's name.
  ```java
  @Resource(name = "myService")
  private MyService myService;
  ```

* `@Inject`:  This annotation is part of the Java EE standard (javax.inject package) and works similarly to @Autowired,
  injecting beans by type. It requires the javax.inject.Inject library to be available on the classpath.

```java
@Inject
private MyService myService;
```

# 16. Tell me the three types to do dependency injection(How can we inject the beans in Spring)? Which way is better and why?

Constructor Injection: Dependencies are provided to the object through its constructor. This approach ensures that the
object is initialized with all its required dependencies, making it immutable and preventing incomplete objects. To
implement constructor injection, you define constructor arguments using the <constructor-arg> element in the XML
configuration or by using the @Autowired annotation on the constructor in the case of annotation-based configuration.

Setter Injection: Dependencies are provided to the object through setter methods. This approach is more flexible and
allows for optional dependencies, but it can lead to partially-initialized objects if not managed properly. To implement
setter injection, you define properties using the <property> element in the XML configuration or by using the @Autowired
annotation on the setter methods in the case of annotation-based configuration.

Field Injection: Dependencies are directly injected into the object's fields, without using constructors or setters.
This approach is less verbose, but it can lead to less clear code and makes it harder to understand the object's
dependencies. To implement field injection, you use the @Autowired annotation directly on the fields in the case of
annotation-based configuration.

# 17. If we have multiple beans for one type, how to set one is primary? and how to let the spring to pick one bean to inject if no primary.

* XML configuration:
  ```xml
  <bean id="primaryBean" class="com.example.PrimaryBean" primary="true"/>
  <bean id="secondaryBean" class="com.example.SecondaryBean"/>
  ```

* Annotation-based configuration:
  ```java
  @Configuration
  public class AppConfig {
      @Bean
      @Primary
      public MyBean primaryBean() {
          return new PrimaryBean();
      }
  
      @Bean
      public MyBean secondaryBean() {
          return new SecondaryBean();
      }
  }
  ```

# 18. What is the difference between BeanFactory and ApplicationContext in Spring?

BeanFactory:

* BeanFactory is the basic container for Spring beans, providing fundamental functionality like bean instantiation,
  wiring, and lifecycle management.
* It uses lazy initialization by default, meaning beans are only instantiated when they are requested. This can lead to
  faster startup times for smaller applications.
* BeanFactory is lightweight and has a smaller memory footprint, making it suitable for resource-constrained
  environments.

ApplicationContext:

* ApplicationContext is an extension of BeanFactory and provides all its features, along with additional advanced
  features.
* It uses eager initialization by default, meaning all singleton beans are instantiated and configured at startup. This
  can help detect configuration issues earlier but may increase startup time.

# 19. What is the Scope of a Bean? and list the examples for each scope.

* Singleton (default scope):

A single instance of the bean is created and shared across the entire application.
This instance is reused whenever a bean of this type is requested.
Singleton is the default scope if none is explicitly specified.
Example: A database connection pool, where a single instance is shared across the application to manage connections
efficiently.

* Prototype:

  A new instance of the bean is created each time it is requested.
  The container does not manage the complete lifecycle of a prototype bean, and it is the responsibility of the client
  code to clean up the bean's resources.
  Example: Objects that hold state and cannot be shared, like a user session or a shopping cart.

* Request (only applicable in web-aware ApplicationContext):

  A new instance of the bean is created for each HTTP request.
  The bean instance is scoped to the lifecycle of a single HTTP request.
  Example: Storing user-specific data during a single HTTP request, like form data.

* Session (only applicable in web-aware ApplicationContext):

  A new instance of the bean is created for each user session.
  The bean instance is scoped to the lifecycle of a single user session.
  Example: Storing user preferences or user-specific data across multiple requests during a user session, like
  authentication information.

* Application (only applicable in web-aware ApplicationContext):

  A single instance of the bean is created and shared across the entire web application.
  Similar to the singleton scope, but scoped to the web application context rather than the entire Spring
  ApplicationContext.
  Example: Storing application-wide data or configuration settings, like a list of supported locales.
* WebSocket (only applicable in web-aware ApplicationContext):

  A new instance of the bean is created for the lifecycle of a WebSocket session.
  The bean instance is scoped to a single WebSocket session.
  Example: Storing user-specific data during a WebSocket session, like a chat application's user state.

# 20. Configure a bean using xml. If bean has parameters/dependencies, how can we configure the bean?

```java
public class DataSource {
    private String url;
    private String username;
    private String password;
    // Getters and setters
}

public class MyService {
    private DataSource dataSource;
    // Getters and setters
}
```

```xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xsi:schemaLocation="http://www.springframework.org/schema/beans
       http://www.springframework.org/schema/beans/spring-beans.xsd">

    <!-- DataSource bean definition -->
    <bean id="dataSource" class="com.example.DataSource">
        <property name="url" value="jdbc:mysql://localhost:3306/mydb"/>
        <property name="username" value="user"/>
        <property name="password" value="password"/>
    </bean>

    <!-- MyService bean definition with DataSource dependency -->
    <bean id="myService" class="com.example.MyService">
        <property name="dataSource" ref="dataSource"/>
    </bean>

</beans>

```

# 21. What is MVC pattern?

The Model-View-Controller (MVC) pattern is a widely used design pattern for separating the concerns of an application's
data, presentation, and user interaction. It promotes modular and maintainable code by organizing the application into
three main components:

**Model**:

Represents the data and business logic of the application.
Encapsulates the application's state, including data storage, retrieval, and manipulation.
The model is responsible for notifying the view of any changes in the data, so the view can update accordingly.

**View**:

Represents the presentation layer or user interface of the application.
Displays the data provided by the model and receives user input.
The view is responsible for rendering the data and may have multiple representations for the same data, depending on the
requirements.

**Controller**:

Acts as an intermediary between the model and view.
Receives user input from the view and processes it, making necessary updates to the model.
The controller determines which view should be displayed based on user input and changes in the model.

# 22. What is Front-Controller?

The Front Controller is a design pattern used in web applications to provide a centralized point of entry for all
incoming client requests. It serves as a single controller that manages the request handling process and delegates the
responsibility of processing each request to the appropriate components within the application.

In the context of the Model-View-Controller (MVC) pattern, the Front Controller acts as a specialized form of the
controller component. The main responsibilities of the Front Controller include:

* Intercepting and preprocessing incoming requests: The Front Controller can perform common tasks such as
  authentication, authorization, logging, or input validation before delegating the request to the appropriate handler.

* Routing requests to specific handlers: Based on the request's characteristics (e.g., URL, HTTP method, or parameters),
  the Front Controller identifies the appropriate handler or controller to process the request.

* Managing the response generation: After the specific handler processes the request, the Front Controller can manage
  the response generation, such as selecting the correct view, applying a template, or performing additional processing
  before sending the response to the client.

* Post-processing requests: The Front Controller can perform post-processing tasks, such as logging or cleaning up
  resources, after the response has been sent to the client.

# 23. What is DispatcherServlet? please describe how it works

In the Spring MVC framework, the DispatcherServlet acts as the Front Controller. It is responsible for managing the
request handling process, including routing requests to the appropriate controllers, managing views, and handling
exceptions.

* Request Reception: The DispatcherServlet receives an incoming HTTP request from the client.

* Handler Mapping: The servlet consults the HandlerMapping bean to determine which Controller should process the
  request. The HandlerMapping maps URL patterns to specific Controllers.

* Controller Invocation: Once the appropriate Controller is identified, the DispatcherServlet hands off the request to
  it. The Controller handles the request and returns a ModelAndView object, which includes the data (Model) and the name
  of the view to be rendered.

* View Resolution: The DispatcherServlet consults the ViewResolver to map the logical view name to a specific View
  object.

* View Rendering: The View object uses the model data to generate the response that will be returned to the client.

* Exception Handling: If an exception occurs at any point during the request handling process, the DispatcherServlet
  consults a set of HandlerExceptionResolver beans to handle the exception and provide an appropriate error response.

The DispatcherServlet is configured in the web.xml file of your application, and you can define multiple
DispatcherServlets if needed, each with its own isolated application context.

# 24. What is JSP and What is ModelAndView？

**JavaServer Pages (JSP):**

JSP is a technology used to create dynamic web content. It allows developers to write HTML, XML, or other types of
documents, and embed Java code within these documents for dynamic processing and content generation. The embedded Java
code is used for processing user requests and building dynamic content.

**ModelAndView:**

ModelAndView is a holder for both Model and View in the web MVC framework of Spring. This class is typically used in a
Spring MVC Controller's handler method.

Model: The Model is a map (i.e., a collection of key-value pairs) where the keys are Strings, and the values are
Objects. The keys (also known as attribute names) are used to access the values (also known as attributes) in the map.
The model represents the data that will be used by the view to render the user interface.

View: The View is a string that represents the logical view name. The view resolver will use this name to resolve an
actual view that will be used to render the response.

```java
@RequestMapping("/hello")
public ModelAndView hello(){
        ModelAndView modelAndView=new ModelAndView();
        modelAndView.setViewName("helloView");
        modelAndView.addObject("message","Hello, World!");
        return modelAndView;
        }
```

# 25. Could you please give me any other servlets?

* HttpServlet
* LoginServlet
* DataServlet

# 26. How many web server do you know? (Tomcat, Jetty, Jboss)

Apache Tomcat: This is an open-source web server and servlet container developed by the Apache Software Foundation. It's
one of the most popular choices for running Java-based web applications, thanks to its lightweight nature, ease of use,
and strong community support.

Jetty: This is another lightweight and highly scalable open-source web server and servlet container. Jetty is often used
for machine-to-machine communications within larger software frameworks. Its small footprint makes it ideal for
distributed and cloud-based environments.

JBoss/WildFly: JBoss is a full-featured, enterprise-grade application server that's well-suited for large-scale
applications. WildFly is the open-source version of the JBoss Application Server. It supports the full Java Enterprise
Edition (Java EE) stack, including technologies such as EJB, JMS, and CDI.
