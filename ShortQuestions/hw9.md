# exception-validation
# 1. List all of the annotations you learned from class and homework to annotaitons.md 
Please check in annotaitons.md

# 2. what is the @configuration and @bean?
In the context of Spring Framework for Java, @Configuration and @Bean are annotations used for defining beans in the application context.
@Configuration is used to indicate that a class is a configuration class that provides bean definitions. This means that any method annotated with @Bean within this class will be treated as a bean definition method.
@Bean is used to declare a bean in the application context. A bean is an object that is instantiated, assembled, and managed by the Spring IoC container. When you annotate a method with @Bean, Spring will execute that method and register the object returned by the method as a bean in the application context.

# 3. How do you handle the exception in Spring? 
- Using @ExceptionHandler: You can annotate a method with @ExceptionHandler to handle a sp ecific exception in a controller or advice class.
- Using @ControllerAdvice: You can use @ControllerAdvice to define a global exception handler for all controllers in the application.
- Using @ResponseStatus: You can annotate an exception class with @ResponseStatus to specify the HTTP status code and reason phrase to return when the exception is thrown.
- Using HandlerExceptionResolver: You can implement the HandlerExceptionResolver interface to define a custom exception handling strategy.

# 4. How do you do the validations in Spring? And list some validation annotaitons you know. 
Perform validations uses the javax.validation API
@NotBlank, @NotNull, @Size, @Min, @Max, @Email

# 5. What is the actuator?
Spring Boot Actuator is a sub-project of Spring Boot that provides production-ready features to help you monitor and manage your application. It includes endpoints that expose information about your application's health, metrics, configuration, and more. Some common endpoints provided by Actuator are:
/actuator/health: Provides information about the application's health.
/actuator/info: Provides custom application information.
/actuator/metrics: Provides metrics about the application's performance.
/actuator/loggers: Allows you to view and configure logging levels for different packages in the application.

# hw43-Spring-Basic
# 1. List all of the annotations you learned from class and homework to annotaitons.md
Please check in annotaitons.md

# 2. What is Spring and Springboot? What is the benfits of using Srpingboot?
Spring is a popular Java framework that provides a comprehensive programming and configuration model for modern Java-based enterprise applications. Spring is based on the principle of dependency injection and inversion of control, which makes it easy to develop scalable, modular, and testable applications.
Spring Boot is an extension of the Spring framework that provides a simplified and opinionated way to create Spring applications. It includes a set of pre-configured dependencies and auto-configuration that can help you get started quickly and easily.
Some of the benefits of using Spring Boot are:
- Simplified configuration: Spring Boot reduces the amount of boilerplate code required to configure and set up a Spring application. It provides a set of sensible defaults and auto-configurations that help you get started quickly.
- Faster development: With Spring Boot, you can develop and deploy applications faster, as it includes a number of useful features out-of-the-box, such as embedded servers, database access, security, and more.
- Increased productivity: Spring Boot makes it easier to build and deploy microservices and other cloud-native applications. It includes features such as health checks, metrics, and tracing that help you monitor and manage your applications more effectively.
- Community support: Spring Boot has a large and active community of developers who contribute to the project and provide support through forums, blogs, and other resources.

# 3. What is IOC and What is DI? 
IoC is a design pattern that is used to invert the flow of control in an application. In traditional programming, the application is responsible for managing its dependencies and creating objects when they are needed. With IoC, the responsibility for managing dependencies is moved outside of the application and into a container or framework. The container is responsible for creating and managing objects, and it injects these objects into the application as needed.
DI is a specific implementation of IoC. It is a design pattern that is used to inject the dependencies of an object into that object, rather than requiring the object to create its dependencies. With DI, an object declares its dependencies, and these dependencies are provided by a container or framework at runtime. This makes the object more modular and easier to test, as it is not responsible for creating its own dependencies.

# 4. What is @CompnonentScan? 
@ComponentScan is an annotation in Spring Framework that is used to specify the packages to be scanned for components, services, and other Spring-managed beans. It is often used in conjunction with other annotations, such as @Component, @Service, @Controller, and @Repository, to automatically discover and register Spring-managed beans in the application context.

# 5. How to define which package spring need to scan in xml and annotaiton?
In Spring Framework, you can specify which packages to scan for components and other Spring-managed beans using both XML configuration and annotations.

# 6. What is @SpringbootApplication?
@SpringBootApplication is an annotation in Spring Boot that combines several other annotations to simplify the configuration of Spring Boot applications.

# 7. How many ways wo can define a bean?
- Using XML configuration
- Using Java configuration
- Using component scanning
- Using factory methods

# 8. What is default bean name for @Component and @Bean?
In Spring Framework, the default bean name for a component annotated with @Component, @Service, @Controller, or @Repository is the uncapitalized non-qualified class name.

# 9. What is the difference between @component and @service,@repository? 
@Component, @Service, and @Repository are all annotations in Spring Framework that are used to mark a class as a Spring-managed component. Although they are similar in nature, they have different intended use cases.

# 10. How many annotaitons we can use to inject the bean? 
@Autowired: This annotation can be used to inject a bean by type. If multiple beans of the same type are available in the application context, the @Autowired annotation can be used with the @Qualifier annotation to specify which bean to inject.

@Resource: This annotation can be used to inject a bean by name or by type. If the name attribute is specified, Spring will attempt to find a bean with a matching name in the application context. If the name attribute is not specified, Spring will attempt to find a bean of the same type in the application context.

@Inject: This annotation is similar to @Autowired and can be used to inject a bean by type. However, unlike @Autowired, @Inject is part of the Java Dependency Injection (DI) standard and can be used with other DI frameworks besides Spring.

@Value: This annotation can be used to inject a value from a properties file, system property, or environment variable into a bean.

# 11. Tell me the three types to do dependency injection(How can we inject the beans in Spring)? Which way is better and why? 
- Constructor Injection: In this type of DI, dependencies are injected through a class constructor. The constructor parameters specify the dependencies required by the class.
- Setter Injection: In this type of DI, dependencies are injected through setter methods. The setter methods are annotated with @Autowired or other bean injection annotations.
- Field Injection: In this type of DI, dependencies are injected directly into class fields. The fields are annotated with @Autowired or other bean injection annotations.

# 12. If we have multiple beans for one type, how to set one is primary? and how to let the spring to pick one bean to inject if no primay. 
In Spring Framework, you can use the @Primary annotation to specify a primary bean for a given type. When multiple beans of the same type are available in the application context, the primary bean will be preferred for injection.

# 13. What is the difference between BeanFactory and ApplicationContext in Spring? 
In Spring Framework, both BeanFactory and ApplicationContext are interfaces used to manage beans and provide dependency injection (DI). However, there are some important differences between the two.

# 14. What is the Scope of a Bean? and list the examples for each scope. 
In Spring Framework, the scope of a bean determines how long the bean will live and how many instances of the bean will be created. Spring provides several built-in bean scopes that you can use to manage the lifecycle of your beans.

# 15. Configure a bean using xml. If bean has parameters/dependencies, how can we configure the bean? (you can google the tutorial how to configure beans in xml, and feel free to ask me any quesitons if you don't understand. it is a little bit old, I am not sure if I need to exaplain it in class) 
To configure a bean in XML, you first need to create a bean definition in the Spring application context XML file.

# Spring-MVC
# 1. List all of the annotations you learned from class and homework to annotaitons.md
# 2. What is MVC pattern?
Model: This component represents the data and the business logic of the application. It encapsulates the data and provides methods to manipulate it.

View: This component represents the user interface of the application. It displays the data to the user and provides a way for the user to interact with the application.

Controller: This component acts as an intermediary between the Model and the View. It receives input from the user, updates the Model accordingly, and then updates the View to reflect the changes.

# 3. What is Front-Controller?
Front-Controller is a design pattern used in web applications to provide a centralized point of control for handling requests from users. In this pattern, a single controller component receives all requests from the user and then delegates to other components to handle the request and generate a response.
# 4. What is DispatcherServlet? please decribe how it works.
In Spring MVC, DispatcherServlet is a key component that serves as the Front-Controller for handling requests from users. The DispatcherServlet is responsible for receiving HTTP requests from the user, delegating the requests to the appropriate controller, and returning an HTTP response to the user.
# 5. What is JSP and What is ModelAndView?(please google to have a basic knowlege)
JSP stands for JavaServer Pages, and it is a technology used to create dynamic web pages in Java. JSP pages can contain both HTML and Java code, which is executed on the server and generates HTML that is sent to the client's browser. In Spring MVC, JSP is one of the view technologies that can be used to generate HTML pages.
# 6. Could you please google any other servlets(理解多少是多少，不要花太多时间， 知道servlet的名字就行。)
HttpServlet: This is a base class for HTTP-specific servlets, which handles HTTP requests and responses. It provides methods for handling GET, POST, PUT, DELETE, and other HTTP methods.

GenericServlet: This is a generic servlet class that provides basic functionality for all servlets. It provides methods for initializing, handling requests, and destroying the servlet.

SingleThreadModel: This is an interface that can be implemented by servlets to indicate that only one thread should be allowed to execute the service() method at a time. This interface is deprecated in the Servlet 4.0 specification.
# 7. How many web server do you know? (Tomcat, Jetty, Jboss)
Apache Tomcat: This is a widely-used open-source web server and servlet container that is often used in production environments.

Jetty: This is a lightweight web server and servlet container that is designed to be fast and easy to use. It is often used in development and testing environments.

JBoss/WildFly: This is a popular open-source application server that includes a web server and supports many different Java technologies, such as EJBs and JMS.

GlassFish: This is an open-source application server that is designed to be easy to use and deploy. It includes a web server and supports many different Java technologies.

IBM WebSphere: This is a commercial application server that is designed to be highly scalable and reliable. It includes a web server and supports many different Java technologies.