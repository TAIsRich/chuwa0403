# HW Exception Validation
## 1. List the annotations you learned from class and homework to annotations.md
See `ShortQuestions/annotations`
## 2. what is the @configuration and @bean?
These two annotations can be used together to declare a bean  
`@Configuration` annotation is to indicate that a class is a configuration class  
`@Bean` is to declare a bean in the Spring application context
## 3. How do you handle the exception in Spring?
We can use `@ExceptionHandler`. This annotation is used to handle exception. If it is used on a method in a controller class, means that it will handle the exceptions thrown within this controller only. If we specify some exception inside the annotation, means that this method will only handle this kind of exception thrown within this controller.  
`@ExceptionHandler` can be used with `@ControllerAdvice`, so that the exception handling can be applied globally or to a set of controllers covered by `@ControllerAdvice`
## 4. How do you do the validations in Spring? And list some validation annotations you know.
Add validation annotations to model classes. We can add the following annotations to the fields: 
`@NotNull`, `@NotEmpty`, `@Size`, `@Pattern`, `@Min`, `@Max`, etc.  
We can use the `@Validated` annotation to enable validation by applying `@Validated` at the class level or method level to enable method-level validation in the Spring bean. 
## 5. What is the actuator?
It is the monitoring module for Spring Boot application   
It provides build-in metrics for runtime status like memory, CPU, thread...
It can be customized to have more metrics 

---
# HW Spring Basic
## 1. List all of the annotations you learned from class and homework to annotaitons.md
See `ShortQuestions/annotations`
## 2. What is Spring and Springboot? What is the benefits of using Springboot?
Spring is a popular Java framework that is famous for its techniques IOC/DI and AOP    

Spring Boot is built on the top of the Spring Framework. It provides an easier and faster way to set up, configure, and run both simple and web-based applications.
Spring Boot is the combination of Spring Framework and Embedded Servers.
In Spring Boot, there is no requirement for XML configuration. (It uses convention over configuration software design paradigm) that means it reduces the effort of the developer.  

SpringBoot is prefered over Spring because tt’s easier to set up the environment. Cause it offers a convention of configuration. If we don’t do the configuration, it will follow the default one which is commonly used in the industry.  

Spring Boot Feature?
- Auto-Configuration
  - Convention over configuration 
  - If we don't config it, it follows the default configuration which is commonly used in the industry.
- Embedded Server 
  - The web starter comes with Tomcat
- Self-Executable Jar 
  - Build a jar file with everything in it. 
  - Can be executed using java -jar to run the jar file. 
  - The jar file could be easily used in Docker image files.
- Starter 
  - Pre-defined dependencies which can provide a specific function without conflicts and compatibility issues.
  - web starter, security starter, jpa starter, cloud starter etc...
  - It simplifies the POM file.
- Actuator
  - Monitoring module for Spring Boot application
  - Provide build-in metrics for runtime status like memory, CPU, thread...
  - Can be customized to have more metrics 


## 3. What is IOC and What is DI?
IOC: Inversion of control that helps to centrally organize the classes, maintains the life cycle of the objects, and makes the code loosely coupled.  
DI: Dependency injection is a technique that makes a class independent of its dependencies. It provides objects that an object needs without having it construct them itself.
## 4. What is @ComponentScan?
`@ComponentScan` is an annotation provided by the Spring framework that is used to specify the packages that should be scanned for Spring-managed components, such as `@Component`, `@Service`, `@Repository`, and `@Controller`.

When using `@ComponentScan` in the Spring application configuration, Spring will scan the specified packages and their sub-packages to discover and register the Spring-managed components as beans in the application context.
## 5. How to define which package spring need to scan in xml and annotation?
In XML configuration, define which packages Spring needs to scan using the `<context:component-scan>` element.  
```aidl
<context:component-scan base-package="com.example.myapp" />
```

In Java annotation configuration, we can use the `@ComponentScan` annotation.  
```
@Configuration
@ComponentScan(basePackages = "com.example.myapp")
public class AppConfig {
    // Configuration class code
}
```
In the above example, the `@ComponentScan` annotation is used at the class level to specify that Spring should scan the `com.example.myapp` package and its sub-packages for Spring components.
## 6. What is @SpringbootApplication?
`@SpringBootApplication` is a convenient annotation provided by the Spring Boot framework. It combines three commonly used annotations: `@Configuration`, `@EnableAutoConfiguration`, and `@ComponentScan`.
`@Configuration`: Marks the class as a configuration class, allowing it to define beans and other configuration elements.

`@EnableAutoConfiguration`: Enables Spring Boot's auto-configuration mechanism. It automatically configures the Spring application based on the classpath and the dependencies present, reducing the need for manual configuration.

`@ComponentScan`: Scans for Spring components, such as @Component, `@Service`, `@Repository`, and `@Controller`, in the specified package and its sub-packages. By default, it scans the current package and its sub-packages.
## 7. How many ways wo can define a bean?
-	Use xml file with the `<bean>` tag to declare a bean, this is rarely used today
-	Use `@Bean` annotation together with the config class annotated with the `@configuration`
-	Use `@Component` annotation  

`@Component` is to mark a class as a Spring-managed component. So it can be automatically detected and instantiated by Spring. This approach can be used for classes that do not have any special configuration or initialization requirements  

`@Bean`, this way is to create beans that require some configuration or initialization. So 
it provides more flexibility and control over the bean creation process.

## 8. What is default bean name for @Component and @Bean?
In Spring, the default bean name for `@Component` and `@Bean` is derived from the name of the class or method, respectively.

`@Component` Default Bean Name:  
- When annotating a class with `@Component`, Spring will create a bean with a default name based on the class name.  
- The default bean name is the simple class name (lowercase first letter) with the first letter converted to lowercase.
- For example, if you have a class named `MyComponent`, the default bean name will be `myComponent`.  
- 
`@Bean` Default Bean Name:
- When you use the `@Bean` annotation on a method within a configuration class, the default bean name is derived from the method name.
- The default bean name is the same as the method name.
- For example, if you have a method named `createDataSource`, the default bean name will be `createDataSource`. 

## 9. What is the difference between @component and @service,@repository?
`@Component` is a generic annotation used to mark a class as a Spring-managed component.  
`@Service`, and `@Repository` are specialized variants of the `@Component` annotation, each serving a specific purpose within the application.
## 10. How many annotations we can use to inject the bean?
- `@Autowired`: Used for automatic bean injection. It can be applied to fields, constructors, setter methods, and even on the parameter level of a method. It supports both dependency injection by type and by name.

- `@Resource`: Used for automatic bean injection by name. It can be applied to fields, setter methods, and parameters of a method. It resolves the bean by name from the application context.

- `@Inject`: Similar to `@Autowired`, it is used for automatic bean injection. It is part of the Java Dependency Injection standard and provides similar functionality to `@Autowired`.

- `@Value`: Used for injecting values from properties files or other sources into beans. It can be applied to fields, methods, and constructor parameters to inject specific values.

- `@Qualifier`: Used to resolve bean injection ambiguity when multiple beans of the same type are available. It can be applied in conjunction with `@Autowired` or `@Inject` to specify the bean name or qualifier to be injected.

- `@Primary`: Used to specify a primary bean when multiple beans of the same type are available. The primary bean will be preferred for injection if no specific qualifier is specified.
## 11. Tell me the three types to do dependency injection(How can we inject the beans in Spring)? Which way is better and why?
- Constructor based dependency injection
- Setter based dependency injection
- Field based dependency injection  

Constructor base DI is preferred:
1.	Compile-time checks: Constructor injection can catch dependency issues at compile time, rather than at runtime. That means if a required dependency is not provided, the compiler will generate an error, which can help to prevent bugs and improve code quality.
2.	Testability: Constructor injection can make objects easier to test, especially in unit tests. since it allows for easier mocking dependencies in unit tests, which can help to isolate the code being tested and reduce the number of external dependencies


## 12. If we have multiple beans for one type, how to set one is primary? and how to let the spring pick one bean to inject if no primary.
Set one bean as the primary bean among multiple beans of the same type using the `@Primary` annotation    
```aidl
@Component
@Primary
public class PrimaryBean implements MyInterface {
    // Implementation
}
```
If there is no primary bean and no specific bean is chosen for injection, Spring will throw an exception indicating the ambiguity of the bean resolution. In such cases, specify the desired bean using the `@Autowired` annotation's `@Qualifier` attribute  
```aidl
@Autowired
@Qualifier("specificBean")
private MyInterface myBean;
```

## 13. What is the difference between BeanFactory and ApplicationContext in Spring?
-	`BeanFactory` represents the most basic IoC container. It creates, configures, and manages beans. `BeanFactory` loads the bean definitions and dependency among the beans based on a XML configuration file or using Java Configuration.
  - It doesn’t support Annotation-based configuration. 
  - It supports only `Singleton` and `Prototype` bean scopes.
-	`ApplicationContext` is an advanced container that extends the beanFactory. So it provides all the functionalities of `BeanFactory` and has some advanced features.
  - It supports annotation-based configuration. 
  - It supports all types of bean scopes

## 14. What is the Scope of a Bean? and list the examples for each scope.
The scope of a bean in Spring defines the lifecycle and visibility of the bean instance within the application context. It determines how long the bean instance is maintained and how it is shared among different components that require it.  

- `Singleton` is the default scope of a bean object. Means that there is only one bean object of that class in the container, it will be reused everytime it is called. 
  - Advantages: Speed is faster, memory is lesser. Cause we don’t have to create a new one every time this object is needed 
  - Disadvantages: Only one object is there, so multi-threads have to share this object, that may cause thread safety issue
- `Prototype` is that Spring will create a new bean object everytime one is needed.
  - `Singleton` scope should be used for stateless beans. Prototype is used for beans that are stateful.
- `Request`: it provides a different instance every time for each HTTP request, available only in the context of a Web Application
- `Session`: it provides a different instance for each HTTP Session, available only in the context of a Web Application.


## 15. Configure a bean using xml. If bean has parameters/dependencies, how can we configure the bean? 

In XML configuration, we can configure a bean and its parameters/dependencies using the `<bean>` element and its attributes.
```aidl
<bean id="myBean" class="com.example.MyBean">
    <constructor-arg value="parameterValue" />
    <property name="propertyName" value="propertyValue" />
    <!-- Additional properties or constructor arguments -->
</bean>
```
- `<bean>`: Defines the bean configuration and provides a unique identifier (id) for the bean.
class: Specifies the fully qualified class name of the bean.
- `<constructor-arg>`: Defines constructor arguments for the bean. You can provide a value using the `value` attribute or reference another bean using the `ref` attribute.
- `<property>`: Sets the value of a bean property. You can specify the property name using the `name` attribute and provide a value using the `value` attribute or reference another bean using the `ref` attribute.

---
# HW Spring MVC
## 1. List all of the annotations you learned from class and homework to annotaitons.md
See `ShortQuestions/annotations`
## 2. What is MVC pattern?
It’s Model – View – Controller. It’s an architectural pattern that separates an application into three main logical components. They are built to handle specific parts of an application
- View is the UI part
- Model is the database part
- Controller is the part between Model and View to handle business logic and incoming requests, manipulate data using the Model component and interact with the Views to render the final output.

## 3. What is Front-Controller?
In web application architecture, a Front Controller is a design pattern that provides a centralized entry point for handling and dispatching incoming requests. It acts as a primary handler responsible for processing requests and coordinating the flow of control within the application.
## 4. What is DispatcherServlet? please decribe how it works.
It serves as the front controller that handles and dispatches incoming HTTP requests in a web application. It acts as the central entry point for request processing and facilitates the flow of control within the Spring MVC framework.  
DispatcherServlet works:

1. Incoming Request:
- When an HTTP request is received by the web server, it is first directed to the DispatcherServlet by the web container.
2. Handler Mapping:
- The DispatcherServlet consults the configured Handler Mapping (configured via @RequestMapping annotations, XML configuration, or other means) to determine the appropriate handler for the request.
- The Handler Mapping maps the request URL to a specific handler or controller that can process the request.
3. Handler Execution:
- Once the appropriate handler is determined, the DispatcherServlet calls the handler's methods to execute the necessary business logic.
- The handler performs the required processing, such as data retrieval, validation, or any other application-specific operations.
4. Model and View Preparation:
- After the handler has executed, it typically prepares a model object containing data to be displayed or processed further.
- The handler returns a logical view name or a View object that represents the desired rendering of the response.
5. View Resolution:
- The DispatcherServlet consults the View Resolver (configured via XML or other means) to determine the appropriate View implementation for the logical view name returned by the handler.
- The View Resolver resolves the logical view name to a concrete view implementation, such as a JSP, Thymeleaf template, or any other view technology.
6. View Rendering:
- The DispatcherServlet invokes the chosen View implementation to generate the actual response by rendering the model data within the selected view technology.
- The rendered response is typically an HTML page, but it can also be JSON, XML, or any other format based on the requested content type.
7. Response Handling:
- The generated response is sent back to the web server, which then delivers it to the client that initiated the request.
## 5. What is JSP and What is ModelAndView? 
JSP (JavaServer Pages) is a view technology commonly used in Java web applications. It allows developers to embed Java code within HTML or XML templates, enabling dynamic content generation and the creation of web pages that can interact with server-side logic.  
`ModelAndView` is a class in the Spring MVC framework that represents both the model and view components in the MVC pattern. It is commonly used to encapsulate the data to be displayed and the logical view name to be rendered by the `ViewResolver`.
## 6. Could you please google any other servlets
1. `HttpServlet`: the base class for servlets that handle HTTP requests and responses.
2. `GenericServlet`: is an abstract class that provides a generic implementation of the `Servlet` interface.
3. `AsyncServlet`: a servlet that supports asynchronous processing of requests.
4. `Filter`: A filter is a special type of servlet that intercepts and modifies incoming requests and outgoing responses
5. `Listener`: A listener is a component that listens for events occurring within a web application.
## 7. How many web server do you know? (Tomcat, Jetty, Jboss)
1. Apache Tomcat:  
- Tomcat is a popular web server and servlet container designed for hosting Java-based web applications.
- It is lightweight, easy to configure, and widely used in Java web development.
2. Jetty:
- Jetty is a lightweight web server and servlet container that focuses on high performance and low resource usage.
- It is written in Java and is known for its fast startup time and small memory footprint.
- Jetty is often used in scenarios where efficiency and embedded deployment are important.

3. JBoss (WildFly):
- JBoss, now known as WildFly, is a Java-based open-source application server that also functions as a web server.
- It provides a robust runtime environment for hosting enterprise-level applications.
- JBoss/WildFly supports Java EE (Enterprise Edition) specifications and offers features like clustering, high availability, and advanced management capabilities.