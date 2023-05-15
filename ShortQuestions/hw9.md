# hw42 exception validation

## 1. List all of the annotations you learned from class and homework to annotaitons.md
check annotations.md

## 2. what is the @configuration and @bean?
`@Configuration` is used to mark a Java class as a configuration class. It indicates that the class contains bean definitions and other configuration-related annotations. The configuration class is typically used in place of XML configuration files. It allows you to define beans and their dependencies, specify initialization and destruction methods, and apply other configuration settings.

`@Bean` is used to mark a method in a @Configuration class as a bean definition method. It indicates that the method produces a bean object that should be managed by the Spring container. The method name represents the bean name, and the return type represents the bean type. You can also provide additional attributes to customize the bean, such as scope, initialization, and destruction methods.

```java
@Configuration
public class AppConfig {
    @Bean
    public MyBean myBean() {
        return new MyBean();
    }
}
```

In the above example, the `myBean()` method is annotated with `@Bean`, indicating that it produces a bean of type MyBean. The method implementation creates and returns an instance of MyBean, which will be managed by the Spring container.

## 3. How do you handle the exception in Spring?
Using `@ExceptionHandler`: You can use the `@ExceptionHandler` annotation to define methods in your controller classes that handle specific exceptions. When an exception of the specified type is thrown during the execution of a request, Spring will invoke the corresponding exception handler method.
```java
@Controller
public class MyController {
    @ExceptionHandler(MyException.class)
    public ResponseEntity<String> handleMyException(MyException ex) {
        // Handle the exception and return a response
    }
}
```

Using `@ControllerAdvice`: `@ControllerAdvice` is an annotation that allows you to define global exception handling across multiple controllers. You can use it to define exception handler methods that will be applied to all controllers or specific controller packages.
```java
@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleException(Exception ex) {
        // Handle the exception and return a response
    }
}
```

Using `HandlerExceptionResolver`: `HandlerExceptionResolver` is an interface that allows you to implement custom exception resolution logic. You can create a class that implements this interface and define your exception handling logic. Spring will automatically detect and use your custom `HandlerExceptionResolver`.

Using `@ResponseStatus`: You can use the `@ResponseStatus` annotation to set the HTTP response status code for a specific exception. By annotating your exception class with `@ResponseStatus`, you can specify the desired status code to be returned when that exception occurs.
```java
@ResponseStatus(HttpStatus.BAD_REQUEST)
public class MyException extends RuntimeException {
    // Exception implementation
}
```

## 4. How do you do the validations in Spring? And list some validation annotaitons you know.
Add validation annotations to your model classes: Annotate the fields or properties of your model classes with validation annotations provided by Spring. These annotations define the validation constraints for the corresponding fields.
```java
public class User {
    @NotBlank
    private String username;

    @Email
    private String email;

    // Getters and setters
}
```

Perform validation in your controller methods: In your controller methods, use the `@Valid` annotation to trigger validation for the annotated model object. Spring will automatically perform the validation based on the defined constraints and populate the BindingResult object with the validation results.
```java
@PostMapping("/users")
public ResponseEntity<String> createUser(@Valid @RequestBody User user, BindingResult bindingResult) {
    if (bindingResult.hasErrors()) {
        // Handle validation errors
    }
    // Process the valid user data
}
```

Some common validation annotations provided by Spring include:

`@NotNull`: Ensures that the annotated element is not null.
`@NotEmpty`: Ensures that the annotated string, collection, map, or array is not empty.
`@NotBlank`: Ensures that the annotated string is not null and not empty, ignoring whitespace.
`@Min`: Specifies the minimum value for numeric fields or properties.
`@Max`: Specifies the maximum value for numeric fields or properties.
`@Size`: Specifies the size constraints for string, collection, map, or array fields or properties.
`@Pattern`: Specifies a regular expression pattern that the annotated string must match.

## 5. What is the actuator?
In the context of Spring Boot, the Actuator is a feature that provides endpoints for monitoring and managing your application. It allows you to gather useful information about your application's health, metrics, configuration, and more. The Actuator endpoints can be accessed via HTTP or JMX, providing valuable insights into your application's internals.

Health check endpoint (/actuator/health): Provides information about the health of your application, indicating whether it's up and running or if there are any issues.

Metrics endpoint (/actuator/metrics): Offers various metrics related to your application, such as CPU usage, memory usage, request counts, and custom metrics. You can monitor and analyze these metrics to gain insights into your application's performance.

Info endpoint (/actuator/info): Allows you to provide custom information about your application. You can include details like version, description, environment-specific configuration, or any other relevant metadata.

Environment endpoint (/actuator/env): Provides information about the application's environment, including system properties, environment variables, and configuration properties.

Logging endpoint (/actuator/loggers): Enables you to view and modify the logging configuration of your application at runtime. You can dynamically change the logging levels for different packages or classes without restarting the application.

Thread dump endpoint (/actuator/threaddump): Generates a thread dump of the running application, which is helpful for diagnosing thread-related issues and analyzing the application's thread usage.

## 6. watch those videos(泛泛地看⼀遍，能理解多少是多少。没有必要看其它视频)
a. Spring 简介： https://www.youtube.com/watch?v=l0MqsOADAUE&list=PLmOn9nNkQxJFbsU4Qz8CdRiVM4Qs3ci75&index=64
b. IOC/DI: https://www.youtube.com/watch?v=PyMxNr2p0C0&list=PLmOn9nNkQxJFbsU4Qz8CdRiVM4Qs3ci75&index=65
c. IOC container: https://www.youtube.com/watch?v=pLa77Tw-yyI&list=PLmOn9nNkQxJFbsU4Qz8CdRiVM4Qs3ci75&index=66
d. Bean:
i. https://www.youtube.com/watch?v=OpgMHzM7tgQ&list=PLmOn9nNkQxJFbsU4Qz8CdRiVM4Qs3ci75&index=67
ii. https://www.youtube.com/watch?v=OpgMHzM7tgQ&list=PLmOn9nNkQxJFbsU4Qz8CdRiVM4Qs3ci75&index=68
iii. https://www.youtube.com/watch?v=OpgMHzM7tgQ&list=PLmOn9nNkQxJFbsU4Qz8CdRiVM4Qs3ci75&index=69
e. DI:
i. https://www.youtube.com/watch?v=MgTpBST9onM&list=PLmOn9nNkQxJFbsU4Qz8CdRiVM4Qs3ci75&index=70
ii. https://www.youtube.com/watch?v=yhEWZx2i1BA&list=PLmOn9nNkQxJFbsU4Qz8CdRiVM4Qs3ci75&index=71

# hw43 spring basic

## 1. List all of the annotations you learned from class and homework to annotaitons.md
check annotations.md

## 2. What is Spring and Springboot? What is the benfits of using Srpingboot?
Spring is a popular open-source framework for building Java applications. It provides a comprehensive programming and configuration model for developing enterprise-grade applications. Spring is known for its modularity, extensibility, and support for dependency injection, which promotes loose coupling and testability of components.

Spring Boot, on the other hand, is a framework built on top of Spring that aims to simplify the development of Spring applications. It provides a streamlined experience by automating the configuration and setup of a Spring application, allowing developers to focus more on writing business logic rather than dealing with complex configuration. Spring Boot takes an opinionated approach, providing sensible defaults and conventions, which helps accelerate application development.

Benefits of using Spring Boot include:

Easy and Quick Setup: Spring Boot eliminates the need for manual configuration and boilerplate code. It provides a set of starter dependencies that include all the necessary libraries, configurations, and defaults for building a specific type of application. This allows developers to get started quickly without spending time on initial setup.

Simplified Configuration: Spring Boot offers a convention-over-configuration approach, allowing developers to minimize the configuration burden. It provides sensible defaults based on the project's dependencies and offers externalized configuration options using properties files, YAML files, or environment variables.

Embedded Server: Spring Boot includes an embedded servlet container (Tomcat, Jetty, or Undertow) that allows developers to package the application as a standalone JAR file. This makes it easy to deploy and run the application without the need for external servers.

Auto-configuration: Spring Boot's auto-configuration feature automatically configures various components based on the dependencies and classpath. It simplifies the configuration process by reducing the need for explicit configuration declarations.

Production-Ready Features: Spring Boot provides a range of production-ready features out of the box, such as health checks, metrics, monitoring, and security. These features help in building robust and scalable applications with minimal effort.

Ecosystem and Community: Spring Boot benefits from the large and active Spring ecosystem and community. It has extensive documentation, tutorials, and community support, making it easier to find help and resources when needed.

## 3. What is IOC and What is DI?
IOC refers to the design principle where the control of object creation and dependency management is inverted or delegated to a container or framework. In traditional programming, objects are responsible for creating and managing their dependencies, leading to tight coupling between classes. With IOC, the responsibility of creating and managing objects is transferred to an external container, which is responsible for wiring dependencies and providing objects to other classes.

DI, on the other hand, is a specific implementation of IOC. It is a technique used to achieve loose coupling between classes by injecting dependencies into a class from an external source rather than creating them within the class itself. With DI, the class declares its dependencies as constructor parameters, method arguments, or properties, and the container resolves and provides these dependencies at runtime.

The main benefits of IOC and DI are:

Loose Coupling: IOC and DI promote loose coupling between classes by removing the responsibility of object creation and dependency management from the classes themselves. This allows for easier maintenance, testing, and reusability of components.

Testability: By injecting dependencies, it becomes easier to create unit tests for individual classes. Mock or stub objects can be easily injected during testing to isolate the class under test.

Modular and Scalable Design: IOC and DI enable modular and scalable design by decoupling components. New components can be easily added or replaced without impacting the existing codebase.

Separation of Concerns: IOC and DI help in separating the concerns of object creation and dependency management from the business logic of the classes. This improves the overall structure and organization of the code.

Reusability: With DI, dependencies can be easily reused in different contexts or scenarios. Components can be wired with different implementations of dependencies without modifying the class itself.

## 4. What is @CompnonentScan?
`@ComponentScan` is an annotation provided by the Spring framework that is used to configure component scanning in a Spring application. Component scanning is the process of automatically detecting and registering Spring components such as `@Component`, `@Service`, `@Repository`, and `@Controller` within the application context.

By default, Spring only scans for components in the current package and its sub-packages. However, when `@ComponentScan` is used, it allows for customizing the component scanning behavior. The `@ComponentScan` annotation can be placed on a configuration class or a main application class.

The `@ComponentScan` annotation supports several attributes that allow for fine-grained control over the component scanning process:

`basePackage` (or basePackages): Specifies the base package(s) to scan for components. By default, it scans the package of the annotated class.

`value` (or basePackageClasses): Alternative to basePackage, it specifies the same information using class references instead of package names.

`includeFilters` and `excludeFilters`: Allows for customizing the filters used during component scanning. Filters can be used to include or exclude certain types of components based on specific criteria such as annotations, custom annotations, or class types.

`useDefaultFilters`: Specifies whether to include the default filters for component scanning. By default, it is set to true.

`lazyInit`: Specifies whether lazy initialization should be enabled for components detected during scanning. By default, it is set to false, meaning all components are eagerly initialized.

The `@ComponentScan` annotation is often used in combination with other annotations like @Configuration to configure and bootstrap a Spring application. It allows Spring to automatically detect and register components within the application context, making them available for dependency injection and other Spring features.
```java
@Configuration
@ComponentScan(basePackages = "com.example.myapp")
public class AppConfig {
    // Configuration class code...
}
```

## 5. How to define which package spring need to scan in xml and annotaiton?
XML Configuration:
In XML configuration, you can use the <context:component-scan> element to specify the packages to be scanned. Here's an example:
```xml
<context:component-scan base-package="com.example.myapp" />
```
In the above example, the `com.example.myapp` package and its sub-packages will be scanned for Spring components.

Annotation Configuration:
In annotation-based configuration, you can use the `@ComponentScan` annotation to specify the packages to be scanned. Here's an example:
```xml
@Configuration
@ComponentScan(basePackages = "com.example.myapp")
public class AppConfig {
    // Configuration class code...
}
```
In the above example, the `com.example.myapp` package and its sub-packages will be scanned for Spring components.

## 6. What is @SpringbootApplication?
`@SpringBootApplication` is a convenient annotation provided by the Spring Boot framework. It is a combination of multiple annotations that are commonly used together to bootstrap a Spring Boot application. It serves as a shortcut to enable the following features:

`@Configuration`: Indicates that the class is a configuration class that defines beans and other Spring configuration.

`@EnableAutoConfiguration`: Enables Spring Boot's auto-configuration mechanism. It automatically configures various dependencies and components based on the classpath and the project's dependencies.

`@ComponentScan`: Scans for components (such as `@Component`, `@Service`, `@Repository`, `@Controller`, etc.) within the application package and its sub-packages.
```java
@SpringBootApplication
public class MyAppApplication {
    public static void main(String[] args) {
        SpringApplication.run(MyAppApplication.class, args);
    }
}
```


## 7. How many ways wo can define a bean?
XML Configuration: You can define beans in an XML configuration file using the <bean> element. You specify the class of the bean, its properties, and dependencies within the XML file.

Annotation-based Configuration: You can use annotations to define beans directly in your Java code. Some commonly used annotations for bean definition include @Component, @Service, @Repository, and @Controller.

Java Configuration: Instead of XML, you can use Java configuration classes to define beans. By using the @Configuration annotation on a class, you can define beans and their dependencies using methods annotated with @Bean.

Component Scanning: Spring can automatically discover and register beans by scanning the classpath. You can use annotations like @Component, @Service, @Repository, and @Controller on your classes, and Spring will detect and register them as beans.

Factory Methods: You can define beans using factory methods within a configuration class. By annotating a method with @Bean, you can specify the logic to create and configure the bean instance.

BeanPostProcessor: Spring provides the BeanPostProcessor interface, which allows you to define custom logic for post-processing bean instances. Implementing this interface gives you control over the bean initialization process.

## 8. What is default bean name for @Component and @Bean?
The default bean names for `@Component` and `@Bean` annotations in Spring are as follows:

`@Component`: When you annotate a class with `@Component` (or its specializations like @Service, @Repository, @Controller, etc.), the default bean name is derived from the class name with the initial lowercase letter. For example, if you have a class named MyComponent, the default bean name will be myComponent.

`@Bean`: When you define a bean using the `@Bean` annotation within a configuration class, the default bean name is the name of the `@Bean` method. For example, if you have a method named myBean annotated with `@Bean`, the default bean name will be myBean.

## 9. What is the difference between @component and @service,@repository?
In Spring, `@Component`, `@Service`, and `@Repository` are three specializations of the `@Component` annotation, and they are used to annotate different types of classes within an application. While they are similar in nature, there are some subtle differences:

`@Component`: The `@Component` annotation is a generic stereotype annotation used to indicate that a class is a Spring-managed component. It is the most generic form and can be used for any class that you want to be managed as a Spring bean. It is a good choice for general-purpose classes that do not fall into more specific categories.

`@Service`: The `@Service` annotation is a specialization of `@Component` and is used to indicate that a class represents a service in the business layer of the application. It is typically used to mark classes that provide specific services or perform business logic. It helps to distinguish services from other components in your application.

`@Repository`: The `@Repository` annotation is another specialization of `@Component` and is used to indicate that a class represents a repository or a data access component. It is commonly used to annotate classes that interact with databases or other data storage systems. It provides additional exception translation features and is typically used in the persistence layer of the application.

## 10. How many annotaitons we can use to inject the bean?

In Spring, there are several annotations available for dependency injection and accessing Spring-managed beans. Some of the commonly used annotations for bean injection are:

`@Autowired`: This annotation is used to autowire a bean by type. It can be applied to fields, constructors, and methods. If multiple beans of the same type are available, you can use the `@Qualifier` annotation to specify the bean to be injected.

`@Qualifier`: This annotation is used in conjunction with `@Autowired` to specify the specific bean to be injected when multiple beans of the same type are available. It is used to resolve ambiguity when there are multiple beans that match the required type.

`@Resource`: This annotation is used to autowire a bean by name. It can be applied to fields, setters, and methods. It allows you to specify the name of the bean to be injected.

`@Inject`: This annotation is similar to `@Autowired` and is used to autowire beans by type. It is a standard Java annotation from the javax.inject package and provides a way to achieve dependency injection without relying on Spring-specific annotations.

`@Value`: This annotation is used to inject values from external properties files or configuration into bean fields or methods. It can be used to inject simple values, such as strings or numbers, as well as complex objects.

## 11. Tell me the three types to do dependency injection(How can we inject the beans in Spring)? Which way is better and why?
In Spring, there are three primary ways to perform dependency injection:

Constructor Injection: In this approach, dependencies are provided through a class constructor. The dependencies are declared as constructor parameters, and Spring automatically resolves and injects the required beans when creating an instance of the class. Constructor injection promotes immutability and ensures that all required dependencies are satisfied when creating an object.

Setter Injection: Setter injection involves using setter methods to inject dependencies. The dependencies are declared as private fields in the class, and Spring uses setter methods to set the values of these fields. Setter injection provides flexibility, as it allows optional dependencies and supports changing dependencies at runtime.

Field Injection: Field injection involves injecting dependencies directly into the class fields using the @Autowired annotation. The dependencies are declared as private fields in the class, and Spring uses reflection to set the values of these fields. Field injection is convenient and concise, but it can make testing and troubleshooting more challenging.

The choice of which dependency injection approach to use depends on the specific requirements of your application and the complexity of the dependencies. Constructor injection is generally considered the recommended approach as it ensures that all dependencies are satisfied when creating an object, promotes immutability, and makes dependencies explicit. Setter injection and field injection can be useful in certain scenarios, such as optional dependencies or dynamic dependency changes. However, they may introduce more coupling and make the code harder to test and maintain.

## 12. If we have multiple beans for one type, how to set one is primary? and how to let the spring to pick one bean to inject if no primay.
In Spring, when you have multiple beans of the same type and you want to set one bean as the primary bean to be injected, you can use the `@Primary` annotation. The `@Primary` annotation is applied to a specific bean declaration, indicating that it should be the primary bean to be used when autowiring by type.
```java
@Component
@Primary
public class PrimaryBean implements MyInterface {
    // Bean implementation
}
```

If you have multiple beans of the same type and none of them is marked as primary, Spring will throw an exception indicating that there is an ambiguity in selecting the bean for injection. However, you can use the `@Qualifier` annotation along with `@Autowired` to explicitly specify the bean to be injected.
```java
@Component
public class BeanA implements MyInterface {
    // Bean implementation
}

@Component
public class BeanB implements MyInterface {
    // Bean implementation
}
@Component
public class MyClass {
    @Autowired
    @Qualifier("beanA")
    private MyInterface myBean;
    
    // Rest of the class
}
```

## 13. What is the difference between BeanFactory and ApplicationContext in Spring?

In Spring, both `BeanFactory` and `ApplicationContext` are interfaces that provide mechanisms for managing and accessing beans. However, there are some differences between them:

`Initialization`: `BeanFactory` is a basic container that provides the fundamental features of the Spring IoC (Inversion of Control) container. It lazily initializes beans when requested. On the other hand, `ApplicationContext` is an advanced container that extends the `BeanFactory` interface and provides additional features such as automatic bean configuration, event publishing, and integration with other Spring modules. The `ApplicationContext` eagerly initializes beans during startup.

`Bean Scopes`: `BeanFactory` supports multiple bean scopes, including singleton, prototype, request, session, etc. It provides flexibility in defining and managing bean scopes. `ApplicationContext` inherits this functionality and adds support for additional scopes such as application and websocket scopes.

`AOP Support`: `ApplicationContext` provides built-in support for aspect-oriented programming (AOP) features, allowing the configuration and usage of aspects such as method interception and declarative transaction management. `BeanFactory` does not provide built-in AOP support.

`Resource Loading`: `ApplicationContext` extends the ResourceLoader interface, which allows it to load resources from different locations, such as the file system, classpath, or URLs. `BeanFactory` does not provide this resource loading capability.

`Internationalization` (i18n) Support: `ApplicationContext` includes built-in support for internationalization and localization, allowing for the resolution of messages based on the specified locale. `BeanFactory` does not provide this i18n support.

In summary, while `BeanFactory` provides the basic functionality for managing beans and their scopes, `ApplicationContext` builds upon `BeanFactory` and adds advanced features such as automatic configuration, AOP support, resource loading, and internationalization. In most applications, it is recommended to use `ApplicationContext` for its richer feature set unless there is a specific need to use `BeanFactory` for more fine-grained control over bean initialization and scope management.

## 14. What is the Scope of a Bean? and list the examples for each scope.
The scope of a bean in Spring defines the lifecycle and visibility of the bean instance. It determines how and when a new instance of the bean is created and how it is shared among different components that depend on it. Spring provides several built-in bean scopes, each serving a specific purpose. Here are the commonly used scopes with examples:

Singleton: Only one instance of the bean is created and shared across the entire application context.
Example: Singleton beans are suitable for stateless components or utility classes that can be safely shared.

Prototype: A new instance of the bean is created each time it is requested.
Example: Prototype beans are useful for stateful components or when you want a new instance every time.

Request: A new instance of the bean is created for each HTTP request.
Example: Request-scoped beans are used in web applications to handle request-specific data.

Session: A new instance of the bean is created for each user session.
Example: Session-scoped beans are used in web applications to store user-specific data throughout their session.

Global Session: Similar to the session scope, but used in a Portlet context.
Example: Global session-scoped beans are used in Portlet-based web applications.

Application: A single instance of the bean is created for the entire lifecycle of the application.
Example: Application-scoped beans are used to hold global state or configuration data.

WebSocket: A new instance of the bean is created for each WebSocket connection.
Example: WebSocket-scoped beans are used in WebSocket-based applications.

## 15. Configure a bean using xml. If bean has parameters/dependencies, how can we configure the bean? (you can google the tutorial how to configure beans in xml, and feel free to ask me any quesitons if you don't understand. it is a little bit old, I am not sure if I need to exaplain it in class)
In XML configuration, you can define beans and their dependencies using the `<bean>` element. If a bean has parameters or dependencies, you can provide them using various attributes and child elements. Here's an example of configuring a bean with parameters/dependencies in XML:
```xml
<bean id="myBean" class="com.example.MyBean">
    <constructor-arg value="parameterValue" />
    <property name="dependencyBean" ref="dependencyBean" />
</bean>

<bean id="dependencyBean" class="com.example.DependencyBean">
    <!-- Dependency bean configuration -->
</bean>
```

In the above example:

`<bean>` element is used to define the `myBean `bean of the class `com.example.MyBean`.
The `id` attribute specifies the bean's unique identifier.
The `class` attribute specifies the fully qualified class name of the bean.
`<constructor-arg>` element is used to provide constructor arguments to the bean. Here, the value `"parameterValue"` is passed as a constructor argument.
<property> element is used to inject dependencies into the bean. Here, the `dependencyBean` property of myBean is set with the reference to the `dependencyBean` bean using the ref attribute.

# hw44 spring mvc

## 1. List all of the annotations you learned from class and homework to annotaitons.md
check annotations.md

## 2. What is MVC pattern?
`MVC (Model-View-Controller)` is a software design pattern commonly used in web development to separate the application logic into three interconnected components: the Model, the View, and the Controller. The MVC pattern promotes a modular and organized approach to building applications.

Here's an overview of each component in the MVC pattern:

`Model`: The Model represents the data and business logic of the application. It encapsulates the data and provides methods to manipulate and access that data. In a web application, the Model typically interacts with the database or other data sources.

`View`: The View represents the user interface of the application. It displays the data to the user and handles user interactions. The View is responsible for presenting the information from the Model in a visually appealing and understandable way.

`Controller`: The Controller acts as an intermediary between the Model and the View. It receives user input from the View, processes it, and updates the Model or selects the appropriate View to display. The Controller contains the application logic and coordinates the interactions between the Model and the View.

## 3. What is Front-Controller?
In the Spring framework, the `Front-Controller` pattern is implemented through the Spring MVC (Model-View-Controller) module. The `Front-Controller` in Spring MVC is represented by the `DispatcherServlet` class, which acts as the central entry point for handling incoming requests and managing the overall flow of the application.

When a request is received by the Spring MVC application, it is first intercepted by the `DispatcherServlet`. The `DispatcherServlet` is responsible for dispatching the request to the appropriate controller based on the requested URL. It coordinates the entire request processing cycle, including pre-processing, request handling, and post-processing.

## 4. What is DispatcherServlet? please decribe how it works.
`Configuration`: In the Spring configuration file (usually web.xml or using Java-based configuration), the DispatcherServlet is defined and mapped to a specific URL pattern. This mapping ensures that all requests that match the specified pattern are intercepted by the DispatcherServlet.

`Request handling`: When a request is received, the DispatcherServlet analyzes the request URL and consults the configured mappings to determine the appropriate controller to handle the request. The controller is responsible for processing the request, executing business logic, and preparing the response data.

`Model-View-Controller`: Spring MVC follows the MVC pattern, where the model represents the data, the view represents the presentation logic, and the controller handles the request and coordinates the flow. The DispatcherServlet interacts with the controllers, views, and other components to fulfill the request and generate the response.

`Handler mappings`: The DispatcherServlet uses handler mappings to determine which controller should handle a specific request. Handler mappings can be configured using various strategies, such as annotations (@RequestMapping), XML-based configuration, or implementing custom HandlerMapping interfaces.

`View resolution`: Once the request has been processed by the controller, the DispatcherServlet is responsible for resolving the appropriate view based on the view name returned by the controller. The view determines how the response data is rendered and presented to the client.

## 5. What is JSP and What is ModelAndView？(please google to have a basic knowlege)
JSP (JavaServer Pages) and ModelAndView are both components used in web development with the Spring framework.

JSP:
JSP is a technology that allows the creation of dynamic web pages using Java. It combines HTML markup with embedded Java code, which is executed on the server-side. JSP pages are compiled into servlets by the web container at runtime. JSP provides a way to separate the presentation layer (HTML) from the business logic (Java code) in a web application. JSP pages can include Java code, JSP tags, and expressions to generate dynamic content.

ModelAndView:
ModelAndView is a class provided by the Spring MVC framework to handle the response data and view in a Spring MVC application. It represents a logical view and its associated model data. It combines both the model data (Java objects) and the view name into a single object. The model data can be any Java object or a collection of objects that need to be passed to the view for rendering. The view name specifies the template or JSP page that will be used to render the response.

The ModelAndView class provides methods to set and retrieve the model data as well as the view name. It allows you to add attributes to the model, set the view name, and perform other operations related to the response data and view. The ModelAndView object is typically returned from a controller method to indicate the view and data to be rendered.

## 6. Could you please google any other servlets(理解多少是多少，不要花太多时间，知道servlet的名字就⾏。)
`HttpServlet` is a class provided by the Java Servlet API that serves as a base class for creating servlets that handle HTTP requests and generate HTTP responses. It is an abstract class that you can extend to create your own servlets.

`GenericServlet`: It is an abstract class that provides a generic implementation of a servlet. It is typically used as a base class for servlets that do not handle HTTP-specific requests but can handle other protocols, such as FTP or SMTP.

`AsyncServlet`: It is a subclass of `HttpServlet` that supports asynchronous request processing. It allows servlets to handle long-running tasks in a non-blocking manner, improving the scalability and responsiveness of the application.

`SingleThreadModel`: It is an interface that can be implemented by a servlet to indicate that it can handle only one request at a time. However, this interface is deprecated and no longer recommended for use.

`JspServlet`: It is a servlet that handles requests for JavaServer Pages (JSP). It compiles JSP files into servlets and dynamically executes them to generate dynamic HTML content.

`DefaultServlet`: It is a servlet provided by the servlet container that serves static resources (e.g., HTML, CSS, JavaScript files) from the web application's file system. It is typically used to handle requests for static content in web applications.

## 7. How many web server do you know? (Tomcat, Jetty, Jboss)
`Apache Tomcat`: It is a popular and widely used open-source web server and servlet container. It is lightweight, easy to configure, and is compatible with the Java Servlet and JavaServer Pages (JSP) specifications.

`Jetty`: It is another lightweight and highly scalable open-source web server and servlet container. Jetty is known for its excellent performance and low resource consumption. It is often used in embedded systems and other environments where a small footprint is desired.

`JBoss Application Server (WildFly)`: It is a full-featured Java EE application server that includes a web server component. JBoss/WildFly provides a complete runtime environment for Java EE applications, offering support for various Java EE technologies and specifications.

`Apache HTTP Server`: Although not specifically designed for Java applications, Apache HTTP Server is a widely used open-source web server that supports multiple platforms and is often used in combination with Java web applications. It can be used with a Java servlet container like Tomcat or Jetty through the Apache Tomcat Connector module.

`GlassFish`: It is an open-source Java EE application server that includes a built-in web server component. GlassFish provides support for the full Java EE stack and is known for its ease of use and administration.

`IBM WebSphere Application Server`: It is a commercial Java EE application server provided by IBM. WebSphere offers a robust and scalable platform for running Java EE applications and provides various features and tools for enterprise-level application development and deployment.

## 8. clone this repo, and run it in you local.
a. https://github.com/TAIsRich/springmvc5-demo
b. Notice that you need to configure the Tomcat by yourself. tutorial in
the slides.
c. find out the APIs in controlelr and call some APIs, In slides, I also list
some API.
d. remeber to create a database for this project
e. all details in the slides.




