## Exception
Q2  
@Configuration is a marker annotation that indicates that the class decorated with it is a configuration class, and contains one or more methods annotated with @Bean. The configuration class is responsible for defining and organizing the beans that will be created by the Spring container.

@Bean is an annotation used to mark a method inside a configuration class that returns a bean instance. The method annotated with @Bean is responsible for creating and configuring the bean instance, and returns the bean object. When the Spring container starts, it will scan the configuration class and create an instance of the beans defined by the @Bean methods.

```java
@Configuration
public class AppConfig {

   @Bean
   public MyService myService() {
      return new MyServiceImpl();
   }
}
```

Q3  
Using @ExceptionHandler annotation: You can define methods annotated with @ExceptionHandler in a controller or globally in a class annotated with @ControllerAdvice to handle specific exceptions or groups of exceptions. When an exception is thrown, Spring will invoke the appropriate @ExceptionHandler method to handle the exception. 

Using HandlerExceptionResolver interface: You can create a custom implementation of the HandlerExceptionResolver interface and register it with Spring. The HandlerExceptionResolver interface provides a way to handle exceptions globally. 

Using @ControllerAdvice and @ResponseStatus annotations: You can define a method in a class annotated with @ControllerAdvice and @ResponseStatus to handle exceptions and set the HTTP status code.

Q4  
Add the required dependencies: You need to add the following dependency to your pom.xml file to use the Java Bean Validation API

Define validation constraints: You can define validation constraints using validation annotations such as @NotNull, @NotBlank, @Size, @Min, @Max, etc. These annotations can be applied to fields or method parameters. 

Use validation in controller methods: You can use the @Valid annotation to validate request objects in your controller methods. 

Q5  
In Spring, the actuator is a set of tools and endpoints that provide production-ready features for monitoring and managing your application. The Spring Boot Actuator module provides several endpoints that expose information about your application, such as health, metrics, environment variables, and more.

## Basic
Q2  
Spring is a popular Java framework that provides a comprehensive programming and configuration model for building enterprise Java applications. It provides a wide range of features and modules, such as dependency injection, AOP, data access, web development, and more.

Spring Boot is a framework built on top of Spring that makes it easier to create standalone, production-grade Spring applications. It provides a streamlined development and deployment experience by auto-configuring many of the common components and dependencies required by Spring applications. Spring Boot also includes an embedded web server, which eliminates the need to deploy your application to a separate web server.

Q3  
In Spring, IOC (Inversion of Control) and DI (Dependency Injection) are closely related concepts that are used to achieve loose coupling between components in a software application.

IOC is a design pattern that reverses the control of flow of an application from the application code to a framework or container. Instead of the application code directly creating and managing the dependencies of its objects, it delegates this responsibility to the container or framework. The container then injects the dependencies into the objects at runtime, based on the configuration.

DI is a type of IOC that focuses on managing the dependencies between objects. It involves injecting the dependencies of an object into the object itself, rather than having the object create and manage its dependencies. This makes the objects loosely coupled and easier to test, maintain, and extend.

Q4  
@ComponentScan is an annotation in Spring that is used to enable component scanning in an application. Component scanning is a process in Spring that automatically detects and registers the Spring-managed components (such as beans, controllers, services, and repositories) in an application.

Q5  
```xml
<context:component-scan base-package="com.example"/>
```
```java
@Configuration
@ComponentScan(basePackages = "com.example")
public class AppConfig {
    // Bean definitions go here
}
```

Q6  
@SpringBootApplication is an annotation in Spring Boot that is used to enable auto-configuration and component scanning in a Spring Boot application. This annotation is a combination of three other annotations: @Configuration, @EnableAutoConfiguration, and @ComponentScan.

Q7  
1. Using the @Bean annotation: This is the most common way to define a bean in Spring. You can annotate a method in a @Configuration class with the @Bean annotation to indicate that it should be registered as a bean in the Spring context.

2. Using component scanning: If you have a class that you want to register as a bean in the Spring context, you can annotate it with @Component, @Service, @Repository, or @Controller, and then use component scanning to automatically detect and register the bean.

3. Using XML configuration: You can define beans in an XML configuration file using the <bean> element. This is an older way of defining beans in Spring, but it is still supported for backwards compatibility.

4. Using annotations such as @ConfigurationProperties: Some Spring annotations can be used to define beans, such as @ConfigurationProperties, which can be used to bind external configuration properties to a bean.

5. Using third-party libraries or frameworks: Some libraries and frameworks provide their own mechanisms for defining beans, such as the @Component annotation in Spring Data JPA, which is used to define repository beans.

Q8  
For @Component: If you annotate a class with @Component and do not specify a name for the bean, the bean name will be the same as the class name, with the first letter in lowercase. For example, if you have a class called UserService, the default bean name will be userService.

For @Bean: If you define a bean using the @Bean annotation and do not specify a name for the bean, the bean name will be the same as the method name. For example, if you have a method called getUserService() that returns a UserService object, the default bean name will be getUserService.

Q9  
@Component: This is the most generic stereotype annotation and is used to indicate that a class is a Spring-managed bean. It can be used for any type of bean and does not carry any specific semantics or functionality.

@Service: This stereotype is used to indicate that a class is a service component in a layered architecture. It typically contains business logic and interacts with data access components, such as repositories. Service components are often used to implement use cases or business processes in an application.

@Repository: This stereotype is used to indicate that a class is a data access component, such as a DAO or repository. It typically interacts with a persistence layer, such as a database, and provides CRUD operations for domain objects.

Q10  
@Autowired: This annotation can be used to inject a bean into another bean. It can be applied to a constructor, a setter method, or a field.

@Qualifier: When multiple beans of the same type are present in the application context, the @Qualifier annotation can be used to specify which bean to inject.

@Resource: This annotation is similar to @Autowired, but it uses the name of the bean to perform the injection. It can be applied to a setter method or a field.

@Value: This annotation can be used to inject a value, such as a string or an integer, into a bean.

@Inject: This annotation is similar to @Autowired and is used to inject a bean into another bean. It can be applied to a constructor, a setter method, or a field.

Q11  
Constructor Injection: This is a type of dependency injection where the dependencies are injected via a constructor. The required dependencies are passed as arguments to the constructor when the object is created. This ensures that the object is in a fully initialized state before it can be used.

Setter Injection: This is a type of dependency injection where the dependencies are injected via setter methods. The required dependencies are set using setter methods after the object is created. Setter injection allows for more flexibility, as it allows for optional dependencies and re-injection of dependencies.

Field Injection: This is a type of dependency injection where the dependencies are injected directly into the fields of the object using annotations such as @Autowired or @Resource. Field injection is the least verbose, but it has some drawbacks, such as making the code less testable and making it harder to enforce dependencies.

Constructor injection is generally considered the best approach for injecting dependencies in Spring, as it promotes immutability and helps ensure that the object is in a fully initialized state before it is used. It also makes it easier to enforce dependencies and to write unit tests.

Q12  
In Spring, you can set one bean as the primary bean for a given type using the @Primary annotation. When there are multiple beans of the same type, Spring will use the primary bean for injection by default.

To select a specific bean to inject in cases where there is no primary bean, you can use the @Qualifier annotation. The @Qualifier annotation allows you to specify a bean name or a custom qualifier to differentiate between multiple beans of the same type.

Q13  
In Spring, BeanFactory and ApplicationContext are two interfaces that provide dependency injection and other services to Spring applications. Here's the difference between the two:

- Initialization: BeanFactory provides a basic set of functionalities for managing and wiring beans. It lazily initializes beans (i.e., creates beans only when needed) while ApplicationContext eagerly initializes all the beans and pre-instantiates singletons (i.e., creates all beans on startup).

- Configuration: BeanFactory provides basic support for dependency injection through XML files, while ApplicationContext provides a more extensive support for various types of configurations such as XML, Annotations, Java Configuration, and Properties files.

- Predefined Beans: ApplicationContext has several built-in beans that can be used in an application, such as Environment, MessageSource, and ResourceLoader. BeanFactory does not provide such built-in beans.

- Features: ApplicationContext provides several additional features on top of what BeanFactory provides, such as internationalization, support for declarative transaction management, support for AOP, and support for various application contexts (e.g., WebApplicationContext).

- Startup Time: Because BeanFactory initializes beans lazily, it is generally faster to start up than ApplicationContext.

Q14  
In Spring, the scope of a bean defines the lifecycle and visibility of the bean instance. Here are the different scopes available in Spring:

1. Singleton: The default scope in Spring. The container creates a single instance of the bean and shares it with all the references to the bean. Examples include database connections, DAOs, and service classes.

2. Prototype: The container creates a new instance of the bean every time it is requested. Examples include stateful objects and objects that are not thread-safe.

3. Request: The container creates a new instance of the bean for each HTTP request. Examples include controllers and web-related objects.

4. Session: The container creates a new instance of the bean for each HTTP session. Examples include user-specific data and shopping cart items.

5. Global Session: The container creates a single instance of the bean for each global HTTP session. This is only applicable for portlet contexts.

6. Application: The container creates a single instance of the bean for each ServletContext. Examples include objects that are used by multiple servlets.

7. Web Socket: The container creates a single instance of the bean for each WebSocket.

Here are a few examples for each scope:

- Singleton: A data source or a logging service
- Prototype: A shopping cart or a game character
- Request: An HTTP request handler or a view controller
- Session: User profile information or a user's shopping cart
- Global Session: A user's session across multiple portlets
- Application: A servlet context listener or a servlet context attribute holder
- Web Socket: A WebSocket endpoint or a WebSocket session handler

Q15

```xml

<bean id="myBean" class="com.example.MyBean">
    <constructor-arg ref="dependencyBean"/>
    <constructor-arg value="someValue"/>
</bean>

<bean id="dependencyBean" class="com.example.DependencyBean"/>
```

## MVC
Q2  
MVC stands for Model-View-Controller, which is a popular design pattern used in software engineering to develop user interfaces. It separates the application logic into three interconnected components, namely:

1. Model: This component represents the data and the business logic of the application. It encapsulates the data and provides methods to manipulate it. The model notifies the controller when there are changes in the data.

2. View: This component is responsible for rendering the data to the user. It presents the data to the user in a particular format. The view gets its data from the model and sends user actions to the controller.

3. Controller: This component acts as an intermediary between the view and the model. It receives user actions from the view, updates the model accordingly, and notifies the view of any changes in the model. The controller is responsible for controlling the flow of the application.

The main benefit of the MVC pattern is that it helps to separate concerns and promote modularity. It makes the application more maintainable, extensible, and testable.

Q3  
Front-Controller is a common pattern used in web development that helps to centralize the processing of web requests. In this pattern, all incoming requests are handled by a single component, called the Front-Controller, which is responsible for dispatching the requests to the appropriate handler.

The Front-Controller receives the incoming request and decides which handler should process the request based on the request parameters, such as the URL or the HTTP method. The handler may be a controller or any other component that is capable of processing the request.

Q4  
In the Spring Framework, the DispatcherServlet is the Front-Controller that handles incoming requests and dispatches them to the appropriate handlers (controllers) based on the request URI and other factors. Here is how the DispatcherServlet works:

1. When a request is received by the web application, the web container forwards it to the DispatcherServlet.

2. The DispatcherServlet reads the request URI and consults its internal HandlerMapping to determine which handler (controller) is responsible for processing the request.

3. The DispatcherServlet invokes the selected handler to process the request.

4. The handler (controller) processes the request and returns a ModelAndView object that contains the model data and the name of the view to render.

5. The DispatcherServlet consults its internal ViewResolver to find the appropriate view to render based on the view name provided in the ModelAndView object.

6. The selected view is rendered, and the final HTML output is returned to the client.

Q5  
JSP (JavaServer Pages) is a technology used for developing dynamic web pages based on Java servlets. JSPs allow you to embed Java code in HTML pages, making it easy to generate dynamic content such as database-driven content, user input validation, and session tracking. JSPs can be deployed on any web server that supports the Java Servlet specification.

ModelAndView is a Spring Framework class used to encapsulate both model data and view information, making it easy to pass data from the controller to the view. A ModelAndView object typically contains a map of model attributes (e.g., user data, form data) and the logical name of the view to be rendered (e.g., a JSP file or a template). When a controller returns a ModelAndView object, the DispatcherServlet extracts the model data and view information and renders the view using the specified view technology (e.g., JSP, Thymeleaf).

Q6  
1. HttpSession: This servlet provides a way for web applications to maintain user sessions across multiple HTTP requests.

2. ServletContext: This servlet provides access to the web application's context information, which can be used to share data between servlets.

3. HttpServletRequest: This servlet provides access to the current HTTP request, including parameters, headers, and other information.

4. HttpServletResponse: This servlet provides access to the current HTTP response, which can be used to send data back to the client.

5. Filter: This servlet provides a way to intercept requests and responses before they reach the servlet or after they have been processed.

6. RequestDispatcher: This servlet provides a way to forward a request from one servlet to another servlet or to include the response from another servlet in the current response.

Q7  
Apache Tomcat: It is an open-source web server and servlet container that is widely used for hosting Java-based web applications.

Jetty: It is a lightweight and highly scalable web server and servlet container that is often used for embedded applications or as a load balancer.

JBoss/WildFly: It is an open-source application server that provides a complete set of services for building, deploying, and running enterprise applications.
