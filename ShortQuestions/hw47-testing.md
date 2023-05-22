# 1. What is selenium

Selenium is an open-source tool used for automating web browsers. It provides a single interface for writing scripts in
various programming languages like Java, C#, Python, Ruby, etc. Selenium is highly flexible when it comes to testing
functional and regression test cases. It also supports different types of browsers like Chrome, Firefox, Safari,
Internet Explorer, etc., and different operating systems like Windows, Mac, Linux, etc. Selenium consists of several
components, including Selenium WebDriver, Selenium Grid, and Selenium IDE.

# 2. What is cucumber

Cucumber is a software tool used by computer programmers that supports behavior-driven development (BDD). The central
theme of this approach is to enable better communication and collaboration between technical and non-technical members
of a software development team. Cucumber reads executable specifications written in plain language and validates that
the software does what those specifications say. The language that Cucumber uses to define test cases is called Gherkin.

# 3. What is JMeter

Apache JMeter is an open-source software application that is designed for load testing and measuring performance. It is
primarily used for testing web applications or FTP applications. JMeter can simulate multiple users with concurrent
threads, create a heavy load on a web server under test, and analyze overall performance under different load types. It
also supports various server types like HTTP, HTTPS, SOAP, Database via JDBC, LDAP, JMS, and more. In addition to its
testing capabilities, JMeter can also parse the response data and display it graphically, which is a critical feature
when analyzing the performance of a target system.

# 4. What is unit-test

Unit testing is a type of software testing where individual units or components of a software are tested. The purpose is
to validate that each unit of the software performs as designed. A unit is the smallest testable part of any software,
often a function or method within a class in object-oriented programming. Unit tests are typically automated and written
by software developers to ensure that code meets its design and behaves as expected.

# 5. What is the life cycle of Junit?

* @BeforeAll: The annotated method will be run once before all the tests in the test class. It's analogous to
  @BeforeClass in JUnit 4.
* @BeforeEach: The annotated method will be run before each test method. It's analogous to @Before in JUnit 4.
* @Test: The annotated method is a test method. This is similar to the @Test annotation in JUnit 4.
* @AfterEach: The annotated method will be run after each test method. It's analogous to @After in JUnit 4.
* @AfterAll: The annotated method will be run once after all the tests in the test class. It's analogous to @AfterClass
  in JUnit 4.

# 6. Is @BeforeAll method should be Class level(static)?

Yes, in JUnit 5, a method annotated with @BeforeAll must be static by default (if the test class is not marked with
@TestInstance(Lifecycle.PER_CLASS)). This is because the @BeforeAll method is called once before any of the test methods
are called, and at this time, there may not be an instance of the test class yet.

However, if you annotate your test class with @TestInstance(Lifecycle.PER_CLASS), then the @BeforeAll (and @AfterAll)
method does not need to be static because a new instance of the test class will be created for each test method or each
test class.

# 7. What is Mockito? and what is its limitations?

Mockito is a popular open-source testing framework for Java. It's used to create and configure mock objects. Using
Mockito, you can verify that certain methods were called on your mock objects, check the parameters of those method
calls, and stub out behavior to control your mock objects' responses. Mockito is typically used for interaction-based
testing, where the focus is on how your object interacts with its dependencies.

1. Cannot Mock Some Classes: Mockito has trouble mocking some types of classes and interfaces. For example, it cannot
   mock final classes and methods, static methods, private methods, constructors, and equals() and hashCode() methods.
   However, Mockito 2 has significantly improved this by allowing mocking of final classes and methods.
2. Cannot Verify Calls to new: Mockito cannot verify that a constructor was called as part of the test. It can't mock
   object creation (calls to new).
3. Difficult to Test Multi-threaded Code: Testing multi-threaded code can be hard with Mockito because of its design to
   be used in a single-thread context.

# 8. What is @Mock and what is @InjectMocks?

@Mock: This annotation is used to create and inject mocked instances. The @Mock annotation tells Mockito to mock an
instance of the class (or interface) it's annotated on.

```java
@Mock
MyService myService;  // Creates a mock instance of MyService

        when(myService.someMethod()).thenReturn(someValue);
```

@InjectMocks: This annotation is used to create an instance of the class and inject the mocked dependencies.
@InjectMocks creates an instance of the class and injects the mocks that are created with the @Mock (or @Spy)
annotations into this instance.

```java
@InjectMocks
MyController myController;  // Creates an instance of MyController and injects the mock created above
```

# 9. What is the stubbing?

Stubbing is a technique used in testing to replace real components with fake components (called "stubs") that mimic the
behavior of the real ones. It's used when the real components are impractical to include in a test.

```java
@Test
public void testMyMethod(){
        // Suppose myService is a mock of a service that your code under test uses
        MyService myService=mock(MyService.class);

        // Here's where we do the stubbing: When getData is called on myService, return some predefined data
        when(myService.getData()).thenReturn("Predefined data");

        // Now you can call your code under test, and when it calls getData on myService, it will get back "Predefined data"
        // instead of making a real network call
        }
```

Please note that while "mocks" and "stubs" are often used interchangeably, they are technically different: stubs provide
canned responses to calls made during the test, while mocks can also assert that certain calls were made. Mockito
provides both these capabilities.

# 10. What is Mockito ArgumentMatchers

Argument Matchers in Mockito are powerful expressions that you can use to make flexible verifications and stubbings.
They allow you to specify the arguments that your stubbed methods will accept, or the arguments you expect to be made to
a verified method call.

```java
// Correct - all arguments have matchers
when(myMock.add(anyInt(),eq(5))).thenReturn(5);
```

# 11. What is Hamcrest Matchers

Hamcrest is a framework for software tests in Java. It's particularly known for providing a library of matcher objects (
also known as constraints or predicates) that allow 'match' rules to be defined declaratively, to be used in other
frameworks such as JUnit or TestNG.

```java
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

@Test
public void test(){
        assertThat(5,equalTo(5));
        }
```

# 12. What is difference between @spy and @Mock?

@Mock: This annotation creates a mock object. The mock object does not have any of its own functionality; instead, you
must define the behavior of its methods using Mockito's when(...).thenReturn(...) method. Any method you do not
explicitly stub out will return a default value (like null, 0, false, etc., depending on the return type).

@Spy: This annotation creates a "spy" object. A spy object is like a hybrid of a mock and a real object. By default,
calling methods on the spy will call the real methods (this is unlike a mock, where you have to define the behavior of
each method). However, you can still stub out certain methods to have them behave the way you want, just like with a
mock.

# 13. Briefly reading this articles

    a. https://www.javatpoint.com/examples-of-mockito-and-junit-in-eclipse-ide
    b. https://www.javatpoint.com/junit-tutorial
    c. https://www.javatpoint.com/testng-tutorial
    d. https://www.javatpoint.com/jmeter-tutorial

# 14. Add unit test for CommentServiceImpl, the coverage should be 100%.