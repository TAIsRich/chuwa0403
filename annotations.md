## Annotations
1. @Autowired: Used for automatic dependency injection. This annotation allows Spring to resolve and inject collaborating beans into a bean.

2. @Component: Used to mark a class as a bean so that Spring can manage its lifecycle.

3. @Configuration: Indicates that a class declares one or more @Bean methods and may be processed by the Spring container to generate bean definitions and service requests for those beans at runtime.

4. @Controller: Used to indicate that a class serves the role of a web @Controller. This annotation is used in combination with Spring RequestMapping annotations to map URL requests to the class.

5. @Repository: Used to indicate that a class is a repository, which is meant to provide storage, retrieval, and search behavior for the domain objects managed by the application.

6. @Service: Used to indicate that a class provides a service that other classes may use. This annotation acts as a specialization of the @Component annotation.

7. @RequestMapping: Used to map HTTP requests to handler methods of @Controller classes.

8. @PathVariable: Used to extract values from the URI path and bind them to method parameters.

9. @RequestParam: Used to extract values from the request query string and bind them to method parameters.

10. @ResponseBody: Used to indicate that the return value of a method should be written directly to the HTTP response body, rather than being interpreted as a view name.
    
11. @Entity: Specifies that the class is an entity and is mapped to a database table.
12. @Table: Specifies the table name for the entity class.
13. @Column: Specifies the column name in the table for a particular field or property.
14. @Id: Specifies the primary key for the entity class.
15. @GeneratedValue: Specifies the strategy to generate the primary key value.
16. @OneToMany: Specifies a one-to-many relationship between two entities.
17. @ManyToOne: Specifies a many-to-one relationship between two entities.
18. @JoinColumn: Specifies the foreign key column in a join relationship.
19. @Transactional: Specifies that a method should be executed within a transaction.
20. @Query: Specifies a SQL or JPQL query to retrieve data from the database.
21. @Repository: Specifies that the class is a repository, which is used to access data from the database.
22. @NamedQuery and @NamedQueries : used to define named queries that can be used to retrieve persistent objects from the database.
23. @Transactional is a Spring annotation that is used to manage transactions in a Spring application. When applied to a method or a class, it enables a transaction for the annotated method or class. This annotation takes care of the boilerplate code related to transaction management, such as starting a transaction, committing it, or rolling it back in case of an exception.