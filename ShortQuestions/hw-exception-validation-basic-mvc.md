# 1.  List all of the annotations you learned from class and homework to annotations.md
## annotations.md
# 2.  what is the @configuration and @bean?
## Annotating a class with the @Configuration indicates that the class can be used by the Spring IoC container as a source of bean definitions. The @Bean annotation tells Spring that a method annotated with @Bean will return an object that should be registered as a bean in the Spring application context.
# 3.  How do you handle the exception in Spring?
## we can define a method in @Controller class and use the annotation @ExceptionHandler on it. Spring configuration will detect this annotation and register the method as an exception handler for the argument exception class and its subclasses.
# 4.  How do you do the validations in Spring? And list some validation annotations you know.
## @NotNull, @NotEmpty, @NotBlank.
# 5.  What is the actuator?
## Actuator is mainly used to expose operational information about the running application.

# 1.  List all of the annotations you learned from class and homework to annotations.md
## annotations.md
# 2.  What is Spring and Springboot? What is the benfits of using Srpingboot?
## Spring is a lightweight application framework. Spring Boot makes it easy to create stand-alone, production-grade Spring based Applications. 
# 3.  What is IOC and What is DI?
## Inversion of control (IOC) talks about who is going to initiate the call to dependent object where as the Dependency Injection (DI) talks about how one object can acquire dependency.
# 4.  What is @CompnonentScan?
## we use the @ComponentScan annotation along with the @Configuration annotation to specify the packages that we want to be scanned. @ComponentScan without arguments tells Spring to scan the current package and all of its sub-packages.
# 5.  How to define which package spring need to scan in xml and annotaiton?
```
@ComponentScan(basePackages = "XXXX.XXXX")
```
```
<beans ...>          
     <context:component-scan base-package="XXXXX.XXXXX"
                             scoped-proxy="XXXXXXXX" />
</beans>
```
# 6.  What is  @SpringbootApplication?
## Spring Boot @SpringBootApplication annotation is used to mark a configuration class that declares one or more @Bean methods and also triggers auto-configuration and component scanning. It's same as declaring a class with @Configuration, @EnableAutoConfiguration and @ComponentScan annotations.
# 7. How many ways wo can define a bean?
## Annotations and xml file.
# 8.  What is default bean name for  @Component and  @Bean?
## class name or the method name.
# 9.  What is the difference between  @component and  @service,@repository?
## @Component is a generic stereotype for any Spring-managed component. @Service annotates classes at the service layer. @Repository annotates classes at the persistence layer, which will act as a database repository
# 10. How many annotations we can use to inject the bean?
## @Autowired, @Qualifier, @Inject, and @Resource
# 11. Tell me the three types to do dependency injection(How can we inject the beans in Spring)? Which way is better and why?
## Constructor Injection, Setter Injection, and  Field Injection
# 12. If we have multiple beans for one type, how to set one is primary? and how to let the spring to pick one bean to inject if no primary.
## @Primary to set the primary bean.
# 13. What is the difference between BeanFactory and ApplicationContext in Spring?
## BeanFactory is lightweight as compared to ApplicationContext.
# 14. What is the Scope of a Bean?  and list the examples for each scope.
## Singleton, Prototype.
# 15. Configure a bean using xml. If bean has parameters/dependencies, how can we configure the bean? 
```
<bean id="XXX" class="XXX">
    <property name="XXX"/>
</bean>
```
```
<bean id="XXX" class="XXX">
    <constructor-arg index="XXX" ref="XXX"/>
</bean>
```

# 1.  List all of the annotations you learned from class and homework to annotaitons.md
## 
# 2.  What is MVC pattern?
## MVC Pattern stands for Model-View-Controller Pattern. This pattern is used to separate application's concerns.
# 3.  What is Front-Controller?
## A Front Controller is a typical structure in web applications that receives requests and delegates their processing to other components in the application.
# 4.  What is DispatcherServlet? please describe how it works.
## it takes the incoming request, and delegates processing of that request to one of a number of handlers. 
# 5.  What is JSP and What is ModelAndView？(please google to have a basic knowlege)
## Jakarta Server Pages (formerly JavaServer Pages) is a Java standard technology that developers use to write dynamic, data-driven web pages for Java web applications. ModelAndView is a value object designed to hold model and view making it possible for a handler to return both model and view in a single return value.
# 6.  Could you please google any other servlets
## ServletRequest, HttpServlet, and GenericServlet.
# 7. How many web server do you know? (Tomcat, Jetty, Jboss)
## Tomcat is an open source web server developed by the Apache Software Foundation. It is a popular choice for web applications due to its scalability, reliability, and performance. Tomcat is a Java servlet container and web server that provides a platform for Java-based web applications.
# 8.  clone this repo, and run it in you local.