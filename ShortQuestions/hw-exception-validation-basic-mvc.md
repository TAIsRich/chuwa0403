# hw42-exception-validation
## what is the @configuration and @bean?
`@configuration` is used to define a configuration class that contains methods that create and configure beans that will be managed by the Spring container.

`@bean` is responsible for creating and configuring the bean instance, and the name of the method serves as the name of the bean in the Spring container.
## How do you handle the exception in Spring?
- We can use the `@ExceptionHandler` and `@ControllerAdvice` annotations. 

Steps:  
- Create ErrorDetails Class.
- Create GlobalExceptionHandler Class.
- Test using Postman Client.
## How do you do the validations in Spring? And list some validation annotaitons you know.
These are the steps to do the validations in Spring.
- Import dependency.
- Add validation Rule to payload.
- Add @valid to controller to apply the Rule.
- Check it in postman.
Some annotations:
- `@Valid`
- `@NotNull`
- `@NotBlank`
- `@NotEmpty`
- `@Min`
- `@Max`
- `@Size`
- `@Pattern`
## What is the actuator?
In Spring Boot, Actuator is a feature that provides production-ready endpoints for monitoring and managing your application. 
# hw43-Spring-Basic
## What is Spring and Springboot? What is the benfits of using Springboot?
`Spring` is a popular open-source framework for building enterprise-level Java applications. `SpringBoot` is a framework built on top of the Spring framework that simplifies the development and deployment of Spring-based applications. 

SpringBoot simplifies and speeds up the development process for Spring-based applications, allowing developers to focus on building business logic instead of boilerplate code. 
## What is IOC and What is DI?
IOC is a design pattern that describes how objects should be created and how they should interact with each other in a software application.

DI is a pattern that implements IOC. It is a way of providing dependencies to a class, rather than having the class create them itself.
## What is @CompnonentScan?
`@ComponentScan` is a Spring annotation used to specify the packages that should be scanned for Spring-managed components. It is used in Class level.
## How to define which package spring need to scan in xml and annotaiton?
To scan using XML configuration, we can use the `<context:component-scan>` element.

To scan using annotations, you can use the `@ComponentScan` annotation.
## What is @SpringbootApplication?
This is a SpringBoot annotation that is used to annotate the main class of a Spring Boot application.
## How many ways we can define a bean?
Annotations (Class level):
- `@Component`
- `@Service`
- `@Repository`
- `@Controller`
- `@ContollerAdvice`
Annotations (Method level):
- `@Bean` (used with `@Configuration`)
We can also use xml to define a bean
## What is default bean name for @Component and @Bean?
For `@Component`, the default bean name is the uncapitalized and unqualified name of the class.

For `@Bean`, the default bean name is the name of the method that declares the @Bean annotation.
## What is the difference between @component and @service,@repository?
`@Component` is a generic stereotype annotation that can be used to indicate any Spring-managed component, `@Service` and `@Repository` are more specific annotations used to indicate service and repository components.
## How many annotaitons we can use to inject the bean?
- `@Autowired`
- `@Resource`
- `@Inject`
- `@Qualifier`
## Tell me the three types to do dependency injection(How can we inject the beans in Spring)? Which way is better and why?
Three types to do dependency injection:
- Constructor Injection
- Setter Injection
- Field Injection
Constructor should be the best one. Because it's simple and safe.
## If we have multiple beans for one type, how to set one is primary? and how to let the spring to pick one bean to inject if no primay.
We can use the `@Primary` annotation to set a bean as primary one. And if there is no primary, we can use the `@Qualifier` annotation to pick one bean to inject.
## What is the difference between BeanFactory and ApplicationContext in Spring?
`BeanFactory` is a lightweight container that provides basic support for managing and accessing Spring beans, and ApplicationContext is a more feature-rich container that provides additional functionality such as support for internationalization, events, and AOP, as well as integration with other Spring frameworks.
## What is the Scope of a Bean? and list the examples for each scope.
- Singleton: This scopes the bean definition to a single instance per Spring IoC container (default).
- Prototype: This scopes a single bean definition to have any number of object instances.
- Request: This scopes a bean definition to an HTTP request. Only valid in the context of a web-aware Spring ApplicationContext.
- Session: This scopes a bean definition to an HTTP session. Only valid in the context of a web-aware Spring ApplicationContext.
- global-session: This scopes a bean definition to a global HTTP session. Only valid in the context of a web-aware Spring ApplicationContext.

# hw44-Spring-MVC
## What is MVC pattern?
Spring Web MVC is the original web framework built on the Servlet API and has been included inthe Spring Framework from the very beginning
## What is Front-Controller?
The front controller maps the incoming request to a controller. Controllers contain the
business logic of the application. They also handle requests and perform marshalling/
unmarshalling. The function of the controller is to handle a user request. The incoming
request may be handled in different ways like reading form data, processing it in some
way, storing data in a database, or retrieving data from a web service etc. The controller
places the data in the model which, simply put, is a container for the data. The controller
returns the model (containing data) back to the front controller
## What is DispatcherServlet? please decribe how it works.
The DispatcherServlet is the front controller for Spring Web MVC-based web applications. It intercepts incoming HTTP requests, routes them to the appropriate controller, and returns the response to the client. It also manages other components of the Spring Web MVC framework, such as the view resolver and message converter.
## What is JSP and What is ModelAndView？(please google to have a basic knowlege)
`JSP` is a view technology used to create dynamic web pages using Java code and HTML markup. In a Spring MVC application, a JSP page can be used as a view to present the data returned by a controller.

`ModelAndView` is a class in the Spring MVC framework that encapsulates the data to be displayed and the logical view name that will be used to render that data. It is returned by a controller to specify the data that needs to be displayed and the view that should be used to present it.
## Could you please google any other servlets(理解多少是多少，不要花太多时间，知道servlet的名字就⾏。)
- HttpServlet 
- GenericServlet 
- ServletContext 
- HttpSession 
- ServletConfig 
- ServletInputStream 
- ServletOutputStream 
## How many web server do you know? (Tomcat, Jetty, Jboss)
- GlassFish 
- WebLogic 
- WebSphere 