> ### 1. `@Autowired`
> 
> `@Autowired` is used to automatically wire beans by matching them based on their types. It can be used on fields, constructors, and methods.
> 
> ```java
> @Autowired
> private MyService myService;
> ```
> 
> ### 2. `@Component`
> 
> `@Component` is a generic stereotype annotation to indicate that a class should be treated as a Spring bean.
> 
> ```java
> @Component
> public class MyComponent {
>   // ...
> }
> ```
> 
> ### 3. `@Controller`
> 
> `@Controller` is a specific stereotype annotation for classes that handle web requests in a Spring MVC application.
> 
> ```java
> @Controller
> public class MyController {
>   // ...
> }
> ```
> 
> ### 4. `@Service`
> 
> `@Service` is a specific stereotype annotation for classes that implement business logic in a Spring application.
> 
> ```java
> @Service
> public class MyService {
>   // ...
> }
> ```
> 
> ### 5. `@Repository`
> 
> `@Repository` is a specific stereotype annotation for classes that handle data access logic in a Spring application.
> 
> ```java
> @Repository
> public class MyRepository {
>   // ...
> }
> ```
> 
> ### 6. `@RequestMapping`
> 
> `@RequestMapping` is used to map web requests to specific methods in a controller.
> 
> ```java
> @Controller
> public class MyController {
> 
>   @RequestMapping("/hello")
>   public String hello() {
>     return "Hello, World!";
>   }
> }
> ```
> 
> ### 7. `@GetMapping`, `@PostMapping`, `@PutMapping`, `@DeleteMapping`, `@PatchMapping`
> 
> These annotations are used to map specific HTTP methods (GET, POST, PUT, DELETE, PATCH) to methods in a controller.
> 
> ```java
> @Controller
> public class MyController {
> 
>   @GetMapping("/hello")
>   public String hello() {
>     return "Hello, World!";
>   }
> }
> ```
> 
> ### 8. `@PathVariable`
> 
> `@PathVariable` is used to bind a path variable from a URL to a method parameter.
> 
> ```java
> @Controller
> public class MyController {
> 
>   @GetMapping("/users/{id}")
>   public String getUser(@PathVariable Long id) {
>     // ...
>   }
> }
> ```
