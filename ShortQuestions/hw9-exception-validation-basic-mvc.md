## part1-exception-validation

### what is the @configuration and @bean?

`@Configuration` and `@Bean` are annotations used in Spring Framework to configure and define beans in the application context.

- `@Configuration`: This annotation is used to indicate that a class is a configuration class. It is typically used in conjunction with `@Bean` to define beans and their dependencies. Configuration classes are used to replace XML-based configurations and provide a way to configure the application using Java-based configuration.

- `@Bean`: This annotation is used to define a bean in the Spring application context. It is applied to methods within a `@Configuration` class and indicates that the method will return an instance of a bean that should be managed by the Spring container. The return value of the method is the bean instance, and the method name is used as the bean name.

Here's an example code snippet to illustrate the usage of `@Configuration` and `@Bean`:

```java
@Configuration
public class AppConfig {
    
    @Bean
    public MyBean myBean() {
        return new MyBean();
    }
    
    @Bean
    public AnotherBean anotherBean() {
        return new AnotherBean(myBean());
    }
    
    // Other bean definitions
    
}
```

In this example, the `AppConfig` class is annotated with `@Configuration`, indicating that it is a configuration class. The `myBean()` method is annotated with `@Bean`, specifying that it should be treated as a bean definition. The `anotherBean()` method also uses `@Bean` and demonstrates how beans can be injected as dependencies.

With this setup, the Spring container will create instances of the `MyBean` and `AnotherBean` beans and manage their lifecycle and dependencies within the application context.

### How do you handle the exception in Spring?

In Spring, exceptions can be handled using various mechanisms. Here are some common approaches for handling exceptions in Spring:

1. `try-catch` block: You can use traditional `try-catch` blocks to catch and handle exceptions within your methods. You can handle exceptions by logging them, providing appropriate error messages, or taking alternative actions.

2. `@ExceptionHandler`: Spring provides the `@ExceptionHandler` annotation that can be used to handle exceptions globally or within a specific controller. By annotating a method with `@ExceptionHandler` and specifying the exception type, you can define the logic to handle that particular exception.

3. `@ControllerAdvice`: The `@ControllerAdvice` annotation allows you to define global exception handling across multiple controllers. You can create a class annotated with `@ControllerAdvice` and define exception handling methods using `@ExceptionHandler` within that class. These methods will be invoked when an exception occurs within any controller.

4. Custom Exception Handling: You can create custom exception classes by extending the `Exception` class or its subclasses. By throwing and catching these custom exceptions, you can handle specific exceptional scenarios in your application.

5. `@ResponseStatus`: You can use the `@ResponseStatus` annotation to specify the HTTP status code to be returned when a specific exception is thrown. This can be useful when you want to customize the response status based on the type of exception.

It is important to choose the appropriate exception handling mechanism based on your application's requirements and the level of control you need over the exception handling process.

### How do you do the validations in Spring? And list some validation annotaitons you know.

We can use the built-in validation framework provided by the `javax.validation` package. Here are the steps to perform validations in Spring:

1. Add Validation Annotations: Annotate the fields or method parameters in your classes with validation annotations. Some common validation annotations include:
   - `@NotNull`: Ensures that the value is not null.
   - `@NotBlank`: Ensures that the value is not null or empty.
   - `@Size`: Specifies the minimum and maximum size constraints for a string or collection.
   - `@Pattern`: Specifies a regular expression pattern that the value must match.
   - `@Min` and `@Max`: Specifies the minimum and maximum value constraints for numeric types.
   - `@Email`: Ensures that the value is a valid email address.

2. Enable Validation: In your Spring configuration, enable validation by adding the `@EnableWebMvc` annotation or configuring a `LocalValidatorFactoryBean`.

3. Perform Validation: In your controller methods, use the `@Valid` annotation to indicate that you want to validate the method parameter or form object. After the validation, you can check for validation errors using the `BindingResult` object.

4. Handle Validation Errors: You can handle validation errors by checking the `BindingResult` object for any errors. You can then provide appropriate error messages or redirect the user to an error page.

By following these steps, you can perform validations in Spring using the validation annotations provided by the `javax.validation` package.

### What is the actuator?

Actuator is a feature that provides endpoints for monitoring and managing your application at runtime. It gives you insights into your application's health, metrics, configuration, logging, and more. The Actuator exposes a set of HTTP endpoints that you can access to obtain information about your application's internals.

Some key features of the Actuator include:

1. Health Monitoring: The Actuator provides a `/health` endpoint that reports the health status of your application. It can be used for monitoring and health checks by external systems.

2. Metrics Collection: The Actuator collects various metrics about your application, such as CPU usage, memory usage, request counts, etc. These metrics can be exposed through the `/metrics` endpoint.

3. Environment and Configuration: The Actuator provides an endpoint to access the application's environment properties and configuration. It can be used to view and modify the configuration of your application at runtime.

4. Logging: The Actuator allows you to view and modify the logging configuration of your application through the `/loggers` endpoint. You can dynamically change log levels and view log output.

The Actuator is a powerful tool for monitoring and managing Spring Boot applications, providing valuable insights and control over your application's runtime behavior.

## part2-MVC

### What is MVC pattern?

Model-View-Controller pattern is a design pattern commonly used in software development, particularly in web application development. It separates the application's logic into three interconnected components:

1. Model: The Model represents the data and business logic of the application. It encapsulates the application's data and provides methods to manipulate and access that data. It is responsible for maintaining the state of the application and implementing the application's business rules.

2. View: The View is responsible for the presentation layer of the application. It defines how the data from the Model is presented to the user. It generates the user interface and displays the data to the user. The View is typically implemented using HTML, CSS, and other client-side technologies.

3. Controller: The Controller acts as an intermediary between the Model and the View. It receives user input and updates the Model accordingly. It also listens for events from the Model and updates the View based on the changes in the Model. The Controller handles the flow of data between the Model and the View and controls the overall behavior of the application.

The MVC pattern promotes separation of concerns and helps in achieving modular, maintainable, and testable code. It allows for independent development of the Model, View, and Controller components, making the application more flexible and scalable.

### What is Front-Controller?

The Front-Controller is a design pattern commonly used in web application development. It centralizes the handling of incoming requests and acts as a single entry point for all requests to the application. The Front-Controller pattern helps to achieve a modular and reusable architecture by providing a centralized point for request handling and routing.

In the Front-Controller pattern, there is a single component called the Front Controller, which receives all incoming requests from clients. It is responsible for processing the requests, delegating them to the appropriate handlers, and coordinating the overall request processing flow. The Front Controller may perform tasks such as request authentication, authorization, logging, and error handling.

Benefits of using the Front-Controller pattern include:

1. Centralized request handling: All requests are routed through a single entry point, making it easier to implement cross-cutting concerns and maintain consistent behavior across the application.

2. Reusability: The Front Controller can be reused for handling different types of requests and can be extended or customized to support various application requirements.

3. Modularity: The Front Controller separates the request handling logic from the rest of the application, promoting modular design and enabling better code organization and maintenance.

Popular frameworks like Spring MVC and JavaServer Faces (JSF) implement the Front-Controller pattern to provide a structured and standardized approach to web application development.

### What is DispatcherServlet? please decribe how it works.

The DispatcherServlet is a key component in the Spring MVC framework. It acts as the front controller in the web application and is responsible for handling incoming requests, routing them to the appropriate handlers, and managing the overall request processing flow.

Here's how the DispatcherServlet works:

1. Incoming request: When a client sends a request to the web application, it first reaches the DispatcherServlet.

2. Request handling: The DispatcherServlet examines the request and determines the appropriate handler to process it based on the configured request mappings. The handler can be a controller method, a REST endpoint, or any other component capable of handling the request.

3. Handler execution: The DispatcherServlet invokes the chosen handler to process the request. The handler performs the necessary business logic and returns a response.

4. View resolution: If the handler returns a logical view name instead of a raw response, the DispatcherServlet resolves the view based on the configured view resolvers. The view resolver maps the logical view name to an actual view template.

5. View rendering: The resolved view template is rendered with the model data provided by the handler, resulting in the final response content.

6. Response dispatch: The DispatcherServlet sends the response back to the client, completing the request-response cycle.

The DispatcherServlet acts as a central hub, coordinating the various components involved in request handling, such as request interceptors, controller methods, view resolvers, and view renderers. It provides a configurable and extensible mechanism for handling web requests in a Spring MVC application.

### What is JSP and What is ModelAndView？

JSP (JavaServer Pages) is a technology used in Java web development to dynamically generate HTML pages. It allows developers to embed Java code within HTML, enabling the creation of dynamic and interactive web pages. JSP files are compiled into Java servlets and executed on the server side, generating HTML content that is sent to the client's web browser.

ModelAndView is a class provided by the Spring MVC framework that combines a model object with a view name, allowing developers to pass data from the controller to the view. It represents the data to be displayed in the view and the logical view name to be resolved by the view resolver. The model contains attributes that can be accessed and rendered in the view, while the view name determines the actual view template to be rendered.

With ModelAndView, the controller can set the model attributes and specify the view name, providing a structured approach to handle the response. It allows for easy integration between the controller and the view, enabling the passing of data and controlling the rendering process.

### Any other servlets

Some other commonly used servlets:

1. HttpServlet: HttpServlet is an abstract class that extends the GenericServlet class and provides HTTP-specific functionality. It handles HTTP request methods (GET, POST, etc.) and provides methods for handling request parameters, session management, and more.

2. GenericServlet: GenericServlet is an abstract class that provides a generic implementation of the Servlet interface. It is protocol-independent and can handle any type of protocol. However, it requires manual handling of the protocol-specific details.

3. RequestDispatcher: RequestDispatcher is an interface that provides a way to forward or include requests to other servlets, JSP pages, or resources in the same web application. It is used for dispatching requests within the server.

4. Filter: Filter is an interface that allows pre-processing and post-processing of requests and responses. It can modify the request or response headers, perform logging, authentication, or any other operations needed before or after the servlet processing.

5. ServletContext: ServletContext is an interface that represents the web application and provides access to its configuration parameters, resources, and other application-wide information. It is used to share data between servlets and provides a way to interact with the servlet container.

These servlets play different roles in handling HTTP requests, dispatching requests, filtering requests and responses, and managing application-wide resources and configurations.

### web server (Tomcat, Jetty, Jboss)

1. Apache Tomcat: Tomcat is an open-source web server and servlet container that is widely used for Java web applications. It is lightweight, easy to configure, and supports the Java Servlet, JavaServer Pages (JSP), and Java Expression Language (EL) specifications.

2. Jetty: Jetty is another popular open-source web server and servlet container written in Java. It is lightweight, scalable, and designed for high-performance applications. Jetty supports the latest Java Servlet specifications and provides features such as HTTP/2 support, WebSocket support, and more.

3. JBoss Application Server (WildFly): JBoss/WildFly is an open-source Java EE application server developed by Red Hat. It provides a full Java EE implementation, including support for servlets, JSP, EJB, JMS, and other Java EE technologies. JBoss/WildFly offers enterprise-level features and is suitable for large-scale applications.

4. Nginx: Nginx is a high-performance web server and reverse proxy server. While primarily known as a web server for static content, it can also act as a reverse proxy for forwarding requests to other web servers or application servers. Nginx is known for its scalability, efficiency, and ability to handle concurrent connections.

5. Microsoft IIS: Internet Information Services (IIS) is a web server developed by Microsoft for hosting websites on Windows servers. It supports various web technologies, including ASP.NET, PHP, and CGI, and provides features such as SSL/TLS support, URL rewriting, and server-side scripting.

These web servers serve as the foundation for hosting and running web applications, providing HTTP protocol support, request handling, and serving static and dynamic content.

### Difference between web serber, servlet, controller

- Web server: A web server is a software application that handles HTTP requests and responses. Its main purpose is to deliver web content to clients, such as web browsers. Web servers are responsible for receiving incoming requests, processing them, and returning the appropriate responses. They handle static files, execute server-side scripts, and may also act as a reverse proxy for forwarding requests to application servers.
- Servlet: A servlet is a Java class that runs on a web server and handles client requests and responses. It is part of the Java Servlet API and follows a specific lifecycle defined by the API. Servlets are responsible for processing dynamic content, interacting with databases, and generating dynamic HTML pages or other types of responses.
- Controller: In the context of web application development using frameworks like Spring MVC, a controller is a component responsible for handling HTTP requests and managing the flow of the application. Controllers receive incoming requests, process them, and determine the appropriate response, which may involve retrieving data, invoking business logic, and returning a view or a JSON/XML response. Controllers typically handle the application's business logic and interact with various components, such as services, repositories, or other external systems.

## part3-basic

### What is Spring and Springboot? What is the benfits of using Srpingboot?

- Spring: Spring is a popular Java framework that provides a comprehensive programming and configuration model for developing enterprise-grade applications. It offers a wide range of features and modules to simplify the development process and promote good software engineering practices. Spring focuses on enabling developers to build loosely coupled, modular, and testable applications by leveraging dependency injection, aspect-oriented programming, and various other components and patterns.
- Spring Boot: Spring Boot is a sub-project of the Spring framework that aims to simplify the development of Spring applications by providing a convention-over-configuration approach. It eliminates the need for explicit XML configuration and boilerplate code by offering sensible defaults and auto-configuration. Spring Boot allows developers to quickly set up and run standalone Spring applications with minimal configuration, making it easier to build microservices and deploy applications in a cloud-native environment.

Benefits of using Spring Boot:

1. Rapid application development: Spring Boot reduces the amount of configuration and boilerplate code, allowing developers to focus on writing business logic and delivering features quickly.
2. Simplified deployment: Spring Boot applications can be easily packaged as executable JAR files, making deployment and distribution simple.
3. Auto-configuration: Spring Boot provides intelligent auto-configuration based on classpath scanning, which eliminates the need for manual configuration and reduces the risk of errors.
4. Production-ready features: Spring Boot offers a range of production-ready features such as metrics, health checks, security, logging, and externalized configuration.
5. Ecosystem and community support: Spring Boot is backed by a large and active community, providing extensive documentation, tutorials, and support resources.

### What is IOC and What is DI?

- IOC (Inversion of Control): In software development, IOC is a design principle and architectural pattern that allows the control of object instantiation and dependency management to be inverted or externalized. It is also known as the "Dependency Injection" pattern. IOC enables loose coupling between classes and promotes modular and testable code. Instead of creating and managing dependencies manually within a class, IOC containers or frameworks take responsibility for instantiating and injecting dependencies into classes at runtime.
- DI (Dependency Injection): DI is a specific implementation of the IOC pattern. It refers to the process of supplying the dependencies of a class from an external source, typically via constructor injection, setter injection, or method injection. DI helps achieve loose coupling between classes and allows for easier unit testing and modular development. By injecting dependencies, classes can be decoupled from their concrete implementations, making them more flexible and maintainable.

In summary, IOC is a design principle that promotes loose coupling and modular development by externalizing object instantiation and dependency management. DI is a specific implementation of IOC that involves injecting dependencies into classes from an external source.

### What is @CompnonentScan?

In Spring, the `@ComponentScan` annotation is used to enable component scanning in the application. It is typically placed on a configuration class or the main application class. 

When `@ComponentScan` is used, Spring will scan the specified packages (or the current package if not specified) and automatically detect and register Spring beans based on certain annotations such as `@Component`, `@Service`, `@Repository`, and `@Controller`. 

By default, `@ComponentScan` scans the current package and its sub-packages, looking for classes annotated with Spring stereotypes. It automatically creates bean instances for those classes and adds them to the Spring application context. 

You can provide additional attributes to `@ComponentScan` to customize the scanning behavior, such as specifying specific packages to scan or excluding certain packages from scanning. 

Overall, `@ComponentScan` is a powerful annotation that simplifies the configuration and registration of Spring beans by automatically scanning and detecting components in the specified packages.

```java
@Configuration
@ComponentScan(basePackages = "com.example.myapp")
public class AppConfig {
    // Configuration class code...
}
```

### How to define which package spring need to scan in xml and annotaiton?

In XML configuration, you can specify the packages that Spring needs to scan using the `<context:component-scan>` element. Here's an example:

```xml
<context:component-scan base-package="com.example.myapp" />
```

In the above example, the `base-package` attribute specifies the package name (`com.example.myapp`) that Spring should scan for components.

Alternatively, if you are using Java annotations for configuration, you can use the `@ComponentScan` annotation. Here's an example:

```java
@Configuration
@ComponentScan(basePackages = "com.example.myapp")
public class AppConfig {
    // Configuration class code...
}
```

In this case, the `basePackages` attribute of `@ComponentScan` specifies the package name (`com.example.myapp`) to be scanned by Spring for components.

Both approaches achieve the same result of instructing Spring to scan the specified packages for components and register them in the application context. Choose the approach that aligns with your preferred configuration style (XML or annotation-based) and integrate it into your Spring configuration file or class.

### What is @SpringbootApplication?

`@SpringBootApplication` is an annotation in Spring Boot that combines three commonly used annotations: `@Configuration`, `@EnableAutoConfiguration`, and `@ComponentScan`.

- `@Configuration`: Indicates that the class is a configuration class, providing bean definitions and other configuration settings.
- `@EnableAutoConfiguration`: Enables Spring Boot's auto-configuration feature, which automatically configures the Spring application based on the dependencies and the classpath.
- `@ComponentScan`: Scans the specified package and its sub-packages for Spring components such as `@Component`, `@Service`, `@Repository`, and `@Controller`.

By using `@SpringBootApplication`, you can annotate your main application class to enable Spring Boot features and provide the necessary configuration for your application. It eliminates the need to explicitly specify these three annotations separately.

Here's an example:

```java
@SpringBootApplication
public class MyAppApplication {
    public static void main(String[] args) {
        SpringApplication.run(MyAppApplication.class, args);
    }
}
```

In the above example, `@SpringBootApplication` is used to annotate the main application class `MyAppApplication`. It combines the necessary annotations for a Spring Boot application and provides the entry point for running the application.

### How many ways wo can define a bean?

In Spring, there are several ways to define a bean:

1. Using XML Configuration: Beans can be defined in an XML configuration file using the `<bean>` element, specifying the bean's class, properties, and dependencies.

2. Using Java Configuration: Beans can be defined in a Java configuration class using the `@Bean` annotation. The `@Configuration` annotation is used to indicate that the class contains bean definitions.

3. Using Component Scanning: Beans can be automatically discovered and registered by enabling component scanning. Annotate the bean class with annotations such as `@Component`, `@Service`, `@Repository`, or `@Controller`. Spring will scan the specified package or packages and register the annotated classes as beans.

4. Using Stereotype Annotations: Spring provides stereotype annotations such as `@Component`, `@Service`, `@Repository`, and `@Controller`. By annotating a class with these annotations, it is automatically registered as a bean.

5. Using Factory Methods: Beans can be created by defining factory methods in a configuration class annotated with `@Configuration`. The methods annotated with `@Bean` will act as factory methods and return the bean instance.

6. Using `@Import`: Beans can be imported from other configuration classes using the `@Import` annotation. This allows beans defined in different configuration classes to be combined and made available in the application context.

These are some of the common ways to define beans in Spring. The choice of method depends on the specific requirements and preferences of the application.

### What is default bean name for @Component and @Bean?

The default bean name for `@Component` and `@Bean` is based on the name of the class or method. 

For `@Component`, if no explicit name is specified using the `value` or `name` attribute, the default bean name is derived from the class name. The default bean name is the uncapitalized version of the class name, with the first letter converted to lowercase. For example, if the class name is `MyComponent`, the default bean name will be `myComponent`.

For `@Bean`, if no explicit name is specified using the `name` attribute, the default bean name is the same as the method name. For example, if the method name is `createBean`, the default bean name will be `createBean`.

It's worth noting that bean names should be unique within the application context. If multiple beans have the same name, it can lead to conflicts and unpredictable behavior. Therefore, it's recommended to provide explicit names using the `value` or `name` attribute to avoid naming conflicts.

### What is the difference between @component and @service,@repository?

1. `@Component`: `@Component` is a generic stereotype annotation that is used to mark a class as a Spring component. It serves as a general-purpose stereotype and can be used to annotate any class in the application. It indicates that the annotated class is a candidate for auto-detection and automatic bean registration.
2. `@Service`: `@Service` is a specialization of `@Component` and is typically used to annotate classes that represent business services or domain-specific operations. It indicates that the annotated class is a service component that performs some business logic or acts as an intermediary between the presentation and data access layers.
3. `@Repository`: `@Repository` is another specialization of `@Component` and is commonly used to annotate classes that serve as data access components, typically interacting with a database or external data source. It indicates that the annotated class is a repository component responsible for data access, such as performing CRUD operations on entities.

### How many annotaitons we can use to inject the bean?

1. `@Autowired`: This annotation is used for automatic dependency injection. It can be applied to fields, constructor parameters, or methods to indicate that Spring should automatically wire the appropriate bean at runtime.

2. `@Qualifier`: When multiple beans of the same type are available, `@Qualifier` can be used along with `@Autowired` to specify the exact bean to be injected based on the bean's qualifier value.

3. `@Resource`: This annotation is used for bean injection by name. It can be applied to fields, setter methods, or constructor parameters to indicate the name of the bean to be injected.

4. `@Inject`: Similar to `@Autowired`, `@Inject` is used for automatic dependency injection. It is a standard Java annotation that can be used in place of `@Autowired`.

5. `@Value`: This annotation is used to inject values from properties files or environment variables into beans. It can be applied to fields, setter methods, or constructor parameters.

6. `@Required`: This annotation indicates that a bean property must be configured with a value, and it is typically used in conjunction with XML-based configuration.

### Tell me the three types to do dependency injection(How can we inject the beans in Spring)? Which way is better and why?

In Spring, there are three main ways to perform dependency injection:

1. Constructor Injection: In this approach, dependencies are injected through a constructor. The required dependencies are specified as constructor parameters, and Spring automatically resolves and provides the appropriate beans when creating the instance of the dependent object.

2. Setter Injection: Setter methods are used to inject dependencies in this approach. The dependent object exposes setter methods for each dependency, and Spring uses these methods to set the dependencies at runtime.

3. Field Injection: Dependencies are directly injected into the fields of the dependent object using annotations like `@Autowired` or `@Resource`. Spring automatically identifies and injects the appropriate beans into the fields.

Each approach has its advantages:

- Constructor Injection promotes immutability and ensures that all required dependencies are provided when creating an object. It helps in creating objects that are fully initialized and ready to use.

- Setter Injection provides flexibility by allowing dependencies to be set or changed at runtime. It can be useful when dealing with optional dependencies or when a large number of dependencies need to be managed.

- Field Injection offers simplicity and reduces the amount of code required. It is suitable for scenarios where dependencies are not expected to change frequently.

The choice between these approaches depends on the specific requirements and design of the application. ==Constructor Injection== is generally considered a best practice as it promotes better encapsulation, testability, and object initialization. However, Setter Injection and Field Injection can be useful in certain scenarios, such as when working with legacy code or frameworks that require default constructors.

### If we have multiple beans for one type, how to set one is primary? and how to let the spring to pick one bean to inject if no primay

In Spring, if you have multiple beans of the same type and want to set one as the primary bean, you can use the `@Primary` annotation. The `@Primary` annotation is applied to the bean definition to indicate that it is the primary bean to be used when multiple candidates are available for autowiring.

Here's an example:

```java
@Component
@Primary
public class PrimaryBean implements MyInterface {
    // ...
}
```

In the above example, the `PrimaryBean` is marked as the primary bean for the `MyInterface` type. When autowiring `MyInterface`, Spring will automatically select the primary bean for injection.

If no primary bean is set, or if you want to manually specify which bean to inject when there are multiple candidates, you can use the `@Qualifier` annotation along with the bean name. The `@Qualifier` annotation allows you to specify the exact bean to be injected by providing the bean's unique identifier.

Here's an example:

```java
@Component
public class MyComponent {
    @Autowired
    @Qualifier("specificBean")
    private MyInterface myBean;
    // ...
}
```

In the above example, the `@Qualifier` annotation is used to specify that the `specificBean` should be injected into the `myBean` field of the `MyComponent` class.

By using `@Primary` and `@Qualifier`, you can control the primary bean selection and explicitly specify the bean to be injected when multiple beans of the same type are available.

### What is the difference between BeanFactory and ApplicationContext in Spring?

The main difference between BeanFactory and ApplicationContext in Spring is the level of functionality and features they provide.

BeanFactory:
- BeanFactory is the basic container and the root interface for accessing any Spring bean.
- It provides the basic support for dependency injection and bean lifecycle management.
- BeanFactory provides lazy initialization of beans, meaning the beans are only created when requested.
- It does not support advanced features like internationalization, event publication, and application context hierarchy.

ApplicationContext:
- ApplicationContext extends the BeanFactory interface and provides a more advanced container for managing beans.
- ApplicationContext includes all the features of BeanFactory and adds additional functionalities.
- It supports internationalization and message resource handling, allowing for easy localization of messages.
- It supports event publication and handling, enabling the application to publish and listen to events.
- ApplicationContext supports a hierarchical structure, allowing multiple contexts to be nested and accessed.
- It provides advanced configuration options, such as aspect-oriented programming (AOP) and declarative transaction management.

In summary, ApplicationContext provides more features and functionality compared to BeanFactory. It is recommended to use ApplicationContext in most applications as it offers a richer set of features and better overall application context management.

### What is the Scope of a Bean? and list the examples for each scope.

The scope of a bean in Spring defines the lifecycle and visibility of the bean instance. Spring provides several bean scopes that determine how the bean is created, maintained, and accessed. The different bean scopes in Spring are:

1. Singleton: The default scope. Only one instance of the bean is created and shared across the entire application context.
   Example: Configuration beans, utility classes.

2. Prototype: A new instance of the bean is created every time it is requested.
   Example: Request-specific beans, stateful beans.

3. Request: A new instance of the bean is created for each HTTP request in a web application.
   Example: Web controllers, request-specific services.

4. Session: A new instance of the bean is created for each HTTP session in a web application.
   Example: User-specific data, session-specific services.

5. Global Session: Similar to the session scope, but used in a portlet context (e.g., JSR-286 portlets).
   Example: Portlet-specific data, portlet-specific services.

6. Application: The bean instance is scoped to the lifecycle of the entire web application.
   Example: Application-specific data, application-wide services.

7. WebSocket: The bean instance is scoped to a specific WebSocket session.
   Example: WebSocket message handlers, WebSocket-specific services.

These are some commonly used bean scopes in Spring. The choice of scope depends on the requirements and behavior of the bean in the application.