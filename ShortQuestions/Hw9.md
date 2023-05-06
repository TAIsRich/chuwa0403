# Homework 9 Part 1
## 1.

## 2. what is the @configuration and @bean?
@configuration indicates that the class declares one or more @Bean methods and may be processed by the Spring container to generate bean definitions and service requests
for beans at runtime. (a class level annotation)

@bean indicates that a method returns a bean to be managed by Spring context

## 3. How do you handle the exception in Spring?

1. create error/exception details class, use ```@ResponseStatus(value = HttpStatus.NOT_FOUND)```;
2. create global exception handler class, annotate the class with @ControllerAdvice and mark the exception handler method with 
@ExceptionHandler(ResourceNotFoundException.class).

## 4. How do you do the validations in Spring? And list some validation annotaitons you know.
Validation is used to validate the request body.

1. Add validation rule to payload properties; e.g. ```@NotEmpty, @Size(min = 10, message = "at least 2")```
2. Add @Valid to the Controller methods parameters; e.g. ```public ResponseEntity<> post(@Valid @RequestParameters PostDto postDto)```

Customize validation, same with exception handling. Add ```@ExceptionHandler(MethodArgumentNotValidException.class)``` to handler methods and add ```@ControllerAdvice``` to the class
```
@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(MethodArgumentNotValidException.class)
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
                                                                 HttpHeaders headers,
                                                                 HttpStatus status,
                                                                 WebRequest request) {
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
## 5. What is the actuator?
An actuator is a manufacturing term that refers to a mechanical device for moving or controlling something. Actuators can generate a large amount of motion from a small change.

Use /acuator/health to check the health of application.

# Part 2
## 1. 
## 2. What is Spring and Springboot? What is the benfits of using Srpingboot?
* Spring: Spring is an open-source lightweight framework used to develop enterprise. The spring framework can be considered as a collection of sub-frameworks such as Spring-AOP, Spring ORM, Spring Web MVC.
* Spring Boot: Spring boot is built on top of conventional spring framework. It provides all features of spring and is easier to use than Spring. Spring boot is a microserviced based framework. Everything in spring boot is auto-figured.

Springboot allows: faster development by eliminating boilerplate code required for setting up spring-based application;
easier configuration: Spring Boot provides a number of sensible defaults and auto-configuration options. 
integration with other technologies: such as database, message queue.
embedded server: availability to run codes locally without having to install a separate server. Such as Tomcat, Jetty.

## 3. What is IOC and What is DI?
IOC is inverse of control. Instead of instantiating the objects by developers using new statements, the spring framework will generate into the application at runtime for developers. This approach helps to decouple the application code from its dependencies. 

DI is dependency injection. It is a implementation of IOC. In DI, an object's dependencies are injected into it from outside, usually by a framework or container. There are several ways to implement DI, like constructor injection, setter injection and method injection.

## 4. What is @CompnonentScan?
@ComponentScan enbales the component scanning in a Spring application. It is a way for Spring automatically detect and register beans within the application context. Spring scans the specified package and all its sub-packages for classes that are annotated with the stereotype annotations such as @Component, @Service, @Repository, @Controller, and so on. Any class that is annotated with one of these annotations is automatically registered with the Spring application context as a bean.

## 5. How to define which package spring need to scan in xml and annotaiton?
* xml: ```<context:component-scan base-package="package name" use-default-filters="false"></context:component-scan>```. Can use include-filter he exclude filter inside ```<context:include-filter type="" expression=""></context:include-filter>```. If using include-filter, the use-default-filters should be set fault.
* annotation: @ComponentScan("package name") 

## 6. What is  @SpringbootApplication?
@SpringBootApplication is a combination of three annotations - @Configuration, @EnableAutoConfiguration, and @ComponentScan.

@Configuration marks the class as a source of bean definitions for the application context. This means that any beans defined in this class or any methods annotated with @Bean will be registered with the Spring application context.

@EnableAutoConfiguration enables Spring Boot's auto-configuration mechanism, which automatically configures the application based on the dependencies on the classpath. This allows developers to focus on writing business logic, while Spring Boot takes care of the infrastructure configuration.

@ComponentScan tells Spring to scan the current package and all its sub-packages for components such as controllers, services, and repositories, and register them with the Spring application context.

When @SpringBootApplication is used, it replaces the need for developers to manually configure the application context, and provides a default set of configurations and conventions for building a Spring Boot application.

## 7. How many ways wo can define a bean?
Using annotations:
* class level: @Component, @Servie, @Repository, @Controller
* method level: @Bean cooperate with @Configurable

Using xml;Beans can be defined in an XML configuration file using the bean element. The bean element contains information about the class, scope, and properties of the bean.

## 8. What is default bean name for  @Component and  @Bean?
The camel case of the class name or method name with the first letter small case.

## 9. What is the difference between  @component and  @service,@repository?
No funcitonal difference. @Component includes @service,@repository. Using the appropriate stereotype annotation for a given class can make the code more self-explanatory and easier to understand. 

## 10. How many annotaitons we can use to inject the bean?
3

* @autowired: a spring type Spring-specific annotation. This annotation is used to inject beans by type. Spring will automatically search for a bean of the same type as the annotated field or parameter and inject it.
* @Resource: a standard Java annotation. It can be used to inject beans by name or by type, and can be used with the name attribute to specify the name of the bean to inject.
* @Inject: This annotation is a standard Java annotation that is similar to @Autowired. It can be used to inject beans by type,

## 11. Tell me the three types to do dependency injection(How can we inject the beans in Spring)? Which way is better and why?
By constructor, by setter, by field.

Constructor injection makes dependencies explicit: When using constructor injection, the required dependencies are explicitly listed as constructor parameters. This makes the dependencies clear and easy to understand, and also makes it harder to accidentally omit a required dependency.

Constructor injection ensures that all dependencies are available: With constructor injection, all required dependencies must be passed as parameters to the constructor. This means that the object cannot be instantiated without all of its dependencies being available, preventing runtime errors due to missing dependencies.

Constructor injection makes testing easier: With constructor injection, it's easy to provide mock or stub dependencies during testing by passing them to the constructor. This allows for more comprehensive testing of the object's behavior and also helps to isolate the object being tested from its dependencies.

Constructor injection is more resilient to changes: With constructor injection, adding or removing dependencies simply requires changing the constructor parameters and any code that calls the constructor. This makes it easier to refactor the code without affecting its behavior or requiring extensive modifications.


## 12. If we have multiple beans for one type, how to set one is primary? and how to let the spring to pick one bean to inject if no primay.
Use @Primary (on the bean class)
Use @Qualifier("bean id"). (on the bean)

## 13. What is the difference between BeanFactory and ApplicationContext in Spring?
* Beanfactory use lazy initialization while ApplicarionContext use eager initialization.
* BeanFactory only supports XML configuration; while ApplicationContext also supports annotation based configuration.
* BeanFactory is more lightweight and extensible, allowing for more customization and flexibility in creating container instances. ApplicationContext provides more out-of-the-box features and functionality, such as internationalization support, event handling, and easier integration with other Spring components.
* ApplicationContext provides additional functionality, such as support for message sources, AOP, and integration with various frameworks and technologies, while BeanFactory provides the basic functionality for managing beans.
## 14. What is the Scope of a Bean?  and list the examples for each scope.
The scope of the bean defines the life cycle and visibility of the bean within the application context.

* singleton: This scopes the bean definition to a single instance per Spring IoC container (default).
* prototype: This scopes a single bean definition to have any number of object instances.
* request: This scopes a bean definition to an HTTP request. Only valid in the context of a web-aware Spring ApplicationContext.
* session: This scopes a bean definition to an HTTP session. Only valid in the context of a web-aware Spring ApplicationContext.
* global-session: This scopes a bean definition to a global HTTP session. Only valid in the context of a web-aware Spring ApplicationContext.

## 15. Configure a bean using xml. If bean has parameters/dependencies, how can we configure the bean? (you can google the tutorial how to configure beans in xml, and feel free to ask me any quesitons if you don't understand. it is a little bit old, I am not sure if I need to exaplain it in class)
