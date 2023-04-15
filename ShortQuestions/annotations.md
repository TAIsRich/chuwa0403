# Annotations used by Entity:
## 1. @Entity
```
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(name = "first_name")
    private String firstName;
    
    @Column(name = "last_name")
    private String lastName;
    
    // getters and setters
}
```

## 2. @Id
```
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;
```

## 3. @Column
```
@Column(name = "first_name")
private String firstName;
```

## 4. @RestController
This annotation is used to mark a class as a RESTful controller. 
It combines @Controller and @ResponseBody annotations.
```
@RestController
@RequestMapping("/api/users")
public class UserController {
    @GetMapping("/{id}")
    public User getUserById(@PathVariable Long id) {
        // logic to get user by id
    }
}
```

# Annotations used by Controller:
## 1. @RestController
This annotation is used to mark a class as a RESTful controller. 
It combines @Controller and @ResponseBody annotations.
```
@RestController
@RequestMapping("/api/users")
public class UserController {
    @GetMapping("/{id}")
    public User getUserById(@PathVariable Long id) {
        // logic to get user by id
    }
}
```

## 2. @RequestMapping 
This annotation is used to map HTTP requests to methods in a controller class. 
It can be used to specify the request method, URL, and other properties.
```
@RequestMapping(value = "/{id}", method = RequestMethod.GET)
public User getUserById(@PathVariable Long id) {
    // logic to get user by id
}
```

## 3. @PathVariable 
This annotation is used to bind a path variable in the URL to a method parameter in a controller.
```
@GetMapping("/{id}")
public User getUserById(@PathVariable Long id) {
    // logic to get user by id
}
```

## 4. @RequestParam
This annotation is used to bind a request parameter to a method parameter in a controller.
```
@GetMapping
public List<User> getUsersByFirstName(@RequestParam("firstName") String firstName) {
    // logic to get users by first name
}
```

# Other commonly used annotations:
## 1. @Autowired
This annotation is used to inject a dependency into a bean. 
It tells Spring to find a bean of the specified type and inject it into the annotated field or method.
```
@Autowired
private UserService userService;
```

## 2. @Component 
This annotation is used to mark a class as a Spring bean. It tells Spring to create an instance of this class and manage its lifecycle.
```
@Component
public class UserService {
    // logic to manage user data
}
```

## 3. @Transactional 
This annotation is used to mark a method as transactional. 
It tells Spring to manage transactions for this method and its underlying operations.
```
@Transactional
public void saveUser(User user) {
    userRepository.save(user);
}
```

## 4. @Valid 
This annotation is used to enable validation on a method parameter or return value. It tells Spring to validate the annotated object based on its validation constraints.
```
@PostMapping
public ResponseEntity<?> createUser(@Valid @RequestBody User user) {
    // logic to create a new user
}
```