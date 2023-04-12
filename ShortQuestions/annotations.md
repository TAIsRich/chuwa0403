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

