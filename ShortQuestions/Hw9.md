# Homework 9
## 1.

## 2. what is the @configuration and @bean?
@configuration indicates that the class declares one or more @Bean methods and may be processed by the Spring container to generate bean definitions and service requests
for beans at runtime. (a class level annotation)

@bean indicates that a method returns a bean to be managed by Spring context

## 3. How do you handle the exception in Spring?

1. create error/exception details class, use ```@ResponseStatus(value = HttpStatus.NOT_FOUND)```;
2. create global exception handler class, annotate the class with @ControllerAdvice and mark the exception handler method with 
@ExceptionHandler(ResourceNotFoundException.class).

## 4. How do you do the validations in Spring? And list some validation annotaitons you know.
Validation is used to validate the request body.

1. Add validation rule to payload properties; e.g. ```@NotEmpty, @Size(min = 10, message = "at least 2")```
2. Add @Valid to the Controller methods parameters; e.g. ```public ResponseEntity<> post(@Valid @RequestParameters PostDto postDto)```

Customize validation, same with exception handling. Add ```@ExceptionHandler(MethodArgumentNotValidException.class)``` to handler methods and add ```@ControllerAdvice``` to the class
```
@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(MethodArgumentNotValidException.class)
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
                                                                 HttpHeaders headers,
                                                                 HttpStatus status,
                                                                 WebRequest request) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String message = error.getDefaultMessage();
            errors.put(fieldName, message);
        });
        return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
    }
}
```
## 5. What is the actuator?
An actuator is a manufacturing term that refers to a mechanical device for moving or controlling something. Actuators can generate a large amount of motion from a small change.

Use /acuator/health to check the health of application.
