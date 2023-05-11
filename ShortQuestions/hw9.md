# Homework 9 
## hw 42 Exception validation
### 1 Annotaitions update
see annotation [annotations](/ShortQuestions/annotations.md)

### 2 What is @configuration and @bean
`@Configuration` is used to define a class as a configuration class for Spring. Configuration classes are used to define beans and their dependencies.
`@Bean` is used to define a method as a bean definiton method within a configuration class. Bean definition methods return an object that will be manged by the Spring container. 
### 3 How to handle the exception in Spring
In Spring, we can create global exception handler and define custom exception handler.
Use `@ControllerAdvice` for a class to define global exception handler. And use `@ExceptionHandler` to difine one or more methods to handle specific types of exceptions and send the custome responses to the client. To achieve gloabl exception handle, we could extends the excpetion class to the `ResponseEntityExceptionHandler`. This would provide a centralized location for handling exceptions in application.
### 4 How to do the validations in Spring? list some validation annotations
To do validations, we could add annotations to set the rules to payload. And add `@Valid` to controller methods and service methods to apply the rules.

Annotations:
- `@NotNull`: check whether the value is not null
- `@NotEmpty`: check whether the value is not null or not empty
- `@Size`: check whether the size of the value is within a specified range
- `@Min` `@Max`: check whether the value is greater(less) than or equal to than a specified value
- `@Email`: check whether the value is a valid email address
- `@Pattern`: check whether the value matches a specified regular regression

### 5 What is actuator
An actuator is a manufacturing term that refers to a mechanical device for moving or controlling something. Actuators can generate a large amount of motion from a small change.
### 6 Watch videos
done

## hw 43 Spring Basic
### 1 Annotaitions update
see annotation [annotations](/ShortQuestions/annotations.md)
### 2 
- Spring: pring is an open-source lightweight framework used to develop enterprise. The spring framework can be considered as a collection of sub-frameworks such as Spring-AOP, Spring ORM, Spring Web MVC.
- Spring Boot: oot: Spring boot is built on top of conventional spring framework. It provides all features of spring and is easier to use than Spring. Spring boot is a microserviced based framework.
- Benfits of SpringBoot: Spring Boot provides a number of sensible defaults and auto-configuration options. It could provide faster development by eliminating boilerplate code required for setting up spring-based application and easier configuration.
### 3
- IOC: inverse of control. Instead of instantiating the objects by developers using new statements, the spring framework will generate into the application at runtime for developers. 
- DI: dependency injection. It is a implementation of IOC. In DI, an object's dependencies are injected into it from outside, usually by a framework or container.
### 4
`@ComponentScan` enbales the component scanning in a Spring application. It is a way for Spring automatically detect and register beans within the application context. 
### 5 How to define which package Spring need to scan
- in xml:
`<context:component-scan base-package="package name" use-default-filters="false"></context:component-scan>`
- annotation: `@ComponentScan("package name")`

### 6 @SpringbootApplication
It is a combination of three annotations: @Configuration, @EnableAutoConfiguration, and @ComponentScan. @Configuration marks the class as a source of bean definitions for the application context. @EnableAutoConfiguration enables Spring Boot's auto-configuration mechanism, which automatically configures the application based on the dependencies on the classpath. @ComponentScan tells Spring to scan the current package and all its sub-packages for components such as controllers, services, and repositories, and register them with the Spring application context.

### 7 how to define a bean:
- Use annotation: 
    - class level: @Component, @Servie, @Repository, @Controller
    - method level: @Bean cooperate with @Configurable
- Using xml

### 8 default bean name for @Component and @Bean
camel case of the class name or method name with the first letter small case.

### 9 What is the difference between @component and @service,@repository
No funcitonal difference. @Component includes @service,@repository. Using the appropriate stereotype annotation for a given class can make the code more self-explanatory and easier to understand.

### 10 annotaitons we can use to inject the bean
- @autowired: a spring type Spring-specific annotation. This annotation is used to inject beans by type. Spring will automatically search for a bean of the same type as the annotated field or parameter and inject it.
- @Resource: a standard Java annotation. It can be used to inject beans by name or by type, and can be used with the name attribute to specify the name of the bean to inject.
- @Inject: This annotation is a standard Java annotation that is similar to @Autowired. It can be used to inject beans by type

### 11 three types to do dependency injection(How can we inject the beans in Spring)? Which way is better and why?
By constructor, by setter, by field.

Constructor injection is better. It makes dependencies explicit. It ensures that all dependencies are available. It makes testing easier. It is more resilient to changes.

### 12 If we have multiple beans for one type, how to set one is primary? and how to let the spring to pick one bean to inject if no primay.
- Use @Primary on the bean class
- Use @Qualifier("bean id") on the bean
### 13 What is the difference between BeanFactory and ApplicationContext in Spring
- Beanfactory use lazy initialization while ApplicarionContext use eager initialization.
- BeanFactory only supports XML configuration; while ApplicationContext also supports annotation based configuration.
- BeanFactory is more lightweight and extensible, allowing for more customization and flexibility in creating container instances. ApplicationContext provides more out-of-the-box features and functionality, such as internationalization support, event handling, and easier integration with other Spring components.
- ApplicationContext provides additional functionality, such as support for message sources, AOP, and integration with various frameworks and technologies, while BeanFactory provides the basic functionality for managing beans.

### 14 the Scope of a Bean
The scope of the bean defines the life cycle and visibility of the bean within the application context: 
- singleton: This scopes the bean definition to a single instance per Spring IoC container (default).
- prototype: This scopes a single bean definition to have any number of object instances.

### 15 Configure a bean using xml. If bean has parameters/dependencies, how can we configure the bean? 
```
<bean id="myBean" class="com.example.MyBean">
    <constructor-arg ref="dependency1"/>
    <constructor-arg ref="dependency2"/>
</bean>

<bean id="dependency1" class="com.example.Dependency1"/>
<bean id="dependency2" class="com.example.Dependency2"/>

```


## hw 44 Spring MVC
### 1 Annotaitions update
see annotation [annotations](/ShortQuestions/annotations.md)
### 2 MVC
Model-View-Controller. - It is a software architecture pattern.
- Model represents the data and business logic.
- View represents the presentation layer of the application.
- Controller: controller works as the intermediary between the model and the view. It receives input from the user and processes it and manipulate the model. It updates the view with the new data.
### 3 Front-Controller
Front-Controller is a design pattern that handles incoming requests to a web application. It is a centralized controller that receives all requests and dispatches them to the appropriate handler for further processing.

### 4 DispatcherServlet
It is the same with Front-Controller. How it works:
- When a request comes into the application, it is intercepted by the Servlet container and passed to the DispatcherServlet.
- The DispatcherServlet consults its configuration to determine how to handle the request, including the URL patterns and handler methods.
- The DispatcherServlet passes the request to the appropriate handler method, which processes the request and produces a response.
- The response is returned to the DispatcherServlet, which determines how to format and present the response to the client.
- The DispatcherServlet uses a number of Spring components, including HandlerMappings, HandlerAdapters, and ViewResolvers, to facilitate the processing of requests and the generation of responses.

### 5 JSP & ModelAndView
JSP: JavaServer Pages. It is a technology used for developing dynamic web pages in Java. JSP allows developers to embed Java code within HTML pages, enabling the creation of dynamic content that can be generated based on user input, data from a database, or other sources.

ModelAndView is a class in Spring MVC that is used to pass data between the controller and the view in a web application. It represents both the data model and the view that will be rendered to the client.

### 6 Other servlets:
JspServlet: It is a servlet implementation specifically designed for handling JavaServer Pages (JSP). It compiles JSP files into servlets and executes them to generate dynamic content.

The HttpServlet class is a subclass of GenericServlet and provides specific functionality for handling HTTP requests and generating HTTP responses in Java web applications. It is part of the Java Servlet API.

### 7 web server:
Tomcat: Apache Tomcat is a popular web server and servlet container that is commonly used for Java-based web applications. It implements the Java Servlet and JavaServer Pages (JSP) specifications and provides a runtime environment for running Java web applications.


Jetty: Jetty is a lightweight and embeddable web server that is often used for developing and testing web applications. It supports the latest Java Servlet API standards and is known for its simplicity and easy integration with Java applications.

### 8 