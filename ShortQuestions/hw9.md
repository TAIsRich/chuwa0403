## Part1
### 1.  List all of the annotations you learned from class and homework to annotaitons.md
### 2.  what is the @configuration and @bean?
@Configuration and @Bean annotation is used to mark a method in Spring to define a bean.

### 3.  How do you handle the exception in Spring?
@ExceptionHandler: You can handle exceptions in a Spring controller by annotating a method with the @ExceptionHandler annotation. This method will be called whenever a specified exception is thrown within the same controller class. 

@ControllerAdvice: This annotation is used to define a global exception handler for multiple controllers in the Spring application. 

### 4.  How do you do the validations in Spring? And list some validation annotaitons you know.
Spring provides us a set of annotations to customize validation rules for method parameters and object fields. To enable validation, you need to include the spring-boot-starter-validation dependency in your project. Usually we do validation in this process:

    1. Specify validation rules to target payload classes. Here are some annotations that we can use:
        @NotNull: not be null
        @Size: specify the size constraints
        @Min: specify the minimum value
        @Max: specify the maximum value
        @Email: validate a variable is a valid email address
        @Pattern: validate a variable matches a regular expression pattern
        @NotEmpty: validate a variable is not null and not empty (only applies to string values).
        @NotBlank: validate a variable is not null and contains at least one non-whitespace character (only applies to string values).
    2. Add @Valid annotation to the method parameter or object field that needs to be validated.
    3. Modify GlobalExceptionHandler(@ControllerAdvie) to handle the errors.
```
Example:

public class User {

    @NotNull
    @Size(min = 5, max = 50)
    private String name;

    @Email(message = "Invalid email format")
    private String email;

    @Min(value = 18, message = "Age must be at least 18")
    private int age;

    // Getters and setters
}
```
```
@RestController
public class UserController {

    @PostMapping("/users")
    public ResponseEntity<User> createUser(@Valid @RequestBody User user) {

        userService.save(user);
        return ResponseEntity.ok(user);
    }
}
```
```
@ControllerAdvice
public class GlobalExceptionHandler {
    
    @ExceptionHandler(MethordArgumentNotValidException.class)
    public ResponseEntity<Object> handleValidationExceptions(MethodArgumentNotValidException ex) {       
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

### 5.  What is the actuator?
The Actuator is a feature in Spring that provides a set of HTTP endpoints to monitor and manage Spring applications.It exposes information about the application's health, metrics, environment, and cofigurations.
/info: Provides general information about the application.
/health: Provides information about health status of the application.
/metrics: Provides metrics about the application, such as the memory usage, requests statistics, and garbage collection.
/env: Provides information about the environment properties, such as system properties and environment variables.

### 6.  watch those videos(泛泛地看一遍，能理解多少是多少。没有必要看其它视频)

## Part2
### 1.  List all of the annotations you learned from class and homework to annotaitons.md

### 2.  What is Spring and Springboot? What is the benfits of using Springboot?
Spring is a popular open-source framework for building Java-based applications. It provides a comprehensive programming and configuration model for building modern, scalable, and robust applications. These easily used features include dependency injection, inversion of control(IoC), data access, transaction management, validation, security.

Spring Boot is an extension of the Spring framework that provides a set of tools and conventions for easily creating  Spring applications. It provides a simpler and more opinionated way of building Spring applications, by reducing the amount of boilerplate code and configuration required. Spring Boot is designed to be easy to use, fast to develop with, and to provide a consistent and stable platform for building microservices.

Benefits of Using Springboot:
1. Faster development: Springboot provides configuration and templates to create applications to start a project quickly.
2. Auto-configuration: Springboot provide a set of auto-configuration features that automatically configure the application based on the dependencies.
3. Embedded web server: Spring Boot includes embedded web servers (Tomcat), allowing developer to create stand-alone, runnable applications without needing a separate web server.

### 3.  What is IOC and What is DI?
Inversion of Control (IoC): IoC is a design principle that refers to the inversion of traditional control of the flow. In traditional programming, the flow of control is determined by the program itself, while in IoC, the flow of control is enables by an external framework or container that manages the dependencies between the different components of the program.

Dependency Injection (DI): DI is a specific form of the IoC that specifies the way dependencies are provided to a component or class. In DI, the dependencies are "injected" into a component, instead of the component creating and managing its dependencies directly. This injection can happen through various methods, such as constructor injection, setter injection, or interface injection.

### 4.  What is @CompnonentScan?
This annotation is used to specify the packages to be scanned for components. Components scanning is a process that Spring automatically detects and registers Spring beans in the application context.
When we use @ComponentScan in the application, Spring scans specified packages and their sub-packages for classes annotated with @Component, @Controller, @Service, @Repository. These components instantiated and managed as Spring beans in the IoC context.

### 5.  How to define which package spring need to scan in xml and annotaiton? 
XML: using *context:component-scan* element
```
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:context="http://www.springframework.org/schema/context"
       xsi:schemaLocation="http://www.springframework.org/schema/beans
                           http://www.springframework.org/schema/beans/spring-beans.xsd
                           http://www.springframework.org/schema/context
                           http://www.springframework.org/schema/context/spring-context.xsd">

    <context:component-scan base-package="com.example.packageName"/>

</beans>
```
@ComponentScan annotation: Using @ComponentScan with @Configuration.
```
@Configuration
@ComponentScan(basePackages = "com.example.packageName")
public class AppConfig {

}
```

### 6.  What is @SpringbootApplication?
This annotation is used to configure and bootstrap a Spring Boot application. It is a combination of three other annotations: @Configuration, @EnableAutoConfiguration, and @ComponentScan:
@Configuration: indicates that the class is a configuration class that provides bean definitions.
@EnableAutoConfiguration: enables Spring Boot's auto-configuration mechanism, which automatically configures the Spring application based on the dependencies on the classpath.
@ComponentScan: enables components scanning and tells Spring to scan the packages and sub-packages containing the class that is annotated with several annotations like @Component, etc.

### 7.  How many ways we can define a bean?
    1. Class level
    ```
     @Component
     @Controller
     @Service
     @Repository
     @ControllerAdvice
    ```
    2. Method Level
    ```
    @Configuration
    public class AppConfig {
    
        @Bean
        public myApp myApp() {
        }
    }
    ```
    3. XML
    ```
    <bean id="beanExample"  class="com..chuwa.BeanExampleClass">
        <!-- Bean properties can be set using the <property> element -->
        <property name="propertyName" value="propertyValue"/>
    
    </bean>
    ```

### 8.  What is default bean name for  @Component and  @Bean?
Using @Component to annotate a class, the default bean name is the class name, only with the first capital letter in lowercase.

Using @Bean to annotate a method, the default bean name is the name of the method by.

### 9.  What is the difference between  @component and  @service, @repository?
@Component is a general-purpose annotation used to indicate that a class is a Spring-managed component. When you annotate a class with @Component, Spring automatically detects and registers the class as a bean. It serves as a base annotation for other stereotype annotations like @Service, @Repository, and @Controller.

In terms of defining beans, @Service, @Repository, @Controler service the same funtion as @Component. Additionally, they indicate the purpose of the class clearly, making it easier to understand the role of the class in the application.  

### 10. How many annotaitons we can use to inject the bean?
@Autowired: is the most commonly used annotation for dependency injection in Spring. It looks for a bean that matches the type. If there are multiple beans of the same type, we can use the @Qualifier annotation to specify the bean by name.

@Resource: is an annotation that can be used to inject a bean by name.

### 11. Tell me the three types to do dependency injection(How can we inject the beans in Spring)? Which way is better and why?
Constructor Injection: Dependencies are passed to the bean through the constructor. This approach ensures that all required dependencies are provided at the time the bean is created. 

Field Injection: Dependencies are injected directly into the fields of the bean. This approach is the least recommended because it can lead to unclear code and issues with testing and debugging.

Setter Injection: Dependencies are provided to the bean through setter methods. This approach is more flexible and allows for optional dependencies, but it can lead to partially-initialized objects if not managed properly. This approach is the less recommended because it can cause the bean being in an inconsistent state if not all required dependencies are provided.

### 12. If we have multiple beans for one type, how to set one is primary? and how to let the spring to pick one bean to inject if no primay.
Here is the priority:
By type -> @Qualifier -> @Primary -> By Name -> Throw Exceptions

### 13. What is the difference between BeanFactory and ApplicationContext in Spring?
BeanFactory and ApplicationContext are two interfaces that are used to manage beans in a Spring application.

BeanFactory is the basic container for Spring beans, providing fundamental functionality like bean instantiation, wiring, and lifecycle management. 
It uses lazy initialization by default, meaning beans are only instantiated when they are requested. BeanFactory is lightweight and faster.


ApplicationContext is an extension of BeanFactory and provides all its features, along with additional advanced features.
It uses eager initialization by default, meaning all singleton beans are instantiated and configured at startup. This can help detect configuration issues earlier but may be slower in performance.

### 14. What is the Scope of a Bean?  and list the examples for each scope.
Singleton: This is the default scope in Spring. A single instance of the beanis created and reused whenever a bean of this type is requested. Example: A database connection pool, where a single instance is shared across the application to manage connections efficiently.

Prototype: A new instance of the bean is created every time it is requested. Examples: a stateful bean that maintains session-specific data or a bean that requires a unique instance for each operation.

Request: A new instance of the bean is created for each HTTP request. This scope is used for beans that are specific to a single HTTP request.

Session: A new instance of the bean is created for each HTTP session. This scope is used for beans that are specific to a single user session, such as storing user specific data across multiple requests during a user session.

Application: A single instance of the bean is created for the entire application context. This scope is used for beans that are shared across multiple requests and sessions, such as a database connection pool or a cache. 和singleton的区别

WebSocket: A new instance of the bean is created for each WebSocket session. This scope is used for beans that are specific to a single WebSocket session.

### 15. Configure a bean using xml. If bean has parameters/dependencies, how can we configure the bean? (you can google the tutorial how to configure beans in xml, and feel free to ask me any quesitons if you don't understand. it is a little bit old, I am not sure if I need to exaplain it in class)
```
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xsi:schemaLocation="http://www.springframework.org/schema/beans
                           http://www.springframework.org/schema/beans/spring-beans.xsd">

    <bean id="myBean" class="com.example.MyBean">
        <property name=" " ref=" " />
        <property name=" " value=" " />
    </bean>


    <bean id="myService" class="com.example.MyBean">
        <constructor-arg ref="myDependency" />
    </bean>

</beans>
```

## Part3
### 1.  List all of the annotations you learned from class and homework to annotaitons.md

### 2.  What is MVC pattern?
The Model-View-Controller (MVC) pattern is a widely used design pattern for separating an application's into three main components including data, presentation, and business logic.
Model: Represents the data. It is responsible for managing the data and providing methods for accessing and manipulating the data.

View: Represents the presentation or UI of the application. It is responsible for rendering and displaying the data to the user interface. 

Controller: It is responsible for receiving input from the user, processing dto, and updating the model accordingly. It also return the data to the view. 

### 3.  What is Front-Controller? 
The Front-Controller is a design pattern that provides a centralized entry point for handling requests in web applications. It is responsible for processing requests and directing them to the appropriate handlers. It is the main servlet in a Spring MVC application
It receives incoming requests, and then routes requests to appropriate handlers. After the handlers returns the data, the Front Controller handles the returned model and selects the view templates, then sends response to the client. 

### 4.  What is DispatcherServlet? please decribe how it works.
The DispatcherServlet is the main servlet in a Spring MVC web application. It is responsible for managing the request handling process.

When a request is sent to the application, the DispatcherServlet receives the incoming request and consults HandlerMapping to determine which controller should handle the request. 

Once the appropriate controller has been identified, the DispatcherServlet invokes the controller's method to process the request. The Controller handles the request and returns a Model object and a view name.

Then the DispatcherServlet consults the ViewResolver to map the logical view name to a specific View object.

The View object uses the model data to generate the response that will be returned to the client.

If an exception occurs at any point during the request handling process, the DispatcherServlet consults a set of HandlerExceptionResolver beans to handle the exception and provide an appropriate error response.

### 5.  What is JSP and What is ModelAndView？(please google to have a basic knowlege)
JSP (JavaServer Pages) is a technology used in Java web development to dynamically generate HTML pages. JSP pages contain a mixture of static HTML and dynamic content, which is generated at runtime using Java code. JSP pages are compiled into servlets at runtime, and are executed by a servlet container to generate HTML pages. In Java Spring, JSP is one of several view technologies that can be used to render the response of a web request. Other view technologies include Thymeleaf, Velocity, and FreeMarker. JSP views can be used in conjunction with Spring MVC to generate dynamic HTML pages.

ModelAndView is a class in Java Spring that is used to store data and the name of the view that should be rendered in response to a web request. It contains two parts: 

The Model object: This is used to store data that will be displayed in the view. The Model object is typically populated in the controller method, and is passed to the ModelAndView object.

The view name: This is the name of the view that should be rendered in response to the web request. The view name is typically passed to the ModelAndView constructor.

When a controller method returns a ModelAndView object, the Spring framework will use the view name to locate the appropriate view and render it with the data from the Model object.

### 6.  Could you please google any other servlets(理解多少是多少，不要花太多时间，知道servlet的名字就行。)
HttpServlet: This is the base class for all servlets that handle HTTP requests. It provides methods for handling various HTTP methods, such as doGet(), doPost(), doPut(), and doDelete().

### 7. How many web server do you know? (Tomcat, Jetty, Jboss)
Apache Tomcat: This is an open-source web server and servlet container developed by the Apache Software Foundation. It is one of the most popular for running Java-based web applications.

Jetty: This is another open-source web server and servlet container, developed by the Eclipse Foundation. Jetty is known for its lightweight and scalable architecture.

JBoss/WildFly: This is a open-source application server developed by Red Hat. WildFly is the open-source version of the JBoss Application Server.

Resin: This is a web server and application server developed by Caucho Technology. It is known for its high performance and scalability.

### 8.  clone this repo, and run it in you local.
    a. https://github.com/TAIsRich/springmvc5-demo
    b. Notice that you need to configure the Tomcat by yourself. tutorial in the slides.
    c.  find out the APIs in controlelr and call some APIs, In slides, I also list some API.
    d.  remeber to create a database for this project
    e.  all details in the slides.
 