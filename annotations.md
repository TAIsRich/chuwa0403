## Annotations
1. @Autowired: Used for automatic dependency injection. This annotation allows Spring to resolve and inject collaborating beans into a bean.
2. @Qualifier: This annotation is used in conjunction with @Autowired to specify the specific bean to be injected when multiple beans of the same type are available. It is used to resolve ambiguity when there are multiple beans that match the required type.
3. @Resource: This annotation is used to autowire a bean by name. It can be applied to fields, setters, and methods. It allows you to specify the name of the bean to be injected.
4. @Inject: This annotation is similar to @Autowired and is used to autowire beans by type. It is a standard Java annotation from the javax.inject package and provides a way to achieve dependency injection without relying on Spring-specific annotations.
5. @Value: This annotation is used to inject values from external properties files or configuration into bean fields or methods. It can be used to inject simple values, such as strings or numbers, as well as complex objects.

5. @Component: Used to mark a class as a bean so that Spring can manage its lifecycle.

6. @Configuration: Indicates that a class declares one or more @Bean methods and may be processed by the Spring container to generate bean definitions and service requests for those beans at runtime.

7. @Controller: Used to indicate that a class serves the role of a web @Controller. This annotation is used in combination with Spring RequestMapping annotations to map URL requests to the class.

8. @Repository: Used to indicate that a class is a repository, which is meant to provide storage, retrieval, and search behavior for the domain objects managed by the application.

9. @Service: Used to indicate that a class provides a service that other classes may use. This annotation acts as a specialization of the @Component annotation.

10. @RequestMapping: Used to map HTTP requests to handler methods of @Controller classes.

11. @PathVariable: Used to extract values from the URI path and bind them to method parameters.

12. @RequestParam: Used to extract values from the request query string and bind them to method parameters.

13. @ResponseBody: Used to indicate that the return value of a method should be written directly to the HTTP response body, rather than being interpreted as a view name.
14. @Bean: Used to mark a method in a @Configuration class as a bean definition method. It indicates that the method produces a bean object that should be managed by the Spring container. The method name represents the bean name, and the return type represents the bean type. You can also provide additional attributes to customize the bean, such as scope, initialization, and destruction methods.
15. @Entity: Specifies that the class is an entity and is mapped to a database table.
16. @Table: Specifies the table name for the entity class.
17. @Column: Specifies the column name in the table for a particular field or property.
18. @Id: Specifies the primary key for the entity class.
19. @GeneratedValue: Specifies the strategy to generate the primary key value.
20. @OneToMany: Specifies a one-to-many relationship between two entities.
21. @ManyToOne: Specifies a many-to-one relationship between two entities.
22. @JoinColumn: Specifies the foreign key column in a join relationship.
23. @Transactional: Specifies that a method should be executed within a transaction.
24. @Query: Specifies a SQL or JPQL query to retrieve data from the database.
25. @Repository: Specifies that the class is a repository, which is used to access data from the database.
26. @NamedQuery and @NamedQueries : used to define named queries that can be used to retrieve persistent objects from the database.
27. @Transactional is a Spring annotation that is used to manage transactions in a Spring application. When applied to a method or a class, it enables a transaction for the annotated method or class. This annotation takes care of the boilerplate code related to transaction management, such as starting a transaction, committing it, or rolling it back in case of an exception.
28. @Email annotation validates that the email field is a valid email address.
29. Some common validation annotations provided by Spring include:
30. @NotNull: Ensures that the annotated element is not null.
31. @NotEmpty: Ensures that the annotated string, collection, map, or array is not empty.
32. @NotBlank: Ensures that the annotated string is not null and not empty, ignoring whitespace.
33. @Min: Specifies the minimum value for numeric fields or properties.
34. @Max: Specifies the maximum value for numeric fields or properties.
35. @Size: Specifies the size constraints for string, collection, map, or array fields or properties.
36. @Pattern: Specifies a regular expression pattern that the annotated string must match.
37. @ComponentScan: it is an annotation provided by the Spring framework that is used to configure component scanning in a Spring application.
38. @SpringBootApplication is a convenient annotation provided by the Spring Boot framework. It is a combination of multiple annotations that are commonly used together to bootstrap a Spring Boot application. 