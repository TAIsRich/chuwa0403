@Configuration: This annotation is used to mark a class as a source of bean definitions in a Spring application context. A class marked with @Configuration typically contains one or more methods annotated with @Bean, which are used to create and configure Spring beans.

@Autowired: This annotation is used to inject dependencies automatically in Spring. When used on a field or a method parameter, Spring will look for a bean that matches the type of the field or parameter and inject it automatically.

@ControllerAdvice: This annotation is used to define a global exception handler for a Spring MVC application. A class annotated with @ControllerAdvice can provide methods to handle exceptions across the whole application.

@Value: This annotation is used to inject a value from a properties file, environment variable, or other external configuration source into a Spring bean.

@NotNull: This annotation is used to ensure that a field is not null. When applied to a method parameter or a field, it tells the Spring container to throw an exception if the value is null.

@Size: This annotation is used to ensure that a field's length is within a specified range. When applied to a method parameter or a field, it tells the Spring container to throw an exception if the length of the value is not within the specified range.

@Min: This annotation is used to ensure that a numeric field's value is greater than or equal to a specified minimum value. When applied to a method parameter or a field, it tells the Spring container to throw an exception if the value is less than the specified minimum.

@Max: This annotation is used to ensure that a numeric field's value is less than or equal to a specified maximum value. When applied to a method parameter or a field, it tells the Spring container to throw an exception if the value is greater than the specified maximum.

@ExceptionHandler: This annotation is used to handle exceptions that occur during the processing of a request in a Spring MVC controller. When an exception occurs, Spring will look for a method annotated with @ExceptionHandler in the controller that can handle the exception.

@Resource: This annotation is used to inject a bean into another component. It can be used to inject a bean by name and can be used in combination with the @Qualifier annotation to specify the desired bean.