Annotations used by entity:

@Entity: This annotation is used in Java to mark a class as a database table. It allows the class to be mapped to a database table and provides various functionalities such as persistence, queries, and relationships.

@Id: This annotation is used in Java to mark a field as the primary key of a database table.

@Column: This annotation is used in Java to map a class attribute to a database column.

@GeneratedValue: This annotation is used in Java to generate an automatic value for a field marked with @Id.

Annotations used by controller:

@Controller: This annotation is used in Spring MVC to mark a class as a controller. It allows the class to handle incoming HTTP requests and generate HTTP responses.

@RequestMapping: This annotation is used in Spring MVC to map a URL pattern to a method in a controller. It allows the method to handle HTTP requests that match the specified URL pattern.

@RequestBody: This annotation is used in Spring MVC to map the HTTP request body to a method parameter. It allows the method to receive data from the client-side.

@ResponseBody: This annotation is used in Spring MVC to map the method return value to the HTTP response body. It allows the method to send data to the client-side.

@PathVariable: This annotation is used in Spring MVC to map a variable part of a URL to a method parameter. It allows the method to receive dynamic values from the client-side.

Annotations used by dependency injection:

@Autowired: This annotation is used in Spring to inject a bean into a class field, constructor or method.

@Component: This annotation is used in Spring to mark a class as a Spring component. It allows the class to be automatically discovered by Spring's component scanning.

@Qualifier: This annotation is used in Spring to specify which bean to inject when multiple beans of the same type are available.

@Configuration: This annotation is used in Spring to mark a class as a configuration class. It allows the class to define beans and configurations for the Spring application context.