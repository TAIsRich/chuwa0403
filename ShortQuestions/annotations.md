# Springboot Annotations
## Spring Core related Annotations
### @Bean
To declare a bean, simply annotate a method with the @Bean annotation. When JavaConfig encounters such a method, it will execute that method and register the return value as a bean within a BeanFactory.
By default, the bean name will be the same as the method name.

### @Configuration
Annotating a class with the @Configuration indicates that the class may be used by JavaConfig as a source of bean definitions. 
```
@Configuration
public class AppConfig {
    @Bean
    public TransferService transferService() {
        return new TransferServiceImpl();
    }
}
```

### @Scope
@Scope indicates the name of a scope to use for instances of the annotated type.

### @Autowired
@Autowired indicates Bean needs to be automatically created by Spring Container.
```
public class TextEditor {
   private SpellChecker spellChecker;

   @Autowired
   public void setSpellChecker( SpellChecker spellChecker ){
      this.spellChecker = spellChecker;
   }
}
```

### @Component
@Component is a class-level annotation. It is used to denote a class as a Component. We can use @Component across the application to mark the beans as Spring’s managed components. A component is responsible for some operations. 

### @Service
specify a class with @Service to indicate that they’re holding the business logic.

### @Repository
@Repository indicates that they’re dealing with CRUD operations, usually, it’s used with DAO (Data Access Object) or Repository implementations that deal with database tables. Components in Repository Layer need to be annotated with @Repository.

### @Controller
@Controller indicate that they’re front controllers and responsible to handle user requests and return the appropriate response. It is mostly used with REST Web Services.
```
@Component
 
// Class
public class ComponentDemo {
 
    // Method
    public void demoFunction()
    {
    }
}
```

## Rest API related annotations
### @RestController
Class annotated with @RestController exposes REST End points
```
@RestController
class EmployeeController{
    @GetMapping("/allemployees")
    List<Employee> getEmployees(){
        //return List of Employees
    }
    //More REST end points can be exposed
}
```

### @RequestBody
@RequestBody used with method parameter of REST end point. This annotation automatically deserializes the body(of Http request) into a Model or Entity object.
```
@RestController
class EmployeeController{
    @PostMapping("/create")
    ResponseEntity<Employee> createEmployee(@RequestBody Employee emp){
        //code to save emp object in DB
    }
    //other REST end points
}
```

### @PathVariable
@PathVariable indicates that a method parameter should be bound to a URI template variable. used with method parameter of REST end point. It automatically retrieves a Path variable into the method parameter of REST end point.
```
@RestController
class EmployeeController{
    @GetMapping("/employee/{eid}")
    Employee getEmployee(@PathVariable("eid") Integer empid){
        //code to fetch Employee from DB
    }
    //other REST end points
}
```

### @RequestParam
@RequestParam indicates that a method parameter should be bound to a web request parameter. used with method parameter of REST end point. It automatically retrieves a Query parameter into the method parameter of REST end point.
```
@RestController
class EmployeeController{
    @GetMapping(“/emp”)
    Employee getEmployee(@RequestParam Integer empid){
        //code to fetch Employee from DB
    }
    //other REST end points
}
```

###  @RequestHeader
@RequestHeader used with method parameter of REST end point. It automatically retrieved value from a specified HTTP header and populates the value into the method parameter.

```
@GetMapping("/greeting")
public ResponseEntity<String> greeting(@RequestHeader(HttpHeaders.ACCEPT_LANGUAGE) String language) {
    // code that uses the language variable
    return new ResponseEntity<String>(greeting, HttpStatus.OK);
}
```

### @RequestMapping, @GetMapping, @PostMapping, @PutMapping, @DeleteMapping
REST End points are annotated with these annotation, to indicate specific HTTP method. 

## Spring Boot Data JPA related annotations:
### @Entity
@Entity — class which need to be mapped with underlying DB Table
### @Table
@Table — Used along with @Entity annotated, to specify custom name for DB Table(by default DB Table has same name as Entity Class name)
### @Column
@Column — Used with Data members of Entity class, to indicate a Column of DB Table.

### Validation related
Data field Validation related — @NotNull, @Max, @Min, @Positive, @Negative, etc…
### @Query
@Query — to specify Custom Query String(native or JPQL query), along with method declaration in Repository interface.

### Entity class relationships
Entity class relationships — @OnetoOne, @OnetoMany, @ManytoOne, @ManytoMany
