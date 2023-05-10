# HW9

Claudia Feng



## Exception Validation

1. List all of the annotations you learned from class and homework to annotations.md

   

2. what is the @configuration and @bean?

   They both are used in the context of Java-based configuration.

   `@Configuration` is a class-level annotation indicating that an object is a source of bean definitions. A Java class annotated with `@Configuration` is a configuration by itself and will have methods to instantiate and configure the dependencies. 

   `@Bean` is a method-level annotation within a `@Configuration` class. A method annotated with `@Bean` will return an object that should be registered as a bean in the Spring application context. The body of the method bears the logic for creating the instance. 

   

3. How do you handle the exception in Spring?

   `@ExceptionHandler`: This annotation is used within a controller class to handle exceptions. It can be applied to a method that should be invoked when a specific exception occurs.

   `@ControllerAdvice`: This annotation allows you to handle exceptions across the whole application, not just within a single controller. You can think of it as an interceptor of exceptions thrown by methods annotated with `@RequestMapping` and similar. 

   Steps

   1. create ErrorDetails Class

   2. Create GlobalExceptionHandler Class 

   3. Test using Postman Client

      

4. How do you do the validations in Spring? And list some validation annotations you know.

   To perform validation, you first annotate your model object's fields with the constraints you want to enforce. Then, you can use Spring's `@Valid` or `@Validated` annotations in your controller methods to activate the validation process when the methods are called.

   Some of the commonly used validation annotations are:

   - `@NotNull`: The annotated element must not be `null`.
   - `@NotEmpty`: The annotated element must not be `null` or empty. Applicable to collections, arrays, and strings.
   - `@NotBlank`: The annotated element must not be `null` or whitespace. Applicable to strings.
   - `@Email`: The annotated element must be a valid email address.
   - `@Size(min=, max=)`: The annotated element's size must be between the specified boundaries. Applicable to strings, collections, arrays, and maps.
   - `@Min`: The annotated element must be a number whose value must be higher or equal to the specified minimum.
   - `@Max`: The annotated element must be a number whose value must be lower or equal to the specified maximum.
   - `@Pattern`: The annotated string must match the specified regular expression.

   

5. What is the actuator?

   Spring Boot Actuator is a sub-project of Spring Boot. It provides built-in production-ready endpoints to monitor and interact with your application. It helps you to expose operational information about the running application – health, metrics, info, dump, env, etc.



## Spring Basic

1. List all of the annotations you learned from class and homework to annotations.md

   

2. What is Spring and Springboot? What is the benfits of using Springboot?

   Spring is a popular Java framework used for developing enterprise applications. Spring Boot, on the other hand, is a project built on top of the Spring Framework. It simplifies the bootstrapping and development of new Spring applications by providing default configurations and a stand-alone application context. 

   

3. What is IOC and What is DI?

   **IoC (Inversion of Control)**: IoC is a design principle that guides the structuring of software components, inverting the traditional control flow. 

   **DI (Dependency Injection)**: Dependency Injection is a design pattern and a form of IoC where the responsibility of object creation and injecting dependencies is given to a container or a framework, instead of the class itself creating its own dependencies. For instance, consider a `Car` class that depends on an `Engine` class. In traditional programming, the `Car` class might create an instance of `Engine` within its constructor or at the point where `Engine` is used. But with DI, the `Car` class would simply declare that it needs an `Engine` — it's the job of the container to create an instance of `Engine` and provide it to the `Car` class. This makes classes loosely coupled, easy to test, and the code more maintainable. In Spring, DI can be done via constructor injection, setter injection, and field injection.

   

4. What is @CompnonentScan?

   When Spring starts up, it reads the configuration metadata supplied (either in the form of XML, annotations, or Java code), and creates and wires the beans accordingly. But in order to know which classes to manage as beans, Spring needs to know where to look. This is where `@ComponentScan` comes in.

   Components are classes that are managed by Spring, and they can be recognized by Spring through various annotations like `@Component`, `@Service`, `@Repository`, and `@Controller`. These annotated classes will be automatically discovered by Spring, thanks to the `@ComponentScan` annotation, and will be instantiated as beans in the Spring application context.

   If no specific packages are specified, `@ComponentScan` will default to scanning the package in which the annotated class is declared.

   

5. How to define which package spring need to scan in xml and annotation?

   **1. XML Configuration:**

   In XML configuration, you can use the `<context:component-scan>` element to specify the base package(s) to scan. 

   **2. Java Annotations:**

   In Java configuration, you can use the `@ComponentScan` annotation to specify the base package(s) to scan.

   

6. What is @SpringbootApplication?

   `@SpringBootApplication` is a convenience annotation in Spring Boot that is often used as an entry point to start a Spring Boot application.

   

7. How many ways wo can define a bean?

   **XML Configuration**: The traditional way of defining beans in Spring was through XML configuration files.

   ```java
   <beans>
       <bean id="exampleBean" class="com.example.ExampleBean">
           <property name="beanProperty" value="propertyValue"/>
       </bean>
   </beans>
   ```

   **Annotation-Based Configuration**: You can use annotations in your Java classes to define beans. 

   ```java
   @Component
   public class ExampleBean {
       //...
   }
   ```

   **Java Configuration**: You can also define beans in Java configuration classes. These classes are typically annotated with `@Configuration` and the methods that define beans are annotated with `@Bean`. 

   ```java
   @Configuration
   public class AppConfig {
       @Bean
       public ExampleBean exampleBean() {
           return new ExampleBean();
       }
   }
   ```

   

8. What is default bean name for @Component and @Bean?

   **1. @Component:**

   For a class annotated with `@Component` (or `@Service`, `@Repository`, `@Controller`, etc.), the default bean name is the uncapitalized non-qualified class name — that is, the class name with the first letter in lowercase.

   ```java
   @Component
   public class MyComponentClass {
       // ...
   }
   ```

   In this case, the default bean name would be "myComponentClass".

   **2. @Bean:**

   For a method annotated with `@Bean`, the default bean name is the method name itself.

   ```java
   @Configuration
   public class AppConfig {
       @Bean
       public ExampleBean exampleBean() {
           return new ExampleBean();
       }
   }
   ```

   In this case, the default bean name would be "exampleBean".

   

9. What is the difference between @component and @service,@repository?

   1. **@Component**: This is a generic annotation. It can be used across application. The `@Component` annotation is used to indicate that a class is a "component". These classes are considered as candidates for auto-detection when using annotation-based configuration and classpath scanning.

   2. **@Service**: This is a specialization of `@Component` and is typically used in the service layer (business layer). Although it doesn't currently provide any additional behavior over the `@Component` annotation, it's a good idea to use `@Service` in your service layer because it specifies intent better and may carry additional semantics in future versions of Spring.

   3. **@Repository**: This is also a specialization of `@Component`, and it's used in the data access layer. In addition to being used for automatic bean detection, the `@Repository` annotation also has a special purpose. It provides a translation of data access exceptions from the technology-specific ones into Spring's unified `DataAccessException`, which is technology agnostic.

      

10. How many annotations we can use to inject the bean?

    **@Autowired**: This annotation can be used on fields, constructors, and methods, and it tells Spring to automatically inject the bean by type. Spring will look for the bean in its context and inject it where `@Autowired` is declared.

    If there are multiple beans of the same type, you can use the `@Qualifier` annotation along with `@Autowired` to specify the name of the bean you want to inject.

    **@Inject**: This annotation is part of the Java CDI (Contexts and Dependency Injection) standard that was introduced in Java EE 6. It works the same way as `@Autowired` but is not Spring-specific. You'll need to have the `javax.inject` package on your classpath to use `@Inject`.

    **@Resource**: This annotation is part of the JSR-250 specification, and it's used to inject beans by name. The name is determined by the name of the annotated field or setter method, but you can also explicitly specify the name using `@Resource(name = "myBean")`.

    

11. Tell me the three types to do dependency injection(How can we inject the beans in Spring)? Which way is better and why?

    **Constructor Injection**: This is where the dependencies of a class are provided through the class's constructor. When a new instance of the class is created, Spring will automatically pass the dependencies to the constructor.

    ```java
    @Service
    public class MyService {
        private final MyDependency myDependency;
    
        public MyService(MyDependency myDependency) {
            this.myDependency = myDependency;
        }
    }
    ```

    

    **Setter Injection**: This is where the dependencies of a class are provided through JavaBean properties (i.e., setter methods). Spring will call these methods after it has called the no-argument constructor or no-constructor to set the dependencies.

    ```java
    @Service
    public class MyService {
        private MyDependency myDependency;
    
        @Autowired
        public void setMyDependency(MyDependency myDependency) {
            this.myDependency = myDependency;
        }
    }
    ```

    

    **Field Injection**: This is where the dependencies are injected directly into the fields. Spring uses reflection to set the fields directly, even if they're private.

    ```java
    @Service
    public class MyService {
        @Autowired
        private MyDependency myDependency;
    }
    ```

    Among these types, **constructor injection** is generally recommended. Here's why:

    - **Immutability**: With constructor injection, the injected dependencies can be final. This ensures that they cannot be changed afterwards, which makes your objects safer from a thread-safety perspective.

    - **Prevents Nulls**: Constructor injection ensures that an object is fully initialized when it's created. You can't construct an object without providing the necessary dependencies, which helps prevent `NullPointerExceptions`.

    - **Simplicity**: With constructor injection, a class can only be in one state: fully initialized. With setter or field injection, an object can be in an in-between state, where it's been constructed but not all of its dependencies have been set yet.

    - **Testability**: Constructor injection makes your classes easier to test. You can simply instantiate an object using the `new` keyword and pass the dependencies to the constructor. This is harder to do with setter or field injection, because you need to remember to call the setter methods or use reflection to set the fields.

      

12. If we have multiple beans for one type, how to set one is primary? and how to let the spring to pick one bean to inject if no primay.

    In Spring, if there are multiple beans of the same type, you can use the `@Primary` annotation to indicate which bean should be chosen when there's an autowiring conflict. 

    ```java
    @Bean
    @Primary
    public MyService myServiceA() {
        return new MyServiceA();
    }
    
    @Bean
    public MyService myServiceB() {
        return new MyServiceB();
    }
    ```

    However, if you want to specify exactly which bean to inject, you can use the `@Qualifier` annotation. The `@Qualifier` annotation allows you to specify the name of the bean to be injected:

    ```java
    @Autowired
    @Qualifier("myServiceB")
    private MyService myService;
    ```

    The `@Qualifier` annotation can be used in conjunction with both field injection and constructor injection. For constructor injection, you would typically put the `@Qualifier` annotation on the constructor parameters:

    ```java
    private final MyService myService;
    
    @Autowired
    public MyClass(@Qualifier("myServiceB") MyService myService) {
        this.myService = myService;
    }
    ```

    

13. What is the difference between BeanFactory and ApplicationContext in Spring?

​	`BeanFactory` and `ApplicationContext` are both fundamental parts of Spring's IoC (Inversion of Control) container. They provide different levels of control over the Spring application:

1. **BeanFactory**: BeanFactory is the root interface for accessing a Spring IoC container. It provides basic Inversion of Control (IoC) and Dependency Injection (DI) features. It's a simple container for instantiating and managing beans.

2. **ApplicationContext**: ApplicationContext is a more advanced interface that adds more enterprise-specific functionality on top of the BeanFactory. It includes all functionality of the `BeanFactory` and much more. Its main features include:

   - Easier integration with Spring's AOP features

   - Message resource handling (for use in internationalization)

   - Event propagation to beans implementing the `ApplicationListener` interface

   - Loading multiple (hierarchical) contexts, allowing each to be focused on one particular layer (for example, the web layer of an application)

   - Transparent resolution of singleton and prototype beans

   - Spring's `@Async` annotation for asynchronous method execution

     

14. What is the Scope of a Bean? and list the examples for each scope.

    **Singleton**: This is the default scope in Spring. Only one instance of the bean is created by the Spring container, and this single instance is shared across multiple requests. This bean is cached, and the same instance is returned each time it is requested. This is best for stateless beans.

    ```java
    @Scope("singleton")
    @Component
    public class SingletonBean {
    //...
    }
    ```

    **Prototype**: A new instance of the bean is created each time it is requested from the container. This is best for stateful beans where each instance can have different data.

    ```java
    @Scope("prototype")
    @Component
    public class PrototypeBean {
    //...
    }
    ```

    **Request**: A new bean is created for each HTTP request. This scope is valid only in a web-aware Spring `ApplicationContext`.

    **Session**: A single bean is created for each HTTP session by the container. This scope is also valid only in a web-aware Spring `ApplicationContext`.

    **Application**: A single bean is created for the life of the entire application. This is similar to a Singleton but scoped to the Servlet `ServletContext`. This scope is valid only in a web-aware Spring `ApplicationContext`.

    **WebSocket**: A single bean is created for the life of a WebSocket. This is scoped to the `SockJS` `WebSocketSession`. This scope is also valid only in a web-aware Spring `ApplicationContext`.

    

15. Configure a bean using xml. If bean has parameters/dependencies, how can we configure the bean? (you can google the tutorial how to configure beans in xml, and feel free to ask me any quesitons if you don't understand. it is a little bit old, I am not sure if I need to exaplain it in class)

```java
<bean id="myDependency" class="com.example.MyDependency" />

<bean id="myService" class="com.example.MyService">
    <property name="dependency" ref="myDependency" />
</bean>
```





## Spring MVC

1. List all of the annotations you learned from class and homework to annotations.md

   

2. What is MVC pattern?

   1. **Model**: The Model represents the data and the business logic of the application. It's responsible for retrieving data and converting it into meaningful concepts for your application. This could be a database table, a JSON file, or any other data source. The Model also defines the rules for data validation and manipulation.
   2. **View**: The View is responsible for rendering the user interface and presenting the data to the user. The same data can have multiple views. For example, you might have one view to display a list of items and another view to display a single item.
   3. **Controller**: The Controller acts as an intermediary between the Model and the View. It processes the user's requests and inputs, updates the Model, and decides which View should be used to display the response.

   Here's a common sequence of events in an MVC application:

   1. The user interacts with the user interface in some way (for example, the user clicks a button).

   2. The Controller handles the user input and updates the Model accordingly.

   3. The Model updates the View.

   4. The user sees the updated View.

      

3. What is Front-Controller?

   The Front Controller is a design pattern in web application development. It's often used in web frameworks to provide a centralized entry point for handling requests.

   In this pattern, a single controller (the "Front Controller") handles all requests for a web application. It's responsible for processing the request and delegating the work to different parts of the application, such as various controllers or handlers, views, and models.

   In the context of Spring MVC, the `DispatcherServlet` acts as the Front Controller. It's responsible for routing incoming requests to the appropriate `@Controller` classes, and it helps to ensure a consistent programming model across different types of applications.

   

4. What is DispatcherServlet? please decribe how it works.

   DispatcherServlet abstracts away the following tedious and boilerplate tasks and focus on

   useful business logic:

   * Mapping an HTTP request to a certain processing method

   * Parsing of HTTP request data and headers into data transfer objects (DTOs)or domain objects

   * Model-view-controller interactions

   * Generation of responses from DTOs, domain objects, etc.

     

5. What is JSP and What is ModelAndView? (please google to have a basic knowlege)

   JSP is a Java-based technology used for building dynamic web pages. It's a server-side technology, which means it runs on the server and generates HTML (or other types of content) that's sent to the client's browser.

   ModelAndView is a class in Spring MVC that is often used as a handler method's return type. It's a holder for both Model and View in the web MVC framework. This class is designed for use in a DispatcherServlet context, often returned as a handler method's return value.

   

6. Could you please google any other servlets(理解多少是多少，不要花太多时间， 知道servlet的名字就行。)

   1. **HttpServlet**: This is part of the Java Servlet API and the basis for all HTTP servlets. It provides methods, such as `doGet()` and `doPost()`, for handling HTTP-specific services.

   2. **GenericServlet**: An abstract class that implements the `Servlet` interface and is extended by other Servlet classes. It provides simple versions of the lifecycle methods `init` and `destroy`, and of the methods in the `ServletConfig` interface.

   3. **FacesServlet (JSF)**: This is the main servlet in JavaServer Faces. It acts as the controller in the MVC design pattern and handles requests for JSF pages.

   4. **JspServlet**: This servlet handles requests for JSP pages. It's part of the Java standard library and is generally used internally rather than directly by developers.

   5. **Struts ActionServlet**: If you're using the Struts framework (an older Java MVC web framework), then you'll likely use `ActionServlet`, which handles the request processing in the Struts framework.

      

7. How many web server do you know? (Tomcat, Jetty, Jboss)

   1. **Apache Tomcat**: Apache Tomcat is an open-source web server and servlet container developed by the Apache Software Foundation. It's often used for serving Java applications and is a popular choice for use with the Spring Framework.

   2. **Jetty**: Jetty is another open-source web server and servlet container. It's lightweight, supports asynchronous I/O, and is often embedded in other Java applications.

   3. **JBoss/WildFly**: JBoss is a Java-based application server developed by Red Hat that includes a web server component. The open-source version is known as WildFly.

   4. **GlassFish**: GlassFish is an open-source application server that implements the Java EE specifications. It's developed by the Eclipse Foundation.

   5. **WebLogic**: Oracle WebLogic is a Java EE application server that is part of Oracle's Fusion Middleware portfolio.

   6. **WebSphere**: IBM WebSphere is another Java EE application server.

   7. **Undertow**: Undertow is a lightweight, flexible web server written in Java. It's used as the default web server in the WildFly application server from version 8 onwards.

   8. **Netty**: While not a web server in the traditional sense, Netty is a Java-based networking framework that includes capabilities for writing web server-like applications.

   9. **Apache HTTP Server**: One of the most popular web servers in the world, often used in combination with Tomcat to serve static content.

   10. **Nginx**: A high-performance web server and reverse proxy server. It's often used as a load balancer or for serving static content.

   11. **Microsoft Internet Information Services (IIS)**: A web server for Microsoft's Windows systems.

       

8. clone this repo, and run it in you local.

   1. https://github.com/TAIsRich/springmvc5-demo

   2. Notice that you need to configure the Tomcat by yourself. tutorial in

      the slides.

   3. find out the APIs in controlelr and call some APIs, In slides, I also list some API.

   4. remeber to create a database for this project

   5. all details in the slides.
