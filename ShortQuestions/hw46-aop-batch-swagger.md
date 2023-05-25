# 1. What is the Aspect Oriented Programming?

Aspect-Oriented Programming (AOP) is a programming paradigm that aims to increase modularity by allowing the separation
of cross-cutting concerns. It does so by adding additional behavior to existing code (an advice) without modifying the
code itself, instead separately specifying which code is modified via a "pointcut" specification, such as "log all
function calls when the function's name begins with 'set'". This allows behaviors that are not central to the business
logic (such as logging, data validation, or security) to be added to a program without cluttering the code that is
central to the business logic.

An aspect can encapsulate behaviors affecting multiple classes into reusable modules. It includes pointcuts (
representing points of interest in the program) and advices (code to be executed when a pointcut is reached).

AspectJ is one of the most known and used languages that support AOP, but AOP concepts can be found in other languages
and frameworks as well, such as Spring AOP in Java.

# 2. What are the advantages and disadvantages of Spring AOP?

Advantages:

* Modularity: Spring AOP helps to modularize cross-cutting concerns in your application, such as logging, security, data
  validation, and transaction management. This can make the code easier to understand and maintain.

* Reusability: Aspects can be defined in one place and automatically applied throughout your codebase, promoting code
  reusability.

* Flexibility: Spring AOP allows you to control where and when aspects are applied using pointcuts and join points. You
  can choose to apply an aspect to all methods in a class, or just certain methods.

* Integration: Spring AOP integrates well with Spring’s other features, such as dependency injection and transaction
  management.

Disadvantages:

* Complexity: While AOP can simplify a codebase by modularizing cross-cutting concerns, it also introduces its own
  complexity. The flow of execution can become harder to follow since aspects are weaved into the existing code at
  runtime, which can make debugging and testing more difficult.

* Performance Overhead: The AOP infrastructure may add some runtime overhead, especially when aspects are applied
  broadly.

* Limited AspectJ Support: Spring AOP does not support all features of AspectJ, as it is a proxy-based system. It only
  supports method execution join points and within certain limits (for example, it does not support constructor and
  field
  interception, and aspects can't be applied to objects not managed by the Spring container).

# 3. What is Aspect in Spring AOP?

An aspect is a cross-cutting module that combines advice and pointcuts. A standard class tagged with the @Aspect
annotation can be used to implement an aspect.

In Spring AOP, an aspect is a modularization of a concern that cuts across multiple classes. It's essentially the
aspect-oriented programming's unit of modularity.

# 4. What is Pointcut in Spring AOP?

In Spring AOP, a pointcut is a set of one or more join points where an advice should be executed. You can specify
pointcuts using expressions or patterns as defined by the AspectJ framework. A pointcut expression is a predicate that
matches join points in the execution of a program. If the evaluation of the pointcut expression is true for a specific
join point, the associated advice will get executed.

# 5. What is the Join point in Spring AOP?

A join point in Spring AOP represents a point in your program's execution where an aspect's advice can be inserted. In
Spring AOP, a join point always represents a method execution.

# 6. What does it mean by Advice and its types in Spring AOP?

In Spring AOP, advice is the code that you want to be executed at a particular join point in your program. It's the
action taken by an aspect at a particular join point. The advice is associated with a pointcut expression and runs at
any join point matched by the pointcut.

There are five types of advice in Spring AOP:

1. Before Advice: This advice runs before a join point, but it cannot prevent the execution flow proceeding to the join
   point (unless it throws an exception).

2. After Returning Advice: This advice runs after a join point completes normally, for example, if a method returns
   without
   throwing an exception.

3. After Throwing Advice: This advice runs after a method exits by throwing an exception.

4. After (finally) Advice: This advice runs regardless of the means by which a join point exits (normal or exceptional
   return).
5. Around Advice: This is the most powerful kind of advice. It runs before and after the method invocation. It is
   responsible for deciding whether and when to proceed with the join point and to execute the method being called.
   Around
   advice can also alter the result of the method execution. It is combined concept of before, after returning and
   after
   throwing advices.

# 7. When to use Spring Batch?

Spring Batch is a lightweight, comprehensive framework designed to enable the development of robust batch applications.
It is typically used when you need to process large amounts of data—such as records from a database, a CSV file, or a
web service—and when you need to perform complex processing and transformation on the data.

Use cases for Spring Batch include:

* Bulk data processing: This could include import/export operations from databases, data migration between different
  systems, or transforming data from one format to another.
* Complex data processing: If your application needs to perform complex calculations, transformations, or validations on
  your data, Spring Batch is a good choice.
* Scheduled processing: Spring Batch is ideal for jobs that need to be run on a schedule, such as nightly or weekly
  processes.

# 8. How Spring Batch works?

Spring Batch processes data in chunks. Each chunk is read, processed, and written as part of a single transaction,
making the process reliable and consistent.

Here are the key components of a Spring Batch job:

* Job: A job is an entity that encapsulates an entire batch process. A job contains one or more steps.
* Step: A step is a domain object that encapsulates an independent, specific phase of a batch job, such as reading from
  a database, processing the data, or writing it back to the database. Each step contains a single ItemReader,
  ItemProcessor, and ItemWriter.
* ItemReader: The ItemReader reads data into the Spring Batch application from a particular technology, such as a
  database or a CSV file.
* ItemProcessor: Once data is read into the application, the ItemProcessor transforms it in some manner.
* ItemWriter: After the ItemProcessor transforms the data, the ItemWriter writes it back out to a technology, such as a
  database or a CSV file.
* JobLauncher: JobLauncher is an interface that controls the execution of a Job.

# 9. How can we schedule a Spring Batch Job?

Spring Batch Jobs can be scheduled to run at specific times by using Spring's scheduling capabilities or an external
system like **Quartz** or **cron**. Here's a simple way to schedule a job using Spring's built-in @Scheduled annotation.

```java

@Configuration
@EnableScheduling
public class MyJobConfiguration {
    @Autowired
    JobLauncher jobLauncher;

    @Autowired
    Job job;

    @Scheduled(cron = "0 0 1 * * ?") // This means the job will run at 1 am every day
    public void executeJob() {
        try {
            JobParameters jobParameters = new JobParametersBuilder()
                    .addLong("time", System.currentTimeMillis())
                    .toJobParameters();
            jobLauncher.run(job, jobParameters);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

```

# 10. What is the cron expression?

Cron expressions are string representations used to define a schedule in time-based job-scheduling formats, notably in
Unix cron jobs and in the Quartz scheduler, among others.

A cron expression is a string of fields, separated by whitespace. Each field represents a time unit, and the expression
as a whole represents a schedule. For example, the cron expression **0 0 * * *** runs a job every hour, on the hour,
every
day.
The fields in a cron expression, from left to right, are as follows:

* Seconds (0 - 59)
* Minutes (0 - 59)
* Hours (0 - 23)
* Day of month (1 - 31)
* Month (1 - 12)
* Day of week (0 - 7) (where both 0 and 7 mean "Sunday")

# 11. What is the spring task?

Spring Task is a part of the Spring Framework that provides support for task scheduling, including features such as
method invocation timing and job scheduling. This is done through the TaskScheduler and TaskExecutor abstractions.

The `TaskScheduler` provides methods for scheduling tasks to run at fixed intervals or on cron-based schedules.

The `TaskExecutor` is an abstraction around task execution mechanisms. While it does not provide scheduling
functionality,
it does provide a simple method for executing tasks concurrently, allowing developers to control the threading details.

# 12. When to use Spring task?

Spring Task should be used when you need to handle asynchronous execution or schedule tasks to be executed at specific
times or intervals. Some use cases include:

* Running long tasks in the background: This could be tasks such as generating reports, sending emails, or any other
  task
  that could take a significant amount of time to complete.
* Scheduling tasks: This could be tasks that need to be done at regular intervals, such as cleaning up old data every
  night, sending weekly emails, or any other task that needs to be done on a schedule.
* Executing multiple tasks in parallel: If you have multiple tasks that can be executed independently, using
  TaskExecutor
  can help to execute them in parallel, potentially speeding up the overall execution time.

You should not use Spring Task for tasks that need advanced scheduling features such as persistent jobs (jobs that are
stored and survive restarts), clustering (running tasks on a cluster of machines), and complex cron expressions, which
would require a more feature-rich scheduling system like Quartz.

# 13. What is Filter and any filter example?

A filter in the context of web development is an object that can intercept HTTP requests/responses and perform specific
tasks such as logging, transforming request/response data, or authentication. The filters are defined and mapped to
specific URLs or URL patterns in the application's web descriptor file (web.xml) or via annotations in the case of
Spring Boot applications.

Here's an example of a simple logging filter in a Spring Boot application:

```java
import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@Component
@Order(1)
public class LoggingFilter implements Filter {

    @Override
    public void doFilter(
            ServletRequest request,
            ServletResponse response,
            FilterChain chain) throws IOException, ServletException {

        HttpServletRequest req = (HttpServletRequest) request;
        System.out.println("Request URI is: " + req.getRequestURI());

        chain.doFilter(request, response);
    }

    // other methods
}

@Configuration
public class FilterConfig {
    @Bean
    public FilterRegistrationBean<LoggingFilter> loggingFilter() {
        FilterRegistrationBean<LoggingFilter> registrationBean = new FilterRegistrationBean<>();

        registrationBean.setFilter(new LoggingFilter());
        registrationBean.addUrlPatterns("/*");

        return registrationBean;
    }
}
```

# 14. What is the Interceptor? What we can do with interceptor?

Filters and Interceptors in Spring Boot both serve similar purposes, that is, they are used to perform certain actions
before or after web requests. However, they are applied at different points in the Spring MVC framework and, therefore,
are used in different situations.

Use a Filter when:

* You need to process every request: Filters are applied before Spring's `DispatcherServlet` processes the request. This
  means that they are applied to every incoming request, even if they are not handled by Spring MVC.

* You need to manipulate the request or response: Filters have access to the raw HttpServletRequest and
  HttpServletResponse. This means you can manipulate the request and response, such as modifying headers or the body
  content.

* You need to perform functionality not related to Spring MVC: For instance, if you want to log request parameters and
  headers or handle authentication, then using a Filter would be the most suitable option.
  Use an Interceptor when:

Use interceptor:

* You need to execute something in the context of Spring MVC: Interceptors are tied to the Spring MVC framework, and
  therefore, have more awareness of the Spring context. If you need to use Spring Beans or other Spring-specific
  functionality, an Interceptor would be a better fit.

* You want to execute actions pre and post Controller execution: Interceptors have methods that execute before the
  request is handed over to the controller (preHandle()), after the controller execution and before the view is
  rendered (postHandle()), and after the complete request has finished (afterCompletion()). This provides more control
  over when the interceptor's logic is applied.

* You want to apply specific behavior to specific handler methods or classes: With Interceptors, you have more
  fine-grained control over which handler methods they apply to. You can specify an Interceptor to apply only to certain
  URLs or even certain methods within your controllers.

Examples of Using Filters:

* Authentication and Authorization: A filter can check if a user is authenticated (logged in) and if they have the right
  permissions to access the requested resource. If not, the filter can redirect the user to a login page.

* Logging and Auditing: A filter can log details about incoming requests and outgoing responses, such as the client's IP
  address, the timestamps, the URLs accessed, and so on. This information can be used for auditing purposes.

* Modifying Request and Response: Filters have the ability to modify the request and response objects. For example, a
  filter can add, modify or remove headers or parameters from the request or response.

Examples of Using Interceptors:

* Locale and Theme Changes: An interceptor can detect if the user has requested a locale or theme change (typically
  through a specific request parameter), and update the user's locale or theme accordingly.

* Performance Monitoring: An interceptor can record the time before a request is processed and the time after a request
  is processed to determine how long the processing took.

* Modifying ModelAndView: An interceptor can add common model data to all requests, so you don't need to do it in each
  controller method.

# 15. In Interceptor, What is preHandle? What is postHandle?

In a Spring MVC HandlerInterceptor, preHandle, postHandle, and afterCompletion are the three main methods that you can
override to control the request handling process:

* preHandle: This method is executed before the actual handler (controller method) is executed. This method can be used
  to add attributes to the model, log information, etc. You can also interrupt the execution chain by returning false
  from this method, which means the handler (and other interceptors/postHandle/afterCompletion methods) won't be
  executed.

* postHandle: This method is executed after the handler is executed and before the view is rendered. You can add or
  change the model attributes here that will then be available on the view.

* afterCompletion: This method is executed after the view is rendered. This is mainly used for cleanup resources.

# 16. What is Swagger?

Swagger is an open-source tool used for designing, building, and documenting RESTful APIs. It provides a wide range of
features to help you develop APIs and integrate them into your software development lifecycle. The Swagger specification
is language-agnostic and is extendable into virtually any programming language.

Key components of Swagger include:

* Swagger Editor: An open-source editor to design, define and document RESTful APIs in the Swagger Specification.
* Swagger UI: A tool to visualize and test the APIs defined with Swagger. It takes the specification and displays it as
  an interactive HTML page where you can explore and test the API's endpoints without implementing the client.
* Swagger Codegen: It allows generating the client library code needed for implementations on the server side and client
  side.
