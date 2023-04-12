1. @Autowired: This annotation is used to inject dependencies into a class. When you use @Autowired, Spring will automatically search for a bean that matches the type of the field or constructor parameter being annotated and inject it.
```
@Service
public class MyService {
    private final MyRepository myRepository;

    @Autowired
    public MyService(MyRepository myRepository) {
        this.myRepository = myRepository;
    }
}

@Repository
public class MyRepository {
    // ...
}
```
2. @Component: This annotation is used to mark a class as a Spring component. This means that Spring will manage the lifecycle of the component and can autowire it into other components.
```
@Component
public class MyComponent {
    // ...
}
```
3. @Repository: This annotation is used to mark a class as a Spring Data repository. This means that Spring will generate a concrete implementation of the repository interface and manage its lifecycle.
```
@Repository
public interface MyRepository extends JpaRepository<MyEntity, Long> {
    // ...
}
```
4. @Service: This annotation is used to mark a class as a Spring service. This means that the class contains business logic and can be used by other components in the application.
```
@Service
public class MyService {
    // ...
}
```
5. @Controller: This annotation is used to mark a class as a Spring MVC controller. This means that the class can handle HTTP requests and return responses.
```
@Controller
public class MyController {
    // ...
}
```
6. @RestController: This annotation is used to combine @Controller and @ResponseBody annotations into a single annotation. This means that the class can handle HTTP requests and return responses in the form of JSON or XML.
```
@RestController
public class MyRestController {
    // ...
}
```
7. @Bean: This annotation is used to mark a method that produces a bean to be managed by Spring.
```
@Configuration
public class MyConfiguration {
    @Bean
    public MyBean myBean() {
        return new MyBean();
    }
}
```
8. @Value: This annotation is used to inject values from the application's properties files into a field or method parameter.
```
@Component
public class MyComponent {
    @Value("${my.property}")
    private String myProperty;
}
```
9. @ConfigurationProperties: This annotation is used to bind properties from the application's properties files to a configuration class.
```
@Configuration
@ConfigurationProperties(prefix = "my.config")
public class MyConfiguration {
    private String propertyOne;
    private String propertyTwo;
}
```