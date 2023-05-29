## 1. List all of the new learned annotations to your annotations.md
Please see annotations file

## 2. what is selenium(YouTube)?
Selenium is primarily known as a tool for automating web browsers for testing purposes. It is commonly used in frontend development to write tests that simulate user interactions and verify the functionality of web applications.

## 3. what is cucumber(youtuebe)?
Cucumber is a popular open-source tool for behavior-driven development (BDD) that promotes collaboration between developers, testers, and business stakeholders. It allows you to write executable specifications in a human-readable format that can be understood by both technical and non-technical individuals.

## 4. what is JMeter(youtube)?
Apache JMeter is an open-source software tool designed for load testing, performance testing, and functional testing of web applications. It is widely used to simulate heavy loads on servers, networks, or objects to analyze the performance and behavior of an application under various scenarios.

## 5. what is unit-test?
A unit test is a type of software testing that focuses on verifying the functionality and correctness of individual units or components of a software system.

## 6. What is the lifecircle of Junit?
Test Setup: Before each test method is executed, JUnit initializes the test environment. It creates an instance of the test class and prepares any necessary resources or dependencies. This is typically done using the @Before annotation or methods marked with @BeforeEach (JUnit 5).

Test Execution: The actual test method is executed. JUnit invokes the test method annotated with @Test or methods marked with @Test (JUnit 5). This is where the specific assertions and verifications are performed to validate the behavior of the unit being tested.

Test Teardown: After the execution of each test method, JUnit cleans up the test environment. It performs any necessary cleanup actions, such as releasing resources or closing connections. This is typically done using the @After annotation or methods marked with @AfterEach (JUnit 5).

Test Suite Setup: In JUnit, a test suite allows you to group multiple test classes together to run them collectively. Before executing any tests within a test suite, JUnit performs the suite setup. It initializes any shared resources or setups that apply to the entire suite. This is typically done using the @BeforeClass annotation or methods marked with @BeforeAll (JUnit 5).

Test Suite Execution: Once the suite setup is complete, JUnit executes the individual test methods in the test classes included in the suite. Each test class goes through the test setup, test execution, and test teardown stages.

Test Suite Teardown: After executing all the test methods within a test suite, JUnit performs the suite teardown. It cleans up any shared resources or performs necessary finalization tasks. This is typically done using the @AfterClass annotation or methods marked with @AfterAll (JUnit 5).

## 7. Is @BeforeAll method should be Class level(static)?
Yes, in JUnit 5, the @BeforeAll annotation is used to mark a method that should be executed once before all test methods in a test class. This method should be static because it operates at the class level, rather than on an instance of the class.

## 8. What is Mockito? and what is its limitations?
Mockito is a popular open-source Java framework used for mocking objects in unit tests. It allows you to create mock objects, stub their behavior, and verify interactions with them during testing. Mockito helps isolate the unit under test by replacing its dependencies with mock objects, allowing you to focus on testing specific units without relying on real implementations.

## 9. What is @Mock and what is @InjectMocks?
@Mock: The @Mock annotation is used to mark a field or a method parameter as a mock object. It tells Mockito to create a mock instance of the specified class or interface. This allows you to replace real dependencies of the unit under test with mock objects.

@InjectMocks: The @InjectMocks annotation is used to inject mock objects into the fields of the class being tested. It tells Mockito to perform automatic injection of mock objects into the fields marked with @InjectMocks.

## 10. What is the stubbing?
Stubbing, in the context of software testing, refers to the process of defining predetermined behavior or responses for methods of objects being mocked or stubbed. When stubbing, you set up specific return values or define exceptions that should occur when a certain method is called during testing.

## 11. what is Mockito ArgumentMatchers

Mockito ArgumentMatchers is a set of utility methods provided by the Mockito mocking framework to simplify the matching of method arguments during stubbing and verification of method invocations.

ArgumentMatchers help you define flexible and precise matching conditions for method arguments, allowing you to stub or verify methods based on specific argument values or patterns. They enable you to create more expressive and targeted tests by specifying the desired behavior or expectations for different argument scenarios.

## 12. what is Hamcrest Matchers
Hamcrest Matchers is a library for creating expressive and readable assertions in software testing. It provides a set of matcher objects that allow you to define flexible and intuitive conditions for comparing values or objects in tests.


## 13. do you know @spy? what is difference between @spy and @Mock?
The @Spy annotation is used in the context of Mockito to create a partial mock object. It allows you to create a real instance of a class while still having the ability to stub or verify specific methods on that object.

The @Spy annotation allows you to create a partial mock that retains the real behavior of the object, while @Mock creates a fully mock object with no real behavior. You can use @Spy when you want to observe and stub specific methods on an actual object, while @Mock is suitable when you want to completely replace the behavior of a dependency with a mock implementation.

## 14. briefly reading this articles
## 15. Add unit test for CommentServiceImpl, the coverage should be 100%.