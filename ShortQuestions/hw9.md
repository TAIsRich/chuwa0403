## 1. List all of the annotations you learned from class and homework to annotaitons.md
Please see annotations.md

## 2. what is the @configuration and @bean?
@Configuration is an annotation used in Spring Framework to indicate that a class defines one or more @Bean methods and may be processed by the Spring container to generate bean definitions and service requests for those beans at runtime. In other words, @Configuration is used to mark a class as a source of bean definitions in a Spring application context.

@Bean is an annotation used within a @Configuration class to declare a Spring bean. When you annotate a method with @Bean, Spring will call that method to instantiate a bean, and the object returned by the method will be managed by the Spring container. The method can also have arguments that will be autowired by the container.

## 3. How do you handle the exception in Spring?
Use the @ExceptionHandler annotation to handle exceptions that occur in a Spring MVC controller. When an exception occurs, Spring will look for a method annotated with @ExceptionHandler in the controller that can handle the exception. This method should have a parameter of the exception type that you want to handle.

Use the @ControllerAdvice annotation to define a global exception handler for your Spring MVC application. This annotation is used to handle exceptions across the whole application, rather than handling them in individual controllers. It allows you to define a class that can be used to provide centralized exception handling for all controllers in your application.

## 4. How do you do the validations in Spring? And list some validation annotaitons you know.
1. import dependecy
2. Add validation Rule to payload
3. Add @valid to controller to apply the Rule
@NotNull: Used to ensure that a field is not null.
@NotEmpty: Used to ensure that a field is not empty.
@NotBlank: Used to ensure that a field is not blank (i.e., contains at least one non-whitespace character).
@Size: Used to ensure that a field's length is within a specified range.
@Min: Used to ensure that a numeric field's value is greater than or equal to a specified minimum value.
@Max: Used to ensure that a numeric field's value is less than or equal to a specified maximum value.
@DecimalMin: Used to ensure that a numeric field's value is greater than or equal to a specified minimum value.
@DecimalMax: Used to ensure that a numeric field's value is less than or equal to a specified maximum value.
@Digits: Used to ensure that a numeric field's value has a specified number of digits in total and a specified number of digits after the decimal point.
@Email: Used to ensure that a field contains a valid email address.
@Pattern: Used to ensure that a field matches a specified regular expression.

## 5. What is the actuator?
The Spring Boot Actuator is a set of production-ready features that are designed to help you monitor and manage your Spring Boot application. The Actuator provides a set of RESTful endpoints and JMX beans that can be used to manage and monitor your application at runtime.

# -------

## 1. List all of the annotations you learned from class and homework to annotaitons.md
Please see annotaitions.md

## 2. What is Spring and Springboot? What is the benfits of using Srpingboot?
Spring is a popular open-source framework for building enterprise-level Java applications. It provides a comprehensive programming and configuration model for modern Java-based enterprise applications, with features such as dependency injection, aspect-oriented programming, and integrated transaction management.

Spring Boot is a framework built on top of Spring that makes it easy to create stand-alone, production-grade Spring-based applications that can be deployed with minimal configuration. Spring Boot provides a set of pre-configured and opinionated dependencies that can be easily integrated into your application, allowing you to focus on writing business logic rather than infrastructure code.

## 3. What is IOC and What is DI?
Inversion of Control (IOC) is a principle in software design that refers to the inversion of the traditional control flow between a software component and its dependencies. Instead of a component controlling the instantiation and management of its dependencies, control is inverted and delegated to a container or framework.

Dependency Injection (DI) is a design pattern that implements IOC. It involves passing dependencies to a component rather than having the component create or find its dependencies. By doing so, the component becomes more modular and reusable, and the dependencies can be easily changed or swapped out without affecting the component's behavior.

## 4. What is @CompnonentScan?
@ComponentScan is an annotation in Spring that is used to specify the base package for Spring to scan for components, such as @Controller, @Service, @Repository, and @Component. Spring uses component scanning to automatically detect and instantiate Spring-managed components that are annotated with one of these annotations.

## 5. How to define which package spring need to scan in xml and annotaiton?
1. Using XML
2. Use ComponentScan(basePackages = "xxx") annotations

## 6. What is @SpringbootApplication?
@SpringBootApplication is an annotation in the Spring Boot framework that is used to denote the main class of a Spring Boot application. It is a convenience annotation that combines three other annotations: @Configuration, @EnableAutoConfiguration, and @ComponentScan


## 7. How many ways wo can define a bean?
Class level, Method level, XML

## 8. What is default bean name for @Component and @Bean?
When using the @Component annotation to create a Spring bean, the default bean name is the uncapitalized non-qualified class name. For example, if you have a class MyComponent, the default bean name would be myComponent.

When using the @Bean annotation to create a Spring bean, the default bean name is the name of the method that declares the bean. For example, if you have a method createMyBean annotated with @Bean, the default bean name would be createMyBean

## 9. What is the difference between @component and @service @repository?
The @Component, @Service, and @Repository annotations in Spring are used to declare beans, but they have slightly different use cases and purposes.

@Component is a generic stereotype annotation used to indicate that a class is a Spring-managed component. It can be used to annotate any class that should be managed by Spring, whether it's a controller, a service, a repository, or any other type of component. It does not imply any specific functionality or behavior, and is often used as a catch-all annotation for any Spring-managed component.

@Service is a specialization of the @Component annotation that is used to indicate that a class is a business service. It is typically used to annotate classes that contain business logic or perform other operations on behalf of the application. The @Service annotation serves as a clear marker for developers to indicate that a particular class is a service component.

@Repository is a specialization of the @Component annotation that is used to indicate that a class is a repository component. It is typically used to annotate classes that are responsible for data access and persistence, such as DAOs or database access objects. The @Repository annotation is used to indicate that a particular class is a repository component.

## 10. How many annotaitons we can use to inject the bean?
@Autowired: This annotation can be used to inject a bean automatically by type. It is the most commonly used annotation for bean injection in Spring.

@Qualifier: This annotation can be used in combination with @Autowired to specify which bean to inject when there are multiple beans of the same type.

@Resource: This annotation can also be used to inject a bean automatically, but it allows you to specify the bean name using the name attribute.

@Inject: This annotation is similar to @Autowired, but it is a standard Java annotation that is used in Java EE and other frameworks.

@Value: This annotation can be used to inject values from properties files or other sources.

@Component: This annotation can be used to declare a class as a Spring-managed component, which can then be injected into other components using one of the other injection annotations.

## 11. Tell me the three types to do dependency injection(How can we inject the beans in Spring)? Which way is better and why?
Constructor Injection: In constructor injection, the dependencies are injected through the constructor of the class. The dependencies are passed as parameters to the constructor, and Spring resolves and injects the dependencies at runtime.
Setter Injection: In setter injection, the dependencies are injected through setter methods on the class. The class provides a setter method for each dependency that needs to be injected, and Spring calls these methods at runtime to inject the dependencies.
Field Injection: In field injection, the dependencies are injected directly into class fields using the @Autowired annotation

## 12. If we have multiple beans for one type, how to set one is primary? and how to let the spring to pick one bean to inject if no primay.
In Spring, if you have multiple beans of the same type and you want to specify which one to use by default (i.e., as the primary bean), you can use the @Primary annotation on that bean.

## 13. What is the difference between BeanFactory and ApplicationContext in Spring?
Lazy vs. Eager Loading: BeanFactory is a lightweight container that provides the basic functionality for managing beans, but it uses lazy loading, which means that beans are only instantiated and initialized when they are actually needed. On the other hand, ApplicationContext is a full-featured container that provides all the functionality of BeanFactory, but also supports eager loading of all singleton beans at startup.

Bean Post-Processing: ApplicationContext supports the BeanPostProcessor interface, which allows for custom modifications to be made to bean instances before they are returned to the calling code. BeanFactory does not support this feature.

Internationalization: ApplicationContext provides support for internationalization (i18n) and localization (l10n) by allowing the use of message resource bundles. BeanFactory does not provide this feature.

Integration with Other Spring Features: ApplicationContext provides integration with many other Spring features, such as AOP, JDBC, and Hibernate, while BeanFactory does not provide these integrations.

Caching: ApplicationContext has the ability to cache singleton beans, which can improve performance by avoiding the need to repeatedly create and initialize bean instances. BeanFactory does not provide this feature.

## 14. What is the Scope of a Bean? and list the examples for each scope.
Singleton: This scope creates a single instance of the bean in the container and shares it across all requests for that bean. This is the default scope for Spring beans. Examples of singleton beans include configuration objects and service objects that are expensive to create.

Prototype: This scope creates a new instance of the bean each time it is requested from the container. This means that each request for the bean will get a unique instance. Examples of prototype beans include stateful session beans and UI components.

## 15. Configure a bean using xml. If bean has parameters/dependencies, how can we configure the bean? (you can google the tutorial how to configure beans in xml, and feel free to ask me any quesitons if you don't understand. it is a little bit old, I am not sure if I need to exaplain it in class) configure them using constructor-arg or property elements in the XML configuration.
onfigure them using constructor-arg or property elements in the XML configuration.
```
<bean id="myBean" class="com.example.MyBean">
    <constructor-arg type="java.lang.String" value="Hello World!"/>
</bean>
```

# ---------
## 1. List all of the annotations you learned from class and homework to annotaitons.md
Please see annotations.md

## 2. What is MVC pattern?
Model: The model represents the data and business logic of the application. It encapsulates the data and provides methods for accessing and manipulating it. It also notifies the view and the controller when the data changes.

View: The view represents the user interface of the application. It displays the data from the model to the user and provides a way for the user to interact with the data. The view also notifies the controller when the user performs an action.

Controller: The controller acts as an intermediary between the model and the view. It handles user input from the view, updates the model accordingly, and then updates the view to reflect the changes in the model. It also provides a way for the view to request data from the model.

## 3. What is Front-Controller?
In Spring MVC, the Front Controller pattern is implemented through the DispatcherServlet, which acts as the central request handler for incoming requests. 

## 4. What is DispatcherServlet? please decribe how it works.
In Spring MVC, the DispatcherServlet is a central servlet that handles incoming HTTP requests and dispatches them to the appropriate controller and view. The DispatcherServlet is the front controller of the Spring MVC framework, and it is responsible for managing the entire request-response cycle.

## 5. What is JSP and What is ModelAndView？(please google to have a basic knowlege)
JSP stands for JavaServer Pages, which is a technology used to create dynamic web pages in Java. JSP allows developers to embed Java code in HTML pages, making it easy to generate dynamic content based on user input or other data sources. JSP pages are compiled into servlets and executed on the server-side, generating HTML, CSS, and JavaScript that can be sent to the client's browser.

ModelAndView is a class in Spring MVC that represents the result of processing an HTTP request. It contains a model object, which is a map of key-value pairs that can be used to store data for the view to render. It also contains a view name, which is a string that identifies the view to be rendered. The ModelAndView class is commonly used in Spring MVC to return a response from a controller method.

## 6 Could you please google any other servlets(理解多少是多少，不要花太多时间， 知道servlet的名字就⾏。)
HttpServlet: This is the base class for all servlets that handle HTTP requests and responses.

GenericServlet: This is the base class for all servlets that handle any type of protocol, not just HTTP.

RequestDispatcher: This servlet is used to forward a request from one servlet to another servlet or JSP page.

Filter: This servlet is used to intercept requests and responses before they are processed by a servlet, allowing developers to modify or reject them as necessary.

Cookie: This servlet is used to manage cookies, which are small pieces of data stored on the client-side that can be used to store user preferences and session data.

Session: This servlet is used to manage user sessions, which allow developers to store user-specific data across multiple requests.

ServletContext: This servlet is used to manage the application context, which contains global information about the web application.

## 7. How many web server do you know?
Apache HTTP Server: Apache is a popular open-source web server that is widely used for serving static content and dynamic content via CGI, FastCGI, and other mechanisms.

Nginx: Nginx is a lightweight and fast web server that is commonly used as a reverse proxy, load balancer, and HTTP cache.

Microsoft IIS: IIS is a web server developed by Microsoft for use with Windows operating systems. It is commonly used with ASP.NET and other Microsoft web technologies.

Apache Tomcat: Tomcat is a popular open-source web server and servlet container that is commonly used for serving Java-based web applications.

Jetty: Jetty is a lightweight and scalable web server and servlet container that is commonly used for embedding in other applications.

Lighttpd: Lighttpd is a lightweight and fast web server that is commonly used for serving static content and as a reverse proxy.

Caddy: Caddy is a modern and easy-to-use web server that is designed to be fast, secure, and reliable.