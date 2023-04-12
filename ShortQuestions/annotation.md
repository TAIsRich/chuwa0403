# HW4 - Annotations

## `@Resource`

`@Resource` annotation is used to inject a resource, such as a data source or a messaging queue, into a Spring-managed bean. `@Resource` annotation is part of the Java EE specification and is supported by Spring as well. It can be used to inject any resource that is available in the Java naming and directory interface (JNDI).

```java
import javax.jms.Queue;
import org.springframework.stereotype.Component;
import javax.annotation.Resource;

@Component
public class MyMessageListener {

    @Resource
    private Queue myQueue;

    // rest of the code...
}
```

## `@Component`

`@Component` annotation is used to mark a class as a Spring-managed bean. Spring Boot scans the classpath for classes annotated with `@Component` and automatically creates an instance of the bean during the application startup. Once a class is marked with `@Component`, it can be injected into other Spring-managed beans using other annotations such as `@Autowired`, `@Resource`, or `@Inject`. Note that `@Component` is a generic annotation that can be used for any Spring-managed bean, regardless of its functionality. There are also more specific annotations available in Spring Boot, such as `@Controller`, `@Service`, and `@Repository`, which are used to mark classes as web controllers, services, and repositories respectively.

```java
import org.springframework.stereotype.Component;

@Component
public class MyComponent {

    // rest of the code...
}
```

## `@Repository`

`@Repository` annotation is used to mark a class as a repository, which is a type of Spring-managed bean that provides a data access interface to the application.

## `@Service`

`@Service` annotation is used to mark a class as a service, which is a type of Spring-managed bean that provides business logic to the application.

## `@Controller`

`@Controller` annotation is used to mark a class as a controller, which is a type of Spring-managed bean that handles incoming HTTP requests and returns a response to the client. Once a controller is marked with `@Controller`, it can be used to handle incoming HTTP requests and return responses to the client. Controllers can perform a wide range of operations, such as fetching data from a database, rendering views, or returning JSON or XML responses.

```java
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MyController {

    @GetMapping("/hello")
    @ResponseBody
    public String hello() {
        return "Hello, World!";
    }
}
```

## `@RestController`

`@RestController` annotation is a specialized version of the `@Controller` annotation, which is used to mark a class as a RESTful web service controller. It combines `@Controller` and `@ResponseBody` annotations to simplify the creation of RESTful web services. The `@RestController` annotation is a combination of the `@Controller` and `@ResponseBody` annotations, which means that Spring Boot automatically serializes the return value of each method into JSON or XML format, depending on the requested content type.

```java
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyRestController {

    @GetMapping("/hello")
    public String hello() {
        return "Hello, World!";
    }
}
```

## `@Configuration`

`@Configuration` annotation is used to mark a class as a Spring configuration class. A configuration class provides bean definitions for the Spring application context. It is typically used to configure third-party libraries or to define custom beans that are not automatically detected by Spring. 

```java
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
// 相当于 xml 中配置 Bean
@Configuration
public class MyConfiguration {
    @Bean
    public MyService myService() {
        return new MyServiceImpl();
    }
}
```

## `@GetMapping`

`@GetMapping` annotation is used to map HTTP GET requests onto specific handler methods in a Spring-managed controller class. Note that `@GetMapping` is a specific type of `@RequestMapping` annotation that is used to handle HTTP GET requests. Other HTTP methods, such as POST, PUT, and DELETE, can be handled using `@PostMapping`, `@PutMapping`, and `@DeleteMapping` annotations, respectively.

```java
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyController {

    @GetMapping("/hello")
    public String hello() {
        return "Hello, World!";
    }
}
```

## `@PostMapping`

`@PostMapping` annotation is used to map HTTP POST requests onto specific handler methods in a Spring-managed controller class. The `@RequestBody` annotation on the `formData` parameter tells Spring to automatically deserialize the HTTP request body into a String object. Note that `@PostMapping` is a specific type of `@RequestMapping` annotation that is used to handle HTTP POST requests. Other HTTP methods, such as GET, PUT, and DELETE, can be handled using `@GetMapping`, `@PutMapping`, and `@DeleteMapping` annotations, respectively.

```java
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyController {

    @PostMapping("/submit")
    public String submitForm(@RequestBody String formData) {
        // handle form submission
        return "Form submitted successfully";
    }
}
```

## `@PutMapping`

`@PutMapping` annotation is used to map HTTP PUT requests onto specific handler methods in a Spring-managed controller class.

```java
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyController {

    @PutMapping("/update")
    public String updateRecord(@RequestBody String updatedData) {
        // update record with new data
        return "Record updated successfully";
    }
}
```

## `@DeleteMapping`

`@DeleteMapping` annotation is used to map HTTP DELETE requests onto specific handler methods in a Spring-managed controller class. 

```java
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyController {

    @DeleteMapping("/delete/{id}")
    public String deleteRecord(@PathVariable int id) {
        // delete record with specified ID
        return "Record deleted successfully";
    }
}
```

