
# hw9.1

## 1. List all of the annotations you learned from class and homework to annotaitons.md

Check ShortQuestions/annotations.md

## 2. what is the @configuration and @bean?

**@Configuration** is used to declare a class as a configuration class, which contains bean definitions and other configuration options for a Spring application context. The @Configuration annotation tells Spring that this class should be used to configure the application context, and it should scan for @Bean annotations inside the class to create beans.

**@Bean** is used to declare a method that produces a bean to be managed by the Spring container. The method annotated with @Bean should return an instance of the bean, and Spring will manage the lifecycle of the bean, including instantiation, dependency injection, and destruction.
```java
@Configuration
public class MyConfiguration {

    @Bean
    public MyService myService() {
        return new MyServiceImpl();
    }

    @Bean
    public MyController myController() {
        return new MyController(myService());
    }
}

```
## 3. How do you handle the exception in Spring?

Create a GlobalExceptionHandler class that extends ResponseEntityExceptionHandler class in Spring. This class provides a set of methods that you can override to handle different types of exceptions.
 
**@ExceptionHandler:** Method Level,used to handle the specific exceptions and sending the custom responses to the client
**@ControllerAdvice:** Class Level to handle the exceptions globally 

**Steps**  
1.  create ErrorDetails Class
2.  Create GlobalExceptionHandler Class
```java
@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(value = {IllegalArgumentException.class, IllegalStateException.class})
    protected ResponseEntity<Object> handleConflict(RuntimeException ex, WebRequest request) {
        String bodyOfResponse = "This should be application specific";
        return handleExceptionInternal(ex, bodyOfResponse,
                new HttpHeaders(), HttpStatus.CONFLICT, request);
    }

    @ExceptionHandler(value = {Exception.class})
    protected ResponseEntity<Object> handleAllExceptions(Exception ex, WebRequest request) {
        String bodyOfResponse = "Something went wrong. Please try again later.";
        return handleExceptionInternal(ex, bodyOfResponse,
                new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR, request);
    }
}
```
## 4. How do you do the validations in Spring? And list some validation annotaitons you know.

In Spring, you can perform validations using the javax.validation API, which provides a set of annotations that can be used to validate request parameters, form data, and other input.

To use validations in Spring, you need to add the spring-boot-starter-validation dependency to your project. Once you've done that, you can use annotations like @NotNull, @Size, @Email, and others to validate input.

**@NotNull:** Validates that the annotated field is not null.

**@Size:** Validates that the annotated field has a size within the specified range.

**@Email:** Validates that the annotated field is a valid email address.

**@Pattern:** Validates that the annotated field matches the specified regular expression.

**@Min:** Validates that the annotated field is a number greater than or equal to the
specified value.

**@Max:** Validates that the annotated field is a number less than or equal to the specified value.

**@NotBlank:** Validates that the annotated field is not blank (i.e., contains at least one non-whitespace character).

**@NotEmpty:** Validates that the annotated field is not empty (i.e., not null and has a length greater than zero).

## 5. What is the actuator?

The Actuator is a set of tools and endpoints that provide insight into your application's runtime behavior and health. It enables you to monitor and manage your application easily.
Actuator can be easily integrated into a Spring Boot application by adding the spring-boot-starter-actuator dependency to your project. Once added, the Actuator endpoints are automatically available.

## 6. watch those videos

Done


# hw9.2

## 1. List all of the annotations you learned from class and homework to annotaitons.md

Check ShortQuestions/annotations.md

## 2. What is Spring and Springboot? What is the benfits of using Srpingboot?

Spring is an open-source application framework for the Java platform that provides comprehensive support for building enterprise-level applications. It provides various features such as dependency injection, aspect-oriented programming, and support for data access, transaction management, and more.

Spring Boot is an extension of the Spring framework that makes it easy to create stand-alone, production-grade Spring-based applications with minimal configuration. It provides a set of pre-configured components and settings that enable developers to quickly create and deploy applications.

Some of the benefits of using Spring Boot are:

**Faster development:** Spring Boot provides a lot of pre-configured components and settings, which means that developers can focus on writing application code rather than worrying about setting up configurations. This leads to faster development times and quicker time-to-market.

**Opinionated defaults:** Spring Boot comes with a set of opinionated defaults, which are sensible defaults that work well for most applications. This means that developers can spend less time configuring and more time building application features.

**Production-ready:** Spring Boot is designed with production readiness in mind. It provides features such as health checks, monitoring, and metrics out of the box, making it easy to build and deploy production-grade applications.

**Ecosystem:** Spring Boot has a large ecosystem of libraries and plugins that can be easily integrated into an application. This allows developers to leverage existing tools and components, reducing development time and improving overall application quality.

## 3. What is IOC and What is DI?
IOC (Inversion of Control) and DI (Dependency Injection) are two related concepts in Spring that are used to manage object dependencies and reduce coupling between classes.

IOC refers to the design pattern in which the control of object creation and management is shifted from the application code to a container or framework. In other words, instead of an application explicitly creating and managing the dependencies between its objects, it delegates that responsibility to an external entity.

DI is a technique for implementing IOC, where the dependencies of an object are injected into it rather than the object itself creating its dependencies. It is a way of providing the necessary dependencies to an object without requiring the object to know how to create them.

In Spring, the IOC container is responsible for creating and managing objects and their dependencies. It uses DI to inject dependencies into an object when it is created. Spring provides several ways of implementing DI, including constructor injection, setter injection, and field injection.

## 4. What is @CompnonentScan?

@ComponentScan is an annotation in Spring that is used to instruct the Spring container to scan for and register beans (components) within a specified package or set of packages.

When Spring scans the specified package(s), it looks for classes annotated with @Component, @Service, @Repository, @Controller, or any custom annotations that are themselves annotated with @Component. These classes are then registered as beans in the Spring container, which can be subsequently injected into other classes.

```java
@Configuration
@ComponentScan("com.example.app")
public class AppConfig {
    // other configuration
}
```
## 5. How to define which package spring need to scan in xml and annotaiton?

1,using XML configuration or using annotations:
```java
<context:component-scan base-package="com.example.app" />
```

2, scan using annotations:
```java
@ComponentScan("com.example.app")
```
## 6. What is @SpringbootApplication?

**@SpringBootApplication** is an annotation in Spring Boot that is used to combine the functionality of three annotations: @Configuration, @EnableAutoConfiguration, and @ComponentScan.

The @SpringBootApplication annotation is a convenient way to configure a Spring Boot application, as it eliminates the need to include each of these annotations separately. When applied to a class, it marks the class as a Spring Boot application and instructs the Spring Boot framework to perform the following tasks:

**@Configuration:** Indicates that the class contains configuration methods that should be processed by the Spring container to generate bean definitions and manage dependencies.

**@EnableAutoConfiguration:** Enables Spring Boot's auto-configuration feature, which automatically configures the Spring application based on classpath settings, such as the presence of certain libraries or frameworks.

**@ComponentScan:** Scans the specified package(s) and registers any classes annotated with @Component, @Service, @Repository, @Controller, or any custom annotations that are themselves annotated with @Component.

```java
@SpringBootApplication
public class MyApp {
    public static void main(String[] args) {
        SpringApplication.run(MyApp.class, args);
    }
}
```
## 7. How many ways wo can define a bean?

There are three ways:

*Class level:*

  **@Component
  @Service
  @Repository
  @Controller
  @ContollerAdvice**
  
  ```java
  @Component
public class MyBean {
    private String property1;
    private DependencyBean property2;

    // getters and setters
}
  ```
  
*Method level*

**@Bean (used with @Configuration) together**
```java
@Configuration
public class MyAppConfig {
    @Bean
    public MyBean myBean() {
        MyBean bean = new MyBean();
        bean.setProperty1("value1");
        bean.setProperty2(dependencyBean());
        return bean;
    }
    @Bean
    public DependencyBean dependencyBean() {
        return new DependencyBean();
    }
}
```
*XML*
```java
<bean id="dataNucleusChuwaNoComponent" 
 class="com.chuwa.springbasic.components.impl.DataNu
cleusChuwaNoComponent"></bean>
```

## 8. What is default bean name for @Component and @Bean?

In Spring, the default bean name for a class annotated with @Component is the uncapitalized and fully-qualified class name. For example, if we have a class named MyComponent in the package com.example, the default bean name would be com.example.myComponent.

On the other hand, when we use the @Bean annotation to define a bean in a @Configuration class, the default bean name is the name of the method annotated with @Bean. For example, if we have a method named myBean in a @Configuration class, the default bean name would be myBean

## 9. What is the difference between @component and @service,@repository?

In Spring, @Component, @Service, and @Repository are three annotations that are used to indicate the role of a class in the application context. Here are the main differences between these annotations:

**@Component:** @Component is a generic annotation that can be used to indicate any Spring-managed component. It's the base annotation for all other stereotype annotations in Spring, including @Service and @Repository.

**@Service:** @Service is a specialization of @Component that is used to indicate a class that performs a service or business logic in the application. Typically, @Service classes are used to encapsulate the application's business logic and are often used in conjunction with @Controller classes to implement the application's use cases.

**@Repository:** @Repository is a specialization of @Component that is used to indicate a class that performs data access operations in the application. @Repository classes typically encapsulate database access code, and may use Spring's JdbcTemplate or HibernateTemplate to interact with the database.

## 10. How many annotaitons we can use to inject the bean?

**@Autowired:** @Autowired is the primary annotation used for dependency injection in Spring. It can be used to inject a bean into a class's constructor, field, or method.

**@Qualifier:** @Qualifier is used in conjunction with @Autowired to specify which bean to inject when there are multiple beans of the same type. We can use @Qualifier to specify the name of the bean to inject, as defined by the @Component or @Bean annotation.

**@Resource:** @Resource is another annotation that can be used to inject beans into a class. It can be used to inject a bean by name or by type.

**@Inject:** @Inject is an alternative to @Autowired that is part of the Java Dependency Injection (JSR-330) specification. It can be used to inject a bean into a class's constructor, field, or method.

**@Value:** @Value is an annotation that can be used to inject values from properties files, environment variables, or system properties into a class's fields.

## 11. Tell me the three types to do dependency injection(How can we inject the beans in Spring)? Which way is better and why?

**1,Constructor injection:**
```java
@Component
public class MyService {
    
    private final MyDependency myDependency;
    @Autowired
    public MyService(MyDependency myDependency) {
        this.myDependency = myDependency;
    }

}
```
**2, Setter injection**
```java
@Component
public class MyService {
    
    private MyDependency myDependency;
 
    @Autowired
    public void setMyDependency(MyDependency myDependency) {
        this.myDependency = myDependency;
    }
}
```
**3, Field injection**
```java
@Component
public class MyService {    
    @Autowired
    private MyDependency myDependency;
}
```
## 12. If we have multiple beans for one type, how to set one is primary? and how to let the spring to pick one bean to inject if no primay.

If you have multiple beans of the same type and you want to specify one as the primary bean to use, you can use the @Primary annotation.
```java
@Component
@Primary
public class MyPrimaryBean implements MyInterface {
}
```
The spring will according to the order to pick one bean:

Priority: @Qualifier > @Primary > By Name > throw exception(NoUniqueBeanDefinitionException)

## 13. What is the difference between BeanFactory and ApplicationContext in Spring?

BeanFactory is a basic interface for managing beans, providing basic support for dependency injection and bean lifecycle management. ApplicationContext is an advanced interface that extends BeanFactory, providing additional features such as AOP, message resource bundles, and event propagation. ApplicationContext is preferred for most Spring applications, while BeanFactory may be better for lightweight containers with basic functionality.

## 14. What is the Scope of a Bean? and list the examples for each scope.

**Singleton Scope** - Creates only one instance of the bean for the entire application context.

**Prototype Scope** - Creates a new instance of the bean every time it is requested.

**Request Scope** - Creates a new instance of the bean for every HTTP request.

**Session Scope** - Creates a new instance of the bean for every HTTP session.

**Global Session Scope** - Same as session scope, but for portlet-based web applications.

**WebSocket Scope** - Creates a new instance of the bean for every WebSocket connection.

Examples of each scope are:

**Singleton Scope** - Typically used for stateless beans such as DAOs, Services, and Utils.

**Prototype Scope** - Used for stateful beans such as Controllers and Command Objects.

**Request Scope** - Used for beans that are required only for a specific HTTP request, such as Controllers, and are discarded after the request has been processed.

**Session Scope** - Used for beans that need to maintain state across multiple HTTP requests from the same client, such as User objects and Shopping Cart objects.

**Global Session Scope** - Used for portlet-based web applications where the session is shared across multiple portlets.

**WebSocket Scope** - Used for beans that need to maintain state across multiple WebSocket connections.

## 15. Configure a bean using xml. If bean has parameters/dependencies, how can we configure the bean?

```java
<bean id="myBean" class="com.example.MyBean">
  <property name="propertyName" value="propertyValue"/>
  <property name="otherBean" ref="otherBean"/>
</bean>

<bean id="otherBean" class="com.example.OtherBean"/>

```

 
# hw9.3

## 1. List all of the annotations you learned from class and homework to annotaitons.md

Check ShortQuestions/annotations.md


## 2. What is MVC pattern?

MVC stands for Model-View-Controller, which is a design pattern used in software development to separate an application's concerns into three interconnected components: the Model, the View, and the Controller.

**Model:** The Model component represents the data and the business logic of the application. It encapsulates the data and provides methods to manipulate and access it.

**View:** The View component represents the presentation layer of the application. It is responsible for rendering the data provided by the Model in a user-friendly format. The View can be a web page, a mobile app screen, or any other user interface element.

**Controller:** The Controller component acts as an intermediary between the Model and the View. It receives input from the user via the View, interacts with the Model to update the data, and then updates the View with the new data.

## 3. What is Front-Controller?
Front-Controller is a design pattern used in web development to provide a centralized entry point for handling incoming requests. The Front-Controller is responsible for handling all the requests and routing them to the appropriate controllers and actions based on the request URL or other criteria.

## 4. What is DispatcherServlet? please decribe how it works.

In Spring MVC, DispatcherServlet is the Front-Controller that receives incoming requests and dispatches them to the appropriate controllers and actions based on the request URL and configuration.

Here is how the DispatcherServlet works:

1, When a request is received, the DispatcherServlet is invoked by the servlet container.
The DispatcherServlet checks the request URL and matches it with the configured mappings to determine the appropriate controller for handling the request.

2, Once the controller is determined, the DispatcherServlet delegates the request to the controller for processing.

3, The controller processes the request and returns a ModelAndView object containing the name of the view to be rendered and any model data to be passed to the view.

4, The DispatcherServlet then uses a ViewResolver to determine the appropriate view to render based on the view name returned by the controller.

5，Once the view is determined, the DispatcherServlet renders the view and sends the response back to the client.

## 5. What is JSP and What is ModelAndView？

**JSP (JavaServer Pages)** is a technology used to create dynamic web pages with Java code embedded within HTML. It enables developers to separate presentation logic from the business logic in a web application.

**ModelAndView** is a class in Spring MVC that combines a model with a view. It allows developers to pass data to a view and also specify the view that should be rendered. The model part of the ModelAndView object contains data that needs to be passed to the view, while the view part of the object specifies the name of the view that should be rendered.

## 6. Could you please google any other servlets

**HttpServlet:** The base class for HTTP servlets in Java, used to handle HTTP requests and responses.

**Filter:** Used to intercept and process requests and responses before they reach the servlet, allowing for pre-processing or post-processing of requests and responses.

**Listener:** Used to receive notifications about changes in the web application or web server, such as session creation or destruction.

**RequestDispatcher:** Used to forward a request from one servlet or JSP page to another resource (servlet, JSP page, or HTML file) on the server.

**AsyncContext:** Used to handle asynchronous request processing in servlets, allowing a servlet to process a request in a separate thread and send the response back to the client at a later time.

**SessionCookieConfig:** Used to configure the session cookie settings, such as the cookie name, domain, and path.

**ServletContext:** Provides a way for servlets to communicate with each other and share data, and also provides access to the container-specific features of the web server.

## 7. How many web server do you know? (Tomcat, Jetty, Jboss)

1, Apache Tomcat

2, Jetty

3, JBoss (Wildfly)

4, Apache HTTP Server

5, NGINX

6, Microsoft IIS (Internet Information Services)

7, Oracle WebLogic

8, IBM WebSphere

9, GlassFish

10, Undertow

## 8. clone this repo, and run it in you local.

Done