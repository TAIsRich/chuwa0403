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