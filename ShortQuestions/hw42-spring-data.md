# 1. List all of the annotations you learned from class and homework to annotaitons.md

Please check `ShortQuestions/annotations.md`

# 2. Type the code, you need to checkout new branch from branch 02_post_RUD, name the new branch with https://github.com/TAIsRich/springboot-redbook/ tree/hw05_01_slides_JPQL.
Please see `MavenProject/redbook`

# 3. What is JPQL?

JPQL stands for Java Persistence Query Language. It is a platform-independent, object-oriented query language used in
Java applications for querying and retrieving data from relational databases. JPQL is part of the Java Persistence API (
JPA), a specification for managing the persistence of Java objects with relational databases in Java applications.

PQL is designed to work with entity classes (Java classes mapped to database tables) rather than directly with database
tables. It abstracts the underlying database schema and allows developers to focus on the object model of the
application.

# 4. What is @NamedQuery and @NamedQueries?

### `@NamedQuery`

This annotation is used to define a single named query for an entity class. It has two mandatory attributes: name and
query. The name attribute represents the unique name given to the query, and the query attribute is the JPQL query
string itself.

```java

@Entity
@NamedQuery(name = "Employee.findByName",
        query = "SELECT e FROM Employee e WHERE e.name = :name")
public class Employee {
    // entity class fields and methods
}
```

### `@NamedQueries`

This annotation is used when multiple named queries need to be defined for an entity class. @NamedQueries is a container
for multiple @NamedQuery annotations. It takes an array of @NamedQuery annotations as its attribute.

```java

@Entity
@NamedQueries({
        @NamedQuery(name = "Employee.findAll",
                query = "SELECT e FROM Employee e"),
        @NamedQuery(name = "Employee.findByDepartment",
                query = "SELECT e FROM Employee e WHERE e.department = :department")
})
public class Employee {
    // entity class fields and methods
}
```

```java
EntityManager em= // get the entity manager
        TypedQuery<Employee> query=em.createNamedQuery("Employee.findByName",Employee.class);
        query.setParameter("name","John Doe");
        List<Employee> employees=query.getResultList();
```

# 5. What is @Query? In which Interface we write the sql or JPQL?

`@Query `is an annotation in the Spring Data JPA framework, which is built on top of the Java Persistence API (JPA). It
is
used to define custom queries directly in the repository interfaces, bypassing the need for named queries defined at the
entity level.

The `@Query` annotation is used within a Repository interface, which is typically an extension of the JpaRepository,
CrudRepository, or PagingAndSortingRepository interfaces provided by Spring Data JPA.

```java
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    @Query("SELECT e FROM Employee e WHERE e.name = :name")
    List<Employee> findByName(@Param("name") String name);

    @Query(value = "SELECT * FROM employees WHERE department_id = :departmentId", nativeQuery = true)
    List<Employee> findByDepartmentId(@Param("departmentId") Long departmentId);

}
```

```java
@Autowired
private EmployeeRepository employeeRepository;

public List<Employee> getEmployeesByName(String name){
        return employeeRepository.findByName(name);
        }
```

# 6. What is HQL and Criteria Queries?

HQL and Criteria Queries are query languages and techniques used in Hibernate, an Object-Relational Mapping (ORM)
framework for Java applications. Hibernate provides different ways to query and retrieve data from the underlying
relational databases.

# 7. What is EntityManager?

EntityManager is a core interface in the Java Persistence API (JPA), which plays a central role in managing the
persistence of Java objects to relational databases. It is responsible for managing the lifecycle of entity instances (
Java objects mapped to database tables), executing queries, and performing database transactions.

The EntityManager provides a set of methods for various CRUD operations (Create, Read, Update, and Delete) and other

* persistence-related tasks, such as:
* persist(): To store a new entity object into the database.
* merge(): To update an existing entity object in the database.
* remove(): To delete an entity object from the database.
* find(): To retrieve an entity object from the database by its primary key.
* getReference(): To get a reference to an entity object without actually loading its data from the database.
* createQuery(): To create a new JPQL (Java Persistence Query Language) query.
* createNamedQuery(): To create a query based on a pre-defined named query.
* createNativeQuery(): To create a query using native SQL.

# 8. What is SessionFactory and Session?

### SessionFactory:

SessionFactory is a heavyweight, thread-safe object that is created once per application (or per database) during the
application's initialization. It is responsible for creating Session instances and holds configurations, metadata, and
cache information for all the mapped entity classes. SessionFactory is typically created using a Hibernate configuration
file (XML or programmatic configuration) and initialized during application startup.

```java
Configuration configuration=new Configuration().configure("hibernate.cfg.xml");
        StandardServiceRegistryBuilder registryBuilder=new StandardServiceRegistryBuilder().applySettings(configuration.getProperties());
        SessionFactory sessionFactory=configuration.buildSessionFactory(registryBuilder.build());
```

### Session:

Session is a lightweight, non-thread-safe object that represents a single unit of work with the database. It is used to
perform CRUD operations (Create, Read, Update, and Delete), execute queries, and manage transactions. Each Session
instance is associated with a persistence context, which is a set of entity instances managed by the Session.

```java
// Opening a new Session
Session session=sessionFactory.openSession();

// Persisting a new Employee object
        Employee employee=new Employee("John Doe");
        Transaction transaction=session.beginTransaction();
        session.save(employee);
        transaction.commit();

// Finding an Employee by its primary key
        Employee foundEmployee=session.get(Employee.class,employee.getId());

// Updating the Employee's name
        transaction=session.beginTransaction();
        foundEmployee.setName("Jane Doe");
        session.update(foundEmployee);
        transaction.commit();

// Deleting the Employee
        transaction=session.beginTransaction();
        session.delete(foundEmployee);
        transaction.commit();

// Closing the Session
        session.close();
```

# 9. What is Transaction? how to manage your transaction?

A transaction in the context of database management represents a single unit of work that consists of one or more
operations, such as inserting, updating, or deleting records. Transactions are crucial in ensuring data consistency and
integrity in database systems. They follow the ACID properties: Atomicity, Consistency, Isolation, and Durability.
Transactions can be managed using the Transaction interface.

# 10. What is hibernate Caching?

Hibernate caching is a performance optimization feature in the Hibernate framework that reduces the number of round
trips between an application and the database by storing frequently accessed data in memory. This can significantly
improve an application's response time and reduce the load on the database. Hibernate provides two levels of caching:
first-level cache and second-level cache.

# 11. What is the difference between first-level cache and second-level cache?

### First-level cache:

The first-level cache is associated with the Hibernate Session and is enabled by default. It is essentially the
persistence context of the Session. Each Session has its own cache, and it cannot be shared between different Sessions.
The first-level cache stores entity objects that have been loaded or persisted within the scope of a Session. When an
application queries for an entity, Hibernate first checks the first-level cache before hitting the database. If the
entity is found in the cache, it is returned directly without querying the database.

### Second-level cache:

The second-level cache is an optional, shared cache that can store data across multiple Sessions and even application
instances. It is not enabled by default and needs to be configured explicitly. The second-level cache can store
entities, collections, and query results. It can be configured to use various caching providers, such as EhCache,
Infinispan, or Hazelcast.

# 12. How do you understand @Transactional?

@Transactional is an annotation provided by the Spring Framework that can be applied to methods or classes to
declaratively manage transactions. When a method annotated with @Transactional is called, Spring automatically manages
the transaction lifecycle, ensuring that the method is executed within the context of a database transaction.

Under the hood, Spring uses Aspect-Oriented Programming (AOP) to wrap the method with transaction management code. The
@Transactional annotation tells Spring to start a new transaction before the method is executed and commit the
transaction after the method successfully completes. If an exception is thrown within the method, Spring automatically
rolls back the transaction to maintain data consistency.

```java

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Transactional
    public Employee createEmployee(Employee employee) {
        // Perform validation, business logic, etc.
        return employeeRepository.save(employee);
    }

    @Transactional
    public Employee updateEmployee(Employee employee) {
        // Perform validation, business logic, etc.
        return employeeRepository.save(employee);
    }

    // Other service methods...
}
```

# 13. Write a simple factory design pattern.

```java
public interface Animal {
    void speak();
}

public class Dog implements Animal {
    @Override
    public void speak() {
        System.out.println("Woof!");
    }
}

public class Cat implements Animal {
    @Override
    public void speak() {
        System.out.println("Meow!");
    }
}

public class AnimalFactory {

    public enum AnimalType {
        DOG,
        CAT
    }

    public static Animal createAnimal(AnimalType type) {
        switch (type) {
            case DOG:
                return new Dog();
            case CAT:
                return new Cat();
            default:
                throw new IllegalArgumentException("Invalid animal type.");
        }
    }
}

public class Main {

    public static void main(String[] args) {
        Animal dog = AnimalFactory.createAnimal(AnimalFactory.AnimalType.DOG);
        dog.speak();

        Animal cat = AnimalFactory.createAnimal(AnimalFactory.AnimalType.CAT);
        cat.speak();
    }
}

```

# 14. List all of the annotations you learned from class and homework to annotaitons.md

Please check `ShortQuestions/annotations.md`

# 15. Type the Comment feature for the class project.

`MavenProject/redbook`

# 16. In postman, call of the APIs in PostController and CommentController.

Done

# 17. what is JPA? and what is Hibernate?

JPA (Java Persistence API) is a Java specification that defines a set of APIs and guidelines for persisting Java objects
to relational databases. It provides a standardized, easy-to-use, and vendor-independent way to perform
Object-Relational Mapping (ORM) in Java applications. JPA allows developers to work with Java objects and their
relationships instead of directly dealing with SQL queries and database-specific details.

Hibernate, on the other hand, is a popular open-source ORM framework for Java that provides an implementation of the JPA
specification. It was developed before JPA and has been widely adopted in the Java community for its rich feature set
and extensive documentation. Hibernate not only implements JPA but also extends it with additional features and
functionality, such as Criteria Queries, native SQL queries, and a powerful caching mechanism.

# 18. What is Hiraki? what is the benefits of connection pool?

HikariCP is a high-performance, lightweight Java connection pooling library. It
provides a fast, efficient, and reliable way to manage database connections in Java applications. HikariCP is well-known
for its performance and simplicity, and it is often used in combination with various Java frameworks, such as Spring
Boot and Micronaut, to improve database access performance.

Connection pooling is a technique used to manage and reuse database connections to optimize resource utilization and
reduce the overhead associated with creating and closing connections. Connection pooling is beneficial for several
reasons:

# 19. What is the @OneToMany, @ManyToOne, @ManyToMany? write some examples.

These annotations help map the associations between database tables to the relationships between Java objects.

### @OneToMany @ManyToOne

```java

@Entity
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @OneToMany(mappedBy = "author", cascade = CascadeType.ALL)
    private List<Book> books;

    // Getters, setters, and other methods...
}

@Entity
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    @ManyToOne
    @JoinColumn(name = "author_id")
    private Author author;

    // Getters, setters, and other methods...
}

```

### @ManyToMany

```java

@Entity
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "student_course",
            joinColumns = @JoinColumn(name = "student_id"),
            inverseJoinColumns = @JoinColumn(name = "course_id"))
    private List<Course> courses;

    // Getters, setters, and other methods...
}

@Entity
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    @ManyToMany(mappedBy = "courses")
    private List<Student> students;

    // Getters, setters, and other methods...
}
```

# 20. What is the cascade = CascadeType.ALL, orphanRemoval = true? and what are the other CascadeType and their features? In which situation we choose which one?

`CascadeType.ALL` is a shorthand for applying all the cascading operations to the related entities.

`orphanRemoval` is an attribute used with the @OneToMany or @OneToOne annotation to specify whether the related child
entities should be automatically removed when they are no longer associated with the parent entity.

* `CascadeType.PERSIST`: When a parent entity is persisted (saved) to the database, the related child entities are also
  persisted.
* `CascadeType.MERGE`: When a parent entity is merged (updated), the changes are also merged with the related child
  entities.
* `CascadeType.REMOVE`: When a parent entity is removed (deleted) from the database, the related child entities are also
  removed.
* `CascadeType.REFRESH`: When a parent entity is refreshed (reloaded) from the database, the related child entities are
  also refreshed.
* `CascadeType.DETACH`: When a parent entity is detached (disassociated) from the persistence context, the related child
  entities are also detached.
* `CascadeType.ALL`: This is a combination of all the above cascading operations (PERSIST, MERGE, REMOVE, REFRESH, and
  DETACH).

# 21. What is the fetch = FetchType.LAZY, fetch = FetchType.EAGER? what is the difference? In which situation you choose which one?

In JPA (Java Persistence API), FetchType determines when the related entities should be loaded from the database. There
are two fetching strategies: FetchType.LAZY and FetchType.EAGER.

* `FetchType.LAZY`: With lazy loading, the related entities are not loaded from the database until they are explicitly
  accessed in your code. This approach can improve performance by reducing the amount of data fetched from the database
  when it is not needed. Lazy fetching is generally the preferred strategy for most situations, as it helps prevent
  loading unnecessary data and can significantly improve the performance of your application.


* `FetchType.EAGER`: With eager loading, the related entities are loaded from the database at the same time as the
  parent
  entity. This approach can be useful when you know that you will always need the related entities for a specific
  operation and want to minimize the number of database queries. However, eager fetching can lead to performance issues
  when loading large amounts of data or when dealing with complex entity relationships.

# 22. What is the rule of JPA naming convention? Shall we implement the method by ourselves? Could you list some examples?

In JPA, naming conventions are mostly related to defining methods in your repository interfaces to perform CRUD
operations and queries on your entities. The JPA naming conventions help you create consistent, readable, and
easy-to-understand code. By following these conventions, JPA can automatically generate the implementation for your
repository methods based on their names.
```java
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // other fields

    @ManyToOne
    @JoinColumn(name = "address_id")
    private Address address;

    // getters, setters, and other methods
}

@Entity
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // other fields

    private String country;

    @OneToMany(mappedBy = "address")
    private List<User> users;

    // getters, setters, and other methods
}
```
```java
public interface UserRepository extends JpaRepository<User, Long> {
    List<User> findByAddress_Country(String country);
    //more 
    User findByUsername(String username);
  
    List<User> findByFirstNameAndLastName(String firstName, String lastName);
  
    List<User> findByLastNameIgnoreCase(String lastName);
  
    List<User> findByAgeGreaterThanEqual(Integer age);
  
    List<User> findByFirstNameAndLastNameOrderByAgeDesc(String firstName, String lastName);
  
    Long countByFirstName(String firstName);
  
    void deleteByUsername(String username);
  
    boolean existsByUsername(String username);
}

```

# 23. Try to use JPA advanced methods in your class project. In the repository layer, you need to use the naming convention to use the method provided by JPA.
Done
