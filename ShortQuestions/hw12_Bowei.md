## 1. List all of the new learned annotations to your annotations.md

1. @RunWith: @RunWith is an annotation used in JUnit to specify a custom test runner for executing test cases. It allows you to extend or customize the behavior of the test execution environment. In JUnit 4, the @RunWith annotation is used at the class level to indicate the test runner that should be used to run the test class. The test runner is responsible for executing the test methods and providing various test-related functionalities.

2. @PrepareForTest: @PrepareForTest is an annotation used in conjunction with the PowerMock framework to prepare classes and methods for testing with features such as mocking static methods, final classes, or private methods. PowerMock is a framework that extends the capabilities of popular testing frameworks like JUnit and Mockito. It allows you to mock static methods, final classes, private methods, constructors, and other elements that are typically difficult to test or modify with traditional mocking frameworks. The @PrepareForTest annotation is used to specify the classes or methods that need to be prepared for testing with PowerMock. It instructs PowerMock to modify the bytecode of the specified classes or methods during test execution, enabling mocking or modification of usually unmodifiable elements.

```java
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

@RunWith(PowerMockRunner.class)
@PrepareForTest({ClassToPrepare.class, AnotherClassToPrepare.class})
public class MyTestClass {

    @Test
    public void testMethod() throws Exception {
        // Test method code using PowerMockito features
        PowerMockito.mockStatic(ClassToPrepare.class);
        PowerMockito.when(ClassToPrepare.staticMethod()).thenReturn("mocked result");
    }
}
```

3. @Mockbean: The @MockBean annotation is part of the Spring Boot Testing framework and is used for mocking beans in the Spring application context during integration testing. Integration testing involves testing the interaction between different components of an application, including the Spring beans. In such tests, you may want to replace certain beans with mock objects to isolate and control the behavior of specific components. The @MockBean annotation allows you to create a mock object and replace an existing bean with the mock version in the Spring application context. This enables  you to test the behavior of other components that depend on the mocked bean.

```java
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

@SpringBootTest
public class MyIntegrationTest {

    @Autowired
    private MyService myService;

    @MockBean
    private MyDependency myDependency;

    @Test
    public void testMethod() {
        // Mock behavior of the myDependency bean
        Mockito.when(myDependency.someMethod()).thenReturn("mocked result");

        // Test the behavior of myService that depends on myDependency
        String result = myService.doSomething();

        // Assert the result
        // ...
    }
}
```

4. @MockMvc: The @MockMvc annotation is used in Spring MVC tests to mock the behavior of the web server and simulate HTTP requests and responses for testing Spring MVC controllers. Spring MVC is a framework for building web applications in the Spring ecosystem. To test the controllers and their interactions with HTTP requests and responses, the MockMvc class is used along with the @MockMvc annotation. By using @MockMvc, you can create a mock environment that simulates the behavior of a web server without actually starting it. This allows you to test your controller logic, request mappings, and other aspects of your web application in a controlled and isolated manner.

5. @Mock: The @Mock annotation is used in testing frameworks like Mockito to create mock objects. Mock objects are simulated objects that mimic the behavior of real objects in a controlled manner. They are commonly used in unit testing to isolate the code being tested and focus on specific components or interactions. When you annotate a field or a method parameter with @Mock, Mockito creates a mock object of the specified class or interface. The mock object behaves as if it were a real object but without the actual implementation logic.

6. @Spy: The @Spy annotation is used in testing frameworks like Mockito to create spy objects. A spy object is a partial mock object that wraps an existing instance of a class. It retains the original behavior of the object but also allows you to stub or verify specific methods as needed.

7. @InjectMocks: The @InjectMocks annotation is used in testing frameworks like Mockito to inject mock objects into the fields of the target class being tested. When writing unit tests, you often need to instantiate the class under test and provide mock objects for its dependencies. The @InjectMocks annotation simplifies this process by automatically injecting the mock objects into the appropriate fields of the target class.

8. @DataJpaTest: The @DataJpaTest annotation is used in Spring Boot for integration testing of JPA repositories. It provides a convenient way to test the persistence layer of your application by automatically configuring an in-memory database, setting up the Spring Data JPA infrastructure, and creating a test-specific application context.
When you annotate a test class with @DataJpaTest, it will: Configure an in-memory database (H2 by default) or connect to a real database depending on the configuration. Set up the necessary Spring Data JPA infrastructure, including the EntityManager, EntityManagerFactory, and transaction management. Scan for and configure only the relevant Spring beans, such as repositories, entities, and data access components. Rollback database transactions after each test method by default, ensuring a clean state for subsequent tests.

```java
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.TestPropertySource;

import static org.assertj.core.api.Assertions.*;

@DataJpaTest
@TestPropertySource(properties = {
    "spring.datasource.url=jdbc:h2:mem:testdb"
})
public class UserRepositoryIntegrationTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private UserRepository userRepository;

    @Test
    public void testFindByName() {
        // Given
        User user = new User("John Doe");
        entityManager.persist(user);
        entityManager.flush();

        // When
        User foundUser = userRepository.findByName("John Doe");

        // Then
        assertThat(foundUser).isEqualTo(user);
    }
}
```

## 2. what is selenium(YouTube)?

Selenium is a popular open-source testing framework used for automating web application testing. It provides a set of tools and libraries that enable developers and testers to automate browser interactions and validate the functionality of web applications. With Selenium, you can write test scripts in various programming languages such as Java, Python, C#, Ruby, and JavaScript. These scripts can simulate user actions, interact with web elements, navigate through different pages, fill out forms, and verify the expected behavior of the application. Selenium supports multiple web browsers like Chrome, Firefox, Safari, and Internet Explorer, allowing you to run tests across different browsers to ensure cross-browser compatibility. It is a user-behavior simulation.

Key features of Selenium:
1. WebDriver: This component provides a programming interface to interact with web browsers, allowing you to automate browser actions like clicking buttons, entering text, and validating page content.
2. Cross-browser Testing: Selenium supports multiple browsers, enabling you to write tests once and run them across different browsers to ensure consistent behavior.
3. Test Framework Integration: Selenium integrates well with popular testing frameworks such as JUnit and TestNG, providing advanced features like test reporting, test management, and test parallelization.
4. Selenium Grid: It allows you to distribute test execution across multiple machines and browsers, enabling parallel testing and reducing test execution time.

## 3. What is cucumber?

Cucumber is an open-source behavior-driven development (BDD) tool that helps bridge the gap between technical and non-technical stakeholders in software development projects. It provides a framework for creating and executing automated tests in a human-readable format. Cucumber allows collaboration between developers, testers, and business stakeholders by using a plain-text format known as Gherkin. Gherkin is a business-readable domain-specific language (DSL) that describes the behavior of the software in a structured manner. It uses keywords like Given, When, and Then to define the steps of a scenario or test case. Cucumber follows the principles of BDD, which emphasizes communication and collaboration between team members to drive the development process. With Cucumber, stakeholders can write and review Gherkin feature files that describe the desired behavior of the software. These feature files serve as a single source of truth and are used to generate executable test cases. Cucumber supports integration with various programming languages, including Java, Ruby, Python, and JavaScript, allowing developers to write step definitions that map to the Gherkin steps defined in the feature files. Step definitions are the code implementations that execute the desired actions for each step of the scenario.

## 4. what is JMeter?

Apache JMeter is an open-source software tool designed for load testing, performance testing, and functional testing of applications. It is widely used for measuring the performance and analyzing the behavior of a variety of services, including web applications, databases, web services, and FTP servers. JMeter allows you to simulate a heavy load on a target system to evaluate its performance under various scenarios. It generates multiple virtual users, known as threads, to simulate concurrent user activity. These threads send requests to the target system, allowing you to measure its response time, throughput, and resource usage.

Key features of JMeter:
1. Test Plan: JMeter organizes tests in a hierarchical structure called a Test Plan. It allows you to define test scenarios, configure thread groups, set up samplers for sending requests, add assertions for validating responses, and specify listeners for collecting test results.
2. Samplers: JMeter supports various samplers that can simulate different types of requests, such as HTTP requests, FTP requests, JDBC database queries, SOAP requests, and more. These samplers allow you to mimic real user interactions with the system under test.
3. Assertions: JMeter provides assertions to validate the responses received from the target system. You can define assertions to check response codes, response data, or specific patterns within the response.
4. Listeners: JMeter offers a range of listeners to collect and analyze test results. These listeners generate graphical and tabular reports, including response times, error rates, throughput, and other performance metrics.
5. Distributed Testing: JMeter supports distributed testing, allowing you to run tests on multiple machines to generate a higher load and distribute the workload. This helps simulate realistic scenarios and measure system performance under heavy loads.

## 5. what is unit-test?

A unit test is a type of software testing that focuses on verifying the correctness and functionality of individual units or components of a software system. The purpose of unit testing is to isolate and test the smallest testable parts, typically individual functions or methods, in order to ensure that each unit performs as expected. Unit tests are typically written by developers and are executed during the development process to catch and fix bugs early. They are usually automated, meaning they are written as code and executed using testing frameworks or tools.

Key characteristics and benefits of unit test:
1. Isolation: Unit tests are designed to test a specific unit in isolation from the rest of the system. Dependencies of the unit under test are often replaced or mocked to ensure that the focus is solely on the behavior of that unit.
2. Atomicity: Unit tests are small and focused on a specific behavior of a unit. They should be independent of each other, allowing them to be executed individually or as a group.
3. Fast Execution: Unit tests are typically fast to execute, allowing developers to run them frequently and get quick feedback on the correctness of their code.
4. Regression Testing: Unit tests provide a safety net by catching bugs and regressions as changes are made to the codebase. Running unit tests after making changes helps ensure that existing functionality has not been inadvertently broken.
5. Documentation: Unit tests serve as executable documentation, providing examples and illustrating how a particular unit should be used and behave.
6. Refactoring Support: Unit tests provide confidence when refactoring code by ensuring that the desired functionality is maintained even after making changes.

## 6. What is the lifecyle of Junit?

The lifecycle of JUnit refers to the sequence of events and phases that occur when executing JUnit tests. The following are the typical stages of the JUnit test lifecycle:

1. Test Class Initialization: JUnit creates an instance of the test class. It scans the class for test methods annotated with @Test and other relevant annotations.
2. Test Setup: JUnit invokes the method annotated with @BeforeClass once before any test method in the class. This method is used for setting up any shared resources or expensive operations needed for the entire test class.
3. Test Method Initialization: JUnit creates an instance of the test class for each test method. It invokes the method annotated with @Before before each test method. This method is used for setting up any preconditions or initializing test-specific resources.
4. Test Execution: JUnit executes each test method annotated with @Test individually.
It captures the test results, including assertions and any thrown exceptions.
5. Test Teardown: JUnit invokes the method annotated with @After after each test method. This method is used for cleaning up resources or performing any necessary post-test actions.
6. Test Class Teardown: JUnit invokes the method annotated with @AfterClass once after all test methods in the class have been executed. This method is used for cleaning up shared resources or performing any final actions.

## 7. Is @BeforeAll method should be Class level(static)?

Yes. @BeforeAll method shouldu be Class level(static).

## 8. What is Mockito? and what is its limitations?

Mockito is a popular open-source mocking framework for Java that allows developers to create mock objects and stub their behavior during unit testing. It simplifies the process of creating mock dependencies, defining their behavior, and verifying interactions with those dependencies.

Here are some key features and benefits of Mockito:

1. Mocking: Mockito provides mechanisms to create mock objects that simulate the behavior of real objects in a controlled manner. Mock objects are used to replace dependencies of the class under test, enabling isolated testing of specific units.
2. Stubbing: With Mockito, you can define the behavior of mock objects by specifying return values or exceptions for specific method calls. This allows you to simulate different scenarios and test edge cases without relying on real implementations.
3. Verification: Mockito offers powerful verification capabilities to verify interactions between the class under test and its dependencies. You can check if specific methods were called, how many times they were called, and with what arguments.
4. Annotation Support: Mockito supports annotations like @Mock, @Spy, and @InjectMocks to simplify the creation and injection of mock objects in test classes.
5. Clear and Readable Syntax: Mockito provides a clean and readable syntax, making the test code more expressive and easier to understand.

Despite its many advantages, Mockito has some limitations:

1. Final Classes and Methods: Mockito cannot mock final classes and methods since it uses dynamic proxies and bytecode manipulation, which are not compatible with final elements. However, there are workarounds available, such as using Mockito extensions like Mockito-inline or Mockito with PowerMock.
2. Static Methods: Mockito cannot directly mock static methods because it relies on instance-based mocking. To mock static methods, you can use additional libraries like PowerMock or consider refactoring your code to make it more testable.
3. Final Fields: Mockito cannot directly mock final fields. If a class under test has final fields, you may need to use reflection or other techniques to modify the field's value for testing purposes.
4. Internal Method Calls: Mockito cannot directly mock internal method calls within the same object. It can only mock external dependencies. If you need to mock internal calls, you may need to refactor your code or use different techniques like partial mocking.
5. Limited Support for Some Complex Scenarios: Mockito may have limited support for certain complex scenarios, such as mocking static initializers, private constructors, or classes that heavily rely on internal state or static state. In such cases, additional libraries or techniques may be required.

## 9. What is @Mock and what is @InjectMocks?

1. @Mock:

The @Mock annotation is used to create mock objects of dependencies in a test class. By annotating a field with @Mock, Mockito automatically creates a mock object for the corresponding type. Mock objects created with @Mock can be stubbed to define their behavior and used to verify interactions during testing. The mock objects are typically injected into the class under test using either @InjectMocks or manually using setter or constructor injection.

2. @InjectMocks:

The @InjectMocks annotation is used to inject mock objects into a test class. It works in conjunction with the @Mock annotation by automatically injecting the mock objects into the class under test. The injection is performed based on the type of the mock objects and the target class fields or constructor parameters. @InjectMocks can be used when the class under test has dependencies that are mocked using @Mock.

```java
import org.mockito.InjectMocks;
import org.mockito.Mock;

public class MyTestClass {

    @Mock
    private MyDependency myDependency; // Mock object

    @InjectMocks
    private MyClass myClass; // Injecting the mock object into MyClass

}

```
## 10. What is the stubbing?

Stubbing, in the context of software testing, refers to the process of defining the behavior or response of a mock object or dependency during test execution. When stubbing, you set up the expected return values or exceptions that should occur when specific methods of the mock object are called.

Here are some key points about stubbing:

1. Creating Expectations: During stubbing, you define the expected behavior of the mock object for a specific method or set of inputs. This includes specifying the return value that the method should provide or the exception that should be thrown.
2. Controlling Behavior: By stubbing the mock object, you gain control over its behavior in different test scenarios. You can simulate different outcomes, edge cases, or error conditions to thoroughly test the behavior of the class under test.
3. Isolating Dependencies: Stubbing helps isolate the class under test by replacing its dependencies with mock objects. This allows you to focus on testing the specific functionality of the class without relying on the behavior of external components.
4. Defining Test Cases: Stubbing plays a crucial role in defining test cases by setting up the expected behavior of dependencies. It allows you to simulate various scenarios and ensure that the class under test interacts correctly with its dependencies.

```java
import org.mockito.Mock;
import static org.mockito.Mockito.when;

public class MyTestClass {

    @Mock
    private MyDependency myDependency; // Mock object created for MyDependency

    public void testMethod() {
        // Stubbing the behavior of the mock object
        when(myDependency.doSomething()).thenReturn("mocked result");

    }
}
```

## 11. What is Mockito ArgumentMatchers?

Mockito ArgumentMatchers are utility methods provided by the Mockito framework to simplify the matching of method arguments when stubbing or verifying interactions with mock objects. ArgumentMatchers help define flexible matching criteria for method parameters, allowing you to specify different argument values or conditions.

Mockito provides a range of ArgumentMatchers that can be used to match method arguments. Some commonly used ArgumentMatchers include:

1. any(): Matches any value of the expected parameter type. For example, any(String.class) matches any string argument.
2. eq(value): Matches the exact value of the expected parameter. For example, eq(42) matches the integer argument with the value 42.
3. isNull(): Matches null arguments.
4. isNotNull(): Matches non-null arguments.
5. anyXxx(): Matches specific types of arguments, such as anyInt(), anyString(), anyBoolean(), etc.
6. argThat(matcher): Matches arguments based on a custom matcher defined by the user. The matcher parameter is an instance of org.hamcrest.Matcher or a lambda expression.

```java
import org.mockito.Mock;
import static org.mockito.Mockito.when;
import static org.mockito.ArgumentMatchers.*;

public class MyTestClass {

    @Mock
    private MyDependency myDependency; // Mock object created for MyDependency

    public void testMethod() {
        // Stubbing the behavior of the mock object with ArgumentMatchers
        when(myDependency.doSomething(anyString(), anyInt())).thenReturn("mocked result");

    }
}
```

## 12. what is Hamcrest Matchers?

Hamcrest is a framework that provides a set of matchers for creating more expressive and readable assertions in unit tests. Hamcrest matchers work seamlessly with popular testing frameworks like JUnit and Mockito, enhancing the clarity and effectiveness of your test code. Hamcrest matchers allow you to construct assertions that closely resemble natural language statements, making it easier to understand the intent of the test. These matchers provide a fluent API for building complex assertions and comparing expected values with actual results.

Some key features and benefits of Hamcrest matchers include:

1. Readability: Hamcrest matchers use a readable syntax that closely mirrors natural language, resulting in more understandable test assertions.
2. Flexibility: Hamcrest matchers offer a wide range of predefined matchers for various data types and conditions. They can be combined and customized to create complex assertions specific to your test cases.
3. Extensibility: Hamcrest provides the ability to create custom matchers, allowing you to define your own domain-specific matchers tailored to your application's needs.
4. Integration: Hamcrest seamlessly integrates with popular testing frameworks like JUnit and Mockito, making it easy to incorporate into your existing testing infrastructure.

Here are some examples of commonly used Hamcrest matchers:

1. equalTo(expectedValue): Matches if the actual value is equal to the expected value.
2. not(equalTo(unexpectedValue)): Matches if the actual value is not equal to the unexpected value.
3. greaterThan(comparableValue): Matches if the actual value is greater than the given comparable value.
4. lessThan(comparableValue): Matches if the actual value is less than the given comparable value.
5. containsString(substring): Matches if the actual string contains the specified substring.
6. hasSize(size): Matches if the actual collection or array has the specified size.
7. instanceOf(classType): Matches if the actual value is an instance of the specified class.
8. anyOf(matcher1, matcher2): Matches if any of the provided matchers match the actual value.
9. allOf(matcher1, matcher2): Matches if all of the provided matchers match the actual value.

## 13. do you know @spy? what is difference between @spy and @Mock?

Here are the key differences between @Spy and @Mock:

1. Object Creation:
@Mock creates a mock object of the specified class or interface without invoking its actual implementation. It provides a completely new instance of the mock object.
@Spy creates a spy object that wraps an existing instance of the specified class or interface. It retains the original behavior of the object but allows you to stub or verify specific methods.

2. Behavior:
@Mock initializes the mock object with default behavior. You need to define the desired behavior explicitly using when().thenReturn() or similar methods.
@Spy retains the original behavior of the object. If you don't stub a method on the spy, the actual implementation of the object is invoked. You can also stub specific methods if needed.

3. Interaction:
@Mock objects are primarily used for defining and verifying interactions with the mocked object. You can use them to verify method invocations, check parameter values, etc.
@Spy objects can also be used to verify method invocations and interactions, similar to @Mock objects. However, they also allow you to call the actual methods on the spy object, enabling partial mocking. This can be useful when you want to stub specific methods while keeping the original behavior of others.

4. Constructor Invocation:
@Mock doesn't invoke the constructor of the mocked object because it creates a new instance of the class/interface.
@Spy invokes the constructor of the spied object as it wraps an existing instance.

To summarize, @Mock creates a fresh mock object with no real behavior, while @Spy wraps an existing object, allowing you to retain its original behavior and selectively stub or verify specific methods. @Mock is typically used for complete mocking, while @Spy is useful for partial mocking or when you need to stub a few methods while preserving the actual behavior of others.

## 14. briefly reading this articles a. https://www.javatpoint.com/examples-of-mockito-and-junit-in-eclipse-ide b. https://www.javatpoint.com/junit-tutorial c. https://www.javatpoint.com/testng-tutorial d. https://www.javatpoint.com/jmeter-tutorial

Done

## 15. Add unit test for CommentServiceImpl, the coverage should be 100%.

See Coding/MockitoTesting
