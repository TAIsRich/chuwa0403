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


## 7. How many ways wo can define a bean?

## 8. What is default bean name for  @Component and  @Bean?

## 9. What is the difference between  @component and  @service,@repository?

## 10. How many annotaitons we can use to inject the bean?

## 11. Tell me the three types to do dependency injection(How can we inject the beans in Spring)? Which way is better and why?

## 12. If we have multiple beans for one type, how to set one is primary? and how to let the spring to pick one bean to inject if no primay.

## 13. What is the difference between BeanFactory and ApplicationContext in Spring?

## 14. What is the Scope of a Bean?  and list the examples for each scope.

## 15. Configure a bean using xml. If bean has parameters/dependencies, how can we configure the bean? (you can google the tutorial how to configure beans in xml, and feel free to ask me any quesitons if you don't understand. it is a little bit old, I am not sure if I need to exaplain it in class)
