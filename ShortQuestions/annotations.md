`@SpringBootApplication`  
This annotation is used to bootstrap and configure a Spring Boot application. It includes @Configuration, @EnableAutoConfiguration and @ComponentScan annotations.
```aidl
@SpringBootApplication
public class MyApp {
   public static void main(String[] args) {
      SpringApplication.run(MyApp.class, args);
   }
}
```

`@Controller`  
This is an annotation that marks a class as a controller class, so this class will receive http requests, deserializes input,  validates input, calls the business logic and serializes the output

`@ResponseBody `  
tells the controller that the object returned is automatically written into HttpResponse as Json or XML. Using Spring MVC, a method should return a page, if we want the method to return only data, we need to tell the Spring MVC to take the return type as a body of the response by adding the `@ResponseBody` annotation  

`@RestController` 
is the same as `@Controller` + `@ResponseBody`

`@RequestMapping` 
is used to map HTTP requests to Spring controller methods. For example, we can use it with class to create the base URI

`@GetMapping` 
annotated method is to handle HTTP Get requests matched the given URI. It is a shortcut for `@RequestMapping(method = RequestMethod.GET)`
```aidl
@RestController
@RequestMapping("/api")
public class MyController {
   @GetMapping("/hello")
   public String sayHello() {
      return "Hello World";
   }
}
```

`@Repository` 
is to indicate that an interface or class provides data access and CRUD operations to DB
```aidl
@Repository
public interface MyRepository extends JpaRepository<MyEntity, Long> {
   // ...
}
```

`@Component`
is to declare a class as a bean that should be managed by the Spring Container
```aidl
@Component
public class MyComponent {
   // ...
}
```

`@EnableAutoConfiguration`
is to enable Spring Boot's auto-configuration mechanism.
```aidl
@EnableAutoConfiguration
public class MyConfig {
   // ...
}
```

`@Autowired`
is to inject dependency
```aidl
@Service
public class MyService {
   @Autowired
   private MyRepository myRepository;
   // ...
}
```

`@RequestBody` 
deserializes an HttpRequest body into a java object
```aidl
@RestController
@RequestMapping("/api")
public class MyController {

   @PostMapping("/user")
   public ResponseEntity<?> createUser(@RequestBody User user) {
      // Do something with the user object
      return ResponseEntity.ok("User created successfully");
   }
   
}
```

`@RequestParam` 
is to extract query parameters from the request

`@PathVariable` 
is to extract values from the URI path. We need to make sure that the number and order of path variables in the url match the ones in the method

`@RequestHeader`
this annotation is to extract the header from the request

`@ResponseStatus`
used to specify the response status of a controller method

`@ExceptionHandler`
This annotation is used to handle exception. If it is used on a method in a controller class, means that it will handle the exceptions thrown within this controller only. If we specify some exception inside the annotation, means that this method will only handle this kind of exception thrown within this controller.
```aidl
@RestController
@RequestMapping("/api")
public class MyController {

   @GetMapping("/user/{id}")
   public ResponseEntity<User> getUserById(@PathVariable Long id) {
      // Code to fetch user by id
      if (user == null) {
         throw new UserNotFoundException("User not found with id " + id);
      }
      return ResponseEntity.ok(user);
   }
   
   @ExceptionHandler(UserNotFoundException.class)
   public ResponseEntity<String> handleUserNotFoundException(UserNotFoundException ex) {
      return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
   }
}
```
