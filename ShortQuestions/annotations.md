# Springboot Annotations Summary

## SpringBoot

### `@SpringBootApplication`

A single @SpringBootApplication annotation can be used to enable those three features, that is:

* `@EnableAutoConfiguration`: enable Spring Boot’s auto-configuration mechanism
* `@ComponentScan`: enable @Component scan on the package where the application is located (see the best practices)
* `@Configuration`: allow to register extra beans in the context or import additional configuration classes

```java

@SpringBootApplication // same as @Configuration @EnableAutoConfiguration @ComponentScan
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}
```

### `@Component`

Indicates that an annotated class is a "component". Such classes are considered as candidates for auto-detection when
using annotation-based configuration and classpath scanning.

```java

@Controller
public class ControllerExample {
}

@Service
public class ServiceExample {
}

@Repository
public class RepositoryExample {
}

@Component
public class ComponentExample {
}
```

### `@Autowired`

Marks a constructor, field, setter method, or config method as to be autowired by Spring's dependency injection
facilities.

```java
public class FooService {
    private FooFormatter fooFormatter;

    @Autowired
    public FooService(FooFormatter fooFormatter) {
        this.fooFormatter = fooFormatter;
    }
}
```

```java
public class FooService {
    @Autowired(required = false)
    private FooDAO dataAccessor;
}
```

### `@Qualifier`

By including the @Qualifier annotation, together with the name of the specific implementation we want to use, in this
example Foo, we can avoid ambiguity when Spring finds multiple beans of the same type.

```java
public class FooService {

    @Autowired
    @Qualifier("fooFormatter")
    private Formatter formatter;
}

@Component("fooFormatter")
public class FooFormatter implements Formatter {

    public String format() {
        return "foo";
    }
}

@Component("barFormatter")
public class BarFormatter implements Formatter {

    public String format() {
        return "bar";
    }
}
```

### `@Primary`

I don’t care which class, just give me the **primary** one

- When using `@Primary`, can have **only one** for multiple implementations
- If you mix `@Primary` and `@Qualifier`, `@Qualifier` has higher priority
- In general, `@Qualifier` is recommended

```java

@Primary
@Component
public class BaseballCoach implements Coach {
    @Override
    public String getDailyWorkout() {
        return "Baseball";
    }
}

@RestController
public class DemoRestController {
    private Coach coach;

    @Autowired
    public DemoRestController(Coach coach) {
        this.coach = coach;
    }

    @GetMapping("/workout")
    public String getDailyWorkout() {
        return coach.getDailyWorkout();
    }
}
```

### `@Lazy`

- By default, when you application starts, all beans are initialized. E.g. `@Component`
- Spring will create an instance of each and make them available
- @Lazy: A bean will only be in the following cases:
    - It is needed for dependency injection
    - Or it is explicitly requested

### `@Scope`

We can also explicitly specify bean scope

```java
import org.springframework.beans.factory.config.ConfigurableBeanFactory;

@Component
@Scope(ConfigurableBeanFactory.SCOPE_SINGLETON)
public class CricketCoach implements Coach {

}
```

### `@PostConstruct and @preDestroy`

```java

@Component
public class CricketCoach implements Coach {
    public CricketCoach() {
        System.out.println(this.getClass().getSimpleName());
    }

    @PostConstruct
    private void postConstruct() {
        System.out.println("do after construction");
    }

    @PreDestroy
    private void preDestroy() {
        System.out.println("do before destroy");
    }

    @Override
    public String getDailyWorkout() {
        return "Cricket";
    }
}
```

### `@Bean and @Configuration`

* Make an existing third-party class available to Spring framework, since you do not have access to the source code of
  third-party class (only jar), so you cannot insert @Component , however, you would like to use the 3rd-party class as
  a Spring bean for DI

```java
public class SwimCoach implements Coach {
    @Override
    public String getDailyWorkout() {
        return "Swim";
    }
}
```

```java
import org.springframework.context.annotation.Configuration;

@Configuration
public class SportConfig {
    @Bean("swimCoach")
    public Coach swimCoach() { //by default: method name same as bean id
        return new SwimCoach();
    }
}
```

```java

@RestController
public class DemoRestController {
    private Coach coach;

    @Autowired
    public DemoRestController(@Qualifier("swimCoach") Coach coach) {
        this.coach = coach;
    }

    @GetMapping("/workout")
    public String getDailyWorkout() {
        return coach.getDailyWorkout();
    }
}
```

### `@Controller`

We can annotate classic controllers with the @Controller annotation. This is simply a specialization of the @Component
class, which allows us to auto-detect implementation classes through the classpath scanning.

We typically use @Controller in combination with a @RequestMapping annotation for request handling methods.

```java

@Controller
@RequestMapping("books")
public class SimpleBookController {

    @GetMapping("/{id}", produces = "application/json")
    public @ResponseBody Book getBook(@PathVariable int id) {
        return findBookById(id);
    }

    private Book findBookById(int id) {
        // ...
    }
}
```

### `@RestController`

Spring 4.0 introduced the @RestController annotation in order to simplify the creation of RESTful web services. It's a
convenient annotation that combines @Controller and @ResponseBody,

```java

@RestController
@RequestMapping("books-rest")
public class SimpleBookRestController {

    @GetMapping("/{id}", produces = "application/json")
    public Book getBook(@PathVariable int id) {
        return findBookById(id);
    }

    private Book findBookById(int id) {
        // ...
    }
}
```

# JPA

### `@Entity`

Java class that is mapped to a database table

- Must be annotated with `@Entity`
- Must have a `public` or `protected` **no-argument constructor**

### `@Table`

The @Table annotation allows you to specify the details of the table that will be used to persist the entity in the
database.

```java

@Entity
@Table(name = "EMPLOYEE")
public class Employee {
    @Id
    @GeneratedValue
    @Column(name = "id")
    private int id;
}
```

### `@Id`

Indicating the member field below is the primary key of the current entity.

### `@GeneratedValue`

Auto-increment

```java

@Entity
@Table(name = "student")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
}
```

### `@Column`

@Column annotation is used for Adding the column the name in the table of a particular MySQL database.

```java
@Column(name = "DESC", nullable = false, length = 512)
```

### `@Transactional`

Describes a transaction attribute on an individual method or on a class.
When this annotation is declared at the class level, it applies as a default to all methods of the declaring class and
its subclasses. Note that it does not apply to ancestor classes up the class hierarchy; inherited methods need to be
locally redeclared in order to participate in a subclass-level annotation. For details on method visibility constraints,
consult the Transaction Management section of the reference manual.

```java

@Repository
public class StudentDAOImpl implements StudentDAO {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    @Transactional
    public void save(Student student) {
        entityManager.persist(student);
    }
}
```

### `@Repository`

- Specialized annotation for repositories, used for DAO implementation
- Supports component scanning, and Spring will automatically registers DAO implementation
- Translates JDBC exceptions